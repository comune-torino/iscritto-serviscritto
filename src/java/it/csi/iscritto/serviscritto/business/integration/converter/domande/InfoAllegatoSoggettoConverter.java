package it.csi.iscritto.serviscritto.business.integration.converter.domande;

import it.csi.iscritto.serviscritto.business.integration.dao.custom.dto.InfoAllegatoSoggettoRow;
import it.csi.iscritto.serviscritto.business.util.converter.AbstractConverter;
import it.csi.iscritto.serviscritto.dto.domanda.InfoAllegatoSoggetto;

public class InfoAllegatoSoggettoConverter extends AbstractConverter<InfoAllegatoSoggettoRow, InfoAllegatoSoggetto> {

	@Override
	public InfoAllegatoSoggetto convert(InfoAllegatoSoggettoRow source) {
		InfoAllegatoSoggetto target = null;

		if (source != null) {
			target = new InfoAllegatoSoggetto();

			target.setCodCondizione(source.getCodCondizione());
			target.setCodiceFiscaleRichiedente(source.getCodiceFiscaleRichiedente());
			target.setCodiceFiscaleSoggetto(source.getCodiceFiscaleSoggetto());
			target.setCodTipoAllegato(source.getCodTipoAllegato());
			target.setCodTipoAllegatoRed(source.getCodTipoAllegatoRed());
			target.setCodTipoSoggetto(source.getCodTipoSoggetto());
			target.setCognome(source.getCognome());
			target.setIdAllegato(source.getIdAllegato());
			target.setIdAnagraficaSoggetto(source.getIdAnagraficaSoggetto());
			target.setIdDomandaIscrizione(source.getIdDomandaIscrizione());
			target.setMimeType(source.getMimeType());
			target.setNome(source.getNome());
			target.setNomeFile(source.getNomeFile());
			target.setProtocollo(source.getProtocollo());
			target.setDataInserimento(source.getDataInserimento());
		}

		return target;
	}

}
