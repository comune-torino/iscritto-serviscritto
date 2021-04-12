package it.csi.iscritto.serviscritto.business.integration.converter.domande;

import it.csi.iscritto.serviscritto.business.integration.dao.view.dto.FasciaEtaRow;
import it.csi.iscritto.serviscritto.business.util.converter.AbstractConverter;
import it.csi.iscritto.serviscritto.dto.domanda.FasciaEta;

public class FasciaEtaConverter extends AbstractConverter<FasciaEtaRow, FasciaEta> {

	@Override
	public FasciaEta convert(FasciaEtaRow source) {
		FasciaEta target = null;
		if (source != null) {
			target = new FasciaEta();

			target.setAnnoLimite(source.getAnnoLimite());
			target.setCodAnnoScolastico(source.getCodAnnoScolastico());
			target.setCodFasciaEta(source.getCodFasciaEta());
			target.setCodOrdineScuola(source.getCodOrdineScuola());
			target.setDataA(source.getDataA());
			target.setDataDa(source.getDataDa());
		}

		return target;
	}

}
