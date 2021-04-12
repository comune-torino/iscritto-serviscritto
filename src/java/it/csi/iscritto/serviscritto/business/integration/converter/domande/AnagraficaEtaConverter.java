package it.csi.iscritto.serviscritto.business.integration.converter.domande;

import it.csi.iscritto.serviscritto.business.integration.dao.custom.dto.AnagraficaEtaRow;
import it.csi.iscritto.serviscritto.business.util.converter.AbstractConverter;
import it.csi.iscritto.serviscritto.dto.domanda.AnagraficaEta;

public class AnagraficaEtaConverter extends AbstractConverter<AnagraficaEtaRow, AnagraficaEta> {

	@Override
	public AnagraficaEta convert(AnagraficaEtaRow source) {
		AnagraficaEta target = null;
		if (source != null) {
			target = new AnagraficaEta();

			target.setCodAnagraficaGraduatoria(source.getCodAnagraficaGra());
			target.setCodAnnoScolastico(source.getCodAnnoScolastico());
			target.setCodFasciaEta(source.getCodFasciaEta());
			target.setCodOrdineScuola(source.getCodOrdineScuola());
			target.setDataA(source.getDataA());
			target.setDataDa(source.getDataDa());
			target.setIdEta(source.getIdEta());
		}

		return target;
	}

}
