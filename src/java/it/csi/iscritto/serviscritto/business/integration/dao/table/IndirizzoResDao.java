package it.csi.iscritto.serviscritto.business.integration.dao.table;

import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTIndirizzoRes;
import it.csi.iscritto.serviscritto.business.integration.exception.DaoException;

public interface IndirizzoResDao {

	IscrittoTIndirizzoRes findIscrittoTIndirizzoResByFk(Long idAnagraficaSoggetto) throws DaoException;

	void insertIscrittoTIndirizzoRes(IscrittoTIndirizzoRes row) throws DaoException;

	Integer deleteIscrittoTIndirizzoRes(Long idAnagraficaSoggetto) throws DaoException;

}
