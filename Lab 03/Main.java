import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner skaner = new Scanner(System.in);
        Random losowa = new Random();

        while (true) {
            System.out.println("Wybierz zadanie (1-5) lub 0 aby zakończyć: ");
            int wybor = skaner.nextInt();

            switch (wybor) {
                case 1:
                    System.out.print("Podaj liczbę studentów: ");
                    int liczbaStudentow = skaner.nextInt();
                    int sumaPunktow = 0, licznik = 0;
                    while (licznik < liczbaStudentow) {
                        System.out.print("Podaj liczbę punktów studenta: ");
                        sumaPunktow += skaner.nextInt();
                        licznik++;
                    }
                    System.out.println("Średnia punktów: " + (double) sumaPunktow / liczbaStudentow);
                    break;

                case 2:
                    int[] liczby = new int[10];
                    int sumaDodatnich = 0, sumaUjemnych = 0;
                    int licznikDodatnich = 0, licznikUjemnych = 0;
                    System.out.println("Podaj 10 liczb:");
                    for (int i = 0; i < 10; i++) {
                        liczby[i] = skaner.nextInt();
                        if (liczby[i] > 0) {
                            sumaDodatnich += liczby[i];
                            licznikDodatnich++;
                        } else if (liczby[i] < 0) {
                            sumaUjemnych += liczby[i];
                            licznikUjemnych++;
                        }
                    }
                    System.out.println("Ilość liczb dodatnich: " + licznikDodatnich + ", ich suma: " + sumaDodatnich);
                    System.out.println("Ilość liczb ujemnych: " + licznikUjemnych + ", ich suma: " + sumaUjemnych);
                    break;

                case 3:
                    System.out.print("Podaj długość ciągu liczb: ");
                    int dlugoscCiagu = skaner.nextInt();
                    int sumaParzystych = 0;
                    System.out.println("Podaj " + dlugoscCiagu + " liczb:");
                    for (int i = 0; i < dlugoscCiagu; i++) {
                        int liczba = skaner.nextInt();
                        if (liczba % 2 == 0) sumaParzystych += liczba;
                    }
                    System.out.println("Suma liczb parzystych: " + sumaParzystych);
                    break;

                case 4:
                    System.out.print("Podaj ilość losowanych liczb: ");
                    int iloscLosowanych = skaner.nextInt();
                    int sumaLosowychParzystych = 0;
                    System.out.println("Wylosowane liczby:");
                    for (int i = 0; i < iloscLosowanych; i++) {
                        int losowaLiczba = losowa.nextInt(56) - 10;
                        System.out.print(losowaLiczba + " ");
                        if (losowaLiczba % 2 == 0) sumaLosowychParzystych += losowaLiczba;
                    }
                    System.out.println("\nSuma liczb parzystych: " + sumaLosowychParzystych);
                    break;

                case 5:
                    System.out.print("Podaj słowo: ");
                    String slowo = skaner.next();
                    String odwrocone = new StringBuilder(slowo).reverse().toString();
                    if (slowo.equals(odwrocone)) {
                        System.out.println("Słowo jest palindromem.");
                    } else {
                        System.out.println("Słowo nie jest palindromem.");
                    }
                    break;

                case 0:
                    System.out.println("Zakończono program.");
                    skaner.close();
                    return;

                default:
                    System.out.println("Niepoprawny wybór. Wybierz od 1 do 5 lub 0 aby zakończyć.");
                    break;
            }
        }
    }
}
