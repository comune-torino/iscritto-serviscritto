package it.csi.iscritto.serviscritto.business.integration.dao.table;

import java.util.List;

import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoRSoggettoRel;
import it.csi.iscritto.serviscritto.business.integration.exception.DaoException;

public interface SoggettoRelDao {

	List<IscrittoRSoggettoRel> findIscrittoRSoggettoRelByIdSog(Long idAnagraficaSoggetto) throws DaoException;

	void insertIscrittoRSoggettoRel(IscrittoRSoggettoRel row) throws DaoException;

	Integer deleteIscrittoRSoggettoRelByIdSoggetto(Long idAnagraficaSoggetto) throws DaoException;

}
