package it.csi.iscritto.serviscritto.business.integration.dao.table;

import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTDisoccupato;
import it.csi.iscritto.serviscritto.business.integration.exception.DaoException;

public interface DisoccupatoDao {

	IscrittoTDisoccupato findDisoccupatoByKey(Long idCondizioneOccupazionale) throws DaoException;

	void insertIscrittoTDisoccupato(IscrittoTDisoccupato row) throws DaoException;

	Integer deleteIscrittoTDisoccupato(Long idCondizioneOccupazionale) throws DaoException;

}
