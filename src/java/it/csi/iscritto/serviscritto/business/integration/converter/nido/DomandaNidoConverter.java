package it.csi.iscritto.serviscritto.business.integration.converter.nido;

import static it.csi.iscritto.serviscritto.business.util.converter.ConvertUtils.fromSN;
import static it.csi.iscritto.serviscritto.business.util.converter.ConvertUtils.toArray;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoDOrdineScuola;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoDStatoDom;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTAnnoSco;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTDomandaIsc;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTUtente;
import it.csi.iscritto.serviscritto.business.util.converter.AbstractConverter;
import it.csi.iscritto.serviscritto.dto.domanda.Affido;
import it.csi.iscritto.serviscritto.dto.domanda.AltriComponenti;
import it.csi.iscritto.serviscritto.dto.domanda.ComponentiNucleo;
import it.csi.iscritto.serviscritto.dto.domanda.CondizionePunteggio;
import it.csi.iscritto.serviscritto.dto.domanda.DomandaNido;
import it.csi.iscritto.serviscritto.dto.domanda.Isee;
import it.csi.iscritto.serviscritto.dto.domanda.Minore;
import it.csi.iscritto.serviscritto.dto.domanda.Nido;
import it.csi.iscritto.serviscritto.dto.domanda.Richiedente;
import it.csi.iscritto.serviscritto.dto.domanda.Soggetto1;
import it.csi.iscritto.serviscritto.dto.domanda.Soggetto2;
import it.csi.iscritto.serviscritto.dto.domanda.Soggetto3;

public class DomandaNidoConverter extends AbstractConverter<DomandaNidoConverter.Data, DomandaNido> {

	@Override
	public DomandaNido convert(Data source) {
		DomandaNido target = null;
		if (source != null && source.getDomandaIsc() != null) {
			IscrittoTDomandaIsc domandaIsc = source.getDomandaIsc();
			IscrittoDStatoDom decStatoDom = Optional.ofNullable(source.getDecStatoDom()).orElse(new IscrittoDStatoDom());
			IscrittoDOrdineScuola decOrdineScuola = Optional.ofNullable(source.getDecOrdineScuola()).orElse(new IscrittoDOrdineScuola());
			IscrittoTUtente utenteIns = Optional.ofNullable(source.getUtenteIns()).orElse(new IscrittoTUtente());
			IscrittoTUtente utenteMod = Optional.ofNullable(source.getUtenteMod()).orElse(new IscrittoTUtente());
			IscrittoTAnnoSco annoSco = Optional.ofNullable(source.getAnnoSco()).orElse(new IscrittoTAnnoSco());

			target = new DomandaNido();

			target.setIdDomandaIscrizione(domandaIsc.getIdDomandaIscrizione());
			target.setProtocollo(domandaIsc.getProtocollo());
			target.setInfoAutocertificazione(fromSN(domandaIsc.getFlInfoAutocertificazione()));
			target.setInfoGdpr(fromSN(domandaIsc.getFlInfoGdpr()));
			target.setResponsabilitaGenitoriale(fromSN(domandaIsc.getFlResponsabilitaGen()));
			target.setNao(fromSN(domandaIsc.getFlNao()));
			target.setDataInserimento(domandaIsc.getDataConsegna());
			target.setDataUltimaModifica(domandaIsc.getDtModifica());

			target.setStatoDomanda(decStatoDom.getCodStatoDom());
			target.setOrdineScuola(decOrdineScuola.getCodOrdineScuola());

			target.setCodiceFiscaleUtenteIns(utenteIns.getCodiceFiscale());
			target.setCodiceFiscaleUtenteMod(utenteMod.getCodiceFiscale());

			target.setAnnoScolastico(annoSco.getCodAnnoScolastico());
			target.setConsensoConvenzionata(fromSN(domandaIsc.getFlConsensoTdConv()));

			// gestiti esternamente
			target.setMinore(source.getMinore());
			target.setRichiedente(source.getRichiedente());
			target.setSoggetto1(source.getSoggetto1());
			target.setSoggetto2(source.getSoggetto2());
			target.setSoggetto3(source.getSoggetto3());
			target.setAffido(source.getAffido());
			target.setAltriComponenti(source.getAltriComponenti());
			target.setComponentiNucleo(source.getComponentiNucleo());
			target.setElencoNidi(toArray(source.getElencoNidi(), Nido.class));
			target.setIsee(source.getIsee());

			// ISBO-111
			target.setCondizioniPunteggio(toArray(source.getCondizioniPunteggio(), CondizionePunteggio.class));
		}

		return target;
	}

	public static final class Data implements Serializable {
		private static final long serialVersionUID = 1L;

		private IscrittoTDomandaIsc domandaIsc;
		private IscrittoDStatoDom decStatoDom;
		private IscrittoDOrdineScuola decOrdineScuola;
		private IscrittoTUtente utenteIns;
		private IscrittoTUtente utenteMod;
		private IscrittoTAnnoSco annoSco;

		private Minore minore;
		private Richiedente richiedente;
		private Soggetto1 soggetto1;
		private Soggetto2 soggetto2;
		private Soggetto3 soggetto3;
		private Affido affido;
		private AltriComponenti altriComponenti;
		private ComponentiNucleo componentiNucleo;
		private List<Nido> elencoNidi;
		private Isee isee;
		private List<CondizionePunteggio> condizioniPunteggio;

		public IscrittoTDomandaIsc getDomandaIsc() {
			return domandaIsc;
		}

		public void setDomandaIsc(IscrittoTDomandaIsc domandaIsc) {
			this.domandaIsc = domandaIsc;
		}

		public IscrittoDStatoDom getDecStatoDom() {
			return decStatoDom;
		}

		public void setDecStatoDom(IscrittoDStatoDom decStatoDom) {
			this.decStatoDom = decStatoDom;
		}

		public IscrittoDOrdineScuola getDecOrdineScuola() {
			return decOrdineScuola;
		}

		public void setDecOrdineScuola(IscrittoDOrdineScuola decOrdineScuola) {
			this.decOrdineScuola = decOrdineScuola;
		}

		public IscrittoTUtente getUtenteIns() {
			return utenteIns;
		}

		public void setUtenteIns(IscrittoTUtente utenteIns) {
			this.utenteIns = utenteIns;
		}

		public IscrittoTUtente getUtenteMod() {
			return utenteMod;
		}

		public void setUtenteMod(IscrittoTUtente utenteMod) {
			this.utenteMod = utenteMod;
		}

		public IscrittoTAnnoSco getAnnoSco() {
			return annoSco;
		}

		public void setAnnoSco(IscrittoTAnnoSco annoSco) {
			this.annoSco = annoSco;
		}

		public Minore getMinore() {
			return minore;
		}

		public void setMinore(Minore minore) {
			this.minore = minore;
		}

		public Richiedente getRichiedente() {
			return richiedente;
		}

		public void setRichiedente(Richiedente richiedente) {
			this.richiedente = richiedente;
		}

		public Soggetto1 getSoggetto1() {
			return soggetto1;
		}

		public void setSoggetto1(Soggetto1 soggetto1) {
			this.soggetto1 = soggetto1;
		}

		public Soggetto2 getSoggetto2() {
			return soggetto2;
		}

		public void setSoggetto2(Soggetto2 soggetto2) {
			this.soggetto2 = soggetto2;
		}

		public Soggetto3 getSoggetto3() {
			return soggetto3;
		}

		public void setSoggetto3(Soggetto3 soggetto3) {
			this.soggetto3 = soggetto3;
		}

		public Affido getAffido() {
			return affido;
		}

		public void setAffido(Affido affido) {
			this.affido = affido;
		}

		public AltriComponenti getAltriComponenti() {
			return altriComponenti;
		}

		public void setAltriComponenti(AltriComponenti altriComponenti) {
			this.altriComponenti = altriComponenti;
		}

		public ComponentiNucleo getComponentiNucleo() {
			return componentiNucleo;
		}

		public void setComponentiNucleo(ComponentiNucleo componentiNucleo) {
			this.componentiNucleo = componentiNucleo;
		}

		public List<Nido> getElencoNidi() {
			return elencoNidi;
		}

		public void setElencoNidi(List<Nido> elencoNidi) {
			this.elencoNidi = elencoNidi;
		}

		public Isee getIsee() {
			return isee;
		}

		public void setIsee(Isee isee) {
			this.isee = isee;
		}

		public List<CondizionePunteggio> getCondizioniPunteggio() {
			return condizioniPunteggio;
		}

		public void setCondizioniPunteggio(List<CondizionePunteggio> condizioniPunteggio) {
			this.condizioniPunteggio = condizioniPunteggio;
		}
	}

}
