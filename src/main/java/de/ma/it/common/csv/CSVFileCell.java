/*
 * CSV file data field.
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
 * CSV file data field.
 * 
 * @author Martin Absmeier
 */
public class CSVFileCell implements Serializable {

	private static final long serialVersionUID = -6156910564837140075L;

	private Integer cellNumber;

	private String cellValue;

	private StringBuilder sb;

	/**
	 * Standard Constructor
	 *
	 * @param cellValue
	 * @param delimiter
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
	 * Use the standard delimiter <code>CSVFileDelimiter.SEMIKOLON</code>
	 */
	@Override
	public String toString() {
		sb.setLength(0);
		sb.append(getCellValue()).append(CSVFileDelimiter.SEMIKOLON.getValue());
		return sb.toString();
	}
	
}
