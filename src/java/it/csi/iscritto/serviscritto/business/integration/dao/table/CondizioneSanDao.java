package it.csi.iscritto.serviscritto.business.integration.dao.table;

import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTCondizioneSan;
import it.csi.iscritto.serviscritto.business.integration.exception.DaoException;

public interface CondizioneSanDao {

	IscrittoTCondizioneSan findIscrittoTCondizioneSanByFk(Long idAnagraficaSoggetto) throws DaoException;

	void insertIscrittoTCondizioneSan(IscrittoTCondizioneSan row) throws DaoException;

	Integer deleteIscrittoTCondizioneSan(Long idAnagraficaSoggetto) throws DaoException;

}
