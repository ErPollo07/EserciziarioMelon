import java.util.Scanner;

public class Tosatti_3E_16A_CaratteriStringa {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str;
        String thereIs = "";
        String thereIsnt = "";

        boolean[] checkers = new boolean[26];

        System.out.print("Inserisci stringa: ");
        str = scanner.next();

        str = str.toLowerCase();

        for (int i = 0; i < str.length(); i++) {
            int charToByte = (byte)str.charAt(i); // take the byte value of the char

            if (!checkers[charToByte - 97]) {
                checkers[charToByte - 97] = true;
            }
        }

        // Adding the char if there is or there isn't
        for (int i = 0; i < checkers.length; i++) {
            char carattere = (char)(i + 97); // converting the byte into char

            if (checkers[i]) {
                thereIs = thereIs + carattere; // Concatenate the string with the new char
            } else {
                thereIsnt = thereIsnt + carattere; // Concatenate the string with the new char
            }
        }

        // Print out the present character
        System.out.println("I caratteri che erano presenti sono: ");
        for (int i = 0; i < thereIs.length(); i++) {
            System.out.print(thereIs.charAt(i) + " ");
        }

        // Print out the present character
        System.out.println("\nI caratteri che non ci sono sono: ");
        for (int i = 0; i < thereIsnt.length(); i++) {
            System.out.print(thereIsnt.charAt(i) + " ");
        }
    }
}
