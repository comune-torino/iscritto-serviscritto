package it.csi.iscritto.serviscritto.business.util.allegato;

public enum TipologiaAllegato {
	GRA,
	SAL,
	DIS,
	SER,
	;

	public static final boolean checkCodTipologia(String codTipologia) {
		for (TipologiaAllegato e : values()) {
			if (e.name().equals(codTipologia)) {
				return true;
			}
		}

		return false;
	}

}
