/*
Per cucinare un uovo sono necessari 3 minuti.
Utilizzando il metodo realizzato in laboratorio realizzare un programma che permetta di
temporizzare la cottura dell'uovo simulandone le fasi di cottura con delle figure realizzate
utilizzando dei caratteri ascii.
*/

import java.util.Scanner;

public class Tosatti_3E_05A_CotturaUovo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String _pause; // Character for pause

        System.out.println("Benvenuti al ristorante");

        System.out.println();
        _pause = scanner.nextLine();

        // mettere tempo 3m
        // fase di test tempo 20s
        for (int i = 20; i > 0; i--) {

            UovoCheBolle();

            System.out.println("\n\nTimer: " + i);
            Wait(1000);
            ClrScr();
        }


    }

    private static void UovoNonBollito() {

        System.out.println("""
                  ,'"`.
                 /     \\
                :       :
                :       :
                 `.___,'
                """);
    }

    private static void UovoCheBolle() {

        System.out.println("""
                  °  ,'"`. °   °
                °   /     \\ °
               °   :       :  °
                 ° :       : °
              °   ° `.___,' °   °
                """);

        /*

         */
    }

    private static void UovoCotto() {

        System.out.println("""
                    ,'"`.
                   /  _  \\
                  : /   \\ :
                  : \\___/ :
                   `.___,' 
                """);
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
