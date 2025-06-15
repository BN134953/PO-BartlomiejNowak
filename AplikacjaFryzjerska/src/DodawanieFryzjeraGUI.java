import javax.swing.*;

public class DodawanieFryzjeraGUI extends GUI{
    private JTextField imieField;
    private JTextField numerField;
    private JTextField nazwiskoField;
    private JButton dodajButton;
    private JPanel panel;
    private DodawanieFryzjeraController controller;

    public DodawanieFryzjeraGUI(){
        super("Dodawanie Fryzjera", 400, 500);
        this.controller = new DodawanieFryzjeraController(this);

        dodajButton.addActionListener(e -> controller.Dodaj());

        this.setContentPane(panel);
        this.setVisible(true);
    }

    public String getImie(){
        return this.imieField.getText();
    }

    public String getNumer(){
        return this.numerField.getText();
    }

    public String getNazwisko(){
        return this.nazwiskoField.getText();
    }


}
