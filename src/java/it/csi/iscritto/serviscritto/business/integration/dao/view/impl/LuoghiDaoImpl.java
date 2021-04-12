package it.csi.iscritto.serviscritto.business.integration.dao.view.impl;

import static it.csi.iscritto.serviscritto.business.util.DateUtils.ISO_8601_FORMAT;
import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.LOG_BEGIN;
import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.LOG_END;
import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.buildMessage;
import static it.csi.iscritto.serviscritto.business.util.converter.ConvertUtils.getFirst;
import static it.csi.iscritto.serviscritto.business.util.sql.SqlHolderUtils.addIf;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import it.csi.iscritto.serviscritto.business.integration.dao.AbstractDao;
import it.csi.iscritto.serviscritto.business.integration.dao.view.LuoghiDao;
import it.csi.iscritto.serviscritto.business.integration.dao.view.dto.LuogoRow;
import it.csi.iscritto.serviscritto.business.integration.exception.DaoException;
import it.csi.iscritto.serviscritto.business.util.Constants;
import it.csi.iscritto.serviscritto.business.util.DateUtils;
import it.csi.iscritto.serviscritto.business.util.sql.SqlHolder;

public class LuoghiDaoImpl extends AbstractDao implements LuoghiDao {
	private static final Logger log = Logger.getLogger(Constants.COMPONENT_NAME + ".dao");

	@Override
	public List<LuogoRow> findStatiAttiviAllaData(Date data) throws DaoException {
		final String methodName = "findStatiAttiviAllaData";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		SqlHolder sh = buildSqlHolder(
				"SELECT",
				"  s.stato,",
				"  s.codice,",
				"  s.cittadinanza",
				"FROM iscritto_t_stato s",
				"WHERE 1 = 1",
				"  AND to_date(:data, 'YYYY-MM-DD') >= to_date(to_char(s.dt_start, 'YYYY-MM-DD'), 'YYYY-MM-DD')",
				"  AND to_date(:data, 'YYYY-MM-DD') <= to_date(to_char(s.dt_stop,  'YYYY-MM-DD'), 'YYYY-MM-DD')",
				"  AND rel_status = '1'",
				"GROUP BY s.stato, s.codice, s.cittadinanza",
				"ORDER BY s.stato");

		sh.bind("data", DateUtils.toStringDate(data, ISO_8601_FORMAT));

		List<LuogoRow> result = this.query(sh, LuogoRow.class);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public List<LuogoRow> findRegioniAttiveAllaData(Date data) throws DaoException {
		final String methodName = "findRegioniAttiveAllaData";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		SqlHolder sh = buildSqlHolder(
				"SELECT",
				"  c.desc_regione,",
				"  c.istat_regione",
				"FROM iscritto_t_comune c",
				"WHERE 1 = 1",
				"  AND to_date(:data, 'YYYY-MM-DD') >= to_date(to_char(c.dt_start, 'YYYY-MM-DD'), 'YYYY-MM-DD')",
				"  AND to_date(:data, 'YYYY-MM-DD') <= to_date(to_char(c.dt_stop,  'YYYY-MM-DD'), 'YYYY-MM-DD')",
				"  AND rel_status = '1'",
				"GROUP BY c.istat_regione, c.desc_regione",
				"ORDER BY c.desc_regione");

		sh.bind("data", DateUtils.toStringDate(data, ISO_8601_FORMAT));

		List<LuogoRow> result = this.query(sh, LuogoRow.class);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public List<LuogoRow> findProvinceAttiveAllaData(Date data, String istatRegione) throws DaoException {
		final String methodName = "findProvinceAttiveAllaData";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		SqlHolder sh = buildSqlHolder(
				"SELECT",
				"  c.istat_provincia,",
				"  c.desc_provincia",
				"FROM iscritto_t_comune c",
				"WHERE 1 = 1",
				"  AND to_date(:data, 'YYYY-MM-DD') >= to_date(to_char(c.dt_start, 'YYYY-MM-DD'), 'YYYY-MM-DD')",
				"  AND to_date(:data, 'YYYY-MM-DD') <= to_date(to_char(c.dt_stop,  'YYYY-MM-DD'), 'YYYY-MM-DD')",
				"  AND rel_status = '1'",
				addIf(StringUtils.isNotBlank(istatRegione),
						"  AND c.istat_regione = :istatRegione"),
				"GROUP BY c.istat_provincia, c.desc_provincia",
				"ORDER BY c.desc_provincia");

		sh.bind("data", DateUtils.toStringDate(data, ISO_8601_FORMAT));
		sh.bind("istatRegione", istatRegione);

		List<LuogoRow> result = this.query(sh, LuogoRow.class);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public List<LuogoRow> findComuniAttiviAllaData(Date data, String istatProvincia) throws DaoException {
		final String methodName = "findComuniAttiviAllaData";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		SqlHolder sh = buildSqlHolder(
				"SELECT",
				"  c.istat_comune,",
				"  c.desc_comune",
				"FROM iscritto_t_comune c",
				"WHERE 1 = 1",
				"  AND to_date(:data, 'YYYY-MM-DD') >= to_date(to_char(c.dt_start, 'YYYY-MM-DD'), 'YYYY-MM-DD')",
				"  AND to_date(:data, 'YYYY-MM-DD') <= to_date(to_char(c.dt_stop,  'YYYY-MM-DD'), 'YYYY-MM-DD')",
				"  AND rel_status = '1'",
				addIf(StringUtils.isNotBlank(istatProvincia),
						"  AND c.istat_provincia = :istatProvincia"),
				"GROUP BY c.istat_comune, c.desc_comune",
				"ORDER BY c.desc_comune");

		sh.bind("data", DateUtils.toStringDate(data, ISO_8601_FORMAT));
		sh.bind("istatProvincia", istatProvincia);

		List<LuogoRow> result = this.query(sh, LuogoRow.class);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public List<LuogoRow> findByIstatComuneAllaData(Date data, String istatComune) throws DaoException {
		final String methodName = "findByIstatComuneAllaData";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		SqlHolder sh = buildSqlHolder(
				"SELECT",
				"  c.desc_regione,",
				"  c.istat_regione,",
				"  c.desc_provincia,",
				"  c.istat_provincia,",
				"  c.desc_comune,",
				"  c.istat_comune",
				"FROM iscritto_t_comune c",
				"WHERE 1 = 1",
				"  AND to_date(:data, 'YYYY-MM-DD') >= to_date(to_char(c.dt_start, 'YYYY-MM-DD'), 'YYYY-MM-DD')",
				"  AND to_date(:data, 'YYYY-MM-DD') <= to_date(to_char(c.dt_stop,  'YYYY-MM-DD'), 'YYYY-MM-DD')",
				"  AND c.istat_comune = :istatComune",
				"ORDER BY c.rel_status");

		sh.bind("istatComune", istatComune);
		sh.bind("data", DateUtils.toStringDate(data, ISO_8601_FORMAT));

		List<LuogoRow> result = this.query(sh, LuogoRow.class);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public LuogoRow findByIstatStatoAllaData(Date data, String istatStato) throws DaoException {
		final String methodName = "findByIstatStatoAllaData";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		SqlHolder sh = buildSqlHolder(
				"SELECT",
				"  s.stato,",
				"  s.codice,",
				"  s.cittadinanza",
				"FROM iscritto_t_stato s",
				"WHERE 1 = 1",
				"  AND to_date(:data, 'YYYY-MM-DD') >= to_date(to_char(dt_start, 'YYYY-MM-DD'), 'YYYY-MM-DD')",
				"  AND to_date(:data, 'YYYY-MM-DD') <= to_date(to_char(dt_stop,  'YYYY-MM-DD'), 'YYYY-MM-DD')",
				"  AND codice_istat = :istatStato",
				"  AND rel_status IN ('1', '2')",
				"ORDER BY rel_status");

		sh.bind("data", DateUtils.toStringDate(data, ISO_8601_FORMAT));
		sh.bind("istatStato", istatStato);

		LuogoRow result = getFirst(this.query(sh, LuogoRow.class));

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

}
