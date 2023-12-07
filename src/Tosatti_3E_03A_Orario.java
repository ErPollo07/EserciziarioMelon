import java.util.Scanner;

public class Tosatti_3E_03A_Orario {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int ore = 0, minuti = 0, secondi = 0;
        double resto = 0;
        String continuare;

        do {
            ClrScr();

            System.out.println("inserisci il tempo in secondi: ");
            secondi = scanner.nextInt();

            // calcolo le ore
            if (secondi < 86400 && secondi > 0) {

                // calcolo le ore
                ore = secondi / 3600;
                secondi = secondi % 3600;

                // calcolo i minuti
                while (secondi >= 60) {
                    minuti = secondi / 60;
                    secondi = secondi % 60;
                }

                // Visualizzo il tempo
                System.out.println("Il tempo e' " + ore + ":" + minuti + ":" + secondi);
            }

            // se il numero di secondi supera quelli in un secondo allora il numero non é valido
            else {
                System.out.println("Numero non valido");
            }

            System.out.println("Voui continuare: ");
            continuare = scanner.next();

        } while (continuare.equals("s"));
    }

    private static void ClrScr() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e ) {
            e.printStackTrace();
        }
    }
}