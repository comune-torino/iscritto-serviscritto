package it.csi.iscritto.serviscritto.business.domanda.service;

import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.LOG_BEGIN;
import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.LOG_END;
import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.LOG_ERROR;
import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.buildMessage;
import static it.csi.iscritto.serviscritto.business.util.converter.ConvertUtils.getFirst;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import org.apache.log4j.Logger;

import it.csi.iscritto.serviscritto.business.integration.converter.domande.AllegatoConverter;
import it.csi.iscritto.serviscritto.business.integration.converter.domande.RicevutaAllegatoConverter;
import it.csi.iscritto.serviscritto.business.integration.dao.TipoSoggetto;
import it.csi.iscritto.serviscritto.business.integration.dao.custom.RicevutaAllegatoDao;
import it.csi.iscritto.serviscritto.business.integration.dao.table.AllegatoDao;
import it.csi.iscritto.serviscritto.business.integration.dao.table.AnagraficaSogDao;
import it.csi.iscritto.serviscritto.business.integration.dao.table.DecodificaDao;
import it.csi.iscritto.serviscritto.business.integration.dao.table.DomandaIscDao;
import it.csi.iscritto.serviscritto.business.integration.dao.table.SoggettoRelDao;
import it.csi.iscritto.serviscritto.business.integration.dao.table.UtenteDao;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoDTipoAll;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoRSoggettoRel;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTAllegato;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTAnagraficaSog;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTUtente;
import it.csi.iscritto.serviscritto.business.integration.dao.view.SoggettoDao;
import it.csi.iscritto.serviscritto.business.integration.dao.view.dto.SoggettoRow;
import it.csi.iscritto.serviscritto.business.integration.exception.DaoException;
import it.csi.iscritto.serviscritto.business.integration.exception.ServiceException;
import it.csi.iscritto.serviscritto.business.integration.validation.ErrorCodeEnum;
import it.csi.iscritto.serviscritto.business.util.Constants;
import it.csi.iscritto.serviscritto.business.util.allegato.TipologiaAllegato;
import it.csi.iscritto.serviscritto.dto.domanda.Allegato;
import it.csi.iscritto.serviscritto.dto.domanda.RicevutaAllegato;
import it.csi.iscritto.serviscritto.exception.domanda.ValidationException;

public class AllegatoService {
	private static final Logger log = Logger.getLogger(Constants.COMPONENT_NAME + ".business");

	private DecodificaDao decodificaDao;
	private AllegatoDao allegatoDao;
	private AnagraficaSogDao anagraficaSogDao;
	private SoggettoRelDao soggettoRelDao;
	private SoggettoDao soggettoDao;
	private DomandaIscDao domandaIscDao;
	private UtenteDao utenteDao;
	private RicevutaAllegatoDao ricevutaAllegatoDao;

	public void setDecodificaDao(DecodificaDao decodificaDao) {
		this.decodificaDao = decodificaDao;
	}

	public void setAllegatoDao(AllegatoDao allegatoDao) {
		this.allegatoDao = allegatoDao;
	}

	public void setAnagraficaSogDao(AnagraficaSogDao anagraficaSogDao) {
		this.anagraficaSogDao = anagraficaSogDao;
	}

	public void setSoggettoRelDao(SoggettoRelDao soggettoRelDao) {
		this.soggettoRelDao = soggettoRelDao;
	}

	public void setSoggettoDao(SoggettoDao soggettoDao) {
		this.soggettoDao = soggettoDao;
	}

	public void setDomandaIscDao(DomandaIscDao domandaIscDao) {
		this.domandaIscDao = domandaIscDao;
	}

	public void setUtenteDao(UtenteDao utenteDao) {
		this.utenteDao = utenteDao;
	}

	public void setRicevutaAllegatoDao(RicevutaAllegatoDao ricevutaAllegatoDao) {
		this.ricevutaAllegatoDao = ricevutaAllegatoDao;
	}

	//////////////////////////////////////////////////////////////////////

	public Allegato getAllegato(String cfRichiedente, Long idDomanda, Long idAllegato, boolean withContent)
			throws ServiceException {

		final String methodName = "getAllegato";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		Allegato result;
		try {
			Validate.notBlank(cfRichiedente);
			Validate.notNull(idDomanda);
			Validate.notNull(idAllegato);

			log.info(buildMessage(getClass(), methodName, "idDomanda: " + idDomanda));
			log.info(buildMessage(getClass(), methodName, "idAllegato: " + idAllegato));
			log.info(buildMessage(getClass(), methodName, "withContent: " + withContent));

			this.checkIdDomanda(cfRichiedente, idDomanda);
			this.checkIdAllegato(cfRichiedente, idAllegato);

			IscrittoTAllegato allegato = this.allegatoDao.findIscrittoTAllegatoByKey(idAllegato, withContent);

			AllegatoConverter.Data data = new AllegatoConverter.Data();
			data.setAllegato(allegato);
			if (allegato != null) {
				data.setDecTipoAll(this.decodificaDao.findIscrittoDTipoAllByKey(allegato.getIdTipoAllegato()));
			}

			result = new AllegatoConverter().convert(data);
		}
		catch (Exception e) {
			log.error(buildMessage(getClass(), methodName, LOG_ERROR), e);
			throw new ServiceException(e);
		}

		log.info(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	public List<Long> insertAllegatoList(String cfRichiedente, String cfOperatore, Long idDomanda, List<Allegato> allegatoList)
			throws ServiceException {

		final String methodName = "insertAllegatoList";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		List<Long> result = new ArrayList<Long>();
		if (CollectionUtils.isNotEmpty(allegatoList)) {
			for (Allegato allegato : allegatoList) {
				result.add(this.insertAllegato(cfRichiedente, cfOperatore, idDomanda, allegato));
			}
		}

		log.info(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	public Long insertAllegato(String cfRichiedente, String cfOperatore, Long idDomanda, Allegato allegato)
			throws ServiceException {

		final String methodName = "insertAllegato";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		Long result = null;
		try {
			Validate.notBlank(cfRichiedente);
			Validate.notNull(idDomanda);
			Validate.notNull(allegato);
			Validate.notNull(allegato.getIdAnagraficaSoggetto());
			Validate.isTrue(TipologiaAllegato.checkCodTipologia(allegato.getCodTipoAllegato()));
			Validate.notNull(allegato.getDocumento());
			Validate.notBlank(allegato.getNomeFile());
			Validate.notBlank(allegato.getMimeType());

			log.info(buildMessage(getClass(), methodName, "idDomanda: " + idDomanda));
			log.info(buildMessage(getClass(), methodName, "idAnagraficaSoggetto: " + allegato.getIdAnagraficaSoggetto()));

			this.checkIdDomanda(cfRichiedente, idDomanda);
			this.checkAllegato(cfRichiedente, allegato);

			IscrittoTAllegato row = this.buildIscrittoTAllegato(allegato);
			if (row != null) {
				result = this.allegatoDao.insertAllegato(row);

				Long idOperatore = this.getIdOperatoreByCF(cfOperatore);
				log.info(buildMessage(getClass(), methodName, "idOperatore: " + idOperatore));

				if (idOperatore != null) {
					this.domandaIscDao.updateUltimaModifica(idDomanda, idOperatore);
				}
			}
		}
		catch (Exception e) {
			log.error(buildMessage(getClass(), methodName, LOG_ERROR), e);
			throw new ServiceException(e);
		}

		log.info(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	public Integer deleteAllegato(String cfRichiedente, String cfOperatore, Long idDomanda, Long idAllegato)
			throws ServiceException {

		final String methodName = "deleteAllegato";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		Integer result;
		try {
			Validate.notBlank(cfRichiedente);
			Validate.notNull(idAllegato);

			log.info(buildMessage(getClass(), methodName, "idDomanda: " + idDomanda));
			log.info(buildMessage(getClass(), methodName, "idAllegato: " + idAllegato));

			this.checkIdDomanda(cfRichiedente, idDomanda);
			this.checkIdAllegato(cfRichiedente, idAllegato);

			result = this.allegatoDao.deleteAllegato(idAllegato);

			Long idOperatore = this.getIdOperatoreByCF(cfOperatore);
			log.info(buildMessage(getClass(), methodName, "idOperatore: " + idOperatore));

			if (idOperatore != null) {
				this.domandaIscDao.updateUltimaModifica(idDomanda, idOperatore);
			}
		}
		catch (Exception e) {
			log.error(buildMessage(getClass(), methodName, LOG_ERROR), e);
			throw new ServiceException(e);
		}

		log.info(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	private IscrittoTAllegato buildIscrittoTAllegato(Allegato allegato) throws DaoException {
		final String methodName = "buildIscrittoTAllegato";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		if (allegato == null) {
			return null;
		}

		IscrittoDTipoAll codTipoAll = this.decodificaDao.findIscrittoDTipoAllByCodTipo(allegato.getCodTipoAllegato());
		IscrittoTAllegato row = new IscrittoTAllegato();

		row.setDataInserimento(new Date());
		row.setDocumento(allegato.getDocumento());
		row.setIdAllegato(allegato.getIdAllegato());
		row.setIdAnagraficaSoggetto(allegato.getIdAnagraficaSoggetto());
		row.setIdTipoAllegato(codTipoAll.getIdTipoAllegato());
		row.setMimeType(allegato.getMimeType());
		row.setNomeFile(allegato.getNomeFile());
		row.setProtocollo(allegato.getProtocollo());

		log.info(buildMessage(getClass(), methodName, LOG_END));
		return row;
	}

	public RicevutaAllegato generaRicevutaAllegato(Long idAllegato) throws DaoException {
		final String methodName = "generaRicevutaAllegato";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		log.info(buildMessage(getClass(), methodName, "idAllegato: " + idAllegato));

		RicevutaAllegato result = new RicevutaAllegatoConverter().convert(
				this.ricevutaAllegatoDao.buildRicevutaAllegato(idAllegato));

		log.info(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	//////////////////////////////////////////////////////////////////////
	// Controlli
	//////////////////////////////////////////////////////////////////////
	public void checkIdDomanda(String cfRichiedente, Long idDomanda)
			throws ServiceException, ValidationException {

		final String methodName = "checkIdDomanda";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		try {
			Long idRichiedente = this.getRichiedenteByIdDomanda(idDomanda);
			this.checkRichiedente(cfRichiedente, idRichiedente);
		}
		catch (ValidationException e) {
			log.error(buildMessage(getClass(), methodName, LOG_ERROR), e);
			throw e;
		}
		catch (Exception e) {
			log.error(buildMessage(getClass(), methodName, LOG_ERROR), e);
			throw new ServiceException(e);
		}

		log.info(buildMessage(getClass(), methodName, LOG_END));
	}

	public void checkIdAllegato(String cfRichiedente, Long idAllegato)
			throws ServiceException, ValidationException {

		final String methodName = "checkIdAllegato";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		try {
			Long idRichiedente = this.getRichiedenteByIdAllegato(idAllegato);
			this.checkRichiedente(cfRichiedente, idRichiedente);
		}
		catch (ValidationException e) {
			log.error(buildMessage(getClass(), methodName, LOG_ERROR), e);
			throw e;
		}
		catch (Exception e) {
			log.error(buildMessage(getClass(), methodName, LOG_ERROR), e);
			throw new ServiceException(e);
		}

		log.info(buildMessage(getClass(), methodName, LOG_END));
	}

	public void checkAllegato(String cfRichiedente, Allegato allegato)
			throws ServiceException, ValidationException {

		final String methodName = "checkAllegato";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		try {
			Long idRichiedente = this.getRichiedenteBySoggettoAllegato(allegato.getIdAnagraficaSoggetto());
			this.checkRichiedente(cfRichiedente, idRichiedente);
		}
		catch (ValidationException e) {
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
	// Utility
	//////////////////////////////////////////////////////////////////////
	private Long getIdOperatoreByCF(String cfOperatore) throws DaoException, ValidationException {
		final String methodName = "getIdOperatoreByCF";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		if (StringUtils.isBlank(cfOperatore)) {
			return null;
		}

		IscrittoTUtente operatore = this.utenteDao.findIscrittoTUtenteByCF(cfOperatore);
		if (operatore == null) {
			throw ErrorCodeEnum.VAL_ALL_003.buildException();
		}

		Long result = operatore.getIdUtente();

		log.info(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	private void checkRichiedente(String cfRichiedente, Long idAnagraficaSoggetto)
			throws DaoException, ValidationException {

		final String methodName = "checkRichiedente";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		if (StringUtils.isBlank(cfRichiedente) || idAnagraficaSoggetto == null) {
			throw ErrorCodeEnum.VAL_ALL_001.buildException();
		}

		if (!this.isRichiedente(idAnagraficaSoggetto)) {
			throw ErrorCodeEnum.VAL_ALL_001.buildException();
		}

		IscrittoTAnagraficaSog richiedente = this.anagraficaSogDao.findIscrittoTAnagraficaSogByKey(idAnagraficaSoggetto);
		if (richiedente == null) {
			throw ErrorCodeEnum.VAL_ALL_001.buildException();
		}

		if (!cfRichiedente.equalsIgnoreCase(richiedente.getCodiceFiscale())) {
			throw ErrorCodeEnum.VAL_ALL_001.buildException();
		}

		log.info(buildMessage(getClass(), methodName, LOG_END));
	}

	private Long getRichiedenteByIdDomanda(Long idDomanda) throws DaoException, ValidationException {
		final String methodName = "getRichiedenteByIdDomanda";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		SoggettoRow richiedente = getFirst(this.soggettoDao.findSoggettiByIdDomanda(idDomanda, TipoSoggetto.RIC));
		if (richiedente == null) {
			throw ErrorCodeEnum.VAL_ALL_001.buildException();
		}

		Long result = richiedente.getIdAnagraficaSoggetto();

		log.info(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	private Long getRichiedenteByIdAllegato(Long idAllegato) throws DaoException, ValidationException {
		final String methodName = "getRichiedenteByIdAllegato";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		IscrittoTAllegato allegato = this.allegatoDao.findIscrittoTAllegatoByKey(idAllegato, false);
		if (allegato == null) {
			throw ErrorCodeEnum.VAL_ALL_002.buildException();
		}

		Long result = this.getRichiedenteBySoggettoAllegato(allegato.getIdAnagraficaSoggetto());

		log.info(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	private Long getRichiedenteBySoggettoAllegato(Long idAnagraficaSoggetto) throws DaoException, ValidationException {
		final String methodName = "getRichiedenteBySoggettoAllegato";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		IscrittoTAnagraficaSog sog = this.anagraficaSogDao.findIscrittoTAnagraficaSogByKey(idAnagraficaSoggetto);
		SoggettoRow richiedente = getFirst(this.soggettoDao.findSoggettiByIdDomanda(sog.getIdDomandaIscrizione(), TipoSoggetto.RIC));

		Long result = richiedente.getIdAnagraficaSoggetto();

		log.info(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	private boolean isRichiedente(Long idAnagraficaSoggetto) throws DaoException {
		final String methodName = "isRichiedente";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		List<IscrittoRSoggettoRel> rows = this.soggettoRelDao.findIscrittoRSoggettoRelByIdSog(idAnagraficaSoggetto);
		if (CollectionUtils.isEmpty(rows)) {
			return false;
		}

		Long idTipoSoggetto = this.decodificaDao.findIscrittoDTipoSogByCod(TipoSoggetto.RIC.getCod()).getIdTipoSoggetto();
		for (IscrittoRSoggettoRel row : rows) {
			if (row.getIdTipoSoggetto().equals(idTipoSoggetto)) {
				return true;
			}
		}

		log.info(buildMessage(getClass(), methodName, LOG_END));
		return false;
	}

}
