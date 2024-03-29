import java.util.Random;
import java.util.Scanner;

public class Tosatti_3E_12C_RollDadoGenericMenu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = new int[2];
        int mod;

        String[] playersNames = new String[2];
        String _pause;

        boolean interruptGame = false;

        String[] menuOptions = {
                "APP Gara Dadi",
                "[1]-Sfida tra due giocatori",
                "[2]-Sfida contro il computer",
                "[3]-Fine"
        };


        do {
            ClrScr();

            mod = printMenu(menuOptions, scanner);


            switch (mod) {
                case 1:

                    // Take name of player 1
                    System.out.println("Player 1 inserisci il tuo nome: ");
                    playersNames[0] = scanner.next();

                    // Take name of player 2
                    System.out.println("Player 2 inserisci il tuo nome: ");
                    playersNames[1] = scanner.next();

                    // Take number of player 1
                    numbers[0] = simulazioneRoll(playersNames[0]); // take number of player 1
                    System.out.println("Il player " + playersNames[0] + " e' uscito: ");
                    FacceDado(numbers[0]);

                    System.out.println("Premi invio per continuare");
                    _pause = scanner.nextLine(); // Pulizia del buffer
                    _pause = scanner.nextLine();

                    // Take number of player 2
                    numbers[1] = simulazioneRoll(playersNames[1]); // take number of player 2
                    System.out.println("Il player " + playersNames[1] + " e' uscito: ");
                    FacceDado(numbers[1]);

                    Wait(1500);

                    break;
                case 2:

                    playersNames[1] = "Bot"; // The player 2 become the bot

                    // Take name of player
                    System.out.println("Player inserisci il tuo nome: ");
                    playersNames[0] = scanner.next();

                    // Simulate the dice roll
                    numbers[0] = simulazioneRoll(playersNames[0]); // take number of player 1
                    System.out.println("Al player e' uscito: ");
                    FacceDado(numbers[0]); // Print the corresponding face of the dice based on the random number of player 1


                    System.out.println("Premi invio per continuare");
                    _pause = scanner.nextLine(); // Pulizia del buffer
                    _pause = scanner.nextLine();

                    numbers[1] = simulazioneRoll(playersNames[1]); // Take the number of player 2 (bot)
                    System.out.println("Al bot e' uscito: ");
                    FacceDado(numbers[1]);

                    Wait(1500);

                    break;
                case 3:
                    interruptGame = true;
                    break;
                default:
                    System.out.println("Scelta non disponibile.");
                    break;
            }

            if (!interruptGame) { // calculate the winning if the game isn't interrupted
                if (numbers[0] == numbers[1]) {
                    System.out.println("Parita'");
                } else if (numbers[0] > numbers[1]) {
                    System.out.println("Ha vinto " + playersNames[0]);
                } else {
                    System.out.println("Ha vinto " + playersNames[1]);
                }

                // Pause before start another game
                System.out.println("Premi invio per continuare");
                _pause = scanner.nextLine();
            }
        } while (!interruptGame);
    }

    private static int simulazioneRoll(String player) {
        Random random = new Random();

        int valoreFaccia = 0;

        for (int i = 0; i <= 7; i++) {

            if (i == 7) {
                valoreFaccia = random.nextInt(0, 6) + 1;
            } else {
                FacceDado(i); // Simulate the roll
                Wait(50);
                ClrScr();
            }
        }

        return valoreFaccia;
    }

    private static int printMenu(String[] option, Scanner scanner) {

        int choice;

        do {

            ClrScr();

            System.out.println("=============");
            System.out.println(option[0]);
            System.out.println("=============");

            for (int i = 1; i < option.length; i++) {
                System.out.println(option[i]);
            }

            System.out.println("\nInserisci la scelta: ");
            choice = scanner.nextInt();

            if (choice < 1 || choice > option.length - 1) {
                System.out.println("\nScelta errata");
                Wait(1000);
            }


        } while (choice < 1 || choice > option.length - 1);

        return choice;
    }

    private static void FacceDado(int valFaccia) {
        switch (valFaccia) {
            case 1:
                System.out.println("\t\t\t ╔═════════╗");
                System.out.println("\t\t\t ║         ║");
                System.out.println("\t\t\t ║    o    ║");
                System.out.println("\t\t\t ║         ║");
                System.out.println("\t\t\t ╚═════════╝");
                break;
            case 2:
                System.out.println("\t\t\t ╔═════════╗");
                System.out.println("\t\t\t ║ o       ║");
                System.out.println("\t\t\t ║         ║");
                System.out.println("\t\t\t ║       o ║");
                System.out.println("\t\t\t ╚═════════╝");
                break;
            case 3:
                System.out.println("\t\t\t ╔═════════╗");
                System.out.println("\t\t\t ║ o       ║");
                System.out.println("\t\t\t ║    o    ║");
                System.out.println("\t\t\t ║       o ║");
                System.out.println("\t\t\t ╚═════════╝");
                break;
            case 4:
                System.out.println("\t\t\t ╔═════════╗");
                System.out.println("\t\t\t ║ o     o ║");
                System.out.println("\t\t\t ║         ║");
                System.out.println("\t\t\t ║ o     o ║");
                System.out.println("\t\t\t ╚═════════╝");
                break;
            case 5:
                System.out.println("\t\t\t ╔═════════╗");
                System.out.println("\t\t\t ║ o     o ║");
                System.out.println("\t\t\t ║    o    ║");
                System.out.println("\t\t\t ║ o     o ║");
                System.out.println("\t\t\t ╚═════════╝");
                break;
            case 6:
                System.out.println("\t\t\t ╔═════════╗");
                System.out.println("\t\t\t ║ o     o ║");
                System.out.println("\t\t\t ║ o     o ║");
                System.out.println("\t\t\t ║ o     o ║");
                System.out.println("\t\t\t ╚═════════╝");
                break;
        }
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
