
package ytrafikbilgisistemi.entity;

public class CezaKayit extends Kayit {
    
    public CezaKayit(String plaka, String tarih, int tutar, String vergiAciklamasi) {
        super(plaka, tarih, tutar, vergiAciklamasi);
    }

    public CezaKayit() {
    }

    @Override
    public String toString() {
        return "Ceza Kayit"; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
