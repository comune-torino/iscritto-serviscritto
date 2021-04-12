package it.csi.iscritto.serviscritto.business.integration.converter.nido;

import static it.csi.iscritto.serviscritto.business.util.converter.ConvertUtils.fromSN;

import java.io.Serializable;
import java.util.Optional;

import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTComune;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTIndirizzoRes;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTStato;
import it.csi.iscritto.serviscritto.business.util.converter.AbstractConverter;
import it.csi.iscritto.serviscritto.dto.domanda.Residenza;

public class ResidenzaConverter extends AbstractConverter<ResidenzaConverter.Data, Residenza> {

	@Override
	public Residenza convert(Data source) {
		Residenza target = null;
		if (source != null) {
			IscrittoTStato stato = Optional.ofNullable(source.getStato()).orElse(new IscrittoTStato());
			IscrittoTComune comune = Optional.ofNullable(source.getComune()).orElse(new IscrittoTComune());
			IscrittoTIndirizzoRes indirizzoRes = Optional.ofNullable(source.getIndirizzoRes()).orElse(new IscrittoTIndirizzoRes());

			target = new Residenza();

			target.setCodNazione(stato.getCodice());
			target.setDescNazione(stato.getStato());
			target.setCodComune(comune.getIstatComune());
			target.setCodProvincia(comune.getIstatProvincia());
			target.setCodRegione(comune.getIstatRegione());
			target.setDescComune(comune.getDescComune());
			target.setDescProvincia(comune.getDescProvincia());
			target.setDescRegione(comune.getDescRegione());
			target.setCap(indirizzoRes.getCap());
			target.setIndirizzo(indirizzoRes.getIndirizzo());
			//target.setNao(fromSN(indirizzoRes.getFlResidenzaNao()));
		}

		return target;
	}

	public static final Residenza buildEmpty() {
		return new Residenza();
	}

	public static final class Data implements Serializable {
		private static final long serialVersionUID = 1L;

		private IscrittoTStato stato;
		private IscrittoTComune comune;
		private IscrittoTIndirizzoRes indirizzoRes;

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

		public IscrittoTIndirizzoRes getIndirizzoRes() {
			return indirizzoRes;
		}

		public void setIndirizzoRes(IscrittoTIndirizzoRes indirizzoRes) {
			this.indirizzoRes = indirizzoRes;
		}
	}

}
