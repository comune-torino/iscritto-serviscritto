package it.csi.iscritto.serviscritto.business.integration.converter.materna;

import static it.csi.iscritto.serviscritto.business.util.converter.ConvertUtils.fromSN;

import java.io.Serializable;
import java.util.Optional;

import it.csi.iscritto.serviscritto.business.integration.converter.nido.AnagraficaConverter;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTDomandaIsc;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTScuola;
import it.csi.iscritto.serviscritto.business.util.converter.AbstractConverter;
import it.csi.iscritto.serviscritto.dto.domanda.Anagrafica;
import it.csi.iscritto.serviscritto.dto.domanda.FratelloNidoContiguo;
import it.csi.iscritto.serviscritto.dto.domanda.NidoContiguo;

public class FratelloNidoContiguoConverter extends AbstractConverter<FratelloNidoContiguoConverter.Data, FratelloNidoContiguo> {

	@Override
	public FratelloNidoContiguo convert(Data source) {
		FratelloNidoContiguo target = null;
		if (source != null) {
			IscrittoTDomandaIsc domandaIsc = source.getDomandaIsc();
			Anagrafica anagrafica = Optional.ofNullable(source.getAnagrafica()).orElse(AnagraficaConverter.buildEmpty());
			IscrittoTScuola nidoContiguo = Optional.ofNullable(source.getNidoContiguo()).orElse(new IscrittoTScuola());

			target = new FratelloNidoContiguo();
			target.setStato(fromSN(domandaIsc.getFlFratelloContiguo()));
			target.setAnagrafica(anagrafica);

			NidoContiguo nc = new NidoContiguo();
			nc.setDescrizione(nidoContiguo.getDescrizione());
			nc.setIndirizzo(nidoContiguo.getIndirizzo());
			target.setNidoContiguo(nc);
		}

		return target;
	}

	public static final class Data implements Serializable {
		private static final long serialVersionUID = 1L;

		private IscrittoTDomandaIsc domandaIsc;
		private IscrittoTScuola nidoContiguo;

		private Anagrafica anagrafica;

		public IscrittoTDomandaIsc getDomandaIsc() {
			return domandaIsc;
		}

		public void setDomandaIsc(IscrittoTDomandaIsc domandaIsc) {
			this.domandaIsc = domandaIsc;
		}

		public Anagrafica getAnagrafica() {
			return anagrafica;
		}

		public void setAnagrafica(Anagrafica anagrafica) {
			this.anagrafica = anagrafica;
		}

		public IscrittoTScuola getNidoContiguo() {
			return nidoContiguo;
		}

		public void setNidoContiguo(IscrittoTScuola nidoContiguo) {
			this.nidoContiguo = nidoContiguo;
		}
	}

}
