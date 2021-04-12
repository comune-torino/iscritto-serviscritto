package it.csi.iscritto.serviscritto.business.integration.converter.domande;

import it.csi.iscritto.serviscritto.business.integration.dao.view.dto.TestataDomandaRow;
import it.csi.iscritto.serviscritto.business.util.converter.AbstractConverter;
import it.csi.iscritto.serviscritto.dto.domanda.TestataDomanda;

public class TestataDomandeConverter extends AbstractConverter<TestataDomandaRow, TestataDomanda> {

	@Override
	public TestataDomanda convert(TestataDomandaRow source) {
		TestataDomanda target = new TestataDomanda();
		if (source != null) {
			target.setAnnoScolasticoDescrizione(source.getAnnoScolasticoDescrizione());
			target.setCodiceAnnoScolastico(source.getCodiceAnnoScolastico());
			target.setCodiceFiscaleMinore(source.getCodiceFiscaleMinore());
			target.setCodiceFiscaleRichiedente(source.getCodiceFiscaleRichiedente());
			target.setCodiceOrdineScuola(source.getCodOrdineScuola());
			target.setCognomeMinore(source.getCognomeMinore());
			target.setCognomeUtenteUltimaModifica(source.getCognomeUtente());
			target.setDataInvio(source.getDataInvio());
			target.setDataUltimaModifica(source.getDataUltimaModifica());
			target.setIdDomandaIscrizione(source.getIdDomandaIscrizione());
			target.setIdSoggettoMinore(source.getIdSoggettoMinore());
			target.setNomeMinore(source.getNomeMinore());
			target.setNomeUtenteUltimaModifica(source.getNomeUtente());
			target.setProtocollo(source.getProtocollo());
			target.setStatoDomandaCodice(source.getStatoDomandaCodice());
			target.setStatoDomandaDescrizione(source.getStatoDomandaDescrizione());
		}

		return target;
	}

}
