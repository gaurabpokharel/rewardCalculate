package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.entity.Transaction;

@Service
public interface TransactionService {

	public Transaction saveTransaction(Transaction transaction);
	
	public List<Transaction> viewAllTransaction();
	
	public Transaction getTransactionById(long id);
	
	public void deleteTransactionById(long id);
}
