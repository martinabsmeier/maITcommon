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
package de.ma.it.common.bo;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * TODO Insert short description
 * 
 * @author Martin Absmeier
 */
@MappedSuperclass
public abstract class AbstractEntity implements Serializable {

	private static final long serialVersionUID = 642244504564484565L;

	@Column(name = "EMPLOYEE_ID")
	private Integer employeeId;

	protected StringBuilder sb;
	
	@Column(name = "VALIDFROM")
	private Date validFrom;
	
	@Column(name = "VALIDTILL")
	private Date validTill;	
	
	/** Constructor */
	public AbstractEntity() {
		super();
		this.sb = new StringBuilder();
	}

	@Override
	public abstract boolean equals(Object other);

	public Integer getEmployeeId() {
		return employeeId;
	}

	public Date getValidFrom() {
		return validFrom;
	}

	public Date getValidTill() {
		return validTill;
	}

	@Override
	public abstract int hashCode();
	
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public void setValidFrom(Date validFrom) {
		this.validFrom = validFrom;
	}

	public void setValidTill(Date validTill) {
		this.validTill = validTill;
	}

	@Override
	public String toString() {
		return super.toString();
	}
	
}
