import java.util.Scanner;


public class Tosatti_3E_01A_Vinaio {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // service variable
        int iva = 21, priceLitre = 1;
        double capacity = 1.5;

        // out variable
        int nBottlesPurchased = 0;
        double price = 0, ivaPrice = 0;

        // How many bottles the client want
        System.out.print("How many bottles you want to buy: ");
        nBottlesPurchased = scanner.nextInt();

        // Calculate the price
        price = nBottlesPurchased * capacity * priceLitre;
        /*
        * It doesn't make sense write the priceLitre because it is 1
        * If it is another number it's obligatory to put it
        * */

        // Calculate the ivaPrice
        ivaPrice = price + (price * iva / 100);

        // Print the receipt
        System.out.println("\n" +
                "Receipt:" + "\n" +
                "Number of bottles purchased: " + nBottlesPurchased + "\n" +
                "Total price: " + price + "\n" +
                "Price plus iva: " + ivaPrice + "\n");
    }
}