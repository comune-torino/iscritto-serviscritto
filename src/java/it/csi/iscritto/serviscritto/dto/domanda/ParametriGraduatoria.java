
package it.csi.iscritto.serviscritto.dto.domanda;

////{PROTECTED REGION ID(R81542465) ENABLED START////}
/**
 * Inserire qui la documentazione della classe ParametriGraduatoria.
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
public class ParametriGraduatoria implements java.io.Serializable {
	// il serial version UID e' impostato in base a quanto configurato nel modello
	/**
	 * @generated
	 */
	static final long serialVersionUID = 1;

	/**
	 * @generated
	 */
	private java.lang.String codice = null;

	/**
	 * Imposta il valore della property [codice]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setCodice(java.lang.String val) {
		codice = val;
	}

	////{PROTECTED REGION ID(R-374699372) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo codice. 
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
	public java.lang.String getCodice() {
		return codice;
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

	////{PROTECTED REGION ID(R-1774208115) ENABLED START////}
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

	////{PROTECTED REGION ID(R246466151) ENABLED START////}
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
	private java.util.Date dataUltimoCalcolo = null;

	/**
	 * Imposta il valore della property [dataUltimoCalcolo]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setDataUltimoCalcolo(java.util.Date val) {
		dataUltimoCalcolo = (val == null ? null : new java.util.Date(val.getTime()));
	}

	////{PROTECTED REGION ID(R-1954129084) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo dataUltimoCalcolo. 
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
	public java.util.Date getDataUltimoCalcolo() {
		return (dataUltimoCalcolo == null ? null : new java.util.Date(dataUltimoCalcolo.getTime()));
	}

	/**
	 * @generated
	 */
	private java.lang.Boolean ammissioni = null;

	/**
	 * Imposta il valore della property [ammissioni]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setAmmissioni(java.lang.Boolean val) {
		ammissioni = val;
	}

	////{PROTECTED REGION ID(R1468936330) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo ammissioni. 
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
	public java.lang.Boolean getAmmissioni() {
		return ammissioni;
	}

	/*PROTECTED REGION ID(R187085496) ENABLED START*/
	/// inserire qui eventuali ridefinizioni di toString, hashCode, equals
	/*PROTECTED REGION END*/
}
