/*
 * Utility class for a easy way to handle regular expressions.
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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * RegexUtil
 *
 * @author Martin Absmeier
 */
public class RegexUtil {

	/** Regex to check SWIFT / BIC codes. */
	public static final Pattern SWIFT_BIC = Pattern.compile("^([a-zA-Z]){4}([a-zA-Z]){2}([0-9a-zA-Z]){2}([0-9a-zA-Z]{3})?$");
	
	/** Regex to check E-Mail adresses. */
	public static final Pattern EMAIL = Pattern.compile("^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

	/** Regex to check alphanumeric */
	public static final Pattern ALPHANUMERIC = Pattern.compile("^[a-zA-Z0-9]*$");

	/** Regex to check numeric */
	public static final Pattern NUMERIC = Pattern.compile("^[0-9]*$");
	
	/**
	 * Matches the given input against the given pattern. 
	 * 
	 * @param input
	 *            the given input
	 * @param pattern
	 *            the given pattern
	 * @return <code>true</code> if, and only if, the entire input sequence matches the pattern
	 */
	public static boolean matches(String input, Pattern pattern) {
		Matcher matcher = pattern.matcher(input);
		return matcher.matches();
	}
	
	/* --------------------------------------------------------------------- */

	/** Standard Constructor */
	private RegexUtil() {
		super();
	}

}
