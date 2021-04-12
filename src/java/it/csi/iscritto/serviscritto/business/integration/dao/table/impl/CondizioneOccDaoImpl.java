package it.csi.iscritto.serviscritto.business.integration.dao.table.impl;

import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.LOG_BEGIN;
import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.LOG_END;
import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.buildMessage;
import static it.csi.iscritto.serviscritto.business.util.converter.ConvertUtils.getFirst;

import org.apache.commons.lang3.Validate;
import org.apache.log4j.Logger;

import it.csi.iscritto.serviscritto.business.integration.dao.AbstractDao;
import it.csi.iscritto.serviscritto.business.integration.dao.table.CondizioneOccDao;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTCondizioneOcc;
import it.csi.iscritto.serviscritto.business.integration.exception.DaoException;
import it.csi.iscritto.serviscritto.business.util.Constants;
import it.csi.iscritto.serviscritto.business.util.sql.SqlHolder;

public class CondizioneOccDaoImpl extends AbstractDao implements CondizioneOccDao {
	private static final Logger log = Logger.getLogger(Constants.COMPONENT_NAME + ".dao");

	@Override
	public IscrittoTCondizioneOcc findCondizioneOccByFk(Long idAnagraficaSoggetto) throws DaoException {
		final String methodName = "findCondizioneOccByFk";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		SqlHolder sh = buildSqlHolder(IscrittoTCondizioneOcc.SQL_SELECT_ALL)
				.addQueryRows(
						"WHERE 1 = 1",
						"  AND id_anagrafica_soggetto = :idAnagraficaSoggetto")
				.bind("idAnagraficaSoggetto", idAnagraficaSoggetto);

		IscrittoTCondizioneOcc result = getFirst(this.query(sh, IscrittoTCondizioneOcc.class));

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public IscrittoTCondizioneOcc findCondizioneOccByKey(Long idCondizioneOccupazionale) throws DaoException {
		final String methodName = "findCondizioneOccByKey";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		SqlHolder sh = buildSqlHolder(IscrittoTCondizioneOcc.SQL_SELECT_ALL)
				.addQueryRows(
						"WHERE 1 = 1",
						"  AND id_condizione_occupazionale = :idCondizioneOccupazionale")
				.bind("idCondizioneOccupazionale", idCondizioneOccupazionale);

		IscrittoTCondizioneOcc result = getFirst(this.query(sh, IscrittoTCondizioneOcc.class));

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	//////////////////////////////////////////////////////////////////////

	@Override
	public Long insertIscrittoTCondizioneOcc(IscrittoTCondizioneOcc row) throws DaoException {
		final String methodName = "insertIscrittoTCondizioneOcc";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		Validate.notNull(row);
		Validate.notNull(row.getIdAnagraficaSoggetto());
		Validate.notNull(row.getIdTipCondOccupazionale());

		final Long idCondizioneOccupazionale = this.nextval("iscritto_t_condizione_occ_id_condizione_occupazionale");

		log.info(buildMessage(getClass(), methodName, "idCondizioneOccupazionale: " + idCondizioneOccupazionale));
		log.info(buildMessage(getClass(), methodName, "idAnagraficaSoggetto: " + row.getIdAnagraficaSoggetto()));
		log.info(buildMessage(getClass(), methodName, "idTipCondOccupazionale: " + row.getIdTipCondOccupazionale()));

		final SqlHolder sh = buildSqlHolder(IscrittoTCondizioneOcc.SQL_INSERT)
				.bind("idCondizioneOccupazionale", idCondizioneOccupazionale)
				.bind("idAnagraficaSoggetto", row.getIdAnagraficaSoggetto())
				.bind("idTipCondOccupazionale", row.getIdTipCondOccupazionale());

		this.update(sh);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return idCondizioneOccupazionale;
	}

	@Override
	public Integer deleteIscrittoTCondizioneOcc(Long idCondizioneOccupazionale) throws DaoException {
		final String methodName = "deleteIscrittoTCondizioneOcc";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		Validate.notNull(idCondizioneOccupazionale);

		log.info(buildMessage(getClass(), methodName, "idCondizioneOccupazionale: " + idCondizioneOccupazionale));

		final SqlHolder sh = buildSqlHolder(IscrittoTCondizioneOcc.SQL_DELETE)
				.bind("idCondizioneOccupazionale", idCondizioneOccupazionale);

		Integer result = this.update(sh);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

}
