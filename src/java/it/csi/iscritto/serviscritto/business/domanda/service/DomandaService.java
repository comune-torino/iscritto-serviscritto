package it.csi.iscritto.serviscritto.business.domanda.service;

import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.LOG_BEGIN;
import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.LOG_END;
import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.buildMessage;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.Validate;
import org.apache.log4j.Logger;

import it.csi.iscritto.serviscritto.business.domanda.filter.DomandeFilterValidator;
import it.csi.iscritto.serviscritto.business.domanda.filter.DomandeIstruttoriaFilterValidator;
import it.csi.iscritto.serviscritto.business.domanda.filter.TipoTestata;
import it.csi.iscritto.serviscritto.business.integration.converter.domande.CallerInfoDomandaConverter;
import it.csi.iscritto.serviscritto.business.integration.converter.domande.CodificaConverter;
import it.csi.iscritto.serviscritto.business.integration.converter.domande.FasciaEtaConverter;
import it.csi.iscritto.serviscritto.business.integration.converter.domande.TestataDomandaDaVerificareConverter;
import it.csi.iscritto.serviscritto.business.integration.converter.domande.TestataDomandeConverter;
import it.csi.iscritto.serviscritto.business.integration.converter.domande.TestataDomandeIstruttoriaConverter;
import it.csi.iscritto.serviscritto.business.integration.dao.StatoCondizionePunteggio;
import it.csi.iscritto.serviscritto.business.integration.dao.TipoScuola;
import it.csi.iscritto.serviscritto.business.integration.dao.view.dto.TestataDomandaRow;
import it.csi.iscritto.serviscritto.business.integration.exception.DaoException;
import it.csi.iscritto.serviscritto.business.util.Constants;
import it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda;
import it.csi.iscritto.serviscritto.dto.domanda.Codifica;
import it.csi.iscritto.serviscritto.dto.domanda.CriterioRicerca;
import it.csi.iscritto.serviscritto.dto.domanda.CriterioRicercaIstruttoria;
import it.csi.iscritto.serviscritto.dto.domanda.FasciaEta;
import it.csi.iscritto.serviscritto.dto.domanda.TestataDomanda;
import it.csi.iscritto.serviscritto.dto.domanda.TestataDomandaDaVerificare;
import it.csi.iscritto.serviscritto.dto.domanda.TestataDomandaIstruttoria;
import it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException;
import it.csi.iscritto.serviscritto.exception.domanda.InvalidFilterException;

public class DomandaService extends AbstractDomandaService {
	private static final Logger log = Logger.getLogger(Constants.COMPONENT_NAME + ".business");

	public void logAudit(CallerInfoDomanda callerInfo) throws DaoException {
		if (callerInfo != null) {
			this.auditLogDao.logAudit(new CallerInfoDomandaConverter().convert(callerInfo));
		}
	}

	public List<Long> getElencoDomande(TipoScuola tipoScuola, String cfOperatore, String codProfilo, CriterioRicerca criterioRicerca)
			throws InvalidFilterException, DaoException {

		final String methodName = "getElencoDomande";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		log.info(buildMessage(getClass(), methodName, "tipoScuola: " + tipoScuola));
		log.info(buildMessage(getClass(), methodName, "codProfilo: " + codProfilo));
		Validate.notNull(tipoScuola);

		// check del filtro di ricerca compilato, a carico del validatore
		DomandeFilterValidator validator = new DomandeFilterValidator(criterioRicerca);
		int criterioCompilato = validator.validateTipologiaCriterio();

		List<Long> chiavi = null;

		switch (criterioCompilato) {
			case Constants.CRITERIO_RICERCA_DOMANDE_CODICE_FISCALE_MIN:
				validator.validateCriterioPerCodiceFiscaleMinore();

				String cfMinore = criterioRicerca.getCodiceFiscaleMinore();

				chiavi = this.domandaDao.findDomandeByCodiceFiscaleMinore(
						tipoScuola, cfOperatore, codProfilo, cfMinore);
				break;
			case Constants.CRITERIO_RICERCA_DOMANDE_CODICE_FISCALE_RIC:
				// caso del FE, le scuole non sono filtrate
				validator.validateCriterioPerCodiceFiscaleRichiedente();

				String cfRichiedente = criterioRicerca.getCodiceFiscaleRichiedente();

				chiavi = this.domandaDao.findDomandeByCodiceFiscaleRichiedente(
						tipoScuola, cfRichiedente);
				break;
			case Constants.CRITERIO_RICERCA_DOMANDE_COGNOME_NOME:
				validator.validateCriterioPerCognomeNomeMinore();

				String cognomeMinore = criterioRicerca.getCognomeMinore();
				String nomeMinore = criterioRicerca.getNomeMinore();

				chiavi = this.domandaDao.findDomandeByCognomeNomeMinore(
						tipoScuola, cfOperatore, codProfilo, cognomeMinore, nomeMinore);
				break;
			case Constants.CRITERIO_RICERCA_DOMANDE_SCUOLA_STATO:
				validator.validateCriterioPerScuolaStatoDomanda();

				String codiceScuola = criterioRicerca.getCodiceScuola();
				String codiceStatoDomanda = criterioRicerca.getCodiceStatoDomanda();

				chiavi = this.domandaDao.findDomandeByCodiceScuola(
						tipoScuola, cfOperatore, codProfilo, codiceScuola, codiceStatoDomanda);
				break;
			case Constants.CRITERIO_RICERCA_DOMANDE_PROTOCOLLO:
				validator.validateCriterioPerProtocollo();

				String protocollo = criterioRicerca.getProtocollo();

				chiavi = this.domandaDao.findDomandeByProtocollo(
						tipoScuola, cfOperatore, codProfilo, protocollo);
				break;
			default:
				break;
		}

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return chiavi;
	}

	public List<TestataDomandaIstruttoria> getDomandeIstruttoria(TipoScuola tipoScuola, CriterioRicercaIstruttoria criterioRicerca, String cfOperatore, String codProfilo)
			throws InvalidFilterException, DaoException {

		final String methodName = "getDomandeIstruttoria";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		log.info(buildMessage(getClass(), methodName, "tipoScuola: " + tipoScuola));
		log.info(buildMessage(getClass(), methodName, "cfOperatore: " + cfOperatore));
		log.info(buildMessage(getClass(), methodName, "codProfilo: " + codProfilo));
		Validate.notNull(tipoScuola);

		List<TestataDomandaIstruttoria> result = new ArrayList<>();

		DomandeIstruttoriaFilterValidator validator = new DomandeIstruttoriaFilterValidator(criterioRicerca);
		int criterioCompilato = validator.validateTipologiaCriterio();

		switch (criterioCompilato) {
			case Constants.CRITERIO_RICERCA_DOMANDE_CONDIZIONE_PUN:
				validator.validateCriterioPerCondizionePunteggio();
				validator.validateCriterioPerCognomeNomeMinore();

				result.addAll(new TestataDomandeIstruttoriaConverter().convertAll(
						this.domandaDao.findDomandeByCondizionePunteggio(
								tipoScuola,
								cfOperatore,
								codProfilo,
								criterioRicerca.getCodiceCondizionePunteggio(),
								StatoCondizionePunteggio.findByCod(criterioRicerca.getStatoCondizionePunteggio()),
								criterioRicerca.getNomeMinore(), criterioRicerca.getCognomeMinore(),
								criterioRicerca.getDataInizio(), criterioRicerca.getDataFine())));

				break;
			default:
				break;
		}

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	public TestataDomanda getTestataDomanda(Long idDomanda, String tipoTestata) throws DaoException, DomandaUserException {
		final String methodName = "getTestataDomanda";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		TestataDomandaRow testata;
		TipoTestata tipo = TipoTestata.findByCod(tipoTestata);
		switch (tipo) {
			case RIC:
				testata = domandaDao.findTestataDomandaRicByIdDomanda(idDomanda);
				break;
			case RIC_MIN:
				testata = domandaDao.findTestataDomandaRicMinByIdDomanda(idDomanda);
				break;
			default:
				log.error(buildMessage(getClass(), methodName, "Tipo testata non valida"));
				throw new DomandaUserException("Tipo testata non valida");
		}

		if (testata == null) {
			log.error(buildMessage(getClass(), methodName, "Domanda di iscrizione NON trovata"));
			throw new DomandaUserException("Domanda di iscrizione NON trovata");
		}

		TestataDomanda result = new TestataDomandeConverter().convert(testata);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	public List<Codifica> getElencoStatiDomanda() throws DaoException {
		final String methodName = "getElencoStatiDomanda";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		List<Codifica> result = new CodificaConverter().convertAll(
				this.domandaDao.findAllStatiDomanda());

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	public List<TestataDomandaDaVerificare> getDomandeDaVerificare(TipoScuola tipoScuola, String codFiscale, String codProfilo) throws DaoException {
		final String methodName = "getDomandeDaVerificare";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		log.info(buildMessage(getClass(), methodName, "tipoScuola: " + tipoScuola));
		log.info(buildMessage(getClass(), methodName, "codice Profilo: " + codProfilo));
		log.info(buildMessage(getClass(), methodName, "codice Fiscale operatore: " + codFiscale));
		Validate.notNull(tipoScuola);

		List<TestataDomandaDaVerificare> result = new TestataDomandaDaVerificareConverter()
				.convertAll(this.domandaDao.findDomandeDaVerificare(tipoScuola, codFiscale,codProfilo));

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	public List<FasciaEta> getFasceEta() throws DaoException {
		final String methodName = "getFasceEta";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		List<FasciaEta> result = new FasciaEtaConverter().convertAll(
				this.scuoleDao.findFasceEta());

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

}
