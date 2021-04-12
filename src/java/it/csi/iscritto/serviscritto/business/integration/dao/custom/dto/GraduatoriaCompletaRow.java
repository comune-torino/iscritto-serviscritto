package it.csi.iscritto.serviscritto.business.integration.dao.custom.dto;

import java.io.Serializable;
import java.util.Date;

public class GraduatoriaCompletaRow implements Serializable {
	private static final long serialVersionUID = 1L;

	private String codFasciaEta;
	private String protocollo;
	private Date dataConsegna;
	private Integer punteggio;
	private String nome;
	private String cognome;
	private String codiceFiscale;
	private Date dataNascita;
	private String oraNascita;
	private Double isee;

	private String prefA;
	private String prefB;
	private String prefC;
	private String prefD;
	private String prefE;
	private String prefF;
	private String prefG;
	private String prefH;
	private String prefI;
	private String prefJ;

	public String getCodFasciaEta() {
		return codFasciaEta;
	}

	public void setCodFasciaEta(String codFasciaEta) {
		this.codFasciaEta = codFasciaEta;
	}

	public String getProtocollo() {
		return protocollo;
	}

	public void setProtocollo(String protocollo) {
		this.protocollo = protocollo;
	}

	public Date getDataConsegna() {
		return dataConsegna;
	}

	public void setDataConsegna(Date dataConsegna) {
		this.dataConsegna = dataConsegna;
	}

	public Integer getPunteggio() {
		return punteggio;
	}

	public void setPunteggio(Integer punteggio) {
		this.punteggio = punteggio;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public Date getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}

	public String getOraNascita() {
		return oraNascita;
	}

	public void setOraNascita(String oraNascita) {
		this.oraNascita = oraNascita;
	}

	public Double getIsee() {
		return isee;
	}

	public void setIsee(Double isee) {
		this.isee = isee;
	}

	public String getPrefA() {
		return prefA;
	}

	public void setPrefA(String prefA) {
		this.prefA = prefA;
	}

	public String getPrefB() {
		return prefB;
	}

	public void setPrefB(String prefB) {
		this.prefB = prefB;
	}

	public String getPrefC() {
		return prefC;
	}

	public void setPrefC(String prefC) {
		this.prefC = prefC;
	}

	public String getPrefD() {
		return prefD;
	}

	public void setPrefD(String prefD) {
		this.prefD = prefD;
	}

	public String getPrefE() {
		return prefE;
	}

	public void setPrefE(String prefE) {
		this.prefE = prefE;
	}

	public String getPrefF() {
		return prefF;
	}

	public void setPrefF(String prefF) {
		this.prefF = prefF;
	}

	public String getPrefG() {
		return prefG;
	}

	public void setPrefG(String prefG) {
		this.prefG = prefG;
	}

	public String getPrefH() {
		return prefH;
	}

	public void setPrefH(String prefH) {
		this.prefH = prefH;
	}

	public String getPrefI() {
		return prefI;
	}

	public void setPrefI(String prefI) {
		this.prefI = prefI;
	}

	public String getPrefJ() {
		return prefJ;
	}

	public void setPrefJ(String prefJ) {
		this.prefJ = prefJ;
	}

}
