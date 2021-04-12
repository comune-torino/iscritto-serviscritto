
package it.csi.iscritto.serviscritto.business.domanda;

import it.csi.csi.wrapper.CSIException;
import it.csi.csi.wrapper.SystemException;
import it.csi.csi.wrapper.UnrecoverableException;

import it.csi.iscritto.serviscritto.dto.domanda.*;

import it.csi.iscritto.serviscritto.interfacecsi.domanda.*;

import it.csi.iscritto.serviscritto.exception.domanda.*;

import it.csi.iscritto.serviscritto.business.domanda.spring.SpringBeanLocator;

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
public class DomandaBean implements SessionBean {

	// business delegate contenente le implementazioni del servizio
	/**
	 * @generated
	 */
	protected DomandaImpl delegate = null;

	/**
	 * @generated
	 */
	public static final String LOGGER_PREFIX = "serviscritto";
	public static final Logger logger = Logger.getLogger(LOGGER_PREFIX);

	/// Operazioni esposte dal servizio

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
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException

			, it.csi.iscritto.serviscritto.exception.domanda.InvalidFilterException

	{ //NOSONAR  Reason:EIAS
		try {

			logger.debug("[DomandaBean::getElencoDomandeNidi()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
			// inizio misurazione
			watcher.start();

			java.lang.Long[] valueObjRet = delegate.getElencoDomandeNidi(

					callerInfo,

					codiceFiscaleOperatore,

					codiceProfilo,

					criterioRicerca

			);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaBean", "getElencoDomandeNidi()",
					"invocazione servizio [domanda]::[getElencoDomandeNidi]", "(valore input omesso)");
			logger.debug("[DomandaBean::getElencoDomandeNidi()] - END");

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

			, it.csi.iscritto.serviscritto.exception.domanda.InvalidFilterException

	{ //NOSONAR  Reason:EIAS
		try {

			logger.debug("[DomandaBean::getElencoDomandeMaterne()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
			// inizio misurazione
			watcher.start();

			java.lang.Long[] valueObjRet = delegate.getElencoDomandeMaterne(

					callerInfo,

					codiceFiscaleOperatore,

					codiceProfilo,

					criterioRicerca

			);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaBean", "getElencoDomandeMaterne()",
					"invocazione servizio [domanda]::[getElencoDomandeMaterne]", "(valore input omesso)");
			logger.debug("[DomandaBean::getElencoDomandeMaterne()] - END");

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
	public it.csi.iscritto.serviscritto.dto.domanda.TestataDomanda getTestataDomanda( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.Long idDomanda, //NOSONAR  Reason:EIAS

			java.lang.String tipoTestata //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException

	{ //NOSONAR  Reason:EIAS
		try {

			logger.debug("[DomandaBean::getTestataDomanda()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
			// inizio misurazione
			watcher.start();

			it.csi.iscritto.serviscritto.dto.domanda.TestataDomanda valueObjRet = delegate.getTestataDomanda(

					callerInfo,

					idDomanda,

					tipoTestata

			);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaBean", "getTestataDomanda()",
					"invocazione servizio [domanda]::[getTestataDomanda]", "(valore input omesso)");
			logger.debug("[DomandaBean::getTestataDomanda()] - END");

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
	public it.csi.iscritto.serviscritto.dto.domanda.Codifica[] getElencoStatiDomanda( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

	{ //NOSONAR  Reason:EIAS
		try {

			logger.debug("[DomandaBean::getElencoStatiDomanda()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
			// inizio misurazione
			watcher.start();

			it.csi.iscritto.serviscritto.dto.domanda.Codifica[] valueObjRet = delegate.getElencoStatiDomanda(

					callerInfo

			);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaBean", "getElencoStatiDomanda()",
					"invocazione servizio [domanda]::[getElencoStatiDomanda]", "(valore input omesso)");
			logger.debug("[DomandaBean::getElencoStatiDomanda()] - END");

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
	public it.csi.iscritto.serviscritto.dto.domanda.DomandaNido getDomandaNido( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.Long idDomanda //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException

	{ //NOSONAR  Reason:EIAS
		try {

			logger.debug("[DomandaBean::getDomandaNido()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
			// inizio misurazione
			watcher.start();

			it.csi.iscritto.serviscritto.dto.domanda.DomandaNido valueObjRet = delegate.getDomandaNido(

					callerInfo,

					idDomanda

			);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaBean", "getDomandaNido()", "invocazione servizio [domanda]::[getDomandaNido]",
					"(valore input omesso)");
			logger.debug("[DomandaBean::getDomandaNido()] - END");

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
	public it.csi.iscritto.serviscritto.dto.domanda.DomandaMaterna getDomandaMaterna( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.Long idDomanda //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException

	{ //NOSONAR  Reason:EIAS
		try {

			logger.debug("[DomandaBean::getDomandaMaterna()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
			// inizio misurazione
			watcher.start();

			it.csi.iscritto.serviscritto.dto.domanda.DomandaMaterna valueObjRet = delegate.getDomandaMaterna(

					callerInfo,

					idDomanda

			);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaBean", "getDomandaMaterna()",
					"invocazione servizio [domanda]::[getDomandaMaterna]", "(valore input omesso)");
			logger.debug("[DomandaBean::getDomandaMaterna()] - END");

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
	public it.csi.iscritto.serviscritto.dto.domanda.DomandaNido insertDomandaNido( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.DomandaNido domandaNido //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException

			, it.csi.iscritto.serviscritto.exception.domanda.ValidationException

	{ //NOSONAR  Reason:EIAS
		try {

			logger.debug("[DomandaBean::insertDomandaNido()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
			// inizio misurazione
			watcher.start();

			it.csi.iscritto.serviscritto.dto.domanda.DomandaNido valueObjRet = delegate.insertDomandaNido(

					callerInfo,

					domandaNido

			);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaBean", "insertDomandaNido()",
					"invocazione servizio [domanda]::[insertDomandaNido]", "(valore input omesso)");
			logger.debug("[DomandaBean::insertDomandaNido()] - END");

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
	public it.csi.iscritto.serviscritto.dto.domanda.DomandaMaterna insertDomandaMaterna( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.DomandaMaterna domandaMaterna //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException

			, it.csi.iscritto.serviscritto.exception.domanda.ValidationException

	{ //NOSONAR  Reason:EIAS
		try {

			logger.debug("[DomandaBean::insertDomandaMaterna()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
			// inizio misurazione
			watcher.start();

			it.csi.iscritto.serviscritto.dto.domanda.DomandaMaterna valueObjRet = delegate.insertDomandaMaterna(

					callerInfo,

					domandaMaterna

			);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaBean", "insertDomandaMaterna()",
					"invocazione servizio [domanda]::[insertDomandaMaterna]", "(valore input omesso)");
			logger.debug("[DomandaBean::insertDomandaMaterna()] - END");

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

			, it.csi.iscritto.serviscritto.exception.domanda.ValidationException

	{ //NOSONAR  Reason:EIAS
		try {

			logger.debug("[DomandaBean::checkDomandaNido()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
			// inizio misurazione
			watcher.start();

			delegate.checkDomandaNido(

					callerInfo,

					codiceFiscaleRic,

					codiceFiscaleMin

			);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaBean", "checkDomandaNido()",
					"invocazione servizio [domanda]::[checkDomandaNido]", "(valore input omesso)");
			logger.debug("[DomandaBean::checkDomandaNido()] - END");

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

			, it.csi.iscritto.serviscritto.exception.domanda.ValidationException

	{ //NOSONAR  Reason:EIAS
		try {

			logger.debug("[DomandaBean::checkDomandaMaterna()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
			// inizio misurazione
			watcher.start();

			delegate.checkDomandaMaterna(

					callerInfo,

					codiceFiscaleRic,

					codiceFiscaleMin

			);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaBean", "checkDomandaMaterna()",
					"invocazione servizio [domanda]::[checkDomandaMaterna]", "(valore input omesso)");
			logger.debug("[DomandaBean::checkDomandaMaterna()] - END");

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

			, it.csi.iscritto.serviscritto.exception.domanda.ValidationException

	{ //NOSONAR  Reason:EIAS
		try {

			logger.debug("[DomandaBean::deleteDomanda()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
			// inizio misurazione
			watcher.start();

			delegate.deleteDomanda(

					callerInfo,

					idDomanda,

					cfOperatore

			);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaBean", "deleteDomanda()", "invocazione servizio [domanda]::[deleteDomanda]",
					"(valore input omesso)");
			logger.debug("[DomandaBean::deleteDomanda()] - END");

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

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException

	{ //NOSONAR  Reason:EIAS
		try {

			logger.debug("[DomandaBean::getAllegato()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
			// inizio misurazione
			watcher.start();

			it.csi.iscritto.serviscritto.dto.domanda.Allegato valueObjRet = delegate.getAllegato(

					callerInfo,

					cfRichiedente,

					idDomanda,

					idAllegato,

					withContent

			);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaBean", "getAllegato()", "invocazione servizio [domanda]::[getAllegato]",
					"(valore input omesso)");
			logger.debug("[DomandaBean::getAllegato()] - END");

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

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException

	{ //NOSONAR  Reason:EIAS
		try {

			logger.debug("[DomandaBean::deleteAllegato()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
			// inizio misurazione
			watcher.start();

			java.lang.Integer valueObjRet = delegate.deleteAllegato(

					callerInfo,

					cfRichiedente,

					cfOperatore,

					idDomanda,

					idAllegato

			);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaBean", "deleteAllegato()", "invocazione servizio [domanda]::[deleteAllegato]",
					"(valore input omesso)");
			logger.debug("[DomandaBean::deleteAllegato()] - END");

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

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException

	{ //NOSONAR  Reason:EIAS
		try {

			logger.debug("[DomandaBean::insertAllegatoList()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
			// inizio misurazione
			watcher.start();

			java.lang.Long[] valueObjRet = delegate.insertAllegatoList(

					callerInfo,

					cfRichiedente,

					cfOperatore,

					idDomanda,

					allegatoList

			);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaBean", "insertAllegatoList()",
					"invocazione servizio [domanda]::[insertAllegatoList]", "(valore input omesso)");
			logger.debug("[DomandaBean::insertAllegatoList()] - END");

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
	public java.lang.String invioDomandaNido( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.Long idDomanda //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException

			, it.csi.iscritto.serviscritto.exception.domanda.ValidationException

	{ //NOSONAR  Reason:EIAS
		try {

			logger.debug("[DomandaBean::invioDomandaNido()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
			// inizio misurazione
			watcher.start();

			java.lang.String valueObjRet = delegate.invioDomandaNido(

					callerInfo,

					idDomanda

			);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaBean", "invioDomandaNido()",
					"invocazione servizio [domanda]::[invioDomandaNido]", "(valore input omesso)");
			logger.debug("[DomandaBean::invioDomandaNido()] - END");

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
	public java.lang.String invioDomandaMaterna( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.Long idDomanda //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException

			, it.csi.iscritto.serviscritto.exception.domanda.ValidationException

	{ //NOSONAR  Reason:EIAS
		try {

			logger.debug("[DomandaBean::invioDomandaMaterna()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
			// inizio misurazione
			watcher.start();

			java.lang.String valueObjRet = delegate.invioDomandaMaterna(

					callerInfo,

					idDomanda

			);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaBean", "invioDomandaMaterna()",
					"invocazione servizio [domanda]::[invioDomandaMaterna]", "(valore input omesso)");
			logger.debug("[DomandaBean::invioDomandaMaterna()] - END");

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

			, it.csi.iscritto.serviscritto.exception.domanda.InvalidFilterException

	{ //NOSONAR  Reason:EIAS
		try {

			logger.debug("[DomandaBean::getDomandeIstruttoriaNidi()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
			// inizio misurazione
			watcher.start();

			it.csi.iscritto.serviscritto.dto.domanda.TestataDomandaIstruttoria[] valueObjRet = delegate
					.getDomandeIstruttoriaNidi(

							callerInfo,

							criterioRicerca,

							cfOperatore,

							codProfilo

			);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaBean", "getDomandeIstruttoriaNidi()",
					"invocazione servizio [domanda]::[getDomandeIstruttoriaNidi]", "(valore input omesso)");
			logger.debug("[DomandaBean::getDomandeIstruttoriaNidi()] - END");

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

			, it.csi.iscritto.serviscritto.exception.domanda.InvalidFilterException

	{ //NOSONAR  Reason:EIAS
		try {

			logger.debug("[DomandaBean::getDomandeIstruttoriaMaterne()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
			// inizio misurazione
			watcher.start();

			it.csi.iscritto.serviscritto.dto.domanda.TestataDomandaIstruttoria[] valueObjRet = delegate
					.getDomandeIstruttoriaMaterne(

							callerInfo,

							criterioRicerca,

							cfOperatore,

							codProfilo

			);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaBean", "getDomandeIstruttoriaMaterne()",
					"invocazione servizio [domanda]::[getDomandeIstruttoriaMaterne]", "(valore input omesso)");
			logger.debug("[DomandaBean::getDomandeIstruttoriaMaterne()] - END");

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

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException

	{ //NOSONAR  Reason:EIAS
		try {

			logger.debug("[DomandaBean::insertLogErroreDomandaNido()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
			// inizio misurazione
			watcher.start();

			delegate.insertLogErroreDomandaNido(

					callerInfo,

					codiceFiscaleOperatore,

					dettaglioErrore,

					domandaNido

			);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaBean", "insertLogErroreDomandaNido()",
					"invocazione servizio [domanda]::[insertLogErroreDomandaNido]", "(valore input omesso)");
			logger.debug("[DomandaBean::insertLogErroreDomandaNido()] - END");

		} catch (CSIException e) {

			throw e;
		} catch (Exception e) {

			throw new UnrecoverableException("Errore non recuperabile durante l'esecuzione del metodo:" + e, e);
		}
	}

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
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException

	{ //NOSONAR  Reason:EIAS
		try {

			logger.debug("[DomandaBean::insertLogErroreDomandaMaterna()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
			// inizio misurazione
			watcher.start();

			delegate.insertLogErroreDomandaMaterna(

					callerInfo,

					codiceFiscaleOperatore,

					dettaglioErrore,

					domandaMaterna

			);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaBean", "insertLogErroreDomandaMaterna()",
					"invocazione servizio [domanda]::[insertLogErroreDomandaMaterna]", "(valore input omesso)");
			logger.debug("[DomandaBean::insertLogErroreDomandaMaterna()] - END");

		} catch (CSIException e) {

			throw e;
		} catch (Exception e) {

			throw new UnrecoverableException("Errore non recuperabile durante l'esecuzione del metodo:" + e, e);
		}
	}

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
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException

			, it.csi.iscritto.serviscritto.exception.domanda.ValidationException

	{ //NOSONAR  Reason:EIAS
		try {

			logger.debug("[DomandaBean::checkIdDomanda()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
			// inizio misurazione
			watcher.start();

			delegate.checkIdDomanda(

					callerInfo,

					codiceFiscaleRic,

					idDomanda

			);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaBean", "checkIdDomanda()", "invocazione servizio [domanda]::[checkIdDomanda]",
					"(valore input omesso)");
			logger.debug("[DomandaBean::checkIdDomanda()] - END");

		} catch (CSIException e) {

			throw e;
		} catch (Exception e) {

			throw new UnrecoverableException("Errore non recuperabile durante l'esecuzione del metodo:" + e, e);
		}
	}

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
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException

			, it.csi.iscritto.serviscritto.exception.domanda.ValidationException

	{ //NOSONAR  Reason:EIAS
		try {

			logger.debug("[DomandaBean::checkRichiedenteDomandaNido()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
			// inizio misurazione
			watcher.start();

			delegate.checkRichiedenteDomandaNido(

					callerInfo,

					codiceFiscaleRic,

					domandaNido

			);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaBean", "checkRichiedenteDomandaNido()",
					"invocazione servizio [domanda]::[checkRichiedenteDomandaNido]", "(valore input omesso)");
			logger.debug("[DomandaBean::checkRichiedenteDomandaNido()] - END");

		} catch (CSIException e) {

			throw e;
		} catch (Exception e) {

			throw new UnrecoverableException("Errore non recuperabile durante l'esecuzione del metodo:" + e, e);
		}
	}

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
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException

			, it.csi.iscritto.serviscritto.exception.domanda.ValidationException

	{ //NOSONAR  Reason:EIAS
		try {

			logger.debug("[DomandaBean::checkRichiedenteDomandaMaterna()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
			// inizio misurazione
			watcher.start();

			delegate.checkRichiedenteDomandaMaterna(

					callerInfo,

					codiceFiscaleRic,

					domandaMaterna

			);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaBean", "checkRichiedenteDomandaMaterna()",
					"invocazione servizio [domanda]::[checkRichiedenteDomandaMaterna]", "(valore input omesso)");
			logger.debug("[DomandaBean::checkRichiedenteDomandaMaterna()] - END");

		} catch (CSIException e) {

			throw e;
		} catch (Exception e) {

			throw new UnrecoverableException("Errore non recuperabile durante l'esecuzione del metodo:" + e, e);
		}
	}

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
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException

	{ //NOSONAR  Reason:EIAS
		try {

			logger.debug("[DomandaBean::getStoricoCondizioniPunteggio()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
			// inizio misurazione
			watcher.start();

			it.csi.iscritto.serviscritto.dto.domanda.DatiCondizionePunteggio[] valueObjRet = delegate
					.getStoricoCondizioniPunteggio(

							callerInfo,

							idDomanda,

							codCondizionePunteggio

			);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaBean", "getStoricoCondizioniPunteggio()",
					"invocazione servizio [domanda]::[getStoricoCondizioniPunteggio]", "(valore input omesso)");
			logger.debug("[DomandaBean::getStoricoCondizioniPunteggio()] - END");

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

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException

	{ //NOSONAR  Reason:EIAS
		try {

			logger.debug("[DomandaBean::modificaCondizionePunteggioNidi()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
			// inizio misurazione
			watcher.start();

			delegate.modificaCondizionePunteggioNidi(

					callerInfo,

					idDomanda,

					codCondizionePunteggio,

					codiceFiscaleOperatore,

					count,

					datiCondizionePunteggio

			);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaBean", "modificaCondizionePunteggioNidi()",
					"invocazione servizio [domanda]::[modificaCondizionePunteggioNidi]", "(valore input omesso)");
			logger.debug("[DomandaBean::modificaCondizionePunteggioNidi()] - END");

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

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException

	{ //NOSONAR  Reason:EIAS
		try {

			logger.debug("[DomandaBean::modificaCondizionePunteggioMaterne()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
			// inizio misurazione
			watcher.start();

			delegate.modificaCondizionePunteggioMaterne(

					callerInfo,

					idDomanda,

					codCondizionePunteggio,

					codiceFiscaleOperatore,

					count,

					datiCondizionePunteggio

			);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaBean", "modificaCondizionePunteggioMaterne()",
					"invocazione servizio [domanda]::[modificaCondizionePunteggioMaterne]", "(valore input omesso)");
			logger.debug("[DomandaBean::modificaCondizionePunteggioMaterne()] - END");

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
	public it.csi.iscritto.serviscritto.dto.domanda.InfoAllegatoSoggetto[] getInfoAllegatiDomanda( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.Long idDomanda, //NOSONAR  Reason:EIAS

			java.lang.String codCondizionePunteggio //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException

	{ //NOSONAR  Reason:EIAS
		try {

			logger.debug("[DomandaBean::getInfoAllegatiDomanda()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
			// inizio misurazione
			watcher.start();

			it.csi.iscritto.serviscritto.dto.domanda.InfoAllegatoSoggetto[] valueObjRet = delegate
					.getInfoAllegatiDomanda(

							callerInfo,

							idDomanda,

							codCondizionePunteggio

			);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaBean", "getInfoAllegatiDomanda()",
					"invocazione servizio [domanda]::[getInfoAllegatiDomanda]", "(valore input omesso)");
			logger.debug("[DomandaBean::getInfoAllegatiDomanda()] - END");

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

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException

	{ //NOSONAR  Reason:EIAS
		try {

			logger.debug("[DomandaBean::getInfoVerbaliNidi()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
			// inizio misurazione
			watcher.start();

			it.csi.iscritto.serviscritto.dto.domanda.VerbaleCommissione[] valueObjRet = delegate.getInfoVerbaliNidi(

					callerInfo,

					codProfilo,

					tipoCommissione,

					dataInizio,

					dataFine

			);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaBean", "getInfoVerbaliNidi()",
					"invocazione servizio [domanda]::[getInfoVerbaliNidi]", "(valore input omesso)");
			logger.debug("[DomandaBean::getInfoVerbaliNidi()] - END");

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

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException

	{ //NOSONAR  Reason:EIAS
		try {

			logger.debug("[DomandaBean::getInfoVerbaliMaterne()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
			// inizio misurazione
			watcher.start();

			it.csi.iscritto.serviscritto.dto.domanda.VerbaleCommissione[] valueObjRet = delegate.getInfoVerbaliMaterne(

					callerInfo,

					codProfilo,

					tipoCommissione,

					dataInizio,

					dataFine

			);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaBean", "getInfoVerbaliMaterne()",
					"invocazione servizio [domanda]::[getInfoVerbaliMaterne]", "(valore input omesso)");
			logger.debug("[DomandaBean::getInfoVerbaliMaterne()] - END");

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
	public it.csi.iscritto.serviscritto.dto.domanda.InfoGenerali getInfoGeneraliNidi( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException

	{ //NOSONAR  Reason:EIAS
		try {

			logger.debug("[DomandaBean::getInfoGeneraliNidi()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
			// inizio misurazione
			watcher.start();

			it.csi.iscritto.serviscritto.dto.domanda.InfoGenerali valueObjRet = delegate.getInfoGeneraliNidi(

					callerInfo

			);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaBean", "getInfoGeneraliNidi()",
					"invocazione servizio [domanda]::[getInfoGeneraliNidi]", "(valore input omesso)");
			logger.debug("[DomandaBean::getInfoGeneraliNidi()] - END");

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
	public it.csi.iscritto.serviscritto.dto.domanda.InfoGenerali getInfoGeneraliMaterne( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException

	{ //NOSONAR  Reason:EIAS
		try {

			logger.debug("[DomandaBean::getInfoGeneraliMaterne()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
			// inizio misurazione
			watcher.start();

			it.csi.iscritto.serviscritto.dto.domanda.InfoGenerali valueObjRet = delegate.getInfoGeneraliMaterne(

					callerInfo

			);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaBean", "getInfoGeneraliMaterne()",
					"invocazione servizio [domanda]::[getInfoGeneraliMaterne]", "(valore input omesso)");
			logger.debug("[DomandaBean::getInfoGeneraliMaterne()] - END");

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
	public it.csi.iscritto.serviscritto.dto.domanda.TestataDomandaDaVerificare[] getDomandeNidoDaVerificare( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.String codProfilo //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException

	{ //NOSONAR  Reason:EIAS
		try {

			logger.debug("[DomandaBean::getDomandeNidoDaVerificare()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
			// inizio misurazione
			watcher.start();

			it.csi.iscritto.serviscritto.dto.domanda.TestataDomandaDaVerificare[] valueObjRet = delegate
					.getDomandeNidoDaVerificare(

							callerInfo,

							codProfilo

			);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaBean", "getDomandeNidoDaVerificare()",
					"invocazione servizio [domanda]::[getDomandeNidoDaVerificare]", "(valore input omesso)");
			logger.debug("[DomandaBean::getDomandeNidoDaVerificare()] - END");

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
	public it.csi.iscritto.serviscritto.dto.domanda.TestataDomandaDaVerificare[] getDomandeMaternaDaVerificare( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.String codProfilo //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException

	{ //NOSONAR  Reason:EIAS
		try {

			logger.debug("[DomandaBean::getDomandeMaternaDaVerificare()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
			// inizio misurazione
			watcher.start();

			it.csi.iscritto.serviscritto.dto.domanda.TestataDomandaDaVerificare[] valueObjRet = delegate
					.getDomandeMaternaDaVerificare(

							callerInfo,

							codProfilo

			);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaBean", "getDomandeMaternaDaVerificare()",
					"invocazione servizio [domanda]::[getDomandeMaternaDaVerificare]", "(valore input omesso)");
			logger.debug("[DomandaBean::getDomandeMaternaDaVerificare()] - END");

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
	public it.csi.iscritto.serviscritto.dto.domanda.Nido[] getElencoNidi( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.Long idDomanda //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException

	{ //NOSONAR  Reason:EIAS
		try {

			logger.debug("[DomandaBean::getElencoNidi()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
			// inizio misurazione
			watcher.start();

			it.csi.iscritto.serviscritto.dto.domanda.Nido[] valueObjRet = delegate.getElencoNidi(

					callerInfo,

					idDomanda

			);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaBean", "getElencoNidi()", "invocazione servizio [domanda]::[getElencoNidi]",
					"(valore input omesso)");
			logger.debug("[DomandaBean::getElencoNidi()] - END");

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
	public it.csi.iscritto.serviscritto.dto.domanda.Materna[] getElencoMaterne( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.Long idDomanda //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException

	{ //NOSONAR  Reason:EIAS
		try {

			logger.debug("[DomandaBean::getElencoMaterne()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
			// inizio misurazione
			watcher.start();

			it.csi.iscritto.serviscritto.dto.domanda.Materna[] valueObjRet = delegate.getElencoMaterne(

					callerInfo,

					idDomanda

			);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaBean", "getElencoMaterne()",
					"invocazione servizio [domanda]::[getElencoMaterne]", "(valore input omesso)");
			logger.debug("[DomandaBean::getElencoMaterne()] - END");

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
	public void modificaStatoNidi( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.Long idDomanda, //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.Nido[] elencoNidi //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException

	{ //NOSONAR  Reason:EIAS
		try {

			logger.debug("[DomandaBean::modificaStatoNidi()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
			// inizio misurazione
			watcher.start();

			delegate.modificaStatoNidi(

					callerInfo,

					idDomanda,

					elencoNidi

			);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaBean", "modificaStatoNidi()",
					"invocazione servizio [domanda]::[modificaStatoNidi]", "(valore input omesso)");
			logger.debug("[DomandaBean::modificaStatoNidi()] - END");

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
	public void modificaStatoMaterne( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.Long idDomanda, //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.Materna[] elencoMaterne //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException

	{ //NOSONAR  Reason:EIAS
		try {

			logger.debug("[DomandaBean::modificaStatoMaterne()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
			// inizio misurazione
			watcher.start();

			delegate.modificaStatoMaterne(

					callerInfo,

					idDomanda,

					elencoMaterne

			);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaBean", "modificaStatoMaterne()",
					"invocazione servizio [domanda]::[modificaStatoMaterne]", "(valore input omesso)");
			logger.debug("[DomandaBean::modificaStatoMaterne()] - END");

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
	public it.csi.iscritto.serviscritto.dto.domanda.TestataDomandaAccettazione getTestataDomandaAccettazione( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.Long idDomanda, //NOSONAR  Reason:EIAS

			java.lang.String cfRichiedente //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException

	{ //NOSONAR  Reason:EIAS
		try {

			logger.debug("[DomandaBean::getTestataDomandaAccettazione()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
			// inizio misurazione
			watcher.start();

			it.csi.iscritto.serviscritto.dto.domanda.TestataDomandaAccettazione valueObjRet = delegate
					.getTestataDomandaAccettazione(

							callerInfo,

							idDomanda,

							cfRichiedente

			);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaBean", "getTestataDomandaAccettazione()",
					"invocazione servizio [domanda]::[getTestataDomandaAccettazione]", "(valore input omesso)");
			logger.debug("[DomandaBean::getTestataDomandaAccettazione()] - END");

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

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException

	{ //NOSONAR  Reason:EIAS
		try {

			logger.debug("[DomandaBean::accettaPreferenzaNidi()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
			// inizio misurazione
			watcher.start();

			it.csi.iscritto.serviscritto.dto.domanda.TestataDomandaAccettazione valueObjRet = delegate
					.accettaPreferenzaNidi(

							callerInfo,

							idDomanda,

							cfRichiedente,

							codScuola,

							codTipoFrequenza,

							cfOperatore,

							telRichiedente,

							codTipoPasto

			);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaBean", "accettaPreferenzaNidi()",
					"invocazione servizio [domanda]::[accettaPreferenzaNidi]", "(valore input omesso)");
			logger.debug("[DomandaBean::accettaPreferenzaNidi()] - END");

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

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException

	{ //NOSONAR  Reason:EIAS
		try {

			logger.debug("[DomandaBean::accettaPreferenzaMaterne()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
			// inizio misurazione
			watcher.start();

			it.csi.iscritto.serviscritto.dto.domanda.TestataDomandaAccettazione valueObjRet = delegate
					.accettaPreferenzaMaterne(

							callerInfo,

							idDomanda,

							cfRichiedente,

							codScuola,

							codTipoFrequenza,

							cfOperatore,

							telRichiedente,

							codTipoPasto

			);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaBean", "accettaPreferenzaMaterne()",
					"invocazione servizio [domanda]::[accettaPreferenzaMaterne]", "(valore input omesso)");
			logger.debug("[DomandaBean::accettaPreferenzaMaterne()] - END");

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

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException

	{ //NOSONAR  Reason:EIAS
		try {

			logger.debug("[DomandaBean::rifiutaPreferenzaNidi()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
			// inizio misurazione
			watcher.start();

			it.csi.iscritto.serviscritto.dto.domanda.TestataDomandaAccettazione valueObjRet = delegate
					.rifiutaPreferenzaNidi(

							callerInfo,

							idDomanda,

							cfRichiedente,

							codScuola,

							codTipoFrequenza,

							cfOperatore

			);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaBean", "rifiutaPreferenzaNidi()",
					"invocazione servizio [domanda]::[rifiutaPreferenzaNidi]", "(valore input omesso)");
			logger.debug("[DomandaBean::rifiutaPreferenzaNidi()] - END");

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

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException

	{ //NOSONAR  Reason:EIAS
		try {

			logger.debug("[DomandaBean::rifiutaPreferenzaMaterne()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
			// inizio misurazione
			watcher.start();

			it.csi.iscritto.serviscritto.dto.domanda.TestataDomandaAccettazione valueObjRet = delegate
					.rifiutaPreferenzaMaterne(

							callerInfo,

							idDomanda,

							cfRichiedente,

							codScuola,

							codTipoFrequenza,

							cfOperatore

			);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaBean", "rifiutaPreferenzaMaterne()",
					"invocazione servizio [domanda]::[rifiutaPreferenzaMaterne]", "(valore input omesso)");
			logger.debug("[DomandaBean::rifiutaPreferenzaMaterne()] - END");

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
	public it.csi.iscritto.serviscritto.dto.domanda.ParametriGraduatoria getParametriUltimaGraduatoriaNidi( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException

	{ //NOSONAR  Reason:EIAS
		try {

			logger.debug("[DomandaBean::getParametriUltimaGraduatoriaNidi()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
			// inizio misurazione
			watcher.start();

			it.csi.iscritto.serviscritto.dto.domanda.ParametriGraduatoria valueObjRet = delegate
					.getParametriUltimaGraduatoriaNidi(

							callerInfo

			);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaBean", "getParametriUltimaGraduatoriaNidi()",
					"invocazione servizio [domanda]::[getParametriUltimaGraduatoriaNidi]", "(valore input omesso)");
			logger.debug("[DomandaBean::getParametriUltimaGraduatoriaNidi()] - END");

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
	public it.csi.iscritto.serviscritto.dto.domanda.ParametriGraduatoria getParametriUltimaGraduatoriaMaterne( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException

	{ //NOSONAR  Reason:EIAS
		try {

			logger.debug("[DomandaBean::getParametriUltimaGraduatoriaMaterne()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
			// inizio misurazione
			watcher.start();

			it.csi.iscritto.serviscritto.dto.domanda.ParametriGraduatoria valueObjRet = delegate
					.getParametriUltimaGraduatoriaMaterne(

							callerInfo

			);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaBean", "getParametriUltimaGraduatoriaMaterne()",
					"invocazione servizio [domanda]::[getParametriUltimaGraduatoriaMaterne]", "(valore input omesso)");
			logger.debug("[DomandaBean::getParametriUltimaGraduatoriaMaterne()] - END");

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
	public it.csi.iscritto.serviscritto.dto.domanda.Graduatoria[] getElencoGraduatorieNidi( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException

	{ //NOSONAR  Reason:EIAS
		try {

			logger.debug("[DomandaBean::getElencoGraduatorieNidi()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
			// inizio misurazione
			watcher.start();

			it.csi.iscritto.serviscritto.dto.domanda.Graduatoria[] valueObjRet = delegate.getElencoGraduatorieNidi(

					callerInfo

			);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaBean", "getElencoGraduatorieNidi()",
					"invocazione servizio [domanda]::[getElencoGraduatorieNidi]", "(valore input omesso)");
			logger.debug("[DomandaBean::getElencoGraduatorieNidi()] - END");

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
	public it.csi.iscritto.serviscritto.dto.domanda.Graduatoria[] getElencoGraduatorieMaterne( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException

	{ //NOSONAR  Reason:EIAS
		try {

			logger.debug("[DomandaBean::getElencoGraduatorieMaterne()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
			// inizio misurazione
			watcher.start();

			it.csi.iscritto.serviscritto.dto.domanda.Graduatoria[] valueObjRet = delegate.getElencoGraduatorieMaterne(

					callerInfo

			);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaBean", "getElencoGraduatorieMaterne()",
					"invocazione servizio [domanda]::[getElencoGraduatorieMaterne]", "(valore input omesso)");
			logger.debug("[DomandaBean::getElencoGraduatorieMaterne()] - END");

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
	public it.csi.iscritto.serviscritto.dto.domanda.StepGraduatoria[] getElencoStepGraduatoriaNidi( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.String codiceGraduatoria //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException

	{ //NOSONAR  Reason:EIAS
		try {

			logger.debug("[DomandaBean::getElencoStepGraduatoriaNidi()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
			// inizio misurazione
			watcher.start();

			it.csi.iscritto.serviscritto.dto.domanda.StepGraduatoria[] valueObjRet = delegate
					.getElencoStepGraduatoriaNidi(

							callerInfo,

							codiceGraduatoria

			);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaBean", "getElencoStepGraduatoriaNidi()",
					"invocazione servizio [domanda]::[getElencoStepGraduatoriaNidi]", "(valore input omesso)");
			logger.debug("[DomandaBean::getElencoStepGraduatoriaNidi()] - END");

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
	public it.csi.iscritto.serviscritto.dto.domanda.StepGraduatoria[] getElencoStepGraduatoriaMaterne( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.String codiceGraduatoria //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException

	{ //NOSONAR  Reason:EIAS
		try {

			logger.debug("[DomandaBean::getElencoStepGraduatoriaMaterne()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
			// inizio misurazione
			watcher.start();

			it.csi.iscritto.serviscritto.dto.domanda.StepGraduatoria[] valueObjRet = delegate
					.getElencoStepGraduatoriaMaterne(

							callerInfo,

							codiceGraduatoria

			);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaBean", "getElencoStepGraduatoriaMaterne()",
					"invocazione servizio [domanda]::[getElencoStepGraduatoriaMaterne]", "(valore input omesso)");
			logger.debug("[DomandaBean::getElencoStepGraduatoriaMaterne()] - END");

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
	public it.csi.iscritto.serviscritto.dto.domanda.TestataGraduatoria[] ricercaGraduatoria( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.RicercaGraduatorieFilter filtroRicerca //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException

	{ //NOSONAR  Reason:EIAS
		try {

			logger.debug("[DomandaBean::ricercaGraduatoria()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
			// inizio misurazione
			watcher.start();

			it.csi.iscritto.serviscritto.dto.domanda.TestataGraduatoria[] valueObjRet = delegate.ricercaGraduatoria(

					callerInfo,

					filtroRicerca

			);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaBean", "ricercaGraduatoria()",
					"invocazione servizio [domanda]::[ricercaGraduatoria]", "(valore input omesso)");
			logger.debug("[DomandaBean::ricercaGraduatoria()] - END");

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
	public it.csi.iscritto.serviscritto.dto.domanda.ParametriGraduatoria getParametriGraduatoriaNidi( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.String codGraduatoria //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException

	{ //NOSONAR  Reason:EIAS
		try {

			logger.debug("[DomandaBean::getParametriGraduatoriaNidi()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
			// inizio misurazione
			watcher.start();

			it.csi.iscritto.serviscritto.dto.domanda.ParametriGraduatoria valueObjRet = delegate
					.getParametriGraduatoriaNidi(

							callerInfo,

							codGraduatoria

			);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaBean", "getParametriGraduatoriaNidi()",
					"invocazione servizio [domanda]::[getParametriGraduatoriaNidi]", "(valore input omesso)");
			logger.debug("[DomandaBean::getParametriGraduatoriaNidi()] - END");

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
	public it.csi.iscritto.serviscritto.dto.domanda.ParametriGraduatoria getParametriGraduatoriaMaterne( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.String codGraduatoria //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException

	{ //NOSONAR  Reason:EIAS
		try {

			logger.debug("[DomandaBean::getParametriGraduatoriaMaterne()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
			// inizio misurazione
			watcher.start();

			it.csi.iscritto.serviscritto.dto.domanda.ParametriGraduatoria valueObjRet = delegate
					.getParametriGraduatoriaMaterne(

							callerInfo,

							codGraduatoria

			);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaBean", "getParametriGraduatoriaMaterne()",
					"invocazione servizio [domanda]::[getParametriGraduatoriaMaterne]", "(valore input omesso)");
			logger.debug("[DomandaBean::getParametriGraduatoriaMaterne()] - END");

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
	public java.lang.Long[] getDomandeNidoNonIstruite( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException

	{ //NOSONAR  Reason:EIAS
		try {

			logger.debug("[DomandaBean::getDomandeNidoNonIstruite()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
			// inizio misurazione
			watcher.start();

			java.lang.Long[] valueObjRet = delegate.getDomandeNidoNonIstruite(

					callerInfo

			);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaBean", "getDomandeNidoNonIstruite()",
					"invocazione servizio [domanda]::[getDomandeNidoNonIstruite]", "(valore input omesso)");
			logger.debug("[DomandaBean::getDomandeNidoNonIstruite()] - END");

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
	public java.lang.Long[] getDomandeMaternaNonIstruite( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException

	{ //NOSONAR  Reason:EIAS
		try {

			logger.debug("[DomandaBean::getDomandeMaternaNonIstruite()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
			// inizio misurazione
			watcher.start();

			java.lang.Long[] valueObjRet = delegate.getDomandeMaternaNonIstruite(

					callerInfo

			);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaBean", "getDomandeMaternaNonIstruite()",
					"invocazione servizio [domanda]::[getDomandeMaternaNonIstruite]", "(valore input omesso)");
			logger.debug("[DomandaBean::getDomandeMaternaNonIstruite()] - END");

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
	public it.csi.iscritto.serviscritto.dto.domanda.InfoVerifiche[] getVerifichePreventivePendenti( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.Long[] idDomande //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException

	{ //NOSONAR  Reason:EIAS
		try {

			logger.debug("[DomandaBean::getVerifichePreventivePendenti()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
			// inizio misurazione
			watcher.start();

			it.csi.iscritto.serviscritto.dto.domanda.InfoVerifiche[] valueObjRet = delegate
					.getVerifichePreventivePendenti(

							callerInfo,

							idDomande

			);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaBean", "getVerifichePreventivePendenti()",
					"invocazione servizio [domanda]::[getVerifichePreventivePendenti]", "(valore input omesso)");
			logger.debug("[DomandaBean::getVerifichePreventivePendenti()] - END");

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
	public void calcolaGraduatoria( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.ParametriCalcoloGraduatoria parametri //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException

	{ //NOSONAR  Reason:EIAS
		try {

			logger.debug("[DomandaBean::calcolaGraduatoria()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
			// inizio misurazione
			watcher.start();

			delegate.calcolaGraduatoria(

					callerInfo,

					parametri

			);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaBean", "calcolaGraduatoria()",
					"invocazione servizio [domanda]::[calcolaGraduatoria]", "(valore input omesso)");
			logger.debug("[DomandaBean::calcolaGraduatoria()] - END");

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
	public it.csi.iscritto.serviscritto.dto.domanda.AnnoScolastico[] getElencoAnniScolastici( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException

	{ //NOSONAR  Reason:EIAS
		try {

			logger.debug("[DomandaBean::getElencoAnniScolastici()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
			// inizio misurazione
			watcher.start();

			it.csi.iscritto.serviscritto.dto.domanda.AnnoScolastico[] valueObjRet = delegate.getElencoAnniScolastici(

					callerInfo

			);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaBean", "getElencoAnniScolastici()",
					"invocazione servizio [domanda]::[getElencoAnniScolastici]", "(valore input omesso)");
			logger.debug("[DomandaBean::getElencoAnniScolastici()] - END");

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
	public it.csi.iscritto.serviscritto.dto.domanda.Classe[] getElencoClassiNido( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.String codScuola, //NOSONAR  Reason:EIAS

			java.lang.String codAnnoScolastico //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException

	{ //NOSONAR  Reason:EIAS
		try {

			logger.debug("[DomandaBean::getElencoClassiNido()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
			// inizio misurazione
			watcher.start();

			it.csi.iscritto.serviscritto.dto.domanda.Classe[] valueObjRet = delegate.getElencoClassiNido(

					callerInfo,

					codScuola,

					codAnnoScolastico

			);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaBean", "getElencoClassiNido()",
					"invocazione servizio [domanda]::[getElencoClassiNido]", "(valore input omesso)");
			logger.debug("[DomandaBean::getElencoClassiNido()] - END");

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
	public it.csi.iscritto.serviscritto.dto.domanda.Classe[] getElencoClassiMaterna( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.String codScuola, //NOSONAR  Reason:EIAS

			java.lang.String codAnnoScolastico //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException

	{ //NOSONAR  Reason:EIAS
		try {

			logger.debug("[DomandaBean::getElencoClassiMaterna()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
			// inizio misurazione
			watcher.start();

			it.csi.iscritto.serviscritto.dto.domanda.Classe[] valueObjRet = delegate.getElencoClassiMaterna(

					callerInfo,

					codScuola,

					codAnnoScolastico

			);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaBean", "getElencoClassiMaterna()",
					"invocazione servizio [domanda]::[getElencoClassiMaterna]", "(valore input omesso)");
			logger.debug("[DomandaBean::getElencoClassiMaterna()] - END");

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
	public java.lang.Long insertClasseNido( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.ClasseParam classe //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException

	{ //NOSONAR  Reason:EIAS
		try {

			logger.debug("[DomandaBean::insertClasseNido()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
			// inizio misurazione
			watcher.start();

			java.lang.Long valueObjRet = delegate.insertClasseNido(

					callerInfo,

					classe

			);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaBean", "insertClasseNido()",
					"invocazione servizio [domanda]::[insertClasseNido]", "(valore input omesso)");
			logger.debug("[DomandaBean::insertClasseNido()] - END");

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
	public java.lang.Long insertClasseMaterna( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.ClasseParam classe //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException

	{ //NOSONAR  Reason:EIAS
		try {

			logger.debug("[DomandaBean::insertClasseMaterna()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
			// inizio misurazione
			watcher.start();

			java.lang.Long valueObjRet = delegate.insertClasseMaterna(

					callerInfo,

					classe

			);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaBean", "insertClasseMaterna()",
					"invocazione servizio [domanda]::[insertClasseMaterna]", "(valore input omesso)");
			logger.debug("[DomandaBean::insertClasseMaterna()] - END");

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
	public java.lang.Integer updateClasseNido( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.ClasseParam classe //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException

	{ //NOSONAR  Reason:EIAS
		try {

			logger.debug("[DomandaBean::updateClasseNido()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
			// inizio misurazione
			watcher.start();

			java.lang.Integer valueObjRet = delegate.updateClasseNido(

					callerInfo,

					classe

			);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaBean", "updateClasseNido()",
					"invocazione servizio [domanda]::[updateClasseNido]", "(valore input omesso)");
			logger.debug("[DomandaBean::updateClasseNido()] - END");

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
	public java.lang.Integer updateClasseMaterna( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.ClasseParam classe //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException

	{ //NOSONAR  Reason:EIAS
		try {

			logger.debug("[DomandaBean::updateClasseMaterna()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
			// inizio misurazione
			watcher.start();

			java.lang.Integer valueObjRet = delegate.updateClasseMaterna(

					callerInfo,

					classe

			);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaBean", "updateClasseMaterna()",
					"invocazione servizio [domanda]::[updateClasseMaterna]", "(valore input omesso)");
			logger.debug("[DomandaBean::updateClasseMaterna()] - END");

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
	public java.lang.Integer deleteClasseNido( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.Long idClasse //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException

	{ //NOSONAR  Reason:EIAS
		try {

			logger.debug("[DomandaBean::deleteClasseNido()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
			// inizio misurazione
			watcher.start();

			java.lang.Integer valueObjRet = delegate.deleteClasseNido(

					callerInfo,

					idClasse

			);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaBean", "deleteClasseNido()",
					"invocazione servizio [domanda]::[deleteClasseNido]", "(valore input omesso)");
			logger.debug("[DomandaBean::deleteClasseNido()] - END");

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
	public java.lang.Integer deleteClasseMaterna( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.Long idClasse //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException

	{ //NOSONAR  Reason:EIAS
		try {

			logger.debug("[DomandaBean::deleteClasseMaterna()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
			// inizio misurazione
			watcher.start();

			java.lang.Integer valueObjRet = delegate.deleteClasseMaterna(

					callerInfo,

					idClasse

			);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaBean", "deleteClasseMaterna()",
					"invocazione servizio [domanda]::[deleteClasseMaterna]", "(valore input omesso)");
			logger.debug("[DomandaBean::deleteClasseMaterna()] - END");

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
	public it.csi.iscritto.serviscritto.dto.domanda.Nido[] getElencoNidiDse( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.Long idDomanda //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException

	{ //NOSONAR  Reason:EIAS
		try {

			logger.debug("[DomandaBean::getElencoNidiDse()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
			// inizio misurazione
			watcher.start();

			it.csi.iscritto.serviscritto.dto.domanda.Nido[] valueObjRet = delegate.getElencoNidiDse(

					callerInfo,

					idDomanda

			);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaBean", "getElencoNidiDse()",
					"invocazione servizio [domanda]::[getElencoNidiDse]", "(valore input omesso)");
			logger.debug("[DomandaBean::getElencoNidiDse()] - END");

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
	public it.csi.iscritto.serviscritto.dto.domanda.Materna[] getElencoMaterneDse( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.Long idDomanda //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException

	{ //NOSONAR  Reason:EIAS
		try {

			logger.debug("[DomandaBean::getElencoMaterneDse()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
			// inizio misurazione
			watcher.start();

			it.csi.iscritto.serviscritto.dto.domanda.Materna[] valueObjRet = delegate.getElencoMaterneDse(

					callerInfo,

					idDomanda

			);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaBean", "getElencoMaterneDse()",
					"invocazione servizio [domanda]::[getElencoMaterneDse]", "(valore input omesso)");
			logger.debug("[DomandaBean::getElencoMaterneDse()] - END");

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
	public it.csi.iscritto.serviscritto.dto.domanda.InfoResidenzeForzate getResidenzeForzateNidi( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException

	{ //NOSONAR  Reason:EIAS
		try {

			logger.debug("[DomandaBean::getResidenzeForzateNidi()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
			// inizio misurazione
			watcher.start();

			it.csi.iscritto.serviscritto.dto.domanda.InfoResidenzeForzate valueObjRet = delegate
					.getResidenzeForzateNidi(

							callerInfo

			);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaBean", "getResidenzeForzateNidi()",
					"invocazione servizio [domanda]::[getResidenzeForzateNidi]", "(valore input omesso)");
			logger.debug("[DomandaBean::getResidenzeForzateNidi()] - END");

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
	public it.csi.iscritto.serviscritto.dto.domanda.InfoResidenzeForzate getResidenzeForzateMaterne( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException

	{ //NOSONAR  Reason:EIAS
		try {

			logger.debug("[DomandaBean::getResidenzeForzateMaterne()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
			// inizio misurazione
			watcher.start();

			it.csi.iscritto.serviscritto.dto.domanda.InfoResidenzeForzate valueObjRet = delegate
					.getResidenzeForzateMaterne(

							callerInfo

			);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaBean", "getResidenzeForzateMaterne()",
					"invocazione servizio [domanda]::[getResidenzeForzateMaterne]", "(valore input omesso)");
			logger.debug("[DomandaBean::getResidenzeForzateMaterne()] - END");

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
	public it.csi.iscritto.serviscritto.dto.domanda.GraduatoriaCompleta[] getGraduatoriaCompletaNidi( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException

	{ //NOSONAR  Reason:EIAS
		try {

			logger.debug("[DomandaBean::getGraduatoriaCompletaNidi()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
			// inizio misurazione
			watcher.start();

			it.csi.iscritto.serviscritto.dto.domanda.GraduatoriaCompleta[] valueObjRet = delegate
					.getGraduatoriaCompletaNidi(

							callerInfo

			);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaBean", "getGraduatoriaCompletaNidi()",
					"invocazione servizio [domanda]::[getGraduatoriaCompletaNidi]", "(valore input omesso)");
			logger.debug("[DomandaBean::getGraduatoriaCompletaNidi()] - END");

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
	public it.csi.iscritto.serviscritto.dto.domanda.GraduatoriaCompleta[] getGraduatoriaCompletaMaterne( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException

	{ //NOSONAR  Reason:EIAS
		try {

			logger.debug("[DomandaBean::getGraduatoriaCompletaMaterne()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
			// inizio misurazione
			watcher.start();

			it.csi.iscritto.serviscritto.dto.domanda.GraduatoriaCompleta[] valueObjRet = delegate
					.getGraduatoriaCompletaMaterne(

							callerInfo

			);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaBean", "getGraduatoriaCompletaMaterne()",
					"invocazione servizio [domanda]::[getGraduatoriaCompletaMaterne]", "(valore input omesso)");
			logger.debug("[DomandaBean::getGraduatoriaCompletaMaterne()] - END");

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
	public java.lang.Integer updateFlagAmmissioni( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.Long[] idClasseList, //NOSONAR  Reason:EIAS

			java.lang.Boolean value //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException

	{ //NOSONAR  Reason:EIAS
		try {

			logger.debug("[DomandaBean::updateFlagAmmissioni()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
			// inizio misurazione
			watcher.start();

			java.lang.Integer valueObjRet = delegate.updateFlagAmmissioni(

					callerInfo,

					idClasseList,

					value

			);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaBean", "updateFlagAmmissioni()",
					"invocazione servizio [domanda]::[updateFlagAmmissioni]", "(valore input omesso)");
			logger.debug("[DomandaBean::updateFlagAmmissioni()] - END");

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
	public it.csi.iscritto.serviscritto.dto.domanda.InfoStepGraduatoria[] getInfoStepGraduatorieNido( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException

	{ //NOSONAR  Reason:EIAS
		try {

			logger.debug("[DomandaBean::getInfoStepGraduatorieNido()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
			// inizio misurazione
			watcher.start();

			it.csi.iscritto.serviscritto.dto.domanda.InfoStepGraduatoria[] valueObjRet = delegate
					.getInfoStepGraduatorieNido(

							callerInfo

			);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaBean", "getInfoStepGraduatorieNido()",
					"invocazione servizio [domanda]::[getInfoStepGraduatorieNido]", "(valore input omesso)");
			logger.debug("[DomandaBean::getInfoStepGraduatorieNido()] - END");

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
	public it.csi.iscritto.serviscritto.dto.domanda.InfoStepGraduatoria[] getInfoStepGraduatorieMaterna( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException

	{ //NOSONAR  Reason:EIAS
		try {

			logger.debug("[DomandaBean::getInfoStepGraduatorieMaterna()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
			// inizio misurazione
			watcher.start();

			it.csi.iscritto.serviscritto.dto.domanda.InfoStepGraduatoria[] valueObjRet = delegate
					.getInfoStepGraduatorieMaterna(

							callerInfo

			);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaBean", "getInfoStepGraduatorieMaterna()",
					"invocazione servizio [domanda]::[getInfoStepGraduatorieMaterna]", "(valore input omesso)");
			logger.debug("[DomandaBean::getInfoStepGraduatorieMaterna()] - END");

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

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException

	{ //NOSONAR  Reason:EIAS
		try {

			logger.debug("[DomandaBean::getGraduatoriaApprovazioneNidi()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
			// inizio misurazione
			watcher.start();

			it.csi.iscritto.serviscritto.dto.domanda.GraduatoriaApprovazione[] valueObjRet = delegate
					.getGraduatoriaApprovazioneNidi(

							callerInfo,

							codiceGraduatoria,

							step,

							codiceStatoGraduatoria

			);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaBean", "getGraduatoriaApprovazioneNidi()",
					"invocazione servizio [domanda]::[getGraduatoriaApprovazioneNidi]", "(valore input omesso)");
			logger.debug("[DomandaBean::getGraduatoriaApprovazioneNidi()] - END");

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

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException

	{ //NOSONAR  Reason:EIAS
		try {

			logger.debug("[DomandaBean::getGraduatoriaApprovazioneMaterne()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
			// inizio misurazione
			watcher.start();

			it.csi.iscritto.serviscritto.dto.domanda.GraduatoriaApprovazione[] valueObjRet = delegate
					.getGraduatoriaApprovazioneMaterne(

							callerInfo,

							codiceGraduatoria,

							step,

							codiceStatoGraduatoria

			);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaBean", "getGraduatoriaApprovazioneMaterne()",
					"invocazione servizio [domanda]::[getGraduatoriaApprovazioneMaterne]", "(valore input omesso)");
			logger.debug("[DomandaBean::getGraduatoriaApprovazioneMaterne()] - END");

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

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException

	{ //NOSONAR  Reason:EIAS
		try {

			logger.debug("[DomandaBean::insertNidoFuoriTermine()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
			// inizio misurazione
			watcher.start();

			delegate.insertNidoFuoriTermine(

					callerInfo,

					idDomanda,

					cfOperatore,

					codScuola,

					codTipoFrequenza

			);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaBean", "insertNidoFuoriTermine()",
					"invocazione servizio [domanda]::[insertNidoFuoriTermine]", "(valore input omesso)");
			logger.debug("[DomandaBean::insertNidoFuoriTermine()] - END");

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

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException

	{ //NOSONAR  Reason:EIAS
		try {

			logger.debug("[DomandaBean::insertMaternaFuoriTermine()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
			// inizio misurazione
			watcher.start();

			delegate.insertMaternaFuoriTermine(

					callerInfo,

					idDomanda,

					cfOperatore,

					codScuola,

					codTipoFrequenza

			);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaBean", "insertMaternaFuoriTermine()",
					"invocazione servizio [domanda]::[insertMaternaFuoriTermine]", "(valore input omesso)");
			logger.debug("[DomandaBean::insertMaternaFuoriTermine()] - END");

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
	public it.csi.iscritto.serviscritto.dto.domanda.RicevutaAllegato generaRicevuta( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.Long idAllegato //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException

	{ //NOSONAR  Reason:EIAS
		try {

			logger.debug("[DomandaBean::generaRicevuta()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
			// inizio misurazione
			watcher.start();

			it.csi.iscritto.serviscritto.dto.domanda.RicevutaAllegato valueObjRet = delegate.generaRicevuta(

					callerInfo,

					idAllegato

			);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaBean", "generaRicevuta()", "invocazione servizio [domanda]::[generaRicevuta]",
					"(valore input omesso)");
			logger.debug("[DomandaBean::generaRicevuta()] - END");

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
	public it.csi.iscritto.serviscritto.dto.domanda.RicevutaAccettazione generaRicevutaAccettazione( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.Long idDomanda, //NOSONAR  Reason:EIAS

			java.lang.String cfRichiedente //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException

	{ //NOSONAR  Reason:EIAS
		try {

			logger.debug("[DomandaBean::generaRicevutaAccettazione()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
			// inizio misurazione
			watcher.start();

			it.csi.iscritto.serviscritto.dto.domanda.RicevutaAccettazione valueObjRet = delegate
					.generaRicevutaAccettazione(

							callerInfo,

							idDomanda,

							cfRichiedente

			);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaBean", "generaRicevutaAccettazione()",
					"invocazione servizio [domanda]::[generaRicevutaAccettazione]", "(valore input omesso)");
			logger.debug("[DomandaBean::generaRicevutaAccettazione()] - END");

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
	public it.csi.iscritto.serviscritto.dto.domanda.FasciaEta[] getFasceEta( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException

	{ //NOSONAR  Reason:EIAS
		try {

			logger.debug("[DomandaBean::getFasceEta()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
			// inizio misurazione
			watcher.start();

			it.csi.iscritto.serviscritto.dto.domanda.FasciaEta[] valueObjRet = delegate.getFasceEta(

					callerInfo

			);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaBean", "getFasceEta()", "invocazione servizio [domanda]::[getFasceEta]",
					"(valore input omesso)");
			logger.debug("[DomandaBean::getFasceEta()] - END");

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
	public it.csi.iscritto.serviscritto.dto.domanda.AnagraficaGraduatoria[] getAnagraficaGraduatorie( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException

	{ //NOSONAR  Reason:EIAS
		try {

			logger.debug("[DomandaBean::getAnagraficaGraduatorie()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
			// inizio misurazione
			watcher.start();

			it.csi.iscritto.serviscritto.dto.domanda.AnagraficaGraduatoria[] valueObjRet = delegate
					.getAnagraficaGraduatorie(

							callerInfo

			);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaBean", "getAnagraficaGraduatorie()",
					"invocazione servizio [domanda]::[getAnagraficaGraduatorie]", "(valore input omesso)");
			logger.debug("[DomandaBean::getAnagraficaGraduatorie()] - END");

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

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException

	{ //NOSONAR  Reason:EIAS
		try {

			logger.debug("[DomandaBean::getAnagraficaGraduatoria()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
			// inizio misurazione
			watcher.start();

			it.csi.iscritto.serviscritto.dto.domanda.AnagraficaGraduatoria valueObjRet = delegate
					.getAnagraficaGraduatoria(

							callerInfo,

							codOrdineScuola,

							codAnagraficaGraduatoria,

							codAnnoScolastico

			);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaBean", "getAnagraficaGraduatoria()",
					"invocazione servizio [domanda]::[getAnagraficaGraduatoria]", "(valore input omesso)");
			logger.debug("[DomandaBean::getAnagraficaGraduatoria()] - END");

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
	public java.lang.Long insertAnagraficaGraduatoria( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.AnagraficaGraduatoria anagraficaGraduatoria //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException

	{ //NOSONAR  Reason:EIAS
		try {

			logger.debug("[DomandaBean::insertAnagraficaGraduatoria()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
			// inizio misurazione
			watcher.start();

			java.lang.Long valueObjRet = delegate.insertAnagraficaGraduatoria(

					callerInfo,

					anagraficaGraduatoria

			);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaBean", "insertAnagraficaGraduatoria()",
					"invocazione servizio [domanda]::[insertAnagraficaGraduatoria]", "(valore input omesso)");
			logger.debug("[DomandaBean::insertAnagraficaGraduatoria()] - END");

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
	public java.lang.Integer updateAnagraficaGraduatoria( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.AnagraficaGraduatoria anagraficaGraduatoria //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException

	{ //NOSONAR  Reason:EIAS
		try {

			logger.debug("[DomandaBean::updateAnagraficaGraduatoria()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
			// inizio misurazione
			watcher.start();

			java.lang.Integer valueObjRet = delegate.updateAnagraficaGraduatoria(

					callerInfo,

					anagraficaGraduatoria

			);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaBean", "updateAnagraficaGraduatoria()",
					"invocazione servizio [domanda]::[updateAnagraficaGraduatoria]", "(valore input omesso)");
			logger.debug("[DomandaBean::updateAnagraficaGraduatoria()] - END");

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

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException

	{ //NOSONAR  Reason:EIAS
		try {

			logger.debug("[DomandaBean::getAnagraficaStepGraduatoria()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
			// inizio misurazione
			watcher.start();

			it.csi.iscritto.serviscritto.dto.domanda.AnagraficaStepGraduatoria[] valueObjRet = delegate
					.getAnagraficaStepGraduatoria(

							callerInfo,

							codOrdineScuola,

							codAnagraficaGraduatoria,

							codAnnoScolastico

			);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaBean", "getAnagraficaStepGraduatoria()",
					"invocazione servizio [domanda]::[getAnagraficaStepGraduatoria]", "(valore input omesso)");
			logger.debug("[DomandaBean::getAnagraficaStepGraduatoria()] - END");

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
	public java.lang.Long insertAnagraficaStepGraduatoria( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.AnagraficaStepGraduatoria stepGraduatoria //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException

	{ //NOSONAR  Reason:EIAS
		try {

			logger.debug("[DomandaBean::insertAnagraficaStepGraduatoria()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
			// inizio misurazione
			watcher.start();

			java.lang.Long valueObjRet = delegate.insertAnagraficaStepGraduatoria(

					callerInfo,

					stepGraduatoria

			);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaBean", "insertAnagraficaStepGraduatoria()",
					"invocazione servizio [domanda]::[insertAnagraficaStepGraduatoria]", "(valore input omesso)");
			logger.debug("[DomandaBean::insertAnagraficaStepGraduatoria()] - END");

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
	public java.lang.Integer updateAnagraficaStepGraduatoria( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.AnagraficaStepGraduatoria stepGraduatoria //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException

	{ //NOSONAR  Reason:EIAS
		try {

			logger.debug("[DomandaBean::updateAnagraficaStepGraduatoria()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
			// inizio misurazione
			watcher.start();

			java.lang.Integer valueObjRet = delegate.updateAnagraficaStepGraduatoria(

					callerInfo,

					stepGraduatoria

			);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaBean", "updateAnagraficaStepGraduatoria()",
					"invocazione servizio [domanda]::[updateAnagraficaStepGraduatoria]", "(valore input omesso)");
			logger.debug("[DomandaBean::updateAnagraficaStepGraduatoria()] - END");

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
	public java.lang.Integer deleteAnagraficaStepGraduatoria( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.Long idStepGra //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException

	{ //NOSONAR  Reason:EIAS
		try {

			logger.debug("[DomandaBean::deleteAnagraficaStepGraduatoria()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
			// inizio misurazione
			watcher.start();

			java.lang.Integer valueObjRet = delegate.deleteAnagraficaStepGraduatoria(

					callerInfo,

					idStepGra

			);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaBean", "deleteAnagraficaStepGraduatoria()",
					"invocazione servizio [domanda]::[deleteAnagraficaStepGraduatoria]", "(valore input omesso)");
			logger.debug("[DomandaBean::deleteAnagraficaStepGraduatoria()] - END");

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

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException

	{ //NOSONAR  Reason:EIAS
		try {

			logger.debug("[DomandaBean::getAnagraficaEta()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
			// inizio misurazione
			watcher.start();

			it.csi.iscritto.serviscritto.dto.domanda.AnagraficaEta[] valueObjRet = delegate.getAnagraficaEta(

					callerInfo,

					codOrdineScuola,

					codAnagraficaGraduatoria,

					codAnnoScolastico

			);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaBean", "getAnagraficaEta()",
					"invocazione servizio [domanda]::[getAnagraficaEta]", "(valore input omesso)");
			logger.debug("[DomandaBean::getAnagraficaEta()] - END");

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
	public java.lang.Long insertAnagraficaEta( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.AnagraficaEta anagraficaEta //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException

	{ //NOSONAR  Reason:EIAS
		try {

			logger.debug("[DomandaBean::insertAnagraficaEta()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
			// inizio misurazione
			watcher.start();

			java.lang.Long valueObjRet = delegate.insertAnagraficaEta(

					callerInfo,

					anagraficaEta

			);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaBean", "insertAnagraficaEta()",
					"invocazione servizio [domanda]::[insertAnagraficaEta]", "(valore input omesso)");
			logger.debug("[DomandaBean::insertAnagraficaEta()] - END");

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
	public java.lang.Integer updateAnagraficaEta( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.AnagraficaEta anagraficaEta //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException

	{ //NOSONAR  Reason:EIAS
		try {

			logger.debug("[DomandaBean::updateAnagraficaEta()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
			// inizio misurazione
			watcher.start();

			java.lang.Integer valueObjRet = delegate.updateAnagraficaEta(

					callerInfo,

					anagraficaEta

			);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaBean", "updateAnagraficaEta()",
					"invocazione servizio [domanda]::[updateAnagraficaEta]", "(valore input omesso)");
			logger.debug("[DomandaBean::updateAnagraficaEta()] - END");

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
	public java.lang.Integer deleteAnagraficaEta( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.Long idEta //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException

	{ //NOSONAR  Reason:EIAS
		try {

			logger.debug("[DomandaBean::deleteAnagraficaEta()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
			// inizio misurazione
			watcher.start();

			java.lang.Integer valueObjRet = delegate.deleteAnagraficaEta(

					callerInfo,

					idEta

			);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaBean", "deleteAnagraficaEta()",
					"invocazione servizio [domanda]::[deleteAnagraficaEta]", "(valore input omesso)");
			logger.debug("[DomandaBean::deleteAnagraficaEta()] - END");

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
	public it.csi.iscritto.serviscritto.dto.domanda.TipoFasciaEta[] getTipiFasceEta( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException

	{ //NOSONAR  Reason:EIAS
		try {

			logger.debug("[DomandaBean::getTipiFasceEta()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
			// inizio misurazione
			watcher.start();

			it.csi.iscritto.serviscritto.dto.domanda.TipoFasciaEta[] valueObjRet = delegate.getTipiFasceEta(

					callerInfo

			);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaBean", "getTipiFasceEta()", "invocazione servizio [domanda]::[getTipiFasceEta]",
					"(valore input omesso)");
			logger.debug("[DomandaBean::getTipiFasceEta()] - END");

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
	public it.csi.iscritto.serviscritto.dto.domanda.RecordPostiLiberi[] getReportPostiLiberi( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.String codOrdineScuola //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException

	{ //NOSONAR  Reason:EIAS
		try {

			logger.debug("[DomandaBean::getReportPostiLiberi()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
			// inizio misurazione
			watcher.start();

			it.csi.iscritto.serviscritto.dto.domanda.RecordPostiLiberi[] valueObjRet = delegate.getReportPostiLiberi(

					callerInfo,

					codOrdineScuola

			);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaBean", "getReportPostiLiberi()",
					"invocazione servizio [domanda]::[getReportPostiLiberi]", "(valore input omesso)");
			logger.debug("[DomandaBean::getReportPostiLiberi()] - END");

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

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException

	{ //NOSONAR  Reason:EIAS
		try {

			logger.debug("[DomandaBean::modificaStatoScuolaPreferenza()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
			// inizio misurazione
			watcher.start();

			it.csi.iscritto.serviscritto.dto.domanda.Result valueObjRet = delegate.modificaStatoScuolaPreferenza(

					callerInfo,

					idGraduatoria,

					idStatoAttuale,

					idStatoRipristino

			);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaBean", "modificaStatoScuolaPreferenza()",
					"invocazione servizio [domanda]::[modificaStatoScuolaPreferenza]", "(valore input omesso)");
			logger.debug("[DomandaBean::modificaStatoScuolaPreferenza()] - END");

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
	public it.csi.iscritto.serviscritto.dto.domanda.RecordPreferenzaScuola[] getPreferenzeScuole( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.Long idAnagraficaGra, //NOSONAR  Reason:EIAS

			java.lang.Long idDomanda //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException

	{ //NOSONAR  Reason:EIAS
		try {

			logger.debug("[DomandaBean::getPreferenzeScuole()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
			// inizio misurazione
			watcher.start();

			it.csi.iscritto.serviscritto.dto.domanda.RecordPreferenzaScuola[] valueObjRet = delegate
					.getPreferenzeScuole(

							callerInfo,

							idAnagraficaGra,

							idDomanda

			);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaBean", "getPreferenzeScuole()",
					"invocazione servizio [domanda]::[getPreferenzeScuole]", "(valore input omesso)");
			logger.debug("[DomandaBean::getPreferenzeScuole()] - END");

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
	public java.lang.Boolean getFlagBloccoGraduatoriaNidi( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException

	{ //NOSONAR  Reason:EIAS
		try {

			logger.debug("[DomandaBean::getFlagBloccoGraduatoriaNidi()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
			// inizio misurazione
			watcher.start();

			java.lang.Boolean valueObjRet = delegate.getFlagBloccoGraduatoriaNidi(

					callerInfo

			);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaBean", "getFlagBloccoGraduatoriaNidi()",
					"invocazione servizio [domanda]::[getFlagBloccoGraduatoriaNidi]", "(valore input omesso)");
			logger.debug("[DomandaBean::getFlagBloccoGraduatoriaNidi()] - END");

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
	public void setFlagBloccoGraduatoriaNidi( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.Boolean value //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException

	{ //NOSONAR  Reason:EIAS
		try {

			logger.debug("[DomandaBean::setFlagBloccoGraduatoriaNidi()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
			// inizio misurazione
			watcher.start();

			delegate.setFlagBloccoGraduatoriaNidi(

					callerInfo,

					value

			);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaBean", "setFlagBloccoGraduatoriaNidi()",
					"invocazione servizio [domanda]::[setFlagBloccoGraduatoriaNidi]", "(valore input omesso)");
			logger.debug("[DomandaBean::setFlagBloccoGraduatoriaNidi()] - END");

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
	public java.lang.Boolean getFlagBloccoGraduatoriaMaterne( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException

	{ //NOSONAR  Reason:EIAS
		try {

			logger.debug("[DomandaBean::getFlagBloccoGraduatoriaMaterne()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
			// inizio misurazione
			watcher.start();

			java.lang.Boolean valueObjRet = delegate.getFlagBloccoGraduatoriaMaterne(

					callerInfo

			);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaBean", "getFlagBloccoGraduatoriaMaterne()",
					"invocazione servizio [domanda]::[getFlagBloccoGraduatoriaMaterne]", "(valore input omesso)");
			logger.debug("[DomandaBean::getFlagBloccoGraduatoriaMaterne()] - END");

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
	public void setFlagBloccoGraduatoriaMaterne( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.Boolean value //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException

	{ //NOSONAR  Reason:EIAS
		try {

			logger.debug("[DomandaBean::setFlagBloccoGraduatoriaMaterne()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
			// inizio misurazione
			watcher.start();

			delegate.setFlagBloccoGraduatoriaMaterne(

					callerInfo,

					value

			);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaBean", "setFlagBloccoGraduatoriaMaterne()",
					"invocazione servizio [domanda]::[setFlagBloccoGraduatoriaMaterne]", "(valore input omesso)");
			logger.debug("[DomandaBean::setFlagBloccoGraduatoriaMaterne()] - END");

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
	public it.csi.iscritto.serviscritto.dto.domanda.TestataDomandaAccettazione getTestataDomandaAccettazioneMaterne( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo, //NOSONAR  Reason:EIAS

			java.lang.Long idDomanda, //NOSONAR  Reason:EIAS

			java.lang.String cfRichiedente //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException

	{ //NOSONAR  Reason:EIAS
		try {

			logger.debug("[DomandaBean::getTestataDomandaAccettazioneMaterne()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
			// inizio misurazione
			watcher.start();

			it.csi.iscritto.serviscritto.dto.domanda.TestataDomandaAccettazione valueObjRet = delegate
					.getTestataDomandaAccettazioneMaterne(

							callerInfo,

							idDomanda,

							cfRichiedente

			);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaBean", "getTestataDomandaAccettazioneMaterne()",
					"invocazione servizio [domanda]::[getTestataDomandaAccettazioneMaterne]", "(valore input omesso)");
			logger.debug("[DomandaBean::getTestataDomandaAccettazioneMaterne()] - END");

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
	public it.csi.iscritto.serviscritto.dto.domanda.RecordDomandeScuolaResidenza[] getReportDomandeScuolaResidenza( //NOSONAR  Reason:EIAS

			it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda callerInfo //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.domanda.DomandaUserException

	{ //NOSONAR  Reason:EIAS
		try {

			logger.debug("[DomandaBean::getReportDomandeScuolaResidenza()] - START");
			it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
			// inizio misurazione
			watcher.start();

			it.csi.iscritto.serviscritto.dto.domanda.RecordDomandeScuolaResidenza[] valueObjRet = delegate
					.getReportDomandeScuolaResidenza(

							callerInfo

			);

			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaBean", "getReportDomandeScuolaResidenza()",
					"invocazione servizio [domanda]::[getReportDomandeScuolaResidenza]", "(valore input omesso)");
			logger.debug("[DomandaBean::getReportDomandeScuolaResidenza()] - END");

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
		logger.debug("[DomandaBean::createImpl] - START");
		try {
			delegate = (DomandaImpl) SpringBeanLocator.getBean("domandaImpl");
			delegate.init(initOptions);
			delegate.setSessionContext(ctx);

		}

		catch (Exception ie) {
			logger.debug("[DomandaBean::createImpl] - ERROR", ie);
			throw new EJBException(
					"Errore nella inizializzazione dell'implementazione del servizio domanda:" + ie.getMessage(), ie);
		} finally {
			logger.debug("[DomandaBean::createImpl] - END");
		}
	}

	/**
	 * @generated
	 */
	public void setSessionContext(SessionContext ctx) throws EJBException, RemoteException {

		/// META-TODO: forse sarebbe opportuno accodare il nome del servizio al logger...
		Logger logger = getLogger(null);
		logger.debug("[DomandaBean::setSessionContext] - START");
		this.ctx = ctx;
		// contiene eventuali oggetti inizializzati nella sezione seguente e che
		// devono essere passati all'oggetto delegate
		Object implInitOptions = null;

		/// Inizializzazione risorse
		/*PROTECTED REGION ID(R71130391) ENABLED START*/
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
		logger.debug("[DomandaBean::setSessionContext] - END");
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
