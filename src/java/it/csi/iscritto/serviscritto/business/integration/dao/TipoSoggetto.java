package it.csi.iscritto.serviscritto.business.integration.dao;

import org.apache.commons.lang3.StringUtils;

public enum TipoSoggetto {
	RIC("RIC", "RICHIEDENTE"),
	MIN("MIN", "MINORE"),
	SOG1("SOG1", "SOGGETTO 1"),
	SOG2("SOG2", "SOGGETTO 2"),
	SOG3("SOG3", "SOGGETTO 3"),
	CMP_NUC("CMP_NUC", "ALTRI SOGGETTI DEL NUCLEO"),
	AFF("AFF", "AFFIDO"),
	ALT_CMP("ALT_CMP", "ALTRI COMPONENTI"),
	;

	private String cod;
	private String desc;

	private TipoSoggetto(String cod, String desc) {
		this.cod = cod;
		this.desc = desc;
	}

	public static TipoSoggetto findByCod(String cod) {
		if (StringUtils.isNotBlank(cod)) {
			for (TipoSoggetto e : values()) {
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
