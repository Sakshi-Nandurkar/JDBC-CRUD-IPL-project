package com.tka.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.tka.entity.Player;

public class Dao {

	String path= "com.mysql.cj.jdbc.Driver";
	String url="jdbc:mysql://localhost:3307/demodb";
	String uname="root"; 
	String pwd="root";

	Connection conn= null;
	Statement st= null;
	ResultSet rs= null;
	ResultSet rs1= null;

	String query = "SELECT * FROM iplplayers_project.player";
	String insertquery = "INSERT INTO iplplayers_project.player VALUES(31, 'jay',100,0,'CSK','batter')";
	String updatequery = "UPDATE iplplayers_project.player SET name='Ruturaj Gaikwad',runs=748 WHERE jn=31 ";
//	String updateQuery1 = String.format(
//			"UPDATE Players SET name = '%s', runs = %d, wickets = %d, tname = '%s' WHERE jn = %d", name, runs,
//			wickets, tname, jn);

	
	List<Player> allplayerlist = null;


	public List<Player> getAllPlayers() {
		//System.out.println("Dao");
		allplayerlist = new ArrayList<Player>();

		try {
			Class.forName(path);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Driver class not found.....");
		}

		try {			
			conn=DriverManager.getConnection(url,uname,pwd);
			st = conn.createStatement();			
			rs= st.executeQuery(query);		

			while(rs.next()) {
				int jn = rs.getInt("jn");
				String pnm = rs.getString("name");
				int runs = rs.getInt("runs");
				int wickets = rs.getInt("wickets");
				String tname = rs.getString("tname");
				String role = rs.getString("role");

				//System.out.println(jn+pnm+runs+wickets+runs+tname);

				Player p1 = new Player(jn,pnm,runs,wickets,tname,role);
				allplayerlist.add(p1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return allplayerlist;
	}




	public void InsertPlayerinDB() {

		try {
			Class.forName(path);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Driver class not found.....");
		}

		try {			
			conn=DriverManager.getConnection(url,uname,pwd);
			st = conn.createStatement();	

			int ack = st.executeUpdate(insertquery);
			if(ack == 1) {
				System.out.println("one record inserted");
			}else {
				System.out.println("something goes wrong ....");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}




	public void UpdatePlayerinDB() {
		
//		Scanner sc = new Scanner(System.in);
//
//		System.out.println("Enter Jersey Number of the player to update: ");
//		int jn = sc.nextInt();
//		sc.nextLine();
//
//		System.out.print("Enter new Player Name: ");
//		String name = sc.nextLine();
//
//		System.out.print("Enter new Total Runs: ");
//		int runs = sc.nextInt();
//
//		System.out.print("Enter new Total Wickets: ");
//		int wickets = sc.nextInt();
//		sc.nextLine();
//
//		System.out.print("Enter new Team Name: ");
//		String tname = sc.nextLine();

		

		
		try {
			Class.forName(path);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Driver class not found.....");
		}

		try {			
			conn=DriverManager.getConnection(url,uname,pwd);
			st = conn.createStatement();
			int updated = st.executeUpdate(updatequery);

			if(updated==1) {
				System.out.println("data updated sucessfully");
			}else {
				System.out.println("no updation completed");
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	
	
	public void deletePlayerinDB() {

		String deletequery = "DELETE FROM iplplayers_project.player WHERE jn = 40";
		
		
		try {
			Class.forName(path);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Driver class not found.....");
		}

		try {			
			conn=DriverManager.getConnection(url,uname,pwd);
			st = conn.createStatement();
			int ack = st.executeUpdate(deletequery);
			
			if(ack==0) {
				System.out.println("deleted completed");
			}else {
				System.out.println("not deleted");
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


}