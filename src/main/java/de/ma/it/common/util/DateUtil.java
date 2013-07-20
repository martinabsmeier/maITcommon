/*
 * Utility class for a easy way to handle Date
 * Copyright (C) 2012 Martin Absmeier, IT Consulting Services
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package de.ma.it.common.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * Date utility class to parse a date string and format date.
 * 
 * @author Martin Absmeier
 */
public class DateUtil implements PreconditionsMessages {

	/** GERMAN_STANDARD_NO_TIME - dd.MM.yyyy */
	public static DateFormat GERMAN_STANDARD_NO_TIME = new SimpleDateFormat("dd.MM.yyyy");

	/** GERMAN_STANDARD_TIME_LONG - dd.MM.yyyy HH:mm:ss */
	public static DateFormat GERMAN_STANDARD_TIME_LONG = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

	/** GERMAN_STANDARD_TIME - dd.MM.yyyy HH:mm */
	public static DateFormat GERMAN_STANDARD_TIME = new SimpleDateFormat("dd.MM.yyyy HH:mm");

	/** GERMAN_SHORT_NO_TIME - dd.MM.yy */
	public static DateFormat GERMAN_SHORT_NO_TIME = new SimpleDateFormat("dd.MM.yy");

	/** GERMAN_SHORT_TIME_LONG - dd.MM.yy HH:mm:ss */
	public static DateFormat GERMAN_SHORT_TIME_LONG = new SimpleDateFormat("dd.MM.yy HH:mm:ss");

	/** GERMAN_SHORT_TIME - dd.MM.yy HH:mm:ss */
	public static DateFormat GERMAN_SHORT_TIME = new SimpleDateFormat("dd.MM.yy HH:mm");

	/** US_STANDARD_NO_TIME - yyyy-MM-dd */
	public static DateFormat US_STANDARD_NO_TIME = new SimpleDateFormat("yyyy-MM-dd");

	/** US_STANDARD_TIME_LONG - yyyy-MM-dd HH:mm:ss */
	public static DateFormat US_STANDARD_TIME_LONG = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	/** US_STANDARD_TIME - yyyy-MM-dd HH:mm */
	public static DateFormat US_STANDARD_TIME = new SimpleDateFormat("yyyy-MM-dd HH:mm");

	/** US_SHORT_NO_TIME - yy-MM-dd */
	public static DateFormat US_SHORT_NO_TIME = new SimpleDateFormat("yy-MM-dd");

	/** US_SHORT_TIME_LONG - yy-MM-dd HH:mm:ss */
	public static DateFormat US_SHORT_TIME_LONG = new SimpleDateFormat("yy-MM-dd HH:mm:ss");

	/** US_SHORT_TIME - yy-MM-dd HH:mm */
	public static DateFormat US_SHORT_TIME = new SimpleDateFormat("yy-MM-dd HH:mm");

	/** MILLIS_PER_SECOND */
	public static final long MILLIS_PER_SECOND = 1000L;

	/** MILLIS_PER_MINUTE */
	public static final long MILLIS_PER_MINUTE = MILLIS_PER_SECOND * 60L;

	/** MILLIS_PER_HOUR */
	public static final long MILLIS_PER_HOUR = MILLIS_PER_MINUTE * 60L;

	/** MILLIS_PER_HOUR */
	public static final long MILLIS_PER_DAY = MILLIS_PER_HOUR * 24L;

	/**
	 * Calculates the easter day of given year.
	 * 
	 * @param year
	 *            the given year
	 * @return the calculated easter day
	 */
	public static Date calculateEasterDay(int year) {
		int a = year % 19;
		int b = year % 4;
		int c = year % 7;
		int month = 0;

		int m = (8 * (year / 100) + 13) / 25 - 2;
		int s = year / 100 - year / 400 - 2;
		m = (15 + s - m) % 30;
		int n = (6 + s) % 7;

		int d = (m + 19 * a) % 30;

		if (d == 29) {
			d = 28;
		} else if (d == 28 && a >= 11) {
			d = 27;
		}

		int e = (2 * b + 4 * c + 6 * d + n) % 7;
		int day = 21 + d + e + 1;

		if (day > 31) {
			day = day % 31;
			month = 4;
		}
		if (day <= 31) {
			month = 3;
		}

		month++;
		return createDate(year, month, day);
	}

	/**
	 * Converts a <code>java.sql.Date</code> to <code>java.util.Date</code>.
	 * 
	 * @param date
	 *            the given <code>java.sql.Date</code>
	 * @return the created <code>java.util.Date</code>
	 */
	public static Date convertDate(java.sql.Date date) {
		return new Date(date.getTime());
	}

	/**
	 * Creates a calendar from given date.
	 * 
	 * @param date
	 *            the given date
	 * @return the created <code>Calendar</code>.
	 */
	public static Calendar createCalendar(Date date) {
		Calendar cal = Calendar.getInstance(Locale.GERMANY);
		cal.setTimeInMillis(date.getTime());

		return cal;
	}

	/**
	 * Creates a <code>java.util.Date</code> <b>without</b> time slice.
	 * 
	 * @param year
	 *            the given year
	 * @param month
	 *            the given month
	 * @param date
	 *            the given date
	 * @return the created <code>java.util.Date</code>.
	 */
	public static Date createDate(int year, int month, int date) {
		return createDate(year, month, date, 0, 0, 0);
	}

	/**
	 * Creates a <code>java.util.Date</code> <b>with</b> time slice.
	 * 
	 * @param year
	 *            the given year
	 * @param month
	 *            the given month
	 * @param date
	 *            the given date
	 * @param hourOfDay
	 *            the given hour of day
	 * @param minute
	 *            the given minute
	 * @param second
	 *            the given second
	 * @return the created <code>java.util.Date</code>.
	 */
	public static Date createDate(int year, int month, int date, int hourOfDay, int minute, int second) {
		Calendar cal = Calendar.getInstance();
		cal.set(year, (month - 1), date, hourOfDay, minute, second);

		return new Date(cal.getTimeInMillis());
	}

	/**
	 * Deletes the time slice of <code>java.util.Date</code>.
	 * 
	 * @param date
	 *            the given date
	 * @return the <code>java.util.Date</code> <b>without</b> time slice.
	 */
	public static Date deleteTimeSlice(Date date) {
		Calendar cal = createCalendar(date);
		cal.set(Calendar.HOUR, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);

		return cal.getTime();
	}

	/**
	 * Provides an array day, month and year.<br>
	 * <code>
	 * int[] ingredients = getDateIngredients(date);<br>
	 * int day = res[0];<br>
	 * int month = res[1];<br>
	 * int year = res[2];<br>
	 * <code>
	 * 
	 * @param date
	 *            The given date.
	 * @return The ingredients of date
	 */
	public static int[] getDateIngredients(Date date) {
		int[] ingredients = new int[3];

		Calendar cal = createCalendar(date);
		ingredients[0] = cal.get(Calendar.DATE);
		ingredients[1] = cal.get(Calendar.MONTH);
		ingredients[2] = cal.get(Calendar.YEAR);

		return ingredients;
	}

	/**
	 * Checks if date1 is after date2. It is tested without time slice.
	 * 
	 * @param date1
	 *            The first given date
	 * @param date2
	 *            The second given date
	 * @return <code>true</code> if date1 is after date2; <code>false</code>
	 *         otherwise.
	 */
	public static boolean isAfter(Date date1, Date date2) {
		int[] dIng1 = getDateIngredients(date1);
		int day1 = dIng1[0];
		int month1 = dIng1[1];
		int year1 = dIng1[2];

		int[] dIng2 = getDateIngredients(date2);
		int day2 = dIng2[0];
		int month2 = dIng2[1];
		int year2 = dIng2[2];

		if (year1 > year2) {
			return true;
		}
		if (year1 < year2) {
			return false;
		}

		if (year1 == year2 && month1 > month2) {
			return true;
		}
		if (year1 == year2 && month1 < month2) {
			return false;
		}

		if (year1 == year2 && month1 == month2 && day1 > day2) {
			return true;
		}

		return false;
	}

	/**
	 * Determines if the time slice of <code>java.util.Date</code> is afternoon.
	 * 
	 * @param date
	 *            the given date
	 * @return <code>true</code> if the given date is afternoon;
	 *         <code>false</code> otherwise.
	 */
	public static boolean isAfternoon(Date date) {
		Calendar cal = createCalendar(date);
		int hourOfDay = cal.get(Calendar.HOUR_OF_DAY);
		return hourOfDay > 12;
	}

	/**
	 * Checks if date1 is before date2. It is tested without time slice.
	 * 
	 * @param date1
	 *            The first given date
	 * @param date2
	 *            The second given date
	 * @return <code>true</code> if date1 is before date2; <code>false</code>
	 *         otherwise.
	 */
	public static boolean isBefore(Date date1, Date date2) {
		int[] dIng1 = getDateIngredients(date1);
		int day1 = dIng1[0];
		int month1 = dIng1[1];
		int year1 = dIng1[2];

		int[] dIng2 = getDateIngredients(date2);
		int day2 = dIng2[0];
		int month2 = dIng2[1];
		int year2 = dIng2[2];

		if (year1 < year2) {
			return true;
		}
		if (year1 > year2) {
			return false;
		}

		if (year1 == year2 && month1 < month2) {
			return true;
		}
		if (year1 == year2 && month1 > month2) {
			return false;
		}

		if (year1 == year2 && month1 == month2 && day1 < day2) {
			return true;
		}

		return false;
	}

	/**
	 * Checks if date1 is equal date2. It is tested without time slice.
	 * 
	 * @param date1
	 *            The first given date
	 * @param date2
	 *            The second given date
	 * @return <code>true</code> if date1 is equal date2; <code>false</code>
	 *         otherwise.
	 */
	public static boolean isEqual(Date date1, Date date2) {
		int[] dIng1 = getDateIngredients(date1);
		int[] dIng2 = getDateIngredients(date2);
		if (dIng1[0] == dIng2[0] && dIng1[1] == dIng2[1] && dIng1[2] == dIng2[2]) {
			return true;
		}
		return false;
	}

	/**
	 * Determines if the time slice of <code>java.util.Date</code> is forenoon.
	 * 
	 * @param date
	 *            the given date
	 * @return <code>true</code> if the given date is forenoon;
	 *         <code>false</code> otherwise.
	 */
	public static boolean isForenoon(Date date) {
		Calendar cal = createCalendar(date);
		int hourOfDay = cal.get(Calendar.HOUR_OF_DAY);
		return hourOfDay <= 12;
	}

	/**
	 * Determines if the given date is a german holiday. Returns
	 * <code>true</code> if the given date is a holiday.
	 * 
	 * @param date
	 *            the given date
	 * @return <code>true</code> if the given date is holiday;
	 *         <code>false</code> otherwise.
	 */
	public static boolean isHoliday(Date date) {
		int[] dIng = getDateIngredients(calculateEasterDay(createCalendar(date).get(Calendar.YEAR)));

		Calendar easterSunday = new GregorianCalendar(dIng[2], dIng[1], dIng[0]);
		Calendar easterMonday = new GregorianCalendar(dIng[2], dIng[1], (dIng[0]) + 1);
		Calendar goodFriday = new GregorianCalendar(dIng[2], dIng[1], (dIng[0]) - 2);
		Calendar rosenMonday = new GregorianCalendar(dIng[2], dIng[1], (dIng[0]) - 48);
		Calendar ascensionDay = new GregorianCalendar(dIng[2], dIng[1], (dIng[0]) + 39);
		Calendar whitSunday = new GregorianCalendar(dIng[2], dIng[1], (dIng[0]) + 49);
		Calendar whitMonday = new GregorianCalendar(dIng[2], dIng[1], (dIng[0]) + 50);
		Calendar corpusChristi = new GregorianCalendar(dIng[2], dIng[1], (dIng[0]) + 60);
		Calendar reUnion = new GregorianCalendar(dIng[2], 9, 1);
		Calendar christmasDay1 = new GregorianCalendar(dIng[2], 11, 24);
		Calendar christmasDay2 = new GregorianCalendar(dIng[2], 11, 25);
		Calendar christmasDay3 = new GregorianCalendar(dIng[2], 11, 26);
		Calendar newYearsEve = new GregorianCalendar(dIng[2], 11, 31);
		Calendar newYear = new GregorianCalendar(dIng[2], 0, 1);

		Calendar cal = createCalendar(date);
		if (	easterSunday.equals(cal) || 
				easterMonday.equals(cal) || 
				goodFriday.equals(cal) || 
				rosenMonday.equals(cal) || 
				ascensionDay.equals(cal) || 
				whitSunday.equals(cal) || 
				whitMonday.equals(cal) || 
				corpusChristi.equals(cal) || 
				reUnion.equals(cal) || 
				christmasDay1.equals(cal) || 
				christmasDay2.equals(cal) || 
				christmasDay3.equals(cal) || 
				newYearsEve.equals(cal) || 
				newYear.equals(cal)) 
		{
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Determines if the given year is a leap year. Returns <code>true</code> if
	 * the given year is a leap year. To specify BC year numbers,
	 * <code>1 - year number</code> must be given. For example, year BC 4 is
	 * specified as -3.
	 * 
	 * @param year
	 *            the given year.
	 * @return <code>true</code> if the given year is a leap year;
	 *         <code>false</code> otherwise.
	 */
	public static boolean isLeapYear(int year) {
		return new GregorianCalendar().isLeapYear(year);
	}

	/**
	 * Analyzes the <code>date</code> string and tries to generate a
	 * <code>java.util.Date</code>.
	 * 
	 * @param date
	 *            the given date as string
	 * @return the <code>java.util.Date</code>.
	 * @throws ParseException
	 *             if <code>date</code> string can not be parsed.
	 */
	public static Date parse(String date) throws ParseException {
		Date result = null;

		// dd.MM.yy or yy-MM-dd
		if (date.length() == 8) {
			if (date.contains(".")) {
				result = GERMAN_SHORT_NO_TIME.parse(date);
			} else {
				result = US_SHORT_NO_TIME.parse(date);
			}
		}

		// dd.MM.yyyy or yyyy-MM-dd
		if (date.length() == 10) {
			if (date.contains(".")) {
				result = GERMAN_STANDARD_NO_TIME.parse(date);
			} else {
				result = US_STANDARD_NO_TIME.parse(date);
			}
		}

		return result;
	}

	/* --------------------------------------------------------------------- */

	/** Standard Constructor */
	private DateUtil() {
		super();
	}

}
