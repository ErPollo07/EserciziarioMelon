import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Tosatti_3E_19C_GestioneDate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int date = 0;
        // array to store [day, month, year]
        int[] separateDate;
        boolean validityOfDate = false;
        int continueToinsert;

        // Take day, months, year
        do {
            System.out.println("Inserisci la data: ");

            try {
                date = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("La data inserta non e' valida");
                validityOfDate = true;
            }

            validityOfDate = validadata(date);

            // If the date is too short or too long,
            // tell the user how to insert the date
            if (!validityOfDate)
                System.out.println("La data non e' valida");
            else {
                // call method to separate day, month, year
                separateDate = separateDate(date);

                validityOfDate = verifyDayMonthPair(separateDate[0], separateDate[1], checkLeapYear(separateDate[2]));

                if (validityOfDate) {
                    System.out.println(dataToString(separateDate));
                }
                else {
                    System.out.println("la data non e' valida");
                }
            }
        } while (!validityOfDate);
    }

    private static String dataToString(int[] data) {
        return Integer.toString(data[0]) + "/" + Integer.toString(data[1]) + "/" + Integer.toString(data[2]);
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

        // Year
        separateDate[2] = date % 10000;
        date /= 10000; // remove the year from the date

        // Month
        separateDate[1] = date % 100;
        date /= 100; // remove the month from the date

        // Day
        separateDate[0] = date;

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
        return switch (m) {
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
    }

    /**
     * This method verifies that the date is valid
     *
     * @param numero The date which we want to control
     * @return true if the date has eight digit, false if the date hasn't eight digit
     * Es -
     * If I pass 1234567   -> false
     * If I pass 12345678  -> true
     * If I pass 123456789 -> false
     */
    private static boolean validadata(int numero){
        return (numero>01010001 && numero<31129999);
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