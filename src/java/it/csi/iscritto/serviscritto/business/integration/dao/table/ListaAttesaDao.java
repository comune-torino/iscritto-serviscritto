package it.csi.iscritto.serviscritto.business.integration.dao.table;

import java.util.List;

import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoRListaAttesa;
import it.csi.iscritto.serviscritto.business.integration.exception.DaoException;

public interface ListaAttesaDao {

	List<IscrittoRListaAttesa> findIscrittoRListaAttesaByIdDomanda(Long idDomandaIsc) throws DaoException;

	void insertIscrittoRListaAttesa(IscrittoRListaAttesa row) throws DaoException;

	Integer deleteIscrittoRListaAttesa(Long idDomandaIsc) throws DaoException;

}
