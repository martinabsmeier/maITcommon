/*
 * A row of a csv document.
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
 * A row of a csv document.
 * 
 * @author Martin Absmeier
 */
public class CSVFileRow implements Serializable {

	private static final long serialVersionUID = 9176513247966201544L;

	private Integer rowNumber;

	private List<CSVFileCell> cells;
	
	private StringBuilder sb;

	/**
	 * Standard Constructor
	 *
	 * @param cellValues
	 */
	public CSVFileRow(Integer rowNumber) {
		super();
		this.rowNumber = rowNumber;
		this.cells = new ArrayList<CSVFileCell>();
		this.sb = new StringBuilder();
	}

	public void addCell(CSVFileCell aCell) {
		aCell.setCellNumber(cells.size() + 1);
		this.cells.add(aCell);
	}

	public List<CSVFileCell> getCells() {
		return this.cells;
	}

	public int getNumberOfCells() {
		return this.cells.size();
	}
	
	public Integer getRowNumber() {
		return this.rowNumber;
	}

	protected void setRowNumber(Integer rowNumber) {
		this.rowNumber = rowNumber;
	}

	public String getRowValue() {
		sb.setLength(0);
		for (CSVFileCell aCell : cells) {
			sb.append(aCell.getCellValue()).append(" ");			
		}
		return sb.toString();
	}
	
	public String getRow(CSVFileDelimiter delimiter) {
		sb.setLength(0);
		sb.append(getRowNumber()).append(": ");
		for (CSVFileCell aCell : cells) {
			sb.append(aCell.getCell(delimiter));			
		}
		// remove last delimiter
		sb.replace(sb.length() - 1, sb.length(), "").append(SystemUtils.getLineSeperator());
		return sb.toString();
	}
	
	
	/**
	 * Use the standard delimiter <code>CSVFileDelimiter.SEMIKOLON</code>
	 */
	@Override
	public String toString() {
		sb.setLength(0);
		for (CSVFileCell aCell : cells) {
			sb.append(aCell.toString());
		}
		// remove last delimiter
		sb.replace(sb.length() - 1, sb.length(), "").append(SystemUtils.getLineSeperator());
		return sb.toString();
	}

}
