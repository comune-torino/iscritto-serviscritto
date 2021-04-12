package it.csi.iscritto.serviscritto.business.integration.dao.table;

import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTAffido;
import it.csi.iscritto.serviscritto.business.integration.exception.DaoException;

public interface AffidoDao {

	IscrittoTAffido findIscrittoTAffidoByFk(Long idAnagraficaSoggetto) throws DaoException;

	void insertIscrittoTAffido(IscrittoTAffido row) throws DaoException;

	Integer deleteIscrittoTAffido(Long idAnagraficaSoggetto) throws DaoException;

}
