
package it.csi.iscritto.serviscritto.dto.domanda;

////{PROTECTED REGION ID(R-1061738063) ENABLED START////}
/**
 * Inserire qui la documentazione della classe CondizionePunteggio.
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
public class CondizionePunteggio implements java.io.Serializable {
	// il serial version UID e' impostato in base a quanto configurato nel modello
	/**
	 * @generated
	 */
	static final long serialVersionUID = 1;

	/**
	 * @generated
	 */
	private java.lang.String tipoIstruttoria = "P";

	/**
	 * Imposta il valore della property [tipoIstruttoria]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setTipoIstruttoria(java.lang.String val) {
		tipoIstruttoria = val;
	}

	////{PROTECTED REGION ID(R-725047901) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo tipoIstruttoria. 
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
	public java.lang.String getTipoIstruttoria() {
		return tipoIstruttoria;
	}

	/**
	 * @generated
	 */
	private java.lang.Boolean validata = null;

	/**
	 * Imposta il valore della property [validata]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setValidata(java.lang.Boolean val) {
		validata = val;
	}

	////{PROTECTED REGION ID(R1041760707) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo validata. 
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
	public java.lang.Boolean getValidata() {
		return validata;
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

	////{PROTECTED REGION ID(R-1738279196) ENABLED START////}
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
	private java.lang.String dataInizioValidita = null;

	/**
	 * Imposta il valore della property [dataInizioValidita]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setDataInizioValidita(java.lang.String val) {
		dataInizioValidita = val;
	}

	////{PROTECTED REGION ID(R-447337039) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo dataInizioValidita. 
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
	public java.lang.String getDataInizioValidita() {
		return dataInizioValidita;
	}

	/**
	 * @generated
	 */
	private java.lang.String dataFineValidita = null;

	/**
	 * Imposta il valore della property [dataFineValidita]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setDataFineValidita(java.lang.String val) {
		dataFineValidita = val;
	}

	////{PROTECTED REGION ID(R-1609763985) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo dataFineValidita. 
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
	public java.lang.String getDataFineValidita() {
		return dataFineValidita;
	}

	/**
	 * @generated
	 */
	private java.lang.String note = null;

	/**
	 * Imposta il valore della property [note]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setNote(java.lang.String val) {
		note = val;
	}

	////{PROTECTED REGION ID(R-655582941) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo note. 
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
	public java.lang.String getNote() {
		return note;
	}

	/**
	 * @generated
	 */
	private it.csi.iscritto.serviscritto.dto.domanda.Utente utente = null;

	/**
	 * Imposta il valore della property [utente]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setUtente(it.csi.iscritto.serviscritto.dto.domanda.Utente val) {
		utente = val;
	}

	////{PROTECTED REGION ID(R1549573354) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo utente. 
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
	public it.csi.iscritto.serviscritto.dto.domanda.Utente getUtente() {
		return utente;
	}

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

	////{PROTECTED REGION ID(R1029595908) ENABLED START////}
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
	private java.lang.String descrizione = null;

	/**
	 * Imposta il valore della property [descrizione]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setDescrizione(java.lang.String val) {
		descrizione = val;
	}

	////{PROTECTED REGION ID(R-705293570) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo descrizione. 
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
	public java.lang.String getDescrizione() {
		return descrizione;
	}

	/*PROTECTED REGION ID(R1494851074) ENABLED START*/
	/// inserire qui eventuali ridefinizioni di toString, hashCode, equals
	/*PROTECTED REGION END*/
}
