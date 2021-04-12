package it.csi.iscritto.serviscritto.business.integration.validation;

import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

import it.csi.iscritto.serviscritto.exception.domanda.ValidationException;

public final class CodiceFiscaleValidator {
	public static final int NUMERIC_LENGTH = 11;
	public static final int ALPHANUMERIC_LENGTH = 16;

	private static final String REGEX_NUMERIC = "\\d+";
	private static final Pattern PATTERN_NUMERIC = Pattern.compile(REGEX_NUMERIC);

	private static final String REGEX_ALPHANUMERIC = "[A-Za-z0-9]+";
	private static final Pattern PATTERN_ALPHANUMERIC = Pattern.compile(REGEX_ALPHANUMERIC);

	private CodiceFiscaleValidator() {
		/* NOP */
	}

	public static void validate(String cf, String path) throws ValidationException {
		if (StringUtils.isBlank(cf)) {
			throw ErrorCodeEnum.VAL_CF_001.buildException(path);
		}

		if (!checkLength(cf)) {
			throw ErrorCodeEnum.VAL_CF_002.buildException(path);
		}

		if (isNumericType(cf)) {
			if (!checkNumericFormat(cf)) {
				throw ErrorCodeEnum.VAL_CF_003.buildException(path);
			}
		}

		if (isAlphanumericType(cf)) {
			if (!checkAlphanumericFormat(cf)) {
				throw ErrorCodeEnum.VAL_CF_004.buildException(path);
			}

			if (!checkDigit(cf)) {
				throw ErrorCodeEnum.VAL_CF_005.buildException(path);
			}
		}
	}

	private static boolean isNumericType(String cf) {
		return cf.length() == NUMERIC_LENGTH;
	}

	private static boolean isAlphanumericType(String cf) {
		return cf.length() == ALPHANUMERIC_LENGTH;
	}

	private static boolean checkLength(String cf) {
		return isNumericType(cf) || isAlphanumericType(cf);
	}

	private static boolean checkNumericFormat(String cf) {
		if (!PATTERN_NUMERIC.matcher(cf).matches()) {
			return false;
		}

		return true;
	}

	private static boolean checkAlphanumericFormat(String cf) {
		if (!PATTERN_ALPHANUMERIC.matcher(cf).matches()) {
			return false;
		}

		return true;
	}

	private static boolean checkDigit(String cf) {
		int c, i, checkDigit;
		int setdisp[] = { 1, 0, 5, 7, 9, 13, 15, 17, 19, 21, 2, 4, 18, 20, 11, 3, 6, 8, 12, 14, 16, 10, 22, 25, 24, 23 };

		String codiceFiscale = cf.toUpperCase();
		checkDigit = 0;

		for (i = 1; i <= 13; i += 2) {
			c = codiceFiscale.charAt(i);
			if (c >= '0' && c <= '9') {
				checkDigit += c - '0';
			}
			else {
				checkDigit += c - 'A';
			}
		}

		for (i = 0; i <= 14; i += 2) {
			c = codiceFiscale.charAt(i);
			if (c >= '0' && c <= '9') {
				c = c - '0' + 'A';
			}
			checkDigit += setdisp[c - 'A'];
		}

		if (checkDigit % 26 + 'A' != codiceFiscale.charAt(15)) {
			return false;
		}

		return true;
	}

}
