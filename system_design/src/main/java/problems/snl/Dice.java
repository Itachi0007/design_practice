package problems.snl;

import java.util.Random;

// Dice will be singleton as we dont need more than 1 dice to play the game
public class Dice {
    private static Dice dice;

    // A private constructor to limit external services from creating more dies
    private Dice(){};

    public static Dice getInstance(){
        if(dice==null) {
            dice = new Dice();
        }
        return dice;
    }

    public int roll() {
        Random rand = new Random();
        return rand.nextInt(6) + 1;
    }
}
