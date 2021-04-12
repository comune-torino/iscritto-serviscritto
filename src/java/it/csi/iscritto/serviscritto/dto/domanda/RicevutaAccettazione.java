
package it.csi.iscritto.serviscritto.dto.domanda;

////{PROTECTED REGION ID(R339107550) ENABLED START////}
/**
 * Inserire qui la documentazione della classe RicevutaAccettazione.
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
public class RicevutaAccettazione implements java.io.Serializable {
	// il serial version UID e' impostato in base a quanto configurato nel modello
	/**
	 * @generated
	 */
	static final long serialVersionUID = 1;

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

	////{PROTECTED REGION ID(R-990079705) ENABLED START////}
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

	////{PROTECTED REGION ID(R-1595010714) ENABLED START////}
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
	private java.lang.String codAnnoScolastico = null;

	/**
	 * Imposta il valore della property [codAnnoScolastico]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setCodAnnoScolastico(java.lang.String val) {
		codAnnoScolastico = val;
	}

	////{PROTECTED REGION ID(R-2064672504) ENABLED START////}
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
	private java.lang.Long idDomandaIscrizione = null;

	/**
	 * Imposta il valore della property [idDomandaIscrizione]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setIdDomandaIscrizione(java.lang.Long val) {
		idDomandaIscrizione = val;
	}

	////{PROTECTED REGION ID(R-964463174) ENABLED START////}
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
	private java.lang.String protocolloDomanda = null;

	/**
	 * Imposta il valore della property [protocolloDomanda]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setProtocolloDomanda(java.lang.String val) {
		protocolloDomanda = val;
	}

	////{PROTECTED REGION ID(R-1662743565) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo protocolloDomanda. 
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
	public java.lang.String getProtocolloDomanda() {
		return protocolloDomanda;
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

	////{PROTECTED REGION ID(R-1837747154) ENABLED START////}
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
	private java.util.Date dataOperazione = null;

	/**
	 * Imposta il valore della property [dataOperazione]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setDataOperazione(java.util.Date val) {
		dataOperazione = (val == null ? null : new java.util.Date(val.getTime()));
	}

	////{PROTECTED REGION ID(R-204134772) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo dataOperazione. 
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
	public java.util.Date getDataOperazione() {
		return (dataOperazione == null ? null : new java.util.Date(dataOperazione.getTime()));
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

	////{PROTECTED REGION ID(R-1239928231) ENABLED START////}
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
	private java.lang.String descScuola = null;

	/**
	 * Imposta il valore della property [descScuola]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setDescScuola(java.lang.String val) {
		descScuola = val;
	}

	////{PROTECTED REGION ID(R2128092974) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo descScuola. 
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
	public java.lang.String getDescScuola() {
		return descScuola;
	}

	/**
	 * @generated
	 */
	private java.lang.String indirizzoScuola = null;

	/**
	 * Imposta il valore della property [indirizzoScuola]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setIndirizzoScuola(java.lang.String val) {
		indirizzoScuola = val;
	}

	////{PROTECTED REGION ID(R-849737649) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo indirizzoScuola. 
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
	public java.lang.String getIndirizzoScuola() {
		return indirizzoScuola;
	}

	/**
	 * @generated
	 */
	private java.lang.String codiceCategoriaScu = null;

	/**
	 * Imposta il valore della property [codiceCategoriaScu]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setCodiceCategoriaScu(java.lang.String val) {
		codiceCategoriaScu = val;
	}

	////{PROTECTED REGION ID(R657745667) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo codiceCategoriaScu. 
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
	public java.lang.String getCodiceCategoriaScu() {
		return codiceCategoriaScu;
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

	////{PROTECTED REGION ID(R1048676632) ENABLED START////}
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
	private java.lang.String codTipoFrequenza = null;

	/**
	 * Imposta il valore della property [codTipoFrequenza]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setCodTipoFrequenza(java.lang.String val) {
		codTipoFrequenza = val;
	}

	////{PROTECTED REGION ID(R-1791073409) ENABLED START////}
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

	/**
	 * @generated
	 */
	private java.lang.String descTipoFrequenza = null;

	/**
	 * Imposta il valore della property [descTipoFrequenza]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setDescTipoFrequenza(java.lang.String val) {
		descTipoFrequenza = val;
	}

	////{PROTECTED REGION ID(R1264012554) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo descTipoFrequenza. 
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
	public java.lang.String getDescTipoFrequenza() {
		return descTipoFrequenza;
	}

	/**
	 * @generated
	 */
	private java.lang.String codTipoPasto = null;

	/**
	 * Imposta il valore della property [codTipoPasto]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setCodTipoPasto(java.lang.String val) {
		codTipoPasto = val;
	}

	////{PROTECTED REGION ID(R-2092006641) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo codTipoPasto. 
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
	public java.lang.String getCodTipoPasto() {
		return codTipoPasto;
	}

	/**
	 * @generated
	 */
	private java.lang.String descTipoPasto = null;

	/**
	 * Imposta il valore della property [descTipoPasto]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setDescTipoPasto(java.lang.String val) {
		descTipoPasto = val;
	}

	////{PROTECTED REGION ID(R-103290342) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo descTipoPasto. 
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
	public java.lang.String getDescTipoPasto() {
		return descTipoPasto;
	}

	/*PROTECTED REGION ID(R-462460421) ENABLED START*/
	/// inserire qui eventuali ridefinizioni di toString, hashCode, equals
	/*PROTECTED REGION END*/
}
