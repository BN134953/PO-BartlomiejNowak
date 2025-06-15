import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class AplikacjaController {
    private AplikacjaGUI gui;
    private Uzytkownik uzytkownik;

    public AplikacjaController(AplikacjaGUI gui, Uzytkownik uzytkownik){
        this.gui = gui;
        this.uzytkownik = uzytkownik;
        gui.SetImie(uzytkownik.GetImie() + " " + uzytkownik.GetNazwisko());
    }

    //Metoda do pobierania wizyt z bazy danych i dodawania ich do listy z klasy AplikacjaGUI
    public void ListaWizyt(){
        DefaultListModel listModel = gui.GetListModel();
        String sql = "SELECT wizyty.id, wizyty.klient_id, wizyty.fryzjer_id, fryzjerzy.imie, fryzjerzy.nazwisko, fryzjerzy.nr_telefonu, wizyty.usluga, wizyty.data, wizyty.godzina, wizyty.status FROM wizyty JOIN fryzjerzy ON wizyty.fryzjer_id = fryzjerzy.id WHERE klient_id = " + uzytkownik.GetId();
        ResultSet rs = BazaDanychPolaczenie.Zapytanie(sql);

        try {
            while (rs.next()) {
                //Utwórz obiekt fryzjera z danych z bazy
                Fryzjer fryzjer = new Fryzjer(rs.getInt("fryzjer_id"), rs.getString("imie"), rs.getString("nazwisko"), rs.getString("nr_telefonu"));
                String usluga = rs.getString("usluga");
                String status = rs.getString("status");
                LocalDate data = rs.getDate("data").toLocalDate();
                String godzina = rs.getString("godzina");

                //Utwórz obiekt wizyty i dodaj do listy
                Wizyta wizyta = new Wizyta(fryzjer,usluga,status,data,godzina);
                listModel.addElement(wizyta);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //Otwiera nowe okno umawiania wizyty i zamyka obecne
    public void UmowWizyte(){
        gui.dispose();
        new NowaWizytaGUI(this.uzytkownik);
    }

    //Anuluje wybraną wizytę i aktualizuje bazę oraz GUI
    public void OdwolajWizyte(){
        //Pobieranie zaznaczonej wizyty
        Wizyta wizyta = (Wizyta) gui.GetList().getSelectedValue();
        int FryzjerID = wizyta.GetFryzjer().GetId();
        LocalDate data = wizyta.GetData();
        String godzina = wizyta.GetGodzina();

        //Zapytanie SQL do aktualizacji statusu wizyty
        String sql = "UPDATE wizyty SET status='Odwołana' WHERE klient_id=" + this.uzytkownik.GetId() + " AND fryzjer_id=" + FryzjerID + " AND data='" + data + "' AND godzina='" + godzina + "'";
        BazaDanychPolaczenie.Polecenie(sql);
        //Zmień status wizyty
        wizyta.SetStatus("Odwołana");
        //Odśwież GUI
        gui.repaint();
        //Pokaż komunikat informujący o odwłowaniu wizyty
        new Komunikat("Odwołano wizytę!");
    }


}
