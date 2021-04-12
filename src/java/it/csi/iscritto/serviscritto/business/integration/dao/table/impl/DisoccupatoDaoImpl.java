package it.csi.iscritto.serviscritto.business.integration.dao.table.impl;

import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.LOG_BEGIN;
import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.LOG_END;
import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.buildMessage;
import static it.csi.iscritto.serviscritto.business.util.converter.ConvertUtils.getFirst;

import org.apache.commons.lang3.Validate;
import org.apache.log4j.Logger;

import it.csi.iscritto.serviscritto.business.integration.dao.AbstractDao;
import it.csi.iscritto.serviscritto.business.integration.dao.table.DisoccupatoDao;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTDisoccupato;
import it.csi.iscritto.serviscritto.business.integration.exception.DaoException;
import it.csi.iscritto.serviscritto.business.util.Constants;
import it.csi.iscritto.serviscritto.business.util.sql.SqlHolder;

public class DisoccupatoDaoImpl extends AbstractDao implements DisoccupatoDao {
	private static final Logger log = Logger.getLogger(Constants.COMPONENT_NAME + ".dao");

	@Override
	public IscrittoTDisoccupato findDisoccupatoByKey(Long idCondizioneOccupazionale) throws DaoException {
		final String methodName = "findDisoccupatoByKey";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		SqlHolder sh = buildSqlHolder(IscrittoTDisoccupato.SQL_SELECT_ALL)
				.addQueryRows(
						"WHERE 1 = 1",
						"  AND id_condizione_occupazionale = :idCondizioneOccupazionale")
				.bind("idCondizioneOccupazionale", idCondizioneOccupazionale);

		IscrittoTDisoccupato result = getFirst(this.query(sh, IscrittoTDisoccupato.class));

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	//////////////////////////////////////////////////////////////////////

	@Override
	public void insertIscrittoTDisoccupato(IscrittoTDisoccupato row) throws DaoException {
		final String methodName = "insertIscrittoTDisoccupato";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		Validate.notNull(row);
		Validate.notNull(row.getIdCondizioneOccupazionale());

		log.info(buildMessage(getClass(), methodName, "idCondizioneOccupazionale: " + row.getIdCondizioneOccupazionale()));

		final SqlHolder sh = buildSqlHolder(IscrittoTDisoccupato.SQL_INSERT)
				.bind("idCondizioneOccupazionale", row.getIdCondizioneOccupazionale())
				.bind("dtDichiarazioneDisponibili", row.getDtDichiarazioneDisponibili())
				.bind("comuneCpi", row.getComuneCpi())
				.bind("idTipoPresentazione", row.getIdTipoPresentazione())
				.bind("provinciaCpi", row.getProvinciaCpi());

		this.update(sh);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
	}

	@Override
	public Integer deleteIscrittoTDisoccupato(Long idCondizioneOccupazionale) throws DaoException {
		final String methodName = "deleteIscrittoTDisoccupato";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		Validate.notNull(idCondizioneOccupazionale);

		log.info(buildMessage(getClass(), methodName, "idCondizioneOccupazionale: " + idCondizioneOccupazionale));

		final SqlHolder sh = buildSqlHolder(IscrittoTDisoccupato.SQL_DELETE)
				.bind("idCondizioneOccupazionale", idCondizioneOccupazionale);

		Integer result = this.update(sh);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

}
