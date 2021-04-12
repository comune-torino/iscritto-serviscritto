package it.csi.iscritto.serviscritto.business.integration.dao.table;

import java.util.List;

import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoDCategoriaScu;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoDCircoscrizione;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoDCoabitazione;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoDGenitoreSol;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoDOrdineScuola;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoDRelazionePar;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoDStatoDom;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoDStatoGra;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoDStatoScu;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoDTipConOcc;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoDTipoAll;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoDTipoCambioRes;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoDTipoCorso;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoDTipoFra;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoDTipoFre;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoDTipoPre;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoDTipoSog;
import it.csi.iscritto.serviscritto.business.integration.exception.DaoException;

public interface DecodificaDao {

	IscrittoDStatoDom findIscrittoDStatoDomByKey(Long idStatoDomanda) throws DaoException;

	IscrittoDStatoDom findIscrittoDStatoDomByCod(String codStatoDomanda) throws DaoException;

	IscrittoDCoabitazione findIscrittoDCoabitazioneByKey(Long idCoabitazione) throws DaoException;

	IscrittoDCoabitazione findIscrittoDCoabitazioneByCod(String codCoabitazione) throws DaoException;

	IscrittoDRelazionePar findIscrittoDRelazioneParByKey(Long idRelParentela) throws DaoException;

	IscrittoDRelazionePar findIscrittoDRelazioneParByCod(String codParentela) throws DaoException;

	IscrittoDTipConOcc findIscrittoDTipConOccByKey(Long idTipCondOccupazionale) throws DaoException;

	IscrittoDTipConOcc findIscrittoDTipConOccByCod(String codTipCondOccupazionale) throws DaoException;

	IscrittoDTipoAll findIscrittoDTipoAllByKey(Long idTipoAllegato) throws DaoException;

	IscrittoDTipoAll findIscrittoDTipoAllByCodTipo(String codTipoAllegato) throws DaoException;

	List<IscrittoDTipoAll> findAllIscrittoDTipoAll() throws DaoException;

	IscrittoDOrdineScuola findIscrittoDOrdineScuolaByKey(Long idOrdineScuola) throws DaoException;

	IscrittoDOrdineScuola findIscrittoDOrdineScuolaByCod(String codOrdineScuola) throws DaoException;

	IscrittoDTipoSog findIscrittoDTipoSogByCod(String codTipoSoggetto) throws DaoException;

	IscrittoDTipoPre findIscrittoDTipoPreByKey(Long idTipoPresentazione) throws DaoException;

	IscrittoDTipoPre findIscrittoDTipoPreByCod(String codTipoPresentazione) throws DaoException;

	IscrittoDCircoscrizione findIscrittoDCircoscrizioneByKey(Long idCircoscrizione) throws DaoException;

	IscrittoDCircoscrizione findIscrittoDCircoscrizioneByCod(String codCircoscrizione) throws DaoException;

	IscrittoDGenitoreSol findIscrittoDGenitoreSolByKey(Long idTipoGenitoreSolo) throws DaoException;

	IscrittoDGenitoreSol findIscrittoDGenitoreSolByCod(String codTipoGenitoreSolo) throws DaoException;

	IscrittoDTipoFra findIscrittoDTipoFraByKey(Long idTipoFratello) throws DaoException;

	IscrittoDTipoFra findIscrittoDTipoFraByCod(String codTipoFratello) throws DaoException;

	IscrittoDTipoCambioRes findIscrittoDTipoCambioResByKey(Long idTipoCambioRes) throws DaoException;

	IscrittoDTipoCambioRes findIscrittoDTipoCambioResByCod(String codTipoCambioRes) throws DaoException;

	IscrittoDTipoFre findIscrittoDTipoFreByCod(String codTipoFrequenza) throws DaoException;

	IscrittoDCategoriaScu findIscrittoDCategoriaScuByKey(Long idCategoriaScu) throws DaoException;

	IscrittoDTipoFre findIscrittoDTipoFreByKey(Long idTipoFrequenza) throws DaoException;

	IscrittoDTipoCorso findIscrittoDTipoCorsoByKey(Long idTipoCorso) throws DaoException;

	IscrittoDTipoCorso findIscrittoDTipoCorsoByCod(String codTipoCorso) throws DaoException;

	IscrittoDStatoScu findIscrittoDStatoScuByKey(Long idStatoScu) throws DaoException;

	IscrittoDStatoGra findIscrittoDStatoGraByKey(Long idStatoGra) throws DaoException;

}
