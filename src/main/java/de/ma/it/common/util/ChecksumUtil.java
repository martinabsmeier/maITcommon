/*
 * Utility class to calculate different checksums
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

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Utility class to calculate several check digits.
 *
 * @author Martin Absmeier
 */
public class ChecksumUtil implements PreconditionsMessages {

	/**
	 * The check digit (tenth digit) of ISBN number is calculated as follows:<br>
	 * Multiply the first digit with one, the second with two, the third with
	 * three and so on until the ninth digit, which is multiplied by nine.<br>
	 * You add up the products and divide the sum with remainder by eleventh.
	 * The remainder is the check digit.<br>
	 * If the remainder is 10, the check digit is an "X".
	 * 
	 * @param isbnNumber
	 *            The ISBN number e.g. ISBN 3-446-19313-[?]
	 * @return
	 */
	public static String calculateISBN(String isbnNumber) {		
		isbnNumber = isbnNumber.toUpperCase();
		if (isbnNumber.startsWith("ISBN")) {
			isbnNumber = isbnNumber.substring(isbnNumber.indexOf("ISBN") + 4, isbnNumber.length());
		}
		isbnNumber = isbnNumber.trim();

		List<Integer> isbnList = new ArrayList<Integer>();
		StringTokenizer tk = new StringTokenizer(isbnNumber, "-");
		while (tk.hasMoreTokens()) {
			String token = tk.nextToken();
			if (token.length() == 1) {
				isbnList.add(Integer.valueOf(token));
			} else {
				for (int i = 0; i < token.length(); i++) {
					isbnList.add(Integer.valueOf(token.substring(i, i + 1)));
				}
			}
		}
		
		int count = 1;
		long sum = 0;
		for (Integer nr : isbnList) {
			sum = sum + nr * count;
			count++;
		}

		Long res = sum % 11L;
		if (res.equals(Long.valueOf(10L))) {
			return "X";
		}

		return res.toString();
	}

	/* --------------------------------------------------------------------- */

	/** Standard Constructor */
	private ChecksumUtil() {
		super();
	}

}
