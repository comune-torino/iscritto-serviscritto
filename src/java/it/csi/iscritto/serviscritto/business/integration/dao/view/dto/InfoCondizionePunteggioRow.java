package it.csi.iscritto.serviscritto.business.integration.dao.view.dto;

import java.io.Serializable;

public class InfoCondizionePunteggioRow implements Serializable {
	private static final long serialVersionUID = 1L;

	private String codCondizione;
	private String descrizione;
	private Long idCondizionePunteggio;
	private String flIstruttoria;
	private String codTipoIstruttoria;
	private String codTipoAllegato;

	public String getCodCondizione() {
		return codCondizione;
	}

	public void setCodCondizione(String codCondizione) {
		this.codCondizione = codCondizione;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public Long getIdCondizionePunteggio() {
		return idCondizionePunteggio;
	}

	public void setIdCondizionePunteggio(Long idCondizionePunteggio) {
		this.idCondizionePunteggio = idCondizionePunteggio;
	}

	public String getFlIstruttoria() {
		return flIstruttoria;
	}

	public void setFlIstruttoria(String flIstruttoria) {
		this.flIstruttoria = flIstruttoria;
	}

	public String getCodTipoIstruttoria() {
		return codTipoIstruttoria;
	}

	public void setCodTipoIstruttoria(String codTipoIstruttoria) {
		this.codTipoIstruttoria = codTipoIstruttoria;
	}

	public String getCodTipoAllegato() {
		return codTipoAllegato;
	}

	public void setCodTipoAllegato(String codTipoAllegato) {
		this.codTipoAllegato = codTipoAllegato;
	}

}
