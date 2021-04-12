package it.csi.iscritto.serviscritto.business.integration.dao.table;

import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoRNidoContiguo;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTFratelloFre;
import it.csi.iscritto.serviscritto.business.integration.exception.DaoException;

public interface FratelloFreDao {

	IscrittoTFratelloFre findIscrittoTFratelloFreByKey(Long idFratelloFrequentante) throws DaoException;

	IscrittoTFratelloFre findIscrittoTFratelloFreByFk(Long idDomandaIscrizione) throws DaoException;

	IscrittoRNidoContiguo findIscrittoRNidoContiguoByIdDomanda(Long idDomandaIsc) throws DaoException;

	Long insertIscrittoTFratelloFre(IscrittoTFratelloFre row) throws DaoException;

	Integer deleteIscrittoTFratelloFreByFk(Long idDomandaIscrizione) throws DaoException;

	void insertIscrittoRNidoContiguo(IscrittoRNidoContiguo row) throws DaoException;

	Integer deleteIscrittoRNidoContiguo(Long idDomandaIsc) throws DaoException;

}
