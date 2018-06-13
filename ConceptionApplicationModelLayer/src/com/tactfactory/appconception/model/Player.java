package com.tactfactory.appconception.model;

public class Player {
	private String pseudo;
	private Racket racket;
	private int winned;
	
	public String getPseudo() {
		return pseudo;
	}
	
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	
	public Racket getRacket() {
		return racket;
	}
	
	public void setRacket(Racket racket) {
		this.racket = racket;
	}
	
	public int getWinned() {
		return winned;
	}
	
	public void setWinned(int winned) {
		this.winned = winned;
	}
}
