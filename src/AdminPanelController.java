import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class AdminPanelController {
    AdminPanelGUI gui;

    public AdminPanelController(AdminPanelGUI gui) {
        this.gui = gui;
    }

    public void ListaWizyt() {
        DefaultListModel listModel = gui.GetWizytyListModel();
        String sql = "SELECT * from wizyty";
        ResultSet rs = BazaDanychPolaczenie.Zapytanie(sql);

        try {
            while (rs.next()) {
                int idWizyty = rs.getInt("id");
                String usluga = rs.getString("usluga");
                String status = rs.getString("status");
                LocalDate data = rs.getDate("data").toLocalDate();
                String godzina = rs.getString("godzina");
                int idKlienta = rs.getInt("klient_id");
                int idFryzjera = rs.getInt("fryzjer_id");

                // Utwórz obiekt wizyty i zapisz je do listy
                Wizyta wizyta = new Wizyta(idWizyty,idKlienta, idFryzjera, usluga, status, data, godzina);

                listModel.addElement(wizyta);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void EdytujWizyte(){
        Wizyta wizyta = (Wizyta) gui.GetWizytyList().getSelectedValue();
        if(wizyta == null){
            new Komunikat("Wybierz wizytę!");
            return;
        }
        // Przekaż id wizyty do dialogu edycji
        new EdycjaWizytyGUI(wizyta.wizytaID);
        gui.dispose();
    }

    public void UsunWizyte(){
        Wizyta wizyta = (Wizyta) gui.GetWizytyList().getSelectedValue();
        if(wizyta == null){
            new Komunikat("Wybierz wizytę!");
            return;
        }
        // Usuń wizytę z bazy na podstawie ID
        String sql = "DELETE FROM wizyty WHERE id=" + wizyta.wizytaID;
        BazaDanychPolaczenie.Polecenie(sql);
        // Usuń wizytę z listy w GUI i odśwież widok
        gui.GetWizytyListModel().removeElement(wizyta);
        gui.GetWizytyList().repaint();
    }

    public void ListaFryzjerow(){
        DefaultListModel listModel = gui.GetFryzjerzyListModel();
        String sql = "SELECT * from fryzjerzy";
        ResultSet rs = BazaDanychPolaczenie.Zapytanie(sql);

        try {
            while (rs.next()) {
                int idFryzjera = rs.getInt("id");
                String imie = rs.getString("imie");
                String nazwisko = rs.getString("nazwisko");
                String numer = rs.getString("nr_telefonu");

                // Utwórz obiekt fryzjera i zapisz je do listy
                Fryzjer fryzjer = new Fryzjer(idFryzjera,imie,nazwisko,numer);

                listModel.addElement(fryzjer);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void EdytujFryzjera(){
        Fryzjer fryzjer = (Fryzjer) gui.GetFryzjerzyList().getSelectedValue();
        if(fryzjer == null){
            new Komunikat("Wybierz fryzjera!");
            return;
        }
        // Przekaż id fryzjera do dialogu edycji
        new EdycjaFryzjeraGUI(fryzjer.GetId());
        gui.dispose();
    }

    public void UsunFryzjera(){
        Fryzjer fryzjer = (Fryzjer) gui.GetFryzjerzyList().getSelectedValue();
        if(fryzjer == null){
            new Komunikat("Wybierz fryzjera!");
            return;
        }
        // Usuń fryzjera z bazy na podstawie ID
        String sql = "DELETE FROM fryzjerzy WHERE id=" + fryzjer.GetId();
        BazaDanychPolaczenie.Polecenie(sql);
        // Usuń fryzjera z listy w GUI i odśwież widok
        gui.GetFryzjerzyListModel().removeElement(fryzjer);
        gui.GetFryzjerzyList().repaint();
    }

    public void DodajFryzjera(){
        // Otwórz okno dodawania nowego fryzjera i zamknij aktualne GUI
        new DodawanieFryzjeraGUI();
        gui.dispose();
    }
}
