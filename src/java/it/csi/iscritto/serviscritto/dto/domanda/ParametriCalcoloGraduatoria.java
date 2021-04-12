
package it.csi.iscritto.serviscritto.dto.domanda;

////{PROTECTED REGION ID(R-160706452) ENABLED START////}
/**
 * Inserire qui la documentazione della classe ParametriCalcoloGraduatoria.
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
public class ParametriCalcoloGraduatoria implements java.io.Serializable {
	// il serial version UID e' impostato in base a quanto configurato nel modello
	/**
	 * @generated
	 */
	static final long serialVersionUID = 1;

	/**
	 * @generated
	 */
	private java.lang.String codiceGraduatoria = null;

	/**
	 * Imposta il valore della property [codiceGraduatoria]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setCodiceGraduatoria(java.lang.String val) {
		codiceGraduatoria = val;
	}

	////{PROTECTED REGION ID(R1962156182) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo codiceGraduatoria. 
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
	public java.lang.String getCodiceGraduatoria() {
		return codiceGraduatoria;
	}

	/**
	 * @generated
	 */
	private java.lang.String ordineScuola = null;

	/**
	 * Imposta il valore della property [ordineScuola]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setOrdineScuola(java.lang.String val) {
		ordineScuola = val;
	}

	////{PROTECTED REGION ID(R-1208128374) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo ordineScuola. 
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
	public java.lang.String getOrdineScuola() {
		return ordineScuola;
	}

	/**
	 * @generated
	 */
	private java.lang.Integer step = null;

	/**
	 * Imposta il valore della property [step]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setStep(java.lang.Integer val) {
		step = val;
	}

	////{PROTECTED REGION ID(R1110163768) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo step. 
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
	public java.lang.Integer getStep() {
		return step;
	}

	/**
	 * @generated
	 */
	private java.lang.String codiceStato = null;

	/**
	 * Imposta il valore della property [codiceStato]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setCodiceStato(java.lang.String val) {
		codiceStato = val;
	}

	////{PROTECTED REGION ID(R713955932) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo codiceStato. 
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
	public java.lang.String getCodiceStato() {
		return codiceStato;
	}

	/**
	 * @generated
	 */
	private java.lang.String codiceStatoDaCalcolare = null;

	/**
	 * Imposta il valore della property [codiceStatoDaCalcolare]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setCodiceStatoDaCalcolare(java.lang.String val) {
		codiceStatoDaCalcolare = val;
	}

	////{PROTECTED REGION ID(R1719861801) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo codiceStatoDaCalcolare. 
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
	public java.lang.String getCodiceStatoDaCalcolare() {
		return codiceStatoDaCalcolare;
	}

	/*PROTECTED REGION ID(R1038930535) ENABLED START*/
	/// inserire qui eventuali ridefinizioni di toString, hashCode, equals
	/*PROTECTED REGION END*/
}
