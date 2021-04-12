package it.csi.iscritto.serviscritto.business.integration.converter.domande;

import it.csi.iscritto.serviscritto.business.integration.dao.view.dto.CodificaRow;
import it.csi.iscritto.serviscritto.business.util.converter.AbstractConverter;
import it.csi.iscritto.serviscritto.dto.domanda.Codifica;

public class CodificaConverter extends AbstractConverter<CodificaRow, Codifica> {

	@Override
	public Codifica convert(CodificaRow source) {

		Codifica target = new Codifica();
		if (source != null) {
			target.setCodice(source.getCodice());
			target.setDescrizione(source.getDescrizione());
			target.setId(source.getId());
		}

		return target;
	}

}
