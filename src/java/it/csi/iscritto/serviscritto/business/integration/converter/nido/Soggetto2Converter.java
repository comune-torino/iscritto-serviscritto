package it.csi.iscritto.serviscritto.business.integration.converter.nido;

import static it.csi.iscritto.serviscritto.business.util.converter.ConvertUtils.fromSN;

import java.io.Serializable;
import java.util.Optional;

import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTDomandaIsc;
import it.csi.iscritto.serviscritto.business.integration.dao.view.dto.SoggettoRow;
import it.csi.iscritto.serviscritto.business.util.converter.AbstractConverter;
import it.csi.iscritto.serviscritto.dto.domanda.Anagrafica;
import it.csi.iscritto.serviscritto.dto.domanda.CondizioneOccupazionale;
import it.csi.iscritto.serviscritto.dto.domanda.Gravidanza;
import it.csi.iscritto.serviscritto.dto.domanda.LuogoNascita;
import it.csi.iscritto.serviscritto.dto.domanda.ProblemiSalute;
import it.csi.iscritto.serviscritto.dto.domanda.Residenza;
import it.csi.iscritto.serviscritto.dto.domanda.Soggetto2;

public class Soggetto2Converter extends AbstractConverter<Soggetto2Converter.Data, Soggetto2> {

	@Override
	public Soggetto2 convert(Data source) {
		Soggetto2 target = null;
		if (source != null) {
			IscrittoTDomandaIsc domandaIsc = source.getDomandaIsc();
			SoggettoRow soggetto = Optional.ofNullable(source.getSoggetto()).orElse(new SoggettoRow());

			target = new Soggetto2();
			target.setId(soggetto.getIdAnagraficaSoggetto());
			target.setPresenzaNucleo(fromSN(domandaIsc.getFlGenitoreDuePreNuc()));
			target.setResidenzaNao(fromSN(soggetto.getFlResidenzaNao()));

			// gestiti esternamente
			target.setAnagrafica(source.getAnagrafica());
			target.setLuogoNascita(source.getLuogoNascita());
			target.setResidenza(source.getResidenza());
			target.setGravidanza(source.getGravidanza());
			target.setProblemiSalute(source.getProblemiSalute());
			target.setCondizioneOccupazionale(source.getCondizioneOccupazionale());
		}

		return target;
	}

	public static final Soggetto2 buildEmpty() {
		Soggetto2 target = new Soggetto2();
		target.setAnagrafica(AnagraficaConverter.buildEmpty());
		target.setLuogoNascita(LuogoNascitaConverter.buildEmpty());
		target.setResidenza(ResidenzaConverter.buildEmpty());
		target.setGravidanza(CondizioneSanitariaConverter.buildEmpty().getGravidanza());
		target.setProblemiSalute(CondizioneSanitariaConverter.buildEmpty().getProblemiSalute());
		target.setCondizioneOccupazionale(CondizioneOccupazionaleConverter.buildEmpty());

		return target;
	}

	public static final class Data implements Serializable {
		private static final long serialVersionUID = 1L;
		private IscrittoTDomandaIsc domandaIsc;
		private SoggettoRow soggetto;

		private Anagrafica anagrafica;
		private LuogoNascita luogoNascita;
		private Residenza residenza;
		private Gravidanza gravidanza;
		private ProblemiSalute problemiSalute;
		private CondizioneOccupazionale condizioneOccupazionale;

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

		public Gravidanza getGravidanza() {
			return gravidanza;
		}

		public void setGravidanza(Gravidanza gravidanza) {
			this.gravidanza = gravidanza;
		}

		public ProblemiSalute getProblemiSalute() {
			return problemiSalute;
		}

		public void setProblemiSalute(ProblemiSalute problemiSalute) {
			this.problemiSalute = problemiSalute;
		}

		public CondizioneOccupazionale getCondizioneOccupazionale() {
			return condizioneOccupazionale;
		}

		public void setCondizioneOccupazionale(CondizioneOccupazionale condizioneOccupazionale) {
			this.condizioneOccupazionale = condizioneOccupazionale;
		}
	}

}
