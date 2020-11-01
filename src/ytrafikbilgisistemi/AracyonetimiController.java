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
import ytrafikbilgisistemi.arac.AracDao;
import ytrafikbilgisistemi.entity.Arac;

/**
 * FXML Controller class
 *
 * @author merca
 */
public class AracyonetimiController implements Initializable {

    
    @FXML TableView<Arac> tableView;
    AracDao aracDao;
    @FXML Button closeButton;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        aracDao = new AracDao();
        ArrayList<Arac> aracListesi = aracDao.Listesi();

        ObservableList<Arac> data = tableView.getItems();
        data.clear();

        for (Arac arac : aracListesi) {
            data.add(arac);
        }
    } 
       
    
    @FXML
    private void yeniArac(ActionEvent event) {
        try {
            Stage thisWindow = (Stage) tableView.getScene().getWindow();
            
            thisWindow.close();
            
            Stage stage = new Stage();
            AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("yeniArac.fxml"));
            stage.setScene(new Scene(root));
            stage.setTitle("Yeni Araç");
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(((Node) event.getSource()).getScene().getWindow());

            stage.show();
            
            

        } catch (IOException e) {
        }
    }
    
}
