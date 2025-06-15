import javax.swing.*;

public class AdminPanelGUI extends GUI{
    private JList listaWizyt;
    private JButton edytujWizytyButton;
    private JButton usunWizytyButton;
    private JPanel adminPanel;
    private JList listaFryzjerow;
    private JButton dodajFryzjeraButton;
    private JButton edytujFryzjeraButton;
    private JButton usunFryzjeraButton;
    private DefaultListModel<Wizyta> wizytyListModel;
    private DefaultListModel<Fryzjer> fryzjerzyListModel;
    private AdminPanelController controller;

    public AdminPanelGUI(){
        super("Admin Panel", 1000, 500);
        this.controller = new AdminPanelController(this);
        wizytyListModel = new DefaultListModel<>();
        fryzjerzyListModel = new DefaultListModel<>();

        listaWizyt.setModel(wizytyListModel);
        listaFryzjerow.setModel(fryzjerzyListModel);

        //Załaduj liste wizyt z bazy danych
        controller.ListaWizyt();
        //Załaduj liste fryzjerów z bazy danych
        controller.ListaFryzjerow();

        edytujWizytyButton.addActionListener(e -> controller.EdytujWizyte());
        usunWizytyButton.addActionListener(e -> controller.UsunWizyte());

        dodajFryzjeraButton.addActionListener(e -> controller.DodajFryzjera());
        edytujFryzjeraButton.addActionListener(e -> controller.EdytujFryzjera());
        usunFryzjeraButton.addActionListener(e -> controller.UsunFryzjera());

        this.setContentPane(adminPanel);
        this.setVisible(true);
    }

    public JList GetWizytyList(){
        return this.listaWizyt;
    }

    public JList GetFryzjerzyList(){
        return this.listaFryzjerow;
    }

    public DefaultListModel GetWizytyListModel(){
        return this.wizytyListModel;
    }

    public DefaultListModel GetFryzjerzyListModel(){
        return this.fryzjerzyListModel;
    }
}
