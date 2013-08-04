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

import org.junit.After;
import org.junit.Before;

import de.ma.it.common.util.SystemUtils;

import junit.framework.TestCase;

/**
 * TODO Insert description !
 *
 * @author Martin Absmeier
 */
public class CSVFileManagerTest extends TestCase {
	
	private String fileName;
	
	private CSVFileManager cfManager;
	
	@Before
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		String filePath =	SystemUtils.getUserDir() + SystemUtils.getFileSeperator() + "src" + SystemUtils.getFileSeperator() + 
							"test" + SystemUtils.getFileSeperator() + "resources" + SystemUtils.getFileSeperator();
		this.fileName = filePath + "postcodes-germany.csv";
	}

	@After
	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		this.fileName = null;
		this.cfManager = null;
	}	
	
	public void testReadCSVFile() {
		try {
			cfManager = new CSVFileManager(CSVFileDelimiter.TABULATOR);
			CSVFile csvFile = cfManager.readCSVFile(fileName, true);
			System.out.println(csvFile.getCSVFile());
		} catch (IOException ex) {
			ex.printStackTrace(System.err);
		}
	}
	
}
