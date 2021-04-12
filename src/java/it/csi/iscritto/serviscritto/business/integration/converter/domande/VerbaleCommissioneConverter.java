package it.csi.iscritto.serviscritto.business.integration.converter.domande;

import it.csi.iscritto.serviscritto.business.integration.dao.custom.dto.VerbaleCommissioneRow;
import it.csi.iscritto.serviscritto.business.util.converter.AbstractConverter;
import it.csi.iscritto.serviscritto.business.util.converter.ConvertUtils;
import it.csi.iscritto.serviscritto.dto.domanda.VerbaleCommissione;

public class VerbaleCommissioneConverter extends AbstractConverter<VerbaleCommissioneRow, VerbaleCommissione> {

	@Override
	public VerbaleCommissione convert(VerbaleCommissioneRow source) {
		VerbaleCommissione target = null;
		if (source != null) {
			target = new VerbaleCommissione();

			target.setCodiceFiscaleMinore(source.getCodiceFiscaleMinore());
			target.setCognomeMinore(source.getCognomeMinore());
			target.setEsito(source.getNote());
			target.setIndirizzoScuolaPrimaScelta(source.getIndirizzoScuolaPrimaScelta());
			target.setNomeMinore(source.getNomeMinore());
			target.setNomeScuolaPrimaScelta(source.getNomeScuolaPrimaScelta());
			target.setProtocollo(source.getProtocollo());

			Boolean valida = ConvertUtils.fromSN(source.getFlValida());
			if (Boolean.TRUE.equals(valida)) {
				target.setDataRifiuto(null);
				target.setDataValidazione(source.getDtInizioValidita());
			}
			else if (Boolean.FALSE.equals(valida)) {
				target.setDataRifiuto(source.getDtInizioValidita());
				target.setDataValidazione(null);
			}
			else {
				target.setDataRifiuto(null);
				target.setDataValidazione(null);
			}
		}

		return target;
	}

}
