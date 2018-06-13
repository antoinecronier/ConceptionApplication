package com.tactfactory.appconception.service.model.dto;

public class FieldDTO {
	private String player1Pseudo;
	private String player1RacketX;
	private String player1RacketY;
	private String player1RacketSize;
	private String player2Pseudo;
	private String player2RacketX;
	private String player2RacketY;
	private String player2RacketSize;
	private String ballX;
	private String ballY;
	private String ballDirectionX;
	private String ballDirectionY;

	public String getPlayer1Pseudo() {
		return player1Pseudo;
	}

	public void setPlayer1Pseudo(String player1Pseudo) {
		this.player1Pseudo = player1Pseudo;
	}

	public String getPlayer1RacketX() {
		return player1RacketX;
	}

	public void setPlayer1RacketX(String player1RacketX) {
		this.player1RacketX = player1RacketX;
	}

	public String getPlayer1RacketY() {
		return player1RacketY;
	}

	public void setPlayer1RacketY(String player1RacketY) {
		this.player1RacketY = player1RacketY;
	}

	public String getPlayer1RacketSize() {
		return player1RacketSize;
	}

	public void setPlayer1RacketSize(String player1RacketSize) {
		this.player1RacketSize = player1RacketSize;
	}

	public String getPlayer2Pseudo() {
		return player2Pseudo;
	}

	public void setPlayer2Pseudo(String player2Pseudo) {
		this.player2Pseudo = player2Pseudo;
	}

	public String getPlayer2RacketX() {
		return player2RacketX;
	}

	public void setPlayer2RacketX(String player2RacketX) {
		this.player2RacketX = player2RacketX;
	}

	public String getPlayer2RacketY() {
		return player2RacketY;
	}

	public void setPlayer2RacketY(String player2RacketY) {
		this.player2RacketY = player2RacketY;
	}

	public String getPlayer2RacketSize() {
		return player2RacketSize;
	}

	public void setPlayer2RacketSize(String player2RacketSize) {
		this.player2RacketSize = player2RacketSize;
	}

	public String getBallX() {
		return ballX;
	}

	public void setBallX(String ballX) {
		this.ballX = ballX;
	}

	public String getBallY() {
		return ballY;
	}

	public void setBallY(String ballY) {
		this.ballY = ballY;
	}

	public String getBallDirectionX() {
		return ballDirectionX;
	}

	public void setBallDirectionX(String ballDirectionX) {
		this.ballDirectionX = ballDirectionX;
	}

	public String getBallDirectionY() {
		return ballDirectionY;
	}

	public void setBallDirectionY(String ballDirectionY) {
		this.ballDirectionY = ballDirectionY;
	}

	public String toStringElement() {
		return player1Pseudo + "," + player1RacketX + "," + player1RacketY + "," + player1RacketSize + ","
				+ player2Pseudo + "," + player2RacketX + "," + player2RacketY + "," + player2RacketSize + "," + ballX
				+ "," + ballY + "," + ballDirectionX + "," + ballDirectionY;
	}

	public FieldDTO fromStringElement(String element) {
		String[] elements = element.split(",");
		this.player1Pseudo = elements[0];
		this.player1RacketX = elements[1];
		this.player1RacketY = elements[2];
		this.player1RacketSize = elements[3];
		this.player2Pseudo = elements[4];
		this.player2RacketX = elements[5];
		this.player2RacketY = elements[6];
		this.player2RacketSize = elements[7];
		this.ballX = elements[8];
		this.ballY = elements[9];
		this.ballDirectionX = elements[10];
		this.ballDirectionY = elements[11];
		
		return this;
	}
}
