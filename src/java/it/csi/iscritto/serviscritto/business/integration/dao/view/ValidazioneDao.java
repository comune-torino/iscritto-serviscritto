package it.csi.iscritto.serviscritto.business.integration.dao.view;

import java.util.Date;
import java.util.List;

import it.csi.iscritto.serviscritto.business.integration.dao.TipoScuola;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTAnagraficaGra;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTEta;
import it.csi.iscritto.serviscritto.business.integration.dao.view.dto.InfoDomandaRow;
import it.csi.iscritto.serviscritto.business.integration.exception.DaoException;

public interface ValidazioneDao {

	List<InfoDomandaRow> dataCheckAltroRichiedente(TipoScuola tipoScuola, String codAnnoScolastico, String codiceFiscaleRic, String codiceFiscaleMin)
			throws DaoException;

	List<InfoDomandaRow> dataCheckDomandaEsistente(TipoScuola tipoScuola, String codAnnoScolastico, String codiceFiscaleRic, String codiceFiscaleMin)
			throws DaoException;

	List<InfoDomandaRow> dataCheckDomandaEsistenteForInvio(TipoScuola tipoScuola, String codAnnoScolastico, String codiceFiscaleRic, String codiceFiscaleMin)
			throws DaoException;

	List<IscrittoTAnagraficaGra> dataCheckDomandaFuoriPeriodo(TipoScuola tipoScuola, Date data)
			throws DaoException;

	List<IscrittoTAnagraficaGra> dataCheckDomandaFuoriTermine(TipoScuola tipoScuola, Date data)
			throws DaoException;

	List<IscrittoTEta> dataDataNascitaMinore(TipoScuola tipoScuola, String codAnnoScolastico, Date data)
			throws DaoException;

}
