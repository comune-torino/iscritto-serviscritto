package it.csi.iscritto.serviscritto.business.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTAllegato;
import it.csi.iscritto.serviscritto.business.util.converter.ConvertUtils;

public final class ProtocolloUtils {
	public static final int PROTOCOLLO_ALLEGATO_PARTS = 5;
	public static final int PROTOCOLLO_ALLEGATO_NUMBER_INDEX = 3;

	private ProtocolloUtils() {
		/* NOP */
	}

	public static String buildProtocollo(long numProtocollo, String codOrdineScuola) {
		int anno = DateUtils.getCurrentYear();
		String codProtocollo = StringUtils.leftPad(String.valueOf(numProtocollo), 5, "0");

		return String.format("%s-%s-%d", codOrdineScuola, codProtocollo, anno);
	}

	public static String buildProtocolloAllegato(String protocolloDomanda, int numAllegato, String codTipoAllegato) {
		String codProtocollo = StringUtils.leftPad(String.valueOf(numAllegato), 3, "0");

		return String.format("%s-%s-%s", protocolloDomanda, codProtocollo, codTipoAllegato);
	}

	public static int getNextProtocolloAllegato(List<IscrittoTAllegato> allegati) {
		if (CollectionUtils.isEmpty(allegati)) {
			return 1;
		}

		List<Integer> numbers = new ArrayList<>();
		for (IscrittoTAllegato allegato : allegati) {
			if (allegato == null) {
				continue;
			}

			String protocollo = allegato.getProtocollo();
			if (StringUtils.isBlank(protocollo)) {
				continue;
			}

			List<String> tokens = ConvertUtils.split(protocollo, "-", true);
			if (CollectionUtils.size(tokens) != PROTOCOLLO_ALLEGATO_PARTS) {
				continue;
			}

			String numberPart = tokens.get(PROTOCOLLO_ALLEGATO_NUMBER_INDEX);
			numbers.add(Integer.valueOf(numberPart));
		}

		if (CollectionUtils.isEmpty(numbers)) {
			return 1;
		}

		return Collections.max(numbers) + 1;
	}

}
