package com.example.client.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class settingsController {
    @FXML
    private Button englishButton;
    @FXML
    private Button russhianButton;
    @FXML
    private Button albanianButton;
    @FXML
    private Button slovakButton;
    public void makeEnglishPink(){
        englishButton.setStyle("-fx-background-color: #eab8df ; -fx-border-color: #1a05d1; -fx-border-width: 3;");
    }
    public void makeEnglishWhite(){
        englishButton.setStyle("-fx-background-color: #ffffff ; -fx-border-color: #1a05d1; -fx-border-width: 3;");
    }
    public void makeRusshianPink(){
        russhianButton.setStyle("-fx-background-color: #eab8df ; -fx-border-color: #1a05d1; -fx-border-width: 3;");
    }
    public void makeRusshianWhite(){
        russhianButton.setStyle("-fx-background-color: #ffffff ; -fx-border-color: #1a05d1; -fx-border-width: 3;");
    }
    public void makeAlbanianPink(){
        albanianButton.setStyle("-fx-background-color: #eab8df ; -fx-border-color: #1a05d1; -fx-border-width: 3;");
    }
    public void makeAlbanianWhite(){
        albanianButton.setStyle("-fx-background-color: #ffffff ; -fx-border-color: #1a05d1; -fx-border-width: 3;");
    }
    public void makeSlovakPink(){
        slovakButton.setStyle("-fx-background-color: #eab8df ; -fx-border-color: #1a05d1; -fx-border-width: 3;");
    }
    public void makeSlovakWhite(){
        slovakButton.setStyle("-fx-background-color: #ffffff ; -fx-border-color: #1a05d1; -fx-border-width: 3;");
    }
    public void changeEnglish(){}
    public void changeRusshian(){}
    public void changeAlbanian(){}
    public void changeSlovak(){}
}
