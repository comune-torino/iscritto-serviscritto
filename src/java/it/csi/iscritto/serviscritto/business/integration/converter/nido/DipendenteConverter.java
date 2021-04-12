package it.csi.iscritto.serviscritto.business.integration.converter.nido;

import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTDipendente;
import it.csi.iscritto.serviscritto.business.util.converter.AbstractConverter;
import it.csi.iscritto.serviscritto.dto.domanda.Dipendente;

public class DipendenteConverter extends AbstractConverter<IscrittoTDipendente, Dipendente> {

	@Override
	public Dipendente convert(IscrittoTDipendente source) {
		Dipendente target = null;
		if (source != null) {
			target = new Dipendente();

			target.setAzienda(source.getAzienda());
			target.setComune(source.getComuneLavoro());
			target.setIndirizzo(source.getIndirizzoLavoro());
			target.setProvincia(source.getProvinciaLavoro());
		}

		return target;
	}

	public static final Dipendente buildEmpty() {
		return new Dipendente();
	}

}
