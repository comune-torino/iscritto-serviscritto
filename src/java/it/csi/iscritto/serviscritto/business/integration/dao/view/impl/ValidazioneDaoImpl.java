package it.csi.iscritto.serviscritto.business.integration.dao.view.impl;

import static it.csi.iscritto.serviscritto.business.util.DateUtils.ISO_8601_FORMAT;
import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.LOG_BEGIN;
import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.LOG_END;
import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.buildMessage;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.Validate;
import org.apache.log4j.Logger;

import it.csi.iscritto.serviscritto.business.integration.dao.AbstractDao;
import it.csi.iscritto.serviscritto.business.integration.dao.TipoScuola;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTAnagraficaGra;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTEta;
import it.csi.iscritto.serviscritto.business.integration.dao.view.ValidazioneDao;
import it.csi.iscritto.serviscritto.business.integration.dao.view.dto.InfoDomandaRow;
import it.csi.iscritto.serviscritto.business.integration.exception.DaoException;
import it.csi.iscritto.serviscritto.business.util.Constants;
import it.csi.iscritto.serviscritto.business.util.DateUtils;
import it.csi.iscritto.serviscritto.business.util.converter.ConvertUtils;
import it.csi.iscritto.serviscritto.business.util.sql.SqlHolder;

public class ValidazioneDaoImpl extends AbstractDao implements ValidazioneDao {
	private static final Logger log = Logger.getLogger(Constants.COMPONENT_NAME + ".dao");

	@Override
	public List<InfoDomandaRow> dataCheckAltroRichiedente(
			TipoScuola tipoScuola, String codAnnoScolastico, String codiceFiscaleRic, String codiceFiscaleMin) throws DaoException {

		final String methodName = "dataCheckAltroRichiedente";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		Validate.notEmpty(codAnnoScolastico);
		Validate.notEmpty(codiceFiscaleRic);
		Validate.notEmpty(codiceFiscaleMin);

		SqlHolder sh = buildSqlHolder()
				.addQueryRows(
						"select * from (",
						"  select",
						"	dom.id_domanda_iscrizione,",
						"	(",
						"	  select anno.cod_anno_scolastico from iscritto_t_anno_sco anno",
						"	  where anno.id_anno_scolastico = dom.id_anno_scolastico",
						"	) as cod_anno_scolastico,",
						"	(",
						"	  select sog.codice_fiscale from iscritto_t_anagrafica_sog sog ",
						"	    join iscritto_r_soggetto_rel r on sog.id_anagrafica_soggetto = r.id_anagrafica_soggetto",
						"	    join iscritto_d_tipo_sog tip on r.id_tipo_soggetto = tip.id_tipo_soggetto",
						"	  where sog.id_domanda_iscrizione = dom.id_domanda_iscrizione and tip.cod_tipo_soggetto = 'RIC'",
						"	) as codice_fiscale_ric,",
						"	(",
						"	  select sog.codice_fiscale from iscritto_t_anagrafica_sog sog ",
						"	    join iscritto_r_soggetto_rel r on sog.id_anagrafica_soggetto = r.id_anagrafica_soggetto",
						"	    join iscritto_d_tipo_sog tip on r.id_tipo_soggetto = tip.id_tipo_soggetto",
						"	  where sog.id_domanda_iscrizione = dom.id_domanda_iscrizione and tip.cod_tipo_soggetto = 'MIN'",
						"	) as codice_fiscale_min,",
						"	(",
						"	  select sd.cod_stato_dom from iscritto_d_stato_dom sd where dom.id_stato_dom = sd.id_stato_dom",
						"	) as cod_stato_dom",
						"  from iscritto_t_domanda_isc dom",
						"  where 1 = 1",
						"    and dom.id_ordine_scuola = (",
						"      select id_ordine_scuola from iscritto_d_ordine_scuola where cod_ordine_scuola = :codOrdineScuola",
						"    )",
						"    and dom.id_stato_dom in (",
						"      select sd.id_stato_dom from iscritto_d_stato_dom sd where sd.cod_stato_dom in ('INV', 'GRA', 'AMM')",
						"    )",
						") as v1",
						"where 1 = 1",
						"  and v1.cod_anno_scolastico = :codAnnoScolastico",
						"  and upper(v1.codice_fiscale_min) = :codiceFiscaleMin",
						"  and upper(v1.codice_fiscale_ric) <> :codiceFiscaleRic")
				.bind("codOrdineScuola", tipoScuola.getCod())
				.bind("codAnnoScolastico", codAnnoScolastico)
				.bind("codiceFiscaleMin", ConvertUtils.toUpper(codiceFiscaleMin))
				.bind("codiceFiscaleRic", ConvertUtils.toUpper(codiceFiscaleRic));

		List<InfoDomandaRow> result = this.query(sh, InfoDomandaRow.class);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public List<InfoDomandaRow> dataCheckDomandaEsistente(
			TipoScuola tipoScuola, String codAnnoScolastico, String codiceFiscaleRic, String codiceFiscaleMin) throws DaoException {

		final String methodName = "dataCheckDomandaEsistente";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		Validate.notEmpty(codAnnoScolastico);
		Validate.notEmpty(codiceFiscaleRic);
		Validate.notEmpty(codiceFiscaleMin);

		SqlHolder sh = buildSqlHolder()
				.addQueryRows(
						"select * from (",
						"  select",
						"	dom.id_domanda_iscrizione,",
						"	(",
						"	  select anno.cod_anno_scolastico from iscritto_t_anno_sco anno",
						"	  where anno.id_anno_scolastico = dom.id_anno_scolastico",
						"	) as cod_anno_scolastico,",
						"	(",
						"	  select sog.codice_fiscale from iscritto_t_anagrafica_sog sog ",
						"	    join iscritto_r_soggetto_rel r on sog.id_anagrafica_soggetto = r.id_anagrafica_soggetto",
						"	    join iscritto_d_tipo_sog tip on r.id_tipo_soggetto = tip.id_tipo_soggetto",
						"	  where sog.id_domanda_iscrizione = dom.id_domanda_iscrizione and tip.cod_tipo_soggetto = 'RIC'",
						"	) as codice_fiscale_ric,",
						"	(",
						"	  select sog.codice_fiscale from iscritto_t_anagrafica_sog sog ",
						"	    join iscritto_r_soggetto_rel r on sog.id_anagrafica_soggetto = r.id_anagrafica_soggetto",
						"	    join iscritto_d_tipo_sog tip on r.id_tipo_soggetto = tip.id_tipo_soggetto",
						"	  where sog.id_domanda_iscrizione = dom.id_domanda_iscrizione and tip.cod_tipo_soggetto = 'MIN'",
						"	) as codice_fiscale_min,",
						"	(",
						"	  select sd.cod_stato_dom from iscritto_d_stato_dom sd where dom.id_stato_dom = sd.id_stato_dom",
						"	) as cod_stato_dom",
						"  from iscritto_t_domanda_isc dom",
						"  where 1 = 1",
						"    and dom.id_ordine_scuola = (",
						"      select id_ordine_scuola from iscritto_d_ordine_scuola where cod_ordine_scuola = :codOrdineScuola",
						"    )",
						"    and dom.id_stato_dom in (",
						"      select sd.id_stato_dom from iscritto_d_stato_dom sd where sd.cod_stato_dom in ('GRA', 'AMM')",
						"    )",
						") as v1",
						"where 1 = 1",
						"  and v1.cod_anno_scolastico = :codAnnoScolastico",
						"  and upper(v1.codice_fiscale_min) = :codiceFiscaleMin",
						"  and upper(v1.codice_fiscale_ric) = :codiceFiscaleRic")
				.bind("codOrdineScuola", tipoScuola.getCod())
				.bind("codAnnoScolastico", codAnnoScolastico)
				.bind("codiceFiscaleMin", ConvertUtils.toUpper(codiceFiscaleMin))
				.bind("codiceFiscaleRic", ConvertUtils.toUpper(codiceFiscaleRic));

		List<InfoDomandaRow> result = this.query(sh, InfoDomandaRow.class);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public List<InfoDomandaRow> dataCheckDomandaEsistenteForInvio(
			TipoScuola tipoScuola, String codAnnoScolastico, String codiceFiscaleRic, String codiceFiscaleMin) throws DaoException {

		final String methodName = "dataCheckDomandaEsistenteForInvio";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		Validate.notEmpty(codAnnoScolastico);
		Validate.notEmpty(codiceFiscaleRic);
		Validate.notEmpty(codiceFiscaleMin);

		SqlHolder sh = buildSqlHolder()
				.addQueryRows(
						"select * from (",
						"  select",
						"	dom.id_domanda_iscrizione,",
						"	(",
						"	  select anno.cod_anno_scolastico from iscritto_t_anno_sco anno",
						"	  where anno.id_anno_scolastico = dom.id_anno_scolastico",
						"	) as cod_anno_scolastico,",
						"	(",
						"	  select sog.codice_fiscale from iscritto_t_anagrafica_sog sog ",
						"	    join iscritto_r_soggetto_rel r on sog.id_anagrafica_soggetto = r.id_anagrafica_soggetto",
						"	    join iscritto_d_tipo_sog tip on r.id_tipo_soggetto = tip.id_tipo_soggetto",
						"	  where sog.id_domanda_iscrizione = dom.id_domanda_iscrizione and tip.cod_tipo_soggetto = 'RIC'",
						"	) as codice_fiscale_ric,",
						"	(",
						"	  select sog.codice_fiscale from iscritto_t_anagrafica_sog sog ",
						"	    join iscritto_r_soggetto_rel r on sog.id_anagrafica_soggetto = r.id_anagrafica_soggetto",
						"	    join iscritto_d_tipo_sog tip on r.id_tipo_soggetto = tip.id_tipo_soggetto",
						"	  where sog.id_domanda_iscrizione = dom.id_domanda_iscrizione and tip.cod_tipo_soggetto = 'MIN'",
						"	) as codice_fiscale_min,",
						"	(",
						"	  select sd.cod_stato_dom from iscritto_d_stato_dom sd where dom.id_stato_dom = sd.id_stato_dom",
						"	) as cod_stato_dom",
						"  from iscritto_t_domanda_isc dom",
						"  where 1 = 1",
						"    and dom.id_ordine_scuola = (",
						"      select id_ordine_scuola from iscritto_d_ordine_scuola where cod_ordine_scuola = :codOrdineScuola",
						"    )",
						"    and dom.id_stato_dom = (",
						"      select sd.id_stato_dom from iscritto_d_stato_dom sd where sd.cod_stato_dom = 'INV'",
						"    )",
						") as v1",
						"where 1 = 1",
						"  and v1.cod_anno_scolastico = :codAnnoScolastico",
						"  and upper(v1.codice_fiscale_min) = :codiceFiscaleMin",
						"  and upper(v1.codice_fiscale_ric) = :codiceFiscaleRic")
				.bind("codOrdineScuola", tipoScuola.getCod())
				.bind("codAnnoScolastico", codAnnoScolastico)
				.bind("codiceFiscaleMin", ConvertUtils.toUpper(codiceFiscaleMin))
				.bind("codiceFiscaleRic", ConvertUtils.toUpper(codiceFiscaleRic));

		List<InfoDomandaRow> result = this.query(sh, InfoDomandaRow.class);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public List<IscrittoTAnagraficaGra> dataCheckDomandaFuoriPeriodo(TipoScuola tipoScuola, Date data) throws DaoException {
		final String methodName = "dataCheckDomandaFuoriPeriodo";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		SqlHolder sh = buildSqlHolder(IscrittoTAnagraficaGra.SQL_SELECT_ALL)
				.addQueryRows(
						"where 1 = 1",
						"  and id_ordine_scuola = (select id_ordine_scuola from iscritto_d_ordine_scuola where cod_ordine_scuola = :codOrdineScuola)",
						"  and to_date(:data, 'YYYY-MM-DD') >= to_date(to_char(dt_inizio_iscr, 'YYYY-MM-DD'), 'YYYY-MM-DD')",
						"  and to_date(:data, 'YYYY-MM-DD') <= to_date(to_char(dt_fine_iscr,  'YYYY-MM-DD'), 'YYYY-MM-DD')");

		sh.bind("codOrdineScuola", tipoScuola.getCod());
		sh.bind("data", DateUtils.toStringDate(data, ISO_8601_FORMAT));

		List<IscrittoTAnagraficaGra> result = this.query(sh, IscrittoTAnagraficaGra.class);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public List<IscrittoTAnagraficaGra> dataCheckDomandaFuoriTermine(TipoScuola tipoScuola, Date data) throws DaoException {
		final String methodName = "dataCheckDomandaFuoriTermine";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		SqlHolder sh = buildSqlHolder(IscrittoTAnagraficaGra.SQL_SELECT_ALL)
				.addQueryRows(
						"where 1 = 1",
						"  and id_ordine_scuola = (select id_ordine_scuola from iscritto_d_ordine_scuola where cod_ordine_scuola = :codOrdineScuola)",
						"  and to_date(:data, 'YYYY-MM-DD') >= to_date(to_char(dt_inizio_iscr, 'YYYY-MM-DD'), 'YYYY-MM-DD')",
						"  and to_date(:data, 'YYYY-MM-DD') <= to_date(to_char(dt_scadenza_iscr,  'YYYY-MM-DD'), 'YYYY-MM-DD')");

		sh.bind("codOrdineScuola", tipoScuola.getCod());
		sh.bind("data", DateUtils.toStringDate(data, ISO_8601_FORMAT));

		List<IscrittoTAnagraficaGra> result = this.query(sh, IscrittoTAnagraficaGra.class);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public List<IscrittoTEta> dataDataNascitaMinore(TipoScuola tipoScuola, String codAnnoScolastico, Date data) throws DaoException {
		final String methodName = "dataDataNascitaMinore";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		SqlHolder sh = buildSqlHolder()
				.addQueryRows(
						"with dati_eta as (",
						"  select ",
						"    eta.id_eta,",
						"    eta.id_fascia_eta,",
						"    eta.id_anagrafica_gra,",
						"    eta.data_da,",
						"    eta.data_a",
						"  from iscritto_t_anagrafica_gra gra",
						"    join iscritto_t_anno_sco anno on anno.id_anno_scolastico = gra.id_anno_scolastico",
						"    join iscritto_t_eta eta on eta.id_anagrafica_gra = gra.id_anagrafica_gra",
						"    join iscritto_d_ordine_scuola ord on ord.id_ordine_scuola = gra.id_ordine_scuola",
						"  where 1 = 1",
						"    and ord.cod_ordine_scuola = :codOrdineScuola",
						"    and anno.cod_anno_scolastico = :codAnnoScolastico",
						")",
						"select",
						"  de.id_eta,",
						"  de.id_fascia_eta,",
						"  de.id_anagrafica_gra,",
						"  de.data_da,",
						"  de.data_a",
						"from dati_eta de",
						"where 1 = 1",
						"  and to_date(:data, 'YYYY-MM-DD') >= (select min(date_trunc('day', data_da)) from dati_eta)",
						"  and to_date(:data, 'YYYY-MM-DD') <= (select max(date_trunc('day', data_a)) from dati_eta)");

		sh.bind("codOrdineScuola", tipoScuola.getCod());
		sh.bind("codAnnoScolastico", codAnnoScolastico);
		sh.bind("data", DateUtils.toStringDate(data, ISO_8601_FORMAT));

		List<IscrittoTEta> result = this.query(sh, IscrittoTEta.class);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

}
