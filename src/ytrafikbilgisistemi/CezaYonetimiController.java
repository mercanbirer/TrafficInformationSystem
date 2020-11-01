/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ytrafikbilgisistemi;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage; 
import ytrafikbilgisistemi.arac.CezaKayitDao; 
import ytrafikbilgisistemi.entity.CezaKayit;

/**
 * FXML Controller class
 *
 * @author msi
 */
public class CezaYonetimiController implements Initializable {

    
    @FXML TableView<CezaKayit> tableView;
    CezaKayitDao cezaKayitDao;
    @FXML Button closeButton;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cezaKayitDao = new CezaKayitDao();
        ArrayList<CezaKayit> liste = cezaKayitDao.Listesi();

        ObservableList<CezaKayit> data = tableView.getItems();
        data.clear();

        for (CezaKayit model : liste) {
            data.add(model);
        }
    }
    
    @FXML
    private void yeniCeza(ActionEvent event) {
        try {
            Stage thisWindow = (Stage) tableView.getScene().getWindow();
            
            thisWindow.close();
            
            Stage stage = new Stage();
            AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("CezaKayit.fxml"));
            stage.setScene(new Scene(root));
            stage.setTitle("Yeni Ceza");
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(((Node) event.getSource()).getScene().getWindow());

            stage.show();
            
            

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
