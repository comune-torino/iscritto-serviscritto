
package it.csi.iscritto.serviscritto.dto.domanda;

////{PROTECTED REGION ID(R-1171358399) ENABLED START////}
/**
 * Inserire qui la documentazione della classe Disoccupato.
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
public class Disoccupato implements java.io.Serializable {
	// il serial version UID e' impostato in base a quanto configurato nel modello
	/**
	 * @generated
	 */
	static final long serialVersionUID = 1;

	/**
	 * @generated
	 */
	private java.lang.String dataDichiarazione = null;

	/**
	 * Imposta il valore della property [dataDichiarazione]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setDataDichiarazione(java.lang.String val) {
		dataDichiarazione = val;
	}

	////{PROTECTED REGION ID(R1332027611) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo dataDichiarazione. 
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
	public java.lang.String getDataDichiarazione() {
		return dataDichiarazione;
	}

	/**
	 * @generated
	 */
	private java.lang.String soggettoDichiarazione = null;

	/**
	 * Imposta il valore della property [soggettoDichiarazione]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setSoggettoDichiarazione(java.lang.String val) {
		soggettoDichiarazione = val;
	}

	////{PROTECTED REGION ID(R-591036193) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo soggettoDichiarazione. 
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
	public java.lang.String getSoggettoDichiarazione() {
		return soggettoDichiarazione;
	}

	/**
	 * @generated
	 */
	private it.csi.iscritto.serviscritto.dto.domanda.DatiCiDisoccupato datiCi = null;

	/**
	 * Imposta il valore della property [datiCi]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setDatiCi(it.csi.iscritto.serviscritto.dto.domanda.DatiCiDisoccupato val) {
		datiCi = val;
	}

	////{PROTECTED REGION ID(R1766038585) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo datiCi. 
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
	public it.csi.iscritto.serviscritto.dto.domanda.DatiCiDisoccupato getDatiCi() {
		return datiCi;
	}

	/*PROTECTED REGION ID(R-1958019726) ENABLED START*/
	/// inserire qui eventuali ridefinizioni di toString, hashCode, equals
	/*PROTECTED REGION END*/
}
