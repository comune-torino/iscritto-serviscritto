package it.csi.iscritto.serviscritto.business.integration.converter.domande;

import it.csi.iscritto.serviscritto.business.integration.dao.custom.dto.RicevutaAccettazioneRow;
import it.csi.iscritto.serviscritto.business.util.converter.AbstractConverter;
import it.csi.iscritto.serviscritto.dto.domanda.RicevutaAccettazione;

public class RicevutaAccettazioneConverter extends AbstractConverter<RicevutaAccettazioneRow, RicevutaAccettazione> {

	@Override
	public RicevutaAccettazione convert(RicevutaAccettazioneRow source) {
		RicevutaAccettazione target = null;
		if (source != null) {
			target = new RicevutaAccettazione();

			target.setCodAnnoScolastico(source.getCodAnnoScolastico());
			target.setCodiceCategoriaScu(source.getCodiceCategoriaScu());
			target.setCodOrdineScuola(source.getCodOrdineScuola());
			target.setCodScuola(source.getCodScuola());
			target.setCodTipoFrequenza(source.getCodTipoFrequenza());
			target.setCodTipoPasto(source.getCodTipoPasto());
			target.setCognomeMinore(source.getCognomeMinore());
			target.setDataConsegna(source.getDataConsegna());
			target.setDataOperazione(source.getDtOperazione());
			target.setDescScuola(source.getDescScuola());
			target.setDescTipoFrequenza(source.getDescTipoFrequenza());
			target.setDescTipoPasto(source.getDescTipoPasto());
			target.setIdDomandaIscrizione(source.getIdDomandaIscrizione());
			target.setIndirizzoScuola(source.getIndirizzoScuola());
			target.setNomeMinore(source.getNomeMinore());
			target.setProtocolloDomanda(source.getProtocollo());
		}

		return target;
	}

}
