package problems.snl;

import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {

        System.out.println("Enter number of rolls - ");
        // Using Console to input data from user
        Scanner scan = new Scanner(System.in);
        int snakesCount = scan.nextInt();

        for(int i=0;i<snakesCount;i++) {
            // for now just rolling the dice N times
            System.out.println(Dice.getInstance().roll());
        }

    }
}
