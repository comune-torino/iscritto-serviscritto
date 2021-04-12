package it.csi.iscritto.serviscritto.business.integration.dao.custom.dto;

import java.io.Serializable;
import java.util.Date;

public class AnagraficaGraduatoriaRow implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long idAnagraficaGra;
	private String codAnagraficaGra;
	private Date dtInizioIscr;
	private Date dtScadenzaIscr;
	private Date dtFineIscr;
	private Date dtScadenzaGrad;
	private Date dtScadenzaRicorsi;
	private String codAnnoScolastico;
	private String codOrdineScuola;

	public Long getIdAnagraficaGra() {
		return idAnagraficaGra;
	}

	public void setIdAnagraficaGra(Long idAnagraficaGra) {
		this.idAnagraficaGra = idAnagraficaGra;
	}

	public String getCodAnagraficaGra() {
		return codAnagraficaGra;
	}

	public void setCodAnagraficaGra(String codAnagraficaGra) {
		this.codAnagraficaGra = codAnagraficaGra;
	}

	public Date getDtInizioIscr() {
		return dtInizioIscr;
	}

	public void setDtInizioIscr(Date dtInizioIscr) {
		this.dtInizioIscr = dtInizioIscr;
	}

	public Date getDtScadenzaIscr() {
		return dtScadenzaIscr;
	}

	public void setDtScadenzaIscr(Date dtScadenzaIscr) {
		this.dtScadenzaIscr = dtScadenzaIscr;
	}

	public Date getDtFineIscr() {
		return dtFineIscr;
	}

	public void setDtFineIscr(Date dtFineIscr) {
		this.dtFineIscr = dtFineIscr;
	}

	public Date getDtScadenzaGrad() {
		return dtScadenzaGrad;
	}

	public void setDtScadenzaGrad(Date dtScadenzaGrad) {
		this.dtScadenzaGrad = dtScadenzaGrad;
	}

	public Date getDtScadenzaRicorsi() {
		return dtScadenzaRicorsi;
	}

	public void setDtScadenzaRicorsi(Date dtScadenzaRicorsi) {
		this.dtScadenzaRicorsi = dtScadenzaRicorsi;
	}

	public String getCodAnnoScolastico() {
		return codAnnoScolastico;
	}

	public void setCodAnnoScolastico(String codAnnoScolastico) {
		this.codAnnoScolastico = codAnnoScolastico;
	}

	public String getCodOrdineScuola() {
		return codOrdineScuola;
	}

	public void setCodOrdineScuola(String codOrdineScuola) {
		this.codOrdineScuola = codOrdineScuola;
	}

}
