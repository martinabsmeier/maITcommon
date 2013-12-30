/*
 * A csv document.
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
import java.util.ArrayList;
import java.util.List;

import de.ma.it.common.util.SystemUtils;

/**
 * A csv document, default delimiter is <code>CSVFileDelimiter.SEMIKOLON</code>
 * 
 * @author Martin Absmeier
 */
public class CSVFile implements Serializable {

	private static final long serialVersionUID = -801920797804257666L;

	/** The header row of csv document */
	private CSVFileRow headerRow;

	/** The rows of a csv document */
	private List<CSVFileRow> rows;

	/** The name of a csv document */
	private String documentName;

	/** The delimiter of a csv document */
	private CSVFileDelimiter delimiter;

	private StringBuilder sb;

	/**
	 * Creates a new csv file with given <code>documentName</code> and <code>delimiter</code>.
	 * 
	 * @param documentName
	 *            The name of the csv document.
	 * @param delimiter
	 *            The delimiter of the csv document, if no delimiter is specified <code>CSVFileDelimiter.SEMIKOLON</code> is used.
	 * @return An instance of the class <code>CSVFile</code>.
	 */
	public CSVFile(String documentName, CSVFileDelimiter delimiter) {
		super();
		this.documentName = documentName;
		if (delimiter == null) {
			delimiter = CSVFileDelimiter.SEMIKOLON;
		}
		this.delimiter = delimiter;
		this.rows = new ArrayList<CSVFileRow>();
		this.sb = new StringBuilder();
	}

	/**
	 * Add header row to the csv file.
	 * 
	 * @param headerRow
	 *            The header row to be added.
	 */
	public void addHeaderRow(CSVFileRow headerRow) {
		this.headerRow = headerRow;
	}

	/**
	 * Add a row to the csv file.
	 * 
	 * @param aRow
	 *            The row to be added.
	 */
	public void addRow(CSVFileRow aRow) {
		this.rows.add(aRow);
	}

	/**
	 * Returns the name of the csv file.
	 * 
	 * @return The name of the csv file.
	 */
	public String getDocumentName() {
		return this.documentName;
	}

	/**
	 * Returns the number of cells.
	 * 
	 * @return The number of cells.
	 */
	public int getNumberOfCells() {
		return this.rows.get(0).getNumberOfCells();
	}

	/**
	 * Returns the number of rows.
	 * 
	 * @return The number of rows
	 */
	public int getNumberOfRows() {
		return this.rows.size();
	}

	/**
	 * Returns all rows of the csv document.
	 * 
	 * @return All rows of the csv document.
	 */
	public List<CSVFileRow> getRows() {
		return this.rows;
	}

	/**
	 * Returns the csv file as String.
	 * 
	 * @return The csv file as String.
	 */
	public String getCSVFile() {
		sb.setLength(0);
		if (headerRow != null) {
			sb.append(headerRow.getRowNumber()).append(": ");
			List<CSVFileCell> headerCells = headerRow.getCells();
			for (CSVFileCell aCell : headerCells) {
				sb.append(aCell.getCell(delimiter));
			}
			sb.replace(sb.length() - 1, sb.length(), "").append(SystemUtils.getLineSeperator());

		}
		for (CSVFileRow aRow : rows) {
			sb.append(aRow.getRow(delimiter));
		}
		return sb.toString();
	}

	@Override
	public String toString() {
		return getDocumentName() + ":" + SystemUtils.getLineSeperator() + getCSVFile();
	}

}
