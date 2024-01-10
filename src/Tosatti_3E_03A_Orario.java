import java.util.Scanner;

public class Tosatti_3E_03A_Orario {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int hours = 0, minutes = 0, seconds = 0;
        double resto = 0;
        String _continuare;

        do {
            ClrScr();

            System.out.println("inserisci il tempo in secondi: ");
            seconds = scanner.nextInt();

            // calcolo le ore
            if (seconds < 86400 && seconds > 0) {

                // calcolo le ore
                hours = seconds / 3600;
                seconds = seconds % 3600;

                // calcolo i minuti
                while (seconds >= 60) {
                    minutes = seconds / 60;
                    seconds = seconds % 60;
                }

                // Visualizzo il tempo
                System.out.println("Il tempo e' " + hours + ":" + minutes + ":" + seconds);
            }

            // se il numero di secondi supera quelli in un secondo allora il numero non é valido
            else {
                System.out.println("Numero non valido");
            }

            System.out.println("Voui continuare: ");
            _continuare = scanner.next();

        } while (_continuare.equals("s"));
    }

    private static void ClrScr() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e ) {
            e.printStackTrace();
        }
    }
}