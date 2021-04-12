package it.csi.iscritto.serviscritto.business.integration.converter.domande;

import it.csi.iscritto.serviscritto.business.integration.dao.custom.dto.RicevutaAllegatoRow;
import it.csi.iscritto.serviscritto.business.util.converter.AbstractConverter;
import it.csi.iscritto.serviscritto.dto.domanda.RicevutaAllegato;

public class RicevutaAllegatoConverter extends AbstractConverter<RicevutaAllegatoRow, RicevutaAllegato> {

	@Override
	public RicevutaAllegato convert(RicevutaAllegatoRow source) {
		RicevutaAllegato target = null;
		if (source != null) {
			target = new RicevutaAllegato();

			target.setCodAnnoScolastico(source.getCodAnnoScolastico());
			target.setCodOrdineScuola(source.getCodOrdineScuola());
			target.setCognomeMinore(source.getCognomeMinore());
			target.setDataOperazione(source.getDataOperazione());
			target.setDescTipoAllegato(source.getDescTipoAllegato());
			target.setNomeFile(source.getNomeFile());
			target.setNomeMinore(source.getNomeMinore());
			target.setProtocolloAllegato(source.getProtocolloAllegato());
			target.setProtocolloDomanda(source.getProtocolloDomanda());
		}

		return target;
	}

}
