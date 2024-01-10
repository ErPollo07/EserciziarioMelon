/*
Introdurre la possibilità di acquistare tre tipi di vino:
1-Barbera 1,5 Euro Litro
2-Lugana 2 Euro Litro
3-Merlot1 Euro Litro.
Gli acquisti possono essere eseguiti da clienti diversi fino alla chiusura della cassa.
*/

import java.util.Scanner;

public class Tosatti_3E_01B_Vinaio {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // input variable
        String vine = "", anotherClient = "";

        // service variable
        int iva = 21;
        double capacity = 1.5;
        double  priceLitreBarbera = 1.5, priceLitreLugana = 2, priceLitreMerlot = 1;
        int numberOfClient = 0;

        // out variable
        int numberBottlesPurchased = 0;
        double price = 0, ivaPrice = 0;

        // This cicle repeats while there isn't another client
        do {
            // Increment the number of client
            numberOfClient++;

            // Ask the client which vine he wants
            do {
                System.out.println("Which type of vine you want (Barbera, Lugana, Merlot)?");
                vine = scanner.next();

                // Verifying if the vine is included
                if (!(vine.equals("Barbera") || vine.equals("Lugana") || vine.equals("Merlot"))) {
                    System.out.println("You must insert Barbera or Lugana or Merlot");
                }
            } while (!(vine.equals("Barbera") || vine.equals("Lugana") || vine.equals("Merlot")));

            do {
                // How many bottles the client want
                System.out.print("How many bottles you want to buy: ");
                numberBottlesPurchased = scanner.nextInt();

                // Verifying if the number of bottles which client want is above 0
                if (numberBottlesPurchased <= 0)
                    System.out.println("You must insert a number above 0");
            } while (numberBottlesPurchased <= 0);


            // Calculate the price based on the
            if (vine.equals("Barbera")) {
                price = numberBottlesPurchased * capacity * priceLitreBarbera;
            }
            else if (vine.equals("Lugana")) {
                price = numberBottlesPurchased * capacity * priceLitreLugana;
            }
            else {
                price = numberBottlesPurchased * capacity * priceLitreMerlot;
            }

            // Calculate the ivaPrice
            ivaPrice = price + (price * iva / 100);

            // Print the receipt
            System.out.println("\n" +
                    "Receipt:" + "\n" +
                    "Selected vine: " + vine + "\n" +
                    "Number of bottles purchased: " + numberBottlesPurchased + "\n" +
                    "Total price: " + price + "\n" +
                    "Price plus iva: " + ivaPrice + "\n");

            System.out.println("There is another client (y/n): ");
            anotherClient = scanner.next().toLowerCase();
        } while (anotherClient.equals("y"));

        // Display number of client
        System.out.println("Number of client: " + numberOfClient);
    }
}
