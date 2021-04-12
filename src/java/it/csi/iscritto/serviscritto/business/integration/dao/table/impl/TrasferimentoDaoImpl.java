package it.csi.iscritto.serviscritto.business.integration.dao.table.impl;

import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.LOG_BEGIN;
import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.LOG_END;
import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.buildMessage;
import static it.csi.iscritto.serviscritto.business.util.converter.ConvertUtils.getFirst;

import org.apache.commons.lang3.Validate;
import org.apache.log4j.Logger;

import it.csi.iscritto.serviscritto.business.integration.dao.AbstractDao;
import it.csi.iscritto.serviscritto.business.integration.dao.table.TrasferimentoDao;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTTrasferimento;
import it.csi.iscritto.serviscritto.business.integration.exception.DaoException;
import it.csi.iscritto.serviscritto.business.util.Constants;
import it.csi.iscritto.serviscritto.business.util.sql.SqlHolder;

public class TrasferimentoDaoImpl extends AbstractDao implements TrasferimentoDao {
	private static final Logger log = Logger.getLogger(Constants.COMPONENT_NAME + ".dao");

	@Override
	public IscrittoTTrasferimento findIscrittoTTrasferimentoByFk(Long idDomandaIscrizione) throws DaoException {
		final String methodName = "findIscrittoTTrasferimentoByFk";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		SqlHolder sh = buildSqlHolder(IscrittoTTrasferimento.SQL_SELECT_ALL)
				.addQueryRows(
						"WHERE 1 = 1",
						"  AND id_domanda_iscrizione = :idDomandaIscrizione")
				.bind("idDomandaIscrizione", idDomandaIscrizione);

		IscrittoTTrasferimento result = getFirst(this.query(sh, IscrittoTTrasferimento.class));

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	//////////////////////////////////////////////////////////////////////

	@Override
	public void insertIscrittoTTrasferimento(IscrittoTTrasferimento row) throws DaoException {
		final String methodName = "insertIscrittoTTrasferimento";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		Validate.notNull(row);
		Validate.notNull(row.getIdDomandaIscrizione());

		log.info(buildMessage(getClass(), methodName, "idDomandaIscrizione: " + row.getIdDomandaIscrizione()));

		final SqlHolder sh = buildSqlHolder(IscrittoTTrasferimento.SQL_INSERT)
				.bind("idDomandaIscrizione", row.getIdDomandaIscrizione())
				.bind("dtCambioResidenza", row.getDtCambioResidenza())
				.bind("indirizzoResidenzaPre", row.getIndirizzoResidenzaPre())
				.bind("indirizzoResidenzaNew", row.getIndirizzoResidenzaNew())
				.bind("indirizzoNidoProv", row.getIndirizzoNidoProv())
				.bind("frequenzaDal", row.getFrequenzaDal())
				.bind("frequenzaAl", row.getFrequenzaAl());

		this.update(sh);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
	}

	@Override
	public Integer deleteIscrittoTTrasferimento(Long idDomandaIscrizione) throws DaoException {
		final String methodName = "deleteIscrittoTTrasferimento";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		Validate.notNull(idDomandaIscrizione);

		log.info(buildMessage(getClass(), methodName, "idDomandaIscrizione: " + idDomandaIscrizione));

		final SqlHolder sh = buildSqlHolder(IscrittoTTrasferimento.SQL_DELETE)
				.bind("idDomandaIscrizione", idDomandaIscrizione);

		Integer result = this.update(sh);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

}
