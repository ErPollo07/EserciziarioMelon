import java.util.Arrays;
import java.util.Scanner;

public class Tosatti_3E_22A_DividiStringa {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dest;
        String stringToSplit = "La mamma e' contenta dei voti dei suoi bambini"; // 54 chars

        dest = split(stringToSplit);

        // Print result
        System.out.println("Qusete sono le stringhe di max 40 char");

        for (int i = 0; i < dest.length; i++) {
            System.out.println("String " + (i+1) + ": " + dest[i]);
        }
    }

    /**
     * This method returns an array of strings with length which is max 40 chars.
     * If there isn't a blank space at the 40th char in string {@code s}
     * then the algorithm retreats to the nearest space.
     * @param s the string to divide
     * @return an array of sub-string of param {@code s}
     */
    private static String[] split(String s) {
        String[] splitString = new String[1];
        int indexSplit = 0;
        int startIndex = 0, endIndex = 40;
        boolean continueToSplit = true;

        // If the string length is less or equals then 40
        // then return the string
        if (s.length() <= 40) {
            splitString[0] = s;
            return splitString;
        }

        do {
            while (s.charAt(endIndex) != ' ') {
                endIndex--;

                // If the endIndex is equal to the start index
                // it means that there isn't space in the substring startIndex to endIndex
                // so add 40 to endIndex and break the while-loop.
                if (endIndex == startIndex) {
                    endIndex += 40;
                    break;
                }
            }

            // Take the string out
            splitString[indexSplit] = s.substring(startIndex, endIndex);

            // increment the indexSplit variable
            indexSplit++;

            // if indexSplit is grander then the length of the array splitString then enlarge the array
            splitString = enlargeArray(splitString);

            // move startIndex and endIndex
            startIndex = endIndex;
            endIndex += 40;

            // Check if the substring length from startIndex to endIndex is grader or equal to 40
            // if the length is less to 40 take the last string and set continueToSplit to false so the cycle can interrupt
            try {
                s.charAt(endIndex);
            } catch (IndexOutOfBoundsException e) {
                splitString[indexSplit] = s.substring(startIndex);
                continueToSplit = false;
            }
        } while (continueToSplit); // I can put while (true) and continueToSplit = false replace with a break? Ask raspa

        // If the last string is null set it to a blank string
        if (splitString[splitString.length - 1] == null) splitString[splitString.length - 1] = "";
        return splitString;
    }

    /**
     * Returns a string array with length of {@code startArray} + 1.
     * @param startArray the array which we want to enlarge
     * @return a string array with one space more then {@code startArray} and all the content of {@code startArray}
     */
    private static String[] enlargeArray(String[] startArray) {
        String[] temp = new String[startArray.length + 1];
        for (int i = 0; i < startArray.length; i++) {
            temp[i] = startArray[i];
        }
        return temp;
    }
}
