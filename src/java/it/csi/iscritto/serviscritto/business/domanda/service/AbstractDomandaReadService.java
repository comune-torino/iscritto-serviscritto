package it.csi.iscritto.serviscritto.business.domanda.service;

import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.LOG_BEGIN;
import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.LOG_END;
import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.buildMessage;
import static it.csi.iscritto.serviscritto.business.util.converter.ConvertUtils.getFirst;
import static it.csi.iscritto.serviscritto.business.util.converter.ConvertUtils.toList;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.log4j.Logger;

import it.csi.iscritto.serviscritto.business.integration.converter.domande.CondizionePunteggioConverter;
import it.csi.iscritto.serviscritto.business.integration.converter.nido.AffidoConverter;
import it.csi.iscritto.serviscritto.business.integration.converter.nido.AltriComponentiConverter;
import it.csi.iscritto.serviscritto.business.integration.converter.nido.AnagraficaConverter;
import it.csi.iscritto.serviscritto.business.integration.converter.nido.AutonomoConverter;
import it.csi.iscritto.serviscritto.business.integration.converter.nido.ComponentiNucleoConverter;
import it.csi.iscritto.serviscritto.business.integration.converter.nido.CondizioneOccupazionaleConverter;
import it.csi.iscritto.serviscritto.business.integration.converter.nido.CondizioneSanitariaConverter;
import it.csi.iscritto.serviscritto.business.integration.converter.nido.DipendenteConverter;
import it.csi.iscritto.serviscritto.business.integration.converter.nido.DisoccupatoConverter;
import it.csi.iscritto.serviscritto.business.integration.converter.nido.FratelloFrequentanteConverter;
import it.csi.iscritto.serviscritto.business.integration.converter.nido.GenitoreSoloConverter;
import it.csi.iscritto.serviscritto.business.integration.converter.nido.IseeConverter;
import it.csi.iscritto.serviscritto.business.integration.converter.nido.LuogoNascitaConverter;
import it.csi.iscritto.serviscritto.business.integration.converter.nido.NonOccupatoConverter;
import it.csi.iscritto.serviscritto.business.integration.converter.nido.ResidenzaConverter;
import it.csi.iscritto.serviscritto.business.integration.converter.nido.RichiedenteConverter;
import it.csi.iscritto.serviscritto.business.integration.converter.nido.SentenzaConverter;
import it.csi.iscritto.serviscritto.business.integration.converter.nido.ServiziSocialiConverter;
import it.csi.iscritto.serviscritto.business.integration.converter.nido.Soggetto1Converter;
import it.csi.iscritto.serviscritto.business.integration.converter.nido.Soggetto2Converter;
import it.csi.iscritto.serviscritto.business.integration.converter.nido.Soggetto3Converter;
import it.csi.iscritto.serviscritto.business.integration.converter.nido.SoggettoAffidoConverter;
import it.csi.iscritto.serviscritto.business.integration.converter.nido.SoggettoAltroComponenteConverter;
import it.csi.iscritto.serviscritto.business.integration.converter.nido.SoggettoNucleoConverter;
import it.csi.iscritto.serviscritto.business.integration.converter.nido.SpostamentoConverter;
import it.csi.iscritto.serviscritto.business.integration.converter.nido.StudenteConverter;
import it.csi.iscritto.serviscritto.business.integration.converter.nido.TrasferimentoConverter;
import it.csi.iscritto.serviscritto.business.integration.dao.TipoCondizioneOccupazionale;
import it.csi.iscritto.serviscritto.business.integration.dao.TipoSoggetto;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoDTipConOcc;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoDTipoAll;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTAffido;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTCambioRes;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTCondizioneOcc;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTDisoccupato;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTDomandaIsc;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTFratelloFre;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTGenitoreSolo;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTIndirizzoRes;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTIsee;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTServiziSoc;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTStudente;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTTrasferimento;
import it.csi.iscritto.serviscritto.business.integration.dao.view.dto.CondizionePunteggioRow;
import it.csi.iscritto.serviscritto.business.integration.dao.view.dto.SoggettoRow;
import it.csi.iscritto.serviscritto.business.integration.exception.DaoException;
import it.csi.iscritto.serviscritto.business.integration.exception.ServiceException;
import it.csi.iscritto.serviscritto.business.util.Constants;
import it.csi.iscritto.serviscritto.dto.domanda.Affido;
import it.csi.iscritto.serviscritto.dto.domanda.AltriComponenti;
import it.csi.iscritto.serviscritto.dto.domanda.Anagrafica;
import it.csi.iscritto.serviscritto.dto.domanda.Autonomo;
import it.csi.iscritto.serviscritto.dto.domanda.ComponentiNucleo;
import it.csi.iscritto.serviscritto.dto.domanda.CondizioneOccupazionale;
import it.csi.iscritto.serviscritto.dto.domanda.CondizionePunteggio;
import it.csi.iscritto.serviscritto.dto.domanda.CondizioneSanitaria;
import it.csi.iscritto.serviscritto.dto.domanda.DatiCondizioneOccupazionale;
import it.csi.iscritto.serviscritto.dto.domanda.Dipendente;
import it.csi.iscritto.serviscritto.dto.domanda.Disoccupato;
import it.csi.iscritto.serviscritto.dto.domanda.FratelloFrequentante;
import it.csi.iscritto.serviscritto.dto.domanda.GenitoreSolo;
import it.csi.iscritto.serviscritto.dto.domanda.Isee;
import it.csi.iscritto.serviscritto.dto.domanda.LuogoNascita;
import it.csi.iscritto.serviscritto.dto.domanda.Minore;
import it.csi.iscritto.serviscritto.dto.domanda.NonOccupato;
import it.csi.iscritto.serviscritto.dto.domanda.Residenza;
import it.csi.iscritto.serviscritto.dto.domanda.Richiedente;
import it.csi.iscritto.serviscritto.dto.domanda.Sentenza;
import it.csi.iscritto.serviscritto.dto.domanda.ServiziSociali;
import it.csi.iscritto.serviscritto.dto.domanda.Soggetto1;
import it.csi.iscritto.serviscritto.dto.domanda.Soggetto2;
import it.csi.iscritto.serviscritto.dto.domanda.Soggetto3;
import it.csi.iscritto.serviscritto.dto.domanda.SoggettoAffido;
import it.csi.iscritto.serviscritto.dto.domanda.SoggettoAltroComponente;
import it.csi.iscritto.serviscritto.dto.domanda.SoggettoNucleo;
import it.csi.iscritto.serviscritto.dto.domanda.Spostamento;
import it.csi.iscritto.serviscritto.dto.domanda.Studente;
import it.csi.iscritto.serviscritto.dto.domanda.Trasferimento;

public abstract class AbstractDomandaReadService extends AbstractDomandaService {
	private static final Logger log = Logger.getLogger(Constants.COMPONENT_NAME + ".business");

	protected abstract Minore getMinore(IscrittoTDomandaIsc domandaIsc) throws DaoException, ServiceException;

	protected Richiedente getRichiedente(IscrittoTDomandaIsc domandaIsc) throws DaoException, ServiceException {
		final String methodName = "getRichiedente";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		Long idDomandaIscrizione = domandaIsc.getIdDomandaIscrizione();
		SoggettoRow richiedente = getFirst(this.soggettoDao.findSoggettiByIdDomanda(idDomandaIscrizione, TipoSoggetto.RIC));
		if (richiedente == null) {
			throw new ServiceException();
		}

		RichiedenteConverter.Data data = new RichiedenteConverter.Data();
		data.setDomandaIsc(domandaIsc);
		data.setSoggetto(richiedente);
		data.setDecCoabitazione(this.decodificaDao.findIscrittoDCoabitazioneByKey(domandaIsc.getIdCoabitazione()));
		data.setDecRelazionePar(this.decodificaDao.findIscrittoDRelazioneParByKey(richiedente.getIdRelParentela()));
		data.setTrasferimento(this.trasferimentoDao.findIscrittoTTrasferimentoByFk(idDomandaIscrizione));

		data.setAnagrafica(this.getAnagrafica(richiedente));
		data.setLuogoNascita(this.getLuogoNascita(richiedente));
		data.setResidenza(this.getResidenza(richiedente));

		Richiedente result = new RichiedenteConverter().convert(data);

		log.info(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	protected Soggetto1 getSoggetto1(IscrittoTDomandaIsc domandaIsc) throws DaoException {
		final String methodName = "getSoggetto1";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		Long idDomandaIscrizione = domandaIsc.getIdDomandaIscrizione();
		SoggettoRow soggetto = getFirst(this.soggettoDao.findSoggettiByIdDomanda(idDomandaIscrizione, TipoSoggetto.SOG1));
		if (soggetto == null) {
			return Soggetto1Converter.buildEmpty();
		}

		Soggetto1Converter.Data data = new Soggetto1Converter.Data();
		data.setSoggetto(soggetto);
		data.setAnagrafica(this.getAnagrafica(soggetto));
		data.setLuogoNascita(this.getLuogoNascita(soggetto));
		data.setResidenza(this.getResidenza(soggetto));
		data.setCondizioneOccupazionale(this.getCondizioneOccupazionale(soggetto));
		data.setGenitoreSolo(this.getGenitoreSolo(soggetto));

		CondizioneSanitaria cs = this.getCondizioneSanitaria(soggetto);
		data.setGravidanza(cs.getGravidanza());
		data.setProblemiSalute(cs.getProblemiSalute());

		Soggetto1 result = new Soggetto1Converter().convert(data);

		log.info(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	protected Soggetto2 getSoggetto2(IscrittoTDomandaIsc domandaIsc) throws DaoException {
		final String methodName = "getSoggetto2";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		Long idDomandaIscrizione = domandaIsc.getIdDomandaIscrizione();
		SoggettoRow soggetto = getFirst(this.soggettoDao.findSoggettiByIdDomanda(idDomandaIscrizione, TipoSoggetto.SOG2));
		if (soggetto == null) {
			return Soggetto2Converter.buildEmpty();
		}

		Soggetto2Converter.Data data = new Soggetto2Converter.Data();
		data.setDomandaIsc(domandaIsc);
		data.setSoggetto(soggetto);
		data.setAnagrafica(this.getAnagrafica(soggetto));
		data.setLuogoNascita(this.getLuogoNascita(soggetto));
		data.setResidenza(this.getResidenza(soggetto));
		data.setCondizioneOccupazionale(this.getCondizioneOccupazionale(soggetto));

		CondizioneSanitaria cs = this.getCondizioneSanitaria(soggetto);
		data.setGravidanza(cs.getGravidanza());
		data.setProblemiSalute(cs.getProblemiSalute());

		Soggetto2 result = new Soggetto2Converter().convert(data);

		log.info(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	protected Soggetto3 getSoggetto3(IscrittoTDomandaIsc domandaIsc) throws DaoException {
		final String methodName = "getSoggetto3";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		Long idDomandaIscrizione = domandaIsc.getIdDomandaIscrizione();
		SoggettoRow soggetto = getFirst(this.soggettoDao.findSoggettiByIdDomanda(idDomandaIscrizione, TipoSoggetto.SOG3));
		if (soggetto == null) {
			return Soggetto3Converter.buildEmpty(domandaIsc);
		}

		Soggetto3Converter.Data data = new Soggetto3Converter.Data();
		data.setDomandaIsc(domandaIsc);
		data.setSoggetto(soggetto);
		data.setAnagrafica(this.getAnagrafica(soggetto));
		data.setLuogoNascita(this.getLuogoNascita(soggetto));
		data.setResidenza(this.getResidenza(soggetto));

		Soggetto3 result = new Soggetto3Converter().convert(data);

		log.info(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	protected ComponentiNucleo getComponentiNucleo(IscrittoTDomandaIsc domandaIsc) throws DaoException {
		final String methodName = "getComponentiNucleo";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		Long idDomandaIscrizione = domandaIsc.getIdDomandaIscrizione();
		List<SoggettoRow> rows = this.soggettoDao.findSoggettiByIdDomanda(idDomandaIscrizione, TipoSoggetto.CMP_NUC);
		if (CollectionUtils.isEmpty(rows)) {
			return ComponentiNucleoConverter.buildEmpty();
		}

		List<SoggettoNucleo> soggetti = new ArrayList<>();
		for (SoggettoRow row : rows) {
			SoggettoNucleoConverter.Data data = new SoggettoNucleoConverter.Data();
			data.setAnagrafica(this.getAnagrafica(row));
			data.setDecRelazionePar(this.decodificaDao.findIscrittoDRelazioneParByKey(row.getIdRelParentela()));
			data.setLuogoNascita(this.getLuogoNascita(row));
			data.setProblemiSalute(this.getCondizioneSanitaria(row).getProblemiSalute());
			data.setSoggetto(row);

			soggetti.add(new SoggettoNucleoConverter().convert(data));
		}

		ComponentiNucleoConverter.Data data = new ComponentiNucleoConverter.Data();
		data.setSoggetti(soggetti);

		ComponentiNucleo result = new ComponentiNucleoConverter().convert(data);

		log.info(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	protected AltriComponenti getAltriComponenti(IscrittoTDomandaIsc domandaIsc) throws DaoException {
		final String methodName = "getAltriComponenti";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		Long idDomandaIscrizione = domandaIsc.getIdDomandaIscrizione();
		List<SoggettoRow> rows = this.soggettoDao.findSoggettiByIdDomanda(idDomandaIscrizione, TipoSoggetto.ALT_CMP);
		if (CollectionUtils.isEmpty(rows)) {
			return AltriComponentiConverter.buildEmpty();
		}

		List<SoggettoAltroComponente> soggetti = new ArrayList<>();
		for (SoggettoRow row : rows) {
			SoggettoAltroComponenteConverter.Data data = new SoggettoAltroComponenteConverter.Data();
			data.setAnagrafica(this.getAnagrafica(row));
			data.setDecRelazionePar(this.decodificaDao.findIscrittoDRelazioneParByKey(row.getIdRelParentela()));
			data.setLuogoNascita(this.getLuogoNascita(row));
			data.setProblemiSalute(this.getCondizioneSanitaria(row).getProblemiSalute());
			data.setResidenza(this.getResidenza(row));
			data.setSoggetto(row);

			soggetti.add(new SoggettoAltroComponenteConverter().convert(data));
		}

		AltriComponentiConverter.Data data = new AltriComponentiConverter.Data();
		data.setDomandaIsc(domandaIsc);
		data.setSoggetti(soggetti);

		AltriComponenti result = new AltriComponentiConverter().convert(data);

		log.info(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	protected Affido getAffido(IscrittoTDomandaIsc domandaIsc) throws DaoException {
		final String methodName = "getAffido";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		Long idDomandaIscrizione = domandaIsc.getIdDomandaIscrizione();
		List<SoggettoRow> rows = this.soggettoDao.findSoggettiByIdDomanda(idDomandaIscrizione, TipoSoggetto.AFF);
		if (CollectionUtils.isEmpty(rows)) {
			return AffidoConverter.buildEmpty();
		}

		List<SoggettoAffido> soggetti = new ArrayList<>();
		for (SoggettoRow row : rows) {
			SoggettoAffidoConverter.Data data = new SoggettoAffidoConverter.Data();
			data.setAnagrafica(this.getAnagrafica(row));
			data.setDecRelazionePar(this.decodificaDao.findIscrittoDRelazioneParByKey(row.getIdRelParentela()));
			data.setLuogoNascita(this.getLuogoNascita(row));
			data.setProblemiSalute(this.getCondizioneSanitaria(row).getProblemiSalute());
			data.setResidenza(this.getResidenza(row));
			data.setSentenza(this.getSentenza(row));
			data.setSoggetto(row);

			soggetti.add(new SoggettoAffidoConverter().convert(data));
		}

		AffidoConverter.Data data = new AffidoConverter.Data();
		data.setDomandaIsc(domandaIsc);
		data.setSoggetti(soggetti);

		Affido result = new AffidoConverter().convert(data);

		log.info(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	protected Isee getIsee(IscrittoTDomandaIsc domandaIsc) throws DaoException {
		final String methodName = "getIsee";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		Long idDomandaIscrizione = domandaIsc.getIdDomandaIscrizione();
		IscrittoTIsee isee = this.iseeDao.findIscrittoTIseeByFk(idDomandaIscrizione);
		if (isee == null) {
			return IseeConverter.buildEmpty();
		}

		IseeConverter.Data data = new IseeConverter.Data();
		data.setDomandaIsc(domandaIsc);
		data.setIsee(isee);

		Isee result = new IseeConverter().convert(data);

		log.info(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	protected List<CondizionePunteggio> getCondizioniPunteggio(IscrittoTDomandaIsc domandaIsc) throws DaoException {
		final String methodName = "getCondizioniPunteggio";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		Long idDomandaIscrizione = domandaIsc.getIdDomandaIscrizione();
		List<CondizionePunteggio> condizioniPunteggioDTO = new ArrayList<CondizionePunteggio>();

		List<CondizionePunteggioRow> condizioniPunteggio = this.domandaDao.findCondizioniPunteggio(idDomandaIscrizione);
		for (CondizionePunteggioRow row : condizioniPunteggio) {
			CondizionePunteggioConverter.Data data = new CondizionePunteggioConverter.Data();
			if (row.getIdUtente() != null) {
				data.setUtente(this.utenteDao.findIscrittoTUtenteByPk(row.getIdUtente()));
			}
			data.setCondizionePunteggioDecodifica(this.condizionePunteggioDao.findIscrittoDCondizionePunByPk(row.getIdCondizionePunteggio()));
			data.setCondizionePunteggioDomanda(row);

			condizioniPunteggioDTO.add(new CondizionePunteggioConverter().convert(data));
		}

		log.info(buildMessage(getClass(), methodName, LOG_END));
		return condizioniPunteggioDTO;
	}

	protected List<String> getFlIrc(IscrittoTDomandaIsc domandaIsc) throws DaoException {
		final String methodName = " getFlIrc";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		Long idDomandaIscrizione = domandaIsc.getIdDomandaIscrizione();
		//List<String> FlIrcDTO = new ArrayList<String>();

		List<String> FlIrc = this.domandaDao.findFlIrc(idDomandaIscrizione);
		log.info("^^101"+FlIrc);

		log.info(buildMessage(getClass(), methodName, LOG_END));
		return FlIrc;
	}



	//////////////////////////////////////////////////////////////////////

	protected Anagrafica getAnagrafica(SoggettoRow soggetto) {
		final String methodName = "getAnagrafica";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		Anagrafica result = new AnagraficaConverter().convert(soggetto);

		log.info(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	protected LuogoNascita getLuogoNascita(SoggettoRow soggetto) throws DaoException {
		final String methodName = "getLuogoNascita";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		LuogoNascitaConverter.Data data = new LuogoNascitaConverter.Data();
		data.setComune(this.comuneDao.findIscrittoTComuneByKey(soggetto.getIdComuneNascita()));
		data.setStato(this.statoDao.findIscrittoTStatoByKey(soggetto.getIdStatoNascita()));

		LuogoNascita result = new LuogoNascitaConverter().convert(data);

		log.info(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	protected Residenza getResidenza(SoggettoRow soggetto) throws DaoException {
		final String methodName = "getResidenza";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		IscrittoTIndirizzoRes indirizzoRes = this.indirizzoResDao.findIscrittoTIndirizzoResByFk(soggetto.getIdAnagraficaSoggetto());

		ResidenzaConverter.Data data = new ResidenzaConverter.Data();
		if (indirizzoRes != null) {
			data.setComune(this.comuneDao.findIscrittoTComuneByKey(indirizzoRes.getIdComune()));
			data.setStato(this.statoDao.findIscrittoTStatoByKey(indirizzoRes.getIdStatoResidenza()));
		}
		data.setIndirizzoRes(this.indirizzoResDao.findIscrittoTIndirizzoResByFk(soggetto.getIdAnagraficaSoggetto()));

		Residenza result = new ResidenzaConverter().convert(data);

		log.info(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	protected ServiziSociali getServiziSociali(IscrittoTDomandaIsc domandaIsc, SoggettoRow soggetto) throws DaoException {
		final String methodName = "getServiziSociali";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		Long idDomandaIscrizione = domandaIsc.getIdDomandaIscrizione();
		Long idAnagraficaSoggetto = soggetto.getIdAnagraficaSoggetto();

		IscrittoTServiziSoc serviziSoc = this.serviziSocDao.findIscrittoTServiziSocByFk(idDomandaIscrizione);
		List<IscrittoDTipoAll> tipologiaAll = this.decodificaDao.findAllIscrittoDTipoAll();

		ServiziSocialiConverter.Data data = new ServiziSocialiConverter.Data();
		data.setDomandaIsc(domandaIsc);
		data.setServiziSoc(serviziSoc);
		data.setAllegatoList(this.allegatoDao.findIscrittoTAllegatoByFk(idAnagraficaSoggetto));

		ServiziSociali result = new ServiziSocialiConverter(tipologiaAll).convert(data);

		log.info(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	protected FratelloFrequentante getFratelloFrequentante(IscrittoTDomandaIsc domandaIsc) throws DaoException {
		final String methodName = "getFratelloFrequentante";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		Long idDomandaIscrizione = domandaIsc.getIdDomandaIscrizione();
		IscrittoTFratelloFre fratelloFre = this.fratelloFreDao.findIscrittoTFratelloFreByFk(idDomandaIscrizione);

		FratelloFrequentanteConverter.Data data = new FratelloFrequentanteConverter.Data();
		data.setDomandaIsc(domandaIsc);
		if (fratelloFre != null) {
			data.setDecTipoFra(this.decodificaDao.findIscrittoDTipoFraByKey(fratelloFre.getIdTipoFratello()));
			data.setStato(this.statoDao.findIscrittoTStatoByKey(fratelloFre.getIdStatoCitt()));
			data.setFratelloFre(fratelloFre);
		}

		FratelloFrequentante result = new FratelloFrequentanteConverter().convert(data);

		log.info(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	protected Spostamento getSpostamento(IscrittoTDomandaIsc domandaIsc) throws DaoException {
		final String methodName = "getSpostamento";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		Long idDomandaIscrizione = domandaIsc.getIdDomandaIscrizione();
		IscrittoTCambioRes cambioRes = this.cambioResDao.findIscrittoTCambioResByFk(idDomandaIscrizione);

		SpostamentoConverter.Data data = new SpostamentoConverter.Data();
		if (cambioRes != null) {
			data.setCambioRes(cambioRes);
			data.setDecTipoCambioRes(this.decodificaDao.findIscrittoDTipoCambioResByKey(cambioRes.getIdTipoCambioRes()));
		}
		data.setDomandaIsc(domandaIsc);

		Spostamento result = new SpostamentoConverter().convert(data);

		log.info(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	protected Trasferimento getTrasferimento(IscrittoTDomandaIsc domandaIsc) throws DaoException {
		final String methodName = "getTrasferimento";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		Long idDomandaIscrizione = domandaIsc.getIdDomandaIscrizione();
		IscrittoTTrasferimento trasferimento = this.trasferimentoDao.findIscrittoTTrasferimentoByFk(idDomandaIscrizione);

		TrasferimentoConverter.Data data = new TrasferimentoConverter.Data();
		data.setDomandaIsc(domandaIsc);
		data.setTrasferimento(trasferimento);

		Trasferimento result = new TrasferimentoConverter().convert(data);

		log.info(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	protected GenitoreSolo getGenitoreSolo(SoggettoRow soggetto) throws DaoException {
		final String methodName = "getGenitoreSolo";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		Long idDomandaIscrizione = soggetto.getIdDomandaIscrizione();
		IscrittoTGenitoreSolo genitoreSolo = this.genitoreSoloDao.findIscrittoTGenitoreSoloByKey(idDomandaIscrizione);
		if (genitoreSolo == null) {
			return GenitoreSoloConverter.buildEmpty();
		}

		GenitoreSoloConverter.Data data = new GenitoreSoloConverter.Data();
		data.setGenitoreSolo(genitoreSolo);
		data.setDecGenitoreSol(this.decodificaDao.findIscrittoDGenitoreSolByKey(genitoreSolo.getIdTipoGenitoreSolo()));

		GenitoreSolo result = new GenitoreSoloConverter().convert(data);

		log.info(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	protected Sentenza getSentenza(SoggettoRow soggetto) throws DaoException {
		final String methodName = "getSentenza";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		IscrittoTAffido affido = this.affidoDao.findIscrittoTAffidoByFk(soggetto.getIdAnagraficaSoggetto());
		if (affido == null) {
			return SentenzaConverter.buildEmpty();
		}

		Sentenza result = new SentenzaConverter().convert(affido);

		log.info(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	protected CondizioneSanitaria getCondizioneSanitaria(SoggettoRow soggetto) throws DaoException {
		final String methodName = "getCondizioneSanitaria";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		Long idAnagraficaSoggetto = soggetto.getIdAnagraficaSoggetto();
		List<IscrittoDTipoAll> tipologiaAll = this.decodificaDao.findAllIscrittoDTipoAll();

		CondizioneSanitariaConverter.Data data = new CondizioneSanitariaConverter.Data();
		data.setAllegatoList(this.allegatoDao.findIscrittoTAllegatoByFk(idAnagraficaSoggetto));
		data.setCondizioneSan(this.condizioneSanDao.findIscrittoTCondizioneSanByFk(idAnagraficaSoggetto));

		CondizioneSanitaria result = new CondizioneSanitariaConverter(tipologiaAll).convert(data);

		log.info(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	protected CondizioneOccupazionale getCondizioneOccupazionale(SoggettoRow soggetto) throws DaoException {
		final String methodName = "getCondizioneOccupazionale";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		IscrittoTCondizioneOcc condizioneOcc = this.condizioneOccDao.findCondizioneOccByFk(soggetto.getIdAnagraficaSoggetto());
		if (condizioneOcc == null) {
			return CondizioneOccupazionaleConverter.buildEmpty();
		}

		IscrittoDTipConOcc decTipConOcc = this.decodificaDao.findIscrittoDTipConOccByKey(condizioneOcc.getIdTipCondOccupazionale());
		TipoCondizioneOccupazionale tipCondOcc = TipoCondizioneOccupazionale.findByCod(decTipConOcc.getCodTipCondOccupazionale());
		DatiCondizioneOccupazionale template = CondizioneOccupazionaleConverter.buildEmpty().getDati();

		CondizioneOccupazionaleConverter.Data data = new CondizioneOccupazionaleConverter.Data();
		data.setDecCondizioneOcc(decTipConOcc);
		data.setAutonomo(template.getAutonomo());
		data.setDipendente(template.getDipendente());
		data.setDisoccupato(template.getDisoccupato());
		data.setNonOccupatoList(toList(template.getNonOccupato()));
		data.setStudente(template.getStudente());

		switch (tipCondOcc) {
			case AUT:
				data.setAutonomo(this.getAutonomo(condizioneOcc));
				break;
			case DIP:
				data.setDipendente(this.getDipendente(condizioneOcc));
				break;
			case DIS:
				data.setDisoccupato(this.getDisoccupato(condizioneOcc));
				break;
			case DIS_LAV:
				data.setNonOccupatoList(this.getNonOccupatoList(condizioneOcc));
				break;
			case STU:
				data.setStudente(this.getStudente(condizioneOcc));
				break;
			case NO_COND:
				break;
			default:
				break;
		}

		CondizioneOccupazionale result = new CondizioneOccupazionaleConverter().convert(data);

		log.info(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	protected Autonomo getAutonomo(IscrittoTCondizioneOcc condizioneOcc) throws DaoException {
		final String methodName = "getAutonomo";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		Autonomo result = new AutonomoConverter().convert(this.autonomoDao.findAutonomoByKey(condizioneOcc.getIdCondizioneOccupazionale()));

		log.info(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	protected Dipendente getDipendente(IscrittoTCondizioneOcc condizioneOcc) throws DaoException {
		final String methodName = "getDipendente";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		Dipendente result = new DipendenteConverter().convert(this.dipendenteDao.findDipendenteByKey(condizioneOcc.getIdCondizioneOccupazionale()));

		log.info(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	protected Disoccupato getDisoccupato(IscrittoTCondizioneOcc condizioneOcc) throws DaoException {
		final String methodName = "getDisoccupato";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		IscrittoTDisoccupato disoccupato = this.disoccupatoDao.findDisoccupatoByKey(condizioneOcc.getIdCondizioneOccupazionale());

		DisoccupatoConverter.Data data = new DisoccupatoConverter.Data();
		data.setDisoccupato(disoccupato);
		if (disoccupato != null) {
			data.setDecTipoPre(this.decodificaDao.findIscrittoDTipoPreByKey(disoccupato.getIdTipoPresentazione()));
		}

		Disoccupato result = new DisoccupatoConverter().convert(data);

		log.info(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	protected List<NonOccupato> getNonOccupatoList(IscrittoTCondizioneOcc condizioneOcc) throws DaoException {
		final String methodName = "getNonOccupatoList";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		List<NonOccupato> result = new NonOccupatoConverter().convertAll(
				this.disoccupatoExDao.findDisoccupatoExByFk(condizioneOcc.getIdCondizioneOccupazionale()));

		log.info(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	protected Studente getStudente(IscrittoTCondizioneOcc condizioneOcc) throws DaoException {
		final String methodName = "getStudente";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		IscrittoTStudente studente = this.studenteDao.findStudenteByKey(condizioneOcc.getIdCondizioneOccupazionale());

		StudenteConverter.Data data = new StudenteConverter.Data();
		data.setStudente(studente);
		if (studente != null) {
			data.setDecTipoCorso(this.decodificaDao.findIscrittoDTipoCorsoByKey(studente.getIdTipoCorso()));
		}

		Studente result = new StudenteConverter().convert(data);

		log.info(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

}
