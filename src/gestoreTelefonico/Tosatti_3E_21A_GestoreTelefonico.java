package gestoreTelefonico;

import static gestoreTelefonico.tools.Utility.*;

import java.util.Scanner;

public class Tosatti_3E_21A_GestoreTelefonico {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] opzioniMenu = {
                "VODAFONE",
                "Inserimento",
                "Visualizzazione",
                "Ricerca",
                "Elimina contatto",
                "Ricerca con sentinella",
                "Fine"
        };

        String[] eliminaContatoSceltaMenu = {
                "Come vuoi elimnare il contatto",
                "Nome e cognome",
                "Numero di telefono"
        };

        String[] ricercaContatoSceltaMenu = {
                "Come vuoi cercare il contatto",
                "Nome e cognome",
                "Numero di telefono"
        };

        boolean Sitel = true;
        final int nMax = 3;
        int contrattiVenduti = 0;
        Contatto[] gestore = new Contatto[nMax];

        String nomeCercare, cognomeCercare, telefonoCercare;
        Contatto contRicerca = new Contatto();
        String nomeCancellare, cognomeCancellare, telefonoCancellare;


        boolean fine = true;
        do {
            switch (menu(opzioniMenu, scanner)) {
                case 1:
                    if (contrattiVenduti < nMax) {
                        //firma contratto
                        gestore[contrattiVenduti] = leggiPersona(Sitel, scanner);
                        contrattiVenduti++;
                    } else {
                        System.out.println("Non ci sono più contratti da vendere");
                    }
                    break;

                case 2:
                    visualizza(gestore, contrattiVenduti);
                    break;

                // Ricerca
                case 3: {
                    if (contrattiVenduti != 0) {
                        switch (menu(ricercaContatoSceltaMenu, scanner)) {
                            case 1:
                                System.out.println("Inserirsci il nome da cercare: ");
                                nomeCercare = scanner.nextLine();

                                System.out.println("Inserisci il cognome da cercare: ");
                                cognomeCercare = scanner.nextLine();

                                contRicerca = ricercaConGeneralita(gestore, nomeCercare, cognomeCercare, contrattiVenduti);
                                break;
                            case 2:
                                System.out.println("Inserirsci il numero di telefono da cercare: ");
                                telefonoCercare = scanner.nextLine();

                                contRicerca = ricercaConTelefono(gestore, telefonoCercare, contrattiVenduti);
                                break;
                        }


                        if (contRicerca != null) {
                            System.out.println("Ecco il contatto che cercavi");
                            System.out.println(contRicerca.toString());
                        } else {
                            System.out.println("Il contatto non esiste");
                        }
                    } else {
                        System.out.println("Non sono ancora presenti contratti venduti");
                    }
                    break;
                }

                case 4:
                    switch (menu(eliminaContatoSceltaMenu, scanner)) {
                        case 1:
                            System.out.println("Inserirsci il nome da eliminare: ");
                            nomeCancellare = scanner.nextLine();

                            System.out.println("Inserisci il cognome da eliminare: ");
                            cognomeCancellare = scanner.nextLine();

                            if (eliminaContattoConGeneralita(gestore, nomeCancellare, cognomeCancellare, contrattiVenduti)) {
                                System.out.println("Il contatto e' stato eliminato");
                                contrattiVenduti--;
                            } else {
                                System.out.println("Il contatto non era in lista.");
                            }

                            break;
                        case 2:
                            System.out.println("Inserirsci il numero di telefono da eliminare: ");
                            telefonoCancellare = scanner.nextLine();

                            if (eliminaContattoConNumero(gestore, telefonoCancellare, contrattiVenduti)) {
                                System.out.println("Il contatto e' stato eliminato");
                                contrattiVenduti--;
                            } else {
                                System.out.println("Il contatto non era in lista.");
                            }
                            break;

                    }
                    break;
                case 5:
                    break;
                default:
                    fine = false;
                    break;
            }
        } while (fine);
    }

    private static boolean eliminaContattoConGeneralita(Contatto[] gestore, String nome, String cognome, int contrattiVenduti) {
        for (int i = 0; i < contrattiVenduti; i++) {
            if (gestore[i].nome.equals(nome) && gestore[i].cognome.equals(cognome)) {
                // sposto tutti i contatti una posizione in meno
                for (int j = i+1; j < contrattiVenduti; j++) {
                    gestore[i] = gestore[j];
                }

                return true;
            }
        }

        return false;
    }

    private static boolean eliminaContattoConNumero(Contatto[] gestore, String numero, int contrattiVenduti) {
        for (int i = 0; i < contrattiVenduti; i++) {
            if (gestore[i].telefono.equals(numero)) {
                // sposto tutti i contatti una posizione in meno
                for (int j = i+1; j < contrattiVenduti; j++) {
                    gestore[i] = gestore[j];
                }

                return true;
            }
        }

        return false;
    }

    private static Contatto leggiPersona(boolean Sitel, Scanner keyboard) {
        //Sitel è true quando dobbiamo leggere
        String[] tipoC = {"Telefono", "1]abitazione", "2]cellulare", "3]aziendale"};
        //Istanziato un oggetto di tipo contatto:
        Contatto persona = new Contatto();
        System.out.println("\nInserisci il nome: ");
        persona.nome = keyboard.nextLine();
        System.out.println("\nInserisci il cognome: ");
        persona.cognome = keyboard.nextLine();

        if (Sitel) {
            System.out.println("\nInserisci il numero di telefono: ");
            persona.telefono = keyboard.nextLine();  //Vado a leggere il numero di telefono
            //I valori assegnati all'attributo sono compresi nel range
            switch (menu(tipoC, keyboard)) {
                case 1 -> persona.tipo = tipoContratto.abitazione;
                case 2 -> persona.tipo = tipoContratto.cellulare;
                default -> persona.tipo = tipoContratto.aziendale;

            }
        }

        return persona;
    }

    private static Contatto ricercaConGeneralita(Contatto[] gestore, String nome, String cognome, int contrattiVenduti) {
        for (int i = 0; i < contrattiVenduti; i++) {
            if (gestore[i].nome.equals(nome) && gestore[i].cognome.equals(cognome)) {
                return gestore[i];
            }
        }

        return null;
    }

    private static Contatto ricercaConTelefono(Contatto[] gestore, String numero, int contrattiVenduti) {
        for (int i = 0; i < contrattiVenduti; i++) {
            if (gestore[i].telefono.equals(numero)) {
                return gestore[i];
            }
        }

        return null;
    }

    private static void visualizza(Contatto[] gestore, int contrattiVenduti) {
        for (int i = 0; i < contrattiVenduti; i++) {
            System.out.println(gestore[i].toString());
        }
    }

    private static int contaContattiAbitazione(Contatto[] gestore, int contrattiVenduti) {
        int contAbitazione = 0;
        for (int i = 0; i < contrattiVenduti; i++) {
            if (gestore[i].tipo == tipoContratto.abitazione) {
                contAbitazione++;
            }
        }

        return contAbitazione;
    }
}
