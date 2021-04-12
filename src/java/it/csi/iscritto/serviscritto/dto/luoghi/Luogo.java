
package it.csi.iscritto.serviscritto.dto.luoghi;

////{PROTECTED REGION ID(R-258952769) ENABLED START////}
/**
 * Inserire qui la documentazione della classe Luogo.
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
public class Luogo implements java.io.Serializable {
	// il serial version UID e' impostato in base a quanto configurato nel modello
	/**
	 * @generated
	 */
	static final long serialVersionUID = 1;

	/**
	 * @generated
	 */
	private java.lang.String stato = null;

	/**
	 * Imposta il valore della property [stato]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setStato(java.lang.String val) {
		stato = val;
	}

	////{PROTECTED REGION ID(R1068388924) ENABLED START////}
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
	public java.lang.String getStato() {
		return stato;
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

	////{PROTECTED REGION ID(R-1702287214) ENABLED START////}
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
	private java.lang.String descCittadinanza = null;

	/**
	 * Imposta il valore della property [descCittadinanza]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setDescCittadinanza(java.lang.String val) {
		descCittadinanza = val;
	}

	////{PROTECTED REGION ID(R1793262834) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo descCittadinanza. 
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
	public java.lang.String getDescCittadinanza() {
		return descCittadinanza;
	}

	/**
	 * @generated
	 */
	private java.lang.String descRegione = null;

	/**
	 * Imposta il valore della property [descRegione]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setDescRegione(java.lang.String val) {
		descRegione = val;
	}

	////{PROTECTED REGION ID(R-1687679743) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo descRegione. 
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
	public java.lang.String getDescRegione() {
		return descRegione;
	}

	/**
	 * @generated
	 */
	private java.lang.String istatRegione = null;

	/**
	 * Imposta il valore della property [istatRegione]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setIstatRegione(java.lang.String val) {
		istatRegione = val;
	}

	////{PROTECTED REGION ID(R-1013112269) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo istatRegione. 
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
	public java.lang.String getIstatRegione() {
		return istatRegione;
	}

	/**
	 * @generated
	 */
	private java.lang.String descProvincia = null;

	/**
	 * Imposta il valore della property [descProvincia]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setDescProvincia(java.lang.String val) {
		descProvincia = val;
	}

	////{PROTECTED REGION ID(R1015778493) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo descProvincia. 
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
	public java.lang.String getDescProvincia() {
		return descProvincia;
	}

	/**
	 * @generated
	 */
	private java.lang.String istatProvincia = null;

	/**
	 * Imposta il valore della property [istatProvincia]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setIstatProvincia(java.lang.String val) {
		istatProvincia = val;
	}

	////{PROTECTED REGION ID(R735059311) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo istatProvincia. 
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
	public java.lang.String getIstatProvincia() {
		return istatProvincia;
	}

	/**
	 * @generated
	 */
	private java.lang.String descComune = null;

	/**
	 * Imposta il valore della property [descComune]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setDescComune(java.lang.String val) {
		descComune = val;
	}

	////{PROTECTED REGION ID(R911020219) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo descComune. 
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
	public java.lang.String getDescComune() {
		return descComune;
	}

	/**
	 * @generated
	 */
	private java.lang.String istatComune = null;

	/**
	 * Imposta il valore della property [istatComune]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setIstatComune(java.lang.String val) {
		istatComune = val;
	}

	////{PROTECTED REGION ID(R1902611785) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo istatComune. 
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
	public java.lang.String getIstatComune() {
		return istatComune;
	}

	/*PROTECTED REGION ID(R-1093564550) ENABLED START*/
	/// inserire qui eventuali ridefinizioni di toString, hashCode, equals
	/*PROTECTED REGION END*/
}
