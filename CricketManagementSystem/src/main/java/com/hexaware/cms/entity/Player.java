package com.hexaware.cms.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "players")
public class Player {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long playerId;
	
	@NotBlank(message = "Player name is required.")
    @Size(max = 100, message = "Player name cannot exceed 100 characters.")
    private String playerName;

    @NotNull(message = "Jersey number is required.")
    @Min(value = 1, message = "Jersey number must be at least 1.")
    private int jerseyNumber;

    @NotBlank(message = "Role is required.")
    @Pattern(regexp = "Batsman|Bowler|Keeper|All Rounder", 
    message = "Role must be one of the following: Batsman, Bowler, Keeper, All Rounder.")
    private String role;

    @NotNull(message = "Total matches played is required.")
    @Min(value = 0, message = "Total matches must be 0 or more.")
    private int totalMatches;

    @NotBlank(message = "Team name is required.")
    @Size(max = 100, message = "Team name cannot exceed 100 characters.")
    private String teamName;

    @NotBlank(message = "Country name is required.")
    @Size(max = 100, message = "Country name cannot exceed 100 characters.")
    private String countryName;

    @Size(max = 500, message = "Description cannot exceed 500 characters.")
    private String description;

    
	public Player() {
		super();
	}

	
    
    
	
	public Player(long playerId,
			 String playerName,
			 int jerseyNumber,
			 String role,
			 int totalMatches,
			 String teamName,
			 String countryName,
			 String description) {
		super();
		this.playerId = playerId;
		this.playerName = playerName;
		this.jerseyNumber = jerseyNumber;
		this.role = role;
		this.totalMatches = totalMatches;
		this.teamName = teamName;
		this.countryName = countryName;
		this.description = description;
	}





	public long getPlayerId() {
		return playerId;
	}

	public void setPlayerId(long playerId) {
		this.playerId = playerId;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public int getJerseyNumber() {
		return jerseyNumber;
	}

	public void setJerseyNumber(int jerseyNumber) {
		this.jerseyNumber = jerseyNumber;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getTotalMatches() {
		return totalMatches;
	}

	public void setTotalMatches(int totalMatches) {
		this.totalMatches = totalMatches;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


    
}
