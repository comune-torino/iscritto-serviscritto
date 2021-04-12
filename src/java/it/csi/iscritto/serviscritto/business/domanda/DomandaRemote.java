
package it.csi.iscritto.serviscritto.business.domanda;

import it.csi.iscritto.serviscritto.dto.domanda.*;

import it.csi.iscritto.serviscritto.exception.domanda.*;

/**
 * Interfaccia remota dell'EJB che implementa il servizio domanda.
 * @generated
 */
public interface DomandaRemote extends javax.ejb.EJBObject {

	/**
	 * @generated
	 */
	public java.lang.Long[] getElencoDomandeNidi( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.String codiceFiscaleOperatore, //NOSONAR  Reason:EIAS

			java.lang.String codiceProfilo, //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CriterioRicerca criterioRicerca //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException, //NOSONAR  Reason:EIAS
			java.rmi.RemoteException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException

			, it.csi.iscritto.serviscritto.exception.domanda.InvalidFilterException;

	/**
	 * @generated
	 */
	public java.lang.Long[] getElencoDomandeMaterne( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.String codiceFiscaleOperatore, //NOSONAR  Reason:EIAS

			java.lang.String codiceProfilo, //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CriterioRicerca criterioRicerca //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException, //NOSONAR  Reason:EIAS
			java.rmi.RemoteException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException

			, it.csi.iscritto.serviscritto.exception.domanda.InvalidFilterException;

	/**
	 * @generated
	 */
	public it.csi.iscritto.serviscritto.dto.domanda.TestataDomanda getTestataDomanda( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.Long idDomanda, //NOSONAR  Reason:EIAS

			java.lang.String tipoTestata //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException, //NOSONAR  Reason:EIAS
			java.rmi.RemoteException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException;

	/**
	 * @generated
	 */
	public it.csi.iscritto.serviscritto.dto.domanda.Codifica[] getElencoStatiDomanda( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException, //NOSONAR  Reason:EIAS
			java.rmi.RemoteException //NOSONAR  Reason:EIAS
	;

	/**
	 * @generated
	 */
	public it.csi.iscritto.serviscritto.dto.domanda.DomandaNido getDomandaNido( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.Long idDomanda //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException, //NOSONAR  Reason:EIAS
			java.rmi.RemoteException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException;

	/**
	 * @generated
	 */
	public it.csi.iscritto.serviscritto.dto.domanda.DomandaMaterna getDomandaMaterna( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.Long idDomanda //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException, //NOSONAR  Reason:EIAS
			java.rmi.RemoteException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException;

	/**
	 * @generated
	 */
	public it.csi.iscritto.serviscritto.dto.domanda.DomandaNido insertDomandaNido( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.DomandaNido domandaNido //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException, //NOSONAR  Reason:EIAS
			java.rmi.RemoteException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException

			, it.csi.iscritto.serviscritto.exception.domanda.ValidationException;

	/**
	 * @generated
	 */
	public it.csi.iscritto.serviscritto.dto.domanda.DomandaMaterna insertDomandaMaterna( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.DomandaMaterna domandaMaterna //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException, //NOSONAR  Reason:EIAS
			java.rmi.RemoteException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException

			, it.csi.iscritto.serviscritto.exception.domanda.ValidationException;

	/**
	 * @generated
	 */
	public void checkDomandaNido( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.String codiceFiscaleRic, //NOSONAR  Reason:EIAS

			java.lang.String codiceFiscaleMin //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException, //NOSONAR  Reason:EIAS
			java.rmi.RemoteException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException

			, it.csi.iscritto.serviscritto.exception.domanda.ValidationException;

	/**
	 * @generated
	 */
	public void checkDomandaMaterna( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.String codiceFiscaleRic, //NOSONAR  Reason:EIAS

			java.lang.String codiceFiscaleMin //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException, //NOSONAR  Reason:EIAS
			java.rmi.RemoteException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException

			, it.csi.iscritto.serviscritto.exception.domanda.ValidationException;

	/**
	 * @generated
	 */
	public void deleteDomanda( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.Long idDomanda, //NOSONAR  Reason:EIAS

			java.lang.String cfOperatore //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException, //NOSONAR  Reason:EIAS
			java.rmi.RemoteException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException

			, it.csi.iscritto.serviscritto.exception.domanda.ValidationException;

	/**
	 * @generated
	 */
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
			it.csi.csi.wrapper.UnrecoverableException, //NOSONAR  Reason:EIAS
			java.rmi.RemoteException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException;

	/**
	 * @generated
	 */
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
			it.csi.csi.wrapper.UnrecoverableException, //NOSONAR  Reason:EIAS
			java.rmi.RemoteException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException;

	/**
	 * @generated
	 */
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
			it.csi.csi.wrapper.UnrecoverableException, //NOSONAR  Reason:EIAS
			java.rmi.RemoteException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException;

	/**
	 * @generated
	 */
	public java.lang.String invioDomandaNido( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.Long idDomanda //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException, //NOSONAR  Reason:EIAS
			java.rmi.RemoteException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException

			, it.csi.iscritto.serviscritto.exception.domanda.ValidationException;

	/**
	 * @generated
	 */
	public java.lang.String invioDomandaMaterna( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.Long idDomanda //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException, //NOSONAR  Reason:EIAS
			java.rmi.RemoteException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException

			, it.csi.iscritto.serviscritto.exception.domanda.ValidationException;

	/**
	 * @generated
	 */
	public it.csi.iscritto.serviscritto.dto.domanda.TestataDomandaIstruttoria[] getDomandeIstruttoriaNidi( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CriterioRicercaIstruttoria criterioRicerca, //NOSONAR  Reason:EIAS

			java.lang.String cfOperatore, //NOSONAR  Reason:EIAS

			java.lang.String codProfilo //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException, //NOSONAR  Reason:EIAS
			java.rmi.RemoteException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException

			, it.csi.iscritto.serviscritto.exception.domanda.InvalidFilterException;

	/**
	 * @generated
	 */
	public it.csi.iscritto.serviscritto.dto.domanda.TestataDomandaIstruttoria[] getDomandeIstruttoriaMaterne( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CriterioRicercaIstruttoria criterioRicerca, //NOSONAR  Reason:EIAS

			java.lang.String cfOperatore, //NOSONAR  Reason:EIAS

			java.lang.String codProfilo //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException, //NOSONAR  Reason:EIAS
			java.rmi.RemoteException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException

			, it.csi.iscritto.serviscritto.exception.domanda.InvalidFilterException;

	/**
	 * @generated
	 */
	public void insertLogErroreDomandaNido( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.String codiceFiscaleOperatore, //NOSONAR  Reason:EIAS

			java.lang.String dettaglioErrore, //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.DomandaNido domandaNido //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException, //NOSONAR  Reason:EIAS
			java.rmi.RemoteException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException;

	/**
	 * @generated
	 */
	public void insertLogErroreDomandaMaterna( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.String codiceFiscaleOperatore, //NOSONAR  Reason:EIAS

			java.lang.String dettaglioErrore, //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.DomandaMaterna domandaMaterna //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException, //NOSONAR  Reason:EIAS
			java.rmi.RemoteException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException;

	/**
	 * @generated
	 */
	public void checkIdDomanda( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.String codiceFiscaleRic, //NOSONAR  Reason:EIAS

			java.lang.Long idDomanda //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException, //NOSONAR  Reason:EIAS
			java.rmi.RemoteException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException

			, it.csi.iscritto.serviscritto.exception.domanda.ValidationException;

	/**
	 * @generated
	 */
	public void checkRichiedenteDomandaNido( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.String codiceFiscaleRic, //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.DomandaNido domandaNido //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException, //NOSONAR  Reason:EIAS
			java.rmi.RemoteException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException

			, it.csi.iscritto.serviscritto.exception.domanda.ValidationException;

	/**
	 * @generated
	 */
	public void checkRichiedenteDomandaMaterna( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.String codiceFiscaleRic, //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.DomandaMaterna domandaMaterna //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException, //NOSONAR  Reason:EIAS
			java.rmi.RemoteException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException

			, it.csi.iscritto.serviscritto.exception.domanda.ValidationException;

	/**
	 * @generated
	 */
	public it.csi.iscritto.serviscritto.dto.domanda.DatiCondizionePunteggio[] getStoricoCondizioniPunteggio( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.Long idDomanda, //NOSONAR  Reason:EIAS

			java.lang.String codCondizionePunteggio //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException, //NOSONAR  Reason:EIAS
			java.rmi.RemoteException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException;

	/**
	 * @generated
	 */
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
			it.csi.csi.wrapper.UnrecoverableException, //NOSONAR  Reason:EIAS
			java.rmi.RemoteException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException;

	/**
	 * @generated
	 */
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
			it.csi.csi.wrapper.UnrecoverableException, //NOSONAR  Reason:EIAS
			java.rmi.RemoteException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException;

	/**
	 * @generated
	 */
	public it.csi.iscritto.serviscritto.dto.domanda.InfoAllegatoSoggetto[] getInfoAllegatiDomanda( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.Long idDomanda, //NOSONAR  Reason:EIAS

			java.lang.String codCondizionePunteggio //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException, //NOSONAR  Reason:EIAS
			java.rmi.RemoteException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException;

	/**
	 * @generated
	 */
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
			it.csi.csi.wrapper.UnrecoverableException, //NOSONAR  Reason:EIAS
			java.rmi.RemoteException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException;

	/**
	 * @generated
	 */
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
			it.csi.csi.wrapper.UnrecoverableException, //NOSONAR  Reason:EIAS
			java.rmi.RemoteException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException;

	/**
	 * @generated
	 */
	public it.csi.iscritto.serviscritto.dto.domanda.InfoGenerali getInfoGeneraliNidi( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException, //NOSONAR  Reason:EIAS
			java.rmi.RemoteException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException;

	/**
	 * @generated
	 */
	public it.csi.iscritto.serviscritto.dto.domanda.InfoGenerali getInfoGeneraliMaterne( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException, //NOSONAR  Reason:EIAS
			java.rmi.RemoteException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException;

	/**
	 * @generated
	 */
	public it.csi.iscritto.serviscritto.dto.domanda.TestataDomandaDaVerificare[] getDomandeNidoDaVerificare( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.String codProfilo //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException, //NOSONAR  Reason:EIAS
			java.rmi.RemoteException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException;

	/**
	 * @generated
	 */
	public it.csi.iscritto.serviscritto.dto.domanda.TestataDomandaDaVerificare[] getDomandeMaternaDaVerificare( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.String codProfilo //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException, //NOSONAR  Reason:EIAS
			java.rmi.RemoteException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException;

	/**
	 * @generated
	 */
	public it.csi.iscritto.serviscritto.dto.domanda.Nido[] getElencoNidi( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.Long idDomanda //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException, //NOSONAR  Reason:EIAS
			java.rmi.RemoteException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException;

	/**
	 * @generated
	 */
	public it.csi.iscritto.serviscritto.dto.domanda.Materna[] getElencoMaterne( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.Long idDomanda //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException, //NOSONAR  Reason:EIAS
			java.rmi.RemoteException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException;

	/**
	 * @generated
	 */
	public void modificaStatoNidi( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.Long idDomanda, //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.Nido[] elencoNidi //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException, //NOSONAR  Reason:EIAS
			java.rmi.RemoteException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException;

	/**
	 * @generated
	 */
	public void modificaStatoMaterne( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.Long idDomanda, //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.Materna[] elencoMaterne //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException, //NOSONAR  Reason:EIAS
			java.rmi.RemoteException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException;

	/**
	 * @generated
	 */
	public it.csi.iscritto.serviscritto.dto.domanda.TestataDomandaAccettazione getTestataDomandaAccettazione( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.Long idDomanda, //NOSONAR  Reason:EIAS

			java.lang.String cfRichiedente //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException, //NOSONAR  Reason:EIAS
			java.rmi.RemoteException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException;

	/**
	 * @generated
	 */
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
			it.csi.csi.wrapper.UnrecoverableException, //NOSONAR  Reason:EIAS
			java.rmi.RemoteException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException;

	/**
	 * @generated
	 */
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
			it.csi.csi.wrapper.UnrecoverableException, //NOSONAR  Reason:EIAS
			java.rmi.RemoteException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException;

	/**
	 * @generated
	 */
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
			it.csi.csi.wrapper.UnrecoverableException, //NOSONAR  Reason:EIAS
			java.rmi.RemoteException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException;

	/**
	 * @generated
	 */
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
			it.csi.csi.wrapper.UnrecoverableException, //NOSONAR  Reason:EIAS
			java.rmi.RemoteException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException;

	/**
	 * @generated
	 */
	public it.csi.iscritto.serviscritto.dto.domanda.ParametriGraduatoria getParametriUltimaGraduatoriaNidi( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException, //NOSONAR  Reason:EIAS
			java.rmi.RemoteException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException;

	/**
	 * @generated
	 */
	public it.csi.iscritto.serviscritto.dto.domanda.ParametriGraduatoria getParametriUltimaGraduatoriaMaterne( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException, //NOSONAR  Reason:EIAS
			java.rmi.RemoteException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException;

	/**
	 * @generated
	 */
	public it.csi.iscritto.serviscritto.dto.domanda.Graduatoria[] getElencoGraduatorieNidi( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException, //NOSONAR  Reason:EIAS
			java.rmi.RemoteException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException;

	/**
	 * @generated
	 */
	public it.csi.iscritto.serviscritto.dto.domanda.Graduatoria[] getElencoGraduatorieMaterne( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException, //NOSONAR  Reason:EIAS
			java.rmi.RemoteException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException;

	/**
	 * @generated
	 */
	public it.csi.iscritto.serviscritto.dto.domanda.StepGraduatoria[] getElencoStepGraduatoriaNidi( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.String codiceGraduatoria //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException, //NOSONAR  Reason:EIAS
			java.rmi.RemoteException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException;

	/**
	 * @generated
	 */
	public it.csi.iscritto.serviscritto.dto.domanda.StepGraduatoria[] getElencoStepGraduatoriaMaterne( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.String codiceGraduatoria //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException, //NOSONAR  Reason:EIAS
			java.rmi.RemoteException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException;

	/**
	 * @generated
	 */
	public it.csi.iscritto.serviscritto.dto.domanda.TestataGraduatoria[] ricercaGraduatoria( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.RicercaGraduatorieFilter filtroRicerca //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException, //NOSONAR  Reason:EIAS
			java.rmi.RemoteException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException;

	/**
	 * @generated
	 */
	public it.csi.iscritto.serviscritto.dto.domanda.ParametriGraduatoria getParametriGraduatoriaNidi( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.String codGraduatoria //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException, //NOSONAR  Reason:EIAS
			java.rmi.RemoteException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException;

	/**
	 * @generated
	 */
	public it.csi.iscritto.serviscritto.dto.domanda.ParametriGraduatoria getParametriGraduatoriaMaterne( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.String codGraduatoria //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException, //NOSONAR  Reason:EIAS
			java.rmi.RemoteException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException;

	/**
	 * @generated
	 */
	public java.lang.Long[] getDomandeNidoNonIstruite( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException, //NOSONAR  Reason:EIAS
			java.rmi.RemoteException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException;

	/**
	 * @generated
	 */
	public java.lang.Long[] getDomandeMaternaNonIstruite( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException, //NOSONAR  Reason:EIAS
			java.rmi.RemoteException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException;

	/**
	 * @generated
	 */
	public it.csi.iscritto.serviscritto.dto.domanda.InfoVerifiche[] getVerifichePreventivePendenti( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.Long[] idDomande //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException, //NOSONAR  Reason:EIAS
			java.rmi.RemoteException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException;

	/**
	 * @generated
	 */
	public void calcolaGraduatoria( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.ParametriCalcoloGraduatoria parametri //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException, //NOSONAR  Reason:EIAS
			java.rmi.RemoteException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException;

	/**
	 * @generated
	 */
	public it.csi.iscritto.serviscritto.dto.domanda.AnnoScolastico[] getElencoAnniScolastici( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException, //NOSONAR  Reason:EIAS
			java.rmi.RemoteException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException;

	/**
	 * @generated
	 */
	public it.csi.iscritto.serviscritto.dto.domanda.Classe[] getElencoClassiNido( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.String codScuola, //NOSONAR  Reason:EIAS

			java.lang.String codAnnoScolastico //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException, //NOSONAR  Reason:EIAS
			java.rmi.RemoteException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException;

	/**
	 * @generated
	 */
	public it.csi.iscritto.serviscritto.dto.domanda.Classe[] getElencoClassiMaterna( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.String codScuola, //NOSONAR  Reason:EIAS

			java.lang.String codAnnoScolastico //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException, //NOSONAR  Reason:EIAS
			java.rmi.RemoteException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException;

	/**
	 * @generated
	 */
	public java.lang.Long insertClasseNido( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.ClasseParam classe //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException, //NOSONAR  Reason:EIAS
			java.rmi.RemoteException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException;

	/**
	 * @generated
	 */
	public java.lang.Long insertClasseMaterna( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.ClasseParam classe //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException, //NOSONAR  Reason:EIAS
			java.rmi.RemoteException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException;

	/**
	 * @generated
	 */
	public java.lang.Integer updateClasseNido( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.ClasseParam classe //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException, //NOSONAR  Reason:EIAS
			java.rmi.RemoteException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException;

	/**
	 * @generated
	 */
	public java.lang.Integer updateClasseMaterna( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.ClasseParam classe //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException, //NOSONAR  Reason:EIAS
			java.rmi.RemoteException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException;

	/**
	 * @generated
	 */
	public java.lang.Integer deleteClasseNido( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.Long idClasse //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException, //NOSONAR  Reason:EIAS
			java.rmi.RemoteException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException;

	/**
	 * @generated
	 */
	public java.lang.Integer deleteClasseMaterna( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.Long idClasse //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException, //NOSONAR  Reason:EIAS
			java.rmi.RemoteException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException;

	/**
	 * @generated
	 */
	public it.csi.iscritto.serviscritto.dto.domanda.Nido[] getElencoNidiDse( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.Long idDomanda //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException, //NOSONAR  Reason:EIAS
			java.rmi.RemoteException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException;

	/**
	 * @generated
	 */
	public it.csi.iscritto.serviscritto.dto.domanda.Materna[] getElencoMaterneDse( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.Long idDomanda //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException, //NOSONAR  Reason:EIAS
			java.rmi.RemoteException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException;

	/**
	 * @generated
	 */
	public it.csi.iscritto.serviscritto.dto.domanda.InfoResidenzeForzate getResidenzeForzateNidi( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException, //NOSONAR  Reason:EIAS
			java.rmi.RemoteException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException;

	/**
	 * @generated
	 */
	public it.csi.iscritto.serviscritto.dto.domanda.InfoResidenzeForzate getResidenzeForzateMaterne( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException, //NOSONAR  Reason:EIAS
			java.rmi.RemoteException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException;

	/**
	 * @generated
	 */
	public it.csi.iscritto.serviscritto.dto.domanda.GraduatoriaCompleta[] getGraduatoriaCompletaNidi( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException, //NOSONAR  Reason:EIAS
			java.rmi.RemoteException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException;

	/**
	 * @generated
	 */
	public it.csi.iscritto.serviscritto.dto.domanda.GraduatoriaCompleta[] getGraduatoriaCompletaMaterne( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException, //NOSONAR  Reason:EIAS
			java.rmi.RemoteException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException;

	/**
	 * @generated
	 */
	public java.lang.Integer updateFlagAmmissioni( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.Long[] idClasseList, //NOSONAR  Reason:EIAS

			java.lang.Boolean value //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException, //NOSONAR  Reason:EIAS
			java.rmi.RemoteException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException;

	/**
	 * @generated
	 */
	public it.csi.iscritto.serviscritto.dto.domanda.InfoStepGraduatoria[] getInfoStepGraduatorieNido( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException, //NOSONAR  Reason:EIAS
			java.rmi.RemoteException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException;

	/**
	 * @generated
	 */
	public it.csi.iscritto.serviscritto.dto.domanda.InfoStepGraduatoria[] getInfoStepGraduatorieMaterna( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException, //NOSONAR  Reason:EIAS
			java.rmi.RemoteException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException;

	/**
	 * @generated
	 */
	public it.csi.iscritto.serviscritto.dto.domanda.GraduatoriaApprovazione[] getGraduatoriaApprovazioneNidi( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.String codiceGraduatoria, //NOSONAR  Reason:EIAS

			java.lang.Integer step, //NOSONAR  Reason:EIAS

			java.lang.String codiceStatoGraduatoria //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException, //NOSONAR  Reason:EIAS
			java.rmi.RemoteException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException;

	/**
	 * @generated
	 */
	public it.csi.iscritto.serviscritto.dto.domanda.GraduatoriaApprovazione[] getGraduatoriaApprovazioneMaterne( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.String codiceGraduatoria, //NOSONAR  Reason:EIAS

			java.lang.Integer step, //NOSONAR  Reason:EIAS

			java.lang.String codiceStatoGraduatoria //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException, //NOSONAR  Reason:EIAS
			java.rmi.RemoteException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException;

	/**
	 * @generated
	 */
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
			it.csi.csi.wrapper.UnrecoverableException, //NOSONAR  Reason:EIAS
			java.rmi.RemoteException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException;

	/**
	 * @generated
	 */
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
			it.csi.csi.wrapper.UnrecoverableException, //NOSONAR  Reason:EIAS
			java.rmi.RemoteException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException;

	/**
	 * @generated
	 */
	public it.csi.iscritto.serviscritto.dto.domanda.RicevutaAllegato generaRicevuta( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.Long idAllegato //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException, //NOSONAR  Reason:EIAS
			java.rmi.RemoteException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException;

	/**
	 * @generated
	 */
	public it.csi.iscritto.serviscritto.dto.domanda.RicevutaAccettazione generaRicevutaAccettazione( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.Long idDomanda, //NOSONAR  Reason:EIAS

			java.lang.String cfRichiedente //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException, //NOSONAR  Reason:EIAS
			java.rmi.RemoteException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException;

	/**
	 * @generated
	 */
	public it.csi.iscritto.serviscritto.dto.domanda.FasciaEta[] getFasceEta( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException, //NOSONAR  Reason:EIAS
			java.rmi.RemoteException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException;

	/**
	 * @generated
	 */
	public it.csi.iscritto.serviscritto.dto.domanda.AnagraficaGraduatoria[] getAnagraficaGraduatorie( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException, //NOSONAR  Reason:EIAS
			java.rmi.RemoteException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException;

	/**
	 * @generated
	 */
	public it.csi.iscritto.serviscritto.dto.domanda.AnagraficaGraduatoria getAnagraficaGraduatoria( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.String codOrdineScuola, //NOSONAR  Reason:EIAS

			java.lang.String codAnagraficaGraduatoria, //NOSONAR  Reason:EIAS

			java.lang.String codAnnoScolastico //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException, //NOSONAR  Reason:EIAS
			java.rmi.RemoteException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException;

	/**
	 * @generated
	 */
	public java.lang.Long insertAnagraficaGraduatoria( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.AnagraficaGraduatoria anagraficaGraduatoria //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException, //NOSONAR  Reason:EIAS
			java.rmi.RemoteException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException;

	/**
	 * @generated
	 */
	public java.lang.Integer updateAnagraficaGraduatoria( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.AnagraficaGraduatoria anagraficaGraduatoria //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException, //NOSONAR  Reason:EIAS
			java.rmi.RemoteException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException;

	/**
	 * @generated
	 */
	public it.csi.iscritto.serviscritto.dto.domanda.AnagraficaStepGraduatoria[] getAnagraficaStepGraduatoria( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.String codOrdineScuola, //NOSONAR  Reason:EIAS

			java.lang.String codAnagraficaGraduatoria, //NOSONAR  Reason:EIAS

			java.lang.String codAnnoScolastico //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException, //NOSONAR  Reason:EIAS
			java.rmi.RemoteException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException;

	/**
	 * @generated
	 */
	public java.lang.Long insertAnagraficaStepGraduatoria( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.AnagraficaStepGraduatoria stepGraduatoria //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException, //NOSONAR  Reason:EIAS
			java.rmi.RemoteException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException;

	/**
	 * @generated
	 */
	public java.lang.Integer updateAnagraficaStepGraduatoria( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.AnagraficaStepGraduatoria stepGraduatoria //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException, //NOSONAR  Reason:EIAS
			java.rmi.RemoteException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException;

	/**
	 * @generated
	 */
	public java.lang.Integer deleteAnagraficaStepGraduatoria( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.Long idStepGra //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException, //NOSONAR  Reason:EIAS
			java.rmi.RemoteException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException;

	/**
	 * @generated
	 */
	public it.csi.iscritto.serviscritto.dto.domanda.AnagraficaEta[] getAnagraficaEta( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.String codOrdineScuola, //NOSONAR  Reason:EIAS

			java.lang.String codAnagraficaGraduatoria, //NOSONAR  Reason:EIAS

			java.lang.String codAnnoScolastico //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException, //NOSONAR  Reason:EIAS
			java.rmi.RemoteException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException;

	/**
	 * @generated
	 */
	public java.lang.Long insertAnagraficaEta( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.AnagraficaEta anagraficaEta //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException, //NOSONAR  Reason:EIAS
			java.rmi.RemoteException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException;

	/**
	 * @generated
	 */
	public java.lang.Integer updateAnagraficaEta( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.AnagraficaEta anagraficaEta //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException, //NOSONAR  Reason:EIAS
			java.rmi.RemoteException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException;

	/**
	 * @generated
	 */
	public java.lang.Integer deleteAnagraficaEta( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.Long idEta //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException, //NOSONAR  Reason:EIAS
			java.rmi.RemoteException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException;

	/**
	 * @generated
	 */
	public it.csi.iscritto.serviscritto.dto.domanda.TipoFasciaEta[] getTipiFasceEta( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException, //NOSONAR  Reason:EIAS
			java.rmi.RemoteException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException;

	/**
	 * @generated
	 */
	public it.csi.iscritto.serviscritto.dto.domanda.RecordPostiLiberi[] getReportPostiLiberi( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.String codOrdineScuola //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException, //NOSONAR  Reason:EIAS
			java.rmi.RemoteException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException;

	/**
	 * @generated
	 */
	public it.csi.iscritto.serviscritto.dto.domanda.Result modificaStatoScuolaPreferenza( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.Long idGraduatoria, //NOSONAR  Reason:EIAS

			java.lang.Long idStatoAttuale, //NOSONAR  Reason:EIAS

			java.lang.Long idStatoRipristino //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException, //NOSONAR  Reason:EIAS
			java.rmi.RemoteException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException;

	/**
	 * @generated
	 */
	public it.csi.iscritto.serviscritto.dto.domanda.RecordPreferenzaScuola[] getPreferenzeScuole( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.Long idAnagraficaGra, //NOSONAR  Reason:EIAS

			java.lang.Long idDomanda //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException, //NOSONAR  Reason:EIAS
			java.rmi.RemoteException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException;

	/**
	 * @generated
	 */
	public java.lang.Boolean getFlagBloccoGraduatoriaNidi( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException, //NOSONAR  Reason:EIAS
			java.rmi.RemoteException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException;

	/**
	 * @generated
	 */
	public void setFlagBloccoGraduatoriaNidi( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.Boolean value //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException, //NOSONAR  Reason:EIAS
			java.rmi.RemoteException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException;

	/**
	 * @generated
	 */
	public java.lang.Boolean getFlagBloccoGraduatoriaMaterne( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException, //NOSONAR  Reason:EIAS
			java.rmi.RemoteException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException;

	/**
	 * @generated
	 */
	public void setFlagBloccoGraduatoriaMaterne( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.Boolean value //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException, //NOSONAR  Reason:EIAS
			java.rmi.RemoteException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException;

	/**
	 * @generated
	 */
	public it.csi.iscritto.serviscritto.dto.domanda.TestataDomandaAccettazione getTestataDomandaAccettazioneMaterne( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.Long idDomanda, //NOSONAR  Reason:EIAS

			java.lang.String cfRichiedente //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException, //NOSONAR  Reason:EIAS
			java.rmi.RemoteException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException;

	/**
	 * @generated
	 */
	public it.csi.iscritto.serviscritto.dto.domanda.RecordDomandeScuolaResidenza[] getReportDomandeScuolaResidenza( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException, //NOSONAR  Reason:EIAS
			java.rmi.RemoteException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException;

}
