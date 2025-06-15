import javax.swing.*;

public class AplikacjaGUI extends GUI{
    private JList list1;
    private DefaultListModel<Wizyta> listModel;
    private JButton nowaWizytaButton;
    private JButton odwolajWizyteButton;
    private JPanel aplikacjaPanel;
    private JLabel imieText;
    private AplikacjaController controller;

    public AplikacjaGUI(Uzytkownik uzytkownik){
        super("Aplikacja Fryzjerska",650,300);
        this.controller = new AplikacjaController(this, uzytkownik);

        //Tworzymy nowy model listy który zawiera Wizyty oraz przypisujemy go do listy
        this.listModel = new DefaultListModel<Wizyta>();
        this.list1.setModel(listModel);

        controller.ListaWizyt();
        this.nowaWizytaButton.addActionListener(e -> controller.UmowWizyte());
        this.odwolajWizyteButton.addActionListener(e -> controller.OdwolajWizyte());

        this.setContentPane(aplikacjaPanel);
        this.setVisible(true);
    }

    public void SetImie(String imie){
        this.imieText.setText(imie);
    }

    //Metoda Zwracająca Model listy
    public DefaultListModel GetListModel(){
        return this.listModel;
    }

    //Metoda Zwracająca Listę
    public JList GetList(){
        return this.list1;
    }
}