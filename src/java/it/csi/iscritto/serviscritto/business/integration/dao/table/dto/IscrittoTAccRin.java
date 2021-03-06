/*
 * Java bean class for entity "iscritto_t_acc_rin"
 * Created on 2019-05-23 ( Date ISO 2019-05-23 - Time 11:50:22 )
 * Generated by Telosys Tools Generator ( version 3.0.0 )
 */

package it.csi.iscritto.serviscritto.business.integration.dao.table.dto;

import java.io.Serializable;

import java.util.Date;

/**
 * Java bean for entity "iscritto_t_acc_rin"
 *
 * @author Telosys Tools Generator
 *
 */
public class IscrittoTAccRin implements Serializable {
    private static final long serialVersionUID = 1L;

	public static final String SQL_SELECT_ALL =
		"select " +
		"  id_accettazione_rin, " +
		"  id_utente, " +
		"  id_domanda_iscrizione, " +
		"  id_scuola, " +
		"  dt_operazione, " +
		"  fl_a_r, " +
		"  fl_auto, " +
		"  id_tipo_frequenza " +
		"from iscritto_t_acc_rin ";

	//////////////////////////////////////////////////////////////////////

	public static final String SQL_INSERT =
		"insert into iscritto_t_acc_rin (" +
		"  id_accettazione_rin, " +
		"  id_utente, " +
		"  id_domanda_iscrizione, " +
		"  id_scuola, " +
		"  dt_operazione, " +
		"  fl_a_r, " +
		"  fl_auto, " +
		"  id_tipo_frequenza " +
		") " +
		"values (" +
		"  :idAccettazioneRin, " +
		"  :idUtente, " +
		"  :idDomandaIscrizione, " +
		"  :idScuola, " +
		"  :dtOperazione, " +
		"  :flAR, " +
		"  :flAuto, " +
		"  :idTipoFrequenza " +
		")";

	//////////////////////////////////////////////////////////////////////

	public static final String SQL_DELETE =
		"delete from iscritto_t_acc_rin where " +
		"  id_accettazione_rin = :idAccettazioneRin ";

	//////////////////////////////////////////////////////////////////////

	public static final String SQL_COUNT_ALL =
		"select count(*) from iscritto_t_acc_rin";

	//////////////////////////////////////////////////////////////////////


    private Long       idAccettazioneRin ; // Id or Primary Key

    private Long       idUtente     ;
    private Long       idDomandaIscrizione ;
    private Long       idScuola     ;
    private Date       dtOperazione ;
    private String     flAR         ;
    private String     flAuto       ;
    private Long       idTipoFrequenza ;

    /**
     * Set the "idAccettazioneRin" field value
     * This field is mapped on the database column "id_accettazione_rin" ( type "int4", NotNull : true )
     * @param idAccettazioneRin
     */
	public void setIdAccettazioneRin(Long idAccettazioneRin) {
        this.idAccettazioneRin = idAccettazioneRin ;
    }

    /**
     * Get the "idAccettazioneRin" field value
     * This field is mapped on the database column "id_accettazione_rin" ( type "int4", NotNull : true )
     * @return the field value
     */
	public Long getIdAccettazioneRin() {
        return this.idAccettazioneRin;
    }

    /**
     * Set the "idUtente" field value
     * This field is mapped on the database column "id_utente" ( type "int4", NotNull : false )
     * @param idUtente
     */
    public void setIdUtente(Long idUtente) {
        this.idUtente = idUtente;
    }

    /**
     * Get the "idUtente" field value
     * This field is mapped on the database column "id_utente" ( type "int4", NotNull : false )
     * @return the field value
     */
    public Long getIdUtente() {
        return this.idUtente;
    }

    /**
     * Set the "idDomandaIscrizione" field value
     * This field is mapped on the database column "id_domanda_iscrizione" ( type "int4", NotNull : true )
     * @param idDomandaIscrizione
     */
    public void setIdDomandaIscrizione(Long idDomandaIscrizione) {
        this.idDomandaIscrizione = idDomandaIscrizione;
    }

    /**
     * Get the "idDomandaIscrizione" field value
     * This field is mapped on the database column "id_domanda_iscrizione" ( type "int4", NotNull : true )
     * @return the field value
     */
    public Long getIdDomandaIscrizione() {
        return this.idDomandaIscrizione;
    }

    /**
     * Set the "idScuola" field value
     * This field is mapped on the database column "id_scuola" ( type "int4", NotNull : true )
     * @param idScuola
     */
    public void setIdScuola(Long idScuola) {
        this.idScuola = idScuola;
    }

    /**
     * Get the "idScuola" field value
     * This field is mapped on the database column "id_scuola" ( type "int4", NotNull : true )
     * @return the field value
     */
    public Long getIdScuola() {
        return this.idScuola;
    }

    /**
     * Set the "dtOperazione" field value
     * This field is mapped on the database column "dt_operazione" ( type "timestamp", NotNull : true )
     * @param dtOperazione
     */
    public void setDtOperazione(Date dtOperazione) {
        this.dtOperazione = dtOperazione;
    }

    /**
     * Get the "dtOperazione" field value
     * This field is mapped on the database column "dt_operazione" ( type "timestamp", NotNull : true )
     * @return the field value
     */
    public Date getDtOperazione() {
        return this.dtOperazione;
    }

    /**
     * Set the "flAR" field value
     * This field is mapped on the database column "fl_a_r" ( type "varchar", NotNull : true )
     * @param flAR
     */
    public void setFlAR(String flAR) {
        this.flAR = flAR;
    }

    /**
     * Get the "flAR" field value
     * This field is mapped on the database column "fl_a_r" ( type "varchar", NotNull : true )
     * @return the field value
     */
    public String getFlAR() {
        return this.flAR;
    }

    /**
     * Set the "flAuto" field value
     * This field is mapped on the database column "fl_auto" ( type "varchar", NotNull : true )
     * @param flAuto
     */
    public void setFlAuto(String flAuto) {
        this.flAuto = flAuto;
    }

    /**
     * Get the "flAuto" field value
     * This field is mapped on the database column "fl_auto" ( type "varchar", NotNull : true )
     * @return the field value
     */
    public String getFlAuto() {
        return this.flAuto;
    }

    /**
     * Set the "idTipoFrequenza" field value
     * This field is mapped on the database column "id_tipo_frequenza" ( type "int4", NotNull : true )
     * @param idTipoFrequenza
     */
    public void setIdTipoFrequenza(Long idTipoFrequenza) {
        this.idTipoFrequenza = idTipoFrequenza;
    }

    /**
     * Get the "idTipoFrequenza" field value
     * This field is mapped on the database column "id_tipo_frequenza" ( type "int4", NotNull : true )
     * @return the field value
     */
    public Long getIdTipoFrequenza() {
        return this.idTipoFrequenza;
    }


    @Override
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append(idAccettazioneRin);
        sb.append("|");
        sb.append(idUtente);
        sb.append("|");
        sb.append(idDomandaIscrizione);
        sb.append("|");
        sb.append(idScuola);
        sb.append("|");
        sb.append(dtOperazione);
        sb.append("|");
        sb.append(flAR);
        sb.append("|");
        sb.append(flAuto);
        sb.append("|");
        sb.append(idTipoFrequenza);
        return sb.toString(); 
    } 

}
