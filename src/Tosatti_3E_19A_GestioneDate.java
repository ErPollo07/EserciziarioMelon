import java.util.Scanner;

public class Tosatti_3E_19A_GestioneDate {
    public static void main(String[] args) {
        /*
        Dato un valore numerico intero che
        rappresenta la data odierna nel formato
        ggmmaaaa determinare i valori che
        rappresentano il giorno,mese anno.
                Es.: 30112011
        giorno=30
        mese=11
        anno=2011
        */

        Scanner scanner = new Scanner(System.in);

        int date;
        // array to store [day, month, year]
        int[] separateDate;

        // Take day, months, year
        do {
            System.out.println("Inserisci la data: ");
            date = scanner.nextInt();

            // If the date is too short or too long,
            // tell the user how to insert the date
            if (!verifyValidityOfDate(date))
                System.out.println("inserire la data in questo formato ggmmyyyy TUTTO ATTACATO");
            // verify is the date is long enough
        } while (!verifyValidityOfDate(date));

        // call method to separate day, month, year
        separateDate = separateDate(date);

        // Print the result
        System.out.println("Giorno: " + separateDate[0]);
        System.out.println("Mese: " + separateDate[1]);
        System.out.println("Anno: " + separateDate[2]);
    }

    /**
     * Separate the digit of the date number
     * Es - I pass 12345678, the method will return:
     * separateDate[0] = 12
     * separateDate[0] = 34
     * separateDate[0] = 5678
     * @param date the number of the date which we want to control
     */
    private static int[] separateDate(int date) {
        int[] separateDate = new int[3];
        int divisor = 10000;

        for (int i = 2; i >= 0; i--) {
            // insert in the correct position
            separateDate[i] = date % divisor;
            date /= divisor; // "delete" the part already insert
            divisor = 100; // Update the divisor
        }

        return separateDate;
    }


    /**
     * This method verify that the date is valid
     * @param date The date which we want to control
     * @return true if the date has eight digit, false if the date hasn't eight digit
     * Es -
     * If I pass 1234567   -> false
     * If I pass 12345678  -> true
     * If I pass 123456789 -> false
     */
    public static boolean verifyValidityOfDate(int date) {
        boolean validity = true;
        int counter = 1;

        // Count all the digit of the date number
        do {
            date = date / 10;
            counter++;
        } while (date > 1);

        // If the number of digit of the date is not valid,
        // set validity to false
        if (counter != 8) validity = false;

        return validity;
    }

}