package it.csi.iscritto.serviscritto.business.integration.dao.custom.dto;

import java.io.Serializable;
import java.util.Date;

public class VerbaleCommissioneRow implements Serializable {
	private static final long serialVersionUID = 1L;

	private String flValida;
	private String flIntegrazione;
	private String note;
	private Date dtInizioValidita;
	private Date dtFineValidita;
	private String protocollo;
	private String codiceFiscaleMinore;
	private String nomeMinore;
	private String cognomeMinore;
	private String nomeScuolaPrimaScelta;
	private String indirizzoScuolaPrimaScelta;

	public String getFlValida() {
		return flValida;
	}

	public void setFlValida(String flValida) {
		this.flValida = flValida;
	}

	public String getFlIntegrazione() {
		return flIntegrazione;
	}

	public void setFlIntegrazione(String flIntegrazione) {
		this.flIntegrazione = flIntegrazione;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
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

	public String getProtocollo() {
		return protocollo;
	}

	public void setProtocollo(String protocollo) {
		this.protocollo = protocollo;
	}

	public String getCodiceFiscaleMinore() {
		return codiceFiscaleMinore;
	}

	public void setCodiceFiscaleMinore(String codiceFiscaleMinore) {
		this.codiceFiscaleMinore = codiceFiscaleMinore;
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

	public String getNomeScuolaPrimaScelta() {
		return nomeScuolaPrimaScelta;
	}

	public void setNomeScuolaPrimaScelta(String nomeScuolaPrimaScelta) {
		this.nomeScuolaPrimaScelta = nomeScuolaPrimaScelta;
	}

	public String getIndirizzoScuolaPrimaScelta() {
		return indirizzoScuolaPrimaScelta;
	}

	public void setIndirizzoScuolaPrimaScelta(String indirizzoScuolaPrimaScelta) {
		this.indirizzoScuolaPrimaScelta = indirizzoScuolaPrimaScelta;
	}

}
