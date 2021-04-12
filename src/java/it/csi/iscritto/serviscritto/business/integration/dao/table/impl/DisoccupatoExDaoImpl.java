package it.csi.iscritto.serviscritto.business.integration.dao.table.impl;

import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.LOG_BEGIN;
import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.LOG_END;
import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.buildMessage;

import java.util.List;

import org.apache.commons.lang3.Validate;
import org.apache.log4j.Logger;

import it.csi.iscritto.serviscritto.business.integration.dao.AbstractDao;
import it.csi.iscritto.serviscritto.business.integration.dao.table.DisoccupatoExDao;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTDisoccupatoEx;
import it.csi.iscritto.serviscritto.business.integration.exception.DaoException;
import it.csi.iscritto.serviscritto.business.util.Constants;
import it.csi.iscritto.serviscritto.business.util.sql.SqlHolder;

public class DisoccupatoExDaoImpl extends AbstractDao implements DisoccupatoExDao {
	private static final Logger log = Logger.getLogger(Constants.COMPONENT_NAME + ".dao");

	@Override
	public List<IscrittoTDisoccupatoEx> findDisoccupatoExByFk(Long idCondizioneOccupazionale) throws DaoException {
		final String methodName = "findDisoccupatoExByFk";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		SqlHolder sh = buildSqlHolder(IscrittoTDisoccupatoEx.SQL_SELECT_ALL)
				.addQueryRows(
						"WHERE 1 = 1",
						"  AND id_condizione_occupazionale = :idCondizioneOccupazionale")
				.bind("idCondizioneOccupazionale", idCondizioneOccupazionale);

		List<IscrittoTDisoccupatoEx> result = this.query(sh, IscrittoTDisoccupatoEx.class);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	//////////////////////////////////////////////////////////////////////

	@Override
	public Long insertIscrittoTDisoccupatoEx(IscrittoTDisoccupatoEx row) throws DaoException {
		final String methodName = "insertIscrittoTDisoccupatoEx";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		Validate.notNull(row);

		final Long idDisoccupatoExLav = this.nextval("iscritto_t_disoccupato_ex_id_disoccupato_ex_lav");

		log.info(buildMessage(getClass(), methodName, "idDisoccupatoExLav: " + idDisoccupatoExLav));

		final SqlHolder sh = buildSqlHolder(IscrittoTDisoccupatoEx.SQL_INSERT)
				.bind("idDisoccupatoExLav", idDisoccupatoExLav)
				.bind("aziendaPivaCf", row.getAziendaPivaCf())
				.bind("comuneLavoro", row.getComuneLavoro())
				.bind("indirizzo", row.getIndirizzo())
				.bind("lavoroDal", row.getLavoroDal())
				.bind("lavoroAl", row.getLavoroAl())
				.bind("idCondizioneOccupazionale", row.getIdCondizioneOccupazionale());

		this.update(sh);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return idDisoccupatoExLav;
	}

	@Override
	public Integer deleteIscrittoTDisoccupatoEx(Long idDisoccupatoExLav) throws DaoException {
		final String methodName = "deleteIscrittoTDisoccupatoEx";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		Validate.notNull(idDisoccupatoExLav);

		log.info(buildMessage(getClass(), methodName, "idDisoccupatoExLav: " + idDisoccupatoExLav));

		final SqlHolder sh = buildSqlHolder(IscrittoTDisoccupatoEx.SQL_DELETE)
				.bind("idDisoccupatoExLav", idDisoccupatoExLav);

		Integer result = this.update(sh);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

}
