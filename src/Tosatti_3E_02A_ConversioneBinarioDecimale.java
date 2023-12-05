import java.util.Scanner;
import java.lang.Math;

public class Tosatti_3E_02A_ConversioneBinarioDecimale {
    public static void main(String[] args) {
        Scanner tastiera = new Scanner(System.in);

        String numeroBinario = ""; // input
        double numeroDecmale = 0; // output

        double carattere = 0;
        double pow = 0;
        boolean flagBinario = true;

        System.out.println("Conversione numero binario in numero decimale\n");

        // Acquisisco numero binario
        System.out.println("Inserisci un numero binario: ");
        numeroBinario = tastiera.next();


        for (int i = numeroBinario.length(); i > 0; i--) {

            carattere  = Character.getNumericValue(numeroBinario.charAt(i - 1));
            if (carattere == 1 || carattere == 0) {
                // nuumeroDecimale = numeroDecimale (int)char * 10**i
                numeroDecmale = numeroDecmale + carattere * Math.pow(2.0, pow);
            }
            else {
                System.out.println("Numero non valido");
                flagBinario= false;
                break;
            }


            // Aggiorno l'esponente
            pow++;
        }

        if (flagBinario)
            System.out.println(numeroDecmale);


    }
}
