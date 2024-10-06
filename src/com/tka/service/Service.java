package com.tka.service;

import java.util.ArrayList;
import java.util.List;

import com.tka.dao.Dao;
import com.tka.entity.Player;

public class Service {

	Dao dao = null;

	public List<Player> getAllPlayers() {

		dao = new Dao();
		List<Player> allPlayers = dao.getAllPlayers();
		return allPlayers;	
	}
	
	

	public List<Player> getPlayersbyteam(String team) {
		dao = new Dao();
		List<Player> allPlayers = dao.getAllPlayers();		
		List<Player> getPlayersteam = new ArrayList<Player>();
		
		for (Player player : allPlayers) {
			if(player.getTname().equalsIgnoreCase(team)) {
				getPlayersteam.add(player);
			}
		}
		return getPlayersteam;
	}

	
	public List<Player> AllPlayersbyrole(String role) {
		dao = new Dao();
		List<Player> allPlayers = dao.getAllPlayers();		
		List<Player> Playersbyrole = new ArrayList<Player>();
		
		for (Player p : allPlayers) {
			if(p.getRole().equalsIgnoreCase(role)) {
				Playersbyrole.add(p);
			}
		}
		return Playersbyrole;
	}
	
	public List<Player> AllwicketPlayers() {
		dao = new Dao();
		List<Player> allPlayers = dao.getAllPlayers();				
		allPlayers.sort((p1, p2) -> Integer.compare(p2.getWickets(), p1.getWickets()));
		return allPlayers;
	}
	
	public List<Player> AllrunPlayers() {
		dao = new Dao();
		List<Player> allPlayers = dao.getAllPlayers();				
		allPlayers.sort((p1, p2) -> Integer.compare(p2.getRuns(), p1.getRuns()));
		return allPlayers;
	}


	public void insertPlayer() {
		dao = new Dao();
		dao.InsertPlayerinDB();
	}
	
	public void updatePlayer() {
		dao = new Dao();
		dao.UpdatePlayerinDB();
	}
	
	public void deletePlayer() {
		dao = new Dao();
		dao.deletePlayerinDB();
	}

	
	
}