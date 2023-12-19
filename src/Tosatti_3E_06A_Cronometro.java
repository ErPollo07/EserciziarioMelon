public class Tosatti_3E_06A_Cronometro {
    public static void main(String[] args) {

        int centSec = 0;
        int second = 0;
        int minute = 0;
        int hour = 0;
        int day = 0;
        int month = 0;
        int year = 0;

        for (int i = 0; i < 1000000000; i++) {

            // ClrScr();

            centSec++;

            if (centSec >= 100) {
                second++;
                centSec = 0;
            }

            if (second >= 60) {
                minute++;
                second = 0;
            }

            if (minute >= 60) {
                hour++;
                minute = 0;
            }

            if (hour >= 24) {
                day++;
                hour = 0;
            }

            if (day >= 30) {
                month++;
                day = 0;
            }

            if (month >= 12) {
                year++;
                month = 0;
            }

            // Stampo il tempo
            System.out.println(year + " : " + month + " : " + day + " : " + hour + " : " + minute + " : " + second + " : " + centSec);

            // Wait(10);
        }
    }

    private static void Wait(int milliSecond) {
        try {
            Thread.sleep(milliSecond);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void ClrScr() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e ) {
            e.printStackTrace();
        }
    }

}
