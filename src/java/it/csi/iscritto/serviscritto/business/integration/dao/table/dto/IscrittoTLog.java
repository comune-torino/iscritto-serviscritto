/*
 * Java bean class for entity "iscritto_t_log"
 * Created on 2019-04-01 ( Date ISO 2019-04-01 - Time 09:21:23 )
 * Generated by Telosys Tools Generator ( version 3.0.0 )
 */

package it.csi.iscritto.serviscritto.business.integration.dao.table.dto;

import java.io.Serializable;

import java.util.Date;

/**
 * Java bean for entity "iscritto_t_log"
 *
 * @author Telosys Tools Generator
 *
 */
public class IscrittoTLog implements Serializable {
    private static final long serialVersionUID = 1L;

	public static final String SQL_SELECT_ALL =
		"select " +
		"  id_log, " +
		"  d_inizio_elab, " +
		"  d_fine_elab, " +
		"  s_proc_log, " +
		"  s_nota_log " +
		"from iscritto_t_log ";

	//////////////////////////////////////////////////////////////////////

	public static final String SQL_INSERT =
		"insert into iscritto_t_log (" +
		"  id_log, " +
		"  d_inizio_elab, " +
		"  d_fine_elab, " +
		"  s_proc_log, " +
		"  s_nota_log " +
		") " +
		"values (" +
		"  :idLog, " +
		"  :dInizioElab, " +
		"  :dFineElab, " +
		"  :sProcLog, " +
		"  :sNotaLog " +
		")";

	//////////////////////////////////////////////////////////////////////

	public static final String SQL_DELETE =
		"delete from iscritto_t_log where " +
		"  id_log = :idLog ";

	//////////////////////////////////////////////////////////////////////

	public static final String SQL_COUNT_ALL =
		"select count(*) from iscritto_t_log";

	//////////////////////////////////////////////////////////////////////


    private Long       idLog        ; // Id or Primary Key

    private Date       dInizioElab  ;
    private Date       dFineElab    ;
    private String     sProcLog     ;
    private String     sNotaLog     ;

    /**
     * Set the "idLog" field value
     * This field is mapped on the database column "id_log" ( type "numeric", NotNull : true )
     * @param idLog
     */
	public void setIdLog(Long idLog) {
        this.idLog = idLog ;
    }

    /**
     * Get the "idLog" field value
     * This field is mapped on the database column "id_log" ( type "numeric", NotNull : true )
     * @return the field value
     */
	public Long getIdLog() {
        return this.idLog;
    }

    /**
     * Set the "dInizioElab" field value
     * This field is mapped on the database column "d_inizio_elab" ( type "timestamp", NotNull : false )
     * @param dInizioElab
     */
    public void setDInizioElab(Date dInizioElab) {
        this.dInizioElab = dInizioElab;
    }

    /**
     * Get the "dInizioElab" field value
     * This field is mapped on the database column "d_inizio_elab" ( type "timestamp", NotNull : false )
     * @return the field value
     */
    public Date getDInizioElab() {
        return this.dInizioElab;
    }

    /**
     * Set the "dFineElab" field value
     * This field is mapped on the database column "d_fine_elab" ( type "timestamp", NotNull : false )
     * @param dFineElab
     */
    public void setDFineElab(Date dFineElab) {
        this.dFineElab = dFineElab;
    }

    /**
     * Get the "dFineElab" field value
     * This field is mapped on the database column "d_fine_elab" ( type "timestamp", NotNull : false )
     * @return the field value
     */
    public Date getDFineElab() {
        return this.dFineElab;
    }

    /**
     * Set the "sProcLog" field value
     * This field is mapped on the database column "s_proc_log" ( type "varchar", NotNull : false )
     * @param sProcLog
     */
    public void setSProcLog(String sProcLog) {
        this.sProcLog = sProcLog;
    }

    /**
     * Get the "sProcLog" field value
     * This field is mapped on the database column "s_proc_log" ( type "varchar", NotNull : false )
     * @return the field value
     */
    public String getSProcLog() {
        return this.sProcLog;
    }

    /**
     * Set the "sNotaLog" field value
     * This field is mapped on the database column "s_nota_log" ( type "varchar", NotNull : false )
     * @param sNotaLog
     */
    public void setSNotaLog(String sNotaLog) {
        this.sNotaLog = sNotaLog;
    }

    /**
     * Get the "sNotaLog" field value
     * This field is mapped on the database column "s_nota_log" ( type "varchar", NotNull : false )
     * @return the field value
     */
    public String getSNotaLog() {
        return this.sNotaLog;
    }


    @Override
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append(idLog);
        sb.append("|");
        sb.append(dInizioElab);
        sb.append("|");
        sb.append(dFineElab);
        sb.append("|");
        sb.append(sProcLog);
        sb.append("|");
        sb.append(sNotaLog);
        return sb.toString(); 
    } 

}