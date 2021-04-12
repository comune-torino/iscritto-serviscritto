
package it.csi.iscritto.serviscritto.dto.profilazione;

////{PROTECTED REGION ID(R-340406508) ENABLED START////}
/**
 * Inserire qui la documentazione della classe Profilo.
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
public class Profilo implements java.io.Serializable {
	// il serial version UID e' impostato in base a quanto configurato nel modello
	/**
	 * @generated
	 */
	static final long serialVersionUID = 1;

	/**
	 * @generated
	 */
	private java.lang.String codProfilo = null;

	/**
	 * Imposta il valore della property [codProfilo]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setCodProfilo(java.lang.String val) {
		codProfilo = val;
	}

	////{PROTECTED REGION ID(R-1028878545) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo codProfilo. 
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
	public java.lang.String getCodProfilo() {
		return codProfilo;
	}

	/**
	 * @generated
	 */
	private java.lang.String descProfilo = null;

	/**
	 * Imposta il valore della property [descProfilo]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setDescProfilo(java.lang.String val) {
		descProfilo = val;
	}

	////{PROTECTED REGION ID(R28084814) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo descProfilo. 
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
	public java.lang.String getDescProfilo() {
		return descProfilo;
	}

	/*PROTECTED REGION ID(R2128467205) ENABLED START*/
	/// inserire qui eventuali ridefinizioni di toString, hashCode, equals
	/*PROTECTED REGION END*/
}
