package it.csi.iscritto.serviscritto.business.integration.dao.view.dto;

import java.io.Serializable;

public class LuogoRow implements Serializable {
	private static final long serialVersionUID = 1L;

	// iscritto_t_stato
	private String stato;
	private String codice;
	private String cittadinanza;

	// iscritto_t_comune
	private String descRegione;
	private String istatRegione;
	private String descProvincia;
	private String istatProvincia;
	private String descComune;
	private String istatComune;

	public String getStato() {
		return stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public String getCittadinanza() {
		return cittadinanza;
	}

	public void setCittadinanza(String cittadinanza) {
		this.cittadinanza = cittadinanza;
	}

	public String getDescRegione() {
		return descRegione;
	}

	public void setDescRegione(String descRegione) {
		this.descRegione = descRegione;
	}

	public String getIstatRegione() {
		return istatRegione;
	}

	public void setIstatRegione(String istatRegione) {
		this.istatRegione = istatRegione;
	}

	public String getDescProvincia() {
		return descProvincia;
	}

	public void setDescProvincia(String descProvincia) {
		this.descProvincia = descProvincia;
	}

	public String getIstatProvincia() {
		return istatProvincia;
	}

	public void setIstatProvincia(String istatProvincia) {
		this.istatProvincia = istatProvincia;
	}

	public String getDescComune() {
		return descComune;
	}

	public void setDescComune(String descComune) {
		this.descComune = descComune;
	}

	public String getIstatComune() {
		return istatComune;
	}

	public void setIstatComune(String istatComune) {
		this.istatComune = istatComune;
	}

}
