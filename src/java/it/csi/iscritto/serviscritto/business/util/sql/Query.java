package it.csi.iscritto.serviscritto.business.util.sql;

import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.LOG_BEGIN_QUERY;
import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.LOG_END_QUERY;
import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.buildMessage;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import it.csi.iscritto.serviscritto.business.integration.exception.DaoException;
import it.csi.iscritto.serviscritto.business.util.Constants;
import it.csi.util.performance.StopWatch;

/**
 * Si occupa di definire le operazioni comuni nell'eseguzione di una query
 * delegando alle sotoclassi l'implementazione dei comportamenti di dettaglio.
 * La sottoclasse di dettaglio deve fornire un'implementazione del metodo doQuery().
 */
public abstract class Query<RET> {
	private static final Logger log = Logger.getLogger(Constants.COMPONENT_NAME + ".dao");
	private static final String MESSAGE = "esecuzione query";

	protected RET result;
	protected final String SQL;
	protected final MapSqlParameterSource PARAMS;

	private final String sqlLog;
	private final Class<?> enclosingClass;
	private final String enclosingClassName;
	private final Method enclosingMethod;
	private final String enclosingMethodName;

	public Query(final SqlHolder sqlHolder) {
		// classe e nome della sottoclasse
		this.enclosingClass = this.getClass().getEnclosingClass();
		this.enclosingClassName = this.enclosingClass != null ? this.enclosingClass.getSimpleName() : "unknown";

		// classe e nome del metodo nel quale e' definita la sottoclasse
		this.enclosingMethod = this.getClass().getEnclosingMethod();
		this.enclosingMethodName = enclosingMethod != null ? enclosingMethod.getName() : "unknown";

		// dati provenienti dal parametro sqlHolder che deve essere fornito durante
		// la creazione della sottoclasse
		this.PARAMS = new MapSqlParameterSource(sqlHolder.getParams());
		this.SQL = sqlHolder.toSql(RowFormatEnum.QUERY_ROW_FORMAT.getRowFormat());
		this.sqlLog = sqlHolder.toSql(RowFormatEnum.PRINT_ROW_FORMAT.getRowFormat());
	}

	/*
	 * Metodo principale per l'esecuzione della query che la sottoclasse puo' invocare ma non ridefinire
	 */
	public final RET execute() throws DaoException {
		log.debug(buildMessage(this.enclosingClass, this.enclosingMethodName, LOG_BEGIN_QUERY));

		StopWatch stw = new StopWatch(Constants.COMPONENT_NAME);
		try {
			stw.start();
			this.result = this.doQuery();
		}
		catch (Exception e) {
			log.error(buildMessage(this.enclosingClass, this.enclosingMethodName, MESSAGE), e);
			throw new DaoException("Query failed", e);
		}
		finally {
			stw.stop();
			stw.dumpElapsed(this.enclosingClassName, this.enclosingMethodName, MESSAGE, this.sqlLog);
			log.debug(buildMessage(this.enclosingClass, this.enclosingMethodName, LOG_END_QUERY));
		}

		return this.result;
	}

	/*
	 * Metodo che la sottoclasse deve implementare
	 */
	protected abstract RET doQuery();

}
