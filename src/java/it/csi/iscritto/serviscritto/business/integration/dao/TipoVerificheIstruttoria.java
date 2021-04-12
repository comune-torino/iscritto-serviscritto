package it.csi.iscritto.serviscritto.business.integration.dao;

public enum TipoVerificheIstruttoria {
	PREVENTIVE("P", "Preventive"),
	SUCCESSIVE("S", "Successive"),
	NESSUNA("N", "Nessuna");

	private String cod;
	private String desc;

	private TipoVerificheIstruttoria(String cod, String desc) {
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
