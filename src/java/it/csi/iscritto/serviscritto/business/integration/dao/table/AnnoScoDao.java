package it.csi.iscritto.serviscritto.business.integration.dao.table;

import java.util.Date;

import it.csi.iscritto.serviscritto.business.integration.dao.TipoScuola;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTAnnoSco;
import it.csi.iscritto.serviscritto.business.integration.exception.DaoException;

public interface AnnoScoDao {

	IscrittoTAnnoSco findIscrittoTAnnoScoByKey(Long idAnnoScolastico) throws DaoException;

	IscrittoTAnnoSco findIscrittoTAnnoScoByCod(String codAnnoScolastico) throws DaoException;

	IscrittoTAnnoSco findIscrittoTAnnoScoByDate(TipoScuola tipoScuola, Date data) throws DaoException;

}
