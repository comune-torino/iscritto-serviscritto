package it.csi.iscritto.serviscritto.business.integration.converter.domande;

import it.csi.iscritto.serviscritto.business.integration.dao.custom.dto.PreferenzaScuolaRow;
import it.csi.iscritto.serviscritto.business.util.converter.AbstractConverter;
import it.csi.iscritto.serviscritto.dto.domanda.RecordPreferenzaScuola;

public class RecordPreferenzaScuolaConverter extends AbstractConverter<PreferenzaScuolaRow, RecordPreferenzaScuola> {

	@Override
	public RecordPreferenzaScuola convert(PreferenzaScuolaRow source) {
		RecordPreferenzaScuola target = null;
		if (source != null) {
			target = new RecordPreferenzaScuola();

			target.setCodScuola(source.getCodScuola());
			target.setCodStatoScu(source.getCodStatoScu());
			target.setCodTipoFrequenza(source.getCodTipoFrequenza());
			target.setDescScuola(source.getDescScuola());
			target.setDescStatoScu(source.getDescStatoScu());
			target.setDescTipoFre(source.getDescTipoFre());
			target.setDtStato(source.getDtStato());
			target.setIdDomandaIscrizione(source.getIdDomandaIscrizione());
			target.setIdGraduatoria(source.getIdGraduatoria());
			target.setIdStatoScu(source.getIdStatoScu());
			target.setIdTipoFrequenza(source.getIdTipoFrequenza());
			target.setIndirizzo(source.getIndirizzo());
			target.setOrdinePreferenza(source.getOrdinePreferenza());
		}

		return target;
	}

}
