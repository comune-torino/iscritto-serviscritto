package it.csi.iscritto.serviscritto.business.integration.dao.table.impl;

import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.LOG_BEGIN;
import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.LOG_END;
import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.buildMessage;
import static it.csi.iscritto.serviscritto.business.util.converter.ConvertUtils.getFirst;

import org.apache.commons.lang3.Validate;
import org.apache.log4j.Logger;

import it.csi.iscritto.serviscritto.business.integration.dao.AbstractDao;
import it.csi.iscritto.serviscritto.business.integration.dao.table.FratelloFreDao;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoRNidoContiguo;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTFratelloFre;
import it.csi.iscritto.serviscritto.business.integration.exception.DaoException;
import it.csi.iscritto.serviscritto.business.util.Constants;
import it.csi.iscritto.serviscritto.business.util.sql.SqlHolder;

public class FratelloFreDaoImpl extends AbstractDao implements FratelloFreDao {
	private static final Logger log = Logger.getLogger(Constants.COMPONENT_NAME + ".dao");

	@Override
	public IscrittoTFratelloFre findIscrittoTFratelloFreByKey(Long idFratelloFrequentante) throws DaoException {
		final String methodName = "findIscrittoTFratelloFreByKey";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		SqlHolder sh = buildSqlHolder(IscrittoTFratelloFre.SQL_SELECT_ALL)
				.addQueryRows(
						"WHERE 1 = 1",
						"  AND id_fratello_frequentante = :idFratelloFrequentante")
				.bind("idDomandaIscrizione", idFratelloFrequentante);

		IscrittoTFratelloFre result = getFirst(this.query(sh, IscrittoTFratelloFre.class));

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public IscrittoTFratelloFre findIscrittoTFratelloFreByFk(Long idDomandaIscrizione) throws DaoException {
		final String methodName = "findIscrittoTFratelloFreByFk";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		SqlHolder sh = buildSqlHolder(IscrittoTFratelloFre.SQL_SELECT_ALL)
				.addQueryRows(
						"WHERE 1 = 1",
						"  AND id_domanda_iscrizione = :idDomandaIscrizione")
				.bind("idDomandaIscrizione", idDomandaIscrizione);

		IscrittoTFratelloFre result = getFirst(this.query(sh, IscrittoTFratelloFre.class));

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public IscrittoRNidoContiguo findIscrittoRNidoContiguoByIdDomanda(Long idDomandaIsc) throws DaoException {
		final String methodName = "findIscrittoTFratelloFreByFk";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		SqlHolder sh = buildSqlHolder()
				.addQueryRows(
						"select",
						"  id_domanda_isc,",
						"  id_anagrafica_soggetto,",
						"  id_nido_contiguo",
						"from",
						"  iscritto_r_nido_contiguo",
						"where",
						"  id_domanda_isc = :idDomandaIsc")
				.bind("idDomandaIsc", idDomandaIsc);

		IscrittoRNidoContiguo result = getFirst(this.query(sh, IscrittoRNidoContiguo.class));

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public Integer deleteIscrittoRNidoContiguo(Long idDomandaIsc) throws DaoException {
		final String methodName = "deleteIscrittoRNidoContiguo";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		Validate.notNull(idDomandaIsc);

		log.info(buildMessage(getClass(), methodName, "idDomandaIsc: " + idDomandaIsc));

		final SqlHolder sh = buildSqlHolder(
				"delete from iscritto_r_nido_contiguo where id_domanda_isc = :idDomandaIsc")
						.bind("idDomandaIsc", idDomandaIsc);

		Integer result = this.update(sh);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	//////////////////////////////////////////////////////////////////////

	@Override
	public Long insertIscrittoTFratelloFre(IscrittoTFratelloFre row) throws DaoException {
		final String methodName = "insertIscrittoTFratelloFre";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		Validate.notNull(row);

		final Long idFratelloFrequentante = this.nextval("iscritto_t_fratello_fre_id_fratello_frequentante");

		log.info(buildMessage(getClass(), methodName, "idFratelloFrequentante: " + idFratelloFrequentante));

		final SqlHolder sh = buildSqlHolder(IscrittoTFratelloFre.SQL_INSERT)
				.bind("idFratelloFrequentante", idFratelloFrequentante)
				.bind("idDomandaIscrizione", row.getIdDomandaIscrizione())
				.bind("cognomeFratello", row.getCognomeFratello())
				.bind("cfFratello", row.getCfFratello())
				.bind("nomeFratello", row.getNomeFratello())
				.bind("dtNascita", row.getDtNascita())
				.bind("sesso", row.getSesso())
				.bind("idTipoFratello", row.getIdTipoFratello())
				.bind("idStatoCitt", row.getIdStatoCitt());

		this.update(sh);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return idFratelloFrequentante;
	}

	@Override
	public Integer deleteIscrittoTFratelloFreByFk(Long idDomandaIscrizione) throws DaoException {
		final String methodName = "deleteIscrittoTFratelloFre";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		Validate.notNull(idDomandaIscrizione);

		log.info(buildMessage(getClass(), methodName, "idDomandaIscrizione: " + idDomandaIscrizione));

		final SqlHolder sh = buildSqlHolder(
				"delete from iscritto_t_fratello_fre where id_domanda_iscrizione = :idDomandaIscrizione")
						.bind("idDomandaIscrizione", idDomandaIscrizione);

		Integer result = this.update(sh);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public void insertIscrittoRNidoContiguo(IscrittoRNidoContiguo row) throws DaoException {
		final String methodName = "insertIscrittoRNidoContiguo";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		Validate.notNull(row);

		log.info(buildMessage(getClass(), methodName, "idDomandaIsc: " + row.getIdDomandaIsc()));
		log.info(buildMessage(getClass(), methodName, "idAnagraficaSoggetto: " + row.getIdAnagraficaSoggetto()));
		log.info(buildMessage(getClass(), methodName, "idNidoContiguo: " + row.getIdNidoContiguo()));

		final SqlHolder sh = buildSqlHolder()
				.addQueryRows(
						"insert into iscritto_r_nido_contiguo (",
						"  id_domanda_isc,",
						"  id_anagrafica_soggetto,",
						"  id_nido_contiguo",
						")",
						"values (",
						"  :idDomandaIsc,",
						"  :idAnagraficaSoggetto,",
						"  :idNidoContiguo",
						")")
				.bind("idDomandaIsc", row.getIdDomandaIsc())
				.bind("idAnagraficaSoggetto", row.getIdAnagraficaSoggetto())
				.bind("idNidoContiguo", row.getIdNidoContiguo());

		this.update(sh);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
	}

}
