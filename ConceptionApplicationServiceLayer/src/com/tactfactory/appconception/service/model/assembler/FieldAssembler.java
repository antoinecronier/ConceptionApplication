package com.tactfactory.appconception.service.model.assembler;

import com.tactfactory.appconception.model.Ball;
import com.tactfactory.appconception.model.Field;
import com.tactfactory.appconception.model.Player;
import com.tactfactory.appconception.model.Racket;
import com.tactfactory.appconception.service.model.dto.FieldDTO;

public class FieldAssembler {

	public FieldDTO FieldToDTO(Field field){
		FieldDTO dto = new FieldDTO();
		
		dto.setBallDirectionX(String.valueOf(field.getBall().getDirectionX()));
		dto.setBallDirectionY(String.valueOf(field.getBall().getDirectionY()));
		dto.setBallX(String.valueOf(field.getBall().getX()));
		dto.setBallY(String.valueOf(field.getBall().getY()));
		
		dto.setPlayer1Pseudo(field.getPlayer1().getPseudo());
		dto.setPlayer1RacketSize(String.valueOf(field.getPlayer1().getRacket().getSize()));
		dto.setPlayer1RacketX(String.valueOf(field.getPlayer1().getRacket().getX()));
		dto.setPlayer1RacketY(String.valueOf(field.getPlayer1().getRacket().getY()));
		
		dto.setPlayer2Pseudo(field.getPlayer2().getPseudo());
		dto.setPlayer2RacketSize(String.valueOf(field.getPlayer2().getRacket().getSize()));
		dto.setPlayer2RacketX(String.valueOf(field.getPlayer2().getRacket().getX()));
		dto.setPlayer2RacketY(String.valueOf(field.getPlayer2().getRacket().getY()));
		
		return dto;
	}
	
	public Field DTOToField(FieldDTO dto){
		Field field = new Field();
		
		Ball ball = new Ball();
		ball.setDirectionX(Integer.valueOf(dto.getBallDirectionX()));
		ball.setDirectionY(Integer.valueOf(dto.getBallDirectionY()));
		ball.setX(Integer.valueOf(dto.getBallX()));
		ball.setY(Integer.valueOf(dto.getBallY()));
		field.setBall(ball);
		
		Player player1 = new Player();
		player1.setPseudo(dto.getPlayer1Pseudo());
		Racket racket1 = new Racket();
		racket1.setSize(Integer.valueOf(dto.getPlayer1RacketSize()));
		racket1.setX(Integer.valueOf(dto.getPlayer1RacketX()));
		racket1.setY(Integer.valueOf(dto.getPlayer1RacketY()));
		player1.setRacket(racket1);
		field.setPlayer1(player1);
		
		Player player2 = new Player();
		player2.setPseudo(dto.getPlayer2Pseudo());
		Racket racket2 = new Racket();
		racket2.setSize(Integer.valueOf(dto.getPlayer2RacketSize()));
		racket2.setX(Integer.valueOf(dto.getPlayer2RacketX()));
		racket2.setY(Integer.valueOf(dto.getPlayer2RacketY()));
		player2.setRacket(racket2);
		field.setPlayer2(player2);
		
		return field;
	}
}
