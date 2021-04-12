package it.csi.iscritto.serviscritto.business.integration.dao.view;

import java.util.List;

import it.csi.iscritto.serviscritto.business.integration.dao.TipoSoggetto;
import it.csi.iscritto.serviscritto.business.integration.dao.view.dto.SoggettoRow;
import it.csi.iscritto.serviscritto.business.integration.exception.DaoException;

public interface SoggettoDao {

	List<SoggettoRow> findSoggettiByIdDomanda(Long idDomandaIscrizione, TipoSoggetto tipoSoggetto) throws DaoException;

	List<SoggettoRow> findSoggettiByIdDomanda(Long idDomandaIscrizione) throws DaoException;

	List<SoggettoRow> findSoggettiByIdSoggetto(Long idAnagraficaSoggetto) throws DaoException;

}
