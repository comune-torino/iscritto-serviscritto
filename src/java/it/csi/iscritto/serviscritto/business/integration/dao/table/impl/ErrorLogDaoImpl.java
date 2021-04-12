package it.csi.iscritto.serviscritto.business.integration.dao.table.impl;

import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.LOG_BEGIN;
import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.LOG_END;
import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.buildMessage;

import java.util.Date;

import org.apache.commons.lang3.Validate;
import org.apache.log4j.Logger;

import it.csi.iscritto.serviscritto.business.integration.dao.AbstractDao;
import it.csi.iscritto.serviscritto.business.integration.dao.table.ErrorLogDao;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTLogErroreDomanda;
import it.csi.iscritto.serviscritto.business.integration.exception.DaoException;
import it.csi.iscritto.serviscritto.business.util.Constants;
import it.csi.iscritto.serviscritto.business.util.sql.SqlHolder;

public class ErrorLogDaoImpl extends AbstractDao implements ErrorLogDao {
	private static final Logger log = Logger.getLogger(Constants.COMPONENT_NAME + ".dao");

	@Override
	public Integer logError(IscrittoTLogErroreDomanda row) throws DaoException {
		final String methodName = "logError";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		Validate.notNull(row);

		final SqlHolder sh = buildSqlHolder()
				.addQueryRows(
						"insert into iscritto_t_log_errore_domanda (",
						"  data_inserimento,",
						"  codice_fiscale_operatore,",
						"  dettaglio_errore,",
						"  json_domanda",
						") ",
						"values (",
						"  :dataInserimento, ",
						"  :codiceFiscaleOperatore, ",
						"  :dettaglioErrore, ",
						"  fcifra_t(:jsonDomanda, :encryptionKey)",
						")")
				.bind("encryptionKey", this.getEncryptionKey())
				.bind("dataInserimento", new Date())
				.bind("codiceFiscaleOperatore", row.getCodiceFiscaleOperatore())
				.bind("dettaglioErrore", row.getDettaglioErrore())
				.bind("jsonDomanda", row.getJsonDomanda());

		Integer result = this.update(sh);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

}
