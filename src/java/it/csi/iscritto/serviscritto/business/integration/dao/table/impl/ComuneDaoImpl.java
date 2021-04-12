package it.csi.iscritto.serviscritto.business.integration.dao.table.impl;

import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.LOG_BEGIN;
import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.LOG_END;
import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.buildMessage;
import static it.csi.iscritto.serviscritto.business.util.converter.ConvertUtils.getFirst;

import java.util.Date;

import org.apache.log4j.Logger;

import it.csi.iscritto.serviscritto.business.integration.dao.AbstractDao;
import it.csi.iscritto.serviscritto.business.integration.dao.table.ComuneDao;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTComune;
import it.csi.iscritto.serviscritto.business.integration.exception.DaoException;
import it.csi.iscritto.serviscritto.business.util.Constants;
import it.csi.iscritto.serviscritto.business.util.DateUtils;
import it.csi.iscritto.serviscritto.business.util.sql.SqlHolder;

public class ComuneDaoImpl extends AbstractDao implements ComuneDao {
	private static final Logger log = Logger.getLogger(Constants.COMPONENT_NAME + ".dao");

	@Override
	public IscrittoTComune findIscrittoTComuneByKey(Long idComune) throws DaoException {
		final String methodName = "findIscrittoTComuneByKey";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		SqlHolder sh = buildSqlHolder(IscrittoTComune.SQL_SELECT_ALL)
				.addQueryRows(
						"WHERE 1 = 1",
						"  AND id_comune = :idComune")
				.bind("idComune", idComune);

		IscrittoTComune result = getFirst(this.query(sh, IscrittoTComune.class));

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public IscrittoTComune findIscrittoTComuneByIstatComune(Date data, String istatComune) throws DaoException {
		final String methodName = "findIscrittoTComuneByKey";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		SqlHolder sh = buildSqlHolder(IscrittoTComune.SQL_SELECT_ALL)
				.addQueryRows(
						"WHERE 1 = 1",
						"  AND to_date(:data, 'YYYY-MM-DD') >= to_date(to_char(dt_start, 'YYYY-MM-DD'), 'YYYY-MM-DD')",
						"  AND to_date(:data, 'YYYY-MM-DD') <= to_date(to_char(dt_stop,  'YYYY-MM-DD'), 'YYYY-MM-DD')",
						"  AND istat_comune = :istatComune",
						"  AND rel_status IN ('1', '2')",
						"ORDER BY rel_status");

		sh.bind("data", DateUtils.toStringDate(data, DateUtils.ISO_8601_FORMAT));
		sh.bind("istatComune", istatComune);

		IscrittoTComune result = getFirst(this.query(sh, IscrittoTComune.class));

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

}
