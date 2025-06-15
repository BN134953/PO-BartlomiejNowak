public class DodawanieFryzjeraController {
    private DodawanieFryzjeraGUI gui;

    public DodawanieFryzjeraController(DodawanieFryzjeraGUI gui){
        this.gui = gui;
    }

    public void Dodaj(){
        String imie = gui.getImie();
        String nazwisko = gui.getNazwisko();
        String numer = gui.getNumer();

        if(!imie.equals("") && !nazwisko.equals("") && !numer.equals("")){
            String sql = "INSERT INTO fryzjerzy(imie,nazwisko,nr_telefonu) VALUES('" + imie + "','" + nazwisko + "','" + numer + "');";
            BazaDanychPolaczenie.Polecenie(sql);
            new AdminPanelGUI();
            gui.dispose();
        }else{
            new Komunikat("Musisz podać wszystkie dane!");
        }
    }
}
