package com.example.client.Controllers;

import com.example.client.CollectionStructure.Album;
import com.example.client.CollectionStructure.Coordinates;
import com.example.client.CollectionStructure.MusicBand;
import com.example.client.CollectionStructure.MusicGenre;
import com.example.client.ConnectionClasses.CommandData;
import com.example.client.ConnectionClasses.DataBaseConnector;
import com.example.client.ConnectionClasses.Reciever;
import com.example.client.ConnectionClasses.Sender;
import com.example.client.UserData;
import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class AddController {
    @FXML
    private Button confirmButton;
    @FXML
    private ImageView panthera;
    @FXML
    private TextField name;
    @FXML
    private TextField x;
    @FXML
    private TextField y;
    @FXML
    private TextField genre;
    @FXML
    private TextField singles;
    @FXML
    private TextField albums;
    @FXML
    private TextField albumName;
    @FXML
    private TextField sales;
    @FXML
    private Rectangle nameBack;
    @FXML
    private Rectangle xBack;
    @FXML
    private Rectangle yBack;
    @FXML
    private Rectangle genreBack;
    @FXML
    private Rectangle singlesBack;
    @FXML
    private Rectangle albumsBack;
    @FXML
    private Rectangle albumNameBack;
    @FXML
    private Rectangle salesBack;
    @FXML
    private Text nameText;
    @FXML
    private Text xText;
    @FXML
    private Text yText;
    @FXML
    private Text genreText;
    @FXML
    private Text singlesText;
    @FXML
    private Text albumsText;
    @FXML
    private Text albumNameText;
    @FXML
    private Text salesText;
    public void initialize(){
        name.setPromptText("Name");
        x.setPromptText("X");
        y.setPromptText("Y");
        genre.setPromptText("Genre: rock/progressive rock/post punk/post rock/punk rock");
        singles.setPromptText("Singles count");
        albums.setPromptText("Albums count");
        albumName.setPromptText("Best album name");
        sales.setPromptText("Best albums sales");
        ArrayList<TextField> textList = new ArrayList<>();
        textList.add(name);
        textList.add(x);
        textList.add(y);
        textList.add(genre);
        textList.add(singles);
        textList.add(albums);
        textList.add(albumName);
        textList.add(sales);
        textList.stream().forEach(x -> x.setPromptText(UserData.translate(x.getPromptText(), "D:\\j_ws\\Lab_8\\JavaApp\\Client\\src\\main\\resources\\com\\example\\client\\Translater\\addText\\" + UserData.currentLanguage + ".txt", true)));
    }

    public void showPanthera(){
        confirmButton.setStyle("-fx-background-color: #eab8df; -fx-border-color: #1a05d1; -fx-border-width: 3;");
        panthera.setStyle("visibility: true;");
    }
    public void hidePanthera(){
        confirmButton.setStyle("-fx-background-color: #ffffff; -fx-border-color: #1a05d1; -fx-border-width: 3;");
        panthera.setStyle("visibility: false;");
    }
    public void addBand() throws SQLException {
        nameBack.setStyle("visibility: false;");
        nameText.setStyle("visibility: false;");
        xBack.setStyle("visibility: false;");
        xText.setStyle("visibility: false;");
        yBack.setStyle("visibility: false;");
        yText.setStyle("visibility: false;");
        genreBack.setStyle("visibility: false;");
        genreText.setStyle("visibility: false;");
        singlesBack.setStyle("visibility: false;");
        singlesText.setStyle("visibility: false;");
        albumsBack.setStyle("visibility: false;");
        albumsText.setStyle("visibility: false;");
        albumNameBack.setStyle("visibility: false;");
        albumNameText.setStyle("visibility: false;");
        salesBack.setStyle("visibility: false;");
        salesText.setStyle("visibility: false;");
        boolean FLAG = true;
        String file = "D:\\j_ws\\Lab_8\\JavaApp\\Client\\src\\main\\resources\\com\\example\\client\\Translater\\addText\\" + UserData.currentLanguage + ".txt";
        //checking name
        if (name.getText().equals("")){
            FLAG = false;
            nameBack.setStyle("visibility: true;");
            nameText.setStyle("visibility: true;");
            nameText.setText(UserData.translate("Please, enter something", file, true));
        }
        //checking x
        if (x.getText().equals("")){
            FLAG = false;
            xBack.setStyle("visibility: true;");
            xText.setStyle("visibility: true;");
            xText.setText(UserData.translate("Please, enter something", file, true));
        } else {
            try {
                if (Integer.valueOf(x.getText()) > 241){
                    FLAG = false;
                    xBack.setStyle("visibility: true;");
                    xText.setStyle("visibility: true;");
                    xText.setText(UserData.translate("Must be lower than -576", file, true));
                }
            } catch (Exception e) {
                FLAG = false;
                xBack.setStyle("visibility: true;");
                xText.setStyle("visibility: true;");
                xText.setText(UserData.translate("Must be digit", file, true));
            }
        }
        //checking y
        if (y.getText().equals("")){
            FLAG = false;
            yBack.setStyle("visibility: true;");
            yText.setStyle("visibility: true;");
            yText.setText(UserData.translate("Please, enter something", file, true));
        } else {
            try {
                if (Integer.valueOf(x.getText()) > -579){
                    FLAG = false;
                    yBack.setStyle("visibility: true;");
                    yText.setStyle("visibility: true;");
                    yText.setText(UserData.translate("Must be lower than -579", file, true));
                }
            } catch (Exception e) {
                FLAG = false;
                yBack.setStyle("visibility: true;");
                yText.setStyle("visibility: true;");
                yText.setText(UserData.translate("Must be digit", file, true));
            }
        }
        //checking genre
        if (genre.getText().equals("")){
            FLAG = false;
            genreBack.setStyle("visibility: true;");
            genreText.setStyle("visibility: true;");
            genreText.setText(UserData.translate("Please, enter something", file, true));
        }
        boolean genreIsCorrect = false;
        ArrayList<String> genres = createGenresList();
        if (! genres.contains(genre.getText())){
            FLAG = false;
            genreBack.setStyle("visibility: true;");
            genreText.setStyle("visibility: true;");
            genreText.setText(UserData.translate("Genre not found", file, true));
        }
        //checking singles count
        if (singles.getText().equals("")){
            FLAG = false;
            singlesBack.setStyle("visibility: true;");
            singlesText.setStyle("visibility: true;");
            singlesText.setText(UserData.translate("Please, enter something", file, true));
        } else {
            try {
                if (Integer.valueOf(singles.getText()) < 0){
                    FLAG = false;
                    singlesBack.setStyle("visibility: true;");
                    singlesText.setStyle("visibility: true;");
                    singlesText.setText(UserData.translate("Must be bigger than 0", file, true));
                }
            } catch (Exception e) {
                FLAG = false;
                singlesBack.setStyle("visibility: true;");
                singlesText.setStyle("visibility: true;");
                singlesText.setText(UserData.translate("Must be digit", file, true));
            }
        }
        //checking albums count
        if (albums.getText().equals("")){
            FLAG = false;
            albumsBack.setStyle("visibility: true;");
            albumsText.setStyle("visibility: true;");
            albumsText.setText(UserData.translate("Please, enter something", file, true));
        } else {
            try {
                if (Integer.valueOf(albums.getText()) < 0){
                    FLAG = false;
                    albumsBack.setStyle("visibility: true;");
                    albumsText.setStyle("visibility: true;");
                    albumsText.setText(UserData.translate("Must be bigger than 0", file, true));
                }
            } catch (Exception e) {
                FLAG = false;
                albumsBack.setStyle("visibility: true;");
                albumsText.setStyle("visibility: true;");
                albumsText.setText(UserData.translate("Must be digit", file, true));
            }
        }
        //checking album name
        if (albumName.getText().equals("")){
            FLAG = false;
            albumNameBack.setStyle("visibility: true;");
            albumNameText.setStyle("visibility: true;");
            albumNameText.setText(UserData.translate("Please, enter something", file, true));
        }
        //checking sales count
        if (sales.getText().equals("")){
            FLAG = false;
            salesBack.setStyle("visibility: true;");
            salesText.setStyle("visibility: true;");
            salesText.setText(UserData.translate("Please, enter something", file, true));
        } else {
            try {
                if (Integer.valueOf(sales.getText()) < 0){
                    FLAG = false;
                    salesBack.setStyle("visibility: true;");
                    salesText.setStyle("visibility: true;");
                    salesText.setText(UserData.translate("Must be bigger than 0", file, true));
                }
            } catch (Exception e) {
                FLAG = false;
                salesBack.setStyle("visibility: true;");
                salesText.setStyle("visibility: true;");
                salesText.setText(UserData.translate("Must be digit", file, true));
            }
        }
        if (FLAG) {
            MusicBand band = new MusicBand(name.getText());
            Coordinates coordinates = new Coordinates(Double.valueOf(x.getText()), Float.valueOf(y.getText()));
            band.setCoordinates(coordinates);
            band.setBestAlbum(new Album(albumName.getText(), Long.valueOf(sales.getText())));
            String gen = UserData.translate(genre.getText(), "D:\\j_ws\\Lab_8\\JavaApp\\Client\\src\\main\\resources\\com\\example\\client\\Translater\\addText\\" + UserData.currentLanguage + "Genres.txt", false);
            band.setGenre(MusicGenre.getGenreName(gen));
            band.setSinglesCount(Long.valueOf(singles.getText()));
            band.setAlbumsCount(Long.valueOf(albums.getText()));
            band.setNumberOfParticipants(Long.valueOf(Long.valueOf((int) (Math.random() * 20))));

            UserData.getTmpStage().close();

            System.out.println(band.toString());

            CommandData data = CommandData.createData().Name("add").Username(UserData.getEmail()).Password(UserData.getPassword()).Band(band);
            try {
                Sender.send(data);
                String[] message = Reciever.getData(UserData.getSoc());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

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
}
