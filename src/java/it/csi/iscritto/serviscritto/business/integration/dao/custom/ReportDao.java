package it.csi.iscritto.serviscritto.business.integration.dao.custom;

import java.util.List;

import it.csi.iscritto.serviscritto.business.integration.dao.TipoScuola;
import it.csi.iscritto.serviscritto.business.integration.dao.custom.dto.GraduatoriaApprovazioneRow;
import it.csi.iscritto.serviscritto.business.integration.dao.custom.dto.GraduatoriaCompletaRow;
import it.csi.iscritto.serviscritto.business.integration.dao.custom.dto.ReportDomandeScuolaResidenzaRow;
import it.csi.iscritto.serviscritto.business.integration.dao.custom.dto.ReportPostiLiberiRow;
import it.csi.iscritto.serviscritto.business.integration.dao.custom.dto.ResidenzaForzataRow;
import it.csi.iscritto.serviscritto.business.integration.exception.DaoException;

public interface ReportDao {

	List<ResidenzaForzataRow> findResidenzeForzate(Long idStepGraCon) throws DaoException;

	List<GraduatoriaCompletaRow> findGraduatoriaCompleta(TipoScuola tipoScuola, Long idStepGraCon) throws DaoException;

	List<GraduatoriaApprovazioneRow> findGraduatoriaApprovazione(TipoScuola tipoScuola, String codAnagraficaGra, Integer step, String codStatoGra)
			throws DaoException;

	List<ReportPostiLiberiRow> findPostiLiberi(String codOrdineScuola) throws DaoException;

	List<ReportDomandeScuolaResidenzaRow> findDomandeScuolaResidenza() throws DaoException;

}
