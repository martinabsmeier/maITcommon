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
import java.io.FileFilter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * TODO Insert short description
 * 
 * @author Martin Absmeier
 */
public class ExcelFileFilter implements FileFilter {

	/** Regular expression to filter excel files */
	private Pattern fileNameRegEx;

	/** Constructor */
	public ExcelFileFilter() {
		super();
		this.fileNameRegEx = null;
	}

	/** Constructor */
	public ExcelFileFilter(Pattern fileNameRegEx) {
		super();
		this.fileNameRegEx = fileNameRegEx;
	}

	@Override
	public boolean accept(File aFile) {
		String fileName = aFile.getName().toLowerCase();
		if (fileNameRegEx == null) {
			if (	fileName.endsWith(ExcelFileExtension.XLS.getValue()) || 
					fileName.endsWith(ExcelFileExtension.XLSB.getValue()) || 
					fileName.endsWith(ExcelFileExtension.XLSM.getValue()) || 
					fileName.endsWith(ExcelFileExtension.XLSX.getValue()) || 
					fileName.endsWith(ExcelFileExtension.XLTX.getValue())) 
			{
				return true;
			}
		} else {
			Matcher matcher = fileNameRegEx.matcher(fileName);
			if (	matcher.matches() && 
					(	fileName.endsWith(ExcelFileExtension.XLS.getValue()) || 
						fileName.endsWith(ExcelFileExtension.XLSB.getValue()) || 
						fileName.endsWith(ExcelFileExtension.XLSM.getValue()) || 
						fileName.endsWith(ExcelFileExtension.XLSX.getValue()) || 
						fileName.endsWith(ExcelFileExtension.XLTX.getValue()))
					)
			{
				return true;
			}
		}

		return false;
	}

}