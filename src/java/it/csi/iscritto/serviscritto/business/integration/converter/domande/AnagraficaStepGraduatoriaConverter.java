package it.csi.iscritto.serviscritto.business.integration.converter.domande;

import it.csi.iscritto.serviscritto.business.integration.dao.custom.dto.AnagraficaStepGraduatoriaRow;
import it.csi.iscritto.serviscritto.business.util.converter.AbstractConverter;
import it.csi.iscritto.serviscritto.dto.domanda.AnagraficaStepGraduatoria;

public class AnagraficaStepGraduatoriaConverter extends AbstractConverter<AnagraficaStepGraduatoriaRow, AnagraficaStepGraduatoria> {

	@Override
	public AnagraficaStepGraduatoria convert(AnagraficaStepGraduatoriaRow source) {
		AnagraficaStepGraduatoria target = null;
		if (source != null) {
			target = new AnagraficaStepGraduatoria();

			target.setDtAllegati(source.getDtAllegati());
			target.setDtDomInvA(source.getDtDomInvA());
			target.setDtDomInvDa(source.getDtDomInvDa());
			target.setDtStepGra(source.getDtStepGra());
			target.setIdStepGra(source.getIdStepGra());
			target.setStep(source.getStep());
			target.setCodAnagraficaGraduatoria(source.getCodAnagraficaGra());
			target.setCodOrdineScuola(source.getCodOrdineScuola());
			target.setCodAnnoScolastico(source.getCodAnnoScolastico());
		}

		return target;
	}

}
