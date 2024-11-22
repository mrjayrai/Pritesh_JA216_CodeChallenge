package com.hexaware.cms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hexaware.cms.dto.PlayerDTO;
import com.hexaware.cms.entity.Player;
import com.hexaware.cms.exception.PlayerNotFoundException;
import com.hexaware.cms.repository.PlayerRepository;

@Service
@Transactional
public class PlayerServiceImpl implements IPlayerService {

	@Autowired
	PlayerRepository repository;
	
	@Override
	public Player createPlayer(PlayerDTO player) {
		// TODO Auto-generated method stub
		Player playerEntity = new Player();
		
		playerEntity.setCountryName(player.getCountryName());
		playerEntity.setDescription(player.getDescription());
		playerEntity.setJerseyNumber(player.getJerseyNumber());
		playerEntity.setPlayerName(player.getPlayerName());
		playerEntity.setRole(player.getRole());
		playerEntity.setTeamName(player.getTeamName());
		playerEntity.setTotalMatches(player.getTotalMatches());
		
		return repository.save(playerEntity);
	}

	@Override
	public List<Player> getAllPlayers() {
		// TODO Auto-generated method stub
		List<Player> player = repository.findAll();
		if(player.isEmpty()) {
			throw new PlayerNotFoundException("No Player Found");
		}
		return player ;
	}

	@Override
	public List<Player> getPlayerById(int playerId) {
		// TODO Auto-generated method stub
		List<Player> player = repository.findByPlayerId(playerId);
		if(player.isEmpty()) {
			throw new PlayerNotFoundException("Player with id:"+playerId+" not found");
		}
		return player ;
	}

	@Override
	public Player updatePlayer(PlayerDTO player) {
		// TODO Auto-generated method stub
		Player playerEntity = new Player();
		
		playerEntity.setCountryName(player.getCountryName());
		playerEntity.setDescription(player.getDescription());
		playerEntity.setJerseyNumber(player.getJerseyNumber());
		playerEntity.setPlayerName(player.getPlayerName());
		playerEntity.setRole(player.getRole());
		playerEntity.setTeamName(player.getTeamName());
		playerEntity.setTotalMatches(player.getTotalMatches());
		playerEntity.setPlayerId(player.getPlayerId());
		
		return repository.save(playerEntity);
	}

	@Override
	public String deletePlayerById(int playerId) {
		// TODO Auto-generated method stub
		repository.deleteByPlayerId(playerId);
		
		List<Player> player = repository.findByPlayerId(playerId);
		
		if(player.isEmpty()) {
			return "Player Deleted Succesfully";
		}else {
			return "Player Can't be Deleted";
		}
	}

	
}
