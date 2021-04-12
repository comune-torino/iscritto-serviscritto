package it.csi.iscritto.serviscritto.business.integration.dao.view.impl;

import static it.csi.iscritto.serviscritto.business.util.DateUtils.ISO_8601_FORMAT;
import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.LOG_BEGIN;
import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.LOG_END;
import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.buildMessage;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import org.apache.log4j.Logger;

import it.csi.iscritto.serviscritto.business.integration.dao.AbstractDao;
import it.csi.iscritto.serviscritto.business.integration.dao.StatoCondizionePunteggio;
import it.csi.iscritto.serviscritto.business.integration.dao.TipoScuola;
import it.csi.iscritto.serviscritto.business.integration.dao.TipoSoggetto;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTDomandaIsc;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTUtente;
import it.csi.iscritto.serviscritto.business.integration.dao.view.DomandaDao;
import it.csi.iscritto.serviscritto.business.integration.dao.view.dto.CodificaRow;
import it.csi.iscritto.serviscritto.business.integration.dao.view.dto.CondizionePunteggioRow;
import it.csi.iscritto.serviscritto.business.integration.dao.view.dto.InfoDomandaRow;
import it.csi.iscritto.serviscritto.business.integration.dao.view.dto.ProtocolloRow;
import it.csi.iscritto.serviscritto.business.integration.dao.view.dto.TestataDomandaDaVerificareRow;
import it.csi.iscritto.serviscritto.business.integration.dao.view.dto.TestataDomandaIstruttoriaRow;
import it.csi.iscritto.serviscritto.business.integration.dao.view.dto.TestataDomandaRow;
import it.csi.iscritto.serviscritto.business.integration.exception.DaoException;
import it.csi.iscritto.serviscritto.business.util.Constants;
import it.csi.iscritto.serviscritto.business.util.DateUtils;
import it.csi.iscritto.serviscritto.business.util.converter.ConvertUtils;
import it.csi.iscritto.serviscritto.business.util.sql.SqlHolder;

public class DomandaDaoImpl extends AbstractDao implements DomandaDao {
	private static final Logger log = Logger.getLogger(Constants.COMPONENT_NAME + ".dao");

/*
	private boolean filtroEconomaComunale(String cfOperatore) throws DaoException{

		SqlHolder rs = buildSqlHolder()
				.addQueryRows(
						"select itu.*",
						"from iscritto_t_utente itu",
						"join iscritto_r_utente_profilo irup on irup.id_utente = itu.id_utente ",
						"join iscritto_d_profilo idp on irup.id_profilo = idp.id_profilo",
						"join iscritto_r_profilo_pri irpc on idp.id_profilo = irpc.id_profilo",
						"join iscritto_t_privilegio itp on irpc.id_privilegio = itp.id_privilegio",
						"where itp.cod_privilegio = 'P_RIC_DOM_ECO_COM'",
						"      and upper(itu.codice_fiscale) = :cfOperatore"
						)
				.bind("cfOperatore", ConvertUtils.toUpper(cfOperatore));

		IscrittoTUtente utente = ConvertUtils.getFirst(this.query(rs, IscrittoTUtente.class)) ;


		if(utente != null) {
			log.info("Economa Comunale");
			return true	;
		}else {
			return false;
		}
	}

	private boolean filtroEconomaStatale(String cfOperatore) throws DaoException{


		SqlHolder rs = buildSqlHolder()
				.addQueryRows(
						"select itu.*",
						"from iscritto_t_utente itu",
						"join iscritto_r_utente_profilo irup on irup.id_utente = itu.id_utente ",
						"join iscritto_d_profilo idp on irup.id_profilo = idp.id_profilo",
						"join iscritto_r_profilo_pri irpc on idp.id_profilo = irpc.id_profilo",
						"join iscritto_t_privilegio itp on irpc.id_privilegio = itp.id_privilegio",
						"where itp.cod_privilegio = 'P_RIC_DOM_ECO_STA'",
						"      and upper(itu.codice_fiscale) = :cfOperatore"
						)
				.bind("cfOperatore", ConvertUtils.toUpper(cfOperatore));

		IscrittoTUtente utente = ConvertUtils.getFirst(this.query(rs, IscrittoTUtente.class)) ;


		if(utente != null) {
			log.info("Economa Statale");
			return true	;
		}else {
			return false;
		}
	}
*/
	private boolean filtroEconomaStataleIstruttoria(String cfOperatore) throws DaoException{


		SqlHolder rs = buildSqlHolder()
				.addQueryRows(
						"select itu.*",
						"from iscritto_t_utente itu",
						"join iscritto_r_utente_profilo irup on irup.id_utente = itu.id_utente ",
						"join iscritto_d_profilo idp on irup.id_profilo = idp.id_profilo",
						"join iscritto_r_profilo_pri irpc on idp.id_profilo = irpc.id_profilo",
						"join iscritto_t_privilegio itp on irpc.id_privilegio = itp.id_privilegio",
						"where itp.cod_privilegio = 'P_ISTR_PRE_STA'",
						"      and upper(itu.codice_fiscale) = :cfOperatore"
						)
				.bind("cfOperatore", ConvertUtils.toUpper(cfOperatore));

		IscrittoTUtente utente = ConvertUtils.getFirst(this.query(rs, IscrittoTUtente.class)) ;


		if(utente != null) {
			log.info("Economa Statale");
			return true	;
		}else {
			return false;
		}
	}


	@Override
	public List<Long> findDomandeByCodiceFiscaleRichiedente(TipoScuola tipoScuola, String codiceFiscale) throws DaoException {

		final String methodName = "findDomandeByCodiceFiscaleRichiedente";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		log.info("^^ 1");

		SqlHolder sh = buildSqlHolder()
				.addQueryRows(
						"select distinct",
						"  a.id_domanda_iscrizione,",
						"  a.dt_modifica",
						"from iscritto_t_domanda_isc a",
						"  join iscritto_t_anagrafica_sog sog on sog.id_domanda_iscrizione = a.id_domanda_iscrizione",
						"  join iscritto_r_soggetto_rel r on sog.id_anagrafica_soggetto = r.id_anagrafica_soggetto",
						"  join iscritto_d_tipo_sog tip on r.id_tipo_soggetto = tip.id_tipo_soggetto",
						"  left join iscritto_r_scuola_pre scuola_iscr on scuola_iscr.id_domanda_iscrizione = a.id_domanda_iscrizione",
						"  left join iscritto_t_scuola scuola on scuola.id_scuola = scuola_iscr.id_scuola",
						"where 1 = 1",
						"  and a.id_ordine_scuola = (",
						"    select id_ordine_scuola from iscritto_d_ordine_scuola where cod_ordine_scuola = :codOrdineScuola",
						"  )",
						"  and tip.cod_tipo_soggetto = :tipoSoggetto",
						"  and upper(sog.codice_fiscale) = :codiceFiscale",
						"order by",
						"  a.dt_modifica desc")
				.bind("codOrdineScuola", tipoScuola.getCod())
				.bind("codiceFiscale", ConvertUtils.toUpper(codiceFiscale))
				.bind("tipoSoggetto", TipoSoggetto.RIC.getCod());

		List<Long> result = getIdDomande(this.query(sh, IscrittoTDomandaIsc.class));

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public List<Long> findDomandeByCodiceFiscaleMinore(TipoScuola tipoScuola, String cfOperatore, String codProfilo, String codiceFiscale)
			throws DaoException {

		final String methodName = "findDomandeByCodiceFiscaleMinore";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		log.info("codice fiscale operatore "+cfOperatore);
		log.info("codice profilo "+codProfilo);
		log.info("codice fiscale operatore "+ codiceFiscale);
		log.info("^^ 2");
		List<Long> result = null;


		if(codProfilo.equals("P11")) {
			log.info("^^ 2.1");
			//economa comunale
			SqlHolder sh = buildSqlHolder()
					.addQueryRows(
							"select distinct",
							"  a.id_domanda_iscrizione,",
							"  a.dt_modifica",
							"from iscritto_t_domanda_isc a",
							"  join iscritto_t_anagrafica_sog sog on sog.id_domanda_iscrizione = a.id_domanda_iscrizione",
							"  join iscritto_r_soggetto_rel r on sog.id_anagrafica_soggetto = r.id_anagrafica_soggetto",
							"  join iscritto_d_tipo_sog tip on r.id_tipo_soggetto = tip.id_tipo_soggetto",
							"  join iscritto_r_scuola_pre scuola_iscr on scuola_iscr.id_domanda_iscrizione = a.id_domanda_iscrizione",
							"  join iscritto_t_scuola scuola on scuola.id_scuola = scuola_iscr.id_scuola",
							"where 1 = 1",
							"  and scuola.id_scuola in(",
							"    select distinct",
							"      irps.id_scuola",
							"    from iscritto_t_utente itu",
							"      join iscritto_r_utente_profilo irup on irup.id_utente = itu.id_utente",
							"      join iscritto_d_profilo idp on idp.id_profilo = irup.id_profilo",
							"      join iscritto_r_profilo_scuole irps on irps.id_prof_ute = irup.id_prof_ute",
							"      join iscritto_r_scuola_pre irsp on irps.id_scuola = irsp.id_scuola",
							"    where 1 = 1",
							"      and itu.fl_eliminato = 'N'",
							"      and upper(itu.codice_fiscale) = :cfOperatore",
							"      and idp.codice_profilo = :codProfilo",
							"      and irsp.id_stato_scu = 4",
							"      and now() between irup.dt_inizio and coalesce(irup.dt_fine, now())",
							"  )",
							"  and a.id_stato_dom = 7 ",
							"  and a.id_ordine_scuola = (",
							"    select id_ordine_scuola from iscritto_d_ordine_scuola where cod_ordine_scuola = :codOrdineScuola",
							"  )",
							"  and tip.cod_tipo_soggetto = :tipoSoggetto",
							"  and upper(sog.codice_fiscale) = :codiceFiscale",
							"order by",
							"  a.dt_modifica desc"
					 )
					.bind("cfOperatore", ConvertUtils.toUpper(cfOperatore))
					.bind("codProfilo", codProfilo)
					.bind("codOrdineScuola", tipoScuola.getCod())
					.bind("codiceFiscale", ConvertUtils.toUpper(codiceFiscale))
					.bind("tipoSoggetto", TipoSoggetto.MIN.getCod());

			result = getIdDomande(this.query(sh, IscrittoTDomandaIsc.class));

		}else if(codProfilo.equals("P12")) {
			log.info("^^ 2.2");
			//economa statale

			SqlHolder sh = buildSqlHolder()
					.addQueryRows(
							"select distinct",
							"  a.id_domanda_iscrizione,",
							"  a.dt_modifica",
							"from iscritto_t_domanda_isc a",
							"  join iscritto_t_anagrafica_sog sog on sog.id_domanda_iscrizione = a.id_domanda_iscrizione",
							"  join iscritto_r_soggetto_rel r on sog.id_anagrafica_soggetto = r.id_anagrafica_soggetto",
							"  join iscritto_d_tipo_sog tip on r.id_tipo_soggetto = tip.id_tipo_soggetto",
							"  join iscritto_r_scuola_pre scuola_iscr on scuola_iscr.id_domanda_iscrizione = a.id_domanda_iscrizione",
							"  join iscritto_t_scuola scuola on scuola.id_scuola = scuola_iscr.id_scuola",
							"where 1 = 1",
							"  and scuola.id_scuola in(",
							"    select",
							"      irps.id_scuola",
							"    from iscritto_t_utente itu",
							"      join iscritto_r_utente_profilo irup on irup.id_utente = itu.id_utente",
							"      join iscritto_d_profilo idp on idp.id_profilo = irup.id_profilo",
							"      join iscritto_r_profilo_scuole irps on irps.id_prof_ute = irup.id_prof_ute",
							"    where 1 = 1",
							"      and itu.fl_eliminato = 'N'",
							"      and upper(itu.codice_fiscale) = :cfOperatore",
							"      and idp.codice_profilo = :codProfilo",
							"      and now() between irup.dt_inizio and coalesce(irup.dt_fine, now())",
							"  )",
							"  and a.id_ordine_scuola = (",
							"    select id_ordine_scuola from iscritto_d_ordine_scuola where cod_ordine_scuola = :codOrdineScuola",
							"  )",
							"  and position(to_char(a.id_stato_dom) in statodomanda(a.id_domanda_iscrizione, scuola.id_scuola)) <> 0",
							"  and tip.cod_tipo_soggetto = :tipoSoggetto",
							"  and upper(sog.codice_fiscale) = :codiceFiscale",
							"order by",
							"  a.dt_modifica desc"
							)
					.bind("cfOperatore", ConvertUtils.toUpper(cfOperatore))
					.bind("codProfilo", codProfilo)
					.bind("codOrdineScuola", tipoScuola.getCod())
					.bind("codiceFiscale", ConvertUtils.toUpper(codiceFiscale))
					.bind("tipoSoggetto", TipoSoggetto.MIN.getCod());

			result = getIdDomande(this.query(sh, IscrittoTDomandaIsc.class));
		} else {
			log.info("^^ 2.3");
			//caso base
			SqlHolder sh = buildSqlHolder()
					.addQueryRows(
							"select distinct",
							"  a.id_domanda_iscrizione,",
							"  a.dt_modifica",
							"from iscritto_t_domanda_isc a",
							"  join iscritto_t_anagrafica_sog sog on sog.id_domanda_iscrizione = a.id_domanda_iscrizione",
							"  join iscritto_r_soggetto_rel r on sog.id_anagrafica_soggetto = r.id_anagrafica_soggetto",
							"  join iscritto_d_tipo_sog tip on r.id_tipo_soggetto = tip.id_tipo_soggetto",
							"  join iscritto_r_scuola_pre scuola_iscr on scuola_iscr.id_domanda_iscrizione = a.id_domanda_iscrizione",
							"  join iscritto_t_scuola scuola on scuola.id_scuola = scuola_iscr.id_scuola",
							"where 1 = 1",
							"  and scuola.id_scuola in(",
							"    select",
							"      irps.id_scuola",
							"    from iscritto_t_utente itu",
							"      join iscritto_r_utente_profilo irup on irup.id_utente = itu.id_utente",
							"      join iscritto_d_profilo idp on idp.id_profilo = irup.id_profilo",
							"      join iscritto_r_profilo_scuole irps on irps.id_prof_ute = irup.id_prof_ute",
							"    where 1 = 1",
							"      and itu.fl_eliminato = 'N'",
							"      and upper(itu.codice_fiscale) = :cfOperatore",
							"      and idp.codice_profilo = :codProfilo",
							"      and now() between irup.dt_inizio and coalesce(irup.dt_fine, now())",
							"  )",
							"  and a.id_ordine_scuola = (",
							"    select id_ordine_scuola from iscritto_d_ordine_scuola where cod_ordine_scuola = :codOrdineScuola",
							"  )",
							"  and tip.cod_tipo_soggetto = :tipoSoggetto",
							"  and upper(sog.codice_fiscale) = :codiceFiscale",
							"order by",
							"  a.dt_modifica desc"
							)
					.bind("cfOperatore", ConvertUtils.toUpper(cfOperatore))
					.bind("codProfilo", codProfilo)
					.bind("codOrdineScuola", tipoScuola.getCod())
					.bind("codiceFiscale", ConvertUtils.toUpper(codiceFiscale))
					.bind("tipoSoggetto", TipoSoggetto.MIN.getCod());

			result = getIdDomande(this.query(sh, IscrittoTDomandaIsc.class));
		}


		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public TestataDomandaRow findTestataDomandaRicByIdDomanda(Long idDomanda) throws DaoException {
		final String methodName = "findTestataDomandaRicByIdDomanda";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		log.info("^^ 3");
		SqlHolder sh = buildSqlHolder(
				"select ",
				"  a.id_domanda_iscrizione,",
				"  a.protocollo,",
				"  sog.id_anagrafica_soggetto as id_soggetto_minore,",
				"  sog.cognome as cognome_minore, ",
				"  sog.nome as nome_minore, ",
				"  sog.codice_fiscale as codice_fiscale_minore,",
				"  sta.cod_stato_dom as stato_domanda_codice,",
				"  sta.descrizione as stato_domanda_descrizione,",
				"  a.dt_modifica as data_ultima_modifica,",
				"  ute.cognome as cognome_utente,",
				"  ute.nome as nome_utente",
				"from ",
				"  iscritto_t_domanda_isc a",
				"  join iscritto_t_anagrafica_sog sog on sog.id_domanda_iscrizione = a.id_domanda_iscrizione",
				"  left outer join iscritto_t_utente ute on ute.id_utente = a.id_utente_mod",
				"  join iscritto_d_stato_dom sta on sta.id_stato_dom = a.id_stato_dom",
				"  join iscritto_r_soggetto_rel r on sog.id_anagrafica_soggetto = r.id_anagrafica_soggetto",
				"  join iscritto_d_tipo_sog tip on r.id_tipo_soggetto = tip.id_tipo_soggetto ",
				"where ",
				"  a.id_domanda_iscrizione = :idDomanda and tip.cod_tipo_soggetto = 'MIN'");

		sh.bind("idDomanda", idDomanda);

		// il ritorno della query e' sempre un array list anche in presenza di un solo elemento trovato.
		// si tratta di una caratteristica della API JdbcNamedTemplate
		TestataDomandaRow result = ConvertUtils.getFirst(this.query(sh, TestataDomandaRow.class));

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public List<Long> findDomandeByCognomeNomeMinore(TipoScuola tipoScuola, String cfOperatore, String codProfilo, String cognome, String nome)
			throws DaoException {

		final String methodName = "findDomandeByCognomeNomeMinore";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));
		log.info("codice fiscale operatore "+cfOperatore);
		log.info("codice profilo "+codProfilo);
		log.info("ognome "+ cognome);
		log.info("nome "+nome);
		log.info("^^ 4");
		List<Long> result = null;


		if(codProfilo.equals("P11")) {
			log.info("^^ 4.1");
			//economa comunale
			SqlHolder sh = buildSqlHolder()
					.addQueryRows(
							"select distinct",
							"  a.id_domanda_iscrizione",
							"from iscritto_t_domanda_isc a",
							"  join iscritto_t_anagrafica_sog sog on sog.id_domanda_iscrizione = a.id_domanda_iscrizione",
							"  join iscritto_r_soggetto_rel r on sog.id_anagrafica_soggetto = r.id_anagrafica_soggetto",
							"  join iscritto_d_tipo_sog tip on r.id_tipo_soggetto = tip.id_tipo_soggetto",
							"  join iscritto_d_stato_dom stato on a.id_stato_dom = stato.id_stato_dom",
							"  join iscritto_r_scuola_pre scuola_iscr on scuola_iscr.id_domanda_iscrizione = a.id_domanda_iscrizione",
							"  join iscritto_t_scuola scuola on scuola.id_scuola = scuola_iscr.id_scuola",
							"where 1 = 1",
							"  and scuola.id_scuola in(",
							"    select distinct",
							"      irps.id_scuola",
							"    from iscritto_t_utente itu",
							"      join iscritto_r_utente_profilo irup on irup.id_utente = itu.id_utente",
							"      join iscritto_d_profilo idp on idp.id_profilo = irup.id_profilo",
							"      join iscritto_r_profilo_scuole irps on irps.id_prof_ute = irup.id_prof_ute",
							"      join iscritto_r_scuola_pre irsp on irps.id_scuola = irsp.id_scuola",
							"    where 1 = 1",
							"      and itu.fl_eliminato = 'N'",
							"      and upper(itu.codice_fiscale) = :cfOperatore",
							"      and idp.codice_profilo = :codProfilo",
							"      and irsp.id_stato_scu = 4",
							"      and now() between irup.dt_inizio and coalesce(irup.dt_fine, now())",
							"  )",
							"  and a.id_stato_dom = 7 ",
							"  and a.id_ordine_scuola = (",
							"    select id_ordine_scuola from iscritto_d_ordine_scuola where cod_ordine_scuola = :codOrdineScuola",
							"  )"
							)
					.bind("cfOperatore", ConvertUtils.toUpper(cfOperatore))
					.bind("codProfilo", codProfilo)
					.bind("codOrdineScuola", tipoScuola.getCod());

			if (StringUtils.isNotBlank(cognome)) {
				sh.addQueryRows("  and upper(sog.cognome) like(:cognome)");
				sh.bind("cognome", ConvertUtils.toUpper(cognome) + "%");
			}

			if (StringUtils.isNotBlank(nome)) {
				sh.addQueryRows("  and upper(sog.nome) like(:nome)");
				sh.bind("nome", ConvertUtils.toUpper(nome) + "%");
			}

			result = this.queryForList(sh, Long.class);

		}else if(codProfilo.equals("P12")) {
			log.info("^^ 4.2");
			SqlHolder sh = buildSqlHolder()
					.addQueryRows(
							"select distinct",
							"  a.id_domanda_iscrizione",
							"from iscritto_t_domanda_isc a",
							"  join iscritto_t_anagrafica_sog sog on sog.id_domanda_iscrizione = a.id_domanda_iscrizione",
							"  join iscritto_r_soggetto_rel r on sog.id_anagrafica_soggetto = r.id_anagrafica_soggetto",
							"  join iscritto_d_tipo_sog tip on r.id_tipo_soggetto = tip.id_tipo_soggetto",
							"  join iscritto_d_stato_dom stato on a.id_stato_dom = stato.id_stato_dom",
							"  join iscritto_r_scuola_pre scuola_iscr on scuola_iscr.id_domanda_iscrizione = a.id_domanda_iscrizione",
							"  join iscritto_t_scuola scuola on scuola.id_scuola = scuola_iscr.id_scuola",
							"where 1 = 1",
							"  and scuola.id_scuola in(",
							"    select",
							"      irps.id_scuola",
							"    from iscritto_t_utente itu",
							"      join iscritto_r_utente_profilo irup on irup.id_utente = itu.id_utente",
							"      join iscritto_d_profilo idp on idp.id_profilo = irup.id_profilo",
							"      join iscritto_r_profilo_scuole irps on irps.id_prof_ute = irup.id_prof_ute",
							"    where 1 = 1",
							"      and itu.fl_eliminato = 'N'",
							"      and upper(itu.codice_fiscale) = :cfOperatore",
							"      and idp.codice_profilo = :codProfilo",
							"      and now() between irup.dt_inizio and coalesce(irup.dt_fine, now())",
							"  )",
							"  and position(to_char(a.id_stato_dom) in statodomanda(a.id_domanda_iscrizione, scuola.id_scuola)) <> 0",
							"  and a.id_ordine_scuola = (",
							"    select id_ordine_scuola from iscritto_d_ordine_scuola where cod_ordine_scuola = :codOrdineScuola",
							"  )"
					)
					.bind("cfOperatore", ConvertUtils.toUpper(cfOperatore))
					.bind("codProfilo", codProfilo)
					.bind("codOrdineScuola", tipoScuola.getCod());

			if (StringUtils.isNotBlank(cognome)) {
				sh.addQueryRows("  and upper(sog.cognome) like(:cognome)");
				sh.bind("cognome", ConvertUtils.toUpper(cognome) + "%");
			}

			if (StringUtils.isNotBlank(nome)) {
				sh.addQueryRows("  and upper(sog.nome) like(:nome)");
				sh.bind("nome", ConvertUtils.toUpper(nome) + "%");
			}

			result = this.queryForList(sh, Long.class);
		} else {
			log.info("^^ 4.3");
			//caso base
			SqlHolder sh = buildSqlHolder()
					.addQueryRows(
							"select distinct",
							"  a.id_domanda_iscrizione",
							"from iscritto_t_domanda_isc a",
							"  join iscritto_t_anagrafica_sog sog on sog.id_domanda_iscrizione = a.id_domanda_iscrizione",
							"  join iscritto_r_soggetto_rel r on sog.id_anagrafica_soggetto = r.id_anagrafica_soggetto",
							"  join iscritto_d_tipo_sog tip on r.id_tipo_soggetto = tip.id_tipo_soggetto",
							"  join iscritto_d_stato_dom stato on a.id_stato_dom = stato.id_stato_dom",
							"  join iscritto_r_scuola_pre scuola_iscr on scuola_iscr.id_domanda_iscrizione = a.id_domanda_iscrizione",
							"  join iscritto_t_scuola scuola on scuola.id_scuola = scuola_iscr.id_scuola",
							"where 1 = 1",
							"  and scuola.id_scuola in(",
							"    select",
							"      irps.id_scuola",
							"    from iscritto_t_utente itu",
							"      join iscritto_r_utente_profilo irup on irup.id_utente = itu.id_utente",
							"      join iscritto_d_profilo idp on idp.id_profilo = irup.id_profilo",
							"      join iscritto_r_profilo_scuole irps on irps.id_prof_ute = irup.id_prof_ute",
							"    where 1 = 1",
							"      and itu.fl_eliminato = 'N'",
							"      and upper(itu.codice_fiscale) = :cfOperatore",
							"      and idp.codice_profilo = :codProfilo",
							"      and now() between irup.dt_inizio and coalesce(irup.dt_fine, now())",
							"  )",
							"  and a.id_ordine_scuola = (",
							"    select id_ordine_scuola from iscritto_d_ordine_scuola where cod_ordine_scuola = :codOrdineScuola",
							"  )")
					.bind("cfOperatore", ConvertUtils.toUpper(cfOperatore))
					.bind("codProfilo", codProfilo)
					.bind("codOrdineScuola", tipoScuola.getCod());

			if (StringUtils.isNotBlank(cognome)) {
				sh.addQueryRows("  and upper(sog.cognome) like(:cognome)");
				sh.bind("cognome", ConvertUtils.toUpper(cognome) + "%");
			}

			if (StringUtils.isNotBlank(nome)) {
				sh.addQueryRows("  and upper(sog.nome) like(:nome)");
				sh.bind("nome", ConvertUtils.toUpper(nome) + "%");
			}

			result = this.queryForList(sh, Long.class);

		}

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public List<Long> findDomandeByCodiceScuola(TipoScuola tipoScuola, String cfOperatore, String codProfilo, String codiceScuola, String codiceStatoDomanda)
			throws DaoException {

		final String methodName = "findDomandeByCodiceScuola";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		log.info("^^ 5");

		List<Long> result = null;

		if (codProfilo.equals("P11")) {
			log.info("^^ 5.1");
			SqlHolder sh = buildSqlHolder().addQueryRows(
					"select distinct ",
					"  a.id_domanda_iscrizione",
					"from iscritto_t_domanda_isc a",
					"  join iscritto_d_stato_dom stato on stato.id_stato_dom = a.id_stato_dom",
					"  join iscritto_d_ordine_scuola ord_scuola on ord_scuola.id_ordine_scuola = a.id_ordine_scuola",
					"  join iscritto_r_scuola_pre scuola_iscr on scuola_iscr.id_domanda_iscrizione = a.id_domanda_iscrizione",
					"  join iscritto_t_scuola scuola on scuola.id_scuola = scuola_iscr.id_scuola",
					"where 1 = 1",
					"  and scuola.id_scuola in(",
					"    select distinct",
					"      irps.id_scuola",
					"    from iscritto_t_utente itu",
					"      join iscritto_r_utente_profilo irup on irup.id_utente = itu.id_utente",
					"      join iscritto_d_profilo idp on idp.id_profilo = irup.id_profilo",
					"      join iscritto_r_profilo_scuole irps on irps.id_prof_ute = irup.id_prof_ute",
					"      join iscritto_r_scuola_pre irsp on irps.id_scuola = irsp.id_scuola",
					"    where 1 = 1",
					"      and itu.fl_eliminato = 'N'",
					"      and upper(itu.codice_fiscale) = :cfOperatore",
					"      and idp.codice_profilo = :codProfilo",
					"      and irsp.id_stato_scu = 4",
					"      and now() between irup.dt_inizio and coalesce(irup.dt_fine, now())",
					"  )",
					"  and a.id_stato_dom = 7 ",
					"  and a.id_ordine_scuola = (",
					"    select id_ordine_scuola from iscritto_d_ordine_scuola where cod_ordine_scuola = :codOrdineScuola",
					"  )"
					)
					.bind("cfOperatore", ConvertUtils.toUpper(cfOperatore)).bind("codProfilo", codProfilo)
					.bind("codOrdineScuola", tipoScuola.getCod());

			if (StringUtils.isNotBlank(codiceScuola) && !codiceScuola.equals(Constants.TUTTE_LE_SCUOLE)) {
				sh.addQueryRows("  and scuola.cod_scuola = :codiceScuola");
				sh.bind("codiceScuola", codiceScuola);
			}

			if (StringUtils.isNotBlank(codiceStatoDomanda)) {
				sh.addQueryRows("  and stato.cod_stato_dom = :codiceStatoDomanda");
				sh.bind("codiceStatoDomanda", codiceStatoDomanda);
			}

			result = this.queryForList(sh, Long.class);
		} else if(codProfilo.equals("P12")) {
			log.info("^^ 5.2");
			SqlHolder sh = buildSqlHolder().addQueryRows(
					"select distinct ",
					"  a.id_domanda_iscrizione",
					"from iscritto_t_domanda_isc a",
					"  join iscritto_d_stato_dom stato on stato.id_stato_dom = a.id_stato_dom",
					"  join iscritto_d_ordine_scuola ord_scuola on ord_scuola.id_ordine_scuola = a.id_ordine_scuola",
					"  join iscritto_r_scuola_pre scuola_iscr on scuola_iscr.id_domanda_iscrizione = a.id_domanda_iscrizione",
					"  join iscritto_t_scuola scuola on scuola.id_scuola = scuola_iscr.id_scuola",
					"  where 1 = 1",
					"  and scuola.id_scuola in(",
					"    select",
					"      irps.id_scuola",
					"    from iscritto_t_utente itu",
					"      join iscritto_r_utente_profilo irup on irup.id_utente = itu.id_utente",
					"      join iscritto_d_profilo idp on idp.id_profilo = irup.id_profilo",
					"      join iscritto_r_profilo_scuole irps on irps.id_prof_ute = irup.id_prof_ute",
					"    where 1 = 1",
					"      and itu.fl_eliminato = 'N'",
					"      and upper(itu.codice_fiscale) = :cfOperatore",
					"      and idp.codice_profilo = :codProfilo",
					"      and now() between irup.dt_inizio and coalesce(irup.dt_fine, now())",
					"  )",
					"  and position(to_char(a.id_stato_dom) in statodomanda(a.id_domanda_iscrizione, scuola.id_scuola)) <> 0",
					"  and a.id_ordine_scuola = (",
					"    select id_ordine_scuola from iscritto_d_ordine_scuola where cod_ordine_scuola = :codOrdineScuola",
					"  )"

					)
					.bind("cfOperatore", ConvertUtils.toUpper(cfOperatore)).bind("codProfilo", codProfilo)
					.bind("codOrdineScuola", tipoScuola.getCod());

			if (StringUtils.isNotBlank(codiceScuola) && !codiceScuola.equals(Constants.TUTTE_LE_SCUOLE)) {
				sh.addQueryRows("  and scuola.cod_scuola = :codiceScuola");
				sh.bind("codiceScuola", codiceScuola);
			}

			if (StringUtils.isNotBlank(codiceStatoDomanda)) {
				sh.addQueryRows("  and stato.cod_stato_dom = :codiceStatoDomanda");
				sh.bind("codiceStatoDomanda", codiceStatoDomanda);
			}

			result = this.queryForList(sh, Long.class);

		} else {
			log.info("^^ 5.3");
			SqlHolder sh = buildSqlHolder().addQueryRows(
					"select distinct ",
					"  a.id_domanda_iscrizione",
					"from iscritto_t_domanda_isc a",
					"  join iscritto_d_stato_dom stato on stato.id_stato_dom = a.id_stato_dom",
					"  join iscritto_d_ordine_scuola ord_scuola on ord_scuola.id_ordine_scuola = a.id_ordine_scuola",
					"  join iscritto_r_scuola_pre scuola_iscr on scuola_iscr.id_domanda_iscrizione = a.id_domanda_iscrizione",
					"  join iscritto_t_scuola scuola on scuola.id_scuola = scuola_iscr.id_scuola",
					"  where 1 = 1",
					"  and scuola.id_scuola in(",
					"    select",
					"      irps.id_scuola",
					"    from iscritto_t_utente itu",
					"      join iscritto_r_utente_profilo irup on irup.id_utente = itu.id_utente",
					"      join iscritto_d_profilo idp on idp.id_profilo = irup.id_profilo",
					"      join iscritto_r_profilo_scuole irps on irps.id_prof_ute = irup.id_prof_ute",
					"    where 1 = 1",
					"      and itu.fl_eliminato = 'N'",
					"      and upper(itu.codice_fiscale) = :cfOperatore",
					"      and idp.codice_profilo = :codProfilo",
					"      and now() between irup.dt_inizio and coalesce(irup.dt_fine, now())",
					"  )",
					"  and a.id_ordine_scuola = (",
					"    select id_ordine_scuola from iscritto_d_ordine_scuola where cod_ordine_scuola = :codOrdineScuola",
					"  )"
					)
					.bind("cfOperatore", ConvertUtils.toUpper(cfOperatore)).bind("codProfilo", codProfilo)
					.bind("codOrdineScuola", tipoScuola.getCod());

			if (StringUtils.isNotBlank(codiceScuola) && !codiceScuola.equals(Constants.TUTTE_LE_SCUOLE)) {
				sh.addQueryRows("  and scuola.cod_scuola = :codiceScuola");
				sh.bind("codiceScuola", codiceScuola);
			}

			if (StringUtils.isNotBlank(codiceStatoDomanda)) {
				sh.addQueryRows("  and stato.cod_stato_dom = :codiceStatoDomanda");
				sh.bind("codiceStatoDomanda", codiceStatoDomanda);
			}

			result = this.queryForList(sh, Long.class);

		}


		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public List<Long> findDomandeByProtocollo(TipoScuola tipoScuola, String cfOperatore, String codProfilo, String protocollo) throws DaoException {
		final String methodName = "findDomandeByProtocollo";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		log.info("^^ 6");

		log.info("codice fiscale operatore"+cfOperatore);
		log.info("codice profilo"+codProfilo);
		log.info("protocollo"+protocollo);

		List<Long> result = null;


		if(codProfilo.equals("P11")) {
			log.info("^^ 6.1");
			//economa comunale
			SqlHolder sh = buildSqlHolder()
					.addQueryRows(
							"select distinct ",
							"  a.id_domanda_iscrizione",
							"from iscritto_t_domanda_isc a",
							"  join iscritto_d_stato_dom stato on stato.id_stato_dom = a.id_stato_dom",
							"  join iscritto_d_ordine_scuola ord_scuola on ord_scuola.id_ordine_scuola = a.id_ordine_scuola",
							"  join iscritto_r_scuola_pre scuola_iscr on scuola_iscr.id_domanda_iscrizione = a.id_domanda_iscrizione",
							"  join iscritto_t_scuola scuola on scuola.id_scuola = scuola_iscr.id_scuola",
							"where 1 = 1",
							"  and scuola.id_scuola in(",
							"    select distinct",
							"      irps.id_scuola",
							"    from iscritto_t_utente itu",
							"      join iscritto_r_utente_profilo irup on irup.id_utente = itu.id_utente",
							"      join iscritto_d_profilo idp on idp.id_profilo = irup.id_profilo",
							"      join iscritto_r_profilo_scuole irps on irps.id_prof_ute = irup.id_prof_ute",
							"      join iscritto_r_scuola_pre irsp on irps.id_scuola = irsp.id_scuola",
							"    where 1 = 1",
							"      and itu.fl_eliminato = 'N'",
							"      and upper(itu.codice_fiscale) = :cfOperatore",
							"      and idp.codice_profilo = :codProfilo",
							"      and irsp.id_stato_scu = 4",
							"      and now() between irup.dt_inizio and coalesce(irup.dt_fine, now())",
							"  )",
							"  and a.id_stato_dom = 7 ",
							"  and a.id_ordine_scuola = (",
							"    select id_ordine_scuola from iscritto_d_ordine_scuola where cod_ordine_scuola = :codOrdineScuola",
							"  )",
							"  and upper(a.protocollo) = :protocollo"
					)
					.bind("cfOperatore", ConvertUtils.toUpper(cfOperatore))
					.bind("codProfilo", codProfilo)
					.bind("codOrdineScuola", tipoScuola.getCod())
					.bind("protocollo", ConvertUtils.toUpper(protocollo));

			result = this.queryForList(sh, Long.class);
		}else if(codProfilo.equals("P12")) {
			log.info("^^ 6.2");
			//economa statale
		    SqlHolder sh = buildSqlHolder()
				.addQueryRows(
						"select distinct ",
						"  a.id_domanda_iscrizione",
						"from iscritto_t_domanda_isc a",
						"  join iscritto_d_stato_dom stato on stato.id_stato_dom = a.id_stato_dom",
						"  join iscritto_d_ordine_scuola ord_scuola on ord_scuola.id_ordine_scuola = a.id_ordine_scuola",
						"  join iscritto_r_scuola_pre scuola_iscr on scuola_iscr.id_domanda_iscrizione = a.id_domanda_iscrizione",
						"  join iscritto_t_scuola scuola on scuola.id_scuola = scuola_iscr.id_scuola",
						"where 1 = 1",
						"  and scuola.id_scuola in(",
						"    select",
						"      irps.id_scuola",
						"    from iscritto_t_utente itu",
						"      join iscritto_r_utente_profilo irup on irup.id_utente = itu.id_utente",
						"      join iscritto_d_profilo idp on idp.id_profilo = irup.id_profilo",
						"      join iscritto_r_profilo_scuole irps on irps.id_prof_ute = irup.id_prof_ute",
						"    where 1 = 1",
						"      and itu.fl_eliminato = 'N'",
						"      and upper(itu.codice_fiscale) = :cfOperatore",
						"      and idp.codice_profilo = :codProfilo",
						"      and now() between irup.dt_inizio and coalesce(irup.dt_fine, now())",
						"  )",
						"  and position(to_char(a.id_stato_dom) in statodomanda(a.id_domanda_iscrizione, scuola.id_scuola)) <> 0",
						"  and a.id_ordine_scuola = (",
						"    select id_ordine_scuola from iscritto_d_ordine_scuola where cod_ordine_scuola = :codOrdineScuola",
						"  )",
						"  and upper(a.protocollo) = :protocollo"
			    )
				.bind("cfOperatore", ConvertUtils.toUpper(cfOperatore))
				.bind("codProfilo", codProfilo)
				.bind("codOrdineScuola", tipoScuola.getCod())
				.bind("protocollo", ConvertUtils.toUpper(protocollo));

		    result = this.queryForList(sh, Long.class);

		} else {
			log.info("^^ 6.3");
			//caso base
		    SqlHolder sh = buildSqlHolder()
				.addQueryRows(
						"select distinct ",
						"  a.id_domanda_iscrizione",
						"from iscritto_t_domanda_isc a",
						"  join iscritto_d_stato_dom stato on stato.id_stato_dom = a.id_stato_dom",
						"  join iscritto_d_ordine_scuola ord_scuola on ord_scuola.id_ordine_scuola = a.id_ordine_scuola",
						"  join iscritto_r_scuola_pre scuola_iscr on scuola_iscr.id_domanda_iscrizione = a.id_domanda_iscrizione",
						"  join iscritto_t_scuola scuola on scuola.id_scuola = scuola_iscr.id_scuola",
						"where 1 = 1",
						"  and scuola.id_scuola in(",
						"    select",
						"      irps.id_scuola",
						"    from iscritto_t_utente itu",
						"      join iscritto_r_utente_profilo irup on irup.id_utente = itu.id_utente",
						"      join iscritto_d_profilo idp on idp.id_profilo = irup.id_profilo",
						"      join iscritto_r_profilo_scuole irps on irps.id_prof_ute = irup.id_prof_ute",
						"    where 1 = 1",
						"      and itu.fl_eliminato = 'N'",
						"      and upper(itu.codice_fiscale) = :cfOperatore",
						"      and idp.codice_profilo = :codProfilo",
						"      and now() between irup.dt_inizio and coalesce(irup.dt_fine, now())",
						"  )",
						"  and a.id_ordine_scuola = (",
						"    select id_ordine_scuola from iscritto_d_ordine_scuola where cod_ordine_scuola = :codOrdineScuola",
						"  )",
						"  and upper(a.protocollo) = :protocollo")
				.bind("cfOperatore", ConvertUtils.toUpper(cfOperatore))
				.bind("codProfilo", codProfilo)
				.bind("codOrdineScuola", tipoScuola.getCod())
				.bind("protocollo", ConvertUtils.toUpper(protocollo));

		result = this.queryForList(sh, Long.class);

		}
		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public List<CodificaRow> findAllStatiDomanda() throws DaoException {
		final String methodName = "findAllStatiDomanda";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));
		log.info("^^ 7");
		SqlHolder sh = buildSqlHolder(
				"SELECT ",
				"  cod_stato_dom AS codice, ",
				"  descrizione AS descrizione, ",
				"  id_stato_dom AS id",
				"FROM iscritto_d_stato_dom ",
				"ORDER BY cod_stato_dom");

		List<CodificaRow> result = this.query(sh, CodificaRow.class);

		log.info(buildMessage(getClass(), methodName, "Record trovati: " + result.size()));

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public TestataDomandaRow findTestataDomandaRicMinByIdDomanda(Long idDomanda) throws DaoException {
		final String methodName = "findTestataDomandaRicMinByIdDomanda";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));
		log.info("^^ 8");
		SqlHolder sh = buildSqlHolder(
				"select",
				"  dom.id_domanda_iscrizione,",
				"  dom.protocollo,",
				"  dom.data_consegna as data_invio,",
				"  dom.dt_modifica as data_ultima_modifica,",
				"  (",
				"    select ord.cod_ordine_scuola from iscritto_d_ordine_scuola ord",
				"    where ord.id_ordine_scuola = dom.id_ordine_scuola",
				"  ) as cod_ordine_scuola,",
				"  (",
				"    select stdom.cod_stato_dom from iscritto_d_stato_dom stdom",
				"    where stdom.id_stato_dom = dom.id_stato_dom",
				"  ) as stato_domanda_codice,",
				"  (",
				"    select anno.cod_anno_scolastico from iscritto_t_anno_sco anno",
				"    where anno.id_anno_scolastico = dom.id_anno_scolastico",
				"  ) as codice_anno_scolastico,",
				"  (",
				"    select anno.descrizione from iscritto_t_anno_sco anno",
				"    where anno.id_anno_scolastico = dom.id_anno_scolastico",
				"  ) as anno_scolastico_descrizione,",
				"  (",
				"    select sog.codice_fiscale from iscritto_t_anagrafica_sog sog ",
				"    join iscritto_r_soggetto_rel r on sog.id_anagrafica_soggetto = r.id_anagrafica_soggetto",
				"    join iscritto_d_tipo_sog tip on r.id_tipo_soggetto = tip.id_tipo_soggetto",
				"    where sog.id_domanda_iscrizione = dom.id_domanda_iscrizione and tip.cod_tipo_soggetto = 'RIC'",
				"  ) as codice_fiscale_richiedente,",
				"  (",
				"    select sog.codice_fiscale from iscritto_t_anagrafica_sog sog ",
				"    join iscritto_r_soggetto_rel r on sog.id_anagrafica_soggetto = r.id_anagrafica_soggetto",
				"    join iscritto_d_tipo_sog tip on r.id_tipo_soggetto = tip.id_tipo_soggetto",
				"    where sog.id_domanda_iscrizione = dom.id_domanda_iscrizione and tip.cod_tipo_soggetto = 'MIN'",
				"  ) as codice_fiscale_minore,",
				"  (",
				"    select sog.nome from iscritto_t_anagrafica_sog sog ",
				"    join iscritto_r_soggetto_rel r on sog.id_anagrafica_soggetto = r.id_anagrafica_soggetto",
				"    join iscritto_d_tipo_sog tip on r.id_tipo_soggetto = tip.id_tipo_soggetto",
				"    where sog.id_domanda_iscrizione = dom.id_domanda_iscrizione and tip.cod_tipo_soggetto = 'MIN'",
				"  ) as nome_minore,",
				"  (",
				"    select sog.cognome from iscritto_t_anagrafica_sog sog ",
				"    join iscritto_r_soggetto_rel r on sog.id_anagrafica_soggetto = r.id_anagrafica_soggetto",
				"    join iscritto_d_tipo_sog tip on r.id_tipo_soggetto = tip.id_tipo_soggetto",
				"    where sog.id_domanda_iscrizione = dom.id_domanda_iscrizione and tip.cod_tipo_soggetto = 'MIN'",
				"  ) as cognome_minore",
				"from iscritto_t_domanda_isc dom",
				"where id_domanda_iscrizione = :idDomanda");

		sh.bind("idDomanda", idDomanda);

		TestataDomandaRow result = ConvertUtils.getFirst(this.query(sh, TestataDomandaRow.class));

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public ProtocolloRow getInfoProtocollo(Long idDomanda) throws DaoException {
		final String methodName = "getProtocollo";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));
		log.info("^^ 9");
		Validate.notNull(idDomanda);

		SqlHolder sh = buildSqlHolder()
				.addQueryRows(
						"select",
						"  dom.id_domanda_iscrizione,",
						"  (",
						"    select stdom.cod_stato_dom from iscritto_d_stato_dom stdom",
						"    where stdom.id_stato_dom = dom.id_stato_dom",
						"  ) as cod_stato_dom,",
						"  (",
						"    select os.cod_ordine_scuola from iscritto_d_ordine_scuola os",
						"    where os.id_ordine_scuola = dom.id_ordine_scuola",
						"  ) as cod_ordine_scuola",
						"from iscritto_t_domanda_isc dom",
						"where id_domanda_iscrizione = :idDomandaIscrizione")
				.bind("idDomandaIscrizione", idDomanda);

		ProtocolloRow result = ConvertUtils.getFirst(this.query(sh, ProtocolloRow.class));

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public Long getNextNumProtocollo(TipoScuola tipoScuola) throws DaoException {
		final String methodName = "getNextNumProtocollo";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));
		log.info("^^ 10");
		final Long result;
		switch (tipoScuola) {
			case NID:
				result = this.nextval("iscritto_t_domanda_isc_protocollo");
				break;
			case MAT:
				result = this.nextval("iscritto_t_domanda_isc_protocollo_mat");
				break;
			default:
				throw new UnsupportedOperationException();
		}

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public List<CondizionePunteggioRow> findCondizioniPunteggio(Long idDomanda) throws DaoException {
		final String methodName = "findCondizioniPunteggio";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));
		log.info("^^ 11");
		SqlHolder sh = buildSqlHolder()
				.addQueryRows(
						"SELECT ",
						"  punt_dom.fl_valida,",
						"  punt_dom.ricorrenza,",
						"  punt_dom.note,",
						"  punt_dom.dt_inizio_validita AS dataInizioValidita,",
						"  punt_dom.dt_fine_validita AS dataFineValidita,",
						"  punt_dom.id_utente,",
						"  punt_dom.id_condizione_punteggio,",
						"  punt_dom.id_domanda_iscrizione",
						"FROM ISCRITTO_R_PUNTEGGIO_DOM punt_dom",
						"WHERE punt_dom.id_domanda_iscrizione = :idDomandaIscrizione ORDER BY punt_dom.dt_inizio_validita DESC")
				.bind("idDomandaIscrizione", idDomanda);

		List<CondizionePunteggioRow> result = this.query(sh, CondizionePunteggioRow.class);

		log.info("Trovate " + result.size() + " condizioni di punteggio per la domanda con id = " + idDomanda);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public List<String> findFlIrc(Long idDomanda) throws DaoException {
		final String methodName = "findFlIrc";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));
		log.info("^^ 100");
		SqlHolder sh = buildSqlHolder()
				.addQueryRows(
						"SELECT ",
						"  fl_irc",
						"FROM iscritto_t_domanda_isc",
						"WHERE id_domanda_iscrizione = :idDomandaIscrizione")
				.bind("idDomandaIscrizione", idDomanda);

		List<String> result = this.query(sh, String.class);

		log.info("Trovato flag religion per la domanda con id = " + idDomanda);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}


	@Override
	public List<TestataDomandaIstruttoriaRow> findDomandeByCondizionePunteggio(
			TipoScuola tipoScuola, String cfOperatore, String codProfilo, String codiceCondizione, StatoCondizionePunteggio condizionePunteggio,
			String nomeMinore, String cognomeMinore, Date dataInizio, Date dataFine) throws DaoException {

		final String methodName = "findDomandeByCondizionePunteggio";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));
		log.info("^^ 12");
		SqlHolder sh = buildSqlHolder()
				.addQueryRows(
						"select",
						"  dom.id_domanda_iscrizione,",
						"  dom.protocollo,",
						"  dom.data_consegna,",
						"  dom.dt_modifica as data_ultima_modifica,",
						"  (",
						"    select stdom.cod_stato_dom from iscritto_d_stato_dom stdom",
						"    where stdom.id_stato_dom = dom.id_stato_dom",
						"  ) as stato_domanda_codice,",
						"  (",
						"    select sog.nome from iscritto_t_anagrafica_sog sog ",
						"    join iscritto_r_soggetto_rel r on sog.id_anagrafica_soggetto = r.id_anagrafica_soggetto",
						"    join iscritto_d_tipo_sog tip on r.id_tipo_soggetto = tip.id_tipo_soggetto",
						"    where sog.id_domanda_iscrizione = dom.id_domanda_iscrizione and tip.cod_tipo_soggetto = 'MIN'",
						"  ) as nome_minore,",
						"  (",
						"    select sog.cognome from iscritto_t_anagrafica_sog sog ",
						"    join iscritto_r_soggetto_rel r on sog.id_anagrafica_soggetto = r.id_anagrafica_soggetto",
						"    join iscritto_d_tipo_sog tip on r.id_tipo_soggetto = tip.id_tipo_soggetto",
						"    where sog.id_domanda_iscrizione = dom.id_domanda_iscrizione and tip.cod_tipo_soggetto = 'MIN'",
						"  ) as cognome_minore,",
						"  (",
						"    select sc.indirizzo from iscritto_t_scuola sc",
						"    where sc.id_scuola in (",
						"      select pre.id_scuola",
						"      from iscritto_r_scuola_pre pre",
						"      where pre.id_domanda_iscrizione = dom.id_domanda_iscrizione and pre.fl_rinuncia = 'N'",
						"      order by pre.posizione",
						"      limit 1",
						"    )",
						"  ) as indirizzo,",
						"  (",
						"    select r_pun.ricorrenza",
						"    from iscritto_r_punteggio_dom r_pun",
						"    join iscritto_d_condizione_pun d_pun on d_pun.id_condizione_punteggio = r_pun.id_condizione_punteggio",
						"    where 1 = 1",
						"      and r_pun.id_domanda_iscrizione = dom.id_domanda_iscrizione",
						"      and d_pun.cod_condizione = :codiceCondizione",
						"      and now() between r_pun.dt_inizio_validita and coalesce(r_pun.dt_fine_validita, now())",
						"  ) as ricorrenza,",
						"  (",
						"    select r_pun.fl_valida",
						"    from iscritto_r_punteggio_dom r_pun",
						"    join iscritto_d_condizione_pun d_pun on d_pun.id_condizione_punteggio = r_pun.id_condizione_punteggio",
						"    where 1 = 1",
						"      and r_pun.id_domanda_iscrizione = dom.id_domanda_iscrizione",
						"      and d_pun.cod_condizione = :codiceCondizione",
						"      and now() between r_pun.dt_inizio_validita and coalesce(r_pun.dt_fine_validita, now())",
						"  ) as fl_valida",
						"from iscritto_t_domanda_isc dom",
						"where 1 = 1",
						"  and dom.id_ordine_scuola = (",
						"    select id_ordine_scuola from iscritto_d_ordine_scuola where cod_ordine_scuola = :codOrdineScuola",
						"  )",
						"  and id_domanda_iscrizione in (",
						"    select",
						"      r_pun.id_domanda_iscrizione",
						"    from iscritto_r_punteggio_dom r_pun",
						"    join iscritto_d_condizione_pun d_pun on d_pun.id_condizione_punteggio = r_pun.id_condizione_punteggio",
						"    where 1 = 1",
						"      and d_pun.cod_condizione = :codiceCondizione",
						"      and now() between r_pun.dt_inizio_validita and coalesce(r_pun.dt_fine_validita, now())");

		sh.bind("codOrdineScuola", tipoScuola.getCod());
		sh.bind("codiceCondizione", codiceCondizione);

		if (condizionePunteggio != null) {
			switch (condizionePunteggio) {
				case DAI:
					sh.addQueryRows("      and r_pun.fl_valida is null");
					break;
				case CON:
					sh.addQueryRows("      and r_pun.fl_valida = 'S'");
					break;
				case INV:
					sh.addQueryRows("      and r_pun.fl_valida = 'N'");
					break;
				default:
					break;
			}
		}

		if (StringUtils.isNotBlank(nomeMinore)) {
			sh.addQueryRows(
					"      and r_pun.id_domanda_iscrizione in (",
					"        select",
					"          view1.id_domanda_iscrizione",
					"        from (",
					"          select",
					"            dom.id_domanda_iscrizione,",
					"            (",
					"              select sog.nome from iscritto_t_anagrafica_sog sog ",
					"              join iscritto_r_soggetto_rel r on sog.id_anagrafica_soggetto = r.id_anagrafica_soggetto",
					"              join iscritto_d_tipo_sog tip on r.id_tipo_soggetto = tip.id_tipo_soggetto",
					"              where sog.id_domanda_iscrizione = dom.id_domanda_iscrizione and tip.cod_tipo_soggetto = 'MIN'",
					"            ) as nome_minore",
					"          from iscritto_t_domanda_isc dom",
					"        ) as view1",
					"        where upper(nome_minore) like(:nomeMinore)",
					"      )");

			sh.bind("nomeMinore", ConvertUtils.toUpper(nomeMinore) + "%");
		}

		if (StringUtils.isNotBlank(cognomeMinore)) {
			sh.addQueryRows(
					"      and r_pun.id_domanda_iscrizione in (",
					"        select",
					"          view1.id_domanda_iscrizione",
					"        from (",
					"          select",
					"            dom.id_domanda_iscrizione,",
					"            (",
					"              select sog.cognome from iscritto_t_anagrafica_sog sog ",
					"              join iscritto_r_soggetto_rel r on sog.id_anagrafica_soggetto = r.id_anagrafica_soggetto",
					"              join iscritto_d_tipo_sog tip on r.id_tipo_soggetto = tip.id_tipo_soggetto",
					"              where sog.id_domanda_iscrizione = dom.id_domanda_iscrizione and tip.cod_tipo_soggetto = 'MIN'",
					"            ) as cognome_minore",
					"          from iscritto_t_domanda_isc dom",
					"        ) as view1",
					"        where upper(cognome_minore) like(:cognomeMinore)",
					"      )");

			sh.bind("cognomeMinore", ConvertUtils.toUpper(cognomeMinore) + "%");
		}

		sh.addQueryRows(
				"  )");

		//filtro su istruttoria se economa statale
		//aggiunta 20/01/2021 filtro commissione H
		if(codProfilo.equals("P12") || codProfilo.equals("P5")) {

			log.info("filtro economa statale e commissioni H ATTIVO");
			sh.addQueryRows(
					"and dom.id_domanda_iscrizione in ( ",
					"select distinct ",
					"  a.id_domanda_iscrizione",
					"from iscritto_t_domanda_isc a",
					"  join iscritto_d_stato_dom stato on stato.id_stato_dom = a.id_stato_dom",
					"  join iscritto_d_ordine_scuola ord_scuola on ord_scuola.id_ordine_scuola = a.id_ordine_scuola",
					"  join iscritto_r_scuola_pre scuola_iscr on scuola_iscr.id_domanda_iscrizione = a.id_domanda_iscrizione",
					"  join iscritto_t_scuola scuola on scuola.id_scuola = scuola_iscr.id_scuola",
					"where 1 = 1",
					"  and scuola.id_scuola in(",
					"    select",
					"      irps.id_scuola",
					"    from iscritto_t_utente itu",
					"      join iscritto_r_utente_profilo irup on irup.id_utente = itu.id_utente",
					"      join iscritto_d_profilo idp on idp.id_profilo = irup.id_profilo",
					"      join iscritto_r_profilo_scuole irps on irps.id_prof_ute = irup.id_prof_ute",
					"    where 1 = 1",
					"      and itu.fl_eliminato = 'N'",
					"      and upper(itu.codice_fiscale) = :cfOperatore",
					"      and idp.codice_profilo = :codProfilo",
					"      and now() between irup.dt_inizio and coalesce(irup.dt_fine, now())",
					"  )",
					"  and position(to_char(a.id_stato_dom) in statodomanda(a.id_domanda_iscrizione, scuola.id_scuola)) <> 0",
					"  and a.id_ordine_scuola = (",
					"    select id_ordine_scuola from iscritto_d_ordine_scuola where cod_ordine_scuola = :codOrdineScuola",
					"  )",
					" ) " )
			.bind("cfOperatore", ConvertUtils.toUpper(cfOperatore))
			.bind("codProfilo", codProfilo)
			.bind("codOrdineScuola", tipoScuola.getCod());

		}



		if (dataInizio != null) {
			sh.addQueryRows(
					"  and to_date(to_char(dom.data_consegna, 'YYYY-MM-DD'), 'YYYY-MM-DD') >= to_date(:dataInizio, 'YYYY-MM-DD')");

			sh.bind("dataInizio", DateUtils.toStringDate(dataInizio, ISO_8601_FORMAT));
		}

		if (dataFine != null) {
			sh.addQueryRows(
					"  and to_date(to_char(dom.data_consegna, 'YYYY-MM-DD'), 'YYYY-MM-DD') <= to_date(:dataFine, 'YYYY-MM-DD')");

			sh.bind("dataFine", DateUtils.toStringDate(dataFine, ISO_8601_FORMAT));
		}


		sh.addQueryRows(
				"order by data_ultima_modifica");

		List<TestataDomandaIstruttoriaRow> result = this.query(sh, TestataDomandaIstruttoriaRow.class);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public List<TestataDomandaDaVerificareRow> findDomandeDaVerificare(TipoScuola tipoScuola, String codFiscale, String codProfilo) throws DaoException {
		final String methodName = "findDomandeDaVerificare";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));
		log.info("^^ 13");
		SqlHolder sh = buildSqlHolder()
				.addQueryRows(
						"select",
						"  id_domanda_iscrizione,",
						"  protocollo,",
						"  cod_stato_dom,",
						"  codice_fiscale_minore,",
						"  nome_minore,",
						"  cognome_minore,",
						"  fl_pa_dis",
						"from (",
						"  select",
						"    dom.id_ordine_scuola,",
						"    dom.id_stato_dom,",
						"    dom.id_anno_scolastico,",
						"    dom.id_domanda_iscrizione,",
						"    dom.protocollo,",
						"    (",
						"      select sd.cod_stato_dom from iscritto_d_stato_dom sd",
						"      where sd.id_stato_dom = dom.id_stato_dom",
						"    ) as cod_stato_dom,",
						"    (",
						"      select sog.codice_fiscale from iscritto_t_anagrafica_sog sog ",
						"        join iscritto_r_soggetto_rel r on sog.id_anagrafica_soggetto = r.id_anagrafica_soggetto",
						"        join iscritto_d_tipo_sog tip on r.id_tipo_soggetto = tip.id_tipo_soggetto",
						"      where sog.id_domanda_iscrizione = dom.id_domanda_iscrizione and tip.cod_tipo_soggetto = 'MIN'",
						"    ) as codice_fiscale_minore,",
						"    (",
						"      select sog.nome from iscritto_t_anagrafica_sog sog ",
						"        join iscritto_r_soggetto_rel r on sog.id_anagrafica_soggetto = r.id_anagrafica_soggetto",
						"        join iscritto_d_tipo_sog tip on r.id_tipo_soggetto = tip.id_tipo_soggetto",
						"      where sog.id_domanda_iscrizione = dom.id_domanda_iscrizione and tip.cod_tipo_soggetto = 'MIN'",
						"    ) as nome_minore,",
						"    (",
						"      select sog.cognome from iscritto_t_anagrafica_sog sog ",
						"        join iscritto_r_soggetto_rel r on sog.id_anagrafica_soggetto = r.id_anagrafica_soggetto",
						"        join iscritto_d_tipo_sog tip on r.id_tipo_soggetto = tip.id_tipo_soggetto",
						"      where sog.id_domanda_iscrizione = dom.id_domanda_iscrizione and tip.cod_tipo_soggetto = 'MIN'",
						"    ) as cognome_minore,",
						"    (",
						"      select 'S'::text",
						"      where exists (",
						"        select * from iscritto_r_punteggio_dom rpd",
						"        where 1 = 1",
						"          and rpd.id_domanda_iscrizione = dom.id_domanda_iscrizione",
						"          and rpd.fl_valida = 'S'",
						"          and now() between rpd.dt_inizio_validita and coalesce(rpd.dt_fine_validita, now())",
						"          and rpd.id_condizione_punteggio in (",
						"            select dcp.id_condizione_punteggio from iscritto_d_condizione_pun dcp",
						"            where dcp.cod_condizione = 'PA_DIS'",
						"          )",
						"      ) and exists (",
						"        select * from iscritto_t_anagrafica_sog sog ",
						"          join iscritto_r_soggetto_rel r on sog.id_anagrafica_soggetto = r.id_anagrafica_soggetto",
						"          join iscritto_d_tipo_sog tip on r.id_tipo_soggetto = tip.id_tipo_soggetto",
						"          join iscritto_t_condizione_san san on san.id_anagrafica_soggetto = sog.id_anagrafica_soggetto",
						"        where 1 = 1",
						"          and sog.id_domanda_iscrizione = dom.id_domanda_iscrizione",
						"          and tip.cod_tipo_soggetto = 'MIN'",
						"          and exists (",
						"            select sog.id_anagrafica_soggetto from iscritto_t_allegato al where al.id_anagrafica_soggetto = sog.id_anagrafica_soggetto",
						"          )",
						"      )",
						"    ) as fl_pa_dis",
						"  from iscritto_t_domanda_isc dom",
						"  where 1 = 1",
						"  and dom.id_domanda_iscrizione in (",
					    "   select distinct",
					    "   a.id_domanda_iscrizione",
					    " from iscritto_t_domanda_isc a",
					    "   join iscritto_d_ordine_scuola ord_scuola on ord_scuola.id_ordine_scuola = a.id_ordine_scuola",
					    "   join iscritto_r_scuola_pre scuola_iscr on scuola_iscr.id_domanda_iscrizione = a.id_domanda_iscrizione",
					    "   join iscritto_t_scuola scuola on scuola.id_scuola = scuola_iscr.id_scuola",
					    " where 1 = 1",
					    "   and scuola.id_scuola in(",
					    "     select",
					    "       irps.id_scuola",
					    "     from iscritto_t_utente itu",
					    "       join iscritto_r_utente_profilo irup on irup.id_utente = itu.id_utente",
					    "       join iscritto_d_profilo idp on idp.id_profilo = irup.id_profilo",
					    "       join iscritto_r_profilo_scuole irps on irps.id_prof_ute = irup.id_prof_ute",
					    "     where 1 = 1",
					    "       and itu.fl_eliminato = 'N'",
					    "       and upper(itu.codice_fiscale) = :cfOperatore",
					    "       and idp.codice_profilo = :codProfilo",
					    "       and now() between irup.dt_inizio and coalesce(irup.dt_fine, now())",
					    "   )",
					    "       and scuola_iscr.posizione = 1",
						"  )",
						"    and dom.id_ordine_scuola = (",
						"      select id_ordine_scuola from iscritto_d_ordine_scuola where cod_ordine_scuola = :codOrdineScuola",
						"    )",
						"    and dom.id_stato_dom in (",
						"      select sd.id_stato_dom from iscritto_d_stato_dom sd",
						"      where sd.cod_stato_dom in ('INV', 'AMM', 'GRA')",
						"    )",
						"    and dom.id_anno_scolastico in (",
						"      select a.id_anno_scolastico",
						"      from iscritto_t_anagrafica_gra ag",
						"        join iscritto_t_anno_sco a on ag.id_anno_scolastico = a.id_anno_scolastico",
						"      where 1 = 1",
						"        and ag.id_ordine_scuola in (",
						"          select os.id_ordine_scuola from iscritto_d_ordine_scuola os",
						"          where os.cod_ordine_scuola = :codOrdineScuola",
						"        )",
						"        and now() >= to_date(to_char(ag.dt_inizio_iscr, 'YYYY-MM-DD'), 'YYYY-MM-DD')",
						"        and now() <= to_date(to_char(ag.dt_fine_iscr,  'YYYY-MM-DD'), 'YYYY-MM-DD')",
						"    )",
						") as v1",
						"where 1 = 1",
						"  and v1.fl_pa_dis = 'S'")
		.bind("codOrdineScuola", tipoScuola.getCod())
		.bind("cfOperatore", ConvertUtils.toUpper(codFiscale))
		.bind("codProfilo", codProfilo);

		List<TestataDomandaDaVerificareRow> result = this.query(sh, TestataDomandaDaVerificareRow.class);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	//////////////////////////////////////////////////////////////////////

	private static List<Long> getIdDomande(List<IscrittoTDomandaIsc> rows) {
		List<Long> result = new ArrayList<>();
		if (CollectionUtils.isNotEmpty(rows)) {
			for (IscrittoTDomandaIsc row : rows) {
				result.add(row.getIdDomandaIscrizione());
			}
		}

		return result;
	}

}
