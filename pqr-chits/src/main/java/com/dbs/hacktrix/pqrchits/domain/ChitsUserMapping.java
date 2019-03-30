package com.dbs.hacktrix.pqrchits.domain;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="chits_user_mapping")
public class ChitsUserMapping {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="user_id")
	private Integer userId;
	
	

	@Column(name="chit_id")
	private Integer chitId;
	
	@Column(name="status")
	private String status;
	
	@Column(name="creation_time")
	private Timestamp creationTime;
	
	@Column(name="updation_time")
	private Timestamp updationTime;
	
	@Column(name="amount")
	private Integer amount;

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getChitId() {
		return chitId;
	}

	public void setChitId(Integer chitId) {
		this.chitId = chitId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Timestamp getCreattionTime() {
		return creationTime;
	}

	public void setCreattionTime(Timestamp creattionTime) {
		this.creationTime = creattionTime;
	}

	public Timestamp getUpdationTime() {
		return updationTime;
	}

	public void setUpdationTime(Timestamp updationTime) {
		this.updationTime = updationTime;
	}
	
}
