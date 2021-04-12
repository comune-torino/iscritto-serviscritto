package it.csi.iscritto.serviscritto.business.integration.dao.custom.dto;

import java.io.Serializable;
import java.util.Date;

public class InfoInvioAccRow implements Serializable {
	private static final long serialVersionUID = 1L;

	private Date dtInvioSise;
	private Date dtInvioScuola;

	public Date getDtInvioSise() {
		return dtInvioSise;
	}

	public void setDtInvioSise(Date dtInvioSise) {
		this.dtInvioSise = dtInvioSise;
	}

	public Date getDtInvioScuola() {
		return dtInvioScuola;
	}

	public void setDtInvioScuola(Date dtInvioScuola) {
		this.dtInvioScuola = dtInvioScuola;
	}

}
