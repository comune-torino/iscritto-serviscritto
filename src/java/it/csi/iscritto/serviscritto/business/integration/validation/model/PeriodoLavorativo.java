package it.csi.iscritto.serviscritto.business.integration.validation.model;

import java.io.Serializable;
import java.util.Date;

public class PeriodoLavorativo implements Serializable {
	private static final long serialVersionUID = 1L;

	private Date dataInizio;
	private Date dataFine;

	public Date getDataInizio() {
		return dataInizio;
	}

	public void setDataInizio(Date dataInizio) {
		this.dataInizio = dataInizio;
	}

	public Date getDataFine() {
		return dataFine;
	}

	public void setDataFine(Date dataFine) {
		this.dataFine = dataFine;
	}

}
