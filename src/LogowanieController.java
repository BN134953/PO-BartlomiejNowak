import java.sql.ResultSet;
import java.sql.SQLException;

public class LogowanieController {
    LogowanieGUI gui;

    public LogowanieController(LogowanieGUI gui){
        this.gui = gui;
    }

    //Metoda służąca do obsługi logowania
    public void Zaloguj(){
        String login = gui.GetLogin();
        String haslo = gui.GetPassword();

        //Sprawdzanie czy login i hasło są wypełnione tekstem a nie puste
        if(!login.equals("") && !haslo.equals("")){
            String sql = "SELECT * FROM uzytkownicy WHERE login='" + login + "' AND haslo='" + haslo +"'";

            //Pobieranie listy wyników wysłania zapytania do bazy danych za pomocą metody Zapytanie w klasie BazaDanychPolaczenie
            ResultSet rs = BazaDanychPolaczenie.Zapytanie(sql);

            try {
                //Sprawdza czy lista wyników rs nie jest pusta
                if(rs.isBeforeFirst()){
                    rs.next();

                    //Pobieranie danych użytkownika z listy wyników i tworzenie nowego użytkownika
                    int id = rs.getInt("id");
                    String imie = rs.getString("imie");
                    String nazwisko = rs.getString("nazwisko");
                    String numer = rs.getString("nr_telefonu");
                    String uprawnienia = rs.getString("uprawnienia");
                    Uzytkownik uzytkownik = new Uzytkownik(id,login,haslo,imie,nazwisko,numer,uprawnienia);
                    //Jeśli osoba logująca się jest klientem uruchamiamy panel dla klientów
                    if (uprawnienia.equals("Klient")) {
                        //Uruchamianie nowego okna AplikacjaGUI wraz z argumentem uzytkownik dla latwiejszego podawania danych uzytkownika
                        new AplikacjaGUI(uzytkownik);
                        gui.dispose();
                    }
                    else{
                        //Jeśli osoba logująca się jest adminem uruchamiamy AdminPanel
                        new AdminPanelGUI();
                        gui.dispose();
                    }
                }
                else{
                    //Uruchamianie nowego okna komunikatu
                    new Komunikat("Podane dane są nieprawidłowe!");
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        else{
            new Komunikat("Żadne pole nie może być puste!");
        }
    }
}
