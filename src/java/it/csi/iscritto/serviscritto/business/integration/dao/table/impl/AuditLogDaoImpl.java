package it.csi.iscritto.serviscritto.business.integration.dao.table.impl;

import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.LOG_BEGIN;
import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.LOG_END;
import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.buildMessage;

import java.util.Date;

import org.apache.commons.lang3.Validate;
import org.apache.log4j.Logger;

import it.csi.iscritto.serviscritto.business.integration.dao.AbstractDao;
import it.csi.iscritto.serviscritto.business.integration.dao.table.AuditLogDao;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoLAuditLog;
import it.csi.iscritto.serviscritto.business.integration.exception.DaoException;
import it.csi.iscritto.serviscritto.business.util.Constants;
import it.csi.iscritto.serviscritto.business.util.sql.SqlHolder;

public class AuditLogDaoImpl extends AbstractDao implements AuditLogDao {
	private static final Logger log = Logger.getLogger(Constants.COMPONENT_NAME + ".dao");

	@Override
	public Integer logAudit(IscrittoLAuditLog row) throws DaoException {
		final String methodName = "logAudit";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		Validate.notNull(row);
		Validate.notBlank(row.getIdApp());
		Validate.notBlank(row.getUtente());
		Validate.notBlank(row.getOperazione());
		Validate.notBlank(row.getOggOper());

		final SqlHolder sh = buildSqlHolder(IscrittoLAuditLog.SQL_INSERT)
				.bind("dataOra", new Date())
				.bind("idApp", row.getIdApp())
				.bind("ipAddress", row.getIpAddress())
				.bind("utente", row.getUtente())
				.bind("operazione", row.getOperazione())
				.bind("oggOper", row.getOggOper())
				.bind("keyOper", row.getKeyOper());

		Integer result = this.update(sh);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

}
