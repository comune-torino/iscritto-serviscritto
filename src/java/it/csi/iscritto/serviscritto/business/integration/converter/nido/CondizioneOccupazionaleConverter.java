package it.csi.iscritto.serviscritto.business.integration.converter.nido;

import static it.csi.iscritto.serviscritto.business.util.converter.ConvertUtils.toArray;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoDTipConOcc;
import it.csi.iscritto.serviscritto.business.util.converter.AbstractConverter;
import it.csi.iscritto.serviscritto.dto.domanda.Autonomo;
import it.csi.iscritto.serviscritto.dto.domanda.CondizioneOccupazionale;
import it.csi.iscritto.serviscritto.dto.domanda.DatiCondizioneOccupazionale;
import it.csi.iscritto.serviscritto.dto.domanda.Dipendente;
import it.csi.iscritto.serviscritto.dto.domanda.Disoccupato;
import it.csi.iscritto.serviscritto.dto.domanda.NonOccupato;
import it.csi.iscritto.serviscritto.dto.domanda.Studente;

public class CondizioneOccupazionaleConverter extends AbstractConverter<CondizioneOccupazionaleConverter.Data, CondizioneOccupazionale> {

	@Override
	public CondizioneOccupazionale convert(Data source) {
		CondizioneOccupazionale target = null;
		if (source != null) {
			IscrittoDTipConOcc decCondizioneOcc = Optional.ofNullable(source.getDecCondizioneOcc()).orElse(new IscrittoDTipConOcc());

			DatiCondizioneOccupazionale dati = new DatiCondizioneOccupazionale();
			// gestiti esternamente
			dati.setAutonomo(source.getAutonomo());
			dati.setDipendente(source.getDipendente());
			dati.setDisoccupato(source.getDisoccupato());
			dati.setNonOccupato(toArray(source.getNonOccupatoList(), NonOccupato.class));
			dati.setStudente(source.getStudente());

			target = new CondizioneOccupazionale();
			target.setStato(decCondizioneOcc.getCodTipCondOccupazionale());
			target.setDati(dati);
		}

		return target;
	}

	public static final CondizioneOccupazionale buildEmpty() {
		DatiCondizioneOccupazionale dati = new DatiCondizioneOccupazionale();
		dati.setAutonomo(AutonomoConverter.buildEmpty());
		dati.setDipendente(DipendenteConverter.buildEmpty());
		dati.setDisoccupato(DisoccupatoConverter.buildEmpty());
		// dati.setNonOccupato(toArray(Arrays.asList(NonOccupatoConverter.buildEmpty()), NonOccupato.class));
		dati.setNonOccupato(new NonOccupato[0]);
		dati.setStudente(StudenteConverter.buildEmpty());

		CondizioneOccupazionale target = new CondizioneOccupazionale();
		target.setDati(dati);

		return target;
	}

	public static final class Data implements Serializable {
		private static final long serialVersionUID = 1L;

		private IscrittoDTipConOcc decCondizioneOcc;

		private Autonomo autonomo;
		private Dipendente dipendente;
		private Disoccupato disoccupato;
		private List<NonOccupato> nonOccupatoList;
		private Studente studente;

		public IscrittoDTipConOcc getDecCondizioneOcc() {
			return decCondizioneOcc;
		}

		public void setDecCondizioneOcc(IscrittoDTipConOcc decCondizioneOcc) {
			this.decCondizioneOcc = decCondizioneOcc;
		}

		public Autonomo getAutonomo() {
			return autonomo;
		}

		public void setAutonomo(Autonomo autonomo) {
			this.autonomo = autonomo;
		}

		public Dipendente getDipendente() {
			return dipendente;
		}

		public void setDipendente(Dipendente dipendente) {
			this.dipendente = dipendente;
		}

		public Disoccupato getDisoccupato() {
			return disoccupato;
		}

		public void setDisoccupato(Disoccupato disoccupato) {
			this.disoccupato = disoccupato;
		}

		public List<NonOccupato> getNonOccupatoList() {
			return nonOccupatoList;
		}

		public void setNonOccupatoList(List<NonOccupato> nonOccupatoList) {
			this.nonOccupatoList = nonOccupatoList;
		}

		public Studente getStudente() {
			return studente;
		}

		public void setStudente(Studente studente) {
			this.studente = studente;
		}
	}

}
