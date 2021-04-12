package it.csi.iscritto.serviscritto.business.integration.dao.custom.dto;

import java.io.Serializable;
import java.util.Date;

public class TestataGraduatoriaRow implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer ordinamento;
	private Integer punteggio;
	private Double isee;
	private Integer ordinePreferenza;
	private Long idDomandaIscrizione;
	private String protocollo;
	private String nomeMinore;
	private String cognomeMinore;
	private Date dataNascita;
	private String codTipoFrequenza;
	private String codStatoScuDse;
	private String codStatoScuEco;
	private String descrizioneScuola;

	public Integer getOrdinamento() {
		return ordinamento;
	}

	public void setOrdinamento(Integer ordinamento) {
		this.ordinamento = ordinamento;
	}

	public Integer getPunteggio() {
		return punteggio;
	}

	public void setPunteggio(Integer punteggio) {
		this.punteggio = punteggio;
	}

	public Double getIsee() {
		return isee;
	}

	public void setIsee(Double isee) {
		this.isee = isee;
	}

	public Integer getOrdinePreferenza() {
		return ordinePreferenza;
	}

	public void setOrdinePreferenza(Integer ordinePreferenza) {
		this.ordinePreferenza = ordinePreferenza;
	}

	public Long getIdDomandaIscrizione() {
		return idDomandaIscrizione;
	}

	public void setIdDomandaIscrizione(Long idDomandaIscrizione) {
		this.idDomandaIscrizione = idDomandaIscrizione;
	}

	public String getProtocollo() {
		return protocollo;
	}

	public void setProtocollo(String protocollo) {
		this.protocollo = protocollo;
	}

	public String getNomeMinore() {
		return nomeMinore;
	}

	public void setNomeMinore(String nomeMinore) {
		this.nomeMinore = nomeMinore;
	}

	public String getCognomeMinore() {
		return cognomeMinore;
	}

	public void setCognomeMinore(String cognomeMinore) {
		this.cognomeMinore = cognomeMinore;
	}

	public Date getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}

	public String getCodTipoFrequenza() {
		return codTipoFrequenza;
	}

	public void setCodTipoFrequenza(String codTipoFrequenza) {
		this.codTipoFrequenza = codTipoFrequenza;
	}

	public String getCodStatoScuDse() {
		return codStatoScuDse;
	}

	public void setCodStatoScuDse(String codStatoScuDse) {
		this.codStatoScuDse = codStatoScuDse;
	}

	public String getCodStatoScuEco() {
		return codStatoScuEco;
	}

	public void setCodStatoScuEco(String codStatoScuEco) {
		this.codStatoScuEco = codStatoScuEco;
	}

	public String getDescrizioneScuola() {
		return descrizioneScuola;
	}

	public void setDescrizioneScuola(String descrizioneScuola) {
		this.descrizioneScuola = descrizioneScuola;
	}

}
