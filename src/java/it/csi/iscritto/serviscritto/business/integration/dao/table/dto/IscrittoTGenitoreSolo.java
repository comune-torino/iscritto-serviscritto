/*
 * Java bean class for entity "iscritto_t_genitore_solo"
 * Created on 2019-04-01 ( Date ISO 2019-04-01 - Time 09:21:23 )
 * Generated by Telosys Tools Generator ( version 3.0.0 )
 */

package it.csi.iscritto.serviscritto.business.integration.dao.table.dto;

import java.io.Serializable;

import java.util.Date;

/**
 * Java bean for entity "iscritto_t_genitore_solo"
 *
 * @author Telosys Tools Generator
 *
 */
public class IscrittoTGenitoreSolo implements Serializable {
    private static final long serialVersionUID = 1L;

	public static final String SQL_SELECT_ALL =
		"select " +
		"  id_domanda_iscrizione, " +
		"  num_sentenza, " +
		"  id_tipo_genitore_solo, " +
		"  tribunale, " +
		"  dt_sentenza " +
		"from iscritto_t_genitore_solo ";

	//////////////////////////////////////////////////////////////////////

	public static final String SQL_INSERT =
		"insert into iscritto_t_genitore_solo (" +
		"  id_domanda_iscrizione, " +
		"  num_sentenza, " +
		"  id_tipo_genitore_solo, " +
		"  tribunale, " +
		"  dt_sentenza " +
		") " +
		"values (" +
		"  :idDomandaIscrizione, " +
		"  :numSentenza, " +
		"  :idTipoGenitoreSolo, " +
		"  :tribunale, " +
		"  :dtSentenza " +
		")";

	//////////////////////////////////////////////////////////////////////

	public static final String SQL_DELETE =
		"delete from iscritto_t_genitore_solo where " +
		"  id_domanda_iscrizione = :idDomandaIscrizione ";

	//////////////////////////////////////////////////////////////////////

	public static final String SQL_COUNT_ALL =
		"select count(*) from iscritto_t_genitore_solo";

	//////////////////////////////////////////////////////////////////////


    private Long       idDomandaIscrizione ; // Id or Primary Key

    private String     numSentenza  ;
    private Long       idTipoGenitoreSolo ;
    private String     tribunale    ;
    private Date       dtSentenza   ;

    /**
     * Set the "idDomandaIscrizione" field value
     * This field is mapped on the database column "id_domanda_iscrizione" ( type "int4", NotNull : true )
     * @param idDomandaIscrizione
     */
	public void setIdDomandaIscrizione(Long idDomandaIscrizione) {
        this.idDomandaIscrizione = idDomandaIscrizione ;
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
     * Set the "numSentenza" field value
     * This field is mapped on the database column "num_sentenza" ( type "varchar", NotNull : false )
     * @param numSentenza
     */
    public void setNumSentenza(String numSentenza) {
        this.numSentenza = numSentenza;
    }

    /**
     * Get the "numSentenza" field value
     * This field is mapped on the database column "num_sentenza" ( type "varchar", NotNull : false )
     * @return the field value
     */
    public String getNumSentenza() {
        return this.numSentenza;
    }

    /**
     * Set the "idTipoGenitoreSolo" field value
     * This field is mapped on the database column "id_tipo_genitore_solo" ( type "int4", NotNull : true )
     * @param idTipoGenitoreSolo
     */
    public void setIdTipoGenitoreSolo(Long idTipoGenitoreSolo) {
        this.idTipoGenitoreSolo = idTipoGenitoreSolo;
    }

    /**
     * Get the "idTipoGenitoreSolo" field value
     * This field is mapped on the database column "id_tipo_genitore_solo" ( type "int4", NotNull : true )
     * @return the field value
     */
    public Long getIdTipoGenitoreSolo() {
        return this.idTipoGenitoreSolo;
    }

    /**
     * Set the "tribunale" field value
     * This field is mapped on the database column "tribunale" ( type "varchar", NotNull : false )
     * @param tribunale
     */
    public void setTribunale(String tribunale) {
        this.tribunale = tribunale;
    }

    /**
     * Get the "tribunale" field value
     * This field is mapped on the database column "tribunale" ( type "varchar", NotNull : false )
     * @return the field value
     */
    public String getTribunale() {
        return this.tribunale;
    }

    /**
     * Set the "dtSentenza" field value
     * This field is mapped on the database column "dt_sentenza" ( type "timestamp", NotNull : false )
     * @param dtSentenza
     */
    public void setDtSentenza(Date dtSentenza) {
        this.dtSentenza = dtSentenza;
    }

    /**
     * Get the "dtSentenza" field value
     * This field is mapped on the database column "dt_sentenza" ( type "timestamp", NotNull : false )
     * @return the field value
     */
    public Date getDtSentenza() {
        return this.dtSentenza;
    }


    @Override
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append(idDomandaIscrizione);
        sb.append("|");
        sb.append(numSentenza);
        sb.append("|");
        sb.append(idTipoGenitoreSolo);
        sb.append("|");
        sb.append(tribunale);
        sb.append("|");
        sb.append(dtSentenza);
        return sb.toString(); 
    } 

}