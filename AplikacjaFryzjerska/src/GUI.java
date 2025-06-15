import javax.swing.*;
//Klasa Ustawiająca elementy wspólne dla każdego GUI, potem klasy GUI dziedziczą po tej klasie
public class GUI extends JFrame{

    GUI(String tytul, int x, int y){
        this.setTitle(tytul);
        this.setSize(x,y);
        this.setLocationRelativeTo(null);
    }

}
