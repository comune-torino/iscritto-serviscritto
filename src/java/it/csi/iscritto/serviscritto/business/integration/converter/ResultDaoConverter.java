package it.csi.iscritto.serviscritto.business.integration.converter;

import it.csi.iscritto.serviscritto.business.integration.dao.ResultDao;
import it.csi.iscritto.serviscritto.business.util.converter.AbstractConverter;
import it.csi.iscritto.serviscritto.business.util.converter.ConvertUtils;
import it.csi.iscritto.serviscritto.dto.domanda.Result;

public class ResultDaoConverter extends AbstractConverter<ResultDao, Result> {

	@Override
	public Result convert(ResultDao source) {
		Result target = new Result();

		if (source != null) {
			target.setStatus(source.getStatus());
			target.setMessages(ConvertUtils.toArray(source.getMessages(), String.class));
		}

		if (target.getMessages() == null) {
			target.setMessages(new String[0]);
		}

		return target;
	}

}
