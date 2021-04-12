
package it.csi.iscritto.serviscritto.dto.domanda;

////{PROTECTED REGION ID(R-1622258779) ENABLED START////}
/**
 * Inserire qui la documentazione della classe ComponentiNucleo.
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
public class ComponentiNucleo implements java.io.Serializable {
	// il serial version UID e' impostato in base a quanto configurato nel modello
	/**
	 * @generated
	 */
	static final long serialVersionUID = 1;

	/**
	 * @generated
	 */
	private it.csi.iscritto.serviscritto.dto.domanda.SoggettoNucleo[] soggetti = null;

	/**
	 * Imposta il valore della property [soggetti]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setSoggetti(it.csi.iscritto.serviscritto.dto.domanda.SoggettoNucleo[] val) {
		if (val == null) {
			soggetti = null;
		} else {
			// non si puo' usare System.arrayCopy perche' i DTO devono essere compilati Java 1.3
			soggetti = new it.csi.iscritto.serviscritto.dto.domanda.SoggettoNucleo[val.length];
			for (int i = 0; i < val.length; i++) { //NOSONAR  Reason:NOTINJ13
				soggetti[i] = val[i]; //NOSONAR  Reason:NOTINJ13
			} //NOSONAR  Reason:NOTINJ13
		}
	}

	////{PROTECTED REGION ID(R1569192005) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo soggetti. 
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
	public it.csi.iscritto.serviscritto.dto.domanda.SoggettoNucleo[] getSoggetti() {
		if (soggetti == null) {
			return null;
		} else {
			// non si puo' usare System.arrayCopy perche' i DTO devono essere compilati Java 1.3
			it.csi.iscritto.serviscritto.dto.domanda.SoggettoNucleo[] copy = new it.csi.iscritto.serviscritto.dto.domanda.SoggettoNucleo[soggetti.length];
			for (int i = 0; i < soggetti.length; i++) { //NOSONAR  Reason:NOTINJ13
				copy[i] = soggetti[i]; //NOSONAR  Reason:NOTINJ13
			} //NOSONAR  Reason:NOTINJ13
			return copy;
		}
	}

	/*PROTECTED REGION ID(R-71593132) ENABLED START*/
	/// inserire qui eventuali ridefinizioni di toString, hashCode, equals
	/*PROTECTED REGION END*/
}
