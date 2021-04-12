package it.csi.iscritto.serviscritto.business.integration.dao.table;

import java.util.Date;

import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTStato;
import it.csi.iscritto.serviscritto.business.integration.exception.DaoException;

public interface StatoDao {

	IscrittoTStato findIscrittoTStatoByKey(Long idStato) throws DaoException;

	IscrittoTStato findIscrittoTStatoByCod(Date data, String codice) throws DaoException;

}
