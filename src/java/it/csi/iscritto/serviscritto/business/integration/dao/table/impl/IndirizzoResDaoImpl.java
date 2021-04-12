package it.csi.iscritto.serviscritto.business.integration.dao.table.impl;

import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.LOG_BEGIN;
import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.LOG_END;
import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.buildMessage;
import static it.csi.iscritto.serviscritto.business.util.converter.ConvertUtils.getFirst;

import org.apache.commons.lang3.Validate;
import org.apache.log4j.Logger;

import it.csi.iscritto.serviscritto.business.integration.dao.AbstractDao;
import it.csi.iscritto.serviscritto.business.integration.dao.table.IndirizzoResDao;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTIndirizzoRes;
import it.csi.iscritto.serviscritto.business.integration.exception.DaoException;
import it.csi.iscritto.serviscritto.business.util.Constants;
import it.csi.iscritto.serviscritto.business.util.sql.SqlHolder;

public class IndirizzoResDaoImpl extends AbstractDao implements IndirizzoResDao {
	private static final Logger log = Logger.getLogger(Constants.COMPONENT_NAME + ".dao");

	@Override
	public IscrittoTIndirizzoRes findIscrittoTIndirizzoResByFk(Long idAnagraficaSoggetto) throws DaoException {
		final String methodName = "findIscrittoTIndirizzoResByFk";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		SqlHolder sh = buildSqlHolder(IscrittoTIndirizzoRes.SQL_SELECT_ALL)
				.addQueryRows(
						"WHERE 1 = 1",
						"  AND id_anagrafica_soggetto = :idAnagraficaSoggetto")
				.bind("idAnagraficaSoggetto", idAnagraficaSoggetto);

		IscrittoTIndirizzoRes result = getFirst(this.query(sh, IscrittoTIndirizzoRes.class));

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	//////////////////////////////////////////////////////////////////////

	@Override
	public void insertIscrittoTIndirizzoRes(IscrittoTIndirizzoRes row) throws DaoException {
		final String methodName = "insertIscrittoTIndirizzoRes";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		Validate.notNull(row);
		Validate.notNull(row.getIdAnagraficaSoggetto());

		log.info(buildMessage(getClass(), methodName, "idAnagraficaSoggetto: " + row.getIdAnagraficaSoggetto()));

		final SqlHolder sh = buildSqlHolder(IscrittoTIndirizzoRes.SQL_INSERT)
				.bind("indirizzo", row.getIndirizzo())
				.bind("cap", row.getCap())
				.bind("idAnagraficaSoggetto", row.getIdAnagraficaSoggetto())
				.bind("idComune", row.getIdComune())
				.bind("idStatoResidenza", row.getIdStatoResidenza());

		this.update(sh);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
	}

	@Override
	public Integer deleteIscrittoTIndirizzoRes(Long idAnagraficaSoggetto) throws DaoException {
		final String methodName = "deleteIscrittoTIndirizzoRes";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		Validate.notNull(idAnagraficaSoggetto);

		log.info(buildMessage(getClass(), methodName, "idAnagraficaSoggetto: " + idAnagraficaSoggetto));

		// @formatter:off
        final SqlHolder sh = buildSqlHolder(
    		"DELETE FROM iscritto_t_indirizzo_res",
    		"WHERE id_anagrafica_soggetto = :idAnagraficaSoggetto"
        )
        .bind("idAnagraficaSoggetto", idAnagraficaSoggetto);
        // @formatter:on

		Integer result = this.update(sh);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

}
