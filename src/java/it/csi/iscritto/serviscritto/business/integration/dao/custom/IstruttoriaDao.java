package it.csi.iscritto.serviscritto.business.integration.dao.custom;

import java.util.Date;
import java.util.List;

import it.csi.iscritto.serviscritto.business.integration.dao.StatoScuola;
import it.csi.iscritto.serviscritto.business.integration.dao.TipoScuola;
import it.csi.iscritto.serviscritto.business.integration.dao.custom.dto.DatiCondizionePunteggioRow;
import it.csi.iscritto.serviscritto.business.integration.dao.custom.dto.InfoAllegatoSoggettoRow;
import it.csi.iscritto.serviscritto.business.integration.dao.custom.dto.VerbaleCommissioneRow;
import it.csi.iscritto.serviscritto.business.integration.exception.DaoException;

public interface IstruttoriaDao {

	List<DatiCondizionePunteggioRow> findStoricoCondizioniPunteggio(Long idDomanda, String codCondizionePunteggio) throws DaoException;

	List<InfoAllegatoSoggettoRow> findAllegatiDomanda(Long idDomanda, String codCondizionePunteggio, boolean withRed) throws DaoException;

	int countCondizioniNonIstruite(Long idDomanda) throws DaoException;

	List<VerbaleCommissioneRow> findInfoVerbali(TipoScuola tipoScuola, String codFiscaleOperatore, String codProfilo, String tipoCommissione, Date dataInizio, Date dataFine) throws DaoException;

	boolean condizioneResNotoLav(Long idDomanda) throws DaoException;

	// jira ISBO-280
	boolean hasDomandaCondizionePunteggio(Long idDomanda, String codCondizionePunteggio) throws DaoException;

	boolean hasDomandaCondizioneIstruita(Long idDomanda, String codCondizionePunteggio) throws DaoException;

	boolean hasDomandaCondizioneValida(Long idDomanda, String codCondizionePunteggio) throws DaoException;

	boolean fuoriTermine(Long idDomanda, Long idAnagraficaGra) throws DaoException;

	Integer modificaCondizionePunteggio(DatiCondizionePunteggioRow row) throws DaoException;

	Integer insertAllegatoRed(Long idAllegato, String codCondizionePunteggio) throws DaoException;

	Integer updateStatoScuola(Long idDomandaIscrizione, String codScuola, String codTipoFrequenza, StatoScuola statoScuola) throws DaoException;

	Integer updateFlIstruita(Long idDomanda, boolean istruita) throws DaoException;

}
