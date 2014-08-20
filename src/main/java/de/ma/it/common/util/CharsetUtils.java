/*
 * Utility class to simplify the use of charsets.
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

import java.nio.charset.Charset;

/**
 * Utility class to simplify the use of charsets.
 * 
 * @author Martin Absmeier
 */
public class CharsetUtils {

	/**
	 * Enumeration of the charsets included in standard jvm implementation.
	 * 
	 * @author Martin Absmeier
	 */
	public enum StandardCharsets {

		/** Seven-bit ASCII, a.k.a. ISO646-US, a.k.a the basic latin block of the unicode character set. */
		US_ASCII("US-ASCII"),

		/** ISO Latin Alphabet Ne. 1, a.k.a ISO-LATIN-1 */
		ISO_8859_1("ISO-8859-1"),

		/** Eight-bit UCS Transformation Format */
		UTF_8("UTF-8"),

		/** Sixteen-bit UCS Transformation Format, big-endian byte order */
		UTF_16BE("UTF-16BE"),

		/** Sixteen-bit UCS Transformation Format, little-endian byte order */
		UTF_16LE("UTF-16LE"),

		/** Sixteen-bit UCS Transformation Format, byte order identified by an byte-order mark */
		UTF_16("UTF-16");

		private final String charsetName;

		private StandardCharsets(String charsetName) {
			this.charsetName = charsetName;
		}

		/**
		 * Returns the name of the charset.
		 * 
		 * @return The name of the charset.
		 */
		public String getCharsetName() {
			return this.charsetName;
		}
	}

	/**
	 * 
	 * @param standardCharset
	 * @return
	 */
	public static Charset getCharset(StandardCharsets standardCharset) {
		return getCharset(standardCharset.getCharsetName());
	}

	/**
	 * 
	 * @param charsetName
	 * @return
	 */
	public static Charset getCharset(String charsetName) {
		return Charset.forName(charsetName);
	}

	/**
	 * 
	 * @return
	 */
	public static Charset getISO_8859_1() {
		return getCharset(StandardCharsets.ISO_8859_1);
	}

	/**
	 * 
	 * @return
	 */
	public static Charset getUS_ASCII() {
		return getCharset(StandardCharsets.US_ASCII);
	}

	/**
	 * 
	 * @return
	 */
	public static Charset getUTF_16() {
		return getCharset(StandardCharsets.UTF_16);
	}

	/**
	 * 
	 * @return
	 */
	public static Charset getUTF_16BE() {
		return getCharset(StandardCharsets.UTF_16BE);
	}

	/**
	 * 
	 * @return
	 */
	public static Charset getUTF_16LE() {
		return getCharset(StandardCharsets.UTF_16LE);
	}

	/**
	 * 
	 * @return
	 */
	public static Charset getUTF_8() {
		return getCharset(StandardCharsets.UTF_8);
	}

}
