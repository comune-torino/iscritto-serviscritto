package it.csi.iscritto.serviscritto.business.integration.converter.nido;

import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTAffido;
import it.csi.iscritto.serviscritto.business.util.DateUtils;
import it.csi.iscritto.serviscritto.business.util.converter.AbstractConverter;
import it.csi.iscritto.serviscritto.dto.domanda.Sentenza;

public class SentenzaConverter extends AbstractConverter<IscrittoTAffido, Sentenza> {

	@Override
	public Sentenza convert(IscrittoTAffido source) {
		Sentenza target = null;
		if (source != null) {
			target = new Sentenza();

			target.setData(DateUtils.toStringDate(source.getDtSentenza(), DateUtils.DEFAULT_DATE_FORMAT));
			target.setNumero(source.getNumSentenza());
			target.setTribunale(source.getComuneTribunale());
		}

		return target;
	}

	public static final Sentenza buildEmpty() {
		return new Sentenza();
	}

}
