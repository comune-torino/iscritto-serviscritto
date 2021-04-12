/*
 * Java bean class for entity "iscritto_t_fratello_fre"
 * Created on 2020-02-19 ( Date ISO 2020-02-19 - Time 12:04:12 )
 * Generated by Telosys Tools Generator ( version 3.0.0 )
 */

package it.csi.iscritto.serviscritto.business.integration.dao.table.dto;

import java.io.Serializable;

import java.util.Date;

/**
 * Java bean for entity "iscritto_t_fratello_fre"
 *
 * @author Telosys Tools Generator
 *
 */
public class IscrittoTFratelloFre implements Serializable {
    private static final long serialVersionUID = 1L;

	public static final String SQL_SELECT_ALL =
		"select " +
		"  id_fratello_frequentante, " +
		"  id_domanda_iscrizione, " +
		"  cf_fratello, " +
		"  cognome_fratello, " +
		"  nome_fratello, " +
		"  dt_nascita, " +
		"  sesso, " +
		"  id_tipo_fratello, " +
		"  id_stato_citt " +
		"from iscritto_t_fratello_fre ";

	//////////////////////////////////////////////////////////////////////

	public static final String SQL_INSERT =
		"insert into iscritto_t_fratello_fre (" +
		"  id_fratello_frequentante, " +
		"  id_domanda_iscrizione, " +
		"  cf_fratello, " +
		"  cognome_fratello, " +
		"  nome_fratello, " +
		"  dt_nascita, " +
		"  sesso, " +
		"  id_tipo_fratello, " +
		"  id_stato_citt " +
		") " +
		"values (" +
		"  :idFratelloFrequentante, " +
		"  :idDomandaIscrizione, " +
		"  :cfFratello, " +
		"  :cognomeFratello, " +
		"  :nomeFratello, " +
		"  :dtNascita, " +
		"  :sesso, " +
		"  :idTipoFratello, " +
		"  :idStatoCitt " +
		")";

	//////////////////////////////////////////////////////////////////////

	public static final String SQL_DELETE =
		"delete from iscritto_t_fratello_fre where " +
		"  id_fratello_frequentante = :idFratelloFrequentante ";

	//////////////////////////////////////////////////////////////////////

	public static final String SQL_COUNT_ALL =
		"select count(*) from iscritto_t_fratello_fre";

	//////////////////////////////////////////////////////////////////////


    private Long       idFratelloFrequentante ; // Id or Primary Key

    private Long       idDomandaIscrizione ;
    private String     cfFratello   ;
    private String     cognomeFratello ;
    private String     nomeFratello ;
    private Date       dtNascita    ;
    private String     sesso        ;
    private Long       idTipoFratello ;
    private Long       idStatoCitt  ;

    /**
     * Set the "idFratelloFrequentante" field value
     * This field is mapped on the database column "id_fratello_frequentante" ( type "int4", NotNull : true )
     * @param idFratelloFrequentante
     */
	public void setIdFratelloFrequentante(Long idFratelloFrequentante) {
        this.idFratelloFrequentante = idFratelloFrequentante ;
    }

    /**
     * Get the "idFratelloFrequentante" field value
     * This field is mapped on the database column "id_fratello_frequentante" ( type "int4", NotNull : true )
     * @return the field value
     */
	public Long getIdFratelloFrequentante() {
        return this.idFratelloFrequentante;
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
     * Set the "cfFratello" field value
     * This field is mapped on the database column "cf_fratello" ( type "varchar", NotNull : true )
     * @param cfFratello
     */
    public void setCfFratello(String cfFratello) {
        this.cfFratello = cfFratello;
    }

    /**
     * Get the "cfFratello" field value
     * This field is mapped on the database column "cf_fratello" ( type "varchar", NotNull : true )
     * @return the field value
     */
    public String getCfFratello() {
        return this.cfFratello;
    }

    /**
     * Set the "cognomeFratello" field value
     * This field is mapped on the database column "cognome_fratello" ( type "varchar", NotNull : true )
     * @param cognomeFratello
     */
    public void setCognomeFratello(String cognomeFratello) {
        this.cognomeFratello = cognomeFratello;
    }

    /**
     * Get the "cognomeFratello" field value
     * This field is mapped on the database column "cognome_fratello" ( type "varchar", NotNull : true )
     * @return the field value
     */
    public String getCognomeFratello() {
        return this.cognomeFratello;
    }

    /**
     * Set the "nomeFratello" field value
     * This field is mapped on the database column "nome_fratello" ( type "varchar", NotNull : true )
     * @param nomeFratello
     */
    public void setNomeFratello(String nomeFratello) {
        this.nomeFratello = nomeFratello;
    }

    /**
     * Get the "nomeFratello" field value
     * This field is mapped on the database column "nome_fratello" ( type "varchar", NotNull : true )
     * @return the field value
     */
    public String getNomeFratello() {
        return this.nomeFratello;
    }

    /**
     * Set the "dtNascita" field value
     * This field is mapped on the database column "dt_nascita" ( type "timestamp", NotNull : true )
     * @param dtNascita
     */
    public void setDtNascita(Date dtNascita) {
        this.dtNascita = dtNascita;
    }

    /**
     * Get the "dtNascita" field value
     * This field is mapped on the database column "dt_nascita" ( type "timestamp", NotNull : true )
     * @return the field value
     */
    public Date getDtNascita() {
        return this.dtNascita;
    }

    /**
     * Set the "sesso" field value
     * This field is mapped on the database column "sesso" ( type "varchar", NotNull : false )
     * @param sesso
     */
    public void setSesso(String sesso) {
        this.sesso = sesso;
    }

    /**
     * Get the "sesso" field value
     * This field is mapped on the database column "sesso" ( type "varchar", NotNull : false )
     * @return the field value
     */
    public String getSesso() {
        return this.sesso;
    }

    /**
     * Set the "idTipoFratello" field value
     * This field is mapped on the database column "id_tipo_fratello" ( type "int4", NotNull : false )
     * @param idTipoFratello
     */
    public void setIdTipoFratello(Long idTipoFratello) {
        this.idTipoFratello = idTipoFratello;
    }

    /**
     * Get the "idTipoFratello" field value
     * This field is mapped on the database column "id_tipo_fratello" ( type "int4", NotNull : false )
     * @return the field value
     */
    public Long getIdTipoFratello() {
        return this.idTipoFratello;
    }

    /**
     * Set the "idStatoCitt" field value
     * This field is mapped on the database column "id_stato_citt" ( type "int4", NotNull : false )
     * @param idStatoCitt
     */
    public void setIdStatoCitt(Long idStatoCitt) {
        this.idStatoCitt = idStatoCitt;
    }

    /**
     * Get the "idStatoCitt" field value
     * This field is mapped on the database column "id_stato_citt" ( type "int4", NotNull : false )
     * @return the field value
     */
    public Long getIdStatoCitt() {
        return this.idStatoCitt;
    }


    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append(idFratelloFrequentante);
        sb.append("|");
        sb.append(idDomandaIscrizione);
        sb.append("|");
        sb.append(cfFratello);
        sb.append("|");
        sb.append(cognomeFratello);
        sb.append("|");
        sb.append(nomeFratello);
        sb.append("|");
        sb.append(dtNascita);
        sb.append("|");
        sb.append(sesso);
        sb.append("|");
        sb.append(idTipoFratello);
        sb.append("|");
        sb.append(idStatoCitt);
        return sb.toString();
    }

}
