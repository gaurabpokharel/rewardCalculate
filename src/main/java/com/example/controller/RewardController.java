package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Reward;
import com.example.service.RewardService;

@RestController
@RequestMapping("/api/reward")
public class RewardController {

	@Autowired
	RewardService rewardService;
	
	@GetMapping("/getAllRewardsDetail")
	public List<Reward> getAllRewards()
	{
		List<Reward> allDetail=rewardService.countRewardPoints();
		return allDetail;
	}
	
	@GetMapping("/getRewardpointByClientId/{id}")
	public Reward getRewardPointByClientId(@PathVariable long id)
	{
		Reward reward=rewardService.countRewardPointByClientId(id);
		return reward;
	}
	
	@GetMapping("/getRewardPointByMonth/{month}")
	public Reward getRewardPointByMonth(@PathVariable int month)
	{
		Reward reward=rewardService.getRewardPointByMonth(month);
		return reward;
	}
}
