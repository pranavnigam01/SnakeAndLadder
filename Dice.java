package com.tutofox.demo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Random;

@Getter
@AllArgsConstructor
public class Dice {

    private int minValue;

    private int maxValue;

    private Random random;

    public int rollDice() {
        return random.nextInt(this.maxValue);
    }
}
