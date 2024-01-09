import java.util.Scanner;

public class Tosatti_3E_11A_Esercizionatalizio {
    public static void main(String[] args) {
        Scanner keyboard= new Scanner(System.in);

        int scelta;

        do {
            PrintMenu();

            System.out.print("Inserire il lavoro che vuoi svolgere: ");
            scelta=keyboard.nextInt();

        } while (scelta<1 || scelta>3);

        switch (scelta) {
            case 1:
                Lavoro1(); break;
            case 2:
                Lavoro2(); break;
            case 3:
                Lavoro3(); break;
        }
    }

    private static void PrintMenu() {

        // Stampo a schermo il menú
        System.out.println("""
                \n\n
                |*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*|
                *                ~ BENVENUTI ~                  *
                |    Lavoro 1 = UOVA            - Scrivi '1'    |
                *    Lavoro 2 = HAMBURGHERIA    - Scrivi '2'    *
                |    Lavoro 3 = INCASSI         - Scrivi '3'    |
                *                                               *
                |*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*|
                """
        );

    }

    private static int Lavoro1() {
        Scanner in = new Scanner(System.in);

        int prezzoUovo = 4;
        int incasso = 0;
        String _pause;

        System.out.println("hai scelto lavoro 1");
        do {
            // Aggiorno l'incasso
            incasso = incasso + prezzoUovo;

            System.out.println("Premere invio se vuoi continuare oppure premere q per uscire");
            _pause = in.nextLine();

            // se l'utente preme q allora l'ultimo ciclo non viene contato
            if (_pause.equals("q")) incasso -= prezzoUovo;
        }
        while(!_pause.equals("q"));

        return incasso;
    }

    private static int Lavoro2() {
        Scanner scanner = new Scanner(System.in);

        int totaleScontato;
        int numeroHamburgerVegani = 13, numeroHamburgerRenna = 26, numeroBevandeAnalcoliche = 2, numeroBevandeAlcoliche = 4;
        int prezzoTot = 0;

        // Faccio inserire il numero di hamburger vegani
        System.out.print("Inserisci il numero di hamburger vegani: ");
        numeroHamburgerVegani = scanner.nextInt();

        // Faccio inserire il numero di hamburger di renna
        System.out.print("Inserisci il numero di hamburger di renna: ");
        numeroHamburgerRenna = scanner.nextInt();

        // Faccio inserire il numero di bevande alcoliche
        System.out.print("Inserisci il numero di bevande analcoliche: ");
        numeroBevandeAnalcoliche = scanner.nextInt();

        // Faccio inserire il numero di bevande analoliche
        System.out.print("Inserisci il numero di bevande alcoliche: ");
        numeroBevandeAlcoliche = scanner.nextInt();

        // Calcolo del prezzo da pagare
        prezzoTot = (numeroHamburgerVegani * 13) + (numeroHamburgerRenna * 26) + (numeroBevandeAnalcoliche * 2) + (numeroBevandeAlcoliche * 5);

        // Se il prezzo é maggiore di 10 euro applico lo sconto
        if (prezzoTot > 10.0) {
            double sconto = prezzoTot * 0.15;
            prezzoTot -= sconto;
            System.out.println("Totale scontato: " + prezzoTot + " euro");
        }
        else {
            System.out.println("Totale: " + prezzoTot + " euro");
        }

        return prezzoTot;
    }

    private static void Lavoro3() {

        int totale = Lavoro1() + Lavoro2();

        // Stampo lo scontrino
        System.out.println("Il totale da pagare e': " + totale);
    }

}
