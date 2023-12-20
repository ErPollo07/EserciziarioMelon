import java.util.*;

public class Tosatti_3E_09A_Random {
    public static void main(String[] args) {

        // Scanner scanner = new Scanner(System.in);

        Random casuale = new Random();

        /*
        for (int i = 0; i < 10; i++) {

            System.out.println(casuale.nextInt(1 ,21));
        }
        */

        // Generiamo un valore CASUALE (1 - 20) corrispondente al numero assegnato agli studenti della calsse 3E

        String studente;
        /*
        switch (casuale.nextInt(1,10)) { // posso definire int byte shortString

            case 1: // Non si possono definire espressioni
                studente = "Mattia Albieri"; break;
            case 2:
                studente = "Filippo Barchi"; break;
            case 3:
                studente = "Noemi Basaglia"; break;
            case 4:
                studente = "Filippo Barchi"; break;
            case 5:
                studente = "Stefano Barchi"; break;
            case 6:
                studente = "Daniele Chiarion"; break;
            case 7:
                studente = "Eleonora Cosmi"; break;
            case 8:
                studente = "Mattia Crepaldi"; break;
            default:
                studente = "Oggi non interroghiamo"; break;
        }

        System.out.println("E' uscito: " + studente);

        */

        // Se escono i numeri 5 6 7 viene stampata Eleonora cosmi

        switch (casuale.nextInt(1,10)) { // posso definire int byte shortString

            case 1: // Non si possono definire espressioni
                studente = "Mattia Albieri"; break;
            case 2:
                studente = "Filippo Barchi"; break;
            case 3:
                studente = "Noemi Basaglia"; break;
            case 4:
                studente = "Filippo Barchi"; break;
            case 5:

            case 6:

            case 7:
                studente = "Eleonora Cosmi"; break;
            case 8:
                studente = "Mattia Crepaldi"; break;
            default:
                studente = "Oggi non interroghiamo"; break;
        }

        System.out.println("E' uscito: " + studente);
    }
}
