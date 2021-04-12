package it.csi.iscritto.serviscritto.business.integration.dao.table.impl;

import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.LOG_BEGIN;
import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.LOG_END;
import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.buildMessage;
import static it.csi.iscritto.serviscritto.business.util.converter.ConvertUtils.getFirst;

import org.apache.commons.lang3.Validate;
import org.apache.log4j.Logger;

import it.csi.iscritto.serviscritto.business.integration.dao.AbstractDao;
import it.csi.iscritto.serviscritto.business.integration.dao.table.GenitoreSoloDao;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTGenitoreSolo;
import it.csi.iscritto.serviscritto.business.integration.exception.DaoException;
import it.csi.iscritto.serviscritto.business.util.Constants;
import it.csi.iscritto.serviscritto.business.util.sql.SqlHolder;

public class GenitoreSoloDaoImpl extends AbstractDao implements GenitoreSoloDao {
	private static final Logger log = Logger.getLogger(Constants.COMPONENT_NAME + ".dao");

	@Override
	public IscrittoTGenitoreSolo findIscrittoTGenitoreSoloByKey(Long idDomandaIscrizione) throws DaoException {
		final String methodName = "findIscrittoTGenitoreSoloByKey";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		SqlHolder sh = buildSqlHolder(IscrittoTGenitoreSolo.SQL_SELECT_ALL)
				.addQueryRows(
						"WHERE 1 = 1",
						"  AND id_domanda_iscrizione = :idDomandaIscrizione")
				.bind("idDomandaIscrizione", idDomandaIscrizione);

		IscrittoTGenitoreSolo result = getFirst(this.query(sh, IscrittoTGenitoreSolo.class));

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	//////////////////////////////////////////////////////////////////////

	@Override
	public void insertIscrittoTGenitoreSolo(IscrittoTGenitoreSolo row) throws DaoException {
		final String methodName = "insertIscrittoTGenitoreSolo";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		Validate.notNull(row);
		Validate.notNull(row.getIdDomandaIscrizione());

		log.info(buildMessage(getClass(), methodName, "idDomandaIscrizione: " + row.getIdDomandaIscrizione()));

		final SqlHolder sh = buildSqlHolder(IscrittoTGenitoreSolo.SQL_INSERT)
				.bind("idDomandaIscrizione", row.getIdDomandaIscrizione())
				.bind("numSentenza", row.getNumSentenza())
				.bind("idTipoGenitoreSolo", row.getIdTipoGenitoreSolo())
				.bind("tribunale", row.getTribunale())
				.bind("dtSentenza", row.getDtSentenza());

		this.update(sh);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
	}

	@Override
	public Integer deleteIscrittoTGenitoreSolo(Long idDomandaIscrizione) throws DaoException {
		final String methodName = "deleteIscrittoTGenitoreSolo";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		Validate.notNull(idDomandaIscrizione);

		log.info(buildMessage(getClass(), methodName, "idDomandaIscrizione: " + idDomandaIscrizione));

		final SqlHolder sh = buildSqlHolder(IscrittoTGenitoreSolo.SQL_DELETE)
				.bind("idDomandaIscrizione", idDomandaIscrizione);

		Integer result = this.update(sh);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

}
