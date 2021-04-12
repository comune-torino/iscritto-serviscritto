package it.csi.iscritto.serviscritto.business.integration.converter.domande;

import it.csi.iscritto.serviscritto.business.integration.dao.custom.dto.NidoRow;
import it.csi.iscritto.serviscritto.business.util.converter.AbstractConverter;
import it.csi.iscritto.serviscritto.business.util.converter.ConvertUtils;
import it.csi.iscritto.serviscritto.dto.domanda.Nido;

public class GraduatoriaNidoConverter extends AbstractConverter<NidoRow, Nido> {

	@Override
	public Nido convert(NidoRow source) {
		Nido target = null;
		if (source != null) {
			target = new Nido();

			target.setCodCategoriaScuola(source.getCodiceCategoriaScu());
			target.setCodCircoscrizione(source.getCodCircoscrizione());
			target.setCodScuola(source.getCodScuola());
			target.setCodStatoScuola(source.getCodStatoScu());
			target.setCodTipoFrequenza(source.getCodTipoFrequenza());
			target.setDataUltimoCambioStato(null);
			target.setDescrizione(source.getDescrizione());
			target.setFuoriTermine(ConvertUtils.fromSN(source.getFlFuoriTermine()));
			target.setId(source.getOrdinePreferenza());
			target.setIndirizzo(source.getIndirizzo());
			target.setPosizione(source.getOrdinePreferenza());
			target.setPunteggio(source.getPunteggio());
			target.setRinuncia(null);
		}

		return target;
	}

}
