import javax.swing.*;

public class RejestracjaGUI extends GUI{
    private JTextField loginField;
    private JPasswordField hasloField;
    private JButton zarejestrujButton;
    private JTextField imieField;
    private JTextField nazwiskoField;
    private JTextField nrTelefonuField;
    private JPanel panelRejestracji;
    private RejestracjaController controller;


    RejestracjaGUI(){
        super("Rejestracja",400,400);
        this.controller = new RejestracjaController(this);

        this.setContentPane(panelRejestracji);
        this.setVisible(true);

        zarejestrujButton.addActionListener(e -> controller.Zarejestruj());
    }

    public String GetLogin(){
        return loginField.getText();
    }

    public String GetHaslo(){
        return hasloField.getText();
    }

    public String GetImie(){
        return imieField.getText();
    }

    public String GetNazwisko(){
        return nazwiskoField.getText();
    }

    public String GetNumer(){
        return this.nrTelefonuField.getText();
    }
}
