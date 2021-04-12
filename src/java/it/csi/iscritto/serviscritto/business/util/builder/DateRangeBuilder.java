package it.csi.iscritto.serviscritto.business.util.builder;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.builder.Builder;

import it.csi.iscritto.serviscritto.business.util.DateUtils;

public final class DateRangeBuilder implements Builder<List<Date>> {
	private Date startDate;
	private Date endDate;
	private Date startFrame;
	private Date endFrame;

	private DateRangeBuilder(Date startDate, Date endDate) {
		this.startDate = startDate;
		this.endDate = endDate;
		this.startFrame = null;
		this.endFrame = null;
	}

	public static DateRangeBuilder onInterval(Date startDate, Date endDate) {
		Validate.notNull(startDate);
		Validate.notNull(endDate);

		return new DateRangeBuilder(startDate, endDate);
	}

	public DateRangeBuilder withStartFrame(Date startFrame) {
		Validate.notNull(startFrame);

		this.startFrame = startFrame;
		return this;
	}

	public DateRangeBuilder withEndFrame(Date endFrame) {
		Validate.notNull(endFrame);

		this.endFrame = endFrame;
		return this;
	}

	@Override
	public List<Date> build() {
		if (!checkStatus()) {
			throw new IllegalArgumentException();
		}

		return getDatesBetween(this.startDate, this.endDate, this.startFrame, this.endFrame);
	}

	private boolean checkStatus() {
		if (!DateUtils.isValidRange(this.startDate, this.endDate)) {
			return false;
		}

		if (this.startFrame != null && this.endFrame != null) {
			if (!DateUtils.isValidRange(this.startFrame, this.endFrame)) {
				return false;
			}
		}

		return true;
	}

	private static List<Date> getDatesBetween(Date startDate, Date endDate, Date startFrame, Date endFrame) {
		Calendar startCalendar = DateUtils.toCalendar(startDate);
		Calendar endCalendar = DateUtils.toCalendar(endDate);

		List<Date> result = new ArrayList<>();
		while (startCalendar.compareTo(endCalendar) <= 0) {
			if (isDateInRange(startCalendar.getTime(), startFrame, endFrame)) {
				result.add(startCalendar.getTime());
			}

			startCalendar.add(Calendar.DATE, 1);
		}

		return result;
	}

	private static boolean isDateInRange(Date testDate, Date startFrame, Date endFrame) {
		if (startFrame == null && endFrame == null) {
			return true;
		}

		if (startFrame != null && endFrame == null) {
			return testDate.compareTo(startFrame) >= 0;
		}

		if (startFrame == null && endFrame != null) {
			return testDate.compareTo(endFrame) <= 0;
		}

		if (startFrame != null && endFrame != null) {
			return testDate.compareTo(startFrame) >= 0 && testDate.compareTo(endFrame) <= 0;
		}

		return false;
	}

}
