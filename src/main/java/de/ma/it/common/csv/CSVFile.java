/*
 * CSV document, as default delimiter is <code>CSVFileDelimiter.COMMA</code>
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
 * CSV document, as default delimiter is <code>CSVFileDelimiter.COMMA</code>
 * 
 * @author Martin Absmeier
 */
public class CSVFile implements Serializable {

	private static final long serialVersionUID = -801920797804257666L;

	private CSVFileRow headerRow;
	
	private List<CSVFileRow> rows;

	private String documentName;
	
	private CSVFileDelimiter delimiter;
	
	private StringBuilder sb;

	/** Constructor */
	public CSVFile(String documentName, CSVFileDelimiter delimiter) {
		super();
		this.documentName = documentName;
		this.delimiter = delimiter;
		this.rows = new ArrayList<CSVFileRow>();
		this.sb = new StringBuilder();
	}

	public void addHeaderRow(CSVFileRow headerRow) {
		this.headerRow = headerRow;
	}

	public void addRow(CSVFileRow aRow) {
		this.rows.add(aRow);
	}
	
	public String getDocumentName() {
		return this.documentName;
	}
	
	public int getNumberOfCells() {
		return this.rows.get(0).getNumberOfCells();
	}
	
	public int getNumberOfRows() {
		return this.rows.size();
	}
	
	public List<CSVFileRow> getRows() {
		return this.rows;
	}
	
	public String getCSVFile() {
		sb.setLength(0);
		sb.append("Filename: ").append(getDocumentName()).append(SystemUtils.getLineSeperator());
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
		sb.setLength(0);
		sb.append(getDocumentName()).append(SystemUtils.getLineSeperator());
		if (headerRow != null) {
			List<CSVFileCell> headerCells = headerRow.getCells();
			for (CSVFileCell aCell : headerCells) {
				sb.append(aCell.toString());
			}
			sb.replace(sb.length() - 1, sb.length(), "").append(SystemUtils.getLineSeperator());
		}
		for (CSVFileRow aRow : rows) {
			sb.append(aRow.toString());
		}
		return sb.toString();
	}
}
