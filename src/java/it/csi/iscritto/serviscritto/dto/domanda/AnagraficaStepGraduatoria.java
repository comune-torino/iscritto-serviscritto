
package it.csi.iscritto.serviscritto.dto.domanda;

////{PROTECTED REGION ID(R1217478471) ENABLED START////}
/**
 * Inserire qui la documentazione della classe AnagraficaStepGraduatoria.
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
public class AnagraficaStepGraduatoria implements java.io.Serializable {
	// il serial version UID e' impostato in base a quanto configurato nel modello
	/**
	 * @generated
	 */
	static final long serialVersionUID = 1;

	/**
	 * @generated
	 */
	private java.lang.Integer step = null;

	/**
	 * Imposta il valore della property [step]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setStep(java.lang.Integer val) {
		step = val;
	}

	////{PROTECTED REGION ID(R335039123) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo step. 
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
	public java.lang.Integer getStep() {
		return step;
	}

	/**
	 * @generated
	 */
	private java.lang.Long idStepGra = null;

	/**
	 * Imposta il valore della property [idStepGra]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setIdStepGra(java.lang.Long val) {
		idStepGra = val;
	}

	////{PROTECTED REGION ID(R-198855320) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo idStepGra. 
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
	public java.lang.Long getIdStepGra() {
		return idStepGra;
	}

	/**
	 * @generated
	 */
	private java.util.Date dtStepGra = null;

	/**
	 * Imposta il valore della property [dtStepGra]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setDtStepGra(java.util.Date val) {
		dtStepGra = (val == null ? null : new java.util.Date(val.getTime()));
	}

	////{PROTECTED REGION ID(R-1931323309) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo dtStepGra. 
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
	public java.util.Date getDtStepGra() {
		return (dtStepGra == null ? null : new java.util.Date(dtStepGra.getTime()));
	}

	/**
	 * @generated
	 */
	private java.util.Date dtDomInvDa = null;

	/**
	 * Imposta il valore della property [dtDomInvDa]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setDtDomInvDa(java.util.Date val) {
		dtDomInvDa = (val == null ? null : new java.util.Date(val.getTime()));
	}

	////{PROTECTED REGION ID(R-62202013) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo dtDomInvDa. 
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
	public java.util.Date getDtDomInvDa() {
		return (dtDomInvDa == null ? null : new java.util.Date(dtDomInvDa.getTime()));
	}

	/**
	 * @generated
	 */
	private java.util.Date dtDomInvA = null;

	/**
	 * Imposta il valore della property [dtDomInvA]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setDtDomInvA(java.util.Date val) {
		dtDomInvA = (val == null ? null : new java.util.Date(val.getTime()));
	}

	////{PROTECTED REGION ID(R1799108795) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo dtDomInvA. 
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
	public java.util.Date getDtDomInvA() {
		return (dtDomInvA == null ? null : new java.util.Date(dtDomInvA.getTime()));
	}

	/**
	 * @generated
	 */
	private java.util.Date dtAllegati = null;

	/**
	 * Imposta il valore della property [dtAllegati]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setDtAllegati(java.util.Date val) {
		dtAllegati = (val == null ? null : new java.util.Date(val.getTime()));
	}

	////{PROTECTED REGION ID(R633792746) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo dtAllegati. 
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
	public java.util.Date getDtAllegati() {
		return (dtAllegati == null ? null : new java.util.Date(dtAllegati.getTime()));
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

	////{PROTECTED REGION ID(R143152481) ENABLED START////}
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
	private java.lang.String codAnnoScolastico = null;

	/**
	 * Imposta il valore della property [codAnnoScolastico]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setCodAnnoScolastico(java.lang.String val) {
		codAnnoScolastico = val;
	}

	////{PROTECTED REGION ID(R-1786349633) ENABLED START////}
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

	////{PROTECTED REGION ID(R-1310807665) ENABLED START////}
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

	/*PROTECTED REGION ID(R575819500) ENABLED START*/
	/// inserire qui eventuali ridefinizioni di toString, hashCode, equals
	/*PROTECTED REGION END*/
}
