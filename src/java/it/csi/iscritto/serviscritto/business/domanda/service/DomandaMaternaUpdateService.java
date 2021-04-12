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

import java.util.ArrayList;
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
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoRListaAttesa;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoRNidoContiguo;
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
import it.csi.iscritto.serviscritto.business.integration.dao.view.dto.SoggettoRow;
import it.csi.iscritto.serviscritto.business.integration.exception.DaoException;
import it.csi.iscritto.serviscritto.business.integration.exception.ServiceException;
import it.csi.iscritto.serviscritto.business.util.Constants;
import it.csi.iscritto.serviscritto.business.util.converter.ConvertUtils;
import it.csi.iscritto.serviscritto.dto.domanda.Affido;
import it.csi.iscritto.serviscritto.dto.domanda.AltriComponenti;
import it.csi.iscritto.serviscritto.dto.domanda.Anagrafica;
import it.csi.iscritto.serviscritto.dto.domanda.CondizioneOccupazionale;
import it.csi.iscritto.serviscritto.dto.domanda.DatiAnnoListaAttesa;
import it.csi.iscritto.serviscritto.dto.domanda.DatiListaAttesa;
import it.csi.iscritto.serviscritto.dto.domanda.Disabilita;
import it.csi.iscritto.serviscritto.dto.domanda.DomandaMaterna;
import it.csi.iscritto.serviscritto.dto.domanda.FratelloNidoContiguo;
import it.csi.iscritto.serviscritto.dto.domanda.Gravidanza;
import it.csi.iscritto.serviscritto.dto.domanda.Isee;
import it.csi.iscritto.serviscritto.dto.domanda.ListaAttesa;
import it.csi.iscritto.serviscritto.dto.domanda.LuogoNascita;
import it.csi.iscritto.serviscritto.dto.domanda.Materna;
import it.csi.iscritto.serviscritto.dto.domanda.Minore;
import it.csi.iscritto.serviscritto.dto.domanda.ProblemiSalute;
import it.csi.iscritto.serviscritto.dto.domanda.Residenza;
import it.csi.iscritto.serviscritto.dto.domanda.Richiedente;
import it.csi.iscritto.serviscritto.dto.domanda.Soggetto1;
import it.csi.iscritto.serviscritto.dto.domanda.Soggetto2;
import it.csi.iscritto.serviscritto.dto.domanda.Soggetto3;

public class DomandaMaternaUpdateService extends AbstractDomandaUpdateService {
	private static final Logger log = Logger.getLogger(Constants.COMPONENT_NAME + ".business");

	public Long insert(DomandaMaterna domandaMaterna) throws ServiceException {
		final String methodName = "insert";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		Long result;
		try {
			Validate.notNull(domandaMaterna);
			Validate.notBlank(domandaMaterna.getStatoDomanda());

			Long oldId = domandaMaterna.getIdDomandaIscrizione();
			log.info(buildMessage(getClass(), methodName, "oldId: " + oldId));

			Long newId = this.insertDomanda(TipoScuola.MAT, domandaMaterna);
			this.updateFlagNao(newId);
			log.info(buildMessage(getClass(), methodName, "newId: " + newId));

			if (oldId != null) {
				this.updateAllegati(oldId, newId, getAllegatiDomanda(domandaMaterna));
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

	public String inviaDomandaMaterna(Long idDomandaIscrizione) throws ServiceException {
		final String methodName = "inviaDomandaMaterna";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		String result;
		try {
			Validate.notNull(idDomandaIscrizione);

			result = this.inviaDomanda(TipoScuola.MAT, idDomandaIscrizione);
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

	public void protocollaAllegatiMaterna(Long idDomandaIscrizione) throws DaoException, ServiceException {
		final String methodName = "protocollaAllegatiMaterna";
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
	public void logError(String codiceFiscaleOperatore, String dettaglioErrore, DomandaMaterna domandaMaterna)
			throws DaoException {

		final String methodName = "logError";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		try {
			String jsonDomanda = domandaMaterna == null
					? null
					: new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(domandaMaterna);

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
	private Long insertDomanda(TipoScuola tipoScuola, DomandaMaterna domandaMaterna) throws DaoException, ServiceException {
		final String methodName = "insertDomanda";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		if (!StatoDomanda.BOZ.getCod().equals(domandaMaterna.getStatoDomanda())) {
			throw new ServiceException("stato domanda non valido");
		}

		IscrittoTDomandaIsc row = this.buildIscrittoTDomandaIsc(tipoScuola, domandaMaterna);
		Long idDomandaIscrizione = this.domandaIscDao.insertIscrittoTDomandaIsc(row);

		if (isRicSog1(domandaMaterna)) {
			this.insertSoggettoRicSog1(domandaMaterna, idDomandaIscrizione);
		}
		else {
			this.insertSoggetto(domandaMaterna, idDomandaIscrizione, TipoSoggetto.RIC);
			this.insertSoggetto(domandaMaterna, idDomandaIscrizione, TipoSoggetto.SOG1);
		}

		this.insertSoggetto(domandaMaterna, idDomandaIscrizione, TipoSoggetto.MIN);
		this.insertSoggetto(domandaMaterna, idDomandaIscrizione, TipoSoggetto.SOG2);
		this.insertSoggetto(domandaMaterna, idDomandaIscrizione, TipoSoggetto.SOG3);

		this.insertComponentiNucleo(domandaMaterna.getComponentiNucleo(), idDomandaIscrizione);
		this.insertAltriComponenti(domandaMaterna.getAltriComponenti(), idDomandaIscrizione);
		this.insertAffido(domandaMaterna.getAffido(), idDomandaIscrizione);
		this.insertIsee(domandaMaterna.getIsee(), idDomandaIscrizione);
		this.insertElencoMaterne(domandaMaterna, idDomandaIscrizione);
		this.insertListaAttesa(domandaMaterna, idDomandaIscrizione);
		this.insertNidoContiguo(domandaMaterna, idDomandaIscrizione);


		log.info(buildMessage(getClass(), methodName, LOG_END));
		return idDomandaIscrizione;
	}


	private void insertSoggetto(DomandaMaterna domandaMaterna, Long idDomandaIscrizione, TipoSoggetto tipoSoggetto)
			throws DaoException, ServiceException {

		final String methodName = "insertSoggetto";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		switch (tipoSoggetto) {
			case SOG2:
			case SOG3:
				if (!checkSoggetto(domandaMaterna, tipoSoggetto)) {
					return;
				}
				break;
			default:
				break;
		}

		IscrittoTAnagraficaSog row = this.buildIscrittoTAnagraficaSog(domandaMaterna, idDomandaIscrizione, tipoSoggetto);
		Long idAnagraficaSoggetto = this.anagraficaSogDao.insertIscrittoTAnagraficaSog(row);

		this.insertSoggettoRel(idAnagraficaSoggetto, tipoSoggetto);
		this.insertResidenza(domandaMaterna, idAnagraficaSoggetto, tipoSoggetto);
		this.insertCondizioneSanitaria(domandaMaterna, idAnagraficaSoggetto, tipoSoggetto);
		this.insertServiziSociali(domandaMaterna, idDomandaIscrizione, tipoSoggetto);
		this.insertCondizioneOccupazionale(domandaMaterna, idAnagraficaSoggetto, tipoSoggetto);
		this.insertGenitoreSolo(domandaMaterna, idDomandaIscrizione, tipoSoggetto);
		this.insertFratelloFrequentante(domandaMaterna, idDomandaIscrizione, tipoSoggetto);
		this.insertTrasferimento(domandaMaterna, idDomandaIscrizione, tipoSoggetto);
		this.insertSpostamento(domandaMaterna, idDomandaIscrizione, tipoSoggetto);

		log.info(buildMessage(getClass(), methodName, LOG_END));
	}

	private void insertSoggettoRicSog1(DomandaMaterna domandaMaterna, Long idDomandaIscrizione)
			throws DaoException, ServiceException {

		final String methodName = "insertSoggettoRicSog1";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		IscrittoTAnagraficaSog row = this.buildIscrittoTAnagraficaSog(domandaMaterna, idDomandaIscrizione, TipoSoggetto.SOG1);
		Long idAnagraficaSoggetto = this.anagraficaSogDao.insertIscrittoTAnagraficaSog(row);

		this.insertSoggettoRel(idAnagraficaSoggetto, TipoSoggetto.RIC);
		this.insertSoggettoRel(idAnagraficaSoggetto, TipoSoggetto.SOG1);

		this.insertResidenza(domandaMaterna, idAnagraficaSoggetto, TipoSoggetto.SOG1);
		this.insertCondizioneSanitaria(domandaMaterna, idAnagraficaSoggetto, TipoSoggetto.SOG1);
		this.insertServiziSociali(domandaMaterna, idDomandaIscrizione, TipoSoggetto.SOG1);
		this.insertCondizioneOccupazionale(domandaMaterna, idAnagraficaSoggetto, TipoSoggetto.SOG1);
		this.insertGenitoreSolo(domandaMaterna, idDomandaIscrizione, TipoSoggetto.SOG1);
		this.insertFratelloFrequentante(domandaMaterna, idDomandaIscrizione, TipoSoggetto.SOG1);
		this.insertTrasferimento(domandaMaterna, idDomandaIscrizione, TipoSoggetto.SOG1);
		this.insertSpostamento(domandaMaterna, idDomandaIscrizione, TipoSoggetto.SOG1);

		log.info(buildMessage(getClass(), methodName, LOG_END));
	}

	private void insertResidenza(DomandaMaterna domandaMaterna, Long idAnagraficaSoggetto, TipoSoggetto tipoSoggetto)
			throws DaoException, ServiceException {

		final String methodName = "insertResidenza";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		switch (tipoSoggetto) {
			case RIC:
			case MIN:
			case SOG1:
			case SOG2:
			case SOG3:
				if (!checkSoggetto(domandaMaterna, tipoSoggetto)) {
					return;
				}
				IscrittoTIndirizzoRes row = this.buildIscrittoTIndirizzoRes(domandaMaterna, idAnagraficaSoggetto, tipoSoggetto);
				if (row != null) {
					this.indirizzoResDao.insertIscrittoTIndirizzoRes(row);
				}
				break;
			default:
				break;
		}

		log.info(buildMessage(getClass(), methodName, LOG_END));
	}

	private void insertCondizioneSanitaria(DomandaMaterna domandaMaterna, Long idAnagraficaSoggetto, TipoSoggetto tipoSoggetto)
			throws DaoException, ServiceException {

		final String methodName = "insertCondizioneSanitaria";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		switch (tipoSoggetto) {
			case MIN:
			case SOG1:
			case SOG2:
				if (!checkSoggetto(domandaMaterna, tipoSoggetto)) {
					return;
				}
				IscrittoTCondizioneSan row = this.buildIscrittoTCondizioneSan(domandaMaterna, idAnagraficaSoggetto, tipoSoggetto);
				if (row != null) {
					this.condizioneSanDao.insertIscrittoTCondizioneSan(row);
				}
				break;
			default:
				break;
		}

		log.info(buildMessage(getClass(), methodName, LOG_END));
	}

	private void insertServiziSociali(DomandaMaterna domandaMaterna, Long idDomandaIscrizione, TipoSoggetto tipoSoggetto)
			throws DaoException, ServiceException {

		final String methodName = "insertServiziSociali";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		switch (tipoSoggetto) {
			case MIN:
				if (!checkSoggetto(domandaMaterna, tipoSoggetto)) {
					return;
				}
				IscrittoTServiziSoc row = this.buildIscrittoTServiziSoc(domandaMaterna.getMinore(), idDomandaIscrizione, tipoSoggetto);
				if (row != null) {
					this.serviziSocDao.insertIscrittoTServiziSoc(row);
				}
				break;
			default:
				break;
		}

		log.info(buildMessage(getClass(), methodName, LOG_END));
	}

	private void insertCondizioneOccupazionale(DomandaMaterna domandaMaterna, Long idAnagraficaSoggetto, TipoSoggetto tipoSoggetto)
			throws DaoException, ServiceException {

		final String methodName = "insertCondizioneOccupazionale";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		switch (tipoSoggetto) {
			case SOG1:
			case SOG2:
				if (!checkSoggetto(domandaMaterna, tipoSoggetto)) {
					return;
				}

				CondizioneOccupazionale condizioneOccupazionale = getCondizioneOccupazionale(domandaMaterna, tipoSoggetto);
				if (condizioneOccupazionale == null || StringUtils.isBlank(condizioneOccupazionale.getStato())) {
					return;
				}

				Long idCondizioneOccupazionale = this.condizioneOccDao.insertIscrittoTCondizioneOcc(
						this.buildIscrittoTCondizioneOcc(
								getCondizioneOccupazionale(domandaMaterna, tipoSoggetto),
								idAnagraficaSoggetto));

				TipoCondizioneOccupazionale tipoCondizioneOccupazionale = TipoCondizioneOccupazionale.findByCod(condizioneOccupazionale.getStato());
				switch (tipoCondizioneOccupazionale) {
					case DIP:
						this.dipendenteDao.insertIscrittoTDipendente(
								this.buildIscrittoTDipendente(
										getCondizioneOccupazionale(domandaMaterna, tipoSoggetto),
										idCondizioneOccupazionale));
						break;
					case AUT:
						this.autonomoDao.insertIscrittoTAutonomo(
								this.buildIscrittoTAutonomo(
										getCondizioneOccupazionale(domandaMaterna, tipoSoggetto),
										idCondizioneOccupazionale));
						break;
					case DIS:
						this.disoccupatoDao.insertIscrittoTDisoccupato(
								this.buildIscrittoTDisoccupato(
										getCondizioneOccupazionale(domandaMaterna, tipoSoggetto),
										idCondizioneOccupazionale));
						break;
					case DIS_LAV:
						List<IscrittoTDisoccupatoEx> nonOccupatoList = this.buildIscrittoTDisoccupatoEx(
								getCondizioneOccupazionale(domandaMaterna, tipoSoggetto),
								idCondizioneOccupazionale);

						for (IscrittoTDisoccupatoEx nonOccupato : nonOccupatoList) {
							this.disoccupatoExDao.insertIscrittoTDisoccupatoEx(nonOccupato);
						}
						break;
					case STU:
						this.studenteDao.insertIscrittoTStudente(
								this.buildIscrittoTStudente(
										getCondizioneOccupazionale(domandaMaterna, tipoSoggetto),
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

	private void insertGenitoreSolo(DomandaMaterna domandaMaterna, Long idDomandaIscrizione, TipoSoggetto tipoSoggetto)
			throws DaoException, ServiceException {

		final String methodName = "insertGenitoreSolo";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		switch (tipoSoggetto) {
			case SOG1:
				if (!checkSoggetto(domandaMaterna, tipoSoggetto)) {
					return;
				}
				IscrittoTGenitoreSolo row = this.buildIscrittoTGenitoreSolo(domandaMaterna.getSoggetto1(), idDomandaIscrizione, tipoSoggetto);
				if (row != null) {
					this.genitoreSoloDao.insertIscrittoTGenitoreSolo(row);
				}
				break;
			default:
				break;
		}

		log.info(buildMessage(getClass(), methodName, LOG_END));
	}

	private void insertFratelloFrequentante(DomandaMaterna domandaMaterna, Long idDomandaIscrizione, TipoSoggetto tipoSoggetto)
			throws DaoException, ServiceException {

		final String methodName = "insertFratelloFrequentante";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		switch (tipoSoggetto) {
			case MIN:
				if (!checkSoggetto(domandaMaterna, tipoSoggetto)) {
					return;
				}
				IscrittoTFratelloFre row = this.buildIscrittoTFratelloFre(domandaMaterna.getMinore(), idDomandaIscrizione, tipoSoggetto);
				if (row != null) {
					this.fratelloFreDao.insertIscrittoTFratelloFre(row);
				}
				break;
			default:
				break;
		}

		log.info(buildMessage(getClass(), methodName, LOG_END));
	}

	private void insertTrasferimento(DomandaMaterna domandaMaterna, Long idDomandaIscrizione, TipoSoggetto tipoSoggetto)
			throws DaoException, ServiceException {

		final String methodName = "insertTrasferimento";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		switch (tipoSoggetto) {
			case MIN:
				if (!checkSoggetto(domandaMaterna, tipoSoggetto)) {
					return;
				}
				IscrittoTTrasferimento row = this.buildIscrittoTTrasferimento(domandaMaterna.getMinore(), idDomandaIscrizione, tipoSoggetto);
				if (row != null) {
					this.trasferimentoDao.insertIscrittoTTrasferimento(row);
				}
				break;
			default:
				break;
		}

		log.info(buildMessage(getClass(), methodName, LOG_END));
	}

	private void insertSpostamento(DomandaMaterna domandaMaterna, Long idDomandaIscrizione, TipoSoggetto tipoSoggetto)
			throws DaoException, ServiceException {

		final String methodName = "insertSpostamento";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		switch (tipoSoggetto) {
			case MIN:
				if (!checkSoggetto(domandaMaterna, tipoSoggetto)) {
					return;
				}
				IscrittoTCambioRes row = this.buildIscrittoTCambioRes(domandaMaterna.getMinore(), idDomandaIscrizione, tipoSoggetto);
				if (row != null) {
					this.cambioResDao.insertIscrittoTCambioRes(row);
				}
				break;
			default:
				break;
		}

		log.info(buildMessage(getClass(), methodName, LOG_END));
	}

	private void insertElencoMaterne(DomandaMaterna domandaMaterna, Long idDomandaIscrizione) throws DaoException, ServiceException {
		final String methodName = "insertElencoMaterne";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		List<Materna> elencoMaterne = toList(domandaMaterna.getElencoMaterne());
		if (CollectionUtils.isEmpty(elencoMaterne)) {
			return;
		}

		int posizione = 1;

		for (Materna materna : elencoMaterne) {
			materna.setId(posizione++);

			IscrittoRScuolaPre row = this.buildIscrittoRScuolaPre(idDomandaIscrizione, materna);
			if (row != null) {
				this.scuolaDao.insertIscrittoRScuolaPre(row);
			}
		}

		log.info(buildMessage(getClass(), methodName, LOG_END));
	}

	private void insertListaAttesa(DomandaMaterna domandaMaterna, Long idDomandaIscrizione) throws DaoException, ServiceException {
		final String methodName = "insertListaAttesa";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		if (!checkSoggetto(domandaMaterna, TipoSoggetto.MIN)) {
			return;
		}

		ListaAttesa listaAttesa = domandaMaterna.getMinore().getListaAttesa();
		if (listaAttesa == null || !Boolean.TRUE.equals(listaAttesa.getStato())) {
			return;
		}

		DatiListaAttesa datiListaAttesa = listaAttesa.getDati();
		if (datiListaAttesa == null) {
			return;
		}

		List<DatiAnnoListaAttesa> anni = new ArrayList<>();

		DatiAnnoListaAttesa primoAnno = datiListaAttesa.getPrimoAnno();
		if (primoAnno != null) {
			anni.add(primoAnno);
		}

		DatiAnnoListaAttesa secondoAnno = datiListaAttesa.getSecondoAnno();
		if (secondoAnno != null) {
			anni.add(secondoAnno);
		}

		for (DatiAnnoListaAttesa anno : anni) {
			if (StringUtils.isBlank(anno.getAnnoScolastico())) {
				continue;
			}

			log.info(buildMessage(getClass(), methodName, "annoScolastico: " + anno.getAnnoScolastico()));

			IscrittoRListaAttesa row = this.buildIscrittoRListaAttesa(anno, idDomandaIscrizione);
			if (row != null) {
				this.listaAttesaDao.insertIscrittoRListaAttesa(row);
			}
		}

		log.info(buildMessage(getClass(), methodName, LOG_END));
	}

	private void insertNidoContiguo(DomandaMaterna domandaMaterna, Long idDomandaIscrizione) throws DaoException, ServiceException {
		final String methodName = "insertNidoContiguo";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		if (!checkSoggetto(domandaMaterna, TipoSoggetto.MIN)) {
			return;
		}

		FratelloNidoContiguo nidoContiguo = domandaMaterna.getMinore().getFratelloNidoContiguo();
		if (nidoContiguo == null || !Boolean.TRUE.equals(nidoContiguo.getStato())) {
			return;
		}

		Anagrafica anagrafica = nidoContiguo.getAnagrafica();
		if (anagrafica == null) {
			return;
		}

		String codiceFiscale = anagrafica.getCodiceFiscale();
		if (StringUtils.isBlank(codiceFiscale)) {
			return;
		}

		SoggettoRow soggetto = this.getSoggettoByCF(idDomandaIscrizione, codiceFiscale);
		if (soggetto == null) {
			return;
		}

		IscrittoRScuolaPre scuolaPre = ConvertUtils.getFirst(this.scuolaDao.findIscrittoRScuolaPreByFk(idDomandaIscrizione));
		if (scuolaPre == null || scuolaPre.getIdScuola() == null) {
			return;
		}

		IscrittoTScuola scuola = this.scuolaDao.findIscrittoTScuolaByKey(scuolaPre.getIdScuola());
		if (scuola == null || scuola.getIdNidoContiguo() == null) {
			return;
		}

		this.fratelloFreDao.insertIscrittoRNidoContiguo(this.buildIscrittoRNidoContiguo(
				idDomandaIscrizione,
				soggetto.getIdAnagraficaSoggetto(),
				scuola.getIdNidoContiguo()));

		log.info(buildMessage(getClass(), methodName, LOG_END));
	}

	//////////////////////////////////////////////////////////////////////
	// Costruzione DTO
	//////////////////////////////////////////////////////////////////////
	private IscrittoTDomandaIsc buildIscrittoTDomandaIsc(TipoScuola tipoScuola, DomandaMaterna domandaMaterna)
			throws DaoException, ServiceException {

		final String methodName = "buildIscrittoTDomandaIsc";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		IscrittoTAnnoSco annoSco = this.annoScoDao.findIscrittoTAnnoScoByCod(domandaMaterna.getAnnoScolastico());
		if (annoSco == null) {
			throw new ServiceException("anno scolastico non trovato");
		}

		IscrittoDCoabitazione decCoabitazione = this.decodificaDao.findIscrittoDCoabitazioneByCod(domandaMaterna.getRichiedente().getCondizioneCoabitazione());
		IscrittoDOrdineScuola decOrdineScuola = this.decodificaDao.findIscrittoDOrdineScuolaByCod(domandaMaterna.getOrdineScuola());
		IscrittoDStatoDom decStatoDom = this.decodificaDao.findIscrittoDStatoDomByCod(domandaMaterna.getStatoDomanda());

		Richiedente richiedente = domandaMaterna.getRichiedente();
		Minore minore = domandaMaterna.getMinore();
		Affido affido = domandaMaterna.getAffido();
		AltriComponenti altriComponenti = domandaMaterna.getAltriComponenti();
		Soggetto2 soggetto2 = domandaMaterna.getSoggetto2();
		Soggetto3 soggetto3 = domandaMaterna.getSoggetto3();
		Isee isee = domandaMaterna.getIsee();
		Long idUtenteIns = this.getIdUtenteByCF(domandaMaterna.getCodiceFiscaleUtenteIns());
		Long idUtenteMod = this.getIdUtenteByCF(domandaMaterna.getCodiceFiscaleUtenteMod());

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
		row.setFlInfoAutocertificazione(toSN(domandaMaterna.getInfoAutocertificazione()));
		row.setFlInfoGdpr(toSN(domandaMaterna.getInfoGdpr()));
		row.setFlIsee(toSN(isee == null ? null : isee.getStato()));
		row.setFlIstruita(toSN(false));
		row.setFlMinorePreNuc(toSN(minore.getPresenzaNucleo() == null ? null : minore.getPresenzaNucleo()));
		row.setFlResConRic(toSN(minore.getResidenzaConRichiedente() == null ? null : minore.getResidenzaConRichiedente()));
		row.setFlResidenzaForzata(toSN(minore.getSpostamento() == null ? null : minore.getSpostamento().getStato()));
		row.setFlResponsabilitaGen(toSN(domandaMaterna.getResponsabilitaGenitoriale()));
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
		row.setFlNao(toSN(domandaMaterna.getNao()));
		row.setFlConsensoTdConv(toSNN(domandaMaterna.getConsensoConvenzionata()));
		row.setFlCinqueAnni(minore.getCinqueAnniNonFrequentante());
		row.setFlListaAttesa(minore.getListaAttesa() == null ? null : toSNN(minore.getListaAttesa().getStato()));
		row.setFlFratelloContiguo(minore.getFratelloNidoContiguo() == null ? null : toSNN(minore.getFratelloNidoContiguo().getStato()));
		row.setFlIrc(domandaMaterna.getFlIrc());

		log.info(buildMessage(getClass(), methodName, LOG_END));
		return row;
	}

	private IscrittoTAnagraficaSog buildIscrittoTAnagraficaSog(DomandaMaterna domandaMaterna, Long idDomandaIscrizione, TipoSoggetto tipoSoggetto)
			throws DaoException, ServiceException {

		final String methodName = "buildIscrittoTAnagraficaSog";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		Anagrafica anagrafica;
		LuogoNascita luogoNascita;
		Long idRelParentela = null;

		switch (tipoSoggetto) {
			case RIC:
				Richiedente richiedente = domandaMaterna.getRichiedente();
				anagrafica = richiedente.getAnagrafica();
				luogoNascita = richiedente.getLuogoNascita();
				idRelParentela = this.getIdParentela(richiedente.getRelazioneConMinore());
				break;
			case MIN:
				Minore minore = domandaMaterna.getMinore();
				anagrafica = minore.getAnagrafica();
				luogoNascita = minore.getLuogoNascita();
				idRelParentela = null;
				break;
			case SOG1:
				Soggetto1 soggetto1 = domandaMaterna.getSoggetto1();
				anagrafica = soggetto1.getAnagrafica();
				luogoNascita = soggetto1.getLuogoNascita();
				if (isRicSog1(domandaMaterna)) {
					idRelParentela = this.getIdParentela(domandaMaterna.getRichiedente().getRelazioneConMinore());
				}
				break;
			case SOG2:
				Soggetto2 soggetto2 = domandaMaterna.getSoggetto2();
				anagrafica = soggetto2.getAnagrafica();
				luogoNascita = soggetto2.getLuogoNascita();
				break;
			case SOG3:
				Soggetto3 soggetto3 = domandaMaterna.getSoggetto3();
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

	private IscrittoTIndirizzoRes buildIscrittoTIndirizzoRes(DomandaMaterna domandaMaterna, Long idAnagraficaSoggetto, TipoSoggetto tipoSoggetto)
			throws DaoException, ServiceException {

		final String methodName = "buildIscrittoTIndirizzoRes";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		Residenza residenza;
		switch (tipoSoggetto) {
			case RIC:
				residenza = domandaMaterna.getRichiedente().getResidenza();
				break;
			case MIN:
				residenza = domandaMaterna.getMinore().getResidenza();
				break;
			case SOG1:
				residenza = domandaMaterna.getSoggetto1().getResidenza();
				break;
			case SOG2:
				residenza = domandaMaterna.getSoggetto2().getResidenza();
				break;
			case SOG3:
				residenza = domandaMaterna.getSoggetto3().getDati().getResidenza();
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

	private IscrittoTCondizioneSan buildIscrittoTCondizioneSan(DomandaMaterna domandaMaterna, Long idAnagraficaSoggetto, TipoSoggetto tipoSoggetto)
			throws ServiceException {

		final String methodName = "buildIscrittoTCondizioneSan";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		Disabilita disabilita = null;
		ProblemiSalute problemiSalute = null;
		Gravidanza gravidanza = null;
		switch (tipoSoggetto) {
			case MIN:
				Minore minore = domandaMaterna.getMinore();
				disabilita = minore.getDisabilita();
				problemiSalute = minore.getProblemiSalute();
				break;
			case SOG1:
				Soggetto1 soggetto1 = domandaMaterna.getSoggetto1();
				problemiSalute = soggetto1.getProblemiSalute();
				gravidanza = soggetto1.getGravidanza();
				break;
			case SOG2:
				Soggetto2 soggetto2 = domandaMaterna.getSoggetto2();
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

	private IscrittoRScuolaPre buildIscrittoRScuolaPre(Long idDomandaIscrizione, Materna materna) throws DaoException, ServiceException {
		final String methodName = "buildIscrittoRScuolaPre";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		if (materna == null) {
			return null;
		}

		IscrittoTScuola scuola = this.scuolaDao.findIscrittoTScuolaByCod(TipoScuola.MAT, materna.getCodScuola());
		IscrittoDTipoFre decTipoFre = this.decodificaDao.findIscrittoDTipoFreByCod(materna.getCodTipoFrequenza());

		IscrittoRScuolaPre row = new IscrittoRScuolaPre();

		row.setFlFuoriTermine(toSN(false));
		row.setFlRinuncia(toSN(false));
		row.setPunteggio(null);

		row.setIdDomandaIscrizione(idDomandaIscrizione);
		row.setIdScuola(scuola.getIdScuola());
		row.setIdTipoFrequenza(decTipoFre.getIdTipoFrequenza());
		row.setPosizione(materna.getId());

		log.info(buildMessage(getClass(), methodName, LOG_END));
		return row;
	}

	private IscrittoRListaAttesa buildIscrittoRListaAttesa(DatiAnnoListaAttesa datiAnno, Long idDomandaIscrizione) throws DaoException, ServiceException {
		final String methodName = "buildIscrittoRListaAttesa";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		if (datiAnno == null) {
			return null;
		}

		IscrittoTAnnoSco annoSco = this.annoScoDao.findIscrittoTAnnoScoByCod(datiAnno.getAnnoScolastico());

		IscrittoRListaAttesa row = new IscrittoRListaAttesa();

		row.setIdDomandaIsc(idDomandaIscrizione);
		row.setIdAnnoScolastico(annoSco.getIdAnnoScolastico());
		row.setScuolaLista(datiAnno.getScuola());

		log.info(buildMessage(getClass(), methodName, LOG_END));
		return row;
	}

	private IscrittoRNidoContiguo buildIscrittoRNidoContiguo(Long idDomandaIscrizione, Long idAnagraficaSoggetto, Long idNidoContiguo) {
		final String methodName = "buildIscrittoRNidoContiguo";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		IscrittoRNidoContiguo row = new IscrittoRNidoContiguo();

		row.setIdDomandaIsc(idDomandaIscrizione);
		row.setIdAnagraficaSoggetto(idAnagraficaSoggetto);
		row.setIdNidoContiguo(idNidoContiguo);

		log.info(buildMessage(getClass(), methodName, LOG_END));
		return row;
	}

}
