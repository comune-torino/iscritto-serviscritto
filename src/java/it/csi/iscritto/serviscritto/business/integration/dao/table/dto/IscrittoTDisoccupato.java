/*
 * Java bean class for entity "iscritto_t_disoccupato"
 * Created on 2019-04-01 ( Date ISO 2019-04-01 - Time 09:21:22 )
 * Generated by Telosys Tools Generator ( version 3.0.0 )
 */

package it.csi.iscritto.serviscritto.business.integration.dao.table.dto;

import java.io.Serializable;

import java.util.Date;

/**
 * Java bean for entity "iscritto_t_disoccupato"
 *
 * @author Telosys Tools Generator
 *
 */
public class IscrittoTDisoccupato implements Serializable {
    private static final long serialVersionUID = 1L;

	public static final String SQL_SELECT_ALL =
		"select " +
		"  id_condizione_occupazionale, " +
		"  dt_dichiarazione_disponibili, " +
		"  comune_cpi, " +
		"  id_tipo_presentazione, " +
		"  provincia_cpi " +
		"from iscritto_t_disoccupato ";

	//////////////////////////////////////////////////////////////////////

	public static final String SQL_INSERT =
		"insert into iscritto_t_disoccupato (" +
		"  id_condizione_occupazionale, " +
		"  dt_dichiarazione_disponibili, " +
		"  comune_cpi, " +
		"  id_tipo_presentazione, " +
		"  provincia_cpi " +
		") " +
		"values (" +
		"  :idCondizioneOccupazionale, " +
		"  :dtDichiarazioneDisponibili, " +
		"  :comuneCpi, " +
		"  :idTipoPresentazione, " +
		"  :provinciaCpi " +
		")";

	//////////////////////////////////////////////////////////////////////

	public static final String SQL_DELETE =
		"delete from iscritto_t_disoccupato where " +
		"  id_condizione_occupazionale = :idCondizioneOccupazionale ";

	//////////////////////////////////////////////////////////////////////

	public static final String SQL_COUNT_ALL =
		"select count(*) from iscritto_t_disoccupato";

	//////////////////////////////////////////////////////////////////////


    private Long       idCondizioneOccupazionale ; // Id or Primary Key

    private Date       dtDichiarazioneDisponibili ;
    private String     comuneCpi    ;
    private Long       idTipoPresentazione ;
    private String     provinciaCpi ;

    /**
     * Set the "idCondizioneOccupazionale" field value
     * This field is mapped on the database column "id_condizione_occupazionale" ( type "int4", NotNull : true )
     * @param idCondizioneOccupazionale
     */
	public void setIdCondizioneOccupazionale(Long idCondizioneOccupazionale) {
        this.idCondizioneOccupazionale = idCondizioneOccupazionale ;
    }

    /**
     * Get the "idCondizioneOccupazionale" field value
     * This field is mapped on the database column "id_condizione_occupazionale" ( type "int4", NotNull : true )
     * @return the field value
     */
	public Long getIdCondizioneOccupazionale() {
        return this.idCondizioneOccupazionale;
    }

    /**
     * Set the "dtDichiarazioneDisponibili" field value
     * This field is mapped on the database column "dt_dichiarazione_disponibili" ( type "timestamp", NotNull : true )
     * @param dtDichiarazioneDisponibili
     */
    public void setDtDichiarazioneDisponibili(Date dtDichiarazioneDisponibili) {
        this.dtDichiarazioneDisponibili = dtDichiarazioneDisponibili;
    }

    /**
     * Get the "dtDichiarazioneDisponibili" field value
     * This field is mapped on the database column "dt_dichiarazione_disponibili" ( type "timestamp", NotNull : true )
     * @return the field value
     */
    public Date getDtDichiarazioneDisponibili() {
        return this.dtDichiarazioneDisponibili;
    }

    /**
     * Set the "comuneCpi" field value
     * This field is mapped on the database column "comune_cpi" ( type "varchar", NotNull : false )
     * @param comuneCpi
     */
    public void setComuneCpi(String comuneCpi) {
        this.comuneCpi = comuneCpi;
    }

    /**
     * Get the "comuneCpi" field value
     * This field is mapped on the database column "comune_cpi" ( type "varchar", NotNull : false )
     * @return the field value
     */
    public String getComuneCpi() {
        return this.comuneCpi;
    }

    /**
     * Set the "idTipoPresentazione" field value
     * This field is mapped on the database column "id_tipo_presentazione" ( type "int4", NotNull : true )
     * @param idTipoPresentazione
     */
    public void setIdTipoPresentazione(Long idTipoPresentazione) {
        this.idTipoPresentazione = idTipoPresentazione;
    }

    /**
     * Get the "idTipoPresentazione" field value
     * This field is mapped on the database column "id_tipo_presentazione" ( type "int4", NotNull : true )
     * @return the field value
     */
    public Long getIdTipoPresentazione() {
        return this.idTipoPresentazione;
    }

    /**
     * Set the "provinciaCpi" field value
     * This field is mapped on the database column "provincia_cpi" ( type "varchar", NotNull : false )
     * @param provinciaCpi
     */
    public void setProvinciaCpi(String provinciaCpi) {
        this.provinciaCpi = provinciaCpi;
    }

    /**
     * Get the "provinciaCpi" field value
     * This field is mapped on the database column "provincia_cpi" ( type "varchar", NotNull : false )
     * @return the field value
     */
    public String getProvinciaCpi() {
        return this.provinciaCpi;
    }


    @Override
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append(idCondizioneOccupazionale);
        sb.append("|");
        sb.append(dtDichiarazioneDisponibili);
        sb.append("|");
        sb.append(comuneCpi);
        sb.append("|");
        sb.append(idTipoPresentazione);
        sb.append("|");
        sb.append(provinciaCpi);
        return sb.toString(); 
    } 

}
