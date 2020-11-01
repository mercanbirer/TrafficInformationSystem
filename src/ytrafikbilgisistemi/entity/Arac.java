/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ytrafikbilgisistemi.entity;

import java.util.ArrayList;

/**
 *
 * @author merca
 */
public class Arac {

   private String plaka;
   private String cinsi;
   private String markasi;
   private String ticariAdi;
   private String tipi;
   private int modelYili;
   private String renk;
   private String kullanimAmaci;
   private int motorNo;
   private int saseNo;
   private int trafigeCikisTarihi;
   private int tescilTarihi;

    public Arac(String plaka, String cinsi, String markasi, String ticariAdi, String tipi, int modelYili, String renk, String kullanimAmaci, int motorNo, int saseNo, int trafigeCikisTarihi, int tescilTarihi) {
        this.plaka = plaka;
        this.cinsi = cinsi;
        this.markasi = markasi;
        this.ticariAdi = ticariAdi;
        this.tipi = tipi;
        this.modelYili = modelYili;
        this.renk = renk;
        this.kullanimAmaci = kullanimAmaci;
        this.motorNo = motorNo;
        this.saseNo = saseNo;
        this.trafigeCikisTarihi = trafigeCikisTarihi;
        this.tescilTarihi = tescilTarihi;
    }

    public Arac() {
        
    }

    public String getPlaka() {
        return plaka;
    }

    public void setPlaka(String plaka) {
        this.plaka = plaka;
    }

    public String getCinsi() {
        return cinsi;
    }

    public void setCinsi(String cinsi) {
        this.cinsi = cinsi;
    }

    public String getMarkasi() {
        return markasi;
    }

    public void setMarkasi(String markasi) {
        this.markasi = markasi;
    }

    public String getTicariAdi() {
        return ticariAdi;
    }

    public void setTicariAdi(String ticariAdi) {
        this.ticariAdi = ticariAdi;
    }

    public String getTipi() {
        return tipi;
    }

    public void setTipi(String tipi) {
        this.tipi = tipi;
    }

    public int getModelYili() {
        return modelYili;
    }

    public void setModelYili(int modelYili) {
        this.modelYili = modelYili;
    }

    public String getRenk() {
        return renk;
    }

    public void setRenk(String renk) {
        this.renk = renk;
    }

    public String getKullanimAmaci() {
        return kullanimAmaci;
    }

    public void setKullanimAmaci(String kullanimAmaci) {
        this.kullanimAmaci = kullanimAmaci;
    }

    public int getMotorNo() {
        return motorNo;
    }

    public void setMotorNo(int motorNo) {
        this.motorNo = motorNo;
    }

    public int getSaseNo() {
        return saseNo;
    }

    public void setSaseNo(int saseNo) {
        this.saseNo = saseNo;
    }

    public int getTrafigeCikisTarihi() {
        return trafigeCikisTarihi;
    }

    public void setTrafigeCikisTarihi(int trafigeCikisTarihi) {
        this.trafigeCikisTarihi = trafigeCikisTarihi;
    }

    public int getTescilTarihi() {
        return tescilTarihi;
    }

    public void setTescilTarihi(int tescilTarihi) {
        this.tescilTarihi = tescilTarihi;
    }
    
    
    
    //overload
    public Arac aracAra(ArrayList<Arac> list, String plaka) {
        return list.stream().
                filter(p -> p.plaka.equals(plaka)).
                findFirst().orElse(null);
    }
    
    //overload
    public Arac aracAra(ArrayList<Arac> list, String AracTipi, String tipi) {
        return list.stream().
                filter(p -> p.markasi.equals(AracTipi) && p.tipi.equals(tipi)).
                findFirst().orElse(null);
    }

    
    
    
   
}