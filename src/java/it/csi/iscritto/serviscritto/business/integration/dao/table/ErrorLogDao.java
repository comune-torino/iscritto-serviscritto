package it.csi.iscritto.serviscritto.business.integration.dao.table;

import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTLogErroreDomanda;
import it.csi.iscritto.serviscritto.business.integration.exception.DaoException;

public interface ErrorLogDao {

	Integer logError(IscrittoTLogErroreDomanda row) throws DaoException;

}
