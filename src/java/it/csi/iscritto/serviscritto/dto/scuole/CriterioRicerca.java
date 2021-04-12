
package it.csi.iscritto.serviscritto.dto.scuole;

////{PROTECTED REGION ID(R-265363046) ENABLED START////}
/**
 * Inserire qui la documentazione della classe CriterioRicerca.
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
public class CriterioRicerca implements java.io.Serializable {
	// il serial version UID e' impostato in base a quanto configurato nel modello
	/**
	 * @generated
	 */
	static final long serialVersionUID = 1;

	/**
	 * @generated
	 */
	private java.lang.String tipoScuola = "NID";

	/**
	 * Imposta il valore della property [tipoScuola]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setTipoScuola(java.lang.String val) {
		tipoScuola = val;
	}

	////{PROTECTED REGION ID(R408515917) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo tipoScuola. 
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
	public java.lang.String getTipoScuola() {
		return tipoScuola;
	}

	/**
	 * @generated
	 */
	private java.lang.String codAnno = null;

	/**
	 * Imposta il valore della property [codAnno]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setCodAnno(java.lang.String val) {
		codAnno = val;
	}

	////{PROTECTED REGION ID(R-1106626196) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo codAnno. 
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
	public java.lang.String getCodAnno() {
		return codAnno;
	}

	/**
	 * @generated
	 */
	private java.lang.Integer circoscrizione = null;

	/**
	 * Imposta il valore della property [circoscrizione]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setCircoscrizione(java.lang.Integer val) {
		circoscrizione = val;
	}

	////{PROTECTED REGION ID(R392466834) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo circoscrizione. 
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
	public java.lang.Integer getCircoscrizione() {
		return circoscrizione;
	}

	/**
	 * @generated
	 */
	private java.util.Date dataNascita = null;

	/**
	 * Imposta il valore della property [dataNascita]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setDataNascita(java.util.Date val) {
		dataNascita = (val == null ? null : new java.util.Date(val.getTime()));
	}

	////{PROTECTED REGION ID(R-1728757361) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo dataNascita. 
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
	public java.util.Date getDataNascita() {
		return (dataNascita == null ? null : new java.util.Date(dataNascita.getTime()));
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

	////{PROTECTED REGION ID(R604340085) ENABLED START////}
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

	////{PROTECTED REGION ID(R-1164761836) ENABLED START////}
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
	private java.lang.String codiceFiscaleUtente = null;

	/**
	 * Imposta il valore della property [codiceFiscaleUtente]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setCodiceFiscaleUtente(java.lang.String val) {
		codiceFiscaleUtente = val;
	}

	////{PROTECTED REGION ID(R62445075) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo codiceFiscaleUtente. 
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
	public java.lang.String getCodiceFiscaleUtente() {
		return codiceFiscaleUtente;
	}

	/**
	 * @generated
	 */
	private java.lang.String codiceProfiloUtente = null;

	/**
	 * Imposta il valore della property [codiceProfiloUtente]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setCodiceProfiloUtente(java.lang.String val) {
		codiceProfiloUtente = val;
	}

	////{PROTECTED REGION ID(R-696174497) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo codiceProfiloUtente. 
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
	public java.lang.String getCodiceProfiloUtente() {
		return codiceProfiloUtente;
	}

	/**
	 * @generated
	 */
	private java.lang.String codiceCfOperatore = null;

	/**
	 * Imposta il valore della property [codiceCfOperatore]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setCodiceCfOperatore(java.lang.String val) {
		codiceCfOperatore = val;
	}

	////{PROTECTED REGION ID(R1411068081) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo codiceCfOperatore. 
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
	public java.lang.String getCodiceCfOperatore() {
		return codiceCfOperatore;
	}

	/*PROTECTED REGION ID(R-844380161) ENABLED START*/
	/// inserire qui eventuali ridefinizioni di toString, hashCode, equals
	/*PROTECTED REGION END*/
}
