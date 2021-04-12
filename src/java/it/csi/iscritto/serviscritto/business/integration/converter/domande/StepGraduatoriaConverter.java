package it.csi.iscritto.serviscritto.business.integration.converter.domande;

import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTStepGra;
import it.csi.iscritto.serviscritto.business.util.converter.AbstractConverter;
import it.csi.iscritto.serviscritto.dto.domanda.StepGraduatoria;

public class StepGraduatoriaConverter extends AbstractConverter<IscrittoTStepGra, StepGraduatoria> {

	@Override
	public StepGraduatoria convert(IscrittoTStepGra source) {
		StepGraduatoria target = null;
		if (source != null) {
			target = new StepGraduatoria();
			target.setDataInvioA(source.getDtDomInvA());
			target.setDataInvioDa(source.getDtDomInvDa());
			target.setDataStepGraduatoria(source.getDtStepGra());
			target.setId(source.getIdAnagraficaGra());
			target.setStep(source.getStep());
		}

		return target;
	}

}
