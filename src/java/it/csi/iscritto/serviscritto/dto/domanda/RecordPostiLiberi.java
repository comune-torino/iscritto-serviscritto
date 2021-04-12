
package it.csi.iscritto.serviscritto.dto.domanda;

////{PROTECTED REGION ID(R1031144528) ENABLED START////}
/**
 * Inserire qui la documentazione della classe RecordPostiLiberi.
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
public class RecordPostiLiberi implements java.io.Serializable {
	// il serial version UID e' impostato in base a quanto configurato nel modello
	/**
	 * @generated
	 */
	static final long serialVersionUID = 1;

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

	////{PROTECTED REGION ID(R106434918) ENABLED START////}
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
	private java.lang.String codAnagraficaGraduatoria = null;

	/**
	 * Imposta il valore della property [codAnagraficaGraduatoria]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setCodAnagraficaGraduatoria(java.lang.String val) {
		codAnagraficaGraduatoria = val;
	}

	////{PROTECTED REGION ID(R1650511722) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo codAnagraficaGraduatoria. 
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
	public java.lang.String getCodAnagraficaGraduatoria() {
		return codAnagraficaGraduatoria;
	}

	/**
	 * @generated
	 */
	private java.util.Date dataCreazione = null;

	/**
	 * Imposta il valore della property [dataCreazione]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setDataCreazione(java.util.Date val) {
		dataCreazione = (val == null ? null : new java.util.Date(val.getTime()));
	}

	////{PROTECTED REGION ID(R-1759139950) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo dataCreazione. 
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
	public java.util.Date getDataCreazione() {
		return (dataCreazione == null ? null : new java.util.Date(dataCreazione.getTime()));
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

	////{PROTECTED REGION ID(R-1571386073) ENABLED START////}
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
	private java.lang.String indirizzoScuola = null;

	/**
	 * Imposta il valore della property [indirizzoScuola]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setIndirizzoScuola(java.lang.String val) {
		indirizzoScuola = val;
	}

	////{PROTECTED REGION ID(R-1791979363) ENABLED START////}
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
	private java.lang.String descFasciaEta = null;

	/**
	 * Imposta il valore della property [descFasciaEta]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setDescFasciaEta(java.lang.String val) {
		descFasciaEta = val;
	}

	////{PROTECTED REGION ID(R-947855858) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo descFasciaEta. 
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
	public java.lang.String getDescFasciaEta() {
		return descFasciaEta;
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

	////{PROTECTED REGION ID(R2007824856) ENABLED START////}
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
	private java.lang.String postiLiberi = null;

	/**
	 * Imposta il valore della property [postiLiberi]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setPostiLiberi(java.lang.String val) {
		postiLiberi = val;
	}

	////{PROTECTED REGION ID(R27521936) ENABLED START////}
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
	public java.lang.String getPostiLiberi() {
		return postiLiberi;
	}

	/**
	 * @generated
	 */
	private java.lang.String postiAmmessi = null;

	/**
	 * Imposta il valore della property [postiAmmessi]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setPostiAmmessi(java.lang.String val) {
		postiAmmessi = val;
	}

	////{PROTECTED REGION ID(R-194749172) ENABLED START////}
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
	public java.lang.String getPostiAmmessi() {
		return postiAmmessi;
	}

	/*PROTECTED REGION ID(R-1658638269) ENABLED START*/
	/// inserire qui eventuali ridefinizioni di toString, hashCode, equals
	/*PROTECTED REGION END*/
}
