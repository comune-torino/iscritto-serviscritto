package it.csi.iscritto.serviscritto.business.integration.converter.report;

import it.csi.iscritto.serviscritto.business.integration.dao.custom.dto.GraduatoriaCompletaRow;
import it.csi.iscritto.serviscritto.business.util.converter.AbstractConverter;
import it.csi.iscritto.serviscritto.dto.domanda.GraduatoriaCompleta;

public class GraduatoriaCompletaConverter extends AbstractConverter<GraduatoriaCompletaRow, GraduatoriaCompleta> {

	@Override
	public GraduatoriaCompleta convert(GraduatoriaCompletaRow source) {
		GraduatoriaCompleta target = null;
		if (source != null) {
			target = new GraduatoriaCompleta();

			target.setCodFasciaEta(source.getCodFasciaEta());
			target.setCodiceFiscale(source.getCodiceFiscale());
			target.setCognome(source.getCognome());
			target.setIsee(source.getIsee());
			target.setNome(source.getNome());
			target.setProtocollo(source.getProtocollo());
			target.setPunteggio(source.getPunteggio());
			target.setDataConsegna(source.getDataConsegna());
			target.setDataNascita(source.getDataNascita());
			target.setOraNascita(source.getOraNascita());

			target.setPref1(source.getPrefA());
			target.setPref2(source.getPrefB());
			target.setPref3(source.getPrefC());
			target.setPref4(source.getPrefD());
			target.setPref5(source.getPrefE());
			target.setPref6(source.getPrefF());
			target.setPref7(source.getPrefG());
			target.setPref8(source.getPrefH());
			target.setPref9(source.getPrefI());
			target.setPref10(source.getPrefJ());
		}

		return target;
	}

}
