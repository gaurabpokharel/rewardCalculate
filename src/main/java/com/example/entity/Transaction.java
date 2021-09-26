package com.example.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table

public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
	//transaction id
    private Long id;
	
	private int clientId;
	
	private String clientName;
	//total amount spent by customer
	private int dollarSpent;
	//transaction date 
	private Date date;
	
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
	public int getDollarSpent() {
		return dollarSpent;
	}
	public void setDollarSpent(int dollarSpent) {
		this.dollarSpent = dollarSpent;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Transaction(Long id, int clientId, String clientName, int dollarSpent, Date date) {
		super();
		this.id = id;
		this.clientId = clientId;
		this.clientName = clientName;
		this.dollarSpent = dollarSpent;
		this.date = date;
	}
	
	public Transaction()
	{
	}
	
	
}
