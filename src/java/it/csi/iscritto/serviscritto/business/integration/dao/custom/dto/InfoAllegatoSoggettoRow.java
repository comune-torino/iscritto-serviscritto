package it.csi.iscritto.serviscritto.business.integration.dao.custom.dto;

import java.io.Serializable;
import java.util.Date;

public class InfoAllegatoSoggettoRow implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long idDomandaIscrizione;
	private String codCondizione;
	private Long idAnagraficaSoggetto;
	private String cognome;
	private String nome;
	private String codiceFiscaleSoggetto;
	private String codiceFiscaleRichiedente;
	private String codTipoSoggetto;
	private Long idAllegato;
	private String nomeFile;
	private String mimeType;
	private String protocollo;
	private String codTipoAllegato;
	private String codTipoAllegatoRed;
	private Date dataInserimento;

	public Long getIdDomandaIscrizione() {
		return idDomandaIscrizione;
	}

	public void setIdDomandaIscrizione(Long idDomandaIscrizione) {
		this.idDomandaIscrizione = idDomandaIscrizione;
	}

	public String getCodCondizione() {
		return codCondizione;
	}

	public void setCodCondizione(String codCondizione) {
		this.codCondizione = codCondizione;
	}

	public Long getIdAnagraficaSoggetto() {
		return idAnagraficaSoggetto;
	}

	public void setIdAnagraficaSoggetto(Long idAnagraficaSoggetto) {
		this.idAnagraficaSoggetto = idAnagraficaSoggetto;
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

	public String getCodiceFiscaleSoggetto() {
		return codiceFiscaleSoggetto;
	}

	public void setCodiceFiscaleSoggetto(String codiceFiscaleSoggetto) {
		this.codiceFiscaleSoggetto = codiceFiscaleSoggetto;
	}

	public String getCodiceFiscaleRichiedente() {
		return codiceFiscaleRichiedente;
	}

	public void setCodiceFiscaleRichiedente(String codiceFiscaleRichiedente) {
		this.codiceFiscaleRichiedente = codiceFiscaleRichiedente;
	}

	public String getCodTipoSoggetto() {
		return codTipoSoggetto;
	}

	public void setCodTipoSoggetto(String codTipoSoggetto) {
		this.codTipoSoggetto = codTipoSoggetto;
	}

	public Long getIdAllegato() {
		return idAllegato;
	}

	public void setIdAllegato(Long idAllegato) {
		this.idAllegato = idAllegato;
	}

	public String getNomeFile() {
		return nomeFile;
	}

	public void setNomeFile(String nomeFile) {
		this.nomeFile = nomeFile;
	}

	public String getMimeType() {
		return mimeType;
	}

	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}

	public String getProtocollo() {
		return protocollo;
	}

	public void setProtocollo(String protocollo) {
		this.protocollo = protocollo;
	}

	public String getCodTipoAllegato() {
		return codTipoAllegato;
	}

	public void setCodTipoAllegato(String codTipoAllegato) {
		this.codTipoAllegato = codTipoAllegato;
	}

	public String getCodTipoAllegatoRed() {
		return codTipoAllegatoRed;
	}

	public void setCodTipoAllegatoRed(String codTipoAllegatoRed) {
		this.codTipoAllegatoRed = codTipoAllegatoRed;
	}

	public Date getDataInserimento() {
		return dataInserimento;
	}

	public void setDataInserimento(Date dataInserimento) {
		this.dataInserimento = dataInserimento;
	}

}
