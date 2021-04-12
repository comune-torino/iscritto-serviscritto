package it.csi.iscritto.serviscritto.business.integration.converter.profilazione;

import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTFunzione;
import it.csi.iscritto.serviscritto.business.util.converter.AbstractConverter;
import it.csi.iscritto.serviscritto.dto.profilazione.Funzione;

public class FunzioneConverter extends AbstractConverter<IscrittoTFunzione, Funzione> {

	@Override
	public Funzione convert(IscrittoTFunzione source) {
		Funzione target = null;
		if (source != null) {
			target = new Funzione();
			target.setId(source.getIdFunzione());
			target.setCodice(source.getCodFunzione());
			target.setDescrizione(source.getDescrizione());
			target.setLink(source.getLink());
		}

		return target;
	}

}
