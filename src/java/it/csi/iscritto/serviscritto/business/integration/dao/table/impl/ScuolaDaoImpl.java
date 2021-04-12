package it.csi.iscritto.serviscritto.business.integration.dao.table.impl;

import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.LOG_BEGIN;
import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.LOG_END;
import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.buildMessage;
import static it.csi.iscritto.serviscritto.business.util.converter.ConvertUtils.getFirst;

import java.util.List;

import org.apache.commons.lang3.Validate;
import org.apache.log4j.Logger;

import it.csi.iscritto.serviscritto.business.integration.dao.AbstractDao;
import it.csi.iscritto.serviscritto.business.integration.dao.TipoScuola;
import it.csi.iscritto.serviscritto.business.integration.dao.table.ScuolaDao;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoRScuolaPre;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTScuola;
import it.csi.iscritto.serviscritto.business.integration.exception.DaoException;
import it.csi.iscritto.serviscritto.business.util.Constants;
import it.csi.iscritto.serviscritto.business.util.converter.ConvertUtils;
import it.csi.iscritto.serviscritto.business.util.sql.SqlHolder;

public class ScuolaDaoImpl extends AbstractDao implements ScuolaDao {
	private static final Logger log = Logger.getLogger(Constants.COMPONENT_NAME + ".dao");

	@Override
	public IscrittoTScuola findIscrittoTScuolaByKey(Long idScuola) throws DaoException {
		final String methodName = "findIscrittoTScuolaByKey";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		SqlHolder sh = buildSqlHolder(IscrittoTScuola.SQL_SELECT_ALL)
				.addQueryRows(
						"WHERE 1 = 1",
						"  AND id_scuola = :idScuola")
				.bind("idScuola", idScuola);

		IscrittoTScuola result = getFirst(this.query(sh, IscrittoTScuola.class));

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public IscrittoTScuola findIscrittoTScuolaByCod(TipoScuola tipoScuola, String codScuola) throws DaoException {
		final String methodName = "findIscrittoTScuolaByCod";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		SqlHolder sh = buildSqlHolder(IscrittoTScuola.SQL_SELECT_ALL)
				.addQueryRows(
						"WHERE 1 = 1",
						"  AND id_ordine_scuola = (select id_ordine_scuola from iscritto_d_ordine_scuola where cod_ordine_scuola = :codOrdineScuola)",
						"  AND cod_scuola = :codScuola")
				.bind("codOrdineScuola", tipoScuola.getCod())
				.bind("codScuola", codScuola);

		IscrittoTScuola result = getFirst(this.query(sh, IscrittoTScuola.class));

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public List<IscrittoRScuolaPre> findIscrittoRScuolaPreByFk(Long idDomandaIscrizione) throws DaoException {
		final String methodName = "findIscrittoRScuolaPreByFk";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		SqlHolder sh = buildSqlHolder(IscrittoRScuolaPre.SQL_SELECT_ALL)
				.addQueryRows(
						"WHERE 1 = 1",
						"  AND id_domanda_iscrizione = :idDomandaIscrizione",
						"ORDER BY posizione")
				.bind("idDomandaIscrizione", idDomandaIscrizione);

		List<IscrittoRScuolaPre> result = this.query(sh, IscrittoRScuolaPre.class);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	//////////////////////////////////////////////////////////////////////

	@Override
	public void insertIscrittoRScuolaPre(IscrittoRScuolaPre row) throws DaoException {
		final String methodName = "insertIscrittoRScuolaPre";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		Validate.notNull(row);

		log.info(buildMessage(getClass(), methodName, "idDomandaIscrizione: " + row.getIdDomandaIscrizione()));
		log.info(buildMessage(getClass(), methodName, "idScuola: " + row.getIdScuola()));
		log.info(buildMessage(getClass(), methodName, "idTipoFrequenza: " + row.getIdTipoFrequenza()));

		Validate.notNull(row.getIdDomandaIscrizione());
		Validate.notNull(row.getIdScuola());
		Validate.notNull(row.getIdTipoFrequenza());

		final SqlHolder sh = buildSqlHolder(IscrittoRScuolaPre.SQL_INSERT)
				.bind("posizione", row.getPosizione())
				.bind("idDomandaIscrizione", row.getIdDomandaIscrizione())
				.bind("idScuola", row.getIdScuola())
				.bind("flFuoriTermine", row.getFlFuoriTermine())
				.bind("idTipoFrequenza", row.getIdTipoFrequenza())
				.bind("punteggio", row.getPunteggio())
				.bind("flRinuncia", row.getFlRinuncia())
				.bind("idStatoScu", row.getIdStatoScu())
				.bind("dtStato", row.getDtStato());

		this.update(sh);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
	}

	@Override
	public Integer deleteIscrittoRScuolaPreByFk(Long idDomandaIscrizione) throws DaoException {
		final String methodName = "deleteIscrittoRScuolaPre";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		log.info(buildMessage(getClass(), methodName, "idDomandaIscrizione: " + idDomandaIscrizione));
		Validate.notNull(idDomandaIscrizione);

		final SqlHolder sh = buildSqlHolder(
				"delete from iscritto_r_scuola_pre where id_domanda_iscrizione = :idDomandaIscrizione")
						.bind("idDomandaIscrizione", idDomandaIscrizione);

		Integer result = this.update(sh);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public Integer updateFlagFuoriTermine(Long idDomandaIscrizione, boolean flag) throws DaoException {
		final String methodName = "updateFlagFuoriTermine";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		log.debug(buildMessage(getClass(), methodName, "idDomandaIscrizione: " + idDomandaIscrizione));
		log.debug(buildMessage(getClass(), methodName, "flag: " + flag));

		Validate.notNull(idDomandaIscrizione);

		final SqlHolder sh = buildSqlHolder()
				.addQueryRows(
						"update iscritto_r_scuola_pre set",
						"  fl_fuori_termine = :flag",
						"where",
						"  id_domanda_iscrizione = :idDomandaIscrizione")
				.bind("idDomandaIscrizione", idDomandaIscrizione)
				.bind("flag", ConvertUtils.toSN(flag));

		Integer result = this.update(sh);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public Integer annullaPreferenze(Long idDomandaIscrizione) throws DaoException {
		final String methodName = "annullaPreferenze";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		log.debug(buildMessage(getClass(), methodName, "idDomandaIscrizione: " + idDomandaIscrizione));

		Validate.notNull(idDomandaIscrizione);

		final SqlHolder sh = buildSqlHolder()
				.addQueryRows(
						"update iscritto_r_scuola_pre set",
						"  id_stato_scu = (select id_stato_scu from iscritto_d_stato_scu where cod_stato_scu = 'ANN'),",
						"  dt_stato = now()",
						"where",
						"  id_stato_scu = (select id_stato_scu from iscritto_d_stato_scu where cod_stato_scu = 'PEN') and",
						"  id_domanda_iscrizione = :idDomandaIscrizione")
				.bind("idDomandaIscrizione", idDomandaIscrizione);

		Integer result = this.update(sh);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

}
