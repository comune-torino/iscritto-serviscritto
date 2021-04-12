package it.csi.iscritto.serviscritto.business.integration.converter.domande;

import it.csi.iscritto.serviscritto.business.integration.dao.custom.dto.InfoStepGraduatoriaRow;
import it.csi.iscritto.serviscritto.business.util.converter.AbstractConverter;
import it.csi.iscritto.serviscritto.dto.domanda.InfoStepGraduatoria;

public class InfoStepGraduatoriaConverter extends AbstractConverter<InfoStepGraduatoriaRow, InfoStepGraduatoria> {

	@Override
	public InfoStepGraduatoria convert(InfoStepGraduatoriaRow source) {
		InfoStepGraduatoria target = null;
		if (source != null) {
			target = new InfoStepGraduatoria();

			target.setCodAnagraficaGra(source.getCodAnagraficaGra());
			target.setCodAnnoScolastico(source.getCodAnnoScolastico());
			target.setCodStatoGra(source.getCodStatoGra());
			target.setDtStepCon(source.getDtStepCon());
			target.setDtStepGra(source.getDtStepGra());
			target.setFlAmmissioni(source.getFlAmmissioni());
			target.setIdAnagraficaGra(source.getIdAnagraficaGra());
			target.setIdStepGra(source.getIdStepGra());
			target.setIdStepGraCon(source.getIdStepGraCon());
			target.setStep(source.getStep());
		}

		return target;
	}

}
