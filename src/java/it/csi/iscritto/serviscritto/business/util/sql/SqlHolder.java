package it.csi.iscritto.serviscritto.business.util.sql;

import java.util.Map;

/**
 * Un oggetto SqlHolder si occupa gestire una query ed i relativi parametri.
 */
public interface SqlHolder {
	/**
	 * Accoda nella struttura di memorizzazione interna una o piu' righe della query
	 */
	SqlHolder addQueryRows(String... rows);

	/**
	 * Inserisce in una struttura di tipo chiave/valore il nome di un parametro della query
	 * ed il suo valore.
	 */
	SqlHolder bind(String paramName, Object value);

	/**
	 * Restituisce la mappa dei parametri inseriti.
	 */
	Map<String, Object> getParams();

	/**
	 * Restituisce la query applicando ad ogni riga inserita con il metodo addQueryRows il formato
	 * che riceve come parametro. Alcuni valori utilizzati per rowFormat sono definiti in RowFormatEnum.
	 */
	String toSql(String rowFormat);

}
