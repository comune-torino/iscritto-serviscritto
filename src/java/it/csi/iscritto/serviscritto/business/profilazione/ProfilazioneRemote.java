
package it.csi.iscritto.serviscritto.business.profilazione;

import it.csi.iscritto.serviscritto.dto.profilazione.*;

import it.csi.iscritto.serviscritto.exception.profilazione.*;

/**
 * Interfaccia remota dell'EJB che implementa il servizio profilazione.
 * @generated
 */
public interface ProfilazioneRemote extends javax.ejb.EJBObject {

	/**
	 * @generated
	 */
	public it.csi.iscritto.serviscritto.dto.profilazione.Funzione[] getFunzioniAbilitateOperatore( //NOSONAR  Reason:EIAS

			java.lang.String codiceFiscale, //NOSONAR  Reason:EIAS

			java.lang.String codiceProfilo //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException, //NOSONAR  Reason:EIAS
			java.rmi.RemoteException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.profilazione.ProfilazioneException;

	/**
	 * @generated
	 */
	public it.csi.iscritto.serviscritto.dto.profilazione.Attivita[] getAttivitaAbilitateOperatore( //NOSONAR  Reason:EIAS

			java.lang.String codiceFiscale, //NOSONAR  Reason:EIAS

			java.lang.String codiceProfilo, //NOSONAR  Reason:EIAS

			java.lang.String codiceFunzione //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException, //NOSONAR  Reason:EIAS
			java.rmi.RemoteException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.profilazione.ProfilazioneException;

	/**
	 * @generated
	 */
	public it.csi.iscritto.serviscritto.dto.profilazione.PrivilegioOperatore[] getPrivilegiOperatore( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.profilazione.CallerInfoProfilazione callerInfo, //NOSONAR  Reason:EIAS

			java.lang.String codiceFiscale, //NOSONAR  Reason:EIAS

			java.lang.String codiceProfilo //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException, //NOSONAR  Reason:EIAS
			java.rmi.RemoteException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.profilazione.ProfilazioneException;

	/**
	 * @generated
	 */
	public it.csi.iscritto.serviscritto.dto.profilazione.Operatore getOperatoreByCodiceFiscale( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.profilazione.CallerInfoProfilazione callerInfo, //NOSONAR  Reason:EIAS

			java.lang.String codiceFiscale //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException, //NOSONAR  Reason:EIAS
			java.rmi.RemoteException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.profilazione.ProfilazioneException;

	/**
	 * @generated
	 */
	public it.csi.iscritto.serviscritto.dto.profilazione.Profilo[] getProfiliOperatore( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.profilazione.CallerInfoProfilazione callerInfo, //NOSONAR  Reason:EIAS

			java.lang.String codiceFiscale //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException, //NOSONAR  Reason:EIAS
			java.rmi.RemoteException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.profilazione.ProfilazioneException;

	/**
	 * @generated
	 */
	public it.csi.iscritto.serviscritto.dto.profilazione.CondizionePunteggio[] getCondizioniPunteggioNidi( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.profilazione.CallerInfoProfilazione callerInfo, //NOSONAR  Reason:EIAS

			java.lang.String codiceFiscale, //NOSONAR  Reason:EIAS

			java.lang.String codiceProfilo, //NOSONAR  Reason:EIAS

			java.lang.String tipoIstruttoria //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException, //NOSONAR  Reason:EIAS
			java.rmi.RemoteException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.profilazione.ProfilazioneException;

	/**
	 * @generated
	 */
	public it.csi.iscritto.serviscritto.dto.profilazione.CondizionePunteggio[] getCondizioniPunteggioMaterne( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.profilazione.CallerInfoProfilazione callerInfo, //NOSONAR  Reason:EIAS

			java.lang.String codiceFiscale, //NOSONAR  Reason:EIAS

			java.lang.String codiceProfilo, //NOSONAR  Reason:EIAS

			java.lang.String tipoIstruttoria //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException, //NOSONAR  Reason:EIAS
			java.rmi.RemoteException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.profilazione.ProfilazioneException;

	/**
	 * @generated
	 */
	public boolean getAutorizzatoNidi( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.profilazione.CallerInfoProfilazione callerInfo, //NOSONAR  Reason:EIAS

			java.lang.String codiceFiscale //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException, //NOSONAR  Reason:EIAS
			java.rmi.RemoteException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.profilazione.ProfilazioneException;

	/**
	 * @generated
	 */
	public boolean getAutorizzatoMaterne( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.profilazione.CallerInfoProfilazione callerInfo, //NOSONAR  Reason:EIAS

			java.lang.String codiceFiscale //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException, //NOSONAR  Reason:EIAS
			java.rmi.RemoteException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.profilazione.ProfilazioneException;

}
