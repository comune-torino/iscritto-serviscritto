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
import java.util.StringTokenizer;

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
import it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda;
import it.csi.iscritto.serviscritto.dto.domanda.CondizioneOccupazionale;
import it.csi.iscritto.serviscritto.dto.domanda.DomandaNido;
import it.csi.iscritto.serviscritto.dto.domanda.FratelloFrequentante;
import it.csi.iscritto.serviscritto.dto.domanda.Minore;
import it.csi.iscritto.serviscritto.dto.domanda.SoggettoAffido;
import it.csi.iscritto.serviscritto.dto.domanda.SoggettoAltroComponente;
import it.csi.iscritto.serviscritto.dto.domanda.SoggettoNucleo;
import it.csi.iscritto.serviscritto.exception.domanda.ValidationException;

public class DomandaNidoValidationService extends AbstractDomandaValidationService {
	private static final Logger log = Logger.getLogger(Constants.COMPONENT_NAME + ".business");

	public static final int MAX_ANNI_NIDO = 3;
	public static final int MIN_NIDI = 1;
	public static final int MIN_NIDI_DIS = 3;

	public void checkDomandaNido(String codiceFiscaleRic, String codiceFiscaleMin)
			throws ServiceException, ValidationException {

		final String methodName = "checkDomandaNido";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		try {
			this.checkAltroRichiedente(TipoScuola.NID, codiceFiscaleRic, codiceFiscaleMin);
			this.checkDomandaEsistente(TipoScuola.NID, codiceFiscaleRic, codiceFiscaleMin);
			this.checkDomandaEsistenteForInvio(TipoScuola.NID, codiceFiscaleRic, codiceFiscaleMin);
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

	public void checkForBozza(DomandaNido domandaNido)
			throws ServiceException, ValidationException {

		final String methodName = "checkForBozza";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		try {
			this.checkStatoBozza(domandaNido);
			this.checkCodiciFiscali(domandaNido);
			this.checkCodiciFiscaleOperatore(domandaNido);
			this.checkCondizioniSalute(domandaNido);
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

	public void checkForInvio(CallerInfoDomanda callerInfo, DomandaNido domandaNido)
			throws ServiceException, ValidationException {

		final String methodName = "checkForInvio";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		try {
			this.checkDomandaInPeriodo(TipoScuola.NID);
			this.checkCodiciFiscali(domandaNido);
			this.checkCodiciFiscaleOperatore(domandaNido);
			this.checkFratelloFrequentante(domandaNido);
			this.checkEtaNido(domandaNido);
			this.checkPeriodiLavorativi(domandaNido);
			this.checkNidiSelezionati(domandaNido);
			this.checkElencoNidi(domandaNido);
			this.checkAltroRichiedente(domandaNido);
			this.checkDomandaEsistente(domandaNido);
			this.checkCondizioniSalute(domandaNido);
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

	public void invalidaDomandeEsistenti(DomandaNido domandaNido)
			throws ServiceException, ValidationException {

		final String methodName = "invalidaDomandeEsistenti";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		try {
			this.invalidaDomandeNidoEsistenti(domandaNido);
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

	public void aggiornaNidiFuoriTermine(DomandaNido domandaNido)
			throws ServiceException, ValidationException {

		final String methodName = "aggiornaNidiFuoriTermine";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		try {
			this.checkDomandaInPeriodo(TipoScuola.NID);
			this.aggiornaScuoleFuoriTermine(TipoScuola.NID, domandaNido.getIdDomandaIscrizione());
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

	public void checkRichiedenteDomanda(String cfRichiedente, DomandaNido domandaNido)
			throws ServiceException, ValidationException {

		final String methodName = "checkRichiedenteDomanda";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		try {
			if (StringUtils.isBlank(cfRichiedente) || domandaNido == null) {
				throw ErrorCodeEnum.VAL_DOM_016.buildException();
			}

			if (!cfRichiedente.equalsIgnoreCase(DomandaUtils.getCfRichiedente(domandaNido))) {
				throw ErrorCodeEnum.VAL_DOM_016.buildException();
			}

			Long idDomandaIscrizione = domandaNido.getIdDomandaIscrizione();
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
	private void invalidaDomandeNidoEsistenti(DomandaNido domandaNido) throws DaoException, ValidationException {
		final String methodName = "invalidaDomandeNidoEsistenti";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		String codiceFiscaleRic = getCfRichiedente(domandaNido);
		String codiceFiscaleMin = getCfMinore(domandaNido);
		Long idDomandaIscrizione = domandaNido.getIdDomandaIscrizione();

		String codAnnoScolastico = this.getAnnoScolastico(TipoScuola.NID).getCodAnnoScolastico();
		List<InfoDomandaRow> rows = this.validazioneDao.dataCheckDomandaEsistenteForInvio(
				TipoScuola.NID, codAnnoScolastico, codiceFiscaleRic, codiceFiscaleMin);

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
	private void checkAltroRichiedente(DomandaNido domandaNido) throws DaoException, ValidationException {
		final String methodName = "checkAltroRichiedente";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		String codiceFiscaleRic = getCfRichiedente(domandaNido);
		String codiceFiscaleMin = getCfMinore(domandaNido);

		this.checkAltroRichiedente(TipoScuola.NID, codiceFiscaleRic, codiceFiscaleMin);

		log.info(buildMessage(getClass(), methodName, LOG_END));
	}

	private void checkDomandaEsistente(DomandaNido domandaNido) throws DaoException, ValidationException {
		final String methodName = "checkDomandaEsistente";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		String codiceFiscaleRic = getCfRichiedente(domandaNido);
		String codiceFiscaleMin = getCfMinore(domandaNido);

		this.checkDomandaEsistente(TipoScuola.NID, codiceFiscaleRic, codiceFiscaleMin);

		log.info(buildMessage(getClass(), methodName, LOG_END));
	}

	private void checkStatoBozza(DomandaNido domandaNido) throws DaoException, ValidationException {
		final String methodName = "checkStatoBozza";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		if (!StatoDomanda.BOZ.getCod().equals(domandaNido.getStatoDomanda())) {
			throw ErrorCodeEnum.VAL_DOM_008.buildException();
		}

		log.info(buildMessage(getClass(), methodName, LOG_END));
	}

	private void checkCodiciFiscali(DomandaNido domandaNido) throws ServiceException, ValidationException {
		final String methodName = "checkCodiciFiscali";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		List<String> cfList = new ArrayList<>();

		if (domandaNido.getRichiedente() != null) {
			cfList.add(toUpper(checkCodiceFiscale(
					domandaNido.getRichiedente().getAnagrafica(), "richiedente")));
		}

		if (domandaNido.getMinore() != null) {
			cfList.add(toUpper(checkCodiceFiscale(
					domandaNido.getMinore().getAnagrafica(), "minore")));

			FratelloFrequentante fratelloFrequentante = domandaNido.getMinore().getFratelloFrequentante();
			if (fratelloFrequentante != null && Boolean.TRUE.equals(fratelloFrequentante.getStato())) {
				checkCodiceFiscale(fratelloFrequentante.getAnagrafica(), "fratello frequentante");
			}
		}

		if (domandaNido.getSoggetto1() != null) {
			String cfSog1 = checkCodiceFiscale(
					domandaNido.getSoggetto1().getAnagrafica(), "soggetto1");

			if (!DomandaUtils.isRicSog1(domandaNido)) {
				cfList.add(toUpper(cfSog1));
			}
		}

		if (domandaNido.getSoggetto2() != null) {
			cfList.add(toUpper(checkCodiceFiscale(
					domandaNido.getSoggetto2().getAnagrafica(), "soggetto2")));
		}

		if (domandaNido.getSoggetto3() != null) {
			if (domandaNido.getSoggetto3().getDati() != null) {
				cfList.add(toUpper(checkCodiceFiscale(
						domandaNido.getSoggetto3().getDati().getAnagrafica(), "soggetto3")));
			}
		}

		List<SoggettoNucleo> componenti = DomandaUtils.getComponenti(domandaNido);
		for (SoggettoNucleo soggetto : componenti) {
			cfList.add(toUpper(checkCodiceFiscale(
					soggetto.getAnagrafica(), "componentiNucleo")));
		}

		List<SoggettoAltroComponente> altriComponenti = DomandaUtils.getAltriComponenti(domandaNido);
		for (SoggettoAltroComponente soggetto : altriComponenti) {
			cfList.add(toUpper(checkCodiceFiscale(
					soggetto.getAnagrafica(), "altriComponenti")));
		}

		List<SoggettoAffido> affidi = DomandaUtils.getAffidi(domandaNido);
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

	private void checkCodiciFiscaleOperatore(DomandaNido domandaNido) throws DaoException, ServiceException, ValidationException {
		final String methodName = "checkCodiciFiscaleOperatore";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		List<String> elencoCf = new ArrayList<>();

		elencoCf.add(domandaNido.getCodiceFiscaleUtenteIns());
		elencoCf.add(domandaNido.getCodiceFiscaleUtenteMod());

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

	private void checkCondizioniSalute(DomandaNido domandaNido) throws ValidationException {
		final String methodName = "checkCondizioniSalute";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		Minore minore = domandaNido.getMinore();
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

	private void checkPeriodiLavorativi(DomandaNido domandaNido) throws DaoException, ServiceException, ValidationException {
		final String methodName = "checkPeriodiLavorativi";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		Date dataPresentazione = getDataPresentazione(domandaNido.getIdDomandaIscrizione());

		if (domandaNido.getSoggetto1() != null) {
			CondizioneOccupazionale co = DomandaUtils.getCondizioneOccupazionale(domandaNido, TipoSoggetto.SOG1);
			if (co != null && TipoCondizioneOccupazionale.DIS_LAV.getCod().equals(co.getStato())) {
				List<PeriodoLavorativo> periodi = DomandaUtils.getPeriodiLavorativi(domandaNido, TipoSoggetto.SOG1);
				CalcoloGiorniValidator.validate(dataPresentazione, periodi, "soggetto1");
			}
		}

		if (domandaNido.getSoggetto2() != null) {
			CondizioneOccupazionale co = DomandaUtils.getCondizioneOccupazionale(domandaNido, TipoSoggetto.SOG2);
			if (co != null && TipoCondizioneOccupazionale.DIS_LAV.getCod().equals(co.getStato())) {
				List<PeriodoLavorativo> periodi = DomandaUtils.getPeriodiLavorativi(domandaNido, TipoSoggetto.SOG2);
				CalcoloGiorniValidator.validate(dataPresentazione, periodi, "soggetto2");
			}
		}

		log.info(buildMessage(getClass(), methodName, LOG_END));
	}

	private void checkNidiSelezionati(DomandaNido domandaNido) throws DaoException, ValidationException {
		final String methodName = "checkNidiSelezionati";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		Minore minore = domandaNido.getMinore();
		if (minore == null) {
			return;
		}

		boolean disabilita = minore.getDisabilita() != null && Boolean.TRUE.equals(minore.getDisabilita().getStato());
		boolean problemiSalute = minore.getProblemiSalute() != null && Boolean.TRUE.equals(minore.getProblemiSalute().getStato());
		boolean disagioSociale = minore.getServiziSociali() != null && Boolean.TRUE.equals(minore.getServiziSociali().getStato());

		int nidiSelezionati = ArrayUtils.getLength(domandaNido.getElencoNidi());

		if (disabilita || problemiSalute || disagioSociale) {
			if (nidiSelezionati < MIN_NIDI_DIS) {
				throw ErrorCodeEnum.VAL_DOM_015.buildException();
			}
		}

		if (nidiSelezionati < MIN_NIDI) {
			throw ErrorCodeEnum.VAL_DOM_014.buildException();
		}

		log.info(buildMessage(getClass(), methodName, LOG_END));
	}

	private void checkElencoNidi(DomandaNido domandaNido) throws DaoException, ServiceException, ValidationException {
		final String methodName = "checkElencoNidi";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		Date dataNascita = DomandaUtils.toDate(domandaNido.getMinore().getAnagrafica().getDataNascita());
		if (dataNascita == null) {
			throw ErrorCodeEnum.VAL_DOM_009.buildException();
		}

		List<IscrittoRScuolaPre> rows = this.scuolaDao.findIscrittoRScuolaPreByFk(domandaNido.getIdDomandaIscrizione());
		if (CollectionUtils.isNotEmpty(rows)) {
			String codAnno = this.getAnnoScolastico(TipoScuola.NID).getCodAnnoScolastico();
			List<ScuolaRow> scuole = this.scuoleDao.findScuole(TipoScuola.NID, codAnno, dataNascita);
			Map<Long, ScuolaRow> index = DomandaUtils.indexScuoleById(scuole);

			for (IscrittoRScuolaPre row : rows) {
				Long idScuola = row.getIdScuola();
				if (!index.containsKey(idScuola)) {
					IscrittoTScuola scuola = this.scuolaDao.findIscrittoTScuolaByKey(idScuola);
					throw ErrorCodeEnum.VAL_NID_001.buildException("codScuola:" + scuola.getCodScuola());
				}
			}
		}

		log.info(buildMessage(getClass(), methodName, LOG_END));
	}

	private void checkFratelloFrequentante(DomandaNido domandaNido) throws DaoException, ServiceException, ValidationException {
		final String methodName = "checkFratelloFrequentante";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		Minore minore = domandaNido.getMinore();
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
		List<SoggettoNucleo> componenti = DomandaUtils.getComponenti(domandaNido);
		for (SoggettoNucleo soggetto : componenti) {
			cfSoggetti.add(toUpper(soggetto.getAnagrafica().getCodiceFiscale()));
		}

		List<SoggettoAltroComponente> altriComponenti = DomandaUtils.getAltriComponenti(domandaNido);
		for (SoggettoAltroComponente soggetto : altriComponenti) {
			cfSoggetti.add(toUpper(soggetto.getAnagrafica().getCodiceFiscale()));
		}

		List<SoggettoAffido> affidi = DomandaUtils.getAffidi(domandaNido);
		for (SoggettoAffido soggetto : affidi) {
			cfSoggetti.add(toUpper(soggetto.getAnagrafica().getCodiceFiscale()));
		}

		if (!cfSoggetti.contains(codiceFiscale)) {
			throw ErrorCodeEnum.VAL_DOM_010.buildException();
		}

		log.info(buildMessage(getClass(), methodName, LOG_END));
	}

	private void checkEtaNido(DomandaNido domandaNido) throws DaoException, ServiceException, ValidationException {
		final String methodName = "checkEtaNido";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		Integer annoLimite = null;
		String codAnno = this.getAnnoScolastico(TipoScuola.NID).getCodAnnoScolastico();
		if (StringUtils.isNotBlank(codAnno)) {
			StringTokenizer tokenizer = new StringTokenizer(codAnno, "-");
			if (tokenizer.hasMoreElements()) {
				annoLimite = Integer.valueOf(tokenizer.nextToken());
			}
		}

		if (annoLimite == null) {
			throw ErrorCodeEnum.VAL_DOM_002.buildException();
		}

		boolean iscrizioneNidoMinore = DomandaUtils.iscrizione(
				DomandaUtils.toDate(domandaNido.getMinore().getAnagrafica().getDataNascita()), annoLimite, MAX_ANNI_NIDO);

		if (!iscrizioneNidoMinore) {
			throw ErrorCodeEnum.VAL_DOM_011.buildException("minore");
		}

		FratelloFrequentante fratelloFrequentante = domandaNido.getMinore().getFratelloFrequentante();
		if (fratelloFrequentante == null || !Boolean.TRUE.equals(fratelloFrequentante.getStato())) {
			return;
		}

		boolean iscrizioneNidoFratello = DomandaUtils.iscrizione(
				DomandaUtils.toDate(fratelloFrequentante.getAnagrafica().getDataNascita()), annoLimite, MAX_ANNI_NIDO);

		if (!iscrizioneNidoFratello) {
			throw ErrorCodeEnum.VAL_DOM_011.buildException("fratello frequentante");
		}

		log.info(buildMessage(getClass(), methodName, LOG_END));
	}

	//////////////////////////////////////////////////////////////////////
	// Utility
	//////////////////////////////////////////////////////////////////////
	private static String getCfRichiedente(DomandaNido domandaNido) throws ValidationException {
		String codiceFiscaleRic = domandaNido.getRichiedente().getAnagrafica().getCodiceFiscale();

		if (StringUtils.isBlank(codiceFiscaleRic)) {
			throw ErrorCodeEnum.VAL_DOM_003.buildException();
		}

		return codiceFiscaleRic;
	}

	private static String getCfMinore(DomandaNido domandaNido) throws ValidationException {
		String codiceFiscaleMin = domandaNido.getMinore().getAnagrafica().getCodiceFiscale();

		if (StringUtils.isBlank(codiceFiscaleMin)) {
			throw ErrorCodeEnum.VAL_DOM_004.buildException();
		}

		return codiceFiscaleMin;
	}

}
