import java.util.Random;


public class Tosatti_3E_14A_NumeriLotto {
    public static void main(String[] args) {

        // Estrarre 5 numeri da 1 a 90

        // ruotaEstratta -> ritorna valore di una ruota

        // Assign to n the array with extract numbers
        int[] n = ruotaEstratta();

        System.out.println("I valori della ruota di Venezia sono: ");

        // for (int i:n) // another method to cicle the array
        for (int i = 0; i < n.length; i++) {
            System.out.println("Il " + (i+1) + " numero e': " + n[i]);
        }

    }

    // Return the array of number extract
    public static int[] ruotaEstratta() {
        int[] numeri = new int[5];
        int minValue = 1, maxValue = 90;

        for (int i = 0; i < numeri.length; i++) {
            numeri[i] = valoreRandom(minValue, maxValue); // Assign random value to numeri[i]

            if (i > 0) valueChecker(numeri, i, minValue, maxValue); // check if the value isn't repeating
        }

        return numeri; // return array
    }

    // Check if the value is available
    // todo change method to check numbers with array that store extact nuber
    private static void valueChecker(int array[], int i, int minValue, int maxValue) {
        for (int k = 0; k < i; k++) {
            // If the value is already in the array, reassign it and recheck all array
            if (array[i] == array[k]) {
                array[i] = valoreRandom(minValue, maxValue); // Assign another random value to array[i]
                k = -1; // Restart the check
            }
        }
    }


    private static int valoreRandom(int minValue, int maxValue)
    {
        Random casuale = new Random();

        return  casuale.nextInt(minValue,maxValue+1);
    }
}
