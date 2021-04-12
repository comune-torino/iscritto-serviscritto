package it.csi.iscritto.serviscritto.business.domanda.service;

import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.LOG_BEGIN;
import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.LOG_END;
import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.LOG_ERROR;
import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.buildMessage;
import static it.csi.iscritto.serviscritto.business.util.converter.ConvertUtils.toUpper;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import it.csi.iscritto.serviscritto.business.integration.dao.StatoDomanda;
import it.csi.iscritto.serviscritto.business.integration.dao.TipoCondizioneOccupazionale;
import it.csi.iscritto.serviscritto.business.integration.dao.TipoScuola;
import it.csi.iscritto.serviscritto.business.integration.dao.TipoSoggetto;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoRScuolaPre;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTScuola;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTUtente;
import it.csi.iscritto.serviscritto.business.integration.dao.view.dto.InfoDomandaRow;
import it.csi.iscritto.serviscritto.business.integration.dao.view.dto.ScuolaRow;
import it.csi.iscritto.serviscritto.business.integration.exception.DaoException;
import it.csi.iscritto.serviscritto.business.integration.exception.ServiceException;
import it.csi.iscritto.serviscritto.business.integration.validation.CalcoloGiorniValidator;
import it.csi.iscritto.serviscritto.business.integration.validation.ErrorCodeEnum;
import it.csi.iscritto.serviscritto.business.integration.validation.model.PeriodoLavorativo;
import it.csi.iscritto.serviscritto.business.util.Constants;
import it.csi.iscritto.serviscritto.business.util.DomandaUtils;
import it.csi.iscritto.serviscritto.business.util.converter.ConvertUtils;
import it.csi.iscritto.serviscritto.dto.domanda.Anagrafica;
import it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda;
import it.csi.iscritto.serviscritto.dto.domanda.CondizioneOccupazionale;
import it.csi.iscritto.serviscritto.dto.domanda.DomandaMaterna;
import it.csi.iscritto.serviscritto.dto.domanda.FratelloFrequentante;
import it.csi.iscritto.serviscritto.dto.domanda.Minore;
import it.csi.iscritto.serviscritto.dto.domanda.SoggettoAffido;
import it.csi.iscritto.serviscritto.dto.domanda.SoggettoAltroComponente;
import it.csi.iscritto.serviscritto.dto.domanda.SoggettoNucleo;
import it.csi.iscritto.serviscritto.exception.domanda.ValidationException;

public class DomandaMaternaValidationService extends AbstractDomandaValidationService {
	private static final Logger log = Logger.getLogger(Constants.COMPONENT_NAME + ".business");

	public static final int MIN_MATERNE = 1;
	public static final int MIN_MATERNE_DIS = 3;

	public void checkDomandaMaterna(String codiceFiscaleRic, String codiceFiscaleMin)
			throws ServiceException, ValidationException {

		final String methodName = "checkDomandaMaterna";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		try {
			this.checkAltroRichiedente(TipoScuola.MAT, codiceFiscaleRic, codiceFiscaleMin);
			this.checkDomandaEsistente(TipoScuola.MAT, codiceFiscaleRic, codiceFiscaleMin);
			this.checkDomandaEsistenteForInvio(TipoScuola.MAT, codiceFiscaleRic, codiceFiscaleMin);
		}
		catch (ValidationException e) {
			log.info(buildMessage(getClass(), methodName, e.getMessage()));
			log.error(buildMessage(getClass(), methodName, LOG_ERROR), e);
			throw e;
		}
		catch (Exception e) {
			log.error(buildMessage(getClass(), methodName, LOG_ERROR), e);
			throw new ServiceException(e);
		}

		log.info(buildMessage(getClass(), methodName, LOG_END));
	}

	public void checkForBozza(DomandaMaterna domandaMaterna)
			throws ServiceException, ValidationException {

		final String methodName = "checkForBozza";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		try {
			this.checkStatoBozza(domandaMaterna);
			this.checkCodiciFiscali(domandaMaterna);
			this.checkCodiciFiscaleOperatore(domandaMaterna);
			this.checkCondizioniSalute(domandaMaterna);
		}
		catch (ValidationException e) {
			log.info(buildMessage(getClass(), methodName, e.getMessage()));
			log.error(buildMessage(getClass(), methodName, LOG_ERROR), e);
			throw e;
		}
		catch (Exception e) {
			log.error(buildMessage(getClass(), methodName, LOG_ERROR), e);
			throw new ServiceException(e);
		}

		log.info(buildMessage(getClass(), methodName, LOG_END));
	}

	public void checkForInvio(CallerInfoDomanda callerInfo, DomandaMaterna domandaMaterna)
			throws ServiceException, ValidationException {

		final String methodName = "checkForInvio";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		try {
			this.checkDomandaInPeriodo(TipoScuola.MAT);
			this.checkCodiciFiscali(domandaMaterna);
			this.checkCodiciFiscaleOperatore(domandaMaterna);
			this.checkFratelloFrequentante(domandaMaterna);
			// this.checkEtaMaterna(domandaMaterna); // TODO: da rivedere
			this.checkPeriodiLavorativi(domandaMaterna);
			this.checkMaterneSelezionate(domandaMaterna);
			//this.checkElencoMaterne(domandaMaterna); //rimosso controllo scuola in elenco in seguito a comunicazione Umberto mail 27/11/2020
			this.checkAltroRichiedente(domandaMaterna);
			this.checkDomandaEsistente(domandaMaterna);
			this.checkCondizioniSalute(domandaMaterna);
		}
		catch (ValidationException e) {
			log.info(buildMessage(getClass(), methodName, e.getMessage()));
			log.error(buildMessage(getClass(), methodName, LOG_ERROR), e);
			throw e;
		}
		catch (Exception e) {
			log.error(buildMessage(getClass(), methodName, LOG_ERROR), e);
			throw new ServiceException(e);
		}

		log.info(buildMessage(getClass(), methodName, LOG_END));
	}

	public void invalidaDomandeEsistenti(DomandaMaterna domandaMaterna)
			throws ServiceException, ValidationException {

		final String methodName = "invalidaDomandeEsistenti";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		try {
			this.invalidaDomandeMaternaEsistenti(domandaMaterna);
		}
		catch (ValidationException e) {
			log.info(buildMessage(getClass(), methodName, e.getMessage()));
			log.error(buildMessage(getClass(), methodName, LOG_ERROR), e);
			throw e;
		}
		catch (Exception e) {
			log.error(buildMessage(getClass(), methodName, LOG_ERROR), e);
			throw new ServiceException(e);
		}

		log.info(buildMessage(getClass(), methodName, LOG_END));
	}

	public void aggiornaMaterneFuoriTermine(DomandaMaterna domandaMaterna)
			throws ServiceException, ValidationException {

		final String methodName = "aggiornaMaterneFuoriTermine";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		try {
			this.checkDomandaInPeriodo(TipoScuola.MAT);
			this.aggiornaScuoleFuoriTermine(TipoScuola.MAT, domandaMaterna.getIdDomandaIscrizione());
		}
		catch (ValidationException e) {
			log.info(buildMessage(getClass(), methodName, e.getMessage()));
			log.error(buildMessage(getClass(), methodName, LOG_ERROR), e);
			throw e;
		}
		catch (Exception e) {
			log.error(buildMessage(getClass(), methodName, LOG_ERROR), e);
			throw new ServiceException(e);
		}

		log.info(buildMessage(getClass(), methodName, LOG_END));
	}

	public void checkRichiedenteDomanda(String cfRichiedente, DomandaMaterna domandaMaterna)
			throws ServiceException, ValidationException {

		final String methodName = "checkRichiedenteDomanda";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		try {
			if (StringUtils.isBlank(cfRichiedente) || domandaMaterna == null) {
				throw ErrorCodeEnum.VAL_DOM_016.buildException();
			}

			if (!cfRichiedente.equalsIgnoreCase(DomandaUtils.getCfRichiedente(domandaMaterna))) {
				throw ErrorCodeEnum.VAL_DOM_016.buildException();
			}

			Long idDomandaIscrizione = domandaMaterna.getIdDomandaIscrizione();
			if (idDomandaIscrizione != null) {
				this.checkIdDomanda(cfRichiedente, idDomandaIscrizione);
			}
		}
		catch (ValidationException e) {
			log.info(buildMessage(getClass(), methodName, e.getMessage()));
			log.error(buildMessage(getClass(), methodName, LOG_ERROR), e);
			throw e;
		}
		catch (Exception e) {
			log.error(buildMessage(getClass(), methodName, LOG_ERROR), e);
			throw new ServiceException(e);
		}

		log.info(buildMessage(getClass(), methodName, LOG_END));
	}

	//////////////////////////////////////////////////////////////////////
	// Invalidazione precedenti domande inviate
	//////////////////////////////////////////////////////////////////////
	private void invalidaDomandeMaternaEsistenti(DomandaMaterna domandaMaterna) throws DaoException, ValidationException {
		final String methodName = "invalidaDomandeMaternaEsistenti";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		String codiceFiscaleRic = getCfRichiedente(domandaMaterna);
		String codiceFiscaleMin = getCfMinore(domandaMaterna);
		Long idDomandaIscrizione = domandaMaterna.getIdDomandaIscrizione();

		String codAnnoScolastico = this.getAnnoScolastico(TipoScuola.MAT).getCodAnnoScolastico();
		List<InfoDomandaRow> rows = this.validazioneDao.dataCheckDomandaEsistenteForInvio(
				TipoScuola.MAT, codAnnoScolastico, codiceFiscaleRic, codiceFiscaleMin);

		int size = rows.size();
		if (size > 0) {
			for (InfoDomandaRow row : rows) {
				if (idDomandaIscrizione.equals(row.getIdDomandaIscrizione())) {
					continue;
				}

				this.domandaIscDao.invalidaDomanda(row.getIdDomandaIscrizione(), null);
			}
		}

		log.info(buildMessage(getClass(), methodName, LOG_END));
	}

	//////////////////////////////////////////////////////////////////////
	// Controlli
	//////////////////////////////////////////////////////////////////////
	private void checkAltroRichiedente(DomandaMaterna domandaMaterna) throws DaoException, ValidationException {
		final String methodName = "checkAltroRichiedente";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		String codiceFiscaleRic = getCfRichiedente(domandaMaterna);
		String codiceFiscaleMin = getCfMinore(domandaMaterna);

		this.checkAltroRichiedente(TipoScuola.MAT, codiceFiscaleRic, codiceFiscaleMin);

		log.info(buildMessage(getClass(), methodName, LOG_END));
	}

	private void checkDomandaEsistente(DomandaMaterna domandaMaterna) throws DaoException, ValidationException {
		final String methodName = "checkDomandaEsistente";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		String codiceFiscaleRic = getCfRichiedente(domandaMaterna);
		String codiceFiscaleMin = getCfMinore(domandaMaterna);

		this.checkDomandaEsistente(TipoScuola.MAT, codiceFiscaleRic, codiceFiscaleMin);

		log.info(buildMessage(getClass(), methodName, LOG_END));
	}

	private void checkStatoBozza(DomandaMaterna domandaMaterna) throws DaoException, ValidationException {
		final String methodName = "checkStatoBozza";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		if (!StatoDomanda.BOZ.getCod().equals(domandaMaterna.getStatoDomanda())) {
			throw ErrorCodeEnum.VAL_DOM_008.buildException();
		}

		log.info(buildMessage(getClass(), methodName, LOG_END));
	}

	private void checkCodiciFiscali(DomandaMaterna domandaMaterna) throws ServiceException, ValidationException {
		final String methodName = "checkCodiciFiscali";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		List<String> cfList = new ArrayList<>();

		if (domandaMaterna.getRichiedente() != null) {
			cfList.add(toUpper(checkCodiceFiscale(
					domandaMaterna.getRichiedente().getAnagrafica(), "richiedente")));
		}

		if (domandaMaterna.getMinore() != null) {
			cfList.add(toUpper(checkCodiceFiscale(
					domandaMaterna.getMinore().getAnagrafica(), "minore")));

			FratelloFrequentante fratelloFrequentante = domandaMaterna.getMinore().getFratelloFrequentante();
			if (fratelloFrequentante != null && Boolean.TRUE.equals(fratelloFrequentante.getStato())) {
				checkCodiceFiscale(fratelloFrequentante.getAnagrafica(), "fratello frequentante");
			}
		}

		if (domandaMaterna.getSoggetto1() != null) {
			String cfSog1 = checkCodiceFiscale(
					domandaMaterna.getSoggetto1().getAnagrafica(), "soggetto1");

			if (!DomandaUtils.isRicSog1(domandaMaterna)) {
				cfList.add(toUpper(cfSog1));
			}
		}

		if (domandaMaterna.getSoggetto2() != null) {
			cfList.add(toUpper(checkCodiceFiscale(
					domandaMaterna.getSoggetto2().getAnagrafica(), "soggetto2")));
		}

		if (domandaMaterna.getSoggetto3() != null) {
			if (domandaMaterna.getSoggetto3().getDati() != null) {
				cfList.add(toUpper(checkCodiceFiscale(
						domandaMaterna.getSoggetto3().getDati().getAnagrafica(), "soggetto3")));
			}
		}

		List<SoggettoNucleo> componenti = DomandaUtils.getComponenti(domandaMaterna);
		for (SoggettoNucleo soggetto : componenti) {
			cfList.add(toUpper(checkCodiceFiscale(
					soggetto.getAnagrafica(), "componentiNucleo")));
		}

		List<SoggettoAltroComponente> altriComponenti = DomandaUtils.getAltriComponenti(domandaMaterna);
		for (SoggettoAltroComponente soggetto : altriComponenti) {
			cfList.add(toUpper(checkCodiceFiscale(
					soggetto.getAnagrafica(), "altriComponenti")));
		}

		List<SoggettoAffido> affidi = DomandaUtils.getAffidi(domandaMaterna);
		for (SoggettoAffido soggetto : affidi) {
			cfList.add(toUpper(checkCodiceFiscale(
					soggetto.getAnagrafica(), "affido")));
		}

		//////////////////////////////////////////////////////////////////////

		ConvertUtils.remove(cfList, new Predicate<String>() {
			@Override
			public boolean evaluate(String value) {
				return StringUtils.isBlank(value);
			}
		});

		if (ConvertUtils.hasDuplicates(cfList)) {
			throw ErrorCodeEnum.VAL_DOM_013.buildException();
		}

		log.info(buildMessage(getClass(), methodName, LOG_END));
	}

	private void checkCodiciFiscaleOperatore(DomandaMaterna domandaMaterna) throws DaoException, ServiceException, ValidationException {
		final String methodName = "checkCodiciFiscaleOperatore";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		List<String> elencoCf = new ArrayList<>();

		elencoCf.add(domandaMaterna.getCodiceFiscaleUtenteIns());
		elencoCf.add(domandaMaterna.getCodiceFiscaleUtenteMod());

		for (String cf : elencoCf) {
			if (StringUtils.isBlank(cf)) {
				continue;
			}

			IscrittoTUtente utente = this.utenteDao.findIscrittoTUtenteByCF(cf);
			if (utente == null) {
				throw ErrorCodeEnum.VAL_DOM_012.buildException("codiceFiscale: " + cf);
			}
		}

		log.info(buildMessage(getClass(), methodName, LOG_END));
	}

	private void checkCondizioniSalute(DomandaMaterna domandaMaterna) throws ValidationException {
		final String methodName = "checkCondizioniSalute";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		Minore minore = domandaMaterna.getMinore();
		if (minore == null) {
			return;
		}

		boolean disabilita = minore.getDisabilita() != null && Boolean.TRUE.equals(minore.getDisabilita().getStato());
		boolean problemiSalute = minore.getProblemiSalute() != null && Boolean.TRUE.equals(minore.getProblemiSalute().getStato());

		if (disabilita && problemiSalute) {
			throw ErrorCodeEnum.VAL_DOM_019.buildException();
		}

		log.info(buildMessage(getClass(), methodName, LOG_END));
	}

	private void checkPeriodiLavorativi(DomandaMaterna domandaMaterna) throws DaoException, ServiceException, ValidationException {
		final String methodName = "checkPeriodiLavorativi";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		Date dataPresentazione = getDataPresentazione(domandaMaterna.getIdDomandaIscrizione());

		if (domandaMaterna.getSoggetto1() != null) {
			CondizioneOccupazionale co = DomandaUtils.getCondizioneOccupazionale(domandaMaterna, TipoSoggetto.SOG1);
			if (co != null && TipoCondizioneOccupazionale.DIS_LAV.getCod().equals(co.getStato())) {
				List<PeriodoLavorativo> periodi = DomandaUtils.getPeriodiLavorativi(domandaMaterna, TipoSoggetto.SOG1);
				CalcoloGiorniValidator.validate(dataPresentazione, periodi, "soggetto1");
			}
		}

		if (domandaMaterna.getSoggetto2() != null) {
			CondizioneOccupazionale co = DomandaUtils.getCondizioneOccupazionale(domandaMaterna, TipoSoggetto.SOG2);
			if (co != null && TipoCondizioneOccupazionale.DIS_LAV.getCod().equals(co.getStato())) {
				List<PeriodoLavorativo> periodi = DomandaUtils.getPeriodiLavorativi(domandaMaterna, TipoSoggetto.SOG2);
				CalcoloGiorniValidator.validate(dataPresentazione, periodi, "soggetto2");
			}
		}

		log.info(buildMessage(getClass(), methodName, LOG_END));
	}

	private void checkMaterneSelezionate(DomandaMaterna domandaMaterna) throws DaoException, ValidationException {
		final String methodName = "checkMaterneSelezionate";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		Minore minore = domandaMaterna.getMinore();
		if (minore == null) {
			return;
		}

		boolean disabilita = minore.getDisabilita() != null && Boolean.TRUE.equals(minore.getDisabilita().getStato());
		boolean problemiSalute = minore.getProblemiSalute() != null && Boolean.TRUE.equals(minore.getProblemiSalute().getStato());
		boolean disagioSociale = minore.getServiziSociali() != null && Boolean.TRUE.equals(minore.getServiziSociali().getStato());

		int materneSelezionate = ArrayUtils.getLength(domandaMaterna.getElencoMaterne());

		if (disabilita || problemiSalute || disagioSociale) {
			if (materneSelezionate < MIN_MATERNE_DIS) {
				throw ErrorCodeEnum.VAL_DOM_015.buildException();
			}
		}

		if (materneSelezionate < MIN_MATERNE) {
			throw ErrorCodeEnum.VAL_DOM_014.buildException();
		}

		log.info(buildMessage(getClass(), methodName, LOG_END));
	}

	private void checkElencoMaterne(DomandaMaterna domandaMaterna) throws DaoException, ServiceException, ValidationException {
		final String methodName = "checkElencoMaterne";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		Date dataNascita = DomandaUtils.toDate(domandaMaterna.getMinore().getAnagrafica().getDataNascita());
		if (dataNascita == null) {
			throw ErrorCodeEnum.VAL_DOM_009.buildException();
		}

		List<IscrittoRScuolaPre> rows = this.scuolaDao.findIscrittoRScuolaPreByFk(domandaMaterna.getIdDomandaIscrizione());
		if (CollectionUtils.isNotEmpty(rows)) {
			String codAnno = this.getAnnoScolastico(TipoScuola.MAT).getCodAnnoScolastico();
			List<ScuolaRow> scuole = this.scuoleDao.findScuole(TipoScuola.MAT, codAnno, dataNascita);
			Map<Long, ScuolaRow> index = DomandaUtils.indexScuoleById(scuole);

			for (IscrittoRScuolaPre row : rows) {
				Long idScuola = row.getIdScuola();
				if (!index.containsKey(idScuola)) {
					IscrittoTScuola scuola = this.scuolaDao.findIscrittoTScuolaByKey(idScuola);
					throw ErrorCodeEnum.VAL_MAT_001.buildException("codScuola:" + scuola.getCodScuola());
				}
			}
		}

		log.info(buildMessage(getClass(), methodName, LOG_END));
	}

	private void checkFratelloFrequentante(DomandaMaterna domandaMaterna) throws DaoException, ServiceException, ValidationException {
		final String methodName = "checkFratelloFrequentante";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		Minore minore = domandaMaterna.getMinore();
		if (minore == null) {
			return;
		}

		FratelloFrequentante fratelloFrequentante = minore.getFratelloFrequentante();
		if (fratelloFrequentante == null || !Boolean.TRUE.equals(fratelloFrequentante.getStato())) {
			return;
		}

		String codiceFiscale = toUpper(fratelloFrequentante.getAnagrafica().getCodiceFiscale());
		if (StringUtils.isBlank(codiceFiscale)) {
			throw ErrorCodeEnum.VAL_CF_001.buildException("fratello frequentante");
		}

		Set<String> cfSoggetti = new HashSet<String>();
		List<SoggettoNucleo> componenti = DomandaUtils.getComponenti(domandaMaterna);
		for (SoggettoNucleo soggetto : componenti) {
			cfSoggetti.add(toUpper(soggetto.getAnagrafica().getCodiceFiscale()));
		}

		List<SoggettoAltroComponente> altriComponenti = DomandaUtils.getAltriComponenti(domandaMaterna);
		for (SoggettoAltroComponente soggetto : altriComponenti) {
			cfSoggetti.add(toUpper(soggetto.getAnagrafica().getCodiceFiscale()));
		}

		List<SoggettoAffido> affidi = DomandaUtils.getAffidi(domandaMaterna);
		for (SoggettoAffido soggetto : affidi) {
			cfSoggetti.add(toUpper(soggetto.getAnagrafica().getCodiceFiscale()));
		}

		if (!cfSoggetti.contains(codiceFiscale)) {
			throw ErrorCodeEnum.VAL_DOM_010.buildException();
		}

		log.info(buildMessage(getClass(), methodName, LOG_END));
	}

	// TODO: da rivedere la logica
	private void checkEtaMaterna(DomandaMaterna domandaMaterna) throws DaoException, ServiceException, ValidationException {
		final String methodName = "checkEtaMaterna";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		String codAnnoScolastico = this.getAnnoScolastico(TipoScuola.MAT).getCodAnnoScolastico();

		Date dataNascitaMinore = DomandaUtils.toDate(domandaMaterna.getMinore().getAnagrafica().getDataNascita());
		boolean iscrizioneNidoMinore = CollectionUtils.isNotEmpty(
				this.validazioneDao.dataDataNascitaMinore(TipoScuola.MAT, codAnnoScolastico, dataNascitaMinore));

		if (!iscrizioneNidoMinore) {
			throw ErrorCodeEnum.VAL_DOM_011.buildException("minore");
		}

		FratelloFrequentante fratelloFrequentante = domandaMaterna.getMinore().getFratelloFrequentante();
		if (fratelloFrequentante == null || !Boolean.TRUE.equals(fratelloFrequentante.getStato())) {
			return;
		}

		Anagrafica anagraficaFratello = fratelloFrequentante.getAnagrafica();
		if (anagraficaFratello == null) {
			return;
		}

		Date dataNascitaFratello = DomandaUtils.toDate(anagraficaFratello.getDataNascita());
		if (dataNascitaFratello == null) {
			return;
		}

		boolean iscrizioneNidoFratello = CollectionUtils.isNotEmpty(
				this.validazioneDao.dataDataNascitaMinore(TipoScuola.MAT, codAnnoScolastico, dataNascitaFratello));

		if (!iscrizioneNidoFratello) {
			throw ErrorCodeEnum.VAL_DOM_011.buildException("fratello frequentante");
		}

		log.info(buildMessage(getClass(), methodName, LOG_END));
	}

	//////////////////////////////////////////////////////////////////////
	// Utility
	//////////////////////////////////////////////////////////////////////
	private static String getCfRichiedente(DomandaMaterna domandaMaterna) throws ValidationException {
		String codiceFiscaleRic = domandaMaterna.getRichiedente().getAnagrafica().getCodiceFiscale();

		if (StringUtils.isBlank(codiceFiscaleRic)) {
			throw ErrorCodeEnum.VAL_DOM_003.buildException();
		}

		return codiceFiscaleRic;
	}

	private static String getCfMinore(DomandaMaterna domandaMaterna) throws ValidationException {
		String codiceFiscaleMin = domandaMaterna.getMinore().getAnagrafica().getCodiceFiscale();

		if (StringUtils.isBlank(codiceFiscaleMin)) {
			throw ErrorCodeEnum.VAL_DOM_004.buildException();
		}

		return codiceFiscaleMin;
	}

}
