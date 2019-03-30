package com.dbs.hacktrix.pqrchits.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="chits")
public class Chits {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="amount")
	private int amount;
	
	@Column(name="numMonths")
	private int numMonths;
	
	@Column(name="commission")
	private int commision;
	
	@Column(name="numPersons")
	private int numPersons;
	
	@Column(name="bidStartTime")
	private long bidStartTime;
	
	@Column(name="bidEndTime")
	private long bidEndTime;
	
	@Column(name="commissionAmount")
	private int commissionAmount;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getNumMonths() {
		return numMonths;
	}

	public void setNumMonths(int numMonths) {
		this.numMonths = numMonths;
	}

	public int getCommision() {
		return commision;
	}

	public void setCommision(int commision) {
		this.commision = commision;
	}

	public int getNumPersons() {
		return numPersons;
	}

	public void setNumPersons(int numPersons) {
		this.numPersons = numPersons;
	}

	public long getBidStartTime() {
		return bidStartTime;
	}

	public void setBidStartTime(long bidStartTime) {
		this.bidStartTime = bidStartTime;
	}

	public long getBidEndTime() {
		return bidEndTime;
	}

	public void setBidEndTime(long bidEndTime) {
		this.bidEndTime = bidEndTime;
	}

	public int getCommissionAmount() {
		return commissionAmount;
	}

	public void setCommissionAmount(int commissionAmount) {
		this.commissionAmount = commissionAmount;
	}
	
	
}
