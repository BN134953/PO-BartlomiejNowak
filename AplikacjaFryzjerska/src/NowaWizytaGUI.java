import javax.swing.*;

public class NowaWizytaGUI extends GUI{
    private JPanel nowawizytaPanel;
    private JComboBox dzienBox;
    private JComboBox miesiacBox;
    private JComboBox uslugaBox;
    private JButton sprawdźDostępnychFryzjerówButton;
    private JComboBox godzinaBox;
    private JComboBox fryzjerzyBox;
    private JLabel wybierzFryzjeraText;
    private JPanel wybierzFryzjeraPanel;
    private JButton umowWizyteButton;
    private Uzytkownik uzytkownik;
    private NowaWizytaController controller;

    public NowaWizytaGUI(Uzytkownik uzytkownik){
        super("Umów się na wizytę!", 300,300);
        this.uzytkownik = uzytkownik;
        this.controller = new NowaWizytaController(this, uzytkownik);
        this.controller.UstawBoxy();

        this.sprawdźDostępnychFryzjerówButton.addActionListener(e -> controller.DostepniFryzjerzy());
        this.umowWizyteButton.addActionListener(e -> controller.UmowWizyte());

        this.setContentPane(nowawizytaPanel);
        this.setVisible(true);
    }

    public JComboBox GetDzienBox(){
        return this.dzienBox;
    }

    public JComboBox GetMiesiacBox(){
        return this.miesiacBox;
    }

    public JComboBox GetGodzinaBox(){
        return this.godzinaBox;
    }

    public JComboBox GetUslugiBox(){
        return this.uslugaBox;
    }

    public JComboBox GetFryzjerzyBox() {
        return fryzjerzyBox;
    }

    public JPanel GetFryzjerzyPanel(){
        return wybierzFryzjeraPanel;
    }

    public int GetDzien(){
        return (int) dzienBox.getSelectedItem();
    }

    public int GetMiesiac(){
        return miesiacBox.getSelectedIndex() + 1;
    }

    public String GetGodzina(){
        return (String) godzinaBox.getSelectedItem();
    }
}
