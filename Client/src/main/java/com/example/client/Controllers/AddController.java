package com.example.client.Controllers;

import com.example.client.CollectionStructure.Album;
import com.example.client.CollectionStructure.Coordinates;
import com.example.client.CollectionStructure.MusicBand;
import com.example.client.CollectionStructure.MusicGenre;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.Locale;

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

    public void showPanthera(){
        confirmButton.setStyle("-fx-background-color: #eab8df; -fx-border-color: #1a05d1; -fx-border-width: 3;");
        panthera.setStyle("visibility: true;");
    }
    public void hidePanthera(){
        confirmButton.setStyle("-fx-background-color: #ffffff; -fx-border-color: #1a05d1; -fx-border-width: 3;");
        panthera.setStyle("visibility: false;");
    }
    public void addBand(){
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
        //checking name
        if (name.getText().equals("")){
            FLAG = false;
            nameBack.setStyle("visibility: true;");
            nameText.setStyle("visibility: true;");
            nameText.setText("Please, enter something");
        }
        //checking x
        if (x.getText().equals("")){
            FLAG = false;
            xBack.setStyle("visibility: true;");
            xText.setStyle("visibility: true;");
            xText.setText("Please, enter something");
        } else {
            try {
                if (Integer.valueOf(x.getText()) > 241){
                    FLAG = false;
                    xBack.setStyle("visibility: true;");
                    xText.setStyle("visibility: true;");
                    xText.setText("Must be lower than 241");
                }
            } catch (Exception e) {
                FLAG = false;
                xBack.setStyle("visibility: true;");
                xText.setStyle("visibility: true;");
                xText.setText("Must be digit");
            }
        }
        //checking y
        if (y.getText().equals("")){
            FLAG = false;
            yBack.setStyle("visibility: true;");
            yText.setStyle("visibility: true;");
            yText.setText("Please, enter something");
        } else {
            try {
                if (Integer.valueOf(x.getText()) > -579){
                    FLAG = false;
                    xBack.setStyle("visibility: true;");
                    xText.setStyle("visibility: true;");
                    xText.setText("Must be lower than -579");
                }
            } catch (Exception e) {
                FLAG = false;
                xBack.setStyle("visibility: true;");
                xText.setStyle("visibility: true;");
                xText.setText("Must be digit");
            }
        }
        //checking genre
        if (genre.getText().equals("")){
            FLAG = false;
            genreBack.setStyle("visibility: true;");
            genreText.setStyle("visibility: true;");
            genreText.setText("Please, enter something");
        }
        ArrayList genres = new ArrayList();
        genres.add("rock");
        genres.add("progressive rock");
        genres.add("post punk");
        genres.add("post rock");
        genres.add("punk rock");
        if (! genres.contains(genre.getText())){
            FLAG = false;
            genreBack.setStyle("visibility: true;");
            genreText.setStyle("visibility: true;");
            genreText.setText("Genre not found");
        }
        //checking singles count
        if (singles.getText().equals("")){
            FLAG = false;
            singlesBack.setStyle("visibility: true;");
            singlesText.setStyle("visibility: true;");
            singlesText.setText("Please, enter something");
        } else {
            try {
                if (Integer.valueOf(singles.getText()) < 0){
                    FLAG = false;
                    singlesBack.setStyle("visibility: true;");
                    singlesText.setStyle("visibility: true;");
                    singlesText.setText("Must be bigger than 0");
                }
            } catch (Exception e) {
                FLAG = false;
                singlesBack.setStyle("visibility: true;");
                singlesText.setStyle("visibility: true;");
                singlesText.setText("Must be digit");
            }
        }
        //checking albums count
        if (albums.getText().equals("")){
            FLAG = false;
            albumsBack.setStyle("visibility: true;");
            albumsText.setStyle("visibility: true;");
            albumsText.setText("Please, enter something");
        } else {
            try {
                if (Integer.valueOf(albums.getText()) < 0){
                    FLAG = false;
                    albumsBack.setStyle("visibility: true;");
                    albumsText.setStyle("visibility: true;");
                    albumsText.setText("Must be bigger than 0");
                }
            } catch (Exception e) {
                FLAG = false;
                albumsBack.setStyle("visibility: true;");
                albumsText.setStyle("visibility: true;");
                albumsText.setText("Must be digit");
            }
        }
        //checking album name
        if (albumName.getText().equals("")){
            FLAG = false;
            albumNameBack.setStyle("visibility: true;");
            albumNameText.setStyle("visibility: true;");
            albumNameText.setText("Please, enter something");
        }
        //checking sales count
        if (sales.getText().equals("")){
            FLAG = false;
            salesBack.setStyle("visibility: true;");
            salesText.setStyle("visibility: true;");
            salesText.setText("Please, enter something");
        } else {
            try {
                if (Integer.valueOf(sales.getText()) < 0){
                    FLAG = false;
                    salesBack.setStyle("visibility: true;");
                    salesText.setStyle("visibility: true;");
                    salesText.setText("Must be bigger than 0");
                }
            } catch (Exception e) {
                FLAG = false;
                salesBack.setStyle("visibility: true;");
                salesText.setStyle("visibility: true;");
                salesText.setText("Must be digit");
            }
        }
        if (FLAG){
            MusicBand band = new MusicBand(name.getText());
            Coordinates coordinates = new Coordinates(Double.valueOf(x.getText()), Float.valueOf(y.getText()));
            band.setCoordinates(coordinates);
            band.setBestAlbum(new Album(albumName.getText(), Long.valueOf(sales.getText())));
            band.setGenre(MusicGenre.getGenreName(genre.getText()));
            band.setSinglesCount(Long.valueOf(singles.getText()));
            band.setAlbumsCount(Long.valueOf(albums.getText()));
            band.setNumberOfParticipants(Long.valueOf(Long.valueOf((int) (Math.random() * 20))));

            System.out.println(band.toString());
        }
        /*
        отправка созданного экземпляра на сервер (внутри if'а)




         */
    }
}
