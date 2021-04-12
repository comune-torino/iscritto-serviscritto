package it.csi.iscritto.serviscritto.business.integration.dao;

import org.apache.commons.lang3.StringUtils;

public enum TipoCondizioneOccupazionale {
	DIP("DIP", "persona con contratto di lavoro dipendente o parasubordinato"),
	AUT("AUT", "persona con lavoro autonomo, coadiuvante o con libera professione"),
	DIS("DIS", "persona disoccupata"),
	DIS_LAV("DIS_LAV", "persona disoccupata o non occupata che ha lavorato almeno 6 mesi nei precedenti 12"),
	STU("STU", "studente"),
	NO_COND("NO_COND", "nessuna condizione"),
	// usato in findByCod
	NOT_FOUND(null, null);

	private String cod;
	private String desc;

	private TipoCondizioneOccupazionale(String cod, String desc) {
		this.cod = cod;
		this.desc = desc;
	}

	public static TipoCondizioneOccupazionale findByCod(String cod) {
		if (StringUtils.isNotBlank(cod)) {
			for (TipoCondizioneOccupazionale e : values()) {
				if (cod.equalsIgnoreCase(e.getCod())) {
					return e;
				}
			}
		}

		return NOT_FOUND;
	}

	public String getCod() {
		return cod;
	}

	public String getDesc() {
		return desc;
	}

}
