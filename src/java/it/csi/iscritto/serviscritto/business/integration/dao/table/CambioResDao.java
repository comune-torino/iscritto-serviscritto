package it.csi.iscritto.serviscritto.business.integration.dao.table;

import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTCambioRes;
import it.csi.iscritto.serviscritto.business.integration.exception.DaoException;

public interface CambioResDao {

	IscrittoTCambioRes findIscrittoTCambioResByFk(Long idDomandaIscrizione) throws DaoException;

	void insertIscrittoTCambioRes(IscrittoTCambioRes row) throws DaoException;

	Integer deleteIscrittoTCambioRes(Long idDomandaIscrizione) throws DaoException;

}
