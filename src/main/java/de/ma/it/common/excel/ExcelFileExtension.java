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
package de.ma.it.common.excel;

/**
 * TODO Insert short description
 * 
 * @author Martin Absmeier
 */
public enum ExcelFileExtension {

	/** Excel spreadsheet until 2007 */
	XLS(".xls"),

	/** Excel spreadsheet from 2007 and higher */
	XLSX(".xlsx"),

	/** Excel spreadsheet with macros */
	XLSM(".xlsm"),

	/** Excel spreadsheet binary */
	XLSB(".xlsb"),

	/** Excel spreadsheet template */
	XLTX(".xltx");

	private String fileExtension;

	private ExcelFileExtension(String fileExtension) {
		this.fileExtension = fileExtension;
	}

	public String getExtension() {
		return this.fileExtension;
	}

}
