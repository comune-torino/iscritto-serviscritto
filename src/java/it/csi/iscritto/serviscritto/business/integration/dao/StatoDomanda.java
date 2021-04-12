package it.csi.iscritto.serviscritto.business.integration.dao;

public enum StatoDomanda {
	BOZ("BOZ", "Bozza"),
	INV("INV", "Inviata"),
	RIN("RIN", "Rinuncia"),
	AMM("AMM", "Ammessa"),
	ACC("ACC", "Accettata"),
	RIT("RIT", "Ritirata"),
	GRA("GRA", "In graduatoria"),
	ANN("ANN", "Annullata per rettifica"),
	CAN("CAN", "Annullata dal richiedente"),
	;

	private String cod;
	private String desc;

	private StatoDomanda(String cod, String desc) {
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
