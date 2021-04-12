package it.csi.iscritto.serviscritto.business.integration.dao.view.impl;

import static it.csi.iscritto.serviscritto.business.util.DateUtils.ISO_8601_FORMAT;
import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.LOG_BEGIN;
import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.LOG_END;
import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.buildMessage;
import static it.csi.iscritto.serviscritto.business.util.converter.ConvertUtils.getFirst;

import java.util.Date;

import org.apache.commons.lang3.Validate;
import org.apache.log4j.Logger;

import it.csi.iscritto.serviscritto.business.integration.dao.AbstractDao;
import it.csi.iscritto.serviscritto.business.integration.dao.TipoScuola;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTAnagraficaGra;
import it.csi.iscritto.serviscritto.business.integration.dao.view.InfoGeneraliDao;
import it.csi.iscritto.serviscritto.business.integration.exception.DaoException;
import it.csi.iscritto.serviscritto.business.util.Constants;
import it.csi.iscritto.serviscritto.business.util.DateUtils;
import it.csi.iscritto.serviscritto.business.util.sql.SqlHolder;

public class InfoGeneraliDaoImpl extends AbstractDao implements InfoGeneraliDao {
	private static final Logger log = Logger.getLogger(Constants.COMPONENT_NAME + ".dao");

	@Override
	public IscrittoTAnagraficaGra findGraduatoriaByDate(TipoScuola tipoScuola, Date data) throws DaoException {
		final String methodName = "findGraduatoriaByDate";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		Validate.notNull(data);

		SqlHolder sh = buildSqlHolder()
				.addQueryRows(
						"select ",
						"  ag.dt_inizio_iscr, ",
						"  ag.dt_scadenza_iscr, ",
						"  ag.dt_fine_iscr",
						"from iscritto_t_anagrafica_gra ag",
						"where 1 = 1",
						"  and ag.id_ordine_scuola = (select id_ordine_scuola from iscritto_d_ordine_scuola where cod_ordine_scuola = :codOrdineScuola)",
						"  and to_date(:data, 'YYYY-MM-DD') >= to_date(to_char(ag.dt_inizio_iscr, 'YYYY-MM-DD'), 'YYYY-MM-DD')",
						"  and to_date(:data, 'YYYY-MM-DD') <= to_date(to_char(ag.dt_fine_iscr,  'YYYY-MM-DD'), 'YYYY-MM-DD')");

		sh.bind("codOrdineScuola", tipoScuola.getCod());
		sh.bind("data", DateUtils.toStringDate(data, ISO_8601_FORMAT));

		IscrittoTAnagraficaGra result = getFirst(this.query(sh, IscrittoTAnagraficaGra.class));

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

}
