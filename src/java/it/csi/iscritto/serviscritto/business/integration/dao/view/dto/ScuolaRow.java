package it.csi.iscritto.serviscritto.business.integration.dao.view.dto;

import java.io.Serializable;

public class ScuolaRow implements Serializable {
	private static final long serialVersionUID = 1L;

	// iscritto_t_scuola
	private Long idScuola;
	private String codScuola;
	private String descrizione;
	private String indirizzo;
	private String descNidoContiguo;
	private String indirizzoNidoContiguo;

	// iscritto_d_categoria_scu
	private String codCategoriaScu;
	private String descCategoriaScu;

	// iscritto_d_ordine_scuola
	private String codOrdineScuola;
	private String descOrdineScuola;

	// iscritto_d_circoscrizione
	private String codCircoscrizione;
	private String descCircoscrizione;

	// iscritto_d_tipo_fre
	private String codTipoFrequenza;
	private String descTipoFrequenza;

	// iscritto_t_anno_sco
	private Long idAnnoScolastico;
	private String codAnnoScolastico;

	// campo S/N calcolato
	private String alert;

	public Long getIdScuola() {
		return idScuola;
	}

	public void setIdScuola(Long idScuola) {
		this.idScuola = idScuola;
	}

	public String getCodScuola() {
		return codScuola;
	}

	public void setCodScuola(String codScuola) {
		this.codScuola = codScuola;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getDescNidoContiguo() {
		return descNidoContiguo;
	}

	public void setDescNidoContiguo(String descNidoContiguo) {
		this.descNidoContiguo = descNidoContiguo;
	}

	public String getIndirizzoNidoContiguo() {
		return indirizzoNidoContiguo;
	}

	public void setIndirizzoNidoContiguo(String indirizzoNidoContiguo) {
		this.indirizzoNidoContiguo = indirizzoNidoContiguo;
	}

	public String getCodCategoriaScu() {
		return codCategoriaScu;
	}

	public void setCodCategoriaScu(String codCategoriaScu) {
		this.codCategoriaScu = codCategoriaScu;
	}

	public String getDescCategoriaScu() {
		return descCategoriaScu;
	}

	public void setDescCategoriaScu(String descCategoriaScu) {
		this.descCategoriaScu = descCategoriaScu;
	}

	public String getCodOrdineScuola() {
		return codOrdineScuola;
	}

	public void setCodOrdineScuola(String codOrdineScuola) {
		this.codOrdineScuola = codOrdineScuola;
	}

	public String getDescOrdineScuola() {
		return descOrdineScuola;
	}

	public void setDescOrdineScuola(String descOrdineScuola) {
		this.descOrdineScuola = descOrdineScuola;
	}

	public String getCodCircoscrizione() {
		return codCircoscrizione;
	}

	public void setCodCircoscrizione(String codCircoscrizione) {
		this.codCircoscrizione = codCircoscrizione;
	}

	public String getDescCircoscrizione() {
		return descCircoscrizione;
	}

	public void setDescCircoscrizione(String descCircoscrizione) {
		this.descCircoscrizione = descCircoscrizione;
	}

	public String getCodTipoFrequenza() {
		return codTipoFrequenza;
	}

	public void setCodTipoFrequenza(String codTipoFrequenza) {
		this.codTipoFrequenza = codTipoFrequenza;
	}

	public String getDescTipoFrequenza() {
		return descTipoFrequenza;
	}

	public void setDescTipoFrequenza(String descTipoFrequenza) {
		this.descTipoFrequenza = descTipoFrequenza;
	}

	public Long getIdAnnoScolastico() {
		return idAnnoScolastico;
	}

	public void setIdAnnoScolastico(Long idAnnoScolastico) {
		this.idAnnoScolastico = idAnnoScolastico;
	}

	public String getCodAnnoScolastico() {
		return codAnnoScolastico;
	}

	public void setCodAnnoScolastico(String codAnnoScolastico) {
		this.codAnnoScolastico = codAnnoScolastico;
	}

	public String getAlert() {
		return alert;
	}

	public void setAlert(String alert) {
		this.alert = alert;
	}

}
