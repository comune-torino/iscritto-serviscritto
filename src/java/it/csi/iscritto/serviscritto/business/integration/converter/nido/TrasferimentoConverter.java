package it.csi.iscritto.serviscritto.business.integration.converter.nido;

import static it.csi.iscritto.serviscritto.business.util.converter.ConvertUtils.fromSN;

import java.io.Serializable;
import java.util.Optional;

import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTDomandaIsc;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTTrasferimento;
import it.csi.iscritto.serviscritto.business.util.DateUtils;
import it.csi.iscritto.serviscritto.business.util.converter.AbstractConverter;
import it.csi.iscritto.serviscritto.dto.domanda.DatiTrasferimento;
import it.csi.iscritto.serviscritto.dto.domanda.Trasferimento;

public class TrasferimentoConverter extends AbstractConverter<TrasferimentoConverter.Data, Trasferimento> {

	@Override
	public Trasferimento convert(Data source) {
		Trasferimento target = null;
		if (source != null) {
			IscrittoTDomandaIsc domandaIsc = source.getDomandaIsc();
			IscrittoTTrasferimento trasferimento = Optional.ofNullable(source.getTrasferimento()).orElse(new IscrittoTTrasferimento());

			DatiTrasferimento datiTrasferimento = new DatiTrasferimento();
			datiTrasferimento.setData(DateUtils.toStringDate(trasferimento.getDtCambioResidenza(), DateUtils.DEFAULT_DATE_FORMAT));
			datiTrasferimento.setDataAl(DateUtils.toStringDate(trasferimento.getFrequenzaAl(), DateUtils.DEFAULT_DATE_FORMAT));
			datiTrasferimento.setDataDal(DateUtils.toStringDate(trasferimento.getFrequenzaDal(), DateUtils.DEFAULT_DATE_FORMAT));
			datiTrasferimento.setIndirizzoNido(trasferimento.getIndirizzoNidoProv());
			datiTrasferimento.setIndirizzoNuovo(trasferimento.getIndirizzoResidenzaNew());
			datiTrasferimento.setIndirizzoVecchio(trasferimento.getIndirizzoResidenzaPre());

			target = new Trasferimento();
			target.setDati(datiTrasferimento);
			target.setStato(fromSN(domandaIsc.getFlTrasferimento()));
		}

		return target;
	}

	public static final Trasferimento buildEmpty() {
		DatiTrasferimento datiTrasferimento = new DatiTrasferimento();

		Trasferimento target = new Trasferimento();
		target.setDati(datiTrasferimento);

		return target;
	}

	public static final class Data implements Serializable {
		private static final long serialVersionUID = 1L;

		private IscrittoTDomandaIsc domandaIsc;
		private IscrittoTTrasferimento trasferimento;

		public IscrittoTDomandaIsc getDomandaIsc() {
			return domandaIsc;
		}

		public void setDomandaIsc(IscrittoTDomandaIsc domandaIsc) {
			this.domandaIsc = domandaIsc;
		}

		public IscrittoTTrasferimento getTrasferimento() {
			return trasferimento;
		}

		public void setTrasferimento(IscrittoTTrasferimento trasferimento) {
			this.trasferimento = trasferimento;
		}
	}

}
