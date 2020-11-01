package ytrafikbilgisistemi.entity;


public class VergiKayit extends Kayit {
    
    public VergiKayit(String plaka, String tarih, int tutar, String vergiAciklamasi) {
        super(plaka, tarih, tutar, vergiAciklamasi);
    }

    public VergiKayit() {
    }
    
    
    @Override
    public String toString() {
        return "Vergi Kayit"; //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
