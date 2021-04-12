package it.csi.iscritto.serviscritto.business.integration.converter.nido;

import java.io.Serializable;
import java.util.Optional;

import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoDTipoCorso;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTStudente;
import it.csi.iscritto.serviscritto.business.util.converter.AbstractConverter;
import it.csi.iscritto.serviscritto.dto.domanda.Studente;

public class StudenteConverter extends AbstractConverter<StudenteConverter.Data, Studente> {

	@Override
	public Studente convert(Data source) {
		Studente target = null;
		if (source != null && source.getStudente() != null) {
			IscrittoTStudente studente = source.getStudente();
			IscrittoDTipoCorso decTipoCorso = Optional.ofNullable(source.getDecTipoCorso()).orElse(new IscrittoDTipoCorso());

			target = new Studente();

			target.setCorso(decTipoCorso.getCodTipoCorso());
			target.setIstituto(studente.getIndirizzo());
		}

		return target;
	}

	public static final Studente buildEmpty() {
		return new Studente();
	}

	public static final class Data implements Serializable {
		private static final long serialVersionUID = 1L;

		private IscrittoTStudente studente;
		private IscrittoDTipoCorso decTipoCorso;

		public IscrittoTStudente getStudente() {
			return studente;
		}

		public void setStudente(IscrittoTStudente studente) {
			this.studente = studente;
		}

		public IscrittoDTipoCorso getDecTipoCorso() {
			return decTipoCorso;
		}

		public void setDecTipoCorso(IscrittoDTipoCorso decTipoCorso) {
			this.decTipoCorso = decTipoCorso;
		}
	}

}
