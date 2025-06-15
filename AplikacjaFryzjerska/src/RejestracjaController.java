import javax.print.attribute.standard.DialogOwner;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RejestracjaController {
    private RejestracjaGUI gui;

    public RejestracjaController(RejestracjaGUI gui){
        this.gui = gui;
    }

    public void Zarejestruj(){
        //Pobieranie danych wpisanych przez użytkownika
        String login = gui.GetLogin();
        String haslo = gui.GetHaslo();
        String imie = gui.GetImie();
        String nazwisko = gui.GetNazwisko();
        String numer = gui.GetNumer();

        //Jeśli wynik funkcji CzyTakieKontoIstnieje wraz z argumentem loginu podanego przez uzytkownika zwraca false to możemy stworzyć nowe konto o tym loginie
        if (!CzyTakieKontoIstnieje(login)) {

            //Sprawdza czy pola danych zostały wypełnione
            if(!login.equals("") && !haslo.equals("") && !imie.equals("") && !nazwisko.equals("") && !numer.equals("")){

                //Polecenie tworzące nowego użytkownika
                String sql = "INSERT INTO uzytkownicy(login,haslo,imie,nazwisko,nr_telefonu) VALUES('" + login + "','"+haslo+"','"+imie+"','"+nazwisko+"','"+numer+"');";
                BazaDanychPolaczenie.Polecenie(sql);
                gui.dispose();
                new LogowanieGUI();
                //Nowy komunikat informujący o pomyślnym stworzeniu nowego konta
                new Komunikat("Konto zostało utworzone pomyślnie!");
            }
            else{
                //Nowy komunikat informujący o niepoprawnym wypełnieniu pól danych
                new Komunikat("Dane nie mogą być puste!");
            }
        }
        else{
            //Nowy komunikat informujący o istniejącym już koncie
            new Komunikat("Konto z tym loginem już istnieje!");
        }
    }

    //Metoda sprawdzająca czy konto o podanym loginie już istnieje
    public boolean CzyTakieKontoIstnieje(String login){
        String zapytanie = "SELECT * FROM uzytkownicy WHERE login='"+login+"';";
        ResultSet rs = BazaDanychPolaczenie.Zapytanie(zapytanie);

        try {
            //Jeśli lista wyników jest pusta to znaczy że konto nie istnieje, w przeciwnym wypadku konto istnieje
            if(!rs.isBeforeFirst()){
                return false;
            }else{
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
