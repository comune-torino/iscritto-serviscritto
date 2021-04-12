
package it.csi.iscritto.serviscritto.business.profilazione;

import it.csi.csi.wrapper.*;

import it.csi.iscritto.serviscritto.dto.profilazione.*;

import it.csi.iscritto.serviscritto.interfacecsi.profilazione.*;

import it.csi.iscritto.serviscritto.exception.profilazione.*;

import javax.ejb.SessionContext;
import javax.sql.DataSource;
import org.apache.log4j.*;

/*PROTECTED REGION ID(R348906151) ENABLED START*/
import java.util.Iterator;
import java.util.List;
import it.csi.iscritto.serviscritto.business.integration.dao.view.ProfilazioneDao;
import it.csi.iscritto.serviscritto.business.integration.dao.view.dto.InfoCondizionePunteggioRow;
import it.csi.iscritto.serviscritto.business.integration.dao.view.dto.PrivilegioOperatoreRow;
import it.csi.iscritto.serviscritto.business.util.converter.ConvertUtils;
import it.csi.iscritto.serviscritto.business.integration.converter.profilazione.AttivitaConverter;
import it.csi.iscritto.serviscritto.business.integration.converter.profilazione.CallerInfoProfilazioneConverter;
import it.csi.iscritto.serviscritto.business.integration.converter.profilazione.CondizionePunteggioConverter;
import it.csi.iscritto.serviscritto.business.integration.converter.profilazione.FunzioneConverter;
import it.csi.iscritto.serviscritto.business.integration.converter.profilazione.OperatoreConverter;
import it.csi.iscritto.serviscritto.business.integration.converter.profilazione.PrivilegioOperatoreConverter;
import it.csi.iscritto.serviscritto.business.integration.converter.profilazione.ProfiloConverter;
import it.csi.iscritto.serviscritto.business.integration.dao.TipoScuola;
import it.csi.iscritto.serviscritto.business.integration.dao.table.AuditLogDao;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTAttivita;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTFunzione;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTUtente;

/*PROTECTED REGION END*/

/**
 * @generated
 */
public class ProfilazioneImpl {
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

	/*PROTECTED REGION ID(R-1017446967) ENABLED START*/

	private ProfilazioneDao profilazioneDao;
	private AuditLogDao auditLogDao;

	public void setProfilazioneDao(ProfilazioneDao profilazioneDao) {
		this.profilazioneDao = profilazioneDao;
	}

	public void setAuditLogDao(AuditLogDao auditLogDao) {
		this.auditLogDao = auditLogDao;
	}

	/*PROTECTED REGION END*/

	/// Implementazione operazioni esposte dal servizio

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
		Logger logger = getLogger(null);
		logger.debug("[ProfilazioneImpl::getFunzioniAbilitateOperatore] - START");

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
		// inizio misurazione
		watcher.start();

		/*PROTECTED REGION ID(R1201423544) ENABLED START*/

		Funzione[] result;

		/*PROTECTED REGION END*/
		try {
			/*PROTECTED REGION ID(R332227928) ENABLED START*/

			List<IscrittoTFunzione> funzioni = profilazioneDao.findFunzioni(codiceFiscale, codiceProfilo);
			FunzioneConverter converter = new FunzioneConverter();
			result = new Funzione[funzioni.size()];
			int i = 0;
			for (Iterator<IscrittoTFunzione> iterator = funzioni.iterator(); iterator.hasNext();) {
				IscrittoTFunzione iscrittoTFunzione = (IscrittoTFunzione) iterator.next();
				result[i] = (converter.convert(iscrittoTFunzione));
				i++;
			}

			return result;

			/*PROTECTED REGION END*/
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error(
						"[ProfilazioneImpl::getFunzioniAbilitateOperatore] - Errore CSI occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[ProfilazioneImpl::getFunzioniAbilitateOperatore] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("ProfilazioneImpl", "getFunzioniAbilitateOperatore()",
					"invocazione servizio [profilazione]::[getFunzioniAbilitateOperatore]", "(valore input omesso)");
			logger.debug("[ProfilazioneImpl::getFunzioniAbilitateOperatore] - END");
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
		Logger logger = getLogger(null);
		logger.debug("[ProfilazioneImpl::getAttivitaAbilitateOperatore] - START");

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
		// inizio misurazione
		watcher.start();

		/*PROTECTED REGION ID(R1050162500) ENABLED START*/

		/*PROTECTED REGION END*/
		try {
			/*PROTECTED REGION ID(R180966884) ENABLED START*/

			List<IscrittoTAttivita> rows = profilazioneDao.findAttivita(codiceFiscale, codiceProfilo, codiceFunzione);

			return ConvertUtils.toArray(new AttivitaConverter().convertAll(rows), Attivita.class);

			/*PROTECTED REGION END*/
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error(
						"[ProfilazioneImpl::getAttivitaAbilitateOperatore] - Errore CSI occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[ProfilazioneImpl::getAttivitaAbilitateOperatore] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("ProfilazioneImpl", "getAttivitaAbilitateOperatore()",
					"invocazione servizio [profilazione]::[getAttivitaAbilitateOperatore]", "(valore input omesso)");
			logger.debug("[ProfilazioneImpl::getAttivitaAbilitateOperatore] - END");
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
		Logger logger = getLogger(null);
		logger.debug("[ProfilazioneImpl::getPrivilegiOperatore] - START");

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
		// inizio misurazione
		watcher.start();

		/*PROTECTED REGION ID(R425209706) ENABLED START*/

		/*PROTECTED REGION END*/
		try {
			/*PROTECTED REGION ID(R1115942922) ENABLED START*/

			if (callerInfo != null) {
				this.auditLogDao.logAudit(new CallerInfoProfilazioneConverter().convert(callerInfo));
			}

			List<PrivilegioOperatoreRow> rows = this.profilazioneDao.findPrivilegi(codiceFiscale, codiceProfilo);

			return ConvertUtils.toArray(new PrivilegioOperatoreConverter().convertAll(rows), PrivilegioOperatore.class);

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
						"[ProfilazioneImpl::getPrivilegiOperatore] - Errore CSI occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[ProfilazioneImpl::getPrivilegiOperatore] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("ProfilazioneImpl", "getPrivilegiOperatore()",
					"invocazione servizio [profilazione]::[getPrivilegiOperatore]", "(valore input omesso)");
			logger.debug("[ProfilazioneImpl::getPrivilegiOperatore] - END");
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
		Logger logger = getLogger(null);
		logger.debug("[ProfilazioneImpl::getOperatoreByCodiceFiscale] - START");

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
		// inizio misurazione
		watcher.start();

		/*PROTECTED REGION ID(R-913927398) ENABLED START*/

		/*PROTECTED REGION END*/
		try {
			/*PROTECTED REGION ID(R-490251334) ENABLED START*/

			if (callerInfo != null) {
				this.auditLogDao.logAudit(new CallerInfoProfilazioneConverter().convert(callerInfo));
			}

			logger.info("@@ sono in getOperatoreByCodiceFiscale, codice fiscale:" + codiceFiscale);
			IscrittoTUtente row = this.profilazioneDao.findUtenteByCodFiscale(codiceFiscale);

			logger.info("@@2 uscito da findUtenteByCodFiscale, row:" + row);
			return new OperatoreConverter().convert(row);

			/*PROTECTED REGION END*/
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error(
						"[ProfilazioneImpl::getOperatoreByCodiceFiscale] - Errore CSI occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[ProfilazioneImpl::getOperatoreByCodiceFiscale] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("ProfilazioneImpl", "getOperatoreByCodiceFiscale()",
					"invocazione servizio [profilazione]::[getOperatoreByCodiceFiscale]", "(valore input omesso)");
			logger.debug("[ProfilazioneImpl::getOperatoreByCodiceFiscale] - END");
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
		Logger logger = getLogger(null);
		logger.debug("[ProfilazioneImpl::getProfiliOperatore] - START");

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
		// inizio misurazione
		watcher.start();

		/*PROTECTED REGION ID(R-1133612302) ENABLED START*/

		/*PROTECTED REGION END*/
		try {
			/*PROTECTED REGION ID(R1892801426) ENABLED START*/

			if (callerInfo != null) {
				this.auditLogDao.logAudit(new CallerInfoProfilazioneConverter().convert(callerInfo));
			}

			List<Profilo> result = new ProfiloConverter().convertAll(this.profilazioneDao.findProfili(codiceFiscale));

			return ConvertUtils.toArray(result, Profilo.class);

			/*PROTECTED REGION END*/
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error(
						"[ProfilazioneImpl::getProfiliOperatore] - Errore CSI occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[ProfilazioneImpl::getProfiliOperatore] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("ProfilazioneImpl", "getProfiliOperatore()",
					"invocazione servizio [profilazione]::[getProfiliOperatore]", "(valore input omesso)");
			logger.debug("[ProfilazioneImpl::getProfiliOperatore] - END");
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
		Logger logger = getLogger(null);
		logger.debug("[ProfilazioneImpl::getCondizioniPunteggioNidi] - START");

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
		// inizio misurazione
		watcher.start();

		/*PROTECTED REGION ID(R-1785511698) ENABLED START*/

		/*PROTECTED REGION END*/
		try {
			/*PROTECTED REGION ID(R583459918) ENABLED START*/

			if (callerInfo != null) {
				this.auditLogDao.logAudit(new CallerInfoProfilazioneConverter().convert(callerInfo));
			}

			List<InfoCondizionePunteggioRow> rows = this.profilazioneDao.findCondizioniPunteggio(TipoScuola.NID,
					codiceFiscale, codiceProfilo, tipoIstruttoria);

			return ConvertUtils.toArray(new CondizionePunteggioConverter().convertAll(rows), CondizionePunteggio.class);

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
						"[ProfilazioneImpl::getCondizioniPunteggioNidi] - Errore CSI occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[ProfilazioneImpl::getCondizioniPunteggioNidi] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("ProfilazioneImpl", "getCondizioniPunteggioNidi()",
					"invocazione servizio [profilazione]::[getCondizioniPunteggioNidi]", "(valore input omesso)");
			logger.debug("[ProfilazioneImpl::getCondizioniPunteggioNidi] - END");
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
		Logger logger = getLogger(null);
		logger.debug("[ProfilazioneImpl::getCondizioniPunteggioMaterne] - START");

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
		// inizio misurazione
		watcher.start();

		/*PROTECTED REGION ID(R-110800810) ENABLED START*/

		/*PROTECTED REGION END*/
		try {
			/*PROTECTED REGION ID(R-979996426) ENABLED START*/

			if (callerInfo != null) {
				this.auditLogDao.logAudit(new CallerInfoProfilazioneConverter().convert(callerInfo));
			}

			List<InfoCondizionePunteggioRow> rows = this.profilazioneDao.findCondizioniPunteggio(TipoScuola.MAT,
					codiceFiscale, codiceProfilo, tipoIstruttoria);

			return ConvertUtils.toArray(new CondizionePunteggioConverter().convertAll(rows), CondizionePunteggio.class);

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
						"[ProfilazioneImpl::getCondizioniPunteggioMaterne] - Errore CSI occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[ProfilazioneImpl::getCondizioniPunteggioMaterne] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("ProfilazioneImpl", "getCondizioniPunteggioMaterne()",
					"invocazione servizio [profilazione]::[getCondizioniPunteggioMaterne]", "(valore input omesso)");
			logger.debug("[ProfilazioneImpl::getCondizioniPunteggioMaterne] - END");
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
		Logger logger = getLogger(null);
		logger.debug("[ProfilazioneImpl::getAutorizzatoNidi] - START");

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
		// inizio misurazione
		watcher.start();

		/*PROTECTED REGION ID(R971152888) ENABLED START*/
		// inserire qui la dichiarazione di variabili locali al metodo
		// non verr&agrave; sovrascritto nelle successive rigenerazioni
		/*PROTECTED REGION END*/
		try {
			/*PROTECTED REGION ID(R-316694184) ENABLED START*/
			if (callerInfo != null) {
				this.auditLogDao.logAudit(new CallerInfoProfilazioneConverter().convert(callerInfo));
			}

			Boolean result = this.profilazioneDao.findAssegnamentoNidi(codiceFiscale);

			return result;

			/*PROTECTED REGION END*/
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error(
						"[ProfilazioneImpl::getAutorizzatoNidi] - Errore CSI occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[ProfilazioneImpl::getAutorizzatoNidi] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("ProfilazioneImpl", "getAutorizzatoNidi()",
					"invocazione servizio [profilazione]::[getAutorizzatoNidi]", "(valore input omesso)");
			logger.debug("[ProfilazioneImpl::getAutorizzatoNidi] - END");
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
		Logger logger = getLogger(null);
		logger.debug("[ProfilazioneImpl::getAutorizzatoMaterne] - START");

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
		// inizio misurazione
		watcher.start();

		/*PROTECTED REGION ID(R-385786100) ENABLED START*/
		// inserire qui la dichiarazione di variabili locali al metodo
		// non verr&agrave; sovrascritto nelle successive rigenerazioni
		/*PROTECTED REGION END*/
		try {
			/*PROTECTED REGION ID(R304947116) ENABLED START*/
			if (callerInfo != null) {
				this.auditLogDao.logAudit(new CallerInfoProfilazioneConverter().convert(callerInfo));
			}

			Boolean result = this.profilazioneDao.findAssegnamentoMaterne(codiceFiscale);

			return result;

			/*PROTECTED REGION END*/
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error(
						"[ProfilazioneImpl::getAutorizzatoMaterne] - Errore CSI occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[ProfilazioneImpl::getAutorizzatoMaterne] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("ProfilazioneImpl", "getAutorizzatoMaterne()",
					"invocazione servizio [profilazione]::[getAutorizzatoMaterne]", "(valore input omesso)");
			logger.debug("[ProfilazioneImpl::getAutorizzatoMaterne] - END");
		}
	}

	/// inizializzazione
	/**
	 * @generated
	 */
	public void init(Object initOptions) {
		/*PROTECTED REGION ID(R-699396702) ENABLED START*/

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
	/*PROTECTED REGION ID(R464066580) ENABLED START*/

	/*PROTECTED REGION END*/
}
