package it.csi.iscritto.serviscritto.business.integration.dao.table;

import java.util.List;

import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTAllegato;
import it.csi.iscritto.serviscritto.business.integration.exception.DaoException;

public interface AllegatoDao {

	IscrittoTAllegato findIscrittoTAllegatoByKey(Long idAllegato, boolean withContent) throws DaoException;

	List<IscrittoTAllegato> findIscrittoTAllegatoByFk(Long idAnagraficaSoggetto) throws DaoException;

	Long insertAllegato(IscrittoTAllegato allegato) throws DaoException;

	Integer updateAllegato(Long idAllegato, Long idAnagraficaSoggetto) throws DaoException;

	Integer updateProtocollo(Long idAllegato, String protocollo) throws DaoException;

	Integer deleteAllegato(Long idAllegato) throws DaoException;

}
