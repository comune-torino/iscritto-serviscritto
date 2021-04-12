package it.csi.iscritto.serviscritto.business.integration.dao.custom.impl;

import static it.csi.iscritto.serviscritto.business.util.DateUtils.ISO_8601_FORMAT;
import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.LOG_BEGIN;
import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.LOG_END;
import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.buildMessage;

import java.util.Date;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.Validate;
import org.apache.log4j.Logger;

import it.csi.iscritto.serviscritto.business.integration.dao.AbstractDao;
import it.csi.iscritto.serviscritto.business.integration.dao.StatoScuola;
import it.csi.iscritto.serviscritto.business.integration.dao.TipoCommissione;
import it.csi.iscritto.serviscritto.business.integration.dao.TipoScuola;
import it.csi.iscritto.serviscritto.business.integration.dao.custom.IstruttoriaDao;
import it.csi.iscritto.serviscritto.business.integration.dao.custom.dto.DatiCondizionePunteggioRow;
import it.csi.iscritto.serviscritto.business.integration.dao.custom.dto.InfoAllegatoSoggettoRow;
import it.csi.iscritto.serviscritto.business.integration.dao.custom.dto.VerbaleCommissioneRow;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoRPunteggioDom;
import it.csi.iscritto.serviscritto.business.integration.dao.view.dto.SoggettoRow;
import it.csi.iscritto.serviscritto.business.integration.exception.DaoException;
import it.csi.iscritto.serviscritto.business.util.Constants;
import it.csi.iscritto.serviscritto.business.util.DateUtils;
import it.csi.iscritto.serviscritto.business.util.converter.ConvertUtils;
import it.csi.iscritto.serviscritto.business.util.sql.SqlHolder;

public class IstruttoriaDaoImpl extends AbstractDao implements IstruttoriaDao {
	private static final Logger log = Logger.getLogger(Constants.COMPONENT_NAME + ".dao");

	@Override
	public List<DatiCondizionePunteggioRow> findStoricoCondizioniPunteggio(Long idDomanda, String codCondizionePunteggio) throws DaoException {
		final String methodName = "findStoricoCondizioniPunteggio";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		log.debug(buildMessage(getClass(), methodName, "idDomanda: " + idDomanda));
		log.debug(buildMessage(getClass(), methodName, "codCondizionePunteggio: " + codCondizionePunteggio));

		SqlHolder sh = buildSqlHolder()
				.addQueryRows(
						"select",
						"  rp.fl_valida,",
						"  rp.ricorrenza,",
						"  rp.dt_inizio_validita,",
						"  rp.dt_fine_validita,",
						"  rp.note,",
						"  rp.id_domanda_iscrizione,",
						"  rp.id_condizione_punteggio,",
						"  (",
						"    select pun.cod_condizione from iscritto_d_condizione_pun pun where pun.id_condizione_punteggio = rp.id_condizione_punteggio",
						"  ) as cod_condizione_punteggio,",
						"  (",
						"    select ut.nome from iscritto_t_utente ut where ut.id_utente = rp.id_utente",
						"  ) as nome_operatore,",
						"  (",
						"    select ut.cognome from iscritto_t_utente ut where ut.id_utente = rp.id_utente",
						"  ) as cognome_operatore",
						"from iscritto_r_punteggio_dom rp",
						"where 1 = 1",
						"  and rp.id_domanda_iscrizione = :idDomandaIscrizione",
						"  and rp.id_condizione_punteggio = (",
						"    select cp.id_condizione_punteggio from iscritto_d_condizione_pun cp where cp.cod_condizione = :codCondizionePunteggio",
						"  )",
						"order by rp.dt_fine_validita nulls last")
				.bind("idDomandaIscrizione", idDomanda)
				.bind("codCondizionePunteggio", codCondizionePunteggio);

		List<DatiCondizionePunteggioRow> result = this.query(sh, DatiCondizionePunteggioRow.class);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public List<InfoAllegatoSoggettoRow> findAllegatiDomanda(Long idDomanda, String codCondizionePunteggio, boolean withRed) throws DaoException {
		final String methodName = "findAllegatiDomanda";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		log.debug(buildMessage(getClass(), methodName, "idDomanda: " + idDomanda));
		log.debug(buildMessage(getClass(), methodName, "codCondizionePunteggio: " + codCondizionePunteggio));

		SqlHolder sh = buildSqlHolder();
		sh.addQueryRows(
				"select distinct",
				"  sog.id_domanda_iscrizione,",
				"  cp.cod_condizione,",
				"  sog.id_anagrafica_soggetto,",
				"  sog.cognome,",
				"  sog.nome,",
				"  sog.codice_fiscale as codice_fiscale_soggetto,",
				"  (",
				"    select sog1.codice_fiscale",
				"    from iscritto_t_anagrafica_sog sog1 ",
				"      join iscritto_r_soggetto_rel r on sog1.id_anagrafica_soggetto = r.id_anagrafica_soggetto",
				"      join iscritto_d_tipo_sog tip on r.id_tipo_soggetto = tip.id_tipo_soggetto",
				"    where sog1.id_domanda_iscrizione = sog.id_domanda_iscrizione and tip.cod_tipo_soggetto = 'RIC'",
				"  ) as codice_fiscale_richiedente,",
				"  tip.cod_tipo_soggetto,",
				"  al.id_allegato,",
				"  al.nome_file,",
				"  al.mime_type,",
				"  al.protocollo,",
				"  al.data_inserimento,",
				"  ta.cod_tipo_allegato,",
				"  (",
				"    select ta1.cod_tipo_allegato",
				"    from iscritto_d_tipo_all ta1",
				"    where red.id_tipo_allegato = ta1.id_tipo_allegato",
				"  ) as cod_tipo_allegato_red",
				"from iscritto_t_anagrafica_sog sog",
				"  join iscritto_r_soggetto_rel r on sog.id_anagrafica_soggetto = r.id_anagrafica_soggetto",
				"  join iscritto_d_tipo_sog tip on r.id_tipo_soggetto = tip.id_tipo_soggetto",
				"  join iscritto_t_allegato al on sog.id_anagrafica_soggetto = al.id_anagrafica_soggetto",
				"  join iscritto_d_condizione_pun cp on al.id_tipo_allegato = cp.id_tipo_allegato",
				"  join iscritto_d_tipo_all ta on al.id_tipo_allegato = ta.id_tipo_allegato",
				"  left join iscritto_t_allegato_red red on red.id_allegato = al.id_allegato",
				"where 1 = 1",
				"  and sog.id_domanda_iscrizione = :idDomandaIscrizione",
				"  and tip.cod_tipo_soggetto <> 'RIC'",
				"  and (",
				"    cp.cod_condizione = :codCondizionePunteggio");

		if (withRed) {
			sh.addQueryRows(
					"    or cp.cod_condizione in (",
					"      select p1.cod_condizione",
					"      from iscritto_d_condizione_pun p1",
					"      where al.id_allegato = red.id_allegato",
					"        and now() between red.data_inizio_validita and coalesce(red.data_fine_validita, now())",
					"    )");
		}

		sh.addQueryRows(
				"  )",
				"order by",
				"  sog.id_anagrafica_soggetto,",
				"  al.id_allegato");

		sh.bind("idDomandaIscrizione", idDomanda);
		sh.bind("codCondizionePunteggio", codCondizionePunteggio);

		List<InfoAllegatoSoggettoRow> result = this.query(sh, InfoAllegatoSoggettoRow.class);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public int countCondizioniNonIstruite(Long idDomanda) throws DaoException {
		final String methodName = "countCondizioniNonIstruite";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		log.debug(buildMessage(getClass(), methodName, "idDomanda: " + idDomanda));

		SqlHolder sh = buildSqlHolder()
				.addQueryRows(
						"select",
						"  rp.id_domanda_iscrizione,",
						"  rp.id_condizione_punteggio",
						"from iscritto_r_punteggio_dom rp",
						"  join iscritto_d_condizione_pun dcp on dcp.id_condizione_punteggio = rp.id_condizione_punteggio",
						"where 1 = 1",
						"  and rp.id_domanda_iscrizione = :idDomandaIscrizione",
						"  and rp.dt_fine_validita is null",
						"  and rp.fl_valida is null",
						"  and dcp.fl_istruttoria = 'P'")
				.bind("idDomandaIscrizione", idDomanda);

		List<DatiCondizionePunteggioRow> rows = this.query(sh, DatiCondizionePunteggioRow.class);
		int result = CollectionUtils.size(rows);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public List<VerbaleCommissioneRow> findInfoVerbali(TipoScuola tipoScuola, String codFiscaleOperatore, String codProfilo, String tipoCommissione, Date dataInizio, Date dataFine) throws DaoException {
		final String methodName = "findInfoVerbali";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		log.debug(buildMessage(getClass(), methodName, "tipoScuola: " + tipoScuola));
		log.debug(buildMessage(getClass(), methodName, "tipoCommissione: " + tipoCommissione));
		log.debug(buildMessage(getClass(), methodName, "dataInizio: " + dataInizio));
		log.debug(buildMessage(getClass(), methodName, "dataFine: " + dataFine));
		log.debug(buildMessage(getClass(), methodName, "codFiscaleOperatore: " + codFiscaleOperatore));
		log.debug(buildMessage(getClass(), methodName, "codProfilo: " + codProfilo));

		Validate.notBlank(tipoCommissione);
		Validate.notNull(dataInizio);
		Validate.notNull(dataFine);


		String tcs,tcs2;
		if(tipoCommissione.equals("S")) {
			TipoCommissione tc1 = TipoCommissione.findByCod(tipoCommissione);
			Validate.notNull(tc1);
			TipoCommissione tc2 = TipoCommissione.findByCod("D");
			Validate.notNull(tc2);
			tcs =tc1.getCodCondizione();
			tcs2 =tc2.getCodCondizione();
		}else {
			TipoCommissione tc = TipoCommissione.findByCod(tipoCommissione);
			Validate.notNull(tc);
			tcs = tc.getCodCondizione();
			//valore x tampone
			tcs2 = " x ";
			log.info(buildMessage(getClass(), methodName, "VALORE TCS2 " + tcs));
		}


		SqlHolder sh = buildSqlHolder()
				.addQueryRows(
						"select",
						"  rpd.fl_valida,",
						"  rpd.fl_integrazione,",
						"  rpd.note,",
						"  rpd.dt_inizio_validita,",
						"  rpd.dt_fine_validita,",
						"  (",
						"    select dom.protocollo",
						"    from iscritto_t_domanda_isc dom",
						"    where dom.id_domanda_iscrizione = rpd.id_domanda_iscrizione",
						"  ) as protocollo,",
						"  (",
						"    select sog.codice_fiscale from iscritto_t_anagrafica_sog sog ",
						"    join iscritto_r_soggetto_rel r on sog.id_anagrafica_soggetto = r.id_anagrafica_soggetto",
						"    join iscritto_d_tipo_sog tip on r.id_tipo_soggetto = tip.id_tipo_soggetto",
						"    where sog.id_domanda_iscrizione = rpd.id_domanda_iscrizione and tip.cod_tipo_soggetto = 'MIN'",
						"  ) as codice_fiscale_minore,",
						"  (",
						"    select sog.nome from iscritto_t_anagrafica_sog sog ",
						"    join iscritto_r_soggetto_rel r on sog.id_anagrafica_soggetto = r.id_anagrafica_soggetto",
						"    join iscritto_d_tipo_sog tip on r.id_tipo_soggetto = tip.id_tipo_soggetto",
						"    where sog.id_domanda_iscrizione = rpd.id_domanda_iscrizione and tip.cod_tipo_soggetto = 'MIN'",
						"  ) as nome_minore,",
						"  (",
						"    select sog.cognome from iscritto_t_anagrafica_sog sog ",
						"    join iscritto_r_soggetto_rel r on sog.id_anagrafica_soggetto = r.id_anagrafica_soggetto",
						"    join iscritto_d_tipo_sog tip on r.id_tipo_soggetto = tip.id_tipo_soggetto",
						"    where sog.id_domanda_iscrizione = rpd.id_domanda_iscrizione and tip.cod_tipo_soggetto = 'MIN'",
						"  ) as cognome_minore,",
						"  (",
						"    select sc.descrizione from iscritto_t_scuola sc",
						"    where sc.id_scuola in (",
						"      select pre.id_scuola",
						"      from iscritto_r_scuola_pre pre",
						"      where pre.id_domanda_iscrizione = rpd.id_domanda_iscrizione and pre.fl_rinuncia = 'N'",
						"      order by pre.posizione",
						"      limit 1",
						"    )",
						"  ) as nome_scuola_prima_scelta,",
						"  (",
						"    select sc.indirizzo from iscritto_t_scuola sc",
						"    where sc.id_scuola in (",
						"      select pre.id_scuola",
						"      from iscritto_r_scuola_pre pre",
						"      where pre.id_domanda_iscrizione = rpd.id_domanda_iscrizione and pre.fl_rinuncia = 'N'",
						"      order by pre.posizione",
						"      limit 1",
						"    )",
						"  ) as indirizzo_scuola_prima_scelta",
						"from iscritto_r_punteggio_dom rpd",
						"where 1 = 1",
						"  and rpd.id_domanda_iscrizione in (",
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
						"  and rpd.fl_valida is not null",
						"  and rpd.id_condizione_punteggio in (",
						"    select dcp.id_condizione_punteggio",
						"    from iscritto_d_condizione_pun dcp",
						"    where dcp.cod_condizione in (:codiceCondizione , :codiceCondizione2)",
						"  )",
						"  and to_date(to_char(rpd.dt_inizio_validita, 'YYYY-MM-DD'), 'YYYY-MM-DD') >= to_date(:dataInizio, 'YYYY-MM-DD')",
						"  and to_date(to_char(rpd.dt_inizio_validita, 'YYYY-MM-DD'), 'YYYY-MM-DD') <= to_date(:dataFine, 'YYYY-MM-DD')",
						"order by",
						"  codice_fiscale_minore,",
						"  rpd.dt_inizio_validita")
				.bind("codOrdineScuola", tipoScuola.getCod())
				.bind("codiceCondizione", tcs)
				.bind("codiceCondizione2", tcs2)
				.bind("codProfilo", codProfilo)
				.bind("cfOperatore", codFiscaleOperatore)
				.bind("dataInizio", DateUtils.toStringDate(dataInizio, ISO_8601_FORMAT))
				.bind("dataFine", DateUtils.toStringDate(dataFine, ISO_8601_FORMAT));


		List<VerbaleCommissioneRow> result = this.query(sh, VerbaleCommissioneRow.class);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public boolean condizioneResNotoLav(Long idDomanda) throws DaoException {
		final String methodName = "condizioneResNotoLav";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		log.debug(buildMessage(getClass(), methodName, "idDomanda: " + idDomanda));

		SqlHolder sh = buildSqlHolder()
				.addQueryRows(
						"select",
						"  sog.id_anagrafica_soggetto",
						"from iscritto_t_anagrafica_sog sog",
						"  join iscritto_r_soggetto_rel r on sog.id_anagrafica_soggetto = r.id_anagrafica_soggetto",
						"  join iscritto_d_tipo_sog tip on r.id_tipo_soggetto = tip.id_tipo_soggetto",
						"  join iscritto_t_condizione_occ co on sog.id_anagrafica_soggetto = co.id_anagrafica_soggetto",
						"  join iscritto_d_tip_con_occ dco on co.id_tip_cond_occupazionale = dco.id_tip_cond_occupazionale",
						"  left join iscritto_t_dipendente dip on dip.id_condizione_occupazionale = co.id_condizione_occupazionale",
						"  left join iscritto_t_autonomo aut on aut.id_condizione_occupazionale = co.id_condizione_occupazionale",
						"where 1 = 1",
						"  and tip.cod_tipo_soggetto in ('SOG1', 'SOG2')",
						"  and dco.cod_tip_cond_occupazionale in ('DIP', 'AUT')",
						"  and (upper(trim(dip.comune_lavoro)) = 'TORINO' or upper(trim(aut.comune_lavoro)) = 'TORINO')",
						"  and sog.id_domanda_iscrizione = :idDomandaIscrizione")
				.bind("idDomandaIscrizione", idDomanda);

		boolean result = CollectionUtils.isNotEmpty(this.query(sh, SoggettoRow.class));

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public boolean fuoriTermine(Long idDomanda, Long idAnagraficaGra) throws DaoException {
		final String methodName = "fuoriTermine";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		log.debug(buildMessage(getClass(), methodName, "idDomanda: " + idDomanda));

		SqlHolder sh = buildSqlHolder()
				.addQueryRows(
						"with dati_graduatoria as (",
						"  select",
						"    gra.id_anagrafica_gra,",
						"    gra.dt_inizio_iscr,",
						"    gra.dt_scadenza_iscr",
						"  from iscritto_t_anagrafica_gra gra",
						"  where gra.id_anagrafica_gra = :idAnagraficaGra",
						")",
						"select * from iscritto_t_domanda_isc dom",
						"where 1 = 1",
						"  and dom.id_domanda_iscrizione = :idDomandaIscrizione",
						"  and to_date(to_char(dom.data_consegna, 'YYYY-MM-DD'), 'YYYY-MM-DD') >= ",
						"      to_date(to_char((select dt_inizio_iscr from dati_graduatoria), 'YYYY-MM-DD'), 'YYYY-MM-DD')",
						"  and to_date(to_char(dom.data_consegna, 'YYYY-MM-DD'), 'YYYY-MM-DD') <=",
						"      to_date(to_char((select dt_scadenza_iscr from dati_graduatoria),  'YYYY-MM-DD'), 'YYYY-MM-DD')")
				.bind("idDomandaIscrizione", idDomanda)
				.bind("idAnagraficaGra", idAnagraficaGra);

		boolean result = CollectionUtils.isEmpty(this.query(sh, SoggettoRow.class));

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public Integer modificaCondizionePunteggio(DatiCondizionePunteggioRow row) throws DaoException {
		final String methodName = "modificaCondizionePunteggio";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		Validate.notNull(row);
		Long idDomanda = Validate.notNull(row.getIdDomandaIscrizione());
		String codCondizionePunteggio = Validate.notBlank(row.getCodCondizionePunteggio());
		String codiceFiscaleOperatore = Validate.notBlank(row.getCodiceFiscaleOperatore());

		log.debug(buildMessage(getClass(), methodName, "idDomanda: " + idDomanda));
		log.debug(buildMessage(getClass(), methodName, "codCondizionePunteggio: " + codCondizionePunteggio));

		this.update(buildSqlHolder()
				.addQueryRows(
						"update iscritto_r_punteggio_dom set",
						"  dt_fine_validita = now()",
						"where 1 = 1",
						"  and id_domanda_iscrizione = :idDomandaIscrizione",
						"  and id_condizione_punteggio = (",
						"    select cp.id_condizione_punteggio from iscritto_d_condizione_pun cp where cp.cod_condizione = :codCondizionePunteggio",
						"  )",
						"  and dt_fine_validita is null")
				.bind("idDomandaIscrizione", idDomanda)
				.bind("codCondizionePunteggio", codCondizionePunteggio));

		Integer result = this.update(buildSqlHolder()
				.addQueryRows(
						"insert into iscritto_r_punteggio_dom (",
						"  id_domanda_iscrizione,",
						"  id_condizione_punteggio,",
						"  id_utente,",
						"  fl_valida,",
						"  note,",
						"  dt_inizio_validita,",
						"  dt_fine_validita,",
						"  ricorrenza,",
						"  fl_integrazione",
						")",
						"values (",
						"  :idDomandaIscrizione,",
						"  (select cp.id_condizione_punteggio from iscritto_d_condizione_pun cp where cp.cod_condizione = :codCondizionePunteggio),",
						"  (select id_utente from iscritto_t_utente where codice_fiscale = :codiceFiscale and fl_eliminato = 'N'),",
						"  :flValida,",
						"  :note,",
						"  now(),",
						"  NULL,",
						"  :ricorrenza,",
						"  :flIntegrazione",
						")")
				.bind("idDomandaIscrizione", idDomanda)
				.bind("codCondizionePunteggio", codCondizionePunteggio)
				.bind("codiceFiscale", codiceFiscaleOperatore)
				.bind("flValida", row.getFlValida())
				.bind("note", row.getNote())
				.bind("ricorrenza", row.getRicorrenza())
				.bind("flIntegrazione", row.getFlIntegrazione()));

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public Integer insertAllegatoRed(Long idAllegato, String codCondizionePunteggio) throws DaoException {
		final String methodName = "insertAllegatoRed";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		log.debug(buildMessage(getClass(), methodName, "idAllegato: " + idAllegato));
		log.debug(buildMessage(getClass(), methodName, "codCondizionePunteggio: " + codCondizionePunteggio));

		Validate.notNull(idAllegato);
		Validate.notBlank(codCondizionePunteggio);

		this.update(buildSqlHolder()
				.addQueryRows(
						"update iscritto_t_allegato_red set",
						"  data_fine_validita = now()",
						"where",
						"  id_allegato = :idAllegato and data_fine_validita is null")
				.bind("idAllegato", idAllegato));

		Integer result = this.update(buildSqlHolder()
				.addQueryRows(
						"insert into iscritto_t_allegato_red (",
						"  id_allegato,",
						"  id_tipo_allegato,",
						"  data_inizio_validita,",
						"  data_fine_validita",
						")",
						"values(",
						"  :idAllegato,",
						"  (select id_tipo_allegato from iscritto_d_condizione_pun where cod_condizione = :codCondizione),",
						"  now(),",
						"  NULL",
						")")
				.bind("idAllegato", idAllegato)
				.bind("codCondizione", codCondizionePunteggio));

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public Integer updateStatoScuola(Long idDomandaIscrizione, String codScuola, String codTipoFrequenza, StatoScuola statoScuola) throws DaoException {
		final String methodName = "updateStatoScuola";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		log.debug(buildMessage(getClass(), methodName, "idDomandaIscrizione: " + idDomandaIscrizione));
		log.debug(buildMessage(getClass(), methodName, "codScuola: " + codScuola));
		log.debug(buildMessage(getClass(), methodName, "codTipoFrequenza: " + codTipoFrequenza));
		log.debug(buildMessage(getClass(), methodName, "statoScuola: " + statoScuola));

		Validate.notNull(idDomandaIscrizione);
		Validate.notBlank(codScuola);
		Validate.notBlank(codTipoFrequenza);

		final SqlHolder sh;

		if (statoScuola == null) {
			sh = buildSqlHolder()
					.addQueryRows(
							"update iscritto_r_scuola_pre set",
							"  id_stato_scu = NULL,",
							"  dt_stato = now()",
							"where 1 = 1",
							"  and id_domanda_iscrizione = :idDomandaIscrizione",
							"  and id_scuola = (select scu.id_scuola from iscritto_t_scuola scu where scu.cod_scuola = :codScuola)",
							"  and id_tipo_frequenza = (select fre.id_tipo_frequenza from iscritto_d_tipo_fre fre where fre.cod_tipo_frequenza = :codTipoFrequenza)")
					.bind("idDomandaIscrizione", idDomandaIscrizione)
					.bind("codScuola", codScuola)
					.bind("codTipoFrequenza", codTipoFrequenza);
		}
		else {
			sh = buildSqlHolder()
					.addQueryRows(
							"update iscritto_r_scuola_pre set",
							"  id_stato_scu = (select ds.id_stato_scu from iscritto_d_stato_scu ds where ds.cod_stato_scu = :codStatoScuola),",
							"  dt_stato = now()",
							"where 1 = 1",
							"  and id_domanda_iscrizione = :idDomandaIscrizione",
							"  and id_scuola = (select scu.id_scuola from iscritto_t_scuola scu where scu.cod_scuola = :codScuola)",
							"  and id_tipo_frequenza = (select fre.id_tipo_frequenza from iscritto_d_tipo_fre fre where fre.cod_tipo_frequenza = :codTipoFrequenza)")
					.bind("idDomandaIscrizione", idDomandaIscrizione)
					.bind("codScuola", codScuola)
					.bind("codStatoScuola", statoScuola.getCod())
					.bind("codTipoFrequenza", codTipoFrequenza);
		}

		Integer result = this.update(sh);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public Integer updateFlIstruita(Long idDomanda, boolean istruita) throws DaoException {
		final String methodName = "updateFlIstruita";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		log.debug(buildMessage(getClass(), methodName, "idDomanda: " + idDomanda));
		log.debug(buildMessage(getClass(), methodName, "istruita: " + istruita));

		Integer result = this.update(buildSqlHolder()
				.addQueryRows(
						"update iscritto_t_domanda_isc set",
						"  fl_istruita = :istruita",
						"where id_domanda_iscrizione = :idDomandaIscrizione")
				.bind("istruita", ConvertUtils.toSN(istruita))
				.bind("idDomandaIscrizione", idDomanda));

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	/*
	 * Jira ISBO-280
	 *
	 * Query di verifica presenza di una condizione di punteggio per una domanda
	 *
	 * @see it.csi.iscritto.serviscritto.business.integration.dao.custom.IstruttoriaDao#hasDomandaCondizionePunteggio(java.lang.Long, java.lang.String)
	 */
	@Override
	public boolean hasDomandaCondizionePunteggio(Long idDomanda, String codCondizionePunteggio) throws DaoException {
		final String methodName = "updateStatoScuola";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		log.debug(buildMessage(getClass(), methodName, "idDomandaIscrizione: " + idDomanda));
		log.debug(buildMessage(getClass(), methodName, "codCondizionePunteggio: " + codCondizionePunteggio));

		Validate.notNull(idDomanda);
		Validate.notBlank(codCondizionePunteggio);

		final SqlHolder sh = buildSqlHolder()
				.addQueryRows(
						"select",
						"  pun_dom.id_domanda_iscrizione",
						"from",
						"  iscritto_r_punteggio_dom pun_dom, iscritto_d_condizione_pun pun",
						"where",
						"  pun_dom.id_condizione_punteggio = pun.id_condizione_punteggio and",
						"  pun_dom.id_domanda_iscrizione = :idDomanda and",
						"  pun.cod_condizione = :codCondizionePunteggio and",
						"  pun_dom.dt_fine_validita is null and",
						"  pun_dom.fl_valida is null")
				.bind("idDomanda", idDomanda)
				.bind("codCondizionePunteggio", codCondizionePunteggio);

		List<IscrittoRPunteggioDom> result = this.query(sh, IscrittoRPunteggioDom.class);

		log.debug(buildMessage(getClass(), methodName, LOG_END));

		if (result != null && result.size() > 0) {
			return true;
		}

		return false;
	}

	@Override
	public boolean hasDomandaCondizioneIstruita(Long idDomanda, String codCondizionePunteggio) throws DaoException {
		final String methodName = "hasDomandaCondizioneIstruita";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		log.debug(buildMessage(getClass(), methodName, "idDomandaIscrizione: " + idDomanda));
		log.debug(buildMessage(getClass(), methodName, "codCondizionePunteggio: " + codCondizionePunteggio));

		Validate.notNull(idDomanda);
		Validate.notBlank(codCondizionePunteggio);

		final SqlHolder sh = buildSqlHolder()
				.addQueryRows(
						"select",
						"  pun_dom.id_domanda_iscrizione",
						"from",
						"  iscritto_r_punteggio_dom pun_dom, iscritto_d_condizione_pun pun",
						"where",
						"  pun_dom.id_condizione_punteggio = pun.id_condizione_punteggio and",
						"  pun_dom.id_domanda_iscrizione = :idDomanda and",
						"  pun.cod_condizione = :codCondizionePunteggio and",
						"  pun_dom.dt_fine_validita is null and",
						"  (pun_dom.fl_valida is null or pun_dom.fl_valida = 'S')")
				.bind("idDomanda", idDomanda)
				.bind("codCondizionePunteggio", codCondizionePunteggio);

		boolean result = CollectionUtils.size(this.query(sh, IscrittoRPunteggioDom.class)) > 0;

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public boolean hasDomandaCondizioneValida(Long idDomanda, String codCondizionePunteggio) throws DaoException {
		final String methodName = "hasDomandaCondizioneValida";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		log.debug(buildMessage(getClass(), methodName, "idDomandaIscrizione: " + idDomanda));
		log.debug(buildMessage(getClass(), methodName, "codCondizionePunteggio: " + codCondizionePunteggio));

		Validate.notNull(idDomanda);
		Validate.notBlank(codCondizionePunteggio);

		final SqlHolder sh = buildSqlHolder()
				.addQueryRows(
						"select",
						"  pun_dom.id_domanda_iscrizione",
						"from",
						"  iscritto_r_punteggio_dom pun_dom, iscritto_d_condizione_pun pun",
						"where",
						"  pun_dom.id_condizione_punteggio = pun.id_condizione_punteggio and",
						"  pun_dom.id_domanda_iscrizione = :idDomanda and",
						"  pun.cod_condizione = :codCondizionePunteggio and",
						"  pun_dom.dt_fine_validita is null and",
						"  pun_dom.fl_valida = 'S'")
				.bind("idDomanda", idDomanda)
				.bind("codCondizionePunteggio", codCondizionePunteggio);

		boolean result = CollectionUtils.size(this.query(sh, IscrittoRPunteggioDom.class)) > 0;

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

}
