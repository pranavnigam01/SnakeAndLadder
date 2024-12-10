package com.tutofox.demo;

import lombok.extern.slf4j.Slf4j;

import java.util.Queue;

@Slf4j
public class SnakeAndLadderGame {

    private Queue<Player> players;
    private Board board;
    private Dice dice;

    private boolean gameCompleted;

    public SnakeAndLadderGame(Queue<Player> players, Board board, Dice dice) {
        this.players = players;
        this.board = board;
        this.dice = dice;
        this.gameCompleted = false;
        playGame();
    }

    private void playGame() {
        Player player = null;
        while(!gameCompleted) {
            player = players.poll();
            System.out.print("player {} is making move \n", player.getName());
            int diceValue = dice.rollDice();
            System.out.print("value of the dice is {}", diceValue);
            this.calculateEndPosition(player, diceValue);
            if(player.getPosition() == board.getSize())
                this.gameCompleted = true;
            players.add(player);
        }
        System.out.print("{} has won the game", player.getName());

    }

    private void calculateEndPosition(Player player, int diceValue) {
        int intermittentFinalPosition = player.getPosition() + diceValue;
        int finalValue = intermittentFinalPosition;
        do {
            if (intermittentFinalPosition > board.getSize()) {
                return;
            }
            if (board.getHurdleMap().containsKey(intermittentFinalPosition)) {
                finalValue = board.getHurdleMap().get(intermittentFinalPosition).getEndPosition();
            }
            player.setPosition(finalValue);
        } while(board.getHurdleMap().containsKey(player.getPosition()));
        System.out.print("player {} is now on position {}", player.getName(),player.getPosition() );
    }
}
