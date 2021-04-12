package it.csi.iscritto.serviscritto.business.domanda.service;

import static it.csi.iscritto.serviscritto.business.util.DomandaUtils.checkSoggetto;
import static it.csi.iscritto.serviscritto.business.util.DomandaUtils.getAllegatiDomanda;
import static it.csi.iscritto.serviscritto.business.util.DomandaUtils.getCondizioneOccupazionale;
import static it.csi.iscritto.serviscritto.business.util.DomandaUtils.isRicSog1;
import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.LOG_BEGIN;
import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.LOG_END;
import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.LOG_ERROR;
import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.buildMessage;
import static it.csi.iscritto.serviscritto.business.util.converter.ConvertUtils.toList;
import static it.csi.iscritto.serviscritto.business.util.converter.ConvertUtils.toSN;
import static it.csi.iscritto.serviscritto.business.util.converter.ConvertUtils.toSNN;

import java.util.Date;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;

import it.csi.iscritto.serviscritto.business.integration.dao.StatoDomanda;
import it.csi.iscritto.serviscritto.business.integration.dao.TipoCondizioneOccupazionale;
import it.csi.iscritto.serviscritto.business.integration.dao.TipoScuola;
import it.csi.iscritto.serviscritto.business.integration.dao.TipoSoggetto;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoDCoabitazione;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoDOrdineScuola;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoDStatoDom;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoDTipoFre;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoRScuolaPre;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTAnagraficaSog;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTAnnoSco;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTCambioRes;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTCondizioneSan;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTDisoccupatoEx;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTDomandaIsc;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTFratelloFre;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTGenitoreSolo;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTIndirizzoRes;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTLogErroreDomanda;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTScuola;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTServiziSoc;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTTrasferimento;
import it.csi.iscritto.serviscritto.business.integration.exception.DaoException;
import it.csi.iscritto.serviscritto.business.integration.exception.ServiceException;
import it.csi.iscritto.serviscritto.business.util.Constants;
import it.csi.iscritto.serviscritto.dto.domanda.Affido;
import it.csi.iscritto.serviscritto.dto.domanda.AltriComponenti;
import it.csi.iscritto.serviscritto.dto.domanda.Anagrafica;
import it.csi.iscritto.serviscritto.dto.domanda.CondizioneOccupazionale;
import it.csi.iscritto.serviscritto.dto.domanda.Disabilita;
import it.csi.iscritto.serviscritto.dto.domanda.DomandaNido;
import it.csi.iscritto.serviscritto.dto.domanda.Gravidanza;
import it.csi.iscritto.serviscritto.dto.domanda.Isee;
import it.csi.iscritto.serviscritto.dto.domanda.LuogoNascita;
import it.csi.iscritto.serviscritto.dto.domanda.Minore;
import it.csi.iscritto.serviscritto.dto.domanda.Nido;
import it.csi.iscritto.serviscritto.dto.domanda.ProblemiSalute;
import it.csi.iscritto.serviscritto.dto.domanda.Residenza;
import it.csi.iscritto.serviscritto.dto.domanda.Richiedente;
import it.csi.iscritto.serviscritto.dto.domanda.Soggetto1;
import it.csi.iscritto.serviscritto.dto.domanda.Soggetto2;
import it.csi.iscritto.serviscritto.dto.domanda.Soggetto3;

public class DomandaNidoUpdateService extends AbstractDomandaUpdateService {
	private static final Logger log = Logger.getLogger(Constants.COMPONENT_NAME + ".business");

	public Long insert(DomandaNido domandaNido) throws ServiceException {
		final String methodName = "insert";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		Long result;
		try {
			Validate.notNull(domandaNido);
			Validate.notBlank(domandaNido.getStatoDomanda());

			Long oldId = domandaNido.getIdDomandaIscrizione();
			log.info(buildMessage(getClass(), methodName, "oldId: " + oldId));

			Long newId = this.insertDomanda(TipoScuola.NID, domandaNido);
			this.updateFlagNao(newId);
			log.info(buildMessage(getClass(), methodName, "newId: " + newId));

			if (oldId != null) {
				this.updateAllegati(oldId, newId, getAllegatiDomanda(domandaNido));
				log.info(buildMessage(getClass(), methodName, "aggiornati allegati"));

				this.deleteBozza(oldId);
				log.info(buildMessage(getClass(), methodName, "rimossa domanda con id: " + oldId));
			}

			result = newId;
		}
		catch (Exception e) {
			log.error(buildMessage(getClass(), methodName, LOG_ERROR), e);
			throw new ServiceException(e);
		}

		log.info(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	public String inviaDomandaNido(Long idDomandaIscrizione) throws ServiceException {
		final String methodName = "inviaDomandaNido";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		String result;
		try {
			Validate.notNull(idDomandaIscrizione);

			result = this.inviaDomanda(TipoScuola.NID, idDomandaIscrizione);
			log.info(buildMessage(getClass(), methodName, "protocollata domanda con id: " + idDomandaIscrizione));

			this.protocollaAllegatiDomanda(idDomandaIscrizione);
			log.info(buildMessage(getClass(), methodName, "protocollati allegati della domanda con id: " + idDomandaIscrizione));
		}
		catch (Exception e) {
			log.error(buildMessage(getClass(), methodName, LOG_ERROR), e);
			throw new ServiceException(e);
		}

		log.info(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	public void protocollaAllegatiNido(Long idDomandaIscrizione) throws DaoException, ServiceException {
		final String methodName = "protocollaAllegatiNido";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		try {
			Validate.notNull(idDomandaIscrizione);

			this.protocollaAllegatiDomanda(idDomandaIscrizione);
			log.info(buildMessage(getClass(), methodName, "protocollati allegati della domanda con id: " + idDomandaIscrizione));
		}
		catch (Exception e) {
			log.error(buildMessage(getClass(), methodName, LOG_ERROR), e);
			throw new ServiceException(e);
		}

		log.info(buildMessage(getClass(), methodName, LOG_END));
	}

	//////////////////////////////////////////////////////////////////////
	// Log errori
	//////////////////////////////////////////////////////////////////////
	public void logError(String codiceFiscaleOperatore, String dettaglioErrore, DomandaNido domandaNido)
			throws DaoException {

		final String methodName = "logError";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		try {
			String jsonDomanda = domandaNido == null
					? null
					: new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(domandaNido);

			IscrittoTLogErroreDomanda row = this.buildIscrittoTLogErroreDomanda(
					codiceFiscaleOperatore, dettaglioErrore, jsonDomanda);

			this.errorLogDao.logError(row);
		}
		catch (Exception e) {
			log.error(buildMessage(getClass(), methodName, LOG_ERROR), e);
		}

		log.info(buildMessage(getClass(), methodName, LOG_END));
	}

	//////////////////////////////////////////////////////////////////////
	// Salvataggio domanda
	//////////////////////////////////////////////////////////////////////
	private Long insertDomanda(TipoScuola tipoScuola, DomandaNido domandaNido) throws DaoException, ServiceException {
		final String methodName = "insertDomanda";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		if (!StatoDomanda.BOZ.getCod().equals(domandaNido.getStatoDomanda())) {
			throw new ServiceException("stato domanda non valido");
		}

		IscrittoTDomandaIsc row = this.buildIscrittoTDomandaIsc(tipoScuola, domandaNido);
		Long idDomandaIscrizione = this.domandaIscDao.insertIscrittoTDomandaIsc(row);

		if (isRicSog1(domandaNido)) {
			this.insertSoggettoRicSog1(domandaNido, idDomandaIscrizione);
		}
		else {
			this.insertSoggetto(domandaNido, idDomandaIscrizione, TipoSoggetto.RIC);
			this.insertSoggetto(domandaNido, idDomandaIscrizione, TipoSoggetto.SOG1);
		}

		this.insertSoggetto(domandaNido, idDomandaIscrizione, TipoSoggetto.MIN);
		this.insertSoggetto(domandaNido, idDomandaIscrizione, TipoSoggetto.SOG2);
		this.insertSoggetto(domandaNido, idDomandaIscrizione, TipoSoggetto.SOG3);

		this.insertComponentiNucleo(domandaNido.getComponentiNucleo(), idDomandaIscrizione);
		this.insertAltriComponenti(domandaNido.getAltriComponenti(), idDomandaIscrizione);
		this.insertAffido(domandaNido.getAffido(), idDomandaIscrizione);
		this.insertIsee(domandaNido.getIsee(), idDomandaIscrizione);
		this.insertElencoNidi(domandaNido, idDomandaIscrizione);

		log.info(buildMessage(getClass(), methodName, LOG_END));
		return idDomandaIscrizione;
	}

	private void insertSoggetto(DomandaNido domandaNido, Long idDomandaIscrizione, TipoSoggetto tipoSoggetto)
			throws DaoException, ServiceException {

		final String methodName = "insertSoggetto";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		switch (tipoSoggetto) {
			case SOG2:
			case SOG3:
				if (!checkSoggetto(domandaNido, tipoSoggetto)) {
					return;
				}
				break;
			default:
				break;
		}

		IscrittoTAnagraficaSog row = this.buildIscrittoTAnagraficaSog(domandaNido, idDomandaIscrizione, tipoSoggetto);
		Long idAnagraficaSoggetto = this.anagraficaSogDao.insertIscrittoTAnagraficaSog(row);

		this.insertSoggettoRel(idAnagraficaSoggetto, tipoSoggetto);
		this.insertResidenza(domandaNido, idAnagraficaSoggetto, tipoSoggetto);
		this.insertCondizioneSanitaria(domandaNido, idAnagraficaSoggetto, tipoSoggetto);
		this.insertServiziSociali(domandaNido, idDomandaIscrizione, tipoSoggetto);
		this.insertCondizioneOccupazionale(domandaNido, idAnagraficaSoggetto, tipoSoggetto);
		this.insertGenitoreSolo(domandaNido, idDomandaIscrizione, tipoSoggetto);
		this.insertFratelloFrequentante(domandaNido, idDomandaIscrizione, tipoSoggetto);
		this.insertTrasferimento(domandaNido, idDomandaIscrizione, tipoSoggetto);
		this.insertSpostamento(domandaNido, idDomandaIscrizione, tipoSoggetto);

		log.info(buildMessage(getClass(), methodName, LOG_END));
	}

	private void insertSoggettoRicSog1(DomandaNido domandaNido, Long idDomandaIscrizione)
			throws DaoException, ServiceException {

		final String methodName = "insertSoggettoRicSog1";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		IscrittoTAnagraficaSog row = this.buildIscrittoTAnagraficaSog(domandaNido, idDomandaIscrizione, TipoSoggetto.SOG1);
		Long idAnagraficaSoggetto = this.anagraficaSogDao.insertIscrittoTAnagraficaSog(row);

		this.insertSoggettoRel(idAnagraficaSoggetto, TipoSoggetto.RIC);
		this.insertSoggettoRel(idAnagraficaSoggetto, TipoSoggetto.SOG1);

		this.insertResidenza(domandaNido, idAnagraficaSoggetto, TipoSoggetto.SOG1);
		this.insertCondizioneSanitaria(domandaNido, idAnagraficaSoggetto, TipoSoggetto.SOG1);
		this.insertServiziSociali(domandaNido, idDomandaIscrizione, TipoSoggetto.SOG1);
		this.insertCondizioneOccupazionale(domandaNido, idAnagraficaSoggetto, TipoSoggetto.SOG1);
		this.insertGenitoreSolo(domandaNido, idDomandaIscrizione, TipoSoggetto.SOG1);
		this.insertFratelloFrequentante(domandaNido, idDomandaIscrizione, TipoSoggetto.SOG1);
		this.insertTrasferimento(domandaNido, idDomandaIscrizione, TipoSoggetto.SOG1);
		this.insertSpostamento(domandaNido, idDomandaIscrizione, TipoSoggetto.SOG1);

		log.info(buildMessage(getClass(), methodName, LOG_END));
	}

	private void insertResidenza(DomandaNido domandaNido, Long idAnagraficaSoggetto, TipoSoggetto tipoSoggetto)
			throws DaoException, ServiceException {

		final String methodName = "insertResidenza";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		switch (tipoSoggetto) {
			case RIC:
			case MIN:
			case SOG1:
			case SOG2:
			case SOG3:
				if (!checkSoggetto(domandaNido, tipoSoggetto)) {
					return;
				}
				IscrittoTIndirizzoRes row = this.buildIscrittoTIndirizzoRes(domandaNido, idAnagraficaSoggetto, tipoSoggetto);
				if (row != null) {
					this.indirizzoResDao.insertIscrittoTIndirizzoRes(row);
				}
				break;
			default:
				break;
		}

		log.info(buildMessage(getClass(), methodName, LOG_END));
	}

	private void insertCondizioneSanitaria(DomandaNido domandaNido, Long idAnagraficaSoggetto, TipoSoggetto tipoSoggetto)
			throws DaoException, ServiceException {

		final String methodName = "insertCondizioneSanitaria";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		switch (tipoSoggetto) {
			case MIN:
			case SOG1:
			case SOG2:
				if (!checkSoggetto(domandaNido, tipoSoggetto)) {
					return;
				}
				IscrittoTCondizioneSan row = this.buildIscrittoTCondizioneSan(domandaNido, idAnagraficaSoggetto, tipoSoggetto);
				if (row != null) {
					this.condizioneSanDao.insertIscrittoTCondizioneSan(row);
				}
				break;
			default:
				break;
		}

		log.info(buildMessage(getClass(), methodName, LOG_END));
	}

	private void insertServiziSociali(DomandaNido domandaNido, Long idDomandaIscrizione, TipoSoggetto tipoSoggetto)
			throws DaoException, ServiceException {

		final String methodName = "insertServiziSociali";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		switch (tipoSoggetto) {
			case MIN:
				if (!checkSoggetto(domandaNido, tipoSoggetto)) {
					return;
				}
				IscrittoTServiziSoc row = this.buildIscrittoTServiziSoc(domandaNido.getMinore(), idDomandaIscrizione, tipoSoggetto);
				if (row != null) {
					this.serviziSocDao.insertIscrittoTServiziSoc(row);
				}
				break;
			default:
				break;
		}

		log.info(buildMessage(getClass(), methodName, LOG_END));
	}

	private void insertCondizioneOccupazionale(DomandaNido domandaNido, Long idAnagraficaSoggetto, TipoSoggetto tipoSoggetto)
			throws DaoException, ServiceException {

		final String methodName = "insertCondizioneOccupazionale";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		switch (tipoSoggetto) {
			case SOG1:
			case SOG2:
				if (!checkSoggetto(domandaNido, tipoSoggetto)) {
					return;
				}

				CondizioneOccupazionale condizioneOccupazionale = getCondizioneOccupazionale(domandaNido, tipoSoggetto);
				if (condizioneOccupazionale == null || StringUtils.isBlank(condizioneOccupazionale.getStato())) {
					return;
				}

				Long idCondizioneOccupazionale = this.condizioneOccDao.insertIscrittoTCondizioneOcc(
						this.buildIscrittoTCondizioneOcc(
								getCondizioneOccupazionale(domandaNido, tipoSoggetto),
								idAnagraficaSoggetto));

				TipoCondizioneOccupazionale tipoCondizioneOccupazionale = TipoCondizioneOccupazionale.findByCod(condizioneOccupazionale.getStato());
				switch (tipoCondizioneOccupazionale) {
					case DIP:
						this.dipendenteDao.insertIscrittoTDipendente(
								this.buildIscrittoTDipendente(
										getCondizioneOccupazionale(domandaNido, tipoSoggetto),
										idCondizioneOccupazionale));
						break;
					case AUT:
						this.autonomoDao.insertIscrittoTAutonomo(
								this.buildIscrittoTAutonomo(
										getCondizioneOccupazionale(domandaNido, tipoSoggetto),
										idCondizioneOccupazionale));
						break;
					case DIS:
						this.disoccupatoDao.insertIscrittoTDisoccupato(
								this.buildIscrittoTDisoccupato(
										getCondizioneOccupazionale(domandaNido, tipoSoggetto),
										idCondizioneOccupazionale));
						break;
					case DIS_LAV:
						List<IscrittoTDisoccupatoEx> nonOccupatoList = this.buildIscrittoTDisoccupatoEx(
								getCondizioneOccupazionale(domandaNido, tipoSoggetto),
								idCondizioneOccupazionale);

						for (IscrittoTDisoccupatoEx nonOccupato : nonOccupatoList) {
							this.disoccupatoExDao.insertIscrittoTDisoccupatoEx(nonOccupato);
						}
						break;
					case STU:
						this.studenteDao.insertIscrittoTStudente(
								this.buildIscrittoTStudente(
										getCondizioneOccupazionale(domandaNido, tipoSoggetto),
										idCondizioneOccupazionale));
						break;
					case NO_COND:
						// nessuna condizione
						break;
					default:
						final String message = "tipo condizione occupazionale non valida";
						log.error(buildMessage(getClass(), methodName, message));
						throw new ServiceException(message);
				}
				break;
			default:
				break;
		}

		log.info(buildMessage(getClass(), methodName, LOG_END));
	}

	private void insertGenitoreSolo(DomandaNido domandaNido, Long idDomandaIscrizione, TipoSoggetto tipoSoggetto)
			throws DaoException, ServiceException {

		final String methodName = "insertGenitoreSolo";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		switch (tipoSoggetto) {
			case SOG1:
				if (!checkSoggetto(domandaNido, tipoSoggetto)) {
					return;
				}
				IscrittoTGenitoreSolo row = this.buildIscrittoTGenitoreSolo(domandaNido.getSoggetto1(), idDomandaIscrizione, tipoSoggetto);
				if (row != null) {
					this.genitoreSoloDao.insertIscrittoTGenitoreSolo(row);
				}
				break;
			default:
				break;
		}

		log.info(buildMessage(getClass(), methodName, LOG_END));
	}

	private void insertFratelloFrequentante(DomandaNido domandaNido, Long idDomandaIscrizione, TipoSoggetto tipoSoggetto)
			throws DaoException, ServiceException {

		final String methodName = "insertFratelloFrequentante";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		switch (tipoSoggetto) {
			case MIN:
				if (!checkSoggetto(domandaNido, tipoSoggetto)) {
					return;
				}
				IscrittoTFratelloFre row = this.buildIscrittoTFratelloFre(domandaNido.getMinore(), idDomandaIscrizione, tipoSoggetto);
				if (row != null) {
					this.fratelloFreDao.insertIscrittoTFratelloFre(row);
				}
				break;
			default:
				break;
		}

		log.info(buildMessage(getClass(), methodName, LOG_END));
	}

	private void insertTrasferimento(DomandaNido domandaNido, Long idDomandaIscrizione, TipoSoggetto tipoSoggetto)
			throws DaoException, ServiceException {

		final String methodName = "insertTrasferimento";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		switch (tipoSoggetto) {
			case MIN:
				if (!checkSoggetto(domandaNido, tipoSoggetto)) {
					return;
				}
				IscrittoTTrasferimento row = this.buildIscrittoTTrasferimento(domandaNido.getMinore(), idDomandaIscrizione, tipoSoggetto);
				if (row != null) {
					this.trasferimentoDao.insertIscrittoTTrasferimento(row);
				}
				break;
			default:
				break;
		}

		log.info(buildMessage(getClass(), methodName, LOG_END));
	}

	private void insertSpostamento(DomandaNido domandaNido, Long idDomandaIscrizione, TipoSoggetto tipoSoggetto)
			throws DaoException, ServiceException {

		final String methodName = "insertSpostamento";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		switch (tipoSoggetto) {
			case MIN:
				if (!checkSoggetto(domandaNido, tipoSoggetto)) {
					return;
				}
				IscrittoTCambioRes row = this.buildIscrittoTCambioRes(domandaNido.getMinore(), idDomandaIscrizione, tipoSoggetto);
				if (row != null) {
					this.cambioResDao.insertIscrittoTCambioRes(row);
				}
				break;
			default:
				break;
		}

		log.info(buildMessage(getClass(), methodName, LOG_END));
	}

	private void insertElencoNidi(DomandaNido domandaNido, Long idDomandaIscrizione) throws DaoException, ServiceException {
		final String methodName = "insertElencoNidi";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		List<Nido> elencoNidi = toList(domandaNido.getElencoNidi());
		if (CollectionUtils.isEmpty(elencoNidi)) {
			return;
		}

		int posizione = 1;

		for (Nido nido : elencoNidi) {
			nido.setId(posizione++);

			IscrittoRScuolaPre row = this.buildIscrittoRScuolaPre(idDomandaIscrizione, nido);
			if (row != null) {
				this.scuolaDao.insertIscrittoRScuolaPre(row);
			}
		}

		log.info(buildMessage(getClass(), methodName, LOG_END));
	}

	//////////////////////////////////////////////////////////////////////
	// Costruzione DTO
	//////////////////////////////////////////////////////////////////////
	private IscrittoTDomandaIsc buildIscrittoTDomandaIsc(TipoScuola tipoScuola, DomandaNido domandaNido)
			throws DaoException, ServiceException {

		final String methodName = "buildIscrittoTDomandaIsc";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		IscrittoTAnnoSco annoSco = this.annoScoDao.findIscrittoTAnnoScoByDate(tipoScuola, new Date());
		IscrittoDCoabitazione decCoabitazione = this.decodificaDao.findIscrittoDCoabitazioneByCod(domandaNido.getRichiedente().getCondizioneCoabitazione());
		IscrittoDOrdineScuola decOrdineScuola = this.decodificaDao.findIscrittoDOrdineScuolaByCod(domandaNido.getOrdineScuola());
		IscrittoDStatoDom decStatoDom = this.decodificaDao.findIscrittoDStatoDomByCod(domandaNido.getStatoDomanda());

		Richiedente richiedente = domandaNido.getRichiedente();
		Minore minore = domandaNido.getMinore();
		Affido affido = domandaNido.getAffido();
		AltriComponenti altriComponenti = domandaNido.getAltriComponenti();
		Soggetto2 soggetto2 = domandaNido.getSoggetto2();
		Soggetto3 soggetto3 = domandaNido.getSoggetto3();
		Isee isee = domandaNido.getIsee();
		Long idUtenteIns = this.getIdUtenteByCF(domandaNido.getCodiceFiscaleUtenteIns());
		Long idUtenteMod = this.getIdUtenteByCF(domandaNido.getCodiceFiscaleUtenteMod());

		IscrittoTDomandaIsc row = new IscrittoTDomandaIsc();

		row.setIdDomandaIscrizione(null); // valore sequence in inserimento
		row.setDataConsegna(new Date());
		row.setDtCancellazione(null);
		row.setDtModifica(new Date());
		row.setEmail(richiedente.getEmail());
		row.setFlAffido(toSN(affido == null ? null : affido.getStato()));
		row.setFlAltriComponenti(toSN(altriComponenti == null ? null : altriComponenti.getStato()));
		row.setFlContestazione(toSN(false));
		row.setFlFratelloFreq(this.getFlagFratelloFreq(minore));
		row.setFlGenitoreDuePreNuc(toSN(soggetto2 == null ? null : soggetto2.getPresenzaNucleo()));
		row.setFlInfoAutocertificazione(toSN(domandaNido.getInfoAutocertificazione()));
		row.setFlInfoGdpr(toSN(domandaNido.getInfoGdpr()));
		row.setFlIsee(toSN(isee == null ? null : isee.getStato()));
		row.setFlIstruita(toSN(false));
		row.setFlMinorePreNuc(toSN(minore.getPresenzaNucleo() == null ? null : minore.getPresenzaNucleo()));
		row.setFlResConRic(toSN(minore.getResidenzaConRichiedente() == null ? null : minore.getResidenzaConRichiedente()));
		row.setFlResidenzaForzata(toSN(minore.getSpostamento() == null ? null : minore.getSpostamento().getStato()));
		row.setFlResponsabilitaGen(toSN(domandaNido.getResponsabilitaGenitoriale()));
		row.setFlServiziSociali(toSN(minore.getServiziSociali() == null ? null : minore.getServiziSociali().getStato()));
		row.setFlSoggettoTre(toSN(soggetto3 == null ? null : soggetto3.getStato()));
		row.setFlTrasferimento(toSN(minore.getTrasferimento() == null ? null : minore.getTrasferimento().getStato()));
		row.setIdAnnoScolastico(annoSco.getIdAnnoScolastico());
		row.setIdCoabitazione(decCoabitazione.getIdCoabitazione());
		row.setIdOrdineScuola(decOrdineScuola.getIdOrdineScuola());
		row.setIdStatoDom(decStatoDom.getIdStatoDom());
		row.setIdUtenteIns(idUtenteIns);
		row.setIdUtenteMod(idUtenteMod);
		row.setNote(null);
		row.setProtocollo(null);
		row.setRecapitoNoRes(richiedente.getRecapitoNoResidenza());
		row.setTelefono(richiedente.getTelefono());
		row.setFlNao(toSN(domandaNido.getNao()));
		row.setFlConsensoTdConv(toSNN(domandaNido.getConsensoConvenzionata()));

		log.info(buildMessage(getClass(), methodName, LOG_END));
		return row;
	}

	private IscrittoTAnagraficaSog buildIscrittoTAnagraficaSog(DomandaNido domandaNido, Long idDomandaIscrizione, TipoSoggetto tipoSoggetto)
			throws DaoException, ServiceException {

		final String methodName = "buildIscrittoTAnagraficaSog";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		Anagrafica anagrafica;
		LuogoNascita luogoNascita;
		Long idRelParentela = null;

		switch (tipoSoggetto) {
			case RIC:
				Richiedente richiedente = domandaNido.getRichiedente();
				anagrafica = richiedente.getAnagrafica();
				luogoNascita = richiedente.getLuogoNascita();
				idRelParentela = this.getIdParentela(richiedente.getRelazioneConMinore());
				break;
			case MIN:
				Minore minore = domandaNido.getMinore();
				anagrafica = minore.getAnagrafica();
				luogoNascita = minore.getLuogoNascita();
				idRelParentela = null;
				break;
			case SOG1:
				Soggetto1 soggetto1 = domandaNido.getSoggetto1();
				anagrafica = soggetto1.getAnagrafica();
				luogoNascita = soggetto1.getLuogoNascita();
				if (isRicSog1(domandaNido)) {
					idRelParentela = this.getIdParentela(domandaNido.getRichiedente().getRelazioneConMinore());
				}
				break;
			case SOG2:
				Soggetto2 soggetto2 = domandaNido.getSoggetto2();
				anagrafica = soggetto2.getAnagrafica();
				luogoNascita = soggetto2.getLuogoNascita();
				break;
			case SOG3:
				Soggetto3 soggetto3 = domandaNido.getSoggetto3();
				anagrafica = soggetto3.getDati().getAnagrafica();
				luogoNascita = soggetto3.getDati().getLuogoNascita();
				break;
			default:
				throw new ServiceException();
		}

		IscrittoTAnagraficaSog row = buildIscrittoTAnagraficaSog(idDomandaIscrizione, anagrafica, luogoNascita, idRelParentela, tipoSoggetto);

		log.info(buildMessage(getClass(), methodName, LOG_END));
		return row;
	}

	private IscrittoTIndirizzoRes buildIscrittoTIndirizzoRes(DomandaNido domandaNido, Long idAnagraficaSoggetto, TipoSoggetto tipoSoggetto)
			throws DaoException, ServiceException {

		final String methodName = "buildIscrittoTIndirizzoRes";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		Residenza residenza;
		switch (tipoSoggetto) {
			case RIC:
				residenza = domandaNido.getRichiedente().getResidenza();
				break;
			case MIN:
				residenza = domandaNido.getMinore().getResidenza();
				break;
			case SOG1:
				residenza = domandaNido.getSoggetto1().getResidenza();
				break;
			case SOG2:
				residenza = domandaNido.getSoggetto2().getResidenza();
				break;
			case SOG3:
				residenza = domandaNido.getSoggetto3().getDati().getResidenza();
				if (StringUtils.isBlank(residenza.getCodNazione())) {
					residenza = null;
				}
				break;
			default:
				throw new ServiceException();
		}

		IscrittoTIndirizzoRes row = buildIscrittoTIndirizzoRes(idAnagraficaSoggetto, residenza);

		log.info(buildMessage(getClass(), methodName, LOG_END));
		return row;
	}

	private IscrittoTCondizioneSan buildIscrittoTCondizioneSan(DomandaNido domandaNido, Long idAnagraficaSoggetto, TipoSoggetto tipoSoggetto)
			throws ServiceException {

		final String methodName = "buildIscrittoTCondizioneSan";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		Disabilita disabilita = null;
		ProblemiSalute problemiSalute = null;
		Gravidanza gravidanza = null;
		switch (tipoSoggetto) {
			case MIN:
				Minore minore = domandaNido.getMinore();
				disabilita = minore.getDisabilita();
				problemiSalute = minore.getProblemiSalute();
				break;
			case SOG1:
				Soggetto1 soggetto1 = domandaNido.getSoggetto1();
				problemiSalute = soggetto1.getProblemiSalute();
				gravidanza = soggetto1.getGravidanza();
				break;
			case SOG2:
				Soggetto2 soggetto2 = domandaNido.getSoggetto2();
				problemiSalute = soggetto2.getProblemiSalute();
				gravidanza = soggetto2.getGravidanza();
				break;
			case SOG3:
				break;
			default:
				throw new ServiceException();
		}

		IscrittoTCondizioneSan row = buildIscrittoTCondizioneSan(idAnagraficaSoggetto, disabilita, problemiSalute, gravidanza);

		log.info(buildMessage(getClass(), methodName, LOG_END));
		return row;
	}

	private IscrittoRScuolaPre buildIscrittoRScuolaPre(Long idDomandaIscrizione, Nido nido) throws DaoException, ServiceException {
		final String methodName = "buildIscrittoRScuolaPre";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		if (nido == null) {
			return null;
		}

		IscrittoTScuola scuola = this.scuolaDao.findIscrittoTScuolaByCod(TipoScuola.NID, nido.getCodScuola());
		IscrittoDTipoFre decTipoFre = this.decodificaDao.findIscrittoDTipoFreByCod(nido.getCodTipoFrequenza());

		IscrittoRScuolaPre row = new IscrittoRScuolaPre();

		row.setFlFuoriTermine(toSN(false));
		row.setFlRinuncia(toSN(false));
		row.setPunteggio(null);

		row.setIdDomandaIscrizione(idDomandaIscrizione);
		row.setIdScuola(scuola.getIdScuola());
		row.setIdTipoFrequenza(decTipoFre.getIdTipoFrequenza());
		row.setPosizione(nido.getId());

		log.info(buildMessage(getClass(), methodName, LOG_END));
		return row;
	}

}
