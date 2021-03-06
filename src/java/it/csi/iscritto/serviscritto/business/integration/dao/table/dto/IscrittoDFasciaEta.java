/*
 * Java bean class for entity "iscritto_d_fascia_eta"
 * Created on 2019-04-01 ( Date ISO 2019-04-01 - Time 09:21:20 )
 * Generated by Telosys Tools Generator ( version 3.0.0 )
 */

package it.csi.iscritto.serviscritto.business.integration.dao.table.dto;

import java.io.Serializable;


/**
 * Java bean for entity "iscritto_d_fascia_eta"
 *
 * @author Telosys Tools Generator
 *
 */
public class IscrittoDFasciaEta implements Serializable {
    private static final long serialVersionUID = 1L;

	public static final String SQL_SELECT_ALL =
		"select " +
		"  id_fascia_eta, " +
		"  cod_fascia_eta, " +
		"  descrizione " +
		"from iscritto_d_fascia_eta ";

	//////////////////////////////////////////////////////////////////////

	public static final String SQL_INSERT =
		"insert into iscritto_d_fascia_eta (" +
		"  id_fascia_eta, " +
		"  cod_fascia_eta, " +
		"  descrizione " +
		") " +
		"values (" +
		"  :idFasciaEta, " +
		"  :codFasciaEta, " +
		"  :descrizione " +
		")";

	//////////////////////////////////////////////////////////////////////

	public static final String SQL_DELETE =
		"delete from iscritto_d_fascia_eta where " +
		"  id_fascia_eta = :idFasciaEta ";

	//////////////////////////////////////////////////////////////////////

	public static final String SQL_COUNT_ALL =
		"select count(*) from iscritto_d_fascia_eta";

	//////////////////////////////////////////////////////////////////////


    private Long       idFasciaEta  ; // Id or Primary Key

    private String     codFasciaEta ;
    private String     descrizione  ;

    /**
     * Set the "idFasciaEta" field value
     * This field is mapped on the database column "id_fascia_eta" ( type "int4", NotNull : true )
     * @param idFasciaEta
     */
	public void setIdFasciaEta(Long idFasciaEta) {
        this.idFasciaEta = idFasciaEta ;
    }

    /**
     * Get the "idFasciaEta" field value
     * This field is mapped on the database column "id_fascia_eta" ( type "int4", NotNull : true )
     * @return the field value
     */
	public Long getIdFasciaEta() {
        return this.idFasciaEta;
    }

    /**
     * Set the "codFasciaEta" field value
     * This field is mapped on the database column "cod_fascia_eta" ( type "varchar", NotNull : true )
     * @param codFasciaEta
     */
    public void setCodFasciaEta(String codFasciaEta) {
        this.codFasciaEta = codFasciaEta;
    }

    /**
     * Get the "codFasciaEta" field value
     * This field is mapped on the database column "cod_fascia_eta" ( type "varchar", NotNull : true )
     * @return the field value
     */
    public String getCodFasciaEta() {
        return this.codFasciaEta;
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


    @Override
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append(idFasciaEta);
        sb.append("|");
        sb.append(codFasciaEta);
        sb.append("|");
        sb.append(descrizione);
        return sb.toString(); 
    } 

}
