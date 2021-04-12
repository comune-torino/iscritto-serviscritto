package it.csi.iscritto.serviscritto.business.domanda.service;

import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.LOG_BEGIN;
import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.LOG_END;
import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.LOG_ERROR;
import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.buildMessage;
import static it.csi.iscritto.serviscritto.business.util.converter.ConvertUtils.getFirst;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.log4j.Logger;

import it.csi.iscritto.serviscritto.business.integration.converter.materna.DomandaMaternaConverter;
import it.csi.iscritto.serviscritto.business.integration.converter.materna.FratelloNidoContiguoConverter;
import it.csi.iscritto.serviscritto.business.integration.converter.materna.ListaAttesaConverter;
import it.csi.iscritto.serviscritto.business.integration.converter.materna.MaternaConverter;
import it.csi.iscritto.serviscritto.business.integration.converter.nido.MinoreConverter;
import it.csi.iscritto.serviscritto.business.integration.dao.TipoSoggetto;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoRListaAttesa;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoRNidoContiguo;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoRScuolaPre;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTAnnoSco;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTDomandaIsc;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTScuola;
import it.csi.iscritto.serviscritto.business.integration.dao.view.dto.SoggettoRow;
import it.csi.iscritto.serviscritto.business.integration.exception.DaoException;
import it.csi.iscritto.serviscritto.business.integration.exception.ServiceException;
import it.csi.iscritto.serviscritto.business.util.Constants;
import it.csi.iscritto.serviscritto.dto.domanda.CondizioneSanitaria;
import it.csi.iscritto.serviscritto.dto.domanda.DatiAnnoListaAttesa;
import it.csi.iscritto.serviscritto.dto.domanda.DomandaMaterna;
import it.csi.iscritto.serviscritto.dto.domanda.FratelloNidoContiguo;
import it.csi.iscritto.serviscritto.dto.domanda.ListaAttesa;
import it.csi.iscritto.serviscritto.dto.domanda.Materna;
import it.csi.iscritto.serviscritto.dto.domanda.Minore;

public class DomandaMaternaReadService extends AbstractDomandaReadService {
	private static final Logger log = Logger.getLogger(Constants.COMPONENT_NAME + ".business");

	public DomandaMaterna readDomandaMaterna(Long idDomandaIscrizione) throws ServiceException {
		final String methodName = "readDomandaMaterna";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		DomandaMaterna result;
		try {
			result = this.getDatiDomandaIscrizioneById(idDomandaIscrizione);
		}
		catch (Exception e) {
			log.error(buildMessage(getClass(), methodName, "errore nella lettura della domanda: " + idDomandaIscrizione));
			log.error(buildMessage(getClass(), methodName, LOG_ERROR), e);
			throw new ServiceException(e);
		}

		log.info(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	public List<Materna> getElencoMaterne(Long idDomandaIscrizione) throws ServiceException {
		final String methodName = "getElencoMaterne";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		List<Materna> result;
		try {
			IscrittoTDomandaIsc dto = new IscrittoTDomandaIsc();
			dto.setIdDomandaIscrizione(idDomandaIscrizione);

			result = this.getElencoMaterne(dto);
		}
		catch (Exception e) {
			log.error(buildMessage(getClass(), methodName, LOG_ERROR), e);
			throw new ServiceException(e);
		}

		log.info(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	//////////////////////////////////////////////////////////////////////

	@Override
	protected Minore getMinore(IscrittoTDomandaIsc domandaIsc) throws DaoException, ServiceException {
		final String methodName = "getMinore";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		Long idDomandaIscrizione = domandaIsc.getIdDomandaIscrizione();
		SoggettoRow minore = getFirst(this.soggettoDao.findSoggettiByIdDomanda(idDomandaIscrizione, TipoSoggetto.MIN));
		if (minore == null) {
			throw new ServiceException();
		}

		MinoreConverter.Data data = new MinoreConverter.Data();
		data.setDomandaIsc(domandaIsc);
		data.setSoggetto(minore);
		data.setAnagrafica(this.getAnagrafica(minore));
		data.setLuogoNascita(this.getLuogoNascita(minore));
		data.setResidenza(this.getResidenza(minore));
		data.setServiziSociali(this.getServiziSociali(domandaIsc, minore));
		data.setFratelloFrequentante(this.getFratelloFrequentante(domandaIsc));
		data.setTrasferimento(this.getTrasferimento(domandaIsc));
		data.setSpostamento(this.getSpostamento(domandaIsc));
		data.setListaAttesa(this.getListaAttesa(domandaIsc));
		data.setFratelloNidoContiguo(this.getFratelloNidoContiguo(domandaIsc));

		CondizioneSanitaria cs = this.getCondizioneSanitaria(minore);
		data.setDisabilita(cs.getDisabilita());
		data.setProblemiSalute(cs.getProblemiSalute());

		Minore result = new MinoreConverter().convert(data);

		log.info(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	//////////////////////////////////////////////////////////////////////

	private DomandaMaterna getDatiDomandaIscrizioneById(Long idDomandaIscrizione) throws DaoException, ServiceException {
		final String methodName = "getDatiDomandaIscrizioneById";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		IscrittoTDomandaIsc domandaIsc = this.domandaIscDao.findIscrittoTDomandaIscByKey(idDomandaIscrizione);
		if (domandaIsc == null) {
			return null;
		}

		DomandaMaternaConverter.Data data = new DomandaMaternaConverter.Data();
		data.setDomandaIsc(domandaIsc);
		data.setDecStatoDom(this.decodificaDao.findIscrittoDStatoDomByKey(domandaIsc.getIdStatoDom()));
		data.setDecOrdineScuola(this.decodificaDao.findIscrittoDOrdineScuolaByKey(domandaIsc.getIdOrdineScuola()));
		data.setAnnoSco(this.annoScoDao.findIscrittoTAnnoScoByKey(domandaIsc.getIdAnnoScolastico()));
		data.setRichiedente(this.getRichiedente(domandaIsc));
		data.setMinore(this.getMinore(domandaIsc));
		data.setSoggetto1(this.getSoggetto1(domandaIsc));
		data.setSoggetto2(this.getSoggetto2(domandaIsc));
		data.setSoggetto3(this.getSoggetto3(domandaIsc));
		data.setComponentiNucleo(this.getComponentiNucleo(domandaIsc));
		data.setAltriComponenti(this.getAltriComponenti(domandaIsc));
		data.setAffido(this.getAffido(domandaIsc));
		data.setIsee(this.getIsee(domandaIsc));
		data.setElencoMaterne(this.getElencoMaterne(domandaIsc));
		data.setCondizioniPunteggio(this.getCondizioniPunteggio(domandaIsc));
		data.setFlIrc(domandaIsc.getFlIrc());

		if (domandaIsc.getIdUtenteIns() != null) {
			data.setUtenteIns(this.utenteDao.findIscrittoTUtenteByPk(domandaIsc.getIdUtenteIns()));
		}

		if (domandaIsc.getIdUtenteMod() != null) {
			data.setUtenteMod(this.utenteDao.findIscrittoTUtenteByPk(domandaIsc.getIdUtenteMod()));
		}

		DomandaMaterna result = new DomandaMaternaConverter().convert(data);

		log.info(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}



	private List<Materna> getElencoMaterne(IscrittoTDomandaIsc domandaIsc) throws DaoException {
		final String methodName = "getElencoMaterne";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		Long idDomandaIscrizione = domandaIsc.getIdDomandaIscrizione();
		List<IscrittoRScuolaPre> rows = this.scuolaDao.findIscrittoRScuolaPreByFk(idDomandaIscrizione);
		if (CollectionUtils.isEmpty(rows)) {
			return MaternaConverter.buildEmptyList();
		}

		List<Materna> materne = new ArrayList<>();
		for (IscrittoRScuolaPre row : rows) {
			IscrittoTScuola iscrittoTScuola = this.scuolaDao.findIscrittoTScuolaByKey(row.getIdScuola());

			MaternaConverter.Data data = new MaternaConverter.Data();
			data.setDecCategoriaScu(this.decodificaDao.findIscrittoDCategoriaScuByKey(iscrittoTScuola.getIdCategoriaScu()));
			data.setDecCircoscrizione(this.decodificaDao.findIscrittoDCircoscrizioneByKey(iscrittoTScuola.getIdCircoscrizione()));
			data.setDecTipoFre(this.decodificaDao.findIscrittoDTipoFreByKey(row.getIdTipoFrequenza()));
			if (row.getIdStatoScu() != null) {
				data.setDecStatoScu(this.decodificaDao.findIscrittoDStatoScuByKey(row.getIdStatoScu()));
			}
			data.setRow(row);
			data.setScuola(iscrittoTScuola);
			if (iscrittoTScuola.getIdNidoContiguo() != null) {
				data.setNidoContiguo(this.scuolaDao.findIscrittoTScuolaByKey(iscrittoTScuola.getIdNidoContiguo()));
			}

			materne.add(new MaternaConverter().convert(data));
		}

		log.info(buildMessage(getClass(), methodName, LOG_END));
		return materne;
	}

	private ListaAttesa getListaAttesa(IscrittoTDomandaIsc domandaIsc) throws DaoException {
		final String methodName = "getListaAttesa";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		Long idDomandaIscrizione = domandaIsc.getIdDomandaIscrizione();
		List<IscrittoRListaAttesa> rows = this.listaAttesaDao.findIscrittoRListaAttesaByIdDomanda(idDomandaIscrizione);

		List<DatiAnnoListaAttesa> anniListaAttesa = new ArrayList<>();
		if (CollectionUtils.isNotEmpty(rows)) {
			for (IscrittoRListaAttesa row : rows) {
				IscrittoTAnnoSco annoSco = this.annoScoDao.findIscrittoTAnnoScoByKey(row.getIdAnnoScolastico());

				DatiAnnoListaAttesa dati = new DatiAnnoListaAttesa();
				dati.setAnnoScolastico(annoSco.getCodAnnoScolastico());
				dati.setScuola(row.getScuolaLista());

				anniListaAttesa.add(dati);
			}
		}

		ListaAttesaConverter.Data data = new ListaAttesaConverter.Data();
		data.setDomandaIsc(domandaIsc);
		data.setAnniListaAttesa(anniListaAttesa);

		ListaAttesa result = new ListaAttesaConverter().convert(data);

		log.info(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	private FratelloNidoContiguo getFratelloNidoContiguo(IscrittoTDomandaIsc domandaIsc) throws DaoException {
		final String methodName = "getFratelloNidoContiguo";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		Long idDomandaIscrizione = domandaIsc.getIdDomandaIscrizione();

		FratelloNidoContiguoConverter.Data data = new FratelloNidoContiguoConverter.Data();
		data.setDomandaIsc(domandaIsc);

		IscrittoRNidoContiguo nidoContiguo = this.fratelloFreDao.findIscrittoRNidoContiguoByIdDomanda(idDomandaIscrizione);
		if (nidoContiguo != null) {
			SoggettoRow sog = getFirst(this.soggettoDao.findSoggettiByIdSoggetto(nidoContiguo.getIdAnagraficaSoggetto()));
			if (sog != null) {
				data.setAnagrafica(this.getAnagrafica(sog));
			}

			if (nidoContiguo.getIdNidoContiguo() != null) {
				data.setNidoContiguo(this.scuolaDao.findIscrittoTScuolaByKey(nidoContiguo.getIdNidoContiguo()));
			}
		}

		FratelloNidoContiguo result = new FratelloNidoContiguoConverter().convert(data);

		log.info(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

}
