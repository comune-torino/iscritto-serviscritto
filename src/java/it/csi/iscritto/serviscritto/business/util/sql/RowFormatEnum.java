package it.csi.iscritto.serviscritto.business.util.sql;

/**
 * Regole principali di formattazione di ogni singola riga della query contenuta in un oggetto di tipo SqlHolder.
 * QUERY_ROW_FORMAT e' utilizzato per l'esecuzione della query ed aggiunge uno spazio alla fine di ogni riga.
 * PRINT_ROW_FORMAT e' utilizzato nella stampa su log della query e prevede un ritorno a capo dopo ogni riga.
 */
public enum RowFormatEnum {
	// @formatter:off
	QUERY_ROW_FORMAT("%s "),
	PRINT_ROW_FORMAT("\n  %s "),
	;
	// @formatter:on

	private String rowFormat;

	private RowFormatEnum(String rowFormat) {
		this.rowFormat = rowFormat;
	}

	public String getRowFormat() {
		return rowFormat;
	}

}
