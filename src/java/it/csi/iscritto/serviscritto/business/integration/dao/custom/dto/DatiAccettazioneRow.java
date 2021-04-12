package it.csi.iscritto.serviscritto.business.integration.dao.custom.dto;

import java.io.Serializable;
import java.util.Date;

public class DatiAccettazioneRow implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long idDomandaIscrizione;
	private String protocollo;
	private Date dataConsegna;
	private Date dtModifica;
	private String telefono;
	private String codTipoPasto;
	private String codOrdineScuola;
	private String nomeMinore;
	private String cognomeMinore;
	private String codStatoDom;
	private String codAnnoScolastico;
	private String irc;

	public String getIrc() {
		return irc;
	}

	public void setIrc(String irc) {
		this.irc = irc;
	}

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

	public Date getDtModifica() {
		return dtModifica;
	}

	public void setDtModifica(Date dtModifica) {
		this.dtModifica = dtModifica;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCodTipoPasto() {
		return codTipoPasto;
	}

	public void setCodTipoPasto(String codTipoPasto) {
		this.codTipoPasto = codTipoPasto;
	}

	public String getCodOrdineScuola() {
		return codOrdineScuola;
	}

	public void setCodOrdineScuola(String codOrdineScuola) {
		this.codOrdineScuola = codOrdineScuola;
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

	public String getCodStatoDom() {
		return codStatoDom;
	}

	public void setCodStatoDom(String codStatoDom) {
		this.codStatoDom = codStatoDom;
	}

	public String getCodAnnoScolastico() {
		return codAnnoScolastico;
	}

	public void setCodAnnoScolastico(String codAnnoScolastico) {
		this.codAnnoScolastico = codAnnoScolastico;
	}

}
