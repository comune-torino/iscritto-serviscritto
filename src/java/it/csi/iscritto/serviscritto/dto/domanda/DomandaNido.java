
package it.csi.iscritto.serviscritto.dto.domanda;

////{PROTECTED REGION ID(R-1838396525) ENABLED START////}
/**
 * Inserire qui la documentazione della classe DomandaNido.
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
public class DomandaNido implements java.io.Serializable {
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

	////{PROTECTED REGION ID(R-516252955) ENABLED START////}
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
	private java.lang.String statoDomanda = null;

	/**
	 * Imposta il valore della property [statoDomanda]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setStatoDomanda(java.lang.String val) {
		statoDomanda = val;
	}

	////{PROTECTED REGION ID(R792124324) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo statoDomanda. 
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
	public java.lang.String getStatoDomanda() {
		return statoDomanda;
	}

	/**
	 * @generated
	 */
	private java.lang.String ordineScuola = null;

	/**
	 * Imposta il valore della property [ordineScuola]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setOrdineScuola(java.lang.String val) {
		ordineScuola = val;
	}

	////{PROTECTED REGION ID(R-1642896079) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo ordineScuola. 
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
	public java.lang.String getOrdineScuola() {
		return ordineScuola;
	}

	/**
	 * @generated
	 */
	private java.lang.Boolean responsabilitaGenitoriale = null;

	/**
	 * Imposta il valore della property [responsabilitaGenitoriale]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setResponsabilitaGenitoriale(java.lang.Boolean val) {
		responsabilitaGenitoriale = val;
	}

	////{PROTECTED REGION ID(R2034236462) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo responsabilitaGenitoriale. 
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
	public java.lang.Boolean getResponsabilitaGenitoriale() {
		return responsabilitaGenitoriale;
	}

	/**
	 * @generated
	 */
	private java.lang.Boolean infoAutocertificazione = null;

	/**
	 * Imposta il valore della property [infoAutocertificazione]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setInfoAutocertificazione(java.lang.Boolean val) {
		infoAutocertificazione = val;
	}

	////{PROTECTED REGION ID(R906898433) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo infoAutocertificazione. 
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
	public java.lang.Boolean getInfoAutocertificazione() {
		return infoAutocertificazione;
	}

	/**
	 * @generated
	 */
	private java.lang.Boolean infoGdpr = null;

	/**
	 * Imposta il valore della property [infoGdpr]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setInfoGdpr(java.lang.Boolean val) {
		infoGdpr = val;
	}

	////{PROTECTED REGION ID(R-1596837376) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo infoGdpr. 
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
	public java.lang.Boolean getInfoGdpr() {
		return infoGdpr;
	}

	/**
	 * @generated
	 */
	private it.csi.iscritto.serviscritto.dto.domanda.Richiedente richiedente = null;

	/**
	 * Imposta il valore della property [richiedente]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setRichiedente(it.csi.iscritto.serviscritto.dto.domanda.Richiedente val) {
		richiedente = val;
	}

	////{PROTECTED REGION ID(R-689341997) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo richiedente. 
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
	public it.csi.iscritto.serviscritto.dto.domanda.Richiedente getRichiedente() {
		return richiedente;
	}

	/**
	 * @generated
	 */
	private it.csi.iscritto.serviscritto.dto.domanda.Minore minore = null;

	/**
	 * Imposta il valore della property [minore]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setMinore(it.csi.iscritto.serviscritto.dto.domanda.Minore val) {
		minore = val;
	}

	////{PROTECTED REGION ID(R-1527275357) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo minore. 
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
	public it.csi.iscritto.serviscritto.dto.domanda.Minore getMinore() {
		return minore;
	}

	/**
	 * @generated
	 */
	private it.csi.iscritto.serviscritto.dto.domanda.Soggetto1 soggetto1 = null;

	/**
	 * Imposta il valore della property [soggetto1]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setSoggetto1(it.csi.iscritto.serviscritto.dto.domanda.Soggetto1 val) {
		soggetto1 = val;
	}

	////{PROTECTED REGION ID(R-722526952) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo soggetto1. 
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
	public it.csi.iscritto.serviscritto.dto.domanda.Soggetto1 getSoggetto1() {
		return soggetto1;
	}

	/**
	 * @generated
	 */
	private it.csi.iscritto.serviscritto.dto.domanda.Soggetto2 soggetto2 = null;

	/**
	 * Imposta il valore della property [soggetto2]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setSoggetto2(it.csi.iscritto.serviscritto.dto.domanda.Soggetto2 val) {
		soggetto2 = val;
	}

	////{PROTECTED REGION ID(R-722526951) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo soggetto2. 
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
	public it.csi.iscritto.serviscritto.dto.domanda.Soggetto2 getSoggetto2() {
		return soggetto2;
	}

	/**
	 * @generated
	 */
	private it.csi.iscritto.serviscritto.dto.domanda.Soggetto3 soggetto3 = null;

	/**
	 * Imposta il valore della property [soggetto3]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setSoggetto3(it.csi.iscritto.serviscritto.dto.domanda.Soggetto3 val) {
		soggetto3 = val;
	}

	////{PROTECTED REGION ID(R-722526950) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo soggetto3. 
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
	public it.csi.iscritto.serviscritto.dto.domanda.Soggetto3 getSoggetto3() {
		return soggetto3;
	}

	/**
	 * @generated
	 */
	private it.csi.iscritto.serviscritto.dto.domanda.ComponentiNucleo componentiNucleo = null;

	/**
	 * Imposta il valore della property [componentiNucleo]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setComponentiNucleo(it.csi.iscritto.serviscritto.dto.domanda.ComponentiNucleo val) {
		componentiNucleo = val;
	}

	////{PROTECTED REGION ID(R-1121242919) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo componentiNucleo. 
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
	public it.csi.iscritto.serviscritto.dto.domanda.ComponentiNucleo getComponentiNucleo() {
		return componentiNucleo;
	}

	/**
	 * @generated
	 */
	private it.csi.iscritto.serviscritto.dto.domanda.AltriComponenti altriComponenti = null;

	/**
	 * Imposta il valore della property [altriComponenti]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setAltriComponenti(it.csi.iscritto.serviscritto.dto.domanda.AltriComponenti val) {
		altriComponenti = val;
	}

	////{PROTECTED REGION ID(R1324963033) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo altriComponenti. 
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
	public it.csi.iscritto.serviscritto.dto.domanda.AltriComponenti getAltriComponenti() {
		return altriComponenti;
	}

	/**
	 * @generated
	 */
	private it.csi.iscritto.serviscritto.dto.domanda.Affido affido = null;

	/**
	 * Imposta il valore della property [affido]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setAffido(it.csi.iscritto.serviscritto.dto.domanda.Affido val) {
		affido = val;
	}

	////{PROTECTED REGION ID(R-1873840250) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo affido. 
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
	public it.csi.iscritto.serviscritto.dto.domanda.Affido getAffido() {
		return affido;
	}

	/**
	 * @generated
	 */
	private it.csi.iscritto.serviscritto.dto.domanda.Isee isee = null;

	/**
	 * Imposta il valore della property [isee]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setIsee(it.csi.iscritto.serviscritto.dto.domanda.Isee val) {
		isee = val;
	}

	////{PROTECTED REGION ID(R-1516781219) ENABLED START////}
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
	public it.csi.iscritto.serviscritto.dto.domanda.Isee getIsee() {
		return isee;
	}

	/**
	 * @generated
	 */
	private it.csi.iscritto.serviscritto.dto.domanda.Nido[] elencoNidi = null;

	/**
	 * Imposta il valore della property [elencoNidi]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setElencoNidi(it.csi.iscritto.serviscritto.dto.domanda.Nido[] val) {
		if (val == null) {
			elencoNidi = null;
		} else {
			// non si puo' usare System.arrayCopy perche' i DTO devono essere compilati Java 1.3
			elencoNidi = new it.csi.iscritto.serviscritto.dto.domanda.Nido[val.length];
			for (int i = 0; i < val.length; i++) { //NOSONAR  Reason:NOTINJ13
				elencoNidi[i] = val[i]; //NOSONAR  Reason:NOTINJ13
			} //NOSONAR  Reason:NOTINJ13
		}
	}

	////{PROTECTED REGION ID(R1324011887) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo elencoNidi. 
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
	public it.csi.iscritto.serviscritto.dto.domanda.Nido[] getElencoNidi() {
		if (elencoNidi == null) {
			return null;
		} else {
			// non si puo' usare System.arrayCopy perche' i DTO devono essere compilati Java 1.3
			it.csi.iscritto.serviscritto.dto.domanda.Nido[] copy = new it.csi.iscritto.serviscritto.dto.domanda.Nido[elencoNidi.length];
			for (int i = 0; i < elencoNidi.length; i++) { //NOSONAR  Reason:NOTINJ13
				copy[i] = elencoNidi[i]; //NOSONAR  Reason:NOTINJ13
			} //NOSONAR  Reason:NOTINJ13
			return copy;
		}
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

	////{PROTECTED REGION ID(R-1480686098) ENABLED START////}
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
	private it.csi.iscritto.serviscritto.dto.domanda.CondizionePunteggio[] condizioniPunteggio = null;

	/**
	 * Imposta il valore della property [condizioniPunteggio]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setCondizioniPunteggio(it.csi.iscritto.serviscritto.dto.domanda.CondizionePunteggio[] val) {
		if (val == null) {
			condizioniPunteggio = null;
		} else {
			// non si puo' usare System.arrayCopy perche' i DTO devono essere compilati Java 1.3
			condizioniPunteggio = new it.csi.iscritto.serviscritto.dto.domanda.CondizionePunteggio[val.length];
			for (int i = 0; i < val.length; i++) { //NOSONAR  Reason:NOTINJ13
				condizioniPunteggio[i] = val[i]; //NOSONAR  Reason:NOTINJ13
			} //NOSONAR  Reason:NOTINJ13
		}
	}

	////{PROTECTED REGION ID(R-1095660423) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo condizioniPunteggio. 
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
	public it.csi.iscritto.serviscritto.dto.domanda.CondizionePunteggio[] getCondizioniPunteggio() {
		if (condizioniPunteggio == null) {
			return null;
		} else {
			// non si puo' usare System.arrayCopy perche' i DTO devono essere compilati Java 1.3
			it.csi.iscritto.serviscritto.dto.domanda.CondizionePunteggio[] copy = new it.csi.iscritto.serviscritto.dto.domanda.CondizionePunteggio[condizioniPunteggio.length];
			for (int i = 0; i < condizioniPunteggio.length; i++) { //NOSONAR  Reason:NOTINJ13
				copy[i] = condizioniPunteggio[i]; //NOSONAR  Reason:NOTINJ13
			} //NOSONAR  Reason:NOTINJ13
			return copy;
		}
	}

	/**
	 * @generated
	 */
	private java.lang.Boolean nao = null;

	/**
	 * Imposta il valore della property [nao]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setNao(java.lang.Boolean val) {
		nao = val;
	}

	////{PROTECTED REGION ID(R1752191145) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo nao. 
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
	public java.lang.Boolean getNao() {
		return nao;
	}

	/**
	 * @generated
	 */
	private java.lang.String codiceFiscaleUtenteIns = null;

	/**
	 * Imposta il valore della property [codiceFiscaleUtenteIns]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setCodiceFiscaleUtenteIns(java.lang.String val) {
		codiceFiscaleUtenteIns = val;
	}

	////{PROTECTED REGION ID(R1261430292) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo codiceFiscaleUtenteIns. 
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
	public java.lang.String getCodiceFiscaleUtenteIns() {
		return codiceFiscaleUtenteIns;
	}

	/**
	 * @generated
	 */
	private java.lang.String codiceFiscaleUtenteMod = null;

	/**
	 * Imposta il valore della property [codiceFiscaleUtenteMod]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setCodiceFiscaleUtenteMod(java.lang.String val) {
		codiceFiscaleUtenteMod = val;
	}

	////{PROTECTED REGION ID(R1261434152) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo codiceFiscaleUtenteMod. 
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
	public java.lang.String getCodiceFiscaleUtenteMod() {
		return codiceFiscaleUtenteMod;
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

	////{PROTECTED REGION ID(R42022630) ENABLED START////}
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

	/**
	 * @generated
	 */
	private java.util.Date dataUltimaModifica = null;

	/**
	 * Imposta il valore della property [dataUltimaModifica]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setDataUltimaModifica(java.util.Date val) {
		dataUltimaModifica = (val == null ? null : new java.util.Date(val.getTime()));
	}

	////{PROTECTED REGION ID(R722434981) ENABLED START////}
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
	public java.util.Date getDataUltimaModifica() {
		return (dataUltimaModifica == null ? null : new java.util.Date(dataUltimaModifica.getTime()));
	}

	/**
	 * @generated
	 */
	private java.lang.String annoScolastico = null;

	/**
	 * Imposta il valore della property [annoScolastico]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setAnnoScolastico(java.lang.String val) {
		annoScolastico = val;
	}

	////{PROTECTED REGION ID(R1199231713) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo annoScolastico. 
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
	public java.lang.String getAnnoScolastico() {
		return annoScolastico;
	}

	/**
	 * @generated
	 */
	private java.lang.Boolean consensoConvenzionata = null;

	/**
	 * Imposta il valore della property [consensoConvenzionata]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setConsensoConvenzionata(java.lang.Boolean val) {
		consensoConvenzionata = val;
	}

	////{PROTECTED REGION ID(R1148156794) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo consensoConvenzionata. 
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
	public java.lang.Boolean getConsensoConvenzionata() {
		return consensoConvenzionata;
	}

	/*PROTECTED REGION ID(R876943840) ENABLED START*/
	/// inserire qui eventuali ridefinizioni di toString, hashCode, equals
	/*PROTECTED REGION END*/
}
