/**
 *
 */
package it.csi.iscritto.serviscritto.business.integration.dao.table.impl;

import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.LOG_BEGIN;
import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.LOG_END;
import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.buildMessage;
import static it.csi.iscritto.serviscritto.business.util.converter.ConvertUtils.getFirst;

import org.apache.log4j.Logger;

import it.csi.iscritto.serviscritto.business.integration.dao.AbstractDao;
import it.csi.iscritto.serviscritto.business.integration.dao.table.UtenteDao;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTUtente;
import it.csi.iscritto.serviscritto.business.integration.exception.DaoException;
import it.csi.iscritto.serviscritto.business.util.Constants;
import it.csi.iscritto.serviscritto.business.util.converter.ConvertUtils;
import it.csi.iscritto.serviscritto.business.util.sql.SqlHolder;

/**
 * @author 630
 *
 */
public class UtenteDaoImpl extends AbstractDao implements UtenteDao {
	private static final Logger log = Logger.getLogger(Constants.COMPONENT_NAME + ".dao");

	/*
	 * (non-Javadoc)
	 *
	 * @see it.csi.iscritto.serviscritto.business.integration.dao.table.UtenteDao#findIscrittoTUtenteByFk(java.lang.Long)
	 */
	@Override
	public IscrittoTUtente findIscrittoTUtenteByPk(Long idUtente) throws DaoException {
		final String methodName = "findIscrittoTUtenteByPk";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		SqlHolder sh = buildSqlHolder(IscrittoTUtente.SQL_SELECT_ALL)
				.addQueryRows(
						"WHERE 1 = 1",
						"  AND id_utente = :idUtente")
				.bind("idUtente", idUtente);

		IscrittoTUtente result = getFirst(this.query(sh, IscrittoTUtente.class));

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public IscrittoTUtente findIscrittoTUtenteByCF(String codiceFiscale) throws DaoException {
		final String methodName = "findIscrittoTUtenteByCF";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		SqlHolder sh = buildSqlHolder(IscrittoTUtente.SQL_SELECT_ALL)
				.addQueryRows(
						"WHERE 1 = 1",
						"  AND upper(codice_fiscale) = :codiceFiscale",
						"  AND fl_eliminato = 'N'")
				.bind("codiceFiscale", ConvertUtils.toUpper(codiceFiscale));

		IscrittoTUtente result = getFirst(this.query(sh, IscrittoTUtente.class));

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

}
