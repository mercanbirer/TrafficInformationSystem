/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ytrafikbilgisistemi.arac;

import java.util.ArrayList;
import ytrafikbilgisistemi.dosyaislemleri.Dosya;
import ytrafikbilgisistemi.entity.CezaKayit;

/**
 *
 * @author merca
 */
public class CezaKayitDao {
    

    Dosya dosya;

    public CezaKayitDao() { 
        dosya = new Dosya("CezaKayit.txt");
    }

    public boolean Kaydet(CezaKayit model) {
        String satir = model.getPlaka()
                + "!" + model.getTarih()
                + "!" + model.getTutar()+ "!"
                + model.getVergiAciklamasi()+ "#";
        return dosya.SatirlaraEkle(satir);
    }

    public ArrayList<CezaKayit> Listesi() {
        ArrayList<CezaKayit> liste = new ArrayList<>();

        String satirlar = dosya.TumSatirlariGetir();
        if ("".equals(satirlar)) {
            return liste;
        }
        String[] araclar = satirlar.split("#");
        for (String aracStr : araclar) {
            String[] ozellikler = aracStr.split("!");

            CezaKayit model = new CezaKayit();
            model.setPlaka(ozellikler[0]);
            model.setTarih(ozellikler[1]);
            model.setTutar(Integer.parseInt(ozellikler[2]));
            model.setVergiAciklamasi(ozellikler[3]);
            liste.add(model);
        }
        return liste;
    }
}


