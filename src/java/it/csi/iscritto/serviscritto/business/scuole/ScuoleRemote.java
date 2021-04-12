
package it.csi.iscritto.serviscritto.business.scuole;

import it.csi.iscritto.serviscritto.dto.scuole.*;

import it.csi.iscritto.serviscritto.exception.scuole.*;

/**
 * Interfaccia remota dell'EJB che implementa il servizio scuole.
 * @generated
 */
public interface ScuoleRemote extends javax.ejb.EJBObject {

	/**
	 * @generated
	 */
	public it.csi.iscritto.serviscritto.dto.scuole.Scuola[] getElencoScuole( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.scuole.CriterioRicerca criterioRicerca //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException, //NOSONAR  Reason:EIAS
			java.rmi.RemoteException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.scuole.ScuoleUserException;

	/**
	 * @generated
	 */
	public java.lang.String getCodAnnoNidi( //NOSONAR  Reason:EIAS

			java.util.Date data //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException, //NOSONAR  Reason:EIAS
			java.rmi.RemoteException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.scuole.ScuoleUserException;

	/**
	 * @generated
	 */
	public java.lang.String[] getCodAnniMaterne( //NOSONAR  Reason:EIAS

			java.util.Date data //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException, //NOSONAR  Reason:EIAS
			java.rmi.RemoteException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.scuole.ScuoleUserException;

}
