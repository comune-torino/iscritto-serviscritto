package it.csi.iscritto.serviscritto.business.integration.dao.table;

import java.util.Date;

import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTComune;
import it.csi.iscritto.serviscritto.business.integration.exception.DaoException;

public interface ComuneDao {

	IscrittoTComune findIscrittoTComuneByKey(Long idComune) throws DaoException;

	IscrittoTComune findIscrittoTComuneByIstatComune(Date data, String istatComune) throws DaoException;

}
