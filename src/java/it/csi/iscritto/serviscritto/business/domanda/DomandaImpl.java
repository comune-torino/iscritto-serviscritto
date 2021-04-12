
package it.csi.iscritto.serviscritto.business.domanda;

import it.csi.csi.wrapper.*;

import it.csi.iscritto.serviscritto.dto.domanda.*;

import it.csi.iscritto.serviscritto.interfacecsi.domanda.*;

import it.csi.iscritto.serviscritto.exception.domanda.*;

import javax.ejb.SessionContext;
import javax.sql.DataSource;
import org.apache.log4j.*;

/*PROTECTED REGION ID(R200582199) ENABLED START*/
import it.csi.iscritto.serviscritto.business.integration.dao.TipoScuola;
import it.csi.iscritto.serviscritto.business.integration.dao.TipoVerificheIstruttoria;
import it.csi.iscritto.serviscritto.business.domanda.service.DomandaNidoUpdateService;
import it.csi.iscritto.serviscritto.business.domanda.service.AccettazioneService;
import it.csi.iscritto.serviscritto.business.domanda.service.AllegatoService;
import it.csi.iscritto.serviscritto.business.domanda.service.AnagraficaService;
import it.csi.iscritto.serviscritto.business.domanda.service.DomandaMaternaReadService;
import it.csi.iscritto.serviscritto.business.domanda.service.DomandaMaternaUpdateService;
import it.csi.iscritto.serviscritto.business.domanda.service.DomandaMaternaValidationService;
import it.csi.iscritto.serviscritto.business.domanda.service.DomandaNidoReadService;
import it.csi.iscritto.serviscritto.business.domanda.service.DomandaNidoValidationService;
import it.csi.iscritto.serviscritto.business.domanda.service.DomandaService;
import it.csi.iscritto.serviscritto.business.domanda.service.GraduatoriaService;
import it.csi.iscritto.serviscritto.business.domanda.service.InfoGeneraliService;
import it.csi.iscritto.serviscritto.business.domanda.service.IstruttoriaService;
import it.csi.iscritto.serviscritto.business.util.converter.ConvertUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/*PROTECTED REGION END*/

/**
 * @generated
 */
public class DomandaImpl {
	/**
	 * @generated
	 */
	public static final String LOGGER_PREFIX = "serviscritto";
	private SessionContext sessionContext;

	public SessionContext getSessionContext() {
		return sessionContext;
	}

	public void setSessionContext(SessionContext sessionContext) {
		this.sessionContext = sessionContext;
	}

	/*PROTECTED REGION ID(R839228373) ENABLED START*/

	private DomandaNidoReadService domandaNidoReadService;
	private DomandaMaternaReadService domandaMaternaReadService;
	private DomandaNidoUpdateService domandaNidoUpdateService;
	private DomandaMaternaUpdateService domandaMaternaUpdateService;
	private DomandaNidoValidationService domandaNidoValidationService;
	private DomandaMaternaValidationService domandaMaternaValidationService;
	private InfoGeneraliService infoGeneraliService;
	private AllegatoService allegatoService;
	private IstruttoriaService istruttoriaService;
	private AccettazioneService accettazioneService;
	private GraduatoriaService graduatoriaService;
	private DomandaService domandaService;
	private AnagraficaService anagraficaService;

	public void setDomandaNidoReadService(DomandaNidoReadService domandaNidoReadService) {
		this.domandaNidoReadService = domandaNidoReadService;
	}

	public void setDomandaMaternaReadService(DomandaMaternaReadService domandaMaternaReadService) {
		this.domandaMaternaReadService = domandaMaternaReadService;
	}

	public void setDomandaNidoUpdateService(DomandaNidoUpdateService domandaNidoUpdateService) {
		this.domandaNidoUpdateService = domandaNidoUpdateService;
	}

	public void setDomandaMaternaUpdateService(DomandaMaternaUpdateService domandaMaternaUpdateService) {
		this.domandaMaternaUpdateService = domandaMaternaUpdateService;
	}

	public void setDomandaNidoValidationService(DomandaNidoValidationService domandaNidoValidationService) {
		this.domandaNidoValidationService = domandaNidoValidationService;
	}

	public void setDomandaMaternaValidationService(DomandaMaternaValidationService domandaMaternaValidationService) {
		this.domandaMaternaValidationService = domandaMaternaValidationService;
	}

	public void setInfoGeneraliService(InfoGeneraliService infoGeneraliService) {
		this.infoGeneraliService = infoGeneraliService;
	}

	public void setAllegatoService(AllegatoService allegatoService) {
		this.allegatoService = allegatoService;
	}

	public void setIstruttoriaService(IstruttoriaService istruttoriaService) {
		this.istruttoriaService = istruttoriaService;
	}

	public void setAccettazioneService(AccettazioneService accettazioneService) {
		this.accettazioneService = accettazioneService;
	}

	public void setGraduatoriaService(GraduatoriaService graduatoriaService) {
		this.graduatoriaService = graduatoriaService;
	}

	public void setDomandaService(DomandaService domandaService) {
		this.domandaService = domandaService;
	}

	public void setAnagraficaService(AnagraficaService anagraficaService) {
		this.anagraficaService = anagraficaService;
	}

	/*PROTECTED REGION END*/

	/// Implementazione operazioni esposte dal servizio

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
		Logger logger = getLogger(null);
		logger.debug("[DomandaImpl::getElencoDomandeNidi] - START");

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
		// inizio misurazione
		watcher.start();

		/*PROTECTED REGION ID(R856410246) ENABLED START*/

		/*PROTECTED REGION END*/
		try {
			/*PROTECTED REGION ID(R-1782808282) ENABLED START*/

			this.domandaService.logAudit(callerInfo);

			List<Long> chiavi = this.domandaService.getElencoDomande(TipoScuola.NID, codiceFiscaleOperatore,
					codiceProfilo, criterioRicerca);

			return Optional.of(chiavi).orElse(new ArrayList<Long>()).toArray(new Long[0]);

			/*PROTECTED REGION END*/
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error("[DomandaImpl::getElencoDomandeNidi] - Errore CSI occorso durante l'esecuzione del metodo:"
						+ ex, ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[DomandaImpl::getElencoDomandeNidi] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaImpl", "getElencoDomandeNidi()",
					"invocazione servizio [domanda]::[getElencoDomandeNidi]", "(valore input omesso)");
			logger.debug("[DomandaImpl::getElencoDomandeNidi] - END");
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
		Logger logger = getLogger(null);
		logger.debug("[DomandaImpl::getElencoDomandeMaterne] - START");

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
		// inizio misurazione
		watcher.start();

		/*PROTECTED REGION ID(R110133694) ENABLED START*/

		/*PROTECTED REGION END*/
		try {
			/*PROTECTED REGION ID(R-1177713378) ENABLED START*/

			this.domandaService.logAudit(callerInfo);

			List<Long> chiavi = this.domandaService.getElencoDomande(TipoScuola.MAT, codiceFiscaleOperatore,
					codiceProfilo, criterioRicerca);

			return Optional.of(chiavi).orElse(new ArrayList<Long>()).toArray(new Long[0]);

			/*PROTECTED REGION END*/
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error(
						"[DomandaImpl::getElencoDomandeMaterne] - Errore CSI occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[DomandaImpl::getElencoDomandeMaterne] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaImpl", "getElencoDomandeMaterne()",
					"invocazione servizio [domanda]::[getElencoDomandeMaterne]", "(valore input omesso)");
			logger.debug("[DomandaImpl::getElencoDomandeMaterne] - END");
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
		Logger logger = getLogger(null);
		logger.debug("[DomandaImpl::getTestataDomanda] - START");

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
		// inizio misurazione
		watcher.start();

		/*PROTECTED REGION ID(R316812734) ENABLED START*/

		/*PROTECTED REGION END*/
		try {
			/*PROTECTED REGION ID(R729626910) ENABLED START*/

			this.domandaService.logAudit(callerInfo);

			return this.domandaService.getTestataDomanda(idDomanda, tipoTestata);

			/*PROTECTED REGION END*/
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error(
						"[DomandaImpl::getTestataDomanda] - Errore CSI occorso durante l'esecuzione del metodo:" + ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[DomandaImpl::getTestataDomanda] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaImpl", "getTestataDomanda()",
					"invocazione servizio [domanda]::[getTestataDomanda]", "(valore input omesso)");
			logger.debug("[DomandaImpl::getTestataDomanda] - END");
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
		Logger logger = getLogger(null);
		logger.debug("[DomandaImpl::getElencoStatiDomanda] - START");

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
		// inizio misurazione
		watcher.start();

		/*PROTECTED REGION ID(R-2038108447) ENABLED START*/

		/*PROTECTED REGION END*/
		try {
			/*PROTECTED REGION ID(R2045463105) ENABLED START*/

			this.domandaService.logAudit(callerInfo);

			List<Codifica> result = this.domandaService.getElencoStatiDomanda();

			return ConvertUtils.toArray(result, Codifica.class);

			/*PROTECTED REGION END*/
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error(
						"[DomandaImpl::getElencoStatiDomanda] - Errore CSI occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[DomandaImpl::getElencoStatiDomanda] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaImpl", "getElencoStatiDomanda()",
					"invocazione servizio [domanda]::[getElencoStatiDomanda]", "(valore input omesso)");
			logger.debug("[DomandaImpl::getElencoStatiDomanda] - END");
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
		Logger logger = getLogger(null);
		logger.debug("[DomandaImpl::getDomandaNido] - START");

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
		// inizio misurazione
		watcher.start();

		/*PROTECTED REGION ID(R750866852) ENABLED START*/

		/*PROTECTED REGION END*/
		try {
			/*PROTECTED REGION ID(R-1374617020) ENABLED START*/

			this.domandaService.logAudit(callerInfo);

			return this.domandaNidoReadService.readDomandaNido(idDomanda);

			/*PROTECTED REGION END*/
		} catch (RuntimeException ex) {
			sessionContext.setRollbackOnly();
			logger.error(
					"[SrvbibliotecaImpl::leggiBiblioteca] - Errore imprevisto occorso durante l'esecuzione del metodo:"
							+ ex + "Forzata RollBack Transazione",
					ex);
			throw new UnrecoverableException(
					"Errore imprevisto occorso durante l'esecuzione del metodo:" + ex + "Forzata RollBack Transazione",
					ex);
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error("[DomandaImpl::getDomandaNido] - Errore CSI occorso durante l'esecuzione del metodo:" + ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[DomandaImpl::getDomandaNido] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaImpl", "getDomandaNido()", "invocazione servizio [domanda]::[getDomandaNido]",
					"(valore input omesso)");
			logger.debug("[DomandaImpl::getDomandaNido] - END");
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
		Logger logger = getLogger(null);
		logger.debug("[DomandaImpl::getDomandaMaterna] - START");

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
		// inizio misurazione
		watcher.start();

		/*PROTECTED REGION ID(R-217235038) ENABLED START*/

		/*PROTECTED REGION END*/
		try {
			/*PROTECTED REGION ID(R195579138) ENABLED START*/

			this.domandaService.logAudit(callerInfo);

			return this.domandaMaternaReadService.readDomandaMaterna(idDomanda);

			/*PROTECTED REGION END*/
		} catch (RuntimeException ex) {
			sessionContext.setRollbackOnly();
			logger.error(
					"[SrvbibliotecaImpl::leggiBiblioteca] - Errore imprevisto occorso durante l'esecuzione del metodo:"
							+ ex + "Forzata RollBack Transazione",
					ex);
			throw new UnrecoverableException(
					"Errore imprevisto occorso durante l'esecuzione del metodo:" + ex + "Forzata RollBack Transazione",
					ex);
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error(
						"[DomandaImpl::getDomandaMaterna] - Errore CSI occorso durante l'esecuzione del metodo:" + ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[DomandaImpl::getDomandaMaterna] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaImpl", "getDomandaMaterna()",
					"invocazione servizio [domanda]::[getDomandaMaterna]", "(valore input omesso)");
			logger.debug("[DomandaImpl::getDomandaMaterna] - END");
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
		Logger logger = getLogger(null);
		logger.debug("[DomandaImpl::insertDomandaNido] - START");

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
		// inizio misurazione
		watcher.start();

		/*PROTECTED REGION ID(R1780541009) ENABLED START*/

		/*PROTECTED REGION END*/
		try {
			/*PROTECTED REGION ID(R-2101612111) ENABLED START*/

			this.domandaService.logAudit(callerInfo);

			this.domandaNidoValidationService.checkForBozza(domandaNido);

			Long idDomandaIscrizione = this.domandaNidoUpdateService.insert(domandaNido);
			return this.domandaNidoReadService.readDomandaNido(idDomandaIscrizione);

			/*PROTECTED REGION END*/
		} catch (RuntimeException ex) {
			sessionContext.setRollbackOnly();
			logger.error(
					"[SrvbibliotecaImpl::leggiBiblioteca] - Errore imprevisto occorso durante l'esecuzione del metodo:"
							+ ex + "Forzata RollBack Transazione",
					ex);
			throw new UnrecoverableException(
					"Errore imprevisto occorso durante l'esecuzione del metodo:" + ex + "Forzata RollBack Transazione",
					ex);
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error(
						"[DomandaImpl::insertDomandaNido] - Errore CSI occorso durante l'esecuzione del metodo:" + ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[DomandaImpl::insertDomandaNido] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaImpl", "insertDomandaNido()",
					"invocazione servizio [domanda]::[insertDomandaNido]", "(valore input omesso)");
			logger.debug("[DomandaImpl::insertDomandaNido] - END");
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
		Logger logger = getLogger(null);
		logger.debug("[DomandaImpl::insertDomandaMaterna] - START");

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
		// inizio misurazione
		watcher.start();

		/*PROTECTED REGION ID(R149148117) ENABLED START*/

		/*PROTECTED REGION END*/
		try {
			/*PROTECTED REGION ID(R1804896885) ENABLED START*/

			this.domandaService.logAudit(callerInfo);

			this.domandaMaternaValidationService.checkForBozza(domandaMaterna);

			Long idDomandaIscrizione = this.domandaMaternaUpdateService.insert(domandaMaterna);
			return this.domandaMaternaReadService.readDomandaMaterna(idDomandaIscrizione);

			/*PROTECTED REGION END*/
		} catch (RuntimeException ex) {
			sessionContext.setRollbackOnly();
			logger.error(
					"[SrvbibliotecaImpl::leggiBiblioteca] - Errore imprevisto occorso durante l'esecuzione del metodo:"
							+ ex + "Forzata RollBack Transazione",
					ex);
			throw new UnrecoverableException(
					"Errore imprevisto occorso durante l'esecuzione del metodo:" + ex + "Forzata RollBack Transazione",
					ex);
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error("[DomandaImpl::insertDomandaMaterna] - Errore CSI occorso durante l'esecuzione del metodo:"
						+ ex, ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[DomandaImpl::insertDomandaMaterna] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaImpl", "insertDomandaMaterna()",
					"invocazione servizio [domanda]::[insertDomandaMaterna]", "(valore input omesso)");
			logger.debug("[DomandaImpl::insertDomandaMaterna] - END");
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
		Logger logger = getLogger(null);
		logger.debug("[DomandaImpl::checkDomandaNido] - START");

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
		// inizio misurazione
		watcher.start();

		/*PROTECTED REGION ID(R-1672276302) ENABLED START*/

		/*PROTECTED REGION END*/
		try {
			/*PROTECTED REGION ID(R142155602) ENABLED START*/

			this.domandaService.logAudit(callerInfo);

			this.domandaNidoValidationService.checkDomandaNido(codiceFiscaleRic, codiceFiscaleMin);

			/*PROTECTED REGION END*/
		} catch (RuntimeException ex) {
			sessionContext.setRollbackOnly();
			logger.error(
					"[SrvbibliotecaImpl::leggiBiblioteca] - Errore imprevisto occorso durante l'esecuzione del metodo:"
							+ ex + "Forzata RollBack Transazione",
					ex);
			throw new UnrecoverableException(
					"Errore imprevisto occorso durante l'esecuzione del metodo:" + ex + "Forzata RollBack Transazione",
					ex);
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error(
						"[DomandaImpl::checkDomandaNido] - Errore CSI occorso durante l'esecuzione del metodo:" + ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[DomandaImpl::checkDomandaNido] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaImpl", "checkDomandaNido()",
					"invocazione servizio [domanda]::[checkDomandaNido]", "(valore input omesso)");
			logger.debug("[DomandaImpl::checkDomandaNido] - END");
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
		Logger logger = getLogger(null);
		logger.debug("[DomandaImpl::checkDomandaMaterna] - START");

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
		// inizio misurazione
		watcher.start();

		/*PROTECTED REGION ID(R1735375316) ENABLED START*/

		/*PROTECTED REGION END*/
		try {
			/*PROTECTED REGION ID(R-982160076) ENABLED START*/

			this.domandaService.logAudit(callerInfo);

			this.domandaMaternaValidationService.checkDomandaMaterna(codiceFiscaleRic, codiceFiscaleMin);

			/*PROTECTED REGION END*/
		} catch (RuntimeException ex) {
			sessionContext.setRollbackOnly();
			logger.error(
					"[SrvbibliotecaImpl::leggiBiblioteca] - Errore imprevisto occorso durante l'esecuzione del metodo:"
							+ ex + "Forzata RollBack Transazione",
					ex);
			throw new UnrecoverableException(
					"Errore imprevisto occorso durante l'esecuzione del metodo:" + ex + "Forzata RollBack Transazione",
					ex);
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error(
						"[DomandaImpl::checkDomandaMaterna] - Errore CSI occorso durante l'esecuzione del metodo:" + ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[DomandaImpl::checkDomandaMaterna] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaImpl", "checkDomandaMaterna()",
					"invocazione servizio [domanda]::[checkDomandaMaterna]", "(valore input omesso)");
			logger.debug("[DomandaImpl::checkDomandaMaterna] - END");
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
		Logger logger = getLogger(null);
		logger.debug("[DomandaImpl::deleteDomanda] - START");

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
		// inizio misurazione
		watcher.start();

		/*PROTECTED REGION ID(R-2061872903) ENABLED START*/

		/*PROTECTED REGION END*/
		try {
			/*PROTECTED REGION ID(R2025983065) ENABLED START*/

			this.domandaService.logAudit(callerInfo);

			this.domandaNidoUpdateService.deleteDomanda(idDomanda, cfOperatore);

			/*PROTECTED REGION END*/
		} catch (RuntimeException ex) {
			sessionContext.setRollbackOnly();
			logger.error(
					"[SrvbibliotecaImpl::leggiBiblioteca] - Errore imprevisto occorso durante l'esecuzione del metodo:"
							+ ex + "Forzata RollBack Transazione",
					ex);
			throw new UnrecoverableException(
					"Errore imprevisto occorso durante l'esecuzione del metodo:" + ex + "Forzata RollBack Transazione",
					ex);
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error("[DomandaImpl::deleteDomanda] - Errore CSI occorso durante l'esecuzione del metodo:" + ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error("[DomandaImpl::deleteDomanda] - Errore imprevisto occorso durante l'esecuzione del metodo:"
						+ ex, ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaImpl", "deleteDomanda()", "invocazione servizio [domanda]::[deleteDomanda]",
					"(valore input omesso)");
			logger.debug("[DomandaImpl::deleteDomanda] - END");
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
		Logger logger = getLogger(null);
		logger.debug("[DomandaImpl::getAllegato] - START");

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
		// inizio misurazione
		watcher.start();

		/*PROTECTED REGION ID(R-229785433) ENABLED START*/

		/*PROTECTED REGION END*/
		try {
			/*PROTECTED REGION ID(R829215751) ENABLED START*/

			this.domandaService.logAudit(callerInfo);

			return this.allegatoService.getAllegato(cfRichiedente, idDomanda, idAllegato, withContent);

			/*PROTECTED REGION END*/
		} catch (RuntimeException ex) {
			sessionContext.setRollbackOnly();
			logger.error(
					"[SrvbibliotecaImpl::leggiBiblioteca] - Errore imprevisto occorso durante l'esecuzione del metodo:"
							+ ex + "Forzata RollBack Transazione",
					ex);
			throw new UnrecoverableException(
					"Errore imprevisto occorso durante l'esecuzione del metodo:" + ex + "Forzata RollBack Transazione",
					ex);
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error("[DomandaImpl::getAllegato] - Errore CSI occorso durante l'esecuzione del metodo:" + ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[DomandaImpl::getAllegato] - Errore imprevisto occorso durante l'esecuzione del metodo:" + ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaImpl", "getAllegato()", "invocazione servizio [domanda]::[getAllegato]",
					"(valore input omesso)");
			logger.debug("[DomandaImpl::getAllegato] - END");
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
		Logger logger = getLogger(null);
		logger.debug("[DomandaImpl::deleteAllegato] - START");

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
		// inizio misurazione
		watcher.start();

		/*PROTECTED REGION ID(R1180296204) ENABLED START*/

		/*PROTECTED REGION END*/
		try {
			/*PROTECTED REGION ID(R-945187668) ENABLED START*/

			this.domandaService.logAudit(callerInfo);

			return this.allegatoService.deleteAllegato(cfRichiedente, cfOperatore, idDomanda, idAllegato);

			/*PROTECTED REGION END*/
		} catch (RuntimeException ex) {
			sessionContext.setRollbackOnly();
			logger.error(
					"[SrvbibliotecaImpl::leggiBiblioteca] - Errore imprevisto occorso durante l'esecuzione del metodo:"
							+ ex + "Forzata RollBack Transazione",
					ex);
			throw new UnrecoverableException(
					"Errore imprevisto occorso durante l'esecuzione del metodo:" + ex + "Forzata RollBack Transazione",
					ex);
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error("[DomandaImpl::deleteAllegato] - Errore CSI occorso durante l'esecuzione del metodo:" + ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[DomandaImpl::deleteAllegato] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaImpl", "deleteAllegato()", "invocazione servizio [domanda]::[deleteAllegato]",
					"(valore input omesso)");
			logger.debug("[DomandaImpl::deleteAllegato] - END");
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
		Logger logger = getLogger(null);
		logger.debug("[DomandaImpl::insertAllegatoList] - START");

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
		// inizio misurazione
		watcher.start();

		/*PROTECTED REGION ID(R223754968) ENABLED START*/

		/*PROTECTED REGION END*/
		try {
			/*PROTECTED REGION ID(R136092536) ENABLED START*/

			this.domandaService.logAudit(callerInfo);

			List<Allegato> allegati = ConvertUtils.toList(allegatoList);
			List<Long> result = this.allegatoService.insertAllegatoList(cfRichiedente, cfOperatore, idDomanda,
					allegati);

			this.domandaNidoUpdateService.protocollaAllegatiNido(idDomanda);

			return ConvertUtils.toArray(result, Long.class);

			/*PROTECTED REGION END*/
		} catch (RuntimeException ex) {
			sessionContext.setRollbackOnly();
			logger.error(
					"[SrvbibliotecaImpl::leggiBiblioteca] - Errore imprevisto occorso durante l'esecuzione del metodo:"
							+ ex + "Forzata RollBack Transazione",
					ex);
			throw new UnrecoverableException(
					"Errore imprevisto occorso durante l'esecuzione del metodo:" + ex + "Forzata RollBack Transazione",
					ex);
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error(
						"[DomandaImpl::insertAllegatoList] - Errore CSI occorso durante l'esecuzione del metodo:" + ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[DomandaImpl::insertAllegatoList] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaImpl", "insertAllegatoList()",
					"invocazione servizio [domanda]::[insertAllegatoList]", "(valore input omesso)");
			logger.debug("[DomandaImpl::insertAllegatoList] - END");
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
		Logger logger = getLogger(null);
		logger.debug("[DomandaImpl::invioDomandaNido] - START");

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
		// inizio misurazione
		watcher.start();

		/*PROTECTED REGION ID(R-1233787005) ENABLED START*/

		/*PROTECTED REGION END*/
		try {
			/*PROTECTED REGION ID(R580644899) ENABLED START*/

			this.domandaService.logAudit(callerInfo);

			DomandaNido domandaNido = this.domandaNidoReadService.readDomandaNido(idDomanda);
			this.domandaNidoValidationService.checkForInvio(callerInfo, domandaNido);
			this.domandaNidoValidationService.invalidaDomandeEsistenti(domandaNido);
			this.domandaNidoValidationService.aggiornaNidiFuoriTermine(domandaNido);

			return this.domandaNidoUpdateService.inviaDomandaNido(idDomanda);

			/*PROTECTED REGION END*/
		} catch (RuntimeException ex) {
			sessionContext.setRollbackOnly();
			logger.error(
					"[SrvbibliotecaImpl::leggiBiblioteca] - Errore imprevisto occorso durante l'esecuzione del metodo:"
							+ ex + "Forzata RollBack Transazione",
					ex);
			throw new UnrecoverableException(
					"Errore imprevisto occorso durante l'esecuzione del metodo:" + ex + "Forzata RollBack Transazione",
					ex);
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error(
						"[DomandaImpl::invioDomandaNido] - Errore CSI occorso durante l'esecuzione del metodo:" + ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[DomandaImpl::invioDomandaNido] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaImpl", "invioDomandaNido()",
					"invocazione servizio [domanda]::[invioDomandaNido]", "(valore input omesso)");
			logger.debug("[DomandaImpl::invioDomandaNido] - END");
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
		Logger logger = getLogger(null);
		logger.debug("[DomandaImpl::invioDomandaMaterna] - START");

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
		// inizio misurazione
		watcher.start();

		/*PROTECTED REGION ID(R-520492189) ENABLED START*/

		/*PROTECTED REGION END*/
		try {
			/*PROTECTED REGION ID(R1056939715) ENABLED START*/

			this.domandaService.logAudit(callerInfo);

			DomandaMaterna domandaMaterna = this.domandaMaternaReadService.readDomandaMaterna(idDomanda);
			this.domandaMaternaValidationService.checkForInvio(callerInfo, domandaMaterna);
			this.domandaMaternaValidationService.invalidaDomandeEsistenti(domandaMaterna);
			this.domandaMaternaValidationService.aggiornaMaterneFuoriTermine(domandaMaterna);

			return this.domandaMaternaUpdateService.inviaDomandaMaterna(idDomanda);

			/*PROTECTED REGION END*/
		} catch (RuntimeException ex) {
			sessionContext.setRollbackOnly();
			logger.error(
					"[SrvbibliotecaImpl::leggiBiblioteca] - Errore imprevisto occorso durante l'esecuzione del metodo:"
							+ ex + "Forzata RollBack Transazione",
					ex);
			throw new UnrecoverableException(
					"Errore imprevisto occorso durante l'esecuzione del metodo:" + ex + "Forzata RollBack Transazione",
					ex);
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error(
						"[DomandaImpl::invioDomandaMaterna] - Errore CSI occorso durante l'esecuzione del metodo:" + ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[DomandaImpl::invioDomandaMaterna] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaImpl", "invioDomandaMaterna()",
					"invocazione servizio [domanda]::[invioDomandaMaterna]", "(valore input omesso)");
			logger.debug("[DomandaImpl::invioDomandaMaterna] - END");
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
		Logger logger = getLogger(null);
		logger.debug("[DomandaImpl::getDomandeIstruttoriaNidi] - START");

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
		// inizio misurazione
		watcher.start();

		/*PROTECTED REGION ID(R-112295546) ENABLED START*/

		/*PROTECTED REGION END*/
		try {
			/*PROTECTED REGION ID(R-782750490) ENABLED START*/

			this.domandaService.logAudit(callerInfo);

			List<TestataDomandaIstruttoria> result = this.domandaService.getDomandeIstruttoria(TipoScuola.NID,
					criterioRicerca, cfOperatore, codProfilo);

			return ConvertUtils.toArray(result, TestataDomandaIstruttoria.class);

			/*PROTECTED REGION END*/
		} catch (RuntimeException ex) {
			sessionContext.setRollbackOnly();
			logger.error(
					"[SrvbibliotecaImpl::leggiBiblioteca] - Errore imprevisto occorso durante l'esecuzione del metodo:"
							+ ex + "Forzata RollBack Transazione",
					ex);
			throw new UnrecoverableException(
					"Errore imprevisto occorso durante l'esecuzione del metodo:" + ex + "Forzata RollBack Transazione",
					ex);
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error(
						"[DomandaImpl::getDomandeIstruttoriaNidi] - Errore CSI occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[DomandaImpl::getDomandeIstruttoriaNidi] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaImpl", "getDomandeIstruttoriaNidi()",
					"invocazione servizio [domanda]::[getDomandeIstruttoriaNidi]", "(valore input omesso)");
			logger.debug("[DomandaImpl::getDomandeIstruttoriaNidi] - END");
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
		Logger logger = getLogger(null);
		logger.debug("[DomandaImpl::getDomandeIstruttoriaMaterne] - START");

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
		// inizio misurazione
		watcher.start();

		/*PROTECTED REGION ID(R-718853954) ENABLED START*/

		/*PROTECTED REGION END*/
		try {
			/*PROTECTED REGION ID(R1650803038) ENABLED START*/

			this.domandaService.logAudit(callerInfo);

			List<TestataDomandaIstruttoria> result = this.domandaService.getDomandeIstruttoria(TipoScuola.MAT,
					criterioRicerca, cfOperatore, codProfilo);

			return ConvertUtils.toArray(result, TestataDomandaIstruttoria.class);

			/*PROTECTED REGION END*/
		} catch (RuntimeException ex) {
			sessionContext.setRollbackOnly();
			logger.error(
					"[SrvbibliotecaImpl::leggiBiblioteca] - Errore imprevisto occorso durante l'esecuzione del metodo:"
							+ ex + "Forzata RollBack Transazione",
					ex);
			throw new UnrecoverableException(
					"Errore imprevisto occorso durante l'esecuzione del metodo:" + ex + "Forzata RollBack Transazione",
					ex);
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error(
						"[DomandaImpl::getDomandeIstruttoriaMaterne] - Errore CSI occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[DomandaImpl::getDomandeIstruttoriaMaterne] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaImpl", "getDomandeIstruttoriaMaterne()",
					"invocazione servizio [domanda]::[getDomandeIstruttoriaMaterne]", "(valore input omesso)");
			logger.debug("[DomandaImpl::getDomandeIstruttoriaMaterne] - END");
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
		Logger logger = getLogger(null);
		logger.debug("[DomandaImpl::insertLogErroreDomandaNido] - START");

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
		// inizio misurazione
		watcher.start();

		/*PROTECTED REGION ID(R-1849075534) ENABLED START*/

		/*PROTECTED REGION END*/
		try {
			/*PROTECTED REGION ID(R-1158342318) ENABLED START*/

			this.domandaService.logAudit(callerInfo);

			this.domandaNidoUpdateService.logError(codiceFiscaleOperatore, dettaglioErrore, domandaNido);

			/*PROTECTED REGION END*/
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error(
						"[DomandaImpl::insertLogErroreDomandaNido] - Errore CSI occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[DomandaImpl::insertLogErroreDomandaNido] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaImpl", "insertLogErroreDomandaNido()",
					"invocazione servizio [domanda]::[insertLogErroreDomandaNido]", "(valore input omesso)");
			logger.debug("[DomandaImpl::insertLogErroreDomandaNido] - END");
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
		Logger logger = getLogger(null);
		logger.debug("[DomandaImpl::insertLogErroreDomandaMaterna] - START");

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
		// inizio misurazione
		watcher.start();

		/*PROTECTED REGION ID(R339359700) ENABLED START*/

		/*PROTECTED REGION END*/
		try {
			/*PROTECTED REGION ID(R784282420) ENABLED START*/

			this.domandaService.logAudit(callerInfo);

			this.domandaMaternaUpdateService.logError(codiceFiscaleOperatore, dettaglioErrore, domandaMaterna);

			/*PROTECTED REGION END*/
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error(
						"[DomandaImpl::insertLogErroreDomandaMaterna] - Errore CSI occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[DomandaImpl::insertLogErroreDomandaMaterna] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaImpl", "insertLogErroreDomandaMaterna()",
					"invocazione servizio [domanda]::[insertLogErroreDomandaMaterna]", "(valore input omesso)");
			logger.debug("[DomandaImpl::insertLogErroreDomandaMaterna] - END");
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
		Logger logger = getLogger(null);
		logger.debug("[DomandaImpl::checkIdDomanda] - START");

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
		// inizio misurazione
		watcher.start();

		/*PROTECTED REGION ID(R-139739279) ENABLED START*/

		/*PROTECTED REGION END*/
		try {
			/*PROTECTED REGION ID(R2029744145) ENABLED START*/

			this.domandaService.logAudit(callerInfo);

			this.domandaNidoValidationService.checkIdDomanda(codiceFiscaleRic, idDomanda);

			/*PROTECTED REGION END*/
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error("[DomandaImpl::checkIdDomanda] - Errore CSI occorso durante l'esecuzione del metodo:" + ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[DomandaImpl::checkIdDomanda] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaImpl", "checkIdDomanda()", "invocazione servizio [domanda]::[checkIdDomanda]",
					"(valore input omesso)");
			logger.debug("[DomandaImpl::checkIdDomanda] - END");
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
		Logger logger = getLogger(null);
		logger.debug("[DomandaImpl::checkRichiedenteDomandaNido] - START");

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
		// inizio misurazione
		watcher.start();

		/*PROTECTED REGION ID(R1501902028) ENABLED START*/

		/*PROTECTED REGION END*/
		try {
			/*PROTECTED REGION ID(R1439795244) ENABLED START*/

			this.domandaService.logAudit(callerInfo);

			this.domandaNidoValidationService.checkRichiedenteDomanda(codiceFiscaleRic, domandaNido);

			/*PROTECTED REGION END*/
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error(
						"[DomandaImpl::checkRichiedenteDomandaNido] - Errore CSI occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[DomandaImpl::checkRichiedenteDomandaNido] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaImpl", "checkRichiedenteDomandaNido()",
					"invocazione servizio [domanda]::[checkRichiedenteDomandaNido]", "(valore input omesso)");
			logger.debug("[DomandaImpl::checkRichiedenteDomandaNido] - END");
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
		Logger logger = getLogger(null);
		logger.debug("[DomandaImpl::checkRichiedenteDomandaMaterna] - START");

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
		// inizio misurazione
		watcher.start();

		/*PROTECTED REGION ID(R1387048314) ENABLED START*/

		/*PROTECTED REGION END*/
		try {
			/*PROTECTED REGION ID(R-2000216550) ENABLED START*/

			this.domandaService.logAudit(callerInfo);

			this.domandaMaternaValidationService.checkRichiedenteDomanda(codiceFiscaleRic, domandaMaterna);

			/*PROTECTED REGION END*/
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error(
						"[DomandaImpl::checkRichiedenteDomandaMaterna] - Errore CSI occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[DomandaImpl::checkRichiedenteDomandaMaterna] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaImpl", "checkRichiedenteDomandaMaterna()",
					"invocazione servizio [domanda]::[checkRichiedenteDomandaMaterna]", "(valore input omesso)");
			logger.debug("[DomandaImpl::checkRichiedenteDomandaMaterna] - END");
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
		Logger logger = getLogger(null);
		logger.debug("[DomandaImpl::getStoricoCondizioniPunteggio] - START");

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
		// inizio misurazione
		watcher.start();

		/*PROTECTED REGION ID(R983592585) ENABLED START*/

		/*PROTECTED REGION END*/
		try {
			/*PROTECTED REGION ID(R1428515305) ENABLED START*/

			this.domandaService.logAudit(callerInfo);

			List<DatiCondizionePunteggio> result = this.istruttoriaService.getStoricoCondizioniPunteggio(idDomanda,
					codCondizionePunteggio);

			return ConvertUtils.toArray(result, DatiCondizionePunteggio.class);

			/*PROTECTED REGION END*/
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error(
						"[DomandaImpl::getStoricoCondizioniPunteggio] - Errore CSI occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[DomandaImpl::getStoricoCondizioniPunteggio] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaImpl", "getStoricoCondizioniPunteggio()",
					"invocazione servizio [domanda]::[getStoricoCondizioniPunteggio]", "(valore input omesso)");
			logger.debug("[DomandaImpl::getStoricoCondizioniPunteggio] - END");
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
		Logger logger = getLogger(null);
		logger.debug("[DomandaImpl::modificaCondizionePunteggioNidi] - START");

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
		// inizio misurazione
		watcher.start();

		/*PROTECTED REGION ID(R-1034105888) ENABLED START*/

		/*PROTECTED REGION END*/
		try {
			/*PROTECTED REGION ID(R1334865728) ENABLED START*/

			this.domandaService.logAudit(callerInfo);

			this.istruttoriaService.checkStatus(idDomanda, codCondizionePunteggio, count);
			this.istruttoriaService.modificaCondizionePunteggio(idDomanda, TipoScuola.NID, codCondizionePunteggio,
					codiceFiscaleOperatore, datiCondizionePunteggio);

			/*PROTECTED REGION END*/
		} catch (RuntimeException ex) {
			sessionContext.setRollbackOnly();
			logger.error(
					"[SrvbibliotecaImpl::leggiBiblioteca] - Errore imprevisto occorso durante l'esecuzione del metodo:"
							+ ex + "Forzata RollBack Transazione",
					ex);
			throw new UnrecoverableException(
					"Errore imprevisto occorso durante l'esecuzione del metodo:" + ex + "Forzata RollBack Transazione",
					ex);
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error(
						"[DomandaImpl::modificaCondizionePunteggioNidi] - Errore CSI occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[DomandaImpl::modificaCondizionePunteggioNidi] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaImpl", "modificaCondizionePunteggioNidi()",
					"invocazione servizio [domanda]::[modificaCondizionePunteggioNidi]", "(valore input omesso)");
			logger.debug("[DomandaImpl::modificaCondizionePunteggioNidi] - END");
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
		Logger logger = getLogger(null);
		logger.debug("[DomandaImpl::modificaCondizionePunteggioMaterne] - START");

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
		// inizio misurazione
		watcher.start();

		/*PROTECTED REGION ID(R-349861852) ENABLED START*/

		/*PROTECTED REGION END*/
		try {
			/*PROTECTED REGION ID(R-1219057468) ENABLED START*/

			this.domandaService.logAudit(callerInfo);

			this.istruttoriaService.checkStatus(idDomanda, codCondizionePunteggio, count);
			this.istruttoriaService.modificaCondizionePunteggio(idDomanda, TipoScuola.MAT, codCondizionePunteggio,
					codiceFiscaleOperatore, datiCondizionePunteggio);

			/*PROTECTED REGION END*/
		} catch (RuntimeException ex) {
			sessionContext.setRollbackOnly();
			logger.error(
					"[SrvbibliotecaImpl::leggiBiblioteca] - Errore imprevisto occorso durante l'esecuzione del metodo:"
							+ ex + "Forzata RollBack Transazione",
					ex);
			throw new UnrecoverableException(
					"Errore imprevisto occorso durante l'esecuzione del metodo:" + ex + "Forzata RollBack Transazione",
					ex);
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error(
						"[DomandaImpl::modificaCondizionePunteggioMaterne] - Errore CSI occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[DomandaImpl::modificaCondizionePunteggioMaterne] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaImpl", "modificaCondizionePunteggioMaterne()",
					"invocazione servizio [domanda]::[modificaCondizionePunteggioMaterne]", "(valore input omesso)");
			logger.debug("[DomandaImpl::modificaCondizionePunteggioMaterne] - END");
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
		Logger logger = getLogger(null);
		logger.debug("[DomandaImpl::getInfoAllegatiDomanda] - START");

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
		// inizio misurazione
		watcher.start();

		/*PROTECTED REGION ID(R1586335293) ENABLED START*/

		/*PROTECTED REGION END*/
		try {
			/*PROTECTED REGION ID(R-671965475) ENABLED START*/

			this.domandaService.logAudit(callerInfo);

			List<InfoAllegatoSoggetto> result = this.istruttoriaService.getInfoAllegatiDomanda(idDomanda,
					codCondizionePunteggio);

			return ConvertUtils.toArray(result, InfoAllegatoSoggetto.class);

			/*PROTECTED REGION END*/
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error(
						"[DomandaImpl::getInfoAllegatiDomanda] - Errore CSI occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[DomandaImpl::getInfoAllegatiDomanda] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaImpl", "getInfoAllegatiDomanda()",
					"invocazione servizio [domanda]::[getInfoAllegatiDomanda]", "(valore input omesso)");
			logger.debug("[DomandaImpl::getInfoAllegatiDomanda] - END");
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
		Logger logger = getLogger(null);
		logger.debug("[DomandaImpl::getInfoVerbaliNidi] - START");

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
		// inizio misurazione
		watcher.start();

		/*PROTECTED REGION ID(R-2088370173) ENABLED START*/

		/*PROTECTED REGION END*/
		try {
			/*PROTECTED REGION ID(R2118934691) ENABLED START*/

			this.domandaService.logAudit(callerInfo);
			String codFiscaleOperatore = callerInfo.getUtente();

			List<VerbaleCommissione> result = this.istruttoriaService.getInfoVerbali(TipoScuola.NID,
					codFiscaleOperatore, codProfilo, tipoCommissione, dataInizio, dataFine);

			return ConvertUtils.toArray(result, VerbaleCommissione.class);

			/*PROTECTED REGION END*/
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error(
						"[DomandaImpl::getInfoVerbaliNidi] - Errore CSI occorso durante l'esecuzione del metodo:" + ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[DomandaImpl::getInfoVerbaliNidi] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaImpl", "getInfoVerbaliNidi()",
					"invocazione servizio [domanda]::[getInfoVerbaliNidi]", "(valore input omesso)");
			logger.debug("[DomandaImpl::getInfoVerbaliNidi] - END");
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
		Logger logger = getLogger(null);
		logger.debug("[DomandaImpl::getInfoVerbaliMaterne] - START");

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
		// inizio misurazione
		watcher.start();

		/*PROTECTED REGION ID(R1158659361) ENABLED START*/

		/*PROTECTED REGION END*/
		try {
			/*PROTECTED REGION ID(R947263617) ENABLED START*/

			this.domandaService.logAudit(callerInfo);
			String codFiscaleOperatore = callerInfo.getUtente();

			List<VerbaleCommissione> result = this.istruttoriaService.getInfoVerbali(TipoScuola.MAT,
					codFiscaleOperatore, codProfilo, tipoCommissione, dataInizio, dataFine);

			return ConvertUtils.toArray(result, VerbaleCommissione.class);

			/*PROTECTED REGION END*/
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error(
						"[DomandaImpl::getInfoVerbaliMaterne] - Errore CSI occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[DomandaImpl::getInfoVerbaliMaterne] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaImpl", "getInfoVerbaliMaterne()",
					"invocazione servizio [domanda]::[getInfoVerbaliMaterne]", "(valore input omesso)");
			logger.debug("[DomandaImpl::getInfoVerbaliMaterne] - END");
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
		Logger logger = getLogger(null);
		logger.debug("[DomandaImpl::getInfoGeneraliNidi] - START");

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
		// inizio misurazione
		watcher.start();

		/*PROTECTED REGION ID(R202840157) ENABLED START*/

		/*PROTECTED REGION END*/
		try {
			/*PROTECTED REGION ID(R1780272061) ENABLED START*/

			this.domandaService.logAudit(callerInfo);

			return this.infoGeneraliService.getInfoGenerali(TipoScuola.NID);

			/*PROTECTED REGION END*/
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error(
						"[DomandaImpl::getInfoGeneraliNidi] - Errore CSI occorso durante l'esecuzione del metodo:" + ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[DomandaImpl::getInfoGeneraliNidi] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaImpl", "getInfoGeneraliNidi()",
					"invocazione servizio [domanda]::[getInfoGeneraliNidi]", "(valore input omesso)");
			logger.debug("[DomandaImpl::getInfoGeneraliNidi] - END");
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
		Logger logger = getLogger(null);
		logger.debug("[DomandaImpl::getInfoGeneraliMaterne] - START");

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
		// inizio misurazione
		watcher.start();

		/*PROTECTED REGION ID(R-1309634937) ENABLED START*/

		/*PROTECTED REGION END*/
		try {
			/*PROTECTED REGION ID(R727031591) ENABLED START*/

			this.domandaService.logAudit(callerInfo);

			return this.infoGeneraliService.getInfoGenerali(TipoScuola.MAT);

			/*PROTECTED REGION END*/
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error(
						"[DomandaImpl::getInfoGeneraliMaterne] - Errore CSI occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[DomandaImpl::getInfoGeneraliMaterne] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaImpl", "getInfoGeneraliMaterne()",
					"invocazione servizio [domanda]::[getInfoGeneraliMaterne]", "(valore input omesso)");
			logger.debug("[DomandaImpl::getInfoGeneraliMaterne] - END");
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
		Logger logger = getLogger(null);
		logger.debug("[DomandaImpl::getDomandeNidoDaVerificare] - START");

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
		// inizio misurazione
		watcher.start();

		/*PROTECTED REGION ID(R1159962399) ENABLED START*/

		/*PROTECTED REGION END*/
		try {
			/*PROTECTED REGION ID(R1850695615) ENABLED START*/

			this.domandaService.logAudit(callerInfo);

			List<TestataDomandaDaVerificare> result = this.domandaService.getDomandeDaVerificare(TipoScuola.NID,
					callerInfo.getUtente(), codProfilo);

			return ConvertUtils.toArray(result, TestataDomandaDaVerificare.class);

			/*PROTECTED REGION END*/
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error(
						"[DomandaImpl::getDomandeNidoDaVerificare] - Errore CSI occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[DomandaImpl::getDomandeNidoDaVerificare] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaImpl", "getDomandeNidoDaVerificare()",
					"invocazione servizio [domanda]::[getDomandeNidoDaVerificare]", "(valore input omesso)");
			logger.debug("[DomandaImpl::getDomandeNidoDaVerificare] - END");
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
		Logger logger = getLogger(null);
		logger.debug("[DomandaImpl::getDomandeMaternaDaVerificare] - START");

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
		// inizio misurazione
		watcher.start();

		/*PROTECTED REGION ID(R1205953429) ENABLED START*/

		/*PROTECTED REGION END*/
		try {
			/*PROTECTED REGION ID(R1650876149) ENABLED START*/

			this.domandaService.logAudit(callerInfo);

			List<TestataDomandaDaVerificare> result = this.domandaService.getDomandeDaVerificare(TipoScuola.MAT,
					callerInfo.getUtente(), codProfilo);

			return ConvertUtils.toArray(result, TestataDomandaDaVerificare.class);

			/*PROTECTED REGION END*/
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error(
						"[DomandaImpl::getDomandeMaternaDaVerificare] - Errore CSI occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[DomandaImpl::getDomandeMaternaDaVerificare] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaImpl", "getDomandeMaternaDaVerificare()",
					"invocazione servizio [domanda]::[getDomandeMaternaDaVerificare]", "(valore input omesso)");
			logger.debug("[DomandaImpl::getDomandeMaternaDaVerificare] - END");
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
		Logger logger = getLogger(null);
		logger.debug("[DomandaImpl::getElencoNidi] - START");

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
		// inizio misurazione
		watcher.start();

		/*PROTECTED REGION ID(R1708550410) ENABLED START*/

		/*PROTECTED REGION END*/
		try {
			/*PROTECTED REGION ID(R1501439082) ENABLED START*/

			this.domandaService.logAudit(callerInfo);

			List<Nido> result = this.domandaNidoReadService.getElencoNidi(idDomanda);

			return ConvertUtils.toArray(result, Nido.class);

			/*PROTECTED REGION END*/
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error("[DomandaImpl::getElencoNidi] - Errore CSI occorso durante l'esecuzione del metodo:" + ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error("[DomandaImpl::getElencoNidi] - Errore imprevisto occorso durante l'esecuzione del metodo:"
						+ ex, ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaImpl", "getElencoNidi()", "invocazione servizio [domanda]::[getElencoNidi]",
					"(valore input omesso)");
			logger.debug("[DomandaImpl::getElencoNidi] - END");
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
		Logger logger = getLogger(null);
		logger.debug("[DomandaImpl::getElencoMaterne] - START");

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
		// inizio misurazione
		watcher.start();

		/*PROTECTED REGION ID(R-1333927238) ENABLED START*/

		/*PROTECTED REGION END*/
		try {
			/*PROTECTED REGION ID(R480504666) ENABLED START*/

			this.domandaService.logAudit(callerInfo);

			List<Materna> result = this.domandaMaternaReadService.getElencoMaterne(idDomanda);

			return ConvertUtils.toArray(result, Materna.class);

			/*PROTECTED REGION END*/
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error(
						"[DomandaImpl::getElencoMaterne] - Errore CSI occorso durante l'esecuzione del metodo:" + ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[DomandaImpl::getElencoMaterne] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaImpl", "getElencoMaterne()",
					"invocazione servizio [domanda]::[getElencoMaterne]", "(valore input omesso)");
			logger.debug("[DomandaImpl::getElencoMaterne] - END");
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
		Logger logger = getLogger(null);
		logger.debug("[DomandaImpl::modificaStatoNidi] - START");

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
		// inizio misurazione
		watcher.start();

		/*PROTECTED REGION ID(R235017355) ENABLED START*/

		/*PROTECTED REGION END*/
		try {
			/*PROTECTED REGION ID(R647831531) ENABLED START*/

			this.domandaService.logAudit(callerInfo);

			DomandaNido domandaNido = this.domandaNidoReadService.readDomandaNido(idDomanda);
			List<Nido> nidi = ConvertUtils.toList(elencoNidi);

			this.istruttoriaService.modificaStatoNidi(domandaNido, nidi);

			/*PROTECTED REGION END*/
		} catch (RuntimeException ex) {
			sessionContext.setRollbackOnly();
			logger.error(
					"[SrvbibliotecaImpl::leggiBiblioteca] - Errore imprevisto occorso durante l'esecuzione del metodo:"
							+ ex + "Forzata RollBack Transazione",
					ex);
			throw new UnrecoverableException(
					"Errore imprevisto occorso durante l'esecuzione del metodo:" + ex + "Forzata RollBack Transazione",
					ex);
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error(
						"[DomandaImpl::modificaStatoNidi] - Errore CSI occorso durante l'esecuzione del metodo:" + ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[DomandaImpl::modificaStatoNidi] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaImpl", "modificaStatoNidi()",
					"invocazione servizio [domanda]::[modificaStatoNidi]", "(valore input omesso)");
			logger.debug("[DomandaImpl::modificaStatoNidi] - END");
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
		Logger logger = getLogger(null);
		logger.debug("[DomandaImpl::modificaStatoMaterne] - START");

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
		// inizio misurazione
		watcher.start();

		/*PROTECTED REGION ID(R-496436327) ENABLED START*/

		/*PROTECTED REGION END*/
		try {
			/*PROTECTED REGION ID(R1159312441) ENABLED START*/

			this.domandaService.logAudit(callerInfo);

			DomandaMaterna domandaMaterna = this.domandaMaternaReadService.readDomandaMaterna(idDomanda);
			List<Materna> materne = ConvertUtils.toList(elencoMaterne);

			this.istruttoriaService.modificaStatoMaterne(domandaMaterna, materne);

			/*PROTECTED REGION END*/
		} catch (RuntimeException ex) {
			sessionContext.setRollbackOnly();
			logger.error(
					"[SrvbibliotecaImpl::leggiBiblioteca] - Errore imprevisto occorso durante l'esecuzione del metodo:"
							+ ex + "Forzata RollBack Transazione",
					ex);
			throw new UnrecoverableException(
					"Errore imprevisto occorso durante l'esecuzione del metodo:" + ex + "Forzata RollBack Transazione",
					ex);
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error("[DomandaImpl::modificaStatoMaterne] - Errore CSI occorso durante l'esecuzione del metodo:"
						+ ex, ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[DomandaImpl::modificaStatoMaterne] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaImpl", "modificaStatoMaterne()",
					"invocazione servizio [domanda]::[modificaStatoMaterne]", "(valore input omesso)");
			logger.debug("[DomandaImpl::modificaStatoMaterne] - END");
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
		Logger logger = getLogger(null);
		logger.debug("[DomandaImpl::getTestataDomandaAccettazione] - START");

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
		// inizio misurazione
		watcher.start();

		/*PROTECTED REGION ID(R335677560) ENABLED START*/

		/*PROTECTED REGION END*/
		try {
			/*PROTECTED REGION ID(R780600280) ENABLED START*/

			this.domandaService.logAudit(callerInfo);

			DomandaNido domandaNido = this.domandaNidoReadService.readDomandaNido(idDomanda);

			this.accettazioneService.checkDomanda(domandaNido, cfRichiedente,
					AccettazioneService.TipoOperazione.ELENCO);

			List<Nido> elencoNidi = ConvertUtils.toList(domandaNido.getElencoNidi());
			List<CondizionePunteggio> condizioniPunteggio = ConvertUtils.toList(domandaNido.getCondizioniPunteggio());

			return this.accettazioneService.getDatiAccettazione(idDomanda, elencoNidi, condizioniPunteggio, null);

			/*PROTECTED REGION END*/
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error(
						"[DomandaImpl::getTestataDomandaAccettazione] - Errore CSI occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[DomandaImpl::getTestataDomandaAccettazione] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaImpl", "getTestataDomandaAccettazione()",
					"invocazione servizio [domanda]::[getTestataDomandaAccettazione]", "(valore input omesso)");
			logger.debug("[DomandaImpl::getTestataDomandaAccettazione] - END");
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
		Logger logger = getLogger(null);
		logger.debug("[DomandaImpl::accettaPreferenzaNidi] - START");

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
		// inizio misurazione
		watcher.start();

		/*PROTECTED REGION ID(R-1186057355) ENABLED START*/

		/*PROTECTED REGION END*/
		try {
			/*PROTECTED REGION ID(R-1397453099) ENABLED START*/

			this.domandaService.logAudit(callerInfo);

			DomandaNido domandaNido = this.domandaNidoReadService.readDomandaNido(idDomanda);

			this.accettazioneService.checkDomanda(domandaNido, cfRichiedente,
					AccettazioneService.TipoOperazione.ACCETTA);

			this.accettazioneService.accettaPreferenza(TipoScuola.NID, idDomanda, cfOperatore, codScuola,
					codTipoFrequenza, telRichiedente, codTipoPasto);

			this.accettazioneService.aggiornaTelefonoRichiedente(idDomanda, telRichiedente);

			domandaNido = this.domandaNidoReadService.readDomandaNido(idDomanda);

			List<Nido> elencoNidi = ConvertUtils.toList(domandaNido.getElencoNidi());

			return this.accettazioneService.getDatiAccettazione(idDomanda, elencoNidi, null, codScuola);

			/*PROTECTED REGION END*/
		} catch (RuntimeException ex) {
			sessionContext.setRollbackOnly();
			logger.error(
					"[SrvbibliotecaImpl::leggiBiblioteca] - Errore imprevisto occorso durante l'esecuzione del metodo:"
							+ ex + "Forzata RollBack Transazione",
					ex);
			throw new UnrecoverableException(
					"Errore imprevisto occorso durante l'esecuzione del metodo:" + ex + "Forzata RollBack Transazione",
					ex);
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error(
						"[DomandaImpl::accettaPreferenzaNidi] - Errore CSI occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[DomandaImpl::accettaPreferenzaNidi] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaImpl", "accettaPreferenzaNidi()",
					"invocazione servizio [domanda]::[accettaPreferenzaNidi]", "(valore input omesso)");
			logger.debug("[DomandaImpl::accettaPreferenzaNidi] - END");
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
		Logger logger = getLogger(null);
		logger.debug("[DomandaImpl::accettaPreferenzaMaterne] - START");

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
		// inizio misurazione
		watcher.start();

		/*PROTECTED REGION ID(R-240485265) ENABLED START*/

		/*PROTECTED REGION END*/
		try {
			/*PROTECTED REGION ID(R-1509038833) ENABLED START*/

			this.domandaService.logAudit(callerInfo);

			DomandaMaterna domandaMaterna = this.domandaMaternaReadService.readDomandaMaterna(idDomanda);

			this.accettazioneService.checkDomandaMaterna(domandaMaterna, cfRichiedente,
					AccettazioneService.TipoOperazione.ACCETTA);

			this.accettazioneService.accettaPreferenza(TipoScuola.MAT, idDomanda, cfOperatore, codScuola,
					codTipoFrequenza, telRichiedente, codTipoPasto);

			this.accettazioneService.aggiornaTelefonoRichiedente(idDomanda, telRichiedente);

			domandaMaterna = this.domandaMaternaReadService.readDomandaMaterna(idDomanda);

			List<Materna> elencoMaterne = ConvertUtils.toList(domandaMaterna.getElencoMaterne());

			return this.accettazioneService.getDatiAccettazioneMaterna(idDomanda, elencoMaterne, null, codScuola);

			/*PROTECTED REGION END*/
		} catch (RuntimeException ex) {
			sessionContext.setRollbackOnly();
			logger.error(
					"[SrvbibliotecaImpl::leggiBiblioteca] - Errore imprevisto occorso durante l'esecuzione del metodo:"
							+ ex + "Forzata RollBack Transazione",
					ex);
			throw new UnrecoverableException(
					"Errore imprevisto occorso durante l'esecuzione del metodo:" + ex + "Forzata RollBack Transazione",
					ex);
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error(
						"[DomandaImpl::accettaPreferenzaMaterne] - Errore CSI occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[DomandaImpl::accettaPreferenzaMaterne] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaImpl", "accettaPreferenzaMaterne()",
					"invocazione servizio [domanda]::[accettaPreferenzaMaterne]", "(valore input omesso)");
			logger.debug("[DomandaImpl::accettaPreferenzaMaterne] - END");
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
		Logger logger = getLogger(null);
		logger.debug("[DomandaImpl::rifiutaPreferenzaNidi] - START");

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
		// inizio misurazione
		watcher.start();

		/*PROTECTED REGION ID(R-919465216) ENABLED START*/

		/*PROTECTED REGION END*/
		try {
			/*PROTECTED REGION ID(R-1130860960) ENABLED START*/

			this.domandaService.logAudit(callerInfo);

			DomandaNido domandaNido = this.domandaNidoReadService.readDomandaNido(idDomanda);

			this.accettazioneService.checkDomanda(domandaNido, cfRichiedente,
					AccettazioneService.TipoOperazione.RIFIUTA);

			this.accettazioneService.rifiutaPreferenza(TipoScuola.NID, idDomanda, cfOperatore, codScuola,
					codTipoFrequenza);

			domandaNido = this.domandaNidoReadService.readDomandaNido(idDomanda);

			List<Nido> elencoNidi = ConvertUtils.toList(domandaNido.getElencoNidi());

			return this.accettazioneService.getDatiAccettazione(idDomanda, elencoNidi, null, codScuola);

			/*PROTECTED REGION END*/
		} catch (RuntimeException ex) {
			sessionContext.setRollbackOnly();
			logger.error(
					"[SrvbibliotecaImpl::leggiBiblioteca] - Errore imprevisto occorso durante l'esecuzione del metodo:"
							+ ex + "Forzata RollBack Transazione",
					ex);
			throw new UnrecoverableException(
					"Errore imprevisto occorso durante l'esecuzione del metodo:" + ex + "Forzata RollBack Transazione",
					ex);
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error(
						"[DomandaImpl::rifiutaPreferenzaNidi] - Errore CSI occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[DomandaImpl::rifiutaPreferenzaNidi] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaImpl", "rifiutaPreferenzaNidi()",
					"invocazione servizio [domanda]::[rifiutaPreferenzaNidi]", "(valore input omesso)");
			logger.debug("[DomandaImpl::rifiutaPreferenzaNidi] - END");
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
		Logger logger = getLogger(null);
		logger.debug("[DomandaImpl::rifiutaPreferenzaMaterne] - START");

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
		// inizio misurazione
		watcher.start();

		/*PROTECTED REGION ID(R411397380) ENABLED START*/

		/*PROTECTED REGION END*/
		try {
			/*PROTECTED REGION ID(R-857156188) ENABLED START*/

			this.domandaService.logAudit(callerInfo);

			DomandaMaterna domandaMaterna = this.domandaMaternaReadService.readDomandaMaterna(idDomanda);

			this.accettazioneService.checkDomandaMaterna(domandaMaterna, cfRichiedente,
					AccettazioneService.TipoOperazione.RIFIUTA);

			this.accettazioneService.rifiutaPreferenza(TipoScuola.MAT, idDomanda, cfOperatore, codScuola,
					codTipoFrequenza);

			domandaMaterna = this.domandaMaternaReadService.readDomandaMaterna(idDomanda);

			List<Materna> elencoMaterne = ConvertUtils.toList(domandaMaterna.getElencoMaterne());

			return this.accettazioneService.getDatiAccettazioneMaterna(idDomanda, elencoMaterne, null, codScuola);
			/*PROTECTED REGION END*/
		} catch (RuntimeException ex) {
			sessionContext.setRollbackOnly();
			logger.error(
					"[SrvbibliotecaImpl::leggiBiblioteca] - Errore imprevisto occorso durante l'esecuzione del metodo:"
							+ ex + "Forzata RollBack Transazione",
					ex);
			throw new UnrecoverableException(
					"Errore imprevisto occorso durante l'esecuzione del metodo:" + ex + "Forzata RollBack Transazione",
					ex);
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error(
						"[DomandaImpl::rifiutaPreferenzaMaterne] - Errore CSI occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[DomandaImpl::rifiutaPreferenzaMaterne] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaImpl", "rifiutaPreferenzaMaterne()",
					"invocazione servizio [domanda]::[rifiutaPreferenzaMaterne]", "(valore input omesso)");
			logger.debug("[DomandaImpl::rifiutaPreferenzaMaterne] - END");
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
		Logger logger = getLogger(null);
		logger.debug("[DomandaImpl::getParametriUltimaGraduatoriaNidi] - START");

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
		// inizio misurazione
		watcher.start();

		/*PROTECTED REGION ID(R-705051728) ENABLED START*/

		/*PROTECTED REGION END*/
		try {
			/*PROTECTED REGION ID(R-455995632) ENABLED START*/

			this.domandaService.logAudit(callerInfo);

			return this.graduatoriaService.getParametriUltimaGraduatoria(TipoScuola.NID);

			/*PROTECTED REGION END*/
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error(
						"[DomandaImpl::getParametriUltimaGraduatoriaNidi] - Errore CSI occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[DomandaImpl::getParametriUltimaGraduatoriaNidi] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaImpl", "getParametriUltimaGraduatoriaNidi()",
					"invocazione servizio [domanda]::[getParametriUltimaGraduatoriaNidi]", "(valore input omesso)");
			logger.debug("[DomandaImpl::getParametriUltimaGraduatoriaNidi] - END");
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
		Logger logger = getLogger(null);
		logger.debug("[DomandaImpl::getParametriUltimaGraduatoriaMaterne] - START");

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
		// inizio misurazione
		watcher.start();

		/*PROTECTED REGION ID(R1387249236) ENABLED START*/

		/*PROTECTED REGION END*/
		try {
			/*PROTECTED REGION ID(R-686082316) ENABLED START*/

			this.domandaService.logAudit(callerInfo);

			return this.graduatoriaService.getParametriUltimaGraduatoria(TipoScuola.MAT);

			/*PROTECTED REGION END*/
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error(
						"[DomandaImpl::getParametriUltimaGraduatoriaMaterne] - Errore CSI occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[DomandaImpl::getParametriUltimaGraduatoriaMaterne] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaImpl", "getParametriUltimaGraduatoriaMaterne()",
					"invocazione servizio [domanda]::[getParametriUltimaGraduatoriaMaterne]", "(valore input omesso)");
			logger.debug("[DomandaImpl::getParametriUltimaGraduatoriaMaterne] - END");
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
		Logger logger = getLogger(null);
		logger.debug("[DomandaImpl::getElencoGraduatorieNidi] - START");

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
		// inizio misurazione
		watcher.start();

		/*PROTECTED REGION ID(R-1990251793) ENABLED START*/

		/*PROTECTED REGION END*/
		try {
			/*PROTECTED REGION ID(R1036161935) ENABLED START*/

			this.domandaService.logAudit(callerInfo);

			List<Graduatoria> result = this.graduatoriaService.getElencoGraduatorie(TipoScuola.NID);

			return ConvertUtils.toArray(result, Graduatoria.class);

			/*PROTECTED REGION END*/
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error(
						"[DomandaImpl::getElencoGraduatorieNidi] - Errore CSI occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[DomandaImpl::getElencoGraduatorieNidi] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaImpl", "getElencoGraduatorieNidi()",
					"invocazione servizio [domanda]::[getElencoGraduatorieNidi]", "(valore input omesso)");
			logger.debug("[DomandaImpl::getElencoGraduatorieNidi] - END");
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
		Logger logger = getLogger(null);
		logger.debug("[DomandaImpl::getElencoGraduatorieMaterne] - START");

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
		// inizio misurazione
		watcher.start();

		/*PROTECTED REGION ID(R-669410635) ENABLED START*/

		/*PROTECTED REGION END*/
		try {
			/*PROTECTED REGION ID(R-731517419) ENABLED START*/

			this.domandaService.logAudit(callerInfo);

			List<Graduatoria> result = this.graduatoriaService.getElencoGraduatorie(TipoScuola.MAT);

			return ConvertUtils.toArray(result, Graduatoria.class);

			/*PROTECTED REGION END*/
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error(
						"[DomandaImpl::getElencoGraduatorieMaterne] - Errore CSI occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[DomandaImpl::getElencoGraduatorieMaterne] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaImpl", "getElencoGraduatorieMaterne()",
					"invocazione servizio [domanda]::[getElencoGraduatorieMaterne]", "(valore input omesso)");
			logger.debug("[DomandaImpl::getElencoGraduatorieMaterne] - END");
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
		Logger logger = getLogger(null);
		logger.debug("[DomandaImpl::getElencoStepGraduatoriaNidi] - START");

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
		// inizio misurazione
		watcher.start();

		/*PROTECTED REGION ID(R137527679) ENABLED START*/

		/*PROTECTED REGION END*/
		try {
			/*PROTECTED REGION ID(R-1787782625) ENABLED START*/

			this.domandaService.logAudit(callerInfo);

			List<StepGraduatoria> result = this.graduatoriaService.getElencoStepGraduatoria(TipoScuola.NID,
					codiceGraduatoria);

			return ConvertUtils.toArray(result, StepGraduatoria.class);

			/*PROTECTED REGION END*/
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error(
						"[DomandaImpl::getElencoStepGraduatoriaNidi] - Errore CSI occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[DomandaImpl::getElencoStepGraduatoriaNidi] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaImpl", "getElencoStepGraduatoriaNidi()",
					"invocazione servizio [domanda]::[getElencoStepGraduatoriaNidi]", "(valore input omesso)");
			logger.debug("[DomandaImpl::getElencoStepGraduatoriaNidi] - END");
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
		Logger logger = getLogger(null);
		logger.debug("[DomandaImpl::getElencoStepGraduatoriaMaterne] - START");

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
		// inizio misurazione
		watcher.start();

		/*PROTECTED REGION ID(R-1413481947) ENABLED START*/

		/*PROTECTED REGION END*/
		try {
			/*PROTECTED REGION ID(R955489669) ENABLED START*/

			this.domandaService.logAudit(callerInfo);

			List<StepGraduatoria> result = this.graduatoriaService.getElencoStepGraduatoria(TipoScuola.MAT,
					codiceGraduatoria);

			return ConvertUtils.toArray(result, StepGraduatoria.class);

			/*PROTECTED REGION END*/
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error(
						"[DomandaImpl::getElencoStepGraduatoriaMaterne] - Errore CSI occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[DomandaImpl::getElencoStepGraduatoriaMaterne] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaImpl", "getElencoStepGraduatoriaMaterne()",
					"invocazione servizio [domanda]::[getElencoStepGraduatoriaMaterne]", "(valore input omesso)");
			logger.debug("[DomandaImpl::getElencoStepGraduatoriaMaterne] - END");
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
		Logger logger = getLogger(null);
		logger.debug("[DomandaImpl::ricercaGraduatoria] - START");

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
		// inizio misurazione
		watcher.start();

		/*PROTECTED REGION ID(R392548806) ENABLED START*/

		/*PROTECTED REGION END*/
		try {
			/*PROTECTED REGION ID(R304886374) ENABLED START*/

			this.domandaService.logAudit(callerInfo);

			List<TestataGraduatoria> result = this.graduatoriaService.ricercaGraduatorie(filtroRicerca);

			return ConvertUtils.toArray(result, TestataGraduatoria.class);

			/*PROTECTED REGION END*/
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error(
						"[DomandaImpl::ricercaGraduatoria] - Errore CSI occorso durante l'esecuzione del metodo:" + ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[DomandaImpl::ricercaGraduatoria] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaImpl", "ricercaGraduatoria()",
					"invocazione servizio [domanda]::[ricercaGraduatoria]", "(valore input omesso)");
			logger.debug("[DomandaImpl::ricercaGraduatoria] - END");
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
		Logger logger = getLogger(null);
		logger.debug("[DomandaImpl::getParametriGraduatoriaNidi] - START");

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
		// inizio misurazione
		watcher.start();

		/*PROTECTED REGION ID(R1617812976) ENABLED START*/

		/*PROTECTED REGION END*/
		try {
			/*PROTECTED REGION ID(R1555706192) ENABLED START*/

			this.domandaService.logAudit(callerInfo);

			return this.graduatoriaService.getParametriGraduatoria(codGraduatoria, TipoScuola.NID);

			/*PROTECTED REGION END*/
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error(
						"[DomandaImpl::getParametriGraduatoriaNidi] - Errore CSI occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[DomandaImpl::getParametriGraduatoriaNidi] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaImpl", "getParametriGraduatoriaNidi()",
					"invocazione servizio [domanda]::[getParametriGraduatoriaNidi]", "(valore input omesso)");
			logger.debug("[DomandaImpl::getParametriGraduatoriaNidi] - END");
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
		Logger logger = getLogger(null);
		logger.debug("[DomandaImpl::getParametriGraduatoriaMaterne] - START");

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
		// inizio misurazione
		watcher.start();

		/*PROTECTED REGION ID(R1336572948) ENABLED START*/

		/*PROTECTED REGION END*/
		try {
			/*PROTECTED REGION ID(R-2050691916) ENABLED START*/

			this.domandaService.logAudit(callerInfo);

			return this.graduatoriaService.getParametriGraduatoria(codGraduatoria, TipoScuola.MAT);

			/*PROTECTED REGION END*/
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error(
						"[DomandaImpl::getParametriGraduatoriaMaterne] - Errore CSI occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[DomandaImpl::getParametriGraduatoriaMaterne] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaImpl", "getParametriGraduatoriaMaterne()",
					"invocazione servizio [domanda]::[getParametriGraduatoriaMaterne]", "(valore input omesso)");
			logger.debug("[DomandaImpl::getParametriGraduatoriaMaterne] - END");
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
		Logger logger = getLogger(null);
		logger.debug("[DomandaImpl::getDomandeNidoNonIstruite] - START");

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
		// inizio misurazione
		watcher.start();

		/*PROTECTED REGION ID(R-670597550) ENABLED START*/

		/*PROTECTED REGION END*/
		try {
			/*PROTECTED REGION ID(R-1341052494) ENABLED START*/

			this.domandaService.logAudit(callerInfo);

			List<Long> result = this.graduatoriaService.getDomandeNonIstruite(TipoScuola.NID);

			return ConvertUtils.toArray(result, Long.class);

			/*PROTECTED REGION END*/
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error(
						"[DomandaImpl::getDomandeNidoNonIstruite] - Errore CSI occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[DomandaImpl::getDomandeNidoNonIstruite] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaImpl", "getDomandeNidoNonIstruite()",
					"invocazione servizio [domanda]::[getDomandeNidoNonIstruite]", "(valore input omesso)");
			logger.debug("[DomandaImpl::getDomandeNidoNonIstruite] - END");
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
		Logger logger = getLogger(null);
		logger.debug("[DomandaImpl::getDomandeMaternaNonIstruite] - START");

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
		// inizio misurazione
		watcher.start();

		/*PROTECTED REGION ID(R-253471972) ENABLED START*/

		/*PROTECTED REGION END*/
		try {
			/*PROTECTED REGION ID(R2116185020) ENABLED START*/

			this.domandaService.logAudit(callerInfo);

			List<Long> result = this.graduatoriaService.getDomandeNonIstruite(TipoScuola.MAT);

			return ConvertUtils.toArray(result, Long.class);

			/*PROTECTED REGION END*/
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error(
						"[DomandaImpl::getDomandeMaternaNonIstruite] - Errore CSI occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[DomandaImpl::getDomandeMaternaNonIstruite] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaImpl", "getDomandeMaternaNonIstruite()",
					"invocazione servizio [domanda]::[getDomandeMaternaNonIstruite]", "(valore input omesso)");
			logger.debug("[DomandaImpl::getDomandeMaternaNonIstruite] - END");
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
		Logger logger = getLogger(null);
		logger.debug("[DomandaImpl::getVerifichePreventivePendenti] - START");

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
		// inizio misurazione
		watcher.start();

		/*PROTECTED REGION ID(R1877060658) ENABLED START*/

		/*PROTECTED REGION END*/
		try {
			/*PROTECTED REGION ID(R-1510204206) ENABLED START*/

			this.domandaService.logAudit(callerInfo);

			List<Long> ids = ConvertUtils.toList(idDomande);

			List<InfoVerifiche> result = this.graduatoriaService.getVerifichePendenti(ids,
					TipoVerificheIstruttoria.PREVENTIVE);

			return ConvertUtils.toArray(result, InfoVerifiche.class);

			/*PROTECTED REGION END*/
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error(
						"[DomandaImpl::getVerifichePreventivePendenti] - Errore CSI occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[DomandaImpl::getVerifichePreventivePendenti] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaImpl", "getVerifichePreventivePendenti()",
					"invocazione servizio [domanda]::[getVerifichePreventivePendenti]", "(valore input omesso)");
			logger.debug("[DomandaImpl::getVerifichePreventivePendenti] - END");
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
		Logger logger = getLogger(null);
		logger.debug("[DomandaImpl::calcolaGraduatoria] - START");

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
		// inizio misurazione
		watcher.start();

		/*PROTECTED REGION ID(R83261422) ENABLED START*/

		/*PROTECTED REGION END*/
		try {
			/*PROTECTED REGION ID(R-4401010) ENABLED START*/

			this.domandaService.logAudit(callerInfo);

			this.graduatoriaService.calcolaGraduatoria(parametri);

			/*PROTECTED REGION END*/
		} catch (RuntimeException ex) {
			sessionContext.setRollbackOnly();
			logger.error(
					"[SrvbibliotecaImpl::leggiBiblioteca] - Errore imprevisto occorso durante l'esecuzione del metodo:"
							+ ex + "Forzata RollBack Transazione",
					ex);
			throw new UnrecoverableException(
					"Errore imprevisto occorso durante l'esecuzione del metodo:" + ex + "Forzata RollBack Transazione",
					ex);
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error(
						"[DomandaImpl::calcolaGraduatoria] - Errore CSI occorso durante l'esecuzione del metodo:" + ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[DomandaImpl::calcolaGraduatoria] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaImpl", "calcolaGraduatoria()",
					"invocazione servizio [domanda]::[calcolaGraduatoria]", "(valore input omesso)");
			logger.debug("[DomandaImpl::calcolaGraduatoria] - END");
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
		Logger logger = getLogger(null);
		logger.debug("[DomandaImpl::getElencoAnniScolastici] - START");

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
		// inizio misurazione
		watcher.start();

		/*PROTECTED REGION ID(R1072529676) ENABLED START*/

		/*PROTECTED REGION END*/
		try {
			/*PROTECTED REGION ID(R-215317396) ENABLED START*/

			this.domandaService.logAudit(callerInfo);

			List<AnnoScolastico> result = this.graduatoriaService.getElencoAnniScolastici();

			return ConvertUtils.toArray(result, AnnoScolastico.class);

			/*PROTECTED REGION END*/
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error(
						"[DomandaImpl::getElencoAnniScolastici] - Errore CSI occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[DomandaImpl::getElencoAnniScolastici] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaImpl", "getElencoAnniScolastici()",
					"invocazione servizio [domanda]::[getElencoAnniScolastici]", "(valore input omesso)");
			logger.debug("[DomandaImpl::getElencoAnniScolastici] - END");
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
		Logger logger = getLogger(null);
		logger.debug("[DomandaImpl::getElencoClassiNido] - START");

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
		// inizio misurazione
		watcher.start();

		/*PROTECTED REGION ID(R-1915997407) ENABLED START*/

		/*PROTECTED REGION END*/
		try {
			/*PROTECTED REGION ID(R-338565503) ENABLED START*/

			this.domandaService.logAudit(callerInfo);

			List<Classe> result = this.graduatoriaService.getElencoClassi(codScuola, TipoScuola.NID, codAnnoScolastico);

			return ConvertUtils.toArray(result, Classe.class);

			/*PROTECTED REGION END*/
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error(
						"[DomandaImpl::getElencoClassiNido] - Errore CSI occorso durante l'esecuzione del metodo:" + ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[DomandaImpl::getElencoClassiNido] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaImpl", "getElencoClassiNido()",
					"invocazione servizio [domanda]::[getElencoClassiNido]", "(valore input omesso)");
			logger.debug("[DomandaImpl::getElencoClassiNido] - END");
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
		Logger logger = getLogger(null);
		logger.debug("[DomandaImpl::getElencoClassiMaterna] - START");

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
		// inizio misurazione
		watcher.start();

		/*PROTECTED REGION ID(R-465333499) ENABLED START*/

		/*PROTECTED REGION END*/
		try {
			/*PROTECTED REGION ID(R1571333029) ENABLED START*/

			this.domandaService.logAudit(callerInfo);

			List<Classe> result = this.graduatoriaService.getElencoClassi(codScuola, TipoScuola.MAT, codAnnoScolastico);

			return ConvertUtils.toArray(result, Classe.class);

			/*PROTECTED REGION END*/
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error(
						"[DomandaImpl::getElencoClassiMaterna] - Errore CSI occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[DomandaImpl::getElencoClassiMaterna] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaImpl", "getElencoClassiMaterna()",
					"invocazione servizio [domanda]::[getElencoClassiMaterna]", "(valore input omesso)");
			logger.debug("[DomandaImpl::getElencoClassiMaterna] - END");
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
		Logger logger = getLogger(null);
		logger.debug("[DomandaImpl::insertClasseNido] - START");

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
		// inizio misurazione
		watcher.start();

		/*PROTECTED REGION ID(R-365741004) ENABLED START*/

		/*PROTECTED REGION END*/
		try {
			/*PROTECTED REGION ID(R1448690900) ENABLED START*/

			this.domandaService.logAudit(callerInfo);

			return this.graduatoriaService.insertClasse(classe, TipoScuola.NID);

			/*PROTECTED REGION END*/
		} catch (RuntimeException ex) {
			sessionContext.setRollbackOnly();
			logger.error(
					"[SrvbibliotecaImpl::leggiBiblioteca] - Errore imprevisto occorso durante l'esecuzione del metodo:"
							+ ex + "Forzata RollBack Transazione",
					ex);
			throw new UnrecoverableException(
					"Errore imprevisto occorso durante l'esecuzione del metodo:" + ex + "Forzata RollBack Transazione",
					ex);
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error(
						"[DomandaImpl::insertClasseNido] - Errore CSI occorso durante l'esecuzione del metodo:" + ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[DomandaImpl::insertClasseNido] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaImpl", "insertClasseNido()",
					"invocazione servizio [domanda]::[insertClasseNido]", "(valore input omesso)");
			logger.debug("[DomandaImpl::insertClasseNido] - END");
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
		Logger logger = getLogger(null);
		logger.debug("[DomandaImpl::insertClasseMaterna] - START");

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
		// inizio misurazione
		watcher.start();

		/*PROTECTED REGION ID(R-560165614) ENABLED START*/

		/*PROTECTED REGION END*/
		try {
			/*PROTECTED REGION ID(R1017266290) ENABLED START*/

			this.domandaService.logAudit(callerInfo);

			return this.graduatoriaService.insertClasse(classe, TipoScuola.MAT);

			/*PROTECTED REGION END*/
		} catch (RuntimeException ex) {
			sessionContext.setRollbackOnly();
			logger.error(
					"[SrvbibliotecaImpl::leggiBiblioteca] - Errore imprevisto occorso durante l'esecuzione del metodo:"
							+ ex + "Forzata RollBack Transazione",
					ex);
			throw new UnrecoverableException(
					"Errore imprevisto occorso durante l'esecuzione del metodo:" + ex + "Forzata RollBack Transazione",
					ex);
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error(
						"[DomandaImpl::insertClasseMaterna] - Errore CSI occorso durante l'esecuzione del metodo:" + ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[DomandaImpl::insertClasseMaterna] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaImpl", "insertClasseMaterna()",
					"invocazione servizio [domanda]::[insertClasseMaterna]", "(valore input omesso)");
			logger.debug("[DomandaImpl::insertClasseMaterna] - END");
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
		Logger logger = getLogger(null);
		logger.debug("[DomandaImpl::updateClasseNido] - START");

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
		// inizio misurazione
		watcher.start();

		/*PROTECTED REGION ID(R-1867358652) ENABLED START*/

		/*PROTECTED REGION END*/
		try {
			/*PROTECTED REGION ID(R-52926748) ENABLED START*/

			this.domandaService.logAudit(callerInfo);

			return this.graduatoriaService.updateClasse(classe, TipoScuola.NID);

			/*PROTECTED REGION END*/
		} catch (RuntimeException ex) {
			sessionContext.setRollbackOnly();
			logger.error(
					"[SrvbibliotecaImpl::leggiBiblioteca] - Errore imprevisto occorso durante l'esecuzione del metodo:"
							+ ex + "Forzata RollBack Transazione",
					ex);
			throw new UnrecoverableException(
					"Errore imprevisto occorso durante l'esecuzione del metodo:" + ex + "Forzata RollBack Transazione",
					ex);
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error(
						"[DomandaImpl::updateClasseNido] - Errore CSI occorso durante l'esecuzione del metodo:" + ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[DomandaImpl::updateClasseNido] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaImpl", "updateClasseNido()",
					"invocazione servizio [domanda]::[updateClasseNido]", "(valore input omesso)");
			logger.debug("[DomandaImpl::updateClasseNido] - END");
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
		Logger logger = getLogger(null);
		logger.debug("[DomandaImpl::updateClasseMaterna] - START");

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
		// inizio misurazione
		watcher.start();

		/*PROTECTED REGION ID(R1127837954) ENABLED START*/

		/*PROTECTED REGION END*/
		try {
			/*PROTECTED REGION ID(R-1589697438) ENABLED START*/

			this.domandaService.logAudit(callerInfo);

			return this.graduatoriaService.updateClasse(classe, TipoScuola.MAT);

			/*PROTECTED REGION END*/
		} catch (RuntimeException ex) {
			sessionContext.setRollbackOnly();
			logger.error(
					"[SrvbibliotecaImpl::leggiBiblioteca] - Errore imprevisto occorso durante l'esecuzione del metodo:"
							+ ex + "Forzata RollBack Transazione",
					ex);
			throw new UnrecoverableException(
					"Errore imprevisto occorso durante l'esecuzione del metodo:" + ex + "Forzata RollBack Transazione",
					ex);
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error(
						"[DomandaImpl::updateClasseMaterna] - Errore CSI occorso durante l'esecuzione del metodo:" + ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[DomandaImpl::updateClasseMaterna] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaImpl", "updateClasseMaterna()",
					"invocazione servizio [domanda]::[updateClasseMaterna]", "(valore input omesso)");
			logger.debug("[DomandaImpl::updateClasseMaterna] - END");
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
		Logger logger = getLogger(null);
		logger.debug("[DomandaImpl::deleteClasseNido] - START");

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
		// inizio misurazione
		watcher.start();

		/*PROTECTED REGION ID(R-2104526682) ENABLED START*/

		/*PROTECTED REGION END*/
		try {
			/*PROTECTED REGION ID(R-290094778) ENABLED START*/

			this.domandaService.logAudit(callerInfo);

			return this.graduatoriaService.deleteClasse(idClasse);

			/*PROTECTED REGION END*/
		} catch (RuntimeException ex) {
			sessionContext.setRollbackOnly();
			logger.error(
					"[SrvbibliotecaImpl::leggiBiblioteca] - Errore imprevisto occorso durante l'esecuzione del metodo:"
							+ ex + "Forzata RollBack Transazione",
					ex);
			throw new UnrecoverableException(
					"Errore imprevisto occorso durante l'esecuzione del metodo:" + ex + "Forzata RollBack Transazione",
					ex);
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error(
						"[DomandaImpl::deleteClasseNido] - Errore CSI occorso durante l'esecuzione del metodo:" + ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[DomandaImpl::deleteClasseNido] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaImpl", "deleteClasseNido()",
					"invocazione servizio [domanda]::[deleteClasseNido]", "(valore input omesso)");
			logger.debug("[DomandaImpl::deleteClasseNido] - END");
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
		Logger logger = getLogger(null);
		logger.debug("[DomandaImpl::deleteClasseMaterna] - START");

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
		// inizio misurazione
		watcher.start();

		/*PROTECTED REGION ID(R876258144) ENABLED START*/

		/*PROTECTED REGION END*/
		try {
			/*PROTECTED REGION ID(R-1841277248) ENABLED START*/

			this.domandaService.logAudit(callerInfo);

			return this.graduatoriaService.deleteClasse(idClasse);

			/*PROTECTED REGION END*/
		} catch (RuntimeException ex) {
			sessionContext.setRollbackOnly();
			logger.error(
					"[SrvbibliotecaImpl::leggiBiblioteca] - Errore imprevisto occorso durante l'esecuzione del metodo:"
							+ ex + "Forzata RollBack Transazione",
					ex);
			throw new UnrecoverableException(
					"Errore imprevisto occorso durante l'esecuzione del metodo:" + ex + "Forzata RollBack Transazione",
					ex);
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error(
						"[DomandaImpl::deleteClasseMaterna] - Errore CSI occorso durante l'esecuzione del metodo:" + ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[DomandaImpl::deleteClasseMaterna] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaImpl", "deleteClasseMaterna()",
					"invocazione servizio [domanda]::[deleteClasseMaterna]", "(valore input omesso)");
			logger.debug("[DomandaImpl::deleteClasseMaterna] - END");
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
		Logger logger = getLogger(null);
		logger.debug("[DomandaImpl::getElencoNidiDse] - START");

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
		// inizio misurazione
		watcher.start();

		/*PROTECTED REGION ID(R-232091572) ENABLED START*/

		/*PROTECTED REGION END*/
		try {
			/*PROTECTED REGION ID(R1582340332) ENABLED START*/

			this.domandaService.logAudit(callerInfo);

			List<Nido> result = this.graduatoriaService.getElencoNidi(idDomanda);

			return ConvertUtils.toArray(result, Nido.class);

			/*PROTECTED REGION END*/
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error(
						"[DomandaImpl::getElencoNidiDse] - Errore CSI occorso durante l'esecuzione del metodo:" + ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[DomandaImpl::getElencoNidiDse] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaImpl", "getElencoNidiDse()",
					"invocazione servizio [domanda]::[getElencoNidiDse]", "(valore input omesso)");
			logger.debug("[DomandaImpl::getElencoNidiDse] - END");
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
		Logger logger = getLogger(null);
		logger.debug("[DomandaImpl::getElencoMaterneDse] - START");

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
		// inizio misurazione
		watcher.start();

		/*PROTECTED REGION ID(R-1988855652) ENABLED START*/

		/*PROTECTED REGION END*/
		try {
			/*PROTECTED REGION ID(R-411423748) ENABLED START*/

			this.domandaService.logAudit(callerInfo);

			throw new UnsupportedOperationException();

			/*PROTECTED REGION END*/
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error(
						"[DomandaImpl::getElencoMaterneDse] - Errore CSI occorso durante l'esecuzione del metodo:" + ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[DomandaImpl::getElencoMaterneDse] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaImpl", "getElencoMaterneDse()",
					"invocazione servizio [domanda]::[getElencoMaterneDse]", "(valore input omesso)");
			logger.debug("[DomandaImpl::getElencoMaterneDse] - END");
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
		Logger logger = getLogger(null);
		logger.debug("[DomandaImpl::getResidenzeForzateNidi] - START");

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
		// inizio misurazione
		watcher.start();

		/*PROTECTED REGION ID(R-383009824) ENABLED START*/

		/*PROTECTED REGION END*/
		try {
			/*PROTECTED REGION ID(R-1670856896) ENABLED START*/

			this.domandaService.logAudit(callerInfo);

			return this.graduatoriaService.getResidenzeForzate(TipoScuola.NID);

			/*PROTECTED REGION END*/
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error(
						"[DomandaImpl::getResidenzeForzateNidi] - Errore CSI occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[DomandaImpl::getResidenzeForzateNidi] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaImpl", "getResidenzeForzateNidi()",
					"invocazione servizio [domanda]::[getResidenzeForzateNidi]", "(valore input omesso)");
			logger.debug("[DomandaImpl::getResidenzeForzateNidi] - END");
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
		Logger logger = getLogger(null);
		logger.debug("[DomandaImpl::getResidenzeForzateMaterne] - START");

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
		// inizio misurazione
		watcher.start();

		/*PROTECTED REGION ID(R380672036) ENABLED START*/

		/*PROTECTED REGION END*/
		try {
			/*PROTECTED REGION ID(R1071405252) ENABLED START*/

			this.domandaService.logAudit(callerInfo);

			return this.graduatoriaService.getResidenzeForzate(TipoScuola.MAT);

			/*PROTECTED REGION END*/
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error(
						"[DomandaImpl::getResidenzeForzateMaterne] - Errore CSI occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[DomandaImpl::getResidenzeForzateMaterne] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaImpl", "getResidenzeForzateMaterne()",
					"invocazione servizio [domanda]::[getResidenzeForzateMaterne]", "(valore input omesso)");
			logger.debug("[DomandaImpl::getResidenzeForzateMaterne] - END");
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
		Logger logger = getLogger(null);
		logger.debug("[DomandaImpl::getGraduatoriaCompletaNidi] - START");

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
		// inizio misurazione
		watcher.start();

		/*PROTECTED REGION ID(R-1065528868) ENABLED START*/

		/*PROTECTED REGION END*/
		try {
			/*PROTECTED REGION ID(R-374795652) ENABLED START*/

			this.domandaService.logAudit(callerInfo);

			List<GraduatoriaCompleta> result = this.graduatoriaService.getGraduatoriaCompleta(TipoScuola.NID);

			return ConvertUtils.toArray(result, GraduatoriaCompleta.class);

			/*PROTECTED REGION END*/
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error(
						"[DomandaImpl::getGraduatoriaCompletaNidi] - Errore CSI occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[DomandaImpl::getGraduatoriaCompletaNidi] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaImpl", "getGraduatoriaCompletaNidi()",
					"invocazione servizio [domanda]::[getGraduatoriaCompletaNidi]", "(valore input omesso)");
			logger.debug("[DomandaImpl::getGraduatoriaCompletaNidi] - END");
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
		Logger logger = getLogger(null);
		logger.debug("[DomandaImpl::getGraduatoriaCompletaMaterne] - START");

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
		// inizio misurazione
		watcher.start();

		/*PROTECTED REGION ID(R-168988504) ENABLED START*/

		/*PROTECTED REGION END*/
		try {
			/*PROTECTED REGION ID(R275934216) ENABLED START*/

			this.domandaService.logAudit(callerInfo);

			List<GraduatoriaCompleta> result = this.graduatoriaService.getGraduatoriaCompleta(TipoScuola.MAT);

			return ConvertUtils.toArray(result, GraduatoriaCompleta.class);

			/*PROTECTED REGION END*/
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error(
						"[DomandaImpl::getGraduatoriaCompletaMaterne] - Errore CSI occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[DomandaImpl::getGraduatoriaCompletaMaterne] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaImpl", "getGraduatoriaCompletaMaterne()",
					"invocazione servizio [domanda]::[getGraduatoriaCompletaMaterne]", "(valore input omesso)");
			logger.debug("[DomandaImpl::getGraduatoriaCompletaMaterne] - END");
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
		Logger logger = getLogger(null);
		logger.debug("[DomandaImpl::updateFlagAmmissioni] - START");

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
		// inizio misurazione
		watcher.start();

		/*PROTECTED REGION ID(R1560600518) ENABLED START*/

		/*PROTECTED REGION END*/
		try {
			/*PROTECTED REGION ID(R-1078618010) ENABLED START*/

			this.domandaService.logAudit(callerInfo);

			List<Long> list = ConvertUtils.toList(idClasseList);
			return this.graduatoriaService.updateFlagAmmissioni(list, value);

			/*PROTECTED REGION END*/
		} catch (RuntimeException ex) {
			sessionContext.setRollbackOnly();
			logger.error(
					"[SrvbibliotecaImpl::leggiBiblioteca] - Errore imprevisto occorso durante l'esecuzione del metodo:"
							+ ex + "Forzata RollBack Transazione",
					ex);
			throw new UnrecoverableException(
					"Errore imprevisto occorso durante l'esecuzione del metodo:" + ex + "Forzata RollBack Transazione",
					ex);
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error("[DomandaImpl::updateFlagAmmissioni] - Errore CSI occorso durante l'esecuzione del metodo:"
						+ ex, ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[DomandaImpl::updateFlagAmmissioni] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaImpl", "updateFlagAmmissioni()",
					"invocazione servizio [domanda]::[updateFlagAmmissioni]", "(valore input omesso)");
			logger.debug("[DomandaImpl::updateFlagAmmissioni] - END");
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
		Logger logger = getLogger(null);
		logger.debug("[DomandaImpl::getInfoStepGraduatorieNido] - START");

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
		// inizio misurazione
		watcher.start();

		/*PROTECTED REGION ID(R-500757993) ENABLED START*/

		/*PROTECTED REGION END*/
		try {
			/*PROTECTED REGION ID(R189975223) ENABLED START*/

			this.domandaService.logAudit(callerInfo);

			List<InfoStepGraduatoria> result = this.graduatoriaService.getInfoStepGraduatorie(TipoScuola.NID);
			return ConvertUtils.toArray(result, InfoStepGraduatoria.class);

			/*PROTECTED REGION END*/
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error(
						"[DomandaImpl::getInfoStepGraduatorieNido] - Errore CSI occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[DomandaImpl::getInfoStepGraduatorieNido] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaImpl", "getInfoStepGraduatorieNido()",
					"invocazione servizio [domanda]::[getInfoStepGraduatorieNido]", "(valore input omesso)");
			logger.debug("[DomandaImpl::getInfoStepGraduatorieNido] - END");
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
		Logger logger = getLogger(null);
		logger.debug("[DomandaImpl::getInfoStepGraduatorieMaterna] - START");

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
		// inizio misurazione
		watcher.start();

		/*PROTECTED REGION ID(R1533071439) ENABLED START*/

		/*PROTECTED REGION END*/
		try {
			/*PROTECTED REGION ID(R1977994159) ENABLED START*/

			this.domandaService.logAudit(callerInfo);

			List<InfoStepGraduatoria> result = this.graduatoriaService.getInfoStepGraduatorie(TipoScuola.MAT);
			return ConvertUtils.toArray(result, InfoStepGraduatoria.class);

			/*PROTECTED REGION END*/
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error(
						"[DomandaImpl::getInfoStepGraduatorieMaterna] - Errore CSI occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[DomandaImpl::getInfoStepGraduatorieMaterna] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaImpl", "getInfoStepGraduatorieMaterna()",
					"invocazione servizio [domanda]::[getInfoStepGraduatorieMaterna]", "(valore input omesso)");
			logger.debug("[DomandaImpl::getInfoStepGraduatorieMaterna] - END");
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
		Logger logger = getLogger(null);
		logger.debug("[DomandaImpl::getGraduatoriaApprovazioneNidi] - START");

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
		// inizio misurazione
		watcher.start();

		/*PROTECTED REGION ID(R1803722709) ENABLED START*/

		/*PROTECTED REGION END*/
		try {
			/*PROTECTED REGION ID(R-1583542155) ENABLED START*/

			this.domandaService.logAudit(callerInfo);

			List<GraduatoriaApprovazione> result = this.graduatoriaService.getGraduatoriaApprovazione(codiceGraduatoria,
					step, codiceStatoGraduatoria, TipoScuola.NID);

			return ConvertUtils.toArray(result, GraduatoriaApprovazione.class);

			/*PROTECTED REGION END*/
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error(
						"[DomandaImpl::getGraduatoriaApprovazioneNidi] - Errore CSI occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[DomandaImpl::getGraduatoriaApprovazioneNidi] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaImpl", "getGraduatoriaApprovazioneNidi()",
					"invocazione servizio [domanda]::[getGraduatoriaApprovazioneNidi]", "(valore input omesso)");
			logger.debug("[DomandaImpl::getGraduatoriaApprovazioneNidi] - END");
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
		Logger logger = getLogger(null);
		logger.debug("[DomandaImpl::getGraduatoriaApprovazioneMaterne] - START");

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
		// inizio misurazione
		watcher.start();

		/*PROTECTED REGION ID(R-734383089) ENABLED START*/

		/*PROTECTED REGION END*/
		try {
			/*PROTECTED REGION ID(R-485326993) ENABLED START*/

			this.domandaService.logAudit(callerInfo);

			List<GraduatoriaApprovazione> result = this.graduatoriaService.getGraduatoriaApprovazione(codiceGraduatoria,
					step, codiceStatoGraduatoria, TipoScuola.MAT);

			return ConvertUtils.toArray(result, GraduatoriaApprovazione.class);

			/*PROTECTED REGION END*/
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error(
						"[DomandaImpl::getGraduatoriaApprovazioneMaterne] - Errore CSI occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[DomandaImpl::getGraduatoriaApprovazioneMaterne] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaImpl", "getGraduatoriaApprovazioneMaterne()",
					"invocazione servizio [domanda]::[getGraduatoriaApprovazioneMaterne]", "(valore input omesso)");
			logger.debug("[DomandaImpl::getGraduatoriaApprovazioneMaterne] - END");
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
		Logger logger = getLogger(null);
		logger.debug("[DomandaImpl::insertNidoFuoriTermine] - START");

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
		// inizio misurazione
		watcher.start();

		/*PROTECTED REGION ID(R1236998980) ENABLED START*/

		/*PROTECTED REGION END*/
		try {
			/*PROTECTED REGION ID(R-1021301788) ENABLED START*/

			this.domandaService.logAudit(callerInfo);

			this.accettazioneService.aggiungiPreferenzaFuoriTermine(TipoScuola.NID, idDomanda, cfOperatore, codScuola,
					codTipoFrequenza);

			/*PROTECTED REGION END*/
		} catch (RuntimeException ex) {
			sessionContext.setRollbackOnly();
			logger.error(
					"[SrvbibliotecaImpl::leggiBiblioteca] - Errore imprevisto occorso durante l'esecuzione del metodo:"
							+ ex + "Forzata RollBack Transazione",
					ex);
			throw new UnrecoverableException(
					"Errore imprevisto occorso durante l'esecuzione del metodo:" + ex + "Forzata RollBack Transazione",
					ex);
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error(
						"[DomandaImpl::insertNidoFuoriTermine] - Errore CSI occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[DomandaImpl::insertNidoFuoriTermine] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaImpl", "insertNidoFuoriTermine()",
					"invocazione servizio [domanda]::[insertNidoFuoriTermine]", "(valore input omesso)");
			logger.debug("[DomandaImpl::insertNidoFuoriTermine] - END");
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
		Logger logger = getLogger(null);
		logger.debug("[DomandaImpl::insertMaternaFuoriTermine] - START");

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
		// inizio misurazione
		watcher.start();

		/*PROTECTED REGION ID(R-1033669412) ENABLED START*/

		/*PROTECTED REGION END*/
		try {
			/*PROTECTED REGION ID(R-1704124356) ENABLED START*/

			this.domandaService.logAudit(callerInfo);

			this.accettazioneService.aggiungiPreferenzaFuoriTermine(TipoScuola.MAT, idDomanda, cfOperatore, codScuola,
					codTipoFrequenza);

			/*PROTECTED REGION END*/
		} catch (RuntimeException ex) {
			sessionContext.setRollbackOnly();
			logger.error(
					"[SrvbibliotecaImpl::leggiBiblioteca] - Errore imprevisto occorso durante l'esecuzione del metodo:"
							+ ex + "Forzata RollBack Transazione",
					ex);
			throw new UnrecoverableException(
					"Errore imprevisto occorso durante l'esecuzione del metodo:" + ex + "Forzata RollBack Transazione",
					ex);
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error(
						"[DomandaImpl::insertMaternaFuoriTermine] - Errore CSI occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[DomandaImpl::insertMaternaFuoriTermine] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaImpl", "insertMaternaFuoriTermine()",
					"invocazione servizio [domanda]::[insertMaternaFuoriTermine]", "(valore input omesso)");
			logger.debug("[DomandaImpl::insertMaternaFuoriTermine] - END");
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
		Logger logger = getLogger(null);
		logger.debug("[DomandaImpl::generaRicevuta] - START");

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
		// inizio misurazione
		watcher.start();

		/*PROTECTED REGION ID(R-107039375) ENABLED START*/

		/*PROTECTED REGION END*/
		try {
			/*PROTECTED REGION ID(R2062444049) ENABLED START*/

			this.domandaService.logAudit(callerInfo);

			return this.allegatoService.generaRicevutaAllegato(idAllegato);

			/*PROTECTED REGION END*/
		} catch (RuntimeException ex) {
			sessionContext.setRollbackOnly();
			logger.error(
					"[SrvbibliotecaImpl::leggiBiblioteca] - Errore imprevisto occorso durante l'esecuzione del metodo:"
							+ ex + "Forzata RollBack Transazione",
					ex);
			throw new UnrecoverableException(
					"Errore imprevisto occorso durante l'esecuzione del metodo:" + ex + "Forzata RollBack Transazione",
					ex);
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error("[DomandaImpl::generaRicevuta] - Errore CSI occorso durante l'esecuzione del metodo:" + ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[DomandaImpl::generaRicevuta] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaImpl", "generaRicevuta()", "invocazione servizio [domanda]::[generaRicevuta]",
					"(valore input omesso)");
			logger.debug("[DomandaImpl::generaRicevuta] - END");
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
		Logger logger = getLogger(null);
		logger.debug("[DomandaImpl::generaRicevutaAccettazione] - START");

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
		// inizio misurazione
		watcher.start();

		/*PROTECTED REGION ID(R-1630954581) ENABLED START*/

		/*PROTECTED REGION END*/
		try {
			/*PROTECTED REGION ID(R-940221365) ENABLED START*/

			this.domandaService.logAudit(callerInfo);

			return this.accettazioneService.getRicevutaAccettazione(idDomanda, cfRichiedente);

			/*PROTECTED REGION END*/
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error(
						"[DomandaImpl::generaRicevutaAccettazione] - Errore CSI occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[DomandaImpl::generaRicevutaAccettazione] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaImpl", "generaRicevutaAccettazione()",
					"invocazione servizio [domanda]::[generaRicevutaAccettazione]", "(valore input omesso)");
			logger.debug("[DomandaImpl::generaRicevutaAccettazione] - END");
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
		Logger logger = getLogger(null);
		logger.debug("[DomandaImpl::getFasceEta] - START");

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
		// inizio misurazione
		watcher.start();

		/*PROTECTED REGION ID(R-1079803738) ENABLED START*/

		/*PROTECTED REGION END*/
		try {
			/*PROTECTED REGION ID(R-20802554) ENABLED START*/

			this.domandaService.logAudit(callerInfo);

			List<FasciaEta> result = this.domandaService.getFasceEta();

			return ConvertUtils.toArray(result, FasciaEta.class);

			/*PROTECTED REGION END*/
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error("[DomandaImpl::getFasceEta] - Errore CSI occorso durante l'esecuzione del metodo:" + ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[DomandaImpl::getFasceEta] - Errore imprevisto occorso durante l'esecuzione del metodo:" + ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaImpl", "getFasceEta()", "invocazione servizio [domanda]::[getFasceEta]",
					"(valore input omesso)");
			logger.debug("[DomandaImpl::getFasceEta] - END");
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
		Logger logger = getLogger(null);
		logger.debug("[DomandaImpl::getAnagraficaGraduatorie] - START");

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
		// inizio misurazione
		watcher.start();

		/*PROTECTED REGION ID(R1010743688) ENABLED START*/

		/*PROTECTED REGION END*/
		try {
			/*PROTECTED REGION ID(R-257809880) ENABLED START*/

			this.domandaService.logAudit(callerInfo);

			List<AnagraficaGraduatoria> result = this.anagraficaService.getAnagraficaGraduatorie();

			return ConvertUtils.toArray(result, AnagraficaGraduatoria.class);

			/*PROTECTED REGION END*/
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error(
						"[DomandaImpl::getAnagraficaGraduatorie] - Errore CSI occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[DomandaImpl::getAnagraficaGraduatorie] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaImpl", "getAnagraficaGraduatorie()",
					"invocazione servizio [domanda]::[getAnagraficaGraduatorie]", "(valore input omesso)");
			logger.debug("[DomandaImpl::getAnagraficaGraduatorie] - END");
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
		Logger logger = getLogger(null);
		logger.debug("[DomandaImpl::getAnagraficaGraduatoria] - START");

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
		// inizio misurazione
		watcher.start();

		/*PROTECTED REGION ID(R1010743684) ENABLED START*/

		/*PROTECTED REGION END*/
		try {
			/*PROTECTED REGION ID(R-257809884) ENABLED START*/

			this.domandaService.logAudit(callerInfo);

			return this.anagraficaService.getAnagraficaGraduatoria(codOrdineScuola, codAnagraficaGraduatoria,
					codAnnoScolastico);

			/*PROTECTED REGION END*/
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error(
						"[DomandaImpl::getAnagraficaGraduatoria] - Errore CSI occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[DomandaImpl::getAnagraficaGraduatoria] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaImpl", "getAnagraficaGraduatoria()",
					"invocazione servizio [domanda]::[getAnagraficaGraduatoria]", "(valore input omesso)");
			logger.debug("[DomandaImpl::getAnagraficaGraduatoria] - END");
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
		Logger logger = getLogger(null);
		logger.debug("[DomandaImpl::insertAnagraficaGraduatoria] - START");

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
		// inizio misurazione
		watcher.start();

		/*PROTECTED REGION ID(R1690442225) ENABLED START*/

		/*PROTECTED REGION END*/
		try {
			/*PROTECTED REGION ID(R1628335441) ENABLED START*/

			this.domandaService.logAudit(callerInfo);

			return this.anagraficaService.insertAnagraficaGraduatoria(anagraficaGraduatoria);

			/*PROTECTED REGION END*/
		} catch (RuntimeException ex) {
			sessionContext.setRollbackOnly();
			logger.error(
					"[SrvbibliotecaImpl::leggiBiblioteca] - Errore imprevisto occorso durante l'esecuzione del metodo:"
							+ ex + "Forzata RollBack Transazione",
					ex);
			throw new UnrecoverableException(
					"Errore imprevisto occorso durante l'esecuzione del metodo:" + ex + "Forzata RollBack Transazione",
					ex);
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error(
						"[DomandaImpl::insertAnagraficaGraduatoria] - Errore CSI occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[DomandaImpl::insertAnagraficaGraduatoria] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaImpl", "insertAnagraficaGraduatoria()",
					"invocazione servizio [domanda]::[insertAnagraficaGraduatoria]", "(valore input omesso)");
			logger.debug("[DomandaImpl::insertAnagraficaGraduatoria] - END");
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
		Logger logger = getLogger(null);
		logger.debug("[DomandaImpl::updateAnagraficaGraduatoria] - START");

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
		// inizio misurazione
		watcher.start();

		/*PROTECTED REGION ID(R468979169) ENABLED START*/

		/*PROTECTED REGION END*/
		try {
			/*PROTECTED REGION ID(R406872385) ENABLED START*/

			this.domandaService.logAudit(callerInfo);

			return this.anagraficaService.updateAnagraficaGraduatoria(anagraficaGraduatoria);

			/*PROTECTED REGION END*/
		} catch (RuntimeException ex) {
			sessionContext.setRollbackOnly();
			logger.error(
					"[SrvbibliotecaImpl::leggiBiblioteca] - Errore imprevisto occorso durante l'esecuzione del metodo:"
							+ ex + "Forzata RollBack Transazione",
					ex);
			throw new UnrecoverableException(
					"Errore imprevisto occorso durante l'esecuzione del metodo:" + ex + "Forzata RollBack Transazione",
					ex);
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error(
						"[DomandaImpl::updateAnagraficaGraduatoria] - Errore CSI occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[DomandaImpl::updateAnagraficaGraduatoria] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaImpl", "updateAnagraficaGraduatoria()",
					"invocazione servizio [domanda]::[updateAnagraficaGraduatoria]", "(valore input omesso)");
			logger.debug("[DomandaImpl::updateAnagraficaGraduatoria] - END");
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
		Logger logger = getLogger(null);
		logger.debug("[DomandaImpl::getAnagraficaStepGraduatoria] - START");

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
		// inizio misurazione
		watcher.start();

		/*PROTECTED REGION ID(R-969550952) ENABLED START*/

		/*PROTECTED REGION END*/
		try {
			/*PROTECTED REGION ID(R1400106040) ENABLED START*/

			this.domandaService.logAudit(callerInfo);

			List<AnagraficaStepGraduatoria> result = this.anagraficaService
					.getElencoAnagraficaStepGraduatoria(codOrdineScuola, codAnagraficaGraduatoria, codAnnoScolastico);

			return ConvertUtils.toArray(result, AnagraficaStepGraduatoria.class);

			/*PROTECTED REGION END*/
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error(
						"[DomandaImpl::getAnagraficaStepGraduatoria] - Errore CSI occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[DomandaImpl::getAnagraficaStepGraduatoria] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaImpl", "getAnagraficaStepGraduatoria()",
					"invocazione servizio [domanda]::[getAnagraficaStepGraduatoria]", "(valore input omesso)");
			logger.debug("[DomandaImpl::getAnagraficaStepGraduatoria] - END");
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
		Logger logger = getLogger(null);
		logger.debug("[DomandaImpl::insertAnagraficaStepGraduatoria] - START");

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
		// inizio misurazione
		watcher.start();

		/*PROTECTED REGION ID(R1141454213) ENABLED START*/

		/*PROTECTED REGION END*/
		try {
			/*PROTECTED REGION ID(R-784541467) ENABLED START*/

			this.domandaService.logAudit(callerInfo);

			return this.anagraficaService.insertAnagraficaStepGraduatoria(stepGraduatoria);

			/*PROTECTED REGION END*/
		} catch (RuntimeException ex) {
			sessionContext.setRollbackOnly();
			logger.error(
					"[SrvbibliotecaImpl::leggiBiblioteca] - Errore imprevisto occorso durante l'esecuzione del metodo:"
							+ ex + "Forzata RollBack Transazione",
					ex);
			throw new UnrecoverableException(
					"Errore imprevisto occorso durante l'esecuzione del metodo:" + ex + "Forzata RollBack Transazione",
					ex);
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error(
						"[DomandaImpl::insertAnagraficaStepGraduatoria] - Errore CSI occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[DomandaImpl::insertAnagraficaStepGraduatoria] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaImpl", "insertAnagraficaStepGraduatoria()",
					"invocazione servizio [domanda]::[insertAnagraficaStepGraduatoria]", "(valore input omesso)");
			logger.debug("[DomandaImpl::insertAnagraficaStepGraduatoria] - END");
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
		Logger logger = getLogger(null);
		logger.debug("[DomandaImpl::updateAnagraficaStepGraduatoria] - START");

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
		// inizio misurazione
		watcher.start();

		/*PROTECTED REGION ID(R1749004661) ENABLED START*/

		/*PROTECTED REGION END*/
		try {
			/*PROTECTED REGION ID(R-176991019) ENABLED START*/

			this.domandaService.logAudit(callerInfo);

			return this.anagraficaService.updateAnagraficaStepGraduatoria(stepGraduatoria);

			/*PROTECTED REGION END*/
		} catch (RuntimeException ex) {
			sessionContext.setRollbackOnly();
			logger.error(
					"[SrvbibliotecaImpl::leggiBiblioteca] - Errore imprevisto occorso durante l'esecuzione del metodo:"
							+ ex + "Forzata RollBack Transazione",
					ex);
			throw new UnrecoverableException(
					"Errore imprevisto occorso durante l'esecuzione del metodo:" + ex + "Forzata RollBack Transazione",
					ex);
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error(
						"[DomandaImpl::updateAnagraficaStepGraduatoria] - Errore CSI occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[DomandaImpl::updateAnagraficaStepGraduatoria] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaImpl", "updateAnagraficaStepGraduatoria()",
					"invocazione servizio [domanda]::[updateAnagraficaStepGraduatoria]", "(valore input omesso)");
			logger.debug("[DomandaImpl::updateAnagraficaStepGraduatoria] - END");
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
		Logger logger = getLogger(null);
		logger.debug("[DomandaImpl::deleteAnagraficaStepGraduatoria] - START");

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
		// inizio misurazione
		watcher.start();

		/*PROTECTED REGION ID(R186795731) ENABLED START*/

		/*PROTECTED REGION END*/
		try {
			/*PROTECTED REGION ID(R-1739199949) ENABLED START*/

			this.domandaService.logAudit(callerInfo);

			return this.anagraficaService.deleteAnagraficaStepGraduatoria(idStepGra);

			/*PROTECTED REGION END*/
		} catch (RuntimeException ex) {
			sessionContext.setRollbackOnly();
			logger.error(
					"[SrvbibliotecaImpl::leggiBiblioteca] - Errore imprevisto occorso durante l'esecuzione del metodo:"
							+ ex + "Forzata RollBack Transazione",
					ex);
			throw new UnrecoverableException(
					"Errore imprevisto occorso durante l'esecuzione del metodo:" + ex + "Forzata RollBack Transazione",
					ex);
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error(
						"[DomandaImpl::deleteAnagraficaStepGraduatoria] - Errore CSI occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[DomandaImpl::deleteAnagraficaStepGraduatoria] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaImpl", "deleteAnagraficaStepGraduatoria()",
					"invocazione servizio [domanda]::[deleteAnagraficaStepGraduatoria]", "(valore input omesso)");
			logger.debug("[DomandaImpl::deleteAnagraficaStepGraduatoria] - END");
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
		Logger logger = getLogger(null);
		logger.debug("[DomandaImpl::getAnagraficaEta] - START");

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
		// inizio misurazione
		watcher.start();

		/*PROTECTED REGION ID(R1025688193) ENABLED START*/

		/*PROTECTED REGION END*/
		try {
			/*PROTECTED REGION ID(R-1454847199) ENABLED START*/

			this.domandaService.logAudit(callerInfo);

			List<AnagraficaEta> result = this.anagraficaService.getAnagraficaEta(codOrdineScuola,
					codAnagraficaGraduatoria, codAnnoScolastico);

			return ConvertUtils.toArray(result, AnagraficaEta.class);

			/*PROTECTED REGION END*/
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error(
						"[DomandaImpl::getAnagraficaEta] - Errore CSI occorso durante l'esecuzione del metodo:" + ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[DomandaImpl::getAnagraficaEta] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaImpl", "getAnagraficaEta()",
					"invocazione servizio [domanda]::[getAnagraficaEta]", "(valore input omesso)");
			logger.debug("[DomandaImpl::getAnagraficaEta] - END");
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
		Logger logger = getLogger(null);
		logger.debug("[DomandaImpl::insertAnagraficaEta] - START");

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
		// inizio misurazione
		watcher.start();

		/*PROTECTED REGION ID(R-1594892306) ENABLED START*/

		/*PROTECTED REGION END*/
		try {
			/*PROTECTED REGION ID(R-17460402) ENABLED START*/

			this.domandaService.logAudit(callerInfo);

			return this.anagraficaService.insertAnagraficaEta(anagraficaEta);

			/*PROTECTED REGION END*/
		} catch (RuntimeException ex) {
			sessionContext.setRollbackOnly();
			logger.error(
					"[SrvbibliotecaImpl::leggiBiblioteca] - Errore imprevisto occorso durante l'esecuzione del metodo:"
							+ ex + "Forzata RollBack Transazione",
					ex);
			throw new UnrecoverableException(
					"Errore imprevisto occorso durante l'esecuzione del metodo:" + ex + "Forzata RollBack Transazione",
					ex);
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error(
						"[DomandaImpl::insertAnagraficaEta] - Errore CSI occorso durante l'esecuzione del metodo:" + ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[DomandaImpl::insertAnagraficaEta] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaImpl", "insertAnagraficaEta()",
					"invocazione servizio [domanda]::[insertAnagraficaEta]", "(valore input omesso)");
			logger.debug("[DomandaImpl::insertAnagraficaEta] - END");
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
		Logger logger = getLogger(null);
		logger.debug("[DomandaImpl::updateAnagraficaEta] - START");

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
		// inizio misurazione
		watcher.start();

		/*PROTECTED REGION ID(R93111262) ENABLED START*/

		/*PROTECTED REGION END*/
		try {
			/*PROTECTED REGION ID(R1670543166) ENABLED START*/

			this.domandaService.logAudit(callerInfo);

			return this.anagraficaService.updateAnagraficaEta(anagraficaEta);

			/*PROTECTED REGION END*/
		} catch (RuntimeException ex) {
			sessionContext.setRollbackOnly();
			logger.error(
					"[SrvbibliotecaImpl::leggiBiblioteca] - Errore imprevisto occorso durante l'esecuzione del metodo:"
							+ ex + "Forzata RollBack Transazione",
					ex);
			throw new UnrecoverableException(
					"Errore imprevisto occorso durante l'esecuzione del metodo:" + ex + "Forzata RollBack Transazione",
					ex);
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error(
						"[DomandaImpl::updateAnagraficaEta] - Errore CSI occorso durante l'esecuzione del metodo:" + ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[DomandaImpl::updateAnagraficaEta] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaImpl", "updateAnagraficaEta()",
					"invocazione servizio [domanda]::[updateAnagraficaEta]", "(valore input omesso)");
			logger.debug("[DomandaImpl::updateAnagraficaEta] - END");
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
		Logger logger = getLogger(null);
		logger.debug("[DomandaImpl::deleteAnagraficaEta] - START");

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
		// inizio misurazione
		watcher.start();

		/*PROTECTED REGION ID(R-158468548) ENABLED START*/

		/*PROTECTED REGION END*/
		try {
			/*PROTECTED REGION ID(R1418963356) ENABLED START*/

			this.domandaService.logAudit(callerInfo);

			return this.anagraficaService.deleteAnagraficaEta(idEta);

			/*PROTECTED REGION END*/
		} catch (RuntimeException ex) {
			sessionContext.setRollbackOnly();
			logger.error(
					"[SrvbibliotecaImpl::leggiBiblioteca] - Errore imprevisto occorso durante l'esecuzione del metodo:"
							+ ex + "Forzata RollBack Transazione",
					ex);
			throw new UnrecoverableException(
					"Errore imprevisto occorso durante l'esecuzione del metodo:" + ex + "Forzata RollBack Transazione",
					ex);
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error(
						"[DomandaImpl::deleteAnagraficaEta] - Errore CSI occorso durante l'esecuzione del metodo:" + ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[DomandaImpl::deleteAnagraficaEta] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaImpl", "deleteAnagraficaEta()",
					"invocazione servizio [domanda]::[deleteAnagraficaEta]", "(valore input omesso)");
			logger.debug("[DomandaImpl::deleteAnagraficaEta] - END");
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
		Logger logger = getLogger(null);
		logger.debug("[DomandaImpl::getTipiFasceEta] - START");

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
		// inizio misurazione
		watcher.start();

		/*PROTECTED REGION ID(R773980916) ENABLED START*/

		/*PROTECTED REGION END*/
		try {
			/*PROTECTED REGION ID(R-691509676) ENABLED START*/

			this.domandaService.logAudit(callerInfo);

			List<TipoFasciaEta> result = this.anagraficaService.getTipiFasceEta();

			return ConvertUtils.toArray(result, TipoFasciaEta.class);

			/*PROTECTED REGION END*/
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error(
						"[DomandaImpl::getTipiFasceEta] - Errore CSI occorso durante l'esecuzione del metodo:" + ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[DomandaImpl::getTipiFasceEta] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaImpl", "getTipiFasceEta()", "invocazione servizio [domanda]::[getTipiFasceEta]",
					"(valore input omesso)");
			logger.debug("[DomandaImpl::getTipiFasceEta] - END");
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
		Logger logger = getLogger(null);
		logger.debug("[DomandaImpl::getReportPostiLiberi] - START");

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
		// inizio misurazione
		watcher.start();

		/*PROTECTED REGION ID(R-134794018) ENABLED START*/

		/*PROTECTED REGION END*/
		try {
			/*PROTECTED REGION ID(R1520954750) ENABLED START*/

			this.domandaService.logAudit(callerInfo);

			List<RecordPostiLiberi> result = this.graduatoriaService.getReportPostiLiberi(codOrdineScuola);

			return ConvertUtils.toArray(result, RecordPostiLiberi.class);

			/*PROTECTED REGION END*/
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error("[DomandaImpl::getReportPostiLiberi] - Errore CSI occorso durante l'esecuzione del metodo:"
						+ ex, ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[DomandaImpl::getReportPostiLiberi] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaImpl", "getReportPostiLiberi()",
					"invocazione servizio [domanda]::[getReportPostiLiberi]", "(valore input omesso)");
			logger.debug("[DomandaImpl::getReportPostiLiberi] - END");
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
		Logger logger = getLogger(null);
		logger.debug("[DomandaImpl::modificaStatoScuolaPreferenza] - START");

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
		// inizio misurazione
		watcher.start();

		/*PROTECTED REGION ID(R-2054022806) ENABLED START*/

		/*PROTECTED REGION END*/
		try {
			/*PROTECTED REGION ID(R-1609100086) ENABLED START*/

			this.domandaService.logAudit(callerInfo);

			return this.graduatoriaService.modificaStatoScuolaPreferenza(idGraduatoria, idStatoAttuale,
					idStatoRipristino);

			/*PROTECTED REGION END*/
		} catch (RuntimeException ex) {
			sessionContext.setRollbackOnly();
			logger.error(
					"[SrvbibliotecaImpl::leggiBiblioteca] - Errore imprevisto occorso durante l'esecuzione del metodo:"
							+ ex + "Forzata RollBack Transazione",
					ex);
			throw new UnrecoverableException(
					"Errore imprevisto occorso durante l'esecuzione del metodo:" + ex + "Forzata RollBack Transazione",
					ex);
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error(
						"[DomandaImpl::modificaStatoScuolaPreferenza] - Errore CSI occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[DomandaImpl::modificaStatoScuolaPreferenza] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaImpl", "modificaStatoScuolaPreferenza()",
					"invocazione servizio [domanda]::[modificaStatoScuolaPreferenza]", "(valore input omesso)");
			logger.debug("[DomandaImpl::modificaStatoScuolaPreferenza] - END");
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
		Logger logger = getLogger(null);
		logger.debug("[DomandaImpl::getPreferenzeScuole] - START");

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
		// inizio misurazione
		watcher.start();

		/*PROTECTED REGION ID(R1476436373) ENABLED START*/

		/*PROTECTED REGION END*/
		try {
			/*PROTECTED REGION ID(R-1241099019) ENABLED START*/

			this.domandaService.logAudit(callerInfo);

			List<RecordPreferenzaScuola> result = this.graduatoriaService.getPreferenzeScuole(idAnagraficaGra,
					idDomanda);

			return ConvertUtils.toArray(result, RecordPreferenzaScuola.class);

			/*PROTECTED REGION END*/
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error(
						"[DomandaImpl::getPreferenzeScuole] - Errore CSI occorso durante l'esecuzione del metodo:" + ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[DomandaImpl::getPreferenzeScuole] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaImpl", "getPreferenzeScuole()",
					"invocazione servizio [domanda]::[getPreferenzeScuole]", "(valore input omesso)");
			logger.debug("[DomandaImpl::getPreferenzeScuole] - END");
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
		Logger logger = getLogger(null);
		logger.debug("[DomandaImpl::getFlagBloccoGraduatoriaNidi] - START");

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
		// inizio misurazione
		watcher.start();

		/*PROTECTED REGION ID(R1298413969) ENABLED START*/
		// inserire qui la dichiarazione di variabili locali al metodo
		// non verr&agrave; sovrascritto nelle successive rigenerazioni
		/*PROTECTED REGION END*/
		try {
			/*PROTECTED REGION ID(R-626896335) ENABLED START*/
			// inserire qui il codice di implementazione del metodo 'getFlagBloccoGraduatoriaNidi'.
			// non verr&agrave; sovrascritto nelle successive rigenerazioni
			this.domandaService.logAudit(callerInfo);

			return graduatoriaService.getFlagBloccoGraduatoria(TipoScuola.NID);
			/*PROTECTED REGION END*/
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error(
						"[DomandaImpl::getFlagBloccoGraduatoriaNidi] - Errore CSI occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[DomandaImpl::getFlagBloccoGraduatoriaNidi] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaImpl", "getFlagBloccoGraduatoriaNidi()",
					"invocazione servizio [domanda]::[getFlagBloccoGraduatoriaNidi]", "(valore input omesso)");
			logger.debug("[DomandaImpl::getFlagBloccoGraduatoriaNidi] - END");
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
		Logger logger = getLogger(null);
		logger.debug("[DomandaImpl::setFlagBloccoGraduatoriaNidi] - START");

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
		// inizio misurazione
		watcher.start();

		/*PROTECTED REGION ID(R-1758424571) ENABLED START*/
		// inserire qui la dichiarazione di variabili locali al metodo
		// non verr&agrave; sovrascritto nelle successive rigenerazioni
		/*PROTECTED REGION END*/
		try {
			/*PROTECTED REGION ID(R611232421) ENABLED START*/
			// inserire qui il codice di implementazione del metodo 'setFlagBloccoGraduatoriaNidi'.
			// non verr&agrave; sovrascritto nelle successive rigenerazioni
			this.domandaService.logAudit(callerInfo);
			graduatoriaService.setFlagBloccoGraduatoria(TipoScuola.NID, value);
			/*PROTECTED REGION END*/
		} catch (RuntimeException ex) {
			sessionContext.setRollbackOnly();
			logger.error(
					"[SrvbibliotecaImpl::leggiBiblioteca] - Errore imprevisto occorso durante l'esecuzione del metodo:"
							+ ex + "Forzata RollBack Transazione",
					ex);
			throw new UnrecoverableException(
					"Errore imprevisto occorso durante l'esecuzione del metodo:" + ex + "Forzata RollBack Transazione",
					ex);
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error(
						"[DomandaImpl::setFlagBloccoGraduatoriaNidi] - Errore CSI occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[DomandaImpl::setFlagBloccoGraduatoriaNidi] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaImpl", "setFlagBloccoGraduatoriaNidi()",
					"invocazione servizio [domanda]::[setFlagBloccoGraduatoriaNidi]", "(valore input omesso)");
			logger.debug("[DomandaImpl::setFlagBloccoGraduatoriaNidi] - END");
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
		Logger logger = getLogger(null);
		logger.debug("[DomandaImpl::getFlagBloccoGraduatoriaMaterne] - START");

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
		// inizio misurazione
		watcher.start();

		/*PROTECTED REGION ID(R-526683949) ENABLED START*/
		// inserire qui la dichiarazione di variabili locali al metodo
		// non verr&agrave; sovrascritto nelle successive rigenerazioni
		/*PROTECTED REGION END*/
		try {
			/*PROTECTED REGION ID(R1842287667) ENABLED START*/
			// inserire qui il codice di implementazione del metodo 'getFlagBloccoGraduatoriaMaterne'.
			// non verr&agrave; sovrascritto nelle successive rigenerazioni
			this.domandaService.logAudit(callerInfo);

			return graduatoriaService.getFlagBloccoGraduatoria(TipoScuola.MAT);
			/*PROTECTED REGION END*/
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error(
						"[DomandaImpl::getFlagBloccoGraduatoriaMaterne] - Errore CSI occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[DomandaImpl::getFlagBloccoGraduatoriaMaterne] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaImpl", "getFlagBloccoGraduatoriaMaterne()",
					"invocazione servizio [domanda]::[getFlagBloccoGraduatoriaMaterne]", "(valore input omesso)");
			logger.debug("[DomandaImpl::getFlagBloccoGraduatoriaMaterne] - END");
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
		Logger logger = getLogger(null);
		logger.debug("[DomandaImpl::setFlagBloccoGraduatoriaMaterne] - START");

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
		// inizio misurazione
		watcher.start();

		/*PROTECTED REGION ID(R-612052001) ENABLED START*/
		// inserire qui la dichiarazione di variabili locali al metodo
		// non verr&agrave; sovrascritto nelle successive rigenerazioni
		/*PROTECTED REGION END*/
		try {
			/*PROTECTED REGION ID(R1756919615) ENABLED START*/
			// inserire qui il codice di implementazione del metodo 'setFlagBloccoGraduatoriaMaterne'.
			// non verr&agrave; sovrascritto nelle successive rigenerazioni
			this.domandaService.logAudit(callerInfo);
			graduatoriaService.setFlagBloccoGraduatoria(TipoScuola.MAT, value);
			/*PROTECTED REGION END*/
		} catch (RuntimeException ex) {
			sessionContext.setRollbackOnly();
			logger.error(
					"[SrvbibliotecaImpl::leggiBiblioteca] - Errore imprevisto occorso durante l'esecuzione del metodo:"
							+ ex + "Forzata RollBack Transazione",
					ex);
			throw new UnrecoverableException(
					"Errore imprevisto occorso durante l'esecuzione del metodo:" + ex + "Forzata RollBack Transazione",
					ex);
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error(
						"[DomandaImpl::setFlagBloccoGraduatoriaMaterne] - Errore CSI occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[DomandaImpl::setFlagBloccoGraduatoriaMaterne] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaImpl", "setFlagBloccoGraduatoriaMaterne()",
					"invocazione servizio [domanda]::[setFlagBloccoGraduatoriaMaterne]", "(valore input omesso)");
			logger.debug("[DomandaImpl::setFlagBloccoGraduatoriaMaterne] - END");
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
		Logger logger = getLogger(null);
		logger.debug("[DomandaImpl::getTestataDomandaAccettazioneMaterne] - START");

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
		// inizio misurazione
		watcher.start();

		/*PROTECTED REGION ID(R369766636) ENABLED START*/
		// inserire qui la dichiarazione di variabili locali al metodo
		// non verr&agrave; sovrascritto nelle successive rigenerazioni
		/*PROTECTED REGION END*/
		try {
			/*PROTECTED REGION ID(R-1703564916) ENABLED START*/

			this.domandaService.logAudit(callerInfo);

			DomandaMaterna domandaMaterna = this.domandaMaternaReadService.readDomandaMaterna(idDomanda);

			this.accettazioneService.checkDomandaMaterna(domandaMaterna, cfRichiedente,
					AccettazioneService.TipoOperazione.ELENCO);

			List<Materna> elencoMaterna = ConvertUtils.toList(domandaMaterna.getElencoMaterne());
			List<CondizionePunteggio> condizioniPunteggio = ConvertUtils
					.toList(domandaMaterna.getCondizioniPunteggio());

			return this.accettazioneService.getDatiAccettazioneMaterna(idDomanda, elencoMaterna, condizioniPunteggio,
					null);

			/*PROTECTED REGION END*/
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error(
						"[DomandaImpl::getTestataDomandaAccettazioneMaterne] - Errore CSI occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[DomandaImpl::getTestataDomandaAccettazioneMaterne] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaImpl", "getTestataDomandaAccettazioneMaterne()",
					"invocazione servizio [domanda]::[getTestataDomandaAccettazioneMaterne]", "(valore input omesso)");
			logger.debug("[DomandaImpl::getTestataDomandaAccettazioneMaterne] - END");
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
		Logger logger = getLogger(null);
		logger.debug("[DomandaImpl::getReportDomandeScuolaResidenza] - START");

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
		// inizio misurazione
		watcher.start();

		/*PROTECTED REGION ID(R579820318) ENABLED START*/
		// inserire qui la dichiarazione di variabili locali al metodo
		// non verr&agrave; sovrascritto nelle successive rigenerazioni
		/*PROTECTED REGION END*/
		try {
			/*PROTECTED REGION ID(R-1346175362) ENABLED START*/
			// inserire qui il codice di implementazione del metodo 'getReportDomandeScuolaResidenza'.
			// non verr&agrave; sovrascritto nelle successive rigenerazioni

			this.domandaService.logAudit(callerInfo);

			List<RecordDomandeScuolaResidenza> result = this.graduatoriaService.getReportDomandeScuolaResidenza();

			return ConvertUtils.toArray(result, RecordDomandeScuolaResidenza.class);

			/*PROTECTED REGION END*/
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error(
						"[DomandaImpl::getReportDomandeScuolaResidenza] - Errore CSI occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[DomandaImpl::getReportDomandeScuolaResidenza] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("DomandaImpl", "getReportDomandeScuolaResidenza()",
					"invocazione servizio [domanda]::[getReportDomandeScuolaResidenza]", "(valore input omesso)");
			logger.debug("[DomandaImpl::getReportDomandeScuolaResidenza] - END");
		}
	}

	/// inizializzazione
	/**
	 * @generated
	 */
	public void init(Object initOptions) {
		/*PROTECTED REGION ID(R-814069668) ENABLED START*/

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
	/*PROTECTED REGION ID(R847052458) ENABLED START*/

	/*PROTECTED REGION END*/
}
