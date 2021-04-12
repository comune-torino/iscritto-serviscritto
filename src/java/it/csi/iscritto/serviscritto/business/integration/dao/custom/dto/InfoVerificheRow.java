package it.csi.iscritto.serviscritto.business.integration.dao.custom.dto;

import java.io.Serializable;

public class InfoVerificheRow implements Serializable {
	private static final long serialVersionUID = 1L;

	private String codCondizione;
	private String descrizione;
	private String flIstruttoria;
	private Integer occorrenze;

	public String getCodCondizione() {
		return codCondizione;
	}

	public void setCodCondizione(String codCondizione) {
		this.codCondizione = codCondizione;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getFlIstruttoria() {
		return flIstruttoria;
	}

	public void setFlIstruttoria(String flIstruttoria) {
		this.flIstruttoria = flIstruttoria;
	}

	public Integer getOccorrenze() {
		return occorrenze;
	}

	public void setOccorrenze(Integer occorrenze) {
		this.occorrenze = occorrenze;
	}

}
