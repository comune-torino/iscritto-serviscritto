package it.csi.iscritto.serviscritto.business.integration.validation;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections4.CollectionUtils;

import it.csi.iscritto.serviscritto.business.integration.validation.model.PeriodoLavorativo;
import it.csi.iscritto.serviscritto.business.util.DateUtils;
import it.csi.iscritto.serviscritto.business.util.builder.DateRangeBuilder;
import it.csi.iscritto.serviscritto.exception.domanda.ValidationException;

public final class CalcoloGiorniValidator {
	public static final int MIN_GIORNI_LAVORATI = 180;

	private CalcoloGiorniValidator() {
		/* NOP */
	}

	public static void validate(Date dataPresentazione, List<PeriodoLavorativo> periodi, String path) throws ValidationException {
		if (dataPresentazione == null) {
			throw ErrorCodeEnum.VAL_PER_001.buildException(path);
		}

		if (CollectionUtils.isEmpty(periodi)) {
			throw ErrorCodeEnum.VAL_PER_002.buildException(path);
		}

		if (!checkPeriodi(periodi)) {
			throw ErrorCodeEnum.VAL_PER_003.buildException(path);
		}

		int giorniLavorati = getGiorniLavorati(dataPresentazione, periodi);
		if (giorniLavorati < MIN_GIORNI_LAVORATI) {
			throw ErrorCodeEnum.VAL_PER_004.buildException(path);
		}
	}

	private static int getGiorniLavorati(Date dataPresentazione, List<PeriodoLavorativo> periodi) {
		Set<String> days = new HashSet<>();

		if (CollectionUtils.isNotEmpty(periodi)) {
			for (PeriodoLavorativo periodo : periodi) {
				List<Date> range = DateRangeBuilder
						.onInterval(periodo.getDataInizio(), periodo.getDataFine())
						.withStartFrame(getInizioValidita(dataPresentazione))
						.withEndFrame(dataPresentazione)
						.build();

				for (Date date : range) {
					days.add(DateUtils.toStringDate(date, DateUtils.DEFAULT_DATE_FORMAT));
				}
			}
		}

		return days.size();
	}

	private static boolean checkPeriodi(List<PeriodoLavorativo> periodi) {
		if (CollectionUtils.isNotEmpty(periodi)) {
			for (PeriodoLavorativo p : periodi) {
				Date dataInizio = p.getDataInizio();
				Date dataFine = p.getDataFine();

				if (dataInizio == null || dataFine == null || !DateUtils.isValidRange(dataInizio, dataFine)) {
					return false;
				}
			}
		}

		return true;
	}

	private static Date getInizioValidita(Date dataPresentazione) {
		Calendar c = DateUtils.toCalendar(dataPresentazione);
		c.add(Calendar.YEAR, -1);
		return c.getTime();
	}

}
