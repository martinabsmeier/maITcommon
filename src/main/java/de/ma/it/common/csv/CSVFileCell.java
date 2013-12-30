/*
 * A cell of a csv document.
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
 * A cell of a csv document.
 * 
 * @author Martin Absmeier
 */
public class CSVFileCell implements Serializable {

	private static final long serialVersionUID = -6156910564837140075L;

	/** The number of the cell. */
	private Integer cellNumber;

	/** The value of the cell. */
	private String cellValue;

	private StringBuilder sb;

	/**
	 * Creates a new csv cell with given <code>cellNumber</code> and <code>cellValue</code>
	 * 
	 * @param cellNumber
	 *            The number of the csv cell.
	 * @param cellValue
	 *            The value of the csv cell.
	 */
	public CSVFileCell(Integer cellNumber, String cellValue) {
		super();
		this.cellNumber = cellNumber;
		this.cellValue = cellValue;
		this.sb = new StringBuilder();
	}

	public String getCell(CSVFileDelimiter delimiter) {
		sb.setLength(0);
		String cellValue = getCellValue();
		sb.append(cellValue).append(delimiter.getValue());
		return sb.toString();
	}

	public Integer getCellNumber() {
		return this.cellNumber;
	}

	public String getCellValue() {
		return this.cellValue;
	}

	public void setCellNumber(Integer cellNumber) {
		this.cellNumber = cellNumber;
	}

	/**
	 * Return the csv cell as string.
	 */
	@Override
	public String toString() {
		sb.setLength(0);
		sb.append(getCellValue());
		return sb.toString();
	}

}
