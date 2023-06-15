package com.example.client.Controllers;

import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class JeneralController {
    @FXML
    private Text add;
    @FXML
    private Text update;
    @FXML
    private Text settings;
    public void makeAddBlue(){
        add.setStyle("-fx-fill: #1a05d1;");
    }
    public void makeAddWhite(){
        add.setStyle("-fx-fill: #ffffff;");
    }
    public void makeUpdateBlue(){
        update.setStyle("-fx-fill: #1a05d1;");
    }
    public void makeUpdateWhite(){
        update.setStyle("-fx-fill: #ffffff;");
    }
    public void makeSettingsBlue(){
        settings.setStyle("-fx-fill: #1a05d1;");
    }
    public void makeSettingsWhite(){
        settings.setStyle("-fx-fill: #ffffff;");
    }
}
