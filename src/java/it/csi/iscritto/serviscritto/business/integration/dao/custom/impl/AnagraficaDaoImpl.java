package it.csi.iscritto.serviscritto.business.integration.dao.custom.impl;

import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.LOG_BEGIN;
import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.LOG_END;
import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.buildMessage;

import java.util.List;

import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTGraduatoria;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import it.csi.iscritto.serviscritto.business.integration.dao.AbstractDao;
import it.csi.iscritto.serviscritto.business.integration.dao.TipoScuola;
import it.csi.iscritto.serviscritto.business.integration.dao.custom.AnagraficaDao;
import it.csi.iscritto.serviscritto.business.integration.dao.custom.dto.AnagraficaEtaRow;
import it.csi.iscritto.serviscritto.business.integration.dao.custom.dto.AnagraficaGraduatoriaRow;
import it.csi.iscritto.serviscritto.business.integration.dao.custom.dto.AnagraficaStepGraduatoriaRow;
import it.csi.iscritto.serviscritto.business.integration.dao.custom.dto.TipoFasciaEtaRow;
import it.csi.iscritto.serviscritto.business.integration.exception.DaoException;
import it.csi.iscritto.serviscritto.business.integration.validation.ErrorCodeEnum;
import it.csi.iscritto.serviscritto.business.util.Constants;
import it.csi.iscritto.serviscritto.business.util.converter.ConvertUtils;
import it.csi.iscritto.serviscritto.business.util.sql.SqlHolder;
import it.csi.iscritto.serviscritto.exception.domanda.ValidationException;

public class AnagraficaDaoImpl extends AbstractDao implements AnagraficaDao {
	private static final Logger log = Logger.getLogger(Constants.COMPONENT_NAME + ".dao");
	private static final String ID_ANAGRAFICA_GRA_SEQ = "iscritto_t_anagrafica_gra_id_anagrafica_gra_seq";
	private static final String ID_ANAGRAFICA_STEP_GRA_SQL = "iscritto_t_step_gra_id_step_gra_seq";
	private static final String ID_ANAGRAFICA_ETA_GRA_SEQ = "iscritto_t_eta_id_eta_seq";

	@Override
	public List<AnagraficaGraduatoriaRow> findAnagraficaGraduatorie() throws DaoException {
		final String methodName = "findAnagraficaGraduatorie";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		SqlHolder sh = buildSqlHolder()
				.addQueryRows(
						"select ",
						"  ag.id_anagrafica_gra, ",
						"  ag.cod_anagrafica_gra, ",
						"  ag.dt_inizio_iscr, ",
						"  ag.dt_scadenza_iscr, ",
						"  ag.dt_fine_iscr, ",
						"  ag.dt_scadenza_grad, ",
						"  ag.dt_scadenza_ricorsi,",
						"  ord.cod_ordine_scuola,",
						"  anno.cod_anno_scolastico",
						"from iscritto_t_anagrafica_gra ag",
						"  join iscritto_d_ordine_scuola ord on ord.id_ordine_scuola = ag.id_ordine_scuola",
						"  join iscritto_t_anno_sco anno on anno.id_anno_scolastico = ag.id_anno_scolastico");

		List<AnagraficaGraduatoriaRow> result = this.query(sh, AnagraficaGraduatoriaRow.class);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public AnagraficaGraduatoriaRow findAnagraficaGraduatoria(TipoScuola tipoScuola, String codAnagraficaGra, String codAnnoScolastico) throws DaoException {
		final String methodName = "findAnagraficaGraduatoria";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		log.info(buildMessage(getClass(), methodName, "codOrdineScuola: " + tipoScuola));
		log.info(buildMessage(getClass(), methodName, "codAnagraficaGra: " + codAnagraficaGra));
		log.info(buildMessage(getClass(), methodName, "codAnnoScolastico: " + codAnnoScolastico));

		SqlHolder sh = buildSqlHolder()
				.addQueryRows(
						"select ",
						"  ag.id_anagrafica_gra, ",
						"  ag.cod_anagrafica_gra, ",
						"  ag.dt_inizio_iscr, ",
						"  ag.dt_scadenza_iscr, ",
						"  ag.dt_fine_iscr, ",
						"  ag.dt_scadenza_grad, ",
						"  ag.dt_scadenza_ricorsi,",
						"  ord.cod_ordine_scuola,",
						"  anno.cod_anno_scolastico",
						"from iscritto_t_anagrafica_gra ag",
						"  join iscritto_d_ordine_scuola ord on ord.id_ordine_scuola = ag.id_ordine_scuola",
						"  join iscritto_t_anno_sco anno on anno.id_anno_scolastico = ag.id_anno_scolastico",
						"where 1 = 1",
						"  and ag.cod_anagrafica_gra = :codAnagraficaGra",
						"  and ord.cod_ordine_scuola = :codOrdineScuola",
						"  and anno.cod_anno_scolastico = :codAnnoScolastico")
				.bind("codAnagraficaGra", codAnagraficaGra)
				.bind("codOrdineScuola", tipoScuola.getCod())
				.bind("codAnnoScolastico", codAnnoScolastico);

		AnagraficaGraduatoriaRow result = ConvertUtils.getFirst(this.query(sh, AnagraficaGraduatoriaRow.class));

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public Long insertAnagraficaGraduatoria(AnagraficaGraduatoriaRow row) throws DaoException, ValidationException {
		final String methodName = "insertAnagraficaGraduatoria";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		checkForInsert(row);

		log.info(buildMessage(getClass(), methodName, "codAnagraficaGra: " + row.getCodAnagraficaGra()));
		log.info(buildMessage(getClass(), methodName, "dtInizioIscr: " + row.getDtInizioIscr()));
		log.info(buildMessage(getClass(), methodName, "dtInizioIscr: " + row.getDtScadenzaIscr()));
		log.info(buildMessage(getClass(), methodName, "dtFineIscr: " + row.getDtFineIscr()));
		log.info(buildMessage(getClass(), methodName, "dtScadenzaGrad: " + row.getDtScadenzaGrad()));
		log.info(buildMessage(getClass(), methodName, "dtScadenzaRicorsi: " + row.getDtScadenzaRicorsi()));
		log.info(buildMessage(getClass(), methodName, "codAnnoScolastico: " + row.getCodAnnoScolastico()));
		log.info(buildMessage(getClass(), methodName, "codOrdineScuola: " + row.getCodOrdineScuola()));

//		Long idAnagraficaGra = 100L; // nuovo id generato dalla sequence, il metodo restituisce questo valore.
		// DONE: da sostituire con:

		Long idAnagraficaGra = this.nextval(ID_ANAGRAFICA_GRA_SEQ);
		log.info(buildMessage(getClass(), methodName, "idAnagraficaGra: " + idAnagraficaGra));

		this.update(buildSqlHolder()
				.addQueryRows(
						// DONE: query inserimento anagrafica graduatoria
						"INSERT INTO iscritto_t_anagrafica_gra (id_anagrafica_gra, cod_anagrafica_gra, dt_inizio_iscr, dt_scadenza_iscr, dt_fine_iscr, dt_scadenza_grad, dt_scadenza_ricorsi, id_anno_scolastico, id_ordine_scuola) " +
								"VALUES (:idAnagraficaGra, :codAnagraficaGra, :dtInizioIscr, :dtScadenzaIscr, :dtFineIscr, :dtScadenzaGrad, :dtScadenzaRicorsi, " +
								"(SELECT id_anno_scolastico from iscritto_t_anno_sco where cod_anno_scolastico=:idAnnoScolastico), " +
								"(SELECT id_ordine_scuola from iscritto_d_ordine_scuola where cod_ordine_scuola=:idOrdineScuola)" +
								");")
				.bind("idAnagraficaGra", idAnagraficaGra)
				.bind("codAnagraficaGra", row.getCodAnagraficaGra())
				.bind("dtInizioIscr", row.getDtInizioIscr())
				.bind("dtScadenzaIscr", row.getDtScadenzaIscr())
				.bind("dtFineIscr", row.getDtFineIscr())
				.bind("dtScadenzaGrad", row.getDtScadenzaGrad())
				.bind("dtScadenzaRicorsi", row.getDtScadenzaRicorsi())
				.bind("idAnnoScolastico", row.getCodAnnoScolastico())
				.bind("idOrdineScuola", row.getCodOrdineScuola())
		);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return idAnagraficaGra;
	}

	@Override
	public Integer updateAnagraficaGraduatoria(AnagraficaGraduatoriaRow row) throws DaoException, ValidationException {
		final String methodName = "updateAnagraficaGraduatoria";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		checkForUpdate(row);

		log.info(buildMessage(getClass(), methodName, "idAnagraficaGra: " + row.getIdAnagraficaGra()));
		log.info(buildMessage(getClass(), methodName, "codAnagraficaGra: " + row.getCodAnagraficaGra()));
		log.info(buildMessage(getClass(), methodName, "dtInizioIscr: " + row.getDtInizioIscr()));
		log.info(buildMessage(getClass(), methodName, "dtInizioIscr: " + row.getDtScadenzaIscr()));
		log.info(buildMessage(getClass(), methodName, "dtFineIscr: " + row.getDtFineIscr()));
		log.info(buildMessage(getClass(), methodName, "dtScadenzaGrad: " + row.getDtScadenzaGrad()));
		log.info(buildMessage(getClass(), methodName, "dtScadenzaRicorsi: " + row.getDtScadenzaRicorsi()));
		log.info(buildMessage(getClass(), methodName, "codAnnoScolastico: " + row.getCodAnnoScolastico()));
		log.info(buildMessage(getClass(), methodName, "codOrdineScuola: " + row.getCodOrdineScuola()));

//		Integer result = 1; // numero di record modificati
		// DONE: da sostituire con:

		Integer result = this.update(buildSqlHolder()
				.addQueryRows(
						"update iscritto_t_anagrafica_gra " +
								"set cod_anagrafica_gra = :codAnagraficaGra, dt_inizio_iscr = :dtInizioIscr, dt_scadenza_iscr = :dtScadenzaIscr, dt_fine_iscr = :dtFineIscr, dt_scadenza_grad = :dtScadenzaGrad, " +
								"dt_scadenza_ricorsi = :dtScadenzaRicorsi " +
								"where id_anno_scolastico = (SELECT id_anno_scolastico from iscritto_t_anno_sco where cod_anno_scolastico=:idAnnoScolastico) and " +
								"id_ordine_scuola = (SELECT id_ordine_scuola from iscritto_d_ordine_scuola where cod_ordine_scuola=:idOrdineScuola)" +
								";"
				)
				.bind("codAnagraficaGra", row.getCodAnagraficaGra())
				.bind("dtInizioIscr", row.getDtInizioIscr())
				.bind("dtScadenzaIscr", row.getDtScadenzaIscr())
				.bind("dtFineIscr", row.getDtFineIscr())
				.bind("dtScadenzaGrad", row.getDtScadenzaGrad())
				.bind("dtScadenzaRicorsi", row.getDtScadenzaRicorsi())
				.bind("idAnnoScolastico", row.getCodAnnoScolastico())
				.bind("idOrdineScuola", row.getCodOrdineScuola())
		);
		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public List<AnagraficaStepGraduatoriaRow> findElencoAnagraficaStepGraduatoria(TipoScuola tipoScuola, String codAnagraficaGra, String codAnnoScolastico)
			throws DaoException, ValidationException {

		final String methodName = "findElencoAnagraficaStepGraduatoria";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		log.info(buildMessage(getClass(), methodName, "codOrdineScuola: " + tipoScuola));
		log.info(buildMessage(getClass(), methodName, "codAnagraficaGra: " + codAnagraficaGra));
		log.info(buildMessage(getClass(), methodName, "codAnnoScolastico: " + codAnnoScolastico));

		SqlHolder sh = buildSqlHolder()
				.addQueryRows(
						"select ",
						"  sg.step, ",
						"  sg.dt_step_gra, ",
						"  sg.id_step_gra, ",
						"  sg.dt_dom_inv_da, ",
						"  sg.dt_dom_inv_a, ",
						"  sg.dt_allegati,",
						"  ag.cod_anagrafica_gra,",
						"  ord.cod_ordine_scuola,",
						"  anno.cod_anno_scolastico",
						"from iscritto_t_step_gra sg",
						"  join iscritto_t_anagrafica_gra ag on ag.id_anagrafica_gra = sg.id_anagrafica_gra",
						"  join iscritto_d_ordine_scuola ord on ord.id_ordine_scuola = ag.id_ordine_scuola",
						"  join iscritto_t_anno_sco anno on anno.id_anno_scolastico = ag.id_anno_scolastico",
						"where 1 = 1",
						"  and ag.cod_anagrafica_gra = :codAnagraficaGra",
						"  and ord.cod_ordine_scuola = :codOrdineScuola",
						"  and anno.cod_anno_scolastico = :codAnnoScolastico")
				.bind("codAnagraficaGra", codAnagraficaGra)
				.bind("codOrdineScuola", tipoScuola.getCod())
				.bind("codAnnoScolastico", codAnnoScolastico);

		List<AnagraficaStepGraduatoriaRow> result = this.query(sh, AnagraficaStepGraduatoriaRow.class);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public Long insertAnagraficaStepGraduatoria(AnagraficaStepGraduatoriaRow row) throws DaoException, ValidationException {
		final String methodName = "insertAnagraficaStepGraduatoria";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		checkForInsert(row);

		log.info(buildMessage(getClass(), methodName, "step: " + row.getStep()));
		log.info(buildMessage(getClass(), methodName, "dtStepGra: " + row.getDtStepGra()));
		log.info(buildMessage(getClass(), methodName, "dtDomInvDa: " + row.getDtDomInvDa()));
		log.info(buildMessage(getClass(), methodName, "dtDomInvA: " + row.getDtDomInvA()));
		log.info(buildMessage(getClass(), methodName, "codAnagraficaGra: " + row.getCodAnagraficaGra()));
		log.info(buildMessage(getClass(), methodName, "codOrdineScuola: " + row.getCodOrdineScuola()));
		log.info(buildMessage(getClass(), methodName, "codAnnoScolastico: " + row.getCodAnnoScolastico()));

		Long idStepGra = this.nextval(ID_ANAGRAFICA_STEP_GRA_SQL);

		this.update(buildSqlHolder()
				.addQueryRows(
						"INSERT INTO iscritto_t_step_gra (step, dt_step_gra, id_step_gra, id_anagrafica_gra, dt_dom_inv_da, dt_dom_inv_a, dt_allegati) " +
								"VALUES (:step, :dateStepGra, :idStepGra, " +
								"(SELECT i.id_anagrafica_gra FROM iscritto_t_anagrafica_gra i " +
								"WHERE i.cod_anagrafica_gra = :codAnagraficaGra " +
								"AND i.id_anno_scolastico = (SELECT id_anno_scolastico from iscritto_t_anno_sco where cod_anno_scolastico=:codAnnoScolastico) " +
								"AND i.id_ordine_scuola = (SELECT id_ordine_scuola from iscritto_d_ordine_scuola where cod_ordine_scuola=:codOrdineScuola)), " +
								" :dateDomInvDa, :dateDomInvA, :dateAllegati);")
				.bind("step", row.getStep()) //
				.bind("dateStepGra", row.getDtStepGra())
				.bind("idStepGra", idStepGra)
				.bind("codAnagraficaGra", row.getCodAnagraficaGra())
				.bind("codAnnoScolastico", row.getCodAnnoScolastico())
				.bind("codOrdineScuola", row.getCodOrdineScuola())
				.bind("dateDomInvDa", row.getDtDomInvDa())
				.bind("dateDomInvA", row.getDtDomInvA())
				.bind("dateAllegati", row.getDtAllegati())
		);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return idStepGra;
	}

	@Override
	public Integer updateAnagraficaStepGraduatoria(AnagraficaStepGraduatoriaRow row) throws DaoException, ValidationException {
		final String methodName = "updateAnagraficaStepGraduatoria";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));


		if(row.getIdStepGra() == null) {
			throw ErrorCodeEnum.VAL_GRA_008.buildException();
		}

		if (checkIdStepGraduatoriaPresente(row.getIdStepGra())) {
			throw ErrorCodeEnum.VAL_GRA_010.buildException();
		}

		checkForUpdate(row);

		log.info(buildMessage(getClass(), methodName, "idStepGra: " + row.getIdStepGra()));
		log.info(buildMessage(getClass(), methodName, "step: " + row.getStep()));
		log.info(buildMessage(getClass(), methodName, "dtStepGra: " + row.getDtStepGra()));
		log.info(buildMessage(getClass(), methodName, "dtDomInvDa: " + row.getDtDomInvDa()));
		log.info(buildMessage(getClass(), methodName, "dtDomInvA: " + row.getDtDomInvA()));
		log.info(buildMessage(getClass(), methodName, "codAnagraficaGra: " + row.getCodAnagraficaGra()));
		log.info(buildMessage(getClass(), methodName, "codOrdineScuola: " + row.getCodOrdineScuola()));
		log.info(buildMessage(getClass(), methodName, "codAnnoScolastico: " + row.getCodAnnoScolastico()));

//		Integer result = 1; // numero di record modificati

		Integer result = this.update(buildSqlHolder()
				.addQueryRows(
						"UPDATE iscritto_t_step_gra " +
								"SET step = :step, dt_step_gra = :dateStepGra,  dt_dom_inv_da = :dateDomInvDa, dt_dom_inv_a = :dateDomInvA, dt_allegati = :dateAllegati, " +
								"id_anagrafica_gra = (SELECT i.id_anagrafica_gra FROM iscritto_t_anagrafica_gra i " +
								"WHERE i.cod_anagrafica_gra = :codAnagraficaGra " +
								"AND i.id_anno_scolastico = (SELECT id_anno_scolastico from iscritto_t_anno_sco where cod_anno_scolastico=:codAnnoScolastico) " +
								"AND i.id_ordine_scuola = (SELECT id_ordine_scuola from iscritto_d_ordine_scuola where cod_ordine_scuola=:codOrdineScuola)) " +
								"WHERE id_step_gra = :idStepGra; "
				)
				.bind("idStepGra", row.getIdStepGra())
				.bind("step", row.getStep()) //
				.bind("dateStepGra", row.getDtStepGra())
				.bind("codAnagraficaGra", row.getCodAnagraficaGra())
				.bind("codAnnoScolastico", row.getCodAnnoScolastico())
				.bind("codOrdineScuola", row.getCodOrdineScuola())
				.bind("dateDomInvDa", row.getDtDomInvDa())
				.bind("dateDomInvA", row.getDtDomInvA())
				.bind("dateAllegati", row.getDtAllegati())
		);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public Integer deleteAnagraficaStepGraduatoria(Long idStepGra) throws DaoException, ValidationException {
		final String methodName = "deleteAnagraficaStepGraduatoria";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		if(idStepGra == null) {
			throw ErrorCodeEnum.VAL_GRA_008.buildException();
		}

		if (checkIdStepGraduatoriaPresente(idStepGra)) {
			throw ErrorCodeEnum.VAL_GRA_010.buildException();
		}

		Integer result = this.update(buildSqlHolder()
				.addQueryRows(
						"DELETE FROM iscritto_t_step_gra WHERE id_step_gra = :idStepGra"
				)
				.bind("idStepGra", idStepGra)
		);
		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public List<AnagraficaEtaRow> findAnagraficaEta(TipoScuola tipoScuola, String codAnagraficaGra, String codAnnoScolastico) throws DaoException {
		final String methodName = "findAnagraficaEta";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		log.info(buildMessage(getClass(), methodName, "codOrdineScuola: " + tipoScuola));
		log.info(buildMessage(getClass(), methodName, "codAnagraficaGra: " + codAnagraficaGra));
		log.info(buildMessage(getClass(), methodName, "codAnnoScolastico: " + codAnnoScolastico));

		SqlHolder sh = buildSqlHolder()
				.addQueryRows(
						"select",
						"  eta.id_eta,",
						"  eta.data_da,",
						"  eta.data_a,",
						"  ag.cod_anagrafica_gra,",
						"  ord.cod_ordine_scuola,",
						"  anno.cod_anno_scolastico,",
						"  fe.cod_fascia_eta",
						"from iscritto_t_eta eta",
						"  join iscritto_t_anagrafica_gra ag on ag.id_anagrafica_gra = eta.id_anagrafica_gra",
						"  join iscritto_d_fascia_eta fe on fe.id_fascia_eta = eta.id_fascia_eta",
						"  join iscritto_t_anno_sco anno on anno.id_anno_scolastico = ag.id_anno_scolastico",
						"  join iscritto_d_ordine_scuola ord on ord.id_ordine_scuola = ag.id_ordine_scuola",
						"where 1 = 1",
						"  and ag.cod_anagrafica_gra = :codAnagraficaGra",
						"  and ord.cod_ordine_scuola = :codOrdineScuola",
						"  and anno.cod_anno_scolastico = :codAnnoScolastico")
				.bind("codAnagraficaGra", codAnagraficaGra)
				.bind("codOrdineScuola", tipoScuola.getCod())
				.bind("codAnnoScolastico", codAnnoScolastico);

		List<AnagraficaEtaRow> result = this.query(sh, AnagraficaEtaRow.class);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public List<TipoFasciaEtaRow> findTipiFasceEta() throws DaoException {
		final String methodName = "findTipiFasceEta";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		SqlHolder sh = buildSqlHolder()
				.addQueryRows(
						"select",
						"  dfe.cod_fascia_eta,",
						"  dfe.descrizione as desc_fascia_eta,",
						"  ord.cod_ordine_scuola",
						"from iscritto_d_fascia_eta dfe",
						"  join iscritto_d_ordine_scuola ord on ord.id_ordine_scuola = dfe.id_ordine_scuola");

		List<TipoFasciaEtaRow> result = this.query(sh, TipoFasciaEtaRow.class);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public Long insertAnagraficaEta(AnagraficaEtaRow row) throws DaoException, ValidationException {
		final String methodName = "insertAnagraficaEta";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		checkForInsert(row);

		log.info(buildMessage(getClass(), methodName, "codOrdineScuola: " + row.getCodOrdineScuola()));
		log.info(buildMessage(getClass(), methodName, "codAnagraficaGra: " + row.getCodAnagraficaGra()));
		log.info(buildMessage(getClass(), methodName, "codAnnoScolastico: " + row.getCodAnnoScolastico()));
		log.info(buildMessage(getClass(), methodName, "dataDa: " + row.getDataDa()));
		log.info(buildMessage(getClass(), methodName, "dataA: " + row.getDataA()));
		log.info(buildMessage(getClass(), methodName, "codFasciaEta: " + row.getCodFasciaEta()));

//		Long idAnagraficaGra = 100L; // nuovo id generato dalla sequence, il metodo restituisce questo valore.
		// TODO: generazione sequence (nuova da definire su DB), insert

		Long idAnagraficaGra = this.nextval(ID_ANAGRAFICA_ETA_GRA_SEQ);

		this.update(buildSqlHolder()
				.addQueryRows(
						"INSERT INTO iscritto_t_eta (id_eta, data_da, data_a, id_anagrafica_gra, id_fascia_eta) " +
								"VALUES (:idEta, :dataDa, :dataA, ( " +
								"    SELECT id_anagrafica_gra FROM iscritto_t_anagrafica_gra  aGra WHERE aGra.id_ordine_scuola = ( " +
								"            (SELECT id_ordine_scuola from iscritto_d_ordine_scuola where cod_ordine_scuola = :codOrdineScuola) " +
								"        ) AND aGra.id_anno_scolastico = ( " +
								"            (SELECT id_anno_scolastico from iscritto_t_anno_sco where cod_anno_scolastico = :codAnnoScolastico) " +
								"        ) AND aGra.cod_anagrafica_gra = :codAnagraficaGra " +
								"    ), ( " +
								"        SELECT id_fascia_eta FROM iscritto_d_fascia_eta t WHERE cod_fascia_eta = :codFasciaEta " +
								"    ));")
				.bind("idEta", idAnagraficaGra)
				.bind("dataDa", row.getDataDa())
				.bind("dataA", row.getDataA())
				.bind("codOrdineScuola", row.getCodOrdineScuola())
				.bind("codAnnoScolastico", row.getCodAnnoScolastico())
				.bind("codAnagraficaGra", row.getCodAnagraficaGra())
				.bind("codFasciaEta", row.getCodFasciaEta())
		);


		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return idAnagraficaGra;
	}

	@Override
	public Integer updateAnagraficaEta(AnagraficaEtaRow row) throws DaoException, ValidationException {
		final String methodName = "updateAnagraficaEta";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		checkForUpdate(row);

		log.info(buildMessage(getClass(), methodName, "idEta: " + row.getIdEta()));
		log.info(buildMessage(getClass(), methodName, "codOrdineScuola: " + row.getCodOrdineScuola()));
		log.info(buildMessage(getClass(), methodName, "codAnagraficaGra: " + row.getCodOrdineScuola()));
		log.info(buildMessage(getClass(), methodName, "codAnnoScolastico: " + row.getCodAnnoScolastico()));
		log.info(buildMessage(getClass(), methodName, "dataDa: " + row.getDataDa()));
		log.info(buildMessage(getClass(), methodName, "dataA: " + row.getDataA()));
		log.info(buildMessage(getClass(), methodName, "codFasciaEta: " + row.getCodFasciaEta()));

		Integer result = this.update(buildSqlHolder()
				.addQueryRows(
						"UPDATE iscritto_t_eta " +
								"SET data_da = :dataDa,  data_a = :dataA, "
								+ "id_anagrafica_gra = (SELECT i.id_anagrafica_gra FROM iscritto_t_anagrafica_gra i " +
								"WHERE i.cod_anagrafica_gra = :codAnagraficaGra " +
								"AND i.id_anno_scolastico = (SELECT id_anno_scolastico from iscritto_t_anno_sco where cod_anno_scolastico=:codAnnoScolastico) " +
								"AND i.id_ordine_scuola = (SELECT id_ordine_scuola from iscritto_d_ordine_scuola where cod_ordine_scuola=:codOrdineScuola)), " +
								"id_fascia_eta = ( " +
								"        SELECT id_fascia_eta FROM iscritto_d_fascia_eta t WHERE cod_fascia_eta = :codFasciaEta )" +
								"WHERE id_eta = :idEta; "
				)
				.bind("idEta", row.getIdEta())
				.bind("dataDa", row.getDataDa())
				.bind("dataA", row.getDataA())
				.bind("codOrdineScuola", row.getCodOrdineScuola())
				.bind("codAnnoScolastico", row.getCodAnnoScolastico())
				.bind("codAnagraficaGra", row.getCodAnagraficaGra())
				.bind("codFasciaEta", row.getCodFasciaEta())
		);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public Integer deleteAnagraficaEta(Long idEta) throws DaoException, ValidationException {
		final String methodName = "deleteAnagraficaEta";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		if (idEta == null) {
			throw ErrorCodeEnum.VAL_DEL_001.buildException();
		}

//		Integer result = 1; // numero di record modificati
		// TODO: delete

		Integer result = this.update(buildSqlHolder()
				.addQueryRows(
						"DELETE FROM iscritto_t_eta WHERE id_eta = :idEta"
				)
				.bind("idEta", idEta)
		);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	//////////////////////////////////////////////////////////////////////

	private static void checkForInsert(AnagraficaGraduatoriaRow row) throws ValidationException {
		boolean isValid = row != null;

		// campi obbligatori
		isValid &= StringUtils.isNotBlank(row.getCodOrdineScuola());
		isValid &= StringUtils.isNotBlank(row.getCodAnagraficaGra());
		isValid &= StringUtils.isNotBlank(row.getCodAnnoScolastico());
		isValid &= row.getDtInizioIscr() != null;
		isValid &= row.getDtScadenzaIscr() != null;
		isValid &= row.getDtFineIscr() != null;
		isValid &= row.getDtScadenzaGrad() != null;
		isValid &= row.getDtScadenzaRicorsi() != null;
		isValid &= row.getDtScadenzaRicorsi() != null;

		if (!isValid) {
			throw ErrorCodeEnum.VAL_INS_001.buildException();
		}
	}

	private static void checkForInsert(AnagraficaStepGraduatoriaRow row) throws ValidationException {
		boolean isValid = row != null;

		// campi obbligatori
		isValid &= StringUtils.isNotBlank(row.getCodOrdineScuola());
		isValid &= StringUtils.isNotBlank(row.getCodAnagraficaGra());
		isValid &= StringUtils.isNotBlank(row.getCodAnnoScolastico());
		isValid &= row.getStep() != null;
		isValid &= row.getDtStepGra() != null;
		isValid &= row.getDtDomInvDa() != null;
		isValid &= row.getDtDomInvA() != null;

		if (!isValid) {
			throw ErrorCodeEnum.VAL_INS_001.buildException();
		}
	}

	private static void checkForInsert(AnagraficaEtaRow row) throws ValidationException {
		boolean isValid = row != null;

		// campi obbligatori
		isValid &= StringUtils.isNotBlank(row.getCodOrdineScuola());
		isValid &= StringUtils.isNotBlank(row.getCodAnagraficaGra());
		isValid &= StringUtils.isNotBlank(row.getCodAnnoScolastico());
		isValid &= row.getDataDa() != null;
		isValid &= row.getDataA() != null;

		if (!isValid) {
			throw ErrorCodeEnum.VAL_INS_001.buildException();
		}
	}

	private static void checkForUpdate(AnagraficaGraduatoriaRow row) throws ValidationException {
		boolean isValid = row != null;

		// campi chiave
//		isValid &= row.getIdAnagraficaGra() != null;

		// campi obbligatori
		isValid &= StringUtils.isNotBlank(row.getCodOrdineScuola());
		isValid &= StringUtils.isNotBlank(row.getCodAnagraficaGra());
		isValid &= StringUtils.isNotBlank(row.getCodAnnoScolastico());
		isValid &= row.getDtInizioIscr() != null;
		isValid &= row.getDtScadenzaIscr() != null;
		isValid &= row.getDtFineIscr() != null;
		isValid &= row.getDtScadenzaGrad() != null;
		isValid &= row.getDtScadenzaRicorsi() != null;
		isValid &= row.getDtScadenzaRicorsi() != null;

		if (!isValid) {
			throw ErrorCodeEnum.VAL_UPD_001.buildException();
		}
	}

	private boolean checkIdStepGraduatoriaPresente(Long idStepGra) throws DaoException {

		final String methodName = "checkIdStepGraduatoriaPresente";

		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		SqlHolder sh = buildSqlHolder()
				.addQueryRows(
						"select id_graduatoria from iscritto_t_graduatoria gra " +
								"join iscritto_t_step_gra_con con on gra.id_step_gra_con = con.id_step_gra_con " +
								"where con.id_step_gra = :idStepGra ; "
						)
				.bind("idStepGra", idStepGra)
				;

		List<IscrittoTGraduatoria> resultList = this.query(sh, IscrittoTGraduatoria.class);


		if(resultList.size() > 0) {
			//errore esiste in iscritto_t_graduatoria
			log.debug(buildMessage(getClass(), methodName, LOG_END));
			return true;
		} else {
			log.debug(buildMessage(getClass(), methodName, LOG_END));
			return false;
		}
	}

	private static void checkForUpdate(AnagraficaStepGraduatoriaRow row) throws ValidationException {
		boolean isValid = row != null;

		// campi chiave
		isValid &= row.getIdStepGra() != null;

		// campi obbligatori
		isValid &= StringUtils.isNotBlank(row.getCodOrdineScuola());
		isValid &= StringUtils.isNotBlank(row.getCodAnagraficaGra());
		isValid &= StringUtils.isNotBlank(row.getCodAnnoScolastico());
		isValid &= row.getStep() != null;
		isValid &= row.getDtStepGra() != null;
		isValid &= row.getDtDomInvDa() != null;
		isValid &= row.getDtDomInvA() != null;

		if (!isValid) {
			throw ErrorCodeEnum.VAL_UPD_001.buildException();
		}
	}

	private static void checkForUpdate(AnagraficaEtaRow row) throws ValidationException {
		boolean isValid = row != null;

		// campi chiave
		isValid &= row.getIdEta() != null;

		// campi obbligatori
		isValid &= StringUtils.isNotBlank(row.getCodOrdineScuola());
		isValid &= StringUtils.isNotBlank(row.getCodAnagraficaGra());
		isValid &= StringUtils.isNotBlank(row.getCodAnnoScolastico());
		isValid &= row.getDataDa() != null;
		isValid &= row.getDataA() != null;

		if (!isValid) {
			throw ErrorCodeEnum.VAL_UPD_001.buildException();
		}
	}

}
