/*
 * Simplifying the access to csv documents.
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

import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.StringTokenizer;

import de.ma.it.common.util.CharsetUtils;

/**
 * Simplifying the access to csv documents.
 * 
 * @author Martin Absmeier
 */
public class CSVFileManager implements Serializable {

	private static final long serialVersionUID = -2120653294656008151L;

	/** The csv file to be managed */
	private CSVFile csvFile;

	/** Creates a new <code>CSVFileManager</code> instance. */
	public CSVFileManager() {
		super();
	}

	/**
	 * Read a csv file from file system with given <code>fileName</code> and <code>delimiter</code>.
	 * 
	 * @param fileName
	 *            The name of the csv file with path.
	 * @param delimiter
	 *            The delimiter of the csv file, if no delimiter is specified semikolon <code>;</code> is uesd.
	 * @param withHeader
	 *            true if csv file has a header, false otherwise
	 * @param encoding
	 *            The encoding of the csv file, if no encoding is specified <code>UTF-8</code> is used.
	 * @return The read csv file.
	 * @throws IOException
	 *             if the csv file could not be read.
	 */
	public CSVFile readDocument(String fileName, CSVFileDelimiter delimiter, boolean withHeader, Charset encoding) throws IOException {
		Path path = Paths.get(fileName);
		csvFile = new CSVFile(path.getFileName().toString(), delimiter);

		Integer rowNr = Integer.valueOf(1);
		if (delimiter == null) {
			delimiter = CSVFileDelimiter.SEMIKOLON;
		}
		if (encoding == null) {
			encoding = CharsetUtils.getUTF_8();
		}
		
		Scanner scanner = new Scanner(path, encoding.name());
		if (withHeader && scanner.hasNextLine()) {
			CSVFileRow readHeader = readHeader(rowNr, scanner.nextLine(), delimiter);
			csvFile.addHeaderRow(readHeader);
		}

		rowNr++;

		while (scanner.hasNextLine()) {
			CSVFileRow aRow = new CSVFileRow(rowNr);
			StringTokenizer tk = new StringTokenizer(scanner.nextLine(), delimiter.getValue());
			Integer cellNr = Integer.valueOf(1);
			while (tk.hasMoreTokens()) {
				CSVFileCell aCell = new CSVFileCell(cellNr, tk.nextToken());
				aRow.addCell(aCell);
				cellNr++;
			}
			csvFile.addRow(aRow);
			rowNr++;
		}
		scanner.close();

		return csvFile;
	}

	private CSVFileRow readHeader(Integer rowNr, String headerLine, CSVFileDelimiter delimiter) {
		CSVFileRow headerRow = new CSVFileRow(rowNr);
		Integer cellNr = Integer.valueOf(1);
		StringTokenizer tk = new StringTokenizer(headerLine, delimiter.getValue());
		while (tk.hasMoreTokens()) {
			CSVFileCell aCell = new CSVFileCell(cellNr, tk.nextToken());
			headerRow.addCell(aCell);
			cellNr++;
		}
		return headerRow;
	}
	
	/**
	 * 
	 * @param csvFile
	 */
	public void writeDocument(CSVFile csvFile) {
		
	}

}
