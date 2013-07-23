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

/**
 * TODO Insert short description
 * 
 * @author Martin Absmeier
 */
public enum PropertyName {

	/**
	 * Character that separates components of a file path. This is "/" on UNIX
	 * and "\" on Windows.
	 */
	FILE_SEPARATOR("file.separator"),

	/**
	 * Path used to find directories and JAR archives containing class files.
	 * Elements of the class path are separated by a platform-specific character
	 * specified in the path.separator property.
	 */
	JAVA_CLASS_PATH("java.class.path"),

	/**
	 * Installation directory for Java Runtime Environment (JRE)
	 */
	JAVA_HOME("java.home"),

	/**
	 * JRE vendor name
	 */
	JAVA_VENDOR("java.vendor"),

	/**
	 * JRE vendor URL
	 */
	JAVA_VENDOR_URL("java.vendor.url"),

	/**
	 * JRE version number
	 */
	JAVA_VERSION("java.version"),

	/**
	 * Sequence used by operating system to separate lines in text files
	 */
	LINE_SEPARATOR("line.separator"),

	/**
	 * Operating system architecture
	 */
	OS_ARCH("os.arch"),

	/**
	 * Operating system name
	 */
	OS_NAME("os.name"),

	/**
	 * Operating system version
	 */
	OS_VERSION("os.version"),

	/**
	 * Path separator character used in java.class.path
	 */
	PATH_SEPARATOR("path.separator"),

	/**
	 * User working directory
	 */
	USER_DIR("user.dir"),

	/**
	 * User home directory
	 */
	USER_HOME("user.home"),

	/**
	 * User account name
	 */
	USER_NAME("user.name");

	private String propertyName;

	private PropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public String getName() {
		return this.propertyName;
	}

}
