package it.csi.iscritto.serviscritto.business.integration.converter.nido;

import static it.csi.iscritto.serviscritto.business.util.converter.ConvertUtils.fromSN;
import static it.csi.iscritto.serviscritto.business.util.converter.ConvertUtils.toArray;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.Validate;

import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoDTipoAll;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTAllegato;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTDomandaIsc;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTServiziSoc;
import it.csi.iscritto.serviscritto.business.util.allegato.TipologiaAllegato;
import it.csi.iscritto.serviscritto.business.util.converter.AbstractConverter;
import it.csi.iscritto.serviscritto.dto.domanda.DatiServiziSociali;
import it.csi.iscritto.serviscritto.dto.domanda.Documento;
import it.csi.iscritto.serviscritto.dto.domanda.File;
import it.csi.iscritto.serviscritto.dto.domanda.ServiziSociali;

public class ServiziSocialiConverter extends AbstractConverter<ServiziSocialiConverter.Data, ServiziSociali> {
	private Map<String, Long> index;

	public ServiziSocialiConverter(List<IscrittoDTipoAll> decTipologiaAllList) {
		Validate.notNull(decTipologiaAllList);
		this.index = buildIndex(decTipologiaAllList);
	}

	@Override
	public ServiziSociali convert(Data source) {
		ServiziSociali target = null;
		if (source != null) {
			IscrittoTDomandaIsc domandaIsc = source.getDomandaIsc();
			IscrittoTServiziSoc serviziSoc = Optional.ofNullable(source.getServiziSoc()).orElse(new IscrittoTServiziSoc());
			List<IscrittoTAllegato> allegatoList = Optional.ofNullable(source.getAllegatoList()).orElse(new ArrayList<IscrittoTAllegato>());

			target = new ServiziSociali();

			DatiServiziSociali datiServiziSociali = new DatiServiziSociali();
			datiServiziSociali.setIndirizzo(serviziSoc.getIndirizzo());
			datiServiziSociali.setAssistente(serviziSoc.getServizio());
			datiServiziSociali.setNome(serviziSoc.getNominativo());
			datiServiziSociali.setTelefono(serviziSoc.getTelefono());

			target.setStato(fromSN(domandaIsc.getFlServiziSociali()));
			target.setDati(datiServiziSociali);
			target.setDocumenti(toArray(this.getDocumenti(allegatoList, TipologiaAllegato.SER), Documento.class));
		}

		return target;
	}

	private List<Documento> getDocumenti(List<IscrittoTAllegato> allegatoList, TipologiaAllegato tipoAllegato) {
		List<Documento> result = new ArrayList<>();
		Long idTipoAllegato = this.index.get(tipoAllegato.name());

		if (idTipoAllegato != null && CollectionUtils.isNotEmpty(allegatoList)) {
			for (IscrittoTAllegato allegato : allegatoList) {
				if (idTipoAllegato.equals(allegato.getIdTipoAllegato())) {
					File file = new File();
					file.setName(allegato.getNomeFile());
					file.setType(allegato.getMimeType());

					Documento doc = new Documento();
					doc.setId(allegato.getIdAllegato());
					doc.setProtocollo(allegato.getProtocollo());
					doc.setDataInserimento(allegato.getDataInserimento());
					doc.setEliminato(false);
					doc.setFile(file);

					result.add(doc);
				}
			}
		}

		return result;
	}

	private static Map<String, Long> buildIndex(List<IscrittoDTipoAll> decTipoAllList) {
		Map<String, Long> result = new HashMap<>();
		for (IscrittoDTipoAll value : decTipoAllList) {
			result.put(value.getCodTipoAllegato(), value.getIdTipoAllegato());
		}

		return result;
	}

	public static final ServiziSociali buildEmpty() {
		DatiServiziSociali datiServiziSociali = new DatiServiziSociali();

		ServiziSociali target = new ServiziSociali();
		target.setDati(datiServiziSociali);

		return target;
	}

	public static final class Data implements Serializable {
		private static final long serialVersionUID = 1L;

		private IscrittoTDomandaIsc domandaIsc;
		private IscrittoTServiziSoc serviziSoc;
		private List<IscrittoTAllegato> allegatoList;

		public IscrittoTDomandaIsc getDomandaIsc() {
			return domandaIsc;
		}

		public void setDomandaIsc(IscrittoTDomandaIsc domandaIsc) {
			this.domandaIsc = domandaIsc;
		}

		public IscrittoTServiziSoc getServiziSoc() {
			return serviziSoc;
		}

		public void setServiziSoc(IscrittoTServiziSoc serviziSoc) {
			this.serviziSoc = serviziSoc;
		}

		public List<IscrittoTAllegato> getAllegatoList() {
			return allegatoList;
		}

		public void setAllegatoList(List<IscrittoTAllegato> allegatoList) {
			this.allegatoList = allegatoList;
		}
	}

}
