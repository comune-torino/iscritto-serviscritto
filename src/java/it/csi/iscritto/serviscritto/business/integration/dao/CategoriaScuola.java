package it.csi.iscritto.serviscritto.business.integration.dao;

public enum CategoriaScuola {
	C("C", "CONVENZIONATA"),
	S("S", "STATALE"),
	M("M", "COMUNALE"),
	A("A", "COMUNALE IN APPALTO"),
	;

	private String cod;
	private String desc;

	private CategoriaScuola(String cod, String desc) {
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
