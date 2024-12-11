package problems.snl;

public class Driver {
    public static void main(String[] args) {

        // Using Console to input data from user
        System.out.println("Enter number of rolls: ");
        Integer snakesCount = Integer.valueOf(System.console().readLine());
        for(int i=0;i<snakesCount;i++) {
            // for now just rolling the dice N times
            System.out.println(Dice.getInstance().roll());
        }

    }
}
