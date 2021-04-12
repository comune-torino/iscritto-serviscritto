/*
 * Java bean class for entity "iscritto_r_scuola_pre"
 * Created on 2019-04-24 ( Date ISO 2019-04-24 - Time 14:32:33 )
 * Generated by Telosys Tools Generator ( version 3.0.0 )
 */

package it.csi.iscritto.serviscritto.business.integration.dao.table.dto;

import java.io.Serializable;

import java.util.Date;

/**
 * Java bean for entity "iscritto_r_scuola_pre"
 *
 * @author Telosys Tools Generator
 *
 */
public class IscrittoRScuolaPre implements Serializable {
    private static final long serialVersionUID = 1L;

	public static final String SQL_SELECT_ALL =
		"select " +
		"  posizione, " +
		"  id_domanda_iscrizione, " +
		"  id_scuola, " +
		"  fl_fuori_termine, " +
		"  id_tipo_frequenza, " +
		"  punteggio, " +
		"  fl_rinuncia, " +
		"  id_stato_scu, " +
		"  dt_stato " +
		"from iscritto_r_scuola_pre ";

	//////////////////////////////////////////////////////////////////////

	public static final String SQL_INSERT =
		"insert into iscritto_r_scuola_pre (" +
		"  posizione, " +
		"  id_domanda_iscrizione, " +
		"  id_scuola, " +
		"  fl_fuori_termine, " +
		"  id_tipo_frequenza, " +
		"  punteggio, " +
		"  fl_rinuncia, " +
		"  id_stato_scu, " +
		"  dt_stato " +
		") " +
		"values (" +
		"  :posizione, " +
		"  :idDomandaIscrizione, " +
		"  :idScuola, " +
		"  :flFuoriTermine, " +
		"  :idTipoFrequenza, " +
		"  :punteggio, " +
		"  :flRinuncia, " +
		"  :idStatoScu, " +
		"  :dtStato " +
		")";

	//////////////////////////////////////////////////////////////////////

	public static final String SQL_DELETE =
		"delete from iscritto_r_scuola_pre where " +
		"  id_domanda_iscrizione = :idDomandaIscrizione and " +
		"  id_scuola = :idScuola and " +
		"  id_tipo_frequenza = :idTipoFrequenza ";

	//////////////////////////////////////////////////////////////////////

	public static final String SQL_COUNT_ALL =
		"select count(*) from iscritto_r_scuola_pre";

	//////////////////////////////////////////////////////////////////////


    private Long       idDomandaIscrizione ; // Id or Primary Key
    private Long       idScuola     ; // Id or Primary Key
    private Long       idTipoFrequenza ; // Id or Primary Key

    private Integer    posizione    ;
    private String     flFuoriTermine ;
    private Integer    punteggio    ;
    private String     flRinuncia   ;
    private Long       idStatoScu   ;
    private Date       dtStato      ;

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
     * Set the "idScuola" field value
     * This field is mapped on the database column "id_scuola" ( type "int4", NotNull : true )
     * @param idScuola
     */
	public void setIdScuola(Long idScuola) {
        this.idScuola = idScuola ;
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
     * Set the "idTipoFrequenza" field value
     * This field is mapped on the database column "id_tipo_frequenza" ( type "int4", NotNull : true )
     * @param idTipoFrequenza
     */
	public void setIdTipoFrequenza(Long idTipoFrequenza) {
        this.idTipoFrequenza = idTipoFrequenza ;
    }

    /**
     * Get the "idTipoFrequenza" field value
     * This field is mapped on the database column "id_tipo_frequenza" ( type "int4", NotNull : true )
     * @return the field value
     */
	public Long getIdTipoFrequenza() {
        return this.idTipoFrequenza;
    }

    /**
     * Set the "posizione" field value
     * This field is mapped on the database column "posizione" ( type "int4", NotNull : true )
     * @param posizione
     */
    public void setPosizione(Integer posizione) {
        this.posizione = posizione;
    }

    /**
     * Get the "posizione" field value
     * This field is mapped on the database column "posizione" ( type "int4", NotNull : true )
     * @return the field value
     */
    public Integer getPosizione() {
        return this.posizione;
    }

    /**
     * Set the "flFuoriTermine" field value
     * This field is mapped on the database column "fl_fuori_termine" ( type "varchar", NotNull : true )
     * @param flFuoriTermine
     */
    public void setFlFuoriTermine(String flFuoriTermine) {
        this.flFuoriTermine = flFuoriTermine;
    }

    /**
     * Get the "flFuoriTermine" field value
     * This field is mapped on the database column "fl_fuori_termine" ( type "varchar", NotNull : true )
     * @return the field value
     */
    public String getFlFuoriTermine() {
        return this.flFuoriTermine;
    }

    /**
     * Set the "punteggio" field value
     * This field is mapped on the database column "punteggio" ( type "int4", NotNull : false )
     * @param punteggio
     */
    public void setPunteggio(Integer punteggio) {
        this.punteggio = punteggio;
    }

    /**
     * Get the "punteggio" field value
     * This field is mapped on the database column "punteggio" ( type "int4", NotNull : false )
     * @return the field value
     */
    public Integer getPunteggio() {
        return this.punteggio;
    }

    /**
     * Set the "flRinuncia" field value
     * This field is mapped on the database column "fl_rinuncia" ( type "varchar", NotNull : true )
     * @param flRinuncia
     */
    public void setFlRinuncia(String flRinuncia) {
        this.flRinuncia = flRinuncia;
    }

    /**
     * Get the "flRinuncia" field value
     * This field is mapped on the database column "fl_rinuncia" ( type "varchar", NotNull : true )
     * @return the field value
     */
    public String getFlRinuncia() {
        return this.flRinuncia;
    }

    /**
     * Set the "idStatoScu" field value
     * This field is mapped on the database column "id_stato_scu" ( type "int4", NotNull : false )
     * @param idStatoScu
     */
    public void setIdStatoScu(Long idStatoScu) {
        this.idStatoScu = idStatoScu;
    }

    /**
     * Get the "idStatoScu" field value
     * This field is mapped on the database column "id_stato_scu" ( type "int4", NotNull : false )
     * @return the field value
     */
    public Long getIdStatoScu() {
        return this.idStatoScu;
    }

    /**
     * Set the "dtStato" field value
     * This field is mapped on the database column "dt_stato" ( type "timestamp", NotNull : false )
     * @param dtStato
     */
    public void setDtStato(Date dtStato) {
        this.dtStato = dtStato;
    }

    /**
     * Get the "dtStato" field value
     * This field is mapped on the database column "dt_stato" ( type "timestamp", NotNull : false )
     * @return the field value
     */
    public Date getDtStato() {
        return this.dtStato;
    }


    @Override
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append(posizione);
        sb.append("|");
        sb.append(idDomandaIscrizione);
        sb.append("|");
        sb.append(idScuola);
        sb.append("|");
        sb.append(flFuoriTermine);
        sb.append("|");
        sb.append(idTipoFrequenza);
        sb.append("|");
        sb.append(punteggio);
        sb.append("|");
        sb.append(flRinuncia);
        sb.append("|");
        sb.append(idStatoScu);
        sb.append("|");
        sb.append(dtStato);
        return sb.toString(); 
    } 

}