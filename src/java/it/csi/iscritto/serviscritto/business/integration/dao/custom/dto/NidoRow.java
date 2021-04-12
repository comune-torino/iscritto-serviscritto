package it.csi.iscritto.serviscritto.business.integration.dao.custom.dto;

import java.io.Serializable;

public class NidoRow implements Serializable {
	private static final long serialVersionUID = 1L;

	private String codiceCategoriaScu;
	private String codCircoscrizione;
	private String codScuola;
	private String codStatoScu;
	private String codTipoFrequenza;
	private String descrizione;
	private Integer ordinePreferenza;
	private String indirizzo;
	private Integer punteggio;
	private String flFuoriTermine;

	public String getCodiceCategoriaScu() {
		return codiceCategoriaScu;
	}

	public void setCodiceCategoriaScu(String codiceCategoriaScu) {
		this.codiceCategoriaScu = codiceCategoriaScu;
	}

	public String getCodCircoscrizione() {
		return codCircoscrizione;
	}

	public void setCodCircoscrizione(String codCircoscrizione) {
		this.codCircoscrizione = codCircoscrizione;
	}

	public String getCodScuola() {
		return codScuola;
	}

	public void setCodScuola(String codScuola) {
		this.codScuola = codScuola;
	}

	public String getCodStatoScu() {
		return codStatoScu;
	}

	public void setCodStatoScu(String codStatoScu) {
		this.codStatoScu = codStatoScu;
	}

	public String getCodTipoFrequenza() {
		return codTipoFrequenza;
	}

	public void setCodTipoFrequenza(String codTipoFrequenza) {
		this.codTipoFrequenza = codTipoFrequenza;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public Integer getOrdinePreferenza() {
		return ordinePreferenza;
	}

	public void setOrdinePreferenza(Integer ordinePreferenza) {
		this.ordinePreferenza = ordinePreferenza;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public Integer getPunteggio() {
		return punteggio;
	}

	public void setPunteggio(Integer punteggio) {
		this.punteggio = punteggio;
	}

	public String getFlFuoriTermine() {
		return flFuoriTermine;
	}

	public void setFlFuoriTermine(String flFuoriTermine) {
		this.flFuoriTermine = flFuoriTermine;
	}

}
