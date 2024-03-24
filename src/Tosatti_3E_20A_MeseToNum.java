public class Tosatti_3E_20A_MeseToNum {
    public static void main(String[] args) {
        /*
        Realizzare un metodo (intToStrMese) che riceve in input un stringa corrispondente al valore di un mese
        es:GENNAIO e ritorna in output il corrispondente valore numerico es:1.
        Se il valore inserito non è valido il metodo deve ritornare -1.
         */

        String[] mesi = {"gennaio", "febbraio", "marzo",  "aprile", "maggio", "giugno", "luglio",
                "agosto", "settembre", "ottobre", "novembre", "dicembre", "dfdfdsfsdf"};

        for (String mese : mesi) {
            System.out.println(intToStrMese(mese));
        }
    }

    /**
     * Returns the number of the month.<br>
     * The method converts the {@code month} to lower case io order to get the number with any formation.
     * If the {@code month} param is not an available month the method returns -1.
     * <br>
     * Example:
     * <pre>
     *   mese: "Gennaio" => 1
     *   mese: "FebbRaio" => 2
     *   mese: "blabla" => -1
     * </pre>
     * @param month the month which we want the number
     * @return the number of the month. If the {@code month} param is not a month returns -1.
     */
    private static int intToStrMese(String month) {
        return switch (month.toLowerCase()) {
            case "gennaio"   -> 1;
            case "febbraio"  -> 2;
            case "marzo"     -> 3;
            case "aprile"    -> 4;
            case "maggio"    -> 5;
            case "giugno"    -> 6;
            case "luglio"    -> 7;
            case "agosto"    -> 8;
            case "settembre" -> 9;
            case "ottobre"   -> 10;
            case "novembre"  -> 11;
            case "dicembre"  -> 12;
            default -> -1;
        };
    }
}
