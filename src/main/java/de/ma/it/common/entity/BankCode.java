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
package de.ma.it.common.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * TODO Insert short description
 * 
 * @author Martin Absmeier
 */
@Entity
@Table(name = "T_BANKCODE")
public class BankCode extends AbstractEntity {

	private static final long serialVersionUID = -5134752342024642223L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "BANKCODE")
	private Long bankCode;
	
	@Column(name = "BIC")
	private String bic;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	@Column(name = "PAN_ID")
	private Long panId;
		
	@Column(name = "POSTAL_CODE_ID")
	private Long postalCodeId;
	
	@Column(name = "SHORT_DESCRIPTION")
	private String shortDescription;
	
	/** Constructor */
	public BankCode() {
		super();
	}

	@Override
	public boolean equals(Object other) {
		if (other == null) {
			return false;
		}
		if (other == this) {
			return true;
		}
		if (other.getClass() != this.getClass()) {
			return false;
		}
		BankCode rhs = (BankCode) other;
		EqualsBuilder eb = new EqualsBuilder();

		eb.append(getId(), rhs.getId());
		eb.append(getBankCode(), rhs.getBankCode());

		return eb.isEquals();
	}
	
	public Long getBankCode() {
		return bankCode;
	}

	public String getBic() {
		return bic;
	}

	public String getDescription() {
		return description;
	}

	public Long getId() {
		return id;
	}

	public Long getPanId() {
		return panId;
	}

	public Long getPostalCodeId() {
		return postalCodeId;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	@Override
	public int hashCode() {
		HashCodeBuilder hb = new HashCodeBuilder();
		hb.append(getId());
		hb.append(getBankCode());
		return hb.toHashCode();
	}

	public void setBankCode(Long bankCode) {
		this.bankCode = bankCode;
	}

	public void setBic(String bic) {
		this.bic = bic;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setPanId(Long panId) {
		this.panId = panId;
	}

	public void setPostalCodeId(Long postalCodeId) {
		this.postalCodeId = postalCodeId;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	@Override
	public String toString() {
		sb.setLength(0);
		sb.append("Id: " + getId());
		return sb.toString();
	}

}
