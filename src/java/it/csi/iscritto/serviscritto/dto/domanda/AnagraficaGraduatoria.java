
package it.csi.iscritto.serviscritto.dto.domanda;

////{PROTECTED REGION ID(R-2000071501) ENABLED START////}
/**
 * Inserire qui la documentazione della classe AnagraficaGraduatoria.
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
public class AnagraficaGraduatoria implements java.io.Serializable {
	// il serial version UID e' impostato in base a quanto configurato nel modello
	/**
	 * @generated
	 */
	static final long serialVersionUID = 1;

	/**
	 * @generated
	 */
	private java.lang.Long idAnagraficaGraduatoria = null;

	/**
	 * Imposta il valore della property [idAnagraficaGraduatoria]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setIdAnagraficaGraduatoria(java.lang.Long val) {
		idAnagraficaGraduatoria = val;
	}

	////{PROTECTED REGION ID(R-1041631932) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo idAnagraficaGraduatoria. 
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
	public java.lang.Long getIdAnagraficaGraduatoria() {
		return idAnagraficaGraduatoria;
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

	////{PROTECTED REGION ID(R-613292339) ENABLED START////}
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
	private java.util.Date dataInizioIscrizioni = null;

	/**
	 * Imposta il valore della property [dataInizioIscrizioni]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setDataInizioIscrizioni(java.util.Date val) {
		dataInizioIscrizioni = (val == null ? null : new java.util.Date(val.getTime()));
	}

	////{PROTECTED REGION ID(R28817732) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo dataInizioIscrizioni. 
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
	public java.util.Date getDataInizioIscrizioni() {
		return (dataInizioIscrizioni == null ? null : new java.util.Date(dataInizioIscrizioni.getTime()));
	}

	/**
	 * @generated
	 */
	private java.util.Date dataScadenzaIscrizioni = null;

	/**
	 * Imposta il valore della property [dataScadenzaIscrizioni]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setDataScadenzaIscrizioni(java.util.Date val) {
		dataScadenzaIscrizioni = (val == null ? null : new java.util.Date(val.getTime()));
	}

	////{PROTECTED REGION ID(R495683339) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo dataScadenzaIscrizioni. 
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
	public java.util.Date getDataScadenzaIscrizioni() {
		return (dataScadenzaIscrizioni == null ? null : new java.util.Date(dataScadenzaIscrizioni.getTime()));
	}

	/**
	 * @generated
	 */
	private java.util.Date dataFineIscrizioni = null;

	/**
	 * Imposta il valore della property [dataFineIscrizioni]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setDataFineIscrizioni(java.util.Date val) {
		dataFineIscrizioni = (val == null ? null : new java.util.Date(val.getTime()));
	}

	////{PROTECTED REGION ID(R-173694974) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo dataFineIscrizioni. 
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
	public java.util.Date getDataFineIscrizioni() {
		return (dataFineIscrizioni == null ? null : new java.util.Date(dataFineIscrizioni.getTime()));
	}

	/**
	 * @generated
	 */
	private java.util.Date dataScadenzaGraduatoria = null;

	/**
	 * Imposta il valore della property [dataScadenzaGraduatoria]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setDataScadenzaGraduatoria(java.util.Date val) {
		dataScadenzaGraduatoria = (val == null ? null : new java.util.Date(val.getTime()));
	}

	////{PROTECTED REGION ID(R-273292555) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo dataScadenzaGraduatoria. 
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
	public java.util.Date getDataScadenzaGraduatoria() {
		return (dataScadenzaGraduatoria == null ? null : new java.util.Date(dataScadenzaGraduatoria.getTime()));
	}

	/**
	 * @generated
	 */
	private java.util.Date dataScadenzaRicorsi = null;

	/**
	 * Imposta il valore della property [dataScadenzaRicorsi]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setDataScadenzaRicorsi(java.util.Date val) {
		dataScadenzaRicorsi = (val == null ? null : new java.util.Date(val.getTime()));
	}

	////{PROTECTED REGION ID(R-244894235) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo dataScadenzaRicorsi. 
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
	public java.util.Date getDataScadenzaRicorsi() {
		return (dataScadenzaRicorsi == null ? null : new java.util.Date(dataScadenzaRicorsi.getTime()));
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

	////{PROTECTED REGION ID(R-1318688813) ENABLED START////}
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
	private java.lang.String codOrdineScuola = null;

	/**
	 * Imposta il valore della property [codOrdineScuola]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setCodOrdineScuola(java.lang.String val) {
		codOrdineScuola = val;
	}

	////{PROTECTED REGION ID(R459509411) ENABLED START////}
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

	/*PROTECTED REGION ID(R773556352) ENABLED START*/
	/// inserire qui eventuali ridefinizioni di toString, hashCode, equals
	/*PROTECTED REGION END*/
}
