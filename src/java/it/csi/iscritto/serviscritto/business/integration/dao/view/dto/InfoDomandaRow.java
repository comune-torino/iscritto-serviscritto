package it.csi.iscritto.serviscritto.business.integration.dao.view.dto;

import java.io.Serializable;

public class InfoDomandaRow implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long idDomandaIscrizione;
	private String codAnnoScolastico;
	private String codiceFiscaleRic;
	private String codiceFiscaleMin;
	private String codStatoDom;


	public Long getIdDomandaIscrizione() {
		return idDomandaIscrizione;
	}

	public void setIdDomandaIscrizione(Long idDomandaIscrizione) {
		this.idDomandaIscrizione = idDomandaIscrizione;
	}

	public String getCodAnnoScolastico() {
		return codAnnoScolastico;
	}

	public void setCodAnnoScolastico(String codAnnoScolastico) {
		this.codAnnoScolastico = codAnnoScolastico;
	}

	public String getCodiceFiscaleRic() {
		return codiceFiscaleRic;
	}

	public void setCodiceFiscaleRic(String codiceFiscaleRic) {
		this.codiceFiscaleRic = codiceFiscaleRic;
	}

	public String getCodiceFiscaleMin() {
		return codiceFiscaleMin;
	}

	public void setCodiceFiscaleMin(String codiceFiscaleMin) {
		this.codiceFiscaleMin = codiceFiscaleMin;
	}

	public String getCodStatoDom() {
		return codStatoDom;
	}

	public void setCodStatoDom(String codStatoDom) {
		this.codStatoDom = codStatoDom;
	}

}
