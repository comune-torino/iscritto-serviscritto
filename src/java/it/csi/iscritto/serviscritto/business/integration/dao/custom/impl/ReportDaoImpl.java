package it.csi.iscritto.serviscritto.business.integration.dao.custom.impl;

import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.LOG_BEGIN;
import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.LOG_END;
import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.buildMessage;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.Validate;
import org.apache.log4j.Logger;

import it.csi.iscritto.serviscritto.business.integration.dao.AbstractDao;
import it.csi.iscritto.serviscritto.business.integration.dao.TipoScuola;
import it.csi.iscritto.serviscritto.business.integration.dao.custom.ReportDao;
import it.csi.iscritto.serviscritto.business.integration.dao.custom.dto.GraduatoriaApprovazioneRow;
import it.csi.iscritto.serviscritto.business.integration.dao.custom.dto.GraduatoriaCompletaRow;
import it.csi.iscritto.serviscritto.business.integration.dao.custom.dto.ReportDomandeScuolaResidenzaRow;
import it.csi.iscritto.serviscritto.business.integration.dao.custom.dto.ReportPostiLiberiRow;
import it.csi.iscritto.serviscritto.business.integration.dao.custom.dto.ResidenzaForzataRow;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTAnagraficaGra;
import it.csi.iscritto.serviscritto.business.integration.exception.DaoException;
import it.csi.iscritto.serviscritto.business.util.Constants;
import it.csi.iscritto.serviscritto.business.util.DateUtils;
import it.csi.iscritto.serviscritto.business.util.sql.SqlHolder;

public class ReportDaoImpl extends AbstractDao implements ReportDao {
	private static final Logger log = Logger.getLogger(Constants.COMPONENT_NAME + ".dao");

	@Override
	public List<ResidenzaForzataRow> findResidenzeForzate(Long idStepGraCon) throws DaoException {
		final String methodName = "findResidenzeForzate";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		log.debug(buildMessage(getClass(), methodName, "idStepGraCon: " + idStepGraCon));

		SqlHolder sh = buildSqlHolder()
				.addQueryRows(
						"select distinct",
						"  dom.id_domanda_iscrizione,",
						"  dom.protocollo,",
						"  fe.cod_fascia_eta,",
						"  scu.cod_scuola,",
						"  scu.descrizione as desc_scuola,",
						"  scu.indirizzo,",
						"  ord.cod_ordine_scuola,",
						"  cd.id_anagrafica_soggetto,",
						"  cd.codice_fiscale,",
						"  cd.cognome,",
						"  cd.nome",
						"from",
						"  componentidomanda cd,",
						"  iscritto_t_graduatoria g,",
						"  iscritto_r_punteggio_dom pp,",
						"  iscritto_t_domanda_isc dom,",
						"  iscritto_d_fascia_eta fe,",
						"  iscritto_t_scuola scu,",
						"  iscritto_d_stato_scu dss,",
						"  iscritto_d_ordine_scuola ord,",
						"  iscritto_d_condizione_pun pun",
						"where g.id_step_gra_con = :idStepGraCon",
						"  and g.id_domanda_iscrizione = cd.id_domanda_iscrizione",
						"  and dom.id_domanda_iscrizione = cd.id_domanda_iscrizione",
						"  and pp.id_domanda_iscrizione = g.id_domanda_iscrizione",
						"  and fe.id_fascia_eta = g.id_fascia_eta",
						"  and scu.id_scuola = g.id_scuola",
						"  and dss.id_stato_scu = g.id_stato_scu",
						"  and ord.id_ordine_scuola = scu.id_ordine_scuola",
						"  and pun.id_condizione_punteggio = pp.id_condizione_punteggio",
						"  and dss.cod_stato_scu = 'AMM'",
						"  and cd.cod_tipo_soggetto = 'MIN'",
						"  and pun.cod_condizione = 'RES_TO_FUT'",
						"  and pp.dt_fine_validita is null",
						"  and (pp.fl_valida = 'S' or pp.fl_valida is null)",
						"order by",
						"  dom.protocollo")
				.bind("idStepGraCon", idStepGraCon);

		List<ResidenzaForzataRow> result = this.query(sh, ResidenzaForzataRow.class);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public List<GraduatoriaCompletaRow> findGraduatoriaCompleta(TipoScuola tipoScuola, Long idStepGraCon) throws DaoException {
		final String methodName = "findGraduatoriaCompleta";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		log.debug(buildMessage(getClass(), methodName, "tipoScuola: " + tipoScuola));
		log.debug(buildMessage(getClass(), methodName, "idStepGraCon: " + idStepGraCon));

		Validate.notNull(tipoScuola);

		SqlHolder sh = buildSqlHolder()
				.addQueryRows(
						"with",
						"graduatoria_complessiva as (",
						"  select",
						"    fe.id_fascia_eta, ",
						"    fe.cod_fascia_eta, ",
						"    di.protocollo,",
						"    di.data_consegna,",
						"    g.punteggio,",
						"    g.ordinamento,",
						"    cd.nome,",
						"    cd.cognome,",
						"    cd.codice_fiscale,",
						"    cd.data_nascita,",
						"    cd.ora_nascita,",
						"    g.isee, ",
						"    '1) '  || ss1.indirizzo  || ' - ' || tf1.cod_tipo_frequenza || ' - ' || stc1.cod_stato_scu as pref_a,",
						"    '2) '  || ss2.indirizzo  || ' - ' || tf2.cod_tipo_frequenza || ' - ' || stc2.cod_stato_scu as pref_b,",
						"    '3) '  || ss3.indirizzo  || ' - ' || tf3.cod_tipo_frequenza || ' - ' || stc3.cod_stato_scu as pref_c,",
						"    '4) '  || ss4.indirizzo  || ' - ' || tf4.cod_tipo_frequenza || ' - ' || stc4.cod_stato_scu as pref_d,",
						"    '5) '  || ss5.indirizzo  || ' - ' || tf5.cod_tipo_frequenza || ' - ' || stc5.cod_stato_scu as pref_e,",
						"    '6) '  || ss6.indirizzo  || ' - ' || tf6.cod_tipo_frequenza || ' - ' || stc6.cod_stato_scu as pref_f,",
						"    '7) '  || ss7.indirizzo  || ' - ' || tf7.cod_tipo_frequenza || ' - ' || stc7.cod_stato_scu as pref_g,",
						"    '8) '  || ss8.indirizzo  || ' - ' || tf8.cod_tipo_frequenza || ' - ' || stc8.cod_stato_scu as pref_h,",
						"    '9) '  || ss9.indirizzo  || ' - ' || tf9.cod_tipo_frequenza || ' - ' || stc9.cod_stato_scu as pref_i,",
						"    '10) ' || ss10.indirizzo || ' - ' ||tf10.cod_tipo_frequenza || ' - ' || stc10.cod_stato_scu as pref_j",
						"  from",
						"    iscritto_t_scuola s,",
						"    iscritto_d_fascia_eta fe,",
						"    iscritto_d_tipo_fre tf,",
						"    iscritto_d_circoscrizione idc1,",
						"    iscritto_t_step_gra_con sgc,",
						"    iscritto_t_domanda_isc di,",
						"    iscritto_t_anno_sco a,",
						"    iscritto_d_ordine_scuola os,",
						"    iscritto_d_stato_gra sg,",
						"    componentidomanda cd,",
						"    iscritto_t_graduatoria g",
						"    left join iscritto_r_scuola_pre sc1 on g.id_domanda_iscrizione= sc1.id_domanda_iscrizione and sc1.posizione=1",
						"    left join iscritto_r_scuola_pre sc2 on g.id_domanda_iscrizione= sc2.id_domanda_iscrizione and sc2.posizione=2",
						"    left join iscritto_r_scuola_pre sc3 on g.id_domanda_iscrizione= sc3.id_domanda_iscrizione and sc3.posizione=3",
						"    left join iscritto_r_scuola_pre sc4 on g.id_domanda_iscrizione= sc4.id_domanda_iscrizione and sc4.posizione=4",
						"    left join iscritto_r_scuola_pre sc5 on g.id_domanda_iscrizione= sc5.id_domanda_iscrizione and sc5.posizione=5",
						"    left join iscritto_r_scuola_pre sc6 on g.id_domanda_iscrizione= sc6.id_domanda_iscrizione and sc6.posizione=6",
						"    left join iscritto_r_scuola_pre sc7 on g.id_domanda_iscrizione= sc7.id_domanda_iscrizione and sc7.posizione=7",
						"    left join iscritto_r_scuola_pre sc8 on g.id_domanda_iscrizione= sc8.id_domanda_iscrizione and sc8.posizione=8",
						"    left join iscritto_r_scuola_pre sc9 on g.id_domanda_iscrizione= sc9.id_domanda_iscrizione and sc9.posizione=9",
						"    left join iscritto_r_scuola_pre sc10 on g.id_domanda_iscrizione= sc10.id_domanda_iscrizione and sc10.posizione=10",
						"    left join iscritto_d_tipo_fre tf1 on sc1.id_tipo_frequenza=tf1.id_tipo_frequenza",
						"    left join iscritto_d_tipo_fre tf2 on sc2.id_tipo_frequenza=tf2.id_tipo_frequenza",
						"    left join iscritto_d_tipo_fre tf3 on sc3.id_tipo_frequenza=tf3.id_tipo_frequenza",
						"    left join iscritto_d_tipo_fre tf4 on sc4.id_tipo_frequenza=tf4.id_tipo_frequenza",
						"    left join iscritto_d_tipo_fre tf5 on sc5.id_tipo_frequenza=tf5.id_tipo_frequenza",
						"    left join iscritto_d_tipo_fre tf6 on sc6.id_tipo_frequenza=tf6.id_tipo_frequenza",
						"    left join iscritto_d_tipo_fre tf7 on sc7.id_tipo_frequenza=tf7.id_tipo_frequenza",
						"    left join iscritto_d_tipo_fre tf8 on sc8.id_tipo_frequenza=tf8.id_tipo_frequenza",
						"    left join iscritto_d_tipo_fre tf9 on sc9.id_tipo_frequenza=tf9.id_tipo_frequenza",
						"    left join iscritto_d_tipo_fre tf10 on sc10.id_tipo_frequenza=tf10.id_tipo_frequenza",
						"    left join iscritto_t_scuola ss1 on sc1.id_scuola=ss1.id_scuola",
						"    left join iscritto_t_scuola ss2 on sc2.id_scuola=ss2.id_scuola",
						"    left join iscritto_t_scuola ss3 on sc3.id_scuola=ss3.id_scuola",
						"    left join iscritto_t_scuola ss4 on sc4.id_scuola=ss4.id_scuola",
						"    left join iscritto_t_scuola ss5 on sc5.id_scuola=ss5.id_scuola",
						"    left join iscritto_t_scuola ss6 on sc6.id_scuola=ss6.id_scuola",
						"    left join iscritto_t_scuola ss7 on sc7.id_scuola=ss7.id_scuola",
						"    left join iscritto_t_scuola ss8 on sc8.id_scuola=ss8.id_scuola",
						"    left join iscritto_t_scuola ss9 on sc9.id_scuola=ss9.id_scuola",
						"    left join iscritto_t_scuola ss10 on sc10.id_scuola=ss10.id_scuola",
						"    left join iscritto_d_stato_scu stc1 on sc1.id_stato_scu =stc1.id_stato_scu",
						"    left join iscritto_d_stato_scu stc2 on sc2.id_stato_scu =stc2.id_stato_scu",
						"    left join iscritto_d_stato_scu stc3 on sc3.id_stato_scu =stc3.id_stato_scu",
						"    left join iscritto_d_stato_scu stc4 on sc4.id_stato_scu =stc4.id_stato_scu",
						"    left join iscritto_d_stato_scu stc5 on sc5.id_stato_scu =stc5.id_stato_scu",
						"    left join iscritto_d_stato_scu stc6 on sc6.id_stato_scu =stc6.id_stato_scu",
						"    left join iscritto_d_stato_scu stc7 on sc7.id_stato_scu =stc7.id_stato_scu",
						"    left join iscritto_d_stato_scu stc8 on sc8.id_stato_scu =stc8.id_stato_scu",
						"    left join iscritto_d_stato_scu stc9 on sc9.id_stato_scu =stc9.id_stato_scu",
						"    left join iscritto_d_stato_scu stc10 on sc10.id_stato_scu =stc10.id_stato_scu",
						"  where",
						"    di.id_domanda_iscrizione = cd.id_domanda_iscrizione and",
						"    cd.cod_tipo_soggetto = 'MIN' and",
						"    g.id_fascia_eta = fe.id_fascia_eta and",
						"    g.id_tipo_frequenza = tf.id_tipo_frequenza and",
						"    g.id_scuola = s.id_scuola and",
						"    s.id_circoscrizione = idc1.id_circoscrizione and",
						"    g.id_step_gra_con = sgc.id_step_gra_con and",
						"    g.id_domanda_iscrizione = di.id_domanda_iscrizione and",
						"    di.id_anno_scolastico = a.id_anno_scolastico and",
						"    di.id_ordine_scuola = os.id_ordine_scuola and",
						"    sgc.id_stato_gra = sg.id_stato_gra and",
						"    g.id_step_gra_con = :idStepGraCon and",
						"    os.cod_ordine_scuola = :codOrdineScuola",
						")",
						"select",
						"  max(gc.ordinamento) as ord,",
						"  gc.id_fascia_eta, ",
						"  gc.cod_fascia_eta, ",
						"  gc.protocollo,",
						"  gc.data_consegna,",
						"  gc.punteggio,",
						"  gc.nome,",
						"  gc.cognome,",
						"  gc.codice_fiscale,",
						"  gc.data_nascita,",
						"  gc.ora_nascita,",
						"  gc.isee, ",
						"  gc.pref_a,",
						"  gc.pref_b,",
						"  gc.pref_c,",
						"  gc.pref_d,",
						"  gc.pref_e,",
						"  gc.pref_f,",
						"  gc.pref_g,",
						"  gc.pref_h,",
						"  gc.pref_i,",
						"  gc.pref_j",
						"from",
						"  graduatoria_complessiva gc",
						"group by ",
						"  gc.id_fascia_eta, ",
						"  gc.cod_fascia_eta, ",
						"  gc.protocollo,",
						"  gc.data_consegna,",
						"  gc.punteggio,",
						"  gc.nome,",
						"  gc.cognome,",
						"  gc.codice_fiscale,",
						"  gc.data_nascita,",
						"  gc.ora_nascita,",
						"  gc.isee, ",
						"  gc.pref_a,",
						"  gc.pref_b,",
						"  gc.pref_c,",
						"  gc.pref_d,",
						"  gc.pref_e,",
						"  gc.pref_f,",
						"  gc.pref_g,",
						"  gc.pref_h,",
						"  gc.pref_i,",
						"  gc.pref_j",
						"order by",
						"  case",
						"    when gc.cod_fascia_eta = 'L' then 1",
						"    when gc.cod_fascia_eta = 'P' then 2",
						"    when gc.cod_fascia_eta = 'G' then 3",
						"    else 0",
						"  end,",
						"  ord")
				.bind("codOrdineScuola", tipoScuola.getCod())
				.bind("idStepGraCon", idStepGraCon);

		List<GraduatoriaCompletaRow> result = this.query(sh, GraduatoriaCompletaRow.class);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public List<GraduatoriaApprovazioneRow> findGraduatoriaApprovazione(
			TipoScuola tipoScuola, String codAnagraficaGra, Integer step, String codStatoGra) throws DaoException {

		final String methodName = "findGraduatoriaApprovazione";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		log.debug(buildMessage(getClass(), methodName, "tipoScuola: " + tipoScuola));
		log.debug(buildMessage(getClass(), methodName, "codAnagraficaGra: " + codAnagraficaGra));
		log.debug(buildMessage(getClass(), methodName, "step: " + step));

		Validate.notNull(tipoScuola);

		SqlHolder sh = buildSqlHolder()
				.addQueryRows(
						"with",
						"view_sgc as (",
						"  select",
						"    sg.id_step_gra,",
						"    sg.dt_dom_inv_da,",
						"    sg.dt_dom_inv_a,",
						"    sgc.id_step_gra_con",
						"  from iscritto_t_step_gra_con sgc",
						"    join iscritto_t_step_gra sg on sg.id_step_gra = sgc.id_step_gra",
						"    join iscritto_t_anagrafica_gra agr on sg.id_anagrafica_gra = agr.id_anagrafica_gra",
						"    join iscritto_d_ordine_scuola os on os.id_ordine_scuola = agr.id_ordine_scuola",
						"    join iscritto_d_stato_gra dsg on dsg.id_stato_gra = sgc.id_stato_gra",
						"  where 1 = 1",
						"    and os.cod_ordine_scuola = :codOrdineScuola",
						"    and agr.cod_anagrafica_gra = :codAnagraficaGra",
						"    and sg.step = :step",
						"    and dsg.cod_stato_gra in ('PRO', 'PRO_CON', 'DEF', 'DEF_CON')",
						"    and dsg.cod_stato_gra = :codStatoGra",
						"  order by",
						"    sgc.dt_step_con desc",
						"),",
						"report as (",
						"  select distinct",
						"    a.protocollo,",
						"    a.data_consegna,",
						"    a.cod_fascia_eta,",
						"    a.cognome,",
						"    a.nome,",
						"    a.data_nascita,",
						"    a.ora_nascita,",
						"    a.isee,",
						"    a.punteggio as punteggio_prima_scelta,",
						"    b.punteggio,",
						"    a.fl_fuori_termine,",
						"    a.ordinamento,",
						"    x.id_domanda_iscrizione",
						"  from",
						"    (",
						"      select",
						"        d.data_consegna,",
						"        d.id_domanda_iscrizione,",
						"        d.protocollo,",
						"        c.cognome,",
						"        c.nome,",
						"        g.punteggio,",
						"        g.ordine_preferenza,",
						"        f.cod_fascia_eta,",
						"        g.id_scuola,",
						"        g.id_stato_scu,",
						"        g.isee,",
						"        c.data_nascita,",
						"        c.ora_nascita,",
						"        rpun.fl_fuori_termine,",
						"        g.ordinamento",
						"      from",
						"        iscritto_t_graduatoria g,",
						"        iscritto_t_domanda_isc d,",
						"        componentidomanda c,",
						"        iscritto_d_fascia_eta f,",
						"        iscritto_r_scuola_pre rpun,",
						"		 iscritto_t_domanda_isc P",
						"      where g.id_domanda_iscrizione = d.id_domanda_iscrizione",
						"		 and rpun.id_scuola = g.id_scuola",
						"        and d.id_domanda_iscrizione = c.id_domanda_iscrizione",
						"        and d.id_domanda_iscrizione = rpun.id_domanda_iscrizione",
						"        and g.id_fascia_eta = f.id_fascia_eta",
						"        and g.id_step_gra_con = (select id_step_gra_con from view_sgc limit 1)",
						"        and c.cod_tipo_soggetto = 'MIN'",
						"		 and g.id_domanda_iscrizione = P.id_domanda_iscrizione",
						"    ) a left join",
						"     (",
				        "          select distinct P.id_domanda_iscrizione",
				        "          from iscritto_r_punteggio_dom P",
				        "                   join iscritto_r_scuola_pre S",
				        "                        on P.id_domanda_iscrizione = S.id_domanda_iscrizione",
				        "         where (P.id_condizione_punteggio = 4",
				        "             or P.id_condizione_punteggio = 5",
				        "            or P.id_condizione_punteggio = 24",
				        "             or P.id_condizione_punteggio = 25)",
				        "              and P.fl_valida = 'S'",
				        "              and S.fl_fuori_termine = 'N'",
				        "              and P.dt_fine_validita is null",
				        "      ) x on x.id_domanda_iscrizione = a.id_domanda_iscrizione",
				        "          left join",
						"    (",
						"      select",
						"        d.id_domanda_iscrizione,",
						"        d.protocollo,",
						"        c.cognome,",
						"        c.nome,",
						"        g.punteggio,",
						"        rpun2.fl_fuori_termine",
						"      from",
						"        iscritto_t_graduatoria g,",
						"        iscritto_t_domanda_isc d,",
						"        componentidomanda c,",
						"        iscritto_r_scuola_pre rpun2",
						"      where g.id_domanda_iscrizione = d.id_domanda_iscrizione",
						"        and d.id_domanda_iscrizione = c.id_domanda_iscrizione",
						"        and d.id_domanda_iscrizione = rpun2.id_domanda_iscrizione",
						"        and g.id_step_gra_con = (select id_step_gra_con from view_sgc limit 1)",
						"        and c.cod_tipo_soggetto = 'MIN'",
						"      group by",
						"        d.id_domanda_iscrizione,",
						"        d.protocollo,",
						"        c.cognome,",
						"        c.nome,",
						"        g.punteggio,",
						"        rpun2.fl_fuori_termine",
						"      ) b on a.id_domanda_iscrizione = b.id_domanda_iscrizione and a.punteggio <> b.punteggio",
						"    left join iscritto_t_graduatoria g2 on a.id_domanda_iscrizione = g2.id_domanda_iscrizione",
						"      and g2.id_step_gra_con = (select id_step_gra_con from view_sgc limit 1)",
						"    left join iscritto_t_scuola s on g2.id_scuola = s.id_scuola",
						"  where",
						"    a.ordine_preferenza = 1 and",
						"    a.data_consegna between (select dt_dom_inv_da from view_sgc limit 1) and (select dt_dom_inv_a from view_sgc limit 1)",
						")",
						"select * from (",
						"  select * from report where cod_fascia_eta = 'L'",
						"  order by",
						"    fl_fuori_termine,",
						"    punteggio_prima_scelta desc,",
						"    isee,",
						"    data_nascita,",
						"    ora_nascita",
						") v1",
						"union all",
						"select * from (",
						"  select * from report where cod_fascia_eta = 'P'",
						"  order by",
						"    fl_fuori_termine,",
						"    punteggio_prima_scelta desc,",
						"    isee,",
						"    data_nascita,",
						"    ora_nascita",
						") v2",
						"union all",
						"select * from (",
						"  select * from report where cod_fascia_eta = 'G'",
						"  order by",
						"    fl_fuori_termine,",
						"    punteggio_prima_scelta desc,",
						"    isee,",
						"    data_nascita desc,",
						"    ora_nascita desc",
						") v3",
						"union all",
						"select * from (",
						"  select * from report where cod_fascia_eta not in ('L', 'P', 'G')",
						"  order by",
						"    cod_fascia_eta,",
						"    fl_fuori_termine,",
						"    punteggio_prima_scelta desc,",
						"    isee,",
						"    data_nascita desc,",
						"    ora_nascita desc",
						") v4")
				.bind("codOrdineScuola", tipoScuola.getCod())
				.bind("codAnagraficaGra", codAnagraficaGra)
				.bind("step", step)
				.bind("codStatoGra", codStatoGra);

		List<GraduatoriaApprovazioneRow> result = this.query(sh, GraduatoriaApprovazioneRow.class);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public List<ReportPostiLiberiRow> findPostiLiberi(String codOrdineScuola) throws DaoException {
		final String methodName = "findPostiLiberi";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		SqlHolder sh = buildSqlHolder()
				.addQueryRows(
						"with dati_anagrafica as (",
						"  select",
						"    ag.cod_anagrafica_gra,",
						"    ag.id_anno_scolastico,",
						"    ag.id_ordine_scuola",
						"  from iscritto_t_anagrafica_gra ag",
						"  where",
						"    ag.dt_scadenza_grad >= current_date and ag.id_ordine_scuola = (select id_ordine_scuola from iscritto_d_ordine_scuola where cod_ordine_scuola = :codOrdineScuola)",
						"  order by",
						"    ag.dt_scadenza_grad",
						"  limit 1",
						")",
						"select",
						"  ord.cod_ordine_scuola,",
						"  (select cod_anagrafica_gra from dati_anagrafica) as cod_anagrafica_graduatoria,",
						"  now() as data_creazione,",
						"  scu.cod_scuola,",
						"  scu.indirizzo as indirizzo_scuola,",
						"  fe.cod_fascia_eta as desc_fascia_eta,",
						"  tf.descrizione as desc_tipo_frequenza,",
						"  cl.posti_liberi,",
						"  cl.posti_ammessi",
						"from iscritto_t_classe cl",
						"  join iscritto_t_scuola scu on scu.id_scuola = cl.id_scuola",
						"  join iscritto_d_ordine_scuola ord on ord.id_ordine_scuola = scu.id_ordine_scuola",
						"  join iscritto_t_eta eta on eta.id_eta = cl.id_eta",
						"  join iscritto_d_fascia_eta fe on fe.id_fascia_eta = eta.id_fascia_eta",
						"  join iscritto_d_tipo_fre tf on tf.id_tipo_frequenza = cl.id_tipo_frequenza",
						"where 1 = 1",
						"  and cl.id_anno_scolastico = (select id_anno_scolastico from dati_anagrafica)",
						"  and scu.id_ordine_scuola = (select id_ordine_scuola from dati_anagrafica)")
						.bind("codOrdineScuola",codOrdineScuola);

		List<ReportPostiLiberiRow> result = this.query(sh, ReportPostiLiberiRow.class);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public List<ReportDomandeScuolaResidenzaRow> findDomandeScuolaResidenza() throws DaoException {
		final String methodName = "findDomendeScuolaResidenza";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		final Date now = new Date();

		SqlHolder sh = buildSqlHolder()
				.addQueryRows(
						"select domIsc.protocollo as protocollo, ",
					    "  anSog.codice_fiscale as codiceFiscaleMinore, ",
					    "   anSog.cognome as cognomeMinore, ",
					    "   anSog.nome as nomeMinore, ",
					    "   its.cod_scuola as codiceScuola, ",
					    "   its.descrizione as descScuola, ",
					    "   its.indirizzo as indirizzoScuola",
					    "from iscritto_t_domanda_isc domIsc ",
					    "join iscritto_t_anagrafica_sog anSog on domIsc.id_domanda_iscrizione = anSog.id_domanda_iscrizione  ",
					    "join iscritto_t_scuola its on domIsc.id_ordine_scuola = its.id_ordine_scuola ",
					    "join iscritto_r_punteggio_dom irpd on domIsc.id_domanda_iscrizione = irpd.id_domanda_iscrizione ",
					    "join iscritto_d_condizione_pun idcp on irpd.id_condizione_punteggio = idcp.id_condizione_punteggio ",
					    "join iscritto_t_anagrafica_gra itag on domIsc.id_anno_scolastico = itag.id_anno_scolastico ",
					    "join iscritto_t_graduatoria gra on domIsc.id_domanda_iscrizione = gra.id_domanda_iscrizione ",
					    "join iscritto_r_soggetto_rel r on anSog.id_anagrafica_soggetto = r.id_anagrafica_soggetto ",
					    "join iscritto_d_tipo_sog tip on r.id_tipo_soggetto = tip.id_tipo_soggetto ",
					    "where 1=1 ",
					    "and to_date(:data, 'YYYY-MM-DD') >= to_date(to_char(itag.dt_inizio_grad, 'YYYY-MM-DD'), 'YYYY-MM-DD') ",
					    "and to_date(:data, 'YYYY-MM-DD') <= to_date(to_char(itag.dt_scadenza_grad,  'YYYY-MM-DD'), 'YYYY-MM-DD') ",
					    "and itag.id_ordine_scuola = (select id_ordine_scuola from iscritto_d_ordine_scuola where cod_ordine_scuola = 'MAT') ",
					    "and gra.id_stato_scu = (select idsp.id_stato_scu from iscritto_d_stato_scu idsp where idsp.cod_stato_scu = 'AMM') ",
					    "and gra.ordine_preferenza = 1 ",
					    "and idcp.cod_condizione = 'RES_TO_EXTRA' ",
						"and irpd.fl_valida = 'S' ",
						"and irpd.dt_fine_validita is null ",
						"and irpd.id_utente is not null ",
						"and tip.cod_tipo_soggetto = 'MIN' ",
						"and its.id_scuola = gra.id_scuola ",
						"and gra.id_step_gra_con = ( ",
						" select ",
						"   sgc.id_step_gra_con ",
						"  from iscritto_t_anagrafica_gra gr ",
						"    join iscritto_t_anno_sco anno on anno.id_anno_scolastico = gr.id_anno_scolastico ",
						"    join iscritto_d_ordine_scuola os on os.id_ordine_scuola = gr.id_ordine_scuola ",
						"    join iscritto_t_step_gra sg on sg.id_anagrafica_gra = gr.id_anagrafica_gra ",
						"    left join iscritto_t_step_gra_con sgc on sgc.id_step_gra = sg.id_step_gra ",
						"    left join iscritto_d_stato_gra st_gra on st_gra.id_stato_gra = sgc.id_stato_gra ",
						"  where ",
						"    os.cod_ordine_scuola = 'MAT' ",
						"    and ",
						"    sgc.id_step_gra_con is not null ",
						"  order by ",
						"       sgc.id_step_gra_con desc ",
						" limit 1 ) ")
						.bind("data", DateUtils.toStringDate(now, DateUtils.ISO_8601_FORMAT));

		List<ReportDomandeScuolaResidenzaRow> result = this.query(sh, ReportDomandeScuolaResidenzaRow.class);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;


	}

}
