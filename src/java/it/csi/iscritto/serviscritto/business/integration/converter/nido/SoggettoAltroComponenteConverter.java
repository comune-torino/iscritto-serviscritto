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
import it.csi.iscritto.serviscritto.dto.domanda.Residenza;
import it.csi.iscritto.serviscritto.dto.domanda.SoggettoAltroComponente;

public class SoggettoAltroComponenteConverter extends AbstractConverter<SoggettoAltroComponenteConverter.Data, SoggettoAltroComponente> {

	@Override
	public SoggettoAltroComponente convert(Data source) {
		SoggettoAltroComponente target = null;
		if (source != null && source.getSoggetto() != null) {
			SoggettoRow soggetto = source.getSoggetto();
			IscrittoDRelazionePar decRelazionePar = Optional.ofNullable(source.getDecRelazionePar()).orElse(new IscrittoDRelazionePar());

			target = new SoggettoAltroComponente();
			target.setId(soggetto.getIdAnagraficaSoggetto());
			target.setResidenzaNao(fromSN(soggetto.getFlResidenzaNao()));
			target.setRelazioneConMinore(decRelazionePar.getCodParentela());

			// gestiti esternamente
			target.setAnagrafica(source.getAnagrafica());
			target.setLuogoNascita(source.getLuogoNascita());
			target.setResidenza(source.getResidenza());
			target.setProblemiSalute(source.getProblemiSalute());
		}

		return target;
	}

	public static final SoggettoAltroComponente buildEmpty() {
		SoggettoAltroComponente target = new SoggettoAltroComponente();

		target.setAnagrafica(AnagraficaConverter.buildEmpty());
		target.setLuogoNascita(LuogoNascitaConverter.buildEmpty());
		target.setResidenza(ResidenzaConverter.buildEmpty());
		target.setProblemiSalute(CondizioneSanitariaConverter.buildEmpty().getProblemiSalute());

		return target;
	}

	public static final class Data implements Serializable {
		private static final long serialVersionUID = 1L;

		private IscrittoDRelazionePar decRelazionePar;
		private SoggettoRow soggetto;

		private Anagrafica anagrafica;
		private LuogoNascita luogoNascita;
		private Residenza residenza;
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

		public Residenza getResidenza() {
			return residenza;
		}

		public void setResidenza(Residenza residenza) {
			this.residenza = residenza;
		}

		public ProblemiSalute getProblemiSalute() {
			return problemiSalute;
		}

		public void setProblemiSalute(ProblemiSalute problemiSalute) {
			this.problemiSalute = problemiSalute;
		}
	}

}
