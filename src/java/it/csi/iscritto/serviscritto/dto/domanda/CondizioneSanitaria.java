
package it.csi.iscritto.serviscritto.dto.domanda;

////{PROTECTED REGION ID(R1308128773) ENABLED START////}
/**
 * Inserire qui la documentazione della classe CondizioneSanitaria.
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
public class CondizioneSanitaria implements java.io.Serializable {
	// il serial version UID e' impostato in base a quanto configurato nel modello
	/**
	 * @generated
	 */
	static final long serialVersionUID = 1;

	/**
	 * @generated
	 */
	private it.csi.iscritto.serviscritto.dto.domanda.Disabilita disabilita = null;

	/**
	 * Imposta il valore della property [disabilita]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setDisabilita(it.csi.iscritto.serviscritto.dto.domanda.Disabilita val) {
		disabilita = val;
	}

	////{PROTECTED REGION ID(R707725449) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo disabilita. 
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
	public it.csi.iscritto.serviscritto.dto.domanda.Disabilita getDisabilita() {
		return disabilita;
	}

	/**
	 * @generated
	 */
	private it.csi.iscritto.serviscritto.dto.domanda.ProblemiSalute problemiSalute = null;

	/**
	 * Imposta il valore della property [problemiSalute]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setProblemiSalute(it.csi.iscritto.serviscritto.dto.domanda.ProblemiSalute val) {
		problemiSalute = val;
	}

	////{PROTECTED REGION ID(R-878365545) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo problemiSalute. 
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
	public it.csi.iscritto.serviscritto.dto.domanda.ProblemiSalute getProblemiSalute() {
		return problemiSalute;
	}

	/**
	 * @generated
	 */
	private it.csi.iscritto.serviscritto.dto.domanda.Gravidanza gravidanza = null;

	/**
	 * Imposta il valore della property [gravidanza]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setGravidanza(it.csi.iscritto.serviscritto.dto.domanda.Gravidanza val) {
		gravidanza = val;
	}

	////{PROTECTED REGION ID(R1378320852) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo gravidanza. 
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
	public it.csi.iscritto.serviscritto.dto.domanda.Gravidanza getGravidanza() {
		return gravidanza;
	}

	/*PROTECTED REGION ID(R653732142) ENABLED START*/
	/// inserire qui eventuali ridefinizioni di toString, hashCode, equals
	/*PROTECTED REGION END*/
}
