package it.csi.iscritto.serviscritto.business.integration.dao.view;

import java.util.List;

import it.csi.iscritto.serviscritto.business.integration.dao.TipoScuola;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoDProfilo;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTAttivita;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTFunzione;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTUtente;
import it.csi.iscritto.serviscritto.business.integration.dao.view.dto.InfoCondizionePunteggioRow;
import it.csi.iscritto.serviscritto.business.integration.dao.view.dto.PrivilegioOperatoreRow;
import it.csi.iscritto.serviscritto.business.integration.exception.DaoException;

public interface ProfilazioneDao {

	List<IscrittoTFunzione> findFunzioni(String codFiscale, String codProfilo) throws DaoException;

	List<IscrittoDProfilo> findProfili(String codFiscale) throws DaoException;

	Boolean findAssegnamentoNidi(String codFiscale) throws DaoException;

	Boolean findAssegnamentoMaterne(String codFiscale) throws DaoException;

	List<IscrittoTAttivita> findAttivita(String codFiscale, String codProfilo, String codFunzione) throws DaoException;

	List<PrivilegioOperatoreRow> findPrivilegi(String codFiscale, String codProfilo) throws DaoException;

	List<InfoCondizionePunteggioRow> findCondizioniPunteggio(TipoScuola tipoScuola, String codFiscale, String codProfilo, String tipoIstruttoria)
			throws DaoException;

	IscrittoTUtente findUtenteByCodFiscale(String codFiscale) throws DaoException;

}
