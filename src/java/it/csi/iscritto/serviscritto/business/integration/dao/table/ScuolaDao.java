package it.csi.iscritto.serviscritto.business.integration.dao.table;

import java.util.List;

import it.csi.iscritto.serviscritto.business.integration.dao.TipoScuola;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoRScuolaPre;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTScuola;
import it.csi.iscritto.serviscritto.business.integration.exception.DaoException;

public interface ScuolaDao {

	IscrittoTScuola findIscrittoTScuolaByKey(Long idScuola) throws DaoException;

	IscrittoTScuola findIscrittoTScuolaByCod(TipoScuola tipoScuola, String codScuola) throws DaoException;

	List<IscrittoRScuolaPre> findIscrittoRScuolaPreByFk(Long idDomandaIscrizione) throws DaoException;

	void insertIscrittoRScuolaPre(IscrittoRScuolaPre row) throws DaoException;

	Integer deleteIscrittoRScuolaPreByFk(Long idDomandaIscrizione) throws DaoException;

	Integer updateFlagFuoriTermine(Long idDomandaIscrizione, boolean flag) throws DaoException;

	Integer annullaPreferenze(Long idDomandaIscrizione) throws DaoException;

}
