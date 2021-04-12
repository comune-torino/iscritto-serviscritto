package it.csi.iscritto.serviscritto.business.domanda.service;

import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.LOG_BEGIN;
import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.LOG_END;
import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.buildMessage;
import static it.csi.iscritto.serviscritto.business.util.converter.ConvertUtils.getFirst;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import org.apache.log4j.Logger;

import it.csi.iscritto.serviscritto.business.integration.converter.domande.RicevutaAccettazioneConverter;
import it.csi.iscritto.serviscritto.business.integration.dao.StatoDomanda;
import it.csi.iscritto.serviscritto.business.integration.dao.StatoScuola;
import it.csi.iscritto.serviscritto.business.integration.dao.TipoScuola;
import it.csi.iscritto.serviscritto.business.integration.dao.TipoSoggetto;
import it.csi.iscritto.serviscritto.business.integration.dao.custom.AccettazioneDao;
import it.csi.iscritto.serviscritto.business.integration.dao.custom.dto.DatiAccettazioneRow;
import it.csi.iscritto.serviscritto.business.integration.dao.table.DecodificaDao;
import it.csi.iscritto.serviscritto.business.integration.dao.table.DomandaIscDao;
import it.csi.iscritto.serviscritto.business.integration.dao.table.UtenteDao;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoDStatoScu;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoRScuolaPre;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTUtente;
import it.csi.iscritto.serviscritto.business.integration.dao.view.SoggettoDao;
import it.csi.iscritto.serviscritto.business.integration.dao.view.dto.SoggettoRow;
import it.csi.iscritto.serviscritto.business.integration.exception.DaoException;
import it.csi.iscritto.serviscritto.business.integration.exception.ServiceException;
import it.csi.iscritto.serviscritto.business.integration.validation.ErrorCodeEnum;
import it.csi.iscritto.serviscritto.business.util.Constants;
import it.csi.iscritto.serviscritto.business.util.LoggingUtils;
import it.csi.iscritto.serviscritto.business.util.converter.ConvertUtils;
import it.csi.iscritto.serviscritto.dto.domanda.CondizionePunteggio;
import it.csi.iscritto.serviscritto.dto.domanda.DomandaMaterna;
import it.csi.iscritto.serviscritto.dto.domanda.DomandaNido;
import it.csi.iscritto.serviscritto.dto.domanda.Materna;
import it.csi.iscritto.serviscritto.dto.domanda.Nido;
import it.csi.iscritto.serviscritto.dto.domanda.RicevutaAccettazione;
import it.csi.iscritto.serviscritto.dto.domanda.Richiedente;
import it.csi.iscritto.serviscritto.dto.domanda.TestataDomandaAccettazione;
import it.csi.iscritto.serviscritto.exception.domanda.ValidationException;

public class AccettazioneService {
	private static final Logger log = Logger.getLogger(Constants.COMPONENT_NAME + ".business");

	public static final int MAX_RIFIUTI = 3;
	public static final int MAX_PREFERENZE = 10;

	private AccettazioneDao accettazioneDao;
	private UtenteDao utenteDao;
	private DomandaIscDao domandaIscDao;
	private DecodificaDao decodificaDao;
	private SoggettoDao soggettoDao;

	public void setAccettazioneDao(AccettazioneDao accettazioneDao) {
		this.accettazioneDao = accettazioneDao;
	}

	public void setUtenteDao(UtenteDao utenteDao) {
		this.utenteDao = utenteDao;
	}

	public void setDomandaIscDao(DomandaIscDao domandaIscDao) {
		this.domandaIscDao = domandaIscDao;
	}

	public void setDecodificaDao(DecodificaDao decodificaDao) {
		this.decodificaDao = decodificaDao;
	}

	public void setSoggettoDao(SoggettoDao soggettoDao) {
		this.soggettoDao = soggettoDao;
	}

	//////////////////////////////////////////////////////////////////////

	public static enum TipoOperazione {
		ELENCO,
		ACCETTA,
		RIFIUTA,
		;
	}

	//////////////////////////////////////////////////////////////////////

	public TestataDomandaAccettazione getDatiAccettazione(Long idDomanda, List<Nido> elencoNidi, List<CondizionePunteggio> condizioniPunteggio, String codScuola)
			throws ServiceException, DaoException {

		final String methodName = "getDatiAccettazione";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		log.info(buildMessage(getClass(), methodName, "idDomanda: " + idDomanda));
		Validate.notNull(idDomanda);

		DatiAccettazioneRow row = this.accettazioneDao.findDatiAccettazione(idDomanda, codScuola);
		TestataDomandaAccettazione result = buildTestata(row, elencoNidi, condizioniPunteggio);

		log.info(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}
	public TestataDomandaAccettazione getDatiAccettazioneMaterna(Long idDomanda, List<Materna> elencoMaterne, List<CondizionePunteggio> condizioniPunteggio, String codScuola)
			throws ServiceException, DaoException {

		final String methodName = "getDatiAccettazioneMaterna";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		log.info(buildMessage(getClass(), methodName, "idDomanda: " + idDomanda));
		Validate.notNull(idDomanda);

		DatiAccettazioneRow row = this.accettazioneDao.findDatiAccettazione(idDomanda, codScuola);
		TestataDomandaAccettazione result = buildTestataMaterna(row, elencoMaterne, condizioniPunteggio);
		log.info("@@@ SERVISCRITTO getDatiAccezioneMaterna: "+result);
		log.info(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	public void accettaPreferenza(
			TipoScuola tipoScuola, Long idDomanda, String cfOperatore, String codScuola, String codTipoFrequenza, String telRichiedente, String codTipoPasto)
			throws DaoException, ValidationException {

		final String methodName = "accettaPreferenza";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		log.info(buildMessage(getClass(), methodName, "tipoScuola: " + tipoScuola));
		log.info(buildMessage(getClass(), methodName, "idDomanda: " + idDomanda));
		log.info(buildMessage(getClass(), methodName, "cfOperatore: " + cfOperatore));
		log.info(buildMessage(getClass(), methodName, "codScuola: " + codScuola));
		log.info(buildMessage(getClass(), methodName, "codTipoFrequenza: " + codTipoFrequenza));
		log.info(buildMessage(getClass(), methodName, "codTipoPasto: " + codTipoPasto));

		this.checkIdDomanda(idDomanda);
		this.checkCfOperatore(cfOperatore);
		this.checkCodScuola(codScuola);
		this.checkCodTipoFrequenza(codTipoFrequenza);
		this.checkTelefonoRichiedente(telRichiedente);
		this.checkCodTipoPasto(tipoScuola, codScuola, codTipoPasto);

		IscrittoRScuolaPre preferenza = this.accettazioneDao.findPreferenza(idDomanda, codScuola, codTipoFrequenza);
		if (preferenza == null) {
			log.error(buildMessage(getClass(), methodName, "preferenza non trovata"));
			throw ErrorCodeEnum.VAL_ACC_003.buildException();
		}

		Long idStatoScuola = preferenza.getIdStatoScu();
		if (idStatoScuola == null) {
			log.error(buildMessage(getClass(), methodName, "idStatoScuola non trovato"));
			throw ErrorCodeEnum.VAL_ACC_006.buildException();
		}

		IscrittoDStatoScu statoScuola = this.decodificaDao.findIscrittoDStatoScuByKey(idStatoScuola);
		if (!StatoScuola.AMM.getCod().equals(statoScuola.getCodStatoScu())) {
			log.error(buildMessage(getClass(), methodName, "stato scuola non valido: " + statoScuola.getCodStatoScu()));
			throw ErrorCodeEnum.VAL_ACC_006.buildException();
		}

		Integer posizione = preferenza.getPosizione();
		if (posizione == null) {
			log.error(buildMessage(getClass(), methodName, "posizione nulla"));
			throw ErrorCodeEnum.VAL_ACC_004.buildException();
		}

		int updatedRows;
		updatedRows = this.accettazioneDao.modificaPreferenza(idDomanda, codScuola, codTipoFrequenza, StatoScuola.ACC);
		if (updatedRows == 0) {
			log.error(buildMessage(getClass(), methodName, "nessuna preferenza modificata"));
			throw ErrorCodeEnum.VAL_ACC_005.buildException();
		}

		updatedRows = this.accettazioneDao.modificaPostiPerAccettazione(tipoScuola, idDomanda, codScuola, codTipoFrequenza);
		if (updatedRows != 1) {
			log.error(buildMessage(getClass(), methodName, "numero posti modificati: " + updatedRows));
			throw ErrorCodeEnum.VAL_ACC_005.buildException();
		}

		this.accettazioneDao.modificaAltrePreferenze(idDomanda, posizione.intValue() == 1 ? StatoScuola.CAN_1SC : StatoScuola.CAN);
		this.accettazioneDao.modificaStatoDomanda(idDomanda, StatoDomanda.ACC);

		this.accettazioneDao.modificaStatoGraduatoria(idDomanda, codScuola, codTipoFrequenza, StatoScuola.ACC);
		this.accettazioneDao.modificaStatoAltreGraduatorie(idDomanda, posizione.intValue() == 1 ? StatoScuola.CAN_1SC : StatoScuola.CAN);

		Long idAccettazioneRin = this.accettazioneDao.insertOperazione(idDomanda, cfOperatore, codScuola, codTipoFrequenza, true);
		this.accettazioneDao.insertInvioAccettazione(idAccettazioneRin, telRichiedente, codTipoPasto);

		log.info(buildMessage(getClass(), methodName, LOG_END));
	}

	public void rifiutaPreferenza(TipoScuola tipoScuola, Long idDomanda, String cfOperatore, String codScuola, String codTipoFrequenza)
			throws DaoException, ValidationException {

		final String methodName = "rifiutaPreferenza";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		log.info(buildMessage(getClass(), methodName, "idDomanda: " + idDomanda));
		log.info(buildMessage(getClass(), methodName, "cfOperatore: " + cfOperatore));
		log.info(buildMessage(getClass(), methodName, "codScuola: " + codScuola));
		log.info(buildMessage(getClass(), methodName, "codTipoFrequenza: " + codTipoFrequenza));

		this.checkIdDomanda(idDomanda);
		this.checkCfOperatore(cfOperatore);
		this.checkCodScuola(codScuola);
		this.checkCodTipoFrequenza(codTipoFrequenza);

		IscrittoRScuolaPre preferenza = this.accettazioneDao.findPreferenza(idDomanda, codScuola, codTipoFrequenza);
		if (preferenza == null) {
			log.error(buildMessage(getClass(), methodName, "preferenza non trovata"));
			throw ErrorCodeEnum.VAL_ACC_003.buildException();
		}

		Long idStatoScuola = preferenza.getIdStatoScu();
		if (idStatoScuola == null) {
			log.error(buildMessage(getClass(), methodName, "idStatoScuola non trovato"));
			throw ErrorCodeEnum.VAL_ACC_006.buildException();
		}

		IscrittoDStatoScu statoScuola = this.decodificaDao.findIscrittoDStatoScuByKey(idStatoScuola);
		if (!StatoScuola.AMM.getCod().equals(statoScuola.getCodStatoScu())) {
			log.error(buildMessage(getClass(), methodName, "stato scuola non valido: " + statoScuola.getCodStatoScu()));
			throw ErrorCodeEnum.VAL_ACC_006.buildException();
		}

		Integer posizione = preferenza.getPosizione();
		if (posizione == null) {
			log.error(buildMessage(getClass(), methodName, "posizione nulla"));
			throw ErrorCodeEnum.VAL_ACC_004.buildException();
		}

		int updatedRows;
		updatedRows = this.accettazioneDao.modificaPreferenza(idDomanda, codScuola, codTipoFrequenza, StatoScuola.RIN);
		if (updatedRows == 0) {
			log.error(buildMessage(getClass(), methodName, "nessuna preferenza modificata"));
			throw ErrorCodeEnum.VAL_ACC_005.buildException();
		}

		updatedRows = this.accettazioneDao.modificaPostiPerRifiuto(tipoScuola, idDomanda, codScuola, codTipoFrequenza);
		if (updatedRows != 1) {
			log.error(buildMessage(getClass(), methodName, "numero posti modificati: " + updatedRows));
			throw ErrorCodeEnum.VAL_ACC_005.buildException();
		}

		this.accettazioneDao.modificaStatoDomanda(idDomanda, StatoDomanda.GRA);
		this.accettazioneDao.modificaStatoGraduatoria(idDomanda, codScuola, codTipoFrequenza, StatoScuola.RIN);

		int rinunceUtente = CollectionUtils.size(
				this.accettazioneDao.findPreferenzeByCodStatoScuola(idDomanda, StatoScuola.RIN));

		int rinunceAutomatiche = CollectionUtils.size(
				this.accettazioneDao.findPreferenzeByCodStatoScuola(idDomanda, StatoScuola.RIN_AUTO));

		log.info(buildMessage(getClass(), methodName, "rinunce utente: " + rinunceUtente));
		log.info(buildMessage(getClass(), methodName, "rinunce automatiche: " + rinunceAutomatiche));

		if (rinunceUtente + rinunceAutomatiche >= MAX_RIFIUTI) {
			this.accettazioneDao.modificaAltrePreferenze(idDomanda, StatoScuola.CAN_RIN);
			this.accettazioneDao.modificaStatoAltreGraduatorie(idDomanda, StatoScuola.CAN_RIN);
			this.accettazioneDao.modificaStatoDomanda(idDomanda, StatoDomanda.RIN);
		}
		else {
			if (posizione.intValue() == 1) {
				this.accettazioneDao.modificaAltrePreferenze(idDomanda, StatoScuola.CAN_R_1SC);
				this.accettazioneDao.modificaStatoAltreGraduatorie(idDomanda, StatoScuola.CAN_R_1SC);
				this.accettazioneDao.modificaStatoDomanda(idDomanda, StatoDomanda.RIN);
			}
		}

		this.accettazioneDao.insertOperazione(idDomanda, cfOperatore, codScuola, codTipoFrequenza, false);

		log.info(buildMessage(getClass(), methodName, LOG_END));
	}

	public void aggiornaTelefonoRichiedente(Long idDomanda, String telRichiedente) throws DaoException, ValidationException {
		final String methodName = "aggiornaTelefonoRichiedente";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		log.info(buildMessage(getClass(), methodName, "idDomanda: " + idDomanda));

		this.checkIdDomanda(idDomanda);
		this.checkTelefonoRichiedente(telRichiedente);

		this.accettazioneDao.modificaTelRichiedente(idDomanda, telRichiedente);

		log.info(buildMessage(getClass(), methodName, LOG_END));
	}

	public void aggiornaDomanda(Long idDomanda, String cfOperatore) throws DaoException, ValidationException {
		final String methodName = "aggiornaDomanda";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		log.info(buildMessage(getClass(), methodName, "idDomanda: " + idDomanda));
		log.info(buildMessage(getClass(), methodName, "cfOperatore: " + cfOperatore));

		this.checkIdDomanda(idDomanda);
		this.checkCfOperatore(cfOperatore);

		if (StringUtils.isNotBlank(cfOperatore)) {
			IscrittoTUtente utente = this.utenteDao.findIscrittoTUtenteByCF(cfOperatore);
			this.domandaIscDao.updateUltimaModifica(idDomanda, utente.getIdUtente());
		}
		else {
			this.domandaIscDao.updateUltimaModifica(idDomanda, null);
		}

		log.info(buildMessage(getClass(), methodName, LOG_END));
	}

	public void checkDomanda(DomandaNido domandaNido, String cfRichiedente, TipoOperazione tipoOperazione) throws ValidationException {
		final String methodName = "checkDomanda";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		if (domandaNido == null) {
			throw ErrorCodeEnum.VAL_DOM_007.buildException();
		}

		Richiedente richiedente = domandaNido.getRichiedente();
		boolean richiedenteValido = true
				&& richiedente != null
				&& richiedente.getAnagrafica() != null
				&& StringUtils.isNotBlank(richiedente.getAnagrafica().getCodiceFiscale());

		if (!richiedenteValido) {
			throw ErrorCodeEnum.VAL_DOM_003.buildException();
		}

		if (StringUtils.isBlank(cfRichiedente)) {
			throw ErrorCodeEnum.VAL_CF_001.buildException("cfRichiedente");
		}

		if (!cfRichiedente.equalsIgnoreCase(richiedente.getAnagrafica().getCodiceFiscale())) {
			throw ErrorCodeEnum.VAL_DOM_016.buildException();
		}

		if (ArrayUtils.isEmpty(domandaNido.getElencoNidi())) {
			throw ErrorCodeEnum.VAL_NID_002.buildException();
		}

		switch (tipoOperazione) {
			case ELENCO:
				for (StatoDomanda e : Arrays.asList(StatoDomanda.BOZ, StatoDomanda.INV, StatoDomanda.ANN)) {
					if (e.getCod().equals(domandaNido.getStatoDomanda())) {
						throw ErrorCodeEnum.VAL_DOM_008.buildException();
					}
				}
				break;
			case ACCETTA:
			case RIFIUTA:
				if (!StatoDomanda.AMM.getCod().equals(domandaNido.getStatoDomanda())) {
					throw ErrorCodeEnum.VAL_DOM_008.buildException();
				}
				break;
			default:
				break;
		}

		log.info(buildMessage(getClass(), methodName, LOG_END));
	}
	public void checkDomandaMaterna(DomandaMaterna domandaMaterna, String cfRichiedente, TipoOperazione tipoOperazione) throws ValidationException {
		final String methodName = "checkDomandaMaterna";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		if (domandaMaterna == null) {
			throw ErrorCodeEnum.VAL_DOM_007.buildException();
		}

		Richiedente richiedente = domandaMaterna.getRichiedente();
		boolean richiedenteValido = true
				&& richiedente != null
				&& richiedente.getAnagrafica() != null
				&& StringUtils.isNotBlank(richiedente.getAnagrafica().getCodiceFiscale());

		if (!richiedenteValido) {
			throw ErrorCodeEnum.VAL_DOM_003.buildException();
		}

		if (StringUtils.isBlank(cfRichiedente)) {
			throw ErrorCodeEnum.VAL_CF_001.buildException("cfRichiedente");
		}

		if (!cfRichiedente.equalsIgnoreCase(richiedente.getAnagrafica().getCodiceFiscale())) {
			throw ErrorCodeEnum.VAL_DOM_016.buildException();
		}

		if (ArrayUtils.isEmpty(domandaMaterna.getElencoMaterne())) {
			throw ErrorCodeEnum.VAL_NID_002.buildException();
		}

		switch (tipoOperazione) {
			case ELENCO:
				for (StatoDomanda e : Arrays.asList(StatoDomanda.BOZ, StatoDomanda.INV, StatoDomanda.ANN)) {
					if (e.getCod().equals(domandaMaterna.getStatoDomanda())) {
						throw ErrorCodeEnum.VAL_DOM_008.buildException();
					}
				}
				break;
			case ACCETTA:
			case RIFIUTA:
				if (!StatoDomanda.AMM.getCod().equals(domandaMaterna.getStatoDomanda())) {
					throw ErrorCodeEnum.VAL_DOM_008.buildException();
				}
				break;
			default:
				break;
		}

		log.info(buildMessage(getClass(), methodName, LOG_END));
	}

	public void aggiungiPreferenzaFuoriTermine(TipoScuola tipoScuola, Long idDomanda, String cfOperatore, String codScuola, String codTipoFrequenza)
			throws DaoException, ValidationException {

		final String methodName = "aggiungiPreferenzaFuoriTermine";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		log.info(buildMessage(getClass(), methodName, "tipoScuola: " + tipoScuola));
		log.info(buildMessage(getClass(), methodName, "idDomanda: " + idDomanda));
		log.info(buildMessage(getClass(), methodName, "cfOperatore: " + cfOperatore));
		log.info(buildMessage(getClass(), methodName, "codScuola: " + codScuola));
		log.info(buildMessage(getClass(), methodName, "codTipoFrequenza: " + codTipoFrequenza));

		this.checkCfOperatore(cfOperatore);

		List<IscrittoRScuolaPre> preferenze = this.accettazioneDao.findPreferenzeByIdDomanda(idDomanda);

		int numPreferenzeAttuali = CollectionUtils.size(preferenze);
		log.info(buildMessage(getClass(), methodName, "numPreferenzeAttuali: " + numPreferenzeAttuali));

		if (numPreferenzeAttuali >= MAX_PREFERENZE) {
			log.error(buildMessage(getClass(), methodName, "numero preferenze non valido"));
			throw ErrorCodeEnum.VAL_DOM_018.buildException();
		}

		Integer insertResult = this.accettazioneDao.insertPreferenzaFuoriTermine(tipoScuola, idDomanda, codScuola, codTipoFrequenza);
		log.info(buildMessage(getClass(), methodName, "insertResult: " + insertResult));

		IscrittoTUtente utente = this.utenteDao.findIscrittoTUtenteByCF(cfOperatore);
		this.domandaIscDao.updateUltimaModifica(idDomanda, utente.getIdUtente());
		log.info(buildMessage(getClass(), methodName, "domanda aggiornata dall'operatore: " + cfOperatore));

		log.info(buildMessage(getClass(), methodName, LOG_END));
	}

	public RicevutaAccettazione getRicevutaAccettazione(Long idDomanda, String cfRichiedente) throws DaoException, ValidationException {
		final String methodName = "getRicevutaAccettazione";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));
		log.info(buildMessage(getClass(), methodName, "idDomanda: " + idDomanda));

		this.checkIdDomanda(idDomanda);
		this.checkRichiedente(idDomanda, cfRichiedente);

		RicevutaAccettazione result = new RicevutaAccettazioneConverter().convert(
				this.accettazioneDao.findRicevutaAccettazione(idDomanda));

		log.info(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	//////////////////////////////////////////////////////////////////////

	private void checkIdDomanda(Long idDomanda) throws ValidationException {
		if (idDomanda == null) {
			throw ErrorCodeEnum.VAL_DOM_007.buildException();
		}
	}

	private void checkCodScuola(String codScuola) throws ValidationException {
		if (StringUtils.isBlank(codScuola)) {
			throw ErrorCodeEnum.VAL_ACC_001.buildException();
		}
	}

	private void checkCodTipoFrequenza(String codTipoFrequenza) throws ValidationException {
		if (StringUtils.isBlank(codTipoFrequenza)) {
			throw ErrorCodeEnum.VAL_ACC_002.buildException();
		}
	}

	private void checkTelefonoRichiedente(String telRichiedente) throws ValidationException {
		if (StringUtils.isBlank(telRichiedente)) {
			throw ErrorCodeEnum.VAL_ACC_007.buildException();
		}
	}

	private void checkCodTipoPasto(TipoScuola tipoScuola, String codScuola, String codTipoPasto) throws DaoException, ValidationException {
		if (StringUtils.isBlank(codTipoPasto)) {
			boolean isTipoPastoObbligatorio = this.accettazioneDao.isTipoPastoObbligatorio(tipoScuola, codScuola);
			if (isTipoPastoObbligatorio) {
				throw ErrorCodeEnum.VAL_ACC_008.buildException();
			}
		}
	}

	private void checkCfOperatore(String cfOperatore) throws DaoException, ValidationException {
		if (StringUtils.isNotBlank(cfOperatore)) {
			IscrittoTUtente utente = this.utenteDao.findIscrittoTUtenteByCF(cfOperatore);
			if (utente == null) {
				throw ErrorCodeEnum.VAL_DOM_012.buildException("codiceFiscale: " + cfOperatore);
			}
		}
	}

	private void checkRichiedente(Long idDomanda, String cfRichiedente) throws DaoException, ValidationException {
		if (StringUtils.isBlank(cfRichiedente) || idDomanda == null) {
			throw ErrorCodeEnum.VAL_DOM_016.buildException();
		}

		SoggettoRow richiedente = getFirst(this.soggettoDao.findSoggettiByIdDomanda(idDomanda, TipoSoggetto.RIC));
		if (richiedente == null) {
			throw ErrorCodeEnum.VAL_DOM_016.buildException();
		}

		if (!cfRichiedente.equalsIgnoreCase(richiedente.getCodiceFiscale())) {
			throw ErrorCodeEnum.VAL_DOM_016.buildException();
		}
	}

	//////////////////////////////////////////////////////////////////////

	private static TestataDomandaAccettazione buildTestata(DatiAccettazioneRow row, List<Nido> elencoNidi, List<CondizionePunteggio> condizioniPunteggio) {
		TestataDomandaAccettazione result = new TestataDomandaAccettazione();

		result.setAnnoScolastico(row.getCodAnnoScolastico());
		result.setCodOrdineScuola(row.getCodOrdineScuola());
		result.setCodStatoDomanda(row.getCodStatoDom());
		result.setCognomeMinore(row.getCognomeMinore());
		result.setDataInvio(row.getDataConsegna());
		result.setDataUltimaModifica(row.getDtModifica());
		result.setElencoPreferenze(ConvertUtils.toArray(elencoNidi, Nido.class));
		result.setIdDomandaIscrizione(row.getIdDomandaIscrizione());
		result.setNomeMinore(row.getNomeMinore());
		result.setProtocollo(row.getProtocollo());
		result.setTelefonoRichiedente(row.getTelefono());
		result.setCodTipoPasto(row.getCodTipoPasto());

		if (CollectionUtils.isNotEmpty(condizioniPunteggio)) {
			result.setElencoCondizioniPunteggio(ConvertUtils.toArray(condizioniPunteggio, CondizionePunteggio.class));
		}

		return result;
	}

	private static TestataDomandaAccettazione buildTestataMaterna(DatiAccettazioneRow row, List<Materna> elencoMaterne, List<CondizionePunteggio> condizioniPunteggio) {
		TestataDomandaAccettazione result = new TestataDomandaAccettazione();

		//LoggingUtils.stampa(row, true, 3);

		result.setAnnoScolastico(row.getCodAnnoScolastico());
		result.setCodOrdineScuola(row.getCodOrdineScuola());
		result.setCodStatoDomanda(row.getCodStatoDom());
		result.setCognomeMinore(row.getCognomeMinore());
		result.setDataInvio(row.getDataConsegna());
		result.setDataUltimaModifica(row.getDtModifica());
		result.setElencoPreferenzeMaterna(ConvertUtils.toArray(elencoMaterne, Materna.class));
		result.setIdDomandaIscrizione(row.getIdDomandaIscrizione());
		result.setNomeMinore(row.getNomeMinore());
		result.setProtocollo(row.getProtocollo());
		result.setTelefonoRichiedente(row.getTelefono());
		result.setCodTipoPasto(row.getCodTipoPasto());

		log.info("@@@ valorizzato irc?:  " + row.getIrc());
		if(row.getIrc() != null) {
			//la scuola non e' convenzionata
			log.info("@@@ scuola non convenzionata");


			result.setIrc(row.getIrc());

			log.info("@@@ ok");
		}else {
			log.info("@@@ scuola convenzionata");
			result.setIrc(null);
		}

	//	LoggingUtils.stampa(result, true, 3);

		if (CollectionUtils.isNotEmpty(condizioniPunteggio)) {
			result.setElencoCondizioniPunteggio(ConvertUtils.toArray(condizioniPunteggio, CondizionePunteggio.class));
		}

		return result;
	}



}
