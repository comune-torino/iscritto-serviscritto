package it.csi.iscritto.serviscritto.business.integration.validation;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.builder.Builder;

import it.csi.iscritto.serviscritto.business.util.Joiner;
import it.csi.iscritto.serviscritto.exception.domanda.ValidationException;

public class ValidationExceptionBuilder implements Builder<ValidationException> {
	private ErrorCodeEnum error;
	private String path;
	private Throwable cause;

	private ValidationExceptionBuilder(ErrorCodeEnum error) {
		Validate.notNull(error);

		this.error = error;
	}

	public static final ValidationExceptionBuilder from(ErrorCodeEnum error) {
		return new ValidationExceptionBuilder(error);
	}

	public ValidationExceptionBuilder withPath(String path) {
		this.path = path;
		return this;
	}

	public ValidationExceptionBuilder withCause(Throwable cause) {
		this.cause = cause;
		return this;
	}

	@Override
	public ValidationException build() {
		List<String> messages = new ArrayList<>();

		messages.add(this.error.getCode());
		messages.add(this.error.getDescription());
		if (StringUtils.isNotEmpty(this.path)) {
			messages.add(this.path);
		}

		String message = Joiner.on("|").join(messages);

		return this.cause == null
				? new ValidationException(message)
				: new ValidationException(message, this.cause);
	}

}
