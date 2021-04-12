package it.csi.iscritto.serviscritto.business.integration.converter.nido;

import static it.csi.iscritto.serviscritto.business.util.converter.ConvertUtils.fromSN;

import java.io.Serializable;
import java.util.Optional;

import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTDomandaIsc;
import it.csi.iscritto.serviscritto.business.integration.dao.view.dto.SoggettoRow;
import it.csi.iscritto.serviscritto.business.util.converter.AbstractConverter;
import it.csi.iscritto.serviscritto.dto.domanda.Anagrafica;
import it.csi.iscritto.serviscritto.dto.domanda.Disabilita;
import it.csi.iscritto.serviscritto.dto.domanda.FratelloFrequentante;
import it.csi.iscritto.serviscritto.dto.domanda.FratelloNidoContiguo;
import it.csi.iscritto.serviscritto.dto.domanda.ListaAttesa;
import it.csi.iscritto.serviscritto.dto.domanda.LuogoNascita;
import it.csi.iscritto.serviscritto.dto.domanda.Minore;
import it.csi.iscritto.serviscritto.dto.domanda.ProblemiSalute;
import it.csi.iscritto.serviscritto.dto.domanda.Residenza;
import it.csi.iscritto.serviscritto.dto.domanda.ServiziSociali;
import it.csi.iscritto.serviscritto.dto.domanda.Spostamento;
import it.csi.iscritto.serviscritto.dto.domanda.Trasferimento;

public class MinoreConverter extends AbstractConverter<MinoreConverter.Data, Minore> {

	@Override
	public Minore convert(Data source) {
		Minore target = null;
		if (source != null) {
			IscrittoTDomandaIsc domandaIsc = source.getDomandaIsc();
			SoggettoRow soggetto = Optional.ofNullable(source.getSoggetto()).orElse(new SoggettoRow());

			target = new Minore();
			target.setPresenzaNucleo(fromSN(domandaIsc.getFlMinorePreNuc()));
			target.setResidenzaConRichiedente(fromSN(domandaIsc.getFlResConRic()));
			target.setId(soggetto.getIdAnagraficaSoggetto());
			target.setResidenzaNao(fromSN(soggetto.getFlResidenzaNao()));
			target.setCinqueAnniNonFrequentante(domandaIsc.getFlCinqueAnni());

			// gestiti esternamente
			target.setAnagrafica(source.getAnagrafica());
			target.setLuogoNascita(source.getLuogoNascita());
			target.setResidenza(source.getResidenza());
			target.setDisabilita(source.getDisabilita());
			target.setServiziSociali(source.getServiziSociali());
			target.setProblemiSalute(source.getProblemiSalute());
			target.setFratelloFrequentante(source.getFratelloFrequentante());
			target.setTrasferimento(source.getTrasferimento());
			target.setSpostamento(source.getSpostamento());
			target.setListaAttesa(source.getListaAttesa());
			target.setFratelloNidoContiguo(source.getFratelloNidoContiguo());
		}

		return target;
	}

	public static final class Data implements Serializable {
		private static final long serialVersionUID = 1L;
		private IscrittoTDomandaIsc domandaIsc;
		private SoggettoRow soggetto;

		private Anagrafica anagrafica;
		private LuogoNascita luogoNascita;
		private Residenza residenza;
		private Disabilita disabilita;
		private ServiziSociali serviziSociali;
		private ProblemiSalute problemiSalute;
		private FratelloFrequentante fratelloFrequentante;
		private Trasferimento trasferimento;
		private Spostamento spostamento;
		private ListaAttesa listaAttesa;
		private FratelloNidoContiguo fratelloNidoContiguo;

		public IscrittoTDomandaIsc getDomandaIsc() {
			return domandaIsc;
		}

		public void setDomandaIsc(IscrittoTDomandaIsc domandaIsc) {
			this.domandaIsc = domandaIsc;
		}

		public SoggettoRow getSoggetto() {
			return soggetto;
		}

		public void setSoggetto(SoggettoRow soggetto) {
			this.soggetto = soggetto;
		}

		public Anagrafica getAnagrafica() {
			return anagrafica;
		}

		public void setAnagrafica(Anagrafica anagrafica) {
			this.anagrafica = anagrafica;
		}

		public LuogoNascita getLuogoNascita() {
			return luogoNascita;
		}

		public void setLuogoNascita(LuogoNascita luogoNascita) {
			this.luogoNascita = luogoNascita;
		}

		public Residenza getResidenza() {
			return residenza;
		}

		public void setResidenza(Residenza residenza) {
			this.residenza = residenza;
		}

		public Disabilita getDisabilita() {
			return disabilita;
		}

		public void setDisabilita(Disabilita disabilita) {
			this.disabilita = disabilita;
		}

		public ServiziSociali getServiziSociali() {
			return serviziSociali;
		}

		public void setServiziSociali(ServiziSociali serviziSociali) {
			this.serviziSociali = serviziSociali;
		}

		public ProblemiSalute getProblemiSalute() {
			return problemiSalute;
		}

		public void setProblemiSalute(ProblemiSalute problemiSalute) {
			this.problemiSalute = problemiSalute;
		}

		public FratelloFrequentante getFratelloFrequentante() {
			return fratelloFrequentante;
		}

		public void setFratelloFrequentante(FratelloFrequentante fratelloFrequentante) {
			this.fratelloFrequentante = fratelloFrequentante;
		}

		public Trasferimento getTrasferimento() {
			return trasferimento;
		}

		public void setTrasferimento(Trasferimento trasferimento) {
			this.trasferimento = trasferimento;
		}

		public Spostamento getSpostamento() {
			return spostamento;
		}

		public void setSpostamento(Spostamento spostamento) {
			this.spostamento = spostamento;
		}

		public ListaAttesa getListaAttesa() {
			return listaAttesa;
		}

		public void setListaAttesa(ListaAttesa listaAttesa) {
			this.listaAttesa = listaAttesa;
		}

		public FratelloNidoContiguo getFratelloNidoContiguo() {
			return fratelloNidoContiguo;
		}

		public void setFratelloNidoContiguo(FratelloNidoContiguo fratelloNidoContiguo) {
			this.fratelloNidoContiguo = fratelloNidoContiguo;
		}
	}

}
