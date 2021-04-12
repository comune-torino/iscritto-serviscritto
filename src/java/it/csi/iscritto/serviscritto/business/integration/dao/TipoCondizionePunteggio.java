package it.csi.iscritto.serviscritto.business.integration.dao;

import org.apache.commons.lang3.StringUtils;

public enum TipoCondizionePunteggio {
	RES_NOTO(
			"RES_NOTO",
			"Famiglie non residenti a Torino"),
	CL_LAV(
			"CL_LAV",
			"Genitore lavoratore"),
	CL_NON_OCC(
			"CL_NON_OCC",
			"Genitore non occupato che alla scadenza iscrizioni ha lavorato almeno 6 mesi nei precedenti 12"),
	LA_PER(
			"LA_PER",
			"Ogni permanenza in lista d attesa al termine dei precedenti anni educativi"),
	RES_TO(
			"RES_TO",
			"Famiglie residenti a Torino"),
	RES_NOTO_LAV(
			"RES_NOTO_LAV",
			"Famiglie non residenti a torino in cui almeno un genitore presta attivita' lavorativa in citta'"),
	PA_SOC(
			"PA_SOC",
			"Bambino/a in situazione di disagio sociale"),
	GEN_SOLO(
			"GEN_SOLO",
			"Bambino/a con un unico genitore"),
	GEN_SEP(
			"GEN_SEP",
			"Genitori separati"),
	CF_INF_11(
			"CF_INF_11",
			"Ogni figlio/a di eta' inferiore a 11 anni"),
	CF_TRA_11_17(
			"CF_TRA_11_17",
			"Ogni figlio tra 11 e 17 anni"),
	CF_FRA_FRE(
			"CF_FRA_FRE",
			"Presenza di fratelli/sorelle frequentanti o iscrivendi lo stesso nido"),
	CF_INF_11_AFF_CON(
			"CF_INF_11_AFF_CON",
			"Ogni figlio/a fino a 10 anni di eta' di cui un genitore coabitante abbia lo affidamento"),
	CF_TRA_11_17_AFF_CON(
			"CF_TRA_11_17_AFF_CON",
			"Ogni figlio/a di eta' superiore a 10 anni e inferiore a 18 di cui un gentitore abbia lo affidamento condiviso"),
	CL_DIS(
			"CL_DIS",
			"Genitore disoccupato da almeno tre mesi"),
	CL_STU(
			"CL_STU",
			"Genitore studente"),
	TR_TRA_NID(
			"TR_TRA_NID",
			"Trasferimento da nido della citta'"),
	PAR_ISEE(
			"PAR_ISEE",
			"Precedenza a domande con ISEE"),
	RES_TO_FUT(
			"RES_TO_FUT",
			"Famiglie prossimamente residenti a Torino"),
	CF_GRA(
			"CF_GRA",
			"Stato di gravidanza della madre"),
	// @Deprecate
	// @since2.0.0
	PA_PRB_SAL(
			"PA_PRB_SAL",
			"Gravi problemi di salute del bambino/a o di persona presente nel nucleo familiare"),
	// ISBO-346
	PA_PRB_SAL_MIN(
			"PA_PRB_SAL_MIN",
			"Gravi problemi di salute del bambino"),
	// ISBO-346
	PA_PRB_SAL_ALT(
			"PA_PRB_SAL_ALT",
			"Gravi problemi di persona presente nel nucleo familiare"),
	PA_DIS(
			"PA_DIS",
			"Bambino/a con disabilita' certificata"),
	RES_TO_FUT_NOTE(
			"RES_TO_FUT_NOTE",
			"Famiglie prossimamente residenti a Torino"),
			;

	private String cod;
	private String desc;

	private TipoCondizionePunteggio(String cod, String desc) {
		this.cod = cod;
		this.desc = desc;
	}

	public static TipoCondizionePunteggio findByCod(String cod) {
		if (StringUtils.isNotBlank(cod)) {
			for (TipoCondizionePunteggio e : values()) {
				if (cod.equalsIgnoreCase(e.getCod())) {
					return e;
				}
			}
		}

		return null;
	}

	public static final TipoCondizionePunteggio getOpposite(TipoCondizionePunteggio e) {
		if (e == null) {
			return null;
		}

		switch (e) {
			case PA_DIS:
				return PA_PRB_SAL_MIN;
			case PA_PRB_SAL_MIN:
				return PA_DIS;
			default:
				return null;
		}
	}

	public static final String getOppositeCod(String cod) {
		TipoCondizionePunteggio opposite = getOpposite(findByCod(cod));
		if (opposite == null) {
			return null;
		}

		return opposite.getCod();
	}

	public String getCod() {
		return cod;
	}

	public String getDesc() {
		return desc;
	}

}
