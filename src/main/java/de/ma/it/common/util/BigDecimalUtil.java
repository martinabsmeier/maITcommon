/*
 * Utility class to simplify the use of BigDecimals
 * Copyright (C) 2012 Martin Absmeier, IT Consulting Services
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package de.ma.it.common.util;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Locale;

/**
 * Utility class to simplify the use of BigDecimals
 * 
 * @author Martin Absmeier
 */
public class BigDecimalUtil {

	/**
	 * Rounds the given <code>value</code>.
	 * 
	 * @param value
	 *            The value to be rounded.
	 * @param decimalPlaces
	 *            The number of decimal places.
	 * @param locale
	 *            The locale.
	 * @param roundCommercial
	 *            true if to rounded commercial, false otherwise
	 * @return The formattet number as String
	 */
	public static String formatNubmer(BigDecimal value, int decimalPlaces, Locale locale, boolean roundCommercial) {
		DecimalFormat df = getDecimalFormat(decimalPlaces, locale);
		if (roundCommercial) {
			return df.format(roundCommercial(value, decimalPlaces));
		}
		return df.format(value);
	}

	/**
	 * Checks if <code>value1</code> is equal to <code>value2</code>.
	 * 
	 * @param value1
	 *            The first value to be checked.
	 * @param value2
	 *            The second value to be checked.
	 * @return true if <code>value1</code> equals <code>value2</code>, false otherwise
	 */
	public static boolean isEqual(BigDecimal value1, BigDecimal value2) {
		return value1.compareTo(value2) == 0;
	}

	/**
	 * Checks if <code>value1</code> is greater then <code>value2</code>.
	 * 
	 * @param value1
	 *            The first value to be checked.
	 * @param value2
	 *            The second value to be checked.
	 * @return true if <code>value1</code> is greater then <code>value2</code>, false otherwise
	 */
	public static boolean isGreaterThen(BigDecimal value1, BigDecimal value2) {
		int compareTo = value1.compareTo(value2);
		return compareTo > 0;
	}

	/**
	 * Checks if <code>value1</code> is greater then or equal <code>value2</code>.
	 * 
	 * @param value1
	 *            The first value to be checked.
	 * @param value2
	 *            The second value to be checked.
	 * @return true if <code>value1</code> is greater then or equal <code>value2</code>, false otherwise
	 */
	public static boolean isGreaterThenOrEqual(BigDecimal value1, BigDecimal value2) {
		int compareTo = value1.compareTo(value2);
		return (compareTo == 0 || compareTo > 0);
	}

	/**
	 * Checks if <code>value1</code> is less then <code>value2</code>.
	 * 
	 * @param value1
	 *            The first value to be checked.
	 * @param value2
	 *            The second value to be checked.
	 * @return true if <code>value1</code> is less then <code>value2</code>, false otherwise
	 */
	public static boolean isLessThen(BigDecimal value1, BigDecimal value2) {
		int compareTo = value1.compareTo(value2);
		return compareTo < 0;
	}

	/**
	 * Checks if <code>value1</code> is less then or equal <code>value2</code>.
	 * 
	 * @param value1
	 *            The first value to be checked.
	 * @param value2
	 *            The second value to be checked.
	 * @return
	 */
	public static boolean isLessThenOrEqual(BigDecimal value1, BigDecimal value2) {
		int compareTo = value1.compareTo(value2);
		return (compareTo == 0 || compareTo < 0);
	}

	/**
	 * Checks if <code>value</code> is a prime number,
	 * 
	 * @param value
	 *            BigInteger to check
	 * @return true if value is prime false otherwise
	 */
	public static boolean isPrime(BigInteger value) {
		if (value.signum() < 0) {
			throw new IllegalArgumentException("Only positive values permitted.");
		}

		BigInteger two = new BigInteger("2");

		// If value < 2
		if (value.compareTo(two) < 0) {
			return false;
		}
		// If value == 2
		if (value.equals(two)) {
			return true;
		}
		// If value % 2 == 0
		if (value.remainder(two).equals(BigInteger.ZERO)) {
			return false;
		}

		BigDecimal sqrt = sqrt(new BigDecimal(value), 0);
		for (long i = 3; i <= sqrt.longValue(); i += 2) {
			if (value.remainder(BigInteger.valueOf(i)).equals(BigInteger.ZERO)) {
				return false;
			}
		}

		return true;
	}

	/**
	 * 
	 * @param value
	 * @param decimalPlaces
	 * @return
	 */
	public static BigDecimal roundCommercial(BigDecimal value, int decimalPlaces) {
		return value.round(getMathContext(decimalPlaces));
	}

	/**
	 * Calculates the square root of <code>value</code>.
	 * 
	 * @param value
	 *            The value to be calculated.
	 * @param decimalPlaces
	 *            The number of decimal places.
	 * @return The square root of value with <code>decimalPlaces</code>.
	 */
	public static BigDecimal sqrt(BigDecimal value, int decimalPlaces) {
		BigDecimal zero = BigDecimal.ZERO.setScale(decimalPlaces + 10);
		BigDecimal one = BigDecimal.ONE.setScale(decimalPlaces + 10);
		BigDecimal two = new BigDecimal("2").setScale(decimalPlaces + 10);
		BigDecimal maxerr = one.movePointLeft(decimalPlaces);
		BigDecimal lower = zero;
		BigDecimal upper = value.compareTo(one) <= 0 ? one : value;
		BigDecimal mid = BigDecimal.ZERO;

		while (true) {
			mid = lower.add(upper).divide(two);
			// mid = lower.add(upper).divide(two, RoundingMode.HALF_UP);
			BigDecimal sqr = mid.multiply(mid);
			BigDecimal error = value.subtract(sqr).abs();
			if (error.compareTo(maxerr) <= 0) {
				break;
			}
			if (sqr.compareTo(value) < 0) {
				lower = mid;
			} else {
				upper = mid;
			}
		}

		return mid.round(getMathContext(decimalPlaces));
	}

	/* --------------------------------------------------------------------- */

	private static DecimalFormat getDecimalFormat(int decimalPlaces, Locale locale) {
		StringBuffer sb = new StringBuffer();

		sb.append("#,###,##0.");
		for (int i = 0; i < decimalPlaces; i++) {
			sb.append('0');
		}
		DecimalFormat df = (DecimalFormat) DecimalFormat.getInstance(locale);
		df.applyPattern(sb.toString());

		return df;
	}

	private static MathContext getMathContext(int decimalPlaces) {
		return new MathContext(decimalPlaces, RoundingMode.HALF_UP);
	}

	/** Standard Constructor */
	private BigDecimalUtil() {
		super();
	}

}
