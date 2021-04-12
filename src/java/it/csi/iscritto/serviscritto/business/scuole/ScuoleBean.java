
package it.csi.iscritto.serviscritto.business.scuole;

import it.csi.csi.wrapper.CSIException;
import it.csi.csi.wrapper.SystemException;
import it.csi.csi.wrapper.UnrecoverableException;

import it.csi.iscritto.serviscritto.dto.scuole.*;

import it.csi.iscritto.serviscritto.interfacecsi.scuole.*;

import it.csi.iscritto.serviscritto.exception.scuole.*;

import it.csi.iscritto.serviscritto.business.scuole.spring.SpringBeanLocator;

import java.rmi.RemoteException;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import org.apache.log4j.*;

/**
 * @generated
 */
public class ScuoleBean implements SessionBean {

	// business delegate contenente le implementazioni del servizio
	/**
	 * @generated
	 */
	protected ScuoleImpl delegate = null;

	/**
	 * @generated
	 */
	public static final String LOGGER_PREFIX = "serviscritto";
	public static final Logger logger = Logger.getLogger(LOGGER_PREFIX);

	/// Operazioni esposte dal servizio

	/**
	 * @generated
	 */
	public it.csi.iscritto.serviscritto.dto.scuole.Scuola[] getElencoScuole( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.scuole.CriterioRicerca criterioRicerca //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.scuole.ScuoleUserException

	{ //NOSONAR  Reason:EIAS
		try {

			logger.debug("[ScuoleBean::getElencoScuole()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
			// inizio misurazione
			watcher.start();

			it.csi.iscritto.serviscritto.dto.scuole.Scuola[] valueObjRet = delegate.getElencoScuole(

					criterioRicerca

			);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("ScuoleBean", "getElencoScuole()", "invocazione servizio [scuole]::[getElencoScuole]",
					"(valore input omesso)");
			logger.debug("[ScuoleBean::getElencoScuole()] - END");

			return valueObjRet;

		} catch (CSIException e) {

			throw e;
		} catch (Exception e) {

			throw new UnrecoverableException("Errore non recuperabile durante l'esecuzione del metodo:" + e, e);
		}
	}

	/**
	 * @generated
	 */
	public java.lang.String getCodAnnoNidi( //NOSONAR  Reason:EIAS

			java.util.Date data //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.scuole.ScuoleUserException

	{ //NOSONAR  Reason:EIAS
		try {

			logger.debug("[ScuoleBean::getCodAnnoNidi()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
			// inizio misurazione
			watcher.start();

			java.lang.String valueObjRet = delegate.getCodAnnoNidi(

					data

			);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("ScuoleBean", "getCodAnnoNidi()", "invocazione servizio [scuole]::[getCodAnnoNidi]",
					"(valore input omesso)");
			logger.debug("[ScuoleBean::getCodAnnoNidi()] - END");

			return valueObjRet;

		} catch (CSIException e) {

			throw e;
		} catch (Exception e) {

			throw new UnrecoverableException("Errore non recuperabile durante l'esecuzione del metodo:" + e, e);
		}
	}

	/**
	 * @generated
	 */
	public java.lang.String[] getCodAnniMaterne( //NOSONAR  Reason:EIAS

			java.util.Date data //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.scuole.ScuoleUserException

	{ //NOSONAR  Reason:EIAS
		try {

			logger.debug("[ScuoleBean::getCodAnniMaterne()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
			// inizio misurazione
			watcher.start();

			java.lang.String[] valueObjRet = delegate.getCodAnniMaterne(

					data

			);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("ScuoleBean", "getCodAnniMaterne()",
					"invocazione servizio [scuole]::[getCodAnniMaterne]", "(valore input omesso)");
			logger.debug("[ScuoleBean::getCodAnniMaterne()] - END");

			return valueObjRet;

		} catch (CSIException e) {

			throw e;
		} catch (Exception e) {

			throw new UnrecoverableException("Errore non recuperabile durante l'esecuzione del metodo:" + e, e);
		}
	}

	/// lifecycle dell EJB

	/**
	 * @generated
	 */
	public void ejbActivate() throws EJBException, RemoteException {
		// TODO Auto-generated method stub

	}

	/**
	 * @generated
	 */
	public void ejbPassivate() throws EJBException, RemoteException {
		// TODO Auto-generated method stub

	}

	/**
	 * @generated
	 */
	public void ejbRemove() throws EJBException, RemoteException {
		// TODO Auto-generated method stub

	}

	/**
	 * @generated
	 */
	public void ejbCreate() {
	}

	/**
	 * @generated
	 */
	SessionContext ctx = null;

	/**
	 * @generated
	 */
	public void createImpl(Object initOptions) throws EJBException {
		Logger logger = getLogger(null);
		logger.debug("[ScuoleBean::createImpl] - START");
		try {
			delegate = (ScuoleImpl) SpringBeanLocator.getBean("scuoleImpl");
			delegate.init(initOptions);

		}

		catch (Exception ie) {
			logger.debug("[ScuoleBean::createImpl] - ERROR", ie);
			throw new EJBException(
					"Errore nella inizializzazione dell'implementazione del servizio scuole:" + ie.getMessage(), ie);
		} finally {
			logger.debug("[ScuoleBean::createImpl] - END");
		}
	}

	/**
	 * @generated
	 */
	public void setSessionContext(SessionContext ctx) throws EJBException, RemoteException {

		/// META-TODO: forse sarebbe opportuno accodare il nome del servizio al logger...
		Logger logger = getLogger(null);
		logger.debug("[ScuoleBean::setSessionContext] - START");
		this.ctx = ctx;
		// contiene eventuali oggetti inizializzati nella sezione seguente e che
		// devono essere passati all'oggetto delegate
		Object implInitOptions = null;

		/// Inizializzazione risorse
		/*PROTECTED REGION ID(R836543256) ENABLED START*/
		// inserire qui il codice di inziializzazione risorse:
		// non verr&agrave; cancellato dalle successive rignerazioni
		// esempio di cose da fare:
		// -- leggere environment entry o context jndi 
		// -- inizializzare datasource, altre risorse
		// -- inserire le options in 'implInitOptions': saranno poi 
		//    passate al metodo initImpl()
		// NOTA: il contenuto specifico dell'oggetto implInitOptions e'
		// specifico di ogni applicazione		
		/*PROTECTED REGION END*/
		/// creazione dell'implementazione
		createImpl(implInitOptions);
		logger.debug("[ScuoleBean::setSessionContext] - END");
	}

	/**
	 * @generated
	 */
	protected Logger getLogger(String subsystem) {
		if (subsystem != null)
			return Logger.getLogger(LOGGER_PREFIX + "." + subsystem);
		else
			return Logger.getLogger(LOGGER_PREFIX);
	}
}
