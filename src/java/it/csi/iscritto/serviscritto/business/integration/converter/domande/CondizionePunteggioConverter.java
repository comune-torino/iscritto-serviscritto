package it.csi.iscritto.serviscritto.business.integration.converter.domande;

import static it.csi.iscritto.serviscritto.business.util.converter.ConvertUtils.fromSN;

import java.io.Serializable;

import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoDCondizionePun;
import it.csi.iscritto.serviscritto.business.integration.dao.table.dto.IscrittoTUtente;
import it.csi.iscritto.serviscritto.business.integration.dao.view.dto.CondizionePunteggioRow;
import it.csi.iscritto.serviscritto.business.util.DateUtils;
import it.csi.iscritto.serviscritto.business.util.converter.AbstractConverter;
import it.csi.iscritto.serviscritto.dto.domanda.CondizionePunteggio;
import it.csi.iscritto.serviscritto.dto.domanda.Utente;

public class CondizionePunteggioConverter
		extends AbstractConverter<CondizionePunteggioConverter.Data, CondizionePunteggio> {

	@Override
	public CondizionePunteggio convert(Data source) {
		CondizionePunteggio target = null;
		if (source != null) {
			target = new CondizionePunteggio();

			// dati di decodifica della condizione di punteggio
			target.setCodice(source.getCondizionePunteggioDecodifica().getCodCondizione());
			target.setDescrizione(source.getCondizionePunteggioDecodifica().getDescrizione());
			target.setTipoIstruttoria(source.getCondizionePunteggioDecodifica().getFlIstruttoria());

			// dati della condizione d punteggio sulla domanda corrente
			target.setValidata(fromSN(source.getCondizionePunteggioDomanda().getFlValida()));
			target.setRicorrenza(source.getCondizionePunteggioDomanda().getRicorrenza());
			target.setNote(source.getCondizionePunteggioDomanda().getNote());
			target.setValidata(fromSN(source.getCondizionePunteggioDomanda().getFlValida()));
			target.setDataInizioValidita(DateUtils.toStringDate(source.getCondizionePunteggioDomanda().getDataInizioValidita(), DateUtils.DEFAULT_DATE_FORMAT));
			target.setDataFineValidita(DateUtils.toStringDate(source.getCondizionePunteggioDomanda().getDataFineValidita(), DateUtils.DEFAULT_DATE_FORMAT));

			// dati utente (opzionale)
			if (source.getUtente() != null) {
				Utente utente = new Utente();
				utente.setCodiceFiscale(source.getUtente().getCodiceFiscale());
				utente.setCognome(source.getUtente().getCognome());
				utente.setNome(source.getUtente().getNome());
				utente.setFlEliminato(fromSN(source.getUtente().getFlEliminato()));
//				utente.setIdProfilo(source.getUtente().getIdProfilo());

				target.setUtente(utente);
			}
		}

		return target;
	}

	public static final class Data implements Serializable {
		private static final long serialVersionUID = 1L;

		private IscrittoTUtente utente;
		private IscrittoDCondizionePun condizionePunteggioDecodifica;
		private CondizionePunteggioRow condizionePunteggioDomanda;

		/**
		 * @return the utente
		 */
		public IscrittoTUtente getUtente() {
			return utente;
		}

		/**
		 * @param utente
		 *            the utente to set
		 */
		public void setUtente(IscrittoTUtente utente) {
			this.utente = utente;
		}

		/**
		 * @return the condizionePunteggioDecodifica
		 */
		public IscrittoDCondizionePun getCondizionePunteggioDecodifica() {
			return condizionePunteggioDecodifica;
		}

		/**
		 * @param condizionePunteggioDecodifica
		 *            the condizionePunteggioDecodifica to set
		 */
		public void setCondizionePunteggioDecodifica(IscrittoDCondizionePun condizionePunteggioDecodifica) {
			this.condizionePunteggioDecodifica = condizionePunteggioDecodifica;
		}

		/**
		 * @return the condizionePunteggioDomanda
		 */
		public CondizionePunteggioRow getCondizionePunteggioDomanda() {
			return condizionePunteggioDomanda;
		}

		/**
		 * @param condizionePunteggioDomanda
		 *            the condizionePunteggioDomanda to set
		 */
		public void setCondizionePunteggioDomanda(CondizionePunteggioRow condizionePunteggioDomanda) {
			this.condizionePunteggioDomanda = condizionePunteggioDomanda;
		}

	}

}
