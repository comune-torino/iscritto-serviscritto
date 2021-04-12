
package it.csi.iscritto.serviscritto.dto.domanda;

////{PROTECTED REGION ID(R54840644) ENABLED START////}
/**
 * Inserire qui la documentazione della classe DatiListaAttesa.
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
public class DatiListaAttesa implements java.io.Serializable {
	// il serial version UID e' impostato in base a quanto configurato nel modello
	/**
	 * @generated
	 */
	static final long serialVersionUID = 1;

	/**
	 * @generated
	 */
	private it.csi.iscritto.serviscritto.dto.domanda.DatiAnnoListaAttesa primoAnno = null;

	/**
	 * Imposta il valore della property [primoAnno]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setPrimoAnno(it.csi.iscritto.serviscritto.dto.domanda.DatiAnnoListaAttesa val) {
		primoAnno = val;
	}

	////{PROTECTED REGION ID(R-1355523053) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo primoAnno. 
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
	public it.csi.iscritto.serviscritto.dto.domanda.DatiAnnoListaAttesa getPrimoAnno() {
		return primoAnno;
	}

	/**
	 * @generated
	 */
	private it.csi.iscritto.serviscritto.dto.domanda.DatiAnnoListaAttesa secondoAnno = null;

	/**
	 * Imposta il valore della property [secondoAnno]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setSecondoAnno(it.csi.iscritto.serviscritto.dto.domanda.DatiAnnoListaAttesa val) {
		secondoAnno = val;
	}

	////{PROTECTED REGION ID(R1735773189) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo secondoAnno. 
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
	public it.csi.iscritto.serviscritto.dto.domanda.DatiAnnoListaAttesa getSecondoAnno() {
		return secondoAnno;
	}

	/*PROTECTED REGION ID(R-1539370481) ENABLED START*/
	/// inserire qui eventuali ridefinizioni di toString, hashCode, equals
	/*PROTECTED REGION END*/
}
