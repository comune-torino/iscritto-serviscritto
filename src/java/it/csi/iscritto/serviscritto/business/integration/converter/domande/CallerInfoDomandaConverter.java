package it.csi.iscritto.serviscritto.business.integration.converter.domande;

import org.apache.commons.lang3.ObjectUtils;

import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoLAuditLog;
import it.csi.iscritto.serviscritto.business.util.converter.AbstractConverter;
import it.csi.iscritto.serviscritto.dto.domanda.CallerInfoDomanda;

public class CallerInfoDomandaConverter extends AbstractConverter<CallerInfoDomanda, IscrittoLAuditLog> {
	private static final String NA = "NA";

	@Override
	public IscrittoLAuditLog convert(CallerInfoDomanda source) {
		IscrittoLAuditLog target = null;
		if (source != null) {
			target = new IscrittoLAuditLog();

			target.setDataOra(null); // valorizzato nella query di inserimento
			target.setIdApp(source.getIdApp());
			target.setIpAddress(ObjectUtils.defaultIfNull(source.getIpAddress(), NA));
			target.setKeyOper(source.getKeyOper());
			target.setOggOper(ObjectUtils.defaultIfNull(source.getOggOper(), NA));
			target.setOperazione(source.getOperazione());
			target.setUtente(source.getUtente());
		}

		return target;
	}

}
