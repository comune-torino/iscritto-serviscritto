package it.csi.iscritto.serviscritto.business.integration.dao.view.impl;

import static it.csi.iscritto.serviscritto.business.util.DateUtils.ISO_8601_FORMAT;
import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.LOG_BEGIN;
import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.LOG_END;
import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.buildMessage;
import static it.csi.iscritto.serviscritto.business.util.sql.SqlHolderUtils.addIf;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import org.apache.log4j.Logger;

import it.csi.iscritto.serviscritto.business.integration.dao.AbstractDao;
import it.csi.iscritto.serviscritto.business.integration.dao.TipoScuola;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTAnnoSco;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTEta;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTGraduatoria;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTUtente;
import it.csi.iscritto.serviscritto.business.integration.dao.view.ScuoleDao;
import it.csi.iscritto.serviscritto.business.integration.dao.view.dto.FasciaEtaRow;
import it.csi.iscritto.serviscritto.business.integration.dao.view.dto.ScuolaRow;
import it.csi.iscritto.serviscritto.business.integration.exception.DaoException;
import it.csi.iscritto.serviscritto.business.util.Constants;
import it.csi.iscritto.serviscritto.business.util.DateUtils;
import it.csi.iscritto.serviscritto.business.util.converter.ConvertUtils;
import it.csi.iscritto.serviscritto.business.util.sql.SqlHolder;

public class ScuoleDaoImpl extends AbstractDao implements ScuoleDao {
	private static final Logger log = Logger.getLogger(Constants.COMPONENT_NAME + ".dao");

	@Override
	public List<ScuolaRow> findScuole(TipoScuola tipoScuola, String codAnno, Date dataNascita) throws DaoException {
		final String methodName = "findScuole";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		log.info("^^ liv query, data di nascita minore: "+dataNascita);
		log.info("^^ codice Anno: "+codAnno);
		Validate.notNull(tipoScuola);
		Validate.notNull(dataNascita);
		int aprile = validaAnticipatariAprile(dataNascita, codAnno);

		SqlHolder sh;
		switch (tipoScuola) {
			case NID:
				sh = buildScuolaRowBaseQueryNidi(dataNascita);
				addAnnoScolasticoFilter(sh, codAnno);
				break;
			case MAT:
				sh = buildScuolaRowBaseQueryMaterne(aprile);
				break;
			default:
				throw new UnsupportedOperationException();
		}

		addOrderByCondition(sh);
		List<ScuolaRow> result = this.query(sh, ScuolaRow.class);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public List<ScuolaRow> findScuoleByDescrizione(TipoScuola tipoScuola, String codAnno, String descrizione, Date dataNascita) throws DaoException {
		final String methodName = "findScuoleByDescrizione";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		Validate.notNull(tipoScuola);
		List<ScuolaRow> result;

		if (StringUtils.isBlank(descrizione)) {
			result = new ArrayList<>();

			log.debug(buildMessage(getClass(), methodName, LOG_END));
			return result;
		}

		int aprile = 0;
		if(dataNascita != null) {
			aprile = validaAnticipatariAprile(dataNascita, codAnno);
		}
		SqlHolder sh;
		switch (tipoScuola) {
			case NID:
				sh = buildScuolaRowBaseQueryNidi(dataNascita);
				addAnnoScolasticoFilter(sh, codAnno);
				break;
			case MAT:
				sh = buildScuolaRowBaseQueryMaterne(aprile);
				break;
			default:
				throw new UnsupportedOperationException();
		}

		sh.addQueryRows(
				"AND upper(s.descrizione) like upper(:descrizione)")
				.bind("descrizione", "%" + descrizione + "%");

		addOrderByCondition(sh);
		result = this.query(sh, ScuolaRow.class);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public List<ScuolaRow> findScuoleByIndirizzo(TipoScuola tipoScuola, String codAnno, String indirizzo, Date dataNascita) throws DaoException {
		final String methodName = "findScuoleByIndirizzo";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		Validate.notNull(tipoScuola);
		List<ScuolaRow> result;

		if (StringUtils.isBlank(indirizzo)) {
			result = new ArrayList<>();

			log.debug(buildMessage(getClass(), methodName, LOG_END));
			return result;
		}

		int aprile = 0;
		if(dataNascita != null) {
			aprile = validaAnticipatariAprile(dataNascita, codAnno);
		}

		SqlHolder sh;
		switch (tipoScuola) {
			case NID:
				sh = buildScuolaRowBaseQueryNidi(dataNascita);
				addAnnoScolasticoFilter(sh, codAnno);
				break;
			case MAT:
				sh = buildScuolaRowBaseQueryMaterne(aprile);
				break;
			default:
				throw new UnsupportedOperationException();
		}

		sh.addQueryRows(
				"AND upper(s.indirizzo) like upper(:indirizzo)")
				.bind("indirizzo", "%" + indirizzo + "%");

		addOrderByCondition(sh);
		result = this.query(sh, ScuolaRow.class);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public List<ScuolaRow> findScuoleByCircoscrizione(TipoScuola tipoScuola, String codAnno, Integer circoscrizione, Date dataNascita) throws DaoException {
		final String methodName = "findScuoleByCircoscrizione";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		int aprile = 0;
		if(dataNascita != null) {
			aprile = validaAnticipatariAprile(dataNascita, codAnno);
		}
		Validate.notNull(tipoScuola);

		SqlHolder sh;
		switch (tipoScuola) {
			case NID:
				sh = buildScuolaRowBaseQueryNidi(dataNascita);
				addAnnoScolasticoFilter(sh, codAnno);
				break;
			case MAT:
				sh = buildScuolaRowBaseQueryMaterne(aprile);
				break;
			default:
				throw new UnsupportedOperationException();
		}

		sh.addQueryRows(
				"AND circ.cod_circoscrizione = :circoscrizione")
				.bind("circoscrizione", String.valueOf(circoscrizione));

		addOrderByCondition(sh);
		List<ScuolaRow> result = this.query(sh, ScuolaRow.class);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public List<IscrittoTAnnoSco> findIscrittoTAnnoScoByDate(TipoScuola tipoScuola, Date data) throws DaoException {
		final String methodName = "findIscrittoTAnnoScoByDate";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		SqlHolder sh = buildSqlHolder()
				.addQueryRows(
						"select",
						"  a.id_anno_scolastico,",
						"  a.cod_anno_scolastico,",
						"  a.descrizione,",
						"  a.data_da,",
						"  a.data_a",
						"from iscritto_t_anagrafica_gra ag",
						"  inner join iscritto_t_anno_sco a on ag.id_anno_scolastico = a.id_anno_scolastico",
						"where 1 = 1",
						"  and ag.id_ordine_scuola = (select id_ordine_scuola from iscritto_d_ordine_scuola where cod_ordine_scuola = :codOrdineScuola)",
						"  and to_date(:data, 'YYYY-MM-DD') >= to_date(to_char(ag.dt_inizio_iscr, 'YYYY-MM-DD'), 'YYYY-MM-DD')",
						"  and to_date(:data, 'YYYY-MM-DD') <= to_date(to_char(ag.dt_fine_iscr,  'YYYY-MM-DD'), 'YYYY-MM-DD')",
						"order by",
						"  a.cod_anno_scolastico");

		sh.bind("codOrdineScuola", tipoScuola.getCod());
		sh.bind("data", DateUtils.toStringDate(data, ISO_8601_FORMAT));

		List<IscrittoTAnnoSco> result = this.query(sh, IscrittoTAnnoSco.class);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public List<ScuolaRow> findScuoleByUtente(TipoScuola tipoScuola, String cfOperatore, String codProfilo) throws DaoException {
		final String methodName = "findScuoleByUtente";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		Validate.notNull(tipoScuola);
		Validate.notNull(cfOperatore);
		Validate.notNull(codProfilo);

/*
		SqlHolder rs = buildSqlHolder()
				.addQueryRows(
						"select itu.*",
						"from iscritto_t_utente itu",
						"join iscritto_d_profilo idp on itu.id_profilo = idp.id_profilo",
						"join iscritto_r_profilo_pri irpc on idp.id_profilo = irpc.id_profilo",
						"join iscritto_t_privilegio itp on irpc.id_privilegio = itp.id_privilegio",
						"where itp.cod_privilegio = 'P_DOM_RIC_VIS_ECO'",
						"      and upper(itu.codice_fiscale) = :cfOperatore"
						)
				.bind("cfOperatore", ConvertUtils.toUpper(cfOperatore));

		IscrittoTUtente utente = ConvertUtils.getFirst(this.query(rs, IscrittoTUtente.class)) ;
		//IscrittoTGraduatoria ordinePreferenza = ConvertUtils.getFirst(this.query(rs, IscrittoTGraduatoria.class));
*/

		List<ScuolaRow> result = null;
/* 	    if(utente != null) {

			log.info("UTENTE  P_DOM_RIC_VIS_ECO");

			SqlHolder sh = buildSqlHolder()
					.addQueryRows(
							"select",
							"  its.id_scuola,",
							"  its.cod_scuola,",
							"  its.descrizione,",
							"  its.indirizzo,",
							"  idos.cod_ordine_scuola",
							"from iscritto_t_scuola its",
							"  join iscritto_d_ordine_scuola idos on idos.id_ordine_scuola = its.id_ordine_scuola",
							"where 1 = 1",
							"  and idos.cod_ordine_scuola = :codOrdineScuola",
							"  and its.fl_eliminata = 'N'",
							"  and its.id_scuola in(",
							"    select",
							"      irps.id_scuola",
							"    from iscritto_t_utente itu",
							"      join iscritto_r_utente_profilo irup on irup.id_utente = itu.id_utente",
							"      join iscritto_d_profilo idp on idp.id_profilo = irup.id_profilo",
							"      join iscritto_r_profilo_scuole irps on irps.id_prof_ute = irup.id_prof_ute",
							"      join iscritto_r_scuola_pre irspr on irspr.id_scuola = irps.id_scuola",
							"    where 1 = 1",
							"      and itu.fl_eliminato = 'N'",
							"      and upper(itu.codice_fiscale) = :cfOperatore",
							"      and idp.codice_profilo = :codProfilo",
							"      and irspr.id_stato_scu = 4",
							"      and now() between irup.dt_inizio and coalesce(irup.dt_fine, now())",
							"  )",
							"order by",
							"  its.indirizzo")
					.bind("cfOperatore", ConvertUtils.toUpper(cfOperatore))
					.bind("codProfilo", codProfilo)
					.bind("codOrdineScuola", tipoScuola.getCod());

			 result = this.query(sh, ScuolaRow.class);
			 */
	//	}else{


			SqlHolder sh = buildSqlHolder()
					.addQueryRows(
							"select",
							"  its.id_scuola,",
							"  its.cod_scuola,",
							"  its.descrizione,",
							"  its.indirizzo,",
							"  idos.cod_ordine_scuola",
							"from iscritto_t_scuola its",
							"  join iscritto_d_ordine_scuola idos on idos.id_ordine_scuola = its.id_ordine_scuola",
							"where 1 = 1",
							"  and idos.cod_ordine_scuola = :codOrdineScuola",
							"  and its.fl_eliminata = 'N'",
							"  and its.id_scuola in(",
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
							"order by",
							"  its.indirizzo")
					.bind("cfOperatore", ConvertUtils.toUpper(cfOperatore))
					.bind("codProfilo", codProfilo)
					.bind("codOrdineScuola", tipoScuola.getCod());

			result = this.query(sh, ScuolaRow.class);

		//}
		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public List<FasciaEtaRow> findFasceEta() throws DaoException {
		final String methodName = "findFasceEta";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		SqlHolder sh = buildSqlHolder()
				.addQueryRows(
						"select",
						"  a.cod_anno_scolastico,",
						"  os.cod_ordine_scuola,",
						"  fe.cod_fascia_eta,",
						"  e.data_da,",
						"  e.data_a,",
						"  substr(a.cod_anno_scolastico, 1, 4) anno_limite",
						"from",
						"  iscritto_t_anno_sco a,",
						"  iscritto_t_anagrafica_gra g,",
						"  iscritto_d_ordine_scuola os,",
						"  iscritto_t_eta e,",
						"  iscritto_d_fascia_eta fe",
						"where",
						"  e.id_fascia_eta = fe.id_fascia_eta",
						"  and g.id_anagrafica_gra = e.id_anagrafica_gra",
						"  and os.id_ordine_scuola = g.id_ordine_scuola",
						"  and a.id_anno_scolastico = g.id_anno_scolastico",
						"  and extract(year from a.data_da) > (extract(year from current_date) - 1)");

		List<FasciaEtaRow> result = this.query(sh, FasciaEtaRow.class);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	//////////////////////////////////////////////////////////////////////

	private static void addAnnoScolasticoFilter(SqlHolder sh, String codAnnoScolastico) {
		sh.addQueryRows(
				"AND anno.cod_anno_scolastico = :codAnnoScolastico")
				.bind("codAnnoScolastico", codAnnoScolastico);
	}

	private static void addOrderByCondition(SqlHolder sh) {
		sh.addQueryRows("order by descrizione");
	}

	private static SqlHolder buildScuolaRowBaseQueryNidi(Date dataNascita) {
		SqlHolder sh = buildSqlHolder();
		sh.addQueryRows(
				"select distinct",
				"  'N' as alert,",
				"  s.id_scuola,",
				"  s.cod_scuola,",
				"  s.descrizione,",
				"  s.indirizzo,",
				"  cat.codice_categoria_scu as cod_categoria_scu,",
				"  cat.descrizione as desc_categoria_scu,",
				"  ord.cod_ordine_scuola as cod_ordine_scuola,",
				"  ord.descrizione as desc_ordine_scuola,",
				"  circ.cod_circoscrizione as cod_circoscrizione,",
				"  circ.descrizione as desc_circoscrizione,",
				"  anno.id_anno_scolastico as id_anno_scolastico,",
				"  anno.cod_anno_scolastico as cod_anno_scolastico,",
				"  tf.cod_tipo_frequenza as cod_tipo_frequenza,",
				"  tf.descrizione as desc_tipo_frequenza,",
				"  s2.descrizione as desc_nido_contiguo,",
				"  s2.indirizzo as indirizzo_nido_contiguo",
				"from iscritto_t_scuola s",
				"  join iscritto_d_categoria_scu cat on cat.id_categoria_scu = s.id_categoria_scu",
				"  join iscritto_d_ordine_scuola ord on ord.id_ordine_scuola = s.id_ordine_scuola",
				"  join iscritto_d_circoscrizione circ on circ.id_circoscrizione = s.id_circoscrizione",
				"  left outer join iscritto_t_classe cl on cl.id_scuola = s.id_scuola",
				"  left outer join iscritto_t_anno_sco anno on anno.id_anno_scolastico = cl.id_anno_scolastico",
				"  left outer join iscritto_d_tipo_fre tf on tf.id_tipo_frequenza = cl.id_tipo_frequenza",
				"  left outer join iscritto_t_scuola s2 on s.id_nido_contiguo = s2.id_scuola",
				"where 1 = 1",
				"  and s.fl_eliminata = 'N'",
				"  and ord.cod_ordine_scuola = 'NID'",
				"  and anno.cod_anno_scolastico = :codAnnoScolastico",
				"  and cl.id_eta in (	",
				"    select et1.id_eta",
				"    from iscritto_t_eta et1",
				"    where et1.id_anagrafica_gra in (",
				"      select ag1.id_anagrafica_gra",
				"      from iscritto_t_anagrafica_gra ag1",
				"      where ag1.id_anno_scolastico = anno.id_anno_scolastico",
				"      and ag1.id_ordine_scuola = s.id_ordine_scuola",
				"    )",
				addIf(dataNascita != null,
						"    and to_date(:data, 'YYYY-MM-DD') >= to_date(to_char(et1.data_da, 'YYYY-MM-DD'), 'YYYY-MM-DD')"),
				addIf(dataNascita != null,
						"    and to_date(:data, 'YYYY-MM-DD') <= to_date(to_char(et1.data_a,  'YYYY-MM-DD'), 'YYYY-MM-DD')"),
				"  )");

		if (dataNascita != null) {
			sh.bind("data", DateUtils.toStringDate(dataNascita, ISO_8601_FORMAT));
		}

		return sh;
	}

	private static SqlHolder buildScuolaRowBaseQueryMaterne(int aprile) {

		//Caso standard
		SqlHolder sh = buildSqlHolder();
		sh.addQueryRows(
				"select distinct",
				"  'N' as alert,",
				"  s.id_scuola,",
				"  s.cod_scuola,",
				"  s.descrizione,",
				"  s.indirizzo,",
				"  cat.codice_categoria_scu as cod_categoria_scu,",
				"  cat.descrizione as desc_categoria_scu,",
				"  ord.cod_ordine_scuola as cod_ordine_scuola,",
				"  ord.descrizione as desc_ordine_scuola,",
				"  circ.cod_circoscrizione as cod_circoscrizione,",
				"  circ.descrizione as desc_circoscrizione,",
				"  anno.id_anno_scolastico as id_anno_scolastico,",
				"  anno.cod_anno_scolastico as cod_anno_scolastico,",
				"  tf.cod_tipo_frequenza as cod_tipo_frequenza,",
				"  tf.descrizione as desc_tipo_frequenza,",
				"  s2.descrizione as desc_nido_contiguo,",
				"  s2.indirizzo as indirizzo_nido_contiguo",
				"from iscritto_t_scuola s",
				"  left outer join iscritto_d_categoria_scu cat on cat.id_categoria_scu = s.id_categoria_scu",
				"  left outer join iscritto_d_ordine_scuola ord on ord.id_ordine_scuola = s.id_ordine_scuola",
				"  left outer join iscritto_d_circoscrizione circ on circ.id_circoscrizione = s.id_circoscrizione",
				"  left outer join iscritto_t_classe cl on cl.id_scuola = s.id_scuola",
				"  left outer join iscritto_t_anno_sco anno on anno.id_anno_scolastico = cl.id_anno_scolastico",
				"  left outer join iscritto_d_tipo_fre tf on tf.id_tipo_frequenza = cl.id_tipo_frequenza",
				"  left outer join iscritto_t_scuola s2 on s.id_nido_contiguo = s2.id_scuola",
				"where 1 = 1",
				"  and s.fl_eliminata = 'N'",
				"  and ord.cod_ordine_scuola = 'MAT'",
				"  and s.tipo_rest LIKE 'S%'",

				addIf(aprile == 1,
						"    and s.id_categoria_scu != 1"),

				"  and 1=1 ");



		return sh;
	}

	@Override
	public List<ScuolaRow>  findScuoleOperatore(TipoScuola tipoScuola, String codAnno, Date dataNascita, String cfOperatore) throws DaoException {
		final String methodName = "findScuoleOperatore";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));
		//evo IM-110


		log.info("Anno di nascita minore: "+ dataNascita);
		Validate.notNull(cfOperatore);
		Validate.notNull(dataNascita);

		SqlHolder sh;


		Integer res = validaOperatore(cfOperatore);
		Integer aprile = validaAnticipatariAprile(dataNascita, codAnno);
		//aprile = 1 attivo il filtro 0 altrimenti
		log.info("Risultato validazione: "+res);

		if(res == 1) {
			res = validaSEuropea(cfOperatore);
			if(res == 0) {
				res = validaSEbraica(cfOperatore);
				if(res == 0) {
					sh = buildScuolaRowBaseQueryMaterne(aprile);
				}
				else {
					sh = buildScuolaRowBaseQueryMaterneEbraiche(cfOperatore,aprile);
					log.info("Incluse Scuole Ebraiche: ");
				}
			} else {
				log.info("Incluse Scuole Europee: ");
				sh = buildScuolaRowBaseQueryMaterneEuropee(cfOperatore, aprile);
			}
		}else
			sh = buildScuolaRowBaseQueryMaterne(aprile);


		addOrderByCondition(sh);
		List<ScuolaRow> result = this.query(sh, ScuolaRow.class);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	private Integer validaAnticipatariAprile(Date dataNascita, String codAnno) throws DaoException {

		SqlHolder sh = buildSqlHolder()
				.addQueryRows(
						"select eta.*",
						"from iscritto_t_eta eta",
						"join iscritto_d_fascia_eta feta on eta.id_fascia_eta = feta.id_fascia_eta",
						"join iscritto_t_anagrafica_gra gra on eta.id_anagrafica_gra = gra.id_anagrafica_gra",
						"join iscritto_t_anno_sco anno on gra.id_anno_scolastico = anno.id_anno_scolastico",
						"where to_date(:data, 'YYYY-MM-DD') >= to_date(to_char(eta.data_da, 'YYYY-MM-DD'), 'YYYY-MM-DD')",
						"and to_date(:data, 'YYYY-MM-DD') <= to_date(to_char(eta.data_a,  'YYYY-MM-DD'), 'YYYY-MM-DD')",
						"and feta.cod_fascia_eta = 'AAPR' ",
						"and anno.cod_anno_scolastico = :codAnno "
						)
				.bind("data", DateUtils.toStringDate(dataNascita, ISO_8601_FORMAT))
				.bind("codAnno", codAnno);

		IscrittoTEta eta = ConvertUtils.getFirst(this.query(sh, IscrittoTEta.class)) ;

		if(eta != null) {
			log.info("Attivo anticipatari aprile");
			return 1;
		}else {
			return 0;
		}

	}

	private Integer validaOperatore(String cfOperatore) throws DaoException {

		SqlHolder sh = buildSqlHolder()
				.addQueryRows(
						   "select",
						   "   itu.*",
						   " from iscritto_t_utente itu",
						   "join iscritto_r_utente_profilo irup on irup.id_utente = itu.id_utente",
						   "join iscritto_d_profilo idp on idp.id_profilo = irup.id_profilo",
						   " where 1 = 1",
						   "   and itu.fl_eliminato = 'N'",
						   "   and upper(itu.codice_fiscale) = :cfOperatore",
						   "   and idp.codice_profilo = 'P3'",
						   "   and now() between irup.dt_inizio and coalesce(irup.dt_fine, now())"
						)
				.bind("cfOperatore", ConvertUtils.toUpper(cfOperatore));

		IscrittoTUtente utente = ConvertUtils.getFirst(this.query(sh, IscrittoTUtente.class)) ;


		if(utente != null) {
			log.info("Utente autorizzato");
			return 1;
		}else {
			return 0;
		}

	}

	private Integer validaSEuropea(String cfOperatore) throws DaoException{

		SqlHolder sh = buildSqlHolder()
				.addQueryRows(
						   "select",
						   "   itu.*",
						   " from iscritto_t_utente itu",
						   " join iscritto_r_utente_profilo irup on irup.id_utente = itu.id_utente",
						   " join iscritto_d_profilo idp on idp.id_profilo = irup.id_profilo",
						   " join iscritto_r_profilo_scuole irps on irps.id_prof_ute = irup.id_prof_ute",
						   " join iscritto_t_scuola its on irps.id_scuola = its.id_scuola",
						   " where 1 = 1",
						   "   and itu.fl_eliminato = 'N'",
						   "   and upper(itu.codice_fiscale) = :cfOperatore",
						   "   and idp.codice_profilo = 'P3'",
						   "   and now() between irup.dt_inizio and coalesce(irup.dt_fine, now())",
						   "   and its.tipo_rest = 'SU'"
						)
				.bind("cfOperatore", ConvertUtils.toUpper(cfOperatore));

		IscrittoTUtente utente = ConvertUtils.getFirst(this.query(sh, IscrittoTUtente.class)) ;


		if(utente != null) {
			log.info("Utente autorizzato scuole europee");
			return 2;
		}else {
			return 0;
		}
	}

	private Integer validaSEbraica(String cfOperatore) throws DaoException{

		SqlHolder sh = buildSqlHolder()
				.addQueryRows(
						   "select",
						   "   itu.*",
						   " from iscritto_t_utente itu",
						   " join iscritto_r_utente_profilo irup on irup.id_utente = itu.id_utente",
						   " join iscritto_d_profilo idp on idp.id_profilo = irup.id_profilo",
						   " join iscritto_r_profilo_scuole irps on irps.id_prof_ute = irup.id_prof_ute",
						   " join iscritto_t_scuola its on irps.id_scuola = its.id_scuola",
						   " where 1 = 1",
						   "   and itu.fl_eliminato = 'N'",
						   "   and upper(itu.codice_fiscale) = :cfOperatore",
						   "   and idp.codice_profilo = 'P3'",
						   "   and now() between irup.dt_inizio and coalesce(irup.dt_fine, now())",
						   "   and its.tipo_rest = 'SE'"
						)
				.bind("cfOperatore", ConvertUtils.toUpper(cfOperatore));

		IscrittoTUtente utente = ConvertUtils.getFirst(this.query(sh, IscrittoTUtente.class)) ;


		if(utente != null) {
			log.info("Utente autorizzato scuole ebraiche");
			return 3;
		}else {
			return 0;
		}
	}

	private static SqlHolder buildScuolaRowBaseQueryMaterneEuropee(String cfOperatore, int aprile) {


		SqlHolder sh = buildSqlHolder();
		sh.addQueryRows(
				"select distinct",
				"  'N' as alert,",
				"  s.id_scuola,",
				"  s.cod_scuola,",
				"  s.descrizione,",
				"  s.indirizzo,",
				"  cat.codice_categoria_scu as cod_categoria_scu,",
				"  cat.descrizione as desc_categoria_scu,",
				"  ord.cod_ordine_scuola as cod_ordine_scuola,",
				"  ord.descrizione as desc_ordine_scuola,",
				"  circ.cod_circoscrizione as cod_circoscrizione,",
				"  circ.descrizione as desc_circoscrizione,",
				"  anno.id_anno_scolastico as id_anno_scolastico,",
				"  anno.cod_anno_scolastico as cod_anno_scolastico,",
				"  tf.cod_tipo_frequenza as cod_tipo_frequenza,",
				"  tf.descrizione as desc_tipo_frequenza,",
				"  s2.descrizione as desc_nido_contiguo,",
				"  s2.indirizzo as indirizzo_nido_contiguo",
				"from iscritto_t_scuola s",
				"  left outer join iscritto_d_categoria_scu cat on cat.id_categoria_scu = s.id_categoria_scu",
				"  left outer join iscritto_d_ordine_scuola ord on ord.id_ordine_scuola = s.id_ordine_scuola",
				"  left outer join iscritto_d_circoscrizione circ on circ.id_circoscrizione = s.id_circoscrizione",
				"  left outer join iscritto_t_classe cl on cl.id_scuola = s.id_scuola",
				"  left outer join iscritto_t_anno_sco anno on anno.id_anno_scolastico = cl.id_anno_scolastico",
				"  left outer join iscritto_d_tipo_fre tf on tf.id_tipo_frequenza = cl.id_tipo_frequenza",
				"  left outer join iscritto_t_scuola s2 on s.id_nido_contiguo = s2.id_scuola",
				"where 1 = 1",
				"  and s.fl_eliminata = 'N'",
				"  and ord.cod_ordine_scuola = 'MAT'",
				"  and s.tipo_rest in ('S','SU','SE','U')",

				addIf(aprile == 1,
						"    and s.id_categoria_scu != 1"),

				"  and 1=1 ");

		return sh;
	}

	private static SqlHolder buildScuolaRowBaseQueryMaterneEbraiche(String cfOperatore, int aprile) {


		SqlHolder sh = buildSqlHolder();
		sh.addQueryRows(
				"select distinct",
				"  'N' as alert,",
				"  s.id_scuola,",
				"  s.cod_scuola,",
				"  s.descrizione,",
				"  s.indirizzo,",
				"  cat.codice_categoria_scu as cod_categoria_scu,",
				"  cat.descrizione as desc_categoria_scu,",
				"  ord.cod_ordine_scuola as cod_ordine_scuola,",
				"  ord.descrizione as desc_ordine_scuola,",
				"  circ.cod_circoscrizione as cod_circoscrizione,",
				"  circ.descrizione as desc_circoscrizione,",
				"  anno.id_anno_scolastico as id_anno_scolastico,",
				"  anno.cod_anno_scolastico as cod_anno_scolastico,",
				"  tf.cod_tipo_frequenza as cod_tipo_frequenza,",
				"  tf.descrizione as desc_tipo_frequenza,",
				"  s2.descrizione as desc_nido_contiguo,",
				"  s2.indirizzo as indirizzo_nido_contiguo",
				"from iscritto_t_scuola s",
				"  left outer join iscritto_d_categoria_scu cat on cat.id_categoria_scu = s.id_categoria_scu",
				"  left outer join iscritto_d_ordine_scuola ord on ord.id_ordine_scuola = s.id_ordine_scuola",
				"  left outer join iscritto_d_circoscrizione circ on circ.id_circoscrizione = s.id_circoscrizione",
				"  left outer join iscritto_t_classe cl on cl.id_scuola = s.id_scuola",
				"  left outer join iscritto_t_anno_sco anno on anno.id_anno_scolastico = cl.id_anno_scolastico",
				"  left outer join iscritto_d_tipo_fre tf on tf.id_tipo_frequenza = cl.id_tipo_frequenza",
				"  left outer join iscritto_t_scuola s2 on s.id_nido_contiguo = s2.id_scuola",
				"where 1 = 1",
				"  and s.fl_eliminata = 'N'",
				"  and ord.cod_ordine_scuola = 'MAT'",
				"  and s.tipo_rest in ('S','SE','SU','E')",

				addIf(aprile == 1,
						"    and s.id_categoria_scu != 1"),

				"  and 1=1 ");

		return sh;
	}


}
