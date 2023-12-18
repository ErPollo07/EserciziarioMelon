public class Tosatti_3E_06A_Cronometro {
    public static void main(String[] args) {

        int centSec = 0;
        int seconds = 0;
        int minutes = 0;
        int hours = 0;

        for (int i = 0; i < 62458; i++) {

            ClrScr();

            centSec++;

            if (centSec >= 100) {
                seconds++;
                centSec = 0;
            }

            if (seconds >= 60) {
                minutes++;
                seconds = 0;
            }

            if (minutes >= 60) {
                hours++;
                minutes = 0;
            }


            System.out.println(hours + " : " + minutes + " : " + seconds + " : " + centSec);

            Wait(10);
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
