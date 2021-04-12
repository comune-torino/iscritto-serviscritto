
package it.csi.iscritto.serviscritto.dto.domanda;

////{PROTECTED REGION ID(R-975968630) ENABLED START////}
/**
 * Inserire qui la documentazione della classe InfoVerifiche.
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
public class InfoVerifiche implements java.io.Serializable {
	// il serial version UID e' impostato in base a quanto configurato nel modello
	/**
	 * @generated
	 */
	static final long serialVersionUID = 1;

	/**
	 * @generated
	 */
	private java.lang.String codCondizione = null;

	/**
	 * Imposta il valore della property [codCondizione]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setCodCondizione(java.lang.String val) {
		codCondizione = val;
	}

	////{PROTECTED REGION ID(R-1988938498) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo codCondizione. 
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
	public java.lang.String getCodCondizione() {
		return codCondizione;
	}

	/**
	 * @generated
	 */
	private java.lang.String descCondizione = null;

	/**
	 * Imposta il valore della property [descCondizione]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setDescCondizione(java.lang.String val) {
		descCondizione = val;
	}

	////{PROTECTED REGION ID(R-946992597) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo descCondizione. 
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
	public java.lang.String getDescCondizione() {
		return descCondizione;
	}

	/**
	 * @generated
	 */
	private java.lang.String codTipoVerifica = null;

	/**
	 * Imposta il valore della property [codTipoVerifica]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setCodTipoVerifica(java.lang.String val) {
		codTipoVerifica = val;
	}

	////{PROTECTED REGION ID(R1222096809) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo codTipoVerifica. 
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
	public java.lang.String getCodTipoVerifica() {
		return codTipoVerifica;
	}

	/**
	 * @generated
	 */
	private java.lang.Integer occorrenze = null;

	/**
	 * Imposta il valore della property [occorrenze]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setOccorrenze(java.lang.Integer val) {
		occorrenze = val;
	}

	////{PROTECTED REGION ID(R-1121301730) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo occorrenze. 
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
	public java.lang.Integer getOccorrenze() {
		return occorrenze;
	}

	/*PROTECTED REGION ID(R1641815625) ENABLED START*/
	/// inserire qui eventuali ridefinizioni di toString, hashCode, equals
	/*PROTECTED REGION END*/
}
