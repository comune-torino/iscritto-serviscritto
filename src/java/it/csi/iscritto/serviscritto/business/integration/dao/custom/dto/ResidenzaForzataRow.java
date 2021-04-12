package it.csi.iscritto.serviscritto.business.integration.dao.custom.dto;

import java.io.Serializable;

public class ResidenzaForzataRow implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long idDomandaIscrizione;
	private String protocollo;
	private String codFasciaEta;
	private String codScuola;
	private String descScuola;
	private String indirizzo;
	private String codOrdineScuola;
	private Long idAnagraficaSoggetto;
	private String codiceFiscale;
	private String cognome;
	private String nome;

	public Long getIdDomandaIscrizione() {
		return idDomandaIscrizione;
	}

	public void setIdDomandaIscrizione(Long idDomandaIscrizione) {
		this.idDomandaIscrizione = idDomandaIscrizione;
	}

	public String getProtocollo() {
		return protocollo;
	}

	public void setProtocollo(String protocollo) {
		this.protocollo = protocollo;
	}

	public String getCodFasciaEta() {
		return codFasciaEta;
	}

	public void setCodFasciaEta(String codFasciaEta) {
		this.codFasciaEta = codFasciaEta;
	}

	public String getCodScuola() {
		return codScuola;
	}

	public void setCodScuola(String codScuola) {
		this.codScuola = codScuola;
	}

	public String getDescScuola() {
		return descScuola;
	}

	public void setDescScuola(String descScuola) {
		this.descScuola = descScuola;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getCodOrdineScuola() {
		return codOrdineScuola;
	}

	public void setCodOrdineScuola(String codOrdineScuola) {
		this.codOrdineScuola = codOrdineScuola;
	}

	public Long getIdAnagraficaSoggetto() {
		return idAnagraficaSoggetto;
	}

	public void setIdAnagraficaSoggetto(Long idAnagraficaSoggetto) {
		this.idAnagraficaSoggetto = idAnagraficaSoggetto;
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
