package it.csi.iscritto.serviscritto.business.integration.dao;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import it.csi.iscritto.serviscritto.business.integration.exception.DaoException;
import it.csi.iscritto.serviscritto.business.util.sql.Query;
import it.csi.iscritto.serviscritto.business.util.sql.SqlHolder;
import it.csi.iscritto.serviscritto.business.util.sql.SqlHolderFactory;

public abstract class AbstractDao {
	public static final String ENCRYPTION_KEY_PLACEHOLDER = "@ENC_KEY@";
	public static final String ENCRYPTION_KEY_PROPERTY_NAME = "iscritto.encryption.key";

	protected NamedParameterJdbcTemplate namedJdbcTemplate;
	private String encryptionKey;

	public void setNamedJdbcTemplate(NamedParameterJdbcTemplate namedJdbcTemplate) {
		this.namedJdbcTemplate = namedJdbcTemplate;
	}

	public void setEncryptionKey(String encryptionKey) {
		this.encryptionKey = encryptionKey;
	}

	protected static final SqlHolder buildSqlHolder(String... sqlRows) {
		return SqlHolderFactory.createSqlHolder(sqlRows);
	}

	protected static final <T> BeanPropertyRowMapper<T> buildRowMapper(Class<T> mappedClass) {
		return new BeanPropertyRowMapper<>(mappedClass);
	}

	protected final String getEncryptionKey() throws DaoException {
		if (StringUtils.isBlank(this.encryptionKey)) {
			throw new DaoException("chiave di cifratura non valida");
		}

		if (this.encryptionKey.contains(ENCRYPTION_KEY_PLACEHOLDER)) {
			throw new DaoException("placeholder non sostituito");
		}

		if (this.encryptionKey.contains(ENCRYPTION_KEY_PROPERTY_NAME)) {
			throw new DaoException("property iscritto.encryption.key non presente");
		}

		return this.encryptionKey;
	}

	//////////////////////////////////////////////////////////////////////

	protected final <T> List<T> query(String query, final Class<T> mappedClass)
			throws DaoException {

		Validate.notBlank(query);
		Validate.notNull(mappedClass);

		return this.query(buildSqlHolder(query), mappedClass);
	}

	protected final <T> List<T> query(SqlHolder sqlHolder, final Class<T> mappedClass)
			throws DaoException {

		Validate.notNull(sqlHolder);
		Validate.notNull(mappedClass);

		return new Query<List<T>>(sqlHolder) {
			@Override
			protected List<T> doQuery() {
				return namedJdbcTemplate.query(SQL, PARAMS, buildRowMapper(mappedClass));
			}
		}.execute();
	}

	protected final <T> List<T> queryForList(SqlHolder sqlHolder, final Class<T> mappedClass)
			throws DaoException {

		Validate.notNull(sqlHolder);
		Validate.notNull(mappedClass);

		return new Query<List<T>>(sqlHolder) {
			@Override
			protected List<T> doQuery() {
				return namedJdbcTemplate.queryForList(SQL, PARAMS, mappedClass);
			}
		}.execute();
	}

	//////////////////////////////////////////////////////////////////////

	protected final Integer update(SqlHolder sqlHolder)
			throws DaoException {

		Validate.notNull(sqlHolder);

		return new Query<Integer>(sqlHolder) {
			@Override
			protected Integer doQuery() {
				return namedJdbcTemplate.update(SQL, PARAMS);
			}
		}.execute();
	}

	//////////////////////////////////////////////////////////////////////

	protected final Long nextval(String sequenceName)
			throws DaoException {

		Validate.notBlank(sequenceName);

		SqlHolder sh = buildSqlHolder("select nextval(:sequenceName) as num")
				.bind("sequenceName", sequenceName);

		return new Query<Long>(sh) {
			@Override
			protected Long doQuery() {
				return namedJdbcTemplate.queryForLong(SQL, PARAMS);
			}
		}.execute();
	}

}
