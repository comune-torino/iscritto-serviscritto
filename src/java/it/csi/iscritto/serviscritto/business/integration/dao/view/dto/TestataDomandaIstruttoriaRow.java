package it.csi.iscritto.serviscritto.business.integration.dao.view.dto;

import java.io.Serializable;
import java.util.Date;

public class TestataDomandaIstruttoriaRow implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long idDomandaIscrizione;
	private String protocollo;
	private Date dataConsegna;
	private Date dataUltimaModifica;
	private String statoDomandaCodice;
	private String nomeMinore;
	private String cognomeMinore;
	private String indirizzo;
	private Integer ricorrenza;
	private String flValida;

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

	public Date getDataConsegna() {
		return dataConsegna;
	}

	public void setDataConsegna(Date dataConsegna) {
		this.dataConsegna = dataConsegna;
	}

	public Date getDataUltimaModifica() {
		return dataUltimaModifica;
	}

	public void setDataUltimaModifica(Date dataUltimaModifica) {
		this.dataUltimaModifica = dataUltimaModifica;
	}

	public String getStatoDomandaCodice() {
		return statoDomandaCodice;
	}

	public void setStatoDomandaCodice(String statoDomandaCodice) {
		this.statoDomandaCodice = statoDomandaCodice;
	}

	public String getNomeMinore() {
		return nomeMinore;
	}

	public void setNomeMinore(String nomeMinore) {
		this.nomeMinore = nomeMinore;
	}

	public String getCognomeMinore() {
		return cognomeMinore;
	}

	public void setCognomeMinore(String cognomeMinore) {
		this.cognomeMinore = cognomeMinore;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public Integer getRicorrenza() {
		return ricorrenza;
	}

	public void setRicorrenza(Integer ricorrenza) {
		this.ricorrenza = ricorrenza;
	}

	public String getFlValida() {
		return flValida;
	}

	public void setFlValida(String flValida) {
		this.flValida = flValida;
	}

}
