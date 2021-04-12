package it.csi.iscritto.serviscritto.business.integration.converter.nido;

import java.io.Serializable;
import java.util.Optional;

import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTComune;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTStato;
import it.csi.iscritto.serviscritto.business.util.converter.AbstractConverter;
import it.csi.iscritto.serviscritto.dto.domanda.LuogoNascita;

public class LuogoNascitaConverter extends AbstractConverter<LuogoNascitaConverter.Data, LuogoNascita> {

	@Override
	public LuogoNascita convert(Data source) {
		LuogoNascita target = null;
		if (source != null) {
			IscrittoTStato stato = Optional.ofNullable(source.getStato()).orElse(new IscrittoTStato());
			IscrittoTComune comune = Optional.ofNullable(source.getComune()).orElse(new IscrittoTComune());

			target = new LuogoNascita();

			target.setCodComune(comune.getIstatComune());
			target.setCodNazione(stato.getCodice());
			target.setCodProvincia(comune.getIstatProvincia());
			target.setCodRegione(comune.getIstatRegione());
			target.setDescComune(comune.getDescComune());
			target.setDescNazione(stato.getStato());
			target.setDescProvincia(comune.getDescProvincia());
			target.setDescRegione(comune.getDescRegione());
		}

		return target;
	}

	public static final LuogoNascita buildEmpty() {
		return new LuogoNascita();
	}

	public static final class Data implements Serializable {
		private static final long serialVersionUID = 1L;

		private IscrittoTStato stato;
		private IscrittoTComune comune;

		public IscrittoTStato getStato() {
			return stato;
		}

		public void setStato(IscrittoTStato stato) {
			this.stato = stato;
		}

		public IscrittoTComune getComune() {
			return comune;
		}

		public void setComune(IscrittoTComune comune) {
			this.comune = comune;
		}
	}

}
