package it.csi.iscritto.serviscritto.business.integration.dao.table.impl;

import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.LOG_BEGIN;
import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.LOG_END;
import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.buildMessage;
import static it.csi.iscritto.serviscritto.business.util.converter.ConvertUtils.getFirst;

import java.util.List;

import org.apache.log4j.Logger;

import it.csi.iscritto.serviscritto.business.integration.dao.AbstractDao;
import it.csi.iscritto.serviscritto.business.integration.dao.table.AllegatoDao;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTAllegato;
import it.csi.iscritto.serviscritto.business.integration.exception.DaoException;
import it.csi.iscritto.serviscritto.business.util.Constants;
import it.csi.iscritto.serviscritto.business.util.sql.SqlHolder;

public class AllegatoDaoImpl extends AbstractDao implements AllegatoDao {
	private static final Logger log = Logger.getLogger(Constants.COMPONENT_NAME + ".dao");

	@Override
	public IscrittoTAllegato findIscrittoTAllegatoByKey(Long idAllegato, boolean withContent) throws DaoException {
		final String methodName = "findIscrittoTAllegatoByFk";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		SqlHolder sh = withContent
				? buildIscrittoTAllegatoFullQuery(this.getEncryptionKey())
				: buildIscrittoTAllegatoBaseQuery();

		sh.addQueryRows("AND id_allegato = :idAllegato")
				.bind("idAllegato", idAllegato);

		IscrittoTAllegato result = getFirst(this.query(sh, IscrittoTAllegato.class));

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public List<IscrittoTAllegato> findIscrittoTAllegatoByFk(Long idAnagraficaSoggetto) throws DaoException {
		final String methodName = "findIscrittoTAllegatoByFk";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		SqlHolder sh = buildIscrittoTAllegatoBaseQuery()
				.addQueryRows("AND id_anagrafica_soggetto = :idAnagraficaSoggetto")
				.bind("idAnagraficaSoggetto", idAnagraficaSoggetto);

		List<IscrittoTAllegato> result = this.query(sh, IscrittoTAllegato.class);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	//////////////////////////////////////////////////////////////////////

	@Override
	public Long insertAllegato(IscrittoTAllegato allegato) throws DaoException {
		final String methodName = "insertAllegato";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		final Long idAllegato = this.nextval("iscritto_t_allegato_id_allegato_seq");

		log.info(buildMessage(getClass(), methodName, "idAllegato: " + idAllegato));

		final SqlHolder sh = buildSqlHolder()
				.addQueryRows(
						"insert into iscritto_t_allegato (",
						"  documento,",
						"  protocollo,",
						"  id_allegato,",
						"  id_anagrafica_soggetto,",
						"  id_tipo_allegato,",
						"  data_inserimento,",
						"  nome_file,",
						"  mime_type",
						") ",
						"values (",
						"  fcifra_b(:documento, :encryptionKey),",
						"  :protocollo,",
						"  :idAllegato,",
						"  :idAnagraficaSoggetto,",
						"  :idTipoAllegato,",
						"  :dataInserimento,",
						"  :nomeFile,",
						"  :mimeType",
						")")
				.bind("encryptionKey", this.getEncryptionKey())
				.bind("documento", allegato.getDocumento())
				.bind("protocollo", allegato.getProtocollo())
				.bind("idAllegato", idAllegato)
				.bind("idAnagraficaSoggetto", allegato.getIdAnagraficaSoggetto())
				.bind("idTipoAllegato", allegato.getIdTipoAllegato())
				.bind("dataInserimento", allegato.getDataInserimento())
				.bind("nomeFile", allegato.getNomeFile())
				.bind("mimeType", allegato.getMimeType());

		this.update(sh);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return idAllegato;
	}

	@Override
	public Integer updateAllegato(Long idAllegato, Long idAnagraficaSoggetto) throws DaoException {
		final String methodName = "deleteAllegato";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		log.info(buildMessage(getClass(), methodName, "idAllegato: " + idAllegato));
		log.info(buildMessage(getClass(), methodName, "idAnagraficaSoggetto: " + idAnagraficaSoggetto));

		final SqlHolder sh = buildSqlHolder()
				.addQueryRows(
						"UPDATE iscritto_t_allegato",
						"SET id_anagrafica_soggetto = :idAnagraficaSoggetto",
						"WHERE id_allegato = :idAllegato")
				.bind("idAllegato", idAllegato)
				.bind("idAnagraficaSoggetto", idAnagraficaSoggetto);

		Integer result = this.update(sh);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public Integer updateProtocollo(Long idAllegato, String protocollo) throws DaoException {
		final String methodName = "deleteAllegato";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		log.info(buildMessage(getClass(), methodName, "idAllegato: " + idAllegato));
		log.info(buildMessage(getClass(), methodName, "protocollo: " + protocollo));

		final SqlHolder sh = buildSqlHolder()
				.addQueryRows(
						"UPDATE iscritto_t_allegato",
						"SET protocollo = :protocollo",
						"WHERE id_allegato = :idAllegato")
				.bind("idAllegato", idAllegato)
				.bind("protocollo", protocollo);

		Integer result = this.update(sh);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	@Override
	public Integer deleteAllegato(Long idAllegato) throws DaoException {
		final String methodName = "deleteAllegato";
		log.debug(buildMessage(getClass(), methodName, LOG_BEGIN));

		log.info(buildMessage(getClass(), methodName, "idAllegato: " + idAllegato));

		final SqlHolder sh = buildSqlHolder()
				.addQueryRows(
						"DELETE FROM iscritto_t_allegato",
						"WHERE id_allegato = :idAllegato")
				.bind("idAllegato", idAllegato);

		Integer result = this.update(sh);

		log.debug(buildMessage(getClass(), methodName, LOG_END));
		return result;
	}

	//////////////////////////////////////////////////////////////////////

	private static SqlHolder buildIscrittoTAllegatoBaseQuery() {
		return buildSqlHolder()
				.addQueryRows(
						"SELECT",
						"  protocollo,",
						"  id_allegato,",
						"  id_anagrafica_soggetto,",
						"  id_tipo_allegato,",
						"  data_inserimento,",
						"  nome_file,",
						"  mime_type",
						"FROM iscritto_t_allegato",
						"WHERE 1 = 1");
	}

	private static SqlHolder buildIscrittoTAllegatoFullQuery(String encryptionKey) throws DaoException {
		return buildSqlHolder()
				.addQueryRows(
						"SELECT",
						"  fdecifra_b(documento::bytea, :encryptionKey) as documento,",
						"  protocollo,",
						"  id_allegato,",
						"  id_anagrafica_soggetto,",
						"  id_tipo_allegato,",
						"  data_inserimento,",
						"  nome_file,",
						"  mime_type",
						"FROM iscritto_t_allegato",
						"WHERE 1 = 1")
				.bind("encryptionKey", encryptionKey);
	}

}
