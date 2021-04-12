package it.csi.iscritto.serviscritto.business.integration.converter.nido;

import static it.csi.iscritto.serviscritto.business.util.converter.ConvertUtils.fromSN;

import java.io.Serializable;
import java.util.Optional;

import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoDRelazionePar;
import it.csi.iscritto.serviscritto.business.integration.dao.view.dto.SoggettoRow;
import it.csi.iscritto.serviscritto.business.util.converter.AbstractConverter;
import it.csi.iscritto.serviscritto.dto.domanda.Anagrafica;
import it.csi.iscritto.serviscritto.dto.domanda.LuogoNascita;
import it.csi.iscritto.serviscritto.dto.domanda.ProblemiSalute;
import it.csi.iscritto.serviscritto.dto.domanda.SoggettoNucleo;

public class SoggettoNucleoConverter extends AbstractConverter<SoggettoNucleoConverter.Data, SoggettoNucleo> {

	@Override
	public SoggettoNucleo convert(Data source) {
		SoggettoNucleo target = null;
		if (source != null && source.getSoggetto() != null) {
			SoggettoRow soggetto = source.getSoggetto();
			IscrittoDRelazionePar decRelazionePar = Optional.ofNullable(source.getDecRelazionePar()).orElse(new IscrittoDRelazionePar());

			target = new SoggettoNucleo();
			target.setId(soggetto.getIdAnagraficaSoggetto());
			target.setResidenzaNao(fromSN(soggetto.getFlResidenzaNao()));
			target.setRelazioneConMinore(decRelazionePar.getCodParentela());

			// gestiti esternamente
			target.setAnagrafica(source.getAnagrafica());
			target.setLuogoNascita(source.getLuogoNascita());
			target.setProblemiSalute(source.getProblemiSalute());
		}

		return target;
	}

	public static final SoggettoNucleo buildEmpty() {
		SoggettoNucleo target = new SoggettoNucleo();

		target.setAnagrafica(AnagraficaConverter.buildEmpty());
		target.setLuogoNascita(LuogoNascitaConverter.buildEmpty());
		target.setProblemiSalute(CondizioneSanitariaConverter.buildEmpty().getProblemiSalute());

		return target;
	}

	public static final class Data implements Serializable {
		private static final long serialVersionUID = 1L;

		private IscrittoDRelazionePar decRelazionePar;
		private SoggettoRow soggetto;

		private Anagrafica anagrafica;
		private LuogoNascita luogoNascita;
		private ProblemiSalute problemiSalute;

		public IscrittoDRelazionePar getDecRelazionePar() {
			return decRelazionePar;
		}

		public void setDecRelazionePar(IscrittoDRelazionePar decRelazionePar) {
			this.decRelazionePar = decRelazionePar;
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

		public ProblemiSalute getProblemiSalute() {
			return problemiSalute;
		}

		public void setProblemiSalute(ProblemiSalute problemiSalute) {
			this.problemiSalute = problemiSalute;
		}
	}

}
