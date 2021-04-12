package it.csi.iscritto.serviscritto.business.integration.converter.domande;

import it.csi.iscritto.serviscritto.business.integration.dao.custom.dto.TipoFasciaEtaRow;
import it.csi.iscritto.serviscritto.business.util.converter.AbstractConverter;
import it.csi.iscritto.serviscritto.dto.domanda.TipoFasciaEta;

public class TipoFasciaEtaConverter extends AbstractConverter<TipoFasciaEtaRow, TipoFasciaEta> {

	@Override
	public TipoFasciaEta convert(TipoFasciaEtaRow source) {
		TipoFasciaEta target = null;
		if (source != null) {
			target = new TipoFasciaEta();

			target.setCodFasciaEta(source.getCodFasciaEta());
			target.setDescFasciaEta(source.getDescFasciaEta());
			target.setCodOrdineScuola(source.getCodOrdineScuola());
		}

		return target;
	}

}
