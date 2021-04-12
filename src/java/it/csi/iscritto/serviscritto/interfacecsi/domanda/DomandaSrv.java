
package it.csi.iscritto.serviscritto.interfacecsi.domanda;

import it.csi.iscritto.serviscritto.dto.domanda.*;

import it.csi.iscritto.serviscritto.exception.domanda.*;

////{PROTECTED REGION ID(R-775554497) ENABLED START////}
/**
 * Inserire qui la documentazione dell'interfaccia pubblica del servizio domanda.
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
public interface DomandaSrv {

	////{PROTECTED REGION ID(R2068779965) ENABLED START////}
	/**
	 * Inserire qui la documentazione del metodo getElencoDomandeNidi.
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
	
	 * @param codiceFiscaleOperatore [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @param criterioRicerca [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @return java.lang.Long[]
	 * @throws DomandaUserException
	 * @throws InvalidFilterException
	 * @throws CSIException (eccezione base rilanciata dall'infrastruttura di cooperazione)
	 * @throws SystemException in caso di errore di sistema (connessione, comunicazione, ecc.)
	 * @throws UnrecoverableException in caso di errore imprevisto e non recuperabile
	 * @generated
	 */
	////{PROTECTED REGION END////}
	public java.lang.Long[] getElencoDomandeNidi( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.String codiceFiscaleOperatore, //NOSONAR  Reason:EIAS

			java.lang.String codiceProfilo, //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CriterioRicerca criterioRicerca //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException

			, it.csi.iscritto.serviscritto.exception.domanda.InvalidFilterException; //NOSONAR  Reason:EIAS

	////{PROTECTED REGION ID(R1436440359) ENABLED START////}
	/**
	 * Inserire qui la documentazione del metodo getElencoDomandeMaterne.
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
	
	 * @param codiceFiscaleOperatore [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @param criterioRicerca [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @return java.lang.Long[]
	 * @throws DomandaUserException
	 * @throws InvalidFilterException
	 * @throws CSIException (eccezione base rilanciata dall'infrastruttura di cooperazione)
	 * @throws SystemException in caso di errore di sistema (connessione, comunicazione, ecc.)
	 * @throws UnrecoverableException in caso di errore imprevisto e non recuperabile
	 * @generated
	 */
	////{PROTECTED REGION END////}
	public java.lang.Long[] getElencoDomandeMaterne( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.String codiceFiscaleOperatore, //NOSONAR  Reason:EIAS

			java.lang.String codiceProfilo, //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CriterioRicerca criterioRicerca //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException

			, it.csi.iscritto.serviscritto.exception.domanda.InvalidFilterException; //NOSONAR  Reason:EIAS

	////{PROTECTED REGION ID(R1622312423) ENABLED START////}
	/**
	 * Inserire qui la documentazione del metodo getTestataDomanda.
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
	 * @param idDomanda [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @return it.csi.iscritto.serviscritto.dto.domanda.TestataDomanda[]
	 * @throws DomandaUserException
	 * @throws CSIException (eccezione base rilanciata dall'infrastruttura di cooperazione)
	 * @throws SystemException in caso di errore di sistema (connessione, comunicazione, ecc.)
	 * @throws UnrecoverableException in caso di errore imprevisto e non recuperabile
	 * @generated
	 */
	////{PROTECTED REGION END////}
	public it.csi.iscritto.serviscritto.dto.domanda.TestataDomanda getTestataDomanda( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.Long idDomanda, //NOSONAR  Reason:EIAS

			java.lang.String tipoTestata //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException; //NOSONAR  Reason:EIAS

	////{PROTECTED REGION ID(R1185614474) ENABLED START////}
	/**
	 * Inserire qui la documentazione del metodo getElencoStatiDomanda.
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
	 * @return it.csi.iscritto.serviscritto.dto.domanda.Codifica[]
	 * @throws CSIException (eccezione base rilanciata dall'infrastruttura di cooperazione)
	 * @throws SystemException in caso di errore di sistema (connessione, comunicazione, ecc.)
	 * @throws UnrecoverableException in caso di errore imprevisto e non recuperabile
	 * @generated
	 */
	////{PROTECTED REGION END////}
	public it.csi.iscritto.serviscritto.dto.domanda.Codifica[] getElencoStatiDomanda( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS
	; //NOSONAR  Reason:EIAS

	////{PROTECTED REGION ID(R256840219) ENABLED START////}
	/**
	 * Inserire qui la documentazione del metodo getDomandaNido.
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
	 * @param idDomanda [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @return it.csi.iscritto.serviscritto.dto.domanda.DomandaNido
	 * @throws DomandaUserException
	 * @throws CSIException (eccezione base rilanciata dall'infrastruttura di cooperazione)
	 * @throws SystemException in caso di errore di sistema (connessione, comunicazione, ecc.)
	 * @throws UnrecoverableException in caso di errore imprevisto e non recuperabile
	 * @generated
	 */
	////{PROTECTED REGION END////}
	public it.csi.iscritto.serviscritto.dto.domanda.DomandaNido getDomandaNido( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.Long idDomanda //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException; //NOSONAR  Reason:EIAS

	////{PROTECTED REGION ID(R1088264651) ENABLED START////}
	/**
	 * Inserire qui la documentazione del metodo getDomandaMaterna.
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
	
	 * @param idDomanda [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @return it.csi.iscritto.serviscritto.dto.domanda.DomandaMaterna
	 * @throws DomandaUserException
	 * @throws CSIException (eccezione base rilanciata dall'infrastruttura di cooperazione)
	 * @throws SystemException in caso di errore di sistema (connessione, comunicazione, ecc.)
	 * @throws UnrecoverableException in caso di errore imprevisto e non recuperabile
	 * @generated
	 */
	////{PROTECTED REGION END////}
	public it.csi.iscritto.serviscritto.dto.domanda.DomandaMaterna getDomandaMaterna( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.Long idDomanda //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException; //NOSONAR  Reason:EIAS

	////{PROTECTED REGION ID(R-1208926598) ENABLED START////}
	/**
	 * Inserire qui la documentazione del metodo insertDomandaNido.
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
	 * @param domandaNido [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @return java.lang.Long
	 * @throws DomandaUserException
	 * @throws CSIException (eccezione base rilanciata dall'infrastruttura di cooperazione)
	 * @throws SystemException in caso di errore di sistema (connessione, comunicazione, ecc.)
	 * @throws UnrecoverableException in caso di errore imprevisto e non recuperabile
	 * @generated
	 */
	////{PROTECTED REGION END////}
	public it.csi.iscritto.serviscritto.dto.domanda.DomandaNido insertDomandaNido( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.DomandaNido domandaNido //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException

			, it.csi.iscritto.serviscritto.exception.domanda.ValidationException; //NOSONAR  Reason:EIAS

	////{PROTECTED REGION ID(R1361517836) ENABLED START////}
	/**
	 * Inserire qui la documentazione del metodo insertDomandaMaterna.
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
	
	 * @param domandaMaterna [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @return it.csi.iscritto.serviscritto.dto.domanda.DomandaMaterna
	 * @throws DomandaUserException
	 * @throws ValidationException
	 * @throws CSIException (eccezione base rilanciata dall'infrastruttura di cooperazione)
	 * @throws SystemException in caso di errore di sistema (connessione, comunicazione, ecc.)
	 * @throws UnrecoverableException in caso di errore imprevisto e non recuperabile
	 * @generated
	 */
	////{PROTECTED REGION END////}
	public it.csi.iscritto.serviscritto.dto.domanda.DomandaMaterna insertDomandaMaterna( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.DomandaMaterna domandaMaterna //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException

			, it.csi.iscritto.serviscritto.exception.domanda.ValidationException; //NOSONAR  Reason:EIAS

	////{PROTECTED REGION ID(R309499241) ENABLED START////}
	/**
	 * Inserire qui la documentazione del metodo checkDomandaNido.
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
	
	 * @param domandaNido [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @return void
	 * @throws DomandaUserException
	 * @throws ValidationException
	 * @throws CSIException (eccezione base rilanciata dall'infrastruttura di cooperazione)
	 * @throws SystemException in caso di errore di sistema (connessione, comunicazione, ecc.)
	 * @throws UnrecoverableException in caso di errore imprevisto e non recuperabile
	 * @generated
	 */
	////{PROTECTED REGION END////}
	public void checkDomandaNido( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.String codiceFiscaleRic, //NOSONAR  Reason:EIAS

			java.lang.String codiceFiscaleMin //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException

			, it.csi.iscritto.serviscritto.exception.domanda.ValidationException; //NOSONAR  Reason:EIAS

	////{PROTECTED REGION ID(R-2104841283) ENABLED START////}
	/**
	 * Inserire qui la documentazione del metodo checkDomandaMaterna.
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
	
	 * @param codiceFiscaleRic [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @param codiceFiscaleMin [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @return void
	 * @throws DomandaUserException
	 * @throws ValidationException
	 * @throws CSIException (eccezione base rilanciata dall'infrastruttura di cooperazione)
	 * @throws SystemException in caso di errore di sistema (connessione, comunicazione, ecc.)
	 * @throws UnrecoverableException in caso di errore imprevisto e non recuperabile
	 * @generated
	 */
	////{PROTECTED REGION END////}
	public void checkDomandaMaterna( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.String codiceFiscaleRic, //NOSONAR  Reason:EIAS

			java.lang.String codiceFiscaleMin //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException

			, it.csi.iscritto.serviscritto.exception.domanda.ValidationException; //NOSONAR  Reason:EIAS

	////{PROTECTED REGION ID(R-2077809246) ENABLED START////}
	/**
	 * Inserire qui la documentazione del metodo deleteDomanda.
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
	
	 * @param idDomanda [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @param cfOperatore [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @return void
	 * @throws DomandaUserException
	 * @throws ValidationException
	 * @throws CSIException (eccezione base rilanciata dall'infrastruttura di cooperazione)
	 * @throws SystemException in caso di errore di sistema (connessione, comunicazione, ecc.)
	 * @throws UnrecoverableException in caso di errore imprevisto e non recuperabile
	 * @generated
	 */
	////{PROTECTED REGION END////}
	public void deleteDomanda( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.Long idDomanda, //NOSONAR  Reason:EIAS

			java.lang.String cfOperatore //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException

			, it.csi.iscritto.serviscritto.exception.domanda.ValidationException; //NOSONAR  Reason:EIAS

	////{PROTECTED REGION ID(R413772688) ENABLED START////}
	/**
	 * Inserire qui la documentazione del metodo getAllegato.
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
	
	 * @param idAllegato [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @return it.csi.iscritto.serviscritto.dto.domanda.Allegato
	 * @throws DomandaUserException
	 * @throws CSIException (eccezione base rilanciata dall'infrastruttura di cooperazione)
	 * @throws SystemException in caso di errore di sistema (connessione, comunicazione, ecc.)
	 * @throws UnrecoverableException in caso di errore imprevisto e non recuperabile
	 * @generated
	 */
	////{PROTECTED REGION END////}
	public it.csi.iscritto.serviscritto.dto.domanda.Allegato getAllegato( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.String cfRichiedente, //NOSONAR  Reason:EIAS

			java.lang.Long idDomanda, //NOSONAR  Reason:EIAS

			java.lang.Long idAllegato, //NOSONAR  Reason:EIAS

			boolean withContent //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException; //NOSONAR  Reason:EIAS

	////{PROTECTED REGION ID(R686269571) ENABLED START////}
	/**
	 * Inserire qui la documentazione del metodo deleteAllegato.
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
	
	 * @param idAllegato [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @return java.lang.Integer
	 * @throws DomandaUserException
	 * @throws CSIException (eccezione base rilanciata dall'infrastruttura di cooperazione)
	 * @throws SystemException in caso di errore di sistema (connessione, comunicazione, ecc.)
	 * @throws UnrecoverableException in caso di errore imprevisto e non recuperabile
	 * @generated
	 */
	////{PROTECTED REGION END////}
	public java.lang.Integer deleteAllegato( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.String cfRichiedente, //NOSONAR  Reason:EIAS

			java.lang.String cfOperatore, //NOSONAR  Reason:EIAS

			java.lang.Long idDomanda, //NOSONAR  Reason:EIAS

			java.lang.Long idAllegato //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException; //NOSONAR  Reason:EIAS

	////{PROTECTED REGION ID(R2039539663) ENABLED START////}
	/**
	 * Inserire qui la documentazione del metodo insertAllegatoList.
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
	
	 * @param allegatoList [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @return java.lang.Long[]
	 * @throws DomandaUserException
	 * @throws CSIException (eccezione base rilanciata dall'infrastruttura di cooperazione)
	 * @throws SystemException in caso di errore di sistema (connessione, comunicazione, ecc.)
	 * @throws UnrecoverableException in caso di errore imprevisto e non recuperabile
	 * @generated
	 */
	////{PROTECTED REGION END////}
	public java.lang.Long[] insertAllegatoList( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.String cfRichiedente, //NOSONAR  Reason:EIAS

			java.lang.String cfOperatore, //NOSONAR  Reason:EIAS

			java.lang.Long idDomanda, //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.Allegato[] allegatoList //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException; //NOSONAR  Reason:EIAS

	////{PROTECTED REGION ID(R747988538) ENABLED START////}
	/**
	 * Inserire qui la documentazione del metodo invioDomandaNido.
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
	
	 * @param domandaNido [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @return java.lang.Long
	 * @throws DomandaUserException
	 * @throws ValidationException
	 * @throws CSIException (eccezione base rilanciata dall'infrastruttura di cooperazione)
	 * @throws SystemException in caso di errore di sistema (connessione, comunicazione, ecc.)
	 * @throws UnrecoverableException in caso di errore imprevisto e non recuperabile
	 * @generated
	 */
	////{PROTECTED REGION END////}
	public java.lang.String invioDomandaNido( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.Long idDomanda //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException

			, it.csi.iscritto.serviscritto.exception.domanda.ValidationException; //NOSONAR  Reason:EIAS

	////{PROTECTED REGION ID(R-65741492) ENABLED START////}
	/**
	 * Inserire qui la documentazione del metodo invioDomandaMaterna.
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
	
	 * @param idDomanda [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @return java.lang.String
	 * @throws DomandaUserException
	 * @throws ValidationException
	 * @throws CSIException (eccezione base rilanciata dall'infrastruttura di cooperazione)
	 * @throws SystemException in caso di errore di sistema (connessione, comunicazione, ecc.)
	 * @throws UnrecoverableException in caso di errore imprevisto e non recuperabile
	 * @generated
	 */
	////{PROTECTED REGION END////}
	public java.lang.String invioDomandaMaterna( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.Long idDomanda //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException

			, it.csi.iscritto.serviscritto.exception.domanda.ValidationException; //NOSONAR  Reason:EIAS

	////{PROTECTED REGION ID(R-1136877393) ENABLED START////}
	/**
	 * Inserire qui la documentazione del metodo getDomandeIstruttoriaNidi.
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
	
	 * @param criterioRicerca [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @return it.csi.iscritto.serviscritto.dto.domanda.TestataDomandaIstruttoria[]
	 * @throws DomandaUserException
	 * @throws InvalidFilterException
	 * @throws CSIException (eccezione base rilanciata dall'infrastruttura di cooperazione)
	 * @throws SystemException in caso di errore di sistema (connessione, comunicazione, ecc.)
	 * @throws UnrecoverableException in caso di errore imprevisto e non recuperabile
	 * @generated
	 */
	////{PROTECTED REGION END////}
	public it.csi.iscritto.serviscritto.dto.domanda.TestataDomandaIstruttoria[] getDomandeIstruttoriaNidi( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CriterioRicercaIstruttoria criterioRicerca, //NOSONAR  Reason:EIAS

			java.lang.String cfOperatore, //NOSONAR  Reason:EIAS

			java.lang.String codProfilo //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException

			, it.csi.iscritto.serviscritto.exception.domanda.InvalidFilterException; //NOSONAR  Reason:EIAS

	////{PROTECTED REGION ID(R295914741) ENABLED START////}
	/**
	 * Inserire qui la documentazione del metodo getDomandeIstruttoriaMaterne.
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
	
	 * @param criterioRicerca [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @return it.csi.iscritto.serviscritto.dto.domanda.TestataDomandaIstruttoria[]
	 * @throws DomandaUserException
	 * @throws InvalidFilterException
	 * @throws CSIException (eccezione base rilanciata dall'infrastruttura di cooperazione)
	 * @throws SystemException in caso di errore di sistema (connessione, comunicazione, ecc.)
	 * @throws UnrecoverableException in caso di errore imprevisto e non recuperabile
	 * @generated
	 */
	////{PROTECTED REGION END////}
	public it.csi.iscritto.serviscritto.dto.domanda.TestataDomandaIstruttoria[] getDomandeIstruttoriaMaterne( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CriterioRicercaIstruttoria criterioRicerca, //NOSONAR  Reason:EIAS

			java.lang.String cfOperatore, //NOSONAR  Reason:EIAS

			java.lang.String codProfilo //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException

			, it.csi.iscritto.serviscritto.exception.domanda.InvalidFilterException; //NOSONAR  Reason:EIAS

	////{PROTECTED REGION ID(R748625577) ENABLED START////}
	/**
	 * Inserire qui la documentazione del metodo insertLogErroreDomandaNido.
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
	
	 * @param codiceFiscaleOperatore [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @param dettaglioErrore [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @param domandaNido [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @return void
	 * @throws DomandaUserException
	 * @throws CSIException (eccezione base rilanciata dall'infrastruttura di cooperazione)
	 * @throws SystemException in caso di errore di sistema (connessione, comunicazione, ecc.)
	 * @throws UnrecoverableException in caso di errore imprevisto e non recuperabile
	 * @generated
	 */
	////{PROTECTED REGION END////}
	public void insertLogErroreDomandaNido( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.String codiceFiscaleOperatore, //NOSONAR  Reason:EIAS

			java.lang.String dettaglioErrore, //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.DomandaNido domandaNido //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException; //NOSONAR  Reason:EIAS

	////{PROTECTED REGION ID(R1732418173) ENABLED START////}
	/**
	 * Inserire qui la documentazione del metodo insertLogErroreDomandaMaterna.
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
	
	 * @param codiceFiscaleOperatore [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @param dettaglioErrore [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @param domandaMaterna [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @return void
	 * @throws DomandaUserException
	 * @throws CSIException (eccezione base rilanciata dall'infrastruttura di cooperazione)
	 * @throws SystemException in caso di errore di sistema (connessione, comunicazione, ecc.)
	 * @throws UnrecoverableException in caso di errore imprevisto e non recuperabile
	 * @generated
	 */
	////{PROTECTED REGION END////}
	public void insertLogErroreDomandaMaterna( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.String codiceFiscaleOperatore, //NOSONAR  Reason:EIAS

			java.lang.String dettaglioErrore, //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.DomandaMaterna domandaMaterna //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException; //NOSONAR  Reason:EIAS

	////{PROTECTED REGION ID(R-633765912) ENABLED START////}
	/**
	 * Inserire qui la documentazione del metodo checkIdDomanda.
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
	
	 * @param codiceFiscaleRic [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @param idDomanda [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @return void
	 * @throws DomandaUserException
	 * @throws ValidationException
	 * @throws CSIException (eccezione base rilanciata dall'infrastruttura di cooperazione)
	 * @throws SystemException in caso di errore di sistema (connessione, comunicazione, ecc.)
	 * @throws UnrecoverableException in caso di errore imprevisto e non recuperabile
	 * @generated
	 */
	////{PROTECTED REGION END////}
	public void checkIdDomanda( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.String codiceFiscaleRic, //NOSONAR  Reason:EIAS

			java.lang.Long idDomanda //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException

			, it.csi.iscritto.serviscritto.exception.domanda.ValidationException; //NOSONAR  Reason:EIAS

	////{PROTECTED REGION ID(R426257845) ENABLED START////}
	/**
	 * Inserire qui la documentazione del metodo checkRichiedenteDomandaNido.
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
	
	 * @param codiceFiscaleRic [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @param domandaNido [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @return void
	 * @throws DomandaUserException
	 * @throws ValidationException
	 * @throws CSIException (eccezione base rilanciata dall'infrastruttura di cooperazione)
	 * @throws SystemException in caso di errore di sistema (connessione, comunicazione, ecc.)
	 * @throws UnrecoverableException in caso di errore imprevisto e non recuperabile
	 * @generated
	 */
	////{PROTECTED REGION END////}
	public void checkRichiedenteDomandaNido( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.String codiceFiscaleRic, //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.DomandaNido domandaNido //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException

			, it.csi.iscritto.serviscritto.exception.domanda.ValidationException; //NOSONAR  Reason:EIAS

	////{PROTECTED REGION ID(R1622188017) ENABLED START////}
	/**
	 * Inserire qui la documentazione del metodo checkRichiedenteDomandaMaterna.
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
	
	 * @param codiceFiscaleRic [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @param domandaMaterna [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @return void
	 * @throws DomandaUserException
	 * @throws ValidationException
	 * @throws CSIException (eccezione base rilanciata dall'infrastruttura di cooperazione)
	 * @throws SystemException in caso di errore di sistema (connessione, comunicazione, ecc.)
	 * @throws UnrecoverableException in caso di errore imprevisto e non recuperabile
	 * @generated
	 */
	////{PROTECTED REGION END////}
	public void checkRichiedenteDomandaMaterna( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.String codiceFiscaleRic, //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.DomandaMaterna domandaMaterna //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException

			, it.csi.iscritto.serviscritto.exception.domanda.ValidationException; //NOSONAR  Reason:EIAS

	////{PROTECTED REGION ID(R-1918316238) ENABLED START////}
	/**
	 * Inserire qui la documentazione del metodo getStoricoCondizioniPunteggio.
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
	
	 * @param idDomanda [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @param codCondizionePunteggio [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @return it.csi.iscritto.serviscritto.dto.domanda.StoricoCondizionePunteggio[]
	 * @throws DomandaUserException
	 * @throws CSIException (eccezione base rilanciata dall'infrastruttura di cooperazione)
	 * @throws SystemException in caso di errore di sistema (connessione, comunicazione, ecc.)
	 * @throws UnrecoverableException in caso di errore imprevisto e non recuperabile
	 * @generated
	 */
	////{PROTECTED REGION END////}
	public it.csi.iscritto.serviscritto.dto.domanda.DatiCondizionePunteggio[] getStoricoCondizioniPunteggio( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.Long idDomanda, //NOSONAR  Reason:EIAS

			java.lang.String codCondizionePunteggio //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException; //NOSONAR  Reason:EIAS

	////{PROTECTED REGION ID(R1960257609) ENABLED START////}
	/**
	 * Inserire qui la documentazione del metodo modificaCondizionePunteggioNidi.
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
	
	 * @param idDomanda [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @param codCondizionePunteggio [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @param codiceFiscaleOperatore [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @param count [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @param datiCondizionePunteggio [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @return void
	 * @throws DomandaUserException
	 * @throws CSIException (eccezione base rilanciata dall'infrastruttura di cooperazione)
	 * @throws SystemException in caso di errore di sistema (connessione, comunicazione, ecc.)
	 * @throws UnrecoverableException in caso di errore imprevisto e non recuperabile
	 * @generated
	 */
	////{PROTECTED REGION END////}
	public void modificaCondizionePunteggioNidi( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.Long idDomanda, //NOSONAR  Reason:EIAS

			java.lang.String codCondizionePunteggio, //NOSONAR  Reason:EIAS

			java.lang.String codiceFiscaleOperatore, //NOSONAR  Reason:EIAS

			java.lang.Integer count, //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.DatiCondizionePunteggio datiCondizionePunteggio //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException; //NOSONAR  Reason:EIAS

	////{PROTECTED REGION ID(R-1737660645) ENABLED START////}
	/**
	 * Inserire qui la documentazione del metodo modificaCondizionePunteggioMaterne.
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
	
	 * @param idDomanda [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @param codCondizionePunteggio [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @param codiceFiscaleOperatore [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @param count [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @param datiCondizionePunteggio [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @return void
	 * @throws DomandaUserException
	 * @throws CSIException (eccezione base rilanciata dall'infrastruttura di cooperazione)
	 * @throws SystemException in caso di errore di sistema (connessione, comunicazione, ecc.)
	 * @throws UnrecoverableException in caso di errore imprevisto e non recuperabile
	 * @generated
	 */
	////{PROTECTED REGION END////}
	public void modificaCondizionePunteggioMaterne( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.Long idDomanda, //NOSONAR  Reason:EIAS

			java.lang.String codCondizionePunteggio, //NOSONAR  Reason:EIAS

			java.lang.String codiceFiscaleOperatore, //NOSONAR  Reason:EIAS

			java.lang.Integer count, //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.DatiCondizionePunteggio datiCondizionePunteggio //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException; //NOSONAR  Reason:EIAS

	////{PROTECTED REGION ID(R-1557469260) ENABLED START////}
	/**
	 * Inserire qui la documentazione del metodo getInfoAllegatiDomanda.
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
	
	 * @param idDomanda [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @param codCondizionePunteggio [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @return it.csi.iscritto.serviscritto.dto.domanda.InfoAllegatoSoggetto[]
	 * @throws DomandaUserException
	 * @throws CSIException (eccezione base rilanciata dall'infrastruttura di cooperazione)
	 * @throws SystemException in caso di errore di sistema (connessione, comunicazione, ecc.)
	 * @throws UnrecoverableException in caso di errore imprevisto e non recuperabile
	 * @generated
	 */
	////{PROTECTED REGION END////}
	public it.csi.iscritto.serviscritto.dto.domanda.InfoAllegatoSoggetto[] getInfoAllegatiDomanda( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.Long idDomanda, //NOSONAR  Reason:EIAS

			java.lang.String codCondizionePunteggio //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException; //NOSONAR  Reason:EIAS

	////{PROTECTED REGION ID(R-272585478) ENABLED START////}
	/**
	 * Inserire qui la documentazione del metodo getInfoVerbaliNidi.
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
	
	 * @param tipoCommissione [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @param dataInizio [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @param dataFine [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @return it.csi.iscritto.serviscritto.dto.domanda.VerbaleCommissione[]
	 * @throws DomandaUserException
	 * @throws CSIException (eccezione base rilanciata dall'infrastruttura di cooperazione)
	 * @throws SystemException in caso di errore di sistema (connessione, comunicazione, ecc.)
	 * @throws UnrecoverableException in caso di errore imprevisto e non recuperabile
	 * @generated
	 */
	////{PROTECTED REGION END////}
	public it.csi.iscritto.serviscritto.dto.domanda.VerbaleCommissione[] getInfoVerbaliNidi( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.String codProfilo, //NOSONAR  Reason:EIAS

			java.lang.String tipoCommissione, //NOSONAR  Reason:EIAS

			java.util.Date dataInizio, //NOSONAR  Reason:EIAS

			java.util.Date dataFine //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException; //NOSONAR  Reason:EIAS

	////{PROTECTED REGION ID(R87414986) ENABLED START////}
	/**
	 * Inserire qui la documentazione del metodo getInfoVerbaliMaterne.
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
	
	 * @param tipoCommissione [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @param dataInizio [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @param dataFine [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @return it.csi.iscritto.serviscritto.dto.domanda.VerbaleCommissione[]
	 * @throws DomandaUserException
	 * @throws CSIException (eccezione base rilanciata dall'infrastruttura di cooperazione)
	 * @throws SystemException in caso di errore di sistema (connessione, comunicazione, ecc.)
	 * @throws UnrecoverableException in caso di errore imprevisto e non recuperabile
	 * @generated
	 */
	////{PROTECTED REGION END////}
	public it.csi.iscritto.serviscritto.dto.domanda.VerbaleCommissione[] getInfoVerbaliMaterne( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.String codProfilo, //NOSONAR  Reason:EIAS

			java.lang.String tipoCommissione, //NOSONAR  Reason:EIAS

			java.util.Date dataInizio, //NOSONAR  Reason:EIAS

			java.util.Date dataFine //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException; //NOSONAR  Reason:EIAS

	////{PROTECTED REGION ID(R657590854) ENABLED START////}
	/**
	 * Inserire qui la documentazione del metodo getInfoGeneraliNidi.
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
	
	 * @return it.csi.iscritto.serviscritto.dto.domanda.InfoGenerali
	 * @throws DomandaUserException
	 * @throws CSIException (eccezione base rilanciata dall'infrastruttura di cooperazione)
	 * @throws SystemException in caso di errore di sistema (connessione, comunicazione, ecc.)
	 * @throws UnrecoverableException in caso di errore imprevisto e non recuperabile
	 * @generated
	 */
	////{PROTECTED REGION END////}
	public it.csi.iscritto.serviscritto.dto.domanda.InfoGenerali getInfoGeneraliNidi( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException; //NOSONAR  Reason:EIAS

	////{PROTECTED REGION ID(R-158472194) ENABLED START////}
	/**
	 * Inserire qui la documentazione del metodo getInfoGeneraliMaterne.
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
	
	 * @return it.csi.iscritto.serviscritto.dto.domanda.InfoGenerali
	 * @throws DomandaUserException
	 * @throws CSIException (eccezione base rilanciata dall'infrastruttura di cooperazione)
	 * @throws SystemException in caso di errore di sistema (connessione, comunicazione, ecc.)
	 * @throws UnrecoverableException in caso di errore imprevisto e non recuperabile
	 * @generated
	 */
	////{PROTECTED REGION END////}
	public it.csi.iscritto.serviscritto.dto.domanda.InfoGenerali getInfoGeneraliMaterne( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException; //NOSONAR  Reason:EIAS

	////{PROTECTED REGION ID(R-537303786) ENABLED START////}
	/**
	 * Inserire qui la documentazione del metodo getDomandeNidoDaVerificare.
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
	
	 * @return it.csi.iscritto.serviscritto.dto.domanda.TestataDomandaDaVerificare[]
	 * @throws DomandaUserException
	 * @throws CSIException (eccezione base rilanciata dall'infrastruttura di cooperazione)
	 * @throws SystemException in caso di errore di sistema (connessione, comunicazione, ecc.)
	 * @throws UnrecoverableException in caso di errore imprevisto e non recuperabile
	 * @generated
	 */
	////{PROTECTED REGION END////}
	public it.csi.iscritto.serviscritto.dto.domanda.TestataDomandaDaVerificare[] getDomandeNidoDaVerificare( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.String codProfilo //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException; //NOSONAR  Reason:EIAS

	////{PROTECTED REGION ID(R-1695955394) ENABLED START////}
	/**
	 * Inserire qui la documentazione del metodo getDomandeMaternaDaVerificare.
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
	
	 * @return it.csi.iscritto.serviscritto.dto.domanda.TestataDomandaDaVerificare[]
	 * @throws DomandaUserException
	 * @throws CSIException (eccezione base rilanciata dall'infrastruttura di cooperazione)
	 * @throws SystemException in caso di errore di sistema (connessione, comunicazione, ecc.)
	 * @throws UnrecoverableException in caso di errore imprevisto e non recuperabile
	 * @generated
	 */
	////{PROTECTED REGION END////}
	public it.csi.iscritto.serviscritto.dto.domanda.TestataDomandaDaVerificare[] getDomandeMaternaDaVerificare( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.String codProfilo //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException; //NOSONAR  Reason:EIAS

	////{PROTECTED REGION ID(R1692614067) ENABLED START////}
	/**
	 * Inserire qui la documentazione del metodo getElencoNidi.
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
	
	 * @param idDomanda [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @return it.csi.iscritto.serviscritto.dto.domanda.Nido[]
	 * @throws DomandaUserException
	 * @throws CSIException (eccezione base rilanciata dall'infrastruttura di cooperazione)
	 * @throws SystemException in caso di errore di sistema (connessione, comunicazione, ecc.)
	 * @throws UnrecoverableException in caso di errore imprevisto e non recuperabile
	 * @generated
	 */
	////{PROTECTED REGION END////}
	public it.csi.iscritto.serviscritto.dto.domanda.Nido[] getElencoNidi( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.Long idDomanda //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException; //NOSONAR  Reason:EIAS

	////{PROTECTED REGION ID(R647848305) ENABLED START////}
	/**
	 * Inserire qui la documentazione del metodo getElencoMaterne.
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
	
	 * @param idDomanda [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @return it.csi.iscritto.serviscritto.dto.domanda.Materna[]
	 * @throws DomandaUserException
	 * @throws CSIException (eccezione base rilanciata dall'infrastruttura di cooperazione)
	 * @throws SystemException in caso di errore di sistema (connessione, comunicazione, ecc.)
	 * @throws UnrecoverableException in caso di errore imprevisto e non recuperabile
	 * @generated
	 */
	////{PROTECTED REGION END////}
	public it.csi.iscritto.serviscritto.dto.domanda.Materna[] getElencoMaterne( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.Long idDomanda //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException; //NOSONAR  Reason:EIAS

	////{PROTECTED REGION ID(R1540517044) ENABLED START////}
	/**
	 * Inserire qui la documentazione del metodo modificaStatoNidi.
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
	
	 * @param idDomanda [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @param elencoNidi [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @return void
	 * @throws DomandaUserException
	 * @throws CSIException (eccezione base rilanciata dall'infrastruttura di cooperazione)
	 * @throws SystemException in caso di errore di sistema (connessione, comunicazione, ecc.)
	 * @throws UnrecoverableException in caso di errore imprevisto e non recuperabile
	 * @generated
	 */
	////{PROTECTED REGION END////}
	public void modificaStatoNidi( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.Long idDomanda, //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.Nido[] elencoNidi //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException; //NOSONAR  Reason:EIAS

	////{PROTECTED REGION ID(R715933392) ENABLED START////}
	/**
	 * Inserire qui la documentazione del metodo modificaStatoMaterne.
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
	
	 * @param idDomanda [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @param elencoMaterne [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @return void
	 * @throws DomandaUserException
	 * @throws CSIException (eccezione base rilanciata dall'infrastruttura di cooperazione)
	 * @throws SystemException in caso di errore di sistema (connessione, comunicazione, ecc.)
	 * @throws UnrecoverableException in caso di errore imprevisto e non recuperabile
	 * @generated
	 */
	////{PROTECTED REGION END////}
	public void modificaStatoMaterne( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.Long idDomanda, //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.Materna[] elencoMaterne //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException; //NOSONAR  Reason:EIAS

	////{PROTECTED REGION ID(R1728736033) ENABLED START////}
	/**
	 * Inserire qui la documentazione del metodo getTestataDomandaAccettazione.
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
	
	 * @param idDomanda [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @param cfRichiedente [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @return it.csi.iscritto.serviscritto.dto.domanda.TestataDomandaAccettazione
	 * @throws DomandaUserException
	 * @throws CSIException (eccezione base rilanciata dall'infrastruttura di cooperazione)
	 * @throws SystemException in caso di errore di sistema (connessione, comunicazione, ecc.)
	 * @throws UnrecoverableException in caso di errore imprevisto e non recuperabile
	 * @generated
	 */
	////{PROTECTED REGION END////}
	public it.csi.iscritto.serviscritto.dto.domanda.TestataDomandaAccettazione getTestataDomandaAccettazione( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.Long idDomanda, //NOSONAR  Reason:EIAS

			java.lang.String cfRichiedente //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException; //NOSONAR  Reason:EIAS

	////{PROTECTED REGION ID(R2037665566) ENABLED START////}
	/**
	 * Inserire qui la documentazione del metodo accettaPreferenzaNidi.
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
	
	 * @param idDomanda [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @param cfRichiedente [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @param codScuola [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @param codTipoFrequenza [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @param cfOperatore [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @param telRichiedente [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @param codTipoPasto [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @return it.csi.iscritto.serviscritto.dto.domanda.TestataDomandaAccettazione
	 * @throws DomandaUserException
	 * @throws CSIException (eccezione base rilanciata dall'infrastruttura di cooperazione)
	 * @throws SystemException in caso di errore di sistema (connessione, comunicazione, ecc.)
	 * @throws UnrecoverableException in caso di errore imprevisto e non recuperabile
	 * @generated
	 */
	////{PROTECTED REGION END////}
	public it.csi.iscritto.serviscritto.dto.domanda.TestataDomandaAccettazione accettaPreferenzaNidi( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.Long idDomanda, //NOSONAR  Reason:EIAS

			java.lang.String cfRichiedente, //NOSONAR  Reason:EIAS

			java.lang.String codScuola, //NOSONAR  Reason:EIAS

			java.lang.String codTipoFrequenza, //NOSONAR  Reason:EIAS

			java.lang.String cfOperatore, //NOSONAR  Reason:EIAS

			java.lang.String telRichiedente, //NOSONAR  Reason:EIAS

			java.lang.String codTipoPasto //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException; //NOSONAR  Reason:EIAS

	////{PROTECTED REGION ID(R-2074651610) ENABLED START////}
	/**
	 * Inserire qui la documentazione del metodo accettaPreferenzaMaterne.
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
	
	 * @param idDomanda [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @param cfRichiedente [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @param codScuola [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @param codTipoFrequenza [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @param cfOperatore [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @param telRichiedente [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @param codTipoPasto [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @return it.csi.iscritto.serviscritto.dto.domanda.TestataDomandaAccettazione
	 * @throws DomandaUserException
	 * @throws CSIException (eccezione base rilanciata dall'infrastruttura di cooperazione)
	 * @throws SystemException in caso di errore di sistema (connessione, comunicazione, ecc.)
	 * @throws UnrecoverableException in caso di errore imprevisto e non recuperabile
	 * @generated
	 */
	////{PROTECTED REGION END////}
	public it.csi.iscritto.serviscritto.dto.domanda.TestataDomandaAccettazione accettaPreferenzaMaterne( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.Long idDomanda, //NOSONAR  Reason:EIAS

			java.lang.String cfRichiedente, //NOSONAR  Reason:EIAS

			java.lang.String codScuola, //NOSONAR  Reason:EIAS

			java.lang.String codTipoFrequenza, //NOSONAR  Reason:EIAS

			java.lang.String cfOperatore, //NOSONAR  Reason:EIAS

			java.lang.String telRichiedente, //NOSONAR  Reason:EIAS

			java.lang.String codTipoPasto //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException; //NOSONAR  Reason:EIAS

	////{PROTECTED REGION ID(R-1990709591) ENABLED START////}
	/**
	 * Inserire qui la documentazione del metodo rifiutaPreferenzaNidi.
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
	
	 * @param idDomanda [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @param cfRichiedente [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @param codScuola [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @param codTipoFrequenza [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @param cfOperatore [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @return it.csi.iscritto.serviscritto.dto.domanda.TestataDomandaAccettazione
	 * @throws DomandaUserException
	 * @throws CSIException (eccezione base rilanciata dall'infrastruttura di cooperazione)
	 * @throws SystemException in caso di errore di sistema (connessione, comunicazione, ecc.)
	 * @throws UnrecoverableException in caso di errore imprevisto e non recuperabile
	 * @generated
	 */
	////{PROTECTED REGION END////}
	public it.csi.iscritto.serviscritto.dto.domanda.TestataDomandaAccettazione rifiutaPreferenzaNidi( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.Long idDomanda, //NOSONAR  Reason:EIAS

			java.lang.String cfRichiedente, //NOSONAR  Reason:EIAS

			java.lang.String codScuola, //NOSONAR  Reason:EIAS

			java.lang.String codTipoFrequenza, //NOSONAR  Reason:EIAS

			java.lang.String cfOperatore //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException; //NOSONAR  Reason:EIAS

	////{PROTECTED REGION ID(R-1422768965) ENABLED START////}
	/**
	 * Inserire qui la documentazione del metodo rifiutaPreferenzaMaterne.
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
	
	 * @param idDomanda [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @param cfRichiedente [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @param codScuola [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @param codTipoFrequenza [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @param cfOperatore [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @return it.csi.iscritto.serviscritto.dto.domanda.TestataDomandaAccettazione
	 * @throws DomandaUserException
	 * @throws CSIException (eccezione base rilanciata dall'infrastruttura di cooperazione)
	 * @throws SystemException in caso di errore di sistema (connessione, comunicazione, ecc.)
	 * @throws UnrecoverableException in caso di errore imprevisto e non recuperabile
	 * @generated
	 */
	////{PROTECTED REGION END////}
	public it.csi.iscritto.serviscritto.dto.domanda.TestataDomandaAccettazione rifiutaPreferenzaMaterne( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.Long idDomanda, //NOSONAR  Reason:EIAS

			java.lang.String cfRichiedente, //NOSONAR  Reason:EIAS

			java.lang.String codScuola, //NOSONAR  Reason:EIAS

			java.lang.String codTipoFrequenza, //NOSONAR  Reason:EIAS

			java.lang.String cfOperatore //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException; //NOSONAR  Reason:EIAS

	////{PROTECTED REGION ID(R-749819431) ENABLED START////}
	/**
	 * Inserire qui la documentazione del metodo getParametriUltimaGraduatoriaNidi.
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
	
	 * @return it.csi.iscritto.serviscritto.dto.domanda.ParametriGraduatoria
	 * @throws DomandaUserException
	 * @throws CSIException (eccezione base rilanciata dall'infrastruttura di cooperazione)
	 * @throws SystemException in caso di errore di sistema (connessione, comunicazione, ecc.)
	 * @throws UnrecoverableException in caso di errore imprevisto e non recuperabile
	 * @generated
	 */
	////{PROTECTED REGION END////}
	public it.csi.iscritto.serviscritto.dto.domanda.ParametriGraduatoria getParametriUltimaGraduatoriaNidi( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException; //NOSONAR  Reason:EIAS

	////{PROTECTED REGION ID(R-847529077) ENABLED START////}
	/**
	 * Inserire qui la documentazione del metodo getParametriUltimaGraduatoriaMaterne.
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
	
	 * @return it.csi.iscritto.serviscritto.dto.domanda.ParametriGraduatoria
	 * @throws DomandaUserException
	 * @throws CSIException (eccezione base rilanciata dall'infrastruttura di cooperazione)
	 * @throws SystemException in caso di errore di sistema (connessione, comunicazione, ecc.)
	 * @throws UnrecoverableException in caso di errore imprevisto e non recuperabile
	 * @generated
	 */
	////{PROTECTED REGION END////}
	public it.csi.iscritto.serviscritto.dto.domanda.ParametriGraduatoria getParametriUltimaGraduatoriaMaterne( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException; //NOSONAR  Reason:EIAS

	////{PROTECTED REGION ID(R470549158) ENABLED START////}
	/**
	 * Inserire qui la documentazione del metodo getElencoGraduatorieNidi.
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
	
	 * @return it.csi.iscritto.serviscritto.dto.domanda.Graduatoria[]
	 * @throws DomandaUserException
	 * @throws CSIException (eccezione base rilanciata dall'infrastruttura di cooperazione)
	 * @throws SystemException in caso di errore di sistema (connessione, comunicazione, ecc.)
	 * @throws UnrecoverableException in caso di errore imprevisto e non recuperabile
	 * @generated
	 */
	////{PROTECTED REGION END////}
	public it.csi.iscritto.serviscritto.dto.domanda.Graduatoria[] getElencoGraduatorieNidi( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException; //NOSONAR  Reason:EIAS

	////{PROTECTED REGION ID(R-1745054818) ENABLED START////}
	/**
	 * Inserire qui la documentazione del metodo getElencoGraduatorieMaterne.
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
	
	 * @return it.csi.iscritto.serviscritto.dto.domanda.Graduatoria[]
	 * @throws DomandaUserException
	 * @throws CSIException (eccezione base rilanciata dall'infrastruttura di cooperazione)
	 * @throws SystemException in caso di errore di sistema (connessione, comunicazione, ecc.)
	 * @throws UnrecoverableException in caso di errore imprevisto e non recuperabile
	 * @generated
	 */
	////{PROTECTED REGION END////}
	public it.csi.iscritto.serviscritto.dto.domanda.Graduatoria[] getElencoGraduatorieMaterne( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException; //NOSONAR  Reason:EIAS

	////{PROTECTED REGION ID(R1152296374) ENABLED START////}
	/**
	 * Inserire qui la documentazione del metodo getElencoStepGraduatoriaNidi.
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
	
	 * @param codiceGraduatoria [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @return it.csi.iscritto.serviscritto.dto.domanda.StepGraduatoria[]
	 * @throws DomandaUserException
	 * @throws CSIException (eccezione base rilanciata dall'infrastruttura di cooperazione)
	 * @throws SystemException in caso di errore di sistema (connessione, comunicazione, ecc.)
	 * @throws UnrecoverableException in caso di errore imprevisto e non recuperabile
	 * @generated
	 */
	////{PROTECTED REGION END////}
	public it.csi.iscritto.serviscritto.dto.domanda.StepGraduatoria[] getElencoStepGraduatoriaNidi( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.String codiceGraduatoria //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException; //NOSONAR  Reason:EIAS

	////{PROTECTED REGION ID(R1580881550) ENABLED START////}
	/**
	 * Inserire qui la documentazione del metodo getElencoStepGraduatoriaMaterne.
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
	
	 * @param codiceGraduatoria [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @return it.csi.iscritto.serviscritto.dto.domanda.StepGraduatoria[]
	 * @throws DomandaUserException
	 * @throws CSIException (eccezione base rilanciata dall'infrastruttura di cooperazione)
	 * @throws SystemException in caso di errore di sistema (connessione, comunicazione, ecc.)
	 * @throws UnrecoverableException in caso di errore imprevisto e non recuperabile
	 * @generated
	 */
	////{PROTECTED REGION END////}
	public it.csi.iscritto.serviscritto.dto.domanda.StepGraduatoria[] getElencoStepGraduatoriaMaterne( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.String codiceGraduatoria //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException; //NOSONAR  Reason:EIAS

	////{PROTECTED REGION ID(R-2086633795) ENABLED START////}
	/**
	 * Inserire qui la documentazione del metodo ricercaGraduatoria.
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
	
	 * @param filtroRicerca [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @return it.csi.iscritto.serviscritto.dto.domanda.TestataGraduatoria[]
	 * @throws DomandaUserException
	 * @throws CSIException (eccezione base rilanciata dall'infrastruttura di cooperazione)
	 * @throws SystemException in caso di errore di sistema (connessione, comunicazione, ecc.)
	 * @throws UnrecoverableException in caso di errore imprevisto e non recuperabile
	 * @generated
	 */
	////{PROTECTED REGION END////}
	public it.csi.iscritto.serviscritto.dto.domanda.TestataGraduatoria[] ricercaGraduatoria( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.RicercaGraduatorieFilter filtroRicerca //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException; //NOSONAR  Reason:EIAS

	////{PROTECTED REGION ID(R542168793) ENABLED START////}
	/**
	 * Inserire qui la documentazione del metodo getParametriGraduatoriaNidi.
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
	
	 * @param codGraduatoria [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @return it.csi.iscritto.serviscritto.dto.domanda.ParametriGraduatoria
	 * @throws DomandaUserException
	 * @throws CSIException (eccezione base rilanciata dall'infrastruttura di cooperazione)
	 * @throws SystemException in caso di errore di sistema (connessione, comunicazione, ecc.)
	 * @throws UnrecoverableException in caso di errore imprevisto e non recuperabile
	 * @generated
	 */
	////{PROTECTED REGION END////}
	public it.csi.iscritto.serviscritto.dto.domanda.ParametriGraduatoria getParametriGraduatoriaNidi( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.String codGraduatoria //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException; //NOSONAR  Reason:EIAS

	////{PROTECTED REGION ID(R1571712651) ENABLED START////}
	/**
	 * Inserire qui la documentazione del metodo getParametriGraduatoriaMaterne.
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
	
	 * @param codGraduatoria [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @return it.csi.iscritto.serviscritto.dto.domanda.ParametriGraduatoria
	 * @throws DomandaUserException
	 * @throws CSIException (eccezione base rilanciata dall'infrastruttura di cooperazione)
	 * @throws SystemException in caso di errore di sistema (connessione, comunicazione, ecc.)
	 * @throws UnrecoverableException in caso di errore imprevisto e non recuperabile
	 * @generated
	 */
	////{PROTECTED REGION END////}
	public it.csi.iscritto.serviscritto.dto.domanda.ParametriGraduatoria getParametriGraduatoriaMaterne( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.String codGraduatoria //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException; //NOSONAR  Reason:EIAS

	////{PROTECTED REGION ID(R-1695179397) ENABLED START////}
	/**
	 * Inserire qui la documentazione del metodo getDomandeNidoNonIstruite.
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
	
	 * @return java.lang.Long[]
	 * @throws DomandaUserException
	 * @throws CSIException (eccezione base rilanciata dall'infrastruttura di cooperazione)
	 * @throws SystemException in caso di errore di sistema (connessione, comunicazione, ecc.)
	 * @throws UnrecoverableException in caso di errore imprevisto e non recuperabile
	 * @generated
	 */
	////{PROTECTED REGION END////}
	public java.lang.Long[] getDomandeNidoNonIstruite( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException; //NOSONAR  Reason:EIAS

	////{PROTECTED REGION ID(R761296723) ENABLED START////}
	/**
	 * Inserire qui la documentazione del metodo getDomandeMaternaNonIstruite.
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
	
	 * @return java.lang.Long[]
	 * @throws DomandaUserException
	 * @throws CSIException (eccezione base rilanciata dall'infrastruttura di cooperazione)
	 * @throws SystemException in caso di errore di sistema (connessione, comunicazione, ecc.)
	 * @throws UnrecoverableException in caso di errore imprevisto e non recuperabile
	 * @generated
	 */
	////{PROTECTED REGION END////}
	public java.lang.Long[] getDomandeMaternaNonIstruite( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException; //NOSONAR  Reason:EIAS

	////{PROTECTED REGION ID(R2112200361) ENABLED START////}
	/**
	 * Inserire qui la documentazione del metodo getVerifichePreventivePendenti.
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
	
	 * @param idDomande [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @return it.csi.iscritto.serviscritto.dto.domanda.InfoVerifiche[]
	 * @throws DomandaUserException
	 * @throws CSIException (eccezione base rilanciata dall'infrastruttura di cooperazione)
	 * @throws SystemException in caso di errore di sistema (connessione, comunicazione, ecc.)
	 * @throws UnrecoverableException in caso di errore imprevisto e non recuperabile
	 * @generated
	 */
	////{PROTECTED REGION END////}
	public it.csi.iscritto.serviscritto.dto.domanda.InfoVerifiche[] getVerifichePreventivePendenti( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.Long[] idDomande //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException; //NOSONAR  Reason:EIAS

	////{PROTECTED REGION ID(R1899046117) ENABLED START////}
	/**
	 * Inserire qui la documentazione del metodo calcolaGraduatoria.
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
	
	 * @param parametri [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @return void
	 * @throws DomandaUserException
	 * @throws CSIException (eccezione base rilanciata dall'infrastruttura di cooperazione)
	 * @throws SystemException in caso di errore di sistema (connessione, comunicazione, ecc.)
	 * @throws UnrecoverableException in caso di errore imprevisto e non recuperabile
	 * @generated
	 */
	////{PROTECTED REGION END////}
	public void calcolaGraduatoria( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.ParametriCalcoloGraduatoria parametri //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException; //NOSONAR  Reason:EIAS

	////{PROTECTED REGION ID(R-1896130955) ENABLED START////}
	/**
	 * Inserire qui la documentazione del metodo getElencoAnniScolastici.
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
	
	 * @return it.csi.iscritto.serviscritto.dto.domanda.AnnoScolastico[]
	 * @throws DomandaUserException
	 * @throws CSIException (eccezione base rilanciata dall'infrastruttura di cooperazione)
	 * @throws SystemException in caso di errore di sistema (connessione, comunicazione, ecc.)
	 * @throws UnrecoverableException in caso di errore imprevisto e non recuperabile
	 * @generated
	 */
	////{PROTECTED REGION END////}
	public it.csi.iscritto.serviscritto.dto.domanda.AnnoScolastico[] getElencoAnniScolastici( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException; //NOSONAR  Reason:EIAS

	////{PROTECTED REGION ID(R-1461246710) ENABLED START////}
	/**
	 * Inserire qui la documentazione del metodo getElencoClassiNido.
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
	
	 * @param codScuola [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @param codAnnoScolastico [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @return it.csi.iscritto.serviscritto.dto.domanda.Classe[]
	 * @throws DomandaUserException
	 * @throws CSIException (eccezione base rilanciata dall'infrastruttura di cooperazione)
	 * @throws SystemException in caso di errore di sistema (connessione, comunicazione, ecc.)
	 * @throws UnrecoverableException in caso di errore imprevisto e non recuperabile
	 * @generated
	 */
	////{PROTECTED REGION END////}
	public it.csi.iscritto.serviscritto.dto.domanda.Classe[] getElencoClassiNido( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.String codScuola, //NOSONAR  Reason:EIAS

			java.lang.String codAnnoScolastico //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException; //NOSONAR  Reason:EIAS

	////{PROTECTED REGION ID(R685829244) ENABLED START////}
	/**
	 * Inserire qui la documentazione del metodo getElencoClassiMaterna.
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
	
	 * @param codScuola [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @param codAnnoScolastico [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @return it.csi.iscritto.serviscritto.dto.domanda.Classe[]
	 * @throws DomandaUserException
	 * @throws CSIException (eccezione base rilanciata dall'infrastruttura di cooperazione)
	 * @throws SystemException in caso di errore di sistema (connessione, comunicazione, ecc.)
	 * @throws UnrecoverableException in caso di errore imprevisto e non recuperabile
	 * @generated
	 */
	////{PROTECTED REGION END////}
	public it.csi.iscritto.serviscritto.dto.domanda.Classe[] getElencoClassiMaterna( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.String codScuola, //NOSONAR  Reason:EIAS

			java.lang.String codAnnoScolastico //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException; //NOSONAR  Reason:EIAS

	////{PROTECTED REGION ID(R1616034539) ENABLED START////}
	/**
	 * Inserire qui la documentazione del metodo insertClasseNido.
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
	
	 * @param classe [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @return java.lang.Long
	 * @throws DomandaUserException
	 * @throws CSIException (eccezione base rilanciata dall'infrastruttura di cooperazione)
	 * @throws SystemException in caso di errore di sistema (connessione, comunicazione, ecc.)
	 * @throws UnrecoverableException in caso di errore imprevisto e non recuperabile
	 * @generated
	 */
	////{PROTECTED REGION END////}
	public java.lang.Long insertClasseNido( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.ClasseParam classe //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException; //NOSONAR  Reason:EIAS

	////{PROTECTED REGION ID(R-105414917) ENABLED START////}
	/**
	 * Inserire qui la documentazione del metodo insertClasseMaterna.
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
	
	 * @param classe [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @return java.lang.Long
	 * @throws DomandaUserException
	 * @throws CSIException (eccezione base rilanciata dall'infrastruttura di cooperazione)
	 * @throws SystemException in caso di errore di sistema (connessione, comunicazione, ecc.)
	 * @throws UnrecoverableException in caso di errore imprevisto e non recuperabile
	 * @generated
	 */
	////{PROTECTED REGION END////}
	public java.lang.Long insertClasseMaterna( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.ClasseParam classe //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException; //NOSONAR  Reason:EIAS

	////{PROTECTED REGION ID(R114416891) ENABLED START////}
	/**
	 * Inserire qui la documentazione del metodo updateClasseNido.
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
	
	 * @param classe [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @return java.lang.Integer
	 * @throws DomandaUserException
	 * @throws CSIException (eccezione base rilanciata dall'infrastruttura di cooperazione)
	 * @throws SystemException in caso di errore di sistema (connessione, comunicazione, ecc.)
	 * @throws UnrecoverableException in caso di errore imprevisto e non recuperabile
	 * @generated
	 */
	////{PROTECTED REGION END////}
	public java.lang.Integer updateClasseNido( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.ClasseParam classe //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException; //NOSONAR  Reason:EIAS

	////{PROTECTED REGION ID(R1582588651) ENABLED START////}
	/**
	 * Inserire qui la documentazione del metodo updateClasseMaterna.
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
	
	 * @param classe [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @return java.lang.Integer
	 * @throws DomandaUserException
	 * @throws CSIException (eccezione base rilanciata dall'infrastruttura di cooperazione)
	 * @throws SystemException in caso di errore di sistema (connessione, comunicazione, ecc.)
	 * @throws UnrecoverableException in caso di errore imprevisto e non recuperabile
	 * @generated
	 */
	////{PROTECTED REGION END////}
	public java.lang.Integer updateClasseMaterna( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.ClasseParam classe //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException; //NOSONAR  Reason:EIAS

	////{PROTECTED REGION ID(R-122751139) ENABLED START////}
	/**
	 * Inserire qui la documentazione del metodo deleteClasseNido.
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
	
	 * @param idClasse [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @return java.lang.Integer
	 * @throws DomandaUserException
	 * @throws CSIException (eccezione base rilanciata dall'infrastruttura di cooperazione)
	 * @throws SystemException in caso di errore di sistema (connessione, comunicazione, ecc.)
	 * @throws UnrecoverableException in caso di errore imprevisto e non recuperabile
	 * @generated
	 */
	////{PROTECTED REGION END////}
	public java.lang.Integer deleteClasseNido( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.Long idClasse //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException; //NOSONAR  Reason:EIAS

	////{PROTECTED REGION ID(R1331008841) ENABLED START////}
	/**
	 * Inserire qui la documentazione del metodo deleteClasseMaterna.
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
	
	 * @param idClasse [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @return java.lang.Integer
	 * @throws DomandaUserException
	 * @throws CSIException (eccezione base rilanciata dall'infrastruttura di cooperazione)
	 * @throws SystemException in caso di errore di sistema (connessione, comunicazione, ecc.)
	 * @throws UnrecoverableException in caso di errore imprevisto e non recuperabile
	 * @generated
	 */
	////{PROTECTED REGION END////}
	public java.lang.Integer deleteClasseMaterna( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.Long idClasse //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException; //NOSONAR  Reason:EIAS

	////{PROTECTED REGION ID(R1749683971) ENABLED START////}
	/**
	 * Inserire qui la documentazione del metodo getElencoNidiDse.
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
	
	 * @param idDomanda [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @return it.csi.iscritto.serviscritto.dto.domanda.Nido[]
	 * @throws DomandaUserException
	 * @throws CSIException (eccezione base rilanciata dall'infrastruttura di cooperazione)
	 * @throws SystemException in caso di errore di sistema (connessione, comunicazione, ecc.)
	 * @throws UnrecoverableException in caso di errore imprevisto e non recuperabile
	 * @generated
	 */
	////{PROTECTED REGION END////}
	public it.csi.iscritto.serviscritto.dto.domanda.Nido[] getElencoNidiDse( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.Long idDomanda //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException; //NOSONAR  Reason:EIAS

	////{PROTECTED REGION ID(R-1534104955) ENABLED START////}
	/**
	 * Inserire qui la documentazione del metodo getElencoMaterneDse.
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
	
	 * @param idDomanda [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @return it.csi.iscritto.serviscritto.dto.domanda.Materna[]
	 * @throws DomandaUserException
	 * @throws CSIException (eccezione base rilanciata dall'infrastruttura di cooperazione)
	 * @throws SystemException in caso di errore di sistema (connessione, comunicazione, ecc.)
	 * @throws UnrecoverableException in caso di errore imprevisto e non recuperabile
	 * @generated
	 */
	////{PROTECTED REGION END////}
	public it.csi.iscritto.serviscritto.dto.domanda.Materna[] getElencoMaterneDse( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.Long idDomanda //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException; //NOSONAR  Reason:EIAS

	////{PROTECTED REGION ID(R943296841) ENABLED START////}
	/**
	 * Inserire qui la documentazione del metodo getResidenzeForzateNidi.
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
	
	 * @return it.csi.iscritto.serviscritto.dto.domanda.ResidenzaForzata[]
	 * @throws DomandaUserException
	 * @throws CSIException (eccezione base rilanciata dall'infrastruttura di cooperazione)
	 * @throws SystemException in caso di errore di sistema (connessione, comunicazione, ecc.)
	 * @throws UnrecoverableException in caso di errore imprevisto e non recuperabile
	 * @generated
	 */
	////{PROTECTED REGION END////}
	public it.csi.iscritto.serviscritto.dto.domanda.InfoResidenzeForzate getResidenzeForzateNidi( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException; //NOSONAR  Reason:EIAS

	////{PROTECTED REGION ID(R-1316594149) ENABLED START////}
	/**
	 * Inserire qui la documentazione del metodo getResidenzeForzateMaterne.
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
	
	 * @return it.csi.iscritto.serviscritto.dto.domanda.InfoResidenzeForzate
	 * @throws DomandaUserException
	 * @throws CSIException (eccezione base rilanciata dall'infrastruttura di cooperazione)
	 * @throws SystemException in caso di errore di sistema (connessione, comunicazione, ecc.)
	 * @throws UnrecoverableException in caso di errore imprevisto e non recuperabile
	 * @generated
	 */
	////{PROTECTED REGION END////}
	public it.csi.iscritto.serviscritto.dto.domanda.InfoResidenzeForzate getResidenzeForzateMaterne( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException; //NOSONAR  Reason:EIAS

	////{PROTECTED REGION ID(R1532172243) ENABLED START////}
	/**
	 * Inserire qui la documentazione del metodo getGraduatoriaCompletaNidi.
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
	
	 * @return it.csi.iscritto.serviscritto.dto.domanda.GraduatoriaCompleta[]
	 * @throws DomandaUserException
	 * @throws CSIException (eccezione base rilanciata dall'infrastruttura di cooperazione)
	 * @throws SystemException in caso di errore di sistema (connessione, comunicazione, ecc.)
	 * @throws UnrecoverableException in caso di errore imprevisto e non recuperabile
	 * @generated
	 */
	////{PROTECTED REGION END////}
	public it.csi.iscritto.serviscritto.dto.domanda.GraduatoriaCompleta[] getGraduatoriaCompletaNidi( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException; //NOSONAR  Reason:EIAS

	////{PROTECTED REGION ID(R1224069969) ENABLED START////}
	/**
	 * Inserire qui la documentazione del metodo getGraduatoriaCompletaMaterne.
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
	
	 * @return it.csi.iscritto.serviscritto.dto.domanda.GraduatoriaCompleta[]
	 * @throws DomandaUserException
	 * @throws CSIException (eccezione base rilanciata dall'infrastruttura di cooperazione)
	 * @throws SystemException in caso di errore di sistema (connessione, comunicazione, ecc.)
	 * @throws UnrecoverableException in caso di errore imprevisto e non recuperabile
	 * @generated
	 */
	////{PROTECTED REGION END////}
	public it.csi.iscritto.serviscritto.dto.domanda.GraduatoriaCompleta[] getGraduatoriaCompletaMaterne( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException; //NOSONAR  Reason:EIAS

	////{PROTECTED REGION ID(R-1521997059) ENABLED START////}
	/**
	 * Inserire qui la documentazione del metodo updateFlagAmmissioni.
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
	
	 * @param idClasseList [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @param value [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @return void
	 * @throws DomandaUserException
	 * @throws CSIException (eccezione base rilanciata dall'infrastruttura di cooperazione)
	 * @throws SystemException in caso di errore di sistema (connessione, comunicazione, ecc.)
	 * @throws UnrecoverableException in caso di errore imprevisto e non recuperabile
	 * @generated
	 */
	////{PROTECTED REGION END////}
	public java.lang.Integer updateFlagAmmissioni( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.Long[] idClasseList, //NOSONAR  Reason:EIAS

			java.lang.Boolean value //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException; //NOSONAR  Reason:EIAS

	////{PROTECTED REGION ID(R2096943118) ENABLED START////}
	/**
	 * Inserire qui la documentazione del metodo getInfoStepGraduatorieNido.
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
	
	 * @return it.csi.iscritto.serviscritto.dto.domanda.InfoStepGraduatoria[]
	 * @throws DomandaUserException
	 * @throws CSIException (eccezione base rilanciata dall'infrastruttura di cooperazione)
	 * @throws SystemException in caso di errore di sistema (connessione, comunicazione, ecc.)
	 * @throws UnrecoverableException in caso di errore imprevisto e non recuperabile
	 * @generated
	 */
	////{PROTECTED REGION END////}
	public it.csi.iscritto.serviscritto.dto.domanda.InfoStepGraduatoria[] getInfoStepGraduatorieNido( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException; //NOSONAR  Reason:EIAS

	////{PROTECTED REGION ID(R-1368837384) ENABLED START////}
	/**
	 * Inserire qui la documentazione del metodo getInfoStepGraduatorieMaterna.
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
	
	 * @return it.csi.iscritto.serviscritto.dto.domanda.InfoStepGraduatoria[]
	 * @throws DomandaUserException
	 * @throws CSIException (eccezione base rilanciata dall'infrastruttura di cooperazione)
	 * @throws SystemException in caso di errore di sistema (connessione, comunicazione, ecc.)
	 * @throws UnrecoverableException in caso di errore imprevisto e non recuperabile
	 * @generated
	 */
	////{PROTECTED REGION END////}
	public it.csi.iscritto.serviscritto.dto.domanda.InfoStepGraduatoria[] getInfoStepGraduatorieMaterna( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException; //NOSONAR  Reason:EIAS

	////{PROTECTED REGION ID(R2038862412) ENABLED START////}
	/**
	 * Inserire qui la documentazione del metodo getGraduatoriaApprovazioneNidi.
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
	
	 * @param codiceGraduatoria [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @param step [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @param codiceStatoGraduatoria [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @return it.csi.iscritto.serviscritto.dto.domanda.GraduatoriaAmmessi[]
	 * @throws DomandaUserException
	 * @throws CSIException (eccezione base rilanciata dall'infrastruttura di cooperazione)
	 * @throws SystemException in caso di errore di sistema (connessione, comunicazione, ecc.)
	 * @throws UnrecoverableException in caso di errore imprevisto e non recuperabile
	 * @generated
	 */
	////{PROTECTED REGION END////}
	public it.csi.iscritto.serviscritto.dto.domanda.GraduatoriaApprovazione[] getGraduatoriaApprovazioneNidi( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.String codiceGraduatoria, //NOSONAR  Reason:EIAS

			java.lang.Integer step, //NOSONAR  Reason:EIAS

			java.lang.String codiceStatoGraduatoria //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException; //NOSONAR  Reason:EIAS

	////{PROTECTED REGION ID(R-779150792) ENABLED START////}
	/**
	 * Inserire qui la documentazione del metodo getGraduatoriaApprovazioneMaterne.
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
	
	 * @param codiceGraduatoria [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @param step [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @param codiceStatoGraduatoria [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @return it.csi.iscritto.serviscritto.dto.domanda.GraduatoriaApprovazione[]
	 * @throws DomandaUserException
	 * @throws CSIException (eccezione base rilanciata dall'infrastruttura di cooperazione)
	 * @throws SystemException in caso di errore di sistema (connessione, comunicazione, ecc.)
	 * @throws UnrecoverableException in caso di errore imprevisto e non recuperabile
	 * @generated
	 */
	////{PROTECTED REGION END////}
	public it.csi.iscritto.serviscritto.dto.domanda.GraduatoriaApprovazione[] getGraduatoriaApprovazioneMaterne( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.String codiceGraduatoria, //NOSONAR  Reason:EIAS

			java.lang.Integer step, //NOSONAR  Reason:EIAS

			java.lang.String codiceStatoGraduatoria //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException; //NOSONAR  Reason:EIAS

	////{PROTECTED REGION ID(R-1906805573) ENABLED START////}
	/**
	 * Inserire qui la documentazione del metodo insertNidoFuoriTermine.
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
	
	 * @param cfOperatore [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @param idDomanda [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @param codScuola [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @param codTipoFrequenza [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @return void
	 * @throws DomandaUserException
	 * @throws CSIException (eccezione base rilanciata dall'infrastruttura di cooperazione)
	 * @throws SystemException in caso di errore di sistema (connessione, comunicazione, ecc.)
	 * @throws UnrecoverableException in caso di errore imprevisto e non recuperabile
	 * @generated
	 */
	////{PROTECTED REGION END////}
	public void insertNidoFuoriTermine( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.Long idDomanda, //NOSONAR  Reason:EIAS

			java.lang.String cfOperatore, //NOSONAR  Reason:EIAS

			java.lang.String codScuola, //NOSONAR  Reason:EIAS

			java.lang.String codTipoFrequenza //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException; //NOSONAR  Reason:EIAS

	////{PROTECTED REGION ID(R-2058251259) ENABLED START////}
	/**
	 * Inserire qui la documentazione del metodo insertMaternaFuoriTermine.
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
	
	 * @param idDomanda [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @param cfOperatore [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @param codScuola [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @param codTipoFrequenza [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @return void
	 * @throws DomandaUserException
	 * @throws CSIException (eccezione base rilanciata dall'infrastruttura di cooperazione)
	 * @throws SystemException in caso di errore di sistema (connessione, comunicazione, ecc.)
	 * @throws UnrecoverableException in caso di errore imprevisto e non recuperabile
	 * @generated
	 */
	////{PROTECTED REGION END////}
	public void insertMaternaFuoriTermine( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.Long idDomanda, //NOSONAR  Reason:EIAS

			java.lang.String cfOperatore, //NOSONAR  Reason:EIAS

			java.lang.String codScuola, //NOSONAR  Reason:EIAS

			java.lang.String codTipoFrequenza //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException; //NOSONAR  Reason:EIAS

	////{PROTECTED REGION ID(R-601066008) ENABLED START////}
	/**
	 * Inserire qui la documentazione del metodo generaRicevuta.
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
	
	 * @param idAllegato [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @return it.csi.iscritto.serviscritto.dto.domanda.RicevutaAllegato
	 * @throws DomandaUserException
	 * @throws CSIException (eccezione base rilanciata dall'infrastruttura di cooperazione)
	 * @throws SystemException in caso di errore di sistema (connessione, comunicazione, ecc.)
	 * @throws UnrecoverableException in caso di errore imprevisto e non recuperabile
	 * @generated
	 */
	////{PROTECTED REGION END////}
	public it.csi.iscritto.serviscritto.dto.domanda.RicevutaAllegato generaRicevuta( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.Long idAllegato //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException; //NOSONAR  Reason:EIAS

	////{PROTECTED REGION ID(R966746530) ENABLED START////}
	/**
	 * Inserire qui la documentazione del metodo generaRicevutaAccettazione.
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
	
	 * @param idDomanda [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @return it.csi.iscritto.serviscritto.dto.domanda.RicevutaAccettazione
	 * @throws DomandaUserException
	 * @throws CSIException (eccezione base rilanciata dall'infrastruttura di cooperazione)
	 * @throws SystemException in caso di errore di sistema (connessione, comunicazione, ecc.)
	 * @throws UnrecoverableException in caso di errore imprevisto e non recuperabile
	 * @generated
	 */
	////{PROTECTED REGION END////}
	public it.csi.iscritto.serviscritto.dto.domanda.RicevutaAccettazione generaRicevutaAccettazione( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.Long idDomanda, //NOSONAR  Reason:EIAS

			java.lang.String cfRichiedente //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException; //NOSONAR  Reason:EIAS

	////{PROTECTED REGION ID(R-436245617) ENABLED START////}
	/**
	 * Inserire qui la documentazione del metodo getFasceEta.
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
	
	 * @return it.csi.iscritto.serviscritto.dto.domanda.FasciaEta[]
	 * @throws DomandaUserException
	 * @throws CSIException (eccezione base rilanciata dall'infrastruttura di cooperazione)
	 * @throws SystemException in caso di errore di sistema (connessione, comunicazione, ecc.)
	 * @throws UnrecoverableException in caso di errore imprevisto e non recuperabile
	 * @generated
	 */
	////{PROTECTED REGION END////}
	public it.csi.iscritto.serviscritto.dto.domanda.FasciaEta[] getFasceEta( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException; //NOSONAR  Reason:EIAS

	////{PROTECTED REGION ID(R-823422657) ENABLED START////}
	/**
	 * Inserire qui la documentazione del metodo getAnagraficaGraduatorie.
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
	
	 * @return it.csi.iscritto.serviscritto.dto.domanda.AnagraficaGraduatoria[]
	 * @throws DomandaUserException
	 * @throws CSIException (eccezione base rilanciata dall'infrastruttura di cooperazione)
	 * @throws SystemException in caso di errore di sistema (connessione, comunicazione, ecc.)
	 * @throws UnrecoverableException in caso di errore imprevisto e non recuperabile
	 * @generated
	 */
	////{PROTECTED REGION END////}
	public it.csi.iscritto.serviscritto.dto.domanda.AnagraficaGraduatoria[] getAnagraficaGraduatorie( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException; //NOSONAR  Reason:EIAS

	////{PROTECTED REGION ID(R-823422661) ENABLED START////}
	/**
	 * Inserire qui la documentazione del metodo getAnagraficaGraduatoria.
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
	
	 * @param codOrdineScuola [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @param codAnagraficaGraduatoria [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @param codAnnoScolastico [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @return it.csi.iscritto.serviscritto.dto.domanda.AnagraficaGraduatoria
	 * @throws DomandaUserException
	 * @throws CSIException (eccezione base rilanciata dall'infrastruttura di cooperazione)
	 * @throws SystemException in caso di errore di sistema (connessione, comunicazione, ecc.)
	 * @throws UnrecoverableException in caso di errore imprevisto e non recuperabile
	 * @generated
	 */
	////{PROTECTED REGION END////}
	public it.csi.iscritto.serviscritto.dto.domanda.AnagraficaGraduatoria getAnagraficaGraduatoria( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.String codOrdineScuola, //NOSONAR  Reason:EIAS

			java.lang.String codAnagraficaGraduatoria, //NOSONAR  Reason:EIAS

			java.lang.String codAnnoScolastico //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException; //NOSONAR  Reason:EIAS

	////{PROTECTED REGION ID(R614798042) ENABLED START////}
	/**
	 * Inserire qui la documentazione del metodo insertAnagraficaGraduatoria.
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
	
	 * @param anagraficaGraduatoria [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @return java.lang.Long
	 * @throws DomandaUserException
	 * @throws CSIException (eccezione base rilanciata dall'infrastruttura di cooperazione)
	 * @throws SystemException in caso di errore di sistema (connessione, comunicazione, ecc.)
	 * @throws UnrecoverableException in caso di errore imprevisto e non recuperabile
	 * @generated
	 */
	////{PROTECTED REGION END////}
	public java.lang.Long insertAnagraficaGraduatoria( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.AnagraficaGraduatoria anagraficaGraduatoria //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException; //NOSONAR  Reason:EIAS

	////{PROTECTED REGION ID(R-606665014) ENABLED START////}
	/**
	 * Inserire qui la documentazione del metodo updateAnagraficaGraduatoria.
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
	
	 * @param anagraficaGraduatoria [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @return java.lang.Integer
	 * @throws DomandaUserException
	 * @throws CSIException (eccezione base rilanciata dall'infrastruttura di cooperazione)
	 * @throws SystemException in caso di errore di sistema (connessione, comunicazione, ecc.)
	 * @throws UnrecoverableException in caso di errore imprevisto e non recuperabile
	 * @generated
	 */
	////{PROTECTED REGION END////}
	public java.lang.Integer updateAnagraficaGraduatoria( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.AnagraficaGraduatoria anagraficaGraduatoria //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException; //NOSONAR  Reason:EIAS

	////{PROTECTED REGION ID(R45217743) ENABLED START////}
	/**
	 * Inserire qui la documentazione del metodo getAnagraficaStepGraduatoria.
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
	
	 * @param codOrdineScuola [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @param codAnagraficaGraduatoria [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @param codAnnoScolastico [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @return it.csi.iscritto.serviscritto.dto.domanda.AnagraficaStepGraduatoria[]
	 * @throws DomandaUserException
	 * @throws CSIException (eccezione base rilanciata dall'infrastruttura di cooperazione)
	 * @throws SystemException in caso di errore di sistema (connessione, comunicazione, ecc.)
	 * @throws UnrecoverableException in caso di errore imprevisto e non recuperabile
	 * @generated
	 */
	////{PROTECTED REGION END////}
	public it.csi.iscritto.serviscritto.dto.domanda.AnagraficaStepGraduatoria[] getAnagraficaStepGraduatoria( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.String codOrdineScuola, //NOSONAR  Reason:EIAS

			java.lang.String codAnagraficaGraduatoria, //NOSONAR  Reason:EIAS

			java.lang.String codAnnoScolastico //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException; //NOSONAR  Reason:EIAS

	////{PROTECTED REGION ID(R-159149586) ENABLED START////}
	/**
	 * Inserire qui la documentazione del metodo insertAnagraficaStepGraduatoria.
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
	
	 * @param stepGraduatoria [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @return java.lang.Long
	 * @throws DomandaUserException
	 * @throws CSIException (eccezione base rilanciata dall'infrastruttura di cooperazione)
	 * @throws SystemException in caso di errore di sistema (connessione, comunicazione, ecc.)
	 * @throws UnrecoverableException in caso di errore imprevisto e non recuperabile
	 * @generated
	 */
	////{PROTECTED REGION END////}
	public java.lang.Long insertAnagraficaStepGraduatoria( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.AnagraficaStepGraduatoria stepGraduatoria //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException; //NOSONAR  Reason:EIAS

	////{PROTECTED REGION ID(R448400862) ENABLED START////}
	/**
	 * Inserire qui la documentazione del metodo updateAnagraficaStepGraduatoria.
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
	
	 * @param stepGraduatoria [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @return java.lang.Integer
	 * @throws DomandaUserException
	 * @throws CSIException (eccezione base rilanciata dall'infrastruttura di cooperazione)
	 * @throws SystemException in caso di errore di sistema (connessione, comunicazione, ecc.)
	 * @throws UnrecoverableException in caso di errore imprevisto e non recuperabile
	 * @generated
	 */
	////{PROTECTED REGION END////}
	public java.lang.Integer updateAnagraficaStepGraduatoria( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.AnagraficaStepGraduatoria stepGraduatoria //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException; //NOSONAR  Reason:EIAS

	////{PROTECTED REGION ID(R-1113808068) ENABLED START////}
	/**
	 * Inserire qui la documentazione del metodo deleteAnagraficaStepGraduatoria.
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
	
	 * @param idStepGra [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @return java.lang.Integer
	 * @throws DomandaUserException
	 * @throws CSIException (eccezione base rilanciata dall'infrastruttura di cooperazione)
	 * @throws SystemException in caso di errore di sistema (connessione, comunicazione, ecc.)
	 * @throws UnrecoverableException in caso di errore imprevisto e non recuperabile
	 * @generated
	 */
	////{PROTECTED REGION END////}
	public java.lang.Integer deleteAnagraficaStepGraduatoria( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.Long idStepGra //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException; //NOSONAR  Reason:EIAS

	////{PROTECTED REGION ID(R-1287503560) ENABLED START////}
	/**
	 * Inserire qui la documentazione del metodo getAnagraficaEta.
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
	
	 * @param codOrdineScuola [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @param codAnagraficaGraduatoria [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @param codAnnoScolastico [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @return it.csi.iscritto.serviscritto.dto.domanda.AnagraficaEta[]
	 * @throws DomandaUserException
	 * @throws CSIException (eccezione base rilanciata dall'infrastruttura di cooperazione)
	 * @throws SystemException in caso di errore di sistema (connessione, comunicazione, ecc.)
	 * @throws UnrecoverableException in caso di errore imprevisto e non recuperabile
	 * @generated
	 */
	////{PROTECTED REGION END////}
	public it.csi.iscritto.serviscritto.dto.domanda.AnagraficaEta[] getAnagraficaEta( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.String codOrdineScuola, //NOSONAR  Reason:EIAS

			java.lang.String codAnagraficaGraduatoria, //NOSONAR  Reason:EIAS

			java.lang.String codAnnoScolastico //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException; //NOSONAR  Reason:EIAS

	////{PROTECTED REGION ID(R-1140141609) ENABLED START////}
	/**
	 * Inserire qui la documentazione del metodo insertAnagraficaEta.
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
	
	 * @param anagraficaEta [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @return java.lang.Long
	 * @throws DomandaUserException
	 * @throws CSIException (eccezione base rilanciata dall'infrastruttura di cooperazione)
	 * @throws SystemException in caso di errore di sistema (connessione, comunicazione, ecc.)
	 * @throws UnrecoverableException in caso di errore imprevisto e non recuperabile
	 * @generated
	 */
	////{PROTECTED REGION END////}
	public java.lang.Long insertAnagraficaEta( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.AnagraficaEta anagraficaEta //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException; //NOSONAR  Reason:EIAS

	////{PROTECTED REGION ID(R547861959) ENABLED START////}
	/**
	 * Inserire qui la documentazione del metodo updateAnagraficaEta.
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
	
	 * @param anagraficaEta [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @return java.lang.Integer
	 * @throws DomandaUserException
	 * @throws CSIException (eccezione base rilanciata dall'infrastruttura di cooperazione)
	 * @throws SystemException in caso di errore di sistema (connessione, comunicazione, ecc.)
	 * @throws UnrecoverableException in caso di errore imprevisto e non recuperabile
	 * @generated
	 */
	////{PROTECTED REGION END////}
	public java.lang.Integer updateAnagraficaEta( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.AnagraficaEta anagraficaEta //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException; //NOSONAR  Reason:EIAS

	////{PROTECTED REGION ID(R296282149) ENABLED START////}
	/**
	 * Inserire qui la documentazione del metodo deleteAnagraficaEta.
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
	
	 * @param idEta [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @return java.lang.Integer
	 * @throws DomandaUserException
	 * @throws CSIException (eccezione base rilanciata dall'infrastruttura di cooperazione)
	 * @throws SystemException in caso di errore di sistema (connessione, comunicazione, ecc.)
	 * @throws UnrecoverableException in caso di errore imprevisto e non recuperabile
	 * @generated
	 */
	////{PROTECTED REGION END////}
	public java.lang.Integer deleteAnagraficaEta( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.Long idEta //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException; //NOSONAR  Reason:EIAS

	////{PROTECTED REGION ID(R-1655942819) ENABLED START////}
	/**
	 * Inserire qui la documentazione del metodo getTipiFasceEta.
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
	
	 * @return it.csi.iscritto.serviscritto.dto.domanda.TipoFasciaEta[]
	 * @throws DomandaUserException
	 * @throws CSIException (eccezione base rilanciata dall'infrastruttura di cooperazione)
	 * @throws SystemException in caso di errore di sistema (connessione, comunicazione, ecc.)
	 * @throws UnrecoverableException in caso di errore imprevisto e non recuperabile
	 * @generated
	 */
	////{PROTECTED REGION END////}
	public it.csi.iscritto.serviscritto.dto.domanda.TipoFasciaEta[] getTipiFasceEta( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException; //NOSONAR  Reason:EIAS

	////{PROTECTED REGION ID(R1077575701) ENABLED START////}
	/**
	 * Inserire qui la documentazione del metodo getReportPostiLiberi.
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
	
	 * @return it.csi.iscritto.serviscritto.dto.domanda.RecordPostiLiberi[]
	 * @throws DomandaUserException
	 * @throws CSIException (eccezione base rilanciata dall'infrastruttura di cooperazione)
	 * @throws SystemException in caso di errore di sistema (connessione, comunicazione, ecc.)
	 * @throws UnrecoverableException in caso di errore imprevisto e non recuperabile
	 * @generated
	 */
	////{PROTECTED REGION END////}
	public it.csi.iscritto.serviscritto.dto.domanda.RecordPostiLiberi[] getReportPostiLiberi( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.String codOrdineScuola //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException; //NOSONAR  Reason:EIAS

	////{PROTECTED REGION ID(R-660964333) ENABLED START////}
	/**
	 * Inserire qui la documentazione del metodo modificaStatoScuolaPreferenza.
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
	
	 * @param idGraduatoria [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @param idStatoAttuale [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @param idStatoRipristino [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @return java.lang.Integer
	 * @throws DomandaUserException
	 * @throws CSIException (eccezione base rilanciata dall'infrastruttura di cooperazione)
	 * @throws SystemException in caso di errore di sistema (connessione, comunicazione, ecc.)
	 * @throws UnrecoverableException in caso di errore imprevisto e non recuperabile
	 * @generated
	 */
	////{PROTECTED REGION END////}
	public it.csi.iscritto.serviscritto.dto.domanda.Result modificaStatoScuolaPreferenza( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.Long idGraduatoria, //NOSONAR  Reason:EIAS

			java.lang.Long idStatoAttuale, //NOSONAR  Reason:EIAS

			java.lang.Long idStatoRipristino //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException; //NOSONAR  Reason:EIAS

	////{PROTECTED REGION ID(R1931187070) ENABLED START////}
	/**
	 * Inserire qui la documentazione del metodo getPreferenzeScuole.
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
	
	 * @param idAnagraficaGra [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @return it.csi.iscritto.serviscritto.dto.domanda.RecordPreferenzaScuola[]
	 * @throws DomandaUserException
	 * @throws CSIException (eccezione base rilanciata dall'infrastruttura di cooperazione)
	 * @throws SystemException in caso di errore di sistema (connessione, comunicazione, ecc.)
	 * @throws UnrecoverableException in caso di errore imprevisto e non recuperabile
	 * @generated
	 */
	////{PROTECTED REGION END////}
	public it.csi.iscritto.serviscritto.dto.domanda.RecordPreferenzaScuola[] getPreferenzeScuole( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.Long idAnagraficaGra, //NOSONAR  Reason:EIAS

			java.lang.Long idDomanda //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException; //NOSONAR  Reason:EIAS

	////{PROTECTED REGION ID(R-1981784632) ENABLED START////}
	/**
	 * Inserire qui la documentazione del metodo getFlagBloccoGraduatoriaNidi.
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
	
	 * @return java.lang.Boolean
	 * @throws DomandaUserException
	 * @throws CSIException (eccezione base rilanciata dall'infrastruttura di cooperazione)
	 * @throws SystemException in caso di errore di sistema (connessione, comunicazione, ecc.)
	 * @throws UnrecoverableException in caso di errore imprevisto e non recuperabile
	 * @generated
	 */
	////{PROTECTED REGION END////}
	public java.lang.Boolean getFlagBloccoGraduatoriaNidi( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException; //NOSONAR  Reason:EIAS

	////{PROTECTED REGION ID(R-743655876) ENABLED START////}
	/**
	 * Inserire qui la documentazione del metodo setFlagBloccoGraduatoriaNidi.
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
	
	 * @param value [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @return void
	 * @throws DomandaUserException
	 * @throws CSIException (eccezione base rilanciata dall'infrastruttura di cooperazione)
	 * @throws SystemException in caso di errore di sistema (connessione, comunicazione, ecc.)
	 * @throws UnrecoverableException in caso di errore imprevisto e non recuperabile
	 * @generated
	 */
	////{PROTECTED REGION END////}
	public void setFlagBloccoGraduatoriaNidi( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.Boolean value //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException; //NOSONAR  Reason:EIAS

	////{PROTECTED REGION ID(R-1827287748) ENABLED START////}
	/**
	 * Inserire qui la documentazione del metodo getFlagBloccoGraduatoriaMaterne.
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
	
	 * @return java.lang.Boolean
	 * @throws DomandaUserException
	 * @throws CSIException (eccezione base rilanciata dall'infrastruttura di cooperazione)
	 * @throws SystemException in caso di errore di sistema (connessione, comunicazione, ecc.)
	 * @throws UnrecoverableException in caso di errore imprevisto e non recuperabile
	 * @generated
	 */
	////{PROTECTED REGION END////}
	public java.lang.Boolean getFlagBloccoGraduatoriaMaterne( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException; //NOSONAR  Reason:EIAS

	////{PROTECTED REGION ID(R-1912655800) ENABLED START////}
	/**
	 * Inserire qui la documentazione del metodo setFlagBloccoGraduatoriaMaterne.
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
	
	 * @param value [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @return void
	 * @throws DomandaUserException
	 * @throws CSIException (eccezione base rilanciata dall'infrastruttura di cooperazione)
	 * @throws SystemException in caso di errore di sistema (connessione, comunicazione, ecc.)
	 * @throws UnrecoverableException in caso di errore imprevisto e non recuperabile
	 * @generated
	 */
	////{PROTECTED REGION END////}
	public void setFlagBloccoGraduatoriaMaterne( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.Boolean value //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException; //NOSONAR  Reason:EIAS

	////{PROTECTED REGION ID(R-1865011677) ENABLED START////}
	/**
	 * Inserire qui la documentazione del metodo getTestataDomandaAccettazioneMaterne.
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
	
	 * @param idDomanda [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @param cfRichiedente [documentazione del parametro (vedere sopra per consigli sulla documentazione)]
	
	 * @return it.csi.iscritto.serviscritto.dto.domanda.TestataDomandaAccettazione
	 * @throws DomandaUserException
	 * @throws CSIException (eccezione base rilanciata dall'infrastruttura di cooperazione)
	 * @throws SystemException in caso di errore di sistema (connessione, comunicazione, ecc.)
	 * @throws UnrecoverableException in caso di errore imprevisto e non recuperabile
	 * @generated
	 */
	////{PROTECTED REGION END////}
	public it.csi.iscritto.serviscritto.dto.domanda.TestataDomandaAccettazione getTestataDomandaAccettazioneMaterne( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.Long idDomanda, //NOSONAR  Reason:EIAS

			java.lang.String cfRichiedente //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException; //NOSONAR  Reason:EIAS

	////{PROTECTED REGION ID(R-720783481) ENABLED START////}
	/**
	 * Inserire qui la documentazione del metodo getReportDomandeScuolaResidenza.
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
	
	 * @return it.csi.iscritto.serviscritto.dto.domanda.RecordDomandeScuolaResidenza[]
	 * @throws DomandaUserException
	 * @throws CSIException (eccezione base rilanciata dall'infrastruttura di cooperazione)
	 * @throws SystemException in caso di errore di sistema (connessione, comunicazione, ecc.)
	 * @throws UnrecoverableException in caso di errore imprevisto e non recuperabile
	 * @generated
	 */
	////{PROTECTED REGION END////}
	public it.csi.iscritto.serviscritto.dto.domanda.RecordDomandeScuolaResidenza[] getReportDomandeScuolaResidenza( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException; //NOSONAR  Reason:EIAS

}
