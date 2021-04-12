package it.csi.iscritto.serviscritto.business.integration.dao.table;

import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTGenitoreSolo;
import it.csi.iscritto.serviscritto.business.integration.exception.DaoException;

public interface GenitoreSoloDao {

	IscrittoTGenitoreSolo findIscrittoTGenitoreSoloByKey(Long idDomandaIscrizione) throws DaoException;

	void insertIscrittoTGenitoreSolo(IscrittoTGenitoreSolo row) throws DaoException;

	Integer deleteIscrittoTGenitoreSolo(Long idDomandaIscrizione) throws DaoException;

}
