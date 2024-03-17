import java.util.Scanner;

public class Tosatti_3E_19D_GestioneDate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //declaration and initialization of variables/arrays

        String[] sceltaIncDec = {
                "Vuoi incrementare o decrementare la data inserita?",
                "[1] - Incremento",
                "[2] - Decremento"
        };

        int numero = 0;
        int[] dataSeparata = new int[3];
        int[] dataIncrementata = new int[3];
        int[] dataDecrementata = new int[3];
        Boolean dataNonValida;
        int quantiGiorni = 0;
        do {
            dataNonValida = false;
            //output for enter the date
            System.out.println("Inserisci un numero intero nel formato ggmmaaaa per determinare la data: ");
            //Check for non-valid user input
            try {
                //insertion of the date
                numero = scanner.nextInt();
                dataSeparata = separazioneData(numero);
                // Se i giorni, rispetto al mese inserito, non risultano corretti, stampa DATA ERRATA
                if (!dataOk(dataSeparata[0], dataSeparata[1], dataSeparata[2])) {
                    dataNonValida = true;
                    System.out.println("DATA ERRATA");
                } else {
                    System.out.println("DATA CORRETTA");
                }
            } catch (Exception x) {
                System.out.println("DATA ERRATA");
                dataNonValida = true;
                scanner.nextLine();
            }
        } while (dataNonValida);

        // Ask the user how many day he wants to increment or decrement the date
        switch (printMenu(sceltaIncDec, scanner)) {
            case 1:
                // chiedo all'utente di quanti giorni vuole incrementare la data
                do {
                    dataNonValida = false;
                    System.out.println("Di quanti giorni vuoi incremntare la data?");

                    try {
                        quantiGiorni = scanner.nextInt();

                        if (quantiGiorni < 0) {
                            System.out.println("Devi inserire un numero maggiore o uguale di 0");
                            dataNonValida = true;
                        }
                    } catch (Exception e) {
                        System.out.println("inserimento non valido");
                        dataNonValida = true;
                    }
                } while (dataNonValida);

                // chiamo la funzione data_up per incrementare la data
                dataIncrementata = data_up(dataSeparata, quantiGiorni);

                // stampo i valori a schermo
                System.out.println("Ecco la data incrementata di " + quantiGiorni + " giorni: " + dataToString1(dataIncrementata));

                break;
            case 2:
                // chiedo all'utente di quanti giorni vuole decrementare la data
                do {
                    System.out.println("Di quanti giorni vuoi decrementare la data?");

                    try {
                        quantiGiorni = scanner.nextInt();

                        if (quantiGiorni < 0) {
                            System.out.println("Devi inserire un numero maggiore o uguale di 0");
                            dataNonValida = true;
                        }
                    } catch (Exception e) {
                        System.out.println("inserimento non valido");
                        dataNonValida = true;
                    }
                } while (dataNonValida);

                // chiamo la funzione data_down per decrementare la data
                dataDecrementata = data_down(dataSeparata, quantiGiorni);

                // stampo i valori a schermo
                System.out.println("Ecco la data decrementata di " + quantiGiorni + " giorni: " + dataToString1(dataDecrementata));

                break;
        }
    }

    private static int[] data_up(int[] data, int up) {
        int[] dataInc = data;
        int giorniMax = getMaxDay(dataInc[1], dataInc[2]);

        for (int i = 0; i < up; i++) {
            dataInc[0]++;
            // Se supero il limite di giorni di quel mese,
            // allora:
            //  - resetto i giorni a 1
            //  - incremento il mese e decremento i mesi rimanenti
            if (dataInc[0] > giorniMax) {
                dataInc[0] = 1;
                dataInc[1]++;
                // Se i mesi rimanenti sono minori di 0 significa che bisogna cambiare anno
                // quindi:
                //  - incremento l'anno
                //  - resetto il mese a 1
                //  - resetto i mesi rimanenti a 11
                if (dataInc[1] > 12) {
                    dataInc[2]++;
                    dataInc[1] = 1;
                }
                // calcolo i giorni massimi nel mese in cui sono
                giorniMax = getMaxDay(dataInc[1], dataInc[2]);
            }
        }

        return dataInc;
    }

    private static int[] data_down(int[] data, int down) {
        int[] dataDec = data;

        for (int i = down; i > 0; i--) {
            dataDec[0]--;
            // Se il giorno risulta <= 0,
            // allora:
            //  - decremento il valore del mese
            //  - controllo di avere ancora mesi a disposizione
            //  - resetto i giorni al massimo valore di giorni del mese corrente
            if (dataDec[0] <= 0) {
                dataDec[1]--;
                // Se il mese e' < 1
                // allora:
                //  - decremento il valore dell'anno
                //  - resetto il mese a 12
                if (dataDec[1] < 1) {
                    dataDec[2]--;
                    dataDec[1] = 12;
                }
                // prendo il numero massimo di giorni del mese corrente
                dataDec[0] = getMaxDay(dataDec[1], dataDec[2]);
            }
        }

        return dataDec;
    }

    private static int getMaxDay(int mese, int anno) {
        switch (mese) {
            case 1, 3, 5, 7, 8, 10, 12:
                return 31;
            case 4, 6, 9, 11:
                return 30;
            case 2:
                if (Bisestile(anno)) return 29;
                else return 28;
        }
        return 0;
    }


    /* Separazione della data inserita in giorno, mese ed anno*/
    //12042024
    //12
    //04
    //2024:
    //Si ottiene dal resto della divisione della data per 10000
    //12042024 / 10000 = 1204 Resto 2024
    //12042024 / 10000 = 1204 Salviamo il risultato dentro data
    //1204 / 100 = 12 Resto 04
    //1204 / 100 = 12 Salviamo il risultato dentro data
    private static int[] separazioneData(int data) {
        //Contiene il valore d'uscita
        int[] output = new int[3];

        //Anno
        output[2] = data % 10000;
        //Rimuovere l'anno dalla data
        data /= 10000;
        //Mese
        output[1] = data % 100;
        //Rimuovere il mese dalla data
        data /= 100;
        //Giorno
        output[0] = data;

        //Ritornare i valori separati
        return output;
    }

    private static String dataToString1(int[] data) {
        String output;

        output = String.valueOf(data[0]) + "/" + String.valueOf(data[1]) + "/" + String.valueOf(data[2]);

        return output;
    }

    private static String dataToString2(int[] data) {
        String output;

        output = Integer.toString(data[0]) + "/" + Integer.toString(data[1]) + "/" + Integer.toString(data[2]);

        return output;
    }

    private static String dataToString3(int[] data) {
        Integer boxing = data[0];
        String output = boxing.toString() + "/";

        boxing = data[1];
        output += boxing.toString() + "/";

        boxing = data[2];
        output += boxing.toString();

        return output;
    }

    /**
    Controlla se l'anno e' bisistile
    */
    private static boolean Bisestile(int anno) {
        return ((anno % 4 == 0 && anno % 100 != 0) || anno % 400 == 0);
    }

    /**
    Controlla se il numero di giorni in un certo mese e' corretto.
    Io posso mettere 31 giorni a marzo ma non 32.
    */
    private static boolean dataOk(int giorno, int mese, int anno) {
        return switch (mese) {
            case 1, 3, 5, 7, 8, 10, 12 -> (giorno > 0 && giorno < 32);
            case 4, 6, 9, 11 -> (giorno > 0 && giorno < 31);
            case 2-> (Bisestile(anno) && giorno > 0 && giorno < 30) || (giorno > 0 && giorno < 29);
            default -> false;
        };
    }



    //anno: 31129999
    //01010001
    private static boolean validadata(int numero){
        return (numero>31129999 || numero<01010001);
    }

    //private static int validata()
    //-1 : No error
    //1 : Out of range
    //2 : Domain incorrect

    /**
     * Stampa il menu
     * @param opzioni
     * @param tastiera
     * @return
     */
    private static int printMenu(String opzioni[], Scanner tastiera)
    {
        int scelta;

        do {
            System.out.println("------------------");
            System.out.println(opzioni[0]);
            System.out.println("------------------");
            for (int i=1; i < opzioni.length; i++)
            {
                System.out.println(opzioni[i]);
            }
            tastiera.nextLine(); // clear buffer
            scelta = Integer.parseInt(tastiera.nextLine());

            if ((scelta < 1 ) || (scelta > opzioni.length - 1))
            {
                System.out.println("Opzione Sbagliata");
            }
        }
        while ((scelta < 1 ) || (scelta > opzioni.length - 1));

        return scelta;
    }
}