/*
 * Delimiters of a csv file.
 * Copyright (C) 2013 Martin Absmeier, IT Consulting Services
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
package de.ma.it.common.csv;

import java.io.Serializable;

/**
 * Delimiters of a csv file.
 * 
 * @author Martin Absmeier
 */
public enum CSVFileDelimiter implements Serializable {

	/** Comma delimiter <code>,</code> */
	COMMA(","),
	/** Semikolon delimiter <code>;</code> */
	SEMIKOLON(";"),
	/** Tabulator delimiter <code>/t</code> */
	TABULATOR("\t"),
	/** Colon delimiter <code>:</code> */
	COLON(":"),
	/** Space delimiter <code> </code> */
	SPACE(" ");

	private String value;

	private CSVFileDelimiter(String value) {
		this.value = value;
	}

	/**
	 * Return the delimiter as string.
	 * 
	 * @return The delimiter as string.
	 */
	public String getValue() {
		return this.value;
	}

}
