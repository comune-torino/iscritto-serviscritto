package it.csi.iscritto.serviscritto.business.integration.dao.custom;

import java.util.List;

import it.csi.iscritto.serviscritto.business.integration.dao.StatoDomanda;
import it.csi.iscritto.serviscritto.business.integration.dao.StatoScuola;
import it.csi.iscritto.serviscritto.business.integration.dao.TipoScuola;
import it.csi.iscritto.serviscritto.business.integration.dao.custom.dto.DatiAccettazioneRow;
import it.csi.iscritto.serviscritto.business.integration.dao.custom.dto.RicevutaAccettazioneRow;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoRScuolaPre;
import it.csi.iscritto.serviscritto.business.integration.exception.DaoException;

public interface AccettazioneDao {

	DatiAccettazioneRow findDatiAccettazione(Long idDomanda, String codScuola) throws DaoException;

	IscrittoRScuolaPre findPreferenza(Long idDomandaIscrizione, String codScuola, String codTipoFrequenza) throws DaoException;

	List<IscrittoRScuolaPre> findPreferenzeByCodStatoScuola(Long idDomandaIscrizione, StatoScuola statoScuola) throws DaoException;

	List<IscrittoRScuolaPre> findPreferenzeByIdDomanda(Long idDomandaIscrizione) throws DaoException;

	Long findStepGraduatoria(Long idDomandaIscrizione) throws DaoException;

	boolean isTipoPastoObbligatorio(TipoScuola tipoScuola, String codScuola) throws DaoException;

	RicevutaAccettazioneRow findRicevutaAccettazione(Long idDomandaIscrizione) throws DaoException;

	Integer modificaPreferenza(Long idDomandaIscrizione, String codScuola, String codTipoFrequenza, StatoScuola statoScuola) throws DaoException;

	Integer modificaPostiPerAccettazione(TipoScuola tipoScuola, Long idDomandaIscrizione, String codScuola, String codTipoFrequenza) throws DaoException;

	Integer modificaPostiPerRifiuto(TipoScuola tipoScuola, Long idDomandaIscrizione, String codScuola, String codTipoFrequenza) throws DaoException;

	Integer modificaAltrePreferenze(Long idDomandaIscrizione, StatoScuola statoScuola) throws DaoException;

	Integer modificaStatoDomanda(Long idDomandaIscrizione, StatoDomanda statoDomanda) throws DaoException;

	Integer modificaStatoGraduatoria(Long idDomandaIscrizione, String codScuola, String codTipoFrequenza, StatoScuola statoScuola) throws DaoException;

	Integer modificaStatoAltreGraduatorie(Long idDomandaIscrizione, StatoScuola statoScuola) throws DaoException;

	Integer modificaTelRichiedente(Long idDomandaIscrizione, String telRichiedente) throws DaoException;

	Long insertOperazione(Long idDomandaIscrizione, String cfOperatore, String codScuola, String codTipoFrequenza, boolean isAccettazione) throws DaoException;

	Integer insertInvioAccettazione(Long idAccettazioneRinuncia, String telRichiedente, String codTipoPasto) throws DaoException;

	Integer insertPreferenzaFuoriTermine(TipoScuola tipoScuola, Long idDomanda, String codScuola, String codTipoFrequenza) throws DaoException;

}
