package it.csi.iscritto.serviscritto.business.util.converter;

import java.util.List;

public interface Converter<S, T> {

	T convert(S source);

	List<T> convertAll(List<S> source);

}
