
package it.csi.iscritto.serviscritto.dto.domanda;

////{PROTECTED REGION ID(R1888640811) ENABLED START////}
/**
 * Inserire qui la documentazione della classe GraduatoriaCompleta.
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
public class GraduatoriaCompleta implements java.io.Serializable {
	// il serial version UID e' impostato in base a quanto configurato nel modello
	/**
	 * @generated
	 */
	static final long serialVersionUID = 1;

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

	////{PROTECTED REGION ID(R602155010) ENABLED START////}
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
	private java.lang.String protocollo = null;

	/**
	 * Imposta il valore della property [protocollo]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setProtocollo(java.lang.String val) {
		protocollo = val;
	}

	////{PROTECTED REGION ID(R-277677178) ENABLED START////}
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
	private java.lang.Integer punteggio = null;

	/**
	 * Imposta il valore della property [punteggio]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setPunteggio(java.lang.Integer val) {
		punteggio = val;
	}

	////{PROTECTED REGION ID(R997710197) ENABLED START////}
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
	private java.lang.String nome = null;

	/**
	 * Imposta il valore della property [nome]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setNome(java.lang.String val) {
		nome = val;
	}

	////{PROTECTED REGION ID(R349995204) ENABLED START////}
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
	private java.lang.String cognome = null;

	/**
	 * Imposta il valore della property [cognome]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setCognome(java.lang.String val) {
		cognome = val;
	}

	////{PROTECTED REGION ID(R1643726217) ENABLED START////}
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
	private java.lang.String codiceFiscale = null;

	/**
	 * Imposta il valore della property [codiceFiscale]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setCodiceFiscale(java.lang.String val) {
		codiceFiscale = val;
	}

	////{PROTECTED REGION ID(R1004144521) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo codiceFiscale. 
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
	public java.lang.String getCodiceFiscale() {
		return codiceFiscale;
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

	////{PROTECTED REGION ID(R349849845) ENABLED START////}
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
	private java.lang.String pref1 = null;

	/**
	 * Imposta il valore della property [pref1]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setPref1(java.lang.String val) {
		pref1 = val;
	}

	////{PROTECTED REGION ID(R-2033121757) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo pref1. 
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
	public java.lang.String getPref1() {
		return pref1;
	}

	/**
	 * @generated
	 */
	private java.lang.String pref2 = null;

	/**
	 * Imposta il valore della property [pref2]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setPref2(java.lang.String val) {
		pref2 = val;
	}

	////{PROTECTED REGION ID(R-2033121756) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo pref2. 
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
	public java.lang.String getPref2() {
		return pref2;
	}

	/**
	 * @generated
	 */
	private java.lang.String pref3 = null;

	/**
	 * Imposta il valore della property [pref3]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setPref3(java.lang.String val) {
		pref3 = val;
	}

	////{PROTECTED REGION ID(R-2033121755) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo pref3. 
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
	public java.lang.String getPref3() {
		return pref3;
	}

	/**
	 * @generated
	 */
	private java.lang.String pref4 = null;

	/**
	 * Imposta il valore della property [pref4]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setPref4(java.lang.String val) {
		pref4 = val;
	}

	////{PROTECTED REGION ID(R-2033121754) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo pref4. 
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
	public java.lang.String getPref4() {
		return pref4;
	}

	/**
	 * @generated
	 */
	private java.lang.String pref5 = null;

	/**
	 * Imposta il valore della property [pref5]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setPref5(java.lang.String val) {
		pref5 = val;
	}

	////{PROTECTED REGION ID(R-2033121753) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo pref5. 
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
	public java.lang.String getPref5() {
		return pref5;
	}

	/**
	 * @generated
	 */
	private java.lang.String pref6 = null;

	/**
	 * Imposta il valore della property [pref6]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setPref6(java.lang.String val) {
		pref6 = val;
	}

	////{PROTECTED REGION ID(R-2033121752) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo pref6. 
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
	public java.lang.String getPref6() {
		return pref6;
	}

	/**
	 * @generated
	 */
	private java.lang.String pref7 = null;

	/**
	 * Imposta il valore della property [pref7]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setPref7(java.lang.String val) {
		pref7 = val;
	}

	////{PROTECTED REGION ID(R-2033121751) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo pref7. 
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
	public java.lang.String getPref7() {
		return pref7;
	}

	/**
	 * @generated
	 */
	private java.lang.String pref8 = null;

	/**
	 * Imposta il valore della property [pref8]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setPref8(java.lang.String val) {
		pref8 = val;
	}

	////{PROTECTED REGION ID(R-2033121750) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo pref8. 
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
	public java.lang.String getPref8() {
		return pref8;
	}

	/**
	 * @generated
	 */
	private java.lang.String pref9 = null;

	/**
	 * Imposta il valore della property [pref9]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setPref9(java.lang.String val) {
		pref9 = val;
	}

	////{PROTECTED REGION ID(R-2033121749) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo pref9. 
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
	public java.lang.String getPref9() {
		return pref9;
	}

	/**
	 * @generated
	 */
	private java.lang.String pref10 = null;

	/**
	 * Imposta il valore della property [pref10]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setPref10(java.lang.String val) {
		pref10 = val;
	}

	////{PROTECTED REGION ID(R1397735021) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo pref10. 
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
	public java.lang.String getPref10() {
		return pref10;
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

	////{PROTECTED REGION ID(R37431547) ENABLED START////}
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
	private java.util.Date dataNascita = null;

	/**
	 * Imposta il valore della property [dataNascita]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setDataNascita(java.util.Date val) {
		dataNascita = (val == null ? null : new java.util.Date(val.getTime()));
	}

	////{PROTECTED REGION ID(R638603102) ENABLED START////}
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

	////{PROTECTED REGION ID(R1537501984) ENABLED START////}
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

	/*PROTECTED REGION ID(R-1847561656) ENABLED START*/
	/// inserire qui eventuali ridefinizioni di toString, hashCode, equals
	/*PROTECTED REGION END*/
}
