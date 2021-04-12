package it.csi.iscritto.serviscritto.business.integration.converter.report;

import it.csi.iscritto.serviscritto.business.integration.dao.custom.dto.ReportPostiLiberiRow;
import it.csi.iscritto.serviscritto.business.util.converter.AbstractConverter;
import it.csi.iscritto.serviscritto.dto.domanda.RecordPostiLiberi;

public class ReportPostiLiberiConverter extends AbstractConverter<ReportPostiLiberiRow, RecordPostiLiberi> {

	@Override
	public RecordPostiLiberi convert(ReportPostiLiberiRow source) {
		RecordPostiLiberi target = null;
		if (source != null) {
			target = new RecordPostiLiberi();

			target.setCodAnagraficaGraduatoria(source.getCodAnagraficaGraduatoria());
			target.setCodOrdineScuola(source.getCodOrdineScuola());
			target.setCodScuola(source.getCodScuola());
			target.setDataCreazione(source.getDataCreazione());
			target.setDescFasciaEta(source.getDescFasciaEta());
			target.setDescTipoFrequenza(source.getDescTipoFrequenza());
			target.setIndirizzoScuola(source.getIndirizzoScuola());
			target.setPostiAmmessi(source.getPostiAmmessi());
			target.setPostiLiberi(source.getPostiLiberi());
		}

		return target;
	}

}
