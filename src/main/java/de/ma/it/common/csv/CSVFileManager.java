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

import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * TODO Insert short description
 * 
 * @author Martin Absmeier
 */
public class CSVFileManager implements Serializable {

	private static final long serialVersionUID = -2120653294656008151L;

	private Charset encoding;

	private CSVFile csvFile;

	private CSVFileDelimiter delimiter;

	/**
	 * Standard Constructor, uses UTF-8 for encoding.
	 * 
	 * @param delimiter
	 */
	public CSVFileManager(CSVFileDelimiter delimiter) {
		this(delimiter, StandardCharsets.UTF_8);
	}

	/**
	 * Standard Constructor
	 * 
	 * @param encoding
	 *            Encoding of csv file.
	 */
	public CSVFileManager(CSVFileDelimiter delimiter, Charset encoding) {
		super();
		this.delimiter = delimiter;
		this.encoding = encoding;
	}

	/**
	 * readCSVFile
	 * 
	 * @param fileName
	 * @return
	 * @throws IOException
	 */
	public CSVFile readCSVFile(String fileName, boolean withHeader) throws IOException {
		Path path = Paths.get(fileName);
		csvFile = new CSVFile(path.getFileName().toString(), delimiter);

		Integer rowNr = Integer.valueOf(1);
		
		Scanner scanner = new Scanner(path, encoding.name());
		if (withHeader && scanner.hasNextLine()) {
			CSVFileRow readHeader = readHeader(rowNr, scanner.nextLine());
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

	private CSVFileRow readHeader(Integer rowNr, String headerLine) {
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

}
