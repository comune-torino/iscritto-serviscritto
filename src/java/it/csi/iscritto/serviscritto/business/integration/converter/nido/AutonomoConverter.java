package it.csi.iscritto.serviscritto.business.integration.converter.nido;

import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTAutonomo;
import it.csi.iscritto.serviscritto.business.util.converter.AbstractConverter;
import it.csi.iscritto.serviscritto.dto.domanda.Autonomo;

public class AutonomoConverter extends AbstractConverter<IscrittoTAutonomo, Autonomo> {

	@Override
	public Autonomo convert(IscrittoTAutonomo source) {
		Autonomo target = null;
		if (source != null) {
			target = new Autonomo();

			target.setComune(source.getComuneLavoro());
			target.setIndirizzo(source.getIndirizzoLavoro());
			target.setPiva(source.getPartitaivaCf());
			target.setProvincia(source.getProvinciaLavoro());
		}

		return target;
	}

	public static final Autonomo buildEmpty() {
		return new Autonomo();
	}

}
