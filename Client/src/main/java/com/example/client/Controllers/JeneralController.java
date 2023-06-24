package com.example.client.Controllers;

import com.example.client.CollectionStructure.Album;
import com.example.client.CollectionStructure.Coordinates;
import com.example.client.CollectionStructure.MusicBand;
import com.example.client.CollectionStructure.MusicGenre;
import com.example.client.ConnectionClasses.CommandData;
import com.example.client.ConnectionClasses.Reciever;
import com.example.client.ConnectionClasses.Sender;
import com.example.client.StartApplication;
import com.example.client.UserData;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Stream;

public class JeneralController {
    private String currentChange;
    @FXML
    private Button deleteButton;
    @FXML
    private TextField insertField;
    @FXML
    private Button okButton;
    @FXML
    private Text errorText;

    @FXML
    private GridPane buttonTable;
    @FXML
    private Button idButton;
    @FXML
    private Button nameButton;
    @FXML
    private Button genreButton;
    @FXML
    private Button creationDateButton;
    @FXML
    private Button coordinatesButton;
    @FXML
    private Button membersCountButton;
    @FXML
    private Button singlesCountButton;
    @FXML
    private Button albumsCountButton;
    @FXML
    private Button albumNameButton;
    @FXML
    private Button salesButton;
    @FXML
    private GridPane showingTable;
    @FXML
    private ImageView showingPanthera;
    @FXML
    private Text idNaming;
    @FXML
    private Text nameNaming;
    @FXML
    private Text genreNaming;
    @FXML
    private Text creationDateNaming;
    @FXML
    private Text coordinatesNaming;
    @FXML
    private Text membersCountNaming;
    @FXML
    private Text singlesCountNaming;
    @FXML
    private Text albumsCountNaming;
    @FXML
    private Text albumNameNaming;
    @FXML
    private Text salesNaming;
    @FXML
    private Text idData;
    @FXML
    private Text nameData;
    @FXML
    private Text genreData;
    @FXML
    private Text creationDateData;
    @FXML
    private Text coordinatesData;
    @FXML
    private Text membersCountData;
    @FXML
    private Text singlesCountData;
    @FXML
    private Text albumsCountData;
    @FXML
    private Text albumNameData;
    @FXML
    private Text salesData;
    @FXML
    private Text idTableUp;
    @FXML
    private Text nameTableUp;
    @FXML
    private Text genreTableUp;
    @FXML
    private Text singlesTableUp;
    @FXML
    private Text albumsTableUp;
    @FXML
    private Text idTableDown;
    @FXML
    private Text nameTableDown;
    @FXML
    private Text genreTableDown;
    @FXML
    private Text singlesTableDown;
    @FXML
    private Text albumsTableDown;
    @FXML
    private Text yourBandsText;
    @FXML
    private Text othersBandsText;
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
    @FXML
    private Text pageNumYour;
    @FXML
    private Text pageNumOthers;

    private int currentSheetNumYour = 1;
    private int currentSheetNumOthers = 1;
    private ArrayList<GridPane> yourSheets;
    private ArrayList<GridPane> othersSheets;

    public Text getIdTableUp() {
        return idTableUp;
    }

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
        showingPanthera.setStyle("visibility: false;");
        showingTable.setStyle("visibility: false; -fx-background-color: #fcdbf5;");
        buttonTable.setStyle("visibility: false; -fx-background-color: #fcdbf500;");
        deleteButton.setStyle("-fx-background-color:  #fcdbf5; -fx-border-color:  #c40e9c; visibility: false");
        this.refreshView();
        ArrayList<MusicBand> yourCollection = UserData.showMy();//get collections
        UserData.myCollection = yourCollection;
        if (yourCollection.isEmpty()){
            Text text = new Text("Your collection is empty(. Click on 'Add band'");
            upStackPane.getChildren().clear();
            upStackPane.getChildren().add(text);
            pageNumYour.setText("0/0");
            currentSheetNumYour = 0;
        } else {
            this.yourSheets = MakeFilledSheets(yourCollection);//generate sheets for table
            yourSheets.stream().forEach(x -> x.setStyle("visibility: false;"));//make sheets invisible
            yourSheets.get(0).setStyle("visibility: true;");//make first sheet visible
            upStackPane.getChildren().clear();
            upStackPane.getChildren().addAll(yourSheets);
            upStackPane.getChildren().add(createButtonTable(true));
            pageNumYour.setText("1/" + String.valueOf(yourSheets.size()));
            currentSheetNumOthers = 1;
        }
        ArrayList<MusicBand> othersCollection = UserData.showOthers();
        UserData.othersCollection = othersCollection;
        if (othersCollection.isEmpty()){
            Text text = new Text("Others collections are empty(");
            downStackPane.getChildren().clear();
            downStackPane.getChildren().add(text);
            pageNumOthers.setText("0/0");
            currentSheetNumOthers = 0;
        } else {
            this.othersSheets = MakeFilledSheets(othersCollection);
            othersSheets.stream().forEach(x -> x.setStyle("visibility: false;"));
            othersSheets.get(0).setStyle("visibility: true;");
            downStackPane.getChildren().clear();
            downStackPane.getChildren().addAll(othersSheets);
            downStackPane.getChildren().add(createButtonTable(false));
            pageNumOthers.setText("1/" + String.valueOf(othersSheets.size()));
            currentSheetNumOthers = 1;
        }

    }
    public GridPane createGridPane(){
        GridPane gp = new GridPane();
        gp.getColumnConstraints().add(new ColumnConstraints(161.0)); //id
        gp.getColumnConstraints().add(new ColumnConstraints(161.2)); //name
        gp.getColumnConstraints().add(new ColumnConstraints(127.19999999999999)); // genre
        gp.getColumnConstraints().add(new ColumnConstraints(84.40000000000003)); //singles count
        gp.getColumnConstraints().add(new ColumnConstraints(74.0)); //albums count
        GridPane.setHalignment(gp, HPos.CENTER);
        GridPane.setValignment(gp, VPos.CENTER);
        return gp;
    }
    public ArrayList<GridPane> MakeFilledSheets(ArrayList<MusicBand> collection){
        Label id;
        Label name;
        Label genre;
        Label singlesCount;
        Label albumsCount;
        ArrayList<GridPane> panes = new ArrayList();
        GridPane currentGrid = null;
        for (int i = 0; i < collection.size(); i++){
            if ((i % 16) == 0){
                currentGrid = createGridPane();
                panes.add(currentGrid);
            }
            name = new Label(collection.get(i).getName());
            name.setStyle("-fx-fill: #1a05d1 ");
            GridPane.setHalignment(name, HPos.CENTER);
            genre = new Label(collection.get(i).getGenre().toString());
            genre.setStyle("-fx-fill: #1a05d1 ");
            GridPane.setHalignment(genre, HPos.CENTER);
            id = new Label(String.valueOf(collection.get(i).getId()));
            id.setStyle("-fx-fill: #1a05d1 ");
            GridPane.setHalignment(id, HPos.CENTER);
            singlesCount = new Label(String.valueOf(collection.get(i).getSinglesCount()));
            singlesCount.setStyle("-fx-fill: #1a05d1 ");
            GridPane.setHalignment(singlesCount, HPos.CENTER);
            albumsCount = new Label(String.valueOf(collection.get(i).getAlbumsCount()));
            albumsCount.setStyle("-fx-fill: #1a05d1 ");
            GridPane.setHalignment(albumsCount, HPos.CENTER);
            currentGrid.addRow(i%16, id, name, genre, singlesCount, albumsCount);
        }
        return panes;
    }
    public void addBand() throws IOException {
        UserData.setTmpStage(new Stage());
        FXMLLoader fxmlLoader = new FXMLLoader(StartApplication.class.getResource("addView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 650, 800);
        UserData.getTmpStage().setScene(scene);
        UserData.getTmpStage().show();
    }
    public void showSettings() throws IOException {
        Stage stm = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(StartApplication.class.getResource("settingsView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 600);
        stm.setScene(scene);
        UserData.settingsStage = stm;
        stm.show();
    }

    public void moveUpRight(){
        if (currentSheetNumYour < yourSheets.size()){
            yourSheets.get(currentSheetNumYour - 1).setStyle("visibility: false;");
            yourSheets.get(currentSheetNumYour).setStyle("visibility: true;");
            currentSheetNumYour += 1;
            pageNumYour.setText(String.valueOf(currentSheetNumYour) + "/" + String.valueOf(yourSheets.size()));
        }
    }
    public void moveUpLeft(){
        if (currentSheetNumYour > 1){
            yourSheets.get(currentSheetNumYour - 1).setStyle("visibility: false;");
            yourSheets.get(currentSheetNumYour - 2).setStyle("visibility: true;");
            currentSheetNumYour -= 1;
            pageNumYour.setText(String.valueOf(currentSheetNumYour) + "/" + String.valueOf(yourSheets.size()));
        }
    }
    public void moveDownRight(){
        if (currentSheetNumOthers < othersSheets.size()){
            othersSheets.get(currentSheetNumOthers - 1).setStyle("visibility: false;");
            othersSheets.get(currentSheetNumOthers).setStyle("visibility: true;");
            currentSheetNumOthers += 1;
            pageNumOthers.setText(String.valueOf(currentSheetNumOthers) + "/" + String.valueOf(othersSheets.size()));
        }
    }
    public void moveDownLeft(){
        if (currentSheetNumOthers > 1){
            othersSheets.get(currentSheetNumOthers - 1).setStyle("visibility: false;");
            othersSheets.get(currentSheetNumOthers - 2).setStyle("visibility: true;");
            currentSheetNumOthers -= 1;
            pageNumOthers.setText(String.valueOf(currentSheetNumOthers) + "/" + String.valueOf(othersSheets.size()));
        }
    }
    public void  refreshView(){
        idTableUp.setText("ID");
        nameTableUp.setText("Name");
        genreTableUp.setText("Genre");
        singlesTableUp.setText("Singles");
        albumsTableUp.setText("Albums");
        idTableDown.setText("ID");
        nameTableDown.setText("Name");
        genreTableDown.setText("Genre");
        singlesTableDown.setText("Singles");
        albumsTableDown.setText("Albums");
        yourBandsText.setText("Your bands");
        othersBandsText.setText("Other's bands");
        add.setText("Add band");
        settings.setText("Settings");
        update.setText("Update");
        idNaming.setText("ID: ");
        nameNaming.setText("Name: ");
        genreNaming.setText("Genre: ");
        creationDateNaming.setText("Creation date: ");
        coordinatesNaming.setText("Coordinates: ");
        membersCountNaming.setText("Members count: ");
        singlesCountNaming.setText("Singles count: ");
        albumsCountNaming.setText("Albums count: ");
        albumNameNaming.setText("Best album: ");
        salesNaming.setText("Best album sales: ");
        ArrayList<Text> words = new ArrayList<>();
        words.add(idTableUp);
        words.add(nameTableUp);
        words.add(genreTableUp);
        words.add(singlesTableUp);
        words.add(albumsTableUp);
        words.add(idTableDown);
        words.add(nameTableDown);
        words.add(genreTableDown);
        words.add(singlesTableDown);
        words.add(albumsTableDown);
        words.add(yourBandsText);
        words.add(othersBandsText);
        words.add(add);
        words.add(update);
        words.add(settings);
        words.add(idNaming);
        words.add(nameNaming);
        words.add(genreNaming);
        words.add(creationDateNaming);
        words.add(coordinatesNaming);
        words.add(membersCountNaming);
        words.add(singlesCountNaming);
        words.add(albumsCountNaming);
        words.add(albumNameNaming);
        words.add(salesNaming);
        String filename = "D:\\j_ws\\Lab_8\\JavaApp\\Client\\src\\main\\resources\\com\\example\\client\\Translater\\addText\\" + UserData.currentLanguage + "Gen.txt";
        words.stream().forEach(x -> x.setText(UserData.translate(x.getText(), filename, true)));
    }
    public void sortIdUp() throws NoSuchAlgorithmException, IOException {
        Collections.sort(UserData.myCollection, MusicBand.compareById);
        SortTables(UserData.myCollection, UserData.othersCollection);
    }
    public void sortNameUp() throws NoSuchAlgorithmException, IOException {
        Collections.sort(UserData.myCollection, MusicBand.compareByName);
        SortTables(UserData.myCollection, UserData.othersCollection);
    }
    public void sortGenreUp() throws NoSuchAlgorithmException, IOException {
        Collections.sort(UserData.myCollection, MusicBand.compareByGenre);
        SortTables(UserData.myCollection, UserData.othersCollection);
    }
    public void sortSinglesUp() throws NoSuchAlgorithmException, IOException {
        Collections.sort(UserData.myCollection, MusicBand.compareBySingles);
        SortTables(UserData.myCollection, UserData.othersCollection);
    }
    public void sortAlbumsUp() throws NoSuchAlgorithmException, IOException {
        Collections.sort(UserData.myCollection, MusicBand.compareByAlbums);
        SortTables(UserData.myCollection, UserData.othersCollection);
    }
    public void sortIdDown() throws NoSuchAlgorithmException, IOException {
        Collections.sort(UserData.othersCollection, MusicBand.compareById);
        SortTables(UserData.myCollection, UserData.othersCollection);
    }
    public void sortNameDown() throws NoSuchAlgorithmException, IOException {
        Collections.sort(UserData.othersCollection, MusicBand.compareByName);
        SortTables(UserData.myCollection, UserData.othersCollection);
    }
    public void sortGenreDown() throws NoSuchAlgorithmException, IOException {
        Collections.sort(UserData.othersCollection, MusicBand.compareByGenre);
        SortTables(UserData.myCollection, UserData.othersCollection);
    }
    public void sortSinglesDown() throws NoSuchAlgorithmException, IOException {
        Collections.sort(UserData.othersCollection, MusicBand.compareBySingles);
        SortTables(UserData.myCollection, UserData.othersCollection);
    }
    public void sortAlbumsDown() throws NoSuchAlgorithmException, IOException {
        Collections.sort(UserData.othersCollection, MusicBand.compareByAlbums);
        SortTables(UserData.myCollection, UserData.othersCollection);
    }
    public void SortTables(ArrayList up, ArrayList down) throws NoSuchAlgorithmException, IOException {
        showingPanthera.setStyle("visibility: false;");
        showingTable.setStyle("visibility: false; -fx-background-color: #fcdbf5;");
        buttonTable.setStyle("visibility: false; -fx-background-color: #fcdbf500;");
        ArrayList<MusicBand> yourCollection = up;//get collections
        if (yourCollection.isEmpty()){
            Text text = new Text("Your collection is empty(. Click on 'Add band'");
            upStackPane.getChildren().clear();
            upStackPane.getChildren().add(text);
            pageNumYour.setText("0/0");
            currentSheetNumYour = 0;
        } else {
            this.yourSheets = MakeFilledSheets(yourCollection);//generate sheets for table
            yourSheets.stream().forEach(x -> x.setStyle("visibility: false;"));//make sheets invisible
            yourSheets.get(0).setStyle("visibility: true;");//make first sheet visible
            upStackPane.getChildren().clear();
            upStackPane.getChildren().addAll(yourSheets);
            upStackPane.getChildren().add(createButtonTable(true));
            pageNumYour.setText("1/" + String.valueOf(yourSheets.size()));
            currentSheetNumOthers = 1;
        }
        ArrayList<MusicBand> othersCollection = down;
        if (othersCollection.isEmpty()){
            Text text = new Text("Others collections are empty(");
            downStackPane.getChildren().clear();
            downStackPane.getChildren().add(text);
            pageNumOthers.setText("0/0");
            currentSheetNumOthers = 0;
        } else {
            this.othersSheets = MakeFilledSheets(othersCollection);
            othersSheets.stream().forEach(x -> x.setStyle("visibility: false;"));
            othersSheets.get(0).setStyle("visibility: true;");
            downStackPane.getChildren().clear();
            downStackPane.getChildren().addAll(othersSheets);
            upStackPane.getChildren().add(createButtonTable(false));
            pageNumOthers.setText("1/" + String.valueOf(othersSheets.size()));
            currentSheetNumOthers = 1;
        }
    }
    public GridPane createButtonTable(boolean flag){
        GridPane gp = new GridPane();
        gp.setMinWidth(600);
        gp.setMaxWidth(600);
        gp.getColumnConstraints().add(new ColumnConstraints(600));
        GridPane.setHalignment(gp, HPos.CENTER);
        GridPane.setValignment(gp, VPos.CENTER);

        Button button1 = new Button();
        Button button2 = new Button();
        Button button3 = new Button();
        Button button4 = new Button();
        Button button5 = new Button();
        Button button6 = new Button();
        Button button7 = new Button();
        Button button8 = new Button();
        Button button9 = new Button();
        Button button10 = new Button();
        Button button11 = new Button();
        Button button12 = new Button();
        Button button13 = new Button();
        Button button14 = new Button();
        Button button15 = new Button();
        Button button16 = new Button();

        int rowHeight = 17;

        button1.setMinSize(600, rowHeight);
        button2.setMinSize(600, rowHeight);
        button3.setMinSize(600, rowHeight);
        button4.setMinSize(600, rowHeight);
        button5.setMinSize(600, rowHeight);
        button6.setMinSize(600, rowHeight);
        button7.setMinSize(600, rowHeight);
        button8.setMinSize(600, rowHeight);
        button9.setMinSize(600, rowHeight);
        button10.setMinSize(600, rowHeight);
        button11.setMinSize(600, rowHeight);
        button12.setMinSize(600, rowHeight);
        button13.setMinSize(600, rowHeight);
        button14.setMinSize(600, rowHeight);
        button15.setMinSize(600, rowHeight);
        button16.setMinSize(600, rowHeight);

        button1.setMaxSize(600, rowHeight);
        button2.setMaxSize(600, rowHeight);
        button3.setMaxSize(600, rowHeight);
        button4.setMaxSize(600, rowHeight);
        button5.setMaxSize(600, rowHeight);
        button6.setMaxSize(600, rowHeight);
        button7.setMaxSize(600, rowHeight);
        button8.setMaxSize(600, rowHeight);
        button9.setMaxSize(600, rowHeight);
        button10.setMaxSize(600, rowHeight);
        button11.setMaxSize(600, rowHeight);
        button12.setMaxSize(600, rowHeight);
        button13.setMaxSize(600, rowHeight);
        button14.setMaxSize(600, rowHeight);
        button15.setMaxSize(600, rowHeight);
        button16.setMaxSize(600, rowHeight);

        String borderColor = "#2197ff00;";
        button1.setStyle("-fx-background-color: #2197ff00; -fx-border-color: " + borderColor);
        button2.setStyle("-fx-background-color: #2197ff00; -fx-border-color: " + borderColor);
        button3.setStyle("-fx-background-color: #2197ff00; -fx-border-color: " + borderColor);
        button4.setStyle("-fx-background-color: #2197ff00; -fx-border-color: " + borderColor);
        button5.setStyle("-fx-background-color: #2197ff00; -fx-border-color: " + borderColor);
        button6.setStyle("-fx-background-color: #2197ff00; -fx-border-color: " + borderColor);
        button7.setStyle("-fx-background-color: #2197ff00; -fx-border-color: " + borderColor);
        button8.setStyle("-fx-background-color: #2197ff00; -fx-border-color: " + borderColor);
        button9.setStyle("-fx-background-color: #2197ff00; -fx-border-color: " + borderColor);
        button9.setStyle("-fx-background-color: #2197ff00; -fx-border-color: " + borderColor);
        button10.setStyle("-fx-background-color: #2197ff00; -fx-border-color: " + borderColor);
        button11.setStyle("-fx-background-color: #2197ff00; -fx-border-color: " + borderColor);
        button12.setStyle("-fx-background-color: #2197ff00; -fx-border-color: " + borderColor);
        button13.setStyle("-fx-background-color: #2197ff00; -fx-border-color: " + borderColor);
        button14.setStyle("-fx-background-color: #2197ff00; -fx-border-color: " + borderColor);
        button15.setStyle("-fx-background-color: #2197ff00; -fx-border-color: " + borderColor);
        button16.setStyle("-fx-background-color: #2197ff00; -fx-border-color: " + borderColor);
        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int num = 1;
                if (flag) {
                    int k = currentSheetNumYour * 16 + num - 17;
                    if (k < UserData.myCollection.size()) {
                        showElement(UserData.myCollection.get(k));
                    }
                } else {
                    int k = currentSheetNumOthers * 16 + num - 17;
                    if (k < UserData.othersCollection.size()) {
                        showElement(UserData.othersCollection.get(k));
                    }
                }
            }
        });
        button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int num = 2;
                if (flag) {
                    int k = currentSheetNumYour * 16 + num - 17;
                    if (k < UserData.myCollection.size()) {
                        showElement(UserData.myCollection.get(k));
                        UserData.elementIsYours = flag;
                    }
                } else {
                    int k = currentSheetNumOthers * 16 + num - 17;
                    if (k < UserData.othersCollection.size()) {
                        showElement(UserData.othersCollection.get(k));
                        UserData.elementIsYours = flag;
                    }
                }
            }
        });
        button3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int num = 3;
                if (flag) {
                    int k = currentSheetNumYour * 16 + num - 17;
                    if (k < UserData.myCollection.size()) {
                        showElement(UserData.myCollection.get(k));
                    }
                } else {
                    int k = currentSheetNumOthers * 16 + num - 17;
                    if (k < UserData.othersCollection.size()) {
                        showElement(UserData.othersCollection.get(k));
                    }
                }
            }
        });
        button4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int num = 4;
                if (flag) {
                    int k = currentSheetNumYour * 16 + num - 17;
                    if (k < UserData.myCollection.size()) {
                        showElement(UserData.myCollection.get(k));
                    }
                } else {
                    int k = currentSheetNumOthers * 16 + num - 17;
                    if (k < UserData.othersCollection.size()) {
                        showElement(UserData.othersCollection.get(k));
                    }
                }
            }
        });
        button5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int num = 5;
                if (flag) {
                    int k = currentSheetNumYour * 16 + num - 17;
                    if (k < UserData.myCollection.size()) {
                        showElement(UserData.myCollection.get(k));
                    }
                } else {
                    int k = currentSheetNumOthers * 16 + num - 17;
                    if (k < UserData.othersCollection.size()) {
                        showElement(UserData.othersCollection.get(k));
                    }
                }
            }
        });
        button6.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int num = 6;
                if (flag) {
                    int k = currentSheetNumYour * 16 + num - 17;
                    if (k < UserData.myCollection.size()) {
                        showElement(UserData.myCollection.get(k));
                    }
                } else {
                    int k = currentSheetNumOthers * 16 + num - 17;
                    if (k < UserData.othersCollection.size()) {
                        showElement(UserData.othersCollection.get(k));
                    }
                }
            }
        });
        button7.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int num = 7;
                if (flag) {
                    int k = currentSheetNumYour * 16 + num - 17;
                    if (k < UserData.myCollection.size()) {
                        showElement(UserData.myCollection.get(k));
                    }
                } else {
                    int k = currentSheetNumOthers * 16 + num - 17;
                    if (k < UserData.othersCollection.size()) {
                        showElement(UserData.othersCollection.get(k));
                    }
                }
            }
        });
        button8.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int num = 8;
                if (flag) {
                    int k = currentSheetNumYour * 16 + num - 17;
                    if (k < UserData.myCollection.size()) {
                        showElement(UserData.myCollection.get(k));
                    }
                } else {
                    int k = currentSheetNumOthers * 16 + num - 17;
                    if (k < UserData.othersCollection.size()) {
                        showElement(UserData.othersCollection.get(k));
                    }
                }
            }
        });
        button9.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int num = 9;
                if (flag) {
                    int k = currentSheetNumYour * 16 + num - 17;
                    if (k < UserData.myCollection.size()) {
                        showElement(UserData.myCollection.get(k));
                    }
                } else {
                    int k = currentSheetNumOthers * 16 + num - 17;
                    if (k < UserData.othersCollection.size()) {
                        showElement(UserData.othersCollection.get(k));
                    }
                }
            }
        });
        button10.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int num = 10;
                if (flag) {
                    int k = currentSheetNumYour * 16 + num - 17;
                    if (k < UserData.myCollection.size()) {
                        showElement(UserData.myCollection.get(k));
                    }
                } else {
                    int k = currentSheetNumOthers * 16 + num - 17;
                    if (k < UserData.othersCollection.size()) {
                        showElement(UserData.othersCollection.get(k));
                    }
                }
            }
        });
        button11.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int num = 11;
                if (flag) {
                    int k = currentSheetNumYour * 16 + num - 17;
                    if (k < UserData.myCollection.size()) {
                        showElement(UserData.myCollection.get(k));
                    }
                } else {
                    int k = currentSheetNumOthers * 16 + num - 17;
                    if (k < UserData.othersCollection.size()) {
                        showElement(UserData.othersCollection.get(k));
                    }
                }
            }
        });
        button12.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int num = 12;
                if (flag) {
                    int k = currentSheetNumYour * 16 + num - 17;
                    if (k < UserData.myCollection.size()) {
                        showElement(UserData.myCollection.get(k));
                    }
                } else {
                    int k = currentSheetNumOthers * 16 + num - 17;
                    if (k < UserData.othersCollection.size()) {
                        showElement(UserData.othersCollection.get(k));
                    }
                }
            }
        });
        button13.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int num = 13;
                if (flag) {
                    int k = currentSheetNumYour * 16 + num - 17;
                    if (k < UserData.myCollection.size()) {
                        showElement(UserData.myCollection.get(k));
                    }
                } else {
                    int k = currentSheetNumOthers * 16 + num - 17;
                    if (k < UserData.othersCollection.size()) {
                        showElement(UserData.othersCollection.get(k));
                    }
                }
            }
        });
        button14.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int num = 14;
                if (flag) {
                    int k = currentSheetNumYour * 16 + num - 17;
                    if (k < UserData.myCollection.size()) {
                        showElement(UserData.myCollection.get(k));
                    }
                } else {
                    int k = currentSheetNumOthers * 16 + num - 17;
                    if (k < UserData.othersCollection.size()) {
                        showElement(UserData.othersCollection.get(k));
                    }
                }
            }
        });
        button15.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int num = 15;
                if (flag) {
                    int k = currentSheetNumYour * 16 + num - 17;
                    if (k < UserData.myCollection.size()) {
                        showElement(UserData.myCollection.get(k));
                    }
                } else {
                    int k = currentSheetNumOthers * 16 + num - 17;
                    if (k < UserData.othersCollection.size()) {
                        showElement(UserData.othersCollection.get(k));
                    }
                }
            }
        });
        button16.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int num = 16;
                if (flag) {
                    int k = currentSheetNumYour * 16 + num - 17;
                    if (k < UserData.myCollection.size()) {
                        showElement(UserData.myCollection.get(k));
                    }
                } else {
                    int k = currentSheetNumOthers * 16 + num - 17;
                    if (k < UserData.othersCollection.size()) {
                        showElement(UserData.othersCollection.get(k));
                    }
                }
            }
        });
        gp.addRow(1, button1);
        gp.addRow(2, button2);
        gp.addRow(3, button3);
        gp.addRow(4, button4);
        gp.addRow(5, button5);
        gp.addRow(6, button6);
        gp.addRow(7, button7);
        gp.addRow(8, button8);
        gp.addRow(9, button9);
        gp.addRow(10, button10);
        gp.addRow(11, button11);
        gp.addRow(12, button12);
        gp.addRow(13, button13);
        gp.addRow(14, button14);
        gp.addRow(15, button15);
        gp.addRow(16, button16);

        return gp;
    }

    public void showElement(MusicBand element){
        UserData.currentElement = element;
        showingPanthera.setStyle("visibility: true;");
        showingTable.setStyle("visibility: true; -fx-background-color: #fcdbf5;");
        buttonTable.setStyle("visibility: true; -fx-background-color: #fcdbf500;");
        if (UserData.myCollection.contains(element)) {
            deleteButton.setStyle("-fx-background-color:  #fcdbf5; -fx-border-color:  #c40e9c; visibility: true");
        }
        idData.setText(String.valueOf(element.getId()));
        nameData.setText(element.getName());
        creationDateData.setText(element.getCreationDate().toString());
        genreData.setText(element.getGenre().toString());
        coordinatesData.setText("(" + String.valueOf(element.getCoordinates().getX()) + "; " + String.valueOf(element.getCoordinates().getY()) + ")");
        membersCountData.setText(String.valueOf(element.getNumberOfParticipants()));
        singlesCountData.setText(String.valueOf(element.getSinglesCount()));
        albumsCountData.setText(String.valueOf(element.getAlbumsCount()));
        albumNameData.setText(element.getBestAlbum().getName());
        salesData.setText(String.valueOf(element.getBestAlbum().getSales()));
    }
    public void idChange(){
    };
    public void nameChange(){
        if (UserData.myCollection.contains(UserData.currentElement)){
        insertField.setStyle("-fx-border-color: #c40e9c ; visibility: true");
        okButton.setStyle("-fx-background-color: #fcdbf5; -fx-border-color: #c40e9c; visibility: true");
        errorText.setStyle("-fx-fill: #1a05d1 ");
        errorText.setText("Enter new name:");
        currentChange = "name";}
    };
    public void genreChange(){
        if (UserData.myCollection.contains(UserData.currentElement)){
        insertField.setStyle("-fx-border-color: #c40e9c ; visibility: true");
        okButton.setStyle("-fx-background-color: #fcdbf5; -fx-border-color: #c40e9c; visibility: true");
        errorText.setStyle("-fx-fill: #1a05d1 ");
        errorText.setText("Enter new genre:");
        currentChange = "genre";}
    }
    public void creationDateChange(){
        if (UserData.myCollection.contains(UserData.currentElement)){
        insertField.setStyle("-fx-border-color: #c40e9c ; visibility: true");
        okButton.setStyle("-fx-background-color: #fcdbf5; -fx-border-color: #c40e9c; visibility: true");
        errorText.setStyle("-fx-fill: #1a05d1 ");
        errorText.setText("Enter new creation date:");
        currentChange = "creationDate";}
    };
    public void coordinatesChange(){
        if (UserData.myCollection.contains(UserData.currentElement)){
        insertField.setStyle("-fx-border-color: #c40e9c ; visibility: true");
        okButton.setStyle("-fx-background-color: #fcdbf5; -fx-border-color: #c40e9c; visibility: true");
        errorText.setStyle("-fx-fill: #1a05d1 ");
        errorText.setText("Enter new coordinates:");
        currentChange = "coordinates";}
    };
    public void membersCountChange(){
        if (UserData.myCollection.contains(UserData.currentElement)){
        insertField.setStyle("-fx-border-color: #c40e9c ; visibility: true");
        okButton.setStyle("-fx-background-color: #fcdbf5; -fx-border-color: #c40e9c; visibility: true");
        errorText.setStyle("-fx-fill: #1a05d1 ");
        errorText.setText("Enter new members count:");
        currentChange = "membersCount";}
    };
    public void singlesCountChange(){
        if (UserData.myCollection.contains(UserData.currentElement)){
        insertField.setStyle("-fx-border-color: #c40e9c ; visibility: true");
        okButton.setStyle("-fx-background-color: #fcdbf5; -fx-border-color: #c40e9c; visibility: true");
        errorText.setStyle("-fx-fill: #1a05d1 ");
        errorText.setText("Enter new singles count:");
        currentChange = "singlesCount";}
    };
    public void albumsCountChange(){
        if (UserData.myCollection.contains(UserData.currentElement)){
        insertField.setStyle("-fx-border-color: #c40e9c ; visibility: true");
        okButton.setStyle("-fx-background-color: #fcdbf5; -fx-border-color: #c40e9c; visibility: true");
        errorText.setStyle("-fx-fill: #1a05d1 ");
        errorText.setText("Enter new albums count:");
        currentChange = "albumsCount";}
    };
    public void albumNameChange(){
        if (UserData.myCollection.contains(UserData.currentElement)){
        insertField.setStyle("-fx-border-color: #c40e9c ; visibility: true");
        okButton.setStyle("-fx-background-color: #fcdbf5; -fx-border-color: #c40e9c; visibility: true");
        errorText.setStyle("-fx-fill: #1a05d1");
        errorText.setText("Enter new best album name:");
        currentChange = "albumName";}
    };
    public void salesChange(){
        if (UserData.myCollection.contains(UserData.currentElement)){
        insertField.setStyle("-fx-border-color: #c40e9c ; visibility: true");
        okButton.setStyle("-fx-background-color: #fcdbf5; -fx-border-color: #c40e9c; visibility: true");
        errorText.setStyle("-fx-fill: #1a05d1 ");
        errorText.setText("Enter new best album sales:");
        currentChange = "sales";}
    };
    public void okPush() throws IOException {
        boolean flag = false;
        if (currentChange.equals("name") && (! insertField.getText().equals(""))){
            flag = true;
            UserData.currentElement.setName(insertField.getText());
        } else if (currentChange.equals("genre") && (! insertField.getText().equals(""))) {
            ArrayList<String> genres = createGenresList();
            if (genres.contains(insertField.getText())){
                flag = true;
                String gen = UserData.translate(insertField.getText(), "D:\\j_ws\\Lab_8\\JavaApp\\Client\\src\\main\\resources\\com\\example\\client\\Translater\\addText\\" + UserData.currentLanguage + "Genres.txt", false);
                UserData.currentElement.setGenre(MusicGenre.getGenreName(gen));
            }
        } else if (currentChange.equals("membersCount") && (! insertField.getText().equals(""))) {
            try {
                if (Integer.valueOf(insertField.getText()) > 0){
                    flag = true;
                    UserData.currentElement.setNumberOfParticipants(Long.valueOf(insertField.getText()));
                }
            } catch (Exception e) {}
        } else if (currentChange.equals("singlesCount") && (! insertField.getText().equals(""))) {
            try {
                if (Integer.valueOf(insertField.getText()) > 0){
                    flag = true;
                    UserData.currentElement.setSinglesCount(Long.valueOf(insertField.getText()));
                }
            } catch (Exception e) {}
        } else if (currentChange.equals("albumsCount") && (! insertField.getText().equals(""))) {
            try {
                if (Integer.valueOf(insertField.getText()) > 0){
                    flag = true;
                    UserData.currentElement.setAlbumsCount(Long.valueOf(insertField.getText()));
                }
            } catch (Exception e) {}
        } else if (currentChange.equals("albumName") && (! insertField.getText().equals(""))) {
            flag = true;
            Album album = new Album();
            album.setName(insertField.getText());
            album.setSales(UserData.currentElement.getBestAlbum().getSales());
            UserData.currentElement.setBestAlbum(album);
        } else if (currentChange.equals("sales") && (! insertField.getText().equals(""))) {
            try {
                if (Integer.valueOf(insertField.getText()) > 0){
                    flag = true;
                    Album album = new Album();
                    album.setName(UserData.currentElement.getBestAlbum().getName());
                    album.setSales(Float.valueOf(insertField.getText()));
                    UserData.currentElement.setBestAlbum(album);
                }
            } catch (Exception e) {}
        }

        if (flag) {
            showElement(UserData.currentElement);

            CommandData data = CommandData.createData().Name("update_by_id").Username(UserData.getEmail()).Password(UserData.getPassword());
            Object[] argumentsData = new Object[1];
            argumentsData[0] = Long.valueOf(UserData.currentElement.getId());
            data.Args(argumentsData).Band(UserData.currentElement);
            Sender.send(data);
            String[] message = Reciever.getData(UserData.getSoc());

            insertField.setStyle("-fx-border-color: #c40e9c ; visibility: false");
            okButton.setStyle("-fx-background-color: #fcdbf5; -fx-border-color: #c40e9c; visibility: false");
            errorText.setStyle("-fx-fill: #1a05d1");
            errorText.setText("");
        }
    }
    public ArrayList<String> createGenresList(){
        ArrayList<String> genres = new ArrayList<>();
        ArrayList<String> res = new ArrayList<>();
        genres.add("rock");
        genres.add("progressive rock");
        genres.add("post punk");
        genres.add("post rock");
        genres.add("punk rock");
        for (int i = 0; i < genres.size(); i++){
            res.add(UserData.translate(genres.get(i), "D:\\j_ws\\Lab_8\\JavaApp\\Client\\src\\main\\resources\\com\\example\\client\\Translater\\addText\\" + UserData.currentLanguage + "Genres.txt", true));
        }
        return res;
    }
    public void deleteBand() throws IOException {
        UserData.myCollection.remove(UserData.currentElement);
        CommandData data = CommandData.createData().Name("remove_by_id").Username(UserData.getEmail()).Password(UserData.getPassword());
        Object[] argumentsData = new Object[1];
        argumentsData[0] = Long.valueOf(UserData.currentElement.getId());
        data.Args(argumentsData);
        Sender.send(data);
        String[] message = Reciever.getData(UserData.getSoc());

        insertField.setStyle("-fx-border-color: #c40e9c ; visibility: false");
        okButton.setStyle("-fx-background-color: #fcdbf5; -fx-border-color: #c40e9c; visibility: false");
        errorText.setStyle("-fx-fill: #1a05d1");
        errorText.setText("");
        showingPanthera.setStyle("visibility: false;");
        showingTable.setStyle("visibility: false; -fx-background-color: #fcdbf5;");
        buttonTable.setStyle("visibility: false; -fx-background-color: #fcdbf500;");
        deleteButton.setStyle("-fx-background-color:  #fcdbf5; -fx-border-color:  #c40e9c; visibility: false");
    }
}
