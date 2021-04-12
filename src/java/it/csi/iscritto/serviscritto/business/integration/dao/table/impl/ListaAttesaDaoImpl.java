package it.csi.iscritto.serviscritto.business.integration.dao.table.impl;

import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.LOG_BEGIN;
import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.LOG_END;
import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.buildMessage;

import java.util.List;

import org.apache.commons.lang3.Validate;
import org.apache.log4j.Logger;

import it.csi.iscritto.serviscritto.business.integration.dao.AbstractDao;
import it.csi.iscritto.serviscritto.business.integration.dao.table.ListaAttesaDao;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoRListaAttesa;
import it.csi.iscritto.serviscritto.business.integration.exception.DaoException;
import it.csi.iscritto.serviscritto.business.util.Constants;
import it.csi.iscritto.serviscritto.business.util.sql.SqlHolder;

public class ListaAttesaDaoImpl extends AbstractDao implements ListaAttesaDao {
	private static final Logger log = Logger.getLogger(Constants.COMPONENT_NAME + ".dao");

	@Override
	public List<IscrittoRListaAttesa> findIscrittoRListaAttesaByIdDomanda(Long idDomandaIsc) throws DaoException {
		final String methodName = "findIscrittoRListaAttesaByIdDomanda";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		SqlHolder sh = buildSqlHolder()
				.addQueryRows(
						"select",
						"  rla.id_domanda_isc,",
						"  rla.id_anno_scolastico,",
						"  rla.scuola_lista",
						"from iscritto_r_lista_attesa rla",
						"  join iscritto_t_anno_sco anno on anno.id_anno_scolastico = rla.id_anno_scolastico",
						"where",
						"  rla.id_domanda_isc = :idDomandaIsc",
						"order by",
						"  anno.cod_anno_scolastico desc")
				.bind("idDomandaIsc", idDomandaIsc);

		List<IscrittoRListaAttesa> result = this.query(sh, IscrittoRListaAttesa.class);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	//////////////////////////////////////////////////////////////////////

	@Override
	public void insertIscrittoRListaAttesa(IscrittoRListaAttesa row) throws DaoException {
		final String methodName = "insertIscrittoRListaAttesa";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		Validate.notNull(row);

		log.info(buildMessage(getClass(), methodName, "idDomandaIsc: " + row.getIdDomandaIsc()));
		log.info(buildMessage(getClass(), methodName, "idAnnoScolastico: " + row.getIdAnnoScolastico()));
		log.info(buildMessage(getClass(), methodName, "scuolaLista: " + row.getScuolaLista()));

		final SqlHolder sh = buildSqlHolder()
				.addQueryRows(
						"insert into iscritto_r_lista_attesa (",
						"  id_domanda_isc,",
						"  id_anno_scolastico,",
						"  scuola_lista",
						")",
						"values (",
						"  :idDomandaIsc,",
						"  :idAnnoScolastico,",
						"  :scuolaLista",
						")")
				.bind("idDomandaIsc", row.getIdDomandaIsc())
				.bind("idAnnoScolastico", row.getIdAnnoScolastico())
				.bind("scuolaLista", row.getScuolaLista());

		this.update(sh);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
	}

	@Override
	public Integer deleteIscrittoRListaAttesa(Long idDomandaIsc) throws DaoException {
		final String methodName = "deleteIscrittoRListaAttesa";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		log.info(buildMessage(getClass(), methodName, "idDomandaIsc: " + idDomandaIsc));
		Validate.notNull(idDomandaIsc);

		final SqlHolder sh = buildSqlHolder(
				"delete from iscritto_r_lista_attesa where id_domanda_isc = :idDomandaIsc")
						.bind("idDomandaIsc", idDomandaIsc);

		Integer result = this.update(sh);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

}
