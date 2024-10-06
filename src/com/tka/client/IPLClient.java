package com.tka.client;

import java.util.List;
import java.util.Scanner;

import com.tka.controller.IPLController;
import com.tka.entity.Player;

public class IPLClient {

	public static void main(String[] args) {

		IPLController controller = new IPLController();

		Scanner sc = new Scanner(System.in);



		List<Player> allPlayers = null;
		List<Player> getPlayers = null;
		List<Player> Playersbyrole= null;
		List<Player> wicketPlayers= null;
		List<Player> runsPlayers= null;


		System.out.println("Welcome to IPl project");
		System.out.println("here are different categories for fetching player data");

		while(true) {		
			System.out.println("\n1. Display player list by categories\n2. All players \n3. Add player\n4. Update player data\n5. Delete player data \n6. Exit\n");
			int key = sc.nextInt();

			switch(key){
			case 1: 
			while(true) {
				 System.out.println("\n1. Player list by teamname \n2. Player list by role \n3.Player list by wickets \n4.Player list by runs \n5.Exit\n ");
					int keychoice = sc.nextInt();

				switch(keychoice) {

				case 1: System.out.println("enter team for of player");
				String team = sc.next();
				getPlayers = controller.getPlayersbyteam(team);
				for (Player player : getPlayers) {
					System.out.print(player);
				}
				break;

				case 2:System.out.println("enter role of player  (batter, bowler, all rounder)");
				String role = sc.next();			
				sc.nextLine();
				Playersbyrole = controller.AllPlayersbyrole(role);
				for (Player player : Playersbyrole) {
					System.out.print(player);
				}
				break;

				case 3:wicketPlayers = controller.AllwicketPlayers();
				for (Player player : wicketPlayers) {
					System.out.print(player.getName()+player.getWickets());
				}
				break;

				case 4:runsPlayers = controller.AllrunPlayers();
				for (Player player : runsPlayers) {
					System.out.print(player.getName()+player.getRuns());
				}
				break;

				case 5: System.out.println("stay connected for more information");
				System.exit(0);
				}
					
			}
			case 2: allPlayers = controller.getAllPlayers();
			for (Player player : allPlayers) {
				System.out.print(player);
			}
			break;

			case 3: controller.insertPlayer();
			break;

			case 4: controller.updatePlayer();
			break;

			case 5: controller.deletePlayer(); 
			break;

			case 6: sc.close();
			System.exit(0);
			}
		
		}

	}
}