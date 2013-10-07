/*
 * Implementation of a stopwatch task.
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
package de.ma.it.common.sw;

/**
 * Implementation of a stop watch task.<br />
 * Used to hold data about one task executed within the stop watch.
 * 
 * <p>
 * Note that "StopWatch" is not designed to be thread-safe and does not use
 * synchronization.
 *
 * @author Martin Absmeier
 */
public class StopWatchTask {

	private String taskName;

	private long startTime;
	
	private long stopTime;
	
	/**
	 * Standard Constructor
	 * 
	 * @param taskName
	 *            Name of task.
	 * @param startTime
	 *            Start time of task.
	 * @param stopTime
	 *            Stop time of task.
	 */
	public StopWatchTask(String taskName, long startTime, long stopTime) {
		super();
		this.taskName = taskName;
		this.startTime = startTime;
		this.stopTime = stopTime;
	}

	/**
	 * Return the start time of the task.
	 *
	 * @return start time of the task.
	 */
	public long getStartTime() {
		return startTime;
	}

	/**
	 * Returns the stop time of the task.
	 *
	 * @return stop time of the task.
	 */
	public long getStopTime() {
		return stopTime;
	}

	/**
	 * Returns the name of the task.
	 *
	 * @return name of the task
	 */
	public String getTaskName() {
		return taskName;
	}
	
	/**
	 * Returns the running time in milliseconds.
	 *
	 * @return running time in milliseconds
	 */
	public long getTimeInMillis() {
		return stopTime - startTime;
	}
	
	/**
	 * Returns the running time in seconds.
	 *
	 * @return running time in seconds
	 */
	public double getTimeInSeconds() {
		return Double.valueOf(stopTime - startTime) / 1000.0D;
	}

}
