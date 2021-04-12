
package it.csi.iscritto.serviscritto.dto.domanda;

////{PROTECTED REGION ID(R-50364148) ENABLED START////}
/**
 * Inserire qui la documentazione della classe Classe.
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
public class Classe implements java.io.Serializable {
	// il serial version UID e' impostato in base a quanto configurato nel modello
	/**
	 * @generated
	 */
	static final long serialVersionUID = 1;

	/**
	 * @generated
	 */
	private java.lang.Long idClasse = null;

	/**
	 * Imposta il valore della property [idClasse]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setIdClasse(java.lang.Long val) {
		idClasse = val;
	}

	////{PROTECTED REGION ID(R-1159547916) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo idClasse. 
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
	public java.lang.Long getIdClasse() {
		return idClasse;
	}

	/**
	 * @generated
	 */
	private java.lang.Integer postiLiberi = null;

	/**
	 * Imposta il valore della property [postiLiberi]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setPostiLiberi(java.lang.Integer val) {
		postiLiberi = val;
	}

	////{PROTECTED REGION ID(R353003860) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo postiLiberi. 
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
	public java.lang.Integer getPostiLiberi() {
		return postiLiberi;
	}

	/**
	 * @generated
	 */
	private java.lang.Integer postiAmmessi = null;

	/**
	 * Imposta il valore della property [postiAmmessi]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setPostiAmmessi(java.lang.Integer val) {
		postiAmmessi = val;
	}

	////{PROTECTED REGION ID(R1305255880) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo postiAmmessi. 
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
	public java.lang.Integer getPostiAmmessi() {
		return postiAmmessi;
	}

	/**
	 * @generated
	 */
	private java.lang.Integer postiAccettati = null;

	/**
	 * Imposta il valore della property [postiAccettati]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setPostiAccettati(java.lang.Integer val) {
		postiAccettati = val;
	}

	////{PROTECTED REGION ID(R-311936811) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo postiAccettati. 
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
	public java.lang.Integer getPostiAccettati() {
		return postiAccettati;
	}

	/**
	 * @generated
	 */
	private java.lang.String denominazione = null;

	/**
	 * Imposta il valore della property [denominazione]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setDenominazione(java.lang.String val) {
		denominazione = val;
	}

	////{PROTECTED REGION ID(R-258209638) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo denominazione. 
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
	public java.lang.String getDenominazione() {
		return denominazione;
	}

	/**
	 * @generated
	 */
	private java.lang.String flAmmissioneDis = null;

	/**
	 * Imposta il valore della property [flAmmissioneDis]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setFlAmmissioneDis(java.lang.String val) {
		flAmmissioneDis = val;
	}

	////{PROTECTED REGION ID(R-668726249) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo flAmmissioneDis. 
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
	public java.lang.String getFlAmmissioneDis() {
		return flAmmissioneDis;
	}

	/**
	 * @generated
	 */
	private java.lang.String codFasciaEta = null;

	/**
	 * Imposta il valore della property [codFasciaEta]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setCodFasciaEta(java.lang.String val) {
		codFasciaEta = val;
	}

	////{PROTECTED REGION ID(R-103776157) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo codFasciaEta. 
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
	public java.lang.String getCodFasciaEta() {
		return codFasciaEta;
	}

	/**
	 * @generated
	 */
	private java.lang.String codScuola = null;

	/**
	 * Imposta il valore della property [codScuola]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setCodScuola(java.lang.String val) {
		codScuola = val;
	}

	////{PROTECTED REGION ID(R1168614379) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo codScuola. 
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
	public java.lang.String getCodScuola() {
		return codScuola;
	}

	/**
	 * @generated
	 */
	private java.lang.String codOrdineScuola = null;

	/**
	 * Imposta il valore della property [codOrdineScuola]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setCodOrdineScuola(java.lang.String val) {
		codOrdineScuola = val;
	}

	////{PROTECTED REGION ID(R1917191466) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo codOrdineScuola. 
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
	public java.lang.String getCodOrdineScuola() {
		return codOrdineScuola;
	}

	/**
	 * @generated
	 */
	private java.lang.String codAnnoScolastico = null;

	/**
	 * Imposta il valore della property [codAnnoScolastico]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setCodAnnoScolastico(java.lang.String val) {
		codAnnoScolastico = val;
	}

	////{PROTECTED REGION ID(R-645572454) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo codAnnoScolastico. 
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
	public java.lang.String getCodAnnoScolastico() {
		return codAnnoScolastico;
	}

	/**
	 * @generated
	 */
	private java.lang.String codTipoFrequenza = null;

	/**
	 * Imposta il valore della property [codTipoFrequenza]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setCodTipoFrequenza(java.lang.String val) {
		codTipoFrequenza = val;
	}

	////{PROTECTED REGION ID(R-636917331) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo codTipoFrequenza. 
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
	public java.lang.String getCodTipoFrequenza() {
		return codTipoFrequenza;
	}

	/*PROTECTED REGION ID(R-647421363) ENABLED START*/
	/// inserire qui eventuali ridefinizioni di toString, hashCode, equals
	/*PROTECTED REGION END*/
}
