import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.Callable;

public class Tosatti_3E_12B_RollDadoMenu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberP1 = 0, numberP2 = 0;
        int mod;

        boolean interruptGame = false;

        String namePlayer1 = "Player1", namePlayer2 = "Player2";
        String _pause;

        do {
            ClrScr();

            printMenu();

            System.out.println("Scegli la modalita' di gioco: ");
            mod = scanner.nextInt();

            switch (mod) {
                case 1:

                    // Take name of player 1
                    System.out.println("Player 1 inserisci il tuo nome: ");
                    namePlayer1 = scanner.next();

                    // Take name of player 2
                    System.out.println("Player 2 inserisci il tuo nome: ");
                    namePlayer2 = scanner.next();

                    // Take number of player 1
                    numberP1 = simulazioneRoll(namePlayer1); // take number of player 1

                    System.out.println("Premi invio per continuare");
                    _pause = scanner.nextLine(); // Pulizia del buffer
                    _pause = scanner.nextLine();

                    // Take number of player 2
                    numberP2 = simulazioneRoll(namePlayer2); // take number of player 2

                    Wait(1500);

                    break;
                case 2:

                    namePlayer2 = "Bot";

                    // Take name of player
                    System.out.println("Player inserisci il tuo nome: ");
                    namePlayer1 = scanner.next();

                    // Simulate the dice roll
                    numberP1 = simulazioneRoll(namePlayer1); // take number of player 1

                    System.out.println("Premi invio per continuare");
                    _pause = scanner.nextLine(); // Pulizia del buffer
                    _pause = scanner.nextLine();

                    numberP2 = simulazioneRoll(namePlayer2); // Take the number of player 2 (bot)

                    Wait(1500);

                    break;
                case 3:
                        interruptGame = true;
                    break;
                default:
                    System.out.println("Scelta non disponibile.");
                    break;
            }

            if (!interruptGame) {
                if (numberP1 == numberP2) {
                    System.out.println("Parita'");
                } else if (numberP1 > numberP2) {
                    System.out.println("Ha vinto " + namePlayer1);
                } else {
                    System.out.println("Ha vinto " + namePlayer2);
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
                if (player.equals("Bot")) System.out.println("Al " + player + " e' uscito: ");
                else System.out.println("Al giocatore " + player + " e' uscito: ");

                /* Another way to do the if-else statement all in onu line of code
                System.out.println(player.equals("Bot") ?
                                "Al " + player + " e' uscito: " :
                                "Al giocatore " + player + " e' uscito: "
                );
                */

                valoreFaccia = random.nextInt(0, 6) + 1;
                FacceDado(valoreFaccia);
            } else {
                FacceDado(i);
                Wait(50);
                ClrScr();
            }
        }

        return valoreFaccia;
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

    private static void printMenu() {
        System.out.println(".======== APP Gara Dadi ========.");
        System.out.println("|  [1]-Sfida tra due giocatori  |");
        System.out.println("|  [2]-Sfida contro il computer |");
        System.out.println("|  [3]-Fine                     |");
        System.out.println("*===============================*\n");
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
