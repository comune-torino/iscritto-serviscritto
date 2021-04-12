package it.csi.iscritto.serviscritto.business.integration.converter.domande;

import it.csi.iscritto.serviscritto.business.integration.dao.custom.dto.InfoVerificheRow;
import it.csi.iscritto.serviscritto.business.util.converter.AbstractConverter;
import it.csi.iscritto.serviscritto.dto.domanda.InfoVerifiche;

public class InfoVerificheConverter extends AbstractConverter<InfoVerificheRow, InfoVerifiche> {

	@Override
	public InfoVerifiche convert(InfoVerificheRow source) {
		InfoVerifiche target = null;
		if (source != null) {
			target = new InfoVerifiche();

			target.setCodCondizione(source.getCodCondizione());
			target.setCodTipoVerifica(source.getFlIstruttoria());
			target.setDescCondizione(source.getDescrizione());
			target.setOccorrenze(source.getOccorrenze());
		}

		return target;
	}

}
