public class Tosatti_3E_17A_EserciziArray {
    public static void main(String[] args) {

        String[] stringArray = {
                "Stringa 1",
                "stringa 2",
                "Stringa 3"
        };

        int character;

        for (int i = 0; i < stringArray.length; i++) {
            character = stringArray[i].charAt(0);

            // The ascii value from A to Z is from 65 to 90
            if (character >= 65 && character <= 90) {
                System.out.println(stringArray[i]);
            }
        }
    }
}
