
package it.csi.iscritto.serviscritto.business.luoghi;

import it.csi.csi.wrapper.*;

import it.csi.iscritto.serviscritto.dto.luoghi.*;

import it.csi.iscritto.serviscritto.interfacecsi.luoghi.*;

import it.csi.iscritto.serviscritto.exception.luoghi.*;

import javax.ejb.SessionContext;
import javax.sql.DataSource;
import org.apache.log4j.*;

/*PROTECTED REGION ID(R-174532105) ENABLED START*/

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;
import it.csi.iscritto.serviscritto.business.integration.converter.luoghi.LuogoConverter;
import it.csi.iscritto.serviscritto.business.integration.dao.view.LuoghiDao;

/*PROTECTED REGION END*/

/**
 * @generated
 */
public class LuoghiImpl {
	/**
	 * @generated
	 */
	public static final String LOGGER_PREFIX = "serviscritto";

	/*PROTECTED REGION ID(R400258713) ENABLED START*/

	private LuoghiDao luoghiDao;

	/*PROTECTED REGION END*/

	/// Implementazione operazioni esposte dal servizio

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
		Logger logger = getLogger(null);
		logger.debug("[LuoghiImpl::findStatiAttiviAllaData] - START");

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
		// inizio misurazione
		watcher.start();

		/*PROTECTED REGION ID(R-1793544807) ENABLED START*/

		/*PROTECTED REGION END*/
		try {
			/*PROTECTED REGION ID(R243121721) ENABLED START*/

			List<Luogo> result = new LuogoConverter().convertAll(this.luoghiDao.findStatiAttiviAllaData(data));

			return Optional.of(result).orElse(new ArrayList<Luogo>()).toArray(new Luogo[0]);

			/*PROTECTED REGION END*/
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error(
						"[LuoghiImpl::findStatiAttiviAllaData] - Errore CSI occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[LuoghiImpl::findStatiAttiviAllaData] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("LuoghiImpl", "findStatiAttiviAllaData()",
					"invocazione servizio [luoghi]::[findStatiAttiviAllaData]", "(valore input omesso)");
			logger.debug("[LuoghiImpl::findStatiAttiviAllaData] - END");
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
		Logger logger = getLogger(null);
		logger.debug("[LuoghiImpl::findRegioniAttiveAllaData] - START");

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
		// inizio misurazione
		watcher.start();

		/*PROTECTED REGION ID(R-300111563) ENABLED START*/

		/*PROTECTED REGION END*/
		try {
			/*PROTECTED REGION ID(R-1568665131) ENABLED START*/

			List<Luogo> result = new LuogoConverter().convertAll(this.luoghiDao.findRegioniAttiveAllaData(data));

			return Optional.of(result).orElse(new ArrayList<Luogo>()).toArray(new Luogo[0]);

			/*PROTECTED REGION END*/
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error(
						"[LuoghiImpl::findRegioniAttiveAllaData] - Errore CSI occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[LuoghiImpl::findRegioniAttiveAllaData] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("LuoghiImpl", "findRegioniAttiveAllaData()",
					"invocazione servizio [luoghi]::[findRegioniAttiveAllaData]", "(valore input omesso)");
			logger.debug("[LuoghiImpl::findRegioniAttiveAllaData] - END");
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
		Logger logger = getLogger(null);
		logger.debug("[LuoghiImpl::findProvinceAttiveAllaData] - START");

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
		// inizio misurazione
		watcher.start();

		/*PROTECTED REGION ID(R1388286482) ENABLED START*/

		/*PROTECTED REGION END*/
		try {
			/*PROTECTED REGION ID(R717831538) ENABLED START*/

			List<Luogo> result = new LuogoConverter()
					.convertAll(this.luoghiDao.findProvinceAttiveAllaData(data, istatRegione));

			return Optional.of(result).orElse(new ArrayList<Luogo>()).toArray(new Luogo[0]);

			/*PROTECTED REGION END*/
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error(
						"[LuoghiImpl::findProvinceAttiveAllaData] - Errore CSI occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[LuoghiImpl::findProvinceAttiveAllaData] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("LuoghiImpl", "findProvinceAttiveAllaData()",
					"invocazione servizio [luoghi]::[findProvinceAttiveAllaData]", "(valore input omesso)");
			logger.debug("[LuoghiImpl::findProvinceAttiveAllaData] - END");
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
		Logger logger = getLogger(null);
		logger.debug("[LuoghiImpl::findComuniAttiviAllaData] - START");

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
		// inizio misurazione
		watcher.start();

		/*PROTECTED REGION ID(R-2098328395) ENABLED START*/

		/*PROTECTED REGION END*/
		try {
			/*PROTECTED REGION ID(R908791829) ENABLED START*/

			List<Luogo> result = new LuogoConverter()
					.convertAll(this.luoghiDao.findComuniAttiviAllaData(data, istatProvincia));

			return Optional.of(result).orElse(new ArrayList<Luogo>()).toArray(new Luogo[0]);

			/*PROTECTED REGION END*/
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error(
						"[LuoghiImpl::findComuniAttiviAllaData] - Errore CSI occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[LuoghiImpl::findComuniAttiviAllaData] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("LuoghiImpl", "findComuniAttiviAllaData()",
					"invocazione servizio [luoghi]::[findComuniAttiviAllaData]", "(valore input omesso)");
			logger.debug("[LuoghiImpl::findComuniAttiviAllaData] - END");
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
		Logger logger = getLogger(null);
		logger.debug("[LuoghiImpl::findByIstatComuneAllaData] - START");

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
		// inizio misurazione
		watcher.start();

		/*PROTECTED REGION ID(R167893210) ENABLED START*/

		/*PROTECTED REGION END*/
		try {
			/*PROTECTED REGION ID(R-1100660358) ENABLED START*/

			List<Luogo> result = new LuogoConverter()
					.convertAll(this.luoghiDao.findByIstatComuneAllaData(data, istatComune));

			return Optional.of(result).orElse(new ArrayList<Luogo>()).toArray(new Luogo[0]);

			/*PROTECTED REGION END*/
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error(
						"[LuoghiImpl::findByIstatComuneAllaData] - Errore CSI occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[LuoghiImpl::findByIstatComuneAllaData] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("LuoghiImpl", "findByIstatComuneAllaData()",
					"invocazione servizio [luoghi]::[findByIstatComuneAllaData]", "(valore input omesso)");
			logger.debug("[LuoghiImpl::findByIstatComuneAllaData] - END");
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
		Logger logger = getLogger(null);
		logger.debug("[LuoghiImpl::findByIstatStatoAllaData] - START");

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
		// inizio misurazione
		watcher.start();

		/*PROTECTED REGION ID(R47830656) ENABLED START*/

		/*PROTECTED REGION END*/
		try {
			/*PROTECTED REGION ID(R-1240016416) ENABLED START*/

			return new LuogoConverter().convert(this.luoghiDao.findByIstatStatoAllaData(data, istatStato));

			/*PROTECTED REGION END*/
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error(
						"[LuoghiImpl::findByIstatStatoAllaData] - Errore CSI occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[LuoghiImpl::findByIstatStatoAllaData] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("LuoghiImpl", "findByIstatStatoAllaData()",
					"invocazione servizio [luoghi]::[findByIstatStatoAllaData]", "(valore input omesso)");
			logger.debug("[LuoghiImpl::findByIstatStatoAllaData] - END");
		}
	}

	/// inizializzazione
	/**
	 * @generated
	 */
	public void init(Object initOptions) {
		/*PROTECTED REGION ID(R208379186) ENABLED START*/

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
	/*PROTECTED REGION ID(R1647437092) ENABLED START*/

	public void setLuoghiDao(LuoghiDao luoghiDao) {
		this.luoghiDao = luoghiDao;
	}

	/*PROTECTED REGION END*/
}
