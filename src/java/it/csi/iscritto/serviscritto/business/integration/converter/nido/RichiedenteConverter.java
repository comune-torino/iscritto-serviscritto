package it.csi.iscritto.serviscritto.business.integration.converter.nido;

import static it.csi.iscritto.serviscritto.business.util.converter.ConvertUtils.fromSN;

import java.io.Serializable;
import java.util.Optional;

import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoDCoabitazione;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoDRelazionePar;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTDomandaIsc;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTTrasferimento;
import it.csi.iscritto.serviscritto.business.integration.dao.view.dto.SoggettoRow;
import it.csi.iscritto.serviscritto.business.util.converter.AbstractConverter;
import it.csi.iscritto.serviscritto.dto.domanda.Anagrafica;
import it.csi.iscritto.serviscritto.dto.domanda.LuogoNascita;
import it.csi.iscritto.serviscritto.dto.domanda.Residenza;
import it.csi.iscritto.serviscritto.dto.domanda.Richiedente;

public class RichiedenteConverter extends AbstractConverter<RichiedenteConverter.Data, Richiedente> {

	@Override
	public Richiedente convert(Data source) {
		Richiedente target = null;
		if (source != null) {
			IscrittoTDomandaIsc domandaIsc = source.getDomandaIsc();
			IscrittoDCoabitazione decCoabitazione = Optional.ofNullable(source.getDecCoabitazione()).orElse(new IscrittoDCoabitazione());
			IscrittoDRelazionePar decRelazionePar = Optional.ofNullable(source.getDecRelazionePar()).orElse(new IscrittoDRelazionePar());
			IscrittoTTrasferimento trasferimento = Optional.ofNullable(source.getTrasferimento()).orElse(new IscrittoTTrasferimento());
			SoggettoRow soggetto = Optional.ofNullable(source.getSoggetto()).orElse(new SoggettoRow());

			target = new Richiedente();

			target.setCondizioneCoabitazione(decCoabitazione.getCodCoabitazione());
			target.setEmail(domandaIsc.getEmail());
			target.setTelefono(domandaIsc.getTelefono());

			target.setRecapitoNoResidenza(domandaIsc.getRecapitoNoRes());
			target.setRelazioneConMinore(decRelazionePar.getCodParentela());
			target.setResidenzaFutura(trasferimento.getIndirizzoResidenzaNew());
			target.setId(soggetto.getIdAnagraficaSoggetto());
			target.setResidenzaNao(fromSN(soggetto.getFlResidenzaNao()));

			// gestiti esternamente
			target.setAnagrafica(source.getAnagrafica());
			target.setLuogoNascita(source.getLuogoNascita());
			target.setResidenza(source.getResidenza());
		}

		return target;
	}

	public static final class Data implements Serializable {
		private static final long serialVersionUID = 1L;

		private IscrittoTDomandaIsc domandaIsc;
		private IscrittoDCoabitazione decCoabitazione;
		private IscrittoDRelazionePar decRelazionePar;
		private IscrittoTTrasferimento trasferimento;
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

		public IscrittoDCoabitazione getDecCoabitazione() {
			return decCoabitazione;
		}

		public void setDecCoabitazione(IscrittoDCoabitazione decCoabitazione) {
			this.decCoabitazione = decCoabitazione;
		}

		public IscrittoDRelazionePar getDecRelazionePar() {
			return decRelazionePar;
		}

		public void setDecRelazionePar(IscrittoDRelazionePar decRelazionePar) {
			this.decRelazionePar = decRelazionePar;
		}

		public IscrittoTTrasferimento getTrasferimento() {
			return trasferimento;
		}

		public void setTrasferimento(IscrittoTTrasferimento trasferimento) {
			this.trasferimento = trasferimento;
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
