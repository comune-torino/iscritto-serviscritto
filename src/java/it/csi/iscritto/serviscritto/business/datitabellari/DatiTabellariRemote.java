
package it.csi.iscritto.serviscritto.business.datitabellari;

import it.csi.iscritto.serviscritto.dto.datitabellari.*;

import it.csi.iscritto.serviscritto.exception.datitabellari.*;

/**
 * Interfaccia remota dell'EJB che implementa il servizio dati_tabellari.
 * @generated
 */
public interface DatiTabellariRemote extends javax.ejb.EJBObject {

	/**
	 * @generated
	 */
	public java.lang.String test( //NOSONAR  Reason:EIAS

			java.lang.String arg0 //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException, //NOSONAR  Reason:EIAS
			java.rmi.RemoteException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.datitabellari.DatiTabellariUserException;

}
