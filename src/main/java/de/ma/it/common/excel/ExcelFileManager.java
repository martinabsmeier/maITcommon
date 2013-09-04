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

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.FormulaEvaluator;

/**
 * Simplifying the access to excel files.
 * 
 * @author Martin Absmeier
 */
public class ExcelFileManager {

	/** Excel formula evaluator */
	private FormulaEvaluator evaluator;

	/** Excel workbook */
	private HSSFWorkbook workBook;

	/** 
	 * Creates a new instance of the class<br>
	 * 
	 * @param excelFile
	 *            The excel file handle
	 */
	public ExcelFileManager(File excelFile) throws IOException {
		super();
		InputStream excelInputStream = new FileInputStream(excelFile);
		init(excelInputStream);
	}

	/** 
	 * Creates a new instance of the class<br>
	 * 
	 * @param exexcelInputStream
	 *            The excel input stream
	 */
	public ExcelFileManager(InputStream excelInputStream) throws IOException {
		super();
		init(excelInputStream);
	}

	/**
	 * 
	 * @param row
	 * @param cellIdx
	 * @return
	 * @throws IllegalArgumentException
	 */
	public HSSFCell getCell(HSSFRow row, int cellIdx) throws IllegalArgumentException {
		HSSFCell cell = null;
		try {
			cell = row.getCell(cellIdx);
		} catch (NullPointerException ex) {
			// Occurs if cell isn't present, is deliberately swallowed -> method returns null
		}

		if (cell.getCellType() == HSSFCell.CELL_TYPE_ERROR) {
			throw new IllegalArgumentException("Value not valid because cell has an error!");
		}
		
		return cell;
	}

	/**
	 * 
	 * @param sheet
	 * @param rowIdx
	 * @return
	 */
	public HSSFRow getRow(HSSFSheet sheet, int rowIdx) {
		HSSFRow row = null;
		try {
			row = sheet.getRow(rowIdx);
		} catch (NullPointerException ex) {
			// Occurs if row isn't present, is deliberately swallowed -> method returns null
		}

		return row;
	}

	/**
	 * 
	 * @param sheetIdx
	 * @return
	 */
	public HSSFSheet getSheet(int sheetIdx) {
		HSSFSheet sheet = null;
		try {
			sheet = this.workBook.getSheetAt(sheetIdx);
		} catch (NullPointerException ex) {
			// Occurs if sheet isn't present, is deliberately swallowed -> method returns null
		}

		return sheet;
	}

	/**
	 * 
	 * @return
	 */
	public HSSFWorkbook getWorkBoob() {
		return this.workBook;
	}

	private void init(InputStream excelInputStream) throws IOException {
		this.workBook = new HSSFWorkbook(excelInputStream);
		this.evaluator = this.workBook.getCreationHelper().createFormulaEvaluator();
	}

	/**
	 * 
	 * @param sheetIdx
	 * @param rowIdx
	 * @param cellIdx
	 * @return
	 */
	public Boolean readCellAsBoolean(int sheetIdx, int rowIdx, int cellIdx) {
		HSSFSheet sheet = getSheet(sheetIdx);
		if (sheet == null) {
			return null;
		}
		HSSFRow row = getRow(sheet, rowIdx);
		if (row == null) {
			return null;
		}

		return readCellAsBoolean(row, cellIdx);
	}

	/**
	 * 
	 * @param row
	 * @param cellIdx
	 * @return
	 * @throws IllegalArgumentException
	 */
	public Boolean readCellAsBoolean(HSSFRow row, int cellIdx) throws IllegalArgumentException {
		HSSFCell cell = getCell(row, cellIdx);
		if (cell == null) {
			return null;
		}

		int cellType = cell.getCellType();
		// First evaluate formula if present
		if (cellType == HSSFCell.CELL_TYPE_FORMULA) {
			cellType = evaluator.evaluateFormulaCell(cell);
		}

		Boolean result;
		switch (cellType) {
		case HSSFCell.CELL_TYPE_BOOLEAN:
			result = cell.getBooleanCellValue();
			break;
		case HSSFCell.CELL_TYPE_NUMERIC:
			result = cell.getNumericCellValue() == 1;
			break;
		case HSSFCell.CELL_TYPE_STRING:
			String stringCellValue = cell.getStringCellValue();
			result = 	"1".equalsIgnoreCase(stringCellValue) || 
						"true".equalsIgnoreCase(stringCellValue) ||
						"yes".equalsIgnoreCase(stringCellValue);
			break;
		default:
			result = null;
			break;
		}

		return result;
	}

	/**
	 * 
	 * @param sheetIdx
	 * @param rowIdx
	 * @param cellIdx
	 * @return
	 */
	public Double readCellAsDouble(int sheetIdx, int rowIdx, int cellIdx) {
		HSSFSheet sheet = getSheet(sheetIdx);
		if (sheet == null) {
			return null;
		}
		HSSFRow row = getRow(sheet, rowIdx);
		if (row == null) {
			return null;
		}

		return readCellAsDouble(row, cellIdx);
	}

	/**
	 * 
	 * @param row
	 * @param cellIdx
	 * @return
	 * @throws IllegalArgumentException
	 */
	public Double readCellAsDouble(HSSFRow row, int cellIdx) throws IllegalArgumentException {
		HSSFCell cell = getCell(row, cellIdx);
		if (cell == null) {
			return null;
		}

		int cellType = cell.getCellType();
		// First evaluate formula if present
		if (cellType == HSSFCell.CELL_TYPE_FORMULA) {
			cellType = evaluator.evaluateFormulaCell(cell);
		}

		Double result;
		switch (cellType) {
		case HSSFCell.CELL_TYPE_NUMERIC:
			double numericCellValue = cell.getNumericCellValue();
			result = Double.valueOf(numericCellValue);
			break;
		case HSSFCell.CELL_TYPE_STRING:
			String stringCellValue = cell.getStringCellValue();
			if (!StringUtils.isNumeric(stringCellValue)) {
				throw new IllegalArgumentException("Value " + stringCellValue + " is not numeric!");
			}
			result = Double.valueOf(stringCellValue);
			break;
		default:
			result = Double.MIN_VALUE;
			break;
		}

		return result;
	}
	
	/**
	 * 
	 * @param sheetIdx
	 * @param rowIdx
	 * @param cellIdx
	 * @return
	 */
	public Float readCellAsFloat(int sheetIdx, int rowIdx, int cellIdx) {
		HSSFSheet sheet = getSheet(sheetIdx);
		if (sheet == null) {
			return null;
		}
		HSSFRow row = getRow(sheet, rowIdx);
		if (row == null) {
			return null;
		}

		return readCellAsFloat(row, cellIdx);
	}

	/**
	 * 
	 * @param row
	 * @param cellIdx
	 * @return
	 * @throws IllegalArgumentException
	 */
	public Float readCellAsFloat(HSSFRow row, int cellIdx) throws IllegalArgumentException {
		HSSFCell cell = getCell(row, cellIdx);
		if (cell == null) {
			return null;
		}

		int cellType = cell.getCellType();
		// First evaluate formula if present
		if (cellType == HSSFCell.CELL_TYPE_FORMULA) {
			cellType = evaluator.evaluateFormulaCell(cell);
		}

		Float result;
		switch (cellType) {
		case HSSFCell.CELL_TYPE_NUMERIC:
			double numericCellValue = cell.getNumericCellValue();
			if (numericCellValue > Float.MAX_VALUE) {
				throw new IllegalArgumentException("Value " + numericCellValue + " to big for integer!");
			}
			result = Double.valueOf(numericCellValue).floatValue();
			break;
		case HSSFCell.CELL_TYPE_STRING:
			String stringCellValue = cell.getStringCellValue();
			if (!StringUtils.isNumeric(stringCellValue)) {
				throw new IllegalArgumentException("Value " + stringCellValue + " is not numeric!");
			}
			result = Double.valueOf(stringCellValue).floatValue();
			break;
		default:
			result = Float.MIN_VALUE;
			break;
		}

		return result;
	}

	/**
	 * 
	 * @param sheetIdx
	 * @param rowIdx
	 * @param cellIdx
	 * @return
	 */
	public Integer readCellAsInt(int sheetIdx, int rowIdx, int cellIdx) {
		HSSFSheet sheet = getSheet(sheetIdx);
		if (sheet == null) {
			return null;
		}
		HSSFRow row = getRow(sheet, rowIdx);
		if (row == null) {
			return null;
		}

		return readCellAsInt(row, cellIdx);
	}

	/**
	 * 
	 * @param row
	 * @param cellIdx
	 * @return
	 * @throws IllegalArgumentException
	 */
	public Integer readCellAsInt(HSSFRow row, int cellIdx) throws IllegalArgumentException {
		HSSFCell cell = getCell(row, cellIdx);
		if (cell == null) {
			return null;
		}

		int cellType = cell.getCellType();
		// First evaluate formula if present
		if (cellType == HSSFCell.CELL_TYPE_FORMULA) {
			cellType = evaluator.evaluateFormulaCell(cell);
		}

		Integer result;
		switch (cellType) {
		case HSSFCell.CELL_TYPE_NUMERIC:
			double numericCellValue = cell.getNumericCellValue();
			if (numericCellValue > Integer.MAX_VALUE) {
				throw new IllegalArgumentException("Value " + numericCellValue + " to big for integer!");
			}
			result = Double.valueOf(numericCellValue).intValue();
			break;
		case HSSFCell.CELL_TYPE_STRING:
			String stringCellValue = cell.getStringCellValue();
			if (!StringUtils.isNumeric(stringCellValue)) {
				throw new IllegalArgumentException("Value " + stringCellValue + " is not numeric!");
			}
			result = Double.valueOf(stringCellValue).intValue();
			break;
		default:
			result = Integer.MIN_VALUE;
			break;
		}

		return result;
	}

	/**
	 * 
	 * @param sheetIdx
	 * @param rowIdx
	 * @param cellIdx
	 * @return
	 */
	public Long readCellAsLong(int sheetIdx, int rowIdx, int cellIdx) {
		HSSFSheet sheet = getSheet(sheetIdx);
		if (sheet == null) {
			return null;
		}
		HSSFRow row = getRow(sheet, rowIdx);
		if (row == null) {
			return null;
		}

		return readCellAsLong(row, cellIdx);
	}

	/**
	 * 
	 * @param row
	 * @param cellIdx
	 * @return
	 * @throws IllegalArgumentException
	 */
	public Long readCellAsLong(HSSFRow row, int cellIdx) throws IllegalArgumentException {
		HSSFCell cell = getCell(row, cellIdx);
		if (cell == null) {
			return null;
		}

		int cellType = cell.getCellType();
		// First evaluate formula if present
		if (cellType == HSSFCell.CELL_TYPE_FORMULA) {
			cellType = evaluator.evaluateFormulaCell(cell);
		}

		Long result;
		switch (cellType) {
		case HSSFCell.CELL_TYPE_NUMERIC:
			double numericCellValue = cell.getNumericCellValue();
			if (numericCellValue > Long.MAX_VALUE) {
				throw new IllegalArgumentException("Value " + numericCellValue + " to big for integer!");
			}
			result = Double.valueOf(numericCellValue).longValue();
			break;
		case HSSFCell.CELL_TYPE_STRING:
			String stringCellValue = cell.getStringCellValue();
			if (!StringUtils.isNumeric(stringCellValue)) {
				throw new IllegalArgumentException("Value " + stringCellValue + " is not numeric!");
			}
			result = Double.valueOf(stringCellValue).longValue();
			break;
		default:
			result = Long.MIN_VALUE;
			break;
		}

		return result;
	}

	/**
	 * 
	 * @param sheetIdx
	 * @param rowIdx
	 * @param cellIdx
	 * @return
	 */
	public String readCellAsString(int sheetIdx, int rowIdx, int cellIdx) {
		HSSFSheet sheet = getSheet(sheetIdx);
		if (sheet == null) {
			return null;
		}
		HSSFRow row = getRow(sheet, rowIdx);
		if (row == null) {
			return null;
		}

		return readCellAsString(row, cellIdx);
	}

	/**
	 * 
	 * @param row
	 * @param cellIdx
	 * @return
	 * @throws IllegalArgumentException
	 */
	public String readCellAsString(HSSFRow row, int cellIdx) throws IllegalArgumentException {
		HSSFCell cell = getCell(row, cellIdx);
		if (cell == null) {
			return null;
		}

		int cellType = cell.getCellType();
		// First evaluate formula if present
		if (cellType == HSSFCell.CELL_TYPE_FORMULA) {
			cellType = evaluator.evaluateFormulaCell(cell);
		}

		String result;
		switch (cellType) {
		case HSSFCell.CELL_TYPE_STRING:
			result = cell.getStringCellValue();
			break;
		default:
			result = "";
			break;
		}

		return result;
	}

}
