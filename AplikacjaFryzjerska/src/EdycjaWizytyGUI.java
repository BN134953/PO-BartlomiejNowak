import javax.swing.*;

public class EdycjaWizytyGUI extends GUI{
    public JTextField idField;
    private JButton zmienIdButton;
    public JTextField idKlientaField;
    public JTextField idFryzjeraField;
    public JTextField dataField;
    public JTextField godzinaField;
    public JTextField uslugaField;
    private JButton zmienIdKlienta;
    private JButton zmienIdFryzjera;
    private JButton zmienDate;
    private JButton zmienGodzine;
    private JButton zmienUsluge;
    private JPanel panel;
    public JTextField statusField;
    private JButton zmienStatus;
    private EdycjaWizytyController controller;

    public EdycjaWizytyGUI(int id){
        super("Edycja Wizyty", 500,600);
        this.controller = new EdycjaWizytyController(this, id);

        zmienIdButton.addActionListener(e -> controller.UstawID());
        zmienIdKlienta.addActionListener(e -> controller.UstawIDKlienta());
        zmienIdFryzjera.addActionListener(e -> controller.UstawIDFyzjera());
        zmienDate.addActionListener(e -> controller.UstawDate());
        zmienGodzine.addActionListener(e -> controller.UstawGodzine());
        zmienUsluge.addActionListener(e -> controller.UstawUsluge());
        zmienStatus.addActionListener(e -> controller.UstawStatus());

        this.setContentPane(panel);
        this.setVisible(true);
    }

}
