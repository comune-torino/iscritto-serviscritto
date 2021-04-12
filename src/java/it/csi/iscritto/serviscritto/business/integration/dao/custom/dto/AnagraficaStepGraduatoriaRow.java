package it.csi.iscritto.serviscritto.business.integration.dao.custom.dto;

import java.io.Serializable;
import java.util.Date;

public class AnagraficaStepGraduatoriaRow implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer step;
	private Date dtStepGra;
	private Long idStepGra;
	private Date dtDomInvDa;
	private Date dtDomInvA;
	private Date dtAllegati;
	private String codAnagraficaGra;
	private String codOrdineScuola;
	private String codAnnoScolastico;

	public Integer getStep() {
		return step;
	}

	public void setStep(Integer step) {
		this.step = step;
	}

	public Date getDtStepGra() {
		return dtStepGra;
	}

	public void setDtStepGra(Date dtStepGra) {
		this.dtStepGra = dtStepGra;
	}

	public Long getIdStepGra() {
		return idStepGra;
	}

	public void setIdStepGra(Long idStepGra) {
		this.idStepGra = idStepGra;
	}

	public Date getDtDomInvDa() {
		return dtDomInvDa;
	}

	public void setDtDomInvDa(Date dtDomInvDa) {
		this.dtDomInvDa = dtDomInvDa;
	}

	public Date getDtDomInvA() {
		return dtDomInvA;
	}

	public void setDtDomInvA(Date dtDomInvA) {
		this.dtDomInvA = dtDomInvA;
	}

	public Date getDtAllegati() {
		return dtAllegati;
	}

	public void setDtAllegati(Date dtAllegati) {
		this.dtAllegati = dtAllegati;
	}

	public String getCodAnagraficaGra() {
		return codAnagraficaGra;
	}

	public void setCodAnagraficaGra(String codAnagraficaGra) {
		this.codAnagraficaGra = codAnagraficaGra;
	}

	public String getCodOrdineScuola() {
		return codOrdineScuola;
	}

	public void setCodOrdineScuola(String codOrdineScuola) {
		this.codOrdineScuola = codOrdineScuola;
	}

	public String getCodAnnoScolastico() {
		return codAnnoScolastico;
	}

	public void setCodAnnoScolastico(String codAnnoScolastico) {
		this.codAnnoScolastico = codAnnoScolastico;
	}

}
