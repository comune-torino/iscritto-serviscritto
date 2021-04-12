package it.csi.iscritto.serviscritto.business.util.sql;

import static org.apache.commons.lang3.StringUtils.EMPTY;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

/**
 * Gestisce e mantiene una query ed i relativi parametri.
 */
public final class SqlHolderImpl implements SqlHolder {
	private final List<String> sqlRows;
	private final Map<String, Object> params;

	public SqlHolderImpl() {
		this.params = new HashMap<>();
		this.sqlRows = new ArrayList<>();
	}

	/*
	 * (non-Javadoc)
	 * @see it.csi.iscritto.iscrittofosrv.util.sql.SqlHolder#addQueryRows(java.lang.String[])
	 *
	 * Aggiunge in coda alla sqlRows tutti i valori che riceve come parametro.
	 */
	public SqlHolderImpl addQueryRows(String... rows) {
		this.addAll(rows);

		return this;
	}

	/*
	 * (non-Javadoc)
	 * @see it.csi.iscritto.iscrittofosrv.util.sql.SqlHolder#bind(java.lang.String, java.lang.Object)
	 *
	 * Aggiunge alla mappa params la coppia chiave/valore che riceve come parametro.
	 * Rappresenta il contenuto di un oggetto MapSqlParameterSource
	 */
	public SqlHolderImpl bind(String paramName, Object value) {
		this.params.put(paramName, value);

		return this;
	}

	/*
	 * (non-Javadoc)
	 * @see it.csi.iscritto.iscrittofosrv.util.sql.SqlHolder#toSql(java.lang.String)
	 *
	 * Restituisce la rappresentazione testuale della query eliminando le righe vuote ed
	 * applicando ad ogni riga la regola di formattazione che riceve come parametro.
	 */
	public String toSql(String rowFormat) {
		final List<String> cleanRows = new ArrayList<>();
		for (String s : this.sqlRows) {
			if (StringUtils.isNotBlank(s)) {
				cleanRows.add(s);
			}
		}

		return SqlHolderUtils.join(cleanRows, EMPTY, rowFormat);
	}

	public Map<String, Object> getParams() {
		return Collections.unmodifiableMap(this.params);
	}

	private void addAll(String... rows) {
		if (rows != null) {
			for (String row : rows) {
				this.sqlRows.add(row);
			}
		}
	}

}
