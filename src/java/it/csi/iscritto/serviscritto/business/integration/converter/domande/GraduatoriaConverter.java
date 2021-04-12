package it.csi.iscritto.serviscritto.business.integration.converter.domande;

import it.csi.iscritto.serviscritto.business.integration.dao.custom.dto.AnagraficaGraduatoriaRow;
import it.csi.iscritto.serviscritto.business.util.converter.AbstractConverter;
import it.csi.iscritto.serviscritto.dto.domanda.Graduatoria;

public class GraduatoriaConverter extends AbstractConverter<AnagraficaGraduatoriaRow, Graduatoria> {

	@Override
	public Graduatoria convert(AnagraficaGraduatoriaRow source) {
		Graduatoria target = null;
		if (source != null) {
			target = new Graduatoria();

			target.setCodAnnoScolastico(source.getCodAnnoScolastico());
			target.setCodice(source.getCodAnagraficaGra());
			target.setCodOrdineScuola(source.getCodOrdineScuola());
			target.setDataFineIscrizioni(source.getDtFineIscr());
			target.setDataInizioIscrizioni(source.getDtInizioIscr());
			target.setDataScadenzaGraduatoria(source.getDtScadenzaGrad());
			target.setDataScadenzaIscrizioni(source.getDtScadenzaIscr());
			target.setDataScadenzaRicorsi(source.getDtScadenzaRicorsi());
			target.setId(source.getIdAnagraficaGra());
		}

		return target;
	}

}
