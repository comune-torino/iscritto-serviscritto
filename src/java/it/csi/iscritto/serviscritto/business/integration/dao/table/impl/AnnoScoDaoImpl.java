package it.csi.iscritto.serviscritto.business.integration.dao.table.impl;

import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.LOG_BEGIN;
import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.LOG_END;
import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.buildMessage;
import static it.csi.iscritto.serviscritto.business.util.converter.ConvertUtils.getFirst;

import java.util.Date;

import org.apache.log4j.Logger;

import it.csi.iscritto.serviscritto.business.integration.dao.AbstractDao;
import it.csi.iscritto.serviscritto.business.integration.dao.TipoScuola;
import it.csi.iscritto.serviscritto.business.integration.dao.table.AnnoScoDao;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTAnnoSco;
import it.csi.iscritto.serviscritto.business.integration.exception.DaoException;
import it.csi.iscritto.serviscritto.business.util.Constants;
import it.csi.iscritto.serviscritto.business.util.DateUtils;
import it.csi.iscritto.serviscritto.business.util.sql.SqlHolder;

public class AnnoScoDaoImpl extends AbstractDao implements AnnoScoDao {
	private static final Logger log = Logger.getLogger(Constants.COMPONENT_NAME + ".dao");

	@Override
	public IscrittoTAnnoSco findIscrittoTAnnoScoByKey(Long idAnnoScolastico) throws DaoException {
		final String methodName = "findIscrittoTAnnoScoByKey";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		SqlHolder sh = buildSqlHolder(IscrittoTAnnoSco.SQL_SELECT_ALL)
				.addQueryRows(
						"WHERE 1 = 1",
						"  AND id_anno_scolastico = :idAnnoScolastico")
				.bind("idAnnoScolastico", idAnnoScolastico);

		IscrittoTAnnoSco result = getFirst(this.query(sh, IscrittoTAnnoSco.class));

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public IscrittoTAnnoSco findIscrittoTAnnoScoByCod(String codAnnoScolastico) throws DaoException {
		final String methodName = "findIscrittoTAnnoScoByCod";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		SqlHolder sh = buildSqlHolder(IscrittoTAnnoSco.SQL_SELECT_ALL)
				.addQueryRows(
						"WHERE 1 = 1",
						"  AND cod_anno_scolastico = :codAnnoScolastico")
				.bind("codAnnoScolastico", codAnnoScolastico);

		IscrittoTAnnoSco result = getFirst(this.query(sh, IscrittoTAnnoSco.class));

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public IscrittoTAnnoSco findIscrittoTAnnoScoByDate(TipoScuola tipoScuola, Date data) throws DaoException {
		final String methodName = "findIscrittoTAnnoScoByDate";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		SqlHolder sh = buildSqlHolder()
				.addQueryRows(
						"select ",
						"  id_anno_scolastico, ",
						"  cod_anno_scolastico, ",
						"  descrizione, ",
						"  data_da, ",
						"  data_a ",
						"from iscritto_t_anno_sco",
						"where 1 = 1",
						"  and id_anno_scolastico in (",
						"    select gr.id_anno_scolastico",
						"    from iscritto_t_anagrafica_gra gr",
						"    where 1 = 1",
						"      and gr.id_ordine_scuola = (select id_ordine_scuola from iscritto_d_ordine_scuola where cod_ordine_scuola = :codOrdineScuola)",
						"      and to_date(:data, 'YYYY-MM-DD') >= to_date(to_char(gr.dt_inizio_iscr, 'YYYY-MM-DD'), 'YYYY-MM-DD')",
						"      and to_date(:data, 'YYYY-MM-DD') <= to_date(to_char(gr.dt_fine_iscr,  'YYYY-MM-DD'), 'YYYY-MM-DD')",
						"  )")
				.bind("codOrdineScuola", tipoScuola.getCod())
				.bind("data", DateUtils.toStringDate(data, DateUtils.ISO_8601_FORMAT));

		IscrittoTAnnoSco result = getFirst(this.query(sh, IscrittoTAnnoSco.class));

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

}
