package it.csi.iscritto.serviscritto.business.domanda.filter;

import org.apache.commons.lang3.StringUtils;

public enum TipoTestata {
	RIC("RIC"),
	RIC_MIN("RIC_MIN"),
	UNKNOWN(null),
	;

	private String cod;

	private TipoTestata(String cod) {
		this.cod = cod;
	}

	public static TipoTestata findByCod(String cod) {
		if (StringUtils.isNotBlank(cod)) {
			for (TipoTestata e : values()) {
				if (cod.equalsIgnoreCase(e.getCod())) {
					return e;
				}
			}
		}

		return UNKNOWN;
	}

	public String getCod() {
		return cod;
	}

}
