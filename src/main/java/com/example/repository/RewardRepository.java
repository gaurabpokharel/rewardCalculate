package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Reward;

@Repository
public interface RewardRepository extends JpaRepository<Reward, Long>{

}
