import java.util.Random;
import java.util.Scanner;

public class Tosatti_3E_10A_TestaCroce {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Random random = new Random();

        int testaCroce;
        String giocatore1 = "Bego", giocatore2 = "Chiarion";
        int mossaG1, mossaG2; // Croce 1 Testa 0
        int facciaMoneta;

        System.out.println(giocatore1 + " cosa vuoi scegliere, testa o croce: ");
        mossaG1 = scanner.nextInt();

        if (mossaG1 == 1) mossaG2 = 0;
        else if (mossaG1 == 0) mossaG2 = 1;

        testaCroce = random.nextInt();

        if (testaCroce % 2 == 0) {
            facciaMoneta = 0;
        } else {
            facciaMoneta = 1;
        }

        System.out.println("Faccia della moneta: " + facciaMoneta);

        if (facciaMoneta == mossaG1) System.out.println(giocatore1 + " ha vinto");
        else System.out.println(giocatore2 + " ha vinto");
    }
}

