package it.csi.iscritto.serviscritto.business.integration.dao.table.impl;

import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.LOG_BEGIN;
import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.LOG_END;
import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.buildMessage;
import static it.csi.iscritto.serviscritto.business.util.converter.ConvertUtils.getFirst;

import java.util.Date;

import org.apache.log4j.Logger;

import it.csi.iscritto.serviscritto.business.integration.dao.AbstractDao;
import it.csi.iscritto.serviscritto.business.integration.dao.table.StatoDao;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTStato;
import it.csi.iscritto.serviscritto.business.integration.exception.DaoException;
import it.csi.iscritto.serviscritto.business.util.Constants;
import it.csi.iscritto.serviscritto.business.util.DateUtils;
import it.csi.iscritto.serviscritto.business.util.sql.SqlHolder;

public class StatoDaoImpl extends AbstractDao implements StatoDao {
	private static final Logger log = Logger.getLogger(Constants.COMPONENT_NAME + ".dao");

	@Override
	public IscrittoTStato findIscrittoTStatoByKey(Long idStato) throws DaoException {
		final String methodName = "findIscrittoTStatoByKey";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		SqlHolder sh = buildSqlHolder(IscrittoTStato.SQL_SELECT_ALL)
				.addQueryRows(
						"WHERE 1 = 1",
						"  AND id_stato = :idStato")
				.bind("idStato", idStato);

		IscrittoTStato result = getFirst(this.query(sh, IscrittoTStato.class));

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public IscrittoTStato findIscrittoTStatoByCod(Date data, String codice) throws DaoException {
		final String methodName = "findIscrittoTStatoByCod";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		SqlHolder sh = buildSqlHolder(IscrittoTStato.SQL_SELECT_ALL)
				.addQueryRows(
						"WHERE 1 = 1",
						"  AND to_date(:data, 'YYYY-MM-DD') >= to_date(to_char(dt_start, 'YYYY-MM-DD'), 'YYYY-MM-DD')",
						"  AND to_date(:data, 'YYYY-MM-DD') <= to_date(to_char(dt_stop,  'YYYY-MM-DD'), 'YYYY-MM-DD')",
						"  AND codice = :codice",
						"  AND rel_status IN ('1', '2')",
						"ORDER BY rel_status");

		sh.bind("data", DateUtils.toStringDate(data, DateUtils.ISO_8601_FORMAT));
		sh.bind("codice", codice);

		IscrittoTStato result = getFirst(this.query(sh, IscrittoTStato.class));

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

}
