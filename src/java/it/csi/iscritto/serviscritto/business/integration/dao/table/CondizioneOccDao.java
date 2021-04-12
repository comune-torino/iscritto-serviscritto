package it.csi.iscritto.serviscritto.business.integration.dao.table;

import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTCondizioneOcc;
import it.csi.iscritto.serviscritto.business.integration.exception.DaoException;

public interface CondizioneOccDao {

	IscrittoTCondizioneOcc findCondizioneOccByFk(Long idAnagraficaSoggetto) throws DaoException;

	IscrittoTCondizioneOcc findCondizioneOccByKey(Long idCondizioneOccupazionale) throws DaoException;

	Long insertIscrittoTCondizioneOcc(IscrittoTCondizioneOcc row) throws DaoException;

	Integer deleteIscrittoTCondizioneOcc(Long idCondizioneOccupazionale) throws DaoException;

}
