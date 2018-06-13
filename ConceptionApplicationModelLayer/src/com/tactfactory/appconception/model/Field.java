package com.tactfactory.appconception.model;

public class Field {
	private Player player1;
	private Player player2;
	private Ball ball;
	private int partyPlayed;
	
	public Player getPlayer1() {
		return player1;
	}
	
	public void setPlayer1(Player player1) {
		this.player1 = player1;
	}
	
	public Player getPlayer2() {
		return player2;
	}
	
	public void setPlayer2(Player player2) {
		this.player2 = player2;
	}
	
	public Ball getBall() {
		return ball;
	}
	
	public void setBall(Ball ball) {
		this.ball = ball;
	}
	
	public int getPartyPlayed() {
		return partyPlayed;
	}
	
	public void setPartyPlayed(int partyPlayed) {
		this.partyPlayed = partyPlayed;
	}
}
