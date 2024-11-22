package com.hexaware.cms.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.cms.dto.PlayerDTO;
import com.hexaware.cms.entity.Player;
import com.hexaware.cms.service.IPlayerService;


@RestController
@RequestMapping("/api/players/")
public class PlayerRestController {

	@Autowired
	IPlayerService service;
	
	@GetMapping("all")
	private List<Player> getAllPlayer(){
		return service.getAllPlayers();
	}
	
	@GetMapping("player/{playerId}")
	private List<Player> getPlayerById(@PathVariable int playerId){
//		System.out.println(playerId);
		return service.getPlayerById(playerId);
	}
	
	@PostMapping("add")
	private Player addPlayer(@RequestBody PlayerDTO player) {
//		System.out.println(player.toString());
		return service.createPlayer(player);
//		return null;
	}
	
	@PutMapping("update")
	private Player updatePlayer(@RequestBody PlayerDTO player) {
		return service.updatePlayer(player);
	}
	
	@DeleteMapping("delete/player/{playerId}")
	private String deletePlayer(@PathVariable int playerId) {
		return service.deletePlayerById(playerId);
	}
	
}
