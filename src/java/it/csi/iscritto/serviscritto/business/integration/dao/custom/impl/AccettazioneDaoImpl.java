package it.csi.iscritto.serviscritto.business.integration.dao.custom.impl;

import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.LOG_BEGIN;
import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.LOG_END;
import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.buildMessage;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import org.apache.log4j.Logger;

import it.csi.iscritto.serviscritto.business.integration.dao.AbstractDao;
import it.csi.iscritto.serviscritto.business.integration.dao.CategoriaScuola;
import it.csi.iscritto.serviscritto.business.integration.dao.StatoDomanda;
import it.csi.iscritto.serviscritto.business.integration.dao.StatoScuola;
import it.csi.iscritto.serviscritto.business.integration.dao.TipoScuola;
import it.csi.iscritto.serviscritto.business.integration.dao.custom.AccettazioneDao;
import it.csi.iscritto.serviscritto.business.integration.dao.custom.dto.DatiAccettazioneRow;
import it.csi.iscritto.serviscritto.business.integration.dao.custom.dto.RicevutaAccettazioneRow;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoDCategoriaScu;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoRScuolaPre;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTStepGraCon;
import it.csi.iscritto.serviscritto.business.integration.exception.DaoException;
import it.csi.iscritto.serviscritto.business.util.Constants;
import it.csi.iscritto.serviscritto.business.util.LoggingUtils;
import it.csi.iscritto.serviscritto.business.util.converter.ConvertUtils;
import it.csi.iscritto.serviscritto.business.util.sql.SqlHolder;

public class AccettazioneDaoImpl extends AbstractDao implements AccettazioneDao {
	private static final Logger log = Logger.getLogger(Constants.COMPONENT_NAME + ".dao");

	@Override
	public DatiAccettazioneRow findDatiAccettazione(Long idDomanda, String codScuola) throws DaoException {
		final String methodName = "findDatiAccettazione";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		log.info(buildMessage(getClass(), methodName, "idDomanda: " + idDomanda));
		log.info(buildMessage(getClass(), methodName, "codScuola: " + codScuola));

		SqlHolder sh = buildSqlHolder()
				.addQueryRows(
						"select",
						"  dom.id_domanda_iscrizione,",
						"  dom.protocollo,",
						"  dom.data_consegna,",
						"  dom.dt_modifica,",
						"  dom.telefono,",
						"  (",
						"    select",
						"      dtp.cod_tipo_pasto",
						"    from iscritto_t_invio_acc inv_acc",
						"      join iscritto_t_acc_rin acc_rin on acc_rin.id_accettazione_rin = inv_acc.id_accettazione_rin",
						"      join iscritto_d_tipo_pasto dtp on dtp.id_tipo_pasto = inv_acc.id_tipo_pasto",
						"    where",
						"      acc_rin.id_domanda_iscrizione = dom.id_domanda_iscrizione",
						"    order by",
						"      acc_rin.dt_operazione desc",
						"    limit 1",
						"  ) as cod_tipo_pasto,",
						"  (",
						"    select scu.cod_ordine_scuola from iscritto_d_ordine_scuola scu where scu.id_ordine_scuola = dom.id_ordine_scuola",
						"  ) as cod_ordine_scuola,",
						"  (",
						"    select sog.nome from iscritto_t_anagrafica_sog sog ",
						"      join iscritto_r_soggetto_rel r on sog.id_anagrafica_soggetto = r.id_anagrafica_soggetto",
						"      join iscritto_d_tipo_sog tip on r.id_tipo_soggetto = tip.id_tipo_soggetto",
						"    where sog.id_domanda_iscrizione = dom.id_domanda_iscrizione and tip.cod_tipo_soggetto = 'MIN'",
						"  ) as nome_minore,",
						"  (",
						"    select sog.cognome from iscritto_t_anagrafica_sog sog ",
						"      join iscritto_r_soggetto_rel r on sog.id_anagrafica_soggetto = r.id_anagrafica_soggetto",
						"      join iscritto_d_tipo_sog tip on r.id_tipo_soggetto = tip.id_tipo_soggetto",
						"    where sog.id_domanda_iscrizione = dom.id_domanda_iscrizione and tip.cod_tipo_soggetto = 'MIN'",
						"  ) as cognome_minore,",
						"  (",
						"    select sd.cod_stato_dom from iscritto_d_stato_dom sd where sd.id_stato_dom = dom.id_stato_dom",
						"  ) as cod_stato_dom,",
						"  (",
						"    select anno.cod_anno_scolastico from iscritto_t_anno_sco anno",
						"    where anno.id_anno_scolastico = dom.id_anno_scolastico",
						"  ) as cod_anno_scolastico,",
						"  (",
						"	 select isc.fl_irc",
					    "    from iscritto_t_domanda_isc isc",
					    "    join  iscritto_r_scuola_pre pre",
					    "    on isc.id_domanda_iscrizione = pre.id_domanda_iscrizione",
					    "    join iscritto_t_scuola s",
					    "    on pre.id_scuola = s.id_scuola",
					    "    where s.id_categoria_scu != 2",
					    "    and s.cod_scuola = :codScuola",
					    "    and isc.id_domanda_iscrizione = :idDomandaIscrizione",
					    "    limit 1",
						"  ) as irc",
						"from iscritto_t_domanda_isc dom",
						"where dom.id_domanda_iscrizione = :idDomandaIscrizione")
				.bind("idDomandaIscrizione", idDomanda)
				.bind("codScuola", codScuola);


		DatiAccettazioneRow result = ConvertUtils.getFirst(this.query(sh, DatiAccettazioneRow.class));
		//LoggingUtils.stampa(result, true, 3);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public IscrittoRScuolaPre findPreferenza(Long idDomandaIscrizione, String codScuola, String codTipoFrequenza) throws DaoException {
		final String methodName = "findPreferenza";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		log.info(buildMessage(getClass(), methodName, "idDomandaIscrizione: " + idDomandaIscrizione));
		log.info(buildMessage(getClass(), methodName, "codScuola: " + codScuola));
		log.info(buildMessage(getClass(), methodName, "codTipoFrequenza: " + codTipoFrequenza));

		SqlHolder sh = buildSqlHolder(IscrittoRScuolaPre.SQL_SELECT_ALL)
				.addQueryRows(
						"where 1 = 1",
						"  and id_domanda_iscrizione = :idDomandaIscrizione",
						"  and id_scuola = (select scu.id_scuola from iscritto_t_scuola scu where scu.cod_scuola = :codScuola)",
						"  and id_tipo_frequenza = (select fre.id_tipo_frequenza from iscritto_d_tipo_fre fre where fre.cod_tipo_frequenza = :codTipoFrequenza)")
				.bind("idDomandaIscrizione", idDomandaIscrizione)
				.bind("codScuola", codScuola)
				.bind("codTipoFrequenza", codTipoFrequenza);

		IscrittoRScuolaPre result = ConvertUtils.getFirst(this.query(sh, IscrittoRScuolaPre.class));

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public List<IscrittoRScuolaPre> findPreferenzeByCodStatoScuola(Long idDomandaIscrizione, StatoScuola statoScuola) throws DaoException {
		final String methodName = "findPreferenzeByCodStatoScuola";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		log.info(buildMessage(getClass(), methodName, "idDomandaIscrizione: " + idDomandaIscrizione));
		log.info(buildMessage(getClass(), methodName, "statoScuola: " + statoScuola));

		SqlHolder sh = buildSqlHolder(IscrittoRScuolaPre.SQL_SELECT_ALL)
				.addQueryRows(
						"where 1 = 1",
						"  and id_domanda_iscrizione = :idDomandaIscrizione",
						"  and id_stato_scu = (select ds.id_stato_scu from iscritto_d_stato_scu ds where ds.cod_stato_scu = :codStatoScuola)")
				.bind("idDomandaIscrizione", idDomandaIscrizione)
				.bind("codStatoScuola", statoScuola.getCod());

		List<IscrittoRScuolaPre> result = this.query(sh, IscrittoRScuolaPre.class);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public List<IscrittoRScuolaPre> findPreferenzeByIdDomanda(Long idDomandaIscrizione) throws DaoException {
		final String methodName = "findPreferenzeByIdDomanda";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		log.info(buildMessage(getClass(), methodName, "idDomandaIscrizione: " + idDomandaIscrizione));

		SqlHolder sh = buildSqlHolder(IscrittoRScuolaPre.SQL_SELECT_ALL)
				.addQueryRows(
						"where 1 = 1",
						"  and id_domanda_iscrizione = :idDomandaIscrizione")
				.bind("idDomandaIscrizione", idDomandaIscrizione);

		List<IscrittoRScuolaPre> result = this.query(sh, IscrittoRScuolaPre.class);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public Long findStepGraduatoria(Long idDomandaIscrizione) throws DaoException {
		final String methodName = "findStepGraduatoria";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		log.info(buildMessage(getClass(), methodName, "idDomandaIscrizione: " + idDomandaIscrizione));

		SqlHolder sh = buildSqlHolder()
				.addQueryRows(
						"select",
						"  sgc.id_step_gra_con",
						"from iscritto_t_step_gra_con sgc ",
						"  join iscritto_t_step_gra sg on sg.id_step_gra = sgc.id_step_gra",
						"  join iscritto_t_anagrafica_gra gra on gra.id_anagrafica_gra = sg.id_anagrafica_gra",
						"  join iscritto_t_domanda_isc dom on dom.id_anno_scolastico = gra.id_anno_scolastico and dom.id_ordine_scuola = gra.id_ordine_scuola",
						"where 1 = 1",
						"  and dom.id_domanda_iscrizione = :idDomandaIscrizione",
						"order by sgc.id_step_gra_con desc",
						"limit 1")
				.bind("idDomandaIscrizione", idDomandaIscrizione);

		IscrittoTStepGraCon row = ConvertUtils.getFirst(this.query(sh, IscrittoTStepGraCon.class));
		Long result = null;
		if (row != null) {
			result = row.getIdStepGraCon();
		}

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public boolean isTipoPastoObbligatorio(TipoScuola tipoScuola, String codScuola) throws DaoException {
		final String methodName = "isTipoPastoObbligatorio";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		log.info(buildMessage(getClass(), methodName, "tipoScuola: " + tipoScuola));
		log.info(buildMessage(getClass(), methodName, "codScuola: " + codScuola));

		Validate.notNull(tipoScuola);

		SqlHolder sh = buildSqlHolder()
				.addQueryRows(
						"select",
						"  cat.id_categoria_scu,",
						"  cat.codice_categoria_scu,",
						"  cat.descrizione",
						"from iscritto_t_scuola scu",
						"  join iscritto_d_ordine_scuola ord on ord.id_ordine_scuola = scu.id_ordine_scuola",
						"  join iscritto_d_categoria_scu cat on cat.id_categoria_scu = scu.id_categoria_scu",
						"where 1 = 1",
						"  and ord.cod_ordine_scuola = :codOrdineScuola",
						"  and scu.cod_scuola = :codScuola")
				.bind("codOrdineScuola", tipoScuola.getCod())
				.bind("codScuola", codScuola);

		IscrittoDCategoriaScu row = ConvertUtils.getFirst(this.query(sh, IscrittoDCategoriaScu.class));
		String codCatScu = row == null ? null : row.getCodiceCategoriaScu();

		boolean result;
		switch (tipoScuola) {
			case NID:
				result = CategoriaScuola.M.getCod().equalsIgnoreCase(codCatScu)
						|| CategoriaScuola.A.getCod().equalsIgnoreCase(codCatScu);
				break;
			case MAT:
				result = CategoriaScuola.M.getCod().equalsIgnoreCase(codCatScu)
						|| CategoriaScuola.S.getCod().equalsIgnoreCase(codCatScu);
				break;
			default:
				throw new UnsupportedOperationException();
		}

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public RicevutaAccettazioneRow findRicevutaAccettazione(Long idDomandaIscrizione) throws DaoException {
		final String methodName = "findRicevutaAccettazione";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		log.info(buildMessage(getClass(), methodName, "idDomandaIscrizione: " + idDomandaIscrizione));

		SqlHolder sh = buildSqlHolder()
				.addQueryRows(
						"with",
						"dati_minore as (",
						"  select",
						"    sog.nome,",
						"    sog.cognome,",
						"    sog.codice_fiscale,",
						"    sog.data_nascita",
						"  from iscritto_t_anagrafica_sog sog ",
						"    join iscritto_r_soggetto_rel r on sog.id_anagrafica_soggetto = r.id_anagrafica_soggetto",
						"    join iscritto_d_tipo_sog tip on r.id_tipo_soggetto = tip.id_tipo_soggetto",
						"  where",
						"    tip.cod_tipo_soggetto = 'MIN' and",
						"    sog.id_domanda_iscrizione = :idDomandaIscrizione",
						"  limit 1",
						")",
						"select",
						"  (",
						"    select nome from dati_minore",
						"  ) as nome_minore,",
						"  (",
						"    select cognome from dati_minore",
						"  ) as cognome_minore,",
						"  anno.cod_anno_scolastico,",
						"  dom.id_domanda_iscrizione,",
						"  dom.protocollo,",
						"  dom.data_consegna,",
						"  ar.dt_operazione,",
						"  scu.cod_scuola,",
						"  scu.descrizione as desc_scuola,",
						"  scu.indirizzo as indirizzo_scuola,",
						"  cat.codice_categoria_scu,",
						"  ord.cod_ordine_scuola,",
						"  fre.cod_tipo_frequenza,",
						"  fre.descrizione as desc_tipo_frequenza,",
						"  tp.cod_tipo_pasto,",
						"  tp.descrizione as desc_tipo_pasto",
						"from iscritto_t_domanda_isc dom",
						"  join iscritto_t_anno_sco anno on anno.id_anno_scolastico = dom.id_anno_scolastico",
						"  join iscritto_t_acc_rin ar on ar.id_domanda_iscrizione = dom.id_domanda_iscrizione",
						"  join iscritto_t_scuola scu on scu.id_scuola = ar.id_scuola",
						"  join iscritto_d_ordine_scuola ord on ord.id_ordine_scuola = scu.id_ordine_scuola",
						"  join iscritto_d_categoria_scu cat on cat.id_categoria_scu = scu.id_categoria_scu",
						"  join iscritto_d_tipo_fre fre on fre.id_tipo_frequenza = ar.id_tipo_frequenza",
						"  join iscritto_t_invio_acc ia on ia.id_accettazione_rin = ar.id_accettazione_rin",
						"  left join iscritto_d_tipo_pasto tp on tp.id_tipo_pasto = ia.id_tipo_pasto",
						"where 1 = 1",
						"  and dom.id_domanda_iscrizione = :idDomandaIscrizione",
						"  and ar.fl_a_r = 'A'",
						"order by",
						"  ar.dt_operazione desc")
				.bind("idDomandaIscrizione", idDomandaIscrizione);

		RicevutaAccettazioneRow result = ConvertUtils.getFirst(this.query(sh, RicevutaAccettazioneRow.class));

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	//////////////////////////////////////////////////////////////////////

	@Override
	public Integer modificaPreferenza(Long idDomandaIscrizione, String codScuola, String codTipoFrequenza, StatoScuola statoScuola) throws DaoException {
		final String methodName = "modificaPreferenza";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		log.info(buildMessage(getClass(), methodName, "idDomandaIscrizione: " + idDomandaIscrizione));
		log.info(buildMessage(getClass(), methodName, "codScuola: " + codScuola));
		log.info(buildMessage(getClass(), methodName, "codTipoFrequenza: " + codTipoFrequenza));
		log.info(buildMessage(getClass(), methodName, "statoScuola: " + statoScuola));

		Validate.notNull(idDomandaIscrizione);
		Validate.notBlank(codScuola);
		Validate.notBlank(codTipoFrequenza);
		Validate.notNull(statoScuola);

		SqlHolder sh = buildSqlHolder()
				.addQueryRows(
						"update iscritto_r_scuola_pre set",
						"  id_stato_scu = (select ds.id_stato_scu from iscritto_d_stato_scu ds where ds.cod_stato_scu = :codStatoScuola),",
						"  dt_stato = now()",
						"where 1 = 1",
						"  and id_domanda_iscrizione = :idDomandaIscrizione",
						"  and id_scuola = (select scu.id_scuola from iscritto_t_scuola scu where scu.cod_scuola = :codScuola)",
						"  and id_tipo_frequenza = (select fre.id_tipo_frequenza from iscritto_d_tipo_fre fre where fre.cod_tipo_frequenza = :codTipoFrequenza)",
						"  and id_stato_scu in (select ds.id_stato_scu from iscritto_d_stato_scu ds where ds.cod_stato_scu in ('AMM'))")
				.bind("idDomandaIscrizione", idDomandaIscrizione)
				.bind("codScuola", codScuola)
				.bind("codTipoFrequenza", codTipoFrequenza)
				.bind("codStatoScuola", statoScuola.getCod());

		Integer result = this.update(sh);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public Integer modificaPostiPerAccettazione(
			TipoScuola tipoScuola, Long idDomandaIscrizione, String codScuola, String codTipoFrequenza) throws DaoException {

		final String methodName = "modificaPostiPerAccettazione";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		log.info(buildMessage(getClass(), methodName, "tipoScuola: " + tipoScuola));
		log.info(buildMessage(getClass(), methodName, "idDomandaIscrizione: " + idDomandaIscrizione));
		log.info(buildMessage(getClass(), methodName, "codScuola: " + codScuola));
		log.info(buildMessage(getClass(), methodName, "codTipoFrequenza: " + codTipoFrequenza));

		Validate.notNull(idDomandaIscrizione);
		Validate.notBlank(codScuola);
		Validate.notBlank(codTipoFrequenza);
		Validate.notBlank(tipoScuola.getCod());

		SqlHolder sh = buildSqlHolder()
				.addQueryRows(
						"update iscritto_t_classe set",
						"  posti_ammessi = posti_ammessi - 1",
						"where 1 = 1",
						"  and posti_ammessi > 0",
						"  and id_scuola = (",
						"    select scu.id_scuola from iscritto_t_scuola scu",
						"    where 1 = 1",
						"      and scu.cod_scuola = :codScuola",
						"      and scu.id_ordine_scuola = (",
						"        select os.id_ordine_scuola from iscritto_d_ordine_scuola os where os.cod_ordine_scuola = :codOrdineScuola",
						"      )",
						"  )",
						"  and id_anno_scolastico = (",
						"    select dom.id_anno_scolastico from iscritto_t_domanda_isc dom where dom.id_domanda_iscrizione = :idDomandaIscrizione",
						"  )",
						"  and id_tipo_frequenza = (",
						"    select tf.id_tipo_frequenza from iscritto_d_tipo_fre tf where tf.cod_tipo_frequenza = :codTipoFrequenza",
						"  )",
						"  and id_eta = (",
						"    select eta.id_eta",
						"    from  iscritto_t_domanda_isc      domIsc",
						"        , iscritto_t_anno_sco         annoSco",
						"        , iscritto_d_ordine_scuola    ordScu",
						"        , iscritto_t_anagrafica_gra   anagGra",
						"        , iscritto_t_graduatoria gra",
						"        , iscritto_t_eta              eta",
						"        , iscritto_t_anagrafica_sog   anagSog",
						"        , iscritto_r_soggetto_rel     sogRel",
						"        , iscritto_d_tipo_sog         tipoSog",
						"    where domIsc.id_anno_scolastico = annoSco.id_anno_scolastico",
						"      and domIsc.id_ordine_scuola = ordScu.id_ordine_scuola",
						"      and annoSco.id_anno_scolastico = anagGra.id_anno_scolastico",
						"      and ordScu.id_ordine_scuola = anagGra.id_ordine_scuola",
						"      and anagGra.id_anagrafica_gra = eta.id_anagrafica_gra",
						"      and gra.id_domanda_iscrizione=domIsc.id_domanda_iscrizione",
						"      and gra.id_stato_scu= getidstatoscuola('AMM')",
						"      and gra.id_step_gra_con=getstepincorso(ordScu.cod_ordine_scuola)",
						"      and gra.id_fascia_eta=eta.id_fascia_eta",
						"      and domIsc.id_domanda_iscrizione = anagSog.id_domanda_iscrizione",
						"      and anagSog.id_anagrafica_soggetto = sogRel.id_anagrafica_soggetto",
						"      and sogRel.id_tipo_soggetto = tipoSog.id_tipo_soggetto",
						"      and domIsc.id_domanda_iscrizione = :idDomandaIscrizione",
						"      and tipoSog.cod_tipo_soggetto = 'MIN'",
						"      and anagSog.data_nascita between eta.data_da and eta.data_a",
						"  )")
				.bind("idDomandaIscrizione", idDomandaIscrizione)
				.bind("codOrdineScuola", tipoScuola.getCod())
				.bind("codScuola", codScuola)
				.bind("codTipoFrequenza", codTipoFrequenza);

		Integer result = this.update(sh);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public Integer modificaPostiPerRifiuto(
			TipoScuola tipoScuola, Long idDomandaIscrizione, String codScuola, String codTipoFrequenza) throws DaoException {

		final String methodName = "modificaPostiPerRifiuto";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		log.info(buildMessage(getClass(), methodName, "tipoScuola: " + tipoScuola));
		log.info(buildMessage(getClass(), methodName, "idDomandaIscrizione: " + idDomandaIscrizione));
		log.info(buildMessage(getClass(), methodName, "codScuola: " + codScuola));
		log.info(buildMessage(getClass(), methodName, "codTipoFrequenza: " + codTipoFrequenza));

		Validate.notNull(idDomandaIscrizione);
		Validate.notBlank(codScuola);
		Validate.notBlank(codTipoFrequenza);
		Validate.notBlank(tipoScuola.getCod());

		SqlHolder sh = buildSqlHolder()
				.addQueryRows(
						"update iscritto_t_classe set",
						"  posti_ammessi = posti_ammessi - 1,",
						"  posti_liberi = posti_liberi + 1",
						"where 1 = 1",
						"  and posti_ammessi > 0",
						"  and id_scuola = (",
						"    select scu.id_scuola from iscritto_t_scuola scu",
						"    where 1 = 1",
						"      and scu.cod_scuola = :codScuola",
						"      and scu.id_ordine_scuola = (",
						"        select os.id_ordine_scuola from iscritto_d_ordine_scuola os where os.cod_ordine_scuola = :codOrdineScuola",
						"      )",
						"  )",
						"  and id_anno_scolastico = (",
						"    select dom.id_anno_scolastico from iscritto_t_domanda_isc dom where dom.id_domanda_iscrizione = :idDomandaIscrizione",
						"  )",
						"  and id_tipo_frequenza = (",
						"    select tf.id_tipo_frequenza from iscritto_d_tipo_fre tf where tf.cod_tipo_frequenza = :codTipoFrequenza",
						"  )",
						"  and id_eta = (",
						"    select eta.id_eta",
						"    from  iscritto_t_domanda_isc      domIsc",
						"        , iscritto_t_anno_sco         annoSco",
						"        , iscritto_d_ordine_scuola    ordScu",
						"        , iscritto_t_anagrafica_gra   anagGra",
						"        , iscritto_t_graduatoria gra",
						"        , iscritto_t_eta              eta",
						"        , iscritto_t_anagrafica_sog   anagSog",
						"        , iscritto_r_soggetto_rel     sogRel",
						"        , iscritto_d_tipo_sog         tipoSog",
						"    where domIsc.id_anno_scolastico = annoSco.id_anno_scolastico",
						"      and domIsc.id_ordine_scuola = ordScu.id_ordine_scuola",
						"      and annoSco.id_anno_scolastico = anagGra.id_anno_scolastico",
						"      and gra.id_domanda_iscrizione=domIsc.id_domanda_iscrizione",
						"      and gra.id_stato_scu= getidstatoscuola('AMM')",
						"      and gra.id_step_gra_con=getstepincorso(ordScu.cod_ordine_scuola)",
						"      and gra.id_fascia_eta=eta.id_fascia_eta",
						"      and ordScu.id_ordine_scuola = anagGra.id_ordine_scuola",
						"      and anagGra.id_anagrafica_gra = eta.id_anagrafica_gra",
						"      and domIsc.id_domanda_iscrizione = anagSog.id_domanda_iscrizione",
						"      and anagSog.id_anagrafica_soggetto = sogRel.id_anagrafica_soggetto",
						"      and sogRel.id_tipo_soggetto = tipoSog.id_tipo_soggetto",
						"      and domIsc.id_domanda_iscrizione = :idDomandaIscrizione",
						"      and tipoSog.cod_tipo_soggetto = 'MIN'",
						"      and anagSog.data_nascita between eta.data_da and eta.data_a",
						"  )")
				.bind("idDomandaIscrizione", idDomandaIscrizione)
				.bind("codOrdineScuola", tipoScuola.getCod())
				.bind("codScuola", codScuola)
				.bind("codTipoFrequenza", codTipoFrequenza);

		Integer result = this.update(sh);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public Integer modificaAltrePreferenze(Long idDomandaIscrizione, StatoScuola statoScuola) throws DaoException {
		final String methodName = "modificaAltrePreferenze";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		log.info(buildMessage(getClass(), methodName, "idDomandaIscrizione: " + idDomandaIscrizione));
		log.info(buildMessage(getClass(), methodName, "statoScuola: " + statoScuola));

		Validate.notNull(idDomandaIscrizione);
		Validate.notNull(statoScuola);

		SqlHolder sh = buildSqlHolder()
				.addQueryRows(
						"update iscritto_r_scuola_pre set",
						"  id_stato_scu = (select ds.id_stato_scu from iscritto_d_stato_scu ds where ds.cod_stato_scu = :codStatoScuola),",
						"  dt_stato = now()",
						"where 1 = 1",
						"  and id_domanda_iscrizione = :idDomandaIscrizione",
						"  and id_stato_scu in (select ds.id_stato_scu from iscritto_d_stato_scu ds where ds.cod_stato_scu in ('PEN'))")
				.bind("idDomandaIscrizione", idDomandaIscrizione)
				.bind("codStatoScuola", statoScuola.getCod());

		Integer result = this.update(sh);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public Integer modificaStatoDomanda(Long idDomandaIscrizione, StatoDomanda statoDomanda) throws DaoException {
		final String methodName = "modificaStatoDomanda";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		log.info(buildMessage(getClass(), methodName, "idDomandaIscrizione: " + idDomandaIscrizione));
		log.info(buildMessage(getClass(), methodName, "statoDomanda: " + statoDomanda));

		Validate.notNull(idDomandaIscrizione);
		Validate.notNull(statoDomanda);

		final SqlHolder sh = buildSqlHolder()
				.addQueryRows(
						"update iscritto_t_domanda_isc set",
						"  id_stato_dom = (select sd.id_stato_dom from iscritto_d_stato_dom sd where sd.cod_stato_dom = :codStatoDom)",
						"where id_domanda_iscrizione = :idDomandaIscrizione")
				.bind("idDomandaIscrizione", idDomandaIscrizione)
				.bind("codStatoDom", statoDomanda.getCod());

		Integer result = this.update(sh);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public Integer modificaStatoGraduatoria(
			Long idDomandaIscrizione, String codScuola, String codTipoFrequenza, StatoScuola statoScuola) throws DaoException {

		final String methodName = "modificaStatoGraduatoria";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		log.info(buildMessage(getClass(), methodName, "idDomandaIscrizione: " + idDomandaIscrizione));
		log.info(buildMessage(getClass(), methodName, "codScuola: " + codScuola));
		log.info(buildMessage(getClass(), methodName, "codTipoFrequenza: " + codTipoFrequenza));
		log.info(buildMessage(getClass(), methodName, "statoScuola: " + statoScuola));

		Validate.notNull(idDomandaIscrizione);
		Validate.notBlank(codScuola);
		Validate.notBlank(codTipoFrequenza);
		Validate.notNull(statoScuola);

		Long idStepGraCon = this.findStepGraduatoria(idDomandaIscrizione);
		log.info(buildMessage(getClass(), methodName, "idStepGraCon: " + idStepGraCon));

		Validate.notNull(idStepGraCon);

		SqlHolder sh = buildSqlHolder()
				.addQueryRows(
						"update iscritto_t_graduatoria set",
						"  id_stato_scu = (select ds.id_stato_scu from iscritto_d_stato_scu ds where ds.cod_stato_scu = :codStatoScuola)",
						"where 1 = 1",
						"  and id_domanda_iscrizione = :idDomandaIscrizione",
						"  and id_scuola = (select scu.id_scuola from iscritto_t_scuola scu where scu.cod_scuola = :codScuola)",
						"  and id_tipo_frequenza = (select fre.id_tipo_frequenza from iscritto_d_tipo_fre fre where fre.cod_tipo_frequenza = :codTipoFrequenza)",
						"  and id_step_gra_con = :idStepGraCon")
				.bind("idDomandaIscrizione", idDomandaIscrizione)
				.bind("codScuola", codScuola)
				.bind("codTipoFrequenza", codTipoFrequenza)
				.bind("codStatoScuola", statoScuola.getCod())
				.bind("idStepGraCon", idStepGraCon);

		Integer result = this.update(sh);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public Integer modificaStatoAltreGraduatorie(Long idDomandaIscrizione, StatoScuola statoScuola) throws DaoException {
		final String methodName = "modificaStatoAltreGraduatorie";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		log.info(buildMessage(getClass(), methodName, "idDomandaIscrizione: " + idDomandaIscrizione));
		log.info(buildMessage(getClass(), methodName, "statoScuola: " + statoScuola));

		Validate.notNull(idDomandaIscrizione);
		Validate.notNull(statoScuola);

		Long idStepGraCon = this.findStepGraduatoria(idDomandaIscrizione);
		log.info(buildMessage(getClass(), methodName, "idStepGraCon: " + idStepGraCon));

		Validate.notNull(idStepGraCon);

		SqlHolder sh = buildSqlHolder()
				.addQueryRows(
						"update iscritto_t_graduatoria set",
						"  id_stato_scu = (select ds.id_stato_scu from iscritto_d_stato_scu ds where ds.cod_stato_scu = :codStatoScuola)",
						"where 1 = 1",
						"  and id_domanda_iscrizione = :idDomandaIscrizione",
						"  and id_step_gra_con = :idStepGraCon",
						"  and id_stato_scu in (select ds.id_stato_scu from iscritto_d_stato_scu ds where ds.cod_stato_scu in ('PEN'))")
				.bind("idDomandaIscrizione", idDomandaIscrizione)
				.bind("codStatoScuola", statoScuola.getCod())
				.bind("idStepGraCon", idStepGraCon);

		Integer result = this.update(sh);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public Integer modificaTelRichiedente(Long idDomandaIscrizione, String telRichiedente) throws DaoException {
		final String methodName = "modificaTelRichiedente";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		log.info(buildMessage(getClass(), methodName, "idDomandaIscrizione: " + idDomandaIscrizione));

		Validate.notNull(idDomandaIscrizione);

		final SqlHolder sh = buildSqlHolder()
				.addQueryRows(
						"update iscritto_t_domanda_isc set",
						"  telefono = :telRichiedente",
						"where id_domanda_iscrizione = :idDomandaIscrizione")
				.bind("idDomandaIscrizione", idDomandaIscrizione)
				.bind("telRichiedente", telRichiedente);

		Integer result = this.update(sh);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	public Long insertOperazione(
			Long idDomandaIscrizione, String cfOperatore, String codScuola, String codTipoFrequenza, boolean isAccettazione) throws DaoException {

		final String methodName = "insertOperazione";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		log.info(buildMessage(getClass(), methodName, "idDomandaIscrizione: " + idDomandaIscrizione));
		log.info(buildMessage(getClass(), methodName, "cfOperatore: " + cfOperatore));
		log.info(buildMessage(getClass(), methodName, "codScuola: " + codScuola));
		log.info(buildMessage(getClass(), methodName, "codTipoFrequenza: " + codTipoFrequenza));
		log.info(buildMessage(getClass(), methodName, "isAccettazione: " + isAccettazione));

		Validate.notNull(idDomandaIscrizione);
		Validate.notBlank(codScuola);
		Validate.notBlank(codTipoFrequenza);

		final Long idAccettazioneRin = this.nextval("iscritto_t_acc_rin_id_accettazione_rin");

		final SqlHolder sh = buildSqlHolder()
				.addQueryRows(
						"insert into iscritto_t_acc_rin (",
						"  id_accettazione_rin,",
						"  id_utente,",
						"  id_domanda_iscrizione,",
						"  id_scuola,",
						"  dt_operazione,",
						"  fl_a_r,",
						"  fl_auto,",
						"  id_tipo_frequenza",
						")",
						"values (",
						"  :idAccettazioneRin,",
						StringUtils.isBlank(cfOperatore)
								? "  NULL,"
								: "  (select ut.id_utente from iscritto_t_utente ut where ut.codice_fiscale = :cfOperatore),",
						"  :idDomandaIscrizione,",
						"  (select scu.id_scuola from iscritto_t_scuola scu where scu.cod_scuola = :codScuola),",
						"  now(),",
						"  :flagAR,",
						"  'N',",
						"  (select fre.id_tipo_frequenza from iscritto_d_tipo_fre fre where fre.cod_tipo_frequenza = :codTipoFrequenza)",
						")")
				.bind("idAccettazioneRin", idAccettazioneRin)
				.bind("cfOperatore", cfOperatore)
				.bind("idDomandaIscrizione", idDomandaIscrizione)
				.bind("codScuola", codScuola)
				.bind("flagAR", isAccettazione ? "A" : "R")
				.bind("codTipoFrequenza", codTipoFrequenza);

		this.update(sh);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return idAccettazioneRin;
	}

	@Override
	public Integer insertInvioAccettazione(Long idAccettazioneRin, String telRichiedente, String codTipoPasto) throws DaoException {
		final String methodName = "insertInvioAccettazione";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		log.info(buildMessage(getClass(), methodName, "idAccettazioneRin: " + idAccettazioneRin));
		log.info(buildMessage(getClass(), methodName, "codTipoPasto: " + codTipoPasto));

		Validate.notNull(idAccettazioneRin);
		Validate.notBlank(telRichiedente);

		final SqlHolder sh = buildSqlHolder()
				.addQueryRows(
						"insert into iscritto_t_invio_acc (",
						"  id_accettazione_rin,",
						"  telefono,",
						"  id_tipo_pasto,",
						"  dt_invio_sise,",
						"  dt_invio_scuola",
						")",
						"values (",
						"  :idAccettazioneRin,",
						"  :telefono,",
						StringUtils.isBlank(codTipoPasto)
								? "  NULL,"
								: "  (select dtp.id_tipo_pasto from iscritto_d_tipo_pasto dtp where dtp.cod_tipo_pasto = :codTipoPasto),",
						"  NULL,",
						"  NULL",
						")")
				.bind("idAccettazioneRin", idAccettazioneRin)
				.bind("telefono", telRichiedente)
				.bind("codTipoPasto", codTipoPasto);

		Integer result = this.update(sh);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public Integer insertPreferenzaFuoriTermine(TipoScuola tipoScuola, Long idDomanda, String codScuola, String codTipoFrequenza) throws DaoException {
		final String methodName = "insertPreferenzaFuoriTermine";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		log.info(buildMessage(getClass(), methodName, "tipoScuola: " + tipoScuola));
		log.info(buildMessage(getClass(), methodName, "idDomanda: " + idDomanda));
		log.info(buildMessage(getClass(), methodName, "codScuola: " + codScuola));
		log.info(buildMessage(getClass(), methodName, "codTipoFrequenza: " + codTipoFrequenza));

		Validate.notNull(tipoScuola);
		Validate.notNull(idDomanda);
		Validate.notBlank(codScuola);
		Validate.notBlank(codTipoFrequenza);

		final SqlHolder sh = buildSqlHolder()
				.addQueryRows(
						"insert into iscritto_r_scuola_pre (",
						"  posizione,",
						"  id_domanda_iscrizione,",
						"  id_scuola,",
						"  fl_fuori_termine,",
						"  id_tipo_frequenza,",
						"  punteggio,",
						"  fl_rinuncia,",
						"  id_stato_scu,",
						"  dt_stato,",
						"  dt_ins_scu",
						")",
						"values (",
						"  (select max(posizione) + 1 as nuova_posizione from iscritto_r_scuola_pre where id_domanda_iscrizione = :idDomandaIscrizione),",
						"  :idDomandaIscrizione,",
						"  (",
						"select scu.id_scuola",
						"    from iscritto_t_scuola scu",
						"      join iscritto_d_ordine_scuola ord on ord.id_ordine_scuola = scu.id_ordine_scuola",
						"    where ord.cod_ordine_scuola = :codOrdineScuola and scu.cod_scuola = :codScuola",
						"  ),",
						"  'S',",
						"  (select fre.id_tipo_frequenza from iscritto_d_tipo_fre fre where fre.cod_tipo_frequenza = :codTipoFrequenza),",
						"  NULL,",
						"  'N',",
						"  NULL,",
						"  NULL,",
						"  now()",
						")")
				.bind("idDomandaIscrizione", idDomanda)
				.bind("codScuola", codScuola)
				.bind("codOrdineScuola", tipoScuola.getCod())
				.bind("codTipoFrequenza", codTipoFrequenza);

		Integer result = this.update(sh);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

}
