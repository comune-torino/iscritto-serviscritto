package it.csi.iscritto.serviscritto.business.integration.dao;

import org.apache.commons.lang3.StringUtils;

public enum StatoGraduatoria {
	CAL("CAL", "Da calcolare"),
	PRO("PRO", "Provvisoria"),
	DEF("DEF", "Definitiva"),
	PRO_CON("PRO_CON", "Provvisoria congelata"),
	DEF_CON("DEF_CON", "Definitiva congelata"),
	PUB("PUB", "Pubblicata"),
	;

	private String cod;
	private String desc;

	private StatoGraduatoria(String cod, String desc) {
		this.cod = cod;
		this.desc = desc;
	}

	public static StatoGraduatoria findByCod(String cod) {
		if (StringUtils.isNotBlank(cod)) {
			for (StatoGraduatoria e : values()) {
				if (cod.equalsIgnoreCase(e.getCod())) {
					return e;
				}
			}
		}

		return null;
	}

	public String getCod() {
		return cod;
	}

	public String getDesc() {
		return desc;
	}

}
