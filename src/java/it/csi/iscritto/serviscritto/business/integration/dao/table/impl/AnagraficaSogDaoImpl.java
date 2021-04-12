package it.csi.iscritto.serviscritto.business.integration.dao.table.impl;

import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.LOG_BEGIN;
import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.LOG_END;
import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.buildMessage;
import static it.csi.iscritto.serviscritto.business.util.converter.ConvertUtils.getFirst;

import java.util.List;

import org.apache.commons.lang3.Validate;
import org.apache.log4j.Logger;

import it.csi.iscritto.serviscritto.business.integration.dao.AbstractDao;
import it.csi.iscritto.serviscritto.business.integration.dao.table.AnagraficaSogDao;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTAnagraficaSog;
import it.csi.iscritto.serviscritto.business.integration.exception.DaoException;
import it.csi.iscritto.serviscritto.business.util.Constants;
import it.csi.iscritto.serviscritto.business.util.converter.ConvertUtils;
import it.csi.iscritto.serviscritto.business.util.sql.SqlHolder;

public class AnagraficaSogDaoImpl extends AbstractDao implements AnagraficaSogDao {
	private static final Logger log = Logger.getLogger(Constants.COMPONENT_NAME + ".dao");

	@Override
	public IscrittoTAnagraficaSog findIscrittoTAnagraficaSogByKey(Long idAnagraficaSoggetto) throws DaoException {
		final String methodName = "findIscrittoTAnagraficaSogByKey";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		SqlHolder sh = buildSqlHolder(IscrittoTAnagraficaSog.SQL_SELECT_ALL)
				.addQueryRows(
						"WHERE 1 = 1",
						"  AND id_anagrafica_soggetto = :idAnagraficaSoggetto")
				.bind("idAnagraficaSoggetto", idAnagraficaSoggetto);

		IscrittoTAnagraficaSog result = getFirst(this.query(sh, IscrittoTAnagraficaSog.class));

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public List<IscrittoTAnagraficaSog> findIscrittoTAnagraficaSogByIdDomanda(Long idDomandaIscrizione) throws DaoException {
		final String methodName = "findIscrittoTAnagraficaSogByIdDomanda";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		SqlHolder sh = buildSqlHolder(IscrittoTAnagraficaSog.SQL_SELECT_ALL)
				.addQueryRows(
						"WHERE 1 = 1",
						"  AND id_domanda_iscrizione = :idDomandaIscrizione")
				.bind("idDomandaIscrizione", idDomandaIscrizione);

		List<IscrittoTAnagraficaSog> result = this.query(sh, IscrittoTAnagraficaSog.class);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	//////////////////////////////////////////////////////////////////////

	@Override
	public Long insertIscrittoTAnagraficaSog(IscrittoTAnagraficaSog row) throws DaoException {
		final String methodName = "insertIscrittoTAnagraficaSog";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		Validate.notNull(row);
		Validate.notNull(row.getIdDomandaIscrizione());

		final Long idAnagraficaSoggetto = this.nextval("iscritto_t_anagrafica_sog_id_anagrafica_soggetto");

		log.info(buildMessage(getClass(), methodName, "idDomandaIscrizione: " + row.getIdDomandaIscrizione()));
		log.info(buildMessage(getClass(), methodName, "idAnagraficaSoggetto: " + idAnagraficaSoggetto));

		final SqlHolder sh = buildSqlHolder(IscrittoTAnagraficaSog.SQL_INSERT)
				.bind("cognome", row.getCognome())
				.bind("nome", row.getNome())
				.bind("dataNascita", row.getDataNascita())
				.bind("codiceFiscale", row.getCodiceFiscale())
				.bind("sesso", row.getSesso())
				.bind("idDomandaIscrizione", row.getIdDomandaIscrizione())
				.bind("idAnagraficaSoggetto", idAnagraficaSoggetto)
				.bind("flResidenzaNao", row.getFlResidenzaNao())
				.bind("idRelParentela", row.getIdRelParentela())
				.bind("idStatoCitt", row.getIdStatoCitt())
				.bind("idComuneNascita", row.getIdComuneNascita())
				.bind("idStatoNascita", row.getIdStatoNascita())
				.bind("oraNascita", row.getOraNascita());

		this.update(sh);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return idAnagraficaSoggetto;
	}

	@Override
	public Integer deleteIscrittoTAnagraficaSog(Long idAnagraficaSoggetto) throws DaoException {
		final String methodName = "deleteIscrittoTAnagraficaSog";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		Validate.notNull(idAnagraficaSoggetto);

		log.info(buildMessage(getClass(), methodName, "idAnagraficaSoggetto: " + idAnagraficaSoggetto));

		final SqlHolder sh = buildSqlHolder(IscrittoTAnagraficaSog.SQL_DELETE)
				.bind("idAnagraficaSoggetto", idAnagraficaSoggetto);

		Integer result = this.update(sh);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public Integer updateIscrittoTAnagraficaSogForNao(Long idAnagraficaSoggetto, Boolean flResidenzaNao) throws DaoException {
		final String methodName = "updateIscrittoTAnagraficaSogForNao";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		Validate.notNull(idAnagraficaSoggetto);

		log.info(buildMessage(getClass(), methodName, "idAnagraficaSoggetto: " + idAnagraficaSoggetto));

		final SqlHolder sh = buildSqlHolder()
				.addQueryRows(
						"update iscritto_t_anagrafica_sog set",
						"  fl_residenza_nao = :flResidenzaNao",
						"where id_anagrafica_soggetto = :idAnagraficaSoggetto")
				.bind("flResidenzaNao", flResidenzaNao == null ? null : ConvertUtils.toSN(flResidenzaNao))
				.bind("idAnagraficaSoggetto", idAnagraficaSoggetto);

		Integer result = this.update(sh);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

}
