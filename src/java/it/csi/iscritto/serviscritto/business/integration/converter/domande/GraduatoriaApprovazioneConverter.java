package it.csi.iscritto.serviscritto.business.integration.converter.domande;

import it.csi.iscritto.serviscritto.business.integration.dao.custom.dto.GraduatoriaApprovazioneRow;
import it.csi.iscritto.serviscritto.business.util.converter.AbstractConverter;
import it.csi.iscritto.serviscritto.dto.domanda.GraduatoriaApprovazione;

public class GraduatoriaApprovazioneConverter extends AbstractConverter<GraduatoriaApprovazioneRow, GraduatoriaApprovazione> {

	@Override
	public GraduatoriaApprovazione convert(GraduatoriaApprovazioneRow source) {
		GraduatoriaApprovazione target = null;
		if (source != null) {
			target = new GraduatoriaApprovazione();

			target.setCodFasciaEta(source.getCodFasciaEta());
			target.setCognome(source.getCognome());
			target.setDataConsegna(source.getDataConsegna());
			target.setDataNascita(source.getDataNascita());
			target.setFlFuoriTermine(source.getFlFuoriTermine());
			target.setIsee(source.getIsee());
			target.setNome(source.getNome());
			target.setOraNascita(source.getOraNascita());
			target.setProtocollo(source.getProtocollo());
			target.setPunteggio(source.getPunteggio());
			target.setPunteggioPrimaScelta(source.getPunteggioPrimaScelta());
			target.setIdDomandaIscrizione(source.getIdDomandaIscrizione());
		}

		return target;
	}

}
