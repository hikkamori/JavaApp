package com.example.client.Controllers;

import com.example.client.UserData;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class settingsController {
    @FXML
    private Button englishButton;
    @FXML
    private Button russianButton;
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
        russianButton.setStyle("-fx-background-color: #eab8df ; -fx-border-color: #1a05d1; -fx-border-width: 3;");
    }
    public void makeRusshianWhite(){
        russianButton.setStyle("-fx-background-color: #ffffff ; -fx-border-color: #1a05d1; -fx-border-width: 3;");
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
    public void changeEnglish(){
        UserData.currentLanguage = "english";
        UserData.settingsStage.close();
    }
    public void changeRussian() {
        UserData.currentLanguage = "russian";
        UserData.settingsStage.close();
    }
    public void changeAlbanian(){
        UserData.currentLanguage = "albanian";
        UserData.settingsStage.close();
    }
    public void changeSlovak(){
        UserData.currentLanguage = "slovak";
        UserData.settingsStage.close();
    }
}
