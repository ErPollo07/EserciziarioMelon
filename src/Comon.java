import java.util.Random;

import static java.lang.Math.random;

public class Comon {
    public static void main(String[] args) { }

    /**
     * Clear screen on cmd
     * On intellij print a square
     * */
    private static void ClrScr() {

        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e ) {
            e.printStackTrace();
        }
    }

    /**
     * Wait for a number of specified second
     * @param milliSecond milliseconds to wait
     * */
    private static void Wait(int milliSecond) {
        try {
            Thread.sleep(milliSecond);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /** Evaluate a numeber if it is prime
     * @param n number to evaluate if it is prime
     * */
    private static boolean IsPrime(int n) {

        boolean flagPrimo = true;

        for (int j = 2; j <= n / 2 && flagPrimo; j++) {

            if (n % j == 0)
                flagPrimo = false;
        }

        return flagPrimo;
    }

}
