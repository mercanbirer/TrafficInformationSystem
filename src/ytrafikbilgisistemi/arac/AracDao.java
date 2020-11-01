package ytrafikbilgisistemi.arac;

import java.util.ArrayList;
import ytrafikbilgisistemi.dosyaislemleri.Dosya;
import ytrafikbilgisistemi.entity.Arac;

public class AracDao {

    Dosya dosya;

    public AracDao() { 
        dosya = new Dosya("aracKayit.txt");
    }

    public boolean Kaydet(Arac model) {
        String satir = model.getPlaka()
                + "!" + model.getCinsi()
                + "!" + model.getMarkasi() + "!"
                + model.getTicariAdi() + "#";
        return dosya.SatirlaraEkle(satir);
    }

    public ArrayList<Arac> Listesi() {
        ArrayList<Arac> liste = new ArrayList<>();

        String satirlar = dosya.TumSatirlariGetir();
        if ("".equals(satirlar)) {
            return liste;
        }
        String[] araclar = satirlar.split("#");
        for (String aracStr : araclar) {
            try {
                String[] aracOzellikler = aracStr.split("!");

                Arac arac = new Arac();
                arac.setPlaka(aracOzellikler[0]);
                arac.setCinsi(aracOzellikler[1]);
                arac.setMarkasi(aracOzellikler[2]);
                arac.setTicariAdi(aracOzellikler[3]);
                liste.add(arac);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return liste;
    }
}
