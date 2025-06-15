import java.time.LocalDate;

public class Wizyta {
    Uzytkownik klient;
    Fryzjer fryzjer;
    String usluga;
    String status;
    String godzina;
    LocalDate data;
    int klientID = 0, fryzjerID, wizytaID;

    public Wizyta(Fryzjer fryzjer, String usluga, String status, LocalDate data, String godzina){
        this.fryzjer = fryzjer;
        this.usluga = usluga;
        this.status = status;
        this.data = data;
        this.godzina = godzina;
    }

    //Konstruktor wizyty dla panelu admina
    public Wizyta(int idWizyty, int idKlienta, int idFryzjera, String usluga, String status, LocalDate data, String godzina){
        this.wizytaID = idWizyty;
        this.klientID = idKlienta;
        this.fryzjerID = idFryzjera;
        this.usluga = usluga;
        this.status = status;
        this.data = data;
        this.godzina = godzina;
    }

    @Override
    public String toString(){
        //Gdy klientId jest różny od 0 co występuje tylko gdy używamy konstruktora dla Admin Panelu
        if(this.klientID != 0){
            return "ID: " + this.wizytaID + " | ID Klienta: " + klientID + " | ID Fryzjera: " + fryzjerID + " | Usługa: " + usluga + " | Data: " + data + " | Godzina: " + godzina + " | Status: " + status;
        }
        else{
            return "Fryzjer: " + fryzjer + " | Usługa: " + usluga + " | Data: " + data + " | Godzina: " + godzina + " | Status: " + status;
        }

    }

    public Fryzjer GetFryzjer(){
        return this.fryzjer;
    }

    public LocalDate GetData(){
        return this.data;
    }

    public String GetGodzina(){
        return this.godzina;
    }

    public void SetStatus(String status){
        this.status = status;
    }
}
