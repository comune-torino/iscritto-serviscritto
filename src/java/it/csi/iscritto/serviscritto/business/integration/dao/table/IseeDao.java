package it.csi.iscritto.serviscritto.business.integration.dao.table;

import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTIsee;
import it.csi.iscritto.serviscritto.business.integration.exception.DaoException;

public interface IseeDao {

	IscrittoTIsee findIscrittoTIseeByFk(Long idDomandaIscrizione) throws DaoException;

	void insertIscrittoTIsee(IscrittoTIsee row) throws DaoException;

	Integer deleteIscrittoTIsee(Long idDomandaIscrizione) throws DaoException;

}
