public class EdycjaFryzjeraController {
    private EdycjaFryzjeraGUI gui;
    int id;

    public EdycjaFryzjeraController(EdycjaFryzjeraGUI gui, int id){
        this.gui = gui;
        this.id = id;
    }

    public void UstawID(){
        String ID = gui.idField.getText();

        if(!ID.equals("")){
            // Aktualizuj ID fryzjera w tabeli fryzjerzy
            String sql = "UPDATE fryzjerzy SET id=" + Integer.parseInt(ID) + " WHERE id=" + this.id;
            BazaDanychPolaczenie.Polecenie(sql);
            // Aktualizuj powiązane wizyty z nowym ID fryzjera
            String sql2 = "UPDATE wizyty SET fryzjer_id=" + Integer.parseInt(ID) + " WHERE fryzjer_id=" + this.id;
            BazaDanychPolaczenie.Polecenie(sql2);
            // Otwórz panel admina i zamknij GUI edycji
            new AdminPanelGUI();
            gui.dispose();
        }
        else{
            new Komunikat("Podaj nowe ID!");
        }
    }

    public void UstawImie(){
        String imie = gui.imieField.getText();

        if(!imie.equals("")){
            // Aktualizuj imię fryzjera w bazie danych
            String sql = "UPDATE fryzjerzy SET imie='" + imie + "' WHERE id=" + this.id;
            BazaDanychPolaczenie.Polecenie(sql);
            new AdminPanelGUI();
            gui.dispose();
        }
        else{
            new Komunikat("Podaj nowe Imie!");
        }
    }

    public void UstawNazwisko(){
        String nazwisko = gui.nazwiskoField.getText();

        if(!nazwisko.equals("")){
            // Aktualizuj nazwisko fryzjera w bazie danych
            String sql = "UPDATE fryzjerzy SET nazwisko='" + nazwisko + "' WHERE id=" + this.id;
            BazaDanychPolaczenie.Polecenie(sql);
            new AdminPanelGUI();
            gui.dispose();
        }
        else{
            new Komunikat("Podaj nowe Nazwisko!");
        }
    }

    public void UstawNumer(){
        String numer = gui.numerField.getText();

        if(!numer.equals("")){
            // Aktualizuj numer telefonu fryzjera w bazie danych
            String sql = "UPDATE fryzjerzy SET nr_telefonu='" + numer + "' WHERE id=" + this.id;
            BazaDanychPolaczenie.Polecenie(sql);
            new AdminPanelGUI();
            gui.dispose();
        }
        else{
            new Komunikat("Podaj nowy Numer Telefonu!");
        }
    }
}
