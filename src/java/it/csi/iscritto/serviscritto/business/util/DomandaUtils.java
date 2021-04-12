package it.csi.iscritto.serviscritto.business.util;

import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.LOG_ERROR;
import static it.csi.iscritto.serviscritto.business.util.LoggingUtils.buildMessage;
import static it.csi.iscritto.serviscritto.business.util.converter.ConvertUtils.toList;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import it.csi.iscritto.serviscritto.business.integration.dao.TipoSoggetto;
import it.csi.iscritto.serviscritto.business.integration.dao.view.dto.ScuolaRow;
import it.csi.iscritto.serviscritto.business.integration.dao.view.dto.SoggettoRow;
import it.csi.iscritto.serviscritto.business.integration.exception.ServiceException;
import it.csi.iscritto.serviscritto.business.integration.validation.model.PeriodoLavorativo;
import it.csi.iscritto.serviscritto.dto.domanda.Affido;
import it.csi.iscritto.serviscritto.dto.domanda.AltriComponenti;
import it.csi.iscritto.serviscritto.dto.domanda.Anagrafica;
import it.csi.iscritto.serviscritto.dto.domanda.ComponentiNucleo;
import it.csi.iscritto.serviscritto.dto.domanda.CondizioneOccupazionale;
import it.csi.iscritto.serviscritto.dto.domanda.Documento;
import it.csi.iscritto.serviscritto.dto.domanda.DomandaMaterna;
import it.csi.iscritto.serviscritto.dto.domanda.DomandaNido;
import it.csi.iscritto.serviscritto.dto.domanda.NonOccupato;
import it.csi.iscritto.serviscritto.dto.domanda.Richiedente;
import it.csi.iscritto.serviscritto.dto.domanda.Soggetto1;
import it.csi.iscritto.serviscritto.dto.domanda.SoggettoAffido;
import it.csi.iscritto.serviscritto.dto.domanda.SoggettoAltroComponente;
import it.csi.iscritto.serviscritto.dto.domanda.SoggettoNucleo;

public final class DomandaUtils {
	private static final Logger log = Logger.getLogger(Constants.COMPONENT_NAME + ".business");

	private DomandaUtils() {
		/* NOP */
	}

	public static boolean checkSoggetto(DomandaNido domandaNido, TipoSoggetto tipoSoggetto) throws ServiceException {
		switch (tipoSoggetto) {
			case RIC:
				if (domandaNido.getRichiedente() != null && checkAnagrafica(domandaNido.getRichiedente().getAnagrafica())) {
					return true;
				}
				break;
			case MIN:
				if (domandaNido.getMinore() != null && checkAnagrafica(domandaNido.getMinore().getAnagrafica())) {
					return true;
				}
				break;
			case SOG1:
				if (domandaNido.getSoggetto1() != null && checkAnagrafica(domandaNido.getSoggetto1().getAnagrafica())) {
					return true;
				}
				break;
			case SOG2:
				if (domandaNido.getSoggetto2() != null && checkAnagrafica(domandaNido.getSoggetto2().getAnagrafica())) {
					return true;
				}
				break;
			case SOG3:
				if (domandaNido.getSoggetto3() != null && Boolean.TRUE.equals(domandaNido.getSoggetto3().getStato())) {
					if (domandaNido.getSoggetto3().getDati() != null && checkAnagrafica(domandaNido.getSoggetto3().getDati().getAnagrafica())) {
						return true;
					}
				}
				break;
			default:
				throw new ServiceException();
		}

		return false;
	}

	public static boolean checkSoggetto(DomandaMaterna domandaMaterna, TipoSoggetto tipoSoggetto) throws ServiceException {
		switch (tipoSoggetto) {
			case RIC:
				if (domandaMaterna.getRichiedente() != null && checkAnagrafica(domandaMaterna.getRichiedente().getAnagrafica())) {
					return true;
				}
				break;
			case MIN:
				if (domandaMaterna.getMinore() != null && checkAnagrafica(domandaMaterna.getMinore().getAnagrafica())) {
					return true;
				}
				break;
			case SOG1:
				if (domandaMaterna.getSoggetto1() != null && checkAnagrafica(domandaMaterna.getSoggetto1().getAnagrafica())) {
					return true;
				}
				break;
			case SOG2:
				if (domandaMaterna.getSoggetto2() != null && checkAnagrafica(domandaMaterna.getSoggetto2().getAnagrafica())) {
					return true;
				}
				break;
			case SOG3:
				if (domandaMaterna.getSoggetto3() != null && Boolean.TRUE.equals(domandaMaterna.getSoggetto3().getStato())) {
					if (domandaMaterna.getSoggetto3().getDati() != null && checkAnagrafica(domandaMaterna.getSoggetto3().getDati().getAnagrafica())) {
						return true;
					}
				}
				break;
			default:
				throw new ServiceException();
		}

		return false;
	}

	public static CondizioneOccupazionale getCondizioneOccupazionale(DomandaNido domandaNido, TipoSoggetto tipoSoggetto)
			throws ServiceException {

		CondizioneOccupazionale condizioneOccupazionale;
		switch (tipoSoggetto) {
			case SOG1:
				condizioneOccupazionale = domandaNido.getSoggetto1() == null ? null : domandaNido.getSoggetto1().getCondizioneOccupazionale();
				break;
			case SOG2:
				condizioneOccupazionale = domandaNido.getSoggetto2() == null ? null : domandaNido.getSoggetto2().getCondizioneOccupazionale();
				break;
			default:
				throw new ServiceException();
		}

		return condizioneOccupazionale;
	}

	public static CondizioneOccupazionale getCondizioneOccupazionale(DomandaMaterna domandaMaterna, TipoSoggetto tipoSoggetto)
			throws ServiceException {

		CondizioneOccupazionale condizioneOccupazionale;
		switch (tipoSoggetto) {
			case SOG1:
				condizioneOccupazionale = domandaMaterna.getSoggetto1() == null ? null : domandaMaterna.getSoggetto1().getCondizioneOccupazionale();
				break;
			case SOG2:
				condizioneOccupazionale = domandaMaterna.getSoggetto2() == null ? null : domandaMaterna.getSoggetto2().getCondizioneOccupazionale();
				break;
			default:
				throw new ServiceException();
		}

		return condizioneOccupazionale;
	}

	public static Date toDate(String date) throws ServiceException {
		final String methodName = "toDate";

		if (StringUtils.isBlank(date)) {
			return null;
		}

		try {
			return DateUtils.toDate(date, DateUtils.DEFAULT_DATE_FORMAT);
		}
		catch (ParseException e) {
			log.error(buildMessage(DomandaUtils.class, methodName, LOG_ERROR), e);
			throw new ServiceException(e);
		}
	}

	public static boolean checkAnagrafica(Anagrafica anagrafica) {
		if (anagrafica == null) {
			return false;
		}

		if (StringUtils.isBlank(anagrafica.getNome()) || StringUtils.isBlank(anagrafica.getCognome())) {
			return false;
		}

		return true;
	}

	public static Map<String, SoggettoRow> indexSoggettoByCF(List<SoggettoRow> list) {
		Map<String, SoggettoRow> index = new LinkedHashMap<>();
		if (CollectionUtils.isNotEmpty(list)) {
			for (SoggettoRow item : list) {
				index.put(item.getCodiceFiscale(), item);
			}
		}

		return index;
	}

	public static Map<Long, ScuolaRow> indexScuoleById(List<ScuolaRow> list) {
		Map<Long, ScuolaRow> index = new LinkedHashMap<>();
		if (CollectionUtils.isNotEmpty(list)) {
			for (ScuolaRow item : list) {
				index.put(item.getIdScuola(), item);
			}
		}

		return index;
	}

	public static boolean areEquals(SoggettoRow a, SoggettoRow b) {
		if (a == null || b == null) {
			return false;
		}

		String cfA = a.getCodiceFiscale();
		String cfB = b.getCodiceFiscale();

		if (StringUtils.isBlank(cfA) || StringUtils.isBlank(cfB)) {
			return false;
		}

		if (!cfA.equalsIgnoreCase(cfB)) {
			return false;
		}

		String tipoA = a.getCodTipoSoggetto();
		String tipoB = b.getCodTipoSoggetto();

		if (StringUtils.isBlank(tipoA) || StringUtils.isBlank(tipoB)) {
			return false;
		}

		if (!tipoA.equalsIgnoreCase(tipoB)) {
			return false;
		}

		return true;
	}

	public static boolean isRicSog1(DomandaNido domandaNido) throws ServiceException {
		if (domandaNido == null) {
			return false;
		}

		Richiedente richiedente = domandaNido.getRichiedente();
		Soggetto1 soggetto1 = domandaNido.getSoggetto1();

		return isRicSog1(richiedente, soggetto1);
	}

	public static boolean isRicSog1(DomandaMaterna domandaMaterna) throws ServiceException {
		if (domandaMaterna == null) {
			return false;
		}

		Richiedente richiedente = domandaMaterna.getRichiedente();
		Soggetto1 soggetto1 = domandaMaterna.getSoggetto1();

		return isRicSog1(richiedente, soggetto1);
	}

	public static boolean isRicSog1(Richiedente richiedente, Soggetto1 soggetto1) throws ServiceException {
		if (richiedente == null || soggetto1 == null) {
			return false;
		}

		Anagrafica anagraficaRic = richiedente.getAnagrafica();
		Anagrafica anagraficaSog1 = soggetto1.getAnagrafica();

		if (anagraficaRic == null || anagraficaSog1 == null) {
			return false;
		}

		String cfRic = anagraficaRic.getCodiceFiscale();
		String cfSog1 = anagraficaSog1.getCodiceFiscale();

		if (StringUtils.isBlank(cfRic) || StringUtils.isBlank(cfSog1)) {
			return false;
		}

		if (!cfRic.equalsIgnoreCase(cfSog1)) {
			return false;
		}

		return true;
	}

	public static List<SoggettoNucleo> getComponenti(DomandaNido domandaNido) {
		List<SoggettoNucleo> result = new ArrayList<>();
		ComponentiNucleo componentiNucleo = domandaNido.getComponentiNucleo();
		if (componentiNucleo != null) {
			result.addAll(toList(componentiNucleo.getSoggetti()));
		}

		return result;
	}

	public static List<SoggettoNucleo> getComponenti(DomandaMaterna domandaMaterna) {
		List<SoggettoNucleo> result = new ArrayList<>();
		ComponentiNucleo componentiNucleo = domandaMaterna.getComponentiNucleo();
		if (componentiNucleo != null) {
			result.addAll(toList(componentiNucleo.getSoggetti()));
		}

		return result;
	}

	public static List<SoggettoAltroComponente> getAltriComponenti(DomandaNido domandaNido) {
		List<SoggettoAltroComponente> result = new ArrayList<>();
		AltriComponenti altriComponenti = domandaNido.getAltriComponenti();
		if (altriComponenti != null) {
			result.addAll(toList(altriComponenti.getSoggetti()));
		}

		return result;
	}

	public static List<SoggettoAltroComponente> getAltriComponenti(DomandaMaterna domandaMaterna) {
		List<SoggettoAltroComponente> result = new ArrayList<>();
		AltriComponenti altriComponenti = domandaMaterna.getAltriComponenti();
		if (altriComponenti != null) {
			result.addAll(toList(altriComponenti.getSoggetti()));
		}

		return result;
	}

	public static List<SoggettoAffido> getAffidi(DomandaNido domandaNido) {
		List<SoggettoAffido> result = new ArrayList<>();
		Affido affido = domandaNido.getAffido();
		if (affido != null) {
			result.addAll(toList(affido.getSoggetti()));
		}

		return result;
	}

	public static List<SoggettoAffido> getAffidi(DomandaMaterna domandaMaterna) {
		List<SoggettoAffido> result = new ArrayList<>();
		Affido affido = domandaMaterna.getAffido();
		if (affido != null) {
			result.addAll(toList(affido.getSoggetti()));
		}

		return result;
	}

	public static List<PeriodoLavorativo> getPeriodiLavorativi(DomandaNido domandaNido, TipoSoggetto tipoSoggetto) throws ServiceException {
		return getPeriodiLavorativi(getCondizioneOccupazionale(domandaNido, tipoSoggetto));
	}

	public static List<PeriodoLavorativo> getPeriodiLavorativi(DomandaMaterna domandaMaterna, TipoSoggetto tipoSoggetto) throws ServiceException {
		return getPeriodiLavorativi(getCondizioneOccupazionale(domandaMaterna, tipoSoggetto));
	}

	public static List<PeriodoLavorativo> getPeriodiLavorativi(CondizioneOccupazionale co) throws ServiceException {
		List<PeriodoLavorativo> result = new ArrayList<>();
		if (co != null && co.getDati() != null) {
			List<NonOccupato> periodi = toList(co.getDati().getNonOccupato());
			for (NonOccupato p : periodi) {
				PeriodoLavorativo pl = new PeriodoLavorativo();
				pl.setDataInizio(toDate(p.getDataInizio()));
				pl.setDataFine(toDate(p.getDataFine()));

				result.add(pl);
			}
		}

		return result;
	}

	public static List<Documento> getAllegatiDomanda(DomandaNido domandaNido) throws ServiceException {
		List<Documento> result = new ArrayList<>();

		if (checkSoggetto(domandaNido, TipoSoggetto.MIN)) {
			result.addAll(toList(domandaNido.getMinore().getDisabilita().getDocumenti()));
			result.addAll(toList(domandaNido.getMinore().getProblemiSalute().getDocumenti()));
			result.addAll(toList(domandaNido.getMinore().getServiziSociali().getDocumenti()));
		}

		if (checkSoggetto(domandaNido, TipoSoggetto.SOG1)) {
			result.addAll(toList(domandaNido.getSoggetto1().getGravidanza().getDocumenti()));
			result.addAll(toList(domandaNido.getSoggetto1().getProblemiSalute().getDocumenti()));
		}

		if (checkSoggetto(domandaNido, TipoSoggetto.SOG2)) {
			result.addAll(toList(domandaNido.getSoggetto2().getGravidanza().getDocumenti()));
			result.addAll(toList(domandaNido.getSoggetto2().getProblemiSalute().getDocumenti()));
		}

		ComponentiNucleo componentiNucleo = domandaNido.getComponentiNucleo();
		if (componentiNucleo != null) {
			List<SoggettoNucleo> soggetti = toList(componentiNucleo.getSoggetti());
			for (SoggettoNucleo soggetto : soggetti) {
				result.addAll(toList(soggetto.getProblemiSalute().getDocumenti()));
			}
		}

		AltriComponenti altriComponenti = domandaNido.getAltriComponenti();
		if (altriComponenti != null) {
			boolean delete = !Boolean.TRUE.equals(altriComponenti.getStato());
			List<SoggettoAltroComponente> soggetti = toList(altriComponenti.getSoggetti());
			for (SoggettoAltroComponente soggetto : soggetti) {
				List<Documento> documenti = toList(soggetto.getProblemiSalute().getDocumenti());
				for (Documento documento : documenti) {
					documento.setEliminato(documento.getEliminato() || delete);
				}

				result.addAll(documenti);
			}
		}

		Affido affido = domandaNido.getAffido();
		if (affido != null) {
			boolean delete = !Boolean.TRUE.equals(affido.getStato());
			List<SoggettoAffido> soggetti = toList(affido.getSoggetti());
			for (SoggettoAffido soggetto : soggetti) {
				List<Documento> documenti = toList(soggetto.getProblemiSalute().getDocumenti());
				for (Documento documento : documenti) {
					documento.setEliminato(documento.getEliminato() || delete);
				}

				result.addAll(documenti);
			}
		}

		return result;
	}

	public static List<Documento> getAllegatiDomanda(DomandaMaterna domandaMaterna) throws ServiceException {
		List<Documento> result = new ArrayList<>();

		if (checkSoggetto(domandaMaterna, TipoSoggetto.MIN)) {
			result.addAll(toList(domandaMaterna.getMinore().getDisabilita().getDocumenti()));
			result.addAll(toList(domandaMaterna.getMinore().getProblemiSalute().getDocumenti()));
			result.addAll(toList(domandaMaterna.getMinore().getServiziSociali().getDocumenti()));
		}

		if (checkSoggetto(domandaMaterna, TipoSoggetto.SOG1)) {
			result.addAll(toList(domandaMaterna.getSoggetto1().getGravidanza().getDocumenti()));
			result.addAll(toList(domandaMaterna.getSoggetto1().getProblemiSalute().getDocumenti()));
		}

		if (checkSoggetto(domandaMaterna, TipoSoggetto.SOG2)) {
			result.addAll(toList(domandaMaterna.getSoggetto2().getGravidanza().getDocumenti()));
			result.addAll(toList(domandaMaterna.getSoggetto2().getProblemiSalute().getDocumenti()));
		}

		ComponentiNucleo componentiNucleo = domandaMaterna.getComponentiNucleo();
		if (componentiNucleo != null) {
			List<SoggettoNucleo> soggetti = toList(componentiNucleo.getSoggetti());
			for (SoggettoNucleo soggetto : soggetti) {
				result.addAll(toList(soggetto.getProblemiSalute().getDocumenti()));
			}
		}

		AltriComponenti altriComponenti = domandaMaterna.getAltriComponenti();
		if (altriComponenti != null) {
			boolean delete = !Boolean.TRUE.equals(altriComponenti.getStato());
			List<SoggettoAltroComponente> soggetti = toList(altriComponenti.getSoggetti());
			for (SoggettoAltroComponente soggetto : soggetti) {
				List<Documento> documenti = toList(soggetto.getProblemiSalute().getDocumenti());
				for (Documento documento : documenti) {
					documento.setEliminato(documento.getEliminato() || delete);
				}

				result.addAll(documenti);
			}
		}

		Affido affido = domandaMaterna.getAffido();
		if (affido != null) {
			boolean delete = !Boolean.TRUE.equals(affido.getStato());
			List<SoggettoAffido> soggetti = toList(affido.getSoggetti());
			for (SoggettoAffido soggetto : soggetti) {
				List<Documento> documenti = toList(soggetto.getProblemiSalute().getDocumenti());
				for (Documento documento : documenti) {
					documento.setEliminato(documento.getEliminato() || delete);
				}

				result.addAll(documenti);
			}
		}

		return result;
	}

	public static Set<Long> getAllegatiEliminati(List<Documento> documenti) {
		Set<Long> result = new LinkedHashSet<>();
		if (CollectionUtils.isNotEmpty(documenti)) {
			for (Documento documento : documenti) {
				Long id = documento.getId();
				if (id != null && Boolean.TRUE.equals(documento.getEliminato())) {
					result.add(id);
				}
			}
		}

		return result;
	}

	public static String getCfRichiedente(DomandaNido domandaNido) {
		if (domandaNido == null) {
			return null;
		}

		return getCfRichiedente(domandaNido.getRichiedente());
	}

	public static String getCfRichiedente(DomandaMaterna domandaMaterna) {
		if (domandaMaterna == null) {
			return null;
		}

		return getCfRichiedente(domandaMaterna.getRichiedente());
	}

	public static String getCfRichiedente(Richiedente richiedente) {
		if (richiedente == null) {
			return null;
		}

		Anagrafica anagrafica = richiedente.getAnagrafica();
		if (anagrafica == null) {
			return null;
		}

		return anagrafica.getCodiceFiscale();
	}

	public static boolean iscrizione(Date dataNascita, Integer annoLimite, int maxAnni) {
		final String methodName = "iscrizione";

		if (annoLimite == null) {
			log.error(buildMessage(DomandaUtils.class, methodName, "anno limite nullo"));
			return false;
		}

		try {
			Date dataLimite = DateUtils.toDate(String.format("31/12/%d", annoLimite), DateUtils.DEFAULT_DATE_FORMAT);
			Date maxEta = DateUtils.addYears(dataNascita, maxAnni);

			return maxEta.compareTo(dataLimite) > 0;
		}
		catch (Exception e) {
			log.error(buildMessage(DomandaUtils.class, methodName, LOG_ERROR), e);
			return false;
		}
	}

}
