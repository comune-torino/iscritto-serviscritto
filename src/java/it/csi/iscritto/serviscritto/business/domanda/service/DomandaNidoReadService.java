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

import it.csi.iscritto.serviscritto.business.integration.converter.nido.DomandaNidoConverter;
import it.csi.iscritto.serviscritto.business.integration.converter.nido.MinoreConverter;
import it.csi.iscritto.serviscritto.business.integration.converter.nido.NidoConverter;
import it.csi.iscritto.serviscritto.business.integration.dao.TipoSoggetto;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoRScuolaPre;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTDomandaIsc;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTScuola;
import it.csi.iscritto.serviscritto.business.integration.dao.view.dto.SoggettoRow;
import it.csi.iscritto.serviscritto.business.integration.exception.DaoException;
import it.csi.iscritto.serviscritto.business.integration.exception.ServiceException;
import it.csi.iscritto.serviscritto.business.util.Constants;
import it.csi.iscritto.serviscritto.dto.domanda.CondizioneSanitaria;
import it.csi.iscritto.serviscritto.dto.domanda.DomandaNido;
import it.csi.iscritto.serviscritto.dto.domanda.Minore;
import it.csi.iscritto.serviscritto.dto.domanda.Nido;

public class DomandaNidoReadService extends AbstractDomandaReadService {
	private static final Logger log = Logger.getLogger(Constants.COMPONENT_NAME + ".business");

	public DomandaNido readDomandaNido(Long idDomandaIscrizione) throws ServiceException {
		final String methodName = "readDomandaNido";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		DomandaNido result;
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

	public List<Nido> getElencoNidi(Long idDomandaIscrizione) throws ServiceException {
		final String methodName = "getElencoNidi";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		List<Nido> result;
		try {
			IscrittoTDomandaIsc dto = new IscrittoTDomandaIsc();
			dto.setIdDomandaIscrizione(idDomandaIscrizione);

			result = this.getElencoNidi(dto);
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

		CondizioneSanitaria cs = this.getCondizioneSanitaria(minore);
		data.setDisabilita(cs.getDisabilita());
		data.setProblemiSalute(cs.getProblemiSalute());

		Minore result = new MinoreConverter().convert(data);

		log.info(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	//////////////////////////////////////////////////////////////////////

	private DomandaNido getDatiDomandaIscrizioneById(Long idDomandaIscrizione) throws DaoException, ServiceException {
		final String methodName = "getDatiDomandaIscrizioneById";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		IscrittoTDomandaIsc domandaIsc = this.domandaIscDao.findIscrittoTDomandaIscByKey(idDomandaIscrizione);
		if (domandaIsc == null) {
			return null;
		}

		DomandaNidoConverter.Data data = new DomandaNidoConverter.Data();
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
		data.setElencoNidi(this.getElencoNidi(domandaIsc));
		data.setCondizioniPunteggio(this.getCondizioniPunteggio(domandaIsc));

		if (domandaIsc.getIdUtenteIns() != null) {
			data.setUtenteIns(this.utenteDao.findIscrittoTUtenteByPk(domandaIsc.getIdUtenteIns()));
		}

		if (domandaIsc.getIdUtenteMod() != null) {
			data.setUtenteMod(this.utenteDao.findIscrittoTUtenteByPk(domandaIsc.getIdUtenteMod()));
		}

		DomandaNido result = new DomandaNidoConverter().convert(data);

		log.info(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	private List<Nido> getElencoNidi(IscrittoTDomandaIsc domandaIsc) throws DaoException {
		final String methodName = "getElencoNidi";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		Long idDomandaIscrizione = domandaIsc.getIdDomandaIscrizione();
		List<IscrittoRScuolaPre> rows = this.scuolaDao.findIscrittoRScuolaPreByFk(idDomandaIscrizione);
		if (CollectionUtils.isEmpty(rows)) {
			return NidoConverter.buildEmptyList();
		}

		List<Nido> nidi = new ArrayList<>();
		for (IscrittoRScuolaPre row : rows) {
			IscrittoTScuola iscrittoTScuola = this.scuolaDao.findIscrittoTScuolaByKey(row.getIdScuola());

			NidoConverter.Data data = new NidoConverter.Data();
			data.setDecCategoriaScu(this.decodificaDao.findIscrittoDCategoriaScuByKey(iscrittoTScuola.getIdCategoriaScu()));
			data.setDecCircoscrizione(this.decodificaDao.findIscrittoDCircoscrizioneByKey(iscrittoTScuola.getIdCircoscrizione()));
			data.setDecTipoFre(this.decodificaDao.findIscrittoDTipoFreByKey(row.getIdTipoFrequenza()));
			if (row.getIdStatoScu() != null) {
				data.setDecStatoScu(this.decodificaDao.findIscrittoDStatoScuByKey(row.getIdStatoScu()));
			}
			data.setRow(row);
			data.setScuola(iscrittoTScuola);

			nidi.add(new NidoConverter().convert(data));
		}

		log.info(buildMessage(getClass(), methodName, LOG_END));
		return nidi;
	}

}
