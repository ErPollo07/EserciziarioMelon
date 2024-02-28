import java.util.Scanner;

public class Tosatti_3E_18A_Parole {
    public static void main(String[] args) {
        /*
        Realizzare un programma che permetta, data una stringa contenente delle parole divise da uno spazio, di caricarle all'interno
        di un vettore utilizzando un metodo.
        Stampare a video il contenuto della parole.
        */

        Scanner scanner = new Scanner(System.in);

        String message;
        String[] separateWords;

        // Take the string with space
        System.out.println("insert a phrase: ");
        message = scanner.nextLine();

        int s = countSpace(message);

        // call takeIndividualWords
        separateWords = takeIndividualWords(message, s);

        // Print out all the word in array
        for (String i:separateWords) {
            System.out.println(i);
        }
    }

    /**
     * If I pass "hello I am Nicola" the method will return ["hello", "I", "am", "Nicola"]
     * @param message message which we want to extract the words
     * @param space who much space there is in the message
     * @return all the individual words in the string message
     */
    private static String[] takeIndividualWords(String message, int space) {
        String[] words = new String[space + 1];
        int indexWords = 0;

        // zero out the array
        for (int i = 0; i < words.length; i++) {
            words[i] = "";
        }

        for (int i = 0; i < message.length(); i++) {
            // if there is a space, don't insert anything
            if (message.charAt(i) != ' ')
                words[indexWords] += message.charAt(i);

            // if the space has a letter after it, update the index of the array words
            if (message.charAt(i) == ' ' && message.charAt(i + 1) != ' ')
                indexWords++;
        }

        return words;
    }

    /**
     * Count the space in the string txet
     * @param text
     * @return return how much space there is in the string text
     */
    private static int countSpace(String text) {
        int counter = 0;

        for (int i = 0; i < text.length() - 1; i++) {
            // if the space have a letter after it, update the counter of space
            if (text.charAt(i) == ' ' && text.charAt(i + 1) != ' ')
                counter++;
        }

        return counter;
    }
}
