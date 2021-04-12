package it.csi.iscritto.serviscritto.business.integration.dao;

import org.apache.commons.lang3.StringUtils;

public enum StatoCondizionePunteggio {
	ALL,
	DAI,
	CON,
	INV;

	public static StatoCondizionePunteggio findByCod(String cod) {
		if (StringUtils.isNotBlank(cod)) {
			for (StatoCondizionePunteggio e : values()) {
				if (cod.equalsIgnoreCase(e.name())) {
					return e;
				}
			}
		}

		return null;
	}
}
