package it.csi.iscritto.serviscritto.business.integration.converter.profilazione;

import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTAttivita;
import it.csi.iscritto.serviscritto.business.util.converter.AbstractConverter;
import it.csi.iscritto.serviscritto.dto.profilazione.Attivita;

public class AttivitaConverter extends AbstractConverter<IscrittoTAttivita, Attivita> {

	@Override
	public Attivita convert(IscrittoTAttivita source) {
		Attivita target = null;
		if (source != null) {
			target = new Attivita();

			target.setId(source.getIdAttivita());
			target.setCodice(source.getCodAttivita());
			target.setDescrizione(source.getDescrizione());
			target.setLink(source.getLink());
		}

		return target;
	}

}
