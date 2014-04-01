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
	public static final Pattern SWIFT_BIC = Pattern
			.compile("^([a-zA-Z]){4}([a-zA-Z]){2}([0-9a-zA-Z]){2}([0-9a-zA-Z]{3})?$");

	/** Regex to check E-Mail adresses. */
	public static final Pattern EMAIL = Pattern
			.compile("^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

	/** Regex to check alphanumeric */
	public static final Pattern ALPHANUMERIC = Pattern.compile("^[a-zA-Z0-9]*$");

	/** Regex to check numeric */
	public static final Pattern NUMERIC = Pattern.compile("^[0-9]*$");

	/**
	 * IP Address Regular Expression Pattern
	 * Whole combination means, digit from 0 to 255 and follow by a dot “.”, repeat 4 time and
	 * ending with no dot “.” Valid IP address format is “0-255.0-255.0-255.0-255″.
	 */
	public static final Pattern IP_ADRESS = Pattern.compile("^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])$");

	/**
	 * Time in 12-Hour Format Regular Expression Pattern The 12-hour clock format is start from
	 * 0-12, then a semi colon (:) and follow by 00-59 , and end with am or pm.
	 */
	public static final Pattern TIME_12H = Pattern.compile("(1[012]|[1-9]):[0-5][0-9](\\s)?(?i)(am|pm)");

	/**
	 * Time in 24-Hour Format Regular Expression Pattern The 24-hour clock format is start from 0-23
	 * or 00-23 then a semi colon (:) and follow by 00-59.
	 */
	public static final Pattern TIME_24H = Pattern.compile("([01]?[0-9]|2[0-3]):[0-5][0-9]");

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
