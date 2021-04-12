
package it.csi.iscritto.serviscritto.business.datitabellari;

import it.csi.csi.wrapper.*;

import it.csi.iscritto.serviscritto.dto.datitabellari.*;

import it.csi.iscritto.serviscritto.interfacecsi.datitabellari.*;

import it.csi.iscritto.serviscritto.exception.datitabellari.*;

import javax.ejb.SessionContext;
import javax.sql.DataSource;
import org.apache.log4j.*;

/*PROTECTED REGION ID(R-1541656016) ENABLED START*/

import it.csi.iscritto.serviscritto.business.datitabellari.helper.DatiTabellariHelper;

/*PROTECTED REGION END*/

/**
 * @generated
 */
public class DatiTabellariImpl {
	/**
	 * @generated
	 */
	public static final String LOGGER_PREFIX = "serviscritto";

	/*PROTECTED REGION ID(R-347009838) ENABLED START*/

	private DatiTabellariHelper datiTabellariHelper;

	/*PROTECTED REGION END*/

	/// Implementazione operazioni esposte dal servizio

	/**
	 * @generated
	 */
	public java.lang.String test( //NOSONAR  Reason:EIAS

			java.lang.String arg0 //NOSONAR  Reason:EIAS

	) //NOSONAR  Reason:EIAS
			throws //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.CSIException, //NOSONAR  Reason:EIAS 
			it.csi.csi.wrapper.SystemException, //NOSONAR  Reason:EIAS
			it.csi.csi.wrapper.UnrecoverableException //NOSONAR  Reason:EIAS

			, it.csi.iscritto.serviscritto.exception.datitabellari.DatiTabellariUserException

	{ //NOSONAR  Reason:EIAS
		Logger logger = getLogger(null);
		logger.debug("[DatiTabellariImpl::test] - START");

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
		// inizio misurazione
		watcher.start();

		/*PROTECTED REGION ID(R-999094416) ENABLED START*/

		/*PROTECTED REGION END*/
		try {
			/*PROTECTED REGION ID(R-1519122416) ENABLED START*/

			return null;

			/*PROTECTED REGION END*/
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error("[DatiTabellariImpl::test] - Errore CSI occorso durante l'esecuzione del metodo:" + ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[DatiTabellariImpl::test] - Errore imprevisto occorso durante l'esecuzione del metodo:" + ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DatiTabellariImpl", "test()", "invocazione servizio [datitabellari]::[test]",
					"(valore input omesso)");
			logger.debug("[DatiTabellariImpl::test] - END");
		}
	}

	/// inizializzazione
	/**
	 * @generated
	 */
	public void init(Object initOptions) {
		/*PROTECTED REGION ID(R356616811) ENABLED START*/

		/*PROTECTED REGION END*/
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

	/// eventuali metodi aggiuntivi
	/*PROTECTED REGION ID(R1753333853) ENABLED START*/

	public void setDatiTabellariHelper(DatiTabellariHelper datiTabellariHelper) {
		this.datiTabellariHelper = datiTabellariHelper;
	}

	/*PROTECTED REGION END*/
}
