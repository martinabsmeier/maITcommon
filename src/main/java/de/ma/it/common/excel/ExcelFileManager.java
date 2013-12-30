/*
 * Simplifying the access to excel documents.
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
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 * Simplifying the access to excel documents.
 * 
 * @author Martin Absmeier
 */
public class ExcelFileManager {

	/** Creates a new <code>ExcelFileManager</code> instance. */
	public ExcelFileManager() {
		super();
	}

	/**
	 * Read the excel document from given <code>excelFile</code> file.
	 * 
	 * @param excelFile
	 *            The excel file to be read.
	 * @return The excel document.
	 * @throws IOException
	 *             If excel document could not be read.
	 */
	public ExcelFile readDocument(File excelFile) throws IOException {
		return readDocument(new FileInputStream(excelFile));
	}

	/**
	 * Read the excel document from given <code>excelInputStream</code> stream.
	 * 
	 * @param excelInputStream
	 *            The excel input stream.
	 * @return The excel document.
	 * @throws IOException
	 *             If excel document could not be read.
	 */
	public ExcelFile readDocument(InputStream excelInputStream) throws IOException {
		HSSFWorkbook workBook = new HSSFWorkbook(excelInputStream);
		return new ExcelFile(workBook);
	}

	/**
	 * Read the excel document from given <code>fileName</code> file name.
	 * 
	 * @param fileName
	 * @return The excel document.
	 * @throws IOException
	 *             If excel document could not be read.
	 */
	public ExcelFile readDocument(String fileName) throws IOException {
		return readDocument(new File(fileName));
	}

	/**
	 * Writes the excel document <code>excelFile</code> to disk.
	 * 
	 * @param excelFile
	 *            The excel document to be written.
	 * @param filePath
	 *            The document is written into it.
	 * @throws IOException
	 *             if the excel document could not be written.
	 */
	public void writeDocument(ExcelFile excelFile, File filePath) throws IOException {
		FileOutputStream fos = new FileOutputStream(filePath);
		HSSFWorkbook workBook = excelFile.getWorkBook();
		workBook.write(fos);
		fos.flush();
		fos.close();
	}

	/**
	 * Writes the excel document <code>fileName</code> to disk.
	 * 
	 * @param excelFile
	 *            The excel document to be written.
	 * @param fileName
	 *            The name of the excel document.
	 * @throws IOException
	 *             if the excel document could not be written.
	 */
	public void writeDocument(ExcelFile excelFile, String fileName) throws IOException {
		writeDocument(excelFile, new File(fileName));
	}

}
