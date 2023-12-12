/*
Per cucinare un uovo sono necessari 3 minuti.
Utilizzando il metodo realizzato in laboratorio realizzare un programma che permetta di
temporizzare la cottura dell'uovo simulandone le fasi di cottura con delle figure realizzate
utilizzando dei caratteri ascii.
*/

public class Tosatti_3E_05A_CotturaUovo {
    public static void main(String[] args) {


    }

    private static void UovoNonBollito() {
        // stampa l'immagine dell'uovo
        /*
          ,'"`.
         /     \
        :       :
        :       :
         `.___,'
          */
    }

    private static void UovoCheBolle() {
        /*
           °  ,'"`. °   °
         °   /     \ °
        °   :       :  °
          ° :       : °
       °   ° `.___,' °   °
         */
    }

    private static void uovoCotto() {
        /*
              ,'"`.
             /  _  \
            : /   \ :
            : \___/ :
             `.___,'
        */
    }

    private static void ClrScr() {

        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e ) {
            e.printStackTrace();
        }
    }
}
