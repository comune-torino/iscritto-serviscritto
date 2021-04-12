package it.csi.iscritto.serviscritto.business.integration.converter.materna;

import static it.csi.iscritto.serviscritto.business.util.converter.ConvertUtils.fromSN;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;

import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTDomandaIsc;
import it.csi.iscritto.serviscritto.business.util.converter.AbstractConverter;
import it.csi.iscritto.serviscritto.dto.domanda.DatiAnnoListaAttesa;
import it.csi.iscritto.serviscritto.dto.domanda.DatiListaAttesa;
import it.csi.iscritto.serviscritto.dto.domanda.ListaAttesa;

public class ListaAttesaConverter extends AbstractConverter<ListaAttesaConverter.Data, ListaAttesa> {

	@Override
	public ListaAttesa convert(Data source) {
		ListaAttesa target = null;
		if (source != null) {
			IscrittoTDomandaIsc domandaIsc = source.getDomandaIsc();

			int size = CollectionUtils.size(source.getAnniListaAttesa());

			DatiListaAttesa datiListaAttesa = new DatiListaAttesa();
			datiListaAttesa.setPrimoAnno(size > 0 ? source.getAnniListaAttesa().get(0) : new DatiAnnoListaAttesa());
			datiListaAttesa.setSecondoAnno(size > 1 ? source.getAnniListaAttesa().get(1) : new DatiAnnoListaAttesa());

			target = new ListaAttesa();
			target.setStato(fromSN(domandaIsc.getFlListaAttesa()));
			target.setDati(datiListaAttesa);
		}

		return target;
	}

	public static final class Data implements Serializable {
		private static final long serialVersionUID = 1L;

		private IscrittoTDomandaIsc domandaIsc;

		private List<DatiAnnoListaAttesa> anniListaAttesa;

		public IscrittoTDomandaIsc getDomandaIsc() {
			return domandaIsc;
		}

		public void setDomandaIsc(IscrittoTDomandaIsc domandaIsc) {
			this.domandaIsc = domandaIsc;
		}

		public List<DatiAnnoListaAttesa> getAnniListaAttesa() {
			return anniListaAttesa;
		}

		public void setAnniListaAttesa(List<DatiAnnoListaAttesa> anniListaAttesa) {
			this.anniListaAttesa = anniListaAttesa;
		}
	}

}
