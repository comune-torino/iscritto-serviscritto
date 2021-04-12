package it.csi.iscritto.serviscritto.business.integration.dao.table;

import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTTrasferimento;
import it.csi.iscritto.serviscritto.business.integration.exception.DaoException;

public interface TrasferimentoDao {

	IscrittoTTrasferimento findIscrittoTTrasferimentoByFk(Long idDomandaIscrizione) throws DaoException;

	void insertIscrittoTTrasferimento(IscrittoTTrasferimento row) throws DaoException;

	Integer deleteIscrittoTTrasferimento(Long idDomandaIscrizione) throws DaoException;

}
