package com.tutofox.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.parameters.P;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;


@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		Player player1 = new Player("prnav", 0);
		Player player2 = new Player("player2", 0);

		Queue<Player> players = new LinkedList<>();
		players.add(player1);
		players.add(player2);

		Hurdle hurdle = new Hurdle(HurdleType.LADDER, 5,20);
		Hurdle hurdle1 = new Hurdle(HurdleType.LADDER, 16,28);
		Hurdle hurdle2 = new Hurdle(HurdleType.LADDER, 60,81);
		Hurdle hurdle3 = new Hurdle(HurdleType.LADDER, 80,90);
		Hurdle hurdle4 = new Hurdle(HurdleType.SNAKE, 99,6);
		Hurdle hurdle5 = new Hurdle(HurdleType.LADDER, 54,55);
		Hurdle hurdle6 = new Hurdle(HurdleType.LADDER, 32,20);

		List<Hurdle> hurdles = List.of(hurdle, hurdle1,hurdle2, hurdle3, hurdle4, hurdle5, hurdle6);

		//Board
		Board board = new Board(100,hurdles);
		Dice dice = new Dice(1,6,new Random());
		SnakeAndLadderGame snakeAndLadderGame = new SnakeAndLadderGame(players,board, dice);

	}
}
