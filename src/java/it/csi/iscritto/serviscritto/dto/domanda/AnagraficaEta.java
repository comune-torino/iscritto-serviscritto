
package it.csi.iscritto.serviscritto.dto.domanda;

////{PROTECTED REGION ID(R-470352720) ENABLED START////}
/**
 * Inserire qui la documentazione della classe AnagraficaEta.
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
public class AnagraficaEta implements java.io.Serializable {
	// il serial version UID e' impostato in base a quanto configurato nel modello
	/**
	 * @generated
	 */
	static final long serialVersionUID = 1;

	/**
	 * @generated
	 */
	private java.lang.Long idEta = null;

	/**
	 * Imposta il valore della property [idEta]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setIdEta(java.lang.Long val) {
		idEta = val;
	}

	////{PROTECTED REGION ID(R1565629383) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo idEta. 
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
	public java.lang.Long getIdEta() {
		return idEta;
	}

	/**
	 * @generated
	 */
	private java.util.Date dataDa = null;

	/**
	 * Imposta il valore della property [dataDa]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setDataDa(java.util.Date val) {
		dataDa = (val == null ? null : new java.util.Date(val.getTime()));
	}

	////{PROTECTED REGION ID(R1145335415) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo dataDa. 
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
	public java.util.Date getDataDa() {
		return (dataDa == null ? null : new java.util.Date(dataDa.getTime()));
	}

	/**
	 * @generated
	 */
	private java.util.Date dataA = null;

	/**
	 * Imposta il valore della property [dataA]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setDataA(java.util.Date val) {
		dataA = (val == null ? null : new java.util.Date(val.getTime()));
	}

	////{PROTECTED REGION ID(R1560966951) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo dataA. 
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
	public java.util.Date getDataA() {
		return (dataA == null ? null : new java.util.Date(dataA.getTime()));
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

	////{PROTECTED REGION ID(R-443111478) ENABLED START////}
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
	private java.lang.String codOrdineScuola = null;

	/**
	 * Imposta il valore della property [codOrdineScuola]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setCodOrdineScuola(java.lang.String val) {
		codOrdineScuola = val;
	}

	////{PROTECTED REGION ID(R1971014918) ENABLED START////}
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

	////{PROTECTED REGION ID(R-460842634) ENABLED START////}
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
	private java.lang.String codFasciaEta = null;

	/**
	 * Imposta il valore della property [codFasciaEta]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setCodFasciaEta(java.lang.String val) {
		codFasciaEta = val;
	}

	////{PROTECTED REGION ID(R-430463481) ENABLED START////}
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

	/*PROTECTED REGION ID(R491461219) ENABLED START*/
	/// inserire qui eventuali ridefinizioni di toString, hashCode, equals
	/*PROTECTED REGION END*/
}
