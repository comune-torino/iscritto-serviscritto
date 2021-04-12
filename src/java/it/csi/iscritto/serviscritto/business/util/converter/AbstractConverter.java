package it.csi.iscritto.serviscritto.business.util.converter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class AbstractConverter<S, T> implements Converter<S, T> {

	protected void beforeConversion(List<S> sourceList) {
		/* NOP */
	}

	public final List<T> convertAll(List<S> source) {
		List<T> target = new ArrayList<>();

		if (source != null) {
			this.beforeConversion(source);

			for (S s : source) {
				target.add(this.convert(s));
			}

			this.afterConversion(target);
		}

		return target;
	}

	public final List<T> convertAll(S[] source) {
		return this.convertAll(toList(source));
	}

	protected void afterConversion(List<T> targetList) {
		/* NOP */
	}

	private static <T> List<T> toList(T[] values) {
		List<T> result = new ArrayList<>();
		if (values != null) {
			result.addAll(Arrays.asList(values));
		}

		return result;
	}

}
