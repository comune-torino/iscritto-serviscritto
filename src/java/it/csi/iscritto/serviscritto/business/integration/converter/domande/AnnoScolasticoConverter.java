package it.csi.iscritto.serviscritto.business.integration.converter.domande;

import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTAnnoSco;
import it.csi.iscritto.serviscritto.business.util.converter.AbstractConverter;
import it.csi.iscritto.serviscritto.dto.domanda.AnnoScolastico;

public class AnnoScolasticoConverter extends AbstractConverter<IscrittoTAnnoSco, AnnoScolastico> {

	@Override
	public AnnoScolastico convert(IscrittoTAnnoSco source) {
		AnnoScolastico target = null;
		if (source != null) {
			target = new AnnoScolastico();

			target.setCodAnnoScolastico(source.getCodAnnoScolastico());
			target.setDataA(source.getDataA());
			target.setDataDa(source.getDataDa());
			target.setDescrizione(source.getDescrizione());
		}

		return target;
	}

}
