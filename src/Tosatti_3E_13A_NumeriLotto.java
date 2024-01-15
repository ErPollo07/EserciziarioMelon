import java.util.Random;

public class Tosatti_3E_13A_NumeriLotto {
    public static void main(String[] args) {

        // Estrarre 5 numeri da 1 a 90

        // ruotaEstratta -> ritorna valore di una ruota


        int[] numeri = new int[5];
        int minValue = 1, maxValue = 6;

        System.out.println("I valori della ruota di Venezia sono: ");

        for (int i = 0; i < numeri.length; i++) {
            numeri[i] = valoreRandom(minValue, maxValue); // // Assign random value to numeri[i]

            if (i > 0) {
                for (int k = 0; k < i; k++) {
                    if (numeri[i] == numeri[k]) {
                        numeri[i] = valoreRandom(minValue, maxValue); // Assign another random value to numeri[i]
                        k = -1; // Restart the check
                    }
                }
            }

            System.out.println("\t" + numeri[i]);
        }
    }

    public static int ruotaEstratta(String r) {
        // todo
        return 0;
    }

vrv

    private static int valoreRandom(int minValue, int maxValue)
    {
        Random casuale = new Random();

        return  casuale.nextInt(minValue,maxValue+1);
    }
}
