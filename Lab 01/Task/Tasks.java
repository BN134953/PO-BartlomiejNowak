package Task;
import java.util.Scanner;

public class Tasks {

 public String zad1(){

     Scanner scanner = new Scanner(System.in);
     System.out.println("Podaj swoje imię: ");
     String imie = scanner.nextLine();
     System.out.println("Podajk swój wiek: ");
     String wiek = scanner.nextLine();
return "Twoje imię to: " + imie +"\n"+"Twój wiek: " + wiek;
     
} 
    public String zad2(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj pierwszą liczbę: ");
        int liczba1 = scanner.nextInt();
        System.out.println("Podaj drugą liczbę: ");
        int liczba2 = scanner.nextInt();
        int suma = liczba1 + liczba2;
        int roznica = liczba1 - liczba2;
        int iloczyn = liczba1 * liczba2;
return "Suma: " + suma + "\n" + "Różnica: " + roznica + "\n" + "Iloczyn: " + iloczyn;
    } 

    public String zad3()
        {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Podaj liczbę: ");
            int liczba = scanner.nextInt();
            if(liczba % 2 == 0){


                return "Liczba jest parzysta";
            }
            else
            {
                return "Liczba jest nie parzysta";
            }
        }
        
public String zad4()
    {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj liczbę: ");
                int liczba = scanner.nextInt();
                if(liczba % 3 == 0 & liczba % 5 == 0){


                    return "Liczba jest podzielna przez 3 i 5";
                }
                else
                {
                    return "Liczba jest nie jest podzielna przez 3 i 5";
                }
    
    }

public String zad5(){

Scanner scanner = new Scanner(System.in);
    System.out.println("Podaj liczbę: ");
    double liczba = scanner.nextInt();
     double wynik = Math.pow(liczba, 3);
    return "Liczba do potęgi 3: " + wynik;

    
}
  public String zad6(){
Scanner scanner = new Scanner(System.in);
      System.out.println("Podaj liczbę: ");
      double liczba = scanner.nextDouble();
        double wynik = Math.sqrt(liczba);
        return "Pierwiastek kwadratowy: " + wynik;
      

      
  }  

public String zad7(){
Scanner scanner = new Scanner(System.in);
    System.out.println("Podaj wartość a: ");
    double a = scanner.nextDouble();
    System.out.println("Podaj wartość b: ");
    double b = scanner.nextDouble();
double a2 = Math.pow(a, 2);
double b2 = Math.pow(b, 2);
   double wynik = a2 + b2;
double pitagoras =  Math.sqrt(wynik);
     

if(a > 0 && b > 0){

    return "przeciwprostokątna c= " + pitagoras +"\n"+"Można zbudowac trójkąt prostokątny";
    
}

  else {
    return "Nie można zbudować trójkąta, ponieważ boki muszą być dodatnie";
        }
    
    
}
    
    
}

    

