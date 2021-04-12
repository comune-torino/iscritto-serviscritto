package it.csi.iscritto.serviscritto.business.integration.dao;

import org.apache.commons.lang3.StringUtils;

public enum TipoCommissione {
	COMMISSIONE_H("H", TipoCondizionePunteggio.PA_DIS),
	COMMISSIONE_S("S", TipoCondizionePunteggio.PA_PRB_SAL_MIN),
	COMMISSIONE_D("D", TipoCondizionePunteggio.PA_PRB_SAL_ALT)
	;

	//la classe ospita un sola condizione di punteggio per codice, ho creato la commissione fittizzia "D" per associare il secondo valore alla commissione s
	private String cod;
	private String codCondizione;

	private TipoCommissione(String cod, TipoCondizionePunteggio tipoCondizionePunteggio) {
		this.cod = cod;
		this.codCondizione = tipoCondizionePunteggio.getCod();
	}

	public static TipoCommissione findByCod(String cod) {

		 if (StringUtils.isNotBlank(cod)) {
			for (TipoCommissione e : values()) {
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

	public String getCodCondizione() {
		return codCondizione;
	}

}
