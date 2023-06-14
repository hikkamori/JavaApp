package com.example.client.Controllers;

import com.example.client.StartApplication;
import com.example.client.UserData;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.stage.Stage;

import java.io.IOException;

public class StartController {
    @FXML
    private Button registerButton;
    @FXML
    private Button authorizeButton;
    @FXML
    private ImageView pantherRegister;
    @FXML
    private ImageView pantherAuthorize;
    FXMLLoader fxmlLoader = new FXMLLoader(StartApplication.class.getResource("inputData.fxml"));
    Scene scene = new Scene(fxmlLoader.load(), 1200, 750);

    public StartController() throws IOException {
    }

    @FXML
    protected void toRegister() {
        UserData.setIsAuthorizing(false);
        registerButton.setStyle("-fx-background-color: #1a05d1; ");
        UserData.getStage().setTitle("Registering...");
        UserData.getStage().setScene(scene);
        UserData.getStage().show();
    }

    @FXML
    protected void toAuthorize() {
        UserData.setIsAuthorizing(true);
        authorizeButton.setStyle("-fx-background-color: #1a05d1; ");
        UserData.getStage().setTitle("Authorizing...");
        UserData.getStage().setScene(scene);
        UserData.getStage().show();
    }
    @FXML
    protected void makeRegisterButtonBlue(){
        registerButton.setStyle("-fx-background-color: #1a05d1");
        pantherRegister.setStyle("visibility: true;");
    }
    @FXML
    protected void makeRegisterButtonPink(){
        registerButton.setStyle("-fx-background-color: #c40e9c");
        pantherRegister.setStyle("visibility: false;");
    }
    @FXML
    protected void makeAuthorizeButtonBlue(){
        authorizeButton.setStyle("-fx-background-color: #1a05d1");
        pantherAuthorize.setStyle("visibility: true;");
    }
    @FXML
    protected void makeAuthorizeButtonPink(){
        authorizeButton.setStyle("-fx-background-color: #c40e9c");
        pantherAuthorize.setStyle("visibility: false;");
    }
}