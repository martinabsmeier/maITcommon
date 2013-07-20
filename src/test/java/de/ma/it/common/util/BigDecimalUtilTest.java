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

import java.math.BigDecimal;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * TODO Insert description !
 *
 * @author Martin Absmeier
 */
public class BigDecimalUtilTest {

	@Before
	public void setUp() {
	}

	@After
	public void tearDown() {
	}
	
	@Test
	public void testIsEqual() {
		assertTrue(BigDecimalUtil.isEqual(BigDecimal.ZERO, BigDecimal.ZERO));
		assertTrue(BigDecimalUtil.isEqual(BigDecimal.TEN, BigDecimal.TEN));
		assertTrue(BigDecimalUtil.isEqual(new BigDecimal("2.056900123"), new BigDecimal("2.056900123")));
		
		assertFalse(BigDecimalUtil.isEqual(BigDecimal.ZERO, BigDecimal.TEN));
		assertFalse(BigDecimalUtil.isEqual(BigDecimal.ZERO, BigDecimal.ONE));
		assertFalse(BigDecimalUtil.isEqual(new BigDecimal("2.07839487"), new BigDecimal("2.17839487")));
	}
	
	@Test
	public void testIsGreaterThen() {
		assertTrue(BigDecimalUtil.isGreaterThen(BigDecimal.ONE, BigDecimal.ZERO));
		assertTrue(BigDecimalUtil.isGreaterThen(BigDecimal.TEN, BigDecimal.ONE));
		assertTrue(BigDecimalUtil.isGreaterThen(new BigDecimal("5.6874637"), new BigDecimal("4.5968745")));
		
		assertFalse(BigDecimalUtil.isGreaterThen(BigDecimal.ONE, BigDecimal.TEN));
		assertFalse(BigDecimalUtil.isGreaterThen(BigDecimal.ZERO, BigDecimal.ONE));
		assertFalse(BigDecimalUtil.isGreaterThen(new BigDecimal("586.059485"), new BigDecimal("74857.4554456")));
	}
	
	@Test
	public void testIsGreaterThenOrEqual() {
		//fail("Implement !");
	}
	
	@Test
	public void testIsLessThen() {
		//fail("Implement !");
	}
	
	@Test
	public void testIsLessThenOrEqual() {
		//fail("Implement !");
	}

}
