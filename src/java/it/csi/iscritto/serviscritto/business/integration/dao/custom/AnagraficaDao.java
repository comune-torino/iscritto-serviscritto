package it.csi.iscritto.serviscritto.business.integration.dao.custom;

import java.util.List;

import it.csi.iscritto.serviscritto.business.integration.dao.TipoScuola;
import it.csi.iscritto.serviscritto.business.integration.dao.custom.dto.AnagraficaEtaRow;
import it.csi.iscritto.serviscritto.business.integration.dao.custom.dto.AnagraficaGraduatoriaRow;
import it.csi.iscritto.serviscritto.business.integration.dao.custom.dto.AnagraficaStepGraduatoriaRow;
import it.csi.iscritto.serviscritto.business.integration.dao.custom.dto.TipoFasciaEtaRow;
import it.csi.iscritto.serviscritto.business.integration.exception.DaoException;
import it.csi.iscritto.serviscritto.exception.domanda.ValidationException;

public interface AnagraficaDao {

	List<AnagraficaGraduatoriaRow> findAnagraficaGraduatorie() throws DaoException;

	AnagraficaGraduatoriaRow findAnagraficaGraduatoria(TipoScuola tipoScuola, String codAnagraficaGra, String codAnnoScolastico) throws DaoException;

	Long insertAnagraficaGraduatoria(AnagraficaGraduatoriaRow row) throws DaoException, ValidationException;

	Integer updateAnagraficaGraduatoria(AnagraficaGraduatoriaRow row) throws DaoException, ValidationException;

	List<AnagraficaStepGraduatoriaRow> findElencoAnagraficaStepGraduatoria(TipoScuola tipoScuola, String codAnagraficaGra, String codAnnoScolastico)
			throws DaoException, ValidationException;

	Long insertAnagraficaStepGraduatoria(AnagraficaStepGraduatoriaRow row) throws DaoException, ValidationException;

	Integer updateAnagraficaStepGraduatoria(AnagraficaStepGraduatoriaRow row) throws DaoException, ValidationException;

	Integer deleteAnagraficaStepGraduatoria(Long idStepGra) throws DaoException, ValidationException;

	List<AnagraficaEtaRow> findAnagraficaEta(TipoScuola tipoScuola, String codAnagraficaGra, String codAnnoScolastico) throws DaoException;

	List<TipoFasciaEtaRow> findTipiFasceEta() throws DaoException;

	Long insertAnagraficaEta(AnagraficaEtaRow row) throws DaoException, ValidationException;

	Integer updateAnagraficaEta(AnagraficaEtaRow row) throws DaoException, ValidationException;

	Integer deleteAnagraficaEta(Long idEta) throws DaoException, ValidationException;

}
