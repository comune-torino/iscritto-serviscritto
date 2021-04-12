package it.csi.iscritto.serviscritto.business.domanda.filter;

import it.csi.iscritto.serviscritto.business.util.Constants;
import it.csi.iscritto.serviscritto.dto.domanda.CriterioRicercaIstruttoria;
import it.csi.iscritto.serviscritto.exception.domanda.InvalidFilterException;

public class DomandeIstruttoriaFilterValidator {

	private CriterioRicercaIstruttoria criterio;

	public DomandeIstruttoriaFilterValidator(CriterioRicercaIstruttoria criterio) {
		this.criterio = criterio;
	}

	public int validateTipologiaCriterio() throws InvalidFilterException {
		if (isAttributoCompilato(criterio.getCodiceCondizionePunteggio()) || isAttributoCompilato(criterio.getStatoCondizionePunteggio())) {
			return Constants.CRITERIO_RICERCA_DOMANDE_CONDIZIONE_PUN;
		}

		throw new InvalidFilterException("what else?");
	}

	public void validateCriterioPerCognomeNomeMinore() throws InvalidFilterException {
		if (isAttributoCompilato(criterio.getCognomeMinore())) {
			// almeno due caratteri
			if (criterio.getCognomeMinore().length() < 2)
				throw new InvalidFilterException("Cognome: almeno due caratteri obbligatori");
		}

		if (isAttributoCompilato(criterio.getNomeMinore())) {
			// almeno due caratteri
			if (criterio.getNomeMinore().length() < 2)
				throw new InvalidFilterException("Nome: almeno due caratteri obbligatori");
		}

	}

	public void validateCriterioPerCondizionePunteggio() throws InvalidFilterException {
		if (isAttributoNonCompilato(criterio.getCodiceCondizionePunteggio())) {
			throw new InvalidFilterException("Codice condizione punteggio: campo Obbligatorio");
		}

		if (isAttributoNonCompilato(criterio.getStatoCondizionePunteggio())) {
			throw new InvalidFilterException("Stato condizione punteggio: campo Obbligatorio");
		}
	}

	private boolean isAttributoNonCompilato(String attributo) {
		return (attributo == null || attributo.isEmpty());
	}

	private boolean isAttributoCompilato(String attributo) {
		return (attributo != null && !attributo.isEmpty());
	}

	@Override
	public String toString() {
		return "DomandeIstruttoriaFilterValidator [criterio=" + criterio + "]";
	}
}
