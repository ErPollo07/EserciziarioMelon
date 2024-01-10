import java.util.Scanner;
import java.lang.Math;

public class Tosatti_3E_02A_ConversioneBinarioDecimale {
    public static void main(String[] args) {
        Scanner tastiera = new Scanner(System.in);

        String binaryNumber = ""; // input
        double decimalNumber = 0; // output

        // variabili di calcolo
        double character = 0;
        double pow = 0;
        boolean flagBinary = true;

        System.out.println("Conversione numero binario in numero decimale\n");

        // Acquisisco numero binario
        System.out.println("Inserisci un numero binario: ");
        binaryNumber = tastiera.next();

        // sto dentro al ciclo fino a quando non arrivo alla fine del numero
        for (int i = binaryNumber.length(); i > 0; i--) {

            character = (double)binaryNumber.charAt(i - 1) - 48;

            // Controllo se il carattere é 0 o 1
            // Se si allora calcolo il numero
            if (binaryNumber.charAt(i - 1) == '1' || binaryNumber.charAt(i - 1) == '0') {
                // FORMULA: numeroDecimale = numeroDecimale + (int)char * 10**pow
                decimalNumber = decimalNumber + character * Math.pow(2.0, pow);
            }

            // se il carattere non é valido
            else {
                System.out.println("Numero non valido");
                flagBinary= false;
                break;
            }

            // Aggiorno l'esponente
            pow++;
        }

        // se il numero é valido allora stampo il risultato
        if (flagBinary)
            System.out.println(decimalNumber);
    }
}
