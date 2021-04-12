
package it.csi.iscritto.serviscritto.dto.domanda;

////{PROTECTED REGION ID(R1653907690) ENABLED START////}
/**
 * Inserire qui la documentazione della classe StepGraduatoria.
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
public class StepGraduatoria implements java.io.Serializable {
	// il serial version UID e' impostato in base a quanto configurato nel modello
	/**
	 * @generated
	 */
	static final long serialVersionUID = 1;

	/**
	 * @generated
	 */
	private java.lang.Long id = null;

	/**
	 * Imposta il valore della property [id]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setId(java.lang.Long val) {
		id = val;
	}

	////{PROTECTED REGION ID(R267393925) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo id. 
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
	public java.lang.Long getId() {
		return id;
	}

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

	////{PROTECTED REGION ID(R-732159306) ENABLED START////}
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
	private java.util.Date dataStepGraduatoria = null;

	/**
	 * Imposta il valore della property [dataStepGraduatoria]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setDataStepGraduatoria(java.util.Date val) {
		dataStepGraduatoria = (val == null ? null : new java.util.Date(val.getTime()));
	}

	////{PROTECTED REGION ID(R-1521476875) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo dataStepGraduatoria. 
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
	public java.util.Date getDataStepGraduatoria() {
		return (dataStepGraduatoria == null ? null : new java.util.Date(dataStepGraduatoria.getTime()));
	}

	/**
	 * @generated
	 */
	private java.util.Date dataInvioDa = null;

	/**
	 * Imposta il valore della property [dataInvioDa]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setDataInvioDa(java.util.Date val) {
		dataInvioDa = (val == null ? null : new java.util.Date(val.getTime()));
	}

	////{PROTECTED REGION ID(R624081280) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo dataInvioDa. 
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
	public java.util.Date getDataInvioDa() {
		return (dataInvioDa == null ? null : new java.util.Date(dataInvioDa.getTime()));
	}

	/**
	 * @generated
	 */
	private java.util.Date dataInvioA = null;

	/**
	 * Imposta il valore della property [dataInvioA]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setDataInvioA(java.util.Date val) {
		dataInvioA = (val == null ? null : new java.util.Date(val.getTime()));
	}

	////{PROTECTED REGION ID(R2098341630) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo dataInvioA. 
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
	public java.util.Date getDataInvioA() {
		return (dataInvioA == null ? null : new java.util.Date(dataInvioA.getTime()));
	}

	/*PROTECTED REGION ID(R-1557045079) ENABLED START*/
	/// inserire qui eventuali ridefinizioni di toString, hashCode, equals
	/*PROTECTED REGION END*/
}
