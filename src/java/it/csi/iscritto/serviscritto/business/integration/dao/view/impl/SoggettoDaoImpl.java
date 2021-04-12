package it.csi.iscritto.serviscritto.business.integration.dao.view.impl;

import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.LOG_BEGIN;
import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.LOG_END;
import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.buildMessage;

import java.util.List;

import org.apache.commons.lang3.Validate;
import org.apache.log4j.Logger;

import it.csi.iscritto.serviscritto.business.integration.dao.AbstractDao;
import it.csi.iscritto.serviscritto.business.integration.dao.TipoSoggetto;
import it.csi.iscritto.serviscritto.business.integration.dao.view.SoggettoDao;
import it.csi.iscritto.serviscritto.business.integration.dao.view.dto.SoggettoRow;
import it.csi.iscritto.serviscritto.business.integration.exception.DaoException;
import it.csi.iscritto.serviscritto.business.util.Constants;
import it.csi.iscritto.serviscritto.business.util.sql.SqlHolder;

public class SoggettoDaoImpl extends AbstractDao implements SoggettoDao {
	private static final Logger log = Logger.getLogger(Constants.COMPONENT_NAME + ".dao");

	@Override
	public List<SoggettoRow> findSoggettiByIdDomanda(Long idDomandaIscrizione, TipoSoggetto tipoSoggetto) throws DaoException {
		final String methodName = "findSoggettiByIdDomanda";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		Validate.notNull(idDomandaIscrizione);
		Validate.notNull(tipoSoggetto);

		SqlHolder sh = buildBaseQuery()
				.addQueryRows(
						"where 1 = 1",
						"  and sog.id_domanda_iscrizione = :idDomandaIscrizione",
						"  and tip.cod_tipo_soggetto = :codTipoSoggetto");

		sh.bind("idDomandaIscrizione", idDomandaIscrizione);
		sh.bind("codTipoSoggetto", tipoSoggetto.getCod());

		List<SoggettoRow> result = this.query(sh, SoggettoRow.class);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public List<SoggettoRow> findSoggettiByIdDomanda(Long idDomandaIscrizione) throws DaoException {
		final String methodName = "findSoggettiByIdDomanda";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		Validate.notNull(idDomandaIscrizione);

		SqlHolder sh = buildBaseQuery()
				.addQueryRows(
						"where 1 = 1",
						"  and sog.id_domanda_iscrizione = :idDomandaIscrizione");

		sh.bind("idDomandaIscrizione", idDomandaIscrizione);

		List<SoggettoRow> result = this.query(sh, SoggettoRow.class);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public List<SoggettoRow> findSoggettiByIdSoggetto(Long idAnagraficaSoggetto) throws DaoException {
		final String methodName = "findSoggettiByIdSoggetto";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		Validate.notNull(idAnagraficaSoggetto);

		SqlHolder sh = buildBaseQuery()
				.addQueryRows(
						"where 1 = 1",
						"  and sog.id_anagrafica_soggetto = :idAnagraficaSoggetto");

		sh.bind("idAnagraficaSoggetto", idAnagraficaSoggetto);

		List<SoggettoRow> result = this.query(sh, SoggettoRow.class);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	private static SqlHolder buildBaseQuery() {
		return buildSqlHolder(
				"select",
				"  sog.cognome,",
				"  sog.nome,",
				"  sog.data_nascita,",
				"  sog.codice_fiscale,",
				"  sog.sesso,",
				"  sog.id_domanda_iscrizione,",
				"  sog.id_anagrafica_soggetto,",
				"  sog.id_rel_parentela,",
				"  sog.id_comune_nascita,",
				"  sog.id_stato_nascita,",
				"  sog.ora_nascita,",
				"  sog.fl_residenza_nao,",
				"  tip.cod_tipo_soggetto,",
				"  stato.codice as cod_cittadinanza,",
				"  stato.cittadinanza as desc_cittadinanza",
				"from iscritto_t_anagrafica_sog sog",
				"  join iscritto_r_soggetto_rel r on sog.id_anagrafica_soggetto = r.id_anagrafica_soggetto",
				"  join iscritto_d_tipo_sog tip on r.id_tipo_soggetto = tip.id_tipo_soggetto",
				"  left join iscritto_t_stato stato on stato.id_stato = sog.id_stato_citt");
	}

}
