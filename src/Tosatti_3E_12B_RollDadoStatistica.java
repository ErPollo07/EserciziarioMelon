import java.util.Random;

public class Tosatti_3E_12B_RollDadoStatistica {

    private static int valoreRandom(int maxValue, int minValue) {
        Random random = new Random();

        int d = 0;

        return d;
    }


    private static void FacceDado(int valFaccia) {
        switch (valFaccia) {
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
}
