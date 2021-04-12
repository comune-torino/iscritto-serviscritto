package it.csi.iscritto.serviscritto.business.integration.dao.table;

import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoDCondizionePun;
import it.csi.iscritto.serviscritto.business.integration.exception.DaoException;

public interface CondizionePunteggioDao {

	IscrittoDCondizionePun findIscrittoDCondizionePunByPk(Long idCondizionePunteggio) throws DaoException;

	Integer deleteIscrittoRPunteggioDomByIdDomanda(Long idDomandaIscrizione) throws DaoException;

}
