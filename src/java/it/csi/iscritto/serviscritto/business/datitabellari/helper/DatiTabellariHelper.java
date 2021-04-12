package it.csi.iscritto.serviscritto.business.datitabellari.helper;

import org.apache.log4j.Logger;

import it.csi.iscritto.serviscritto.business.integration.dao.view.DatiTabellariDao;
import it.csi.iscritto.serviscritto.business.util.Constants;

public class DatiTabellariHelper {
	private static final Logger log = Logger.getLogger(Constants.COMPONENT_NAME + ".helper");

	private DatiTabellariDao datiTabellariDao;

	public void setDatiTabellariDao(DatiTabellariDao datiTabellariDao) {
		this.datiTabellariDao = datiTabellariDao;
	}

}
