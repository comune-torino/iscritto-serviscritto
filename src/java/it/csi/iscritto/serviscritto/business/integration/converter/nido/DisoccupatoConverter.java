package it.csi.iscritto.serviscritto.business.integration.converter.nido;

import java.io.Serializable;
import java.util.Optional;

import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoDTipoPre;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTDisoccupato;
import it.csi.iscritto.serviscritto.business.util.DateUtils;
import it.csi.iscritto.serviscritto.business.util.converter.AbstractConverter;
import it.csi.iscritto.serviscritto.dto.domanda.DatiCiDisoccupato;
import it.csi.iscritto.serviscritto.dto.domanda.Disoccupato;

public class DisoccupatoConverter extends AbstractConverter<DisoccupatoConverter.Data, Disoccupato> {

	@Override
	public Disoccupato convert(Data source) {
		Disoccupato target = null;
		if (source != null && source.getDisoccupato() != null) {
			IscrittoTDisoccupato disoccupato = Optional.ofNullable(source.getDisoccupato()).orElse(new IscrittoTDisoccupato());
			IscrittoDTipoPre decTipoPre = Optional.ofNullable(source.getDecTipoPre()).orElse(new IscrittoDTipoPre());

			DatiCiDisoccupato datiCi = new DatiCiDisoccupato();
			datiCi.setComune(disoccupato.getComuneCpi());
			datiCi.setProvincia(disoccupato.getProvinciaCpi());

			target = new Disoccupato();
			target.setDataDichiarazione(DateUtils.toStringDate(disoccupato.getDtDichiarazioneDisponibili(), DateUtils.DEFAULT_DATE_FORMAT));
			target.setSoggettoDichiarazione(decTipoPre.getCodTipoPresentazione());
			target.setDatiCi(datiCi);
		}

		return target;
	}

	public static final Disoccupato buildEmpty() {
		DatiCiDisoccupato datiCi = new DatiCiDisoccupato();

		Disoccupato target = new Disoccupato();
		target.setDatiCi(datiCi);

		return target;
	}

	public static final class Data implements Serializable {
		private static final long serialVersionUID = 1L;

		private IscrittoTDisoccupato disoccupato;
		private IscrittoDTipoPre decTipoPre;

		public IscrittoTDisoccupato getDisoccupato() {
			return disoccupato;
		}

		public void setDisoccupato(IscrittoTDisoccupato disoccupato) {
			this.disoccupato = disoccupato;
		}

		public IscrittoDTipoPre getDecTipoPre() {
			return decTipoPre;
		}

		public void setDecTipoPre(IscrittoDTipoPre decTipoPre) {
			this.decTipoPre = decTipoPre;
		}
	}

}
