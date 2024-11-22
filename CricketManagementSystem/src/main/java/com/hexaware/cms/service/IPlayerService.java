package com.hexaware.cms.service;

import java.util.List;

import com.hexaware.cms.dto.PlayerDTO;
import com.hexaware.cms.entity.Player;
import com.hexaware.cms.exception.PlayerNotFoundException;

public interface IPlayerService {

	Player createPlayer(PlayerDTO player);
	
	List<Player> getAllPlayers();
	
	List<Player> getPlayerById(int playerId);
	
	Player updatePlayer(PlayerDTO player);
	
	String deletePlayerById(int playerId);
}
