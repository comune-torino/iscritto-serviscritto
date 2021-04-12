package it.csi.iscritto.serviscritto.business.integration.converter.materna;

import static it.csi.iscritto.serviscritto.business.util.converter.ConvertUtils.fromSN;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoDCategoriaScu;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoDCircoscrizione;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoDStatoScu;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoDTipoFre;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoRScuolaPre;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTScuola;
import it.csi.iscritto.serviscritto.business.util.converter.AbstractConverter;
import it.csi.iscritto.serviscritto.dto.domanda.Materna;
import it.csi.iscritto.serviscritto.dto.domanda.NidoContiguo;

public class MaternaConverter extends AbstractConverter<MaternaConverter.Data, Materna> {

	@Override
	public Materna convert(Data source) {
		Materna target = null;
		if (source != null) {
			IscrittoRScuolaPre row = Optional.ofNullable(source.getRow()).orElse(new IscrittoRScuolaPre());
			IscrittoTScuola scuola = Optional.ofNullable(source.getScuola()).orElse(new IscrittoTScuola());
			IscrittoDCategoriaScu decCategoriaScu = Optional.ofNullable(source.getDecCategoriaScu()).orElse(new IscrittoDCategoriaScu());
			IscrittoDTipoFre decTipoFre = Optional.ofNullable(source.getDecTipoFre()).orElse(new IscrittoDTipoFre());
			IscrittoDCircoscrizione decCircoscrizione = Optional.ofNullable(source.getDecCircoscrizione()).orElse(new IscrittoDCircoscrizione());
			IscrittoDStatoScu decStatoScu = Optional.ofNullable(source.getDecStatoScu()).orElse(new IscrittoDStatoScu());
			IscrittoTScuola nidoContiguo = Optional.ofNullable(source.getNidoContiguo()).orElse(new IscrittoTScuola());

			target = new Materna();
			target.setCodCategoriaScuola(decCategoriaScu.getCodiceCategoriaScu());
			target.setCodCircoscrizione(decCircoscrizione.getCodCircoscrizione());
			target.setCodScuola(scuola.getCodScuola());
			target.setCodStatoScuola(decStatoScu.getCodStatoScu());
			target.setCodTipoFrequenza(decTipoFre.getCodTipoFrequenza());
			target.setDescrizione(scuola.getDescrizione());
			target.setId(row.getPosizione());
			target.setIndirizzo(scuola.getIndirizzo());

			NidoContiguo nc = new NidoContiguo();
			nc.setDescrizione(nidoContiguo.getDescrizione());
			nc.setIndirizzo(nidoContiguo.getIndirizzo());
			target.setNidoContiguo(nc);

			target.setPosizione(row.getPosizione());
			target.setPunteggio(row.getPunteggio());
			target.setFuoriTermine(fromSN(row.getFlFuoriTermine()));
			target.setRinuncia(fromSN(row.getFlRinuncia()));
			target.setDataUltimoCambioStato(row.getDtStato());
		}

		return target;
	}

	public static final Materna buildEmpty() {
		return new Materna();
	}

	public static final List<Materna> buildEmptyList() {
		return new ArrayList<>();
	}

	public static final class Data implements Serializable {
		private static final long serialVersionUID = 1L;

		private IscrittoRScuolaPre row;
		private IscrittoTScuola scuola;
		private IscrittoDCategoriaScu decCategoriaScu;
		private IscrittoDTipoFre decTipoFre;
		private IscrittoDCircoscrizione decCircoscrizione;
		private IscrittoDStatoScu decStatoScu;
		private IscrittoTScuola nidoContiguo;

		public IscrittoRScuolaPre getRow() {
			return row;
		}

		public void setRow(IscrittoRScuolaPre row) {
			this.row = row;
		}

		public IscrittoTScuola getScuola() {
			return scuola;
		}

		public void setScuola(IscrittoTScuola scuola) {
			this.scuola = scuola;
		}

		public IscrittoDCategoriaScu getDecCategoriaScu() {
			return decCategoriaScu;
		}

		public void setDecCategoriaScu(IscrittoDCategoriaScu decCategoriaScu) {
			this.decCategoriaScu = decCategoriaScu;
		}

		public IscrittoDTipoFre getDecTipoFre() {
			return decTipoFre;
		}

		public void setDecTipoFre(IscrittoDTipoFre decTipoFre) {
			this.decTipoFre = decTipoFre;
		}

		public IscrittoDCircoscrizione getDecCircoscrizione() {
			return decCircoscrizione;
		}

		public void setDecCircoscrizione(IscrittoDCircoscrizione decCircoscrizione) {
			this.decCircoscrizione = decCircoscrizione;
		}

		public IscrittoDStatoScu getDecStatoScu() {
			return decStatoScu;
		}

		public void setDecStatoScu(IscrittoDStatoScu decStatoScu) {
			this.decStatoScu = decStatoScu;
		}

		public IscrittoTScuola getNidoContiguo() {
			return nidoContiguo;
		}

		public void setNidoContiguo(IscrittoTScuola nidoContiguo) {
			this.nidoContiguo = nidoContiguo;
		}
	}

}
