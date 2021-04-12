package it.csi.iscritto.serviscritto.business.integration.converter.domande;

import it.csi.iscritto.serviscritto.business.integration.dao.custom.dto.ClasseRow;
import it.csi.iscritto.serviscritto.business.util.converter.AbstractConverter;
import it.csi.iscritto.serviscritto.dto.domanda.Classe;

public class ClasseConverter extends AbstractConverter<ClasseRow, Classe> {

	@Override
	public Classe convert(ClasseRow source) {
		Classe target = null;
		if (source != null) {
			target = new Classe();

			target.setCodAnnoScolastico(source.getCodAnnoScolastico());
			target.setCodFasciaEta(source.getCodFasciaEta());
			target.setCodOrdineScuola(source.getCodOrdineScuola());
			target.setCodScuola(source.getCodScuola());
			target.setCodTipoFrequenza(source.getCodTipoFrequenza());
			target.setDenominazione(source.getDenominazione());
			target.setFlAmmissioneDis(source.getFlAmmissioneDis());
			target.setIdClasse(source.getIdClasse());
			target.setPostiAccettati(source.getPostiAccettati());
			target.setPostiAmmessi(source.getPostiAmmessi());
			target.setPostiLiberi(source.getPostiLiberi());
		}

		return target;
	}

}
