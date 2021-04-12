package it.csi.iscritto.serviscritto.business.domanda.filter;

import it.csi.iscritto.serviscritto.business.util.Constants;
import it.csi.iscritto.serviscritto.dto.domanda.CriterioRicerca;
import it.csi.iscritto.serviscritto.exception.domanda.InvalidFilterException;

/*
 * Implementa la logica di controllo del criterio di ricerca selezionato ed anche la correttezza
 * di compilazione degli attributi per ciascun criterio previsto.
 * I criteri di ricerca previsti sono in mutua esclusione e sono:
 * - per codice fiscale minore: in uguaglianza sul valore compilato
 * - per cognome-nome minore: almeno uno dei due compilato, ciascuno, se compilato, con almeno due caratteri
 * - per codice scuola-stato domanda: scelta scuola obbligatoria: una scuola (oppure tutte), lo stato della domanda e' opzionale
 */
public class DomandeFilterValidator {
	private CriterioRicerca criterio;

	public DomandeFilterValidator(CriterioRicerca criterio) {
		this.criterio = criterio;
	}

	/**
	 * Verifica che sia stata impostata una sola tipologia di criterio
	 *
	 * @throws InvalidFilterException
	 */
	public int validateTipologiaCriterio() throws InvalidFilterException {

		// se CF presente, vale quel criterio (non considero eventuali valori su altri attributi)
		if (isAttributoCompilato(criterio.getCodiceFiscaleMinore())) {
			return Constants.CRITERIO_RICERCA_DOMANDE_CODICE_FISCALE_MIN;
		}

		if (isAttributoCompilato(criterio.getCodiceFiscaleRichiedente())) {
			return Constants.CRITERIO_RICERCA_DOMANDE_CODICE_FISCALE_RIC;
		}

		// in assenza di cf, se presenti cognome e/o nome, non considero scuole e stato
		if (isAttributoCompilato(criterio.getCognomeMinore()) || isAttributoCompilato(criterio.getNomeMinore())) {
			return Constants.CRITERIO_RICERCA_DOMANDE_COGNOME_NOME;
		}

		if (isAttributoCompilato(criterio.getCodiceScuola()) || isAttributoCompilato(criterio.getCodiceStatoDomanda())) {
			return Constants.CRITERIO_RICERCA_DOMANDE_SCUOLA_STATO;
		}

		if (isAttributoCompilato(criterio.getProtocollo())) {
			return Constants.CRITERIO_RICERCA_DOMANDE_PROTOCOLLO;
		}

		throw new InvalidFilterException("what else?");
	}

	/**
	 * Controlla che il codice fiscale sia stato valorizzato
	 *
	 * @throws InvalidFilterException
	 */
	public void validateCriterioPerCodiceFiscaleMinore() throws InvalidFilterException {
		if (isAttributoNonCompilato(criterio.getCodiceFiscaleMinore())) {
			throw new InvalidFilterException("Codice Fiscale: campo Obbligatorio");
		}

		// TODO: richiamare la routine che controlla la correttezza formale del CF
	}

	public void validateCriterioPerCodiceFiscaleRichiedente() throws InvalidFilterException {
		if (isAttributoNonCompilato(criterio.getCodiceFiscaleRichiedente())) {
			throw new InvalidFilterException("Codice Fiscale: campo Obbligatorio");
		}

		// TODO: richiamare la routine che controlla la correttezza formale del CF
	}

	public void validateCriterioPerCognomeNomeMinore() throws InvalidFilterException {
		if (isAttributoCompilato(criterio.getCognomeMinore())) {
			// almeno due caratteri
			if (criterio.getCognomeMinore().length() < 2) {
				throw new InvalidFilterException("Cognome: almeno due caratteri obbligatori");
			}
		}

		if (isAttributoCompilato(criterio.getNomeMinore())) {
			// almeno due caratteri
			if (criterio.getNomeMinore().length() < 2) {
				throw new InvalidFilterException("Nome: almeno due caratteri obbligatori");
			}
		}
	}

	public void validateCriterioPerScuolaStatoDomanda() throws InvalidFilterException {
		if (isAttributoNonCompilato(criterio.getCodiceScuola())) {
			throw new InvalidFilterException("Codice Scuola: campo Obbligatorio");
		}
	}

	public void validateCriterioPerProtocollo() throws InvalidFilterException {
		if (isAttributoNonCompilato(criterio.getProtocollo())) {
			throw new InvalidFilterException("Protocollo domanda: campo Obbligatorio");
		}
	}

	@Override
	public String toString() {
		return "DomandeFilterValidator [criterio=" + criterio + "]";
	}

	//////////////////////////////////////////////////////////////////////

	private boolean isAttributoNonCompilato(String attributo) {
		return attributo == null || attributo.isEmpty();
	}

	private boolean isAttributoCompilato(String attributo) {
		return attributo != null && !attributo.isEmpty();
	}

}
