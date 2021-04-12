package it.csi.iscritto.serviscritto.business.integration.dao.table;

import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTAutonomo;
import it.csi.iscritto.serviscritto.business.integration.exception.DaoException;

public interface AutonomoDao {

	IscrittoTAutonomo findAutonomoByKey(Long idCondizioneOccupazionale) throws DaoException;

	void insertIscrittoTAutonomo(IscrittoTAutonomo row) throws DaoException;

	Integer deleteIscrittoTAutonomo(Long idCondizioneOccupazionale) throws DaoException;

}
