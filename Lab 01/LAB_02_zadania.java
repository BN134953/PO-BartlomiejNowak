import java.util.Scanner;

class LAB_02_zadania {

    public static void main(String[] args) {
        Scanner skaner = new Scanner(System.in);
        System.out.println("Wybierz opcje");
        int wybor = skaner.nextInt();

        switch (wybor) {
            case 1:
                zad1();
                break;
            case 2:
                zad2();
                break;
            case 3:
                zad3();
                break;
            case 4:
                zad4();
                break;
            case 5:
                zad5();
                break;
            case 6:
                zad6();
                break;
            default:
                System.out.println("Nie ma takeigo zadania");
                break;

        }

    }

    public static void zad1() {
        Scanner skaner = new Scanner(System.in);
        System.out.print("Podaj współczynnik a: ");
        double a = skaner.nextDouble();
        System.out.print("Podaj współczynnik b: ");
        double b = skaner.nextDouble();
        System.out.print("Podaj współczynnik c: ");
        double c = skaner.nextDouble();

        double delta = b * b - 4 * a * c;

        if (delta > 0) {
            double x1 = (-b + Math.sqrt(delta)) / (2 * a);
            double x2 = (-b - Math.sqrt(delta)) / (2 * a);
            System.out.println("Równanie ma dwa pierwiastki: x1 = " + x1 + ", x2 = " + x2);
        } else if (delta == 0) {
            double x = -b / (2 * a);
            System.out.println("Równanie ma jeden pierwiastek: x = " + x);
        } else {
            System.out.println("Równanie nie ma rozwiązań w zbiorze liczb rzeczywistych.");
        }
    }

    public static void zad2() {
        Scanner skaner = new Scanner(System.in);
        System.out.print("Podaj wartość x: ");
        double x = skaner.nextDouble();

        System.out.println("Wybierz funkcję: a, b lub c");
        char wybor = skaner.next().charAt(0);

        switch (wybor) {
            case 'a':
                if (x > 0) {
                    System.out.println("a(x) = " + (2 * x));
                } else if (x == 0) {
                    System.out.println("a(x) = 0");
                } else {
                    System.out.println("a(x) = " + (-3 * x));
                }
                break;
            case 'b':
                if (x >= 1) {
                    System.out.println("b(x) = " + (x * x));
                } else {
                    System.out.println("b(x) = " + x);
                }
                break;
            case 'c':
                if (x > 2) {
                    System.out.println("c(x) = " + (2 + x));
                } else if (x == 2) {
                    System.out.println("c(x) = 8");
                } else {
                    System.out.println("c(x) = " + (x - 4));
                }
                break;
            default:
                System.out.println("Niepoprawny wybór funkcji.");
        }
    }

    public static void zad3() {
        Scanner skaner = new Scanner(System.in);

        System.out.println("Podaj liczbę x: ");
        int x = skaner.nextInt();
        System.out.println("Podaj liczbę y: ");
        int y = skaner.nextInt();
        System.out.println("Podaj liczbę z: ");
        int z = skaner.nextInt();

        int min = x;
        int max = x;

        if (y < min) {
            min = y;
        }
        if (y > max) {
            max = y;
        }

        if (z < min) {
            min = z;

        }
        if (z > max) {
            max = z;
        }
        int srodkowa = (x + y + z) - min - max;
        System.out.println("Największa liczba to: " + max);
        System.out.println("Najmniejsza liczba to: " + min);
        System.out.println("Środkowa liczba to: " + srodkowa);
    }

    public static void zad4() {
        Scanner skaner = new Scanner(System.in);
        System.out.println("Pada deszcz? (tak/nie)");
        String deszcz = skaner.nextLine();
        System.out.println("Jest autobus? (tak/nie)");
        String autobus = skaner.nextLine();

        if (deszcz.equals("tak") && autobus.equals("tak")) {
            System.out.println("weź parasol, dostaniesz się na uczelnie");
        } else if (deszcz.equals("tak") && autobus.equals("nie")) {
            System.out.println("Nie dostaniesz się na uczelnie");
        } else if (deszcz.equals("nie") && autobus.equals("tak")) {

            System.out.println("Dostaniesz się na uczelnie, Miłego dnia i pięknej pogody");
        }
    }

    public static void zad5() {
        Scanner skaner = new Scanner(System.in);
        System.out.println("Jest zniżka na samochód? (tak/nie)");
        String znizka = skaner.nextLine();
        System.out.println("Otrzymałeś premię? (tak/nie)");
        String premia = skaner.nextLine();

        if (znizka.equals("nie") && premia.equals("tak")) {
            System.out.println("Możesz kupić samochód");
            System.out.println("Zniżki na samochód nie ma!");
        }

        else if (znizka.equals("nie") && premia.equals("nie")) {
            System.out.println("Zakup samochód trzeba odłożyć na później");
            System.out.println("Zniżki na samochód nie ma!");

        } else if (znizka.equals("tak") || premia.equals("tak")) {
            System.out.println("Możesz kupić samochód!");

        }
    }

    public static void zad6() {
        Scanner skaner = new Scanner(System.in);

        System.out.println("Dodawanie - 1");
        System.out.println("Odejmowanie - 2");
        System.out.println("Iloczyn - 3");
        System.out.println("Iloraz - 4");
        System.out.println("Reszta z dzielenia - 5");
        System.out.println("Podaj numer działania: ");
        int wybor = skaner.nextInt();
        System.out.println("Podaj pierwszą liczbę: ");
        float liczba1 = skaner.nextInt();
        System.out.println("Podaj drugą liczbę: ");
        float liczba2 = skaner.nextInt();
        System.out.println("Twoja pierwsza liczba: " + liczba1);
        System.out.println("Twoja druga liczba: " + liczba2);

        switch (wybor) {
            case 1:
                float suma = liczba1 + liczba2;
                System.out.println("Suma: " + suma);
                break;

            case 2:
                float roznica = liczba1 - liczba2;
                System.out.println("Różnica: " + roznica);
                break;

            case 3:
                float iloczyn = liczba1 * liczba2;
                System.out.println("Iloczyn: " + iloczyn);
                break;

            case 4:
                if (liczba2 != 0) {
                    float Iloraz = liczba1 / liczba2;
                    System.out.println("Iloraz: " + Iloraz);
                } else {
                    System.out.println("Nie można dzielić przez 0");

                }

                break;
            case 5:
                if (liczba2 != 0) {

                    float reszta = liczba1 % liczba2;

                    System.out.println("Reszta z dzielenia: " + reszta);
                } else {
                    System.out.println("Nie można dzielić przez 0");

                }
                break;
        }

    }

}