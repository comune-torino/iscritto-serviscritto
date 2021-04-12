package it.csi.iscritto.serviscritto.business.domanda.service;

import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.LOG_BEGIN;
import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.LOG_END;
import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.buildMessage;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import it.csi.iscritto.serviscritto.business.integration.converter.domande.AnagraficaEtaConverter;
import it.csi.iscritto.serviscritto.business.integration.converter.domande.AnagraficaGraduatoriaConverter;
import it.csi.iscritto.serviscritto.business.integration.converter.domande.AnagraficaStepGraduatoriaConverter;
import it.csi.iscritto.serviscritto.business.integration.converter.domande.TipoFasciaEtaConverter;
import it.csi.iscritto.serviscritto.business.integration.dao.TipoScuola;
import it.csi.iscritto.serviscritto.business.integration.dao.custom.AnagraficaDao;
import it.csi.iscritto.serviscritto.business.integration.dao.custom.dto.AnagraficaEtaRow;
import it.csi.iscritto.serviscritto.business.integration.dao.custom.dto.AnagraficaGraduatoriaRow;
import it.csi.iscritto.serviscritto.business.integration.dao.custom.dto.AnagraficaStepGraduatoriaRow;
import it.csi.iscritto.serviscritto.business.integration.exception.DaoException;
import it.csi.iscritto.serviscritto.business.integration.validation.ErrorCodeEnum;
import it.csi.iscritto.serviscritto.business.util.Constants;
import it.csi.iscritto.serviscritto.dto.domanda.AnagraficaEta;
import it.csi.iscritto.serviscritto.dto.domanda.AnagraficaGraduatoria;
import it.csi.iscritto.serviscritto.dto.domanda.AnagraficaStepGraduatoria;
import it.csi.iscritto.serviscritto.dto.domanda.TipoFasciaEta;
import it.csi.iscritto.serviscritto.exception.domanda.ValidationException;

public class AnagraficaService {
	private static final Logger log = Logger.getLogger(Constants.COMPONENT_NAME + ".business");

	private AnagraficaDao anagraficaDao;

	public void setAnagraficaDao(AnagraficaDao anagraficaDao) {
		this.anagraficaDao = anagraficaDao;
	}

	//////////////////////////////////////////////////////////////////////
	// anagrafica graduatorie
	//////////////////////////////////////////////////////////////////////
	public List<AnagraficaGraduatoria> getAnagraficaGraduatorie() throws DaoException {
		final String methodName = "getAnagraficaGraduatorie";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		List<AnagraficaGraduatoria> result = new AnagraficaGraduatoriaConverter().convertAll(
				this.anagraficaDao.findAnagraficaGraduatorie());

		log.info(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	public AnagraficaGraduatoria getAnagraficaGraduatoria(String codOrdineScuola, String codAnagraficaGra, String codAnnoScolastico)
			throws DaoException, ValidationException {

		final String methodName = "getAnagraficaGraduatoria";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		TipoScuola tipoScuola = TipoScuola.findByCod(codOrdineScuola);
		if (tipoScuola == null || StringUtils.isEmpty(codAnagraficaGra) || StringUtils.isEmpty(codAnnoScolastico)) {
			throw ErrorCodeEnum.VAL_RIC_001.buildException();
		}

		AnagraficaGraduatoria result = new AnagraficaGraduatoriaConverter().convert(
				this.anagraficaDao.findAnagraficaGraduatoria(tipoScuola, codAnagraficaGra, codAnnoScolastico));

		log.info(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	public Long insertAnagraficaGraduatoria(AnagraficaGraduatoria anagraficaGraduatoria) throws DaoException, ValidationException {
		final String methodName = "insertAnagraficaGraduatoria";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		Long result = this.anagraficaDao.insertAnagraficaGraduatoria(
				buildAnagraficaGraduatoriaRow(anagraficaGraduatoria));

		log.info(buildMessage(getClass(), methodName, "result: " + result));

		log.info(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	public Integer updateAnagraficaGraduatoria(AnagraficaGraduatoria anagraficaGraduatoria) throws DaoException, ValidationException {
		final String methodName = "updateAnagraficaGraduatoria";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		Integer result = this.anagraficaDao.updateAnagraficaGraduatoria(
				buildAnagraficaGraduatoriaRow(anagraficaGraduatoria));

		log.info(buildMessage(getClass(), methodName, "result: " + result));

		log.info(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	//////////////////////////////////////////////////////////////////////
	// anagrafica step graduatoria
	//////////////////////////////////////////////////////////////////////
	public List<AnagraficaStepGraduatoria> getElencoAnagraficaStepGraduatoria(String codOrdineScuola, String codAnagraficaGra, String codAnnoScolastico)
			throws DaoException, ValidationException {

		final String methodName = "getElencoAnagraficaStepGraduatoria";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		TipoScuola tipoScuola = TipoScuola.findByCod(codOrdineScuola);
		if (tipoScuola == null || StringUtils.isEmpty(codAnagraficaGra) || StringUtils.isEmpty(codAnnoScolastico)) {
			throw ErrorCodeEnum.VAL_RIC_001.buildException();
		}

		List<AnagraficaStepGraduatoria> result = new AnagraficaStepGraduatoriaConverter().convertAll(
				this.anagraficaDao.findElencoAnagraficaStepGraduatoria(tipoScuola, codAnagraficaGra, codAnnoScolastico));

		log.info(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	public Long insertAnagraficaStepGraduatoria(AnagraficaStepGraduatoria stepGraduatoria) throws DaoException, ValidationException {
		final String methodName = "insertAnagraficaStepGraduatoria";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		Long result = this.anagraficaDao.insertAnagraficaStepGraduatoria(
				buildStepGraduatoriaRow(stepGraduatoria));

		log.info(buildMessage(getClass(), methodName, "result: " + result));

		log.info(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	public Integer updateAnagraficaStepGraduatoria(AnagraficaStepGraduatoria stepGraduatoria) throws DaoException, ValidationException {
		final String methodName = "updateAnagraficaStepGraduatoria";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		Integer result = this.anagraficaDao.updateAnagraficaStepGraduatoria(
				buildStepGraduatoriaRow(stepGraduatoria));

		log.info(buildMessage(getClass(), methodName, "result: " + result));

		log.info(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	public Integer deleteAnagraficaStepGraduatoria(Long idStepGra) throws DaoException, ValidationException {
		final String methodName = "deleteAnagraficaStepGraduatoria";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		Integer result = this.anagraficaDao.deleteAnagraficaStepGraduatoria(idStepGra);

		log.info(buildMessage(getClass(), methodName, "result: " + result));

		log.info(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	//////////////////////////////////////////////////////////////////////
	// anagrafica fasce eta'
	//////////////////////////////////////////////////////////////////////
	public List<AnagraficaEta> getAnagraficaEta(String codOrdineScuola, String codAnagraficaGra, String codAnnoScolastico)
			throws DaoException, ValidationException {

		final String methodName = "getAnagraficaEta";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		TipoScuola tipoScuola = TipoScuola.findByCod(codOrdineScuola);
		if (tipoScuola == null || StringUtils.isEmpty(codAnagraficaGra) || StringUtils.isEmpty(codAnnoScolastico)) {
			throw ErrorCodeEnum.VAL_RIC_001.buildException();
		}

		List<AnagraficaEta> result = new AnagraficaEtaConverter().convertAll(
				this.anagraficaDao.findAnagraficaEta(tipoScuola, codAnagraficaGra, codAnnoScolastico));

		log.info(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	public List<TipoFasciaEta> getTipiFasceEta() throws DaoException {
		final String methodName = "getTipiFasceEta";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		List<TipoFasciaEta> result = new TipoFasciaEtaConverter().convertAll(
				this.anagraficaDao.findTipiFasceEta());

		log.info(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	public Long insertAnagraficaEta(AnagraficaEta anagraficaEta) throws DaoException, ValidationException {
		final String methodName = "insertAnagraficaEta";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		Long result = this.anagraficaDao.insertAnagraficaEta(
				buildAnagraficaEtaRow(anagraficaEta));

		log.info(buildMessage(getClass(), methodName, "result: " + result));

		log.info(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	public Integer updateAnagraficaEta(AnagraficaEta anagraficaEta) throws DaoException, ValidationException {
		final String methodName = "updateAnagraficaEta";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		Integer result = this.anagraficaDao.updateAnagraficaEta(
				buildAnagraficaEtaRow(anagraficaEta));

		log.info(buildMessage(getClass(), methodName, "result: " + result));

		log.info(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	public Integer deleteAnagraficaEta(Long idEta) throws DaoException, ValidationException {
		final String methodName = "deleteAnagraficaEta";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		Integer result = this.anagraficaDao.deleteAnagraficaEta(idEta);

		log.info(buildMessage(getClass(), methodName, "result: " + result));

		log.info(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	//////////////////////////////////////////////////////////////////////

	private static AnagraficaGraduatoriaRow buildAnagraficaGraduatoriaRow(AnagraficaGraduatoria source) {
		AnagraficaGraduatoriaRow target = new AnagraficaGraduatoriaRow();
		if (source != null) {
			target.setCodAnagraficaGra(source.getCodAnagraficaGraduatoria());
			target.setCodAnnoScolastico(source.getCodAnnoScolastico());
			target.setCodOrdineScuola(source.getCodOrdineScuola());
			target.setDtFineIscr(source.getDataFineIscrizioni());
			target.setDtInizioIscr(source.getDataInizioIscrizioni());
			target.setDtScadenzaGrad(source.getDataScadenzaGraduatoria());
			target.setDtScadenzaIscr(source.getDataScadenzaIscrizioni());
			target.setDtScadenzaRicorsi(source.getDataScadenzaRicorsi());
			target.setIdAnagraficaGra(source.getIdAnagraficaGraduatoria());
		}

		return target;
	}

	private static AnagraficaStepGraduatoriaRow buildStepGraduatoriaRow(AnagraficaStepGraduatoria source) {
		AnagraficaStepGraduatoriaRow target = new AnagraficaStepGraduatoriaRow();
		if (source != null) {
			target.setDtAllegati(source.getDtAllegati());
			target.setDtDomInvA(source.getDtDomInvA());
			target.setDtDomInvDa(source.getDtDomInvDa());
			target.setDtStepGra(source.getDtStepGra());
			target.setIdStepGra(source.getIdStepGra());
			target.setStep(source.getStep());
			target.setCodAnagraficaGra(source.getCodAnagraficaGraduatoria());
			target.setCodAnnoScolastico(source.getCodAnnoScolastico());
			target.setCodOrdineScuola(source.getCodOrdineScuola());
		}

		return target;
	}

	private static AnagraficaEtaRow buildAnagraficaEtaRow(AnagraficaEta source) {
		AnagraficaEtaRow target = new AnagraficaEtaRow();
		if (source != null) {
			target.setCodAnagraficaGra(source.getCodAnagraficaGraduatoria());
			target.setCodAnnoScolastico(source.getCodAnnoScolastico());
			target.setCodFasciaEta(source.getCodFasciaEta());
			target.setCodOrdineScuola(source.getCodOrdineScuola());
			target.setDataA(source.getDataA());
			target.setDataDa(source.getDataDa());
			target.setIdEta(source.getIdEta());
		}

		return target;
	}

}
