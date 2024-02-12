import java.util.Random;
import java.util.Scanner;

public class Tosatti_3E_15A_EstrazioniLotto {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] menuOptions = {
                "Lotto",
                "[1] - Estrazioni ruota di Venezia",
                "[2] - Giocata utente",
                "[3] - Verifica vincita",
                "[4] - Visualizza giocate",
                "[5] - EXIT"
        };

        // il giocatore punta 5 numeri sulla ruota di venezia
        // Lista spesa:
        // - array 5 elementi
        // - controllo che i numeri siano compresi da 1 a 90
        // - controllo se i numeri non si ripetano
        // - controllo se i numeri sono solo 5 e non di più o di meno
        // visuallizza giocate lista spesa:
        // - menu di scelta
        // - opzioni2(venezia, giocatore)

        int[] extractNumbers = new int[5];
        int[] playerNumbers = new int[5];
        int choice;
        boolean interruptGame = false;

        String _pause;

        do {
            choice = printMenu(menuOptions);

            switch (choice) {
                case 1:
                    extractNumbers = ruotaEstratta();
                    System.out.println("La ruota e' stata estratta");
                    break;
                case 2:
                    playerNumbers = gioacataUtente();
                    break;
                case 3:
                    System.out.println(verificaVincita(extractNumbers, playerNumbers));
                    break;
                case 4:
                    visuallizza(extractNumbers, playerNumbers);
                    break;
                case 5:
                    interruptGame = true;
                    break;
                default:
                    System.out.println("Scelta errata");
                    break;
            }

            System.out.println("\nPremi invio per continuare");
            _pause = scanner.nextLine();
            _pause = scanner.nextLine();
        } while (!interruptGame);
    }

    private static int[] gioacataUtente() {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[5];
        boolean[] n = new boolean[90];

        for (int i = 0; i < numbers.length; i++) {
            System.out.println("inserisci un numero: ");
            numbers[i] = scanner.nextInt();

            // if in the array of boolean there is a true it's indicate that there is already a number
            while (n[numbers[i] - 1]) {
                // Ask to reinsert the number
                System.out.println("Numero gia inserito. Iserisci un altro numero: ");
                numbers[i] = scanner.nextInt();
            }

            // Set the correct pos in the array to true to indicate that there is the number
            n[numbers[i] - 1] = true;
        }

        return numbers;
    }

    private static String verificaVincita(int[] ruota, int[] player) {
        int counter = 0;
        String victoryMessage = "";

        // Check for every number in array if there is someone which is equal to another one
        for (int i = 0; i < ruota.length; i++) {
            // Update the counter if the
            for (int m = 0; m < player.length; m++) {
                if (ruota[i] == player[m]) counter++;
            }
        }

        // For every combination there is a different victory message
        switch (counter) {
            case 1:
                victoryMessage = "Hai indovinato un numero";
                break;
            case 2:
                victoryMessage = "Hai fatto ambo";
                break;
            case 3:
                victoryMessage = "Hai fatto terna";
                break;
            case 4:
                victoryMessage = "Hai fatto qauterna";
                break;
            case 5:
                victoryMessage = "Hai fatto cinquina";
                break;
            default:
                victoryMessage = "Non hai indovinato";
                break;
        }

        return victoryMessage;
    }

    private static void visuallizza(int[] ruota, int[] player) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        System.out.println("Valori array: ");

        // Ask which array the user want to display
        String[] opzioni = {
                "cosa vuoi stampare",
                "[1] - Ruota",
                "[2] - Giocatore"
        };

        choice = printMenu(opzioni);

        switch (choice) {
            case 1:
                for (int i:ruota) {
                    System.out.printf("%d ", i);
                }
                break;
            case 2:
                for (int i:player) {
                    System.out.printf("%d ", i);
                }
                break;
        }
    }

    public static int[] ruotaEstratta() {
        int[] numeri = new int[5];
        int minValue = 1, maxValue = 90;

        for (int i = 0; i < numeri.length; i++) {
            numeri[i] = valoreRandom(minValue, maxValue); // Assign random value to numeri[i]

            if (i > 0) valueChecker(numeri, i, minValue, maxValue); // check if the value isn't repeating
        }

        return numeri; // return array
    }

    // Check if the value is available
    private static void valueChecker(int[] array, int i, int minValue, int maxValue) {
        for (int k = 0; k < i; k++) {
            // If the value is already in the array, reassign it and recheck all array
            if (array[i] == array[k]) {
                array[i] = valoreRandom(minValue, maxValue); // Assign another random value to array[i]
                k = -1; // Restart the check
            }
        }
    }

    private static int valoreRandom(int minValue, int maxValue)
    {
        Random casuale = new Random();

        return  casuale.nextInt(minValue,maxValue+1);
    }

    private static int printMenu(String[] option) {
        Scanner scanner = new Scanner(System.in);

        int choiceMenu;

        do {
            ClrScr();

            System.out.println("=============");
            System.out.println(option[0]);
            System.out.println("=============");

            for (int i = 1; i < option.length; i++) {
                System.out.println(option[i]);
            }

            System.out.println("\nInserisci la scelta: ");
            choiceMenu = scanner.nextInt();

            if (choiceMenu < 1 || choiceMenu > option.length - 1) {
                System.out.println("\nScelta errata");
                Wait(1000);
            }
        } while (choiceMenu < 1 || choiceMenu > option.length - 1);

        return choiceMenu;
    }

    private static void ClrScr() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void Wait(int milliSecond) {
        try {
            Thread.sleep(milliSecond);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}