package it.csi.iscritto.serviscritto.business.integration.dao.view;

import java.util.Date;
import java.util.List;

import it.csi.iscritto.serviscritto.business.integration.dao.StatoCondizionePunteggio;
import it.csi.iscritto.serviscritto.business.integration.dao.TipoScuola;
import it.csi.iscritto.serviscritto.business.integration.dao.view.dto.CodificaRow;
import it.csi.iscritto.serviscritto.business.integration.dao.view.dto.CondizionePunteggioRow;
import it.csi.iscritto.serviscritto.business.integration.dao.view.dto.ProtocolloRow;
import it.csi.iscritto.serviscritto.business.integration.dao.view.dto.TestataDomandaDaVerificareRow;
import it.csi.iscritto.serviscritto.business.integration.dao.view.dto.TestataDomandaIstruttoriaRow;
import it.csi.iscritto.serviscritto.business.integration.dao.view.dto.TestataDomandaRow;
import it.csi.iscritto.serviscritto.business.integration.exception.DaoException;

public interface DomandaDao {

	List<Long> findDomandeByCodiceFiscaleMinore(TipoScuola tipoScuola, String cfOperatore, String codProfilo, String codiceFiscale) throws DaoException;

	List<Long> findDomandeByCodiceFiscaleRichiedente(TipoScuola tipoScuola, String codiceFiscale) throws DaoException;

	List<Long> findDomandeByCognomeNomeMinore(TipoScuola tipoScuola, String cfOperatore, String codProfilo, String cognome, String nome) throws DaoException;

	List<Long> findDomandeByCodiceScuola(TipoScuola tipoScuola, String cfOperatore, String codProfilo, String codiceScuola, String codiceStatoDomanda)
			throws DaoException;

	List<Long> findDomandeByProtocollo(TipoScuola tipoScuola, String cfOperatore, String codProfilo, String protocollo) throws DaoException;

	List<TestataDomandaIstruttoriaRow> findDomandeByCondizionePunteggio(
			TipoScuola tipoScuola, String cfOperatore, String codProfilo, String codiceCondizione, StatoCondizionePunteggio condizionePunteggio,
			String nomeMinore, String cognomeMinore, Date dataInizio, Date dataFine)
			throws DaoException;

	List<CodificaRow> findAllStatiDomanda() throws DaoException;

	TestataDomandaRow findTestataDomandaRicByIdDomanda(Long idDomanda) throws DaoException;

	TestataDomandaRow findTestataDomandaRicMinByIdDomanda(Long idDomanda) throws DaoException;

	ProtocolloRow getInfoProtocollo(Long idDomanda) throws DaoException;

	Long getNextNumProtocollo(TipoScuola tipoScuola) throws DaoException;

	List<CondizionePunteggioRow> findCondizioniPunteggio(Long idDomanda) throws DaoException;

	List<String> findFlIrc(Long idDomanda) throws DaoException;

	List<TestataDomandaDaVerificareRow> findDomandeDaVerificare(TipoScuola tipoScuola, String codFiscale, String codProfilo) throws DaoException;

}
