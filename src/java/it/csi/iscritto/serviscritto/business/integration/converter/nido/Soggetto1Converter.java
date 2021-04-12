package it.csi.iscritto.serviscritto.business.integration.converter.nido;

import static it.csi.iscritto.serviscritto.business.util.converter.ConvertUtils.fromSN;

import java.io.Serializable;
import java.util.Optional;

import it.csi.iscritto.serviscritto.business.integration.dao.view.dto.SoggettoRow;
import it.csi.iscritto.serviscritto.business.util.converter.AbstractConverter;
import it.csi.iscritto.serviscritto.dto.domanda.Anagrafica;
import it.csi.iscritto.serviscritto.dto.domanda.CondizioneOccupazionale;
import it.csi.iscritto.serviscritto.dto.domanda.GenitoreSolo;
import it.csi.iscritto.serviscritto.dto.domanda.Gravidanza;
import it.csi.iscritto.serviscritto.dto.domanda.LuogoNascita;
import it.csi.iscritto.serviscritto.dto.domanda.ProblemiSalute;
import it.csi.iscritto.serviscritto.dto.domanda.Residenza;
import it.csi.iscritto.serviscritto.dto.domanda.Soggetto1;

public class Soggetto1Converter extends AbstractConverter<Soggetto1Converter.Data, Soggetto1> {

	@Override
	public Soggetto1 convert(Data source) {
		Soggetto1 target = null;
		if (source != null) {
			SoggettoRow soggetto = Optional.ofNullable(source.getSoggetto()).orElse(new SoggettoRow());

			target = new Soggetto1();
			target.setId(soggetto.getIdAnagraficaSoggetto());
			target.setResidenzaNao(fromSN(soggetto.getFlResidenzaNao()));

			// gestiti esternamente
			target.setAnagrafica(source.getAnagrafica());
			target.setCondizioneOccupazionale(source.getCondizioneOccupazionale());
			target.setGravidanza(source.getGravidanza());
			target.setLuogoNascita(source.getLuogoNascita());
			target.setResidenza(source.getResidenza());
			target.setProblemiSalute(source.getProblemiSalute());
			target.setGenitoreSolo(source.getGenitoreSolo());
		}

		return target;
	}

	public static final Soggetto1 buildEmpty() {
		Soggetto1 target = new Soggetto1();
		target.setAnagrafica(AnagraficaConverter.buildEmpty());
		target.setCondizioneOccupazionale(CondizioneOccupazionaleConverter.buildEmpty());
		target.setGravidanza(CondizioneSanitariaConverter.buildEmpty().getGravidanza());
		target.setLuogoNascita(LuogoNascitaConverter.buildEmpty());
		target.setResidenza(ResidenzaConverter.buildEmpty());
		target.setProblemiSalute(CondizioneSanitariaConverter.buildEmpty().getProblemiSalute());
		target.setGenitoreSolo(GenitoreSoloConverter.buildEmpty());

		return target;
	}

	public static final class Data implements Serializable {
		private static final long serialVersionUID = 1L;
		private SoggettoRow soggetto;

		private Anagrafica anagrafica;
		private LuogoNascita luogoNascita;
		private Residenza residenza;
		private Gravidanza gravidanza;
		private ProblemiSalute problemiSalute;
		private CondizioneOccupazionale condizioneOccupazionale;
		private GenitoreSolo genitoreSolo;

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

		public GenitoreSolo getGenitoreSolo() {
			return genitoreSolo;
		}

		public void setGenitoreSolo(GenitoreSolo genitoreSolo) {
			this.genitoreSolo = genitoreSolo;
		}
	}

}
