package it.csi.iscritto.serviscritto.business.integration.converter.nido;

import static it.csi.iscritto.serviscritto.business.util.converter.ConvertUtils.fromSN;
import static it.csi.iscritto.serviscritto.business.util.converter.ConvertUtils.toArray;

import java.io.Serializable;
import java.util.List;

import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTDomandaIsc;
import it.csi.iscritto.serviscritto.business.util.converter.AbstractConverter;
import it.csi.iscritto.serviscritto.dto.domanda.AltriComponenti;
import it.csi.iscritto.serviscritto.dto.domanda.SoggettoAltroComponente;

public class AltriComponentiConverter extends AbstractConverter<AltriComponentiConverter.Data, AltriComponenti> {

	@Override
	public AltriComponenti convert(Data source) {
		AltriComponenti target = null;
		if (source != null) {
			IscrittoTDomandaIsc domandaIsc = source.getDomandaIsc();

			target = new AltriComponenti();
			target.setStato(fromSN(domandaIsc.getFlAltriComponenti()));
			target.setSoggetti(toArray(source.getSoggetti(), SoggettoAltroComponente.class));
		}

		return target;
	}

	public static final AltriComponenti buildEmpty() {
		AltriComponenti target = new AltriComponenti();
		// target.setSoggetti(toArray(Arrays.asList(SoggettoAltroComponenteConverter.buildEmpty()), SoggettoAltroComponente.class));
		target.setStato(false);
		target.setSoggetti(new SoggettoAltroComponente[0]);

		return target;
	}

	public static final class Data implements Serializable {
		private static final long serialVersionUID = 1L;

		private IscrittoTDomandaIsc domandaIsc;
		private List<SoggettoAltroComponente> soggetti;

		public IscrittoTDomandaIsc getDomandaIsc() {
			return domandaIsc;
		}

		public void setDomandaIsc(IscrittoTDomandaIsc domandaIsc) {
			this.domandaIsc = domandaIsc;
		}

		public List<SoggettoAltroComponente> getSoggetti() {
			return soggetti;
		}

		public void setSoggetti(List<SoggettoAltroComponente> soggetti) {
			this.soggetti = soggetti;
		}
	}

}
