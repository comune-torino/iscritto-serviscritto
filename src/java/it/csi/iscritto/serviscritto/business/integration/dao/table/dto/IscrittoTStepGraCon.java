/*
 * Java bean class for entity "iscritto_t_step_gra_con"
 * Created on 2019-05-17 ( Date ISO 2019-05-17 - Time 12:52:47 )
 * Generated by Telosys Tools Generator ( version 3.0.0 )
 */

package it.csi.iscritto.serviscritto.business.integration.dao.table.dto;

import java.io.Serializable;

import java.util.Date;

/**
 * Java bean for entity "iscritto_t_step_gra_con"
 *
 * @author Telosys Tools Generator
 *
 */
public class IscrittoTStepGraCon implements Serializable {
    private static final long serialVersionUID = 1L;

	public static final String SQL_SELECT_ALL =
		"select " +
		"  id_step_gra_con, " +
		"  id_step_gra, " +
		"  id_stato_gra, " +
		"  fl_ammissioni, " +
		"  fl_calcolo_in_corso, " +
		"  dt_step_con " +
		"from iscritto_t_step_gra_con ";

	//////////////////////////////////////////////////////////////////////

	public static final String SQL_INSERT =
		"insert into iscritto_t_step_gra_con (" +
		"  id_step_gra_con, " +
		"  id_step_gra, " +
		"  id_stato_gra, " +
		"  fl_ammissioni, " +
		"  fl_calcolo_in_corso, " +
		"  dt_step_con " +
		") " +
		"values (" +
		"  :idStepGraCon, " +
		"  :idStepGra, " +
		"  :idStatoGra, " +
		"  :flAmmissioni, " +
		"  :flCalcoloInCorso, " +
		"  :dtStepCon " +
		")";

	//////////////////////////////////////////////////////////////////////

	public static final String SQL_DELETE =
		"delete from iscritto_t_step_gra_con where " +
		"  id_step_gra_con = :idStepGraCon ";

	//////////////////////////////////////////////////////////////////////

	public static final String SQL_COUNT_ALL =
		"select count(*) from iscritto_t_step_gra_con";

	//////////////////////////////////////////////////////////////////////


    private Long       idStepGraCon ; // Id or Primary Key

    private Long       idStepGra    ;
    private Long       idStatoGra   ;
    private String     flAmmissioni ;
    private String     flCalcoloInCorso ;
    private Date       dtStepCon    ;

    /**
     * Set the "idStepGraCon" field value
     * This field is mapped on the database column "id_step_gra_con" ( type "int4", NotNull : true )
     * @param idStepGraCon
     */
	public void setIdStepGraCon(Long idStepGraCon) {
        this.idStepGraCon = idStepGraCon ;
    }

    /**
     * Get the "idStepGraCon" field value
     * This field is mapped on the database column "id_step_gra_con" ( type "int4", NotNull : true )
     * @return the field value
     */
	public Long getIdStepGraCon() {
        return this.idStepGraCon;
    }

    /**
     * Set the "idStepGra" field value
     * This field is mapped on the database column "id_step_gra" ( type "int4", NotNull : false )
     * @param idStepGra
     */
    public void setIdStepGra(Long idStepGra) {
        this.idStepGra = idStepGra;
    }

    /**
     * Get the "idStepGra" field value
     * This field is mapped on the database column "id_step_gra" ( type "int4", NotNull : false )
     * @return the field value
     */
    public Long getIdStepGra() {
        return this.idStepGra;
    }

    /**
     * Set the "idStatoGra" field value
     * This field is mapped on the database column "id_stato_gra" ( type "int4", NotNull : false )
     * @param idStatoGra
     */
    public void setIdStatoGra(Long idStatoGra) {
        this.idStatoGra = idStatoGra;
    }

    /**
     * Get the "idStatoGra" field value
     * This field is mapped on the database column "id_stato_gra" ( type "int4", NotNull : false )
     * @return the field value
     */
    public Long getIdStatoGra() {
        return this.idStatoGra;
    }

    /**
     * Set the "flAmmissioni" field value
     * This field is mapped on the database column "fl_ammissioni" ( type "varchar", NotNull : false )
     * @param flAmmissioni
     */
    public void setFlAmmissioni(String flAmmissioni) {
        this.flAmmissioni = flAmmissioni;
    }

    /**
     * Get the "flAmmissioni" field value
     * This field is mapped on the database column "fl_ammissioni" ( type "varchar", NotNull : false )
     * @return the field value
     */
    public String getFlAmmissioni() {
        return this.flAmmissioni;
    }

    /**
     * Set the "flCalcoloInCorso" field value
     * This field is mapped on the database column "fl_calcolo_in_corso" ( type "varchar", NotNull : false )
     * @param flCalcoloInCorso
     */
    public void setFlCalcoloInCorso(String flCalcoloInCorso) {
        this.flCalcoloInCorso = flCalcoloInCorso;
    }

    /**
     * Get the "flCalcoloInCorso" field value
     * This field is mapped on the database column "fl_calcolo_in_corso" ( type "varchar", NotNull : false )
     * @return the field value
     */
    public String getFlCalcoloInCorso() {
        return this.flCalcoloInCorso;
    }

    /**
     * Set the "dtStepCon" field value
     * This field is mapped on the database column "dt_step_con" ( type "timestamp", NotNull : false )
     * @param dtStepCon
     */
    public void setDtStepCon(Date dtStepCon) {
        this.dtStepCon = dtStepCon;
    }

    /**
     * Get the "dtStepCon" field value
     * This field is mapped on the database column "dt_step_con" ( type "timestamp", NotNull : false )
     * @return the field value
     */
    public Date getDtStepCon() {
        return this.dtStepCon;
    }


    @Override
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append(idStepGraCon);
        sb.append("|");
        sb.append(idStepGra);
        sb.append("|");
        sb.append(idStatoGra);
        sb.append("|");
        sb.append(flAmmissioni);
        sb.append("|");
        sb.append(flCalcoloInCorso);
        sb.append("|");
        sb.append(dtStepCon);
        return sb.toString(); 
    } 

}
