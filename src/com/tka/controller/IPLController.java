package com.tka.controller;

import java.util.List;

import com.tka.entity.Player;
import com.tka.service.Service;

public class IPLController {

	Service service=null;

	public List<Player> getAllPlayers() {
		service = new Service();
		List<Player> allPlayers = service.getAllPlayers();
		return allPlayers;
	}

	public List<Player> getPlayersbyteam(String team) {
		service = new Service();
		List<Player> getPlayers = service.getPlayersbyteam(team);
		return getPlayers;
	}



	
	public List<Player> AllPlayersbyrole(String role) {
		service = new Service();
		List<Player> playersbyrole = service.AllPlayersbyrole(role);
		return playersbyrole;	
		}

	public List<Player> AllwicketPlayers() {
		service = new Service();
		List<Player> wicketplayer = service.AllwicketPlayers();
		return wicketplayer;	
	}

	public List<Player> AllrunPlayers() {
		service = new Service();
		List<Player> runsPlayers = service.AllrunPlayers();
		return runsPlayers;
	}

	
	public void insertPlayer() {
		service = new Service();
		service.insertPlayer();
	}

	public void updatePlayer() {
		service = new Service();
		service.updatePlayer();
	}
	
	public void deletePlayer() {
		service = new Service();
		service.deletePlayer();
	}

	
	
	
	

	

	
}