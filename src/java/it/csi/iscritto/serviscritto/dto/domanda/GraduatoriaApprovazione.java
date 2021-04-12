
package it.csi.iscritto.serviscritto.dto.domanda;

////{PROTECTED REGION ID(R1000505892) ENABLED START////}
/**
 * Inserire qui la documentazione della classe GraduatoriaApprovazione.
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
public class GraduatoriaApprovazione implements java.io.Serializable {
	// il serial version UID e' impostato in base a quanto configurato nel modello
	/**
	 * @generated
	 */
	static final long serialVersionUID = 1;

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

	////{PROTECTED REGION ID(R1488091967) ENABLED START////}
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
	private java.util.Date dataConsegna = null;

	/**
	 * Imposta il valore della property [dataConsegna]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setDataConsegna(java.util.Date val) {
		dataConsegna = (val == null ? null : new java.util.Date(val.getTime()));
	}

	////{PROTECTED REGION ID(R429497972) ENABLED START////}
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
	public java.util.Date getDataConsegna() {
		return (dataConsegna == null ? null : new java.util.Date(dataConsegna.getTime()));
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

	////{PROTECTED REGION ID(R994221435) ENABLED START////}
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
	private java.lang.String cognome = null;

	/**
	 * Imposta il valore della property [cognome]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setCognome(java.lang.String val) {
		cognome = val;
	}

	////{PROTECTED REGION ID(R-152860560) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo cognome. 
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
	public java.lang.String getCognome() {
		return cognome;
	}

	/**
	 * @generated
	 */
	private java.lang.String nome = null;

	/**
	 * Imposta il valore della property [nome]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setNome(java.lang.String val) {
		nome = val;
	}

	////{PROTECTED REGION ID(R-994017475) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo nome. 
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
	public java.lang.String getNome() {
		return nome;
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

	////{PROTECTED REGION ID(R-457128251) ENABLED START////}
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
	private java.lang.String oraNascita = null;

	/**
	 * Imposta il valore della property [oraNascita]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setOraNascita(java.lang.String val) {
		oraNascita = val;
	}

	////{PROTECTED REGION ID(R-991696167) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo oraNascita. 
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
	public java.lang.String getOraNascita() {
		return oraNascita;
	}

	/**
	 * @generated
	 */
	private java.lang.Double isee = null;

	/**
	 * Imposta il valore della property [isee]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setIsee(java.lang.Double val) {
		isee = val;
	}

	////{PROTECTED REGION ID(R-994162834) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo isee. 
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
	public java.lang.Double getIsee() {
		return isee;
	}

	/**
	 * @generated
	 */
	private java.lang.Integer punteggioPrimaScelta = null;

	/**
	 * Imposta il valore della property [punteggioPrimaScelta]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setPunteggioPrimaScelta(java.lang.Integer val) {
		punteggioPrimaScelta = val;
	}

	////{PROTECTED REGION ID(R194525635) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo punteggioPrimaScelta. 
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
	public java.lang.Integer getPunteggioPrimaScelta() {
		return punteggioPrimaScelta;
	}

	/**
	 * @generated
	 */
	private java.lang.Integer punteggio = null;

	/**
	 * Imposta il valore della property [punteggio]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setPunteggio(java.lang.Integer val) {
		punteggio = val;
	}

	////{PROTECTED REGION ID(R1054670492) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo punteggio. 
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
	public java.lang.Integer getPunteggio() {
		return punteggio;
	}

	/**
	 * @generated
	 */
	private java.lang.String nidoAmmissione = null;

	/**
	 * Imposta il valore della property [nidoAmmissione]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setNidoAmmissione(java.lang.String val) {
		nidoAmmissione = val;
	}

	////{PROTECTED REGION ID(R-1738209329) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo nidoAmmissione. 
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
	public java.lang.String getNidoAmmissione() {
		return nidoAmmissione;
	}

	/**
	 * @generated
	 */
	private java.lang.String flFuoriTermine = null;

	/**
	 * Imposta il valore della property [flFuoriTermine]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setFlFuoriTermine(java.lang.String val) {
		flFuoriTermine = val;
	}

	////{PROTECTED REGION ID(R-1480894649) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo flFuoriTermine. 
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
	public java.lang.String getFlFuoriTermine() {
		return flFuoriTermine;
	}

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

	////{PROTECTED REGION ID(R640094388) ENABLED START////}
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

	/*PROTECTED REGION ID(R1700787247) ENABLED START*/
	/// inserire qui eventuali ridefinizioni di toString, hashCode, equals
	/*PROTECTED REGION END*/
}
