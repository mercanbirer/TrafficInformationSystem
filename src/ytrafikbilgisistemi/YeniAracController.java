/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ytrafikbilgisistemi;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import ytrafikbilgisistemi.arac.AracDao;
import ytrafikbilgisistemi.entity.Arac;

/**
 * FXML Controller class
 *
 * @author merca
 */
public class YeniAracController implements Initializable {

    @FXML
        TextField plaka;
    @FXML
    TextField cinsi;
    @FXML
    TextField markasi;
    @FXML
    TextField ticariAdi;
    @FXML
    TextField tipi;
    @FXML
    TextField ModelYili;
    @FXML
    TextField renk;
    @FXML
    TextField KullanimYili;
    @FXML
    TextField motorNo;
    @FXML
    TextField saseNo;
    @FXML
    TextField TrafigeCikisTarihi;
    @FXML
    TextField TescilTarihi;;
    @FXML Button closeButton;
   
    AracDao aracDao;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        aracDao = new AracDao();
    }

    @FXML
    private void kaydet(ActionEvent event) {
        Arac arac = new Arac();
        
        arac.setPlaka(plaka.getText()); 
        arac.setCinsi(cinsi.getText()); 
        arac.setMarkasi(markasi.getText());
        arac.setTicariAdi(ticariAdi.getText());
                

        boolean eklendimi = aracDao.Kaydet(arac);
        if (eklendimi) {
            Alert alert = new Alert(AlertType.CONFIRMATION, "Başarılı", ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
            alert.showAndWait();

            if (alert.getResult() == ButtonType.YES) {
                try {
                    
                    Stage thisWindow = (Stage) plaka.getScene().getWindow();
                    
                    thisWindow.close();
                    
                    Stage stage = new Stage();
                    AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("aracyonetimi.fxml"));
                    stage.setScene(new Scene(root));
                    stage.setTitle("Araç");
                    stage.initModality(Modality.WINDOW_MODAL);
                    stage.initOwner(((Node) event.getSource()).getScene().getWindow());
                    
                    stage.show();
                    
                } catch (IOException ex) {
                    Logger.getLogger(YeniAracController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            Alert alert = new Alert(AlertType.CONFIRMATION, "Başarısız", ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
            alert.showAndWait();

            if (alert.getResult() == ButtonType.YES) {
                //do stuff
            }
        }

    }

}
