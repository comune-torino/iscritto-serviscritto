package it.csi.iscritto.serviscritto.business.integration.dao;

import org.apache.commons.lang3.StringUtils;

public enum TipoSpostamento {
	VAR_RES("VAR_RES", "Ho fatto richiesta di variazione residenza"),
	RES_FUT("RES_FUT", "Mi trasferiro' prossimamente a Torino"),
	APP_VAR_RES("APP_VAR_RES", "Ho appuntamento all anagrafe per variazione residenza"),
	;

	private String cod;
	private String desc;

	private TipoSpostamento(String cod, String desc) {
		this.cod = cod;
		this.desc = desc;
	}

	public static TipoSpostamento findByCod(String cod) {
		if (StringUtils.isNotBlank(cod)) {
			for (TipoSpostamento e : values()) {
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
