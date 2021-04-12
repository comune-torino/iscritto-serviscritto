
package it.csi.iscritto.serviscritto.dto.domanda;

////{PROTECTED REGION ID(R1205331337) ENABLED START////}
/**
 * Inserire qui la documentazione della classe SoggettoAltroComponente.
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
public class SoggettoAltroComponente implements java.io.Serializable {
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

	////{PROTECTED REGION ID(R-1317751708) ENABLED START////}
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
	private java.lang.String relazioneConMinore = null;

	/**
	 * Imposta il valore della property [relazioneConMinore]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setRelazioneConMinore(java.lang.String val) {
		relazioneConMinore = val;
	}

	////{PROTECTED REGION ID(R-252874100) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo relazioneConMinore. 
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
	public java.lang.String getRelazioneConMinore() {
		return relazioneConMinore;
	}

	/**
	 * @generated
	 */
	private it.csi.iscritto.serviscritto.dto.domanda.Anagrafica anagrafica = null;

	/**
	 * Imposta il valore della property [anagrafica]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setAnagrafica(it.csi.iscritto.serviscritto.dto.domanda.Anagrafica val) {
		anagrafica = val;
	}

	////{PROTECTED REGION ID(R-1684010964) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo anagrafica. 
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
	public it.csi.iscritto.serviscritto.dto.domanda.Anagrafica getAnagrafica() {
		return anagrafica;
	}

	/**
	 * @generated
	 */
	private it.csi.iscritto.serviscritto.dto.domanda.LuogoNascita luogoNascita = null;

	/**
	 * Imposta il valore della property [luogoNascita]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setLuogoNascita(it.csi.iscritto.serviscritto.dto.domanda.LuogoNascita val) {
		luogoNascita = val;
	}

	////{PROTECTED REGION ID(R-906966226) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo luogoNascita. 
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
	public it.csi.iscritto.serviscritto.dto.domanda.LuogoNascita getLuogoNascita() {
		return luogoNascita;
	}

	/**
	 * @generated
	 */
	private it.csi.iscritto.serviscritto.dto.domanda.Residenza residenza = null;

	/**
	 * Imposta il valore della property [residenza]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setResidenza(it.csi.iscritto.serviscritto.dto.domanda.Residenza val) {
		residenza = val;
	}

	////{PROTECTED REGION ID(R-2044616094) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo residenza. 
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
	public it.csi.iscritto.serviscritto.dto.domanda.Residenza getResidenza() {
		return residenza;
	}

	/**
	 * @generated
	 */
	private it.csi.iscritto.serviscritto.dto.domanda.ProblemiSalute problemiSalute = null;

	/**
	 * Imposta il valore della property [problemiSalute]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setProblemiSalute(it.csi.iscritto.serviscritto.dto.domanda.ProblemiSalute val) {
		problemiSalute = val;
	}

	////{PROTECTED REGION ID(R192490779) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo problemiSalute. 
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
	public it.csi.iscritto.serviscritto.dto.domanda.ProblemiSalute getProblemiSalute() {
		return problemiSalute;
	}

	/**
	 * @generated
	 */
	private java.lang.Boolean residenzaNao = null;

	/**
	 * Imposta il valore della property [residenzaNao]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setResidenzaNao(java.lang.Boolean val) {
		residenzaNao = val;
	}

	////{PROTECTED REGION ID(R68213594) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo residenzaNao. 
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
	public java.lang.Boolean getResidenzaNao() {
		return residenzaNao;
	}

	/*PROTECTED REGION ID(R868959402) ENABLED START*/
	/// inserire qui eventuali ridefinizioni di toString, hashCode, equals
	/*PROTECTED REGION END*/
}
