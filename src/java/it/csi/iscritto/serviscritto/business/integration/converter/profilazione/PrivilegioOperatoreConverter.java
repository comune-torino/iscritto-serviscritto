package it.csi.iscritto.serviscritto.business.integration.converter.profilazione;

import it.csi.iscritto.serviscritto.business.integration.dao.view.dto.PrivilegioOperatoreRow;
import it.csi.iscritto.serviscritto.business.util.converter.AbstractConverter;
import it.csi.iscritto.serviscritto.dto.profilazione.PrivilegioOperatore;

public class PrivilegioOperatoreConverter extends AbstractConverter<PrivilegioOperatoreRow, PrivilegioOperatore> {

	@Override
	public PrivilegioOperatore convert(PrivilegioOperatoreRow source) {
		PrivilegioOperatore target = null;
		if (source != null) {
			target = new PrivilegioOperatore();

			target.setCodiceFiscale(source.getCodiceFiscale());
			target.setCodicePrivilegio(source.getCodPrivilegio());
			target.setCodiceProfilo(source.getCodiceProfilo());
			target.setCognome(source.getCognome());
			target.setDescPrivilegio(source.getDescrizione());
			target.setIdPrivilegio(source.getIdPrivilegio());
			target.setIdAttivita(source.getIdAttivita());
			target.setIdUtente(source.getIdUtente());
			target.setNome(source.getNome());
		}

		return target;
	}

}
