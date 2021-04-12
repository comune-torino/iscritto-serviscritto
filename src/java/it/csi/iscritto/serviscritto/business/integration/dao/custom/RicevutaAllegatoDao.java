package it.csi.iscritto.serviscritto.business.integration.dao.custom;

import it.csi.iscritto.serviscritto.business.integration.dao.custom.dto.RicevutaAllegatoRow;
import it.csi.iscritto.serviscritto.business.integration.exception.DaoException;

public interface RicevutaAllegatoDao {

	RicevutaAllegatoRow buildRicevutaAllegato(Long idAllegato) throws DaoException;

}
