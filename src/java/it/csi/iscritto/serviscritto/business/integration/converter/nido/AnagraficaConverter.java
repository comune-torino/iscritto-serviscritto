package it.csi.iscritto.serviscritto.business.integration.converter.nido;

import it.csi.iscritto.serviscritto.business.integration.dao.view.dto.SoggettoRow;
import it.csi.iscritto.serviscritto.business.util.DateUtils;
import it.csi.iscritto.serviscritto.business.util.converter.AbstractConverter;
import it.csi.iscritto.serviscritto.dto.domanda.Anagrafica;

public class AnagraficaConverter extends AbstractConverter<SoggettoRow, Anagrafica> {

	@Override
	public Anagrafica convert(SoggettoRow source) {
		Anagrafica target = null;
		if (source != null) {
			target = new Anagrafica();

			target.setCodiceFiscale(source.getCodiceFiscale());
			target.setCognome(source.getCognome());
			target.setDataNascita(DateUtils.toStringDate(source.getDataNascita(), DateUtils.DEFAULT_DATE_FORMAT));
			target.setNome(source.getNome());
			target.setOraMinutiNascita(source.getOraNascita());
			target.setSesso(source.getSesso());
			target.setCodCittadinanza(source.getCodCittadinanza());
			target.setDescCittadinanza(source.getDescCittadinanza());
		}

		return target;
	}

	public static final Anagrafica buildEmpty() {
		return new Anagrafica();
	}

}
