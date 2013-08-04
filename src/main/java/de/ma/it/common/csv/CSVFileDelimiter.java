/*
 * Delimiter of CSV file cells
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
 * Delimiter of CSV file cells
 * 
 * @author Martin Absmeier
 */
public enum CSVFileDelimiter implements Serializable {

	COMMA(","),
	SEMIKOLON(";"),
	TABULATOR("\t"),
	COLON(":"),
	SPACE(" ");

	private String value;

	private CSVFileDelimiter(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}

}
