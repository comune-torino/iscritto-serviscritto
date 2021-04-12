package it.csi.iscritto.serviscritto.business.integration.dao.table.impl;

import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.LOG_BEGIN;
import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.LOG_END;
import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.buildMessage;
import static it.csi.iscritto.serviscritto.business.util.converter.ConvertUtils.getFirst;

import org.apache.commons.lang3.Validate;
import org.apache.log4j.Logger;

import it.csi.iscritto.serviscritto.business.integration.dao.AbstractDao;
import it.csi.iscritto.serviscritto.business.integration.dao.table.CambioResDao;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTCambioRes;
import it.csi.iscritto.serviscritto.business.integration.exception.DaoException;
import it.csi.iscritto.serviscritto.business.util.Constants;
import it.csi.iscritto.serviscritto.business.util.sql.SqlHolder;

public class CambioResDaoImpl extends AbstractDao implements CambioResDao {
	private static final Logger log = Logger.getLogger(Constants.COMPONENT_NAME + ".dao");

	@Override
	public IscrittoTCambioRes findIscrittoTCambioResByFk(Long idDomandaIscrizione) throws DaoException {
		final String methodName = "findIscrittoTCambioResByFk";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		SqlHolder sh = buildSqlHolder(IscrittoTCambioRes.SQL_SELECT_ALL)
				.addQueryRows(
						"WHERE 1 = 1",
						"  AND id_domanda_iscrizione = :idDomandaIscrizione")
				.bind("idDomandaIscrizione", idDomandaIscrizione);

		IscrittoTCambioRes result = getFirst(this.query(sh, IscrittoTCambioRes.class));

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	//////////////////////////////////////////////////////////////////////

	@Override
	public void insertIscrittoTCambioRes(IscrittoTCambioRes row) throws DaoException {
		final String methodName = "insertIscrittoTCambioRes";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		Validate.notNull(row);
		Validate.notNull(row.getIdDomandaIscrizione());

		log.info(buildMessage(getClass(), methodName, "idDomandaIscrizione: " + row.getIdDomandaIscrizione()));

		final SqlHolder sh = buildSqlHolder(IscrittoTCambioRes.SQL_INSERT)
				.bind("idDomandaIscrizione", row.getIdDomandaIscrizione())
				.bind("idTipoCambioRes", row.getIdTipoCambioRes())
				.bind("dtVariazione", row.getDtVariazione())
				.bind("dtAppuntamento", row.getDtAppuntamento())
				.bind("motivazione", row.getMotivazione())
				.bind("indirizzo", row.getIndirizzo());

		this.update(sh);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
	}

	@Override
	public Integer deleteIscrittoTCambioRes(Long idDomandaIscrizione) throws DaoException {
		final String methodName = "deleteIscrittoTCambioRes";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		Validate.notNull(idDomandaIscrizione);

		log.info(buildMessage(getClass(), methodName, "idDomandaIscrizione: " + idDomandaIscrizione));

		final SqlHolder sh = buildSqlHolder(IscrittoTCambioRes.SQL_DELETE)
				.bind("idDomandaIscrizione", idDomandaIscrizione);

		Integer result = this.update(sh);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

}
