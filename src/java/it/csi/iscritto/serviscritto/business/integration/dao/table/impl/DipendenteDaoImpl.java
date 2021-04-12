package it.csi.iscritto.serviscritto.business.integration.dao.table.impl;

import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.LOG_BEGIN;
import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.LOG_END;
import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.buildMessage;
import static it.csi.iscritto.serviscritto.business.util.converter.ConvertUtils.getFirst;

import org.apache.commons.lang3.Validate;
import org.apache.log4j.Logger;

import it.csi.iscritto.serviscritto.business.integration.dao.AbstractDao;
import it.csi.iscritto.serviscritto.business.integration.dao.table.DipendenteDao;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTDipendente;
import it.csi.iscritto.serviscritto.business.integration.exception.DaoException;
import it.csi.iscritto.serviscritto.business.util.Constants;
import it.csi.iscritto.serviscritto.business.util.sql.SqlHolder;

public class DipendenteDaoImpl extends AbstractDao implements DipendenteDao {
	private static final Logger log = Logger.getLogger(Constants.COMPONENT_NAME + ".dao");

	@Override
	public IscrittoTDipendente findDipendenteByKey(Long idCondizioneOccupazionale) throws DaoException {
		final String methodName = "findDipendenteByKey";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		SqlHolder sh = buildSqlHolder(IscrittoTDipendente.SQL_SELECT_ALL)
				.addQueryRows(
						"WHERE 1 = 1",
						"  AND id_condizione_occupazionale = :idCondizioneOccupazionale")
				.bind("idCondizioneOccupazionale", idCondizioneOccupazionale);

		IscrittoTDipendente result = getFirst(this.query(sh, IscrittoTDipendente.class));

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	//////////////////////////////////////////////////////////////////////

	@Override
	public void insertIscrittoTDipendente(IscrittoTDipendente row) throws DaoException {
		final String methodName = "insertIscrittoTDipendente";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		Validate.notNull(row);
		Validate.notNull(row.getIdCondizioneOccupazionale());

		log.info(buildMessage(getClass(), methodName, "idCondizioneOccupazionale: " + row.getIdCondizioneOccupazionale()));

		final SqlHolder sh = buildSqlHolder(IscrittoTDipendente.SQL_INSERT)
				.bind("idCondizioneOccupazionale", row.getIdCondizioneOccupazionale())
				.bind("azienda", row.getAzienda())
				.bind("comuneLavoro", row.getComuneLavoro())
				.bind("indirizzoLavoro", row.getIndirizzoLavoro())
				.bind("provinciaLavoro", row.getProvinciaLavoro());

		this.update(sh);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
	}

	@Override
	public Integer deleteIscrittoTDipendente(Long idCondizioneOccupazionale) throws DaoException {
		final String methodName = "deleteIscrittoTDipendente";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		Validate.notNull(idCondizioneOccupazionale);

		log.info(buildMessage(getClass(), methodName, "idCondizioneOccupazionale: " + idCondizioneOccupazionale));

		final SqlHolder sh = buildSqlHolder(IscrittoTDipendente.SQL_DELETE)
				.bind("idCondizioneOccupazionale", idCondizioneOccupazionale);

		Integer result = this.update(sh);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

}
