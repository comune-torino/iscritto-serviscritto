package it.csi.iscritto.serviscritto.business.integration.dao.view.dto;

import java.io.Serializable;
import java.util.Date;

import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTUtente;

public class CondizionePunteggioRow implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long idDomanda;
	private Long idUtente;
	private Long idCondizionePunteggio;
	/**
	 * @return the idDomanda
	 */
	public Long getIdDomanda() {
		return idDomanda;
	}

	/**
	 * @param idDomanda the idDomanda to set
	 */
	public void setIdDomanda(Long idDomanda) {
		this.idDomanda = idDomanda;
	}

	/**
	 * @return the idCondizionePunteggio
	 */
	public Long getIdCondizionePunteggio() {
		return idCondizionePunteggio;
	}

	/**
	 * @param idCondizionePunteggio the idCondizionePunteggio to set
	 */
	public void setIdCondizionePunteggio(Long idCondizionePunteggio) {
		this.idCondizionePunteggio = idCondizionePunteggio;
	}

	private String flValida;
	private Integer ricorrenza;
	
	// estensione della jira ISBO-111
	private Date dataInizioValidita;
	private Date dataFineValidita;
	private String note;
	

	/**
	 * @return the ricorrenza
	 */
	public Integer getRicorrenza() {
		return ricorrenza;
	}

	/**
	 * @param ricorrenza the ricorrenza to set
	 */
	public void setRicorrenza(Integer ricorrenza) {
		this.ricorrenza = ricorrenza;
	}

	

	public String getFlValida() {
		return flValida;
	}

	public void setFlValida(String flValida) {
		this.flValida = flValida;
	}

	



	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CondizionePunteggioRow [idDomanda=" + idDomanda + ", idUtente=" + idUtente + ", idCondizionePunteggio="
				+ idCondizionePunteggio + ", flValida=" + flValida + ", ricorrenza=" + ricorrenza
				+ ", dataInizioValidita=" + dataInizioValidita + ", dataFineValidita=" + dataFineValidita + ", note="
				+ note + "]";
	}


	/**
	 * @return the idUtente
	 */
	public Long getIdUtente() {
		return idUtente;
	}

	/**
	 * @param idUtente the idUtente to set
	 */
	public void setIdUtente(Long idUtente) {
		this.idUtente = idUtente;
	}

	public Date getDataInizioValidita() {
		return dataInizioValidita;
	}

	public void setDataInizioValidita(Date dataInizioValidita) {
		this.dataInizioValidita = dataInizioValidita;
	}

	public Date getDataFineValidita() {
		return dataFineValidita;
	}

	public void setDataFineValidita(Date dataFineValidita) {
		this.dataFineValidita = dataFineValidita;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	
}
