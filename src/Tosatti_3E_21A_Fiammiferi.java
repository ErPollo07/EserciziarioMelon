import java.util.Scanner;
import static Utility.Tools.printFiammiferi;
import static Utility.Tools.printMenu;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    static String[] players = new String[2];
    static int indexPlayers = 0;
    static int nFiammiferi = 21;


    public static void main(String[] args) {

        String[] principalMenu = {
                "Fiammiferi",
                "Giocare contro giocatore",
                "Pc vince sempre",
                "Quit"
        };

        int nFiamTogliere = 0;

        // print menu
        // switch della scelta
        switch (printMenu(principalMenu)) {
            case 1:
                System.out.println("Giocatore 1 inserisci il tuo nome: ");
                players[0] = scanner.next();

                System.out.println("Giocatore 1 inserisci il tuo nome: ");
                players[1] = scanner.next();

                do {
                    System.out.println(players[indexPlayers] + " E' IL TUO TURNO");
                    // get the number of player 1

                    printFiammiferi(nFiammiferi);

                    // Ask the user how many matches want to extract
                    do {
                        System.out.println("Quanti fiamiferi vuoi togliere? MAX 3.");
                        nFiamTogliere = Integer.parseInt(scanner.next());

                        if (nFiamTogliere < 1 || nFiamTogliere > 3) {
                            System.out.println("Devi inserire un numero tra 1 e 3 compresi.");
                        }
                    } while (nFiamTogliere < 1 || nFiamTogliere > 3);

                    nFiammiferi -= nFiamTogliere;

                    // Update the index of the player which has to take the matches
                    if (indexPlayers == 0) {
                        indexPlayers++;
                    } else {
                        indexPlayers = 0;
                    }
                } while (nFiammiferi > 3);

                System.out.println("HA VINTO IL GIOCATORE " + players[indexPlayers]);

                break;
            case 2:
                System.out.println("Giocatore 1 inserisci il tuo nome: ");
                players[0] = scanner.next();

                players[1] = "PC";

                do {
                    System.out.println(players[indexPlayers] + " E' IL TUO TURNO");
                    // get the number of player 1

                    printFiammiferi(nFiammiferi);

                    if (players[indexPlayers].equals("Bot")) {

                    }

                    // Ask the user how many matches want to extract
                    do {
                        System.out.println("Quanti fiamiferi vuoi togliere? MAX 3.");
                        nFiamTogliere = Integer.parseInt(scanner.next());

                        if (nFiamTogliere < 1 || nFiamTogliere > 3) {
                            System.out.println("Devi inserire un numero tra 1 e 3 compresi.");
                        }
                    } while (nFiamTogliere < 1 || nFiamTogliere > 3);

                    nFiammiferi -= nFiamTogliere;

                    // Update the index of the player which has to take the matches
                    if (indexPlayers == 0) {
                        indexPlayers++;
                    } else {
                        indexPlayers = 0;
                    }
                } while (nFiammiferi > 3);
                break;
            case 3:
                System.out.println("Procedura di spegnimento attivata");
                break;
            default:
                break;
        }


        // calcolo della vittoria solo per le prime due opzioni di gioco
        // per la terza farlo dentro allo switch
    }
}
