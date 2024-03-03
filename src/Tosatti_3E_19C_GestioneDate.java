import java.util.Scanner;

public class Tosatti_3E_19C_GestioneDate {
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
        boolean validityOfDate;
        int continueToinsert;

        do {
            // Take day, months, year
            do {
                System.out.println("Inserisci la data: ");
                date = scanner.nextInt();

                // If the date is too short or too long,
                // tell the user how to insert the date
                if (verifyValidityOfDate(date) != 8)
                    System.out.println("inserire la data in questo formato ggmmyyyy TUTTO ATTACATO");
                // verify is the date is long enough
            } while (verifyValidityOfDate(date) != 8);

            // call method to separate day, month, year
            separateDate = separateDate(date);

            // Check if the day is correct based on the month
            validityOfDate = verifyDayMonthPair(separateDate[0], separateDate[1], checkLeapYear(separateDate[2]));

            // Print the result
            if (validityOfDate) {
                System.out.println("Giorno: " + separateDate[0]);
                System.out.println("Mese: " + convertMonthToString(separateDate[1]));
                System.out.println("Anno: " + separateDate[2]);
                System.out.println(checkLeapYear(separateDate[2]));
            }
            else {
                System.out.println("La data non e' valida");
            }

            System.out.println("Vuoi continuare: \n\t[1] - SI\n\t[2] - NO\nInserisci la scelta: ");
            continueToinsert = scanner.nextInt();
        } while(continueToinsert == 1);


    }

    /**
     * if I pass y = 2024, the method returns true
     * if I pass y = 2023, the method returns false
     *
     * @param y the year which we want to check
     * @return true if the year is a leap year, false if is not.
     */
    private static boolean checkLeapYear(int y) {
        return ((y % 4 == 0 && y % 100 != 0) || y % 400 == 0);
    }

    /**
     * Separate the digit of the date number
     * Es - I pass 12345678, the method will return:
     * separateDate[0] = 12
     * separateDate[0] = 34
     * separateDate[0] = 5678
     *
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
     * If I pass m = 3, the method will return me "marzo".
     * If I pass m = a number above 12, the method will return me "NOT VALID"
     *
     * @param m the number of the month
     * @return the name of the month respective to the number passed as a parameter
     */
    private static String convertMonthToString(int m) {

        String month = switch (m) {
            case 1 -> "Gennaio";
            case 2 -> "Febbraio";
            case 3 -> "Marzo";
            case 4 -> "Aprile";
            case 5 -> "Maggio";
            case 6 -> "Giugno";
            case 7 -> "Luglio";
            case 8 -> "Agosto";
            case 9 -> "Settembre";
            case 10 -> "Ottobre";
            case 11 -> "Novembre";
            case 12 -> "Dicembre";
            default -> "NOT VALID";
        };

        return month;
    }

    /**
     * This method verifies that the date is valid
     *
     * @param date The date which we want to control
     * @return true if the date has eight digit, false if the date hasn't eight digit
     * Es -
     * If I pass 1234567   -> false
     * If I pass 12345678  -> true
     * If I pass 123456789 -> false
     */
    public static int verifyValidityOfDate(int date) {
        int counter = 0;

        // Count all the digit of the date number
        do {
            date = date / 10;
            counter++;
        } while (date > 0);

        return counter;
    }

    /**
     *
     * @param d
     * @param m
     * @param leapYear
     * @return
     */
    private static boolean verifyDayMonthPair(int d, int m, boolean leapYear) {
        boolean validity = true;

        // If the m is grader than 12, set validity to false
        if (m > 12)
            validity = false;
        // If the month is February and check if bisistile == true and the day grader than 29
        // or check if leap year == false and day is grader than 28
        else if (m == 2 && ((leapYear && d > 29) || (!leapYear && d > 28)))
            validity = false;
        // Check if the month is equals to 4 or 6 or 9 or 11 and d is grader than 30
        else if ((m == 4 || m == 6 || m == 9 || m == 11) && d > 30)
            validity = false;
        else if (d > 31)
            validity = false;

        return validity;
    }
}