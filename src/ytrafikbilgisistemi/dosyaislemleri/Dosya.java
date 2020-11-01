package ytrafikbilgisistemi.dosyaislemleri;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Dosya {

    String directory = System.getProperty("user.dir");
    String fileName = "aracdata.txt";
    String absolutePath = directory + File.separator + fileName;

    public Dosya(String fileName) {
        absolutePath = directory + File.separator + fileName;
    }

    public String TumSatirlariGetir() {
        String str = "";
        try {
            File file = new File(absolutePath);
            FileInputStream fis = new FileInputStream(file);
            byte[] data = new byte[(int) file.length()];
            fis.read(data);
            fis.close();

            str = new String(data, "UTF-8");
        } catch (Exception e) {
            System.out.printf(e.getMessage());
        }
        return str;
    }

    public boolean SatirlaraEkle(String content) {
        BufferedWriter bw = null;
        FileWriter fw = null;

        try {

            fw = new FileWriter(absolutePath, true);
            bw = new BufferedWriter(fw);
            bw.write(content);

        } catch (IOException e) {
            return false;

        } finally {

            try {

                if (bw != null) {
                    bw.close();
                }

                if (fw != null) {
                    fw.close();
                }

                return true;
            } catch (IOException ex) {

                return false;

            }

        }
    }

    public void SatirlariSil() {
        FileWriter fwOb = null;
        try {
            fwOb = new FileWriter(absolutePath, false);
            PrintWriter pwOb = new PrintWriter(fwOb, false);
            pwOb.flush();
            pwOb.close();
            fwOb.close();
        } catch (IOException ex) {
            Logger.getLogger(Dosya.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fwOb.close();
            } catch (IOException ex) {
                Logger.getLogger(Dosya.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
