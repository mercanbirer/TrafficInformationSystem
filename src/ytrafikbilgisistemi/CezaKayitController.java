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
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import ytrafikbilgisistemi.arac.CezaKayitDao;
import ytrafikbilgisistemi.entity.CezaKayit;

/**
 * FXML Controller class
 *
 * @author merca
 */
public class CezaKayitController implements Initializable {

    @FXML
    TextField plaka;
    @FXML
    DatePicker tarih;
    @FXML
    TextField tutar;
    @FXML
    TextArea aciklama;
    
    CezaKayitDao cezaKayitDao; 

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cezaKayitDao = new CezaKayitDao();
    }
    
    @FXML
    private void kaydet(ActionEvent event) {
        CezaKayit model = new CezaKayit();
        
        model.setPlaka(plaka.getText()); 
        model.setTarih(tarih.getValue().toString()); 
        model.setTutar(Integer.parseInt(tutar.getText()));
        model.setVergiAciklamasi(aciklama.getText());
                

        boolean eklendimi = cezaKayitDao.Kaydet(model);
        if (eklendimi) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Başarılı", ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
            alert.showAndWait();

            if (alert.getResult() == ButtonType.YES) {
                try {
                    
                    Stage thisWindow = (Stage) plaka.getScene().getWindow();
                    
                    thisWindow.close();
                    
                    Stage stage = new Stage();
                    AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("CezaYonetimi.fxml"));
                    stage.setScene(new Scene(root));
                    stage.setTitle("Ceza");
                    stage.initModality(Modality.WINDOW_MODAL);
                    stage.initOwner(((Node) event.getSource()).getScene().getWindow());
                    
                    stage.show();
                    
                } catch (IOException ex) {
                    Logger.getLogger(YeniAracController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Başarısız", ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
            alert.showAndWait();

            if (alert.getResult() == ButtonType.YES) {
                //do stuff
            }
        }

    }

}
