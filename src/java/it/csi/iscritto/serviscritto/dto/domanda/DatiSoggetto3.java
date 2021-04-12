
package it.csi.iscritto.serviscritto.dto.domanda;

////{PROTECTED REGION ID(R749723580) ENABLED START////}
/**
 * Inserire qui la documentazione della classe DatiSoggetto3.
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
public class DatiSoggetto3 implements java.io.Serializable {
	// il serial version UID e' impostato in base a quanto configurato nel modello
	/**
	 * @generated
	 */
	static final long serialVersionUID = 1;

	/**
	 * @generated
	 */
	private it.csi.iscritto.serviscritto.dto.domanda.Anagrafica anagrafica = null;

	/**
	 * Imposta il valore della property [anagrafica]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setAnagrafica(it.csi.iscritto.serviscritto.dto.domanda.Anagrafica val) {
		anagrafica = val;
	}

	////{PROTECTED REGION ID(R-1613291873) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo anagrafica. 
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
	public it.csi.iscritto.serviscritto.dto.domanda.Anagrafica getAnagrafica() {
		return anagrafica;
	}

	/**
	 * @generated
	 */
	private it.csi.iscritto.serviscritto.dto.domanda.LuogoNascita luogoNascita = null;

	/**
	 * Imposta il valore della property [luogoNascita]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setLuogoNascita(it.csi.iscritto.serviscritto.dto.domanda.LuogoNascita val) {
		luogoNascita = val;
	}

	////{PROTECTED REGION ID(R-1665396511) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo luogoNascita. 
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
	public it.csi.iscritto.serviscritto.dto.domanda.LuogoNascita getLuogoNascita() {
		return luogoNascita;
	}

	/**
	 * @generated
	 */
	private it.csi.iscritto.serviscritto.dto.domanda.Residenza residenza = null;

	/**
	 * Imposta il valore della property [residenza]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setResidenza(it.csi.iscritto.serviscritto.dto.domanda.Residenza val) {
		residenza = val;
	}

	////{PROTECTED REGION ID(R-2042334833) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo residenza. 
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
	public it.csi.iscritto.serviscritto.dto.domanda.Residenza getResidenza() {
		return residenza;
	}

	/*PROTECTED REGION ID(R1178559447) ENABLED START*/
	/// inserire qui eventuali ridefinizioni di toString, hashCode, equals
	/*PROTECTED REGION END*/
}
