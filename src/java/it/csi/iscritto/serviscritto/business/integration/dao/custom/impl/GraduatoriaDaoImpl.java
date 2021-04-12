package it.csi.iscritto.serviscritto.business.integration.dao.custom.impl;

import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.LOG_BEGIN;
import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.LOG_END;
import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.buildMessage;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import org.apache.log4j.Logger;

import it.csi.iscritto.serviscritto.business.integration.dao.AbstractDao;
import it.csi.iscritto.serviscritto.business.integration.dao.ResultDao;
import it.csi.iscritto.serviscritto.business.integration.dao.StatoGraduatoria;
import it.csi.iscritto.serviscritto.business.integration.dao.TipoScuola;
import it.csi.iscritto.serviscritto.business.integration.dao.TipoVerificheIstruttoria;
import it.csi.iscritto.serviscritto.business.integration.dao.custom.GraduatoriaDao;
import it.csi.iscritto.serviscritto.business.integration.dao.custom.dto.AnagraficaGraduatoriaRow;
import it.csi.iscritto.serviscritto.business.integration.dao.custom.dto.ClasseRow;
import it.csi.iscritto.serviscritto.business.integration.dao.custom.dto.FunctionRow;
import it.csi.iscritto.serviscritto.business.integration.dao.custom.dto.InfoInvioAccRow;
import it.csi.iscritto.serviscritto.business.integration.dao.custom.dto.InfoStepGraduatoriaRow;
import it.csi.iscritto.serviscritto.business.integration.dao.custom.dto.InfoVerificheRow;
import it.csi.iscritto.serviscritto.business.integration.dao.custom.dto.NidoRow;
import it.csi.iscritto.serviscritto.business.integration.dao.custom.dto.PreferenzaScuolaRow;
import it.csi.iscritto.serviscritto.business.integration.dao.custom.dto.TestataGraduatoriaRow;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTAnagraficaGra;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTAnnoSco;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTClasse;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTDomandaIsc;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTGraduatoria;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTParametro;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTStepGra;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTStepGraCon;
import it.csi.iscritto.serviscritto.business.integration.exception.DaoException;
import it.csi.iscritto.serviscritto.business.integration.validation.ErrorCodeEnum;
import it.csi.iscritto.serviscritto.business.util.Constants;
import it.csi.iscritto.serviscritto.business.util.DateUtils;
import it.csi.iscritto.serviscritto.business.util.converter.ConvertUtils;
import it.csi.iscritto.serviscritto.business.util.sql.SqlHolder;
import it.csi.iscritto.serviscritto.dto.domanda.ClasseParam;
import it.csi.iscritto.serviscritto.dto.domanda.RicercaGraduatorieFilter;
import it.csi.iscritto.serviscritto.exception.domanda.ValidationException;

public class GraduatoriaDaoImpl extends AbstractDao implements GraduatoriaDao {
	private static final Logger log = Logger.getLogger(Constants.COMPONENT_NAME + ".dao");
	private static final String ID_STEP_GRA_CON_SEQ = "iscritto_t_step_gra_con_id_step_gra_con_seq";
	private static final String ID_CLASSE_SEQ = "iscritto_t_classe_id_classe_seq";

	@Override
	public List<IscrittoTAnagraficaGra> findUltimaGraduatoria(TipoScuola tipoScuola) throws DaoException {
		final String methodName = "findUltimaGraduatoria";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		log.debug(buildMessage(getClass(), methodName, "tipoScuola: " + tipoScuola));
		Validate.notNull(tipoScuola);

		final Date now = new Date();

		SqlHolder sh = buildSqlHolder()
				.addQueryRows(
						"select ",
						"  gr.id_anagrafica_gra, ",
						"  gr.cod_anagrafica_gra, ",
						"  gr.dt_inizio_iscr, ",
						"  gr.dt_scadenza_iscr, ",
						"  gr.dt_fine_iscr, ",
						"  gr.dt_scadenza_grad, ",
						"  gr.dt_scadenza_ricorsi, ",
						"  gr.id_anno_scolastico, ",
						"  gr.id_ordine_scuola ",
						"from iscritto_t_anagrafica_gra gr",
						"where 1 = 1",
						"  and to_date(:data, 'YYYY-MM-DD') >= to_date(to_char(gr.dt_inizio_grad, 'YYYY-MM-DD'), 'YYYY-MM-DD')",
						"  and to_date(:data, 'YYYY-MM-DD') <= to_date(to_char(gr.dt_scadenza_grad,  'YYYY-MM-DD'), 'YYYY-MM-DD')",
						"  and gr.id_ordine_scuola = (select id_ordine_scuola from iscritto_d_ordine_scuola where cod_ordine_scuola = :codOrdineScuola)")
				.bind("data", DateUtils.toStringDate(now, DateUtils.ISO_8601_FORMAT))
				.bind("codOrdineScuola", tipoScuola.getCod());

		List<IscrittoTAnagraficaGra> result = this.query(sh, IscrittoTAnagraficaGra.class);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public List<IscrittoTAnagraficaGra> findGraduatoria(TipoScuola tipoScuola, String codAnagraficaGra) throws DaoException {
		final String methodName = "findGraduatoria";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		log.debug(buildMessage(getClass(), methodName, "tipoScuola: " + tipoScuola));
		log.debug(buildMessage(getClass(), methodName, "codAnagraficaGra: " + codAnagraficaGra));

		Validate.notBlank(codAnagraficaGra);
		Validate.notNull(tipoScuola);

		SqlHolder sh = buildSqlHolder()
				.addQueryRows(
						"select ",
						"  gr.id_anagrafica_gra, ",
						"  gr.cod_anagrafica_gra, ",
						"  gr.dt_inizio_iscr, ",
						"  gr.dt_scadenza_iscr, ",
						"  gr.dt_fine_iscr, ",
						"  gr.dt_scadenza_grad, ",
						"  gr.dt_scadenza_ricorsi, ",
						"  gr.id_anno_scolastico, ",
						"  gr.id_ordine_scuola ",
						"from iscritto_t_anagrafica_gra gr",
						"where 1 = 1",
						"  and gr.cod_anagrafica_gra = :codAnagraficaGra",
						"  and gr.id_ordine_scuola = (select id_ordine_scuola from iscritto_d_ordine_scuola where cod_ordine_scuola = :codOrdineScuola)")
				.bind("codAnagraficaGra", codAnagraficaGra)
				.bind("codOrdineScuola", tipoScuola.getCod());

		List<IscrittoTAnagraficaGra> result = this.query(sh, IscrittoTAnagraficaGra.class);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public IscrittoTStepGra findStepGraduatoria(Long idAnagraficaGra) throws DaoException {
		final String methodName = "findStepGraduatoria";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		log.debug(buildMessage(getClass(), methodName, "idAnagraficaGra: " + idAnagraficaGra));
		Validate.notNull(idAnagraficaGra);

		final Date now = new Date();

		SqlHolder sh = buildSqlHolder()
				.addQueryRows(
						"select",
						"  sg.step,",
						"  sg.dt_step_gra,",
						"  sg.id_step_gra,",
						"  sg.id_anagrafica_gra,",
						"  sg.dt_dom_inv_da,",
						"  sg.dt_dom_inv_a,",
						"  sg.dt_allegati",
						"from iscritto_t_step_gra sg",
						"where 1 = 1",
						"  and sg.id_anagrafica_gra = :idAnagraficaGra",
						"  and to_date(:data, 'YYYY-MM-DD') >= to_date(to_char(sg.dt_step_gra, 'YYYY-MM-DD'), 'YYYY-MM-DD')",
						"order by sg.dt_step_gra desc",
						"limit 1")
				.bind("data", DateUtils.toStringDate(now, DateUtils.ISO_8601_FORMAT))
				.bind("idAnagraficaGra", idAnagraficaGra);

		IscrittoTStepGra result = ConvertUtils.getFirst(this.query(sh, IscrittoTStepGra.class));

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public IscrittoTStepGraCon findStepGraduatoriaCon(Long idStepGra) throws DaoException {
		final String methodName = "findStepGraduatoriaCon";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		log.debug(buildMessage(getClass(), methodName, "idStepGra: " + idStepGra));
		Validate.notNull(idStepGra);

		SqlHolder sh = buildSqlHolder()
				.addQueryRows(
						"select",
						"  sgc.id_step_gra_con,",
						"  sgc.id_step_gra,",
						"  sgc.id_stato_gra,",
						"  sgc.fl_ammissioni,",
						"  sgc.fl_calcolo_in_corso,",
						"  sgc.dt_step_con",
						"from iscritto_t_step_gra_con sgc",
						"where 1 = 1",
						"  and sgc.id_step_gra = :idStepGra",
						"order by sgc.dt_step_con desc",
						"limit 1")
				.bind("idStepGra", idStepGra);

		IscrittoTStepGraCon result = ConvertUtils.getFirst(this.query(sh, IscrittoTStepGraCon.class));

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public List<AnagraficaGraduatoriaRow> findElencoGraduatorie(TipoScuola tipoScuola) throws DaoException {
		final String methodName = "findElencoGraduatorie";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		log.debug(buildMessage(getClass(), methodName, "tipoScuola: " + tipoScuola));
		Validate.notNull(tipoScuola);

		SqlHolder sh = buildSqlHolder()
				.addQueryRows(
						"select ",
						"  gr.id_anagrafica_gra, ",
						"  gr.cod_anagrafica_gra, ",
						"  gr.dt_inizio_iscr, ",
						"  gr.dt_scadenza_iscr, ",
						"  gr.dt_fine_iscr, ",
						"  gr.dt_scadenza_grad, ",
						"  gr.dt_scadenza_ricorsi, ",
						"  (",
						"    select anno.cod_anno_scolastico from iscritto_t_anno_sco anno where anno.id_anno_scolastico = gr.id_anno_scolastico",
						"  ) as cod_anno_scolastico,",
						"  (",
						"    select os.cod_ordine_scuola from iscritto_d_ordine_scuola os where os.id_ordine_scuola = gr.id_ordine_scuola",
						"  ) as cod_ordine_scuola",
						"from iscritto_t_anagrafica_gra gr",
						"where 1 = 1",
						"  and gr.id_ordine_scuola = (select id_ordine_scuola from iscritto_d_ordine_scuola where cod_ordine_scuola = :codOrdineScuola)")
				.bind("codOrdineScuola", tipoScuola.getCod());

		List<AnagraficaGraduatoriaRow> result = this.query(sh, AnagraficaGraduatoriaRow.class);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public List<IscrittoTStepGra> findElencoStepGraduatoria(TipoScuola tipoScuola, String codAnagraficaGra) throws DaoException {
		final String methodName = "findElencoStepGraduatoria";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		log.debug(buildMessage(getClass(), methodName, "tipoScuola: " + tipoScuola));
		log.debug(buildMessage(getClass(), methodName, "codAnagraficaGra: " + codAnagraficaGra));

		Validate.notNull(tipoScuola);
		Validate.notBlank(codAnagraficaGra);

		SqlHolder sh = buildSqlHolder()
				.addQueryRows(
						"select ",
						"  sg.step, ",
						"  sg.dt_step_gra, ",
						"  sg.id_step_gra, ",
						"  sg.id_anagrafica_gra, ",
						"  sg.dt_dom_inv_da, ",
						"  sg.dt_dom_inv_a, ",
						"  sg.dt_allegati ",
						"from iscritto_t_step_gra sg",
						"where 1 = 1",
						"  and sg.id_anagrafica_gra = (",
						"    select gr.id_anagrafica_gra from iscritto_t_anagrafica_gra gr",
						"    where gr.cod_anagrafica_gra = :codAnagraficaGra",
						"      and gr.id_ordine_scuola = (",
						"        select id_ordine_scuola from iscritto_d_ordine_scuola where cod_ordine_scuola = :codOrdineScuola",
						"      )",
						"  )",
						"  and exists (select * from iscritto_t_step_gra_con sgc where sgc.id_step_gra = sg.id_step_gra)",
						"order by sg.dt_step_gra")
				.bind("codOrdineScuola", tipoScuola.getCod())
				.bind("codAnagraficaGra", codAnagraficaGra);

		List<IscrittoTStepGra> result = this.query(sh, IscrittoTStepGra.class);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public List<InfoStepGraduatoriaRow> findInfoStepGraduatorie(TipoScuola tipoScuola) throws DaoException {
		final String methodName = "findInfoStepGraduatorie";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		log.debug(buildMessage(getClass(), methodName, "tipoScuola: " + tipoScuola));
		Validate.notNull(tipoScuola);

		SqlHolder sh = buildSqlHolder()
				.addQueryRows(
						"select",
						"  gr.id_anagrafica_gra, ",
						"  gr.cod_anagrafica_gra,",
						"  anno.cod_anno_scolastico,",
						"  sg.id_step_gra,",
						"  sg.step,",
						"  sg.dt_step_gra,",
						"  sgc.id_step_gra_con,",
						"  sgc.dt_step_con,",
						"  sgc.fl_ammissioni,",
						"  st_gra.cod_stato_gra",
						"from iscritto_t_anagrafica_gra gr",
						"  join iscritto_t_anno_sco anno on anno.id_anno_scolastico = gr.id_anno_scolastico",
						"  join iscritto_d_ordine_scuola os on os.id_ordine_scuola = gr.id_ordine_scuola",
						"  join iscritto_t_step_gra sg on sg.id_anagrafica_gra = gr.id_anagrafica_gra",
						"  left join iscritto_t_step_gra_con sgc on sgc.id_step_gra = sg.id_step_gra",
						"  left join iscritto_d_stato_gra st_gra on st_gra.id_stato_gra = sgc.id_stato_gra",
						"where",
						"  os.cod_ordine_scuola = :codOrdineScuola",
						"order by",
						"  gr.cod_anagrafica_gra,",
						"  sg.step,",
						"  sg.dt_step_gra,",
						"  sgc.dt_step_con desc")
				.bind("codOrdineScuola", tipoScuola.getCod());

		List<InfoStepGraduatoriaRow> result = this.query(sh, InfoStepGraduatoriaRow.class);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public List<TestataGraduatoriaRow> findGraduatorie(RicercaGraduatorieFilter filter) throws DaoException {
		final String methodName = "findGraduatorie";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		Validate.notNull(filter);
		TipoScuola tipoScuola = Validate.notNull(TipoScuola.findByCod(filter.getCodOrdineScuola()));

		if (StringUtils.isEmpty(filter.getCodGraduatoria())) {
			log.error(buildMessage(getClass(), methodName, "codice graduatoria nullo"));
		}

		if (filter.getStepGraduatoria() == null) {
			log.error(buildMessage(getClass(), methodName, "step graduatoria nullo"));
		}

		SqlHolder sh = buildSqlHolder();
		sh.addQueryRows(
				"select * from (",
				"  select distinct",
				"    gr.ordinamento,",
				"    gr.punteggio,",
				"    gr.isee,",
				"    gr.ordine_preferenza,",
				"    gr.id_step_gra_con,",
				"    gr.id_domanda_iscrizione,",
				"    (",
				"      select dom.protocollo from iscritto_t_domanda_isc dom",
				"      where gr.id_domanda_iscrizione = dom.id_domanda_iscrizione",
				"    ) as protocollo,",
				"    (",
				"      select sog.nome from iscritto_t_anagrafica_sog sog ",
				"        join iscritto_r_soggetto_rel r on sog.id_anagrafica_soggetto = r.id_anagrafica_soggetto",
				"        join iscritto_d_tipo_sog tip on r.id_tipo_soggetto = tip.id_tipo_soggetto",
				"      where sog.id_domanda_iscrizione = gr.id_domanda_iscrizione and tip.cod_tipo_soggetto = 'MIN'",
				"    ) as nome_minore,",
				"    (",
				"      select sog.cognome from iscritto_t_anagrafica_sog sog ",
				"        join iscritto_r_soggetto_rel r on sog.id_anagrafica_soggetto = r.id_anagrafica_soggetto",
				"        join iscritto_d_tipo_sog tip on r.id_tipo_soggetto = tip.id_tipo_soggetto",
				"      where sog.id_domanda_iscrizione = gr.id_domanda_iscrizione and tip.cod_tipo_soggetto = 'MIN'",
				"    ) as cognome_minore,",
				"    (",
				"      select sog.data_nascita from iscritto_t_anagrafica_sog sog ",
				"        join iscritto_r_soggetto_rel r on sog.id_anagrafica_soggetto = r.id_anagrafica_soggetto",
				"        join iscritto_d_tipo_sog tip on r.id_tipo_soggetto = tip.id_tipo_soggetto",
				"      where sog.id_domanda_iscrizione = gr.id_domanda_iscrizione and tip.cod_tipo_soggetto = 'MIN'",
				"    ) as data_nascita,",
				"    (",
				"      select tf.cod_tipo_frequenza from iscritto_d_tipo_fre tf",
				"      where tf.id_tipo_frequenza = gr.id_tipo_frequenza",
				"    ) as cod_tipo_frequenza,",
				"    (",
				"      select ag.cod_anagrafica_gra from iscritto_t_step_gra_con sgc",
				"        join iscritto_t_step_gra sg on sgc.id_step_gra = sg.id_step_gra",
				"        join iscritto_t_anagrafica_gra ag on ag.id_anagrafica_gra = sg.id_anagrafica_gra",
				"      where sgc.id_step_gra_con = gr.id_step_gra_con",
				"      and ag.id_ordine_scuola in (",
				"        select sc.id_ordine_scuola from iscritto_t_scuola sc",
				"        where sc.id_scuola = gr.id_scuola",
				"      )",
				"    ) as cod_anagrafica_gra,",
				"    (",
				"      select sg.step from iscritto_t_step_gra_con sgc",
				"        join iscritto_t_step_gra sg on sgc.id_step_gra = sg.id_step_gra",
				"      where sgc.id_step_gra_con = gr.id_step_gra_con",
				"    ) as step,",
				"    (",
				"      select sc.cod_scuola from iscritto_t_scuola sc",
				"      where sc.id_scuola = gr.id_scuola",
				"    ) as cod_scuola,",
				"    (",
				"      select fe.cod_fascia_eta from iscritto_d_fascia_eta fe",
				"      where fe.id_fascia_eta = gr.id_fascia_eta",
				"    ) as cod_fascia_eta,",
				"    (",
				"      select dss.cod_stato_scu from iscritto_d_stato_scu dss",
				"      where dss.id_stato_scu = gr.id_stato_scu",
				"    ) as cod_stato_scu_dse,",
				"    (",
				"      select dss.cod_stato_scu from iscritto_d_stato_scu dss",
				"      where dss.id_stato_scu = (",
				"        select rsp.id_stato_scu from iscritto_r_scuola_pre rsp",
				"        where 1 = 1",
				"          and rsp.id_domanda_iscrizione = gr.id_domanda_iscrizione",
				"          and rsp.id_scuola = gr.id_scuola",
				"          and rsp.id_tipo_frequenza = gr.id_tipo_frequenza",
				"      )",
				"    ) as cod_stato_scu_eco,",
				"    (",
				"      select os.cod_ordine_scuola from iscritto_t_step_gra_con sgc",
				"        join iscritto_t_step_gra sg on sgc.id_step_gra = sg.id_step_gra",
				"        join iscritto_t_anagrafica_gra ag on ag.id_anagrafica_gra = sg.id_anagrafica_gra",
				"        join iscritto_d_ordine_scuola os on os.id_ordine_scuola = ag.id_ordine_scuola",
				"      where sgc.id_step_gra_con = gr.id_step_gra_con",
				"    ) as cod_ordine_scuola,",
				"    (",
				"      select sc.descrizione from iscritto_t_scuola sc",
				"      where sc.id_scuola = gr.id_scuola",
				"    ) as descrizione_scuola",
				"  from iscritto_t_graduatoria gr",
				") as v1",
				"where 1 = 1",
				"    and v1.cod_ordine_scuola = :codOrdineScuola",
				"    and v1.cod_anagrafica_gra = :codAnagraficaGra",
				"    and v1.step = :step",
				"    and v1.id_step_gra_con = (",
				"      select",
				"        sgc.id_step_gra_con",
				"      from iscritto_t_step_gra_con sgc",
				"        join iscritto_t_step_gra sg on sg.id_step_gra = sgc.id_step_gra",
				"        join iscritto_t_anagrafica_gra agr on sg.id_anagrafica_gra = agr.id_anagrafica_gra",
				"        join iscritto_d_ordine_scuola os on os.id_ordine_scuola = agr.id_ordine_scuola",
				"      where 1 = 1",
				"        and os.cod_ordine_scuola = :codOrdineScuola",
				"        and sg.step = :step",
				"        and agr.cod_anagrafica_gra = v1.cod_anagrafica_gra",
				"      order by",
				"        sgc.dt_step_con desc",
				"      limit 1",
				"    )");

		sh.bind("codOrdineScuola", tipoScuola.getCod());
		sh.bind("codAnagraficaGra", filter.getCodGraduatoria());
		sh.bind("step", filter.getStepGraduatoria());

		if (StringUtils.isNotBlank(filter.getCodScuola())) {
			sh.addQueryRows(
					"  and v1.cod_scuola = :codScuola");
			sh.bind("codScuola", filter.getCodScuola());
		}

		if (StringUtils.isNotBlank(filter.getCodTipologiaFrequenza())) {
			sh.addQueryRows(
					"  and v1.cod_tipo_frequenza = :codTipoFrequenza");
			sh.bind("codTipoFrequenza", filter.getCodTipologiaFrequenza());
		}

		if (StringUtils.isNotBlank(filter.getCodFasciaEta())) {
			sh.addQueryRows(
					"  and v1.cod_fascia_eta = :codFasciaEta");
			sh.bind("codFasciaEta", filter.getCodFasciaEta());
		}

		sh.addQueryRows(
				"order by v1.ordinamento asc, v1.step desc");

		List<TestataGraduatoriaRow> result = this.query(sh, TestataGraduatoriaRow.class);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public List<IscrittoTDomandaIsc> findDomandeNonIstruite(TipoScuola tipoScuola) throws DaoException {
		final String methodName = "findDomandeNonIstruite";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		final Date now = new Date();

		SqlHolder sh = buildSqlHolder()
				.addQueryRows(
						"with",
						"ultima_graduatoria as (",
						"  select ",
						"    gr.id_anagrafica_gra, ",
						"    gr.cod_anagrafica_gra, ",
						"    gr.dt_inizio_iscr, ",
						"    gr.dt_scadenza_iscr, ",
						"    gr.dt_fine_iscr, ",
						"    gr.dt_scadenza_grad, ",
						"    gr.dt_scadenza_ricorsi, ",
						"    gr.id_anno_scolastico, ",
						"    gr.id_ordine_scuola ",
						"  from iscritto_t_anagrafica_gra gr",
						"  where 1 = 1",
						"    and to_date(:data, 'YYYY-MM-DD') >= to_date(to_char(gr.dt_inizio_grad, 'YYYY-MM-DD'), 'YYYY-MM-DD')",
						"    and to_date(:data, 'YYYY-MM-DD') <= to_date(to_char(gr.dt_scadenza_grad,  'YYYY-MM-DD'), 'YYYY-MM-DD')",
						"    and gr.id_ordine_scuola = (select id_ordine_scuola from iscritto_d_ordine_scuola where cod_ordine_scuola = :codOrdineScuola)",
						"),",
						"step_in_corso as (",
						"  select",
						"    sg.step,",
						"    sg.dt_step_gra,",
						"    sg.id_step_gra,",
						"    sg.id_anagrafica_gra,",
						"    sg.dt_dom_inv_da,",
						"    sg.dt_dom_inv_a,",
						"    sg.dt_allegati",
						"  from iscritto_t_step_gra sg",
						"  where 1 = 1",
						"    and sg.id_anagrafica_gra in (select id_anagrafica_gra from ultima_graduatoria)",
						"    and to_date(:data, 'YYYY-MM-DD') >= to_date(to_char(sg.dt_step_gra, 'YYYY-MM-DD'), 'YYYY-MM-DD')",
						"  order by sg.dt_step_gra desc",
						"  limit 1",
						")",
						"select distinct",
						"  dom.id_domanda_iscrizione",
						"from iscritto_t_domanda_isc dom",
						"where 1 = 1",
						"  and dom.id_ordine_scuola = (select id_ordine_scuola from iscritto_d_ordine_scuola where cod_ordine_scuola = :codOrdineScuola)",
						"  and dom.id_stato_dom = (select id_stato_dom from iscritto_d_stato_dom where cod_stato_dom = 'INV')",
						"  and (dom.fl_istruita is null or dom.fl_istruita <> 'S')",
						"  and dom.id_anno_scolastico in (select id_anno_scolastico from ultima_graduatoria)",
						"  and dom.data_consegna between (select dt_dom_inv_da from step_in_corso) and (select dt_dom_inv_a from step_in_corso)",
						"order by dom.id_domanda_iscrizione")
				.bind("codOrdineScuola", tipoScuola.getCod())
				.bind("data", DateUtils.toStringDate(now, DateUtils.ISO_8601_FORMAT));

		List<IscrittoTDomandaIsc> result = this.query(sh, IscrittoTDomandaIsc.class);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public List<InfoVerificheRow> findInfoVerifiche(List<Long> idDomande, TipoVerificheIstruttoria tipoVerificheIstruttoria) throws DaoException {
		final String methodName = "findInfoVerifiche";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		log.debug(buildMessage(getClass(), methodName, "idDomande: " + idDomande));
		log.debug(buildMessage(getClass(), methodName, "tipoVerificheIstruttoria: " + tipoVerificheIstruttoria));
		Validate.notNull(tipoVerificheIstruttoria);

		SqlHolder sh = buildSqlHolder()
				.addQueryRows(
						"select",
						"  dcp.cod_condizione,",
						"  dcp.descrizione,",
						"  dcp.fl_istruttoria,",
						"  count(dcp.cod_condizione) as occorrenze",
						"from iscritto_r_punteggio_dom rpd",
						"  join iscritto_d_condizione_pun dcp on dcp.id_condizione_punteggio = rpd.id_condizione_punteggio",
						"where 1 = 1",
						"  and rpd.dt_fine_validita is null",
						"  and rpd.fl_valida is null",
						"  and dcp.fl_istruttoria = :flIstruttoria",
						"  and rpd.id_domanda_iscrizione in(:idDomande)",
						"group by",
						"  dcp.cod_condizione,",
						"  dcp.descrizione,",
						"  dcp.fl_istruttoria",
						"order by",
						"  dcp.cod_condizione,",
						"  dcp.descrizione,",
						"  dcp.fl_istruttoria")
				.bind("idDomande", idDomande)
				.bind("flIstruttoria", tipoVerificheIstruttoria.getCod());

		List<InfoVerificheRow> result = new ArrayList<>();
		if (CollectionUtils.isNotEmpty(idDomande)) {
			result.addAll(this.query(sh, InfoVerificheRow.class));
		}

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public List<IscrittoTAnnoSco> findAnniScolastici() throws DaoException {
		final String methodName = "findAnniScolastici";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		SqlHolder sh = buildSqlHolder()
				.addQueryRows(
						"select ",
						"  id_anno_scolastico, ",
						"  cod_anno_scolastico, ",
						"  descrizione, ",
						"  data_da, ",
						"  data_a ",
						"from iscritto_t_anno_sco ",
						"order by cod_anno_scolastico");

		List<IscrittoTAnnoSco> result = this.query(sh, IscrittoTAnnoSco.class);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public List<ClasseRow> findClassi(TipoScuola tipoScuola, String codScuola, String codAnnoScolastico) throws DaoException {
		final String methodName = "findClassi";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		log.debug(buildMessage(getClass(), methodName, "tipoScuola: " + tipoScuola));
		log.debug(buildMessage(getClass(), methodName, "codScuola: " + codScuola));
		log.debug(buildMessage(getClass(), methodName, "codAnnoScolastico: " + codAnnoScolastico));
		Validate.notNull(tipoScuola);

		SqlHolder sh = buildSqlHolder()
				.addQueryRows(
						"with posti_accettati as (",
						"  select",
						"    gr.id_scuola,",
						"    gr.id_fascia_eta,",
						"    gr.id_tipo_frequenza,",
						"    count(gr.id_domanda_iscrizione) num_acc",
						"  from iscritto_t_graduatoria gr",
						"    join iscritto_t_scuola scu on gr.id_scuola = scu.id_scuola",
						"    join iscritto_t_domanda_isc dom on gr.id_domanda_iscrizione = dom.id_domanda_iscrizione",
						"    join iscritto_t_step_gra_con sgc on gr.id_step_gra_con = sgc.id_step_gra_con",
						"    join iscritto_t_step_gra sg on sg.id_step_gra = sgc.id_step_gra",
						"    join iscritto_t_anno_sco anno on anno.id_anno_scolastico = dom.id_anno_scolastico",
						"    join iscritto_d_ordine_scuola ord on ord.id_ordine_scuola = scu.id_ordine_scuola",
						"    join iscritto_d_stato_scu stato on stato.id_stato_scu = gr.id_stato_scu",
						"  where 1 = 1",
						"    and stato.cod_stato_scu = 'ACC'",
						"    and sgc.id_step_gra_con = (",
						"      select i.id_step_gra_con from iscritto_t_step_gra_con i where i.id_step_gra = sg.id_step_gra",
						"      order by i.dt_step_con desc",
						"      limit 1",
						"    )",
						"    and ord.cod_ordine_scuola = :codOrdineScuola",
						"    and anno.cod_anno_scolastico = :codAnnoScolastico",
						"  group by",
						"    gr.id_scuola,",
						"    gr.id_fascia_eta,",
						"    gr.id_tipo_frequenza",
						"  order by",
						"    gr.id_scuola,",
						"    gr.id_fascia_eta,",
						"    gr.id_tipo_frequenza",
						")",
						"select",
						"  cl.id_classe, ",
						"  cl.posti_liberi, ",
						"  cl.posti_ammessi,",
						"  (",
						"    select pa.num_acc",
						"    from posti_accettati pa",
						"    where 1 = 1",
						"      and pa.id_scuola = cl.id_scuola",
						"      and pa.id_fascia_eta = fascia.id_fascia_eta",
						"      and pa.id_tipo_frequenza = cl.id_tipo_frequenza",
						"  ) as posti_accettati,",
						"  cl.denominazione, ",
						"  cl.fl_ammissione_dis,",
						"  fascia.cod_fascia_eta,",
						"  scu.cod_scuola,",
						"  ord.cod_ordine_scuola,",
						"  anno.cod_anno_scolastico,",
						"  fre.cod_tipo_frequenza",
						"from iscritto_t_classe cl",
						"  join iscritto_t_scuola scu on cl.id_scuola = scu.id_scuola",
						"  join iscritto_t_anno_sco anno on anno.id_anno_scolastico = cl.id_anno_scolastico",
						"  join iscritto_t_eta eta on eta.id_eta = cl.id_eta",
						"  join iscritto_d_tipo_fre fre on fre.id_tipo_frequenza = cl.id_tipo_frequenza",
						"  join iscritto_d_ordine_scuola ord on ord.id_ordine_scuola = scu.id_ordine_scuola",
						"  join iscritto_d_fascia_eta fascia on fascia.id_fascia_eta = eta.id_fascia_eta",
						"where 1 = 1",
						"  and scu.cod_scuola = :codScuola",
						"  and ord.cod_ordine_scuola = :codOrdineScuola",
						"  and anno.cod_anno_scolastico = :codAnnoScolastico",
						"order by",
						"  case",
						"    when fascia.cod_fascia_eta = 'L' then 1",
						"    when fascia.cod_fascia_eta = 'P' then 2",
						"    when fascia.cod_fascia_eta = 'G' then 3",
						"    else 0",
						"  end,",
						"  case",
						"    when fre.cod_tipo_frequenza = 'BRV' then 1",
						"    when fre.cod_tipo_frequenza = 'INT' then 2",
						"    when fre.cod_tipo_frequenza = 'LNG' then 3",
						"    else 0",
						"  end,",
						"  cl.posti_liberi")
				.bind("codScuola", codScuola)
				.bind("codOrdineScuola", tipoScuola.getCod())
				.bind("codAnnoScolastico", codAnnoScolastico);

		List<ClasseRow> result = this.query(sh, ClasseRow.class);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public List<NidoRow> findElencoNidi(Long idDomanda) throws DaoException {
		final String methodName = "findElencoNidi";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		log.debug(buildMessage(getClass(), methodName, "idDomanda: " + idDomanda));

		SqlHolder sh = buildSqlHolder()
				.addQueryRows(
						"select",
						"  d_cs.codice_categoria_scu,",
						"  d_cir.cod_circoscrizione,",
						"  scu.cod_scuola,",
						"  d_ss.cod_stato_scu,",
						"  d_tf.cod_tipo_frequenza,",
						"  scu.descrizione,",
						"  gr.ordine_preferenza,",
						"  scu.indirizzo,",
						"  gr.punteggio,",
						"  gr.fl_fuori_termine",
						"from iscritto_t_graduatoria gr",
						"  join iscritto_t_scuola scu on scu.id_scuola = gr.id_scuola",
						"  join iscritto_d_categoria_scu d_cs on d_cs.id_categoria_scu = scu.id_categoria_scu",
						"  join iscritto_d_circoscrizione d_cir on d_cir.id_circoscrizione = scu.id_circoscrizione",
						"  join iscritto_d_tipo_fre d_tf on d_tf.id_tipo_frequenza = gr.id_tipo_frequenza",
						"  join iscritto_d_stato_scu d_ss on d_ss.id_stato_scu = gr.id_stato_scu",
						"where 1 = 1",
						"  and gr.id_domanda_iscrizione = :idDomandaIscrizione",
						"  and gr.id_step_gra_con = (",
						"    select max(id_step_gra_con) from iscritto_t_graduatoria where id_domanda_iscrizione = :idDomandaIscrizione ",
						"  )",
						"order by",
						"  gr.ordine_preferenza")
				.bind("idDomandaIscrizione", idDomanda);

		List<NidoRow> result = this.query(sh, NidoRow.class);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public boolean canDeleteClasse(Long idClasse) throws DaoException {
		final String methodName = "canDeleteClasse";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		log.debug(buildMessage(getClass(), methodName, "idClasse: " + idClasse));
		Validate.notNull(idClasse);

		SqlHolder sh = buildSqlHolder()
				.addQueryRows(
						"select distinct",
						"  classe.id_classe",
						"from iscritto_t_classe classe",
						"  join iscritto_t_eta eta on eta.id_eta = classe.id_eta",
						"  join iscritto_r_scuola_pre scuola_pre on scuola_pre.id_scuola = classe.id_scuola",
						"    and scuola_pre.id_tipo_frequenza = classe.id_tipo_frequenza",
						"  join iscritto_t_anagrafica_sog anagrafica_sog on anagrafica_sog.id_domanda_iscrizione = scuola_pre.id_domanda_iscrizione",
						"  join iscritto_t_domanda_isc domanda_isc on domanda_isc.id_domanda_iscrizione = scuola_pre.id_domanda_iscrizione",
						"  join iscritto_d_stato_dom stato_dom on stato_dom.id_stato_dom = domanda_isc.id_stato_dom",
						"  join iscritto_r_soggetto_rel soggetto_rel on soggetto_rel.id_anagrafica_soggetto = anagrafica_sog.id_anagrafica_soggetto",
						"  join iscritto_d_tipo_sog tipo_sog on tipo_sog.id_tipo_soggetto = soggetto_rel.id_tipo_soggetto",
						"where 1 = 1",
						"  and tipo_sog.cod_tipo_soggetto = 'MIN'",
						"  and stato_dom.cod_stato_dom not in ('BOZ', 'ANN', 'CAN')",
						"  and anagrafica_sog.data_nascita between eta.data_da and eta.data_a",
						"  and domanda_isc.id_anno_scolastico = classe.id_anno_scolastico",
						"  and classe.id_classe = :idClasse")
				.bind("idClasse", idClasse);

		List<IscrittoTClasse> rows = this.query(sh, IscrittoTClasse.class);
		boolean result = CollectionUtils.size(rows) == 0;

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public Long insertClasse(TipoScuola tipoScuola, ClasseParam classe) throws DaoException {
		final String methodName = "insertClasse";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		log.debug(buildMessage(getClass(), methodName, "tipoScuola: " + tipoScuola));
		Validate.notNull(tipoScuola);
		Validate.notNull(classe);

		log.debug(buildMessage(getClass(), methodName, "codAnnoScolastico: " + classe.getCodAnnoScolastico()));
		log.debug(buildMessage(getClass(), methodName, "codFasciaEta: " + classe.getCodFasciaEta()));
		log.debug(buildMessage(getClass(), methodName, "codScuola: " + classe.getCodScuola()));
		log.debug(buildMessage(getClass(), methodName, "codTipoFrequenza: " + classe.getCodTipoFrequenza()));
		log.debug(buildMessage(getClass(), methodName, "denominazione: " + classe.getDenominazione()));
		log.debug(buildMessage(getClass(), methodName, "postiAmmessi: " + classe.getPostiAmmessi()));
		log.debug(buildMessage(getClass(), methodName, "postiLiberi: " + classe.getPostiLiberi()));
		log.debug(buildMessage(getClass(), methodName, "ammissioneDis: " + classe.getAmmissioneDis()));

		Long idClasse = this.nextval(ID_CLASSE_SEQ);
		log.info(buildMessage(getClass(), methodName, "idClasse: " + idClasse));

		this.update(buildSqlHolder()
				.addQueryRows(
						"insert into iscritto_t_classe (",
						"  id_classe,",
						"  id_scuola,",
						"  posti_liberi,",
						"  posti_ammessi,",
						"  denominazione,",
						"  id_anno_scolastico,",
						"  id_tipo_frequenza,",
						"  id_eta,",
						"  fl_ammissione_dis",
						")",
						"values (",
						"  :idClasse,",
						"  (",
						"    select distinct scu.id_scuola",
						"    from iscritto_t_scuola scu join iscritto_d_ordine_scuola ord on scu.id_ordine_scuola = ord.id_ordine_scuola",
						"    where scu.cod_scuola = :codScuola and ord.cod_ordine_scuola = :codOrdineScuola",
						"  ),",
						"  :postiLiberi,",
						"  :postiAmmessi,",
						"  :denominazione,",
						"  (",
						"    select anno.id_anno_scolastico",
						"    from iscritto_t_anno_sco anno",
						"    where anno.cod_anno_scolastico = :codAnnoScolastico",
						"  ),",
						"  (",
						"    select tf.id_tipo_frequenza",
						"    from iscritto_d_tipo_fre tf",
						"    where tf.cod_tipo_frequenza = :codTipoFrequenza",
						"  ),",
						"  (",
						"    select distinct eta.id_eta",
						"    from iscritto_t_eta eta",
						"      join iscritto_t_anagrafica_gra agr on agr.id_anagrafica_gra = eta.id_anagrafica_gra",
						"      join iscritto_d_fascia_eta fascia on fascia.id_fascia_eta = eta.id_fascia_eta",
						"      join iscritto_t_anno_sco anno on anno.id_anno_scolastico = agr.id_anno_scolastico",
						"      join iscritto_d_ordine_scuola ord on ord.id_ordine_scuola = agr.id_ordine_scuola",
						"    where 1 = 1",
						"      and fascia.cod_fascia_eta = :codFasciaEta",
						"      and anno.cod_anno_scolastico = :codAnnoScolastico",
						"      and ord.cod_ordine_scuola = :codOrdineScuola",
						"  ),",
						"  :flAmmissioneDis",
						")")
				.bind("idClasse", idClasse)
				.bind("codScuola", classe.getCodScuola())
				.bind("codOrdineScuola", tipoScuola.getCod())
				.bind("postiLiberi", classe.getPostiLiberi())
				.bind("postiAmmessi", classe.getPostiAmmessi())
				.bind("denominazione", classe.getDenominazione())
				.bind("codAnnoScolastico", classe.getCodAnnoScolastico())
				.bind("codTipoFrequenza", classe.getCodTipoFrequenza())
				.bind("codFasciaEta", classe.getCodFasciaEta())
				.bind("flAmmissioneDis", ConvertUtils.toSN(classe.getAmmissioneDis())));

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return idClasse;
	}

	@Override
	public Integer updateClasse(TipoScuola tipoScuola, ClasseParam classe) throws DaoException {
		final String methodName = "updateClasse";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		log.debug(buildMessage(getClass(), methodName, "tipoScuola: " + tipoScuola));
		Validate.notNull(tipoScuola);
		Validate.notNull(classe);

		log.debug(buildMessage(getClass(), methodName, "idClasse: " + classe.getIdClasse()));
		Validate.notNull(classe.getIdClasse());

		log.debug(buildMessage(getClass(), methodName, "codAnnoScolastico: " + classe.getCodAnnoScolastico()));
		log.debug(buildMessage(getClass(), methodName, "codFasciaEta: " + classe.getCodFasciaEta()));
		log.debug(buildMessage(getClass(), methodName, "codScuola: " + classe.getCodScuola()));
		log.debug(buildMessage(getClass(), methodName, "codTipoFrequenza: " + classe.getCodTipoFrequenza()));
		log.debug(buildMessage(getClass(), methodName, "denominazione: " + classe.getDenominazione()));
		log.debug(buildMessage(getClass(), methodName, "postiAmmessi: " + classe.getPostiAmmessi()));
		log.debug(buildMessage(getClass(), methodName, "postiLiberi: " + classe.getPostiLiberi()));
		log.debug(buildMessage(getClass(), methodName, "ammissioneDis: " + classe.getAmmissioneDis()));

		Integer result = this.update(buildSqlHolder()
				.addQueryRows(
						"update iscritto_t_classe set",
						"  id_scuola = (",
						"    select distinct scu.id_scuola",
						"    from iscritto_t_scuola scu join iscritto_d_ordine_scuola ord on scu.id_ordine_scuola = ord.id_ordine_scuola",
						"    where scu.cod_scuola = :codScuola and ord.cod_ordine_scuola = :codOrdineScuola",
						"  ),",
						"  posti_liberi = :postiLiberi,",
						"  posti_ammessi= :postiAmmessi,",
						"  denominazione = :denominazione,",
						"  id_anno_scolastico = (",
						"    select anno.id_anno_scolastico",
						"    from iscritto_t_anno_sco anno",
						"    where anno.cod_anno_scolastico = :codAnnoScolastico",
						"  ),",
						"  id_tipo_frequenza = (",
						"    select tf.id_tipo_frequenza",
						"    from iscritto_d_tipo_fre tf",
						"    where tf.cod_tipo_frequenza = :codTipoFrequenza",
						"  ),",
						"  id_eta = (",
						"    select distinct eta.id_eta",
						"    from iscritto_t_eta eta",
						"      join iscritto_t_anagrafica_gra agr on agr.id_anagrafica_gra = eta.id_anagrafica_gra",
						"      join iscritto_d_fascia_eta fascia on fascia.id_fascia_eta = eta.id_fascia_eta",
						"      join iscritto_t_anno_sco anno on anno.id_anno_scolastico = agr.id_anno_scolastico",
						"      join iscritto_d_ordine_scuola ord on ord.id_ordine_scuola = agr.id_ordine_scuola",
						"    where 1 = 1",
						"      and fascia.cod_fascia_eta = :codFasciaEta",
						"      and anno.cod_anno_scolastico = :codAnnoScolastico",
						"      and ord.cod_ordine_scuola = :codOrdineScuola",
						"  ),",
						"  fl_ammissione_dis = :flAmmissioneDis",
						"where id_classe = :idClasse")
				.bind("idClasse", classe.getIdClasse())
				.bind("codScuola", classe.getCodScuola())
				.bind("codOrdineScuola", tipoScuola.getCod())
				.bind("postiLiberi", classe.getPostiLiberi())
				.bind("postiAmmessi", classe.getPostiAmmessi())
				.bind("denominazione", classe.getDenominazione())
				.bind("codAnnoScolastico", classe.getCodAnnoScolastico())
				.bind("codTipoFrequenza", classe.getCodTipoFrequenza())
				.bind("codFasciaEta", classe.getCodFasciaEta())
				.bind("flAmmissioneDis", ConvertUtils.toSN(classe.getAmmissioneDis())));

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public Integer deleteClasse(Long idClasse) throws DaoException {
		final String methodName = "deleteClasse";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		log.debug(buildMessage(getClass(), methodName, "idClasse: " + idClasse));
		Validate.notNull(idClasse);

		Integer result = this.update(buildSqlHolder()
				.addQueryRows(
						"delete from iscritto_t_classe where id_classe = :idClasse")
				.bind("idClasse", idClasse));

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public Integer updateFlagAmmissioni(List<Long> idClasseList, Boolean value) throws DaoException {
		final String methodName = "updateFlagAmmissioni";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		log.debug(buildMessage(getClass(), methodName, "value: " + value));
		Validate.isTrue(CollectionUtils.isNotEmpty(idClasseList));

		Integer result = this.update(buildSqlHolder()
				.addQueryRows(
						"update iscritto_t_classe set",
						"  fl_ammissione_dis = :flAmmissioneDis",
						"where id_classe in(:idClasseList)")
				.bind("idClasseList", idClasseList)
				.bind("flAmmissioneDis", ConvertUtils.toSN(value)));

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public void calcolaGraduatoria(
			TipoScuola tipoScuola, String codGraduatoria, StatoGraduatoria statoAttuale, StatoGraduatoria statoDaCalcolare, Integer step)
			throws DaoException, ValidationException {

		final String methodName = "calcolaGraduatoria";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		String dataProcesso = sdf.format(new Date());
		try
		{

		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		log.debug(buildMessage(getClass(), methodName, "tipoScuola: " + tipoScuola));
		log.debug(buildMessage(getClass(), methodName, "codGraduatoria: " + codGraduatoria));
		log.debug(buildMessage(getClass(), methodName, "statoAttuale: " + statoAttuale));
		log.debug(buildMessage(getClass(), methodName, "statoDaCalcolare: " + statoDaCalcolare));
		log.debug(buildMessage(getClass(), methodName, "step: " + step));

		log.info(buildMessage(getClass(), methodName, "@@@ INIZIO CALCOLO GRADUATORIA: "+dataProcesso));
		this.lock();
		log.info(buildMessage(getClass(), methodName, "lock acquisito"));

		if (StatoGraduatoria.CAL == statoAttuale && StatoGraduatoria.PRO == statoDaCalcolare) {
			log.info(buildMessage(getClass(), methodName, "@@@ 1 CAL - PRO START"));
			Long idStepGraConNext = this.nextval(ID_STEP_GRA_CON_SEQ);
			log.info(buildMessage(getClass(), methodName, "idStepGraConNext: " + idStepGraConNext));

			Long idStepGra = this.getIdStepGra(tipoScuola, codGraduatoria);
			log.info(buildMessage(getClass(), methodName, "idStepGra: " + idStepGra));

			log.info(buildMessage(getClass(), methodName, "@@@ 1 inizio insert into: "+dataProcesso));
			this.update(buildSqlHolder()
					.addQueryRows(
							"insert into iscritto_t_step_gra_con (",
							"  id_step_gra_con,",
							"  id_step_gra,",
							"  id_stato_gra,",
							"  fl_ammissioni,",
							"  fl_calcolo_in_corso,",
							"  dt_step_con",
							")",
							"VALUES (",
							"  :idStepGraCon,",
							"  :idStepGra,",
							"  (select id_stato_gra from iscritto_d_stato_gra where cod_stato_gra = 'PRO'),",
							"  'N',",
							"  'S',",
							"  now()",
							")")
					.bind("idStepGraCon", idStepGraConNext)
					.bind("idStepGra", idStepGra));

			log.info(buildMessage(getClass(), methodName, "@@@ 1 fine insert into, inizio function calcolaGraduatoria: "+dataProcesso));
			this.callFunction(buildSqlHolder(
					"select calcolagraduatoria(:idStepGraConNext::int4, null::int4, 'P'::varchar) as int_result")
							.bind("idStepGraConNext", idStepGraConNext));

			log.info(buildMessage(getClass(), methodName, "@@@ 1 fine calcolaGraduatoria, inizio aggiornaData: "+dataProcesso));
			this.aggiornaData(idStepGraConNext);
			log.info(buildMessage(getClass(), methodName, "@@@ 1 fine aggiornaData, inizio setCalcoloIncorso: "+dataProcesso));
			this.setCalcoloInCorso(idStepGraConNext, false);
			log.info(buildMessage(getClass(), methodName, "@@@ 1 CAL - PRO FINE: "+dataProcesso));
		}
		else if (StatoGraduatoria.PRO == statoAttuale && StatoGraduatoria.PRO == statoDaCalcolare) {
			log.info(buildMessage(getClass(), methodName, "@@@ 2 PRO - PRO INIZIO: "+dataProcesso));
			Long idStepGra = this.getIdStepGra(tipoScuola, codGraduatoria);
			log.info(buildMessage(getClass(), methodName, "idStepGra: " + idStepGra));

			Long idStepGraCon = this.getIdStepGraCon(idStepGra);
			log.info(buildMessage(getClass(), methodName, "idStepGraCon: " + idStepGraCon));

			this.setCalcoloInCorso(idStepGraCon, true);

			this.callFunction(buildSqlHolder(
					"select calcolagraduatoria(:idStepGraCon::int4, :idStepGraCon::int4, 'P'::varchar) as int_result")
							.bind("idStepGraCon", idStepGraCon));

			this.aggiornaData(idStepGraCon);
			this.setCalcoloInCorso(idStepGraCon, false);
			log.info(buildMessage(getClass(), methodName, "@@@ 2 PRO - PRO FINE"));
		}
		else if (StatoGraduatoria.PRO == statoAttuale && StatoGraduatoria.PRO_CON == statoDaCalcolare) {
			log.info(buildMessage(getClass(), methodName, "@@@ 3 PRO - PRO_CON INIZIO"));
			Long idStepGra = this.getIdStepGra(tipoScuola, codGraduatoria);
			log.info(buildMessage(getClass(), methodName, "idStepGra: " + idStepGra));

			Long idStepGraCon = this.getIdStepGraCon(idStepGra);
			log.info(buildMessage(getClass(), methodName, "idStepGraCon: " + idStepGraCon));

			this.setCalcoloInCorso(idStepGraCon, true);

			this.update(buildSqlHolder()
					.addQueryRows(
							"update iscritto_t_step_gra_con set",
							"  id_stato_gra = (select id_stato_gra from iscritto_d_stato_gra where cod_stato_gra = 'PRO_CON')",
							"where id_step_gra_con = :idStepGraCon")
					.bind("idStepGraCon", idStepGraCon));

			this.aggiornaData(idStepGraCon);
			this.setCalcoloInCorso(idStepGraCon, false);
			log.info(buildMessage(getClass(), methodName, "@@@ 3 PRO - PRO_CON FINE"));
		}
		else if (StatoGraduatoria.PRO_CON == statoAttuale && StatoGraduatoria.DEF == statoDaCalcolare) {
			log.info(buildMessage(getClass(), methodName, "@@@ 4 PRO_CON - DEF INIZIO"));
			Long idStepGraConNext = this.nextval(ID_STEP_GRA_CON_SEQ);
			log.info(buildMessage(getClass(), methodName, "idStepGraConNext: " + idStepGraConNext));

			Long idStepGra = this.getIdStepGra(tipoScuola, codGraduatoria);
			log.info(buildMessage(getClass(), methodName, "idStepGra: " + idStepGra));

			Long idStepGraConPrev = this.getIdStepGraCon(idStepGra);
			log.info(buildMessage(getClass(), methodName, "idStepGraConPrev: " + idStepGraConPrev));

			this.update(buildSqlHolder()
					.addQueryRows(
							"insert into iscritto_t_step_gra_con (",
							"  id_step_gra_con,",
							"  id_step_gra,",
							"  id_stato_gra,",
							"  fl_ammissioni,",
							"  fl_calcolo_in_corso,",
							"  dt_step_con",
							")",
							"VALUES (",
							"  :idStepGraCon,",
							"  :idStepGra,",
							"  (select id_stato_gra from iscritto_d_stato_gra where cod_stato_gra = 'DEF'),",
							"  'S',",
							"  'S',",
							"  now()",
							")")
					.bind("idStepGraCon", idStepGraConNext)
					.bind("idStepGra", idStepGra));

			this.setCalcoloInCorso(idStepGraConNext, true);

			this.callFunction(buildSqlHolder(
					"select calcolagraduatoria(:idStepGraConNext::int4, :idStepGraConPrev::int4, 'D'::varchar) as int_result")
							.bind("idStepGraConNext", idStepGraConNext)
							.bind("idStepGraConPrev", idStepGraConPrev));

			this.callFunction(buildSqlHolder(
					"select attribuisciposti(:idStepGraConNext::int4) as int_result")
							.bind("idStepGraConNext", idStepGraConNext));

			this.aggiornaData(idStepGraConNext);
			this.setCalcoloInCorso(idStepGraConNext, false);
			log.info(buildMessage(getClass(), methodName, "@@@ 4 PRO_CON - DEF FINE"));
		}
		else if (StatoGraduatoria.DEF == statoAttuale && StatoGraduatoria.DEF == statoDaCalcolare) {
			log.info(buildMessage(getClass(), methodName, "@@@ 5 DEF - DEF INIZIO"));
			Long idStepGra = this.getIdStepGra(tipoScuola, codGraduatoria);
			log.info(buildMessage(getClass(), methodName, "idStepGra: " + idStepGra));

			Long idStepGraCon = this.getIdStepGraCon(idStepGra);
			log.info(buildMessage(getClass(), methodName, "idStepGraCon: " + idStepGraCon));

			this.checkFlagAmmissioni(this.findStepGraduatoriaCon(idStepGra));
			this.setCalcoloInCorso(idStepGraCon, true);

			this.callFunction(buildSqlHolder(
					"select attribuisciposti(:idStepGraCon::int4) as int_result")
							.bind("idStepGraCon", idStepGraCon));

			this.aggiornaData(idStepGraCon);
			this.setCalcoloInCorso(idStepGraCon, false);
			log.info(buildMessage(getClass(), methodName, "@@@ 5 DEF - DEF FINE"));
		}
		else if (StatoGraduatoria.PUB == statoAttuale && StatoGraduatoria.PUB == statoDaCalcolare) {
			log.info(buildMessage(getClass(), methodName, "@@@ 6 PUB - PUB INIZIO"));
			Long idStepGra = this.getIdStepGra(tipoScuola, codGraduatoria);
			log.info(buildMessage(getClass(), methodName, "idStepGra: " + idStepGra));

			Long idStepGraCon = this.getIdStepGraCon(idStepGra);
			log.info(buildMessage(getClass(), methodName, "idStepGraCon: " + idStepGraCon));

			this.checkFlagAmmissioni(this.findStepGraduatoriaCon(idStepGra));
			this.setCalcoloInCorso(idStepGraCon, true);

			this.callFunction(buildSqlHolder(
					"select attribuisciposti(:idStepGraCon::int4) as int_result")
							.bind("idStepGraCon", idStepGraCon));

			this.aggiornaData(idStepGraCon);
			this.setCalcoloInCorso(idStepGraCon, false);
			log.info(buildMessage(getClass(), methodName, "@@@ 6 PUB - PUB FINE"));
		}
		else if (StatoGraduatoria.PUB == statoAttuale && StatoGraduatoria.DEF == statoDaCalcolare) {
			log.info(buildMessage(getClass(), methodName, "@@@ 7 PUB - DEF INIZIO"));
			Long idStepGra = this.getIdStepGra(tipoScuola, codGraduatoria);
			log.info(buildMessage(getClass(), methodName, "idStepGra: " + idStepGra));

			this.checkEmptyResult(idStepGra);

			Long idStepGraConNext = this.nextval(ID_STEP_GRA_CON_SEQ);
			log.info(buildMessage(getClass(), methodName, "idStepGraConNext: " + idStepGraConNext));

			Long idStepGraPrev = this.getIdPrevStepGra(idStepGra);
			log.info(buildMessage(getClass(), methodName, "idStepGraPrev: " + idStepGraPrev));

			Long idStepGraConPrev = this.getIdStepGraCon(idStepGraPrev);
			log.info(buildMessage(getClass(), methodName, "idStepGraConPrev: " + idStepGraConPrev));

			this.update(buildSqlHolder()
					.addQueryRows(
							"insert into iscritto_t_step_gra_con (",
							"  id_step_gra_con,",
							"  id_step_gra,",
							"  id_stato_gra,",
							"  fl_ammissioni,",
							"  fl_calcolo_in_corso,",
							"  dt_step_con",
							")",
							"VALUES (",
							"  :idStepGraCon,",
							"  :idStepGra,",
							"  (select id_stato_gra from iscritto_d_stato_gra where cod_stato_gra = 'DEF'),",
							"  'S',",
							"  'S',",
							"  now()",
							")")
					.bind("idStepGraCon", idStepGraConNext)
					.bind("idStepGra", idStepGra));

			this.setCalcoloInCorso(idStepGraConNext, true);

			this.callFunction(buildSqlHolder(
					"select calcolagraduatoria(:idStepGraConNext::int4, :idStepGraConPrev::int4, 'S'::varchar) as int_result")
							.bind("idStepGraConNext", idStepGraConNext)
							.bind("idStepGraConPrev", idStepGraConPrev));

			this.callFunction(buildSqlHolder(
					"select attribuisciposti(:idStepGraConNext::int4) as int_result")
							.bind("idStepGraConNext", idStepGraConNext));

			this.aggiornaData(idStepGraConNext);
			this.setCalcoloInCorso(idStepGraConNext, false);
			log.info(buildMessage(getClass(), methodName, "@@@ 7 PUB - DEF INIZIO"));
		}
		else {
			log.info(buildMessage(getClass(), methodName, "@@@ 8 ERRORE"));
			log.error(buildMessage(getClass(), methodName, "statoAttuale: " + statoAttuale));
			log.error(buildMessage(getClass(), methodName, "statoDaCalcolare: " + statoDaCalcolare));
			throw new DaoException("condizione non valida");
		}
		}
		catch (Exception e)
		{
			log.info(buildMessage(getClass(), methodName, "ECCEZIONE: "+dataProcesso));

			log.error("ECCEZIONE: ",e);

			throw e;
		}
		log.debug(buildMessage(getClass(), methodName, LOG_END));
	}

	@Override
	public Integer annullaPreferenze(Long idDomandaIscrizione) throws DaoException {
		final String methodName = "annullaPreferenze";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		log.info(buildMessage(getClass(), methodName, "idDomandaIscrizione: " + idDomandaIscrizione));

		Integer result = this.update(buildSqlHolder()
				.addQueryRows(
						"update iscritto_t_graduatoria set",
						"  id_stato_scu = (select id_stato_scu from iscritto_d_stato_scu where cod_stato_scu = 'ANN')",
						"where",
						"  id_stato_scu = (select id_stato_scu from iscritto_d_stato_scu where cod_stato_scu = 'PEN') and",
						"  id_domanda_iscrizione = :idDomandaIscrizione and",
						"  id_step_gra_con = (",
						"    select",
						"      sgc.id_step_gra_con",
						"    from iscritto_t_step_gra_con sgc ",
						"      join iscritto_t_step_gra sg on sg.id_step_gra = sgc.id_step_gra",
						"      join iscritto_t_anagrafica_gra gra on gra.id_anagrafica_gra = sg.id_anagrafica_gra",
						"      join iscritto_t_domanda_isc dom on dom.id_anno_scolastico = gra.id_anno_scolastico and dom.id_ordine_scuola = gra.id_ordine_scuola",
						"    where 1 = 1",
						"      and dom.id_domanda_iscrizione = :idDomandaIscrizione",
						"    order by sgc.id_step_gra_con desc",
						"    limit 1",
						"  )")
				.bind("idDomandaIscrizione", idDomandaIscrizione));

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public List<PreferenzaScuolaRow> findPreferenzeScuole(Long idAnagraficaGra, Long idDomanda) throws DaoException {
		final String methodName = "findPreferenzeScuole";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		log.debug(buildMessage(getClass(), methodName, "idAnagraficaGra: " + idAnagraficaGra));
		Validate.notNull(idAnagraficaGra);

		SqlHolder sh = buildSqlHolder()
				.addQueryRows(
						"select",
						"  itg.id_graduatoria,",
						"  itg.id_domanda_iscrizione,",
						"  itg.ordine_preferenza,",
						"  its.cod_scuola,",
						"  its.descrizione as desc_scuola,",
						"  its.indirizzo,",
						"  idtf.id_tipo_frequenza,",
						"  idtf.cod_tipo_frequenza,",
						"  idtf.descrizione as desc_tipo_fre,",
						"  idss.id_stato_scu,",
						"  idss.cod_stato_scu,",
						"  idss.descrizione as desc_stato_scu,",
						"  irsp.dt_stato",
						"FROM iscritto_t_graduatoria itg",
						"  JOIN iscritto_t_scuola its on itg.id_scuola = its.id_scuola",
						"  JOIN iscritto_d_tipo_fre idtf on itg.id_tipo_frequenza = idtf.id_tipo_frequenza",
						"  JOIN iscritto_d_stato_scu idss on itg.id_stato_scu = idss.id_stato_scu",
						"  JOIN iscritto_r_scuola_pre irsp on irsp.id_domanda_iscrizione = itg.id_domanda_iscrizione",
						"where",
						"  itg.id_step_gra_con = (",
						"    select i.id_step_gra_con",
						"    from iscritto_t_step_gra itsg2",
						"        join iscritto_t_step_gra_con i on itsg2.id_step_gra = i.id_step_gra",
						"        where itsg2.id_anagrafica_gra = :idAnagraficaGra",
						"    ORDER BY dt_step_con desc",
						"    FETCH first 1 row only",
						"  ) ",
						"  AND itg.id_domanda_iscrizione = :idDomanda",
						"  and irsp.id_tipo_frequenza = itg.id_tipo_frequenza",
						"  and irsp.id_scuola = itg.id_scuola",
						"order by",
						"  itg.ordine_preferenza")
				.bind("idAnagraficaGra", idAnagraficaGra)
				.bind("idDomanda", idDomanda);

		List<PreferenzaScuolaRow> result = this.query(sh, PreferenzaScuolaRow.class);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public ResultDao updateStatoScuolaPreferenza(Long idGraduatoria, Long idStatoAttuale, Long idStatoRipristino) throws DaoException, ValidationException {
		final String methodName = "updateStatoScuolaPreferenza";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		log.info(buildMessage(getClass(), methodName, "idGraduatoria: " + idGraduatoria));
		log.info(buildMessage(getClass(), methodName, "idStatoAttuale: " + idStatoAttuale));
		log.info(buildMessage(getClass(), methodName, "idStatoRipristino: " + idStatoRipristino));

		ResultDao result = new ResultDao(-1);

		// *************************************
		// *******************AMM->PEN**********
		// *************************************
		if (idStatoAttuale == 3 && idStatoRipristino == 1) {
			log.info("AMM->PEN");
			// Incremento di 1 del valore del campo posti_liberi e decremento di 1 del valore del campo posti_ammessi

			result.setStatus(this.update(buildSqlHolder()
					.addQueryRows(
							"update iscritto_t_classe set",
							"  posti_liberi = posti_liberi + 1,",
							"  posti_ammessi = posti_ammessi - 1",
							"where",
							"  id_scuola = (",
							"     select id_scuola from iscritto_t_graduatoria where id_graduatoria = :idGraduatoria",
							"  ) and",
							"  id_tipo_frequenza = (",
							"     select id_tipo_frequenza from iscritto_t_graduatoria where id_graduatoria = :idGraduatoria",
							"  ) and",
							"  id_eta = (",
							"    select eta.id_eta from iscritto_t_eta eta",
							"    where eta.id_fascia_eta = (",
							"      select id_fascia_eta from iscritto_t_graduatoria where id_graduatoria = :idGraduatoria",
							"    )",
							"    and eta.id_anagrafica_gra = (",
							"      select sg.id_anagrafica_gra from iscritto_t_step_gra sg",
							"        join iscritto_t_step_gra_con sgc on sgc.id_step_gra = sg.id_step_gra",
							"      where sgc.id_step_gra_con = (",
							"        select id_step_gra_con from iscritto_t_graduatoria where id_graduatoria = :idGraduatoria",
							"      )",
							"    )",
							"  )")
					.bind("idGraduatoria", idGraduatoria)));

			log.info("Numero classi modificate: " + result);

			result.setStatus(this.update(buildSqlHolder()
					.addQueryRows(
							"update iscritto_t_graduatoria",
							"  set id_stato_scu = :idStatoRipristino",
							"where id_graduatoria = :idGraduatoria")
					.bind("idGraduatoria", idGraduatoria)
					.bind("idStatoRipristino", idStatoRipristino)));

			log.info("Modificato stato : " + result);

			//inizio fix segnalazione 11 31/07/2020
			// controllo scuola prima preferenza

			SqlHolder rs = buildSqlHolder()
					.addQueryRows(
							"SELECT *",
							"FROM iscritto_t_graduatoria g",
							"WHERE g.id_graduatoria = :idGraduatoria"
							)
					.bind("idGraduatoria", idGraduatoria);


			IscrittoTGraduatoria ordinePreferenza = ConvertUtils.getFirst(this.query(rs, IscrittoTGraduatoria.class));
			log.info("pippo = " + ordinePreferenza);


			Integer ordinePref = ordinePreferenza.getIdStatoScu().intValue();
			if(ordinePref==1) {
				//prima scelta
				//aggiorno tabella ISCRITTO_T_STEP_GRA

				result.setStatus(this.update(buildSqlHolder()
						.addQueryRows(
								 " update iscritto_t_graduatoria ",
								 " set id_stato_scu = (select id_stato_scu from iscritto_d_stato_scu where cod_stato_scu = 'PEN')",
								 " where ",
								 " id_step_gra_con = (",
								 "       select gra.id_step_gra_con",
								 "       from iscritto_t_graduatoria gra",
								 "       join iscritto_t_step_gra_con stepGraCon on gra.id_step_gra_con = stepGraCon.id_step_gra_con",
								 "       join iscritto_t_step_gra stepGra on stepGraCon.id_step_gra = stepGra.id_step_gra",
								 "       where id_graduatoria = :idGraduatoria",
								 "       order by dt_step_con desc",
								 "       FETCH first 1 row only",
								 " )and",
								 " id_domanda_iscrizione = (",
								 "       select id_domanda_iscrizione",
								 "       from iscritto_t_graduatoria",
								 "       where id_graduatoria = :idGraduatoria",
								 " )and",
								 " id_stato_scu = (",
								 "    select id_stato_scu",
								 "     from iscritto_d_stato_scu",
								 "     where cod_stato_scu = 'CAN_1SC')"
								)
						.bind("idGraduatoria", idGraduatoria)));
				log.info("Eseguito update di iscritto_t_graduatoria da CAN_1SC a PEN " + result);

				//aggiorno tabella ISCRITTO_R_SCUOLA_PRE

				result.setStatus(this.update(buildSqlHolder()
						.addQueryRows(
								 " update iscritto_r_scuola_pre ",
								 " set id_stato_scu = (select id_stato_scu from iscritto_d_stato_scu where cod_stato_scu = 'PEN'),",
								 "     dt_stato = CURRENT_TIMESTAMP",
								 " where ",
								 " id_domanda_iscrizione = (",
								 "       select id_domanda_iscrizione",
								 "       from iscritto_t_graduatoria",
								 "       where id_graduatoria = :idGraduatoria",
								 " )and",
								 " id_stato_scu = (",
								 "    select id_stato_scu",
								 "     from iscritto_d_stato_scu",
								 "     where cod_stato_scu = 'CAN_1SC')"
								)
						.bind("idGraduatoria", idGraduatoria)));
				log.info("Eseguito update iscritto_r_scuola_pre da CAN_1SC a PEN " + result);



				//update della tabella ISCRITTO_R_SCUOLA_PRE dello stato della scuola oggetto di ripristino stato
				result.setStatus(this.update(buildSqlHolder()
						.addQueryRows(
								"update iscritto_r_scuola_pre",
								"  set id_stato_scu = (select id_stato_scu from iscritto_d_stato_scu where cod_stato_scu = 'PEN'),",
								"      dt_stato = CURRENT_TIMESTAMP",
								"where",
								"  id_domanda_iscrizione = (",
								"     select id_domanda_iscrizione from iscritto_t_graduatoria where id_graduatoria = :idGraduatoria",
								"  ) and",
								"  id_scuola = (",
								"     select id_scuola from iscritto_t_graduatoria where id_graduatoria = :idGraduatoria",
								"  ) and",
								"  id_tipo_frequenza = (",
								"     select id_tipo_frequenza from iscritto_t_graduatoria where id_graduatoria = :idGraduatoria",
								"  )"
								)
						.bind("idGraduatoria", idGraduatoria)
						.bind("idStatoRipristino", idStatoRipristino)));

				log.info("Modificato tabella ISCRITTO_R_SCUOLA_PRE stato : " + result);


				//update stato della domanda



				result.setStatus(this.update(buildSqlHolder()
						.addQueryRows(
								"update iscritto_t_domanda_isc",
								"set id_stato_dom = (select id_stato_dom from iscritto_d_stato_dom where cod_stato_dom = 'GRA')",
								"where",
								"  id_domanda_iscrizione = (",
								"     select id_domanda_iscrizione from iscritto_t_graduatoria  where id_graduatoria = :idGraduatoria )"
								)
						.bind("idGraduatoria", idGraduatoria)));

				log.info("Modificato tabella ISCRITTO_T_DOMANDA_ISC stato : " + result);


			}


			//fine


		}
		// *************************************
		// *******************RIN->AMM**********
		// *************************************
		else if (idStatoAttuale == 2 && idStatoRipristino == 3) {
			SqlHolder sh = buildSqlHolder()
					.addQueryRows(
							"select",
							"  posti_liberi",
							"from iscritto_t_classe",
							"where",
							"  id_scuola = (",
							"     select id_scuola from iscritto_t_graduatoria where id_graduatoria = :idGraduatoria",
							"  ) and",
							"  id_tipo_frequenza = (",
							"     select id_tipo_frequenza from iscritto_t_graduatoria where id_graduatoria = :idGraduatoria",
							"  ) and",
							"  id_eta = (",
							"    select eta.id_eta from iscritto_t_eta eta",
							"    where eta.id_fascia_eta = (",
							"      select id_fascia_eta from iscritto_t_graduatoria where id_graduatoria = :idGraduatoria",
							"    )",
							"    and eta.id_anagrafica_gra = (",
							"      select sg.id_anagrafica_gra from iscritto_t_step_gra sg",
							"        join iscritto_t_step_gra_con sgc on sgc.id_step_gra = sg.id_step_gra",
							"      where sgc.id_step_gra_con = (",
							"        select id_step_gra_con from iscritto_t_graduatoria where id_graduatoria = :idGraduatoria",
							"      )",
							"    )",
							"  )")
					.bind("idGraduatoria", idGraduatoria);

			IscrittoTClasse classe = ConvertUtils.getFirst(this.query(sh, IscrittoTClasse.class));
			Integer postiLiberi = classe == null ? null : classe.getPostiLiberi();

			log.info("Numero posti liberi : " + postiLiberi);

			if (postiLiberi == null || postiLiberi.intValue() <= 0) {
				log.error(buildMessage(getClass(), methodName, "errore operazione non eseguibile perche' non ci sono posti liberi"));
				throw ErrorCodeEnum.VAL_GRA_011.buildException();
			}
			else {
				// incrementare di 1 il valore del campo posti_ammessi e diminuire di 1 il valore del campo posti_liberi
				Integer incr = this.update(buildSqlHolder()
						.addQueryRows(
								"update iscritto_t_classe set",
								"  posti_liberi = posti_liberi - 1,",
								"  posti_ammessi = posti_ammessi + 1",
								"where",
								"  id_scuola = (",
								"     select id_scuola from iscritto_t_graduatoria where id_graduatoria = :idGraduatoria",
								"  ) and",
								"  id_tipo_frequenza = (",
								"     select id_tipo_frequenza from iscritto_t_graduatoria where id_graduatoria = :idGraduatoria",
								"  ) and",
								"  id_eta = (",
								"    select eta.id_eta from iscritto_t_eta eta",
								"    where eta.id_fascia_eta = (",
								"      select id_fascia_eta from iscritto_t_graduatoria where id_graduatoria = :idGraduatoria",
								"    )",
								"    and eta.id_anagrafica_gra = (",
								"      select sg.id_anagrafica_gra from iscritto_t_step_gra sg",
								"        join iscritto_t_step_gra_con sgc on sgc.id_step_gra = sg.id_step_gra",
								"      where sgc.id_step_gra_con = (",
								"        select id_step_gra_con from iscritto_t_graduatoria where id_graduatoria = :idGraduatoria",
								"      )",
								"    )",
								"  )")
						.bind("idGraduatoria", idGraduatoria));

				log.info("Numero classi modificate: " + incr);

				// Impostare il valore del campo fl_auto a ‘S’ del record selezionato da R.
				incr = this.update(buildSqlHolder()
						.addQueryRows(
								"update iscritto_t_acc_rin set",
								"  fl_auto = :flAuto",
								"where",
								"  id_domanda_iscrizione = (",
								"    select acc.id_domanda_iscrizione ",
								"    from iscritto_t_acc_rin acc",
								"      join iscritto_t_graduatoria itg on acc.id_domanda_iscrizione = itg.id_domanda_iscrizione",
								"      join iscritto_t_scuola its on acc.id_scuola = its.id_scuola",
								"    where id_graduatoria = :idGraduatoria and fl_a_r = 'R'",
								"  )")
						.bind("flAuto", "S")
						.bind("idGraduatoria", idGraduatoria));

				log.info("Numero record modificati: " + incr);

				result.setStatus(this.update(buildSqlHolder()
						.addQueryRows(
								"update iscritto_t_graduatoria ",
								"set id_stato_scu = :idStatoRipristino ",
								"where id_graduatoria = :idGraduatoria")
						.bind("idStatoRipristino", idStatoRipristino)
						.bind("idGraduatoria", idGraduatoria)));

				log.info("Modificato stato : " + result);

				//aggiornamento segnalazione 11 da CAN_RIN a PEN e da CAN_R_1SC a CAN_1SC


				result.setStatus(this.update(buildSqlHolder()
						.addQueryRows(
								"with parametri as (",
								"  select",
								"    id_domanda_iscrizione,",
								"    id_step_gra_con",
								"  from iscritto_t_graduatoria",
								"  where id_graduatoria = :idGraduatoria",
								")",
								"update iscritto_t_graduatoria set",
								"  id_stato_scu = (select ds.id_stato_scu from iscritto_d_stato_scu ds where ds.cod_stato_scu = 'PEN')",
								"where 1 = 1",
								"  and id_domanda_iscrizione = (select id_domanda_iscrizione from parametri)",
								"  and id_step_gra_con = (select id_step_gra_con from parametri)",
								//"  and id_stato_scu in (select ds.id_stato_scu from iscritto_d_stato_scu ds where ds.cod_stato_scu in ('CAN_RIN', 'CAN_R_1SC'))")
								"  and id_stato_scu in (select ds.id_stato_scu from iscritto_d_stato_scu ds where ds.cod_stato_scu ='CAN_RIN')")
						.bind("idGraduatoria", idGraduatoria)));

				log.info("Modificato stato : " + result);

				result.setStatus(this.update(buildSqlHolder()
						.addQueryRows(
								"with parametri as (",
								"  select",
								"    id_domanda_iscrizione,",
								"    id_step_gra_con",
								"  from iscritto_t_graduatoria",
								"  where id_graduatoria = :idGraduatoria",
								")",
								"update iscritto_t_graduatoria set",
								"  id_stato_scu = (select ds.id_stato_scu from iscritto_d_stato_scu ds where ds.cod_stato_scu = 'CAN_1SC')",
								"where 1 = 1",
								"  and id_domanda_iscrizione = (select id_domanda_iscrizione from parametri)",
								"  and id_step_gra_con = (select id_step_gra_con from parametri)",
								"  and id_stato_scu in (select ds.id_stato_scu from iscritto_d_stato_scu ds where ds.cod_stato_scu ='CAN_R_1SC')")
						.bind("idGraduatoria", idGraduatoria)));

				log.info("Modificato stato : " + result);

				//aggiornamento segnalazione 11 aggiornamento della tabella ISCRITTO_R_SCUOLA_PRE

				result.setStatus(this.update(buildSqlHolder()
						.addQueryRows(
								 " update iscritto_r_scuola_pre ",
								 " set id_stato_scu = (select id_stato_scu from iscritto_d_stato_scu where cod_stato_scu = 'PEN'),",
								 "     dt_stato = CURRENT_TIMESTAMP",
								 " where ",
								 " id_domanda_iscrizione = (",
								 "       select id_domanda_iscrizione",
								 "       from iscritto_t_graduatoria",
								 "       where id_graduatoria = :idGraduatoria",
								 " )and",
								 " id_stato_scu in (",
								 "    select id_stato_scu",
								 "     from iscritto_d_stato_scu",
								 "     where cod_stato_scu in ('CAN_RIN', 'CAN_R_1SC'))"
								)
						.bind("idGraduatoria", idGraduatoria)));
				log.info("Eseguito update tabella iscritto_r_scuola_pre da CAN_1SC o CAN_RIN a PEN " + result);


				//update della tabella ISCRITTO_R_SCUOLA dello stato della scuola oggetto di ripristino stato
				result.setStatus(this.update(buildSqlHolder()
						.addQueryRows(
								"update iscritto_r_scuola_pre",
								"  set id_stato_scu = :idStatoRipristino,",
								"      dt_stato = CURRENT_TIMESTAMP",
								"where",
								"  id_domanda_iscrizione = (",
								"     select id_domanda_iscrizione from iscritto_t_graduatoria where id_graduatoria = :idGraduatoria",
								"  ) and",
								"  id_scuola = (",
								"     select id_scuola from iscritto_t_graduatoria where id_graduatoria = :idGraduatoria",
								"  ) and",
								"  id_tipo_frequenza = (",
								"     select id_tipo_frequenza from iscritto_t_graduatoria where id_graduatoria = :idGraduatoria",
								"  )"
								)
						.bind("idGraduatoria", idGraduatoria)
						.bind("idStatoRipristino", idStatoRipristino)));

				log.info("Modificato tabella ISCRITTO_R_SCUOLA_PRE stato : " + result);



				//update stato della domanda

				result.setStatus(this.update(buildSqlHolder()
						.addQueryRows(
								"update iscritto_t_domanda_isc",
								"set id_stato_dom = (select id_stato_dom from iscritto_d_stato_dom where cod_stato_dom = 'AMM')",
								"where",
								"  id_domanda_iscrizione = (",
								"     select id_domanda_iscrizione from iscritto_t_graduatoria where id_graduatoria = :idGraduatoria )"
								)
						.bind("idGraduatoria", idGraduatoria)));

				log.info("Modificato tabella ISCRITTO_T_DOMANDA_ISC stato : " + result);


				//fine

			}
		}
		// *************************************
		// *******************ACC->AMM**********
		// *************************************
		else if (idStatoAttuale == 4 && idStatoRipristino == 3) {

			// Incrementare di 1 il valore del campo posti_ammessi.
			result.setStatus(this.update(buildSqlHolder()
					.addQueryRows(
							"update iscritto_t_classe set",
							"  posti_ammessi = posti_ammessi + 1",
							"where",
							"  id_scuola = (",
							"     select id_scuola from iscritto_t_graduatoria where id_graduatoria = :idGraduatoria",
							"  ) and",
							"  id_tipo_frequenza = (",
							"     select id_tipo_frequenza from iscritto_t_graduatoria where id_graduatoria = :idGraduatoria",
							"  ) and",
							"  id_eta = (",
							"    select eta.id_eta from iscritto_t_eta eta",
							"    where eta.id_fascia_eta = (",
							"      select id_fascia_eta from iscritto_t_graduatoria where id_graduatoria = :idGraduatoria",
							"    )",
							"    and eta.id_anagrafica_gra = (",
							"      select sg.id_anagrafica_gra from iscritto_t_step_gra sg",
							"        join iscritto_t_step_gra_con sgc on sgc.id_step_gra = sg.id_step_gra",
							"      where sgc.id_step_gra_con = (",
							"        select id_step_gra_con from iscritto_t_graduatoria where id_graduatoria = :idGraduatoria",
							"      )",
							"    )",
							"  )")
					.bind("idGraduatoria", idGraduatoria)));

			log.info("Numero classi modificate: " + result);

			// Impostare il valore del campo fl_auto a ‘S’ del record selezionato da A.
			result.setStatus(this.update(buildSqlHolder()
					.addQueryRows(
							"update iscritto_t_acc_rin",
							"	set fl_auto = :flAuto",
							"	where id_domanda_iscrizione = (",
							"	    SELECT acc.id_domanda_iscrizione ",
							"	    from iscritto_t_acc_rin acc",
							"	        join iscritto_t_graduatoria itg on acc.id_domanda_iscrizione = itg.id_domanda_iscrizione",
							"	        join iscritto_t_scuola its on acc.id_scuola = its.id_scuola",
							"	    where itg.id_graduatoria = :idGraduatoria and acc.fl_a_r = 'A'",
							"	)")
					.bind("flAuto", "S")
					.bind("idGraduatoria", idGraduatoria)));

			log.info("Numero record modificati: " + result);

			InfoInvioAccRow infoInvioAcc = ConvertUtils.getFirst(this.query(buildSqlHolder()
					.addQueryRows(
							"select dt_invio_scuola, dt_invio_sise " +
									"from iscritto_t_invio_acc " +
									"where id_accettazione_rin = ( " +
									"    select id_accettazione_rin " +
									"    from iscritto_t_acc_rin " +
									"    where id_domanda_iscrizione = ( " +
									"   SELECT rin2.id_domanda_iscrizione " +
									" from iscritto_t_acc_rin rin2 " +
									" join iscritto_t_graduatoria itg on rin2.id_domanda_iscrizione = itg.id_domanda_iscrizione " +
									" join iscritto_t_scuola its on rin2.id_scuola = its.id_scuola " +
									" where itg.id_graduatoria = :idGraduatoria " +
									" ) " +
									"    ) fetch first 1 row only;")
					.bind("idGraduatoria", idGraduatoria), InfoInvioAccRow.class));

			if (infoInvioAcc.getDtInvioSise() == null && infoInvioAcc.getDtInvioScuola() == null) {
				result.setStatus(this.update(buildSqlHolder()
						.addQueryRows(
								"delete from iscritto_t_invio_acc " +
										"where id_accettazione_rin = ( " +
										"    select id_accettazione_rin " +
										"    from iscritto_t_acc_rin " +
										"    where id_domanda_iscrizione = ( " +
										"           SELECT rin2.id_domanda_iscrizione " +
										"        from iscritto_t_acc_rin rin2 " +
										"        join iscritto_t_graduatoria itg on rin2.id_domanda_iscrizione = itg.id_domanda_iscrizione " +
										"        join iscritto_t_scuola its on rin2.id_scuola = its.id_scuola " +
										"        where itg.id_graduatoria = :idGraduatoria " +
										"        ) " +
										"    ); ")
						.bind("idGraduatoria", idGraduatoria)));

				log.info("Modificato stato : " + result);
			}
			else {
				if (infoInvioAcc.getDtInvioSise() != null) {
					log.info(buildMessage(getClass(), methodName, "dtInvioSise: " + infoInvioAcc.getDtInvioSise()));

					result.addMessage(String.format(
							"L'accettazione del posto e' stato comunicato al sistema SISE in data %s",
							DateUtils.toStringDate(infoInvioAcc.getDtInvioSise(), DateUtils.DEFAULT_DATE_FORMAT)));
				}
				if (infoInvioAcc.getDtInvioScuola() != null) {
					log.info(buildMessage(getClass(), methodName, "dtInvioScuola: " + infoInvioAcc.getDtInvioScuola()));

					result.addMessage(String.format(
							"L'accettazione del posto e' stato comunicato alla scuola in data %s",
							DateUtils.toStringDate(infoInvioAcc.getDtInvioScuola(), DateUtils.DEFAULT_DATE_FORMAT)));
				}
			}

			result.setStatus(this.update(buildSqlHolder()
					.addQueryRows(
							"update iscritto_t_graduatoria ",
							"set id_stato_scu = :idStatoRipristino ",
							"where id_graduatoria = :idGraduatoria")
					.bind("idStatoRipristino", idStatoRipristino)
					.bind("idGraduatoria", idGraduatoria)));

			log.info("Modificato stato : " + result);

			result.setStatus(this.update(buildSqlHolder()
					.addQueryRows(
							"with parametri as (",
							"  select",
							"    id_domanda_iscrizione,",
							"    id_step_gra_con",
							"  from iscritto_t_graduatoria",
							"  where id_graduatoria = :idGraduatoria",
							")",
							"update iscritto_t_graduatoria set",
							"  id_stato_scu = (select ds.id_stato_scu from iscritto_d_stato_scu ds where ds.cod_stato_scu = 'PEN')",
							"where 1 = 1",
							"  and id_domanda_iscrizione = (select id_domanda_iscrizione from parametri)",
							"  and id_step_gra_con = (select id_step_gra_con from parametri)",
						//	"  and id_stato_scu in (select ds.id_stato_scu from iscritto_d_stato_scu ds where ds.cod_stato_scu in ('CAN', 'CAN_1SC'))")
							"  and id_stato_scu in (select ds.id_stato_scu from iscritto_d_stato_scu ds where ds.cod_stato_scu ='CAN')")
					.bind("idGraduatoria", idGraduatoria)));

			log.info("Modificato stato : " + result);

			//aggiornamento segnalazione 11, modifica della query precedente nelle condizione di stato da CAN_1SC e CAN a solo CAN
			//update della tabella ISCRITTO_R_SCUOLA_PRE

			result.setStatus(this.update(buildSqlHolder()
					.addQueryRows(
							 " update iscritto_r_scuola_pre ",
							 " set id_stato_scu = (select id_stato_scu from iscritto_d_stato_scu where cod_stato_scu = 'PEN'),",
							 "     dt_stato = CURRENT_TIMESTAMP",
							 " where ",
							 " id_domanda_iscrizione = (",
							 "       select id_domanda_iscrizione",
							 "       from iscritto_t_graduatoria",
							 "       where id_graduatoria = :idGraduatoria",
							 " )and",
							 " id_stato_scu = (",
							 "    select id_stato_scu",
							 "     from iscritto_d_stato_scu",
							 "     where cod_stato_scu ='CAN')"
							)
					.bind("idGraduatoria", idGraduatoria)));
			log.info("Eseguito update tabella iscritto_r_scuola_pre da CAN a PEN " + result);

			//update della tabella ISCRITTO_R_SCUOLA dello stato della scuola oggetto di ripristino stato
			result.setStatus(this.update(buildSqlHolder()
					.addQueryRows(
							"update iscritto_r_scuola_pre",
							"  set id_stato_scu = :idStatoRipristino,",
							"      dt_stato = CURRENT_TIMESTAMP",
							"where",
							"  id_domanda_iscrizione = (",
							"     select id_domanda_iscrizione from iscritto_t_graduatoria where id_graduatoria = :idGraduatoria",
							"  ) and",
							"  id_scuola = (",
							"     select id_scuola from iscritto_t_graduatoria where id_graduatoria = :idGraduatoria",
							"  ) and",
							"  id_tipo_frequenza = (",
							"     select id_tipo_frequenza from iscritto_t_graduatoria where id_graduatoria = :idGraduatoria",
							"  )"
							)
					.bind("idGraduatoria", idGraduatoria)
					.bind("idStatoRipristino", idStatoRipristino)));

			log.info("Modificato tabella ISCRITTO_R_SCUOLA_PRE stato : " + result);


			//update stato della domanda

			result.setStatus(this.update(buildSqlHolder()
					.addQueryRows(
							"update iscritto_t_domanda_isc",
							"set id_stato_dom = (select id_stato_dom from iscritto_d_stato_dom where cod_stato_dom = 'AMM')",
							"where",
							"  id_domanda_iscrizione = (",
							"     select id_domanda_iscrizione from iscritto_t_graduatoria where id_graduatoria = :idGraduatoria )"
							)
					.bind("idGraduatoria", idGraduatoria)));

			log.info("Modificato tabella ISCRITTO_T_DOMANDA_ISC stato : " + result);



			//fine

		}
		// *************************************
		// ***EVOLUTIVA R31B CAMBIARE DA********
		// ***RIN_AUTO->PEN A RIN_AUTO->AMM*****
		// ************RIN_AUTO->AMM************
		// *************************************
		else if (idStatoAttuale == 8 && idStatoRipristino == 3) {

			//inizio

			SqlHolder sh = buildSqlHolder()
					.addQueryRows(
							"select",
							"  posti_liberi",
							"from iscritto_t_classe",
							"where",
							"  id_scuola = (",
							"     select id_scuola from iscritto_t_graduatoria where id_graduatoria = :idGraduatoria",
							"  ) and",
							"  id_tipo_frequenza = (",
							"     select id_tipo_frequenza from iscritto_t_graduatoria where id_graduatoria = :idGraduatoria",
							"  ) and",
							"  id_eta = (",
							"    select eta.id_eta from iscritto_t_eta eta",
							"    where eta.id_fascia_eta = (",
							"      select id_fascia_eta from iscritto_t_graduatoria where id_graduatoria = :idGraduatoria",
							"    )",
							"    and eta.id_anagrafica_gra = (",
							"      select sg.id_anagrafica_gra from iscritto_t_step_gra sg",
							"        join iscritto_t_step_gra_con sgc on sgc.id_step_gra = sg.id_step_gra",
							"      where sgc.id_step_gra_con = (",
							"        select id_step_gra_con from iscritto_t_graduatoria where id_graduatoria = :idGraduatoria",
							"      )",
							"    )",
							"  )")
					.bind("idGraduatoria", idGraduatoria);

			IscrittoTClasse classe = ConvertUtils.getFirst(this.query(sh, IscrittoTClasse.class));
			Integer postiLiberi = classe == null ? null : classe.getPostiLiberi();

			log.info("Numero posti liberi : " + postiLiberi);

			if (postiLiberi == null || postiLiberi.intValue() <= 0) {
				log.error(buildMessage(getClass(), methodName, "errore operazione non eseguibile perche' non ci sono posti liberi"));
				throw ErrorCodeEnum.VAL_GRA_011.buildException();
			}
			else {
				// incrementare di 1 il valore del campo posti_ammessi e diminuire di 1 il valore del campo posti_liberi
				Integer incr = this.update(buildSqlHolder()
						.addQueryRows(
								"update iscritto_t_classe set",
								"  posti_liberi = posti_liberi - 1,",
								"  posti_ammessi = posti_ammessi + 1",
								"where",
								"  id_scuola = (",
								"     select id_scuola from iscritto_t_graduatoria where id_graduatoria = :idGraduatoria",
								"  ) and",
								"  id_tipo_frequenza = (",
								"     select id_tipo_frequenza from iscritto_t_graduatoria where id_graduatoria = :idGraduatoria",
								"  ) and",
								"  id_eta = (",
								"    select eta.id_eta from iscritto_t_eta eta",
								"    where eta.id_fascia_eta = (",
								"      select id_fascia_eta from iscritto_t_graduatoria where id_graduatoria = :idGraduatoria",
								"    )",
								"    and eta.id_anagrafica_gra = (",
								"      select sg.id_anagrafica_gra from iscritto_t_step_gra sg",
								"        join iscritto_t_step_gra_con sgc on sgc.id_step_gra = sg.id_step_gra",
								"      where sgc.id_step_gra_con = (",
								"        select id_step_gra_con from iscritto_t_graduatoria where id_graduatoria = :idGraduatoria",
								"      )",
								"    )",
								"  )")
						.bind("idGraduatoria", idGraduatoria));

				log.info("Numero classi modificate: " + incr);


				result.setStatus(this.update(buildSqlHolder()
						.addQueryRows(
								"update iscritto_t_graduatoria ",
								"set id_stato_scu = :idStatoRipristino ",
								"where id_graduatoria = :idGraduatoria")
						.bind("idStatoRipristino", idStatoRipristino)
						.bind("idGraduatoria", idGraduatoria)));

				log.info("Modificato stato : " + result);

				result.setStatus(this.update(buildSqlHolder()
						.addQueryRows(
								"with parametri as (",
								"  select",
								"    id_domanda_iscrizione,",
								"    id_step_gra_con",
								"  from iscritto_t_graduatoria",
								"  where id_graduatoria = :idGraduatoria",
								")",
								"update iscritto_t_graduatoria set",
								"  id_stato_scu = (select ds.id_stato_scu from iscritto_d_stato_scu ds where ds.cod_stato_scu = 'PEN')",
								"where 1 = 1",
								"  and id_domanda_iscrizione = (select id_domanda_iscrizione from parametri)",
								"  and id_step_gra_con = (select id_step_gra_con from parametri)",
								"  and id_stato_scu in (select ds.id_stato_scu from iscritto_d_stato_scu ds where ds.cod_stato_scu ='CAN_RIN')")
						.bind("idGraduatoria", idGraduatoria)));

				log.info("Modificato stato : " + result);

				result.setStatus(this.update(buildSqlHolder()
						.addQueryRows(
								"with parametri as (",
								"  select",
								"    id_domanda_iscrizione,",
								"    id_step_gra_con",
								"  from iscritto_t_graduatoria",
								"  where id_graduatoria = :idGraduatoria",
								")",
								"update iscritto_t_graduatoria set",
								"  id_stato_scu = (select ds.id_stato_scu from iscritto_d_stato_scu ds where ds.cod_stato_scu = 'CAN_1SC')",
								"where 1 = 1",
								"  and id_domanda_iscrizione = (select id_domanda_iscrizione from parametri)",
								"  and id_step_gra_con = (select id_step_gra_con from parametri)",
								"  and id_stato_scu in (select ds.id_stato_scu from iscritto_d_stato_scu ds where ds.cod_stato_scu ='CAN_R_1SC')")
						.bind("idGraduatoria", idGraduatoria)));

				log.info("Modificato stato : " + result);


				//aggiornamento segnalazione 11 aggiornamento della tabella ISCRITTO_R_SCUOLA_PRE

				result.setStatus(this.update(buildSqlHolder()
						.addQueryRows(
								 " update iscritto_r_scuola_pre ",
								 " set id_stato_scu = (select id_stato_scu from iscritto_d_stato_scu where cod_stato_scu = 'PEN'),",
								 "     dt_stato = CURRENT_TIMESTAMP",
								 " where ",
								 " id_domanda_iscrizione = (",
								 "       select id_domanda_iscrizione",
								 "       from iscritto_t_graduatoria",
								 "       where id_graduatoria = :idGraduatoria",
								 " )and",
								 " id_stato_scu in (",
								 "    select id_stato_scu",
								 "     from iscritto_d_stato_scu",
								 "     where cod_stato_scu in ('CAN_RIN', 'CAN_R_1SC'))"
								)
						.bind("idGraduatoria", idGraduatoria)));
				log.info("Eseguito update tabella iscritto_r_scuola_pre da CAN_1SC o CAN_RIN a PEN " + result);

				//update della tabella ISCRITTO_R_SCUOLA dello stato della scuola oggetto di ripristino stato
				result.setStatus(this.update(buildSqlHolder()
						.addQueryRows(
								"update iscritto_r_scuola_pre",
								"  set id_stato_scu = :idStatoRipristino,",
								"      dt_stato = CURRENT_TIMESTAMP",
								"where",
								"  id_domanda_iscrizione = (",
								"     select id_domanda_iscrizione from iscritto_t_graduatoria where id_graduatoria = :idGraduatoria",
								"  ) and",
								"  id_scuola = (",
								"     select id_scuola from iscritto_t_graduatoria where id_graduatoria = :idGraduatoria",
								"  ) and",
								"  id_tipo_frequenza = (",
								"     select id_tipo_frequenza from iscritto_t_graduatoria where id_graduatoria = :idGraduatoria",
								"  )"
								)
						.bind("idGraduatoria", idGraduatoria)
						.bind("idStatoRipristino", idStatoRipristino)));

				log.info("Modificato tabella ISCRITTO_R_SCUOLA_PRE stato : " + result);


				//update stato della domanda

				result.setStatus(this.update(buildSqlHolder()
						.addQueryRows(
								"update iscritto_t_domanda_isc",
								"set id_stato_dom = (select id_stato_dom from iscritto_d_stato_dom where cod_stato_dom = 'AMM')",
								"where",
								"  id_domanda_iscrizione = (",
								"     select id_domanda_iscrizione from iscritto_t_graduatoria where id_graduatoria = :idGraduatoria )"
								)
						.bind("idGraduatoria", idGraduatoria)));

				log.info("Modificato tabella ISCRITTO_T_DOMANDA_ISC stato : " + result);



			}

			//fine


		}

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	//////////////////////////////////////////////////////////////////////

	private Long getIdStepGra(TipoScuola tipoScuola, String codAnagraficaGra) throws DaoException, ValidationException {
		final String methodName = "getIdStepGra";

		IscrittoTStepGra row = this.getStepGra(codAnagraficaGra, tipoScuola.getCod());
		if (row == null) {
			log.error(buildMessage(getClass(), methodName, "nessun record trovato su iscritto_t_step_gra"));
			throw ErrorCodeEnum.VAL_GRA_004.buildException();
		}

		return row.getIdStepGra();
	}

	private Long getIdStepGraCon(Long idStepGra) throws DaoException, ValidationException {
		final String methodName = "getIdStepGraCon";

		IscrittoTStepGraCon row = this.findStepGraduatoriaCon(idStepGra);
		if (row == null) {
			log.error(buildMessage(getClass(), methodName, "nessun record trovato su iscritto_t_step_gra_con"));
			throw ErrorCodeEnum.VAL_GRA_004.buildException();
		}

		return row.getIdStepGraCon();
	}

	private Long getIdPrevStepGra(Long idStepGra) throws DaoException, ValidationException {
		final String methodName = "getIdNextStepGra";

		IscrittoTStepGra row = this.getPrevStepGra(idStepGra);
		if (row == null) {
			log.error(buildMessage(getClass(), methodName, "step precedente non trovato su iscritto_t_step_gra"));
			throw ErrorCodeEnum.VAL_GRA_004.buildException();
		}

		return row.getIdStepGra();
	}

	private IscrittoTStepGra getStepGra(String codAnagraficaGra, String codOrdineScuola) throws DaoException {
		final Date now = new Date();

		SqlHolder sh = buildSqlHolder()
				.addQueryRows(
						"select",
						"  sg.step,",
						"  sg.dt_step_gra,",
						"  sg.id_step_gra,",
						"  sg.id_anagrafica_gra,",
						"  sg.dt_dom_inv_da,",
						"  sg.dt_dom_inv_a,",
						"  sg.dt_allegati",
						"from iscritto_t_step_gra sg",
						"where 1 = 1",
						"  and sg.id_anagrafica_gra in (",
						"    select gr.id_anagrafica_gra",
						"    from iscritto_t_anagrafica_gra gr",
						"    where gr.cod_anagrafica_gra = :codAnagraficaGra and gr.id_ordine_scuola in (",
						"      select os.id_ordine_scuola from iscritto_d_ordine_scuola os where os.cod_ordine_scuola = :codOrdineScuola",
						"    )",
						"  )",
						"  and to_date(:data, 'YYYY-MM-DD') >= to_date(to_char(sg.dt_step_gra, 'YYYY-MM-DD'), 'YYYY-MM-DD')",
						"order by sg.dt_step_gra desc",
						"limit 1")
				.bind("codAnagraficaGra", codAnagraficaGra)
				.bind("codOrdineScuola", codOrdineScuola)
				.bind("data", DateUtils.toStringDate(now, DateUtils.ISO_8601_FORMAT));

		return ConvertUtils.getFirst(this.query(sh, IscrittoTStepGra.class));
	}

	private void setCalcoloInCorso(Long idStepGraCon, boolean value) throws DaoException {
		this.update(buildSqlHolder()
				.addQueryRows(
						"update iscritto_t_step_gra_con set",
						"  fl_calcolo_in_corso = :flCalcoloInCorso",
						"where id_step_gra_con = :idStepGraCon")
				.bind("idStepGraCon", idStepGraCon)
				.bind("flCalcoloInCorso", ConvertUtils.toSN(value)));
	}

	private void aggiornaData(Long idStepGraCon) throws DaoException {
		this.update(buildSqlHolder()
				.addQueryRows(
						"update iscritto_t_step_gra_con set",
						"  dt_step_con = now()",
						"where id_step_gra_con = :idStepGraCon")
				.bind("idStepGraCon", idStepGraCon));
	}

	private IscrittoTStepGra getPrevStepGra(Long idStepGra) throws DaoException {
		SqlHolder sh = buildSqlHolder()
				.addQueryRows(
						"with step_attuale as (",
						"  select",
						"    sg.step,",
						"    sg.id_anagrafica_gra",
						"  from iscritto_t_step_gra sg",
						"  where id_step_gra = :idStepGra",
						")",
						"select",
						"  sg.step,",
						"  sg.dt_step_gra,",
						"  sg.id_step_gra,",
						"  sg.id_anagrafica_gra,",
						"  sg.dt_dom_inv_da,",
						"  sg.dt_dom_inv_a,",
						"  sg.dt_allegati",
						"from iscritto_t_step_gra sg",
						"where 1 = 1",
						"  and sg.id_anagrafica_gra = (select id_anagrafica_gra from step_attuale)",
						"  and sg.step = (select step - 1 from step_attuale)")
				.bind("idStepGra", idStepGra);

		return ConvertUtils.getFirst(this.query(sh, IscrittoTStepGra.class));
	}

	private void checkFlagAmmissioni(IscrittoTStepGraCon row) throws ValidationException {
		final String methodName = "checkFlagAmmissioni";

		if (row != null) {
			Boolean ammissioni = ConvertUtils.fromSN(row.getFlAmmissioni());
			if (!Boolean.TRUE.equals(ammissioni)) {
				log.error(buildMessage(getClass(), methodName, "flag ammissioni diverso da 'S'"));
				throw ErrorCodeEnum.VAL_GRA_007.buildException();
			}
		}
	}

	private void checkEmptyResult(Long idStepGra) throws DaoException, ValidationException {
		final String methodName = "checkEmptyResult";

		IscrittoTStepGraCon row = this.findStepGraduatoriaCon(idStepGra);
		if (row != null) {
			log.error(buildMessage(getClass(), methodName,
					"esiste gia' un record su iscritto_t_step_gra_con relativo a id_step_gra: " + idStepGra));
			throw ErrorCodeEnum.VAL_GRA_004.buildException();
		}
	}

	private void lock() throws ValidationException {
		final String methodName = "lock";

		List<IscrittoTStepGra> rows;
		try {
			rows = this.query(buildSqlHolder()
					.addQueryRows(
							"select id_step_gra from iscritto_t_step_gra order by id_step_gra limit 1 for update nowait"),
					IscrittoTStepGra.class);
		}
		catch (DaoException e) {
			log.error(buildMessage(getClass(), methodName, e.getMessage()));
			throw ErrorCodeEnum.VAL_GRA_006.buildException();
		}

		if (CollectionUtils.isEmpty(rows)) {
			log.error(buildMessage(getClass(), methodName, "nessun record su iscritto_t_step_gra_con"));
			throw ErrorCodeEnum.VAL_GRA_001.buildException();
		}
	}

	private void callFunction(SqlHolder sh) throws DaoException, ValidationException {
		final String methodName = "callFunction";
		List<FunctionRow> rows = this.query(sh, FunctionRow.class);

		if (CollectionUtils.isEmpty(rows)) {
			log.error(buildMessage(GraduatoriaDaoImpl.class, methodName, "errore nella funzione, nessun risultato restituito"));
			throw ErrorCodeEnum.VAL_GRA_005.buildException();
		}

		Integer intResult = rows.get(0).getIntResult();
		if (intResult == null) {
			log.error(buildMessage(GraduatoriaDaoImpl.class, methodName, "errore nella funzione, risultato nullo"));
			throw ErrorCodeEnum.VAL_GRA_005.buildException();
		}

		if (intResult.intValue() != 0) {
			log.error(buildMessage(GraduatoriaDaoImpl.class, methodName, "errore nella funzione, risultato diverso da 0"));
			throw ErrorCodeEnum.VAL_GRA_005.buildException();
		}
	}

	@Override
	public String findFlagBloccoGraduatoria(TipoScuola tipoScuola) throws DaoException {

		SqlHolder sh = buildSqlHolder()
				.addQueryRows(
						"select",
						"  testo_sms_amm",
						"from iscritto_t_parametro"
						);


		IscrittoTParametro row = ConvertUtils.getFirst(this.query(sh, IscrittoTParametro.class));
		return row.getTestoSmsAmm();
	}

	@Override
	public void updateFlagBloccoGraduatoria(TipoScuola tipoScuola, Boolean value) throws DaoException {


	}

}
