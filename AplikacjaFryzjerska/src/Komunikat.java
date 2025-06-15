import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Komunikat extends GUI{
    private JPanel komunikatPanel;
    private JLabel komunikatText;
    private JButton okButton;

    public Komunikat(String tekst){
        super("Komunikat", 400, 200);
        this.komunikatText.setText(tekst);
        this.setContentPane(komunikatPanel);
        this.setVisible(true);
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Komunikat.this.dispose();
            }
        });
    }


}
