package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Transaction;
import com.example.service.TransactionService;

@RestController
@RequestMapping("/api/transaction")
public class TransactionController {

	@Autowired
	TransactionService transactionService;
	
	@PostMapping("/saveTransaction")
	public Transaction saveTransactionDetail(@RequestBody Transaction transaction)
	{
		Transaction saveDetail=transactionService.saveTransaction(transaction);
		return saveDetail;
	}
	
	@GetMapping("/getAllTransactionDetail")
	public List<Transaction> viewAllTransactionDetail()
	{
		List<Transaction> viewAllDetail=transactionService.viewAllTransaction();
		return viewAllDetail;
	}
	
	@GetMapping("/viewTransactionDetailById/{id}")
	public Transaction viewTransactionById(@PathVariable long id)
	{
		Transaction viewById=transactionService.getTransactionById(id);
		return viewById;
	}
	
	@DeleteMapping("/deleteTranactionById/{id}")
	public void deleteById(@PathVariable long id)
	{
		transactionService.deleteTransactionById(id);
	}
}
