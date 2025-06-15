public class Fryzjer {
    private int id;
    private String imie,nazwisko,nrTelefonu;

    //Konstruktor
    public Fryzjer(int id, String imie, String nazwisko, String nrTelefonu){
        this.id = id;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.nrTelefonu = nrTelefonu;
    }

    //Teraz Wypisanie obiektu fryzjer skutkuje wypisaniem jego imienia i nazwiska
    @Override
    public String toString(){
        return this.imie + " " + this.nazwisko;
    }

    //Metoda zwracająca id fryzjera
    public int GetId(){
        return this.id;
    }

}
