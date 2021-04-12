package it.csi.iscritto.serviscritto.business.integration.converter.domande;

import it.csi.iscritto.serviscritto.business.integration.dao.custom.dto.TestataGraduatoriaRow;
import it.csi.iscritto.serviscritto.business.util.converter.AbstractConverter;
import it.csi.iscritto.serviscritto.dto.domanda.TestataGraduatoria;

public class TestataGraduatoriaConverter extends AbstractConverter<TestataGraduatoriaRow, TestataGraduatoria> {

	@Override
	public TestataGraduatoria convert(TestataGraduatoriaRow source) {
		TestataGraduatoria target = null;
		if (source != null) {
			target = new TestataGraduatoria();

			target.setCodStatoScuolaDse(source.getCodStatoScuDse());
			target.setCodStatoScuolaEco(source.getCodStatoScuEco());
			target.setCodTipoFrequenza(source.getCodTipoFrequenza());
			target.setCognomeMinore(source.getCognomeMinore());
			target.setDataNascitaMinore(source.getDataNascita());
			target.setDescrizioneScuola(source.getDescrizioneScuola());
			target.setIdDomandaIscrizione(source.getIdDomandaIscrizione());
			target.setIsee(source.getIsee());
			target.setNomeMinore(source.getNomeMinore());
			target.setOrdinamento(source.getOrdinamento());
			target.setOrdinePreferenza(source.getOrdinePreferenza());
			target.setProtocolloDomanda(source.getProtocollo());
			target.setPunteggio(source.getPunteggio());
		}

		return target;
	}

}
