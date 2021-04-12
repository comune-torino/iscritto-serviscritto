
package it.csi.iscritto.serviscritto.dto.domanda;

////{PROTECTED REGION ID(R264549460) ENABLED START////}
/**
 * Inserire qui la documentazione della classe DatiCondizioneOccupazionale.
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
public class DatiCondizioneOccupazionale implements java.io.Serializable {
	// il serial version UID e' impostato in base a quanto configurato nel modello
	/**
	 * @generated
	 */
	static final long serialVersionUID = 1;

	/**
	 * @generated
	 */
	private it.csi.iscritto.serviscritto.dto.domanda.Dipendente dipendente = null;

	/**
	 * Imposta il valore della property [dipendente]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setDipendente(it.csi.iscritto.serviscritto.dto.domanda.Dipendente val) {
		dipendente = val;
	}

	////{PROTECTED REGION ID(R587132062) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo dipendente. 
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
	public it.csi.iscritto.serviscritto.dto.domanda.Dipendente getDipendente() {
		return dipendente;
	}

	/**
	 * @generated
	 */
	private it.csi.iscritto.serviscritto.dto.domanda.Autonomo autonomo = null;

	/**
	 * Imposta il valore della property [autonomo]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setAutonomo(it.csi.iscritto.serviscritto.dto.domanda.Autonomo val) {
		autonomo = val;
	}

	////{PROTECTED REGION ID(R638729638) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo autonomo. 
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
	public it.csi.iscritto.serviscritto.dto.domanda.Autonomo getAutonomo() {
		return autonomo;
	}

	/**
	 * @generated
	 */
	private it.csi.iscritto.serviscritto.dto.domanda.Disoccupato disoccupato = null;

	/**
	 * Imposta il valore della property [disoccupato]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setDisoccupato(it.csi.iscritto.serviscritto.dto.domanda.Disoccupato val) {
		disoccupato = val;
	}

	////{PROTECTED REGION ID(R-1044354004) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo disoccupato. 
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
	public it.csi.iscritto.serviscritto.dto.domanda.Disoccupato getDisoccupato() {
		return disoccupato;
	}

	/**
	 * @generated
	 */
	private it.csi.iscritto.serviscritto.dto.domanda.NonOccupato[] nonOccupato = null;

	/**
	 * Imposta il valore della property [nonOccupato]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setNonOccupato(it.csi.iscritto.serviscritto.dto.domanda.NonOccupato[] val) {
		if (val == null) {
			nonOccupato = null;
		} else {
			// non si puo' usare System.arrayCopy perche' i DTO devono essere compilati Java 1.3
			nonOccupato = new it.csi.iscritto.serviscritto.dto.domanda.NonOccupato[val.length];
			for (int i = 0; i < val.length; i++) { //NOSONAR  Reason:NOTINJ13
				nonOccupato[i] = val[i]; //NOSONAR  Reason:NOTINJ13
			} //NOSONAR  Reason:NOTINJ13
		}
	}

	////{PROTECTED REGION ID(R1793869707) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo nonOccupato. 
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
	public it.csi.iscritto.serviscritto.dto.domanda.NonOccupato[] getNonOccupato() {
		if (nonOccupato == null) {
			return null;
		} else {
			// non si puo' usare System.arrayCopy perche' i DTO devono essere compilati Java 1.3
			it.csi.iscritto.serviscritto.dto.domanda.NonOccupato[] copy = new it.csi.iscritto.serviscritto.dto.domanda.NonOccupato[nonOccupato.length];
			for (int i = 0; i < nonOccupato.length; i++) { //NOSONAR  Reason:NOTINJ13
				copy[i] = nonOccupato[i]; //NOSONAR  Reason:NOTINJ13
			} //NOSONAR  Reason:NOTINJ13
			return copy;
		}
	}

	/**
	 * @generated
	 */
	private it.csi.iscritto.serviscritto.dto.domanda.Studente studente = null;

	/**
	 * Imposta il valore della property [studente]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setStudente(it.csi.iscritto.serviscritto.dto.domanda.Studente val) {
		studente = val;
	}

	////{PROTECTED REGION ID(R1075242462) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo studente. 
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
	public it.csi.iscritto.serviscritto.dto.domanda.Studente getStudente() {
		return studente;
	}

	/*PROTECTED REGION ID(R-1588243073) ENABLED START*/
	/// inserire qui eventuali ridefinizioni di toString, hashCode, equals
	/*PROTECTED REGION END*/
}
