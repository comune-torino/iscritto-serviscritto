package it.csi.iscritto.serviscritto.business.integration.converter.nido;

import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTDisoccupatoEx;
import it.csi.iscritto.serviscritto.business.util.DateUtils;
import it.csi.iscritto.serviscritto.business.util.converter.AbstractConverter;
import it.csi.iscritto.serviscritto.dto.domanda.NonOccupato;

public class NonOccupatoConverter extends AbstractConverter<IscrittoTDisoccupatoEx, NonOccupato> {

	@Override
	public NonOccupato convert(IscrittoTDisoccupatoEx source) {
		NonOccupato target = null;
		if (source != null) {
			target = new NonOccupato();

			target.setId(source.getIdDisoccupatoExLav());
			target.setAzienda(source.getAziendaPivaCf());
			target.setComune(source.getComuneLavoro());
			target.setDataFine(DateUtils.toStringDate(source.getLavoroAl(), DateUtils.DEFAULT_DATE_FORMAT));
			target.setDataInizio(DateUtils.toStringDate(source.getLavoroDal(), DateUtils.DEFAULT_DATE_FORMAT));
			target.setIndirizzo(source.getIndirizzo());
		}

		return target;
	}

	public static final NonOccupato buildEmpty() {
		return new NonOccupato();
	}

}
