package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.entity.Reward;

@Service
public interface RewardService {

	public List<Reward> countRewardPoints();
	
	public Reward countRewardPointByClientId(long id);
	
	public Reward getRewardPointByMonth(int month);
}
