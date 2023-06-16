package com.example.client.Controllers;

import com.example.client.CollectionStructure.Coordinates;
import com.example.client.CollectionStructure.MusicBand;
import com.example.client.CollectionStructure.MusicGenre;
import com.example.client.StartApplication;
import com.example.client.UserData;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;
import java.util.stream.Stream;

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
    @FXML
    private Button updateButton;
    @FXML
    private StackPane upStackPane;
    @FXML
    private StackPane downStackPane;
    private int currentSheetNumYour = 1;
    private int currentSheetNumOthers = 1;
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
    public void UpdateTables() throws NoSuchAlgorithmException, IOException {
        ArrayList<MusicBand> yourCollection = UserData.showMy();//get collections
        if (yourCollection.isEmpty()){
            Text text = new Text("Your collection is empty(. Click on 'Add band'");
            upStackPane.getChildren().clear();
            upStackPane.getChildren().add(text);
        } else {
            ArrayList<GridPane> yourSheets = MakeFilledSheets(yourCollection);//generate sheets for table
            yourSheets.stream().forEach(x -> x.setStyle("visibility: false;"));//make sheets invisible
            yourSheets.get(0).setStyle("visibility: false;");//make first sheet visible
            currentSheetNumYour = 1;
            upStackPane.getChildren().clear();
            upStackPane.getChildren().addAll(yourSheets);
        }
        ArrayList<MusicBand> othersCollection = UserData.showOthers();
        if (othersCollection.isEmpty()){
            Text text = new Text("Others collections are empty(");
            downStackPane.getChildren().clear();
            downStackPane.getChildren().add(text);
        } else {
            ArrayList<GridPane> othersSheets = MakeFilledSheets(othersCollection);
            othersSheets.stream().forEach(x -> x.setStyle("visibility: true;"));
            othersSheets.get(0).setStyle("visibility: true;");
            currentSheetNumOthers = 1;
            downStackPane.getChildren().clear();
            downStackPane.getChildren().addAll(othersSheets);
        }

    }
    public GridPane createGridPane(){
        GridPane gp = new GridPane();
        gp.getColumnConstraints().add(new ColumnConstraints(207.39998474121094)); //name
        gp.getColumnConstraints().add(new ColumnConstraints(123.40001525878907)); //genre
        gp.getColumnConstraints().add(new ColumnConstraints(115.19999999999999)); // creation
        gp.getColumnConstraints().add(new ColumnConstraints(77.59999999999997)); //singles count
        gp.getColumnConstraints().add(new ColumnConstraints(74.0)); //albums count
        return gp;
    }
    public ArrayList<GridPane> MakeFilledSheets(ArrayList<MusicBand> collection){
        Text name;
        Text genre;
        Text creation;
        Text singlesCount;
        Text albumsCount;
        ArrayList<GridPane> panes = new ArrayList();
        GridPane currentGrid = null;
        for (int i = 0; i < collection.size(); i++){
            if ((i % 8) == 0){
                currentGrid = createGridPane();
                panes.add(currentGrid);
            }
            name = new Text(collection.get(i).getName());
            name.setStyle("-fx-fill: #1a05d1 ");
            genre = new Text(collection.get(i).getGenre().toString());
            genre.setStyle("-fx-fill: #1a05d1 ");
            creation = new Text(collection.get(i).getCreationDate().toString());
            creation.setStyle("-fx-fill: #1a05d1 ");
            singlesCount = new Text(String.valueOf(collection.get(i).getSinglesCount()));
            singlesCount.setStyle("-fx-fill: #1a05d1 ");
            albumsCount = new Text(String.valueOf(collection.get(i).getAlbumsCount()));
            albumsCount.setStyle("-fx-fill: #1a05d1 ");
            currentGrid.addRow(i%8, name, genre, creation, singlesCount, albumsCount);
        }
        return panes;
    }
    public void addBand() throws IOException {
        Stage tmpStage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(StartApplication.class.getResource("addView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 650, 800);
        tmpStage.setScene(scene);
        tmpStage.show();
    }
    public void showSettings() throws IOException {
        Stage stm = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(StartApplication.class.getResource("settingsView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 600);
        stm.setScene(scene);
        stm.show();
    }
}
