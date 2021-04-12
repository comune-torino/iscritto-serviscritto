package it.csi.iscritto.serviscritto.business.integration.dao.view.dto;

import java.io.Serializable;

public class ProtocolloRow implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long idDomandaIscrizione;
	private String codStatoDom;
	private String codOrdineScuola;

	public Long getIdDomandaIscrizione() {
		return idDomandaIscrizione;
	}

	public void setIdDomandaIscrizione(Long idDomandaIscrizione) {
		this.idDomandaIscrizione = idDomandaIscrizione;
	}

	public String getCodStatoDom() {
		return codStatoDom;
	}

	public void setCodStatoDom(String codStatoDom) {
		this.codStatoDom = codStatoDom;
	}

	public String getCodOrdineScuola() {
		return codOrdineScuola;
	}

	public void setCodOrdineScuola(String codOrdineScuola) {
		this.codOrdineScuola = codOrdineScuola;
	}

}
