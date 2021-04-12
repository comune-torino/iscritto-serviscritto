package it.csi.iscritto.serviscritto.business.integration.converter.nido;

import static it.csi.iscritto.serviscritto.business.util.converter.ConvertUtils.fromSN;

import java.io.Serializable;
import java.util.Optional;

import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoDTipoFra;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTDomandaIsc;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTFratelloFre;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTStato;
import it.csi.iscritto.serviscritto.business.util.DateUtils;
import it.csi.iscritto.serviscritto.business.util.converter.AbstractConverter;
import it.csi.iscritto.serviscritto.dto.domanda.Anagrafica;
import it.csi.iscritto.serviscritto.dto.domanda.FratelloFrequentante;

public class FratelloFrequentanteConverter extends AbstractConverter<FratelloFrequentanteConverter.Data, FratelloFrequentante> {

	@Override
	public FratelloFrequentante convert(Data source) {
		FratelloFrequentante target = null;
		if (source != null) {
			IscrittoTDomandaIsc domandaIsc = source.getDomandaIsc();
			IscrittoTFratelloFre fratelloFre = Optional.ofNullable(source.getFratelloFre()).orElse(new IscrittoTFratelloFre());
			IscrittoDTipoFra decTipoFra = Optional.ofNullable(source.getDecTipoFra()).orElse(new IscrittoDTipoFra());
			IscrittoTStato stato = Optional.ofNullable(source.getStato()).orElse(new IscrittoTStato());

			Anagrafica anagrafica = new Anagrafica();
			anagrafica.setCodiceFiscale(fratelloFre.getCfFratello());
			anagrafica.setCognome(fratelloFre.getCognomeFratello());
			anagrafica.setDataNascita(DateUtils.toStringDate(fratelloFre.getDtNascita(), DateUtils.DEFAULT_DATE_FORMAT));
			anagrafica.setNome(fratelloFre.getNomeFratello());
			anagrafica.setOraMinutiNascita(null);
			anagrafica.setSesso(fratelloFre.getSesso());
			anagrafica.setCodCittadinanza(stato.getCodice());
			anagrafica.setDescCittadinanza(stato.getCittadinanza());

			target = new FratelloFrequentante();
			target.setAnagrafica(anagrafica);
			target.setStato(fromSN(domandaIsc.getFlFratelloFreq()));
			target.setTipo(decTipoFra.getCodTipoFratello());
		}

		return target;
	}

	public static final FratelloFrequentante buildEmpty() {
		FratelloFrequentante target = new FratelloFrequentante();
		target.setAnagrafica(AnagraficaConverter.buildEmpty());

		return target;
	}

	public static final class Data implements Serializable {
		private static final long serialVersionUID = 1L;

		private IscrittoTDomandaIsc domandaIsc;
		private IscrittoTFratelloFre fratelloFre;
		private IscrittoDTipoFra decTipoFra;
		private IscrittoTStato stato;

		public IscrittoTDomandaIsc getDomandaIsc() {
			return domandaIsc;
		}

		public void setDomandaIsc(IscrittoTDomandaIsc domandaIsc) {
			this.domandaIsc = domandaIsc;
		}

		public IscrittoTFratelloFre getFratelloFre() {
			return fratelloFre;
		}

		public void setFratelloFre(IscrittoTFratelloFre fratelloFre) {
			this.fratelloFre = fratelloFre;
		}

		public IscrittoDTipoFra getDecTipoFra() {
			return decTipoFra;
		}

		public void setDecTipoFra(IscrittoDTipoFra decTipoFra) {
			this.decTipoFra = decTipoFra;
		}

		public IscrittoTStato getStato() {
			return stato;
		}

		public void setStato(IscrittoTStato stato) {
			this.stato = stato;
		}
	}

}
