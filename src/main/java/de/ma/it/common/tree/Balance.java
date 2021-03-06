/*
 * Enum for tree balance factor.
 * Copyright (C) 2012 Martin Absmeier, IT Consulting Services
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
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package de.ma.it.common.tree;

/** 
 * Enum for tree balance factor.
 * 
 * @author Martin Absmeier
 */
public enum Balance {

	/** Code for left high trees. */
	LEFT_HIGH,
	/** Code for Balance.BALANCED trees. */
	BALANCED,
	/** Code for right high trees. */
	RIGHT_HIGH;

}
