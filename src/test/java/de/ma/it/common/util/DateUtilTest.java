/*
 * Testclass for DateUtil.java.
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
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package de.ma.it.common.util;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * DateUtilTest
 * 
 * @author Martin Absmeier
 */
public class DateUtilTest {

	@Test
	public void testCalculateEasterDay() {
		Date expected = DateUtil.createDate(2009, 4, 12);
		Date actual = DateUtil.calculateEasterDay(2009);
		assertTrue(DateUtil.isEqual(expected, actual));
	
		expected = DateUtil.createDate(2010, 4, 4);
		actual = DateUtil.calculateEasterDay(2010);
		assertTrue(DateUtil.isEqual(expected, actual));
		
		expected = DateUtil.createDate(2011, 4, 24);
		actual = DateUtil.calculateEasterDay(2011);
		assertTrue(DateUtil.isEqual(expected, actual));
	}

	@Test
	public void testConvertDate() {
		try {
			DateUtil.convertDate(null);
		} catch (NullPointerException ex) {
			assertTrue("NullPointerException thrown!", true);
		}
		
		long now = System.currentTimeMillis();
		assertEquals(new Date(now), DateUtil.convertDate(new java.sql.Date(now)));
	}
	
	@Test
	public void testCreateCalendar() {
		try {
			DateUtil.createCalendar(null);
		} catch (NullPointerException ex) {
			assertTrue("NullPointerException thrown!", true);
		}
		
		Date actual = new Date(System.currentTimeMillis());
		Calendar expected = DateUtil.createCalendar(actual);
		assertEquals(expected.getTimeInMillis(), actual.getTime());
	}

	@Test
	public void testCreateDateNoTime() {
		try {
			DateUtil.createDate(0, 12, 31);
		} catch (IllegalArgumentException ex) {
			assertTrue("IllegalArgumentException thrown!", true);
		}
		try {
			DateUtil.createDate(2012, 0, 31);
		} catch (IllegalArgumentException ex) {
			assertTrue("IllegalArgumentException thrown!", true);
		}
		try {
			DateUtil.createDate(2012, 12, 0);
		} catch (IllegalArgumentException ex) {
			assertTrue("IllegalArgumentException thrown!", true);
		}
		
		Date actual = DateUtil.createDate(2012, 8, 1);
		int[] dIng = DateUtil.getDateIngredients(actual);
		int actDate = dIng[0];
		int actMonth = dIng[1] + 1;
		int actYear = dIng[2];

		assertEquals(1, actDate);
		assertEquals(8, actMonth);
		assertEquals(2012, actYear);
	}

	@Test
	public void testCreateDateTime() {
		try {
			DateUtil.createDate(-1, 12, 31);
		} catch (IllegalArgumentException ex) {
			assertTrue("IllegalArgumentException thrown!", true);
		}
		try {
			DateUtil.createDate(2012, -1, 31);
		} catch (IllegalArgumentException ex) {
			assertTrue("IllegalArgumentException thrown!", true);
		}
		try {
			DateUtil.createDate(2012, 12, -1);
		} catch (IllegalArgumentException ex) {
			assertTrue("IllegalArgumentException thrown!", true);
		}

		long expected = DateUtil.createDate(2012, 4, 26, 16, 45, 20).getTime();
		Calendar cal = Calendar.getInstance();
		cal.set(2012, 3, 26, 16, 45, 20);
		long actual = cal.getTimeInMillis();
		assertEquals(expected, actual);
	}

	// @Test
	public void testDeleteTimeSlice() {
		assertTrue(true);
	}

	// @Test
	public void testGetDateIngredients() {
		assertTrue(true);
	}

	// @Test
	public void testIsAfter() {
		assertTrue(true);
	}

	@Test
	public void testIsAfternoon() {
		Date expected = DateUtil.createDate(2012, 4, 26, 10, 0, 0);
		assertFalse(DateUtil.isAfternoon(expected));
		
		expected = DateUtil.createDate(2012, 4, 26, 13, 0, 0);
		assertTrue(DateUtil.isAfternoon(expected));
	}

	// @Test
	public void testIsBefore() {
		assertTrue(true);
	}

	@Test
	public void testIsForenoon() {
		assertTrue(DateUtil.isForenoon(DateUtil.createDate(2012, 4, 26, 10, 0, 0)));
		assertFalse(DateUtil.isForenoon(DateUtil.createDate(2012, 4, 26, 13, 0, 0)));
	}

	// @Test
	public void testIsHoliday() {
		assertTrue(true);
	}

	@Test
	public void testIsLeapYear() {
		assertTrue(DateUtil.isLeapYear(1996));
		assertTrue(DateUtil.isLeapYear(2000));
		assertTrue(DateUtil.isLeapYear(2004));
		assertTrue(DateUtil.isLeapYear(2008));
		assertTrue(DateUtil.isLeapYear(2012));
		assertTrue(DateUtil.isLeapYear(2016));
		assertTrue(DateUtil.isLeapYear(2020));
		assertTrue(DateUtil.isLeapYear(2024));
		assertTrue(DateUtil.isLeapYear(2032));
	}

	// @Test
	public void testParse() {
		assertTrue(true);
	}

}
