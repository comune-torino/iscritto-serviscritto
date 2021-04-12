package it.csi.iscritto.serviscritto.business.integration.dao.table.impl;

import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.LOG_BEGIN;
import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.LOG_END;
import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.buildMessage;
import static it.csi.iscritto.serviscritto.business.util.converter.ConvertUtils.getFirst;

import org.apache.commons.lang3.Validate;
import org.apache.log4j.Logger;

import it.csi.iscritto.serviscritto.business.integration.dao.AbstractDao;
import it.csi.iscritto.serviscritto.business.integration.dao.table.AffidoDao;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTAffido;
import it.csi.iscritto.serviscritto.business.integration.exception.DaoException;
import it.csi.iscritto.serviscritto.business.util.Constants;
import it.csi.iscritto.serviscritto.business.util.sql.SqlHolder;

public class AffidoDaoImpl extends AbstractDao implements AffidoDao {
	private static final Logger log = Logger.getLogger(Constants.COMPONENT_NAME + ".dao");

	@Override
	public IscrittoTAffido findIscrittoTAffidoByFk(Long idAnagraficaSoggetto) throws DaoException {
		final String methodName = "findIscrittoTAffidoByFk";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		SqlHolder sh = buildSqlHolder(IscrittoTAffido.SQL_SELECT_ALL)
				.addQueryRows(
						"WHERE 1 = 1",
						"  AND id_anagrafica_soggetto = :idAnagraficaSoggetto")
				.bind("idAnagraficaSoggetto", idAnagraficaSoggetto);

		IscrittoTAffido result = getFirst(this.query(sh, IscrittoTAffido.class));

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	//////////////////////////////////////////////////////////////////////

	@Override
	public void insertIscrittoTAffido(IscrittoTAffido row) throws DaoException {
		final String methodName = "insertIscrittoTAffido";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		Validate.notNull(row);
		Validate.notNull(row.getIdAnagraficaSoggetto());

		log.info(buildMessage(getClass(), methodName, "idAnagraficaSoggetto: " + row.getIdAnagraficaSoggetto()));

		final SqlHolder sh = buildSqlHolder(IscrittoTAffido.SQL_INSERT)
				.bind("idAnagraficaSoggetto", row.getIdAnagraficaSoggetto())
				.bind("numSentenza", row.getNumSentenza())
				.bind("dtSentenza", row.getDtSentenza())
				.bind("comuneTribunale", row.getComuneTribunale());

		this.update(sh);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
	}

	@Override
	public Integer deleteIscrittoTAffido(Long idAnagraficaSoggetto) throws DaoException {
		final String methodName = "deleteIscrittoTAffido";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		Validate.notNull(idAnagraficaSoggetto);

		log.info(buildMessage(getClass(), methodName, "idAnagraficaSoggetto: " + idAnagraficaSoggetto));

		final SqlHolder sh = buildSqlHolder(IscrittoTAffido.SQL_DELETE)
				.bind("idAnagraficaSoggetto", idAnagraficaSoggetto);

		Integer result = this.update(sh);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

}
