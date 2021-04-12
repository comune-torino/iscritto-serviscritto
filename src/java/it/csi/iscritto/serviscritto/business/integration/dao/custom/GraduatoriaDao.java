package it.csi.iscritto.serviscritto.business.integration.dao.custom;

import java.util.List;

import it.csi.iscritto.serviscritto.business.integration.dao.ResultDao;
import it.csi.iscritto.serviscritto.business.integration.dao.StatoGraduatoria;
import it.csi.iscritto.serviscritto.business.integration.dao.TipoScuola;
import it.csi.iscritto.serviscritto.business.integration.dao.TipoVerificheIstruttoria;
import it.csi.iscritto.serviscritto.business.integration.dao.custom.dto.AnagraficaGraduatoriaRow;
import it.csi.iscritto.serviscritto.business.integration.dao.custom.dto.ClasseRow;
import it.csi.iscritto.serviscritto.business.integration.dao.custom.dto.InfoStepGraduatoriaRow;
import it.csi.iscritto.serviscritto.business.integration.dao.custom.dto.InfoVerificheRow;
import it.csi.iscritto.serviscritto.business.integration.dao.custom.dto.NidoRow;
import it.csi.iscritto.serviscritto.business.integration.dao.custom.dto.PreferenzaScuolaRow;
import it.csi.iscritto.serviscritto.business.integration.dao.custom.dto.TestataGraduatoriaRow;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTAnagraficaGra;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTAnnoSco;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTDomandaIsc;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTStepGra;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTStepGraCon;
import it.csi.iscritto.serviscritto.business.integration.exception.DaoException;
import it.csi.iscritto.serviscritto.dto.domanda.ClasseParam;
import it.csi.iscritto.serviscritto.dto.domanda.RicercaGraduatorieFilter;
import it.csi.iscritto.serviscritto.exception.domanda.ValidationException;

public interface GraduatoriaDao {

	List<IscrittoTAnagraficaGra> findUltimaGraduatoria(TipoScuola tipoScuola) throws DaoException;

	List<IscrittoTAnagraficaGra> findGraduatoria(TipoScuola tipoScuola, String codAnagraficaGra) throws DaoException;

	IscrittoTStepGra findStepGraduatoria(Long idAnagraficaGra) throws DaoException;

	IscrittoTStepGraCon findStepGraduatoriaCon(Long idStepGra) throws DaoException;

	List<AnagraficaGraduatoriaRow> findElencoGraduatorie(TipoScuola tipoScuola) throws DaoException;

	List<IscrittoTStepGra> findElencoStepGraduatoria(TipoScuola tipoScuola, String codAnagraficaGra) throws DaoException;

	List<InfoStepGraduatoriaRow> findInfoStepGraduatorie(TipoScuola tipoScuola) throws DaoException;

	List<TestataGraduatoriaRow> findGraduatorie(RicercaGraduatorieFilter filter) throws DaoException;

	List<IscrittoTDomandaIsc> findDomandeNonIstruite(TipoScuola tipoScuola) throws DaoException;

	List<InfoVerificheRow> findInfoVerifiche(List<Long> idDomande, TipoVerificheIstruttoria tipoVerificheIstruttoria) throws DaoException;

	List<IscrittoTAnnoSco> findAnniScolastici() throws DaoException;

	List<ClasseRow> findClassi(TipoScuola tipoScuola, String codScuola, String codAnnoScolastico) throws DaoException;

	List<NidoRow> findElencoNidi(Long idDomanda) throws DaoException;

	boolean canDeleteClasse(Long idClasse) throws DaoException;

	Long insertClasse(TipoScuola tipoScuola, ClasseParam classe) throws DaoException;

	Integer updateClasse(TipoScuola tipoScuola, ClasseParam classe) throws DaoException;

	Integer deleteClasse(Long idClasse) throws DaoException;

	Integer updateFlagAmmissioni(List<Long> idClasseList, Boolean value) throws DaoException;

	void calcolaGraduatoria(TipoScuola tipoScuola, String codGraduatoria, StatoGraduatoria statoAttuale, StatoGraduatoria statoDaCalcolare, Integer step)
			throws DaoException, ValidationException;

	Integer annullaPreferenze(Long idDomandaIscrizione) throws DaoException;

	List<PreferenzaScuolaRow> findPreferenzeScuole(Long idAnagraficaGra, Long idDomanda) throws DaoException;

	ResultDao updateStatoScuolaPreferenza(Long idGraduatoria, Long idStatoAttuale, Long idStatoRipristino) throws DaoException, ValidationException;

	String findFlagBloccoGraduatoria(TipoScuola tipoScuola)throws DaoException;

	void updateFlagBloccoGraduatoria(TipoScuola tipoScuola, Boolean value)throws DaoException;

}
