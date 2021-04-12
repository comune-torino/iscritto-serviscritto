package it.csi.iscritto.serviscritto.business.domanda.service;

import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.LOG_BEGIN;
import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.LOG_END;
import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.buildMessage;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import it.csi.iscritto.serviscritto.business.integration.converter.ResultDaoConverter;
import it.csi.iscritto.serviscritto.business.integration.converter.domande.AnnoScolasticoConverter;
import it.csi.iscritto.serviscritto.business.integration.converter.domande.ClasseConverter;
import it.csi.iscritto.serviscritto.business.integration.converter.domande.GraduatoriaApprovazioneConverter;
import it.csi.iscritto.serviscritto.business.integration.converter.domande.GraduatoriaConverter;
import it.csi.iscritto.serviscritto.business.integration.converter.domande.GraduatoriaNidoConverter;
import it.csi.iscritto.serviscritto.business.integration.converter.domande.InfoStepGraduatoriaConverter;
import it.csi.iscritto.serviscritto.business.integration.converter.domande.InfoVerificheConverter;
import it.csi.iscritto.serviscritto.business.integration.converter.domande.RecordPreferenzaScuolaConverter;
import it.csi.iscritto.serviscritto.business.integration.converter.domande.StepGraduatoriaConverter;
import it.csi.iscritto.serviscritto.business.integration.converter.domande.TestataGraduatoriaConverter;
import it.csi.iscritto.serviscritto.business.integration.converter.report.GraduatoriaCompletaConverter;
import it.csi.iscritto.serviscritto.business.integration.converter.report.ReportDomandeScuolaResidenzaConverter;
import it.csi.iscritto.serviscritto.business.integration.converter.report.ReportPostiLiberiConverter;
import it.csi.iscritto.serviscritto.business.integration.converter.report.ResidenzaForzataConverter;
import it.csi.iscritto.serviscritto.business.integration.dao.StatoGraduatoria;
import it.csi.iscritto.serviscritto.business.integration.dao.TipoScuola;
import it.csi.iscritto.serviscritto.business.integration.dao.TipoVerificheIstruttoria;
import it.csi.iscritto.serviscritto.business.integration.dao.custom.GraduatoriaDao;
import it.csi.iscritto.serviscritto.business.integration.dao.custom.ReportDao;
import it.csi.iscritto.serviscritto.business.integration.dao.table.DecodificaDao;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTAnagraficaGra;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTDomandaIsc;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTStepGra;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTStepGraCon;
import it.csi.iscritto.serviscritto.business.integration.exception.DaoException;
import it.csi.iscritto.serviscritto.business.integration.validation.ErrorCodeEnum;
import it.csi.iscritto.serviscritto.business.util.Constants;
import it.csi.iscritto.serviscritto.business.util.Joiner;
import it.csi.iscritto.serviscritto.business.util.converter.ConvertUtils;
import it.csi.iscritto.serviscritto.dto.domanda.AnnoScolastico;
import it.csi.iscritto.serviscritto.dto.domanda.Classe;
import it.csi.iscritto.serviscritto.dto.domanda.ClasseParam;
import it.csi.iscritto.serviscritto.dto.domanda.Graduatoria;
import it.csi.iscritto.serviscritto.dto.domanda.GraduatoriaApprovazione;
import it.csi.iscritto.serviscritto.dto.domanda.GraduatoriaCompleta;
import it.csi.iscritto.serviscritto.dto.domanda.InfoResidenzeForzate;
import it.csi.iscritto.serviscritto.dto.domanda.InfoStepGraduatoria;
import it.csi.iscritto.serviscritto.dto.domanda.InfoVerifiche;
import it.csi.iscritto.serviscritto.dto.domanda.Nido;
import it.csi.iscritto.serviscritto.dto.domanda.ParametriCalcoloGraduatoria;
import it.csi.iscritto.serviscritto.dto.domanda.ParametriGraduatoria;
import it.csi.iscritto.serviscritto.dto.domanda.RecordDomandeScuolaResidenza;
import it.csi.iscritto.serviscritto.dto.domanda.RecordPostiLiberi;
import it.csi.iscritto.serviscritto.dto.domanda.RecordPreferenzaScuola;
import it.csi.iscritto.serviscritto.dto.domanda.ResidenzaForzata;
import it.csi.iscritto.serviscritto.dto.domanda.Result;
import it.csi.iscritto.serviscritto.dto.domanda.RicercaGraduatorieFilter;
import it.csi.iscritto.serviscritto.dto.domanda.StepGraduatoria;
import it.csi.iscritto.serviscritto.dto.domanda.TestataGraduatoria;
import it.csi.iscritto.serviscritto.exception.domanda.ValidationException;

public class GraduatoriaService {
	private static final Logger log = Logger.getLogger(Constants.COMPONENT_NAME + ".business");

	private GraduatoriaDao graduatoriaDao;
	private ReportDao reportDao;
	private DecodificaDao decodificaDao;

	public void setGraduatoriaDao(GraduatoriaDao graduatoriaDao) {
		this.graduatoriaDao = graduatoriaDao;
	}

	public void setReportDao(ReportDao reportDao) {
		this.reportDao = reportDao;
	}

	public void setDecodificaDao(DecodificaDao decodificaDao) {
		this.decodificaDao = decodificaDao;
	}

	//////////////////////////////////////////////////////////////////////

	public ParametriGraduatoria getParametriUltimaGraduatoria(TipoScuola tipoScuola) throws DaoException, ValidationException {
		final String methodName = "getParametriUltimaGraduatoria";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		log.info(buildMessage(getClass(), methodName, "tipoScuola: " + tipoScuola));
		Validate.notNull(tipoScuola);

		IscrittoTAnagraficaGra ultimaGraduatoria = this.getUltimaGraduatoria(tipoScuola);
		ParametriGraduatoria result = this.getParametriGraduatoria(ultimaGraduatoria.getCodAnagraficaGra(), tipoScuola);

		log.info(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	public ParametriGraduatoria getParametriGraduatoria(String codGraduatoria, TipoScuola tipoScuola) throws DaoException, ValidationException {
		final String methodName = "getParametriGraduatoria";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		log.info(buildMessage(getClass(), methodName, "codGraduatoria: " + codGraduatoria));
		log.info(buildMessage(getClass(), methodName, "tipoScuola: " + tipoScuola));

		Validate.notBlank(codGraduatoria);
		Validate.notNull(tipoScuola);

		IscrittoTAnagraficaGra graduatoria = this.getGraduatoria(codGraduatoria, tipoScuola);
		log.info(buildMessage(getClass(), methodName, "codAnagraficaGra: " + graduatoria.getCodAnagraficaGra()));

		IscrittoTStepGra stepGra = this.getStepGraduatoria(graduatoria.getIdAnagraficaGra());
		log.info(buildMessage(getClass(), methodName, "idStepGra: " + stepGra.getIdStepGra()));

		IscrittoTStepGraCon stepGraCon = this.getStepGraduatoriaCon(stepGra.getIdStepGra());

		ParametriGraduatoria result = new ParametriGraduatoria();
		result.setCodice(graduatoria.getCodAnagraficaGra());
		result.setStep(stepGra.getStep());

		if (stepGraCon == null) {
			log.info(buildMessage(getClass(), methodName, "idStepGraCon: null"));
			result.setCodiceStato(StatoGraduatoria.CAL.getCod());
			result.setDataUltimoCalcolo(null);
			result.setAmmissioni(false);
		}
		else {
			log.info(buildMessage(getClass(), methodName, "idStepGraCon: " + stepGraCon.getIdStepGraCon()));
			result.setAmmissioni(ConvertUtils.fromSN(stepGraCon.getFlAmmissioni()));
			result.setCodiceStato(this.decodificaDao.findIscrittoDStatoGraByKey(stepGraCon.getIdStatoGra()).getCodStatoGra());
			result.setDataUltimoCalcolo(stepGraCon.getDtStepCon());
		}

		log.info(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	public List<Graduatoria> getElencoGraduatorie(TipoScuola tipoScuola) throws DaoException {
		final String methodName = "getElencoGraduatorie";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		log.info(buildMessage(getClass(), methodName, "tipoScuola: " + tipoScuola));
		Validate.notNull(tipoScuola);

		List<Graduatoria> result = new GraduatoriaConverter().convertAll(
				this.graduatoriaDao.findElencoGraduatorie(tipoScuola));

		log.info(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	public List<StepGraduatoria> getElencoStepGraduatoria(TipoScuola tipoScuola, String codiceGraduatoria) throws DaoException {
		final String methodName = "getElencoStepGraduatoria";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		log.info(buildMessage(getClass(), methodName, "tipoScuola: " + tipoScuola));
		log.info(buildMessage(getClass(), methodName, "codiceGraduatoria: " + codiceGraduatoria));

		Validate.notNull(tipoScuola);
		Validate.notBlank(codiceGraduatoria);

		List<StepGraduatoria> result = new StepGraduatoriaConverter().convertAll(
				this.graduatoriaDao.findElencoStepGraduatoria(tipoScuola, codiceGraduatoria));

		log.info(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	public List<InfoStepGraduatoria> getInfoStepGraduatorie(TipoScuola tipoScuola) throws DaoException {
		final String methodName = "getInfoStepGraduatorie";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		log.info(buildMessage(getClass(), methodName, "tipoScuola: " + tipoScuola));
		Validate.notNull(tipoScuola);

		List<InfoStepGraduatoria> result = new InfoStepGraduatoriaConverter().convertAll(
				this.graduatoriaDao.findInfoStepGraduatorie(tipoScuola));

		log.info(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	public List<TestataGraduatoria> ricercaGraduatorie(RicercaGraduatorieFilter filtroRicerca) throws DaoException {
		final String methodName = "ricercaGraduatorie";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		log.info(buildMessage(getClass(), methodName, "filtroRicerca: " + filtroRicerca));
		Validate.notNull(filtroRicerca);

		List<TestataGraduatoria> result = new TestataGraduatoriaConverter().convertAll(
				this.graduatoriaDao.findGraduatorie(filtroRicerca));

		log.info(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	public List<Long> getDomandeNonIstruite(TipoScuola tipoScuola) throws DaoException, ValidationException {
		final String methodName = "getDomandeNonIstruite";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		log.info(buildMessage(getClass(), methodName, "tipoScuola: " + tipoScuola));

		List<Long> result = new ArrayList<>();

		List<IscrittoTDomandaIsc> rows = this.graduatoriaDao.findDomandeNonIstruite(tipoScuola);
		if (CollectionUtils.isNotEmpty(rows)) {
			for (IscrittoTDomandaIsc row : rows) {
				result.add(row.getIdDomandaIscrizione());
			}
		}

		log.info(buildMessage(getClass(), methodName, String.format(
				"trovate %d domande non istruite", CollectionUtils.size(result))));

		log.info(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	public List<InfoVerifiche> getVerifichePendenti(List<Long> idDomande, TipoVerificheIstruttoria tipoVerificheIstruttoria)
			throws DaoException, ValidationException {

		final String methodName = "getVerifichePendenti";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		List<InfoVerifiche> result = new InfoVerificheConverter().convertAll(
				this.graduatoriaDao.findInfoVerifiche(idDomande, tipoVerificheIstruttoria));

		log.info(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}
	
	@Transactional(timeout=300)
	public void calcolaGraduatoria(ParametriCalcoloGraduatoria parametri) throws DaoException, ValidationException {
		final String methodName = "calcolaGraduatoria";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		try {


			this.checkParametriCalcoloGraduatoria(parametri);

			String codGraduatoria = parametri.getCodiceGraduatoria();
			StatoGraduatoria statoAttuale = StatoGraduatoria.findByCod(parametri.getCodiceStato());
			StatoGraduatoria statoDaCalcolare = StatoGraduatoria.findByCod(parametri.getCodiceStatoDaCalcolare());
			TipoScuola tipoScuola = TipoScuola.findByCod(parametri.getOrdineScuola());
			Integer step = parametri.getStep();

			log.info(buildMessage(getClass(), methodName, "codGraduatoria: " + codGraduatoria));
			log.info(buildMessage(getClass(), methodName, "statoAttuale: " + statoAttuale));
			log.info(buildMessage(getClass(), methodName, "statoDaCalcolare: " + statoDaCalcolare));
			log.info(buildMessage(getClass(), methodName, "tipoScuola: " + tipoScuola));
			log.info(buildMessage(getClass(), methodName, "step: " + step));

			this.graduatoriaDao.calcolaGraduatoria(tipoScuola, codGraduatoria, statoAttuale, statoDaCalcolare, step);

		}catch (Exception e) {
			log.error("Errore generaLibrettoImportNew",e);
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}finally{
			log.info(buildMessage(getClass(), methodName, LOG_END));
		}

	}

	public List<AnnoScolastico> getElencoAnniScolastici() throws DaoException {
		final String methodName = "getElencoAnniScolastici";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		List<AnnoScolastico> result = new AnnoScolasticoConverter().convertAll(
				this.graduatoriaDao.findAnniScolastici());

		log.info(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	public List<Classe> getElencoClassi(String codScuola, TipoScuola tipoScuola, String codAnnoScolastico) throws DaoException {
		final String methodName = "getElencoClassi";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		log.info(buildMessage(getClass(), methodName, "codScuola: " + codScuola));
		log.info(buildMessage(getClass(), methodName, "tipoScuola: " + tipoScuola));
		log.info(buildMessage(getClass(), methodName, "codAnnoScolastico: " + codAnnoScolastico));

		Validate.notNull(tipoScuola);

		List<Classe> result = new ClasseConverter().convertAll(
				this.graduatoriaDao.findClassi(tipoScuola, codScuola, codAnnoScolastico));

		log.info(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	public Long insertClasse(ClasseParam classe, TipoScuola tipoScuola) throws DaoException, ValidationException {
		final String methodName = "insertClasse";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		log.info(buildMessage(getClass(), methodName, "tipoScuola: " + tipoScuola));

		this.checkParametriClasse(classe, tipoScuola, false);

		log.info(buildMessage(getClass(), methodName, "codAnnoScolastico: " + classe.getCodAnnoScolastico()));
		log.info(buildMessage(getClass(), methodName, "codFasciaEta: " + classe.getCodFasciaEta()));
		log.info(buildMessage(getClass(), methodName, "codScuola: " + classe.getCodScuola()));
		log.info(buildMessage(getClass(), methodName, "codTipoFrequenza: " + classe.getCodTipoFrequenza()));
		log.info(buildMessage(getClass(), methodName, "denominazione: " + classe.getDenominazione()));
		log.info(buildMessage(getClass(), methodName, "postiAmmessi: " + classe.getPostiAmmessi()));
		log.info(buildMessage(getClass(), methodName, "postiLiberi: " + classe.getPostiLiberi()));
		log.info(buildMessage(getClass(), methodName, "ammissioneDis: " + classe.getAmmissioneDis()));

		Long result = this.graduatoriaDao.insertClasse(tipoScuola, classe);

		log.info(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	public Integer updateClasse(ClasseParam classe, TipoScuola tipoScuola) throws DaoException, ValidationException {
		final String methodName = "updateClasse";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		log.info(buildMessage(getClass(), methodName, "tipoScuola: " + tipoScuola));

		this.checkParametriClasse(classe, tipoScuola, true);

		log.info(buildMessage(getClass(), methodName, "idClasse: " + classe.getIdClasse()));
		log.info(buildMessage(getClass(), methodName, "codAnnoScolastico: " + classe.getCodAnnoScolastico()));
		log.info(buildMessage(getClass(), methodName, "codFasciaEta: " + classe.getCodFasciaEta()));
		log.info(buildMessage(getClass(), methodName, "codScuola: " + classe.getCodScuola()));
		log.info(buildMessage(getClass(), methodName, "codTipoFrequenza: " + classe.getCodTipoFrequenza()));
		log.info(buildMessage(getClass(), methodName, "denominazione: " + classe.getDenominazione()));
		log.info(buildMessage(getClass(), methodName, "postiAmmessi: " + classe.getPostiAmmessi()));
		log.info(buildMessage(getClass(), methodName, "postiLiberi: " + classe.getPostiLiberi()));
		log.info(buildMessage(getClass(), methodName, "ammissioneDis: " + classe.getAmmissioneDis()));

		Integer result = this.graduatoriaDao.updateClasse(tipoScuola, classe);

		log.info(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	public Integer deleteClasse(Long idClasse) throws DaoException, ValidationException {
		final String methodName = "deleteClasse";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		log.info(buildMessage(getClass(), methodName, "idClasse: " + idClasse));
		Validate.notNull(idClasse);

		boolean canDelete = this.graduatoriaDao.canDeleteClasse(idClasse);
		if (!canDelete) {
			log.error(buildMessage(getClass(), methodName, "la classe ha delle preferenze associate"));
			throw ErrorCodeEnum.VAL_GRA_009.buildException();
		}

		Integer result = this.graduatoriaDao.deleteClasse(idClasse);

		log.info(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	public Integer updateFlagAmmissioni(List<Long> idClasseList, Boolean value) throws DaoException {
		final String methodName = "updateFlagAmmissioni";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		Validate.isTrue(CollectionUtils.isNotEmpty(idClasseList));
		log.info(buildMessage(getClass(), methodName, "idClasseList: " + Joiner.on(", ").join(idClasseList)));
		log.info(buildMessage(getClass(), methodName, "value: " + value));

		Integer result = this.graduatoriaDao.updateFlagAmmissioni(idClasseList, value);

		log.info(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	public List<Nido> getElencoNidi(Long idDomanda) throws DaoException {
		final String methodName = "getElencoNidi";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		log.info(buildMessage(getClass(), methodName, "idDomanda: " + idDomanda));

		List<Nido> result = new GraduatoriaNidoConverter().convertAll(
				this.graduatoriaDao.findElencoNidi(idDomanda));

		log.info(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	public InfoResidenzeForzate getResidenzeForzate(TipoScuola tipoScuola) throws DaoException, ValidationException {
		final String methodName = "getResidenzeForzate";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		log.info(buildMessage(getClass(), methodName, "tipoScuola: " + tipoScuola));
		Validate.notNull(tipoScuola);

		InfoResidenzeForzate result = new InfoResidenzeForzate();
		result.setCodTipoScuola(tipoScuola.getCod());

		// ultima graduatoria
		IscrittoTAnagraficaGra graduatoria = this.getUltimaGraduatoria(tipoScuola);
		result.setCodGraduatoria(graduatoria.getCodAnagraficaGra());
		log.info(buildMessage(getClass(), methodName, "codAnagraficaGra: " + graduatoria.getCodAnagraficaGra()));

		// step graduatoria
		IscrittoTStepGra stepGra = this.getStepGraduatoria(graduatoria.getIdAnagraficaGra());
		result.setIdStepGra(stepGra.getIdStepGra());
		log.info(buildMessage(getClass(), methodName, "idStepGra: " + stepGra.getIdStepGra()));

		// step graduatoria congelata
		IscrittoTStepGraCon stepGraCon = this.getStepGraduatoriaCon(stepGra.getIdStepGra());
		if (stepGraCon != null) {
			Long idStepGraCon = stepGraCon.getIdStepGraCon();
			result.setIdStepGraCon(idStepGraCon);
			log.info(buildMessage(getClass(), methodName, "idStepGraCon: " + idStepGraCon));

			List<ResidenzaForzata> residenzeForzate = new ResidenzaForzataConverter().convertAll(
					this.reportDao.findResidenzeForzate(idStepGraCon));

			result.setResidenzeForzate(ConvertUtils.toArray(residenzeForzate, ResidenzaForzata.class));
		}
		else {
			log.error(buildMessage(getClass(), methodName, "idStepGraCon: non presente"));
		}

		log.info(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	public List<GraduatoriaCompleta> getGraduatoriaCompleta(TipoScuola tipoScuola) throws DaoException, ValidationException {
		final String methodName = "getGraduatoriaCompleta";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		log.info(buildMessage(getClass(), methodName, "tipoScuola: " + tipoScuola));
		Validate.notNull(tipoScuola);

		List<GraduatoriaCompleta> result = new ArrayList<>();

		// ultima graduatoria
		IscrittoTAnagraficaGra graduatoria = this.getUltimaGraduatoria(tipoScuola);
		log.info(buildMessage(getClass(), methodName, "codAnagraficaGra: " + graduatoria.getCodAnagraficaGra()));

		// step graduatoria
		IscrittoTStepGra stepGra = this.getStepGraduatoria(graduatoria.getIdAnagraficaGra());
		log.info(buildMessage(getClass(), methodName, "idStepGra: " + stepGra.getIdStepGra()));

		// step graduatoria congelata
		IscrittoTStepGraCon stepGraCon = this.getStepGraduatoriaCon(stepGra.getIdStepGra());
		if (stepGraCon != null) {
			Long idStepGraCon = stepGraCon.getIdStepGraCon();
			log.info(buildMessage(getClass(), methodName, "idStepGraCon: " + idStepGraCon));

			result = new GraduatoriaCompletaConverter().convertAll(
					this.reportDao.findGraduatoriaCompleta(tipoScuola, idStepGraCon));
		}
		else {
			log.error(buildMessage(getClass(), methodName, "idStepGraCon: non presente"));
		}

		log.info(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	public List<GraduatoriaApprovazione> getGraduatoriaApprovazione(String codGraduatoria, Integer step, String codStatoGraduatoria, TipoScuola tipoScuola)
			throws DaoException, ValidationException {

		final String methodName = "getGraduatoriaApprovazione";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		log.info(buildMessage(getClass(), methodName, "codGraduatoria: " + codGraduatoria));
		log.info(buildMessage(getClass(), methodName, "step: " + step));
		log.info(buildMessage(getClass(), methodName, "codStatoGraduatoria: " + codStatoGraduatoria));
		log.info(buildMessage(getClass(), methodName, "tipoScuola: " + tipoScuola));

		Validate.notNull(tipoScuola);
		Validate.notEmpty(codGraduatoria);
		Validate.notNull(step);
		Validate.notEmpty(codStatoGraduatoria);

		List<GraduatoriaApprovazione> result = new GraduatoriaApprovazioneConverter().convertAll(
				this.reportDao.findGraduatoriaApprovazione(tipoScuola, codGraduatoria, step, codStatoGraduatoria));

		log.info(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	public List<RecordPostiLiberi> getReportPostiLiberi(String codOrdineScuola) throws DaoException, ValidationException {
		final String methodName = "getReportPostiLiberi";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		List<RecordPostiLiberi> result = new ReportPostiLiberiConverter().convertAll(
				this.reportDao.findPostiLiberi(codOrdineScuola));

		log.info(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}
	public List<RecordDomandeScuolaResidenza> getReportDomandeScuolaResidenza() throws DaoException, ValidationException {
		final String methodName = "getRecordDomandeScuolaResidenza";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		List<RecordDomandeScuolaResidenza> result = new ReportDomandeScuolaResidenzaConverter().convertAll(
				this.reportDao.findDomandeScuolaResidenza());

		log.info(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	public List<RecordPreferenzaScuola> getPreferenzeScuole(Long idAnagraficaGra, Long idDomanda) throws DaoException, ValidationException {
		final String methodName = "getPreferenzeScuole";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		List<RecordPreferenzaScuola> result = new RecordPreferenzaScuolaConverter().convertAll(
				this.graduatoriaDao.findPreferenzeScuole(idAnagraficaGra, idDomanda));

		log.info(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	public Result modificaStatoScuolaPreferenza(Long idGraduatoria, Long idStatoAttuale, Long idStatoRipristino) throws DaoException, ValidationException {
		final String methodName = "modificaStatoScuolaPreferenza";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		log.info(buildMessage(getClass(), methodName, "idGraduatoria: " + idGraduatoria));
		log.info(buildMessage(getClass(), methodName, "idStatoAttuale: " + idStatoAttuale));
		log.info(buildMessage(getClass(), methodName, "idStatoRipristino: " + idStatoRipristino));

		Result result = new ResultDaoConverter().convert(
				this.graduatoriaDao.updateStatoScuolaPreferenza(idGraduatoria, idStatoAttuale, idStatoRipristino));

		log.info(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	//////////////////////////////////////////////////////////////////////

	private IscrittoTAnagraficaGra getUltimaGraduatoria(TipoScuola tipoScuola) throws DaoException, ValidationException {
		final String methodName = "getUltimaGraduatoria";
		log.info(buildMessage(getClass(), methodName, "tipoScuola: " + tipoScuola));

		List<IscrittoTAnagraficaGra> graduatoriaList = this.graduatoriaDao.findUltimaGraduatoria(tipoScuola);
		int numGraduatorie = CollectionUtils.size(graduatoriaList);

		if (numGraduatorie != 1) {
			log.error(buildMessage(getClass(), methodName, String.format(
					"trovate %d graduatorie, il valore deve essere 1", numGraduatorie)));

			throw ErrorCodeEnum.VAL_GRA_001.buildException();
		}

		return ConvertUtils.getFirst(graduatoriaList);
	}

	private IscrittoTAnagraficaGra getGraduatoria(String codGraduatoria, TipoScuola tipoScuola) throws DaoException, ValidationException {
		final String methodName = "getGraduatoria";
		log.info(buildMessage(getClass(), methodName, "tipoScuola: " + tipoScuola));
		log.info(buildMessage(getClass(), methodName, "codGraduatoria: " + codGraduatoria));

		List<IscrittoTAnagraficaGra> graduatoriaList = this.graduatoriaDao.findGraduatoria(tipoScuola, codGraduatoria);
		int numGraduatorie = CollectionUtils.size(graduatoriaList);

		if (numGraduatorie != 1) {
			log.error(buildMessage(getClass(), methodName, String.format(
					"trovate %d graduatorie, il valore deve essere 1", numGraduatorie)));

			throw ErrorCodeEnum.VAL_GRA_002.buildException();
		}

		return ConvertUtils.getFirst(graduatoriaList);
	}

	private IscrittoTStepGra getStepGraduatoria(Long idAnagraficaGra) throws DaoException, ValidationException {
		final String methodName = "getStepGraduatoria";
		log.info(buildMessage(getClass(), methodName, "idAnagraficaGra: " + idAnagraficaGra));

		IscrittoTStepGra row = this.graduatoriaDao.findStepGraduatoria(idAnagraficaGra);
		if (row == null || row.getStep() == null) {
			log.error(buildMessage(getClass(), methodName, "step graduatoria non trovato"));

			throw ErrorCodeEnum.VAL_GRA_001.buildException();
		}

		return row;
	}

	private IscrittoTStepGraCon getStepGraduatoriaCon(Long idStepGra) throws DaoException, ValidationException {
		final String methodName = "getStepGraduatoriaCon";
		log.info(buildMessage(getClass(), methodName, "idStepGra: " + idStepGra));

		IscrittoTStepGraCon row = this.graduatoriaDao.findStepGraduatoriaCon(idStepGra);
		if (row != null) {
			if (row.getDtStepCon() == null) {
				log.error(buildMessage(getClass(), methodName, "iscritto_t_step_gra_con: campo dt_step_con obbligatorio"));

				throw ErrorCodeEnum.VAL_GRA_001.buildException();
			}

			if (row.getIdStatoGra() == null) {
				log.error(buildMessage(getClass(), methodName, "iscritto_t_step_gra_con: campo id_stato_gra obbligatorio"));

				throw ErrorCodeEnum.VAL_GRA_001.buildException();
			}
		}

		return row;
	}

	private void checkParametriCalcoloGraduatoria(ParametriCalcoloGraduatoria parametri) throws ValidationException {
		final String methodName = "checkParametriCalcoloGraduatoria";

		if (parametri == null) {
			log.error(buildMessage(getClass(), methodName, "parametri calcolo graduatoria"));
			throw ErrorCodeEnum.VAL_GRA_003.buildException();
		}

		if (StringUtils.isBlank(parametri.getCodiceGraduatoria())) {
			log.error(buildMessage(getClass(), methodName, "codice graduatoria:" + parametri.getCodiceGraduatoria()));
			throw ErrorCodeEnum.VAL_GRA_003.buildException();
		}

		if (StringUtils.isBlank(parametri.getCodiceStato()) || StatoGraduatoria.findByCod(parametri.getCodiceStato()) == null) {
			log.error(buildMessage(getClass(), methodName, "codice stato:" + parametri.getCodiceStato()));
			throw ErrorCodeEnum.VAL_GRA_003.buildException();
		}

		if (StringUtils.isBlank(parametri.getCodiceStatoDaCalcolare())) {
			log.info(buildMessage(getClass(), methodName, "codice stato da calcolare vuoto"));
		}
		else if (StatoGraduatoria.findByCod(parametri.getCodiceStatoDaCalcolare()) == null) {
			log.error(buildMessage(getClass(), methodName, "codice stato da calcolare:" + parametri.getCodiceStatoDaCalcolare()));
			throw ErrorCodeEnum.VAL_GRA_003.buildException();
		}

		if (TipoScuola.findByCod(parametri.getOrdineScuola()) == null) {
			log.error(buildMessage(getClass(), methodName, "codice ordine scuola:" + parametri.getOrdineScuola()));
			throw ErrorCodeEnum.VAL_GRA_003.buildException();
		}

		if (parametri.getStep() == null) {
			log.info(buildMessage(getClass(), methodName, "step nullo"));
		}
	}

	private void checkParametriClasse(ClasseParam classe, TipoScuola tipoScuola, boolean isUpdate) throws ValidationException {
		final String methodName = "checkParametriInserimentoClasse";

		if (classe == null) {
			log.error(buildMessage(getClass(), methodName, "oggetto classe nullo"));
			throw ErrorCodeEnum.VAL_GRA_008.buildException();
		}

		if (isUpdate) {
			if (classe.getIdClasse() == null) {
				log.error(buildMessage(getClass(), methodName, "idClasse nullo"));
				throw ErrorCodeEnum.VAL_GRA_008.buildException();
			}
		}

		if (tipoScuola == null) {
			log.error(buildMessage(getClass(), methodName, "tipoScuola nullo"));
			throw ErrorCodeEnum.VAL_GRA_008.buildException();
		}

		if (StringUtils.isBlank(classe.getCodAnnoScolastico())) {
			log.error(buildMessage(getClass(), methodName, "codAnnoScolastico nullo"));
			throw ErrorCodeEnum.VAL_GRA_008.buildException();
		}

		if (StringUtils.isBlank(classe.getCodFasciaEta())) {
			log.error(buildMessage(getClass(), methodName, "codFasciaEta nullo"));
			throw ErrorCodeEnum.VAL_GRA_008.buildException();
		}

		if (StringUtils.isBlank(classe.getCodScuola())) {
			log.error(buildMessage(getClass(), methodName, "codScuola nullo"));
			throw ErrorCodeEnum.VAL_GRA_008.buildException();
		}

		if (StringUtils.isBlank(classe.getCodTipoFrequenza())) {
			log.error(buildMessage(getClass(), methodName, "codTipoFrequenza nullo"));
			throw ErrorCodeEnum.VAL_GRA_008.buildException();
		}

		if (StringUtils.isBlank(classe.getDenominazione())) {
			log.error(buildMessage(getClass(), methodName, "denominazione nullo"));
			throw ErrorCodeEnum.VAL_GRA_008.buildException();
		}

		if (classe.getPostiLiberi() == null) {
			log.error(buildMessage(getClass(), methodName, "postiLiberi nullo"));
			throw ErrorCodeEnum.VAL_GRA_008.buildException();
		}

		if (classe.getPostiAmmessi() == null) {
			log.error(buildMessage(getClass(), methodName, "postiAmmessi nullo"));
			throw ErrorCodeEnum.VAL_GRA_008.buildException();
		}

		if (classe.getAmmissioneDis() == null) {
			log.error(buildMessage(getClass(), methodName, "ammissioneDis nullo"));
			throw ErrorCodeEnum.VAL_GRA_008.buildException();
		}
	}

	public Boolean getFlagBloccoGraduatoria(TipoScuola tipoScuola) throws DaoException{
		final String methodName = "getFlagBloccoGraduatoria";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		String row = this.graduatoriaDao.findFlagBloccoGraduatoria(tipoScuola);

		log.info(buildMessage(getClass(), methodName, LOG_END));
		return ConvertUtils.fromSN(row);
	}

	public void setFlagBloccoGraduatoria(TipoScuola tipoScuola, Boolean value)throws DaoException {
		final String methodName = "setFlagBloccoGraduatoria";
		log.info(buildMessage(getClass(), methodName, LOG_BEGIN));

		this.graduatoriaDao.updateFlagBloccoGraduatoria(tipoScuola, value);

		log.info(buildMessage(getClass(), methodName, LOG_END));

	}

}
