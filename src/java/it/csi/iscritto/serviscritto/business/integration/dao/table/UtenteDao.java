package it.csi.iscritto.serviscritto.business.integration.dao.table;

import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTUtente;
import it.csi.iscritto.serviscritto.business.integration.exception.DaoException;

public interface UtenteDao {

	IscrittoTUtente findIscrittoTUtenteByPk(Long idUtente) throws DaoException;

	IscrittoTUtente findIscrittoTUtenteByCF(String codiceFiscale) throws DaoException;

}
