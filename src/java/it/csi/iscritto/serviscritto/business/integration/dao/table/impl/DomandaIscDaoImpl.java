package it.csi.iscritto.serviscritto.business.integration.dao.table.impl;

import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.LOG_BEGIN;
import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.LOG_END;
import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.buildMessage;
import static it.csi.iscritto.serviscritto.business.util.converter.ConvertUtils.getFirst;

import org.apache.commons.lang3.Validate;
import org.apache.log4j.Logger;

import it.csi.iscritto.serviscritto.business.integration.dao.AbstractDao;
import it.csi.iscritto.serviscritto.business.integration.dao.table.DomandaIscDao;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTDomandaIsc;
import it.csi.iscritto.serviscritto.business.integration.exception.DaoException;
import it.csi.iscritto.serviscritto.business.util.Constants;
import it.csi.iscritto.serviscritto.business.util.sql.SqlHolder;

public class DomandaIscDaoImpl extends AbstractDao implements DomandaIscDao {
	private static final Logger log = Logger.getLogger(Constants.COMPONENT_NAME + ".dao");

	@Override
	public IscrittoTDomandaIsc findIscrittoTDomandaIscByKey(Long idDomandaIscrizione) throws DaoException {
		final String methodName = "findIscrittoTDomandaIscByKey";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));
		log.info(buildMessage(getClass(), methodName, "idDomandaIscrizione: " + idDomandaIscrizione));

		SqlHolder sh = buildSqlHolder().addQueryRows(
				"select ",
				"  id_domanda_iscrizione, ",
				"  data_consegna, ",
				"  id_coabitazione, ",
				"  protocollo, ",
				"  fdecifra_t(fl_servizi_sociali::bytea, :encryptionKey) as fl_servizi_sociali, ",
				"  note, ",
				"  fl_residenza_forzata, ",
				"  fl_contestazione, ",
				"  fl_trasferimento, ",
				"  id_anno_scolastico, ",
				"  id_ordine_scuola, ",
				"  fl_isee, ",
				"  fl_fratello_freq, ",
				"  dt_modifica, ",
				"  dt_cancellazione, ",
				"  email, ",
				"  fl_istruita, ",
				"  telefono, ",
				"  fl_responsabilita_gen, ",
				"  recapito_no_res, ",
				"  fl_info_autocertificazione, ",
				"  id_stato_dom, ",
				"  fl_info_gdpr, ",
				"  fl_minore_pre_nuc, ",
				"  fl_res_con_ric, ",
				"  id_utente_ins, ",
				"  fl_genitore_due_pre_nuc, ",
				"  fl_altri_componenti, ",
				"  id_utente_mod, ",
				"  fl_affido, ",
				"  fl_nao, ",
				"  fl_soggetto_tre, ",
				"  fl_consenso_td_conv, ",
				"  fl_cinque_anni, ",
				"  fl_lista_attesa, ",
				"  fl_fratello_contiguo, ",
				"  fl_irc ",
				"from iscritto_t_domanda_isc ")
				.bind("encryptionKey", this.getEncryptionKey())
				.addQueryRows(
						"WHERE 1 = 1",
						"  AND id_domanda_iscrizione = :idDomandaIscrizione")
				.bind("idDomandaIscrizione", idDomandaIscrizione);

		IscrittoTDomandaIsc result = getFirst(this.query(sh, IscrittoTDomandaIsc.class));
		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	//////////////////////////////////////////////////////////////////////

	@Override
	public Long insertIscrittoTDomandaIsc(IscrittoTDomandaIsc row) throws DaoException {
		final String methodName = "insertIscrittoTDomandaIsc";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		Validate.notNull(row);

		final Long idDomandaIscrizione = this.nextval("iscritto_t_domanda_isc_id_domanda_iscrizione");

		log.info(buildMessage(getClass(), methodName, "idDomandaIscrizione: " + idDomandaIscrizione));

		final SqlHolder sh = buildSqlHolder()
				.addQueryRows(
						"insert into iscritto_t_domanda_isc (",
						"  id_domanda_iscrizione, ",
						"  data_consegna, ",
						"  id_coabitazione, ",
						"  protocollo, ",
						"  fl_servizi_sociali, ",
						"  note, ",
						"  fl_residenza_forzata, ",
						"  fl_contestazione, ",
						"  fl_trasferimento, ",
						"  id_anno_scolastico, ",
						"  id_ordine_scuola, ",
						"  fl_isee, ",
						"  fl_fratello_freq, ",
						"  dt_modifica, ",
						"  dt_cancellazione, ",
						"  email, ",
						"  fl_istruita, ",
						"  telefono, ",
						"  fl_responsabilita_gen, ",
						"  recapito_no_res, ",
						"  fl_info_autocertificazione, ",
						"  id_stato_dom, ",
						"  fl_info_gdpr, ",
						"  fl_minore_pre_nuc, ",
						"  fl_res_con_ric, ",
						"  id_utente_ins, ",
						"  fl_genitore_due_pre_nuc, ",
						"  fl_altri_componenti, ",
						"  id_utente_mod, ",
						"  fl_affido, ",
						"  fl_nao, ",
						"  fl_soggetto_tre, ",
						"  fl_consenso_td_conv, ",
						"  fl_cinque_anni, ",
						"  fl_lista_attesa, ",
						"  fl_fratello_contiguo, ",
						"  fl_irc ",
						") ",
						"values (",
						"  :idDomandaIscrizione, ",
						"  :dataConsegna, ",
						"  :idCoabitazione, ",
						"  :protocollo, ",
						"  fcifra_t(:flServiziSociali, :encryptionKey),",
						"  :note, ",
						"  :flResidenzaForzata, ",
						"  :flContestazione, ",
						"  :flTrasferimento, ",
						"  :idAnnoScolastico, ",
						"  :idOrdineScuola, ",
						"  :flIsee, ",
						"  :flFratelloFreq, ",
						"  :dtModifica, ",
						"  :dtCancellazione, ",
						"  :email, ",
						"  :flIstruita, ",
						"  :telefono, ",
						"  :flResponsabilitaGen, ",
						"  :recapitoNoRes, ",
						"  :flInfoAutocertificazione, ",
						"  :idStatoDom, ",
						"  :flInfoGdpr, ",
						"  :flMinorePreNuc, ",
						"  :flResConRic, ",
						"  :idUtenteIns, ",
						"  :flGenitoreDuePreNuc, ",
						"  :flAltriComponenti, ",
						"  :idUtenteMod, ",
						"  :flAffido, ",
						"  :flNao, ",
						"  :flSoggettoTre, ",
						"  :flConsensoTdConv, ",
						"  :flCinqueAnni, ",
						"  :flListaAttesa, ",
						"  :flFratelloContiguo, ",
						"  :flIrc ",
						")")
				.bind("encryptionKey", this.getEncryptionKey())
				.bind("idDomandaIscrizione", idDomandaIscrizione)
				.bind("dataConsegna", row.getDataConsegna())
				.bind("idCoabitazione", row.getIdCoabitazione())
				.bind("protocollo", row.getProtocollo())
				.bind("flServiziSociali", row.getFlServiziSociali())
				.bind("note", row.getNote())
				.bind("flResidenzaForzata", row.getFlResidenzaForzata())
				.bind("flContestazione", row.getFlContestazione())
				.bind("flTrasferimento", row.getFlTrasferimento())
				.bind("idAnnoScolastico", row.getIdAnnoScolastico())
				.bind("idOrdineScuola", row.getIdOrdineScuola())
				.bind("flIsee", row.getFlIsee())
				.bind("flFratelloFreq", row.getFlFratelloFreq())
				.bind("dtModifica", row.getDtModifica())
				.bind("dtCancellazione", row.getDtCancellazione())
				.bind("email", row.getEmail())
				.bind("flIstruita", row.getFlIstruita())
				.bind("telefono", row.getTelefono())
				.bind("flResponsabilitaGen", row.getFlResponsabilitaGen())
				.bind("recapitoNoRes", row.getRecapitoNoRes())
				.bind("flInfoAutocertificazione", row.getFlInfoAutocertificazione())
				.bind("idStatoDom", row.getIdStatoDom())
				.bind("flInfoGdpr", row.getFlInfoGdpr())
				.bind("flMinorePreNuc", row.getFlMinorePreNuc())
				.bind("flResConRic", row.getFlResConRic())
				.bind("idUtenteIns", row.getIdUtenteIns())
				.bind("flGenitoreDuePreNuc", row.getFlGenitoreDuePreNuc())
				.bind("flAltriComponenti", row.getFlAltriComponenti())
				.bind("idUtenteMod", row.getIdUtenteMod())
				.bind("flNao", row.getFlNao())
				.bind("flAffido", row.getFlAffido())
				.bind("flSoggettoTre", row.getFlSoggettoTre())
				.bind("flConsensoTdConv", row.getFlConsensoTdConv())
				.bind("flCinqueAnni", row.getFlCinqueAnni())
				.bind("flListaAttesa", row.getFlListaAttesa())
				.bind("flFratelloContiguo", row.getFlFratelloContiguo())
				.bind("flIrc", row.getFlIrc());

		this.update(sh);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return idDomandaIscrizione;
	}

	@Override
	public Integer updateDomandaForInvio(Long idDomandaIscrizione, String protocollo) throws DaoException {
		final String methodName = "updateDomandaForInvio";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		Validate.notNull(idDomandaIscrizione);
		Validate.notBlank(protocollo);

		log.info(buildMessage(getClass(), methodName, "idDomandaIscrizione: " + idDomandaIscrizione));
		log.info(buildMessage(getClass(), methodName, "protocollo: " + protocollo));

		final SqlHolder sh = buildSqlHolder()
				.addQueryRows(
						"UPDATE iscritto_t_domanda_isc SET",
						"  protocollo = :protocollo,",
						"  id_stato_dom = (select sd.id_stato_dom from iscritto_d_stato_dom sd where sd.cod_stato_dom = 'INV'),",
						"  data_consegna = now(),",
						"  dt_modifica = now()",
						"WHERE id_domanda_iscrizione = :idDomandaIscrizione")
				.bind("idDomandaIscrizione", idDomandaIscrizione)
				.bind("protocollo", protocollo);

		Integer result = this.update(sh);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public Integer invalidaDomanda(Long idDomandaIscrizione, Long idOperatore) throws DaoException {
		final String methodName = "invalidaDomanda";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		Validate.notNull(idDomandaIscrizione);

		log.info(buildMessage(getClass(), methodName, "idDomandaIscrizione: " + idDomandaIscrizione));
		log.info(buildMessage(getClass(), methodName, "idOperatore: " + idOperatore));

		final SqlHolder sh = buildSqlHolder()
				.addQueryRows(
						"UPDATE iscritto_t_domanda_isc SET",
						"  id_stato_dom = (select sd.id_stato_dom from iscritto_d_stato_dom sd where sd.cod_stato_dom = 'ANN'),",
						"  id_utente_mod = :idOperatore,",
						"  dt_modifica = now()",
						"WHERE id_domanda_iscrizione = :idDomandaIscrizione")
				.bind("idDomandaIscrizione", idDomandaIscrizione)
				.bind("idOperatore", idOperatore);

		Integer result = this.update(sh);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public Integer annullaDomanda(Long idDomandaIscrizione, Long idOperatore) throws DaoException {
		final String methodName = "invalidaDomanda";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		Validate.notNull(idDomandaIscrizione);

		log.info(buildMessage(getClass(), methodName, "idDomandaIscrizione: " + idDomandaIscrizione));
		log.info(buildMessage(getClass(), methodName, "idOperatore: " + idOperatore));

		final SqlHolder sh = buildSqlHolder()
				.addQueryRows(
						"UPDATE iscritto_t_domanda_isc SET",
						"  id_stato_dom = (select sd.id_stato_dom from iscritto_d_stato_dom sd where sd.cod_stato_dom = 'CAN'),",
						"  id_utente_mod = :idOperatore,",
						"  dt_modifica = now(),",
						"  dt_cancellazione = now()",
						"WHERE id_domanda_iscrizione = :idDomandaIscrizione")
				.bind("idDomandaIscrizione", idDomandaIscrizione)
				.bind("idOperatore", idOperatore);

		Integer result = this.update(sh);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public Integer updateUltimaModifica(Long idDomandaIscrizione, Long idOperatore) throws DaoException {
		final String methodName = "updateUltimaModifica";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		Validate.notNull(idDomandaIscrizione);

		log.info(buildMessage(getClass(), methodName, "idDomandaIscrizione: " + idDomandaIscrizione));
		log.info(buildMessage(getClass(), methodName, "idOperatore: " + idOperatore));

		final SqlHolder sh = buildSqlHolder()
				.addQueryRows(
						"UPDATE iscritto_t_domanda_isc SET",
						"  id_utente_mod = :idOperatore,",
						"  dt_modifica = now()",
						"WHERE id_domanda_iscrizione = :idDomandaIscrizione")
				.bind("idDomandaIscrizione", idDomandaIscrizione)
				.bind("idOperatore", idOperatore);

		Integer result = this.update(sh);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public Integer deleteIscrittoTDomandaIsc(Long idDomandaIscrizione) throws DaoException {
		final String methodName = "deleteIscrittoTDomandaIsc";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		Validate.notNull(idDomandaIscrizione);

		log.info(buildMessage(getClass(), methodName, "idDomandaIscrizione: " + idDomandaIscrizione));

		final SqlHolder sh = buildSqlHolder()
				.addQueryRows(
						"delete from iscritto_t_domanda_isc ",
						"where id_domanda_iscrizione = :idDomandaIscrizione")
				.bind("idDomandaIscrizione", idDomandaIscrizione);

		Integer result = this.update(sh);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

}
