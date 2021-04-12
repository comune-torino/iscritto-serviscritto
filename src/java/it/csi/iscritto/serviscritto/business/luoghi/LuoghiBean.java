
package it.csi.iscritto.serviscritto.business.luoghi;

import it.csi.csi.wrapper.CSIException;
import it.csi.csi.wrapper.SystemException;
import it.csi.csi.wrapper.UnrecoverableException;

import it.csi.iscritto.serviscritto.dto.luoghi.*;

import it.csi.iscritto.serviscritto.interfacecsi.luoghi.*;

import it.csi.iscritto.serviscritto.exception.luoghi.*;

import it.csi.iscritto.serviscritto.business.luoghi.spring.SpringBeanLocator;

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
public class LuoghiBean implements SessionBean {

	// business delegate contenente le implementazioni del servizio
	/**
	 * @generated
	 */
	protected LuoghiImpl delegate = null;

	/**
	 * @generated
	 */
	public static final String LOGGER_PREFIX = "serviscritto";
	public static final Logger logger = Logger.getLogger(LOGGER_PREFIX);

	/// Operazioni esposte dal servizio

	/**
	 * @generated
	 */
	public it.csi.iscritto.serviscritto.dto.luoghi.Luogo[] findStatiAttiviAllaData( //NOSONAR  Reason:EIAS

			java.util.Date data //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.luoghi.LuoghiUserException

	{ //NOSONAR  Reason:EIAS
		try {

			logger.debug("[LuoghiBean::findStatiAttiviAllaData()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
			// inizio misurazione
			watcher.start();

			it.csi.iscritto.serviscritto.dto.luoghi.Luogo[] valueObjRet = delegate.findStatiAttiviAllaData(

					data

			);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("LuoghiBean", "findStatiAttiviAllaData()",
					"invocazione servizio [luoghi]::[findStatiAttiviAllaData]", "(valore input omesso)");
			logger.debug("[LuoghiBean::findStatiAttiviAllaData()] - END");

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
	public it.csi.iscritto.serviscritto.dto.luoghi.Luogo[] findRegioniAttiveAllaData( //NOSONAR  Reason:EIAS

			java.util.Date data //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.luoghi.LuoghiUserException

	{ //NOSONAR  Reason:EIAS
		try {

			logger.debug("[LuoghiBean::findRegioniAttiveAllaData()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
			// inizio misurazione
			watcher.start();

			it.csi.iscritto.serviscritto.dto.luoghi.Luogo[] valueObjRet = delegate.findRegioniAttiveAllaData(

					data

			);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("LuoghiBean", "findRegioniAttiveAllaData()",
					"invocazione servizio [luoghi]::[findRegioniAttiveAllaData]", "(valore input omesso)");
			logger.debug("[LuoghiBean::findRegioniAttiveAllaData()] - END");

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
	public it.csi.iscritto.serviscritto.dto.luoghi.Luogo[] findProvinceAttiveAllaData( //NOSONAR  Reason:EIAS

			java.util.Date data, //NOSONAR  Reason:EIAS

			java.lang.String istatRegione //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.luoghi.LuoghiUserException

	{ //NOSONAR  Reason:EIAS
		try {

			logger.debug("[LuoghiBean::findProvinceAttiveAllaData()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
			// inizio misurazione
			watcher.start();

			it.csi.iscritto.serviscritto.dto.luoghi.Luogo[] valueObjRet = delegate.findProvinceAttiveAllaData(

					data,

					istatRegione

			);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("LuoghiBean", "findProvinceAttiveAllaData()",
					"invocazione servizio [luoghi]::[findProvinceAttiveAllaData]", "(valore input omesso)");
			logger.debug("[LuoghiBean::findProvinceAttiveAllaData()] - END");

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
	public it.csi.iscritto.serviscritto.dto.luoghi.Luogo[] findComuniAttiviAllaData( //NOSONAR  Reason:EIAS

			java.util.Date data, //NOSONAR  Reason:EIAS

			java.lang.String istatProvincia //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.luoghi.LuoghiUserException

	{ //NOSONAR  Reason:EIAS
		try {

			logger.debug("[LuoghiBean::findComuniAttiviAllaData()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
			// inizio misurazione
			watcher.start();

			it.csi.iscritto.serviscritto.dto.luoghi.Luogo[] valueObjRet = delegate.findComuniAttiviAllaData(

					data,

					istatProvincia

			);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("LuoghiBean", "findComuniAttiviAllaData()",
					"invocazione servizio [luoghi]::[findComuniAttiviAllaData]", "(valore input omesso)");
			logger.debug("[LuoghiBean::findComuniAttiviAllaData()] - END");

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
	public it.csi.iscritto.serviscritto.dto.luoghi.Luogo[] findByIstatComuneAllaData( //NOSONAR  Reason:EIAS

			java.util.Date data, //NOSONAR  Reason:EIAS

			java.lang.String istatComune //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.luoghi.LuoghiUserException

	{ //NOSONAR  Reason:EIAS
		try {

			logger.debug("[LuoghiBean::findByIstatComuneAllaData()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
			// inizio misurazione
			watcher.start();

			it.csi.iscritto.serviscritto.dto.luoghi.Luogo[] valueObjRet = delegate.findByIstatComuneAllaData(

					data,

					istatComune

			);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("LuoghiBean", "findByIstatComuneAllaData()",
					"invocazione servizio [luoghi]::[findByIstatComuneAllaData]", "(valore input omesso)");
			logger.debug("[LuoghiBean::findByIstatComuneAllaData()] - END");

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
	public it.csi.iscritto.serviscritto.dto.luoghi.Luogo findByIstatStatoAllaData( //NOSONAR  Reason:EIAS

			java.util.Date data, //NOSONAR  Reason:EIAS

			java.lang.String istatStato //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.luoghi.LuoghiUserException

	{ //NOSONAR  Reason:EIAS
		try {

			logger.debug("[LuoghiBean::findByIstatStatoAllaData()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
			// inizio misurazione
			watcher.start();

			it.csi.iscritto.serviscritto.dto.luoghi.Luogo valueObjRet = delegate.findByIstatStatoAllaData(

					data,

					istatStato

			);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("LuoghiBean", "findByIstatStatoAllaData()",
					"invocazione servizio [luoghi]::[findByIstatStatoAllaData]", "(valore input omesso)");
			logger.debug("[LuoghiBean::findByIstatStatoAllaData()] - END");

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
		logger.debug("[LuoghiBean::createImpl] - START");
		try {
			delegate = (LuoghiImpl) SpringBeanLocator.getBean("luoghiImpl");
			delegate.init(initOptions);

		}

		catch (Exception ie) {
			logger.debug("[LuoghiBean::createImpl] - ERROR", ie);
			throw new EJBException(
					"Errore nella inizializzazione dell'implementazione del servizio luoghi:" + ie.getMessage(), ie);
		} finally {
			logger.debug("[LuoghiBean::createImpl] - END");
		}
	}

	/**
	 * @generated
	 */
	public void setSessionContext(SessionContext ctx) throws EJBException, RemoteException {

		/// META-TODO: forse sarebbe opportuno accodare il nome del servizio al logger...
		Logger logger = getLogger(null);
		logger.debug("[LuoghiBean::setSessionContext] - START");
		this.ctx = ctx;
		// contiene eventuali oggetti inizializzati nella sezione seguente e che
		// devono essere passati all'oggetto delegate
		Object implInitOptions = null;

		/// Inizializzazione risorse
		/*PROTECTED REGION ID(R652576023) ENABLED START*/
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
		logger.debug("[LuoghiBean::setSessionContext] - END");
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
