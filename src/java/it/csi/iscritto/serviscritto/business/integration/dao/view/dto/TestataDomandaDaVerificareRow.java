package it.csi.iscritto.serviscritto.business.integration.dao.view.dto;

import java.io.Serializable;

public class TestataDomandaDaVerificareRow implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long idDomandaIscrizione;
	private String protocollo;
	private String codStatoDom;
	private String codiceFiscaleMinore;
	private String nomeMinore;
	private String cognomeMinore;
	private String flPaDis;
	private String flPaPrbSal;

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

	public String getCodStatoDom() {
		return codStatoDom;
	}

	public void setCodStatoDom(String codStatoDom) {
		this.codStatoDom = codStatoDom;
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

	public String getFlPaDis() {
		return flPaDis;
	}

	public void setFlPaDis(String flPaDis) {
		this.flPaDis = flPaDis;
	}

	public String getFlPaPrbSal() {
		return flPaPrbSal;
	}

	public void setFlPaPrbSal(String flPaPrbSal) {
		this.flPaPrbSal = flPaPrbSal;
	}

}
