package it.csi.iscritto.serviscritto.business.integration.dao.view;

import java.util.Date;
import java.util.List;

import it.csi.iscritto.serviscritto.business.integration.dao.TipoScuola;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTAnnoSco;
import it.csi.iscritto.serviscritto.business.integration.dao.view.dto.FasciaEtaRow;
import it.csi.iscritto.serviscritto.business.integration.dao.view.dto.ScuolaRow;
import it.csi.iscritto.serviscritto.business.integration.exception.DaoException;

public interface ScuoleDao {

	List<ScuolaRow> findScuole(TipoScuola tipoScuola, String codAnno, Date dataNascita) throws DaoException;

	List<ScuolaRow> findScuoleByDescrizione(TipoScuola tipoScuola, String codAnno, String descrizione, Date dataNascita) throws DaoException;

	List<ScuolaRow> findScuoleByIndirizzo(TipoScuola tipoScuola, String codAnno, String indirizzo, Date dataNascita) throws DaoException;

	List<ScuolaRow> findScuoleByCircoscrizione(TipoScuola tipoScuola, String codAnno, Integer circoscrizione, Date dataNascita) throws DaoException;

	List<IscrittoTAnnoSco> findIscrittoTAnnoScoByDate(TipoScuola tipoScuola, Date data) throws DaoException;

	List<ScuolaRow> findScuoleByUtente(TipoScuola tipoScuola, String cfOperatore, String codProfilo) throws DaoException;

	List<ScuolaRow> findScuoleOperatore(TipoScuola tipoScuola, String codAnno, Date dataNascita, String cfOperatore) throws DaoException;

	List<FasciaEtaRow> findFasceEta() throws DaoException;

}
