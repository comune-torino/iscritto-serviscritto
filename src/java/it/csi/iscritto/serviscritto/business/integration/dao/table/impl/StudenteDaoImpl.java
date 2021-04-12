package it.csi.iscritto.serviscritto.business.integration.dao.table.impl;

import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.LOG_BEGIN;
import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.LOG_END;
import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.buildMessage;
import static it.csi.iscritto.serviscritto.business.util.converter.ConvertUtils.getFirst;

import org.apache.commons.lang3.Validate;
import org.apache.log4j.Logger;

import it.csi.iscritto.serviscritto.business.integration.dao.AbstractDao;
import it.csi.iscritto.serviscritto.business.integration.dao.table.StudenteDao;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTStudente;
import it.csi.iscritto.serviscritto.business.integration.exception.DaoException;
import it.csi.iscritto.serviscritto.business.util.Constants;
import it.csi.iscritto.serviscritto.business.util.sql.SqlHolder;

public class StudenteDaoImpl extends AbstractDao implements StudenteDao {
	private static final Logger log = Logger.getLogger(Constants.COMPONENT_NAME + ".dao");

	@Override
	public IscrittoTStudente findStudenteByKey(Long idCondizioneOccupazionale) throws DaoException {
		final String methodName = "findStudenteByKey";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		SqlHolder sh = buildSqlHolder(IscrittoTStudente.SQL_SELECT_ALL)
				.addQueryRows(
						"WHERE 1 = 1",
						"  AND id_condizione_occupazionale = :idCondizioneOccupazionale")
				.bind("idCondizioneOccupazionale", idCondizioneOccupazionale);

		IscrittoTStudente result = getFirst(this.query(sh, IscrittoTStudente.class));

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	//////////////////////////////////////////////////////////////////////

	@Override
	public void insertIscrittoTStudente(IscrittoTStudente row) throws DaoException {
		final String methodName = "insertIscrittoTStudente";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		Validate.notNull(row);
		Validate.notNull(row.getIdCondizioneOccupazionale());

		log.info(buildMessage(getClass(), methodName, "idCondizioneOccupazionale: " + row.getIdCondizioneOccupazionale()));

		final SqlHolder sh = buildSqlHolder(IscrittoTStudente.SQL_INSERT)
				.bind("idCondizioneOccupazionale", row.getIdCondizioneOccupazionale())
				.bind("denominazioneScuola", row.getDenominazioneScuola())
				.bind("indirizzo", row.getIndirizzo())
				.bind("idTipoCorso", row.getIdTipoCorso());

		this.update(sh);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
	}

	@Override
	public Integer deleteIscrittoTStudente(Long idCondizioneOccupazionale) throws DaoException {
		final String methodName = "deleteIscrittoTStudente";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		Validate.notNull(idCondizioneOccupazionale);

		log.info(buildMessage(getClass(), methodName, "idCondizioneOccupazionale: " + idCondizioneOccupazionale));

		final SqlHolder sh = buildSqlHolder(IscrittoTStudente.SQL_DELETE)
				.bind("idCondizioneOccupazionale", idCondizioneOccupazionale);

		Integer result = this.update(sh);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

}
