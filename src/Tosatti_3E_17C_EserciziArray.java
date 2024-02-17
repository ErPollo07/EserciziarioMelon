public class Tosatti_3E_17C_EserciziArray {
    public static void main(String[] args) {
        boolean[] presents = new boolean[26];
        String phrase = "La mAmma DI pie1ino";

        checker(presents, phrase);

        printPresentsCharacter(presents, phrase);
    }

    /**
     * Make the variable true in array presenti if the character is lowercase if it's not lowercase the
     * corrsponding variable doesn't change to true
     * @param presents array of bool that stores the status of every character in the string
     * @param phrase string to analise
     */
    private static void checker(boolean[] presents, String phrase){
        for (int i = 0; i < phrase.length(); i++) {
            if (phrase.charAt(i) >= 'a' && phrase.charAt(i) <= 'z') {
                presents[phrase.charAt(i) - 'a'] = true;
            }
        }
    }

    /**
     * Print all the lowercase character of the string
     * @param presents array of bool for the character status
     * @param phrase string for reference
     */
    private static void printPresentsCharacter(boolean[] presents, String phrase){
        for (int i = 0; i < phrase.length(); i++) {
            // if, in the string, there is a blank space, print a blank space
            if ((byte)(phrase.charAt(i)) == 32) {
                System.out.print(" ");
            }
            // If in the string there is a character, check if presents[j] is true
            else {
                for (int j = 0; j < presents.length; j++) {
                    // If the character is allowed and is on the correct position
                    if (presents[j] && phrase.charAt(i) == (char)(j + 'a')) {
                        System.out.print((char)(j + 'a'));
                    }
                }
                // Check if in index i there something and if this thig is a not-allowed-character in the string
                if (phrase.charAt(i) != ' ' && (phrase.charAt(i) < 'a' || phrase.charAt(i) > 'z')) {
                    System.out.print("*"); // Print * to indicate there is a not-allowed-character
                }
            }
        }
    }
}
