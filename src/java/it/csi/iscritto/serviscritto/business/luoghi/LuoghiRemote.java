
package it.csi.iscritto.serviscritto.business.luoghi;

import it.csi.iscritto.serviscritto.dto.luoghi.*;

import it.csi.iscritto.serviscritto.exception.luoghi.*;

/**
 * Interfaccia remota dell'EJB che implementa il servizio luoghi.
 * @generated
 */
public interface LuoghiRemote extends javax.ejb.EJBObject {

	/**
	 * @generated
	 */
	public it.csi.iscritto.serviscritto.dto.luoghi.Luogo[] findStatiAttiviAllaData( //NOSONAR  Reason:EIAS

			java.util.Date data //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException, //NOSONAR  Reason:EIAS
			java.rmi.RemoteException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.luoghi.LuoghiUserException;

	/**
	 * @generated
	 */
	public it.csi.iscritto.serviscritto.dto.luoghi.Luogo[] findRegioniAttiveAllaData( //NOSONAR  Reason:EIAS

			java.util.Date data //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException, //NOSONAR  Reason:EIAS
			java.rmi.RemoteException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.luoghi.LuoghiUserException;

	/**
	 * @generated
	 */
	public it.csi.iscritto.serviscritto.dto.luoghi.Luogo[] findProvinceAttiveAllaData( //NOSONAR  Reason:EIAS

			java.util.Date data, //NOSONAR  Reason:EIAS

			java.lang.String istatRegione //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException, //NOSONAR  Reason:EIAS
			java.rmi.RemoteException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.luoghi.LuoghiUserException;

	/**
	 * @generated
	 */
	public it.csi.iscritto.serviscritto.dto.luoghi.Luogo[] findComuniAttiviAllaData( //NOSONAR  Reason:EIAS

			java.util.Date data, //NOSONAR  Reason:EIAS

			java.lang.String istatProvincia //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException, //NOSONAR  Reason:EIAS
			java.rmi.RemoteException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.luoghi.LuoghiUserException;

	/**
	 * @generated
	 */
	public it.csi.iscritto.serviscritto.dto.luoghi.Luogo[] findByIstatComuneAllaData( //NOSONAR  Reason:EIAS

			java.util.Date data, //NOSONAR  Reason:EIAS

			java.lang.String istatComune //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException, //NOSONAR  Reason:EIAS
			java.rmi.RemoteException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.luoghi.LuoghiUserException;

	/**
	 * @generated
	 */
	public it.csi.iscritto.serviscritto.dto.luoghi.Luogo findByIstatStatoAllaData( //NOSONAR  Reason:EIAS

			java.util.Date data, //NOSONAR  Reason:EIAS

			java.lang.String istatStato //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException, //NOSONAR  Reason:EIAS
			java.rmi.RemoteException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.luoghi.LuoghiUserException;

}
