package it.csi.iscritto.serviscritto.business.integration.dao.table;

import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTDomandaIsc;
import it.csi.iscritto.serviscritto.business.integration.exception.DaoException;

public interface DomandaIscDao {

	IscrittoTDomandaIsc findIscrittoTDomandaIscByKey(Long idDomandaIscrizione) throws DaoException;

	Long insertIscrittoTDomandaIsc(IscrittoTDomandaIsc row) throws DaoException;

	Integer updateUltimaModifica(Long idDomandaIscrizione, Long idOperatore) throws DaoException;

	Integer deleteIscrittoTDomandaIsc(Long idDomandaIscrizione) throws DaoException;

	Integer updateDomandaForInvio(Long idDomandaIscrizione, String protocollo) throws DaoException;

	Integer invalidaDomanda(Long idDomandaIscrizione, Long idOperatore) throws DaoException;

	Integer annullaDomanda(Long idDomandaIscrizione, Long idOperatore) throws DaoException;

}
