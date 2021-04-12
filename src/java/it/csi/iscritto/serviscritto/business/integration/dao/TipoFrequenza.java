package it.csi.iscritto.serviscritto.business.integration.dao;

public enum TipoFrequenza {
	BRV("BRV", "Tempo breve"),
	LNG("LNG", "Tempo lungo"),
	INT("INT", "Tempo intermedio");

	private String cod;
	private String desc;

	private TipoFrequenza(String cod, String desc) {
		this.cod = cod;
		this.desc = desc;
	}

	public String getCod() {
		return cod;
	}

	public String getDesc() {
		return desc;
	}
}
