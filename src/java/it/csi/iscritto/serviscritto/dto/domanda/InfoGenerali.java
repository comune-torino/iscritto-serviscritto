
package it.csi.iscritto.serviscritto.dto.domanda;

////{PROTECTED REGION ID(R863778606) ENABLED START////}
/**
 * Inserire qui la documentazione della classe InfoGenerali.
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
public class InfoGenerali implements java.io.Serializable {
	// il serial version UID e' impostato in base a quanto configurato nel modello
	/**
	 * @generated
	 */
	static final long serialVersionUID = 1;

	/**
	 * @generated
	 */
	private java.util.Date dataInizioIscrizioniNidi = null;

	/**
	 * Imposta il valore della property [dataInizioIscrizioniNidi]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setDataInizioIscrizioniNidi(java.util.Date val) {
		dataInizioIscrizioniNidi = (val == null ? null : new java.util.Date(val.getTime()));
	}

	////{PROTECTED REGION ID(R-587701153) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo dataInizioIscrizioniNidi. 
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
	public java.util.Date getDataInizioIscrizioniNidi() {
		return (dataInizioIscrizioniNidi == null ? null : new java.util.Date(dataInizioIscrizioniNidi.getTime()));
	}

	/**
	 * @generated
	 */
	private java.util.Date dataScadenzaIscrizioniNidi = null;

	/**
	 * Imposta il valore della property [dataScadenzaIscrizioniNidi]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setDataScadenzaIscrizioniNidi(java.util.Date val) {
		dataScadenzaIscrizioniNidi = (val == null ? null : new java.util.Date(val.getTime()));
	}

	////{PROTECTED REGION ID(R-1172339738) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo dataScadenzaIscrizioniNidi. 
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
	public java.util.Date getDataScadenzaIscrizioniNidi() {
		return (dataScadenzaIscrizioniNidi == null ? null : new java.util.Date(dataScadenzaIscrizioniNidi.getTime()));
	}

	/**
	 * @generated
	 */
	private java.util.Date dataFineIscrizioniNidi = null;

	/**
	 * Imposta il valore della property [dataFineIscrizioniNidi]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setDataFineIscrizioniNidi(java.util.Date val) {
		dataFineIscrizioniNidi = (val == null ? null : new java.util.Date(val.getTime()));
	}

	////{PROTECTED REGION ID(R-1838620963) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo dataFineIscrizioniNidi. 
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
	public java.util.Date getDataFineIscrizioniNidi() {
		return (dataFineIscrizioniNidi == null ? null : new java.util.Date(dataFineIscrizioniNidi.getTime()));
	}

	/*PROTECTED REGION ID(R-354536789) ENABLED START*/
	/// inserire qui eventuali ridefinizioni di toString, hashCode, equals
	/*PROTECTED REGION END*/
}
