package it.csi.iscritto.serviscritto.business.integration.converter.domande;

import java.io.Serializable;
import java.util.Optional;

import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoDTipoAll;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTAllegato;
import it.csi.iscritto.serviscritto.business.util.converter.AbstractConverter;
import it.csi.iscritto.serviscritto.dto.domanda.Allegato;

public class AllegatoConverter extends AbstractConverter<AllegatoConverter.Data, Allegato> {

	@Override
	public Allegato convert(Data source) {
		Allegato target = null;
		if (source != null && source.getAllegato() != null) {
			IscrittoTAllegato allegato = source.getAllegato();
			IscrittoDTipoAll decTipoAll = Optional.ofNullable(source.getDecTipoAll()).orElse(new IscrittoDTipoAll());

			target = new Allegato();

			target.setDataInserimento(allegato.getDataInserimento());
			target.setDocumento(allegato.getDocumento());
			target.setIdAllegato(allegato.getIdAllegato());
			target.setIdAnagraficaSoggetto(allegato.getIdAnagraficaSoggetto());
			target.setCodTipoAllegato(decTipoAll.getCodTipoAllegato());
			target.setMimeType(allegato.getMimeType());
			target.setNomeFile(allegato.getNomeFile());
			target.setProtocollo(allegato.getProtocollo());
		}

		return target;
	}

	public static final class Data implements Serializable {
		private static final long serialVersionUID = 1L;

		private IscrittoTAllegato allegato;
		private IscrittoDTipoAll decTipoAll;

		public IscrittoTAllegato getAllegato() {
			return allegato;
		}

		public void setAllegato(IscrittoTAllegato allegato) {
			this.allegato = allegato;
		}

		public IscrittoDTipoAll getDecTipoAll() {
			return decTipoAll;
		}

		public void setDecTipoAll(IscrittoDTipoAll decTipoAll) {
			this.decTipoAll = decTipoAll;
		}
	}

}
