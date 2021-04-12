package it.csi.iscritto.serviscritto.business.integration.converter.profilazione;

import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTUtente;
import it.csi.iscritto.serviscritto.business.util.converter.AbstractConverter;
import it.csi.iscritto.serviscritto.dto.profilazione.Operatore;

public class OperatoreConverter extends AbstractConverter<IscrittoTUtente, Operatore> {

	@Override
	public Operatore convert(IscrittoTUtente source) {
		Operatore target = null;
		if (source != null) {
			target = new Operatore();

			target.setCodiceFiscale(source.getCodiceFiscale());
			target.setCognome(source.getCognome());
			target.setNome(source.getNome());
		}

		return target;
	}

}
