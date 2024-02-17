public class Tosatti_3E_17B_EserciziArray {
    public static void main(String[] args) {
        /*
        Scrivere un programma TreConsecutivi che prevede un array di 10 numeri interi contenente valori a piacere
        (senza bisogno di chiederli all’utente) e stampa "Tre valori consecuitivi uguali"
        se l’array contiene tre valori uguali in tre posizioni consecutive, oppure stampa "NO" altrimenti.
         */

        int[] integerArray = {1,2,3,4,4,4,2,2,2,7,8};
        int counter;

        for (int i = 0; i <= integerArray.length - 3; i++) {
            if (integerArray[i] == integerArray[i + 1] && integerArray[i + 1] == integerArray[i + 2]) {
                System.out.println("Tre valori consecutivi uguali");
            }
            else {
                System.out.println("NO");
            }
        }
    }
}
