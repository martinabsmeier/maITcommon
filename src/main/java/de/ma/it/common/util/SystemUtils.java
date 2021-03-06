/*
 * Utility class to get the use of system information
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
 * Utility class to simplify access to the system information.
 * 
 * @author Martin Absmeier
 */
public class SystemUtils {

	/**
	 * List of property names.
	 * 
	 * @author Martin Absmeier
	 */
	public enum PropertyName {

		/**
		 * Character that separates components of a file path. This is "/" on UNIX and "\" on Windows.
		 */
		FILE_SEPARATOR("file.separator"),

		/**
		 * Path used to find directories and JAR archives containing class files. Elements of the class path are separated by a
		 * platform-specific character specified in the path.separator property.
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

	/* User's account name */
	private static final String USER_NAME = System.getProperty(PropertyName.USER_NAME.getName());

	/* User's current working directory */
	private static final String USER_DIR = System.getProperty(PropertyName.USER_DIR.getName());

	/* User's home directory */
	private static final String USER_HOME = System.getProperty(PropertyName.USER_HOME.getName());

	/* Operating system name */
	private static final String OS_NAME = System.getProperty(PropertyName.OS_NAME.getName());

	/* Operating system architecture */
	private static final String OS_ARCH = System.getProperty(PropertyName.OS_ARCH.getName());

	/* Operating system version */
	private static final String OS_VERSION = System.getProperty(PropertyName.OS_VERSION.getName());

	/* File separator ("/" on UNIX) */
	private static final String FILE_SEPERATOR = System.getProperty(PropertyName.FILE_SEPARATOR.getName());

	/* Path separator (":" on UNIX) */
	private static final String PATH_SEPERATOR = System.getProperty(PropertyName.PATH_SEPARATOR.getName());

	/* Line separator ("\n" on UNIX) */
	private static final String LINE_SEPERATOR = System.getProperty(PropertyName.LINE_SEPARATOR.getName());

	/**
	 * Get user's account name
	 * 
	 * @return user's account name
	 */
	public static String getUserName() {
		return USER_NAME;
	}

	/**
	 * Get user's current working directory
	 * 
	 * @return user's current working directory
	 */
	public static String getUserDir() {
		return USER_DIR;
	}

	/**
	 * Get user's home directory
	 * 
	 * @return user's home directory
	 */
	public static String getUserHome() {
		return USER_HOME;
	}

	/**
	 * Get the operating system name.
	 * 
	 * @return The operating system name.
	 */
	public static String getOsName() {
		return OS_NAME;
	}

	/**
	 * Get the operating system architecture.
	 * 
	 * @return The operating system architecture.
	 */
	public static String getOsArchitecture() {
		return OS_ARCH;
	}

	/**
	 * Get the operating system version.
	 * 
	 * @return The operating system version.
	 */
	public static String getOsVersion() {
		return OS_VERSION;
	}

	/**
	 * Get the File separator ("/" on UNIX)
	 * 
	 * @return file separator
	 */
	public static String getFileSeperator() {
		return FILE_SEPERATOR;
	}

	/**
	 * Get the File separator ("/" on UNIX).
	 * 
	 * @return The file separator ("/" on UNIX).
	 */
	public static String getPathSeperator() {
		return PATH_SEPERATOR;
	}

	/**
	 * Get the line separator ("\n" on UNIX).
	 * 
	 * @return The line separator ("\n" on UNIX).
	 */
	public static String getLineSeperator() {
		return LINE_SEPERATOR;
	}

	/**
	 * Returns the number of processors available to the Java virtual machine. This value may change during a particular invocation of the
	 * virtual machine. Applications that are sensitive to the number of available processors should therefore occasionally poll this
	 * property and adjust their resource usage appropriately.
	 * 
	 * @return The number of available processors
	 */
	public static int getAvailableProcessors() {
		return Runtime.getRuntime().availableProcessors();
	}

	/**
	 * Returns the amount of free memory in the Java Virtual Machine. Calling the garbage collector method may result in increasing the
	 * value returned by freeMemory.
	 * 
	 * @return The amount free memory
	 */
	public static long getFreeMemory() {
		return Runtime.getRuntime().freeMemory();
	}

	/**
	 * Returns the maximum amount of memory that the Java virtual machine will attempt to use. If there is no inherent limit then the value
	 * java.lang.Long.MAX_VALUE will be returned.
	 * 
	 * @return The maximum amount of memory.
	 */
	public static long getMaxMemory() {
		return Runtime.getRuntime().maxMemory();
	}

	/**
	 * Returns the total amount of memory in the Java virtual machine. The value returned by this method may vary over time, depending on
	 * the host environment.
	 * 
	 * @return The total amount of memory.
	 */
	public static long getTotalMemory() {
		return Runtime.getRuntime().totalMemory();
	}

	/**
	 * Standard Constructor
	 */
	private SystemUtils() {
		super();
	}

}
