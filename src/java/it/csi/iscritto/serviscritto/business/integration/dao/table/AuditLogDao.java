package it.csi.iscritto.serviscritto.business.integration.dao.table;

import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoLAuditLog;
import it.csi.iscritto.serviscritto.business.integration.exception.DaoException;

public interface AuditLogDao {

	Integer logAudit(IscrittoLAuditLog row) throws DaoException;

}
