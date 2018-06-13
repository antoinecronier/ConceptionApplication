package com.tactfactory.appconception.buisness;

import java.io.IOException;
import java.net.Socket;

import com.tactfactory.appconception.model.Ball;
import com.tactfactory.appconception.model.Field;
import com.tactfactory.appconception.model.Player;
import com.tactfactory.appconception.model.Racket;
import com.tactfactory.appconception.service.CommunicationManager;
import com.tactfactory.appconception.service.model.assembler.FieldAssembler;

public class Game {

	private Field field;
	private int maxHeight;
	private int maxWidth;
	private CommunicationManager client1;
	private CommunicationManager client2;

	public Game(int maxHeight, int maxWidth, Socket client1, Socket client2) {
		this.field = new Field();
		this.field.setPartyPlayed(0);
		Ball ball = new Ball();
		ball.setDirectionX(+1);
		ball.setDirectionY(+1);
		ball.setX(maxHeight/2);
		ball.setY(maxWidth/2);
		this.field.setBall(ball);
		Player player1 = new Player();
		player1.setPseudo("Player1");
		player1.setWinned(0);
		Racket racket1 = new Racket();
		racket1.setSize(5);
		racket1.setX(0);
		racket1.setY(0);
		player1.setRacket(racket1);
		this.field.setPlayer1(player1);
		Player player2 = new Player();
		player2.setPseudo("Player2");
		player2.setWinned(0);
		Racket racket2 = new Racket();
		racket2.setSize(5);
		racket2.setX(0);
		racket2.setY(maxWidth-1);
		player2.setRacket(racket2);
		this.field.setPlayer2(player2);

		this.maxHeight = maxHeight;
		this.maxWidth = maxWidth;
		this.client1 = new CommunicationManager(client1);
		this.client2 = new CommunicationManager(client2);
		
		this.client1.sendData("start");
		this.client2.sendData("start");
	}

	public void play(int turn) throws IOException {
		int currentTurn = 0;
		int ballLooperSpeed = 0;
		while (currentTurn < turn) {
			// move P1 Racket, move P2 Racket, move ball => ball interaction
			// logique
			String response = "";
			
			while (this.field.getBall().getY() != -1 
					&& this.field.getBall().getY() != maxWidth) {
				// Wait P1 call
				if (GameDataUtil.isSocketDatasOk(response = this.client1.listenStringResponse())) {
					this.field.getPlayer1().getRacket().setX(
							Integer.valueOf(response.split(GameDataUtil.GAME_TURN_PREFIX)[1]));
				}
				// Wait P2 call
				if (GameDataUtil.isSocketDatasOk(response = this.client2.listenStringResponse())) {
					this.field.getPlayer2().getRacket().setX(
							Integer.valueOf(response.split(GameDataUtil.GAME_TURN_PREFIX)[1]));
				}
				
				// Move ball
//				if (ballLooperSpeed%3==0) {
					ballMover(this.field.getBall());
					ballLooperSpeed = 0;
//				}
				
				String field = new FieldAssembler().FieldToDTO(this.field).toStringElement();
				this.client1.sendData(field);
				this.client2.sendData(field);
				
				ballLooperSpeed++;
				
				System.out.println("Game " + currentTurn + " loop " + ballLooperSpeed);
			}

			this.field.setPartyPlayed(this.field.getPartyPlayed() + 1);
			
			if (this.field.getBall().getY() == -1) {
				this.field.getPlayer2().setWinned(this.field.getPlayer2().getWinned()+1);
			}else {
				this.field.getPlayer1().setWinned(this.field.getPlayer1().getWinned()+1);
			}
			
			currentTurn++;
		}
	}

	private void ballMover(Ball ball) {
		
		if (ball.getX()+ball.getDirectionX() < 0) {
			ball.setDirectionX(+1);
		}else if (ball.getX()+ball.getDirectionX() >= maxHeight) {
			ball.setDirectionX(-1);
		}
		
		if (ball.getY()+ball.getDirectionY() < 0) {
			ball.setDirectionY(+1);
		}else if (ball.getY()+ball.getDirectionY() >= maxWidth) {
			ball.setDirectionY(-1);
		}
		
		ball.setX(ball.getX()+ball.getDirectionX());
		ball.setY(ball.getY()+ball.getDirectionY());
	}
}
