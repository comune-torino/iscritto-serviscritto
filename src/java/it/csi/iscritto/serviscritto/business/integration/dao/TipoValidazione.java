package it.csi.iscritto.serviscritto.business.integration.dao;

import org.apache.commons.lang3.StringUtils;

public enum TipoValidazione {
	ACC_PUN_PRIO("ACC-PUN-PRIO", "VALIDATA CON PUNTEGGIO E PRIORITA'"),
	ACC_PUN("ACC-PUN", "VALIDATA CON SOLO PUNTEGGIO"),
	ACC_RED_CON("ACC-RED-CON", null),
	RIF_SOCIO_SAN("RIF-SOCIO-SAN", null),
	RIF_RED_CON("RIF-RED-CON", null),
	RIF_RIC_INTEGR("RIF-RIC-INTEGR", null),
	;

	private String cod;
	private String desc;

	private TipoValidazione(String cod, String desc) {
		this.cod = cod;
		this.desc = desc;
	}

	public static TipoValidazione findByCod(String cod) {
		if (StringUtils.isNotBlank(cod)) {
			for (TipoValidazione e : values()) {
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
