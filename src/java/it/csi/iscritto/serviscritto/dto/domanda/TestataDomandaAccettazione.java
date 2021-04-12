
package it.csi.iscritto.serviscritto.dto.domanda;

////{PROTECTED REGION ID(R-585887063) ENABLED START////}
/**
 * Inserire qui la documentazione della classe TestataDomandaAccettazione.
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
public class TestataDomandaAccettazione implements java.io.Serializable {
	// il serial version UID e' impostato in base a quanto configurato nel modello
	/**
	 * @generated
	 */
	static final long serialVersionUID = 1;

	/**
	 * @generated
	 */
	private java.lang.Long idDomandaIscrizione = null;

	/**
	 * Imposta il valore della property [idDomandaIscrizione]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setIdDomandaIscrizione(java.lang.Long val) {
		idDomandaIscrizione = val;
	}

	////{PROTECTED REGION ID(R-457187313) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo idDomandaIscrizione. 
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
	public java.lang.Long getIdDomandaIscrizione() {
		return idDomandaIscrizione;
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

	////{PROTECTED REGION ID(R-1606358652) ENABLED START////}
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
	private java.lang.String codOrdineScuola = null;

	/**
	 * Imposta il valore della property [codOrdineScuola]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setCodOrdineScuola(java.lang.String val) {
		codOrdineScuola = val;
	}

	////{PROTECTED REGION ID(R-590191123) ENABLED START////}
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
	private java.lang.String nomeMinore = null;

	/**
	 * Imposta il valore della property [nomeMinore]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setNomeMinore(java.lang.String val) {
		nomeMinore = val;
	}

	////{PROTECTED REGION ID(R-672118990) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo nomeMinore. 
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
	public java.lang.String getNomeMinore() {
		return nomeMinore;
	}

	/**
	 * @generated
	 */
	private java.lang.String cognomeMinore = null;

	/**
	 * Imposta il valore della property [cognomeMinore]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setCognomeMinore(java.lang.String val) {
		cognomeMinore = val;
	}

	////{PROTECTED REGION ID(R369762171) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo cognomeMinore. 
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
	public java.lang.String getCognomeMinore() {
		return cognomeMinore;
	}

	/**
	 * @generated
	 */
	private java.lang.String codStatoDomanda = null;

	/**
	 * Imposta il valore della property [codStatoDomanda]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setCodStatoDomanda(java.lang.String val) {
		codStatoDomanda = val;
	}

	////{PROTECTED REGION ID(R1844829280) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo codStatoDomanda. 
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
	public java.lang.String getCodStatoDomanda() {
		return codStatoDomanda;
	}

	/**
	 * @generated
	 */
	private java.lang.String annoScolastico = null;

	/**
	 * Imposta il valore della property [annoScolastico]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setAnnoScolastico(java.lang.String val) {
		annoScolastico = val;
	}

	////{PROTECTED REGION ID(R-1437238409) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo annoScolastico. 
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
	public java.lang.String getAnnoScolastico() {
		return annoScolastico;
	}

	/**
	 * @generated
	 */
	private java.util.Date dataInvio = null;

	/**
	 * Imposta il valore della property [dataInvio]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setDataInvio(java.util.Date val) {
		dataInvio = (val == null ? null : new java.util.Date(val.getTime()));
	}

	////{PROTECTED REGION ID(R-252009788) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo dataInvio. 
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
	public java.util.Date getDataInvio() {
		return (dataInvio == null ? null : new java.util.Date(dataInvio.getTime()));
	}

	/**
	 * @generated
	 */
	private java.util.Date dataUltimaModifica = null;

	/**
	 * Imposta il valore della property [dataUltimaModifica]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setDataUltimaModifica(java.util.Date val) {
		dataUltimaModifica = (val == null ? null : new java.util.Date(val.getTime()));
	}

	////{PROTECTED REGION ID(R-661132997) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo dataUltimaModifica. 
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
	public java.util.Date getDataUltimaModifica() {
		return (dataUltimaModifica == null ? null : new java.util.Date(dataUltimaModifica.getTime()));
	}

	/**
	 * @generated
	 */
	private java.lang.String telefonoRichiedente = null;

	/**
	 * Imposta il valore della property [telefonoRichiedente]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setTelefonoRichiedente(java.lang.String val) {
		telefonoRichiedente = val;
	}

	////{PROTECTED REGION ID(R855801449) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo telefonoRichiedente. 
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
	public java.lang.String getTelefonoRichiedente() {
		return telefonoRichiedente;
	}

	/**
	 * @generated
	 */
	private java.lang.String codTipoPasto = null;

	/**
	 * Imposta il valore della property [codTipoPasto]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setCodTipoPasto(java.lang.String val) {
		codTipoPasto = val;
	}

	////{PROTECTED REGION ID(R-1474437542) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo codTipoPasto. 
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
	public java.lang.String getCodTipoPasto() {
		return codTipoPasto;
	}

	/**
	 * @generated
	 */
	private it.csi.iscritto.serviscritto.dto.domanda.Nido[] elencoPreferenze = null;

	/**
	 * Imposta il valore della property [elencoPreferenze]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setElencoPreferenze(it.csi.iscritto.serviscritto.dto.domanda.Nido[] val) {
		if (val == null) {
			elencoPreferenze = null;
		} else {
			// non si puo' usare System.arrayCopy perche' i DTO devono essere compilati Java 1.3
			elencoPreferenze = new it.csi.iscritto.serviscritto.dto.domanda.Nido[val.length];
			for (int i = 0; i < val.length; i++) { //NOSONAR  Reason:NOTINJ13
				elencoPreferenze[i] = val[i]; //NOSONAR  Reason:NOTINJ13
			} //NOSONAR  Reason:NOTINJ13
		}
	}

	////{PROTECTED REGION ID(R-1888918167) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo elencoPreferenze. 
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
	public it.csi.iscritto.serviscritto.dto.domanda.Nido[] getElencoPreferenze() {
		if (elencoPreferenze == null) {
			return null;
		} else {
			// non si puo' usare System.arrayCopy perche' i DTO devono essere compilati Java 1.3
			it.csi.iscritto.serviscritto.dto.domanda.Nido[] copy = new it.csi.iscritto.serviscritto.dto.domanda.Nido[elencoPreferenze.length];
			for (int i = 0; i < elencoPreferenze.length; i++) { //NOSONAR  Reason:NOTINJ13
				copy[i] = elencoPreferenze[i]; //NOSONAR  Reason:NOTINJ13
			} //NOSONAR  Reason:NOTINJ13
			return copy;
		}
	}

	/**
	 * @generated
	 */
	private it.csi.iscritto.serviscritto.dto.domanda.CondizionePunteggio[] elencoCondizioniPunteggio = null;

	/**
	 * Imposta il valore della property [elencoCondizioniPunteggio]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setElencoCondizioniPunteggio(it.csi.iscritto.serviscritto.dto.domanda.CondizionePunteggio[] val) {
		if (val == null) {
			elencoCondizioniPunteggio = null;
		} else {
			// non si puo' usare System.arrayCopy perche' i DTO devono essere compilati Java 1.3
			elencoCondizioniPunteggio = new it.csi.iscritto.serviscritto.dto.domanda.CondizionePunteggio[val.length];
			for (int i = 0; i < val.length; i++) { //NOSONAR  Reason:NOTINJ13
				elencoCondizioniPunteggio[i] = val[i]; //NOSONAR  Reason:NOTINJ13
			} //NOSONAR  Reason:NOTINJ13
		}
	}

	////{PROTECTED REGION ID(R-1704810809) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo elencoCondizioniPunteggio. 
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
	public it.csi.iscritto.serviscritto.dto.domanda.CondizionePunteggio[] getElencoCondizioniPunteggio() {
		if (elencoCondizioniPunteggio == null) {
			return null;
		} else {
			// non si puo' usare System.arrayCopy perche' i DTO devono essere compilati Java 1.3
			it.csi.iscritto.serviscritto.dto.domanda.CondizionePunteggio[] copy = new it.csi.iscritto.serviscritto.dto.domanda.CondizionePunteggio[elencoCondizioniPunteggio.length];
			for (int i = 0; i < elencoCondizioniPunteggio.length; i++) { //NOSONAR  Reason:NOTINJ13
				copy[i] = elencoCondizioniPunteggio[i]; //NOSONAR  Reason:NOTINJ13
			} //NOSONAR  Reason:NOTINJ13
			return copy;
		}
	}

	/**
	 * @generated
	 */
	private it.csi.iscritto.serviscritto.dto.domanda.Materna[] elencoPreferenzeMaterna = null;

	/**
	 * Imposta il valore della property [elencoPreferenzeMaterna]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setElencoPreferenzeMaterna(it.csi.iscritto.serviscritto.dto.domanda.Materna[] val) {
		if (val == null) {
			elencoPreferenzeMaterna = null;
		} else {
			// non si puo' usare System.arrayCopy perche' i DTO devono essere compilati Java 1.3
			elencoPreferenzeMaterna = new it.csi.iscritto.serviscritto.dto.domanda.Materna[val.length];
			for (int i = 0; i < val.length; i++) { //NOSONAR  Reason:NOTINJ13
				elencoPreferenzeMaterna[i] = val[i]; //NOSONAR  Reason:NOTINJ13
			} //NOSONAR  Reason:NOTINJ13
		}
	}

	////{PROTECTED REGION ID(R-2190633) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo elencoPreferenzeMaterna. 
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
	public it.csi.iscritto.serviscritto.dto.domanda.Materna[] getElencoPreferenzeMaterna() {
		if (elencoPreferenzeMaterna == null) {
			return null;
		} else {
			// non si puo' usare System.arrayCopy perche' i DTO devono essere compilati Java 1.3
			it.csi.iscritto.serviscritto.dto.domanda.Materna[] copy = new it.csi.iscritto.serviscritto.dto.domanda.Materna[elencoPreferenzeMaterna.length];
			for (int i = 0; i < elencoPreferenzeMaterna.length; i++) { //NOSONAR  Reason:NOTINJ13
				copy[i] = elencoPreferenzeMaterna[i]; //NOSONAR  Reason:NOTINJ13
			} //NOSONAR  Reason:NOTINJ13
			return copy;
		}
	}

	/**
	 * @generated
	 */
	private java.lang.String irc = null;

	/**
	 * Imposta il valore della property [irc]
	 * @param val il valore da impostare
	 * @generated
	 */
	public void setIrc(java.lang.String val) {
		irc = val;
	}

	////{PROTECTED REGION ID(R585701649) ENABLED START////}
	/**
	 * Inserire qui la documentazione dell'attributo irc. 
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
	public java.lang.String getIrc() {
		return irc;
	}

	/*PROTECTED REGION ID(R1542181392) ENABLED START*/
	/// inserire qui eventuali ridefinizioni di toString, hashCode, equals
	/*PROTECTED REGION END*/
}
