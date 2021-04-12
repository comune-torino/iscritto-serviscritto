package it.csi.iscritto.serviscritto.business.integration.dao.table;

import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTStudente;
import it.csi.iscritto.serviscritto.business.integration.exception.DaoException;

public interface StudenteDao {

	IscrittoTStudente findStudenteByKey(Long idCondizioneOccupazionale) throws DaoException;

	void insertIscrittoTStudente(IscrittoTStudente row) throws DaoException;

	Integer deleteIscrittoTStudente(Long idCondizioneOccupazionale) throws DaoException;

}
