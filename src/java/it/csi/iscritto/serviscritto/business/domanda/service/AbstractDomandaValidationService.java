package it.csi.iscritto.serviscritto.business.domanda.service;

import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.LOG_BEGIN;
import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.LOG_END;
import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.LOG_ERROR;
import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.buildMessage;
import static it.csi.iscritto.serviscritto.business.util.converter.ConvertUtils.getFirst;

import java.util.Date;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import it.csi.iscritto.serviscritto.business.integration.dao.StatoDomanda;
import it.csi.iscritto.serviscritto.business.integration.dao.TipoScuola;
import it.csi.iscritto.serviscritto.business.integration.dao.TipoSoggetto;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTAnagraficaGra;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTAnnoSco;
import it.csi.iscritto.serviscritto.business.integration.dao.view.dto.InfoDomandaRow;
import it.csi.iscritto.serviscritto.business.integration.dao.view.dto.SoggettoRow;
import it.csi.iscritto.serviscritto.business.integration.exception.DaoException;
import it.csi.iscritto.serviscritto.business.integration.exception.ServiceException;
import it.csi.iscritto.serviscritto.business.integration.validation.CodiceFiscaleValidator;
import it.csi.iscritto.serviscritto.business.integration.validation.ErrorCodeEnum;
import it.csi.iscritto.serviscritto.business.util.Constants;
import it.csi.iscritto.serviscritto.dto.domanda.Anagrafica;
import it.csi.iscritto.serviscritto.exception.domanda.ValidationException;

public abstract class AbstractDomandaValidationService extends AbstractDomandaService {
	private static final Logger log = Logger.getLogger(Constants.COMPONENT_NAME + ".business");

	public void checkIdDomanda(String cfRichiedente, Long idDomanda)
			throws ServiceException, ValidationException {

		final String methodName = "checkIdDomanda";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		try {
			if (StringUtils.isBlank(cfRichiedente) || idDomanda == null) {
				throw ErrorCodeEnum.VAL_DOM_016.buildException();
			}

			SoggettoRow richiedente = getFirst(this.soggettoDao.findSoggettiByIdDomanda(idDomanda, TipoSoggetto.RIC));
			if (richiedente == null) {
				throw ErrorCodeEnum.VAL_DOM_016.buildException();
			}

			if (!cfRichiedente.equalsIgnoreCase(richiedente.getCodiceFiscale())) {
				throw ErrorCodeEnum.VAL_DOM_016.buildException();
			}
		}
		catch (ValidationException e) {
			log.info(buildMessage(getClass(), methodName, e.getMessage()));
			log.error(buildMessage(getClass(), methodName, LOG_ERROR), e);
			throw e;
		}
		catch (Exception e) {
			log.error(buildMessage(getClass(), methodName, LOG_ERROR), e);
			throw new ServiceException(e);
		}

		log.info(buildMessage(getClass(), methodName, LOG_END));
	}

	//////////////////////////////////////////////////////////////////////

	protected void aggiornaScuoleFuoriTermine(TipoScuola tipoScuola, Long idDomandaIscrizione) throws DaoException, ValidationException {
		final String methodName = "aggiornaScuoleFuoriTermine";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		Date now = new Date();
		List<IscrittoTAnagraficaGra> rows = this.validazioneDao.dataCheckDomandaFuoriTermine(tipoScuola, now);

		if (CollectionUtils.isEmpty(rows)) {
			this.scuolaDao.updateFlagFuoriTermine(idDomandaIscrizione, true);
		}

		log.info(buildMessage(getClass(), methodName, LOG_END));
	}

	protected void checkDomandaInPeriodo(TipoScuola tipoScuola) throws DaoException, ValidationException {
		final String methodName = "checkDomandaInPeriodo";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		Date now = new Date();
		List<IscrittoTAnagraficaGra> rows = this.validazioneDao.dataCheckDomandaFuoriPeriodo(
				tipoScuola, now);

		if (CollectionUtils.isEmpty(rows)) {
			throw ErrorCodeEnum.VAL_DOM_001.buildException();
		}

		log.info(buildMessage(getClass(), methodName, LOG_END));
	}

	protected void checkAltroRichiedente(TipoScuola tipoScuola, String codiceFiscaleRic, String codiceFiscaleMin) throws DaoException, ValidationException {
		final String methodName = "checkAltroRichiedente";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		String codAnnoScolastico = this.getAnnoScolastico(tipoScuola).getCodAnnoScolastico();
		List<InfoDomandaRow> rows = this.validazioneDao.dataCheckAltroRichiedente(
				tipoScuola, codAnnoScolastico, codiceFiscaleRic, codiceFiscaleMin);

		int size = rows.size();
		if (size > 0) {
			log.error(buildMessage(getClass(), methodName, String.format("trovati %d risultati", size)));
			throw ErrorCodeEnum.VAL_DOM_005.buildException();
		}

		log.info(buildMessage(getClass(), methodName, LOG_END));
	}

	protected void checkDomandaEsistente(TipoScuola tipoScuola, String codiceFiscaleRic, String codiceFiscaleMin) throws DaoException, ValidationException {
		final String methodName = "checkDomandaEsistente";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		String codAnnoScolastico = this.getAnnoScolastico(tipoScuola).getCodAnnoScolastico();
		List<InfoDomandaRow> rows = this.validazioneDao.dataCheckDomandaEsistente(
				tipoScuola, codAnnoScolastico, codiceFiscaleRic, codiceFiscaleMin);

		int size = rows.size();
		if (size > 0) {
			log.error(buildMessage(getClass(), methodName, String.format("trovati %d risultati", size)));

			final String codStatoDom = rows.get(0).getCodStatoDom();

			if (StatoDomanda.AMM.getCod().equals(codStatoDom)) {
				throw ErrorCodeEnum.VAL_DOM_020.buildException();
			}

			if (StatoDomanda.GRA.getCod().equals(codStatoDom)) {
				throw ErrorCodeEnum.VAL_DOM_017.buildException();
			}

			throw ErrorCodeEnum.SYS_001.buildException();
		}

		log.info(buildMessage(getClass(), methodName, LOG_END));
	}

	protected void checkDomandaEsistenteForInvio(TipoScuola tipoScuola, String codiceFiscaleRic, String codiceFiscaleMin)
			throws DaoException, ValidationException {

		final String methodName = "checkDomandaEsistenteForInvio";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		String codAnnoScolastico = this.getAnnoScolastico(tipoScuola).getCodAnnoScolastico();
		List<InfoDomandaRow> rows = this.validazioneDao.dataCheckDomandaEsistenteForInvio(
				tipoScuola, codAnnoScolastico, codiceFiscaleRic, codiceFiscaleMin);

		int size = rows.size();
		if (size > 0) {
			log.error(buildMessage(getClass(), methodName, String.format("trovati %d risultati", size)));
			throw ErrorCodeEnum.VAL_DOM_006.buildException();
		}

		log.info(buildMessage(getClass(), methodName, LOG_END));
	}

	//////////////////////////////////////////////////////////////////////
	// Utility
	//////////////////////////////////////////////////////////////////////
	protected IscrittoTAnnoSco getAnnoScolastico(TipoScuola tipoScuola) throws DaoException, ValidationException {
		IscrittoTAnnoSco annoSco = this.annoScoDao.findIscrittoTAnnoScoByDate(tipoScuola, new Date());
		if (annoSco == null) {
			throw ErrorCodeEnum.VAL_DOM_002.buildException();
		}

		return annoSco;
	}

	protected Date getDataPresentazione(Long idDomandaIscrizione) throws DaoException, ValidationException {
		return this.domandaIscDao.findIscrittoTDomandaIscByKey(idDomandaIscrizione).getDataConsegna();
	}

	protected static String checkCodiceFiscale(Anagrafica anagrafica, String path) throws ValidationException {
		if (anagrafica == null) {
			return null;
		}

		String cf = anagrafica.getCodiceFiscale();

		if (StringUtils.isNotBlank(cf)) {
			CodiceFiscaleValidator.validate(cf, String.format("%s;%s", path, cf));
		}

		return cf;
	}
}
