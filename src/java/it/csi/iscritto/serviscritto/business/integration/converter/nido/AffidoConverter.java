package it.csi.iscritto.serviscritto.business.integration.converter.nido;

import static it.csi.iscritto.serviscritto.business.util.converter.ConvertUtils.fromSN;
import static it.csi.iscritto.serviscritto.business.util.converter.ConvertUtils.toArray;

import java.io.Serializable;
import java.util.List;

import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTDomandaIsc;
import it.csi.iscritto.serviscritto.business.util.converter.AbstractConverter;
import it.csi.iscritto.serviscritto.dto.domanda.Affido;
import it.csi.iscritto.serviscritto.dto.domanda.SoggettoAffido;

public class AffidoConverter extends AbstractConverter<AffidoConverter.Data, Affido> {

	@Override
	public Affido convert(Data source) {
		Affido target = null;
		if (source != null) {
			IscrittoTDomandaIsc domandaIsc = source.getDomandaIsc();

			target = new Affido();
			target.setStato(fromSN(domandaIsc.getFlAffido()));
			target.setSoggetti(toArray(source.getSoggetti(), SoggettoAffido.class));
		}

		return target;
	}

	public static final Affido buildEmpty() {
		Affido target = new Affido();
		// target.setSoggetti(toArray(Arrays.asList(SoggettoAffidoConverter.buildEmpty()), SoggettoAffido.class));
		target.setStato(false);
		target.setSoggetti(new SoggettoAffido[0]);

		return target;
	}

	public static final class Data implements Serializable {
		private static final long serialVersionUID = 1L;

		private IscrittoTDomandaIsc domandaIsc;
		private List<SoggettoAffido> soggetti;

		public IscrittoTDomandaIsc getDomandaIsc() {
			return domandaIsc;
		}

		public void setDomandaIsc(IscrittoTDomandaIsc domandaIsc) {
			this.domandaIsc = domandaIsc;
		}

		public List<SoggettoAffido> getSoggetti() {
			return soggetti;
		}

		public void setSoggetti(List<SoggettoAffido> soggetti) {
			this.soggetti = soggetti;
		}
	}

}
