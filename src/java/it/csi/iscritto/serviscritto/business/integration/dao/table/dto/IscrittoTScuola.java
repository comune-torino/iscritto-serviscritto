/*
 * Java bean class for entity "iscritto_t_scuola"
 * Created on 2019-11-25 ( Date ISO 2019-11-25 - Time 12:38:02 )
 * Generated by Telosys Tools Generator ( version 3.0.0 )
 */

package it.csi.iscritto.serviscritto.business.integration.dao.table.dto;

import java.io.Serializable;


/**
 * Java bean for entity "iscritto_t_scuola"
 *
 * @author Telosys Tools Generator
 *
 */
public class IscrittoTScuola implements Serializable {
    private static final long serialVersionUID = 1L;

	public static final String SQL_SELECT_ALL =
		"select " +
		"  id_scuola, " +
		"  cod_scuola, " +
		"  descrizione, " +
		"  indirizzo, " +
		"  fl_eliminata, " +
		"  id_categoria_scu, " +
		"  id_ordine_scuola, " +
		"  id_circoscrizione, " +
		"  telefono, " +
		"  email, " +
		"  id_nido_contiguo " +
		"from iscritto_t_scuola ";

	//////////////////////////////////////////////////////////////////////

	public static final String SQL_INSERT =
		"insert into iscritto_t_scuola (" +
		"  id_scuola, " +
		"  cod_scuola, " +
		"  descrizione, " +
		"  indirizzo, " +
		"  fl_eliminata, " +
		"  id_categoria_scu, " +
		"  id_ordine_scuola, " +
		"  id_circoscrizione, " +
		"  telefono, " +
		"  email, " +
		"  id_nido_contiguo " +
		") " +
		"values (" +
		"  :idScuola, " +
		"  :codScuola, " +
		"  :descrizione, " +
		"  :indirizzo, " +
		"  :flEliminata, " +
		"  :idCategoriaScu, " +
		"  :idOrdineScuola, " +
		"  :idCircoscrizione, " +
		"  :telefono, " +
		"  :email, " +
		"  :idNidoContiguo " +
		")";

	//////////////////////////////////////////////////////////////////////

	public static final String SQL_DELETE =
		"delete from iscritto_t_scuola where " +
		"  id_scuola = :idScuola ";

	//////////////////////////////////////////////////////////////////////

	public static final String SQL_COUNT_ALL =
		"select count(*) from iscritto_t_scuola";

	//////////////////////////////////////////////////////////////////////


    private Long       idScuola     ; // Id or Primary Key

    private String     codScuola    ;
    private String     descrizione  ;
    private String     indirizzo    ;
    private String     flEliminata  ;
    private Long       idCategoriaScu ;
    private Long       idOrdineScuola ;
    private Long       idCircoscrizione ;
    private String     telefono     ;
    private String     email        ;
    private Long       idNidoContiguo ;

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
     * Set the "codScuola" field value
     * This field is mapped on the database column "cod_scuola" ( type "varchar", NotNull : true )
     * @param codScuola
     */
    public void setCodScuola(String codScuola) {
        this.codScuola = codScuola;
    }

    /**
     * Get the "codScuola" field value
     * This field is mapped on the database column "cod_scuola" ( type "varchar", NotNull : true )
     * @return the field value
     */
    public String getCodScuola() {
        return this.codScuola;
    }

    /**
     * Set the "descrizione" field value
     * This field is mapped on the database column "descrizione" ( type "varchar", NotNull : true )
     * @param descrizione
     */
    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    /**
     * Get the "descrizione" field value
     * This field is mapped on the database column "descrizione" ( type "varchar", NotNull : true )
     * @return the field value
     */
    public String getDescrizione() {
        return this.descrizione;
    }

    /**
     * Set the "indirizzo" field value
     * This field is mapped on the database column "indirizzo" ( type "varchar", NotNull : true )
     * @param indirizzo
     */
    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    /**
     * Get the "indirizzo" field value
     * This field is mapped on the database column "indirizzo" ( type "varchar", NotNull : true )
     * @return the field value
     */
    public String getIndirizzo() {
        return this.indirizzo;
    }

    /**
     * Set the "flEliminata" field value
     * This field is mapped on the database column "fl_eliminata" ( type "varchar", NotNull : true )
     * @param flEliminata
     */
    public void setFlEliminata(String flEliminata) {
        this.flEliminata = flEliminata;
    }

    /**
     * Get the "flEliminata" field value
     * This field is mapped on the database column "fl_eliminata" ( type "varchar", NotNull : true )
     * @return the field value
     */
    public String getFlEliminata() {
        return this.flEliminata;
    }

    /**
     * Set the "idCategoriaScu" field value
     * This field is mapped on the database column "id_categoria_scu" ( type "int4", NotNull : true )
     * @param idCategoriaScu
     */
    public void setIdCategoriaScu(Long idCategoriaScu) {
        this.idCategoriaScu = idCategoriaScu;
    }

    /**
     * Get the "idCategoriaScu" field value
     * This field is mapped on the database column "id_categoria_scu" ( type "int4", NotNull : true )
     * @return the field value
     */
    public Long getIdCategoriaScu() {
        return this.idCategoriaScu;
    }

    /**
     * Set the "idOrdineScuola" field value
     * This field is mapped on the database column "id_ordine_scuola" ( type "int4", NotNull : true )
     * @param idOrdineScuola
     */
    public void setIdOrdineScuola(Long idOrdineScuola) {
        this.idOrdineScuola = idOrdineScuola;
    }

    /**
     * Get the "idOrdineScuola" field value
     * This field is mapped on the database column "id_ordine_scuola" ( type "int4", NotNull : true )
     * @return the field value
     */
    public Long getIdOrdineScuola() {
        return this.idOrdineScuola;
    }

    /**
     * Set the "idCircoscrizione" field value
     * This field is mapped on the database column "id_circoscrizione" ( type "int4", NotNull : true )
     * @param idCircoscrizione
     */
    public void setIdCircoscrizione(Long idCircoscrizione) {
        this.idCircoscrizione = idCircoscrizione;
    }

    /**
     * Get the "idCircoscrizione" field value
     * This field is mapped on the database column "id_circoscrizione" ( type "int4", NotNull : true )
     * @return the field value
     */
    public Long getIdCircoscrizione() {
        return this.idCircoscrizione;
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

    /**
     * Set the "email" field value
     * This field is mapped on the database column "email" ( type "varchar", NotNull : false )
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Get the "email" field value
     * This field is mapped on the database column "email" ( type "varchar", NotNull : false )
     * @return the field value
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Set the "idNidoContiguo" field value
     * This field is mapped on the database column "id_nido_contiguo" ( type "int4", NotNull : false )
     * @param idNidoContiguo
     */
    public void setIdNidoContiguo(Long idNidoContiguo) {
        this.idNidoContiguo = idNidoContiguo;
    }

    /**
     * Get the "idNidoContiguo" field value
     * This field is mapped on the database column "id_nido_contiguo" ( type "int4", NotNull : false )
     * @return the field value
     */
    public Long getIdNidoContiguo() {
        return this.idNidoContiguo;
    }


    @Override
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append(idScuola);
        sb.append("|");
        sb.append(codScuola);
        sb.append("|");
        sb.append(descrizione);
        sb.append("|");
        sb.append(indirizzo);
        sb.append("|");
        sb.append(flEliminata);
        sb.append("|");
        sb.append(idCategoriaScu);
        sb.append("|");
        sb.append(idOrdineScuola);
        sb.append("|");
        sb.append(idCircoscrizione);
        sb.append("|");
        sb.append(telefono);
        sb.append("|");
        sb.append(email);
        sb.append("|");
        sb.append(idNidoContiguo);
        return sb.toString(); 
    } 

}
