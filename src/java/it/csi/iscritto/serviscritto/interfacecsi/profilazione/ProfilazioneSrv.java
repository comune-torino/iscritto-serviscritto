
package it.csi.iscritto.serviscritto.interfacecsi.profilazione;

import it.csi.iscritto.serviscritto.dto.profilazione.*;

import it.csi.iscritto.serviscritto.exception.profilazione.*;

////{PROTECTED REGION ID(R403116447) ENABLED START////}
/**
 * Inserire qui la documentazione dell'interfaccia pubblica del servizio profilazione.
 * Consigli:
 * <ul>
 * <li> Descrivere qual'&egrave; lo scopo generale del servizio
 * <li> Se necessario fornire una overview delle funzioni messe a disposizione
 *      eventualmente raggruppandole logicamente. Il dettaglio dei singoli
 *      metodi va documentato in corrispondenza dei metodi stessi
 * <li> Se necessario descrivere gli scenari di utilizzo pi&ugrave; frequenti, ovvero
 *      le "coreografie" (nel caso sia necessario richiamare in una sequenza
 *      particolare i metodi
 * <li> Inserire informazioni quali il livello di securizzazione A0-A3
 * <li> Inserire varie ed eventuali... 
 * </ul>
 * @generated
 */
////{PROTECTED REGION END////}
public interface ProfilazioneSrv {

	////{PROTECTED REGION ID(R-1207937263) ENABLED START////}
	/**
	 * Inserire qui la documentazione del metodo getFunzioniAbilitateOperatore.
	 * Descrivere dettagliatamente:
	 * <ul>
	 * <li>la semantica del metodo (facendo riferimento ai parametri). E' importante 
	 *     elencare casi particolari (dati non trovati, ecc...)
	 * <li> i singoli parametri (nelle sezioni apposite sottostanti): &egrave; importante
	 *      indicare:
	 *      <ul>
	 *      <li>se il parametro &egrave; obbligatorio
	 *      <li>se ci sono dei vincoli sulla valorizzazione (es. range numerico,
	 *          dimensioni massime in caso di stringa o tipo array, eventuale necessit&agrave;
	 *          di corrispondenza con una particolare codifica, che pu&ograve; essere prefissata
	 *          (es. da un elenco predefinito) oppure dinamica (presente su un archivio
	 *          di un'applicazione)
	 *      </ul>
	 * <li> le eccezioni rilanciate (nelle sezioni apposite sottostanti)
	 * <li> il tipo di ritorno
	 * </ul>
	 * @param codiceFiscale [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @return it.csi.iscritto.serviscritto.dto.profilazione.Funzione[]
	 * @throws ProfilazioneException
	 * @throws CSIException (eccezione base rilanciata dall'infrastruttura di cooperazione)
	 * @throws SystemException in caso di errore di sistema (connessione, comunicazione, ecc.)
	 * @throws UnrecoverableException in caso di errore imprevisto e non recuperabile
	 * @generated
	 */
	////{PROTECTED REGION END////}
	public it.csi.iscritto.serviscritto.dto.profilazione.Funzione[] getFunzioniAbilitateOperatore( //NOSONAR  Reason:EIAS

			java.lang.String codiceFiscale, //NOSONAR  Reason:EIAS

			java.lang.String codiceProfilo //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.profilazione.ProfilazioneException; //NOSONAR  Reason:EIAS

	////{PROTECTED REGION ID(R-1359198307) ENABLED START////}
	/**
	 * Inserire qui la documentazione del metodo getAttivitaAbilitateOperatore.
	 * Descrivere dettagliatamente:
	 * <ul>
	 * <li>la semantica del metodo (facendo riferimento ai parametri). E' importante 
	 *     elencare casi particolari (dati non trovati, ecc...)
	 * <li> i singoli parametri (nelle sezioni apposite sottostanti): &egrave; importante
	 *      indicare:
	 *      <ul>
	 *      <li>se il parametro &egrave; obbligatorio
	 *      <li>se ci sono dei vincoli sulla valorizzazione (es. range numerico,
	 *          dimensioni massime in caso di stringa o tipo array, eventuale necessit&agrave;
	 *          di corrispondenza con una particolare codifica, che pu&ograve; essere prefissata
	 *          (es. da un elenco predefinito) oppure dinamica (presente su un archivio
	 *          di un'applicazione)
	 *      </ul>
	 * <li> le eccezioni rilanciate (nelle sezioni apposite sottostanti)
	 * <li> il tipo di ritorno
	 * </ul>
	 * @param codiceFiscale [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @param codiceFunzione [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @return it.csi.iscritto.serviscritto.dto.profilazione.Attivita[]
	 * @throws ProfilazioneException
	 * @throws CSIException (eccezione base rilanciata dall'infrastruttura di cooperazione)
	 * @throws SystemException in caso di errore di sistema (connessione, comunicazione, ecc.)
	 * @throws UnrecoverableException in caso di errore imprevisto e non recuperabile
	 * @generated
	 */
	////{PROTECTED REGION END////}
	public it.csi.iscritto.serviscritto.dto.profilazione.Attivita[] getAttivitaAbilitateOperatore( //NOSONAR  Reason:EIAS

			java.lang.String codiceFiscale, //NOSONAR  Reason:EIAS

			java.lang.String codiceProfilo, //NOSONAR  Reason:EIAS

			java.lang.String codiceFunzione //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.profilazione.ProfilazioneException; //NOSONAR  Reason:EIAS

	////{PROTECTED REGION ID(R-1600345405) ENABLED START////}
	/**
	 * Inserire qui la documentazione del metodo getPrivilegiOperatore.
	 * Descrivere dettagliatamente:
	 * <ul>
	 * <li>la semantica del metodo (facendo riferimento ai parametri). E' importante 
	 *     elencare casi particolari (dati non trovati, ecc...)
	 * <li> i singoli parametri (nelle sezioni apposite sottostanti): &egrave; importante
	 *      indicare:
	 *      <ul>
	 *      <li>se il parametro &egrave; obbligatorio
	 *      <li>se ci sono dei vincoli sulla valorizzazione (es. range numerico,
	 *          dimensioni massime in caso di stringa o tipo array, eventuale necessit&agrave;
	 *          di corrispondenza con una particolare codifica, che pu&ograve; essere prefissata
	 *          (es. da un elenco predefinito) oppure dinamica (presente su un archivio
	 *          di un'applicazione)
	 *      </ul>
	 * <li> le eccezioni rilanciate (nelle sezioni apposite sottostanti)
	 * <li> il tipo di ritorno
	 * </ul>
	 * @param codiceFiscale [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @return it.csi.iscritto.serviscritto.dto.profilazione.PrivilegioOperatore[]
	 * @throws ProfilazioneException
	 * @throws CSIException (eccezione base rilanciata dall'infrastruttura di cooperazione)
	 * @throws SystemException in caso di errore di sistema (connessione, comunicazione, ecc.)
	 * @throws UnrecoverableException in caso di errore imprevisto e non recuperabile
	 * @generated
	 */
	////{PROTECTED REGION END////}
	public it.csi.iscritto.serviscritto.dto.profilazione.PrivilegioOperatore[] getPrivilegiOperatore( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.profilazione.CallerInfoProfilazione callerInfo, //NOSONAR  Reason:EIAS

			java.lang.String codiceFiscale, //NOSONAR  Reason:EIAS

			java.lang.String codiceProfilo //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.profilazione.ProfilazioneException; //NOSONAR  Reason:EIAS

	////{PROTECTED REGION ID(R-800233549) ENABLED START////}
	/**
	 * Inserire qui la documentazione del metodo getOperatoreByCodiceFiscale.
	 * Descrivere dettagliatamente:
	 * <ul>
	 * <li>la semantica del metodo (facendo riferimento ai parametri). E' importante 
	 *     elencare casi particolari (dati non trovati, ecc...)
	 * <li> i singoli parametri (nelle sezioni apposite sottostanti): &egrave; importante
	 *      indicare:
	 *      <ul>
	 *      <li>se il parametro &egrave; obbligatorio
	 *      <li>se ci sono dei vincoli sulla valorizzazione (es. range numerico,
	 *          dimensioni massime in caso di stringa o tipo array, eventuale necessit&agrave;
	 *          di corrispondenza con una particolare codifica, che pu&ograve; essere prefissata
	 *          (es. da un elenco predefinito) oppure dinamica (presente su un archivio
	 *          di un'applicazione)
	 *      </ul>
	 * <li> le eccezioni rilanciate (nelle sezioni apposite sottostanti)
	 * <li> il tipo di ritorno
	 * </ul>
	 * @param callerInfo [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @param codiceFiscale [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @return it.csi.iscritto.serviscritto.dto.profilazione.Operatore
	 * @throws ProfilazioneException
	 * @throws CSIException (eccezione base rilanciata dall'infrastruttura di cooperazione)
	 * @throws SystemException in caso di errore di sistema (connessione, comunicazione, ecc.)
	 * @throws UnrecoverableException in caso di errore imprevisto e non recuperabile
	 * @generated
	 */
	////{PROTECTED REGION END////}
	public it.csi.iscritto.serviscritto.dto.profilazione.Operatore getOperatoreByCodiceFiscale( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.profilazione.CallerInfoProfilazione callerInfo, //NOSONAR  Reason:EIAS

			java.lang.String codiceFiscale //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.profilazione.ProfilazioneException; //NOSONAR  Reason:EIAS

	////{PROTECTED REGION ID(R-1189351285) ENABLED START////}
	/**
	 * Inserire qui la documentazione del metodo getProfiliOperatore.
	 * Descrivere dettagliatamente:
	 * <ul>
	 * <li>la semantica del metodo (facendo riferimento ai parametri). E' importante 
	 *     elencare casi particolari (dati non trovati, ecc...)
	 * <li> i singoli parametri (nelle sezioni apposite sottostanti): &egrave; importante
	 *      indicare:
	 *      <ul>
	 *      <li>se il parametro &egrave; obbligatorio
	 *      <li>se ci sono dei vincoli sulla valorizzazione (es. range numerico,
	 *          dimensioni massime in caso di stringa o tipo array, eventuale necessit&agrave;
	 *          di corrispondenza con una particolare codifica, che pu&ograve; essere prefissata
	 *          (es. da un elenco predefinito) oppure dinamica (presente su un archivio
	 *          di un'applicazione)
	 *      </ul>
	 * <li> le eccezioni rilanciate (nelle sezioni apposite sottostanti)
	 * <li> il tipo di ritorno
	 * </ul>
	 * @param codiceFiscale [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @return it.csi.iscritto.serviscritto.dto.profilazione.Profilo[]
	 * @throws ProfilazioneException
	 * @throws CSIException (eccezione base rilanciata dall'infrastruttura di cooperazione)
	 * @throws SystemException in caso di errore di sistema (connessione, comunicazione, ecc.)
	 * @throws UnrecoverableException in caso di errore imprevisto e non recuperabile
	 * @generated
	 */
	////{PROTECTED REGION END////}
	public it.csi.iscritto.serviscritto.dto.profilazione.Profilo[] getProfiliOperatore( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.profilazione.CallerInfoProfilazione callerInfo, //NOSONAR  Reason:EIAS

			java.lang.String codiceFiscale //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.profilazione.ProfilazioneException; //NOSONAR  Reason:EIAS

	////{PROTECTED REGION ID(R1958933813) ENABLED START////}
	/**
	 * Inserire qui la documentazione del metodo getCondizioniPunteggioNidi.
	 * Descrivere dettagliatamente:
	 * <ul>
	 * <li>la semantica del metodo (facendo riferimento ai parametri). E' importante 
	 *     elencare casi particolari (dati non trovati, ecc...)
	 * <li> i singoli parametri (nelle sezioni apposite sottostanti): &egrave; importante
	 *      indicare:
	 *      <ul>
	 *      <li>se il parametro &egrave; obbligatorio
	 *      <li>se ci sono dei vincoli sulla valorizzazione (es. range numerico,
	 *          dimensioni massime in caso di stringa o tipo array, eventuale necessit&agrave;
	 *          di corrispondenza con una particolare codifica, che pu&ograve; essere prefissata
	 *          (es. da un elenco predefinito) oppure dinamica (presente su un archivio
	 *          di un'applicazione)
	 *      </ul>
	 * <li> le eccezioni rilanciate (nelle sezioni apposite sottostanti)
	 * <li> il tipo di ritorno
	 * </ul>
	 * @param callerInfo [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @param codiceFiscale [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @param tipoIstruttoria [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @return it.csi.iscritto.serviscritto.dto.profilazione.CondizionePunteggio[]
	 * @throws ProfilazioneException
	 * @throws CSIException (eccezione base rilanciata dall'infrastruttura di cooperazione)
	 * @throws SystemException in caso di errore di sistema (connessione, comunicazione, ecc.)
	 * @throws UnrecoverableException in caso di errore imprevisto e non recuperabile
	 * @generated
	 */
	////{PROTECTED REGION END////}
	public it.csi.iscritto.serviscritto.dto.profilazione.CondizionePunteggio[] getCondizioniPunteggioNidi( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.profilazione.CallerInfoProfilazione callerInfo, //NOSONAR  Reason:EIAS

			java.lang.String codiceFiscale, //NOSONAR  Reason:EIAS

			java.lang.String codiceProfilo, //NOSONAR  Reason:EIAS

			java.lang.String tipoIstruttoria //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.profilazione.ProfilazioneException; //NOSONAR  Reason:EIAS

	////{PROTECTED REGION ID(R1774805679) ENABLED START////}
	/**
	 * Inserire qui la documentazione del metodo getCondizioniPunteggioMaterne.
	 * Descrivere dettagliatamente:
	 * <ul>
	 * <li>la semantica del metodo (facendo riferimento ai parametri). E' importante 
	 *     elencare casi particolari (dati non trovati, ecc...)
	 * <li> i singoli parametri (nelle sezioni apposite sottostanti): &egrave; importante
	 *      indicare:
	 *      <ul>
	 *      <li>se il parametro &egrave; obbligatorio
	 *      <li>se ci sono dei vincoli sulla valorizzazione (es. range numerico,
	 *          dimensioni massime in caso di stringa o tipo array, eventuale necessit&agrave;
	 *          di corrispondenza con una particolare codifica, che pu&ograve; essere prefissata
	 *          (es. da un elenco predefinito) oppure dinamica (presente su un archivio
	 *          di un'applicazione)
	 *      </ul>
	 * <li> le eccezioni rilanciate (nelle sezioni apposite sottostanti)
	 * <li> il tipo di ritorno
	 * </ul>
	 * @param callerInfo [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @param codiceFiscale [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @param tipoIstruttoria [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @return it.csi.iscritto.serviscritto.dto.profilazione.CondizionePunteggio[]
	 * @throws ProfilazioneException
	 * @throws CSIException (eccezione base rilanciata dall'infrastruttura di cooperazione)
	 * @throws SystemException in caso di errore di sistema (connessione, comunicazione, ecc.)
	 * @throws UnrecoverableException in caso di errore imprevisto e non recuperabile
	 * @generated
	 */
	////{PROTECTED REGION END////}
	public it.csi.iscritto.serviscritto.dto.profilazione.CondizionePunteggio[] getCondizioniPunteggioMaterne( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.profilazione.CallerInfoProfilazione callerInfo, //NOSONAR  Reason:EIAS

			java.lang.String codiceFiscale, //NOSONAR  Reason:EIAS

			java.lang.String codiceProfilo, //NOSONAR  Reason:EIAS

			java.lang.String tipoIstruttoria //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.profilazione.ProfilazioneException; //NOSONAR  Reason:EIAS

	////{PROTECTED REGION ID(R-416118465) ENABLED START////}
	/**
	 * Inserire qui la documentazione del metodo getAutorizzatoNidi.
	 * Descrivere dettagliatamente:
	 * <ul>
	 * <li>la semantica del metodo (facendo riferimento ai parametri). E' importante 
	 *     elencare casi particolari (dati non trovati, ecc...)
	 * <li> i singoli parametri (nelle sezioni apposite sottostanti): &egrave; importante
	 *      indicare:
	 *      <ul>
	 *      <li>se il parametro &egrave; obbligatorio
	 *      <li>se ci sono dei vincoli sulla valorizzazione (es. range numerico,
	 *          dimensioni massime in caso di stringa o tipo array, eventuale necessit&agrave;
	 *          di corrispondenza con una particolare codifica, che pu&ograve; essere prefissata
	 *          (es. da un elenco predefinito) oppure dinamica (presente su un archivio
	 *          di un'applicazione)
	 *      </ul>
	 * <li> le eccezioni rilanciate (nelle sezioni apposite sottostanti)
	 * <li> il tipo di ritorno
	 * </ul>
	 * @param callerInfo [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @param codiceFiscale [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @return boolean
	 * @throws ProfilazioneException
	 * @throws CSIException (eccezione base rilanciata dall'infrastruttura di cooperazione)
	 * @throws SystemException in caso di errore di sistema (connessione, comunicazione, ecc.)
	 * @throws UnrecoverableException in caso di errore imprevisto e non recuperabile
	 * @generated
	 */
	////{PROTECTED REGION END////}
	public boolean getAutorizzatoNidi( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.profilazione.CallerInfoProfilazione callerInfo, //NOSONAR  Reason:EIAS

			java.lang.String codiceFiscale //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.profilazione.ProfilazioneException; //NOSONAR  Reason:EIAS

	////{PROTECTED REGION ID(R1883626085) ENABLED START////}
	/**
	 * Inserire qui la documentazione del metodo getAutorizzatoMaterne.
	 * Descrivere dettagliatamente:
	 * <ul>
	 * <li>la semantica del metodo (facendo riferimento ai parametri). E' importante 
	 *     elencare casi particolari (dati non trovati, ecc...)
	 * <li> i singoli parametri (nelle sezioni apposite sottostanti): &egrave; importante
	 *      indicare:
	 *      <ul>
	 *      <li>se il parametro &egrave; obbligatorio
	 *      <li>se ci sono dei vincoli sulla valorizzazione (es. range numerico,
	 *          dimensioni massime in caso di stringa o tipo array, eventuale necessit&agrave;
	 *          di corrispondenza con una particolare codifica, che pu&ograve; essere prefissata
	 *          (es. da un elenco predefinito) oppure dinamica (presente su un archivio
	 *          di un'applicazione)
	 *      </ul>
	 * <li> le eccezioni rilanciate (nelle sezioni apposite sottostanti)
	 * <li> il tipo di ritorno
	 * </ul>
	 * @param callerInfo [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @param codiceFiscale [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @return boolean
	 * @throws ProfilazioneException
	 * @throws CSIException (eccezione base rilanciata dall'infrastruttura di cooperazione)
	 * @throws SystemException in caso di errore di sistema (connessione, comunicazione, ecc.)
	 * @throws UnrecoverableException in caso di errore imprevisto e non recuperabile
	 * @generated
	 */
	////{PROTECTED REGION END////}
	public boolean getAutorizzatoMaterne( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.profilazione.CallerInfoProfilazione callerInfo, //NOSONAR  Reason:EIAS

			java.lang.String codiceFiscale //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.profilazione.ProfilazioneException; //NOSONAR  Reason:EIAS

}
