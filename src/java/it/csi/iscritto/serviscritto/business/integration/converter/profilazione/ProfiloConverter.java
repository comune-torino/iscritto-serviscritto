package it.csi.iscritto.serviscritto.business.integration.converter.profilazione;

import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoDProfilo;
import it.csi.iscritto.serviscritto.business.util.converter.AbstractConverter;
import it.csi.iscritto.serviscritto.dto.profilazione.Profilo;

public class ProfiloConverter extends AbstractConverter<IscrittoDProfilo, Profilo> {

	@Override
	public Profilo convert(IscrittoDProfilo source) {
		Profilo target = null;
		if (source != null) {
			target = new Profilo();

			target.setCodProfilo(source.getCodiceProfilo());
			target.setDescProfilo(source.getDescrizione());
		}

		return target;
	}

}
