package com.example.serviceImpl;

import java.math.BigDecimal;
import java.time.Month;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Reward;
import com.example.entity.Transaction;
import com.example.exception.ClientIdNotFoundExcpetion;
import com.example.exception.MonthNotFoundException;
import com.example.repository.RewardRepository;
import com.example.repository.TransactionRepository;
import com.example.service.RewardService;

@Service
public class RewardServiceImpl implements RewardService {

	@Autowired
	RewardRepository rewardRepository;
	
	@Autowired
	TransactionRepository transactionRepository;
	
	@Override
	public List<Reward> countRewardPoints() {
		List<Transaction> allTransactionDetail= transactionRepository.findAll();
		List<Reward> rewardList=new ArrayList<Reward>();
		
		for (Transaction transaction : allTransactionDetail) {
			Reward reward=new Reward();
			int amount=transaction.getDollarSpent();
			int rewards=0;
			if(amount>=100)
			{
				 rewards=(amount-100)*2+1*50;
			}
			
			reward.setClientId(transaction.getClientId());
			reward.setClientName(transaction.getClientName());
			reward.setDollarSpent(transaction.getDollarSpent());
			reward.setRewardPoints(rewards);
			Date date=transaction.getDate();
			int month=date.getMonth()+1;
			reward.setMonth(month);
			
			rewardList.add(reward);
		}
		return rewardList;
	}
	
	@Override
	public Reward countRewardPointByClientId(long id) {
		List<Transaction> allTransactionDetail= transactionRepository.findAll();
		List<Integer> Rewardlist = new ArrayList<>();
		List<Integer> MoneySpentlist = new ArrayList<>();
		Reward reward=new Reward();
		
		for (Transaction transaction : allTransactionDetail) {
			if(transaction.getClientId()==id)
			{
			int amount=transaction.getDollarSpent();
			int rewards=0;
			if(amount>=100)
			{
				 rewards=(amount-100)*2+1*50;
			}
			Rewardlist.add(rewards);
			reward.setClientId(transaction.getClientId());
			reward.setClientName(transaction.getClientName());
			MoneySpentlist.add(transaction.getDollarSpent());
		}
		}
		int rewardsum=0;
		 for (int i = 0; i < Rewardlist.size(); i++)
			 rewardsum += Rewardlist.get(i);
		 reward.setRewardPoints(rewardsum);
		 
		 int moneySpentSum=0;
		 for (int i = 0; i < MoneySpentlist.size(); i++)
			 moneySpentSum += MoneySpentlist.get(i);
	 reward.setDollarSpent(moneySpentSum);
	 
	 if(reward==null)
	 {
		 throw new ClientIdNotFoundExcpetion("id :"+id+"is not found");
	 }
		
		return reward;
	}
	
	@Override
	public Reward getRewardPointByMonth(int month) {
		List<Transaction> allTransactionDetail= transactionRepository.findAll();
		List<Integer> Rewardlist = new ArrayList<>();
		List<Integer> MoneySpentlist = new ArrayList<>();
		Reward reward=new Reward();
		
		for (Transaction transaction : allTransactionDetail) {
			Date date=transaction.getDate();
			int dbmonth=date.getMonth()+1;
			if(dbmonth==month)
			{
			int amount=transaction.getDollarSpent();
			int rewards=0;
			if(amount>=100)
			{
				 rewards=(amount-100)*2+1*50;
			}
			reward.setMonth(month);
			Rewardlist.add(rewards);
			MoneySpentlist.add(transaction.getDollarSpent());
		}
		}
		int rewardsum=0;
		 for (int i = 0; i < Rewardlist.size(); i++)
			 rewardsum += Rewardlist.get(i);
		 reward.setRewardPoints(rewardsum);
		 
		 int moneySpentSum=0;
		 for (int i = 0; i < MoneySpentlist.size(); i++)
			 moneySpentSum += MoneySpentlist.get(i);
	 reward.setDollarSpent(moneySpentSum);
		
	 	if(reward==null)
	 	{
	 		throw new MonthNotFoundException("Month :"+month+"is not found");
	 	}
		return reward;
	}
}
