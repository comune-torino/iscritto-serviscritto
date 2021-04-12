package it.csi.iscritto.serviscritto.business.integration.dao.view.dto;

public class FunzioneRow {
	Long idFunzione;
	/**
	 * @return the idFunzione
	 */
	public Long getIdFunzione() {
		return idFunzione;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FunzioneRow [idFunzione=" + idFunzione + ", codice=" + codice + ", descrizione=" + descrizione + "]";
	}
	public FunzioneRow(Long idFunzione, String codice, String descrizione) {
		super();
		this.idFunzione = idFunzione;
		this.codice = codice;
		this.descrizione = descrizione;
	}
	/**
	 * @param idFunzione the idFunzione to set
	 */
	public void setIdFunzione(Long idFunzione) {
		this.idFunzione = idFunzione;
	}
	/**
	 * @return the codice
	 */
	public String getCodice() {
		return codice;
	}
	/**
	 * @param codice the codice to set
	 */
	public void setCodice(String codice) {
		this.codice = codice;
	}
	/**
	 * @return the descrizione
	 */
	public String getDescrizione() {
		return descrizione;
	}
	/**
	 * @param descrizione the descrizione to set
	 */
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	String codice;
	String descrizione;

}
