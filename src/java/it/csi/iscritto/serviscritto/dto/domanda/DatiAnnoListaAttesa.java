
package it.csi.iscritto.serviscritto.dto.domanda;

////{PROTECTED REGION ID(R75360822) ENABLED START////}
/**
 * Inserire qui la documentazione della classe DatiAnnoListaAttesa.
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
public class DatiAnnoListaAttesa implements java.io.Serializable {
	// il serial version UID e' impostato in base a quanto configurato nel modello
	/**
	 * @generated
	 */
	static final long serialVersionUID = 1;

	/**
	 * @generated
	 */
	private java.lang.String annoScolastico = null;

	/**
	 * Imposta il valore della property [annoScolastico]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setAnnoScolastico(java.lang.String val) {
		annoScolastico = val;
	}

	////{PROTECTED REGION ID(R-367749052) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo annoScolastico. 
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
	public java.lang.String getAnnoScolastico() {
		return annoScolastico;
	}

	/**
	 * @generated
	 */
	private java.lang.String scuola = null;

	/**
	 * Imposta il valore della property [scuola]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setScuola(java.lang.String val) {
		scuola = val;
	}

	////{PROTECTED REGION ID(R1465789845) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo scuola. 
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
	public java.lang.String getScuola() {
		return scuola;
	}

	/*PROTECTED REGION ID(R-1150337699) ENABLED START*/
	/// inserire qui eventuali ridefinizioni di toString, hashCode, equals
	/*PROTECTED REGION END*/
}
