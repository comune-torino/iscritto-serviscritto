
package it.csi.iscritto.serviscritto.dto.domanda;

////{PROTECTED REGION ID(R1298354126) ENABLED START////}
/**
 * Inserire qui la documentazione della classe Soggetto3.
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
public class Soggetto3 implements java.io.Serializable {
	// il serial version UID e' impostato in base a quanto configurato nel modello
	/**
	 * @generated
	 */
	static final long serialVersionUID = 1;

	/**
	 * @generated
	 */
	private java.lang.Boolean stato = null;

	/**
	 * Imposta il valore della property [stato]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setStato(java.lang.Boolean val) {
		stato = val;
	}

	////{PROTECTED REGION ID(R-848878195) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo stato. 
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
	public java.lang.Boolean getStato() {
		return stato;
	}

	/**
	 * @generated
	 */
	private it.csi.iscritto.serviscritto.dto.domanda.DatiSoggetto3 dati = null;

	/**
	 * Imposta il valore della property [dati]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setDati(it.csi.iscritto.serviscritto.dto.domanda.DatiSoggetto3 val) {
		dati = val;
	}

	////{PROTECTED REGION ID(R1219078272) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo dati. 
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
	public it.csi.iscritto.serviscritto.dto.domanda.DatiSoggetto3 getDati() {
		return dati;
	}

	/**
	 * @generated
	 */
	private java.lang.Boolean residenzaNao = null;

	/**
	 * Imposta il valore della property [residenzaNao]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setResidenzaNao(java.lang.Boolean val) {
		residenzaNao = val;
	}

	////{PROTECTED REGION ID(R-1692531169) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo residenzaNao. 
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
	public java.lang.Boolean getResidenzaNao() {
		return residenzaNao;
	}

	/*PROTECTED REGION ID(R-827996923) ENABLED START*/
	/// inserire qui eventuali ridefinizioni di toString, hashCode, equals
	/*PROTECTED REGION END*/
}
