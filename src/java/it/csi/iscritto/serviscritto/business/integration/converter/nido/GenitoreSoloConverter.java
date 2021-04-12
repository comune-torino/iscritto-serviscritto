package it.csi.iscritto.serviscritto.business.integration.converter.nido;

import java.io.Serializable;
import java.util.Optional;

import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoDGenitoreSol;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTGenitoreSolo;
import it.csi.iscritto.serviscritto.business.util.DateUtils;
import it.csi.iscritto.serviscritto.business.util.converter.AbstractConverter;
import it.csi.iscritto.serviscritto.dto.domanda.GenitoreSolo;
import it.csi.iscritto.serviscritto.dto.domanda.Sentenza;

public class GenitoreSoloConverter extends AbstractConverter<GenitoreSoloConverter.Data, GenitoreSolo> {

	@Override
	public GenitoreSolo convert(Data source) {
		GenitoreSolo target = null;
		if (source != null && source.getGenitoreSolo() != null) {
			IscrittoTGenitoreSolo genitoreSolo = Optional.ofNullable(source.getGenitoreSolo()).orElse(new IscrittoTGenitoreSolo());
			IscrittoDGenitoreSol decGenitoreSol = Optional.ofNullable(source.getDecGenitoreSol()).orElse(new IscrittoDGenitoreSol());

			Sentenza sentenza = new Sentenza();
			sentenza.setData(DateUtils.toStringDate(genitoreSolo.getDtSentenza(), DateUtils.DEFAULT_DATE_FORMAT));
			sentenza.setNumero(genitoreSolo.getNumSentenza());
			sentenza.setTribunale(genitoreSolo.getTribunale());

			target = new GenitoreSolo();
			target.setStato(decGenitoreSol.getCodTipoGenitoreSolo());
			target.setSentenza(sentenza);
		}

		return target;
	}

	public static final GenitoreSolo buildEmpty() {
		GenitoreSolo target = new GenitoreSolo();
		target.setSentenza(SentenzaConverter.buildEmpty());

		return target;
	}

	public static final class Data implements Serializable {
		private static final long serialVersionUID = 1L;

		private IscrittoTGenitoreSolo genitoreSolo;
		private IscrittoDGenitoreSol decGenitoreSol;

		public IscrittoTGenitoreSolo getGenitoreSolo() {
			return genitoreSolo;
		}

		public void setGenitoreSolo(IscrittoTGenitoreSolo genitoreSolo) {
			this.genitoreSolo = genitoreSolo;
		}

		public IscrittoDGenitoreSol getDecGenitoreSol() {
			return decGenitoreSol;
		}

		public void setDecGenitoreSol(IscrittoDGenitoreSol decGenitoreSol) {
			this.decGenitoreSol = decGenitoreSol;
		}
	}

}
