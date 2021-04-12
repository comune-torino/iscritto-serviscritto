
package it.csi.iscritto.serviscritto.business.integration.dao.view.dto;

import java.io.Serializable;

public class PrivilegioOperatoreRow implements Serializable {
	static final long serialVersionUID = 1;

	private Long idUtente;
	private String codiceFiscale;
	private String cognome;
	private String nome;
	private String codiceProfilo;
	private Long idPrivilegio;
	private String codPrivilegio;
	private String descrizione;
	private Long idAttivita;

	public Long getIdUtente() {
		return idUtente;
	}

	public void setIdUtente(Long idUtente) {
		this.idUtente = idUtente;
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodiceProfilo() {
		return codiceProfilo;
	}

	public void setCodiceProfilo(String codiceProfilo) {
		this.codiceProfilo = codiceProfilo;
	}

	public Long getIdPrivilegio() {
		return idPrivilegio;
	}

	public void setIdPrivilegio(Long idPrivilegio) {
		this.idPrivilegio = idPrivilegio;
	}

	public String getCodPrivilegio() {
		return codPrivilegio;
	}

	public void setCodPrivilegio(String codPrivilegio) {
		this.codPrivilegio = codPrivilegio;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public Long getIdAttivita() {
		return idAttivita;
	}

	public void setIdAttivita(Long idAttivita) {
		this.idAttivita = idAttivita;
	}

}
