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

/**
 * Simple implementation of a stop watch.
 * 
 * <p>
 * Note that "StopWatch" is not designed to be thread-safe and does not use synchronization.
 * </p>
 * 
 * @author Martin Absmeier
 */
public class StopWatch {

	private enum State {
		NOT_RUNNING, RUNNING, STOPPED;
	}

	private class Task {

		private long startTime;

		private State state;

		private long stopTime;

		private String taskName;

		protected Task(String taskName) {
			this.taskName = taskName;
			this.state = State.NOT_RUNNING;
		}

		protected String getTaskName() {
			return taskName;
		}

		protected long getTimeInMillis() {
			return stopTime - startTime;
		}

		protected double getTimeInSeconds() {
			return Double.valueOf(getTimeInMillis()) / 1000D;
		}

		protected boolean isRunning() {
			return State.RUNNING == state;
		}

		protected void start() {
			this.state = State.RUNNING;
			this.startTime = System.currentTimeMillis();
		}

		protected void stop() {
			this.state = State.STOPPED;
			this.stopTime = System.currentTimeMillis();
		}
	}

	private String stopWatchName;

	private List<Task> tasks = new ArrayList<>();

	private Task currentTask = null;

	public StopWatch() {
		this("");
	}

	public StopWatch(String stopWatchName) {
		super();
		this.stopWatchName = stopWatchName;
	}

	public long getTotalTimeInMillis() {
		long totalTimeInMillis = 0;
		for (Task aTask : tasks) {
			totalTimeInMillis += aTask.getTimeInMillis();
		}
		return totalTimeInMillis;
	}

	public double getTotalTimeInSeconds() {
		return Double.valueOf(getTotalTimeInMillis()) / 1000D;
	}

	public String prettyPrint() {
		NumberFormat nf = NumberFormat.getNumberInstance();
		nf.setMinimumIntegerDigits(7);
		nf.setGroupingUsed(false);

		NumberFormat pf = NumberFormat.getPercentInstance();
		pf.setMinimumIntegerDigits(3);
		pf.setGroupingUsed(true);

		String nl = System.getProperty("line.separator");
		StringBuilder sb = new StringBuilder("StopWatch:");
		if (stopWatchName != null && stopWatchName.trim().length() > 0) {
			sb.append(" ").append(stopWatchName);
		}
		sb.append(" totalRunningTime = ").append(getTotalTimeInMillis()).append(" ms").append(nl);
		sb.append("     ms     %  TaskName").append(nl);
		sb.append("-------------------------------------------------------------------------------").append(nl);

		for (Task aTask : tasks) {
			if (aTask.isRunning()) {
				throw new IllegalStateException("Task " + aTask.getTaskName()
						+ " is running, please stop it before calling pretty print.");
			}
			sb.append(nf.format(aTask.getTimeInMillis())).append("  ");
			sb.append(pf.format(aTask.getTimeInSeconds() / getTotalTimeInSeconds())).append("  ");
			sb.append(aTask.getTaskName()).append(nl);
		}

		return sb.toString();
	}

	public void start() {
		start("");
	}

	public void start(String taskName) throws IllegalStateException {
		if (currentTask == null || !currentTask.isRunning()) {
			currentTask = new Task(taskName);
			currentTask.start();
		} else {
			throw new IllegalStateException("Can't start StopWatch: it's already running!");
		}
	}

	public void stop() throws IllegalStateException {
		if (currentTask == null || !currentTask.isRunning()) {
			throw new IllegalStateException("Can't start StopWatch: it's not running!");
		} else {
			currentTask.stop();
			tasks.add(currentTask);
			currentTask = null;
		}
	}
}
