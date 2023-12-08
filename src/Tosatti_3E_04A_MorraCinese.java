
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

public class Tosatti_3E_04A_MorraCinese {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String inputPlayer1;
        String inputPlayer2;

        boolean interruptGame = false;

        System.out.println("MORRA CINESE");


        do {
            ClrScr();

            System.out.println("E' il turno del gicatore 1");
            System.out.println("""
                    Scegliere cosa inserire:
                    \t1. A - carta
                    \t2. S - sasso
                    \t3. D - forbici
                    """);

            // Chiedo di inserire la scelta
            System.out.println("Inserire la scelta: ");
            inputPlayer1 = scanner.next().toUpperCase();

        } while (!(inputPlayer1.equals("A") || inputPlayer1.equals("S") || inputPlayer1.equals("D") || inputPlayer1.equals("X")));

        // se il giocatore 1 non preme x allora vai avanti
        if (!inputPlayer1.equals("X")) {
            // Perndo l'input del secondo giocatore
            do {
                ClrScr();

                System.out.println("E' il turno del gicatore 2");
                System.out.println("Scegliere cosa inserire:" +
                        "\n\t1. J - carta" +
                        "\n\t2. K - sasso" +
                        "\n\t3. L - forbici\n");

                // Chiedo di inserire la scelta
                System.out.println("Inserire la scelta: ");
                inputPlayer2 = scanner.next().toUpperCase();

            } while (!(inputPlayer2.equals("J") || inputPlayer2.equals("K") || inputPlayer2.equals("L") || inputPlayer2.equals("X")));

            if (inputPlayer2.equals("X"))
                interruptGame = true;

            // Calcola tutti i vari casi
            if (!interruptGame) {
                if ((inputPlayer1.equals("A") && inputPlayer2.equals("J")) || (inputPlayer1.equals("S") && inputPlayer2.equals("K")) || (inputPlayer1.equals("D") && inputPlayer2.equals("L"))) {
                    System.out.println("Pareggio");
                }

                // Valuto tutti i casi in cui il giocatre 1 vince la partita
                else if ((inputPlayer1.equals("S") && inputPlayer2.equals("L")) ||
                        (inputPlayer1.equals("A") && inputPlayer2.equals("K")) ||
                        (inputPlayer1.equals("D") && inputPlayer2.equals("J"))) {

                    System.out.println("Il giocatore 1 a vinto");
                }
                // Se la partita non finisce in pareggio e non vince il giocatore 1 allora vince il giocatore 2
                else {
                    System.out.println("Il giocatore 2 ha vinto");
                }
            } else {
                interruptGame = false;
            }
        }
    }

    private static void ClrScr() {

        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e ) {
            e.printStackTrace();
        }
    }
}
