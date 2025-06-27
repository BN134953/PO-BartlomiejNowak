import javax.swing.*;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Date;

//Kontroler obsługujący logikę umawiania nowej wizyty
public class NowaWizytaController {
    private NowaWizytaGUI gui;
    //Zalogowany użytkownik
    private Uzytkownik uzytkownik;
    String[] miesiace;

    //Konstruktor przypisuje GUI i użytkownika
    public NowaWizytaController(NowaWizytaGUI gui, Uzytkownik uzytkownik){
        this.gui = gui;
        this.uzytkownik = uzytkownik;
    }

    public void UstawBoxy() {
        JComboBox<Integer> dniBox = gui.GetDzienBox();
        JComboBox<String> miesiaceBox = gui.GetMiesiacBox();
        JComboBox<String> uslugiBox = gui.GetUslugiBox();
        JComboBox<String> godzinaBox = gui.GetGodzinaBox();

        dniBox.removeAllItems();
        miesiaceBox.removeAllItems();
        uslugiBox.removeAllItems();
        godzinaBox.removeAllItems();

        LocalDate today = LocalDate.now();
        int todayDay = today.getDayOfMonth();
        int todayMonth = today.getMonthValue(); // 1–12

        String[] miesiace = {"Styczeń", "Luty", "Marzec", "Kwiecień", "Maj", "Czerwiec",
                "Lipiec", "Sierpień", "Wrzesień", "Październik", "Listopad", "Grudzień"};

        for (String miesiac : miesiace) {
            miesiaceBox.addItem(miesiac);
        }

        // Nasłuchiwanie na zmianę miesiąca
        miesiaceBox.addActionListener(e -> {
            int selectedMonth = miesiaceBox.getSelectedIndex() + 1;

            //Jeśli wybrany miesiąc już minął – przywróć wybór na dzisiejszy miesiąc
            if (selectedMonth < todayMonth) {
                miesiaceBox.setSelectedIndex(todayMonth - 1);
                return;
            }

            dniBox.removeAllItems();

            YearMonth yearMonth = YearMonth.of(today.getYear(), selectedMonth);
            int daysInMonth = yearMonth.lengthOfMonth();
            int startDay = (selectedMonth == todayMonth) ? todayDay : 1;

            for (int i = startDay; i <= daysInMonth; i++) {
                dniBox.addItem(i);
            }
        });

        //Wywołaj ręcznie, żeby ustawić dni na start
        miesiaceBox.setSelectedIndex(todayMonth - 1); // Ustaw bieżący miesiąc
        miesiaceBox.getActionListeners()[0].actionPerformed(null);

        //Usługi
        String[] uslugi = {"Strzyżenie", "Farbowanie Włosów", "Modelowanie Włosów"};
        for (String usluga : uslugi) {
            uslugiBox.addItem(usluga);
        }

        for (int i = 10; i <= 18; i++) {
            godzinaBox.addItem(i + ":00");
        }
    }


    //Pobieranie dostępnych fryzjerów na wybrany termin i godzinę
    public void DostepniFryzjerzy(){
        //Pobieranie ComboBox fryzjerów
        JComboBox<Fryzjer> fryzjerzyBox = gui.GetFryzjerzyBox();
        //Pobieranie panelu który jest nie widoczny dopóki użytkownik nie poda daty i godziny
        JPanel fryzjerzyPanel = gui.GetFryzjerzyPanel();
        //Pobieranie terminu wizyty
        int dzien = gui.GetDzien();
        int miesiac = gui.GetMiesiac();
        //Tworzenie daty, rok jest pobierany z komputera, miesiąc i dzień ustawiane są na wybrane przez użytkownika
        LocalDate data = LocalDate.of(LocalDate.now().getYear(),miesiac,dzien);
        String godzina = gui.GetGodzina();

        System.out.println(data + " " +godzina);

        //Pobieranie listy dostępnych fryzjerów z bazy danych
        String sql = "SELECT f.id, f.imie, f.nazwisko, f.nr_telefonu FROM fryzjerzy f WHERE NOT EXISTS (SELECT 1 FROM wizyty w WHERE w.fryzjer_id = f.id AND w.data = '" + data + "' AND w.godzina = '" +  godzina + "' AND w.status!='odwołana');";
        ResultSet rs = BazaDanychPolaczenie.Zapytanie(sql);

        try {
            //Dla każdego dostępnego fryzjera tworzony jest obiekt fryzjer który jest dodawany do ComboBoxa
            if (rs.isBeforeFirst()) {
                while (rs.next()) {
                    int fryzjerID = rs.getInt("id");
                    String fryzjerImie = rs.getString("imie");
                    String fryzjerNazwisko = rs.getString("nazwisko");
                    String fryzjerNumer = rs.getString("nr_telefonu");
                    Fryzjer fryzjer = new Fryzjer(fryzjerID,fryzjerImie,fryzjerNazwisko,fryzjerNumer);

                    fryzjerzyBox.addItem(fryzjer);
                }

                fryzjerzyPanel.setVisible(true);

            }
            else{
                new Komunikat("Na wybrany termin nie ma dostępnego żadnego fryzjera!");
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    //Tworzy nową wizytę w bazie i otwiera główne okno aplikacji
    public void UmowWizyte(){
        //Pobieranie ID klienta
        int klientID = this.uzytkownik.GetId();

        //Pobieranie wybranego fryzjera
        Fryzjer fryzjer = (Fryzjer) gui.GetFryzjerzyBox().getSelectedItem();
        int fryzjerID = fryzjer.GetId();

        int dzien = gui.GetDzien();
        int miesiac = gui.GetMiesiac();

        //Tworzenie daty
        LocalDate data = LocalDate.of(LocalDate.now().getYear(), miesiac, dzien);
        //Pobieranie godziny
        String godzina = gui.GetGodzina();
        //Pobieranie usługi
        String usluga = (String) gui.GetUslugiBox().getSelectedItem();

        //Polecenie SQL dodania nowej wizyty
        String sql = "INSERT INTO wizyty(klient_id,fryzjer_id,data,godzina,usluga) VALUES(" + klientID +"," + fryzjerID + ",'" + data +"','" + godzina + "','" + usluga +"');";
        //Wykonanie polecenia
        BazaDanychPolaczenie.Polecenie(sql);
        gui.dispose();
        new AplikacjaGUI(this.uzytkownik);
        new Komunikat("Umówienie wizyty zakończone powodzeniem!");


    }
}
