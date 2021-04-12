package it.csi.iscritto.serviscritto.business.integration.converter.domande;

import it.csi.iscritto.serviscritto.business.integration.dao.custom.dto.DatiCondizionePunteggioRow;
import it.csi.iscritto.serviscritto.business.util.converter.AbstractConverter;
import it.csi.iscritto.serviscritto.business.util.converter.ConvertUtils;
import it.csi.iscritto.serviscritto.dto.domanda.DatiCondizionePunteggio;

public class DatiCondizionePunteggioConverter extends AbstractConverter<DatiCondizionePunteggioRow, DatiCondizionePunteggio> {

	@Override
	public DatiCondizionePunteggio convert(DatiCondizionePunteggioRow source) {
		DatiCondizionePunteggio target = null;

		if (source != null) {
			target = new DatiCondizionePunteggio();

			target.setCognomeOperatore(source.getCognomeOperatore());
			target.setDataFineValidita(source.getDtFineValidita());
			target.setDataInizioValidita(source.getDtInizioValidita());
			target.setIdCondizionePunteggio(source.getIdCondizionePunteggio());
			target.setIdDomanda(source.getIdDomandaIscrizione());
			target.setNomeOperatore(source.getNomeOperatore());
			target.setNote(source.getNote());
			target.setRicorrenza(source.getRicorrenza());
			target.setValidata(ConvertUtils.fromSN(source.getFlValida()));
			target.setCodCondizionePunteggio(source.getCodCondizionePunteggio());
		}

		return target;
	}

}
