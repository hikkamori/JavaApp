package com.example.client;

import javafx.stage.Stage;

import java.net.DatagramSocket;

public class UserData {
    private static int attempts = 0;
    private static Stage stage;
    private static Boolean isAuthorizing;
    private static String email;
    private static String password;
    private static DatagramSocket soc;

    public static void setAttempts(int attempts) {
        UserData.attempts = attempts;
    }

    public static int getAttempts() {
        return attempts;
    }

    public static void setSoc(DatagramSocket soc) {
        UserData.soc = soc;
    }

    public static DatagramSocket getSoc() {
        return soc;
    }

    public static void setStage(Stage stage) {
        UserData.stage = stage;
    }

    public static void setIsAuthorizing(Boolean isAuthorizing) {
        UserData.isAuthorizing = isAuthorizing;
    }

    public static void setEmail(String email) {
        UserData.email = email;
    }

    public static void setPassword(String password) {
        UserData.password = password;
    }


    public static Stage getStage() {
        return stage;
    }

    public static Boolean getIsAuthorizing() {
        return isAuthorizing;
    }

    public static String getEmail() {
        return email;
    }

    public static String getPassword() {
        return password;
    }
}
