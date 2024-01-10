import java.util.Random;

public class Tosatti_3E_12B_RollDadoStatistica {
    public static void main(String[] args) {

        int val;

        int[] frequenze = new int[6];

        for (int i = 0; i < 100; i++) {

            val = valoreRandom(1,7);
            // System.out.printf("Valore %d\n", val);
            // %f float
            // %s string

            FacceDado(val);

            switch (val) {
                case 1:
                    frequenze[0]++;
                    break;
                case 2:
                    frequenze[1]++;
                    break;
                case 3:
                    frequenze[2]++;
                    break;
                case 4:
                    frequenze[3]++;
                    break;
                case 5:
                    frequenze[4]++;
                    break;
                case 6:
                    frequenze[5]++;
                    break;
            }
        }

        for (int i = 0; i < frequenze.length; i++) {

            System.out.printf("Faccia%d: %d\n", i + 1,  frequenze[i]);
        }
    }

    private static int valoreRandom(int minValue, int maxValue) {
        Random random = new Random();

        return random.nextInt(minValue, maxValue);
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
