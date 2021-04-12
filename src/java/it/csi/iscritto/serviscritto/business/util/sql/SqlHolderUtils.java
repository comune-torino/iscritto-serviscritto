package it.csi.iscritto.serviscritto.business.util.sql;

import static org.apache.commons.lang3.StringUtils.EMPTY;

import java.util.Iterator;

import org.apache.commons.lang3.StringUtils;

public final class SqlHolderUtils {
	private SqlHolderUtils() {
		/* NOP */
	}

	/*
	 * Metodo di utilita' per aggiungere in modo condizionale una riga durante
	 * la costruzione di un oggetto SqlHolder. Se la condizione non è soddisfatta
	 * il metodo restituisce una stringa vuota.
	 */
	public static String addIf(boolean condition, String row) {
		if (condition && StringUtils.isNotBlank(row)) {
			return row;
		}

		return EMPTY;
	}

	/*
	 * Si occupa di concatenare la rappresentazione testuale di tutti gli oggetti dell'insieme che riceve
	 * come primo parametro (objs) separati tra loro dal delimitatore che riceve come secondo parametro (delimiter).
	 * Ad ogni elemento dell'insieme viene applicata la regola di formattazione che riceve come terzo parametro (format).
	 * Per esempio se objs = 1 2 3; delimiter = ", "; format = "(%d)";
	 * Si ottiene come risultato "(1), (2), (3)"
	 */
	public static <T> String join(Iterable<T> objs, String delimiter, String format) {
		final StringBuilder sb = new StringBuilder();
		final Iterator<T> iter = objs.iterator();

		if (iter.hasNext()) {
			sb.append(String.format(format, String.valueOf(iter.next())));
			while (iter.hasNext()) {
				sb.append(delimiter).append(String.format(format, String.valueOf(iter.next())));
			}
		}

		return sb.toString();
	}

}
