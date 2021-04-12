package it.csi.iscritto.serviscritto.business.integration.dao.view;

import java.util.Date;

import it.csi.iscritto.serviscritto.business.integration.dao.TipoScuola;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTAnagraficaGra;
import it.csi.iscritto.serviscritto.business.integration.exception.DaoException;

public interface InfoGeneraliDao {

	IscrittoTAnagraficaGra findGraduatoriaByDate(TipoScuola tipoScuola, Date data) throws DaoException;

}
