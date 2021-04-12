package it.csi.iscritto.serviscritto.business.integration.dao.custom.dto;

import java.io.Serializable;
import java.util.Date;

public class DatiCondizionePunteggioRow implements Serializable {
	private static final long serialVersionUID = 1L;

	private String flValida;
	private Integer ricorrenza;
	private Date dtInizioValidita;
	private Date dtFineValidita;
	private String note;
	private Long idDomandaIscrizione;
	private Long idCondizionePunteggio;
	private String codCondizionePunteggio;
	private String codiceFiscaleOperatore;
	private String nomeOperatore;
	private String cognomeOperatore;
	private String flIntegrazione;

	public String getFlValida() {
		return flValida;
	}

	public void setFlValida(String flValida) {
		this.flValida = flValida;
	}

	public Integer getRicorrenza() {
		return ricorrenza;
	}

	public void setRicorrenza(Integer ricorrenza) {
		this.ricorrenza = ricorrenza;
	}

	public Date getDtInizioValidita() {
		return dtInizioValidita;
	}

	public void setDtInizioValidita(Date dtInizioValidita) {
		this.dtInizioValidita = dtInizioValidita;
	}

	public Date getDtFineValidita() {
		return dtFineValidita;
	}

	public void setDtFineValidita(Date dtFineValidita) {
		this.dtFineValidita = dtFineValidita;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Long getIdDomandaIscrizione() {
		return idDomandaIscrizione;
	}

	public void setIdDomandaIscrizione(Long idDomandaIscrizione) {
		this.idDomandaIscrizione = idDomandaIscrizione;
	}

	public Long getIdCondizionePunteggio() {
		return idCondizionePunteggio;
	}

	public void setIdCondizionePunteggio(Long idCondizionePunteggio) {
		this.idCondizionePunteggio = idCondizionePunteggio;
	}

	public String getCodCondizionePunteggio() {
		return codCondizionePunteggio;
	}

	public void setCodCondizionePunteggio(String codCondizionePunteggio) {
		this.codCondizionePunteggio = codCondizionePunteggio;
	}

	public String getCodiceFiscaleOperatore() {
		return codiceFiscaleOperatore;
	}

	public void setCodiceFiscaleOperatore(String codiceFiscaleOperatore) {
		this.codiceFiscaleOperatore = codiceFiscaleOperatore;
	}

	public String getNomeOperatore() {
		return nomeOperatore;
	}

	public void setNomeOperatore(String nomeOperatore) {
		this.nomeOperatore = nomeOperatore;
	}

	public String getCognomeOperatore() {
		return cognomeOperatore;
	}

	public void setCognomeOperatore(String cognomeOperatore) {
		this.cognomeOperatore = cognomeOperatore;
	}

	public String getFlIntegrazione() {
		return flIntegrazione;
	}

	public void setFlIntegrazione(String flIntegrazione) {
		this.flIntegrazione = flIntegrazione;
	}

}
