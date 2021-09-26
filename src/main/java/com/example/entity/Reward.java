package com.example.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Reward {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private int clientId;
    private String clientName;
    private int month;
    private int rewardPoints;
    private int dollarSpent;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getRewardPoints() {
		return rewardPoints;
	}
	public void setRewardPoints(int rewardPoints) {
		this.rewardPoints = rewardPoints;
	}
	public int getDollarSpent() {
		return dollarSpent;
	}
	public void setDollarSpent(int dollarSpent) {
		this.dollarSpent = dollarSpent;
	}
	public Reward(Long id, int clientId, String clientName, int month, int rewardPoints,
			int dollarSpent) {
		super();
		this.id = id;
		this.clientId = clientId;
		this.clientName = clientName;
		this.month = month;
		this.rewardPoints = rewardPoints;
		this.dollarSpent = dollarSpent;
	}
    
	public Reward()
	{
		
	}
    
}
