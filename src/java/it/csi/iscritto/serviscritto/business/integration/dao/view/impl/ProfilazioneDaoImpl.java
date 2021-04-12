package it.csi.iscritto.serviscritto.business.integration.dao.view.impl;

import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.LOG_BEGIN;
import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.LOG_END;
import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.buildMessage;

import java.util.List;

import org.apache.commons.lang3.Validate;
import org.apache.log4j.Logger;

import it.csi.iscritto.serviscritto.business.integration.dao.AbstractDao;
import it.csi.iscritto.serviscritto.business.integration.dao.TipoScuola;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoDProfilo;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTAttivita;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTFunzione;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTUtente;
import it.csi.iscritto.serviscritto.business.integration.dao.view.ProfilazioneDao;
import it.csi.iscritto.serviscritto.business.integration.dao.view.dto.InfoCondizionePunteggioRow;
import it.csi.iscritto.serviscritto.business.integration.dao.view.dto.PrivilegioOperatoreRow;
import it.csi.iscritto.serviscritto.business.integration.dao.view.dto.ProtocolloRow;
import it.csi.iscritto.serviscritto.business.integration.exception.DaoException;
import it.csi.iscritto.serviscritto.business.util.Constants;
import it.csi.iscritto.serviscritto.business.util.converter.ConvertUtils;
import it.csi.iscritto.serviscritto.business.util.sql.SqlHolder;

public class ProfilazioneDaoImpl extends AbstractDao implements ProfilazioneDao {
	private static final Logger log = Logger.getLogger(Constants.COMPONENT_NAME + ".dao");

	@Override
	public List<IscrittoTFunzione> findFunzioni(String codFiscale, String codProfilo) throws DaoException {
		final String methodName = "findFunzioni";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		SqlHolder sh = buildSqlHolder()
				.addQueryRows(
						"select distinct",
						"  itf.id_funzione,",
						"  itf.cod_funzione,",
						"  itf.descrizione,",
						"  itf.link",
						"from iscritto_t_utente itu",
						"  join iscritto_r_utente_profilo irup on irup.id_utente = itu.id_utente",
						"  join iscritto_d_profilo idp on idp.id_profilo = irup.id_profilo",
						"  join iscritto_r_profilo_pri irpp on irpp.id_profilo = idp.id_profilo",
						"  join iscritto_t_privilegio itp on itp.id_privilegio = irpp.id_privilegio",
						"  join iscritto_t_attivita ita on ita.id_attivita = itp.id_attivita",
						"  join iscritto_t_funzione itf on itf.id_funzione = ita.id_funzione",
						"where 1 = 1",
						"  and itu.fl_eliminato = 'N'",
						"  and upper(itu.codice_fiscale) = :codFiscale",
						"  and idp.codice_profilo = :codProfilo",
						"  and now() between irup.dt_inizio and coalesce(irup.dt_fine, now())")
				.bind("codFiscale", ConvertUtils.toUpper(codFiscale))
				.bind("codProfilo", codProfilo);

		List<IscrittoTFunzione> result = this.query(sh, IscrittoTFunzione.class);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public List<IscrittoDProfilo> findProfili(String codFiscale) throws DaoException {
		final String methodName = "findProfili";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		SqlHolder sh = buildSqlHolder()
				.addQueryRows(
						"select distinct",
						"  idp.id_profilo, ",
						"  idp.codice_profilo, ",
						"  idp.descrizione ",
						"from iscritto_t_utente itu",
						"  join iscritto_r_utente_profilo irup on irup.id_utente = itu.id_utente",
						"  join iscritto_d_profilo idp on idp.id_profilo = irup.id_profilo",
						"where 1 = 1",
						"  and itu.fl_eliminato = 'N'",
						"  and upper(itu.codice_fiscale) = :codFiscale",
						"  and now() between irup.dt_inizio and coalesce(irup.dt_fine, now())")
				.bind("codFiscale", ConvertUtils.toUpper(codFiscale));

		List<IscrittoDProfilo> result = this.query(sh, IscrittoDProfilo.class);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public Boolean findAssegnamentoNidi(String codFiscale) throws DaoException {
		final String methodName = "findAssegnamentoNidi";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		log.info("@@ find assegnamento Nidi");

		SqlHolder sh = buildSqlHolder()
				.addQueryRows(
						"select its.cod_scuola ",
						"from iscritto_t_utente itu",
						"  join iscritto_r_utente_profilo irup on irup.id_utente = itu.id_utente",
						"  join iscritto_d_profilo idp on idp.id_profilo = irup.id_profilo",
						"  join iscritto_r_profilo_scuole irps on irup.id_prof_ute = irps.id_prof_ute ",
						"  join iscritto_t_scuola its on irps.id_scuola = its.id_scuola ",
						"where 1 = 1",
						"  and itu.fl_eliminato = 'N'",
						"  and upper(itu.codice_fiscale) = :codFiscale",
						"  and its.id_ordine_scuola = 1 ",
						"  and idp.codice_profilo = 'P3' ",
						"  and now() between irup.dt_inizio and coalesce(irup.dt_fine, now()) ",
						"  limit 1 "
						)
				.bind("codFiscale", ConvertUtils.toUpper(codFiscale));

		List<String> result = this.query(sh, String.class);
		log.debug(buildMessage(getClass(), methodName, LOG_END));
		if(!result.isEmpty()) {
			log.info("@@ abilitato nidi");
			return true;

		}else {
			log.info("@@ NON abilitato Nidi");
			return false;
		}

	}

	@Override
	public Boolean findAssegnamentoMaterne(String codFiscale) throws DaoException {
		final String methodName = "findAssegnamentoMaterne";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));
		log.info("@@ find assegnamento Materne");

		SqlHolder sh = buildSqlHolder()
				.addQueryRows(
						"select its.cod_scuola ",
						"from iscritto_t_utente itu",
						"  join iscritto_r_utente_profilo irup on irup.id_utente = itu.id_utente",
						"  join iscritto_d_profilo idp on idp.id_profilo = irup.id_profilo",
						"  join iscritto_r_profilo_scuole irps on irup.id_prof_ute = irps.id_prof_ute ",
						"  join iscritto_t_scuola its on irps.id_scuola = its.id_scuola ",
						"where 1 = 1",
						"  and itu.fl_eliminato = 'N'",
						"  and upper(itu.codice_fiscale) = :codFiscale",
						"  and its.id_ordine_scuola = 2 ",
						"  and idp.codice_profilo = 'P3' ",
						"  and now() between irup.dt_inizio and coalesce(irup.dt_fine, now()) ",
						"  limit 1"
						)
				.bind("codFiscale", ConvertUtils.toUpper(codFiscale));

		List<String> result = this.query(sh, String.class);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		if(!result.isEmpty()) {
			log.info("@@ abilitato materne");
			return true;

		}else {
			log.info("@@ NON abilitato materne");
			return false;
		}

	}

	@Override
	public List<IscrittoTAttivita> findAttivita(String codFiscale, String codProfilo, String codFunzione) throws DaoException {
		final String methodName = "findAttivita";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		SqlHolder sh = buildSqlHolder()
				.addQueryRows(
						"select distinct",
						"  ita.id_attivita,",
						"  ita.cod_attivita,",
						"  ita.descrizione,",
						"  ita.link,",
						"  ita.ordinamento",
						"from iscritto_t_utente itu",
						"  join iscritto_r_utente_profilo irup on irup.id_utente = itu.id_utente",
						"  join iscritto_d_profilo idp on idp.id_profilo = irup.id_profilo",
						"  join iscritto_r_profilo_pri irpp on irpp.id_profilo = idp.id_profilo",
						"  join iscritto_t_privilegio itp on itp.id_privilegio = irpp.id_privilegio",
						"  join iscritto_t_attivita ita on ita.id_attivita = itp.id_attivita",
						"  join iscritto_t_funzione itf on itf.id_funzione = ita.id_funzione",
						"where 1 = 1",
						"  and itu.fl_eliminato = 'N'",
						"  and upper(itu.codice_fiscale) = :codFiscale",
						"  and idp.codice_profilo = :codProfilo",
						"  and itf.cod_funzione = :codFunzione",
						"  and now() between irup.dt_inizio and coalesce(irup.dt_fine, now())",
						"order by ita.ordinamento")
				.bind("codFiscale", ConvertUtils.toUpper(codFiscale))
				.bind("codProfilo", codProfilo)
				.bind("codFunzione", codFunzione);

		List<IscrittoTAttivita> result = this.query(sh, IscrittoTAttivita.class);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public List<PrivilegioOperatoreRow> findPrivilegi(String codFiscale, String codProfilo) throws DaoException {
		final String methodName = "findPrivilegi";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		SqlHolder sh = buildSqlHolder()
				.addQueryRows(
						"select",
						"  itu.id_utente,",
						"  itu.codice_fiscale,",
						"  itu.cognome,",
						"  itu.nome,",
						"  idp.codice_profilo,",
						"  itp.id_privilegio,",
						"  itp.cod_privilegio,",
						"  itp.descrizione,",
						"  itp.id_attivita",
						"from iscritto_t_utente itu",
						"  join iscritto_r_utente_profilo irup on irup.id_utente = itu.id_utente",
						"  join iscritto_d_profilo idp on idp.id_profilo = irup.id_profilo",
						"  join iscritto_r_profilo_pri irpp on irpp.id_profilo = idp.id_profilo",
						"  join iscritto_t_privilegio itp on itp.id_privilegio = irpp.id_privilegio",
						"where 1 = 1",
						"  and itu.fl_eliminato = 'N'",
						"  and upper(itu.codice_fiscale) = :codFiscale",
						"  and idp.codice_profilo = :codProfilo",
						"  and now() between irup.dt_inizio and coalesce(irup.dt_fine, now())")
				.bind("codFiscale", ConvertUtils.toUpper(codFiscale))
				.bind("codProfilo", codProfilo);

		List<PrivilegioOperatoreRow> result = this.query(sh, PrivilegioOperatoreRow.class);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public List<InfoCondizionePunteggioRow> findCondizioniPunteggio(TipoScuola tipoScuola, String codFiscale, String codProfilo, String tipoIstruttoria)
			throws DaoException {

		final String methodName = "findCondizioniPunteggio";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		Validate.notNull(tipoScuola);

		SqlHolder sh = buildSqlHolder()
				.addQueryRows(
						"with condizioni_punteggio as (",
						"  select",
						"    rp.id_condizione_punteggio",
						"  from iscritto_r_profilo_cp rp",
						"    join iscritto_r_utente_profilo irup on irup.id_profilo = rp.id_profilo",
						"    join iscritto_t_utente itu on itu.id_utente = irup.id_utente",
						"    join iscritto_d_profilo idp on idp.id_profilo = irup.id_profilo",
						"  where 1 = 1",
						"    and itu.fl_eliminato = 'N'",
						"    and upper(itu.codice_fiscale) = :codFiscale",
						"    and idp.codice_profilo = :codProfilo",
						"    and now() between irup.dt_inizio and coalesce(irup.dt_fine, now())",
						")",
						"select",
						"  cp.cod_condizione,",
						"  cp.descrizione,",
						"  cp.id_condizione_punteggio,",
						"  cp.fl_istruttoria,",
						"  ti.cod_tipo_istruttoria,",
						"  ta.cod_tipo_allegato",
						"from iscritto_d_condizione_pun cp",
						"  join iscritto_d_tipo_ist ti on cp.id_tipo_istruttoria = ti.id_tipo_istruttoria",
						"  join iscritto_t_punteggio p on p.id_condizione_punteggio = cp.id_condizione_punteggio",
						"  join iscritto_d_ordine_scuola ord on ord.id_ordine_scuola = p.id_ordine_scuola",
						"  left outer join iscritto_d_tipo_all ta on cp.id_tipo_allegato = ta.id_tipo_allegato",
						"where 1 = 1",
						"  and cp.fl_istruttoria = :tipoIstruttoria",
						"  and ord.cod_ordine_scuola = :codOrdineScuola",
						"  and cp.id_condizione_punteggio in(",
						"    select id_condizione_punteggio from condizioni_punteggio",
						"  )",
						"  and now() between p.dt_inizio_validita and coalesce(p.dt_fine_validita, now())")
				.bind("tipoIstruttoria", tipoIstruttoria)
				.bind("codFiscale", ConvertUtils.toUpper(codFiscale))
				.bind("codProfilo", codProfilo)
				.bind("codOrdineScuola", tipoScuola.getCod());

		List<InfoCondizionePunteggioRow> result = this.query(sh, InfoCondizionePunteggioRow.class);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public IscrittoTUtente findUtenteByCodFiscale(String codFiscale) throws DaoException {
		final String methodName = "findUtenteByCodFiscale";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		SqlHolder sh = buildSqlHolder()
				.addQueryRows(
						"select",
						"  id_utente,",
						"  codice_fiscale,",
						"  cognome,",
						"  nome,",
						"  id_profilo,",
						"  fl_eliminato",
						"from iscritto_t_utente",
						"where 1 = 1",
						"  and fl_eliminato = 'N'",
						"  and upper(codice_fiscale) = :codFiscale")
				.bind("codFiscale", ConvertUtils.toUpper(codFiscale));

		IscrittoTUtente result = ConvertUtils.getFirst(this.query(sh, IscrittoTUtente.class));

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

}
