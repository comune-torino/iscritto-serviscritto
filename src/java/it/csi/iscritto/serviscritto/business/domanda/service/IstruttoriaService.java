package it.csi.iscritto.serviscritto.business.domanda.service;

import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.LOG_BEGIN;
import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.LOG_END;
import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.buildMessage;

import java.util.Date;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import it.csi.iscritto.serviscritto.business.integration.converter.domande.DatiCondizionePunteggioConverter;
import it.csi.iscritto.serviscritto.business.integration.converter.domande.InfoAllegatoSoggettoConverter;
import it.csi.iscritto.serviscritto.business.integration.converter.domande.VerbaleCommissioneConverter;
import it.csi.iscritto.serviscritto.business.integration.dao.StatoDomanda;
import it.csi.iscritto.serviscritto.business.integration.dao.StatoScuola;
import it.csi.iscritto.serviscritto.business.integration.dao.TipoCondizionePunteggio;
import it.csi.iscritto.serviscritto.business.integration.dao.TipoScuola;
import it.csi.iscritto.serviscritto.business.integration.dao.TipoValidazione;
import it.csi.iscritto.serviscritto.business.integration.dao.custom.GraduatoriaDao;
import it.csi.iscritto.serviscritto.business.integration.dao.custom.IstruttoriaDao;
import it.csi.iscritto.serviscritto.business.integration.dao.custom.dto.DatiCondizionePunteggioRow;
import it.csi.iscritto.serviscritto.business.integration.dao.custom.dto.InfoAllegatoSoggettoRow;
import it.csi.iscritto.serviscritto.business.integration.dao.table.ScuolaDao;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTAnagraficaGra;
import it.csi.iscritto.serviscritto.business.integration.exception.DaoException;
import it.csi.iscritto.serviscritto.business.integration.validation.ErrorCodeEnum;
import it.csi.iscritto.serviscritto.business.util.Constants;
import it.csi.iscritto.serviscritto.business.util.converter.ConvertUtils;
import it.csi.iscritto.serviscritto.dto.domanda.DatiCondizionePunteggio;
import it.csi.iscritto.serviscritto.dto.domanda.DomandaMaterna;
import it.csi.iscritto.serviscritto.dto.domanda.DomandaNido;
import it.csi.iscritto.serviscritto.dto.domanda.InfoAllegatoSoggetto;
import it.csi.iscritto.serviscritto.dto.domanda.Materna;
import it.csi.iscritto.serviscritto.dto.domanda.Nido;
import it.csi.iscritto.serviscritto.dto.domanda.VerbaleCommissione;
import it.csi.iscritto.serviscritto.exception.domanda.ValidationException;

public class IstruttoriaService {
	private static final Logger log = Logger.getLogger(Constants.COMPONENT_NAME + ".business");

	private IstruttoriaDao istruttoriaDao;
	private ScuolaDao scuolaDao;
	private GraduatoriaDao graduatoriaDao;

	public void setIstruttoriaDao(IstruttoriaDao istruttoriaDao) {
		this.istruttoriaDao = istruttoriaDao;
	}

	public void setScuolaDao(ScuolaDao scuolaDao) {
		this.scuolaDao = scuolaDao;
	}

	public void setGraduatoriaDao(GraduatoriaDao graduatoriaDao) {
		this.graduatoriaDao = graduatoriaDao;
	}

	//////////////////////////////////////////////////////////////////////

	public List<DatiCondizionePunteggio> getStoricoCondizioniPunteggio(Long idDomanda, String codCondizionePunteggio) throws DaoException {
		final String methodName = "getStoricoCondizioniPunteggio";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		log.info(buildMessage(getClass(), methodName, "idDomanda: " + idDomanda));
		log.info(buildMessage(getClass(), methodName, "codCondizionePunteggio: " + codCondizionePunteggio));

		List<DatiCondizionePunteggio> result = new DatiCondizionePunteggioConverter()
				.convertAll(this.istruttoriaDao.findStoricoCondizioniPunteggio(idDomanda, codCondizionePunteggio));

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	public void checkStatus(Long idDomanda, String codCondizionePunteggio, int count) throws DaoException, ValidationException {
		final String methodName = "checkStatus";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		log.info(buildMessage(getClass(), methodName, "idDomanda: " + idDomanda));
		log.info(buildMessage(getClass(), methodName, "codCondizionePunteggio: " + codCondizionePunteggio));
		log.info(buildMessage(getClass(), methodName, "count: " + count));

		List<DatiCondizionePunteggio> result = new DatiCondizionePunteggioConverter()
				.convertAll(this.istruttoriaDao.findStoricoCondizioniPunteggio(idDomanda, codCondizionePunteggio));

		if (result.size() != count) {
			throw ErrorCodeEnum.VAL_IST_001.buildException();
		}

		log.debug(buildMessage(getClass(), methodName, LOG_END));
	}

	public void modificaCondizionePunteggio(Long idDomanda, TipoScuola tipoScuola, String codCondizionePunteggio, String codiceFiscaleOperatore,
			DatiCondizionePunteggio datiCondizionePunteggio) throws DaoException, ValidationException {

		final String methodName = "modificaCondizionePunteggio";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		log.info(buildMessage(getClass(), methodName, "idDomanda: " + idDomanda));
		log.info(buildMessage(getClass(), methodName, "tipoScuola: " + tipoScuola));
		log.info(buildMessage(getClass(), methodName, "codCondizionePunteggio: " + codCondizionePunteggio));

		boolean isValid = true
				&& idDomanda != null
				&& tipoScuola != null
				&& StringUtils.isNotBlank(codCondizionePunteggio)
				&& StringUtils.isNotBlank(codiceFiscaleOperatore)
				&& datiCondizionePunteggio != null
				&& datiCondizionePunteggio.getValidata() != null
				&& datiCondizionePunteggio.getRicorrenza() != null;

		if (!isValid) {
			throw ErrorCodeEnum.VAL_IST_002.buildException();
		}

		this.checkRicorrenza(idDomanda, codCondizionePunteggio, datiCondizionePunteggio);
		this.checkTipoValidazione(datiCondizionePunteggio);

		DatiCondizionePunteggioRow row = buildDatiCondizionePunteggioRow(
				idDomanda, codCondizionePunteggio, codiceFiscaleOperatore, datiCondizionePunteggio);

		TipoValidazione tipoValidazione = TipoValidazione.findByCod(datiCondizionePunteggio.getTipoValidazione());

		if (tipoValidazione != null) {
			log.info(buildMessage(getClass(), methodName, "tipoValidazione: " + tipoValidazione));

			this.ricalcolaFlagFuoriTermine(idDomanda, tipoScuola);

			switch (tipoValidazione) {
				case ACC_PUN_PRIO:
					this.scuolaDao.updateFlagFuoriTermine(idDomanda, false);
					row.setNote(tipoValidazione.getDesc());
					break;
				case ACC_PUN:
					row.setNote(tipoValidazione.getDesc());
					break;
				case RIF_RIC_INTEGR:
					row.setFlIntegrazione(ConvertUtils.toSN(true));
					break;
				case ACC_RED_CON:
				case RIF_RED_CON:
					String codiceOpposto = TipoCondizionePunteggio.getOppositeCod(codCondizionePunteggio);
					DatiCondizionePunteggioRow lastRow = getLastRow(this.istruttoriaDao.findStoricoCondizioniPunteggio(idDomanda, codiceOpposto));
					if (lastRow != null) {
						if (Boolean.FALSE.equals(ConvertUtils.fromSN(lastRow.getFlValida()))) {
							lastRow.setCodiceFiscaleOperatore(codiceFiscaleOperatore);
							lastRow.setFlValida(null);
							lastRow.setNote(row.getNote());

							this.istruttoriaDao.modificaCondizionePunteggio(lastRow);
						}
					}
					else {
						DatiCondizionePunteggioRow row2 = buildDatiCondizionePunteggioRow(
								idDomanda, codCondizionePunteggio, codiceFiscaleOperatore, datiCondizionePunteggio);

						row2.setCodCondizionePunteggio(codiceOpposto);
						row2.setFlValida(null);

						this.istruttoriaDao.modificaCondizionePunteggio(row2);
					}
					this.insertAllegatiRed(idDomanda, codCondizionePunteggio, codiceOpposto);
					break;
				default:
					break;
			}
		}

		this.gestioneResNotoLav(idDomanda, codCondizionePunteggio, codiceFiscaleOperatore, datiCondizionePunteggio);
		this.gestioneResToAndResToFut(idDomanda, codCondizionePunteggio, codiceFiscaleOperatore, datiCondizionePunteggio);
		this.gestionePaSoc(idDomanda, tipoScuola, codCondizionePunteggio, codiceFiscaleOperatore, datiCondizionePunteggio);

		// jira ISBO-280
		this.gestioneResToAndSonUnder11OrBetween11And17(idDomanda, tipoScuola, codCondizionePunteggio, codiceFiscaleOperatore, datiCondizionePunteggio);

		// jira ISBO-287,346
		this.gestioneGraviProblemiDiSaluteMinore(idDomanda, tipoScuola, codCondizionePunteggio, codiceFiscaleOperatore, datiCondizionePunteggio);

		this.istruttoriaDao.modificaCondizionePunteggio(row);
		this.gestioneFlIstruita(idDomanda);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
	}

	public List<InfoAllegatoSoggetto> getInfoAllegatiDomanda(Long idDomanda, String codCondizionePunteggio) throws DaoException, ValidationException {
		final String methodName = "getInfoAllegatiDomanda";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		log.info(buildMessage(getClass(), methodName, "idDomanda: " + idDomanda));
		log.info(buildMessage(getClass(), methodName, "codCondizionePunteggio: " + codCondizionePunteggio));

		if (idDomanda == null || StringUtils.isBlank(codCondizionePunteggio)) {
			throw ErrorCodeEnum.VAL_IST_002.buildException();
		}

		List<InfoAllegatoSoggetto> result = new InfoAllegatoSoggettoConverter().convertAll(
				this.istruttoriaDao.findAllegatiDomanda(idDomanda, codCondizionePunteggio, true));

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	public List<VerbaleCommissione> getInfoVerbali(
			TipoScuola tipoScuola, String codFiscaleOperatore, String codProfilo, String tipoCommissione, Date dataInizio, Date dataFine) throws DaoException, ValidationException {

		final String methodName = "getInfoVerbali";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		log.info(buildMessage(getClass(), methodName, "tipoScuola: " + tipoScuola));
		log.info(buildMessage(getClass(), methodName, "tipoCommissione: " + tipoCommissione));
		log.info(buildMessage(getClass(), methodName, "dataInizio: " + dataInizio));
		log.info(buildMessage(getClass(), methodName, "dataFine: " + dataFine));
		log.info(buildMessage(getClass(), methodName, "cfOperatore: " + codFiscaleOperatore));
		log.info(buildMessage(getClass(), methodName, "codice Profilo: " + codProfilo));

		if (StringUtils.isBlank(tipoCommissione) || dataInizio == null || dataFine == null) {
			throw ErrorCodeEnum.VAL_IST_002.buildException();
		}

		List<VerbaleCommissione> result = new VerbaleCommissioneConverter().convertAll(
				this.istruttoriaDao.findInfoVerbali(tipoScuola, codFiscaleOperatore, codProfilo, tipoCommissione, dataInizio, dataFine));

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	public void modificaStatoNidi(DomandaNido domandaNido, List<Nido> nidi) throws DaoException, ValidationException {
		final String methodName = "modificaStatoNidi";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		if (domandaNido == null) {
			log.error(buildMessage(getClass(), methodName, "domanda nido non trovata"));
			throw ErrorCodeEnum.VAL_IST_002.buildException();
		}

		String statoDomanda = domandaNido.getStatoDomanda();
		if (StringUtils.isBlank(statoDomanda)) {
			log.error(buildMessage(getClass(), methodName, "stato domanda non valido"));
			throw ErrorCodeEnum.VAL_IST_002.buildException();
		}

		if (CollectionUtils.isEmpty(nidi)) {
			return;
		}

		for (Nido nido : nidi) {
			String codScuola = nido.getCodScuola();
			String codTipoFrequenza = nido.getCodTipoFrequenza();
			String codStatoScuola = nido.getCodStatoScuola();

			if (codStatoScuola != null && !StatoScuola.NON_AMM.getCod().equals(codStatoScuola) && !StatoScuola.PEN.getCod().equals(codStatoScuola)) {
				continue;
			}

			boolean ammissibile = !StatoScuola.NON_AMM.getCod().equals(codStatoScuola);
			StatoScuola statoScuola = null;

			if (ammissibile) {
				if (codStatoScuola == null) {
					statoScuola = null;
				}
				else if (StatoScuola.PEN.getCod().equals(codStatoScuola)) {
					statoScuola = StatoScuola.PEN;
				}
				else if (StatoScuola.NON_AMM.getCod().equals(codStatoScuola)) {
					statoScuola = StatoDomanda.INV.getCod().equals(statoDomanda) ? null : StatoScuola.PEN;
				}
				else {
					continue;
				}
			}
			else {
				statoScuola = StatoScuola.NON_AMM;
			}

			Long idDomanda = domandaNido.getIdDomandaIscrizione();
			this.istruttoriaDao.updateStatoScuola(idDomanda, codScuola, codTipoFrequenza, statoScuola);
		}

		log.debug(buildMessage(getClass(), methodName, LOG_END));
	}

	public void modificaStatoMaterne(DomandaMaterna domandaMaterna, List<Materna> materne) throws DaoException, ValidationException {
		final String methodName = "modificaStatoNidi";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		if (domandaMaterna == null) {
			log.error(buildMessage(getClass(), methodName, "domanda materna non trovata"));
			throw ErrorCodeEnum.VAL_IST_002.buildException();
		}

		String statoDomanda = domandaMaterna.getStatoDomanda();
		if (StringUtils.isBlank(statoDomanda)) {
			log.error(buildMessage(getClass(), methodName, "stato domanda non valido"));
			throw ErrorCodeEnum.VAL_IST_002.buildException();
		}

		if (CollectionUtils.isEmpty(materne)) {
			return;
		}

		for (Materna materna : materne) {
			String codScuola = materna.getCodScuola();
			String codTipoFrequenza = materna.getCodTipoFrequenza();
			String codStatoScuola = materna.getCodStatoScuola();

			if (codStatoScuola != null && !StatoScuola.NON_AMM.getCod().equals(codStatoScuola) && !StatoScuola.PEN.getCod().equals(codStatoScuola)) {
				continue;
			}

			boolean ammissibile = !StatoScuola.NON_AMM.getCod().equals(codStatoScuola);
			StatoScuola statoScuola = null;

			if (ammissibile) {
				if (codStatoScuola == null) {
					statoScuola = null;
				}
				else if (StatoScuola.PEN.getCod().equals(codStatoScuola)) {
					statoScuola = StatoScuola.PEN;
				}
				else if (StatoScuola.NON_AMM.getCod().equals(codStatoScuola)) {
					statoScuola = StatoDomanda.INV.getCod().equals(statoDomanda) ? null : StatoScuola.PEN;
				}
				else {
					continue;
				}
			}
			else {
				statoScuola = StatoScuola.NON_AMM;
			}

			Long idDomanda = domandaMaterna.getIdDomandaIscrizione();
			this.istruttoriaDao.updateStatoScuola(idDomanda, codScuola, codTipoFrequenza, statoScuola);
		}

		log.debug(buildMessage(getClass(), methodName, LOG_END));
	}

	//////////////////////////////////////////////////////////////////////

	private void gestioneResNotoLav(Long idDomanda, String codCondizionePunteggio, String codiceFiscaleOperatore,
			DatiCondizionePunteggio datiCondizionePunteggio) throws DaoException {

		if (Boolean.FALSE.equals(datiCondizionePunteggio.getValidata())) {
			TipoCondizionePunteggio tc = TipoCondizionePunteggio.findByCod(codCondizionePunteggio);
			if (TipoCondizionePunteggio.RES_NOTO_LAV == tc) {
				DatiCondizionePunteggioRow row = new DatiCondizionePunteggioRow();

				row.setIdDomandaIscrizione(idDomanda);
				row.setCodCondizionePunteggio(TipoCondizionePunteggio.RES_NOTO.getCod());
				row.setCodiceFiscaleOperatore(codiceFiscaleOperatore);
				row.setFlValida(ConvertUtils.toSN(true));
				row.setNote(null);
				row.setRicorrenza(1);
				row.setFlIntegrazione(null);

				this.istruttoriaDao.modificaCondizionePunteggio(row);
			}
		}
	}

	private void gestioneResToAndResToFut(Long idDomanda, String codCondizionePunteggio, String codiceFiscaleOperatore,
			DatiCondizionePunteggio datiCondizionePunteggio) throws DaoException {

		if (Boolean.FALSE.equals(datiCondizionePunteggio.getValidata())) {
			TipoCondizionePunteggio tc = TipoCondizionePunteggio.findByCod(codCondizionePunteggio);
			if (TipoCondizionePunteggio.RES_TO == tc || TipoCondizionePunteggio.RES_TO_FUT == tc || TipoCondizionePunteggio.RES_TO_FUT_NOTE == tc) {
				boolean condizioneResNotoLav = this.istruttoriaDao.condizioneResNotoLav(idDomanda);

				String codCondizionePunteggioNew = condizioneResNotoLav
						? TipoCondizionePunteggio.RES_NOTO_LAV.getCod()
						: TipoCondizionePunteggio.RES_NOTO.getCod();

				DatiCondizionePunteggioRow row = new DatiCondizionePunteggioRow();

				row.setIdDomandaIscrizione(idDomanda);
				row.setCodCondizionePunteggio(codCondizionePunteggioNew);
				row.setCodiceFiscaleOperatore(codiceFiscaleOperatore);
				row.setFlValida(condizioneResNotoLav ? null : ConvertUtils.toSN(true));
				row.setNote(null);
				row.setRicorrenza(1);
				row.setFlIntegrazione(null);

				this.istruttoriaDao.modificaCondizionePunteggio(row);
			}
		}
	}

	private void gestionePaSoc(Long idDomanda, TipoScuola tipoScuola, String codCondizionePunteggio, String codiceFiscaleOperatore,
			DatiCondizionePunteggio datiCondizionePunteggio) throws DaoException, ValidationException {

		TipoCondizionePunteggio tc = TipoCondizionePunteggio.findByCod(codCondizionePunteggio);
		if (TipoCondizionePunteggio.PA_SOC == tc) {
			if (Boolean.TRUE.equals(datiCondizionePunteggio.getValidata())) {
				this.scuolaDao.updateFlagFuoriTermine(idDomanda, false);
			}
			else {
				this.ricalcolaFlagFuoriTermine(idDomanda, tipoScuola);
			}
		}
	}

	private void gestioneFlIstruita(Long idDomanda) throws DaoException {
		final String methodName = "gestioneFlIstruita";

		int condizioniNonIstruite = this.istruttoriaDao.countCondizioniNonIstruite(idDomanda);
		log.info(buildMessage(getClass(), methodName, String.format(
				"trovate %d condizioni non istruite", condizioniNonIstruite)));

		this.istruttoriaDao.updateFlIstruita(idDomanda, condizioniNonIstruite == 0);
	}

	//////////////////////////////////////////////////////////////////////

	private void checkRicorrenza(Long idDomanda, String codCondizionePunteggio, DatiCondizionePunteggio datiCondizionePunteggio)
			throws DaoException, ValidationException {

		int ricorrenza = datiCondizionePunteggio.getRicorrenza();
		int maxRicorrenza = this.getMaxRicorrenza(idDomanda, codCondizionePunteggio);

		if (ricorrenza > maxRicorrenza) {
			throw ErrorCodeEnum.VAL_IST_003.buildException();
		}
	}

	private void checkTipoValidazione(DatiCondizionePunteggio datiCondizionePunteggio) throws ValidationException {
		TipoValidazione tipoValidazione = TipoValidazione.findByCod(datiCondizionePunteggio.getTipoValidazione());
		if (tipoValidazione != null) {
			Boolean validata = datiCondizionePunteggio.getValidata();

			TipoCondizionePunteggio tc;
			switch (tipoValidazione) {
				case ACC_PUN_PRIO:
				case ACC_PUN:
					if (!Boolean.TRUE.equals(validata)) {
						throw ErrorCodeEnum.VAL_IST_004.buildException();
					}
					break;
				case ACC_RED_CON:
					if (!Boolean.TRUE.equals(validata)) {
						throw ErrorCodeEnum.VAL_IST_004.buildException();
					}

					tc = TipoCondizionePunteggio.findByCod(datiCondizionePunteggio.getCodCondizionePunteggio());
					if (tc == null || tc != TipoCondizionePunteggio.PA_PRB_SAL_MIN) {
						throw ErrorCodeEnum.VAL_IST_005.buildException();
					}
					break;
				case RIF_RED_CON:
					if (!Boolean.FALSE.equals(validata)) {
						throw ErrorCodeEnum.VAL_IST_004.buildException();
					}

					tc = TipoCondizionePunteggio.findByCod(datiCondizionePunteggio.getCodCondizionePunteggio());
					if (tc == null || (tc != TipoCondizionePunteggio.PA_DIS && tc != TipoCondizionePunteggio.PA_PRB_SAL_MIN)) {
						throw ErrorCodeEnum.VAL_IST_005.buildException();
					}
					break;
				case RIF_RIC_INTEGR:
				case RIF_SOCIO_SAN:
					if (!Boolean.FALSE.equals(validata)) {
						throw ErrorCodeEnum.VAL_IST_004.buildException();
					}
					break;
				default:
					break;
			}
		}
	}

	//////////////////////////////////////////////////////////////////////

	private static DatiCondizionePunteggioRow buildDatiCondizionePunteggioRow(
			Long idDomanda, String codCondizionePunteggio, String codiceFiscaleOperatore, DatiCondizionePunteggio datiCondizionePunteggio) {

		DatiCondizionePunteggioRow row = new DatiCondizionePunteggioRow();

		row.setIdDomandaIscrizione(idDomanda);
		row.setCodCondizionePunteggio(codCondizionePunteggio);
		row.setCodiceFiscaleOperatore(codiceFiscaleOperatore);
		row.setFlValida(ConvertUtils.toSN(datiCondizionePunteggio.getValidata()));
		row.setNote(datiCondizionePunteggio.getNote());
		row.setRicorrenza(datiCondizionePunteggio.getRicorrenza());
		row.setFlIntegrazione(null);

		return row;
	}

	private static DatiCondizionePunteggioRow getLastRow(List<DatiCondizionePunteggioRow> rows) {
		if (CollectionUtils.isEmpty(rows)) {
			return null;
		}

		for (DatiCondizionePunteggioRow row : rows) {
			if (row.getDtFineValidita() == null) {
				return row;
			}
		}

		return null;
	}

	private int getMaxRicorrenza(Long idDomanda, String codCondizionePunteggio) throws DaoException {
		List<DatiCondizionePunteggio> rows = new DatiCondizionePunteggioConverter()
				.convertAll(this.istruttoriaDao.findStoricoCondizioniPunteggio(idDomanda, codCondizionePunteggio));

		int result = 0;
		for (DatiCondizionePunteggio row : rows) {
			Integer ricorrenza = row.getRicorrenza();
			if (ricorrenza != null) {
				result = Math.max(result, ricorrenza);
			}
		}

		return result;
	}

	private void insertAllegatiRed(Long idDomanda, String codCondFrom, String codCondTo) throws DaoException, ValidationException {
		List<InfoAllegatoSoggettoRow> rows = this.istruttoriaDao.findAllegatiDomanda(idDomanda, codCondFrom, false);
		if (CollectionUtils.isEmpty(rows)) {
			return;
		}

		for (InfoAllegatoSoggettoRow row : rows) {
			this.istruttoriaDao.insertAllegatoRed(row.getIdAllegato(), codCondTo);
		}
	}

	private void ricalcolaFlagFuoriTermine(Long idDomanda, TipoScuola tipoScuola) throws DaoException, ValidationException {
		final String methodName = "ricalcolaFlagFuoriTermine";

		Long idAnagraficaGra = this.getUltimaGraduatoria(tipoScuola).getIdAnagraficaGra();
		boolean fuoriTermine = this.istruttoriaDao.fuoriTermine(idDomanda, idAnagraficaGra);

		log.info(buildMessage(getClass(), methodName, "idAnagraficaGra: " + idAnagraficaGra));
		log.info(buildMessage(getClass(), methodName, "tipoScuola: " + tipoScuola));
		log.info(buildMessage(getClass(), methodName, "fuoriTermine: " + fuoriTermine));

		this.scuolaDao.updateFlagFuoriTermine(idDomanda, fuoriTermine);
	}

	private IscrittoTAnagraficaGra getUltimaGraduatoria(TipoScuola tipoScuola) throws DaoException, ValidationException {
		final String methodName = "getUltimaGraduatoria";
		log.info(buildMessage(getClass(), methodName, "tipoScuola: " + tipoScuola));

		List<IscrittoTAnagraficaGra> graduatoriaList = this.graduatoriaDao.findUltimaGraduatoria(tipoScuola);
		int numGraduatorie = CollectionUtils.size(graduatoriaList);

		if (numGraduatorie != 1) {
			log.error(buildMessage(getClass(), methodName, String.format(
					"trovate %d graduatorie, il valore deve essere 1", numGraduatorie)));

			throw ErrorCodeEnum.VAL_GRA_001.buildException();
		}

		return ConvertUtils.getFirst(graduatoriaList);
	}

	/**
	 * JIRA ISBO-280 CHG-138
	 *
	 * @param idDomanda
	 * @param tipoScuola
	 * @param codCondizionePunteggio
	 * @param codiceFiscaleOperatore
	 * @param datiCondizionePunteggio
	 */
	private void gestioneResToAndSonUnder11OrBetween11And17(Long idDomanda, TipoScuola tipoScuola,
			String codCondizionePunteggio, String codiceFiscaleOperatore,
			DatiCondizionePunteggio datiCondizionePunteggio) throws DaoException, ValidationException {

		if (Boolean.FALSE.equals(datiCondizionePunteggio.getValidata())) {
			TipoCondizionePunteggio tc = TipoCondizionePunteggio.findByCod(codCondizionePunteggio);
			if (TipoCondizionePunteggio.RES_TO == tc) {

				// check presenza condizione CF_INF_11 sulla domanda
				if (this.istruttoriaDao.hasDomandaCondizionePunteggio(idDomanda, TipoCondizionePunteggio.CF_INF_11.getCod())) {

					DatiCondizionePunteggioRow row = new DatiCondizionePunteggioRow();

					row.setIdDomandaIscrizione(idDomanda);
					row.setCodCondizionePunteggio(TipoCondizionePunteggio.CF_INF_11.getCod());
					row.setCodiceFiscaleOperatore(codiceFiscaleOperatore);
					row.setFlValida(ConvertUtils.toSN(true));
					row.setNote(null);
					row.setRicorrenza(1);
					row.setFlIntegrazione(null);

					this.istruttoriaDao.modificaCondizionePunteggio(row);
				}

				// check presenza condizione CF_TRA_11_17 sulla domanda
				if (this.istruttoriaDao.hasDomandaCondizionePunteggio(idDomanda, TipoCondizionePunteggio.CF_TRA_11_17.getCod())) {

					DatiCondizionePunteggioRow row = new DatiCondizionePunteggioRow();

					row.setIdDomandaIscrizione(idDomanda);
					row.setCodCondizionePunteggio(TipoCondizionePunteggio.CF_TRA_11_17.getCod());
					row.setCodiceFiscaleOperatore(codiceFiscaleOperatore);
					row.setFlValida(ConvertUtils.toSN(true));
					row.setNote(null);
					row.setRicorrenza(1);
					row.setFlIntegrazione(null);

					this.istruttoriaDao.modificaCondizionePunteggio(row);
				}
			}
		}

	}

	/**
	 * ISBO-287, 346 CHG 141
	 *
	 * @param idDomanda
	 * @param tipoScuola
	 * @param codCondizionePunteggio
	 * @param codiceFiscaleOperatore
	 * @param datiCondizionePunteggio
	 * @throws DaoException
	 * @throws ValidationException
	 */
	private void gestioneGraviProblemiDiSaluteMinore(Long idDomanda, TipoScuola tipoScuola, String codCondizionePunteggio,
			String codiceFiscaleOperatore, DatiCondizionePunteggio datiCondizionePunteggio) throws DaoException, ValidationException {

		if (Boolean.TRUE.equals(datiCondizionePunteggio.getValidata()) &&
				TipoCondizionePunteggio.findByCod(codCondizionePunteggio) == TipoCondizionePunteggio.PA_PRB_SAL_MIN) {

			// check presenza condizione PA_PRB_SAL_ALT sulla domanda
			if (this.istruttoriaDao.hasDomandaCondizioneIstruita(idDomanda, TipoCondizionePunteggio.PA_PRB_SAL_ALT.getCod())) {
				DatiCondizionePunteggioRow row = new DatiCondizionePunteggioRow();

				row.setIdDomandaIscrizione(idDomanda);
				row.setCodCondizionePunteggio(TipoCondizionePunteggio.PA_PRB_SAL_ALT.getCod());
				row.setCodiceFiscaleOperatore(codiceFiscaleOperatore);
				row.setFlValida(ConvertUtils.toSN(false));
				row.setNote(
						"Gia' presa in considerazione la condizione di punteggio relativa ai problemi di salute del/la bambino/a; i due punteggi non sono cumulabili");
				row.setRicorrenza(1);
				row.setFlIntegrazione(null);

				this.istruttoriaDao.modificaCondizionePunteggio(row);
			}
		}

		if (Boolean.TRUE.equals(datiCondizionePunteggio.getValidata()) &&
				TipoCondizionePunteggio.findByCod(codCondizionePunteggio) == TipoCondizionePunteggio.PA_PRB_SAL_ALT) {

			if (this.istruttoriaDao.hasDomandaCondizioneValida(idDomanda, TipoCondizionePunteggio.PA_PRB_SAL_MIN.getCod())) {
				throw ErrorCodeEnum.VAL_IST_006.buildException();
			}
		}
	}

}
