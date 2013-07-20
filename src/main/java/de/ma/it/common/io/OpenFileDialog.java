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
package de.ma.it.common.io;

import java.io.File;

import javax.swing.JFileChooser;

import de.ma.it.common.io.filter.FileExtensionFilter;
import de.ma.it.common.util.SystemUtils;

/**
 * TODO Insert description !
 * 
 * @author Martin Absmeier
 */
public class OpenFileDialog {

	private FileExtensionFilter filter = null;

	/**
	 * Standard Constructor
	 * 
	 */
	public OpenFileDialog(FileExtensionFilter filter) {
		super();
		this.filter = filter;
	}

	/**
	 * Opens a File with JFileChooser
	 *
	 * @return the selected file or null if the dialog is canceled
	 */
	public File withFileDialog() {
		return withFileDialog(SystemUtils.getUserDir());
	}	
	
	/**
	 * Opens a File with JFileChooser
	 * 
	 * @return the selected file or null if the dialog is canceled
	 */
	public File withFileDialog(String directoryPath) {
		File selectedFile = null;

		JFileChooser fc = new JFileChooser(directoryPath);
		fc.setFileFilter(this.filter);
		int state = fc.showOpenDialog(null);

		switch (state) {
			case JFileChooser.APPROVE_OPTION:
				selectedFile = fc.getSelectedFile();
			break;
			case JFileChooser.CANCEL_OPTION:
				selectedFile = null;
			break;
			default:
				selectedFile = null;
			break;
		}

		return selectedFile;
	}
}
