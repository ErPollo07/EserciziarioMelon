import java.util.Scanner;

public class Tosatti_3E_08A_RaccoglitoreEsercizi {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int scelta;
        int continuare;


        do {
            PrintMenu();

            System.out.println("Inserisci la tua scelta: ");
            scelta = scanner.nextInt();

            if (scelta == 1) Es1();
            else if (scelta == 2) Es2();
            else if (scelta == 3) Es3();
            else if (scelta == 4) Es4();
            else System.out.println("Scelta non contemplata");

            System.out.println("\n\nSe vuoi continuare inserire un numero diverso da 0: ");
            continuare = scanner.nextInt();

        } while(continuare != 0);
    }

    private static void Es1() {

        Scanner scanner = new Scanner(System.in);

        int numero = 0;
        int lenght = 0;

        // somme
        double sommaPari = 0;
        double sommaDispari = 0;

        // lenght
        double lenghtPari = 0;
        double lenghtDispari = 0;

        // medie
        double mediaPari = 0;
        double mediaDispari = 0;

        System.out.println("Inserisci il numero di numeri che vuoi inserire: ");
        lenght = scanner.nextInt();

        if (lenght < 30) {
            while(lenght > 0) {
                System.out.println("Inserisci un numero: ");
                numero = scanner.nextInt();

                if (numero % 2 == 0) {
                    sommaPari += numero;
                    lenghtPari += 1;
                }
                else {
                    sommaDispari += numero;
                    lenghtDispari += 1;
                }

                lenght--;
            }

            if (lenghtPari > 0)
                mediaPari = sommaPari / lenghtPari;
            if (lenghtDispari > 0)
                mediaDispari = sommaDispari / lenghtDispari;

            if (mediaPari > 0)
                System.out.println("La media dei numeri pari: " + mediaPari);
            if (mediaDispari > 0)
                System.out.println("La media dei numeri dispari: " + mediaDispari);
        }
        else {
            System.out.println("Non puoi inserire piú di 30 numeri");
        }
    }

    private static void Es2() {

        Scanner scanner = new Scanner(System.in);

        double prezzo;

        double scontoMinore500 = 10, sconto1000 = 20, scontoOltre1001 = 30;

        double prezzoScontato = 0;

        // Chiedo l'input fino a che il prezzo < 0
        do {
            System.out.println("inserire l'importo: ");
            prezzo = scanner.nextDouble();
        } while (prezzo < 0);


        // Calcolo lo sconto e lo applico al prezzo
        if (prezzo < 500) {
            prezzoScontato = prezzo - prezzo * (scontoMinore500 / 100.0);
        }
        else if (prezzo >= 501 && prezzo < 1001) {
            prezzoScontato = prezzo - prezzo * (sconto1000 / 100.0);
        }
        else if (prezzo >= 1001) {
            prezzoScontato = prezzo - prezzo * (scontoOltre1001 / 100.0);
        }
        else {
            System.out.println("inserire un valore positivo");
        }

        // Stampo il prezzo inserito dall'utente e il prezzo con lo sconto applicato
        System.out.println("Importo inseririto: " + prezzo +
                "\nImporto con sconto: " + prezzoScontato);
    }

    private static void Es3() {

        Scanner scanner = new Scanner(System.in);

        int n;
        int numero = 0;

        double coutPositivi = 0, coutNegativi = 0;

        double sommaPositivi = 0, sommaNegativi = 0;
        double mediaPositivi = 0, mediaNegativi = 0;

        System.out.println("Inserisci quanti numeri vuoi leggere: ");
        n = scanner.nextInt();

        for (int i = 0; i < n; i++)
        {

            System.out.println("Inserisci il numero: ");
            numero = scanner.nextInt();

            if (numero > 0)
            {
                coutPositivi++;
                sommaPositivi += numero;
            }
            else
            {
                coutNegativi++;
                sommaNegativi += numero;
            }
        }

        if (coutPositivi > 0)
            mediaPositivi = sommaPositivi / coutPositivi;

        if (coutNegativi > 0)
            mediaNegativi = (sommaNegativi * -1) / coutNegativi;

        System.out.println("La somma dei numeri positivi e': " + sommaPositivi +
                "\nLa media dei numeri positivi e': " +  mediaPositivi
        );


        System.out.println("La somma dei numeri negativi e': " + (sommaNegativi * -1) +
                "\nLa media dei numeri negativi e': " + mediaNegativi);
    }

    private static void Es4() {

        Scanner scanner = new Scanner(System.in);

        int numero;
        int count = 0;
        int somma = 0;

        System.out.println("Inserisci il numero: ");
        numero = scanner.nextInt();

        for (int i = 1; i < numero; i++) {

            if (i > 1) {
                if (IsPrime(i)) {
                    if (count % 2 == 0) {
                        somma += i;
                    }

                    count++;
                }
            }
        }

        System.out.println("La somma dei numeri primi alternati minori di " + numero + " e': " + somma);
    }

    private static boolean IsPrime(int n) {

        boolean flag = true;

        for (int j = 2; j <= n / 2 && flag; j++) {

            if (n % j == 0)
                flag = false;
        }

        return flag;
    }

    private static void PrintMenu() {
        System.out.println("""
                Questi sono gli esercizi disponibili:
                    1. Somma pari dispari
                    2. Calcolatore di sconti
                    3. Somma media n positivi negativi
                    4. Somma numeri primi alterni
                """);
    }
}
