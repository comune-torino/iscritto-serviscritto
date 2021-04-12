
package it.csi.iscritto.serviscritto.business.profilazione;

import it.csi.csi.wrapper.CSIException;
import it.csi.csi.wrapper.SystemException;
import it.csi.csi.wrapper.UnrecoverableException;

import it.csi.iscritto.serviscritto.dto.profilazione.*;

import it.csi.iscritto.serviscritto.interfacecsi.profilazione.*;

import it.csi.iscritto.serviscritto.exception.profilazione.*;

import it.csi.iscritto.serviscritto.business.profilazione.spring.SpringBeanLocator;

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
public class ProfilazioneBean implements SessionBean {

	// business delegate contenente le implementazioni del servizio
	/**
	 * @generated
	 */
	protected ProfilazioneImpl delegate = null;

	/**
	 * @generated
	 */
	public static final String LOGGER_PREFIX = "serviscritto";
	public static final Logger logger = Logger.getLogger(LOGGER_PREFIX);

	/// Operazioni esposte dal servizio

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
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.profilazione.ProfilazioneException

	{ //NOSONAR  Reason:EIAS
		try {

			logger.debug("[ProfilazioneBean::getFunzioniAbilitateOperatore()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
			// inizio misurazione
			watcher.start();

			it.csi.iscritto.serviscritto.dto.profilazione.Funzione[] valueObjRet = delegate
					.getFunzioniAbilitateOperatore(

							codiceFiscale,

							codiceProfilo

			);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("ProfilazioneBean", "getFunzioniAbilitateOperatore()",
					"invocazione servizio [profilazione]::[getFunzioniAbilitateOperatore]", "(valore input omesso)");
			logger.debug("[ProfilazioneBean::getFunzioniAbilitateOperatore()] - END");

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
	public it.csi.iscritto.serviscritto.dto.profilazione.Attivita[] getAttivitaAbilitateOperatore( //NOSONAR  Reason:EIAS

			java.lang.String codiceFiscale, //NOSONAR  Reason:EIAS

			java.lang.String codiceProfilo, //NOSONAR  Reason:EIAS

			java.lang.String codiceFunzione //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.profilazione.ProfilazioneException

	{ //NOSONAR  Reason:EIAS
		try {

			logger.debug("[ProfilazioneBean::getAttivitaAbilitateOperatore()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
			// inizio misurazione
			watcher.start();

			it.csi.iscritto.serviscritto.dto.profilazione.Attivita[] valueObjRet = delegate
					.getAttivitaAbilitateOperatore(

							codiceFiscale,

							codiceProfilo,

							codiceFunzione

			);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("ProfilazioneBean", "getAttivitaAbilitateOperatore()",
					"invocazione servizio [profilazione]::[getAttivitaAbilitateOperatore]", "(valore input omesso)");
			logger.debug("[ProfilazioneBean::getAttivitaAbilitateOperatore()] - END");

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
	public it.csi.iscritto.serviscritto.dto.profilazione.PrivilegioOperatore[] getPrivilegiOperatore( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.profilazione.CallerInfoProfilazione callerInfo, //NOSONAR  Reason:EIAS

			java.lang.String codiceFiscale, //NOSONAR  Reason:EIAS

			java.lang.String codiceProfilo //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.profilazione.ProfilazioneException

	{ //NOSONAR  Reason:EIAS
		try {

			logger.debug("[ProfilazioneBean::getPrivilegiOperatore()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
			// inizio misurazione
			watcher.start();

			it.csi.iscritto.serviscritto.dto.profilazione.PrivilegioOperatore[] valueObjRet = delegate
					.getPrivilegiOperatore(

							callerInfo,

							codiceFiscale,

							codiceProfilo

			);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("ProfilazioneBean", "getPrivilegiOperatore()",
					"invocazione servizio [profilazione]::[getPrivilegiOperatore]", "(valore input omesso)");
			logger.debug("[ProfilazioneBean::getPrivilegiOperatore()] - END");

			return valueObjRet;

		} catch (CSIException e) {

			ctx.setRollbackOnly();

			throw e;
		} catch (Exception e) {

			ctx.setRollbackOnly();

			throw new UnrecoverableException("Errore non recuperabile durante l'esecuzione del metodo:" + e, e);
		}
	}

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
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.profilazione.ProfilazioneException

	{ //NOSONAR  Reason:EIAS
		try {

			logger.debug("[ProfilazioneBean::getOperatoreByCodiceFiscale()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
			// inizio misurazione
			watcher.start();

			it.csi.iscritto.serviscritto.dto.profilazione.Operatore valueObjRet = delegate.getOperatoreByCodiceFiscale(

					callerInfo,

					codiceFiscale

			);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("ProfilazioneBean", "getOperatoreByCodiceFiscale()",
					"invocazione servizio [profilazione]::[getOperatoreByCodiceFiscale]", "(valore input omesso)");
			logger.debug("[ProfilazioneBean::getOperatoreByCodiceFiscale()] - END");

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
	public it.csi.iscritto.serviscritto.dto.profilazione.Profilo[] getProfiliOperatore( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.profilazione.CallerInfoProfilazione callerInfo, //NOSONAR  Reason:EIAS

			java.lang.String codiceFiscale //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.profilazione.ProfilazioneException

	{ //NOSONAR  Reason:EIAS
		try {

			logger.debug("[ProfilazioneBean::getProfiliOperatore()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
			// inizio misurazione
			watcher.start();

			it.csi.iscritto.serviscritto.dto.profilazione.Profilo[] valueObjRet = delegate.getProfiliOperatore(

					callerInfo,

					codiceFiscale

			);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("ProfilazioneBean", "getProfiliOperatore()",
					"invocazione servizio [profilazione]::[getProfiliOperatore]", "(valore input omesso)");
			logger.debug("[ProfilazioneBean::getProfiliOperatore()] - END");

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

			, it.csi.iscritto.serviscritto.exception.profilazione.ProfilazioneException

	{ //NOSONAR  Reason:EIAS
		try {

			logger.debug("[ProfilazioneBean::getCondizioniPunteggioNidi()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
			// inizio misurazione
			watcher.start();

			it.csi.iscritto.serviscritto.dto.profilazione.CondizionePunteggio[] valueObjRet = delegate
					.getCondizioniPunteggioNidi(

							callerInfo,

							codiceFiscale,

							codiceProfilo,

							tipoIstruttoria

			);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("ProfilazioneBean", "getCondizioniPunteggioNidi()",
					"invocazione servizio [profilazione]::[getCondizioniPunteggioNidi]", "(valore input omesso)");
			logger.debug("[ProfilazioneBean::getCondizioniPunteggioNidi()] - END");

			return valueObjRet;

		} catch (CSIException e) {

			ctx.setRollbackOnly();

			throw e;
		} catch (Exception e) {

			ctx.setRollbackOnly();

			throw new UnrecoverableException("Errore non recuperabile durante l'esecuzione del metodo:" + e, e);
		}
	}

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
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.profilazione.ProfilazioneException

	{ //NOSONAR  Reason:EIAS
		try {

			logger.debug("[ProfilazioneBean::getCondizioniPunteggioMaterne()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
			// inizio misurazione
			watcher.start();

			it.csi.iscritto.serviscritto.dto.profilazione.CondizionePunteggio[] valueObjRet = delegate
					.getCondizioniPunteggioMaterne(

							callerInfo,

							codiceFiscale,

							codiceProfilo,

							tipoIstruttoria

			);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("ProfilazioneBean", "getCondizioniPunteggioMaterne()",
					"invocazione servizio [profilazione]::[getCondizioniPunteggioMaterne]", "(valore input omesso)");
			logger.debug("[ProfilazioneBean::getCondizioniPunteggioMaterne()] - END");

			return valueObjRet;

		} catch (CSIException e) {

			ctx.setRollbackOnly();

			throw e;
		} catch (Exception e) {

			ctx.setRollbackOnly();

			throw new UnrecoverableException("Errore non recuperabile durante l'esecuzione del metodo:" + e, e);
		}
	}

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
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.profilazione.ProfilazioneException

	{ //NOSONAR  Reason:EIAS
		try {

			logger.debug("[ProfilazioneBean::getAutorizzatoNidi()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
			// inizio misurazione
			watcher.start();

			boolean valueObjRet = delegate.getAutorizzatoNidi(

					callerInfo,

					codiceFiscale

			);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("ProfilazioneBean", "getAutorizzatoNidi()",
					"invocazione servizio [profilazione]::[getAutorizzatoNidi]", "(valore input omesso)");
			logger.debug("[ProfilazioneBean::getAutorizzatoNidi()] - END");

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
	public boolean getAutorizzatoMaterne( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.profilazione.CallerInfoProfilazione callerInfo, //NOSONAR  Reason:EIAS

			java.lang.String codiceFiscale //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.profilazione.ProfilazioneException

	{ //NOSONAR  Reason:EIAS
		try {

			logger.debug("[ProfilazioneBean::getAutorizzatoMaterne()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
			// inizio misurazione
			watcher.start();

			boolean valueObjRet = delegate.getAutorizzatoMaterne(

					callerInfo,

					codiceFiscale

			);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("ProfilazioneBean", "getAutorizzatoMaterne()",
					"invocazione servizio [profilazione]::[getAutorizzatoMaterne]", "(valore input omesso)");
			logger.debug("[ProfilazioneBean::getAutorizzatoMaterne()] - END");

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
		logger.debug("[ProfilazioneBean::createImpl] - START");
		try {
			delegate = (ProfilazioneImpl) SpringBeanLocator.getBean("profilazioneImpl");
			delegate.init(initOptions);
			delegate.setSessionContext(ctx);

		}

		catch (Exception ie) {
			logger.debug("[ProfilazioneBean::createImpl] - ERROR", ie);
			throw new EJBException(
					"Errore nella inizializzazione dell'implementazione del servizio profilazione:" + ie.getMessage(),
					ie);
		} finally {
			logger.debug("[ProfilazioneBean::createImpl] - END");
		}
	}

	/**
	 * @generated
	 */
	public void setSessionContext(SessionContext ctx) throws EJBException, RemoteException {

		/// META-TODO: forse sarebbe opportuno accodare il nome del servizio al logger...
		Logger logger = getLogger(null);
		logger.debug("[ProfilazioneBean::setSessionContext] - START");
		this.ctx = ctx;
		// contiene eventuali oggetti inizializzati nella sezione seguente e che
		// devono essere passati all'oggetto delegate
		Object implInitOptions = null;

		/// Inizializzazione risorse
		/*PROTECTED REGION ID(R-2089568825) ENABLED START*/
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
		logger.debug("[ProfilazioneBean::setSessionContext] - END");
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
