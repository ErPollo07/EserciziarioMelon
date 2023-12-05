import java.util.Scanner;
import java.lang.Math;

public class Tosatti_3E_02A_ConversioneBinarioDecimale {
    public static void main(String[] args) {
        Scanner tastiera = new Scanner(System.in);

        String numeroBinario = ""; // input
        double numeroDecimale = 0; // output

        // variabili di calcolo
        double carattere = 0;
        double pow = 0;
        boolean flagBinario = true;

        System.out.println("Conversione numero binario in numero decimale\n");

        // Acquisisco numero binario
        System.out.println("Inserisci un numero binario: ");
        numeroBinario = tastiera.next();

        // sto dentro al ciclo fino a quando non arrivo alla fine del numero
        for (int i = numeroBinario.length(); i > 0; i--) {

            // Prendo il carattere
            carattere  = Character.getNumericValue(numeroBinario.charAt(i - 1));

            // Controllo se il carattere é 0 o 1
            // Se si allora calcolo il numero
            if (carattere == 1 || carattere == 0) {
                // FORMULA: numeroDecimale = numeroDecimale (int)char * 10**pow
                numeroDecimale = numeroDecimale + carattere * Math.pow(2.0, pow);
            }

            // se il carattere non é valido
            else {
                System.out.println("Numero non valido");
                flagBinario= false;
                break;
            }

            // Aggiorno l'esponente
            pow++;
        }

        // se il numero é valido allora stampo il risultato
        if (flagBinario)
            System.out.println(numeroDecimale);
    }
}
