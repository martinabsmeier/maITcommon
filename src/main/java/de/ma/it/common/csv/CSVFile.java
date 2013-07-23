/*
 * TODO Insert short description
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

/**
 * CSV document, as default delimiter is <code>CSVFileDelimiter.COMMA</code>
 * 
 * @author Martin Absmeier
 */
public class CSVFile implements Serializable {
	
	/**
	 * Cell of a csv row
	 * 
	 * @author Martin Absmeier
	 */
	public class CSVFileCell implements Serializable {

		private static final long serialVersionUID = -6156910564837140075L;

		private Integer index;

		private String cellValue;

		private StringBuilder sb;
		
		public CSVFileCell(String cellValue) {
			super();
			this.index = Integer.valueOf(0);
			this.cellValue = cellValue;
			this.sb = new StringBuilder();
		}
		
		public String getCellValue() {
			return cellValue;
		}

		protected void setIndex(Integer index) {
			this.index = index;
		}

		public Integer getIndex() {
			return this.index;
		}
		
		@Override
		public String toString() {
			this.sb.setLength(0);
			
			sb.append(getIndex()).append(": ").append(getCellValue());
			
			return this.sb.toString();
		}
	}
	
	/**
	 * 
	 * @author Martin Absmeier
	 */
	public enum CSVFileDelimiter {
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
	
	/**
	 * Row of a csv document
	 * 
	 * @author Martin Absmeier
	 */
	public class CSVFileRow implements Serializable {

		private static final long serialVersionUID = 9176513247966201544L;

		private Integer index;

		private List<CSVFileCell> cells;

		private StringBuilder sb;

		public CSVFileRow() {
			super();
			this.index = Integer.valueOf(0);
			this.cells = new ArrayList<CSVFileCell>();
			this.sb = new StringBuilder();
		}

		public void addCell(CSVFileCell aCell) {
			aCell.setIndex(cells.size() + 1);
			this.cells.add(aCell);
		}

		public List<CSVFileCell> getCells() {
			return this.cells;
		}

		public Integer getIndex() {
			return this.index;
		}

		protected void setIndex(Integer index) {
			this.index = index;
		}

		@Override
		public String toString() {
			this.sb.setLength(0);

			sb.append("row: ").append(getIndex());
			for (CSVFileCell aCell : getCells()) {
				sb.append(aCell.toString());
			}
			sb.append("\n");

			return this.sb.toString();
		}
	}
	
	private static final long serialVersionUID = -801920797804257666L;

	private List<CSVFileRow> rows;

	private String documentName;
	
	private StringBuilder sb;

	/** Constructor */
	public CSVFile(String documentName) {
		super();
		this.documentName = documentName;
		this.rows = new ArrayList<CSVFileRow>();
		this.sb = new StringBuilder();
	}

	public void addRow(CSVFileRow aRow) {
		this.rows.add(aRow);
	}

	public String getDocumentName() {
		return this.documentName;
	}
	
	public List<CSVFileRow> getRows() {
		return this.rows;
	}
	
	@Override
	public String toString() {
		this.sb.setLength(0);

		sb.append("CSVFile: ").append(getDocumentName()).append("\n");
		for (CSVFileRow aRow : getRows()) {
			sb.append(aRow.toString()).append("\n");
		}
		
		return this.sb.toString();
	}

}
