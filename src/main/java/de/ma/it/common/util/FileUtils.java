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
package de.ma.it.common.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO Insert description !
 *
 * @author Martin Absmeier
 */
public class FileUtils {

	/**
	 * serializeFiles
	 *
	 * @param files
	 * @return
	 * @throws IOException
	 */
	public byte[] serializeFiles(List<File> files) throws IOException {		
		Map<String, byte[]> serMap = new HashMap<String, byte[]>();
		for (File file : files) {
			serMap.put(file.getCanonicalPath(), serializeFile(file));
		}
		
		ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		ObjectOutputStream oOut = new ObjectOutputStream(bOut);
		oOut.writeObject(serMap);
		oOut.close();

		return bOut.toByteArray();
	}

	/**
	 * serializeFile
	 *
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public static byte[] serializeFile(File file) throws IOException {		
		ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		ObjectOutputStream oOut = new ObjectOutputStream(bOut);
		oOut.writeObject(file);
		oOut.close();		
		return bOut.toByteArray();
	}
	
	/* --------------------------------------------------------------------- */

	/** Standard Constructor */
	private FileUtils() {
		super();
	}

}
