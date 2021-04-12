package it.csi.iscritto.serviscritto.business.integration.dao.table;

import java.util.List;

import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTAnagraficaSog;
import it.csi.iscritto.serviscritto.business.integration.exception.DaoException;

public interface AnagraficaSogDao {

	IscrittoTAnagraficaSog findIscrittoTAnagraficaSogByKey(Long idAnagraficaSoggetto) throws DaoException;

	List<IscrittoTAnagraficaSog> findIscrittoTAnagraficaSogByIdDomanda(Long idDomandaIscrizione) throws DaoException;

	Long insertIscrittoTAnagraficaSog(IscrittoTAnagraficaSog row) throws DaoException;

	Integer updateIscrittoTAnagraficaSogForNao(Long idAnagraficaSoggetto, Boolean flResidenzaNao) throws DaoException;

	Integer deleteIscrittoTAnagraficaSog(Long idAnagraficaSoggetto) throws DaoException;

}
