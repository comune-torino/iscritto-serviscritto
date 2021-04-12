
package it.csi.iscritto.serviscritto.dto.domanda;

////{PROTECTED REGION ID(R-501903563) ENABLED START////}
/**
 * Inserire qui la documentazione della classe Documento.
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
public class Documento implements java.io.Serializable {
	// il serial version UID e' impostato in base a quanto configurato nel modello
	/**
	 * @generated
	 */
	static final long serialVersionUID = 1;

	/**
	 * @generated
	 */
	private java.lang.Long id = null;

	/**
	 * Imposta il valore della property [id]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setId(java.lang.Long val) {
		id = val;
	}

	////{PROTECTED REGION ID(R-1292983536) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo id. 
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
	public java.lang.Long getId() {
		return id;
	}

	/**
	 * @generated
	 */
	private java.lang.String protocollo = null;

	/**
	 * Imposta il valore della property [protocollo]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setProtocollo(java.lang.String val) {
		protocollo = val;
	}

	////{PROTECTED REGION ID(R1269376784) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo protocollo. 
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
	public java.lang.String getProtocollo() {
		return protocollo;
	}

	/**
	 * @generated
	 */
	private it.csi.iscritto.serviscritto.dto.domanda.File file = null;

	/**
	 * Imposta il valore della property [file]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setFile(it.csi.iscritto.serviscritto.dto.domanda.File val) {
		file = val;
	}

	////{PROTECTED REGION ID(R-1311710671) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo file. 
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
	public it.csi.iscritto.serviscritto.dto.domanda.File getFile() {
		return file;
	}

	/**
	 * @generated
	 */
	private java.lang.Boolean eliminato = null;

	/**
	 * Imposta il valore della property [eliminato]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setEliminato(java.lang.Boolean val) {
		eliminato = val;
	}

	////{PROTECTED REGION ID(R56106647) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo eliminato. 
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
	public java.lang.Boolean getEliminato() {
		return eliminato;
	}

	/**
	 * @generated
	 */
	private java.util.Date dataInserimento = null;

	/**
	 * Imposta il valore della property [dataInserimento]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setDataInserimento(java.util.Date val) {
		dataInserimento = (val == null ? null : new java.util.Date(val.getTime()));
	}

	////{PROTECTED REGION ID(R924318468) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo dataInserimento. 
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
	public java.util.Date getDataInserimento() {
		return (dataInserimento == null ? null : new java.util.Date(dataInserimento.getTime()));
	}

	/*PROTECTED REGION ID(R-829266370) ENABLED START*/
	/// inserire qui eventuali ridefinizioni di toString, hashCode, equals
	/*PROTECTED REGION END*/
}
