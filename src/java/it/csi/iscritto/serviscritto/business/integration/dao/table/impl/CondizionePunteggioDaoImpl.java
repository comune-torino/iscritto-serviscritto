package it.csi.iscritto.serviscritto.business.integration.dao.table.impl;

import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.LOG_BEGIN;
import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.LOG_END;
import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.buildMessage;
import static it.csi.iscritto.serviscritto.business.util.converter.ConvertUtils.getFirst;

import org.apache.commons.lang3.Validate;
import org.apache.log4j.Logger;

import it.csi.iscritto.serviscritto.business.integration.dao.AbstractDao;
import it.csi.iscritto.serviscritto.business.integration.dao.table.CondizionePunteggioDao;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoDCondizionePun;
import it.csi.iscritto.serviscritto.business.integration.exception.DaoException;
import it.csi.iscritto.serviscritto.business.util.Constants;
import it.csi.iscritto.serviscritto.business.util.sql.SqlHolder;

/**
 * @author 630
 *
 */
public class CondizionePunteggioDaoImpl extends AbstractDao implements CondizionePunteggioDao {
	private static final Logger log = Logger.getLogger(Constants.COMPONENT_NAME + ".dao");

	/*
	 * (non-Javadoc)
	 *
	 * @see it.csi.iscritto.serviscritto.business.integration.dao.table.CondizionePunteggioDao#findIscrittoDCondizionePunByPk(java.lang.Long)
	 */
	@Override
	public IscrittoDCondizionePun findIscrittoDCondizionePunByPk(Long idCondizionePunteggio) throws DaoException {
		final String methodName = "findIscrittoDCondizionePunByPk";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		SqlHolder sh = buildSqlHolder(IscrittoDCondizionePun.SQL_SELECT_ALL)
				.addQueryRows(
						"WHERE 1 = 1",
						"  AND id_condizione_punteggio = :idCondizionePunteggio")
				.bind("idCondizionePunteggio", idCondizionePunteggio);

		IscrittoDCondizionePun result = getFirst(this.query(sh, IscrittoDCondizionePun.class));

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public Integer deleteIscrittoRPunteggioDomByIdDomanda(Long idDomandaIscrizione) throws DaoException {
		final String methodName = "deleteIscrittoRPunteggioDomByIdDomanda";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		Validate.notNull(idDomandaIscrizione);

		log.info(buildMessage(getClass(), methodName, "idDomandaIscrizione: " + idDomandaIscrizione));

		final SqlHolder sh = buildSqlHolder()
				.addQueryRows(
						"delete from iscritto_r_punteggio_dom",
						"where id_domanda_iscrizione = :idDomandaIscrizione")
				.bind("idDomandaIscrizione", idDomandaIscrizione);

		Integer result = this.update(sh);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

}
