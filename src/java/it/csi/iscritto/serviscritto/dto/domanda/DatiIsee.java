
package it.csi.iscritto.serviscritto.dto.domanda;

////{PROTECTED REGION ID(R-51617413) ENABLED START////}
/**
 * Inserire qui la documentazione della classe DatiIsee.
 * Consigli:
 * <ul>
 * <li> Descrivere il "concetto" rappresentato dall'entita' (qual'&egrave; l'oggetto
 *      del dominio del servizio rappresentato)
 * <li> Se necessario indicare se questo concetto &egrave; mantenuto sugli archivi di
 *      una particolare applicazione
 * <li> Se l'oggetto ha un particolare ciclo di vita (stati, es. creato, da approvare, 
 *      approvato, respinto, annullato.....) si pu&ograve; decidere di descrivere
 *      la state machine qui o nella documentazione dell'interfaccia del servizio
 *      che manipola quest'oggetto
 * </ul>
 * @generated
 */
////{PROTECTED REGION END////}
public class DatiIsee implements java.io.Serializable {
	// il serial version UID e' impostato in base a quanto configurato nel modello
	/**
	 * @generated
	 */
	static final long serialVersionUID = 1;

	/**
	 * @generated
	 */
	private java.lang.Double valore = null;

	/**
	 * Imposta il valore della property [valore]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setValore(java.lang.Double val) {
		valore = val;
	}

	////{PROTECTED REGION ID(R300130652) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo valore. 
	 * Descrivere:
	 * <ul>
	 *      <li>se l'attributo deve essere sempre valoriuzzato o meno
	 *      <li>se ci sono dei vincoli sulla valorizzazione (es. range numerico,
	 *          dimensioni massime in caso di stringa o tipo array, eventuale necessit&agrave;
	 *          di corrispondenza con una particolare codifica, che pu&ograve; essere prefissata
	 *          (es. da un elenco predefinito) oppure dinamica (presente su un archivio
	 *          di un'applicazione)
	 *      <li>se ci sono particolari vincoli di valorizzazione relativi al valore di
	 *          altri attributi della stessa classe.
	 *      <li>...
	 *      </ul>
	 * @generated 
	 */
	////{PROTECTED REGION END////}
	public java.lang.Double getValore() {
		return valore;
	}

	/**
	 * @generated
	 */
	private java.lang.String dataAttestazione = null;

	/**
	 * Imposta il valore della property [dataAttestazione]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setDataAttestazione(java.lang.String val) {
		dataAttestazione = val;
	}

	////{PROTECTED REGION ID(R-1881765664) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo dataAttestazione. 
	 * Descrivere:
	 * <ul>
	 *      <li>se l'attributo deve essere sempre valoriuzzato o meno
	 *      <li>se ci sono dei vincoli sulla valorizzazione (es. range numerico,
	 *          dimensioni massime in caso di stringa o tipo array, eventuale necessit&agrave;
	 *          di corrispondenza con una particolare codifica, che pu&ograve; essere prefissata
	 *          (es. da un elenco predefinito) oppure dinamica (presente su un archivio
	 *          di un'applicazione)
	 *      <li>se ci sono particolari vincoli di valorizzazione relativi al valore di
	 *          altri attributi della stessa classe.
	 *      <li>...
	 *      </ul>
	 * @generated 
	 */
	////{PROTECTED REGION END////}
	public java.lang.String getDataAttestazione() {
		return dataAttestazione;
	}

	/*PROTECTED REGION ID(R-1150896962) ENABLED START*/
	/// inserire qui eventuali ridefinizioni di toString, hashCode, equals
	/*PROTECTED REGION END*/
}
