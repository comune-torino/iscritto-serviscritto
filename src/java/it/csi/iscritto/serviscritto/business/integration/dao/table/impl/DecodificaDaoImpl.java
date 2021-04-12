package it.csi.iscritto.serviscritto.business.integration.dao.table.impl;

import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.LOG_BEGIN;
import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.LOG_END;
import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.buildMessage;
import static it.csi.iscritto.serviscritto.business.util.converter.ConvertUtils.getFirst;

import java.util.List;

import org.apache.log4j.Logger;

import it.csi.iscritto.serviscritto.business.integration.dao.AbstractDao;
import it.csi.iscritto.serviscritto.business.integration.dao.table.DecodificaDao;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoDCategoriaScu;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoDCircoscrizione;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoDCoabitazione;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoDGenitoreSol;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoDOrdineScuola;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoDRelazionePar;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoDStatoDom;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoDStatoGra;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoDStatoScu;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoDTipConOcc;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoDTipoAll;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoDTipoCambioRes;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoDTipoCorso;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoDTipoFra;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoDTipoFre;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoDTipoPre;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoDTipoSog;
import it.csi.iscritto.serviscritto.business.integration.exception.DaoException;
import it.csi.iscritto.serviscritto.business.util.Constants;
import it.csi.iscritto.serviscritto.business.util.sql.SqlHolder;

public class DecodificaDaoImpl extends AbstractDao implements DecodificaDao {
	private static final Logger log = Logger.getLogger(Constants.COMPONENT_NAME + ".dao");

	@Override
	public IscrittoDStatoDom findIscrittoDStatoDomByKey(Long idStatoDom) throws DaoException {
		final String methodName = "findIscrittoDStatoDomByKey";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		SqlHolder sh = buildSqlHolder(IscrittoDStatoDom.SQL_SELECT_ALL)
				.addQueryRows(
						"WHERE 1 = 1",
						"  AND id_stato_dom = :idStatoDom")
				.bind("idStatoDom", idStatoDom);

		IscrittoDStatoDom result = getFirst(this.query(sh, IscrittoDStatoDom.class));

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public IscrittoDStatoDom findIscrittoDStatoDomByCod(String codStatoDom) throws DaoException {
		final String methodName = "findIscrittoDStatoDomByCod";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		SqlHolder sh = buildSqlHolder(IscrittoDStatoDom.SQL_SELECT_ALL)
				.addQueryRows(
						"WHERE 1 = 1",
						"  AND cod_stato_dom = :codStatoDom")
				.bind("codStatoDom", codStatoDom);

		IscrittoDStatoDom result = getFirst(this.query(sh, IscrittoDStatoDom.class));

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public IscrittoDCoabitazione findIscrittoDCoabitazioneByKey(Long idCoabitazione) throws DaoException {
		final String methodName = "findIscrittoDCoabitazioneByKey";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		SqlHolder sh = buildSqlHolder(IscrittoDCoabitazione.SQL_SELECT_ALL)
				.addQueryRows(
						"WHERE 1 = 1",
						"  AND id_coabitazione = :idCoabitazione")
				.bind("idCoabitazione", idCoabitazione);

		IscrittoDCoabitazione result = getFirst(this.query(sh, IscrittoDCoabitazione.class));

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public IscrittoDCoabitazione findIscrittoDCoabitazioneByCod(String codCoabitazione) throws DaoException {
		final String methodName = "findIscrittoDCoabitazioneByCod";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		SqlHolder sh = buildSqlHolder(IscrittoDCoabitazione.SQL_SELECT_ALL)
				.addQueryRows(
						"WHERE 1 = 1",
						"  AND cod_coabitazione = :codCoabitazione")
				.bind("codCoabitazione", codCoabitazione);

		IscrittoDCoabitazione result = getFirst(this.query(sh, IscrittoDCoabitazione.class));

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public IscrittoDRelazionePar findIscrittoDRelazioneParByKey(Long idRelParentela) throws DaoException {
		final String methodName = "findIscrittoDRelazioneParByKey";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		SqlHolder sh = buildSqlHolder(IscrittoDRelazionePar.SQL_SELECT_ALL)
				.addQueryRows(
						"WHERE 1 = 1",
						"  AND id_rel_parentela = :idRelParentela")
				.bind("idRelParentela", idRelParentela);

		IscrittoDRelazionePar result = getFirst(this.query(sh, IscrittoDRelazionePar.class));

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public IscrittoDRelazionePar findIscrittoDRelazioneParByCod(String codParentela) throws DaoException {
		final String methodName = "findIscrittoDRelazioneParByCod";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		SqlHolder sh = buildSqlHolder(IscrittoDRelazionePar.SQL_SELECT_ALL)
				.addQueryRows(
						"WHERE 1 = 1",
						"  AND cod_parentela = :codParentela")
				.bind("codParentela", codParentela);

		IscrittoDRelazionePar result = getFirst(this.query(sh, IscrittoDRelazionePar.class));

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public IscrittoDTipConOcc findIscrittoDTipConOccByKey(Long idTipCondOccupazionale) throws DaoException {
		final String methodName = "findIscrittoDTipConOccByKey";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		SqlHolder sh = buildSqlHolder(IscrittoDTipConOcc.SQL_SELECT_ALL)
				.addQueryRows(
						"WHERE 1 = 1",
						"  AND id_tip_cond_occupazionale = :idTipCondOccupazionale")
				.bind("idTipCondOccupazionale", idTipCondOccupazionale);

		IscrittoDTipConOcc result = getFirst(this.query(sh, IscrittoDTipConOcc.class));

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public IscrittoDTipConOcc findIscrittoDTipConOccByCod(String codTipCondOccupazionale) throws DaoException {
		final String methodName = "findIscrittoDTipConOccByCod";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		SqlHolder sh = buildSqlHolder(IscrittoDTipConOcc.SQL_SELECT_ALL)
				.addQueryRows(
						"WHERE 1 = 1",
						"  AND cod_tip_cond_occupazionale = :codTipCondOccupazionale")
				.bind("codTipCondOccupazionale", codTipCondOccupazionale);

		IscrittoDTipConOcc result = getFirst(this.query(sh, IscrittoDTipConOcc.class));

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public IscrittoDTipoAll findIscrittoDTipoAllByKey(Long idTipoAllegato) throws DaoException {
		final String methodName = "findIscrittoDTipoAllByKey";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		SqlHolder sh = buildSqlHolder(IscrittoDTipoAll.SQL_SELECT_ALL)
				.addQueryRows(
						"WHERE 1 = 1",
						"  AND id_tipo_allegato = :idTipoAllegato")
				.bind("idTipoAllegato", idTipoAllegato);

		IscrittoDTipoAll result = getFirst(this.query(sh, IscrittoDTipoAll.class));

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public IscrittoDTipoAll findIscrittoDTipoAllByCodTipo(String codTipoAllegato) throws DaoException {
		final String methodName = "findIscrittoDTipoAllByCodTipo";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		SqlHolder sh = buildSqlHolder(IscrittoDTipoAll.SQL_SELECT_ALL)
				.addQueryRows(
						"WHERE 1 = 1",
						"  AND cod_tipo_allegato = :codTipoAllegato")
				.bind("codTipoAllegato", codTipoAllegato);

		IscrittoDTipoAll result = getFirst(this.query(sh, IscrittoDTipoAll.class));

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public List<IscrittoDTipoAll> findAllIscrittoDTipoAll() throws DaoException {
		final String methodName = "findAllIscrittoDTipoAll";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		SqlHolder sh = buildSqlHolder(IscrittoDTipoAll.SQL_SELECT_ALL);
		List<IscrittoDTipoAll> result = this.query(sh, IscrittoDTipoAll.class);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public IscrittoDOrdineScuola findIscrittoDOrdineScuolaByKey(Long idOrdineScuola) throws DaoException {
		final String methodName = "findIscrittoDOrdineScuolaByKey";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		SqlHolder sh = buildSqlHolder(IscrittoDOrdineScuola.SQL_SELECT_ALL)
				.addQueryRows(
						"WHERE 1 = 1",
						"  AND id_ordine_scuola = :idOrdineScuola")
				.bind("idOrdineScuola", idOrdineScuola);

		IscrittoDOrdineScuola result = getFirst(this.query(sh, IscrittoDOrdineScuola.class));

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public IscrittoDOrdineScuola findIscrittoDOrdineScuolaByCod(String codOrdineScuola) throws DaoException {
		final String methodName = "findIscrittoDOrdineScuolaByCod";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		SqlHolder sh = buildSqlHolder(IscrittoDOrdineScuola.SQL_SELECT_ALL)
				.addQueryRows(
						"WHERE 1 = 1",
						"  AND cod_ordine_scuola = :codOrdineScuola")
				.bind("codOrdineScuola", codOrdineScuola);

		IscrittoDOrdineScuola result = getFirst(this.query(sh, IscrittoDOrdineScuola.class));

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public IscrittoDTipoSog findIscrittoDTipoSogByCod(String codTipoSoggetto) throws DaoException {
		final String methodName = "findIscrittoDTipoSogByCod";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		SqlHolder sh = buildSqlHolder(IscrittoDTipoSog.SQL_SELECT_ALL)
				.addQueryRows(
						"WHERE 1 = 1",
						"  AND cod_tipo_soggetto = :codTipoSoggetto")
				.bind("codTipoSoggetto", codTipoSoggetto);

		IscrittoDTipoSog result = getFirst(this.query(sh, IscrittoDTipoSog.class));

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public IscrittoDTipoPre findIscrittoDTipoPreByKey(Long idTipoPresentazione) throws DaoException {
		final String methodName = "findIscrittoDTipoPreByKey";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		SqlHolder sh = buildSqlHolder(IscrittoDTipoPre.SQL_SELECT_ALL)
				.addQueryRows(
						"WHERE 1 = 1",
						"  AND id_tipo_presentazione = :idTipoPresentazione")
				.bind("idTipoPresentazione", idTipoPresentazione);

		IscrittoDTipoPre result = getFirst(this.query(sh, IscrittoDTipoPre.class));

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public IscrittoDTipoPre findIscrittoDTipoPreByCod(String codTipoPresentazione) throws DaoException {
		final String methodName = "findIscrittoDTipoPreByCod";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		SqlHolder sh = buildSqlHolder(IscrittoDTipoPre.SQL_SELECT_ALL)
				.addQueryRows(
						"WHERE 1 = 1",
						"  AND cod_tipo_presentazione = :codTipoPresentazione")
				.bind("codTipoPresentazione", codTipoPresentazione);

		IscrittoDTipoPre result = getFirst(this.query(sh, IscrittoDTipoPre.class));

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public IscrittoDCircoscrizione findIscrittoDCircoscrizioneByKey(Long idCircoscrizione) throws DaoException {
		final String methodName = "findIscrittoDCircoscrizioneByKey";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		SqlHolder sh = buildSqlHolder(IscrittoDCircoscrizione.SQL_SELECT_ALL)
				.addQueryRows(
						"WHERE 1 = 1",
						"  AND id_circoscrizione = :idCircoscrizione")
				.bind("idCircoscrizione", idCircoscrizione);

		IscrittoDCircoscrizione result = getFirst(this.query(sh, IscrittoDCircoscrizione.class));

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public IscrittoDCircoscrizione findIscrittoDCircoscrizioneByCod(String codCircoscrizione) throws DaoException {
		final String methodName = "findIscrittoDCircoscrizioneByCod";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		SqlHolder sh = buildSqlHolder(IscrittoDCircoscrizione.SQL_SELECT_ALL)
				.addQueryRows(
						"WHERE 1 = 1",
						"  AND cod_circoscrizione = :codCircoscrizione")
				.bind("codCircoscrizione", codCircoscrizione);

		IscrittoDCircoscrizione result = getFirst(this.query(sh, IscrittoDCircoscrizione.class));

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public IscrittoDGenitoreSol findIscrittoDGenitoreSolByKey(Long idTipoGenitoreSolo) throws DaoException {
		final String methodName = "findIscrittoDGenitoreSolByKey";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		SqlHolder sh = buildSqlHolder(IscrittoDGenitoreSol.SQL_SELECT_ALL)
				.addQueryRows(
						"WHERE 1 = 1",
						"  AND id_tipo_genitore_solo = :idTipoGenitoreSolo")
				.bind("idTipoGenitoreSolo", idTipoGenitoreSolo);

		IscrittoDGenitoreSol result = getFirst(this.query(sh, IscrittoDGenitoreSol.class));

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public IscrittoDGenitoreSol findIscrittoDGenitoreSolByCod(String codTipoGenitoreSolo) throws DaoException {
		final String methodName = "findIscrittoDGenitoreSolByCod";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		SqlHolder sh = buildSqlHolder(IscrittoDGenitoreSol.SQL_SELECT_ALL)
				.addQueryRows(
						"WHERE 1 = 1",
						"  AND cod_tipo_genitore_solo = :codTipoGenitoreSolo")
				.bind("codTipoGenitoreSolo", codTipoGenitoreSolo);

		IscrittoDGenitoreSol result = getFirst(this.query(sh, IscrittoDGenitoreSol.class));

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public IscrittoDTipoFra findIscrittoDTipoFraByKey(Long idTipoFratello) throws DaoException {
		final String methodName = "findIscrittoDTipoFraByKey";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		SqlHolder sh = buildSqlHolder(IscrittoDTipoFra.SQL_SELECT_ALL)
				.addQueryRows(
						"WHERE 1 = 1",
						"  AND id_tipo_fratello = :idTipoFratello")
				.bind("idTipoFratello", idTipoFratello);

		IscrittoDTipoFra result = getFirst(this.query(sh, IscrittoDTipoFra.class));

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public IscrittoDTipoFra findIscrittoDTipoFraByCod(String codTipoFratello) throws DaoException {
		final String methodName = "findIscrittoDTipoFraByCod";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		SqlHolder sh = buildSqlHolder(IscrittoDTipoFra.SQL_SELECT_ALL)
				.addQueryRows(
						"WHERE 1 = 1",
						"  AND cod_tipo_fratello = :codTipoFratello")
				.bind("codTipoFratello", codTipoFratello);

		IscrittoDTipoFra result = getFirst(this.query(sh, IscrittoDTipoFra.class));

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public IscrittoDTipoCambioRes findIscrittoDTipoCambioResByKey(Long idTipoCambioRes) throws DaoException {
		final String methodName = "findIscrittoDTipoCambioResByKey";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		SqlHolder sh = buildSqlHolder(IscrittoDTipoCambioRes.SQL_SELECT_ALL)
				.addQueryRows(
						"WHERE 1 = 1",
						"  AND id_tipo_cambio_res = :idTipoCambioRes")
				.bind("idTipoCambioRes", idTipoCambioRes);

		IscrittoDTipoCambioRes result = getFirst(this.query(sh, IscrittoDTipoCambioRes.class));

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public IscrittoDTipoCambioRes findIscrittoDTipoCambioResByCod(String codTipoCambioRes) throws DaoException {
		final String methodName = "findIscrittoDTipoCambioResByCod";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		SqlHolder sh = buildSqlHolder(IscrittoDTipoCambioRes.SQL_SELECT_ALL)
				.addQueryRows(
						"WHERE 1 = 1",
						"  AND cod_tipo_cambio_res = :codTipoCambioRes")
				.bind("codTipoCambioRes", codTipoCambioRes);

		IscrittoDTipoCambioRes result = getFirst(this.query(sh, IscrittoDTipoCambioRes.class));

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public IscrittoDTipoFre findIscrittoDTipoFreByCod(String codTipoFrequenza) throws DaoException {
		final String methodName = "findIscrittoDTipoFreByCod";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		SqlHolder sh = buildSqlHolder(IscrittoDTipoFre.SQL_SELECT_ALL)
				.addQueryRows(
						"WHERE 1 = 1",
						"  AND cod_tipo_frequenza = :codTipoFrequenza")
				.bind("codTipoFrequenza", codTipoFrequenza);

		IscrittoDTipoFre result = getFirst(this.query(sh, IscrittoDTipoFre.class));

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public IscrittoDCategoriaScu findIscrittoDCategoriaScuByKey(Long idCategoriaScu) throws DaoException {
		final String methodName = "findIscrittoDCategoriaScuByKey";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		SqlHolder sh = buildSqlHolder(IscrittoDCategoriaScu.SQL_SELECT_ALL)
				.addQueryRows(
						"WHERE 1 = 1",
						"  AND id_categoria_scu = :idCategoriaScu")
				.bind("idCategoriaScu", idCategoriaScu);

		IscrittoDCategoriaScu result = getFirst(this.query(sh, IscrittoDCategoriaScu.class));

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public IscrittoDTipoFre findIscrittoDTipoFreByKey(Long idTipoFrequenza) throws DaoException {
		final String methodName = "findIscrittoDTipoFreByKey";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		SqlHolder sh = buildSqlHolder(IscrittoDTipoFre.SQL_SELECT_ALL)
				.addQueryRows(
						"WHERE 1 = 1",
						"  AND id_tipo_frequenza = :idTipoFrequenza")
				.bind("idTipoFrequenza", idTipoFrequenza);

		IscrittoDTipoFre result = getFirst(this.query(sh, IscrittoDTipoFre.class));

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public IscrittoDTipoCorso findIscrittoDTipoCorsoByKey(Long idTipoCorso) throws DaoException {
		final String methodName = "findIscrittoDTipoCorsoByKey";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		SqlHolder sh = buildSqlHolder(IscrittoDTipoCorso.SQL_SELECT_ALL)
				.addQueryRows(
						"WHERE 1 = 1",
						"  AND id_tipo_corso = :idTipoCorso")
				.bind("idTipoCorso", idTipoCorso);

		IscrittoDTipoCorso result = getFirst(this.query(sh, IscrittoDTipoCorso.class));

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public IscrittoDTipoCorso findIscrittoDTipoCorsoByCod(String codTipoCorso) throws DaoException {
		final String methodName = "findIscrittoDTipoCorsoByCod";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		SqlHolder sh = buildSqlHolder(IscrittoDTipoCorso.SQL_SELECT_ALL)
				.addQueryRows(
						"WHERE 1 = 1",
						"  AND cod_tipo_corso = :codTipoCorso")
				.bind("codTipoCorso", codTipoCorso);

		IscrittoDTipoCorso result = getFirst(this.query(sh, IscrittoDTipoCorso.class));

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public IscrittoDStatoScu findIscrittoDStatoScuByKey(Long idStatoScu) throws DaoException {
		final String methodName = "findIscrittoDStatoScuByKey";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		SqlHolder sh = buildSqlHolder(IscrittoDStatoScu.SQL_SELECT_ALL)
				.addQueryRows(
						"WHERE 1 = 1",
						"  AND id_stato_scu = :idStatoScu")
				.bind("idStatoScu", idStatoScu);

		IscrittoDStatoScu result = getFirst(this.query(sh, IscrittoDStatoScu.class));

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public IscrittoDStatoGra findIscrittoDStatoGraByKey(Long idStatoGra) throws DaoException {
		final String methodName = "findIscrittoDStatoGraByKey";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		SqlHolder sh = buildSqlHolder(IscrittoDStatoGra.SQL_SELECT_ALL)
				.addQueryRows(
						"WHERE 1 = 1",
						"  AND id_stato_gra = :idStatoGra")
				.bind("idStatoGra", idStatoGra);

		IscrittoDStatoGra result = getFirst(this.query(sh, IscrittoDStatoGra.class));

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

}
