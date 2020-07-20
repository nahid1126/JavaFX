package sample.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController {


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXTextField UserName;

    @FXML
    private JFXPasswordField UserPass;

    @FXML
    private JFXButton LoginBu;

    @FXML
    void initialize() {
//        UserName.setStyle("-fx-text-inner-color: #a0a2ab");
//        UserPass.setStyle("-fx-text-inner-color: #a0a2ab");
        LoginBu.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                loginUser();
            }
        });
    }

    private void loginUser() {
        //get the main window
       // LoginBu.getScene().getWindow().hide();

        if (UserName.getText().toString().trim().equals("Nahid Hasan") && UserPass.getText().toString().trim().equals("nahid1234")) {
            //We are ready to show details
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/view/details.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();  //parent stored loader info
            Stage stage = new Stage();   //new stage calling
            stage.setScene(new Scene(root));  //scene add to the stage

            DetailsController detailsController = loader.getController();
            detailsController.setDetails(UserName.getText(), "Student", 23);
            stage.show();

        } else {
            JOptionPane.showMessageDialog(null, "Wrong user name or password");
        }
    }
}
