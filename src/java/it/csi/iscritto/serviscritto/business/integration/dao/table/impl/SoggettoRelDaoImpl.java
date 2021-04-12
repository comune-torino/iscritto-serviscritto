package it.csi.iscritto.serviscritto.business.integration.dao.table.impl;

import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.LOG_BEGIN;
import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.LOG_END;
import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.buildMessage;

import java.util.List;

import org.apache.commons.lang3.Validate;
import org.apache.log4j.Logger;

import it.csi.iscritto.serviscritto.business.integration.dao.AbstractDao;
import it.csi.iscritto.serviscritto.business.integration.dao.table.SoggettoRelDao;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoRSoggettoRel;
import it.csi.iscritto.serviscritto.business.integration.exception.DaoException;
import it.csi.iscritto.serviscritto.business.util.Constants;
import it.csi.iscritto.serviscritto.business.util.sql.SqlHolder;

public class SoggettoRelDaoImpl extends AbstractDao implements SoggettoRelDao {
	private static final Logger log = Logger.getLogger(Constants.COMPONENT_NAME + ".dao");

	@Override
	public List<IscrittoRSoggettoRel> findIscrittoRSoggettoRelByIdSog(Long idAnagraficaSoggetto) throws DaoException {
		final String methodName = "findIscrittoRSoggettoRelByIdSog";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		SqlHolder sh = buildSqlHolder(IscrittoRSoggettoRel.SQL_SELECT_ALL)
				.addQueryRows(
						"WHERE 1 = 1",
						"  AND id_anagrafica_soggetto = :idAnagraficaSoggetto")
				.bind("idAnagraficaSoggetto", idAnagraficaSoggetto);

		List<IscrittoRSoggettoRel> result = this.query(sh, IscrittoRSoggettoRel.class);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public void insertIscrittoRSoggettoRel(IscrittoRSoggettoRel row) throws DaoException {
		final String methodName = "insertIscrittoRSoggettoRel";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		Validate.notNull(row);
		Validate.notNull(row.getIdAnagraficaSoggetto());
		Validate.notNull(row.getIdTipoSoggetto());

		log.info(buildMessage(getClass(), methodName, "idAnagraficaSoggetto: " + row.getIdAnagraficaSoggetto()));
		log.info(buildMessage(getClass(), methodName, "idTipoSoggetto: " + row.getIdTipoSoggetto()));

		final SqlHolder sh = buildSqlHolder(IscrittoRSoggettoRel.SQL_INSERT)
				.bind("idAnagraficaSoggetto", row.getIdAnagraficaSoggetto())
				.bind("idTipoSoggetto", row.getIdTipoSoggetto());

		this.update(sh);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
	}

	@Override
	public Integer deleteIscrittoRSoggettoRelByIdSoggetto(Long idAnagraficaSoggetto) throws DaoException {
		final String methodName = "deleteIscrittoRSoggettoRel";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		Validate.notNull(idAnagraficaSoggetto);

		log.info(buildMessage(getClass(), methodName, "idAnagraficaSoggetto: " + idAnagraficaSoggetto));

		// @formatter:off
        final SqlHolder sh = buildSqlHolder(
    		"DELETE FROM iscritto_r_soggetto_rel",
    		"WHERE id_anagrafica_soggetto = :idAnagraficaSoggetto"
        )
        .bind("idAnagraficaSoggetto", idAnagraficaSoggetto);
        // @formatter:on

		Integer result = this.update(sh);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

}
