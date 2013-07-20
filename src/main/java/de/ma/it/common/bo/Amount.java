/*
 * Amount represents the amount of a financial transaction.
 * Copyright (C) 2012 Martin Absmeier, IT Consulting Serices
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
package de.ma.it.common.bo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Amount represents the amount of a financial transaction.
 *
 * @author Martin Absmeier
 */
public class Amount implements Serializable {

	private static final long serialVersionUID = 2481419556600466804L;

	private BigDecimal value;

	private Currency currency;
	
	/** Constructor */
	public Amount() {
		super();
	}
	
	/** Constructor */
	public Amount(BigDecimal value, Currency currency) {
		super();
		this.value = value;
		this.currency = currency;
	}

	/**
	 * Getter of field value
	 *
	 * @return the value
	 */
	public BigDecimal getValue() {
		return value;
	}

	/**
	 * Setter of field value
	 *
	 * @param value the value to set
	 */
	public void setValue(BigDecimal value) {
		this.value = value;
	}

	/**
	 * Getter of field currency
	 *
	 * @return the currency
	 */
	public Currency getCurrency() {
		return currency;
	}

	/**
	 * Setter of field currency
	 *
	 * @param currency the currency to set
	 */
	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

}
