package com.example.client;

import com.example.client.ConnectionClasses.CommandData;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Locale;
import java.util.ResourceBundle;

public class StartApplication extends Application {

    public static int CLIENTPORT = 5007;
    public static int SERVERPORT = 1256;

    public void start(Stage stage) throws IOException {

        startWork();
        UserData.setStage(stage);
        FXMLLoader fxmlLoader = new FXMLLoader(StartApplication.class.getResource("start.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1200, 750);
        stage.setTitle("Music Band Manager");
        stage.setScene(scene);
        stage.show();
    }
    public void startWork(){
            DatagramSocket soc;
            try {
                soc = new DatagramSocket(CLIENTPORT);
                soc.connect(InetAddress.getByName("localhost"), SERVERPORT);
            } catch (SocketException e) {
                throw new RuntimeException(e);
            } catch (UnknownHostException e) {
                throw new RuntimeException(e);
            }
            UserData.setSoc(soc);
        }


    public static void main(String[] args) {
        launch();
    }
}