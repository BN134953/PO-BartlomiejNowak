import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner skaner = new Scanner(System.in);

        while (true) {
            System.out.println("Wybierz zadanie (1-7) lub 0 aby zakończyć: ");
            int wybor = skaner.nextInt();

            switch (wybor) {
                case 1:
                    zadanie1();
                    break;
                case 2:
                    zadanie2();
                    break;
                case 3:
                    zadanie3();
                    break;
                case 4:
                    zadanie4();
                    break;
                case 5:
                    zadanie5();
                    break;
                case 6:
                    zadanie6();
                    break;
                case 7:
                    zadanie7();
                    break;
                case 0:
                    System.out.println("Zakończono program.");
                    skaner.close();
                    return;
                default:
                    System.out.println("Niepoprawny wybór. Wybierz od 1 do 7 lub 0 aby zakończyć.");
                    break;
            }
        }
    }

    public static void zadanie1() {
        Random rand = new Random();
        int[] tablica = new int[10];
        int suma = 0;

        for (int i = 0; i < tablica.length; i++) {
            tablica[i] = rand.nextInt(100); 
            suma += tablica[i];
        }

        System.out.println("Tablica: " + Arrays.toString(tablica));
        System.out.println("Suma: " + suma);
        System.out.println("Średnia: " + (double) suma / tablica.length);
    }

    public static void zadanie2() {
        int[] parzysta = {2, 4, 6, 8};
        int[] nieparzysta = {1, 3, 5};
        System.out.println("Drugi element tablicy parzystej: " + parzysta[1]);
        System.out.println("Drugi element tablicy nieparzystej: " + nieparzysta[1]);
    }

    public static void zadanie3() {
        String[] slowa = {"java", "programowanie", "tablica"};
        for (String slowo : slowa) {
            System.out.println(slowo.toUpperCase());
        }
    }

    public static void zadanie4() {
        Scanner skaner = new Scanner(System.in);
        String[] slowa = new String[5];
        for (int i = 0; i < 5; i++) {
            System.out.print("Podaj słowo: ");
            slowa[i] = skaner.next();
        }

        System.out.println("Odwrócone słowa: ");
        for (int i = slowa.length - 1; i >= 0; i--) {
            System.out.println(new StringBuilder(slowa[i]).reverse());
        }
    }

    public static void zadanie5() {
        Scanner skaner = new Scanner(System.in);
        int[] liczby = new int[7];
        for (int i = 0; i < liczby.length; i++) {
            System.out.print("Podaj liczbę: ");
            liczby[i] = skaner.nextInt();
        }
        Arrays.sort(liczby);
        System.out.println("Posortowana tablica: " + Arrays.toString(liczby));
    }

    public static void zadanie6() {
        Scanner skaner = new Scanner(System.in);
        int[] liczby = new int[5];
        for (int i = 0; i < liczby.length; i++) {
            System.out.print("Podaj liczbę: ");
            liczby[i] = skaner.nextInt();
        }

        for (int liczba : liczby) {
            System.out.println("Silnia z " + liczba + " wynosi " + silnia(liczba));
        }
    }

    public static int silnia(int n) {
        if (n == 0 || n == 1) return 1;
        return n * silnia(n - 1);
    }

    public static void zadanie7() {
        String[] tablica1 = {"kot", "pies", "mysz"};
        String[] tablica2 = {"kot", "pies", "mysz"};

        if (Arrays.equals(tablica1, tablica2)) {
            System.out.println("Tablice są takie same.");
        } else {
            System.out.println("Tablice są różne.");
        }
    }
}
