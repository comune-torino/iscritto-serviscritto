package it.csi.iscritto.serviscritto.business.domanda.service;

import static it.csi.iscritto.serviscritto.business.util.DomandaUtils.areEquals;
import static it.csi.iscritto.serviscritto.business.util.DomandaUtils.getAllegatiEliminati;
import static it.csi.iscritto.serviscritto.business.util.DomandaUtils.indexSoggettoByCF;
import static it.csi.iscritto.serviscritto.business.util.DomandaUtils.toDate;
import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.LOG_BEGIN;
import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.LOG_END;
import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.LOG_ERROR;
import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.buildMessage;
import static it.csi.iscritto.serviscritto.business.util.converter.ConvertUtils.toList;
import static it.csi.iscritto.serviscritto.business.util.converter.ConvertUtils.toSN;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import it.csi.iscritto.serviscritto.business.integration.dao.StatoDomanda;
import it.csi.iscritto.serviscritto.business.integration.dao.TipoScuola;
import it.csi.iscritto.serviscritto.business.integration.dao.TipoSoggetto;
import it.csi.iscritto.serviscritto.business.integration.dao.TipoSpostamento;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoDGenitoreSol;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoDRelazionePar;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoDTipConOcc;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoDTipoCambioRes;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoDTipoCorso;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoDTipoFra;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoDTipoPre;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoRSoggettoRel;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTAffido;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTAllegato;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTAnagraficaSog;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTAutonomo;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTCambioRes;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTComune;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTCondizioneOcc;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTCondizioneSan;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTDipendente;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTDisoccupato;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTDisoccupatoEx;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTDomandaIsc;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTFratelloFre;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTGenitoreSolo;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTIndirizzoRes;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTIsee;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTLogErroreDomanda;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTServiziSoc;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTStato;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTStudente;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTTrasferimento;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTUtente;
import it.csi.iscritto.serviscritto.business.integration.dao.view.dto.ProtocolloRow;
import it.csi.iscritto.serviscritto.business.integration.dao.view.dto.SoggettoRow;
import it.csi.iscritto.serviscritto.business.integration.exception.DaoException;
import it.csi.iscritto.serviscritto.business.integration.exception.ServiceException;
import it.csi.iscritto.serviscritto.business.util.Constants;
import it.csi.iscritto.serviscritto.business.util.DateUtils;
import it.csi.iscritto.serviscritto.business.util.ProtocolloUtils;
import it.csi.iscritto.serviscritto.business.util.converter.ConvertUtils;
import it.csi.iscritto.serviscritto.dto.domanda.Affido;
import it.csi.iscritto.serviscritto.dto.domanda.AltriComponenti;
import it.csi.iscritto.serviscritto.dto.domanda.Anagrafica;
import it.csi.iscritto.serviscritto.dto.domanda.Autonomo;
import it.csi.iscritto.serviscritto.dto.domanda.ComponentiNucleo;
import it.csi.iscritto.serviscritto.dto.domanda.CondizioneOccupazionale;
import it.csi.iscritto.serviscritto.dto.domanda.DatiCiDisoccupato;
import it.csi.iscritto.serviscritto.dto.domanda.DatiIsee;
import it.csi.iscritto.serviscritto.dto.domanda.DatiSpostamento;
import it.csi.iscritto.serviscritto.dto.domanda.DatiTrasferimento;
import it.csi.iscritto.serviscritto.dto.domanda.Dipendente;
import it.csi.iscritto.serviscritto.dto.domanda.Disabilita;
import it.csi.iscritto.serviscritto.dto.domanda.Disoccupato;
import it.csi.iscritto.serviscritto.dto.domanda.Documento;
import it.csi.iscritto.serviscritto.dto.domanda.FratelloFrequentante;
import it.csi.iscritto.serviscritto.dto.domanda.GenitoreSolo;
import it.csi.iscritto.serviscritto.dto.domanda.Gravidanza;
import it.csi.iscritto.serviscritto.dto.domanda.Isee;
import it.csi.iscritto.serviscritto.dto.domanda.LuogoNascita;
import it.csi.iscritto.serviscritto.dto.domanda.Minore;
import it.csi.iscritto.serviscritto.dto.domanda.NonOccupato;
import it.csi.iscritto.serviscritto.dto.domanda.ProblemiSalute;
import it.csi.iscritto.serviscritto.dto.domanda.Residenza;
import it.csi.iscritto.serviscritto.dto.domanda.Sentenza;
import it.csi.iscritto.serviscritto.dto.domanda.ServiziSociali;
import it.csi.iscritto.serviscritto.dto.domanda.Soggetto1;
import it.csi.iscritto.serviscritto.dto.domanda.SoggettoAffido;
import it.csi.iscritto.serviscritto.dto.domanda.SoggettoAltroComponente;
import it.csi.iscritto.serviscritto.dto.domanda.SoggettoNucleo;
import it.csi.iscritto.serviscritto.dto.domanda.Spostamento;
import it.csi.iscritto.serviscritto.dto.domanda.Studente;
import it.csi.iscritto.serviscritto.dto.domanda.Trasferimento;

public abstract class AbstractDomandaUpdateService extends AbstractDomandaService {
	private static final Logger log = Logger.getLogger(Constants.COMPONENT_NAME + ".business");
	// jira iscritto-34 (in stop)
	public void deleteDomanda(Long idDomandaIscrizione, String cfOperatore)
			throws DaoException, ServiceException {

		final String methodName = "deleteDomanda";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		log.info(buildMessage(getClass(), methodName, "idDomandaIscrizione: " + idDomandaIscrizione));

		try {
			IscrittoTDomandaIsc row = this.domandaIscDao.findIscrittoTDomandaIscByKey(idDomandaIscrizione);
			if (row == null) {
				throw new ServiceException("domanda non presente");
			}

			String codStatoDom = this.decodificaDao.findIscrittoDStatoDomByKey(row.getIdStatoDom()).getCodStatoDom();
			if (StatoDomanda.CAN.getCod().equals(codStatoDom)) {
				throw new ServiceException("la domanda e' gia' annullata");
			}

			if (StatoDomanda.BOZ.getCod().equals(codStatoDom)) {
				this.deleteBozza(idDomandaIscrizione);
			}
			else {
				final Long idOperatore;
				if (StringUtils.isNotBlank(cfOperatore)) {
					IscrittoTUtente utente = this.utenteDao.findIscrittoTUtenteByCF(cfOperatore);
					if (utente == null) {
						throw new ServiceException("operatore non presente o non abilitato");
					}
					idOperatore = utente.getIdUtente();
					log.info(buildMessage(getClass(), methodName, "idOperatore: " + idOperatore));
				}
				else {
					idOperatore = null;
				}

				this.domandaIscDao.annullaDomanda(idDomandaIscrizione, idOperatore);
				this.scuolaDao.annullaPreferenze(idDomandaIscrizione);
				this.graduatoriaDao.annullaPreferenze(idDomandaIscrizione);
			}
		}
		catch (Exception e) {
			log.error(buildMessage(getClass(), methodName, LOG_ERROR), e);
			throw new ServiceException(e);
		}

		log.info(buildMessage(getClass(), methodName, LOG_END));
	}

	//////////////////////////////////////////////////////////////////////

	protected String inviaDomanda(TipoScuola tipoScuola, Long idDomandaIscrizione) throws DaoException, ServiceException {
		final String methodName = "inviaDomanda";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		ProtocolloRow infoProtocollo = this.domandaDao.getInfoProtocollo(idDomandaIscrizione);

		if (!StatoDomanda.BOZ.getCod().equals(infoProtocollo.getCodStatoDom())) {
			throw new ServiceException("stato domanda non valido");
		}

		String codStatoDom = infoProtocollo.getCodStatoDom();
		log.info(buildMessage(getClass(), methodName, "codStatoDom: " + codStatoDom));

		String codOrdineScuola = infoProtocollo.getCodOrdineScuola();
		log.info(buildMessage(getClass(), methodName, "codOrdineScuola: " + codOrdineScuola));

		int anno = DateUtils.getCurrentYear();
		log.info(buildMessage(getClass(), methodName, "anno: " + anno));

		long numProtocollo = this.domandaDao.getNextNumProtocollo(tipoScuola);
		log.info(buildMessage(getClass(), methodName, "numProtocollo: " + numProtocollo));

		String protocollo = ProtocolloUtils.buildProtocollo(numProtocollo, codOrdineScuola);
		log.info(buildMessage(getClass(), methodName, "protocollo: " + protocollo));

		this.domandaIscDao.updateDomandaForInvio(idDomandaIscrizione, protocollo);

		log.info(buildMessage(getClass(), methodName, LOG_END));
		return protocollo;
	}

	protected void protocollaAllegatiDomanda(Long idDomandaIscrizione) throws DaoException, ServiceException {
		final String methodName = "protocollaAllegatiDomanda";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		IscrittoTDomandaIsc dom = this.domandaIscDao.findIscrittoTDomandaIscByKey(idDomandaIscrizione);
		if (dom == null) {
			throw new ServiceException("domanda non trovata");
		}

		ProtocolloRow infoProtocollo = this.domandaDao.getInfoProtocollo(idDomandaIscrizione);
		if (StatoDomanda.BOZ.getCod().equals(infoProtocollo.getCodStatoDom())) {
			return;
		}

		final String protocolloDomanda = dom.getProtocollo();
		if (StringUtils.isBlank(protocolloDomanda)) {
			throw new ServiceException("protocollo domanda non valorizzato");
		}

		List<IscrittoTAnagraficaSog> soggetti = this.anagraficaSogDao.findIscrittoTAnagraficaSogByIdDomanda(idDomandaIscrizione);
		if (CollectionUtils.isEmpty(soggetti)) {
			return;
		}

		List<IscrittoTAllegato> allegati = new ArrayList<>();
		for (IscrittoTAnagraficaSog soggetto : soggetti) {
			allegati.addAll(this.allegatoDao.findIscrittoTAllegatoByFk(soggetto.getIdAnagraficaSoggetto()));
		}

		int count = ProtocolloUtils.getNextProtocolloAllegato(allegati);
		for (IscrittoTAllegato allegato : allegati) {
			Long idAllegato = allegato.getIdAllegato();

			if (StringUtils.isNotBlank(allegato.getProtocollo())) {
				log.info(buildMessage(getClass(), methodName,
						String.format("allegato %s gia' protocollato con %s", idAllegato, allegato.getProtocollo())));

				continue;
			}

			String codTipoAllegato = this.decodificaDao.findIscrittoDTipoAllByKey(allegato.getIdTipoAllegato()).getCodTipoAllegato();
			String protocollo = ProtocolloUtils.buildProtocolloAllegato(protocolloDomanda, count++, codTipoAllegato);

			this.allegatoDao.updateProtocollo(idAllegato, protocollo);
			log.info(buildMessage(getClass(), methodName,
					String.format("allegato %s protocollato con %s", idAllegato, protocollo)));
		}

		log.info(buildMessage(getClass(), methodName, LOG_END));
	}

	//////////////////////////////////////////////////////////////////////
	// Gestione allegati
	//////////////////////////////////////////////////////////////////////
	protected void updateAllegati(Long oldId, Long newId, List<Documento> allegatiDomanda) throws DaoException, ServiceException {
		final String methodName = "updateAllegati";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		List<SoggettoRow> soggettiOld = this.soggettoDao.findSoggettiByIdDomanda(oldId);
		List<SoggettoRow> soggettiNew = this.soggettoDao.findSoggettiByIdDomanda(newId);

		Map<String, SoggettoRow> cfIndex = indexSoggettoByCF(soggettiOld);
		Map<Long, Long> idMap = new LinkedHashMap<>();
		for (SoggettoRow soggettoNew : soggettiNew) {
			SoggettoRow soggettoOld = cfIndex.get(soggettoNew.getCodiceFiscale());
			if (areEquals(soggettoNew, soggettoOld)) {
				Long idSoggettoOld = soggettoOld.getIdAnagraficaSoggetto();
				Long idSoggettoNew = soggettoNew.getIdAnagraficaSoggetto();

				idMap.put(idSoggettoOld, idSoggettoNew);

				log.info(buildMessage(getClass(), methodName,
						String.format("soggetto %s mappato su soggetto %s", idSoggettoOld, idSoggettoNew)));
			}
		}

		Set<Long> allegatiEliminati = getAllegatiEliminati(allegatiDomanda);
		for (Map.Entry<Long, Long> entry : idMap.entrySet()) {
			Long from = entry.getKey();
			Long to = entry.getValue();

			List<IscrittoTAllegato> allegati = this.allegatoDao.findIscrittoTAllegatoByFk(from);
			for (IscrittoTAllegato allegato : allegati) {
				Long idAllegato = allegato.getIdAllegato();
				if (allegatiEliminati.contains(idAllegato)) {
					continue;
				}

				this.allegatoDao.updateAllegato(idAllegato, to);
				log.info(buildMessage(getClass(), methodName,
						String.format("aggiornato allegato %s da soggetto %s a soggetto %s", idAllegato, from, to)));
			}
		}

		log.info(buildMessage(getClass(), methodName, LOG_END));
	}

	//////////////////////////////////////////////////////////////////////
	// Cancellazione domanda
	//////////////////////////////////////////////////////////////////////
	protected void deleteBozza(Long oldId) throws DaoException {
		final String methodName = "deleteBozza";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		IscrittoTDomandaIsc row = this.domandaIscDao.findIscrittoTDomandaIscByKey(oldId);
		if (row == null) {
			return;
		}

		// verifica stato domanda
		String codStatoDom = this.decodificaDao.findIscrittoDStatoDomByKey(row.getIdStatoDom()).getCodStatoDom();
		if (!StatoDomanda.BOZ.getCod().equals(codStatoDom)) {
			new ServiceException("stato domanda non valido");
		}

		List<IscrittoTAnagraficaSog> soggettoList = this.anagraficaSogDao.findIscrittoTAnagraficaSogByIdDomanda(oldId);

		// allegati
		for (IscrittoTAnagraficaSog soggetto : soggettoList) {
			List<IscrittoTAllegato> allegati = this.allegatoDao.findIscrittoTAllegatoByFk(soggetto.getIdAnagraficaSoggetto());
			for (IscrittoTAllegato allegato : allegati) {
				this.allegatoDao.deleteAllegato(allegato.getIdAllegato());
			}
		}

		// sentenza affido
		for (IscrittoTAnagraficaSog soggetto : soggettoList) {
			this.affidoDao.deleteIscrittoTAffido(soggetto.getIdAnagraficaSoggetto());
		}

		// condizione sanitaria
		for (IscrittoTAnagraficaSog soggetto : soggettoList) {
			this.condizioneSanDao.deleteIscrittoTCondizioneSan(soggetto.getIdAnagraficaSoggetto());
		}

		// condizione occupazionale
		for (IscrittoTAnagraficaSog soggetto : soggettoList) {
			IscrittoTCondizioneOcc condizioneOcc = this.condizioneOccDao.findCondizioneOccByFk(soggetto.getIdAnagraficaSoggetto());
			if (condizioneOcc == null) {
				continue;
			}

			Long idCondizioneOccupazionale = condizioneOcc.getIdCondizioneOccupazionale();

			this.dipendenteDao.deleteIscrittoTDipendente(idCondizioneOccupazionale);
			this.disoccupatoDao.deleteIscrittoTDisoccupato(idCondizioneOccupazionale);
			this.autonomoDao.deleteIscrittoTAutonomo(idCondizioneOccupazionale);
			this.studenteDao.deleteIscrittoTStudente(idCondizioneOccupazionale);

			List<IscrittoTDisoccupatoEx> disoccupatoList = this.disoccupatoExDao.findDisoccupatoExByFk(idCondizioneOccupazionale);
			for (IscrittoTDisoccupatoEx disoccupato : disoccupatoList) {
				this.disoccupatoExDao.deleteIscrittoTDisoccupatoEx(disoccupato.getIdDisoccupatoExLav());
			}

			this.condizioneOccDao.deleteIscrittoTCondizioneOcc(idCondizioneOccupazionale);
		}

		this.fratelloFreDao.deleteIscrittoRNidoContiguo(oldId);
		this.listaAttesaDao.deleteIscrittoRListaAttesa(oldId);

		// soggetto
		for (IscrittoTAnagraficaSog soggetto : soggettoList) {
			this.indirizzoResDao.deleteIscrittoTIndirizzoRes(soggetto.getIdAnagraficaSoggetto());
			this.soggettoRelDao.deleteIscrittoRSoggettoRelByIdSoggetto(soggetto.getIdAnagraficaSoggetto());
			this.anagraficaSogDao.deleteIscrittoTAnagraficaSog(soggetto.getIdAnagraficaSoggetto());
		}

		this.serviziSocDao.deleteIscrittoTServiziSoc(oldId);
		this.genitoreSoloDao.deleteIscrittoTGenitoreSolo(oldId);
		this.fratelloFreDao.deleteIscrittoTFratelloFreByFk(oldId);
		this.trasferimentoDao.deleteIscrittoTTrasferimento(oldId);
		this.cambioResDao.deleteIscrittoTCambioRes(oldId);
		this.scuolaDao.deleteIscrittoRScuolaPreByFk(oldId);
		this.iseeDao.deleteIscrittoTIsee(oldId);
		this.condizionePunteggioDao.deleteIscrittoRPunteggioDomByIdDomanda(oldId);
		this.domandaIscDao.deleteIscrittoTDomandaIsc(oldId);

		log.info(buildMessage(getClass(), methodName, LOG_END));
	}

	//////////////////////////////////////////////////////////////////////
	// Aggiornamento flag nao soggetti
	//////////////////////////////////////////////////////////////////////
	protected void updateFlagNao(Long idDomandaIscrizione) throws DaoException, ServiceException {
		final String methodName = "updateFlagNao";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		IscrittoTDomandaIsc row = this.domandaIscDao.findIscrittoTDomandaIscByKey(idDomandaIscrizione);
		if (row == null) {
			throw new ServiceException("domanda non valida");
		}

		final boolean flNao = Boolean.TRUE.equals(ConvertUtils.fromSN(row.getFlNao()));
		final boolean flMinorePreNuc = Boolean.TRUE.equals(ConvertUtils.fromSN(row.getFlMinorePreNuc()));

		List<SoggettoRow> soggetti = this.soggettoDao.findSoggettiByIdDomanda(idDomandaIscrizione);
		for (SoggettoRow soggetto : soggetti) {
			TipoSoggetto tipoSoggetto = TipoSoggetto.findByCod(soggetto.getCodTipoSoggetto());
			if (tipoSoggetto == null) {
				continue;
			}

			Boolean flResidenzaNao = this.getFlagResidenzaNao(flNao, flMinorePreNuc, tipoSoggetto);
			this.anagraficaSogDao.updateIscrittoTAnagraficaSogForNao(soggetto.getIdAnagraficaSoggetto(), flResidenzaNao);
		}

		log.info(buildMessage(getClass(), methodName, LOG_END));
	}

	protected Boolean getFlagResidenzaNao(boolean flNao, boolean flMinorePreNuc, TipoSoggetto tipoSoggetto) {
		final String methodName = "getFlagResidenzaNao";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		Boolean flResidenzaNao;
		switch (tipoSoggetto) {
			case RIC:
				flResidenzaNao = flNao;
				break;
			case MIN:
				flResidenzaNao = flNao && flMinorePreNuc;
				break;
			case SOG1:
				flResidenzaNao = flNao && flMinorePreNuc;
				break;
			case SOG2:
				flResidenzaNao = null;
				break;
			case SOG3:
				flResidenzaNao = null;
				break;
			case CMP_NUC:
				flResidenzaNao = flNao;
				break;
			case AFF:
				flResidenzaNao = false;
				break;
			case ALT_CMP:
				flResidenzaNao = false;
				break;
			default:
				flResidenzaNao = null;
				break;
		}

		log.info(buildMessage(getClass(), methodName, LOG_END));
		return flResidenzaNao;
	}

	//////////////////////////////////////////////////////////////////////
	// Salvataggio domanda
	//////////////////////////////////////////////////////////////////////
	protected void insertComponentiNucleo(ComponentiNucleo componentiNucleo, Long idDomandaIscrizione) throws DaoException, ServiceException {
		final String methodName = "insertComponentiNucleo";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		if (componentiNucleo == null) {
			return;
		}

		List<SoggettoNucleo> soggetti = toList(componentiNucleo.getSoggetti());
		if (CollectionUtils.isEmpty(soggetti)) {
			return;
		}

		for (SoggettoNucleo soggetto : soggetti) {
			Anagrafica anagrafica = soggetto.getAnagrafica();
			LuogoNascita luogoNascita = soggetto.getLuogoNascita();
			Long idRelParentela = getIdParentela(soggetto.getRelazioneConMinore());

			Long idAnagraficaSoggetto = this.anagraficaSogDao.insertIscrittoTAnagraficaSog(
					this.buildIscrittoTAnagraficaSog(idDomandaIscrizione, anagrafica, luogoNascita, idRelParentela, TipoSoggetto.CMP_NUC));

			this.insertSoggettoRel(idAnagraficaSoggetto, TipoSoggetto.CMP_NUC);

			this.condizioneSanDao.insertIscrittoTCondizioneSan(
					this.buildIscrittoTCondizioneSan(idAnagraficaSoggetto, null, soggetto.getProblemiSalute(), null));
		}

		log.info(buildMessage(getClass(), methodName, LOG_END));
	}

	protected void insertAltriComponenti(AltriComponenti altriComponenti, Long idDomandaIscrizione) throws DaoException, ServiceException {
		final String methodName = "insertAltriComponenti";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		if (altriComponenti == null || !Boolean.TRUE.equals(altriComponenti.getStato())) {
			return;
		}

		List<SoggettoAltroComponente> soggetti = toList(altriComponenti.getSoggetti());
		if (CollectionUtils.isEmpty(soggetti)) {
			return;
		}

		for (SoggettoAltroComponente soggetto : soggetti) {
			Anagrafica anagrafica = soggetto.getAnagrafica();
			LuogoNascita luogoNascita = soggetto.getLuogoNascita();
			Residenza residenza = soggetto.getResidenza();
			Long idRelParentela = getIdParentela(soggetto.getRelazioneConMinore());

			Long idAnagraficaSoggetto = this.anagraficaSogDao.insertIscrittoTAnagraficaSog(
					this.buildIscrittoTAnagraficaSog(idDomandaIscrizione, anagrafica, luogoNascita, idRelParentela, TipoSoggetto.ALT_CMP));

			this.insertSoggettoRel(idAnagraficaSoggetto, TipoSoggetto.ALT_CMP);

			this.condizioneSanDao.insertIscrittoTCondizioneSan(
					this.buildIscrittoTCondizioneSan(idAnagraficaSoggetto, null, soggetto.getProblemiSalute(), null));

			this.insertResidenza(idAnagraficaSoggetto, residenza);
		}

		log.info(buildMessage(getClass(), methodName, LOG_END));
	}

	protected void insertAffido(Affido affido, Long idDomandaIscrizione) throws DaoException, ServiceException {
		final String methodName = "insertAffido";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		if (affido == null || !Boolean.TRUE.equals(affido.getStato())) {
			return;
		}

		List<SoggettoAffido> soggetti = toList(affido.getSoggetti());
		if (CollectionUtils.isEmpty(soggetti)) {
			return;
		}

		for (SoggettoAffido soggetto : soggetti) {
			Anagrafica anagrafica = soggetto.getAnagrafica();
			LuogoNascita luogoNascita = soggetto.getLuogoNascita();
			Residenza residenza = soggetto.getResidenza();
			Sentenza sentenza = soggetto.getSentenza();
			Long idRelParentela = getIdParentela(soggetto.getRelazioneConMinore());

			Long idAnagraficaSoggetto = this.anagraficaSogDao.insertIscrittoTAnagraficaSog(
					this.buildIscrittoTAnagraficaSog(idDomandaIscrizione, anagrafica, luogoNascita, idRelParentela, TipoSoggetto.AFF));

			this.insertSoggettoRel(idAnagraficaSoggetto, TipoSoggetto.AFF);

			this.condizioneSanDao.insertIscrittoTCondizioneSan(
					this.buildIscrittoTCondizioneSan(idAnagraficaSoggetto, null, soggetto.getProblemiSalute(), null));

			this.insertResidenza(idAnagraficaSoggetto, residenza);
			this.insertSentenzaAffido(idAnagraficaSoggetto, sentenza);
		}

		log.info(buildMessage(getClass(), methodName, LOG_END));
	}

	protected void insertSoggettoRel(Long idAnagraficaSoggetto, TipoSoggetto tipoSoggetto)
			throws DaoException {

		final String methodName = "insertSoggettoRel";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		IscrittoRSoggettoRel row = this.buildIscrittoRSoggettoRel(idAnagraficaSoggetto, tipoSoggetto);
		if (row != null) {
			this.soggettoRelDao.insertIscrittoRSoggettoRel(row);
		}

		log.info(buildMessage(getClass(), methodName, LOG_END));
	}

	protected void insertResidenza(Long idAnagraficaSoggetto, Residenza residenza) throws DaoException {
		final String methodName = "insertResidenza";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		if (residenza == null) {
			return;
		}

		IscrittoTIndirizzoRes row = this.buildIscrittoTIndirizzoRes(idAnagraficaSoggetto, residenza);
		if (row != null) {
			this.indirizzoResDao.insertIscrittoTIndirizzoRes(row);
		}

		log.info(buildMessage(getClass(), methodName, LOG_END));
	}

	protected void insertSentenzaAffido(Long idAnagraficaSoggetto, Sentenza sentenza) throws DaoException, ServiceException {
		final String methodName = "insertSentenzaAffido";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		if (sentenza == null) {
			return;
		}

		IscrittoTAffido row = this.buildIscrittoTAffido(idAnagraficaSoggetto, sentenza);
		if (row != null) {
			this.affidoDao.insertIscrittoTAffido(row);
		}

		log.info(buildMessage(getClass(), methodName, LOG_END));
	}

	protected void insertIsee(Isee isee, Long idDomandaIscrizione) throws DaoException, ServiceException {
		final String methodName = "insertIsee";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		if (isee == null || !Boolean.TRUE.equals(isee.getStato())) {
			return;
		}

		IscrittoTIsee row = this.buildIscrittoTIsee(idDomandaIscrizione, isee);

		if (row != null) {
			this.iseeDao.insertIscrittoTIsee(row);
		}

		log.info(buildMessage(getClass(), methodName, LOG_END));
	}

	//////////////////////////////////////////////////////////////////////
	// Costruzione DTO
	//////////////////////////////////////////////////////////////////////
	protected String getFlagFratelloFreq(Minore minore) {
		FratelloFrequentante fratelloFrequentante = minore.getFratelloFrequentante();
		if (fratelloFrequentante == null) {
			return null;
		}

		Boolean stato = fratelloFrequentante.getStato();
		if (stato == null) {
			return null;
		}

		return toSN(stato);
	}

	protected IscrittoTAnagraficaSog buildIscrittoTAnagraficaSog(
			Long idDomandaIscrizione, Anagrafica anagrafica, LuogoNascita luogoNascita, Long idRelParentela, TipoSoggetto tipoSoggetto)
			throws DaoException, ServiceException {

		final String methodName = "buildIscrittoTAnagraficaSog";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		Date dataNascita = toDate(anagrafica.getDataNascita());
		IscrittoTComune comune = null;
		IscrittoTStato stato = null;
		if (luogoNascita != null) {
			Date now = new Date();
			comune = this.comuneDao.findIscrittoTComuneByIstatComune(now, luogoNascita.getCodComune());
			stato = this.statoDao.findIscrittoTStatoByCod(now, luogoNascita.getCodNazione());
		}

		IscrittoTStato cittadinanza = null;
		if (StringUtils.isNotBlank(anagrafica.getCodCittadinanza())) {
			cittadinanza = this.statoDao.findIscrittoTStatoByCod(new Date(), anagrafica.getCodCittadinanza());
		}

		IscrittoTAnagraficaSog row = new IscrittoTAnagraficaSog();

		row.setIdAnagraficaSoggetto(null);
		row.setCodiceFiscale(anagrafica.getCodiceFiscale());
		row.setCognome(anagrafica.getCognome());
		row.setDataNascita(dataNascita);
		row.setIdComuneNascita(comune == null ? null : comune.getIdComune());
		row.setIdDomandaIscrizione(idDomandaIscrizione);
		row.setIdRelParentela(idRelParentela);
		row.setIdStatoNascita(stato == null ? null : stato.getIdStato());
		row.setNome(anagrafica.getNome());
		if (TipoSoggetto.MIN.equals(tipoSoggetto)) {
			row.setOraNascita(anagrafica.getOraMinutiNascita());
		}
		row.setSesso(anagrafica.getSesso());
		row.setIdStatoCitt(cittadinanza == null ? null : cittadinanza.getIdStato());

		log.info(buildMessage(getClass(), methodName, LOG_END));
		return row;
	}

	protected IscrittoRSoggettoRel buildIscrittoRSoggettoRel(Long idAnagraficaSoggetto, TipoSoggetto tipoSoggetto)
			throws DaoException {

		final String methodName = "buildIscrittoRSoggettoRel";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		Long idTipoSoggetto = this.decodificaDao.findIscrittoDTipoSogByCod(tipoSoggetto.getCod()).getIdTipoSoggetto();
		IscrittoRSoggettoRel row = new IscrittoRSoggettoRel();

		row.setIdAnagraficaSoggetto(idAnagraficaSoggetto);
		row.setIdTipoSoggetto(idTipoSoggetto);

		log.info(buildMessage(getClass(), methodName, LOG_END));
		return row;
	}

	protected IscrittoTIndirizzoRes buildIscrittoTIndirizzoRes(Long idAnagraficaSoggetto, Residenza residenza) throws DaoException {
		final String methodName = "buildIscrittoTIndirizzoRes";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		if (residenza == null) {
			return null;
		}

		Date now = new Date();
		IscrittoTComune comune = this.comuneDao.findIscrittoTComuneByIstatComune(now, residenza.getCodComune());
		IscrittoTStato stato = this.statoDao.findIscrittoTStatoByCod(now, residenza.getCodNazione());

		IscrittoTIndirizzoRes row = new IscrittoTIndirizzoRes();

		row.setCap(residenza.getCap());
		row.setIdAnagraficaSoggetto(idAnagraficaSoggetto);
		row.setIdComune(comune == null ? null : comune.getIdComune());
		row.setIdStatoResidenza(stato == null ? null : stato.getIdStato());
		row.setIndirizzo(residenza.getIndirizzo());

		log.info(buildMessage(getClass(), methodName, LOG_END));
		return row;
	}

	protected IscrittoTCondizioneSan buildIscrittoTCondizioneSan(
			Long idAnagraficaSoggetto,
			Disabilita disabilita,
			ProblemiSalute problemiSalute,
			Gravidanza gravidanza) {

		final String methodName = "buildIscrittoTCondizioneSan";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		IscrittoTCondizioneSan row = new IscrittoTCondizioneSan();
		row.setIdAnagraficaSoggetto(idAnagraficaSoggetto);

		row.setFlDisabilita(disabilita == null ? toSN(false) : toSN(disabilita.getStato()));
		row.setFlProblemiSalute(problemiSalute == null ? toSN(false) : toSN(problemiSalute.getStato()));
		row.setFlStatoGravidanza(gravidanza == null ? toSN(false) : toSN(gravidanza.getStato()));

		log.info(buildMessage(getClass(), methodName, LOG_END));
		return row;
	}

	protected IscrittoTServiziSoc buildIscrittoTServiziSoc(Minore minore, Long idDomandaIscrizione, TipoSoggetto tipoSoggetto)
			throws ServiceException {

		final String methodName = "buildIscrittoTServiziSoc";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		ServiziSociali serviziSociali = minore.getServiziSociali();

		if (serviziSociali == null || !Boolean.TRUE.equals(serviziSociali.getStato())) {
			return null;
		}

		IscrittoTServiziSoc row = new IscrittoTServiziSoc();
		row.setIdDomandaIscrizione(idDomandaIscrizione);

		switch (tipoSoggetto) {
			case MIN:
				row.setIndirizzo(serviziSociali.getDati().getIndirizzo());
				row.setNominativo(serviziSociali.getDati().getNome());
				row.setServizio(serviziSociali.getDati().getAssistente());
				row.setTelefono(serviziSociali.getDati().getTelefono());
				break;
			default:
				throw new ServiceException();
		}

		log.info(buildMessage(getClass(), methodName, LOG_END));
		return row;
	}

	protected IscrittoTGenitoreSolo buildIscrittoTGenitoreSolo(Soggetto1 soggetto1, Long idDomandaIscrizione, TipoSoggetto tipoSoggetto)
			throws DaoException, ServiceException {

		final String methodName = "buildIscrittoTGenitoreSolo";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		GenitoreSolo genitoreSolo;
		switch (tipoSoggetto) {
			case SOG1:
				genitoreSolo = soggetto1.getGenitoreSolo();
				break;
			default:
				throw new ServiceException();
		}

		if (genitoreSolo == null || StringUtils.isBlank(genitoreSolo.getStato())) {
			return null;
		}

		Sentenza sentenza = genitoreSolo.getSentenza();
		IscrittoDGenitoreSol decGenitoreSol = this.decodificaDao.findIscrittoDGenitoreSolByCod(genitoreSolo.getStato());

		IscrittoTGenitoreSolo row = new IscrittoTGenitoreSolo();

		row.setDtSentenza(toDate(sentenza.getData()));
		row.setIdDomandaIscrizione(idDomandaIscrizione);
		row.setIdTipoGenitoreSolo(decGenitoreSol.getIdTipoGenitoreSolo());
		row.setNumSentenza(sentenza.getNumero());
		row.setTribunale(sentenza.getTribunale());

		log.info(buildMessage(getClass(), methodName, LOG_END));
		return row;
	}

	protected IscrittoTCondizioneOcc buildIscrittoTCondizioneOcc(CondizioneOccupazionale condizioneOccupazionale, Long idAnagraficaSoggetto)
			throws DaoException, ServiceException {

		final String methodName = "buildIscrittoTCondizioneOcc";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		IscrittoDTipConOcc decTipConOcc = this.decodificaDao.findIscrittoDTipConOccByCod(condizioneOccupazionale.getStato());

		IscrittoTCondizioneOcc row = new IscrittoTCondizioneOcc();

		row.setIdAnagraficaSoggetto(idAnagraficaSoggetto);
		row.setIdCondizioneOccupazionale(null);
		row.setIdTipCondOccupazionale(decTipConOcc.getIdTipCondOccupazionale());

		log.info(buildMessage(getClass(), methodName, LOG_END));
		return row;
	}

	protected IscrittoTDipendente buildIscrittoTDipendente(CondizioneOccupazionale condizioneOccupazionale, Long idCondizioneOccupazionale)
			throws ServiceException {

		final String methodName = "buildIscrittoTDipendente";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		Dipendente dipendente = condizioneOccupazionale.getDati().getDipendente();

		IscrittoTDipendente row = new IscrittoTDipendente();

		row.setIdCondizioneOccupazionale(idCondizioneOccupazionale);
		row.setAzienda(dipendente.getAzienda());
		row.setComuneLavoro(dipendente.getComune());
		row.setIndirizzoLavoro(dipendente.getIndirizzo());
		row.setProvinciaLavoro(dipendente.getProvincia());

		log.info(buildMessage(getClass(), methodName, LOG_END));
		return row;
	}

	protected IscrittoTAutonomo buildIscrittoTAutonomo(CondizioneOccupazionale condizioneOccupazionale, Long idCondizioneOccupazionale)
			throws ServiceException {

		final String methodName = "buildIscrittoTAutonomo";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		Autonomo autonomo = condizioneOccupazionale.getDati().getAutonomo();

		IscrittoTAutonomo row = new IscrittoTAutonomo();

		row.setIdCondizioneOccupazionale(idCondizioneOccupazionale);
		row.setComuneLavoro(autonomo.getComune());
		row.setIndirizzoLavoro(autonomo.getIndirizzo());
		row.setPartitaivaCf(autonomo.getPiva());
		row.setProvinciaLavoro(autonomo.getProvincia());

		log.info(buildMessage(getClass(), methodName, LOG_END));
		return row;
	}

	protected IscrittoTDisoccupato buildIscrittoTDisoccupato(CondizioneOccupazionale condizioneOccupazionale, Long idCondizioneOccupazionale)
			throws DaoException, ServiceException {

		final String methodName = "buildIscrittoTDisoccupato";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		Disoccupato disoccupato = condizioneOccupazionale.getDati().getDisoccupato();
		DatiCiDisoccupato datiCi = disoccupato.getDatiCi();

		IscrittoDTipoPre decTipoPre = this.decodificaDao.findIscrittoDTipoPreByCod(disoccupato.getSoggettoDichiarazione());

		IscrittoTDisoccupato row = new IscrittoTDisoccupato();

		row.setDtDichiarazioneDisponibili(toDate(disoccupato.getDataDichiarazione()));
		row.setIdCondizioneOccupazionale(idCondizioneOccupazionale);
		row.setIdTipoPresentazione(decTipoPre.getIdTipoPresentazione());
		if (datiCi != null) {
			row.setComuneCpi(datiCi.getComune());
			row.setProvinciaCpi(datiCi.getProvincia());
		}

		log.info(buildMessage(getClass(), methodName, LOG_END));
		return row;
	}

	protected List<IscrittoTDisoccupatoEx> buildIscrittoTDisoccupatoEx(CondizioneOccupazionale condizioneOccupazionale, Long idCondizioneOccupazionale)
			throws ServiceException {

		final String methodName = "buildIscrittoTDisoccupatoEx";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		List<NonOccupato> nonOccupatoList = toList(condizioneOccupazionale.getDati().getNonOccupato());

		List<IscrittoTDisoccupatoEx> result = new ArrayList<>();
		if (CollectionUtils.isNotEmpty(nonOccupatoList)) {
			for (NonOccupato item : nonOccupatoList) {
				IscrittoTDisoccupatoEx row = new IscrittoTDisoccupatoEx();

				row.setIdCondizioneOccupazionale(idCondizioneOccupazionale);
				row.setAziendaPivaCf(item.getAzienda());
				row.setComuneLavoro(item.getComune());
				row.setIdDisoccupatoExLav(null);
				row.setIndirizzo(item.getIndirizzo());
				row.setLavoroAl(toDate(item.getDataFine()));
				row.setLavoroDal(toDate(item.getDataInizio()));

				result.add(row);
			}
		}

		log.info(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	protected IscrittoTStudente buildIscrittoTStudente(CondizioneOccupazionale condizioneOccupazionale, Long idCondizioneOccupazionale)
			throws DaoException, ServiceException {

		final String methodName = "buildIscrittoTStudente";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		Studente studente = condizioneOccupazionale.getDati().getStudente();
		IscrittoDTipoCorso tipoCorso = this.decodificaDao.findIscrittoDTipoCorsoByCod(studente.getCorso());

		IscrittoTStudente row = new IscrittoTStudente();
		row.setIdCondizioneOccupazionale(idCondizioneOccupazionale);
		row.setIndirizzo(studente.getIstituto());
		row.setIdTipoCorso(tipoCorso.getIdTipoCorso());

		log.info(buildMessage(getClass(), methodName, LOG_END));
		return row;
	}

	protected IscrittoTFratelloFre buildIscrittoTFratelloFre(Minore minore, Long idDomandaIscrizione, TipoSoggetto tipoSoggetto)
			throws DaoException, ServiceException {

		final String methodName = "buildIscrittoTFratelloFre";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		FratelloFrequentante fratelloFrequentante;
		switch (tipoSoggetto) {
			case MIN:
				fratelloFrequentante = minore.getFratelloFrequentante();
				break;
			default:
				throw new ServiceException();
		}

		if (fratelloFrequentante == null || !Boolean.TRUE.equals(fratelloFrequentante.getStato())) {
			return null;
		}

		Anagrafica anagrafica = fratelloFrequentante.getAnagrafica();
		IscrittoDTipoFra decTipoFra = this.decodificaDao.findIscrittoDTipoFraByCod(fratelloFrequentante.getTipo());

		IscrittoTStato cittadinanza = null;
		if (StringUtils.isNotBlank(anagrafica.getCodCittadinanza())) {
			cittadinanza = this.statoDao.findIscrittoTStatoByCod(new Date(), anagrafica.getCodCittadinanza());
		}

		IscrittoTFratelloFre row = new IscrittoTFratelloFre();
		row.setIdFratelloFrequentante(null);
		row.setIdDomandaIscrizione(idDomandaIscrizione);
		row.setCfFratello(anagrafica.getCodiceFiscale());
		row.setCognomeFratello(anagrafica.getCognome());
		row.setDtNascita(toDate(anagrafica.getDataNascita()));
		row.setIdTipoFratello(decTipoFra.getIdTipoFratello());
		row.setNomeFratello(anagrafica.getNome());
		row.setSesso(anagrafica.getSesso());
		row.setIdStatoCitt(cittadinanza == null ? null : cittadinanza.getIdStato());

		log.info(buildMessage(getClass(), methodName, LOG_END));
		return row;
	}

	protected IscrittoTTrasferimento buildIscrittoTTrasferimento(Minore minore, Long idDomandaIscrizione, TipoSoggetto tipoSoggetto)
			throws DaoException, ServiceException {

		final String methodName = "buildIscrittoTTrasferimento";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		Trasferimento trasferimento;
		switch (tipoSoggetto) {
			case MIN:
				trasferimento = minore.getTrasferimento();
				break;
			default:
				throw new ServiceException();
		}

		if (trasferimento == null || !Boolean.TRUE.equals(trasferimento.getStato())) {
			return null;
		}

		DatiTrasferimento datiTrasferimento = trasferimento.getDati();

		IscrittoTTrasferimento row = new IscrittoTTrasferimento();
		row.setDtCambioResidenza(toDate(datiTrasferimento.getData()));
		row.setFrequenzaAl(toDate(datiTrasferimento.getDataAl()));
		row.setFrequenzaDal(toDate(datiTrasferimento.getDataDal()));
		row.setIdDomandaIscrizione(idDomandaIscrizione);
		row.setIndirizzoNidoProv(datiTrasferimento.getIndirizzoNido());
		row.setIndirizzoResidenzaNew(datiTrasferimento.getIndirizzoNuovo());
		row.setIndirizzoResidenzaPre(datiTrasferimento.getIndirizzoVecchio());

		log.info(buildMessage(getClass(), methodName, LOG_END));
		return row;
	}

	protected IscrittoTCambioRes buildIscrittoTCambioRes(Minore minore, Long idDomandaIscrizione, TipoSoggetto tipoSoggetto)
			throws DaoException, ServiceException {

		final String methodName = "buildIscrittoTCambioRes";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		Spostamento spostamento;
		switch (tipoSoggetto) {
			case MIN:
				spostamento = minore.getSpostamento();
				break;
			default:
				throw new ServiceException();
		}

		if (spostamento == null || !Boolean.TRUE.equals(spostamento.getStato())) {
			return null;
		}

		DatiSpostamento datiSpostamento = spostamento.getDati();
		IscrittoDTipoCambioRes decTipoCambioRes = this.decodificaDao.findIscrittoDTipoCambioResByCod(datiSpostamento.getStato());

		TipoSpostamento tipoSpostamento = TipoSpostamento.findByCod(decTipoCambioRes.getCodTipoCambioRes());
		if (tipoSpostamento == null) {
			throw new ServiceException("tipo spostamento non riconosciuto");
		}

		IscrittoTCambioRes row = new IscrittoTCambioRes();
		row.setIdDomandaIscrizione(idDomandaIscrizione);
		row.setIdTipoCambioRes(decTipoCambioRes.getIdTipoCambioRes());

		switch (tipoSpostamento) {
			case VAR_RES:
				row.setDtVariazione(toDate(datiSpostamento.getDataVariazione()));
				row.setIndirizzo(datiSpostamento.getIndirizzo());
				break;
			case APP_VAR_RES:
				row.setDtAppuntamento(toDate(datiSpostamento.getDataAppuntamento()));
				row.setIndirizzo(datiSpostamento.getIndirizzo());
				break;
			case RES_FUT:
				row.setMotivazione(datiSpostamento.getResidenzaFutura());
				row.setIndirizzo(datiSpostamento.getIndirizzo());
				break;
			default:
				throw new ServiceException();
		}

		log.info(buildMessage(getClass(), methodName, LOG_END));
		return row;
	}

	protected IscrittoTAffido buildIscrittoTAffido(Long idAnagraficaSoggetto, Sentenza sentenza) throws ServiceException {
		final String methodName = "buildIscrittoTAffido";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		if (sentenza == null) {
			return null;
		}

		IscrittoTAffido row = new IscrittoTAffido();

		row.setComuneTribunale(sentenza.getTribunale());
		row.setDtSentenza(toDate(sentenza.getData()));
		row.setIdAnagraficaSoggetto(idAnagraficaSoggetto);
		row.setNumSentenza(sentenza.getNumero());

		log.info(buildMessage(getClass(), methodName, LOG_END));
		return row;
	}

	protected IscrittoTIsee buildIscrittoTIsee(Long idDomandaIscrizione, Isee isee) throws ServiceException {
		final String methodName = "buildIscrittoTIsee";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		if (isee == null || !Boolean.TRUE.equals(isee.getStato())) {
			return null;
		}

		DatiIsee datiIsee = isee.getDati();
		IscrittoTIsee row = new IscrittoTIsee();

		row.setDtSottoscrizione(toDate(datiIsee.getDataAttestazione()));
		row.setIdDomandaIscrizione(idDomandaIscrizione);
		row.setValoreIsee(datiIsee.getValore());

		log.info(buildMessage(getClass(), methodName, LOG_END));
		return row;
	}

	protected IscrittoTLogErroreDomanda buildIscrittoTLogErroreDomanda(String codiceFiscaleOperatore, String dettaglioErrore, String jsonDomanda)
			throws ServiceException {
		final String methodName = "buildIscrittoTLogErroreDomanda";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		IscrittoTLogErroreDomanda row = new IscrittoTLogErroreDomanda();
		row.setCodiceFiscaleOperatore(codiceFiscaleOperatore);
		row.setDettaglioErrore(dettaglioErrore);
		row.setJsonDomanda(jsonDomanda);

		log.info(buildMessage(getClass(), methodName, LOG_END));
		return row;
	}

	protected Long getIdParentela(String relazioneConMinore) throws DaoException {
		final String methodName = "getIdParentela";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		if (StringUtils.isBlank(relazioneConMinore)) {
			return null;
		}

		IscrittoDRelazionePar row = this.decodificaDao.findIscrittoDRelazioneParByCod(relazioneConMinore);
		if (row == null) {
			return null;
		}

		Long result = row.getIdRelParentela();

		log.info(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	protected Long getIdUtenteByCF(String codiceFiscale) throws DaoException, ServiceException {
		final String methodName = "getIdUtenteByCF";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		if (StringUtils.isBlank(codiceFiscale)) {
			return null;
		}

		IscrittoTUtente utente = this.utenteDao.findIscrittoTUtenteByCF(codiceFiscale);
		if (utente == null) {
			final String message = "codice fiscale utente non trovato";
			log.error(buildMessage(getClass(), methodName, message));

			throw new ServiceException(message);
		}

		Long result = utente.getIdUtente();

		log.info(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	protected SoggettoRow getSoggettoByCF(Long idDomandaIscrizione, String codiceFiscale) throws DaoException {
		final String methodName = "getSoggettoByCF";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		SoggettoRow result = null;
		List<SoggettoRow> rows = this.soggettoDao.findSoggettiByIdDomanda(idDomandaIscrizione);
		if (CollectionUtils.isNotEmpty(rows)) {
			for (SoggettoRow row : rows) {
				if (codiceFiscale.equalsIgnoreCase(row.getCodiceFiscale())) {
					result = row;
					break;
				}
			}
		}

		log.info(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

}
