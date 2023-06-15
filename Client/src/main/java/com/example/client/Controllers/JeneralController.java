package com.example.client.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class JeneralController {
    @FXML
    private Text add;
    @FXML
    private Text update;
    @FXML
    private Text settings;
    @FXML
    private Button rightUp;
    @FXML
    private Button leftUp;
    @FXML
    private Button rightDown;
    @FXML
    private Button leftDown;
    @FXML
    private ImageView helpPanthera;
    @FXML
    private Text helpText;
    @FXML
    private Rectangle helpRectangle;
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
    public void makeLeftUpPink(){
        leftUp.setStyle("-fx-border-color: #1a05d1; -fx-border-width: 2; -fx-background-color: #eab8df ;");
    }
    public void makeLeftUpWhite(){
        leftUp.setStyle("-fx-border-color: #1a05d1; -fx-border-width: 2; -fx-background-color: #ffffff;");
    }
    public void makeRightUpPink(){
        rightUp.setStyle("-fx-border-color: #1a05d1; -fx-border-width: 2; -fx-background-color: #eab8df ;");
    }
    public void makeRightUpWhite(){
        rightUp.setStyle("-fx-border-color: #1a05d1; -fx-border-width: 2; -fx-background-color: #ffffff;");
    }
    public void makeLeftDownPink(){
        leftDown.setStyle("-fx-border-color: #1a05d1; -fx-border-width: 2; -fx-background-color: #eab8df ;");
    }
    public void makeLeftDownWhite(){
        leftDown.setStyle("-fx-border-color: #1a05d1; -fx-border-width: 2; -fx-background-color: #ffffff;");
    }
    public void makeRightDownPink(){
        rightDown.setStyle("-fx-border-color: #1a05d1; -fx-border-width: 2; -fx-background-color: #eab8df ;");
    }
    public void makeRightDownWhite(){
        rightDown.setStyle("-fx-border-color: #1a05d1; -fx-border-width: 2; -fx-background-color: #ffffff;");
    }
    public void showHelp(){
        helpRectangle.setStyle("visibility: true;");
        helpText.setStyle("visibility: true;");
    }
    public void closeHelp(){
        helpRectangle.setStyle("visibility: false;");
        helpText.setStyle("visibility: false;");
    }
}
