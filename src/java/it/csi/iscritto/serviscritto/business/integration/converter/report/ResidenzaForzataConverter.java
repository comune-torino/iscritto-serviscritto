package it.csi.iscritto.serviscritto.business.integration.converter.report;

import it.csi.iscritto.serviscritto.business.integration.dao.custom.dto.ResidenzaForzataRow;
import it.csi.iscritto.serviscritto.business.util.converter.AbstractConverter;
import it.csi.iscritto.serviscritto.dto.domanda.ResidenzaForzata;

public class ResidenzaForzataConverter extends AbstractConverter<ResidenzaForzataRow, ResidenzaForzata> {

	@Override
	public ResidenzaForzata convert(ResidenzaForzataRow source) {
		ResidenzaForzata target = null;
		if (source != null) {
			target = new ResidenzaForzata();

			target.setCodiceFiscale(source.getCodiceFiscale());
			target.setCognome(source.getCognome());
			target.setIdDomanda(source.getIdDomandaIscrizione());
			target.setIdSoggetto(source.getIdAnagraficaSoggetto());
			target.setNome(source.getNome());
			target.setProtocollo(source.getProtocollo());
			target.setCodFasciaEta(source.getCodFasciaEta());
			target.setCodScuola(source.getCodScuola());
			target.setDescScuola(source.getDescScuola());
			target.setIndirizzo(source.getIndirizzo());
			target.setCodOrdineScuola(source.getCodOrdineScuola());
		}

		return target;
	}

}
