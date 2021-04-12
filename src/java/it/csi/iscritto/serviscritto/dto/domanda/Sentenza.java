
package it.csi.iscritto.serviscritto.dto.domanda;

////{PROTECTED REGION ID(R-585004921) ENABLED START////}
/**
 * Inserire qui la documentazione della classe Sentenza.
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
public class Sentenza implements java.io.Serializable {
	// il serial version UID e' impostato in base a quanto configurato nel modello
	/**
	 * @generated
	 */
	static final long serialVersionUID = 1;

	/**
	 * @generated
	 */
	private java.lang.String numero = null;

	/**
	 * Imposta il valore della property [numero]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setNumero(java.lang.String val) {
		numero = val;
	}

	////{PROTECTED REGION ID(R-1214402717) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo numero. 
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
	public java.lang.String getNumero() {
		return numero;
	}

	/**
	 * @generated
	 */
	private java.lang.String data = null;

	/**
	 * Imposta il valore della property [data]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setData(java.lang.String val) {
		data = val;
	}

	////{PROTECTED REGION ID(R-390406991) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo data. 
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
	public java.lang.String getData() {
		return data;
	}

	/**
	 * @generated
	 */
	private java.lang.String tribunale = null;

	/**
	 * Imposta il valore della property [tribunale]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setTribunale(java.lang.String val) {
		tribunale = val;
	}

	////{PROTECTED REGION ID(R6806019) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo tribunale. 
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
	public java.lang.String getTribunale() {
		return tribunale;
	}

	/*PROTECTED REGION ID(R-1068484046) ENABLED START*/
	/// inserire qui eventuali ridefinizioni di toString, hashCode, equals
	/*PROTECTED REGION END*/
}
