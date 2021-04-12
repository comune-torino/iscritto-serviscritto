package it.csi.iscritto.serviscritto.business.integration.dao.custom.impl;

import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.LOG_BEGIN;
import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.LOG_END;
import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.buildMessage;

import org.apache.log4j.Logger;

import it.csi.iscritto.serviscritto.business.integration.dao.AbstractDao;
import it.csi.iscritto.serviscritto.business.integration.dao.custom.RicevutaAllegatoDao;
import it.csi.iscritto.serviscritto.business.integration.dao.custom.dto.RicevutaAllegatoRow;
import it.csi.iscritto.serviscritto.business.integration.exception.DaoException;
import it.csi.iscritto.serviscritto.business.util.Constants;
import it.csi.iscritto.serviscritto.business.util.converter.ConvertUtils;
import it.csi.iscritto.serviscritto.business.util.sql.SqlHolder;

public class RicevutaAllegatoDaoImpl extends AbstractDao implements RicevutaAllegatoDao {
	private static final Logger log = Logger.getLogger(Constants.COMPONENT_NAME + ".dao");

	@Override
	public RicevutaAllegatoRow buildRicevutaAllegato(Long idAllegato) throws DaoException {
		final String methodName = "buildRicevutaAllegato";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));
		log.debug(buildMessage(getClass(), methodName, "idAllegato: " + idAllegato));

		SqlHolder sh = buildSqlHolder()
				.addQueryRows(
						"select",
						"  ord.cod_ordine_scuola as cod_ordine_scuola,",
						"  anno.cod_anno_scolastico as cod_anno_scolastico,",
						"  dom.protocollo as protocollo_domanda,",
						"  (",
						"    select sog.cognome from iscritto_t_anagrafica_sog sog ",
						"      join iscritto_r_soggetto_rel r on sog.id_anagrafica_soggetto = r.id_anagrafica_soggetto",
						"      join iscritto_d_tipo_sog tip on r.id_tipo_soggetto = tip.id_tipo_soggetto",
						"    where sog.id_domanda_iscrizione = dom.id_domanda_iscrizione and tip.cod_tipo_soggetto = 'MIN'",
						"  ) as cognome_minore,",
						"  (",
						"    select sog.nome from iscritto_t_anagrafica_sog sog ",
						"      join iscritto_r_soggetto_rel r on sog.id_anagrafica_soggetto = r.id_anagrafica_soggetto",
						"      join iscritto_d_tipo_sog tip on r.id_tipo_soggetto = tip.id_tipo_soggetto",
						"    where sog.id_domanda_iscrizione = dom.id_domanda_iscrizione and tip.cod_tipo_soggetto = 'MIN'",
						"  ) as nome_minore,",
						"  tal.descrizione as desc_tipo_allegato,",
						"  al.protocollo as protocollo_allegato,",
						"  al.nome_file as nome_file,",
						"  now() as data_operazione",
						"from iscritto_t_allegato al",
						"  join iscritto_t_anagrafica_sog sog on sog.id_anagrafica_soggetto = al.id_anagrafica_soggetto",
						"  join iscritto_t_domanda_isc dom on dom.id_domanda_iscrizione = sog.id_domanda_iscrizione",
						"  join iscritto_d_ordine_scuola ord on ord.id_ordine_scuola = dom.id_ordine_scuola",
						"  join iscritto_t_anno_sco anno on anno.id_anno_scolastico = dom.id_anno_scolastico",
						"  join iscritto_d_tipo_all tal on tal.id_tipo_allegato = al.id_tipo_allegato",
						"where",
						"  al.id_allegato = :idAllegato")
				.bind("idAllegato", idAllegato);

		RicevutaAllegatoRow result = ConvertUtils.getFirst(this.query(sh, RicevutaAllegatoRow.class));

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

}
