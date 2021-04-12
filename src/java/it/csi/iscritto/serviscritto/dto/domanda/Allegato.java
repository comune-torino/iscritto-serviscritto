
package it.csi.iscritto.serviscritto.dto.domanda;

////{PROTECTED REGION ID(R-44325608) ENABLED START////}
/**
 * Inserire qui la documentazione della classe Allegato.
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
public class Allegato implements java.io.Serializable {
	// il serial version UID e' impostato in base a quanto configurato nel modello
	/**
	 * @generated
	 */
	static final long serialVersionUID = 1;

	/**
	 * @generated
	 */
	private java.lang.Long idAllegato = null;

	/**
	 * Imposta il valore della property [idAllegato]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setIdAllegato(java.lang.Long val) {
		idAllegato = val;
	}

	////{PROTECTED REGION ID(R812991244) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo idAllegato. 
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
	public java.lang.Long getIdAllegato() {
		return idAllegato;
	}

	/**
	 * @generated
	 */
	private byte[] documento = null;

	/**
	 * Imposta il valore della property [documento]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setDocumento(byte[] val) {
		if (val == null) {
			documento = null;
		} else {
			// non si puo' usare System.arrayCopy perche' i DTO devono essere compilati Java 1.3
			documento = new byte[val.length];
			for (int i = 0; i < val.length; i++) { //NOSONAR  Reason:NOTINJ13
				documento[i] = val[i]; //NOSONAR  Reason:NOTINJ13
			} //NOSONAR  Reason:NOTINJ13
		}
	}

	////{PROTECTED REGION ID(R1309534364) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo documento. 
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
	public byte[] getDocumento() {
		if (documento == null) {
			return null;
		} else {
			// non si puo' usare System.arrayCopy perche' i DTO devono essere compilati Java 1.3
			byte[] copy = new byte[documento.length];
			for (int i = 0; i < documento.length; i++) { //NOSONAR  Reason:NOTINJ13
				copy[i] = documento[i]; //NOSONAR  Reason:NOTINJ13
			} //NOSONAR  Reason:NOTINJ13
			return copy;
		}
	}

	/**
	 * @generated
	 */
	private java.lang.String protocollo = null;

	/**
	 * Imposta il valore della property [protocollo]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setProtocollo(java.lang.String val) {
		protocollo = val;
	}

	////{PROTECTED REGION ID(R1357086003) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo protocollo. 
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
	public java.lang.String getProtocollo() {
		return protocollo;
	}

	/**
	 * @generated
	 */
	private java.lang.Long idAnagraficaSoggetto = null;

	/**
	 * Imposta il valore della property [idAnagraficaSoggetto]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setIdAnagraficaSoggetto(java.lang.Long val) {
		idAnagraficaSoggetto = val;
	}

	////{PROTECTED REGION ID(R548974140) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo idAnagraficaSoggetto. 
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
	public java.lang.Long getIdAnagraficaSoggetto() {
		return idAnagraficaSoggetto;
	}

	/**
	 * @generated
	 */
	private java.lang.String codTipoAllegato = null;

	/**
	 * Imposta il valore della property [codTipoAllegato]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setCodTipoAllegato(java.lang.String val) {
		codTipoAllegato = val;
	}

	////{PROTECTED REGION ID(R1986208397) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo codTipoAllegato. 
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
	public java.lang.String getCodTipoAllegato() {
		return codTipoAllegato;
	}

	/**
	 * @generated
	 */
	private java.util.Date dataInserimento = null;

	/**
	 * Imposta il valore della property [dataInserimento]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setDataInserimento(java.util.Date val) {
		dataInserimento = (val == null ? null : new java.util.Date(val.getTime()));
	}

	////{PROTECTED REGION ID(R1654457025) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo dataInserimento. 
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
	public java.util.Date getDataInserimento() {
		return (dataInserimento == null ? null : new java.util.Date(dataInserimento.getTime()));
	}

	/**
	 * @generated
	 */
	private java.lang.String nomeFile = null;

	/**
	 * Imposta il valore della property [nomeFile]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setNomeFile(java.lang.String val) {
		nomeFile = val;
	}

	////{PROTECTED REGION ID(R-963186355) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo nomeFile. 
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
	public java.lang.String getNomeFile() {
		return nomeFile;
	}

	/**
	 * @generated
	 */
	private java.lang.String mimeType = null;

	/**
	 * Imposta il valore della property [mimeType]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setMimeType(java.lang.String val) {
		mimeType = val;
	}

	////{PROTECTED REGION ID(R559348390) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo mimeType. 
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
	public java.lang.String getMimeType() {
		return mimeType;
	}

	/*PROTECTED REGION ID(R401803777) ENABLED START*/
	/// inserire qui eventuali ridefinizioni di toString, hashCode, equals
	/*PROTECTED REGION END*/
}
