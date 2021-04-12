package it.csi.iscritto.serviscritto.business.integration.converter.nido;

import static it.csi.iscritto.serviscritto.business.util.converter.ConvertUtils.fromSN;

import java.io.Serializable;
import java.util.Optional;

import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoDTipoCambioRes;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTCambioRes;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTDomandaIsc;
import it.csi.iscritto.serviscritto.business.util.DateUtils;
import it.csi.iscritto.serviscritto.business.util.converter.AbstractConverter;
import it.csi.iscritto.serviscritto.dto.domanda.DatiSpostamento;
import it.csi.iscritto.serviscritto.dto.domanda.Spostamento;

public class SpostamentoConverter extends AbstractConverter<SpostamentoConverter.Data, Spostamento> {

	@Override
	public Spostamento convert(Data source) {
		Spostamento target = null;
		if (source != null) {
			IscrittoTDomandaIsc domandaIsc = source.getDomandaIsc();
			IscrittoTCambioRes cambioRes = Optional.ofNullable(source.getCambioRes()).orElse(new IscrittoTCambioRes());
			IscrittoDTipoCambioRes decTipoCambioRes = Optional.ofNullable(source.getDecTipoCambioRes()).orElse(new IscrittoDTipoCambioRes());

			DatiSpostamento datiSpostamento = new DatiSpostamento();
			datiSpostamento.setDataAppuntamento(DateUtils.toStringDate(cambioRes.getDtAppuntamento(), DateUtils.DEFAULT_DATE_FORMAT));
			datiSpostamento.setDataVariazione(DateUtils.toStringDate(cambioRes.getDtVariazione(), DateUtils.DEFAULT_DATE_FORMAT));
			datiSpostamento.setResidenzaFutura(cambioRes.getMotivazione());
			datiSpostamento.setIndirizzo(cambioRes.getIndirizzo());
			datiSpostamento.setStato(decTipoCambioRes.getCodTipoCambioRes());

			target = new Spostamento();
			target.setDati(datiSpostamento);
			target.setStato(fromSN(domandaIsc.getFlResidenzaForzata()));
		}

		return target;
	}

	public static final Spostamento buildEmpty() {
		DatiSpostamento datiSpostamento = new DatiSpostamento();

		Spostamento target = new Spostamento();
		target.setDati(datiSpostamento);

		return target;
	}

	public static final class Data implements Serializable {
		private static final long serialVersionUID = 1L;

		private IscrittoTDomandaIsc domandaIsc;
		private IscrittoTCambioRes cambioRes;
		private IscrittoDTipoCambioRes decTipoCambioRes;

		public IscrittoTDomandaIsc getDomandaIsc() {
			return domandaIsc;
		}

		public void setDomandaIsc(IscrittoTDomandaIsc domandaIsc) {
			this.domandaIsc = domandaIsc;
		}

		public IscrittoTCambioRes getCambioRes() {
			return cambioRes;
		}

		public void setCambioRes(IscrittoTCambioRes cambioRes) {
			this.cambioRes = cambioRes;
		}

		public IscrittoDTipoCambioRes getDecTipoCambioRes() {
			return decTipoCambioRes;
		}

		public void setDecTipoCambioRes(IscrittoDTipoCambioRes decTipoCambioRes) {
			this.decTipoCambioRes = decTipoCambioRes;
		}
	}

}
