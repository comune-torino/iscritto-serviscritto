package it.csi.iscritto.serviscritto.business.domanda.service;

import it.csi.iscritto.serviscritto.business.integration.dao.custom.GraduatoriaDao;
import it.csi.iscritto.serviscritto.business.integration.dao.table.AffidoDao;
import it.csi.iscritto.serviscritto.business.integration.dao.table.AllegatoDao;
import it.csi.iscritto.serviscritto.business.integration.dao.table.AnagraficaSogDao;
import it.csi.iscritto.serviscritto.business.integration.dao.table.AnnoScoDao;
import it.csi.iscritto.serviscritto.business.integration.dao.table.AuditLogDao;
import it.csi.iscritto.serviscritto.business.integration.dao.table.AutonomoDao;
import it.csi.iscritto.serviscritto.business.integration.dao.table.CambioResDao;
import it.csi.iscritto.serviscritto.business.integration.dao.table.ComuneDao;
import it.csi.iscritto.serviscritto.business.integration.dao.table.CondizioneOccDao;
import it.csi.iscritto.serviscritto.business.integration.dao.table.CondizionePunteggioDao;
import it.csi.iscritto.serviscritto.business.integration.dao.table.CondizioneSanDao;
import it.csi.iscritto.serviscritto.business.integration.dao.table.DecodificaDao;
import it.csi.iscritto.serviscritto.business.integration.dao.table.DipendenteDao;
import it.csi.iscritto.serviscritto.business.integration.dao.table.DisoccupatoDao;
import it.csi.iscritto.serviscritto.business.integration.dao.table.DisoccupatoExDao;
import it.csi.iscritto.serviscritto.business.integration.dao.table.DomandaIscDao;
import it.csi.iscritto.serviscritto.business.integration.dao.table.ErrorLogDao;
import it.csi.iscritto.serviscritto.business.integration.dao.table.FratelloFreDao;
import it.csi.iscritto.serviscritto.business.integration.dao.table.GenitoreSoloDao;
import it.csi.iscritto.serviscritto.business.integration.dao.table.IndirizzoResDao;
import it.csi.iscritto.serviscritto.business.integration.dao.table.IseeDao;
import it.csi.iscritto.serviscritto.business.integration.dao.table.ListaAttesaDao;
import it.csi.iscritto.serviscritto.business.integration.dao.table.ScuolaDao;
import it.csi.iscritto.serviscritto.business.integration.dao.table.ServiziSocDao;
import it.csi.iscritto.serviscritto.business.integration.dao.table.SoggettoRelDao;
import it.csi.iscritto.serviscritto.business.integration.dao.table.StatoDao;
import it.csi.iscritto.serviscritto.business.integration.dao.table.StudenteDao;
import it.csi.iscritto.serviscritto.business.integration.dao.table.TrasferimentoDao;
import it.csi.iscritto.serviscritto.business.integration.dao.table.UtenteDao;
import it.csi.iscritto.serviscritto.business.integration.dao.view.DomandaDao;
import it.csi.iscritto.serviscritto.business.integration.dao.view.ProfilazioneDao;
import it.csi.iscritto.serviscritto.business.integration.dao.view.ScuoleDao;
import it.csi.iscritto.serviscritto.business.integration.dao.view.SoggettoDao;
import it.csi.iscritto.serviscritto.business.integration.dao.view.ValidazioneDao;

public abstract class AbstractDomandaService {
	//////////////////////////////////////////////////////////////////////
	// Tabelle (lettura - scrittura)
	//////////////////////////////////////////////////////////////////////
	protected AffidoDao affidoDao;
	protected AllegatoDao allegatoDao;
	protected AnagraficaSogDao anagraficaSogDao;
	protected AnnoScoDao annoScoDao;
	protected AuditLogDao auditLogDao;
	protected AutonomoDao autonomoDao;
	protected CambioResDao cambioResDao;
	protected CondizioneOccDao condizioneOccDao;
	protected CondizioneSanDao condizioneSanDao;
	protected DipendenteDao dipendenteDao;
	protected DisoccupatoDao disoccupatoDao;
	protected DisoccupatoExDao disoccupatoExDao;
	protected DomandaIscDao domandaIscDao;
	protected ErrorLogDao errorLogDao;
	protected FratelloFreDao fratelloFreDao;
	protected GenitoreSoloDao genitoreSoloDao;
	protected IndirizzoResDao indirizzoResDao;
	protected IseeDao iseeDao;
	protected ScuolaDao scuolaDao;
	protected ServiziSocDao serviziSocDao;
	protected SoggettoRelDao soggettoRelDao;
	protected StudenteDao studenteDao;
	protected TrasferimentoDao trasferimentoDao;

	//////////////////////////////////////////////////////////////////////
	// Tabelle (sola lettura)
	//////////////////////////////////////////////////////////////////////
	protected DecodificaDao decodificaDao;
	protected ComuneDao comuneDao;
	protected StatoDao statoDao;
	// jira isbo-111
	protected UtenteDao utenteDao;
	protected CondizionePunteggioDao condizionePunteggioDao;

	//////////////////////////////////////////////////////////////////////
	// Viste
	//////////////////////////////////////////////////////////////////////
	protected SoggettoDao soggettoDao;
	protected ValidazioneDao validazioneDao;
	protected DomandaDao domandaDao;
	protected ScuoleDao scuoleDao;
	protected ProfilazioneDao profilazioneDao;

	//////////////////////////////////////////////////////////////////////
	// Altro
	//////////////////////////////////////////////////////////////////////
	protected GraduatoriaDao graduatoriaDao;
	protected ListaAttesaDao listaAttesaDao;
	//////////////////////////////////////////////////////////////////////

	public AffidoDao getAffidoDao() {
		return affidoDao;
	}

	public void setAffidoDao(AffidoDao affidoDao) {
		this.affidoDao = affidoDao;
	}

	public AllegatoDao getAllegatoDao() {
		return allegatoDao;
	}

	public void setAllegatoDao(AllegatoDao allegatoDao) {
		this.allegatoDao = allegatoDao;
	}

	public AnagraficaSogDao getAnagraficaSogDao() {
		return anagraficaSogDao;
	}

	public void setAnagraficaSogDao(AnagraficaSogDao anagraficaSogDao) {
		this.anagraficaSogDao = anagraficaSogDao;
	}

	public AnnoScoDao getAnnoScoDao() {
		return annoScoDao;
	}

	public void setAnnoScoDao(AnnoScoDao annoScoDao) {
		this.annoScoDao = annoScoDao;
	}

	public AuditLogDao getAuditLogDao() {
		return auditLogDao;
	}

	public void setAuditLogDao(AuditLogDao auditLogDao) {
		this.auditLogDao = auditLogDao;
	}

	public AutonomoDao getAutonomoDao() {
		return autonomoDao;
	}

	public void setAutonomoDao(AutonomoDao autonomoDao) {
		this.autonomoDao = autonomoDao;
	}

	public CambioResDao getCambioResDao() {
		return cambioResDao;
	}

	public void setCambioResDao(CambioResDao cambioResDao) {
		this.cambioResDao = cambioResDao;
	}

	public CondizioneOccDao getCondizioneOccDao() {
		return condizioneOccDao;
	}

	public void setCondizioneOccDao(CondizioneOccDao condizioneOccDao) {
		this.condizioneOccDao = condizioneOccDao;
	}

	public CondizioneSanDao getCondizioneSanDao() {
		return condizioneSanDao;
	}

	public void setCondizioneSanDao(CondizioneSanDao condizioneSanDao) {
		this.condizioneSanDao = condizioneSanDao;
	}

	public DipendenteDao getDipendenteDao() {
		return dipendenteDao;
	}

	public void setDipendenteDao(DipendenteDao dipendenteDao) {
		this.dipendenteDao = dipendenteDao;
	}

	public DisoccupatoDao getDisoccupatoDao() {
		return disoccupatoDao;
	}

	public void setDisoccupatoDao(DisoccupatoDao disoccupatoDao) {
		this.disoccupatoDao = disoccupatoDao;
	}

	public DisoccupatoExDao getDisoccupatoExDao() {
		return disoccupatoExDao;
	}

	public void setDisoccupatoExDao(DisoccupatoExDao disoccupatoExDao) {
		this.disoccupatoExDao = disoccupatoExDao;
	}

	public DomandaIscDao getDomandaIscDao() {
		return domandaIscDao;
	}

	public void setDomandaIscDao(DomandaIscDao domandaIscDao) {
		this.domandaIscDao = domandaIscDao;
	}

	public ErrorLogDao getErrorLogDao() {
		return errorLogDao;
	}

	public void setErrorLogDao(ErrorLogDao errorLogDao) {
		this.errorLogDao = errorLogDao;
	}

	public FratelloFreDao getFratelloFreDao() {
		return fratelloFreDao;
	}

	public void setFratelloFreDao(FratelloFreDao fratelloFreDao) {
		this.fratelloFreDao = fratelloFreDao;
	}

	public GenitoreSoloDao getGenitoreSoloDao() {
		return genitoreSoloDao;
	}

	public void setGenitoreSoloDao(GenitoreSoloDao genitoreSoloDao) {
		this.genitoreSoloDao = genitoreSoloDao;
	}

	public IndirizzoResDao getIndirizzoResDao() {
		return indirizzoResDao;
	}

	public void setIndirizzoResDao(IndirizzoResDao indirizzoResDao) {
		this.indirizzoResDao = indirizzoResDao;
	}

	public IseeDao getIseeDao() {
		return iseeDao;
	}

	public void setIseeDao(IseeDao iseeDao) {
		this.iseeDao = iseeDao;
	}

	public ScuolaDao getScuolaDao() {
		return scuolaDao;
	}

	public void setScuolaDao(ScuolaDao scuolaDao) {
		this.scuolaDao = scuolaDao;
	}

	public ServiziSocDao getServiziSocDao() {
		return serviziSocDao;
	}

	public void setServiziSocDao(ServiziSocDao serviziSocDao) {
		this.serviziSocDao = serviziSocDao;
	}

	public SoggettoRelDao getSoggettoRelDao() {
		return soggettoRelDao;
	}

	public void setSoggettoRelDao(SoggettoRelDao soggettoRelDao) {
		this.soggettoRelDao = soggettoRelDao;
	}

	public StudenteDao getStudenteDao() {
		return studenteDao;
	}

	public void setStudenteDao(StudenteDao studenteDao) {
		this.studenteDao = studenteDao;
	}

	public TrasferimentoDao getTrasferimentoDao() {
		return trasferimentoDao;
	}

	public void setTrasferimentoDao(TrasferimentoDao trasferimentoDao) {
		this.trasferimentoDao = trasferimentoDao;
	}

	public DecodificaDao getDecodificaDao() {
		return decodificaDao;
	}

	public void setDecodificaDao(DecodificaDao decodificaDao) {
		this.decodificaDao = decodificaDao;
	}

	public ComuneDao getComuneDao() {
		return comuneDao;
	}

	public void setComuneDao(ComuneDao comuneDao) {
		this.comuneDao = comuneDao;
	}

	public StatoDao getStatoDao() {
		return statoDao;
	}

	public void setStatoDao(StatoDao statoDao) {
		this.statoDao = statoDao;
	}

	public UtenteDao getUtenteDao() {
		return utenteDao;
	}

	public void setUtenteDao(UtenteDao utenteDao) {
		this.utenteDao = utenteDao;
	}

	public CondizionePunteggioDao getCondizionePunteggioDao() {
		return condizionePunteggioDao;
	}

	public void setCondizionePunteggioDao(CondizionePunteggioDao condizionePunteggioDao) {
		this.condizionePunteggioDao = condizionePunteggioDao;
	}

	public SoggettoDao getSoggettoDao() {
		return soggettoDao;
	}

	public void setSoggettoDao(SoggettoDao soggettoDao) {
		this.soggettoDao = soggettoDao;
	}

	public ValidazioneDao getValidazioneDao() {
		return validazioneDao;
	}

	public void setValidazioneDao(ValidazioneDao validazioneDao) {
		this.validazioneDao = validazioneDao;
	}

	public DomandaDao getDomandaDao() {
		return domandaDao;
	}

	public void setDomandaDao(DomandaDao domandaDao) {
		this.domandaDao = domandaDao;
	}

	public ScuoleDao getScuoleDao() {
		return scuoleDao;
	}

	public void setScuoleDao(ScuoleDao scuoleDao) {
		this.scuoleDao = scuoleDao;
	}

	public ProfilazioneDao getProfilazioneDao() {
		return profilazioneDao;
	}

	public void setProfilazioneDao(ProfilazioneDao profilazioneDao) {
		this.profilazioneDao = profilazioneDao;
	}

	public GraduatoriaDao getGraduatoriaDao() {
		return graduatoriaDao;
	}

	public void setGraduatoriaDao(GraduatoriaDao graduatoriaDao) {
		this.graduatoriaDao = graduatoriaDao;
	}

	public ListaAttesaDao getListaAttesaDao() {
		return listaAttesaDao;
	}

	public void setListaAttesaDao(ListaAttesaDao listaAttesaDao) {
		this.listaAttesaDao = listaAttesaDao;
	}

}
