
package it.csi.iscritto.serviscritto.dto.domanda;

////{PROTECTED REGION ID(R-1151140263) ENABLED START////}
/**
 * Inserire qui la documentazione della classe TestataDomandaIstruttoria.
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
public class TestataDomandaIstruttoria implements java.io.Serializable {
	// il serial version UID e' impostato in base a quanto configurato nel modello
	/**
	 * @generated
	 */
	static final long serialVersionUID = 1;

	/**
	 * @generated
	 */
	private java.lang.Long idDomandaIscrizione = null;

	/**
	 * Imposta il valore della property [idDomandaIscrizione]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setIdDomandaIscrizione(java.lang.Long val) {
		idDomandaIscrizione = val;
	}

	////{PROTECTED REGION ID(R1723758175) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo idDomandaIscrizione. 
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
	public java.lang.Long getIdDomandaIscrizione() {
		return idDomandaIscrizione;
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

	////{PROTECTED REGION ID(R-1033832140) ENABLED START////}
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
	private java.lang.String dataConsegna = null;

	/**
	 * Imposta il valore della property [dataConsegna]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setDataConsegna(java.lang.String val) {
		dataConsegna = val;
	}

	////{PROTECTED REGION ID(R-778013911) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo dataConsegna. 
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
	public java.lang.String getDataConsegna() {
		return dataConsegna;
	}

	/**
	 * @generated
	 */
	private java.lang.String dataUltimaModifica = null;

	/**
	 * Imposta il valore della property [dataUltimaModifica]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setDataUltimaModifica(java.lang.String val) {
		dataUltimaModifica = val;
	}

	////{PROTECTED REGION ID(R-867874581) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo dataUltimaModifica. 
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
	public java.lang.String getDataUltimaModifica() {
		return dataUltimaModifica;
	}

	/**
	 * @generated
	 */
	private java.lang.String statoDomandaCodice = null;

	/**
	 * Imposta il valore della property [statoDomandaCodice]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setStatoDomandaCodice(java.lang.String val) {
		statoDomandaCodice = val;
	}

	////{PROTECTED REGION ID(R1622821917) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo statoDomandaCodice. 
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
	public java.lang.String getStatoDomandaCodice() {
		return statoDomandaCodice;
	}

	/**
	 * @generated
	 */
	private java.lang.String nomeMinore = null;

	/**
	 * Imposta il valore della property [nomeMinore]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setNomeMinore(java.lang.String val) {
		nomeMinore = val;
	}

	////{PROTECTED REGION ID(R-99592478) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo nomeMinore. 
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
	public java.lang.String getNomeMinore() {
		return nomeMinore;
	}

	/**
	 * @generated
	 */
	private java.lang.String cognomeMinore = null;

	/**
	 * Imposta il valore della property [cognomeMinore]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setCognomeMinore(java.lang.String val) {
		cognomeMinore = val;
	}

	////{PROTECTED REGION ID(R1191948747) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo cognomeMinore. 
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
	public java.lang.String getCognomeMinore() {
		return cognomeMinore;
	}

	/**
	 * @generated
	 */
	private java.lang.String indirizzo = null;

	/**
	 * Imposta il valore della property [indirizzo]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setIndirizzo(java.lang.String val) {
		indirizzo = val;
	}

	////{PROTECTED REGION ID(R-1794511051) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo indirizzo. 
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
	public java.lang.String getIndirizzo() {
		return indirizzo;
	}

	/**
	 * @generated
	 */
	private java.lang.Integer ricorrenza = null;

	/**
	 * Imposta il valore della property [ricorrenza]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setRicorrenza(java.lang.Integer val) {
		ricorrenza = val;
	}

	////{PROTECTED REGION ID(R-1821632116) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo ricorrenza. 
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
	public java.lang.Integer getRicorrenza() {
		return ricorrenza;
	}

	/**
	 * @generated
	 */
	private java.lang.Boolean valida = null;

	/**
	 * Imposta il valore della property [valida]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setValida(java.lang.Boolean val) {
		valida = val;
	}

	////{PROTECTED REGION ID(R-878934146) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo valida. 
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
	public java.lang.Boolean getValida() {
		return valida;
	}

	/*PROTECTED REGION ID(R2083734170) ENABLED START*/
	/// inserire qui eventuali ridefinizioni di toString, hashCode, equals
	/*PROTECTED REGION END*/
}
