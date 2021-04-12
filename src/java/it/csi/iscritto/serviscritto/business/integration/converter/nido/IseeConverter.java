package it.csi.iscritto.serviscritto.business.integration.converter.nido;

import static it.csi.iscritto.serviscritto.business.util.converter.ConvertUtils.fromSN;

import java.io.Serializable;
import java.util.Optional;

import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTDomandaIsc;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTIsee;
import it.csi.iscritto.serviscritto.business.util.DateUtils;
import it.csi.iscritto.serviscritto.business.util.converter.AbstractConverter;
import it.csi.iscritto.serviscritto.dto.domanda.DatiIsee;
import it.csi.iscritto.serviscritto.dto.domanda.Isee;

public class IseeConverter extends AbstractConverter<IseeConverter.Data, Isee> {

	@Override
	public Isee convert(Data source) {
		Isee target = null;
		if (source != null) {
			IscrittoTDomandaIsc domandaIsc = source.getDomandaIsc();
			IscrittoTIsee isee = Optional.ofNullable(source.getIsee()).orElse(new IscrittoTIsee());

			DatiIsee datiIsee = new DatiIsee();
			datiIsee.setDataAttestazione(DateUtils.toStringDate(isee.getDtSottoscrizione(), DateUtils.DEFAULT_DATE_FORMAT));
			datiIsee.setValore(isee.getValoreIsee());

			target = new Isee();
			target.setStato(fromSN(domandaIsc.getFlIsee()));
			target.setDati(datiIsee);
		}

		return target;
	}

	public static final Isee buildEmpty() {
		DatiIsee datiIsee = new DatiIsee();

		Isee target = new Isee();
		target.setStato(false);
		target.setDati(datiIsee);

		return target;
	}

	public static final class Data implements Serializable {
		private static final long serialVersionUID = 1L;

		private IscrittoTDomandaIsc domandaIsc;
		private IscrittoTIsee isee;

		public IscrittoTDomandaIsc getDomandaIsc() {
			return domandaIsc;
		}

		public void setDomandaIsc(IscrittoTDomandaIsc domandaIsc) {
			this.domandaIsc = domandaIsc;
		}

		public IscrittoTIsee getIsee() {
			return isee;
		}

		public void setIsee(IscrittoTIsee isee) {
			this.isee = isee;
		}
	}

}
