import java.util.Random;
import java.util.Scanner;

public class Tosatti_3E_12A_RollDado {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int numeroG1;
        int numeroG2;

        String giocatore1 = "Melon", giocatore2 = "Raspa";

        numeroG1 = SimulazioneRollG1(giocatore1);
        numeroG2 = SimulazioneRollG2(giocatore2);

        if (numeroG1 == numeroG2) {
            System.out.println("Paritá");
        } else if (numeroG1 > numeroG2) {
            System.out.println("Ha vinto il " + giocatore1);
        } else {
            System.out.println("Ha vinto il " + giocatore2);
        }
    }

    private static int SimulazioneRollG1(String g1) {
        Random random = new Random();

        int valoreFaccia = 0;

        for (int i = 0; i <= 7; i++) {

            if (i == 7) {
                System.out.println("Al giocatore " + g1 + " uscito :");
                valoreFaccia = random.nextInt(0, 6) + 1;
                FacceDado(valoreFaccia);
            }
            else {
                FacceDado(i);
                Wait(50);
                ClrScr();
            }
        }

        return valoreFaccia;
    }

    private static int SimulazioneRollG2(String g2) {
        Random random = new Random();

        int valoreFaccia = 0;

        for (int i = 0; i <= 7; i++) {

            if (i == 7) {
                System.out.println("Al giocatore " + g2 + " uscito :");
                valoreFaccia = random.nextInt(0, 6) + 1;
                FacceDado(valoreFaccia);
            }
            else {
                FacceDado(i);
                Wait(50);
                ClrScr();
            }
        }

        return valoreFaccia;
    }

    private static void FacceDado(int valoreFaccia) {
        switch (valoreFaccia) {
            case 1:
                System.out.println("\t\t\t\t\t ╔═════════╗");
                System.out.println("\t\t\t\t\t ║         ║");
                System.out.println("\t\t\t\t\t ║    o    ║");
                System.out.println("\t\t\t\t\t ║         ║");
                System.out.println("\t\t\t\t\t ╚═════════╝");
                break;
            case 2:
                System.out.println("\t\t\t\t\t ╔═════════╗");
                System.out.println("\t\t\t\t\t ║ o       ║");
                System.out.println("\t\t\t\t\t ║         ║");
                System.out.println("\t\t\t\t\t ║       o ║");
                System.out.println("\t\t\t\t\t ╚═════════╝");
                break;
            case 3:
                System.out.println("\t\t\t\t\t ╔═════════╗");
                System.out.println("\t\t\t\t\t ║ o       ║");
                System.out.println("\t\t\t\t\t ║    o    ║");
                System.out.println("\t\t\t\t\t ║       o ║");
                System.out.println("\t\t\t\t\t ╚═════════╝");
                break;
            case 4:
                System.out.println("\t\t\t\t\t ╔═════════╗");
                System.out.println("\t\t\t\t\t ║ o     o ║");
                System.out.println("\t\t\t\t\t ║         ║");
                System.out.println("\t\t\t\t\t ║ o     o ║");
                System.out.println("\t\t\t\t\t ╚═════════╝");
                break;
            case 5:
                System.out.println("\t\t\t\t\t ╔═════════╗");
                System.out.println("\t\t\t\t\t ║ o     o ║");
                System.out.println("\t\t\t\t\t ║    o    ║");
                System.out.println("\t\t\t\t\t ║ o     o ║");
                System.out.println("\t\t\t\t\t ╚═════════╝");
                break;
            case 6:
                System.out.println("\t\t\t\t\t ╔═════════╗");
                System.out.println("\t\t\t\t\t ║ o     o ║");
                System.out.println("\t\t\t\t\t ║ o     o ║");
                System.out.println("\t\t\t\t\t ║ o     o ║");
                System.out.println("\t\t\t\t\t ╚═════════╝");
                break;
        }
    }


    private static void ClrScr() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e ) {
            e.printStackTrace();
        }
    }

    private static void Wait(int milliSecond) {
        try {
            Thread.sleep(milliSecond);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
