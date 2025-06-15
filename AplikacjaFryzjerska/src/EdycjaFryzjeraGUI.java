import javax.swing.*;

public class EdycjaFryzjeraGUI extends GUI{
    public JTextField idField;
    private JButton zmienIdButton;
    public JTextField imieField;
    private JButton zmienImie;
    public JTextField numerField;
    private JButton zmienNumer;
    public JTextField nazwiskoField;
    private JButton zmienNazwisko;
    private JPanel panel;
    private EdycjaFryzjeraController controller;

    public EdycjaFryzjeraGUI(int id){
        super("Edycja Fryzjera", 500, 500);
        this.controller = new EdycjaFryzjeraController(this, id);

        zmienIdButton.addActionListener(e -> controller.UstawID());
        zmienImie.addActionListener(e -> controller.UstawImie());
        zmienNazwisko.addActionListener(e -> controller.UstawNazwisko());
        zmienNumer.addActionListener(e -> controller.UstawNumer());

        this.setContentPane(panel);
        this.setVisible(true);

    }
}
