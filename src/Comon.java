import java.util.Random;
import java.util.Scanner;

import static java.lang.Math.random;

public class Comon {
    public static void main(String[] args) {
        // USEFULL LINKS:
        //   1. https://www.asciitable.com/
        //          For all the ascii code
    }

    public static void array2D() {
        // r = raw
        // c = column
        //                         r  c
        int[][] array2d = new int[10][5];

        // Print array 2d
        for (int i = 0; i < array2d.length; i++) {
            System.out.println();
            for (int j = 0; j < array2d[i].length; j++) {
                System.out.print(array2d[i][j] + " ");
            }
        }

        // Another method to declare the value of the array
        int[][] array2d2 = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
    }

    /**
     * Copy this in main to get a pause
     * */
    private static void pause() {
        Scanner scanner = new Scanner(System.in);

        String _pause;

        System.out.println("Premi invio per continuare");
        _pause = scanner.nextLine(); // Pulizia del buffer
        _pause = scanner.nextLine();
    }

    /**
     * Clear screen on cmd
     * On intellij print a square
     * */
    private static void clrScr() {

        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e ) {
            e.printStackTrace();
        }
    }

    /**
     * Wait for a number of specified milliseconds
     * @param milliSecond milliseconds to wait
     * */
    private static void wait(int milliSecond) {
        try {
            Thread.sleep(milliSecond);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /** Evaluate a numeber if it is prime
     * @param n number to evaluate if it is prime
     * */
    private static boolean isPrime(int n) {

        boolean flagPrimo = true;

        for (int j = 2; j <= n / 2 && flagPrimo; j++) {

            if (n % j == 0)
                flagPrimo = false;
        }

        return flagPrimo;
    }

}
