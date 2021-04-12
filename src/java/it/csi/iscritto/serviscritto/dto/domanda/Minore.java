
package it.csi.iscritto.serviscritto.dto.domanda;

////{PROTECTED REGION ID(R233540207) ENABLED START////}
/**
 * Inserire qui la documentazione della classe Minore.
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
public class Minore implements java.io.Serializable {
	// il serial version UID e' impostato in base a quanto configurato nel modello
	/**
	 * @generated
	 */
	static final long serialVersionUID = 1;

	/**
	 * @generated
	 */
	private java.lang.Boolean presenzaNucleo = null;

	/**
	 * Imposta il valore della property [presenzaNucleo]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setPresenzaNucleo(java.lang.Boolean val) {
		presenzaNucleo = val;
	}

	////{PROTECTED REGION ID(R904875305) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo presenzaNucleo. 
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
	public java.lang.Boolean getPresenzaNucleo() {
		return presenzaNucleo;
	}

	/**
	 * @generated
	 */
	private java.lang.Boolean residenzaConRichiedente = null;

	/**
	 * Imposta il valore della property [residenzaConRichiedente]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setResidenzaConRichiedente(java.lang.Boolean val) {
		residenzaConRichiedente = val;
	}

	////{PROTECTED REGION ID(R487719872) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo residenzaConRichiedente. 
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
	public java.lang.Boolean getResidenzaConRichiedente() {
		return residenzaConRichiedente;
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

	////{PROTECTED REGION ID(R1844397458) ENABLED START////}
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

	////{PROTECTED REGION ID(R1164330772) ENABLED START////}
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

	////{PROTECTED REGION ID(R1809981500) ENABLED START////}
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
	private it.csi.iscritto.serviscritto.dto.domanda.Disabilita disabilita = null;

	/**
	 * Imposta il valore della property [disabilita]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setDisabilita(it.csi.iscritto.serviscritto.dto.domanda.Disabilita val) {
		disabilita = val;
	}

	////{PROTECTED REGION ID(R1527455859) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo disabilita. 
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
	public it.csi.iscritto.serviscritto.dto.domanda.Disabilita getDisabilita() {
		return disabilita;
	}

	/**
	 * @generated
	 */
	private it.csi.iscritto.serviscritto.dto.domanda.ServiziSociali serviziSociali = null;

	/**
	 * Imposta il valore della property [serviziSociali]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setServiziSociali(it.csi.iscritto.serviscritto.dto.domanda.ServiziSociali val) {
		serviziSociali = val;
	}

	////{PROTECTED REGION ID(R314141417) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo serviziSociali. 
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
	public it.csi.iscritto.serviscritto.dto.domanda.ServiziSociali getServiziSociali() {
		return serviziSociali;
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

	////{PROTECTED REGION ID(R2139047809) ENABLED START////}
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
	private it.csi.iscritto.serviscritto.dto.domanda.FratelloFrequentante fratelloFrequentante = null;

	/**
	 * Imposta il valore della property [fratelloFrequentante]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setFratelloFrequentante(it.csi.iscritto.serviscritto.dto.domanda.FratelloFrequentante val) {
		fratelloFrequentante = val;
	}

	////{PROTECTED REGION ID(R-1345632860) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo fratelloFrequentante. 
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
	public it.csi.iscritto.serviscritto.dto.domanda.FratelloFrequentante getFratelloFrequentante() {
		return fratelloFrequentante;
	}

	/**
	 * @generated
	 */
	private it.csi.iscritto.serviscritto.dto.domanda.Trasferimento trasferimento = null;

	/**
	 * Imposta il valore della property [trasferimento]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setTrasferimento(it.csi.iscritto.serviscritto.dto.domanda.Trasferimento val) {
		trasferimento = val;
	}

	////{PROTECTED REGION ID(R-1527970276) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo trasferimento. 
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
	public it.csi.iscritto.serviscritto.dto.domanda.Trasferimento getTrasferimento() {
		return trasferimento;
	}

	/**
	 * @generated
	 */
	private it.csi.iscritto.serviscritto.dto.domanda.Spostamento spostamento = null;

	/**
	 * Imposta il valore della property [spostamento]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setSpostamento(it.csi.iscritto.serviscritto.dto.domanda.Spostamento val) {
		spostamento = val;
	}

	////{PROTECTED REGION ID(R354058900) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo spostamento. 
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
	public it.csi.iscritto.serviscritto.dto.domanda.Spostamento getSpostamento() {
		return spostamento;
	}

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

	////{PROTECTED REGION ID(R1093842890) ENABLED START////}
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
	private java.lang.Boolean residenzaNao = null;

	/**
	 * Imposta il valore della property [residenzaNao]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setResidenzaNao(java.lang.Boolean val) {
		residenzaNao = val;
	}

	////{PROTECTED REGION ID(R2139510592) ENABLED START////}
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

	/**
	 * @generated
	 */
	private java.lang.String cinqueAnniNonFrequentante = null;

	/**
	 * Imposta il valore della property [cinqueAnniNonFrequentante]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setCinqueAnniNonFrequentante(java.lang.String val) {
		cinqueAnniNonFrequentante = val;
	}

	////{PROTECTED REGION ID(R-1231295095) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo cinqueAnniNonFrequentante. 
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
	public java.lang.String getCinqueAnniNonFrequentante() {
		return cinqueAnniNonFrequentante;
	}

	/**
	 * @generated
	 */
	private it.csi.iscritto.serviscritto.dto.domanda.ListaAttesa listaAttesa = null;

	/**
	 * Imposta il valore della property [listaAttesa]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setListaAttesa(it.csi.iscritto.serviscritto.dto.domanda.ListaAttesa val) {
		listaAttesa = val;
	}

	////{PROTECTED REGION ID(R-360559930) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo listaAttesa. 
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
	public it.csi.iscritto.serviscritto.dto.domanda.ListaAttesa getListaAttesa() {
		return listaAttesa;
	}

	/**
	 * @generated
	 */
	private it.csi.iscritto.serviscritto.dto.domanda.FratelloNidoContiguo fratelloNidoContiguo = null;

	/**
	 * Imposta il valore della property [fratelloNidoContiguo]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setFratelloNidoContiguo(it.csi.iscritto.serviscritto.dto.domanda.FratelloNidoContiguo val) {
		fratelloNidoContiguo = val;
	}

	////{PROTECTED REGION ID(R1535307400) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo fratelloNidoContiguo. 
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
	public it.csi.iscritto.serviscritto.dto.domanda.FratelloNidoContiguo getFratelloNidoContiguo() {
		return fratelloNidoContiguo;
	}

	/*PROTECTED REGION ID(R-1390649334) ENABLED START*/
	/// inserire qui eventuali ridefinizioni di toString, hashCode, equals
	/*PROTECTED REGION END*/
}
