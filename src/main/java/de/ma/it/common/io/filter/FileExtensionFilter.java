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
package de.ma.it.common.io.filter;

import java.io.File;

import javax.swing.filechooser.FileFilter;

/**
 * TODO Insert description !
 * 
 * @author Martin Absmeier
 */
public class FileExtensionFilter extends FileFilter {

	private String[] permittedExtension;

	/** Standard Constructor */
	public FileExtensionFilter(String[] permittedExtension) {
		super();
		this.permittedExtension = permittedExtension;
	}

	@Override
	public boolean accept(File file) {
		String fileName = file.getName().toLowerCase();
		return file.isDirectory() || checkFileName(fileName);
	}

	@Override
	public String getDescription() {
		return "no description available";
	}

	/* ----------------------------------------------------------------- */

	private boolean checkFileName(String fileName) {
		for (int i = 0; i < permittedExtension.length; i++) {
			String ext = permittedExtension[i];
			if (fileName.endsWith(ext)) {
				return true;
			}
		}

		return false;
	}
}
