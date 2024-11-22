package com.hexaware.cms.repository;

import org.springframework.stereotype.Repository;

import com.hexaware.cms.entity.Player;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


@Repository
public interface PlayerRepository extends JpaRepository<Player,Integer>{
	
	List<Player> findByPlayerId(long playerId);
	void deleteByPlayerId(int playerId);
	
	
	@Modifying
	@Query("DELETE from Player p where p.playerName =:playerName")
	void deleteplayerByName( String playerName);
}
