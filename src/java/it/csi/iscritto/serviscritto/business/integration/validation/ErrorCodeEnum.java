package it.csi.iscritto.serviscritto.business.integration.validation;

import it.csi.iscritto.serviscritto.exception.domanda.ValidationException;

public enum ErrorCodeEnum {
	// errori di sistema non recuperabili
	SYS_001("SYS-001", "errore interno"),

	// validazioni generali
	VAL_INS_001("VAL-INS-001", "errore insert"),
	VAL_UPD_001("VAL-UPD-001", "errore update"),
	VAL_DEL_001("VAL-DEL-001", "errore delete"),
	VAL_RIC_001("VAL-RIC-001", "parametri non corretti"),

	// validazione codice fiscale
	VAL_CF_001("VAL-CF-001", "codice fiscale vuoto"),
	VAL_CF_002("VAL-CF-002", "lunghezza codice fiscale non valida"),
	VAL_CF_003("VAL-CF-003", "formato codice fiscale numerico non valido"),
	VAL_CF_004("VAL-CF-004", "formato codice fiscale alfanumerico non valido"),
	VAL_CF_005("VAL-CF-005", "carattere di controllo non valido"),

	// validazione periodi lavorativi
	VAL_PER_001("VAL-PER-001", "data presentazione non valida"),
	VAL_PER_002("VAL-PER-002", "elenco periodi vuoto"),
	VAL_PER_003("VAL-PER-003", "elenco periodi non valido"),
	VAL_PER_004("VAL-PER-004", "numero giorni lavorati non valido"),

	// validazione elenco nidi
	VAL_NID_001("VAL-NID-001", "nido non presente in elenco"),
	VAL_NID_002("VAL-NID-002", "domanda senza nidi associati"),

	// validazione elenco materne
	VAL_MAT_001("VAL-MAT-001", "materna non presente in elenco"),
	VAL_MAT_002("VAL-MAT-002", "domanda senza materne associate"),

	// validazione allegati
	VAL_ALL_001("VAL-ALL-001", "utente non valido"),
	VAL_ALL_002("VAL-ALL-002", "allegato non presente"),
	VAL_ALL_003("VAL-ALL-003", "operatore non presente"),

	// validazione domanda
	VAL_DOM_001("VAL-DOM-001", "domanda fuori periodo"),
	VAL_DOM_002("VAL-DOM-002", "anno scolastico non presente"),
	VAL_DOM_003("VAL-DOM-003", "cf richiedente non presente"),
	VAL_DOM_004("VAL-DOM-004", "cf minore non presente"),
	VAL_DOM_005("VAL-DOM-005", "esiste gia' una domanda per lo stesso minore e diverso richiedente"),
	VAL_DOM_006("VAL-DOM-006", "esiste gia' una domanda per lo stesso minore e stesso richiedente"),
	VAL_DOM_007("VAL-DOM-007", "domanda non presente"),
	VAL_DOM_008("VAL-DOM-008", "stato domanda non valido"),
	VAL_DOM_009("VAL-DOM-009", "data nascita minore non presente"),
	VAL_DOM_010("VAL-DOM-010", "fratello frequentante non presente"),
	VAL_DOM_011("VAL-DOM-011", "et&agrave; nido non valida"),
	VAL_DOM_012("VAL-DOM-012", "cf operatore non presente"),
	VAL_DOM_013("VAL-DOM-013", "sono presenti piu' soggetti aventi lo stesso codice fiscale"),
	VAL_DOM_014("VAL-DOM-014", "selezionare almeno una scuola"),
	VAL_DOM_015("VAL-DOM-015", "selezionare almeno tre scuole"),
	VAL_DOM_016("VAL-DOM-016", "utente non valido"),
	VAL_DOM_017("VAL-DOM-017", "esiste gia' una domanda in graduatoria per lo stesso minore e stesso richiedente"),
	VAL_DOM_018("VAL-DOM-018", "numero preferenze non valido"),
	VAL_DOM_019("VAL-DOM-019", "condizione di salute non valida"),
	VAL_DOM_020("VAL-DOM-020", "esiste gia' una domanda ammessa per lo stesso minore e stesso richiedente"),

	// istruttoria
	VAL_IST_001("VAL-IST-001", "modifiche concorrenti"),
	VAL_IST_002("VAL-IST-002", "parametro non valido"),
	VAL_IST_003("VAL-IST-003", "valore ricorrenza non corretto"),
	VAL_IST_004("VAL-IST-004", "tipo validazione non corretta"),
	VAL_IST_005("VAL-IST-005", "codice condizione punteggio non corretto"),
	VAL_IST_006("VAL-IST-006", "validazione condizione di punteggio non compatibile"),

	// accettazione
	VAL_ACC_001("VAL-ACC-001", "codice scuola non presente"),
	VAL_ACC_002("VAL-ACC-002", "codice tipo frequenza non presente"),
	VAL_ACC_003("VAL-ACC-003", "preferenza non trovata"),
	VAL_ACC_004("VAL-ACC-004", "preferenza non valida"),
	VAL_ACC_005("VAL-ACC-005", "errore salvataggio preferenza"),
	VAL_ACC_006("VAL-ACC-006", "stato preferenza non valido"),
	VAL_ACC_007("VAL-ACC-007", "telefono richiedente non presente"),
	VAL_ACC_008("VAL-ACC-008", "tipo pasto non presente"),

	// graduatoria
	VAL_GRA_001("VAL-GRA-001", "configurazione graduatoria corrente errata"),
	VAL_GRA_002("VAL-GRA-002", "graduatoria non presente"),
	VAL_GRA_003("VAL-GRA-003", "parametri calcolo graduatoria non corretti"),
	VAL_GRA_004("VAL-GRA-004", "errore nella configurazione per il calcolo graduatoria"),
	VAL_GRA_005("VAL-GRA-005", "errore nel calcolo della graduatoria"),
	VAL_GRA_006("VAL-GRA-006", "errore nell' acquisizione del lock"),
	VAL_GRA_007("VAL-GRA-007", "impossibile eseguire l'ammissione in questa fase"),
	VAL_GRA_008("VAL-GRA-008", "parametri inserimento classe non corretti"),
	VAL_GRA_009("VAL-GRA-009", "errore nella cancellazione della classe"),
	VAL_GRA_010("VAL-GRA-010", "errore id_step_gra gia' presente in t_graduatoria"),
	VAL_GRA_011("VAL-GRA-011", "operazione non eseguibile perche' non ci sono posti liberi"),
	;

	private String code;
	private String description;

	private ErrorCodeEnum(String code, String description) {
		this.code = code;
		this.description = description;
	}

	public ValidationException buildException() {
		return ValidationExceptionBuilder.from(this).build();
	}

	public ValidationException buildException(String path) {
		return ValidationExceptionBuilder.from(this).withPath(path).build();
	}

	public ValidationException buildException(Throwable cause) {
		return ValidationExceptionBuilder.from(this).withCause(cause).build();
	}

	public String getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}

}
