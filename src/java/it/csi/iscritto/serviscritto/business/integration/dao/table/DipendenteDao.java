package it.csi.iscritto.serviscritto.business.integration.dao.table;

import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTDipendente;
import it.csi.iscritto.serviscritto.business.integration.exception.DaoException;

public interface DipendenteDao {

	IscrittoTDipendente findDipendenteByKey(Long idCondizioneOccupazionale) throws DaoException;

	void insertIscrittoTDipendente(IscrittoTDipendente row) throws DaoException;

	Integer deleteIscrittoTDipendente(Long idCondizioneOccupazionale) throws DaoException;

}
