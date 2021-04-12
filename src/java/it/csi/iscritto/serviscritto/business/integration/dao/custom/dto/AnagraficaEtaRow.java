package it.csi.iscritto.serviscritto.business.integration.dao.custom.dto;

import java.io.Serializable;
import java.util.Date;

public class AnagraficaEtaRow implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long idEta;
	private Date dataDa;
	private Date dataA;
	private String codAnagraficaGra;
	private String codOrdineScuola;
	private String codAnnoScolastico;
	private String codFasciaEta;

	public Long getIdEta() {
		return idEta;
	}

	public void setIdEta(Long idEta) {
		this.idEta = idEta;
	}

	public Date getDataDa() {
		return dataDa;
	}

	public void setDataDa(Date dataDa) {
		this.dataDa = dataDa;
	}

	public Date getDataA() {
		return dataA;
	}

	public void setDataA(Date dataA) {
		this.dataA = dataA;
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

	public String getCodFasciaEta() {
		return codFasciaEta;
	}

	public void setCodFasciaEta(String codFasciaEta) {
		this.codFasciaEta = codFasciaEta;
	}

}
