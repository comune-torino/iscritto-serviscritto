package it.csi.iscritto.serviscritto.business.integration.converter.scuole;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.commons.collections4.CollectionUtils;

import it.csi.iscritto.serviscritto.business.integration.dao.TipoFrequenza;
import it.csi.iscritto.serviscritto.business.integration.dao.view.dto.ScuolaRow;
import it.csi.iscritto.serviscritto.business.util.converter.AbstractConverter;
import it.csi.iscritto.serviscritto.business.util.converter.ConvertUtils;
import it.csi.iscritto.serviscritto.dto.scuole.Scuola;

public class ScuolaConverter extends AbstractConverter<ScuolaRow, Scuola> {

	@Override
	public Scuola convert(ScuolaRow source) {
		Scuola target = null;
		if (source != null) {
			target = new Scuola();

			target.setCodCategoriaScuola(source.getCodCategoriaScu());
			target.setCodCircoscrizione(source.getCodCircoscrizione());
			target.setCodOrdineScuola(source.getCodOrdineScuola());
			target.setCodScuola(source.getCodScuola());
			target.setDescCategoriaScuola(source.getDescCategoriaScu());
			target.setDescCircoscrizione(source.getDescCircoscrizione());
			target.setDescOrdineScuola(source.getDescOrdineScuola());
			target.setDescrizione(source.getDescrizione());
			target.setIndirizzo(source.getIndirizzo());
			target.setAnnoScolastico(source.getCodAnnoScolastico());
			target.setAlert(ConvertUtils.fromSN(source.getAlert()));
			target.setTempoBreve(TipoFrequenza.BRV.getCod().equals(source.getCodTipoFrequenza()));
			target.setTempoLungo(TipoFrequenza.LNG.getCod().equals(source.getCodTipoFrequenza()));
			target.setTempoIntermedio(TipoFrequenza.INT.getCod().equals(source.getCodTipoFrequenza()));
			target.setDescNidoContiguo(source.getDescNidoContiguo());
			target.setIndirizzoNidoContiguo(source.getIndirizzoNidoContiguo());
		}

		return target;
	}

	@Override
	protected void afterConversion(List<Scuola> targetList) {
		mergeInfoScuola(targetList);
	}

	private static void mergeInfoScuola(List<Scuola> targetList) {
		if (CollectionUtils.isEmpty(targetList)) {
			return;
		}

		Map<String, Scuola> index = new LinkedHashMap<>();
		for (Iterator<Scuola> it = targetList.iterator(); it.hasNext();) {
			Scuola item = it.next();

			String codScuola = item.getCodScuola();
			Scuola obj = index.get(codScuola);

			if (obj == null) {
				index.put(codScuola, item);
			}
			else {
				mergeTipoFrequenza(obj, item);
				mergeAlert(obj, item);

				it.remove();
			}
		}
	}

	private static void mergeTipoFrequenza(Scuola a, Scuola b) {
		a.setTempoBreve(
				Optional.ofNullable(a.getTempoBreve()).orElse(false) || Optional.ofNullable(b.getTempoBreve()).orElse(false));

		a.setTempoLungo(
				Optional.ofNullable(a.getTempoLungo()).orElse(false) || Optional.ofNullable(b.getTempoLungo()).orElse(false));

		a.setTempoIntermedio(
				Optional.ofNullable(a.getTempoIntermedio()).orElse(false) || Optional.ofNullable(b.getTempoIntermedio()).orElse(false));
	}

	private static void mergeAlert(Scuola a, Scuola b) {
		a.setAlert(
				Optional.ofNullable(a.getAlert()).orElse(false) || Optional.ofNullable(b.getAlert()).orElse(false));
	}

}
