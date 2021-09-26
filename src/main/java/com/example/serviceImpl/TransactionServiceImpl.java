package com.example.serviceImpl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Transaction;
import com.example.repository.TransactionRepository;
import com.example.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	TransactionRepository transactionRepository;
	
	@Override
	public Transaction saveTransaction(Transaction transaction) {
		Transaction saveDetail=transactionRepository.save(transaction);
		return saveDetail;
	}
	@Override
	public List<Transaction> viewAllTransaction() {
		List<Transaction> viewAll=transactionRepository.findAll();
		return viewAll;
	}
	@Override
	public Transaction getTransactionById(long id) {
		Transaction viewById=transactionRepository.findById(id).get();
		return viewById;
	}
	@Override
	public void deleteTransactionById(long id) {
		transactionRepository.deleteById(id);
	}
}
