package it.csi.iscritto.serviscritto.business.integration.dao;

public enum StatoScuola {
	PEN("PEN", "Pendente"),
	RIN("RIN", "Rinunciato"),
	AMM("AMM", "Ammesso"),
	ACC("ACC", "Accettato"),
	RIT("RIT", "Ritirato"),
	CAN("CAN", "Cancellato per accettazione"),
	RIN_AUTO("RIN_AUTO", "Rinuncia automatica"),
	CAN_1SC("CAN_1SC", "Cancellazione per attribuzione 1a scelta"),
	CAN_R_1SC("CAN_R_1SC", "Cancellazione per rinuncia prima scelta"),
	CAN_RIN("CAN_RIN", "Cancellazione per rinuncia"),
	NON_AMM("NON_AMM", "Non ammissibile"),
	ANN("ANN", "Annullata dal richiedente"),
	;

	private String cod;
	private String desc;

	private StatoScuola(String cod, String desc) {
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
