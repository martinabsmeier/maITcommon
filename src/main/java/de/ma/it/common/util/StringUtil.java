/*
 * Utility class for a easy way to handle String
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

/**
 * StringUtil
 * 
 * @author Martin Absmeier
 */
public class StringUtil {

	/**
	 * Checks if <code>input</code> is a palindrome.
	 *
	 * @param input
	 *            The given string.
	 * @return <code>true</code> if <code>input</code> is a palindrome; <code>false</code> otherwise
	 */
	public static boolean isPalindrome(String input) {
		String a = input.toLowerCase();
		String b = new StringBuilder(a).reverse().toString();
		return a.equals(b);
	}

	/* --------------------------------------------------------------------- */

	/** Standard Constructor */
	private StringUtil() {
		super();
	}

}
