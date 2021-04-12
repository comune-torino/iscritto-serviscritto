package it.csi.iscritto.serviscritto.business.integration.converter.nido;

import static it.csi.iscritto.serviscritto.business.util.converter.ConvertUtils.fromSN;

import java.io.Serializable;
import java.util.Optional;

import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTDomandaIsc;
import it.csi.iscritto.serviscritto.business.integration.dao.view.dto.SoggettoRow;
import it.csi.iscritto.serviscritto.business.util.converter.AbstractConverter;
import it.csi.iscritto.serviscritto.dto.domanda.Anagrafica;
import it.csi.iscritto.serviscritto.dto.domanda.DatiSoggetto3;
import it.csi.iscritto.serviscritto.dto.domanda.LuogoNascita;
import it.csi.iscritto.serviscritto.dto.domanda.Residenza;
import it.csi.iscritto.serviscritto.dto.domanda.Soggetto3;

public class Soggetto3Converter extends AbstractConverter<Soggetto3Converter.Data, Soggetto3> {

	@Override
	public Soggetto3 convert(Data source) {
		Soggetto3 target = null;
		if (source != null) {
			IscrittoTDomandaIsc domandaIsc = source.getDomandaIsc();
			SoggettoRow soggetto = Optional.ofNullable(source.getSoggetto()).orElse(new SoggettoRow());

			DatiSoggetto3 dati = new DatiSoggetto3();
			dati.setAnagrafica(source.getAnagrafica());
			dati.setLuogoNascita(source.getLuogoNascita());
			dati.setResidenza(source.getResidenza());

			target = new Soggetto3();
			target.setStato(fromSN(domandaIsc.getFlSoggettoTre()));
			target.setResidenzaNao(fromSN(soggetto.getFlResidenzaNao()));
			target.setDati(dati);
		}

		return target;
	}

	public static final Soggetto3 buildEmpty(IscrittoTDomandaIsc domandaIsc) {
		DatiSoggetto3 dati = new DatiSoggetto3();
		dati.setAnagrafica(AnagraficaConverter.buildEmpty());
		dati.setLuogoNascita(LuogoNascitaConverter.buildEmpty());
		dati.setResidenza(ResidenzaConverter.buildEmpty());

		Soggetto3 target = new Soggetto3();
		target.setStato(fromSN(domandaIsc.getFlSoggettoTre()));
		target.setDati(dati);

		return target;
	}

	public static final class Data implements Serializable {
		private static final long serialVersionUID = 1L;
		private IscrittoTDomandaIsc domandaIsc;

		private SoggettoRow soggetto;
		private Anagrafica anagrafica;
		private LuogoNascita luogoNascita;
		private Residenza residenza;

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
	}

}
