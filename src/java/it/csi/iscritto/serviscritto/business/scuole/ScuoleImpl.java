
package it.csi.iscritto.serviscritto.business.scuole;

import it.csi.csi.wrapper.*;

import it.csi.iscritto.serviscritto.dto.scuole.*;

import it.csi.iscritto.serviscritto.interfacecsi.scuole.*;

import it.csi.iscritto.serviscritto.exception.scuole.*;

import javax.ejb.SessionContext;
import javax.sql.DataSource;
import org.apache.log4j.*;

/*PROTECTED REGION ID(R9435128) ENABLED START*/

import it.csi.iscritto.serviscritto.business.integration.dao.TipoScuola;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTAnnoSco;
import it.csi.iscritto.serviscritto.business.integration.dao.view.ScuoleDao;
import it.csi.iscritto.serviscritto.business.integration.dao.view.dto.ScuolaRow;
import it.csi.iscritto.serviscritto.business.util.converter.ConvertUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import it.csi.iscritto.serviscritto.business.integration.converter.scuole.ScuolaConverter;

/*PROTECTED REGION END*/

/**
 * @generated
 */
public class ScuoleImpl {
	/**
	 * @generated
	 */
	public static final String LOGGER_PREFIX = "serviscritto";

	/*PROTECTED REGION ID(R584225946) ENABLED START*/

	private ScuoleDao scuoleDao;

	/*PROTECTED REGION END*/

	/// Implementazione operazioni esposte dal servizio

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
		Logger logger = getLogger(null);
		logger.debug("[ScuoleImpl::getElencoScuole] - START");

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
		// inizio misurazione
		watcher.start();

		/*PROTECTED REGION ID(R-1608554834) ENABLED START*/

		/*PROTECTED REGION END*/
		try {
			/*PROTECTED REGION ID(R560928590) ENABLED START*/

			TipoScuola tipoScuolaEnum = TipoScuola.findByCod(criterioRicerca.getTipoScuola());
			String codAnno = criterioRicerca.getCodAnno();
			String descrizione = criterioRicerca.getDescrizione();
			String indirizzo = criterioRicerca.getIndirizzo();
			Integer circoscrizione = criterioRicerca.getCircoscrizione();
			Date dataNascita = criterioRicerca.getDataNascita();
			String codiceFiscaleUtente = criterioRicerca.getCodiceFiscaleUtente();
			String codiceProfiloUtente = criterioRicerca.getCodiceProfiloUtente();
			//codice fiscale dell operatore/utente, il pre esistente cf utente e' utilizzato per il bo, questo servira' per il fo
			String cfOperatore = criterioRicerca.getCodiceCfOperatore();

			List<ScuolaRow> rows;

			if (dataNascita != null) {
				logger.info("^^ data nascita minore: " + dataNascita);
			} else {
				logger.info("^^ data nascita minore NON presente");
			}

			logger.info("Svolgimento get Elenco Scuole");
			if (descrizione != null) {
				logger.info("Descrizione: " + descrizione);
				rows = this.scuoleDao.findScuoleByDescrizione(tipoScuolaEnum, codAnno, descrizione, dataNascita);
			} else if (indirizzo != null) {
				logger.info("Indirizzo: " + indirizzo);
				rows = this.scuoleDao.findScuoleByIndirizzo(tipoScuolaEnum, codAnno, indirizzo, dataNascita);
			} else if (circoscrizione != null) {
				rows = this.scuoleDao.findScuoleByCircoscrizione(tipoScuolaEnum, codAnno, circoscrizione, dataNascita);
			} else if (codiceFiscaleUtente != null) {
				// chiamata dal BO
				logger.info("codice fiscale operatore BO: " + codiceFiscaleUtente);
				rows = this.scuoleDao.findScuoleByUtente(tipoScuolaEnum, codiceFiscaleUtente, codiceProfiloUtente);
			} else if (cfOperatore != null) {
				//chiamata per fo im-110
				logger.info("codice fiscale operatore FO: " + cfOperatore);
				rows = this.scuoleDao.findScuoleOperatore(tipoScuolaEnum, codAnno, dataNascita, cfOperatore);
			} else {
				logger.info("NON ho il codice fiscale");
				rows = this.scuoleDao.findScuole(tipoScuolaEnum, codAnno, dataNascita);
			}

			List<Scuola> result = new ScuolaConverter().convertAll(rows);
			return Optional.of(result).orElse(new ArrayList<Scuola>()).toArray(new Scuola[0]);

			/*PROTECTED REGION END*/
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error("[ScuoleImpl::getElencoScuole] - Errore CSI occorso durante l'esecuzione del metodo:" + ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[ScuoleImpl::getElencoScuole] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("ScuoleImpl", "getElencoScuole()", "invocazione servizio [scuole]::[getElencoScuole]",
					"(valore input omesso)");
			logger.debug("[ScuoleImpl::getElencoScuole] - END");
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
		Logger logger = getLogger(null);
		logger.debug("[ScuoleImpl::getCodAnnoNidi] - START");

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
		// inizio misurazione
		watcher.start();

		/*PROTECTED REGION ID(R378557271) ENABLED START*/

		/*PROTECTED REGION END*/
		try {
			/*PROTECTED REGION ID(R171445943) ENABLED START*/

			String result = null;
			List<IscrittoTAnnoSco> rows = this.scuoleDao.findIscrittoTAnnoScoByDate(TipoScuola.NID, data);
			if (rows != null && rows.size() > 0) {
				result = rows.get(0).getCodAnnoScolastico();
			}

			return result;

			/*PROTECTED REGION END*/
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error("[ScuoleImpl::getCodAnnoNidi] - Errore CSI occorso durante l'esecuzione del metodo:" + ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error("[ScuoleImpl::getCodAnnoNidi] - Errore imprevisto occorso durante l'esecuzione del metodo:"
						+ ex, ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("ScuoleImpl", "getCodAnnoNidi()", "invocazione servizio [scuole]::[getCodAnnoNidi]",
					"(valore input omesso)");
			logger.debug("[ScuoleImpl::getCodAnnoNidi] - END");
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
		Logger logger = getLogger(null);
		logger.debug("[ScuoleImpl::getCodAnniMaterne] - START");

		it.csi.util.performance.StopWatch watcher = new it.csi.util.performance.StopWatch("serviscritto");
		// inizio misurazione
		watcher.start();

		/*PROTECTED REGION ID(R341814291) ENABLED START*/

		/*PROTECTED REGION END*/
		try {
			/*PROTECTED REGION ID(R-2138721101) ENABLED START*/

			List<String> result = new ArrayList<>();
			List<IscrittoTAnnoSco> rows = this.scuoleDao.findIscrittoTAnnoScoByDate(TipoScuola.MAT, data);
			if (rows != null) {
				for (IscrittoTAnnoSco row : rows) {
					result.add(row.getCodAnnoScolastico());
				}
			}

			return ConvertUtils.toArray(result, String.class);

			/*PROTECTED REGION END*/
		} catch (Exception ex) {
			if (CSIException.class.isAssignableFrom(ex.getClass())) {
				logger.error(
						"[ScuoleImpl::getCodAnniMaterne] - Errore CSI occorso durante l'esecuzione del metodo:" + ex,
						ex);
				throw (CSIException) ex;
			} else {
				logger.error(
						"[ScuoleImpl::getCodAnniMaterne] - Errore imprevisto occorso durante l'esecuzione del metodo:"
								+ ex,
						ex);
				throw new UnrecoverableException("Errore imprevisto occorso durante l'esecuzione del metodo:" + ex, ex);
			}
		} finally {
			// fine misurazione
			watcher.stop();
			watcher.dumpElapsed("ScuoleImpl", "getCodAnniMaterne()",
					"invocazione servizio [scuole]::[getCodAnniMaterne]", "(valore input omesso)");
			logger.debug("[ScuoleImpl::getCodAnniMaterne] - END");
		}
	}

	/// inizializzazione
	/**
	 * @generated
	 */
	public void init(Object initOptions) {
		/*PROTECTED REGION ID(R392346419) ENABLED START*/

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
	/*PROTECTED REGION ID(R1831404325) ENABLED START*/

	public void setScuoleDao(ScuoleDao scuoleDao) {
		this.scuoleDao = scuoleDao;
	}

	/*PROTECTED REGION END*/
}
