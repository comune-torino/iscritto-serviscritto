package it.csi.iscritto.serviscritto.business.integration.converter.domande;

import it.csi.iscritto.serviscritto.business.integration.dao.view.dto.TestataDomandaIstruttoriaRow;
import it.csi.iscritto.serviscritto.business.util.DateUtils;
import it.csi.iscritto.serviscritto.business.util.converter.AbstractConverter;
import it.csi.iscritto.serviscritto.business.util.converter.ConvertUtils;
import it.csi.iscritto.serviscritto.dto.domanda.TestataDomandaIstruttoria;

public class TestataDomandeIstruttoriaConverter extends AbstractConverter<TestataDomandaIstruttoriaRow, TestataDomandaIstruttoria> {

	@Override
	public TestataDomandaIstruttoria convert(TestataDomandaIstruttoriaRow source) {
		TestataDomandaIstruttoria target = new TestataDomandaIstruttoria();
		if (source != null) {
			target.setCognomeMinore(source.getCognomeMinore());
			target.setDataConsegna(DateUtils.toStringDate(source.getDataConsegna(), DateUtils.DEFAULT_DATE_FORMAT));
			target.setDataUltimaModifica(DateUtils.toStringDate(source.getDataUltimaModifica(), DateUtils.DEFAULT_DATE_FORMAT));
			target.setIdDomandaIscrizione(source.getIdDomandaIscrizione());
			target.setIndirizzo(source.getIndirizzo());
			target.setNomeMinore(source.getNomeMinore());
			target.setProtocollo(source.getProtocollo());
			target.setRicorrenza(source.getRicorrenza());
			target.setStatoDomandaCodice(source.getStatoDomandaCodice());
			target.setValida(ConvertUtils.fromSN(source.getFlValida()));
		}

		return target;
	}

}
