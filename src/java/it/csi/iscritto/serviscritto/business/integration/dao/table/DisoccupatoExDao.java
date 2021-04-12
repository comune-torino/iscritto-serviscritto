package it.csi.iscritto.serviscritto.business.integration.dao.table;

import java.util.List;

import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTDisoccupatoEx;
import it.csi.iscritto.serviscritto.business.integration.exception.DaoException;

public interface DisoccupatoExDao {

	List<IscrittoTDisoccupatoEx> findDisoccupatoExByFk(Long idCondizioneOccupazionale) throws DaoException;

	Long insertIscrittoTDisoccupatoEx(IscrittoTDisoccupatoEx row) throws DaoException;

	Integer deleteIscrittoTDisoccupatoEx(Long idDisoccupatoExLav) throws DaoException;

}
