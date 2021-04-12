package it.csi.iscritto.serviscritto.business.integration.dao.view.dto;

import java.io.Serializable;
import java.util.Date;

public class SoggettoRow implements Serializable {
	private static final long serialVersionUID = 1L;

	// iscritto_t_anagrafica_sog
	private Long idAnagraficaSoggetto;
	private String cognome;
	private String nome;
	private Date dataNascita;
	private String codiceFiscale;
	private String sesso;
	private Long idDomandaIscrizione;
	private Long idRelParentela;
	private Long idComuneNascita;
	private Long idStatoNascita;
	private String oraNascita;
	private String flResidenzaNao;

	// iscritto_d_tipo_sog
	private String codTipoSoggetto;

	// iscritto_t_stato
	private String codCittadinanza;
	private String descCittadinanza;

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

	public Date getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public String getSesso() {
		return sesso;
	}

	public void setSesso(String sesso) {
		this.sesso = sesso;
	}

	public Long getIdDomandaIscrizione() {
		return idDomandaIscrizione;
	}

	public void setIdDomandaIscrizione(Long idDomandaIscrizione) {
		this.idDomandaIscrizione = idDomandaIscrizione;
	}

	public Long getIdRelParentela() {
		return idRelParentela;
	}

	public void setIdRelParentela(Long idRelParentela) {
		this.idRelParentela = idRelParentela;
	}

	public Long getIdComuneNascita() {
		return idComuneNascita;
	}

	public void setIdComuneNascita(Long idComuneNascita) {
		this.idComuneNascita = idComuneNascita;
	}

	public Long getIdStatoNascita() {
		return idStatoNascita;
	}

	public void setIdStatoNascita(Long idStatoNascita) {
		this.idStatoNascita = idStatoNascita;
	}

	public String getOraNascita() {
		return oraNascita;
	}

	public void setOraNascita(String oraNascita) {
		this.oraNascita = oraNascita;
	}

	public String getFlResidenzaNao() {
		return flResidenzaNao;
	}

	public void setFlResidenzaNao(String flResidenzaNao) {
		this.flResidenzaNao = flResidenzaNao;
	}

	public String getCodTipoSoggetto() {
		return codTipoSoggetto;
	}

	public void setCodTipoSoggetto(String codTipoSoggetto) {
		this.codTipoSoggetto = codTipoSoggetto;
	}

	public String getCodCittadinanza() {
		return codCittadinanza;
	}

	public void setCodCittadinanza(String codCittadinanza) {
		this.codCittadinanza = codCittadinanza;
	}

	public String getDescCittadinanza() {
		return descCittadinanza;
	}

	public void setDescCittadinanza(String descCittadinanza) {
		this.descCittadinanza = descCittadinanza;
	}

}
