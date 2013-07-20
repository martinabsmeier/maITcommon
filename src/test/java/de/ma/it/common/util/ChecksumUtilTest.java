/*
 * TODO Insert short description
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

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * TODO Insert description !
 *
 * @author Martin Absmeier
 */
public class ChecksumUtilTest {

	@Before
	public void setUp() {
		
	}

	@After
	public void tearDown() {
		
	}

	@Test
	public void testCalculateISBN() {
		String isbn1 = "ISBN 3-499-13599";
		String checkDigit = ChecksumUtil.calculateISBN(isbn1);
		//Prüfziffer: X
		assertEquals("X", checkDigit);

		String isbn2 = "Isbn 3-446-19313";
		checkDigit = ChecksumUtil.calculateISBN(isbn2);
		// Prüfziffer: 8
		assertEquals("8", checkDigit);

		String isbn3 = "0-7475-5100";
		checkDigit = ChecksumUtil.calculateISBN(isbn3);
		//Prüfziffer: 6
		assertEquals("6", checkDigit);

		String isbn4 = "1-57231-422";
		checkDigit = ChecksumUtil.calculateISBN(isbn4);
		//Prüfziffer: 2
		assertEquals("2", checkDigit);
	}
	
}
