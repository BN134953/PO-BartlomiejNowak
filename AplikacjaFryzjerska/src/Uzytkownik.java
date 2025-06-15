public class Uzytkownik {

    private String login,haslo,imie,nazwisko,nrTelefonu, uprawnienia;
    private int id;

    //Konstruktor uzytkownika
    public Uzytkownik(int id,String login, String haslo, String imie, String nazwisko, String nrTelefonu, String uprawnienia){
        this.login = login;
        this.haslo = haslo;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.nrTelefonu = nrTelefonu;
        this.id = id;
        this.uprawnienia = uprawnienia;
    }

    public int GetId(){
        return this.id;
    }

    public String GetImie(){
        return this.imie;
    }

    public String GetNazwisko(){
        return this.nazwisko;
    }

}
