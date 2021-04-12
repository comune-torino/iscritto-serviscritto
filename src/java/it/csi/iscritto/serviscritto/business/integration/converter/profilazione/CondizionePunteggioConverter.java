package it.csi.iscritto.serviscritto.business.integration.converter.profilazione;

import it.csi.iscritto.serviscritto.business.integration.dao.view.dto.InfoCondizionePunteggioRow;
import it.csi.iscritto.serviscritto.business.util.converter.AbstractConverter;
import it.csi.iscritto.serviscritto.dto.profilazione.CondizionePunteggio;

public class CondizionePunteggioConverter extends AbstractConverter<InfoCondizionePunteggioRow, CondizionePunteggio> {

	@Override
	public CondizionePunteggio convert(InfoCondizionePunteggioRow source) {
		CondizionePunteggio target = null;
		if (source != null) {
			target = new CondizionePunteggio();

			target.setCodCondizione(source.getCodCondizione());
			target.setCodTipoIstruttoria(source.getCodTipoIstruttoria());
			target.setDescrizione(source.getDescrizione());
			target.setIstruttoria(source.getFlIstruttoria());
			target.setCodTipoAllegato(source.getCodTipoAllegato());
		}

		return target;
	}

}
