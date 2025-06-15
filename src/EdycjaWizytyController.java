public class EdycjaWizytyController {
    private EdycjaWizytyGUI gui;
    private int id;

    public EdycjaWizytyController(EdycjaWizytyGUI gui, int id){
        this.gui = gui;
        this.id = id;
    }

    public void UstawID(){
        String ID = gui.idField.getText();

        if(!ID.equals("")){
            //Aktualizuj ID wizyty w bazie danych
            String sql = "UPDATE wizyty SET id=" + Integer.parseInt(ID) + " WHERE id=" + this.id;
            BazaDanychPolaczenie.Polecenie(sql);
            new AdminPanelGUI();
            gui.dispose();
        }
        else{
            new Komunikat("Podaj nowe ID!");
        }
    }

    public void UstawIDKlienta(){
        String ID = gui.idKlientaField.getText();

        if(!ID.equals("")){
            //Aktualizuj ID klienta powiązanego z wizytą
            String sql = "UPDATE wizyty SET klient_id=" + Integer.parseInt(ID) + " WHERE id=" + this.id;
            BazaDanychPolaczenie.Polecenie(sql);
            new AdminPanelGUI();
            gui.dispose();
        }
        else{
            new Komunikat("Podaj nowe ID!");
        }
    }

    public void UstawIDFyzjera(){
        String ID = gui.idFryzjeraField.getText();

        if(!ID.equals("")){
            //Aktualizuj ID fryzjera powiązanego z wizytą
            String sql = "UPDATE wizyty SET fryzjer_id=" + Integer.parseInt(ID) + " WHERE id=" + this.id;
            BazaDanychPolaczenie.Polecenie(sql);
            new AdminPanelGUI();
            gui.dispose();
        }
        else{
            new Komunikat("Podaj nowe ID!");
        }
    }

    public void UstawDate(){
        String data = gui.dataField.getText();

        if(!data.equals("")){
            //Aktualizuj datę wizyty
            String sql = "UPDATE wizyty SET data='" + data + "' WHERE id=" + this.id;
            BazaDanychPolaczenie.Polecenie(sql);
            new AdminPanelGUI();
            gui.dispose();
        }
        else{
            new Komunikat("Podaj nowa Datę!");
        }
    }

    public void UstawGodzine(){
        String godzina = gui.godzinaField.getText();

        if(!godzina.equals("")){
            //Aktualizuj godzinę wizyty
            String sql = "UPDATE wizyty SET godzina='" + godzina + "' WHERE id=" + this.id;
            BazaDanychPolaczenie.Polecenie(sql);
            new AdminPanelGUI();
            gui.dispose();
        }
        else{
            new Komunikat("Podaj nowa Godzinę!");
        }
    }

    public void UstawStatus(){
        String status = gui.statusField.getText();

        if(!status.equals("")){
            //Aktualizuj status wizyty
            String sql = "UPDATE wizyty SET status='" + status + "' WHERE id=" + this.id;
            BazaDanychPolaczenie.Polecenie(sql);
            new AdminPanelGUI();
            gui.dispose();
        }
        else{
            new Komunikat("Podaj nowy Status!");
        }
    }

    public void UstawUsluge(){
        String usluga = gui.uslugaField.getText();

        if(!usluga.equals("")){
            //Aktualizuj usługę powiązaną z wizytą
            String sql = "UPDATE wizyty SET usluga='" + usluga + "' WHERE id=" + this.id;
            BazaDanychPolaczenie.Polecenie(sql);
            new AdminPanelGUI();
            gui.dispose();
        }
        else{
            new Komunikat("Podaj nową Usługę!");
        }
    }
}
