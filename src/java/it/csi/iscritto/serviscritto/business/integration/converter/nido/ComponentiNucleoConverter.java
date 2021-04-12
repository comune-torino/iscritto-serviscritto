package it.csi.iscritto.serviscritto.business.integration.converter.nido;

import static it.csi.iscritto.serviscritto.business.util.converter.ConvertUtils.toArray;

import java.io.Serializable;
import java.util.List;

import it.csi.iscritto.serviscritto.business.util.converter.AbstractConverter;
import it.csi.iscritto.serviscritto.dto.domanda.ComponentiNucleo;
import it.csi.iscritto.serviscritto.dto.domanda.SoggettoNucleo;

public class ComponentiNucleoConverter extends AbstractConverter<ComponentiNucleoConverter.Data, ComponentiNucleo> {

	@Override
	public ComponentiNucleo convert(Data source) {
		ComponentiNucleo target = null;
		if (source != null) {
			target = new ComponentiNucleo();

			// gestito esternamente
			target.setSoggetti(toArray(source.getSoggetti(), SoggettoNucleo.class));
		}

		return target;
	}

	public static final ComponentiNucleo buildEmpty() {
		ComponentiNucleo target = new ComponentiNucleo();
		// target.setSoggetti(toArray(Arrays.asList(SoggettoNucleoConverter.buildEmpty()), SoggettoNucleo.class));
		target.setSoggetti(new SoggettoNucleo[0]);

		return target;
	}

	public static final class Data implements Serializable {
		private static final long serialVersionUID = 1L;

		private List<SoggettoNucleo> soggetti;

		public List<SoggettoNucleo> getSoggetti() {
			return soggetti;
		}

		public void setSoggetti(List<SoggettoNucleo> soggetti) {
			this.soggetti = soggetti;
		}
	}

}
