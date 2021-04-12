package it.csi.iscritto.serviscritto.business.integration.converter.domande;

import it.csi.iscritto.serviscritto.business.integration.dao.custom.dto.AnagraficaGraduatoriaRow;
import it.csi.iscritto.serviscritto.business.util.converter.AbstractConverter;
import it.csi.iscritto.serviscritto.dto.domanda.AnagraficaGraduatoria;

public class AnagraficaGraduatoriaConverter extends AbstractConverter<AnagraficaGraduatoriaRow, AnagraficaGraduatoria> {

	@Override
	public AnagraficaGraduatoria convert(AnagraficaGraduatoriaRow source) {
		AnagraficaGraduatoria target = null;
		if (source != null) {
			target = new AnagraficaGraduatoria();

			target.setCodAnagraficaGraduatoria(source.getCodAnagraficaGra());
			target.setCodAnnoScolastico(source.getCodAnnoScolastico());
			target.setCodOrdineScuola(source.getCodOrdineScuola());
			target.setDataFineIscrizioni(source.getDtFineIscr());
			target.setDataInizioIscrizioni(source.getDtInizioIscr());
			target.setDataScadenzaGraduatoria(source.getDtScadenzaGrad());
			target.setDataScadenzaIscrizioni(source.getDtScadenzaIscr());
			target.setDataScadenzaRicorsi(source.getDtScadenzaRicorsi());
			target.setIdAnagraficaGraduatoria(source.getIdAnagraficaGra());
		}

		return target;
	}

}
