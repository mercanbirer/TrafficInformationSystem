package ytrafikbilgisistemi.entity;


public class Kayit {
    String plaka;
    String tarih;
    int tutar;
    String vergiAciklamasi;

    public Kayit(String plaka, String tarih, int tutar, String vergiAciklamasi) {
        this.plaka = plaka;
        this.tarih = tarih;
        this.tutar = tutar;
        this.vergiAciklamasi = vergiAciklamasi;
    }

    public Kayit() {
    }
    

    public String getPlaka() {
        return plaka;
    }

    public void setPlaka(String plaka) {
        this.plaka = plaka;
    }

    public String getTarih() {
        return tarih;
    }

    public void setTarih(String tarih) {
        this.tarih = tarih;
    }

    public int getTutar() {
        return tutar;
    }

    public void setTutar(int tutar) {
        this.tutar = tutar;
    }

    public String getVergiAciklamasi() {
        return vergiAciklamasi;
    }

    public void setVergiAciklamasi(String vergiAciklamasi) {
        this.vergiAciklamasi = vergiAciklamasi;
    }
    
    
}
