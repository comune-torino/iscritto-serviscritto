package it.csi.iscritto.serviscritto.business.integration.dao.table;

import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTServiziSoc;
import it.csi.iscritto.serviscritto.business.integration.exception.DaoException;

public interface ServiziSocDao {

	IscrittoTServiziSoc findIscrittoTServiziSocByFk(Long idDomandaIscrizione) throws DaoException;

	void insertIscrittoTServiziSoc(IscrittoTServiziSoc row) throws DaoException;

	Integer deleteIscrittoTServiziSoc(Long idDomandaIscrizione) throws DaoException;

}
