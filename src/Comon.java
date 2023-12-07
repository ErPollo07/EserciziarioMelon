public class Comon {
    public static void main(String[] args) { }

    /**
     * Clear screen on cmd
     * */
    private static void ClrScr() {

        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e ) {
            e.printStackTrace();
        }
    }
}
