package it.csi.iscritto.serviscritto.business.integration.dao.view.dto;

import java.io.Serializable;
import java.util.Date;

public class TestataDomandaRow implements Serializable {
	private static final long serialVersionUID = 1L;

	// Common
	private Long idDomandaIscrizione;
	private String protocollo;
	private String nomeMinore;
	private String cognomeMinore;
	private String codiceFiscaleMinore;
	private String statoDomandaCodice;
	private Date dataUltimaModifica;
	private String cognomeUtente;
	private String nomeUtente;

	// FO
	private Date dataInvio;
	private String codiceAnnoScolastico;
	private String annoScolasticoDescrizione;
	private String codiceFiscaleRichiedente;
	private String codOrdineScuola;

	// BO
	private Long idSoggettoMinore;
	private String statoDomandaDescrizione;

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

	public String getCodiceFiscaleMinore() {
		return codiceFiscaleMinore;
	}

	public void setCodiceFiscaleMinore(String codiceFiscaleMinore) {
		this.codiceFiscaleMinore = codiceFiscaleMinore;
	}

	public String getStatoDomandaCodice() {
		return statoDomandaCodice;
	}

	public void setStatoDomandaCodice(String statoDomandaCodice) {
		this.statoDomandaCodice = statoDomandaCodice;
	}

	public Date getDataUltimaModifica() {
		return dataUltimaModifica;
	}

	public void setDataUltimaModifica(Date dataUltimaModifica) {
		this.dataUltimaModifica = dataUltimaModifica;
	}

	public String getCognomeUtente() {
		return cognomeUtente;
	}

	public void setCognomeUtente(String cognomeUtente) {
		this.cognomeUtente = cognomeUtente;
	}

	public String getNomeUtente() {
		return nomeUtente;
	}

	public void setNomeUtente(String nomeUtente) {
		this.nomeUtente = nomeUtente;
	}

	public Date getDataInvio() {
		return dataInvio;
	}

	public void setDataInvio(Date dataInvio) {
		this.dataInvio = dataInvio;
	}

	public String getCodiceAnnoScolastico() {
		return codiceAnnoScolastico;
	}

	public void setCodiceAnnoScolastico(String codiceAnnoScolastico) {
		this.codiceAnnoScolastico = codiceAnnoScolastico;
	}

	public String getAnnoScolasticoDescrizione() {
		return annoScolasticoDescrizione;
	}

	public void setAnnoScolasticoDescrizione(String annoScolasticoDescrizione) {
		this.annoScolasticoDescrizione = annoScolasticoDescrizione;
	}

	public String getCodiceFiscaleRichiedente() {
		return codiceFiscaleRichiedente;
	}

	public void setCodiceFiscaleRichiedente(String codiceFiscaleRichiedente) {
		this.codiceFiscaleRichiedente = codiceFiscaleRichiedente;
	}

	public String getCodOrdineScuola() {
		return codOrdineScuola;
	}

	public void setCodOrdineScuola(String codOrdineScuola) {
		this.codOrdineScuola = codOrdineScuola;
	}

	public Long getIdSoggettoMinore() {
		return idSoggettoMinore;
	}

	public void setIdSoggettoMinore(Long idSoggettoMinore) {
		this.idSoggettoMinore = idSoggettoMinore;
	}

	public String getStatoDomandaDescrizione() {
		return statoDomandaDescrizione;
	}

	public void setStatoDomandaDescrizione(String statoDomandaDescrizione) {
		this.statoDomandaDescrizione = statoDomandaDescrizione;
	}

}
