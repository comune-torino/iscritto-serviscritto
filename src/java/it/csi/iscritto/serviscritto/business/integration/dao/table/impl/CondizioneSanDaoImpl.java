package it.csi.iscritto.serviscritto.business.integration.dao.table.impl;

import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.LOG_BEGIN;
import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.LOG_END;
import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.buildMessage;
import static it.csi.iscritto.serviscritto.business.util.converter.ConvertUtils.getFirst;

import org.apache.commons.lang3.Validate;
import org.apache.log4j.Logger;

import it.csi.iscritto.serviscritto.business.integration.dao.AbstractDao;
import it.csi.iscritto.serviscritto.business.integration.dao.table.CondizioneSanDao;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTCondizioneSan;
import it.csi.iscritto.serviscritto.business.integration.exception.DaoException;
import it.csi.iscritto.serviscritto.business.util.Constants;
import it.csi.iscritto.serviscritto.business.util.sql.SqlHolder;

public class CondizioneSanDaoImpl extends AbstractDao implements CondizioneSanDao {
	private static final Logger log = Logger.getLogger(Constants.COMPONENT_NAME + ".dao");

	@Override
	public IscrittoTCondizioneSan findIscrittoTCondizioneSanByFk(Long idAnagraficaSoggetto) throws DaoException {
		final String methodName = "findIscrittoTCondizioneSanByFk";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		SqlHolder sh = buildSqlHolder()
				.addQueryRows(
						"select",
						"  fdecifra_t(fl_disabilita::bytea, :encryptionKey) as fl_disabilita,",
						"  fdecifra_t(fl_problemi_salute::bytea, :encryptionKey) as fl_problemi_salute,",
						"  fdecifra_t(fl_stato_gravidanza::bytea, :encryptionKey) as fl_stato_gravidanza,",
						"  id_anagrafica_soggetto",
						"from iscritto_t_condizione_san")
				.bind("encryptionKey", this.getEncryptionKey())
				.addQueryRows(
						"WHERE 1 = 1",
						"  AND id_anagrafica_soggetto = :idAnagraficaSoggetto")
				.bind("idAnagraficaSoggetto", idAnagraficaSoggetto);

		IscrittoTCondizioneSan result = getFirst(this.query(sh, IscrittoTCondizioneSan.class));

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	//////////////////////////////////////////////////////////////////////

	@Override
	public void insertIscrittoTCondizioneSan(IscrittoTCondizioneSan row) throws DaoException {
		final String methodName = "insertIscrittoTCondizioneSan";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		Validate.notNull(row);
		Validate.notNull(row.getIdAnagraficaSoggetto());

		log.info(buildMessage(getClass(), methodName, "idAnagraficaSoggetto: " + row.getIdAnagraficaSoggetto()));

		final SqlHolder sh = buildSqlHolder()
				.addQueryRows(
						"insert into iscritto_t_condizione_san (",
						"  fl_disabilita, ",
						"  fl_problemi_salute, ",
						"  fl_stato_gravidanza, ",
						"  id_anagrafica_soggetto ",
						") ",
						"values (",
						"  fcifra_t(:flDisabilita, :encryptionKey),",
						"  fcifra_t(:flProblemiSalute, :encryptionKey),",
						"  fcifra_t(:flStatoGravidanza, :encryptionKey),",
						"  :idAnagraficaSoggetto",
						")")
				.bind("encryptionKey", this.getEncryptionKey())
				.bind("flDisabilita", row.getFlDisabilita())
				.bind("flProblemiSalute", row.getFlProblemiSalute())
				.bind("flStatoGravidanza", row.getFlStatoGravidanza())
				.bind("idAnagraficaSoggetto", row.getIdAnagraficaSoggetto());

		this.update(sh);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
	}

	@Override
	public Integer deleteIscrittoTCondizioneSan(Long idAnagraficaSoggetto) throws DaoException {
		final String methodName = "deleteIscrittoTCondizioneSan";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		Validate.notNull(idAnagraficaSoggetto);

		log.info(buildMessage(getClass(), methodName, "idAnagraficaSoggetto: " + idAnagraficaSoggetto));

		final SqlHolder sh = buildSqlHolder(IscrittoTCondizioneSan.SQL_DELETE)
				.bind("idAnagraficaSoggetto", idAnagraficaSoggetto);

		Integer result = this.update(sh);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

}
