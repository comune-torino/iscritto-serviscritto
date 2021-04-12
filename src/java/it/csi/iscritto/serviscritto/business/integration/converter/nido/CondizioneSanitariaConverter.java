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
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTCondizioneSan;
import it.csi.iscritto.serviscritto.business.util.allegato.TipologiaAllegato;
import it.csi.iscritto.serviscritto.business.util.converter.AbstractConverter;
import it.csi.iscritto.serviscritto.dto.domanda.CondizioneSanitaria;
import it.csi.iscritto.serviscritto.dto.domanda.Disabilita;
import it.csi.iscritto.serviscritto.dto.domanda.Documento;
import it.csi.iscritto.serviscritto.dto.domanda.File;
import it.csi.iscritto.serviscritto.dto.domanda.Gravidanza;
import it.csi.iscritto.serviscritto.dto.domanda.ProblemiSalute;

public class CondizioneSanitariaConverter extends AbstractConverter<CondizioneSanitariaConverter.Data, CondizioneSanitaria> {
	private Map<String, Long> index;

	public CondizioneSanitariaConverter(List<IscrittoDTipoAll> decTipologiaAllList) {
		Validate.notNull(decTipologiaAllList);
		this.index = buildIndex(decTipologiaAllList);
	}

	@Override
	public CondizioneSanitaria convert(Data source) {
		CondizioneSanitaria target = null;
		if (source != null) {
			IscrittoTCondizioneSan condizioneSan = Optional.ofNullable(source.getCondizioneSan()).orElse(new IscrittoTCondizioneSan());
			List<IscrittoTAllegato> allegatoList = Optional.ofNullable(source.getAllegatoList()).orElse(new ArrayList<IscrittoTAllegato>());

			target = new CondizioneSanitaria();

			Disabilita disabilita = new Disabilita();
			disabilita.setStato(fromSN(condizioneSan.getFlDisabilita()));
			disabilita.setDocumenti(toArray(this.getDocumenti(allegatoList, TipologiaAllegato.DIS), Documento.class));
			target.setDisabilita(disabilita);

			ProblemiSalute problemiSalute = new ProblemiSalute();
			problemiSalute.setStato(fromSN(condizioneSan.getFlProblemiSalute()));
			problemiSalute.setDocumenti(toArray(this.getDocumenti(allegatoList, TipologiaAllegato.SAL), Documento.class));
			target.setProblemiSalute(problemiSalute);

			Gravidanza gravidanza = new Gravidanza();
			gravidanza.setStato(fromSN(condizioneSan.getFlStatoGravidanza()));
			gravidanza.setDocumenti(toArray(this.getDocumenti(allegatoList, TipologiaAllegato.GRA), Documento.class));
			target.setGravidanza(gravidanza);
		}

		return target;
	}

	public static final CondizioneSanitaria buildEmpty() {
		Disabilita disabilita = new Disabilita();
		disabilita.setDocumenti(new Documento[0]);

		ProblemiSalute problemiSalute = new ProblemiSalute();
		problemiSalute.setDocumenti(new Documento[0]);

		Gravidanza gravidanza = new Gravidanza();
		gravidanza.setDocumenti(new Documento[0]);

		CondizioneSanitaria target = new CondizioneSanitaria();
		target.setDisabilita(disabilita);
		target.setGravidanza(gravidanza);
		target.setProblemiSalute(problemiSalute);

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

	public static final class Data implements Serializable {
		private static final long serialVersionUID = 1L;

		private IscrittoTCondizioneSan condizioneSan;
		private List<IscrittoTAllegato> allegatoList;

		public IscrittoTCondizioneSan getCondizioneSan() {
			return condizioneSan;
		}

		public void setCondizioneSan(IscrittoTCondizioneSan condizioneSan) {
			this.condizioneSan = condizioneSan;
		}

		public List<IscrittoTAllegato> getAllegatoList() {
			return allegatoList;
		}

		public void setAllegatoList(List<IscrittoTAllegato> allegatoList) {
			this.allegatoList = allegatoList;
		}
	}

}
