/*
 * Simple implementation of a stop watch.
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

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import de.ma.it.common.util.SystemUtils;

/**
 * Simple implementation of a stop watch.
 *
 * <p>
 * Note that "StopWatch" is not designed to be thread-safe and does not use
 * synchronization.
 * 
 * @author Martin Absmeier
 */
public class StopWatch {
	
	/** Name of the currently running task. */
	private String currentTaskName;

	/** Start time of currently running task. */
	private long currentStartTime;
	
	/** Is the stop watch currently running? */
	private boolean isRunning;

	/** List of all executed tasks. */
	private List<StopWatchTask> taskList;	
	
	private StringBuilder sb;

	private static final String NL = SystemUtils.getLineSeperator();
	
	private static final String TAB = "\t";
	
	/**
	 * Standard Constructor
	 */
	public StopWatch() {
		super();
		this.taskList = new ArrayList<StopWatchTask>();
		this.sb = new StringBuilder();
	}

	/**
	 * Returns the total time in milliseconds for all executed task.
	 *
	 * @return total time in milliseconds
	 */
	public long getTotalTimeInMillis() {
		long totalTimeInMillis = 0;

		for (StopWatchTask aTask : this.taskList) {
			totalTimeInMillis = totalTimeInMillis + aTask.getTimeInMillis();
		}

		return totalTimeInMillis;
	}

	/**
	 * Returns the total time in seconds for all executed task.
	 *
	 * @return total time in seconds
	 */
	public double getTotalTimeInSeconds() {
		return Double.valueOf(getTotalTimeInMillis()) / 1000.0D;
	}
	
	/**
	 * Returns if the StopWatch is running.
	 *
	 * @return true if the StopWatch is running, false otherwise
	 */
	public boolean isRunning() {
		return this.isRunning;
	}

	/**
	 * Start the StopWatch with a named task.
	 *
	 * @param taskName
	 *            the name of the task.
	 */
	public void start(String taskName) throws IllegalStateException {
		if (isRunning()) {
			throw new IllegalStateException("Can't start StopWatch: it's already running!");
		}
		this.isRunning = true;
		this.currentTaskName = taskName;
		this.currentStartTime = System.currentTimeMillis();
	}
	
	/**
	 * Stops the current running task.
	 */
	public void stop() throws IllegalStateException {
		if (!isRunning()) {
			throw new IllegalStateException("Can't stop StopWatch: it's not running!");
		}
		this.taskList.add(new StopWatchTask(this.currentTaskName, this.currentStartTime, System.currentTimeMillis()));
		this.isRunning = false;
		this.currentTaskName = null;
		this.currentStartTime = 0;
	}

	public String prettyPrint() {
		NumberFormat nf = NumberFormat.getNumberInstance();
		nf.setMinimumIntegerDigits(7);
		nf.setGroupingUsed(false);
		NumberFormat pf = NumberFormat.getPercentInstance();
		pf.setMinimumIntegerDigits(3);
		pf.setGroupingUsed(false);
		
		sb.setLength(0);
		sb.append("StopWatch totalRunningTime = ").append(getTotalTimeInMillis()).append(" ms").append(NL);
		sb.append(TAB).append("     ms     %  TaskName").append(NL);
		sb.append(TAB).append("---------------").append(missingSeparatorChars()).append(NL);
		
		for (StopWatchTask aTask : taskList) {
			sb.append(TAB);
			sb.append(nf.format(aTask.getTimeInMillis())).append("  ");
			sb.append(pf.format(aTask.getTimeInSeconds() / getTotalTimeInSeconds())).append("  ");
			sb.append(aTask.getTaskName()).append(NL);
		}

		return sb.toString();
	}

	private int getLengthOfLongestTaskName() {
		int lengthOfLongestTaskName = 0;
		for (StopWatchTask aTask : taskList) {
			int taskNameLength = aTask.getTaskName().length();
			if (taskNameLength > lengthOfLongestTaskName) {
				lengthOfLongestTaskName = taskNameLength; 
			}
		}
		return lengthOfLongestTaskName;
	}
	
	private String missingSeparatorChars() {
		StringBuilder sb = new StringBuilder();
		int taskNameLength = getLengthOfLongestTaskName();
		for (int count = 0; count < taskNameLength; count++) {
			sb.append("-");
		}
		return sb.toString();
	}
	
}
