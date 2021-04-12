/*
 * Java bean class for entity "iscritto_l_audit_log"
 * Created on 2019-04-01 ( Date ISO 2019-04-01 - Time 09:21:21 )
 * Generated by Telosys Tools Generator ( version 3.0.0 )
 */

package it.csi.iscritto.serviscritto.business.integration.dao.table.dto;

import java.io.Serializable;

import java.util.Date;

/**
 * Java bean for entity "iscritto_l_audit_log"
 *
 * @author Telosys Tools Generator
 *
 */
public class IscrittoLAuditLog implements Serializable {
    private static final long serialVersionUID = 1L;

	public static final String SQL_SELECT_ALL =
		"select " +
		"  data_ora, " +
		"  id_app, " +
		"  ip_address, " +
		"  utente, " +
		"  operazione, " +
		"  ogg_oper, " +
		"  key_oper " +
		"from iscritto_l_audit_log ";

	//////////////////////////////////////////////////////////////////////

	public static final String SQL_INSERT =
		"insert into iscritto_l_audit_log (" +
		"  data_ora, " +
		"  id_app, " +
		"  ip_address, " +
		"  utente, " +
		"  operazione, " +
		"  ogg_oper, " +
		"  key_oper " +
		") " +
		"values (" +
		"  :dataOra, " +
		"  :idApp, " +
		"  :ipAddress, " +
		"  :utente, " +
		"  :operazione, " +
		"  :oggOper, " +
		"  :keyOper " +
		")";

	//////////////////////////////////////////////////////////////////////


	//////////////////////////////////////////////////////////////////////

	public static final String SQL_COUNT_ALL =
		"select count(*) from iscritto_l_audit_log";

	//////////////////////////////////////////////////////////////////////



    private Date       dataOra      ;
    private String     idApp        ;
    private String     ipAddress    ;
    private String     utente       ;
    private String     operazione   ;
    private String     oggOper      ;
    private String     keyOper      ;


    /**
     * Set the "dataOra" field value
     * This field is mapped on the database column "data_ora" ( type "timestamp", NotNull : false )
     * @param dataOra
     */
    public void setDataOra(Date dataOra) {
        this.dataOra = dataOra;
    }

    /**
     * Get the "dataOra" field value
     * This field is mapped on the database column "data_ora" ( type "timestamp", NotNull : false )
     * @return the field value
     */
    public Date getDataOra() {
        return this.dataOra;
    }

    /**
     * Set the "idApp" field value
     * This field is mapped on the database column "id_app" ( type "varchar", NotNull : false )
     * @param idApp
     */
    public void setIdApp(String idApp) {
        this.idApp = idApp;
    }

    /**
     * Get the "idApp" field value
     * This field is mapped on the database column "id_app" ( type "varchar", NotNull : false )
     * @return the field value
     */
    public String getIdApp() {
        return this.idApp;
    }

    /**
     * Set the "ipAddress" field value
     * This field is mapped on the database column "ip_address" ( type "varchar", NotNull : false )
     * @param ipAddress
     */
    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    /**
     * Get the "ipAddress" field value
     * This field is mapped on the database column "ip_address" ( type "varchar", NotNull : false )
     * @return the field value
     */
    public String getIpAddress() {
        return this.ipAddress;
    }

    /**
     * Set the "utente" field value
     * This field is mapped on the database column "utente" ( type "varchar", NotNull : false )
     * @param utente
     */
    public void setUtente(String utente) {
        this.utente = utente;
    }

    /**
     * Get the "utente" field value
     * This field is mapped on the database column "utente" ( type "varchar", NotNull : false )
     * @return the field value
     */
    public String getUtente() {
        return this.utente;
    }

    /**
     * Set the "operazione" field value
     * This field is mapped on the database column "operazione" ( type "varchar", NotNull : false )
     * @param operazione
     */
    public void setOperazione(String operazione) {
        this.operazione = operazione;
    }

    /**
     * Get the "operazione" field value
     * This field is mapped on the database column "operazione" ( type "varchar", NotNull : false )
     * @return the field value
     */
    public String getOperazione() {
        return this.operazione;
    }

    /**
     * Set the "oggOper" field value
     * This field is mapped on the database column "ogg_oper" ( type "varchar", NotNull : false )
     * @param oggOper
     */
    public void setOggOper(String oggOper) {
        this.oggOper = oggOper;
    }

    /**
     * Get the "oggOper" field value
     * This field is mapped on the database column "ogg_oper" ( type "varchar", NotNull : false )
     * @return the field value
     */
    public String getOggOper() {
        return this.oggOper;
    }

    /**
     * Set the "keyOper" field value
     * This field is mapped on the database column "key_oper" ( type "varchar", NotNull : false )
     * @param keyOper
     */
    public void setKeyOper(String keyOper) {
        this.keyOper = keyOper;
    }

    /**
     * Get the "keyOper" field value
     * This field is mapped on the database column "key_oper" ( type "varchar", NotNull : false )
     * @return the field value
     */
    public String getKeyOper() {
        return this.keyOper;
    }


    @Override
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append(dataOra);
        sb.append("|");
        sb.append(idApp);
        sb.append("|");
        sb.append(ipAddress);
        sb.append("|");
        sb.append(utente);
        sb.append("|");
        sb.append(operazione);
        sb.append("|");
        sb.append(oggOper);
        sb.append("|");
        sb.append(keyOper);
        return sb.toString(); 
    } 

}
