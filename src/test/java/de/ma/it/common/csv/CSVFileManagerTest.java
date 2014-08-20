/*
 * Test the 
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

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import de.ma.it.common.util.SystemUtils;

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
	public void setUp() throws Exception {
		StringBuilder sb = new StringBuilder(SystemUtils.getUserDir());
		sb.append(SystemUtils.getFileSeperator()).append("src");
		sb.append(SystemUtils.getFileSeperator()).append("test");
		sb.append(SystemUtils.getFileSeperator()).append("resources");
		sb.append(SystemUtils.getFileSeperator());
		this.fileName = sb.toString() + "postcodes-germany.csv";
	}

	@After
    @Override
	public void tearDown() throws Exception {
		this.fileName = null;
		this.cfManager = null;
	}	

	@Test
	public void testReadCSVFile() {
		try {
			cfManager = new CSVFileManager();
			CSVFile csvFile = cfManager.readDocument(fileName, CSVFileDelimiter.TABULATOR, true, null);
			System.out.println(csvFile.getCSVFile());
		} catch (IOException ex) {
			ex.printStackTrace(System.err);
		}
	}
	
}
