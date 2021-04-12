package it.csi.iscritto.serviscritto.business.util.sql;

/**
 * Questa classe si occupa della creazione dell'ogggetto SqlHolder.
 * Nasconde il tipo effettivo dell'istanza e le sue modalita' di creazione.
 * Cio' che viene esternamente reso pubblico e' unicamente l'interfaccia di riferimento.
 */
public final class SqlHolderFactory {

	private SqlHolderFactory() {
		/* NOP */
	}

	public static SqlHolder createSqlHolder(String... rows) {
		return new SqlHolderImpl().addQueryRows(rows);
	}

}
