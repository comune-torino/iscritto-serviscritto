/*
 * Java bean class for entity "iscritto_t_servizi_soc"
 * Created on 2019-04-01 ( Date ISO 2019-04-01 - Time 09:21:23 )
 * Generated by Telosys Tools Generator ( version 3.0.0 )
 */

package it.csi.iscritto.serviscritto.business.integration.dao.table.dto;

import java.io.Serializable;


/**
 * Java bean for entity "iscritto_t_servizi_soc"
 *
 * @author Telosys Tools Generator
 *
 */
public class IscrittoTServiziSoc implements Serializable {
    private static final long serialVersionUID = 1L;

	public static final String SQL_SELECT_ALL =
		"select " +
		"  id_domanda_iscrizione, " +
		"  nominativo, " +
		"  servizio, " +
		"  indirizzo, " +
		"  telefono " +
		"from iscritto_t_servizi_soc ";

	//////////////////////////////////////////////////////////////////////

	public static final String SQL_INSERT =
		"insert into iscritto_t_servizi_soc (" +
		"  id_domanda_iscrizione, " +
		"  nominativo, " +
		"  servizio, " +
		"  indirizzo, " +
		"  telefono " +
		") " +
		"values (" +
		"  :idDomandaIscrizione, " +
		"  :nominativo, " +
		"  :servizio, " +
		"  :indirizzo, " +
		"  :telefono " +
		")";

	//////////////////////////////////////////////////////////////////////

	public static final String SQL_DELETE =
		"delete from iscritto_t_servizi_soc where " +
		"  id_domanda_iscrizione = :idDomandaIscrizione ";

	//////////////////////////////////////////////////////////////////////

	public static final String SQL_COUNT_ALL =
		"select count(*) from iscritto_t_servizi_soc";

	//////////////////////////////////////////////////////////////////////


    private Long       idDomandaIscrizione ; // Id or Primary Key

    private String     nominativo   ;
    private String     servizio     ;
    private String     indirizzo    ;
    private String     telefono     ;

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
     * Set the "nominativo" field value
     * This field is mapped on the database column "nominativo" ( type "varchar", NotNull : false )
     * @param nominativo
     */
    public void setNominativo(String nominativo) {
        this.nominativo = nominativo;
    }

    /**
     * Get the "nominativo" field value
     * This field is mapped on the database column "nominativo" ( type "varchar", NotNull : false )
     * @return the field value
     */
    public String getNominativo() {
        return this.nominativo;
    }

    /**
     * Set the "servizio" field value
     * This field is mapped on the database column "servizio" ( type "varchar", NotNull : false )
     * @param servizio
     */
    public void setServizio(String servizio) {
        this.servizio = servizio;
    }

    /**
     * Get the "servizio" field value
     * This field is mapped on the database column "servizio" ( type "varchar", NotNull : false )
     * @return the field value
     */
    public String getServizio() {
        return this.servizio;
    }

    /**
     * Set the "indirizzo" field value
     * This field is mapped on the database column "indirizzo" ( type "varchar", NotNull : false )
     * @param indirizzo
     */
    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    /**
     * Get the "indirizzo" field value
     * This field is mapped on the database column "indirizzo" ( type "varchar", NotNull : false )
     * @return the field value
     */
    public String getIndirizzo() {
        return this.indirizzo;
    }

    /**
     * Set the "telefono" field value
     * This field is mapped on the database column "telefono" ( type "varchar", NotNull : false )
     * @param telefono
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Get the "telefono" field value
     * This field is mapped on the database column "telefono" ( type "varchar", NotNull : false )
     * @return the field value
     */
    public String getTelefono() {
        return this.telefono;
    }


    @Override
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append(idDomandaIscrizione);
        sb.append("|");
        sb.append(nominativo);
        sb.append("|");
        sb.append(servizio);
        sb.append("|");
        sb.append(indirizzo);
        sb.append("|");
        sb.append(telefono);
        return sb.toString(); 
    } 

}
