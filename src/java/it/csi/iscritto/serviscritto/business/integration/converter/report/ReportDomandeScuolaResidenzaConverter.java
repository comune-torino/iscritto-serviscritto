package it.csi.iscritto.serviscritto.business.integration.converter.report;

import it.csi.iscritto.serviscritto.business.integration.dao.custom.dto.ReportDomandeScuolaResidenzaRow;
import it.csi.iscritto.serviscritto.business.util.converter.AbstractConverter;
import it.csi.iscritto.serviscritto.dto.domanda.RecordDomandeScuolaResidenza;

public class ReportDomandeScuolaResidenzaConverter extends AbstractConverter<ReportDomandeScuolaResidenzaRow, RecordDomandeScuolaResidenza> {

	@Override
	public RecordDomandeScuolaResidenza convert(ReportDomandeScuolaResidenzaRow source) {
		RecordDomandeScuolaResidenza target = null;
		if (source != null) {
			target = new RecordDomandeScuolaResidenza();

			target.setProtocollo(source.getProtocollo());
			target.setCodiceFiscaleMinore(source.getCodiceFiscaleMinore());
			target.setCognomeMinore(source.getCognomeMinore());
			target.setNomeMinore(source.getNomeMinore());
			target.setCodiceScuola(source.getCodiceScuola());
			target.setDescScuola(source.getDescScuola());
			target.setIndirizzoScuola(source.getIndirizzoScuola());

		}

		return target;
	}

}
