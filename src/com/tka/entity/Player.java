package com.tka.entity;

public class Player {

	private int jn;
	private String name;
	private int runs;
	private int wickets;
	private String tname;
	private String role;

	public Player() {
		super();
	}

	public Player(int jn, String name, int runs, int wickets, String tname,String role) {
		super();
		this.jn = jn;
		this.name = name;
		this.runs = runs;
		this.wickets = wickets;
		this.tname = tname;
		this.role = role;
	}

	public int getJn() {
		return jn;
	}

	public void setJn(int jn) {
		this.jn = jn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRuns() {
		return runs;
	}

	public void setRuns(int runs) {
		this.runs = runs;
	}

	public int getWickets() {
		return wickets;
	}

	public void setWickets(int wickets) {
		this.wickets = wickets;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "\nPlayer [jn = " + jn + ", name = " + name + ", runs = " + runs + ", wickets = " + wickets + ", tname = " + tname
				+ ", role = " + role + "]";
	}

}