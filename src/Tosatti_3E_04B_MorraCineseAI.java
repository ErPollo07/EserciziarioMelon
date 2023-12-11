
/* SASSO CARTA FORBICI

Regole:

carta batte sasso
sasso batte forbici
forbici batte carta

INPUT DEI GIOCATORI
1. A - carta S - sasso D - forbici
2. J - carta K - sasso L - forbici
*/

import java.util.Scanner;
import java.util.Random;

public class Tosatti_3E_04B_MorraCineseAI {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();


        String inputPlayer1; // input player 1
        String inputPlayer2; // input player 2

        boolean interruptGame = false; // var per capire se il gioco é stato interrotto da uno dei due giocatori

        String _pause; // Carattere di pausa alla fine di ogni partita

        int counterPartite = 0; // contatore delle partite

        System.out.println("MORRA CINESE");

        System.out.print("\nPremere invio per continuare ");
        _pause = scanner.nextLine();

        // Ciclo per ripetere la partita
        do {
            // Aggiorno il counter delle partite
            counterPartite++;

            // Prendo l'input del giocatore 1
            do {
                ClrScr();

                // Mostro la partita corente
                System.out.println("PARTITA " + counterPartite + "\n");

                // Menu di scelta del giocatore 1
                System.out.println("E' il turno del gicatore 1");
                System.out.println(
                    "Scegliere cosa inserire:" +
                    "\n\t1. A - carta" +
                    "\n\t2. S - sasso" +
                    "\n\t3. D - forbici\n"
                    );

                // Chiedo di inserire la scelta
                System.out.println("Inserire la scelta: ");
                inputPlayer1 = scanner.next().toUpperCase();

            } while (!(inputPlayer1.equals("A") || inputPlayer1.equals("S") || inputPlayer1.equals("D") || inputPlayer1.equals("X")));

            // se il giocatore 1 non preme x allora vai avanti
            if (!inputPlayer1.equals("X")) {

                // Prendo il valore random tra le lettere disponibili
                String[] x = {"J", "K", "L"}; // Lista di valori disponibili
                int _randomIndex = random.nextInt(x.length); // Prendo un random index
                inputPlayer2 = x[_randomIndex];

                // controllo se il giocatore 2 ha inserito la X se si non fa il calcolo di chi vince
                if (inputPlayer2.equals("X"))
                    interruptGame = true;

                // Calcola tutti i vari casi
                if (!interruptGame) {

                    // pareggio
                    if ((inputPlayer1.equals("A") && inputPlayer2.equals("J")) || (inputPlayer1.equals("S") && inputPlayer2.equals("K")) || (inputPlayer1.equals("D") && inputPlayer2.equals("L"))) {
                        System.out.println("Pareggio");
                    }

                    // Vittoria giocatore 1
                    else if ((inputPlayer1.equals("S") && inputPlayer2.equals("L")) ||
                            (inputPlayer1.equals("A") && inputPlayer2.equals("K")) ||
                            (inputPlayer1.equals("D") && inputPlayer2.equals("J"))) {

                        System.out.println("\nIl giocatore 1 a vinto!!");
                    }

                    // Vittoria giocatore 2
                    else {
                        System.out.println("\nIl giocatore 2 ha vinto!!");
                    }

                    System.out.print("\nPremere invio per continuare ");
                    _pause = scanner.nextLine();
                    _pause = scanner.nextLine();
                }
            }
            else {
                interruptGame = true;
            }
        } while (!interruptGame); // se nesuno ha inserito il carattere X allora il gioco continua


        System.out.println("\nGioco finito.");

        // stampo quante partite sono state completate
        System.out.println("Partite completate: " + (counterPartite - 1));
    }

    private static void ClrScr() {

        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e ) {
            e.printStackTrace();
        }
    }
}
