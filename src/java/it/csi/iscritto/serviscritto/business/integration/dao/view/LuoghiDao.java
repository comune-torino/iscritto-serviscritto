package it.csi.iscritto.serviscritto.business.integration.dao.view;

import java.util.Date;
import java.util.List;

import it.csi.iscritto.serviscritto.business.integration.dao.view.dto.LuogoRow;
import it.csi.iscritto.serviscritto.business.integration.exception.DaoException;

public interface LuoghiDao {

	List<LuogoRow> findStatiAttiviAllaData(Date data) throws DaoException;

	List<LuogoRow> findRegioniAttiveAllaData(Date data) throws DaoException;

	List<LuogoRow> findProvinceAttiveAllaData(Date data, String istatRegione) throws DaoException;

	List<LuogoRow> findComuniAttiviAllaData(Date data, String istatProvincia) throws DaoException;

	List<LuogoRow> findByIstatComuneAllaData(Date data, String istatComune) throws DaoException;

	LuogoRow findByIstatStatoAllaData(Date data, String istatStato) throws DaoException;

}
