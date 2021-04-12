/*
 * Java bean class for entity "iscritto_t_affido"
 * Created on 2019-04-01 ( Date ISO 2019-04-01 - Time 09:21:21 )
 * Generated by Telosys Tools Generator ( version 3.0.0 )
 */

package it.csi.iscritto.serviscritto.business.integration.dao.table.dto;

import java.io.Serializable;

import java.util.Date;

/**
 * Java bean for entity "iscritto_t_affido"
 *
 * @author Telosys Tools Generator
 *
 */
public class IscrittoTAffido implements Serializable {
    private static final long serialVersionUID = 1L;

	public static final String SQL_SELECT_ALL =
		"select " +
		"  id_anagrafica_soggetto, " +
		"  num_sentenza, " +
		"  dt_sentenza, " +
		"  comune_tribunale " +
		"from iscritto_t_affido ";

	//////////////////////////////////////////////////////////////////////

	public static final String SQL_INSERT =
		"insert into iscritto_t_affido (" +
		"  id_anagrafica_soggetto, " +
		"  num_sentenza, " +
		"  dt_sentenza, " +
		"  comune_tribunale " +
		") " +
		"values (" +
		"  :idAnagraficaSoggetto, " +
		"  :numSentenza, " +
		"  :dtSentenza, " +
		"  :comuneTribunale " +
		")";

	//////////////////////////////////////////////////////////////////////

	public static final String SQL_DELETE =
		"delete from iscritto_t_affido where " +
		"  id_anagrafica_soggetto = :idAnagraficaSoggetto ";

	//////////////////////////////////////////////////////////////////////

	public static final String SQL_COUNT_ALL =
		"select count(*) from iscritto_t_affido";

	//////////////////////////////////////////////////////////////////////


    private Long       idAnagraficaSoggetto ; // Id or Primary Key

    private String     numSentenza  ;
    private Date       dtSentenza   ;
    private String     comuneTribunale ;

    /**
     * Set the "idAnagraficaSoggetto" field value
     * This field is mapped on the database column "id_anagrafica_soggetto" ( type "int4", NotNull : true )
     * @param idAnagraficaSoggetto
     */
	public void setIdAnagraficaSoggetto(Long idAnagraficaSoggetto) {
        this.idAnagraficaSoggetto = idAnagraficaSoggetto ;
    }

    /**
     * Get the "idAnagraficaSoggetto" field value
     * This field is mapped on the database column "id_anagrafica_soggetto" ( type "int4", NotNull : true )
     * @return the field value
     */
	public Long getIdAnagraficaSoggetto() {
        return this.idAnagraficaSoggetto;
    }

    /**
     * Set the "numSentenza" field value
     * This field is mapped on the database column "num_sentenza" ( type "varchar", NotNull : true )
     * @param numSentenza
     */
    public void setNumSentenza(String numSentenza) {
        this.numSentenza = numSentenza;
    }

    /**
     * Get the "numSentenza" field value
     * This field is mapped on the database column "num_sentenza" ( type "varchar", NotNull : true )
     * @return the field value
     */
    public String getNumSentenza() {
        return this.numSentenza;
    }

    /**
     * Set the "dtSentenza" field value
     * This field is mapped on the database column "dt_sentenza" ( type "timestamp", NotNull : true )
     * @param dtSentenza
     */
    public void setDtSentenza(Date dtSentenza) {
        this.dtSentenza = dtSentenza;
    }

    /**
     * Get the "dtSentenza" field value
     * This field is mapped on the database column "dt_sentenza" ( type "timestamp", NotNull : true )
     * @return the field value
     */
    public Date getDtSentenza() {
        return this.dtSentenza;
    }

    /**
     * Set the "comuneTribunale" field value
     * This field is mapped on the database column "comune_tribunale" ( type "varchar", NotNull : true )
     * @param comuneTribunale
     */
    public void setComuneTribunale(String comuneTribunale) {
        this.comuneTribunale = comuneTribunale;
    }

    /**
     * Get the "comuneTribunale" field value
     * This field is mapped on the database column "comune_tribunale" ( type "varchar", NotNull : true )
     * @return the field value
     */
    public String getComuneTribunale() {
        return this.comuneTribunale;
    }


    @Override
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append(idAnagraficaSoggetto);
        sb.append("|");
        sb.append(numSentenza);
        sb.append("|");
        sb.append(dtSentenza);
        sb.append("|");
        sb.append(comuneTribunale);
        return sb.toString(); 
    } 

}