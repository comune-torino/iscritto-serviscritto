package it.csi.iscritto.serviscritto.business.domanda.service;

import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.LOG_BEGIN;
import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.LOG_END;
import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.buildMessage;

import java.util.Date;

import org.apache.log4j.Logger;

import it.csi.iscritto.serviscritto.business.integration.dao.TipoScuola;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTAnagraficaGra;
import it.csi.iscritto.serviscritto.business.integration.dao.view.InfoGeneraliDao;
import it.csi.iscritto.serviscritto.business.integration.exception.DaoException;
import it.csi.iscritto.serviscritto.business.util.Constants;
import it.csi.iscritto.serviscritto.dto.domanda.InfoGenerali;

public class InfoGeneraliService {
	private static final Logger log = Logger.getLogger(Constants.COMPONENT_NAME + ".business");

	private InfoGeneraliDao infoGeneraliDao;

	public void setInfoGeneraliDao(InfoGeneraliDao infoGeneraliDao) {
		this.infoGeneraliDao = infoGeneraliDao;
	}

	//////////////////////////////////////////////////////////////////////

	public InfoGenerali getInfoGenerali(TipoScuola tipoScuola) throws DaoException {
		final String methodName = "getInfoGenerali";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		InfoGenerali result = new InfoGenerali();

		this.populateDatiGraduatoria(tipoScuola, result);

		log.info(buildMessage(getClass(), methodName, "dataInizioIscrizioniNidi: " + result.getDataInizioIscrizioniNidi()));
		log.info(buildMessage(getClass(), methodName, "dataScadenzaIscrizioniNidi: " + result.getDataScadenzaIscrizioniNidi()));
		log.info(buildMessage(getClass(), methodName, "dataFineIscrizioniNidi: " + result.getDataFineIscrizioniNidi()));

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	private void populateDatiGraduatoria(TipoScuola tipoScuola, final InfoGenerali infoGenerali) throws DaoException {
		Date now = new Date();

		IscrittoTAnagraficaGra anagraficaGraRow = this.infoGeneraliDao.findGraduatoriaByDate(tipoScuola, now);
		if (anagraficaGraRow != null) {
			infoGenerali.setDataInizioIscrizioniNidi(anagraficaGraRow.getDtInizioIscr());
			infoGenerali.setDataScadenzaIscrizioniNidi(anagraficaGraRow.getDtScadenzaIscr());
			infoGenerali.setDataFineIscrizioniNidi(anagraficaGraRow.getDtFineIscr());
		}
	}

}
