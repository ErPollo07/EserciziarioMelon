package Utility;

import java.util.Scanner;

public class Tools {
    static Scanner scanner = new Scanner(System.in);
    public static void printFiammiferi(int nFiammiferi) {
        for (int i = 0; i < nFiammiferi; i++) {
            System.out.print("* ");
        }

        // Print a new line
        System.out.println();

        for (int i = 0; i < nFiammiferi; i++) {
            System.out.print("| ");
        }

        System.out.println();
    }

    public static int printMenu(String opzioni[])
    {
        int scelta;

        do {
            for (int i = 0; i < opzioni[0].length(); i++) {
                System.out.print("-");
            }
            System.out.println();

            System.out.println(opzioni[0]);

            for (int i = 0; i < opzioni[0].length(); i++) {
                System.out.print("-");
            }
            System.out.println();

            for (int i=1; i < opzioni.length; i++) {
                System.out.println("[" + i + "] - " + opzioni[i]);
            }

            scelta = Integer.parseInt(scanner.nextLine());

            if ((scelta < 1 ) || (scelta > opzioni.length - 1)) {
                System.out.println("Opzione Sbagliata");
            }
        }
        while ((scelta < 1 ) || (scelta > opzioni.length - 1));

        return scelta;
    }
}
