package it.csi.iscritto.serviscritto.business.integration.converter.domande;

import it.csi.iscritto.serviscritto.business.integration.dao.view.dto.TestataDomandaDaVerificareRow;
import it.csi.iscritto.serviscritto.business.util.converter.AbstractConverter;
import it.csi.iscritto.serviscritto.business.util.converter.ConvertUtils;
import it.csi.iscritto.serviscritto.dto.domanda.TestataDomandaDaVerificare;

public class TestataDomandaDaVerificareConverter extends AbstractConverter<TestataDomandaDaVerificareRow, TestataDomandaDaVerificare> {

	@Override
	public TestataDomandaDaVerificare convert(TestataDomandaDaVerificareRow source) {
		TestataDomandaDaVerificare target = new TestataDomandaDaVerificare();
		if (source != null) {
			target.setCodiceFiscaleMinore(source.getCodiceFiscaleMinore());
			target.setCodStatoDomanda(source.getCodStatoDom());
			target.setCognomeMinore(source.getCognomeMinore());
			target.setIdDomandaIscrizione(source.getIdDomandaIscrizione());
			target.setNomeMinore(source.getNomeMinore());
			target.setPaDis(ConvertUtils.fromSN(source.getFlPaDis()));
			target.setPaPrbSal(ConvertUtils.fromSN(source.getFlPaPrbSal()));
			target.setProtocollo(source.getProtocollo());
		}

		return target;
	}

}
