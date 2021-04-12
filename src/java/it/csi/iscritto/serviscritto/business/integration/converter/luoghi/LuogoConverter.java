package it.csi.iscritto.serviscritto.business.integration.converter.luoghi;

import it.csi.iscritto.serviscritto.business.integration.dao.view.dto.LuogoRow;
import it.csi.iscritto.serviscritto.business.util.converter.AbstractConverter;
import it.csi.iscritto.serviscritto.dto.luoghi.Luogo;

public class LuogoConverter extends AbstractConverter<LuogoRow, Luogo> {

	@Override
	public Luogo convert(LuogoRow source) {
		Luogo target = null;
		if (source != null) {
			target = new Luogo();

			target.setCodice(source.getCodice());
			target.setDescCittadinanza(source.getCittadinanza());
			target.setDescComune(source.getDescComune());
			target.setDescProvincia(source.getDescProvincia());
			target.setDescRegione(source.getDescRegione());
			target.setIstatComune(source.getIstatComune());
			target.setIstatProvincia(source.getIstatProvincia());
			target.setIstatRegione(source.getIstatRegione());
			target.setStato(source.getStato());
		}

		return target;
	}

}
