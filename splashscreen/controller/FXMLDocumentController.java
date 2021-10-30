package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class FXMLDocumentController implements Initializable {

    public ProgressBar prograssBar;
    public ProgressIndicator prograssind;
    public AnchorPane root;
    public AnchorPane ap;

    class ShowSplashScreen extends Thread{


        @Override
        public void run(){
              try{
                for (int i = 0 ; i <= 10 ; i++){
                   // prograssind.setVisible(false);
                    double x = i * (0.1);
                    prograssBar.setProgress(x);
                    String y = String.valueOf(i * 10) ;
                    prograssind.setProgress(x);


                    if(i*10 == 100){
                        prograssind.setVisible(true);
                        prograssind.setProgress(1);

                    }

                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }

                Platform.runLater(() -> {
                    Stage stage = new Stage();
                    Parent root = null;
                    try {
                        root = FXMLLoader.load(getClass().getResource("../view/SecondScene.fxml"));
                    } catch (IOException ex) {
                        Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                    ap.getScene().getWindow().hide();
                });                
            } catch (Exception ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        new ShowSplashScreen().start();





    }
}
