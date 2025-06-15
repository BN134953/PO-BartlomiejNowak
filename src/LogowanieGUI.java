import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LogowanieGUI extends GUI{
    private JTextField loginField;
    private JPasswordField passwordField;
    private JButton zalogujButton;
    private JPanel logowaniePanel;
    private JLabel rejestracjaLabel;
    private LogowanieController controller;

    public LogowanieGUI(){
        super("Panel Logowania", 400,300);
        controller = new LogowanieController(this);

        this.setContentPane(logowaniePanel);
        this.setVisible(true);

        //Działanie przycisku zalogujButton to wywołanie metody Zaloguj z controllera.
        zalogujButton.addActionListener(e -> controller.Zaloguj());

        //Obsługa napisu jako przycisku poprzez MouseListener
        rejestracjaLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //Naciśnięcie napisu usuwa obecne okienko i uruchamia okienko klasy RejestracjaGUI
                dispose();
                new RejestracjaGUI();
            }
        });
    }

    //Zwracanie loginu
    public String GetLogin(){
        return loginField.getText();
    }

    //Zwracanie hasła
    public String GetPassword(){
        return passwordField.getText();
    }
}
