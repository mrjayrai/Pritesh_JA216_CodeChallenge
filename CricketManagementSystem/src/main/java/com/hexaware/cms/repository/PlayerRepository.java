package com.hexaware.cms.repository;

import org.springframework.stereotype.Repository;

import com.hexaware.cms.entity.Player;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


@Repository
public interface PlayerRepository extends JpaRepository<Player,Integer>{
	
	List<Player> findByPlayerId(long playerId);
	void deleteByPlayerId(int playerId);
}
