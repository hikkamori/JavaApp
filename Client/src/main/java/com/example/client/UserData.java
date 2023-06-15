package com.example.client;

import com.example.client.CollectionStructure.Album;
import com.example.client.CollectionStructure.Coordinates;
import com.example.client.CollectionStructure.MusicBand;
import com.example.client.CollectionStructure.MusicGenre;
import com.example.client.ConnectionClasses.CommandData;
import com.example.client.ConnectionClasses.Reciever;
import com.example.client.ConnectionClasses.Sender;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.DatagramSocket;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.util.*;

public class UserData {
    private static int attempts = 0;
    private static Stage stage;
    private static Boolean isAuthorizing;
    private static String email;
    private static String password;
    private static DatagramSocket soc;

    public static ArrayList<MusicBand> showMy() throws NoSuchAlgorithmException, IOException {
        String userinfo = "show";
        MessageDigest digest = MessageDigest.getInstance("SHA-1");
        digest.reset();
        digest.update(UserData.getPassword().getBytes("utf8"));
        String codedPassword = String.format("%040x", new BigInteger(1, digest.digest()));
        CommandData data = CommandData.createData().Name(userinfo).Username(UserData.getEmail()).Password(codedPassword);
        Sender.send(data);
        String[] messages = Reciever.getData(UserData.getSoc());
        ArrayList<String> mylist = new ArrayList<>(List.of(Arrays.toString(messages).split(", ")));
        ArrayList<MusicBand> res = new ArrayList<>();

        for(int j = 2; j < mylist.indexOf("OTHER BANDS"); j=j+11){
                    MusicBand tmp = new MusicBand();
                    tmp.setId(Long.parseLong(mylist.get(j)));
                    tmp.setName(mylist.get(j + 1));
                    tmp.setCoordinates(new Coordinates(Double.valueOf(mylist.get(j + 2)), Float.parseFloat(mylist.get(j + 3))));
                    tmp.setCreationDate(LocalDate.parse(mylist.get(j + 4)));
                    tmp.setNumberOfParticipants(Long.valueOf(mylist.get(j + 5)));
                    tmp.setSinglesCount(Long.parseLong(mylist.get(j + 6)));
                    tmp.setAlbumsCount(Long.valueOf(mylist.get(j + 7)));
                    tmp.setGenre(MusicGenre.valueOf(mylist.get(j + 8).toUpperCase(Locale.ROOT)));
                    Album tmpal = new Album();
                    tmpal.setName(mylist.get(j + 9));
                    tmpal.setSales(Float.parseFloat(mylist.get(j + 10)));
                    tmp.setBestAlbum(tmpal);

                    res.add(tmp);

        }


        return res;
    }
    public static ArrayList<MusicBand> showOthers() throws NoSuchAlgorithmException, IOException {
        String userinfo = "show";
        ArrayList<MusicBand> mybands = new ArrayList<>();
        MessageDigest digest = MessageDigest.getInstance("SHA-1");
        digest.reset();
        digest.update(UserData.getPassword().getBytes("utf8"));
        String codedPassword = String.format("%040x", new BigInteger(1, digest.digest()));
        CommandData data = CommandData.createData().Name(userinfo).Username(UserData.getEmail()).Password(codedPassword);
        Sender.send(data);
        String[] messages = Reciever.getData(UserData.getSoc());
        ArrayList<String> mylist = new ArrayList<>(List.of(Arrays.toString(messages).split(", ")));
        ArrayList<MusicBand> res = new ArrayList<>();
        mylist.add(mylist.get(mylist.size()-1).substring(0,mylist.get(mylist.size()-1).length() - 1));
        mylist.remove(mylist.size() - 2);
        System.out.println(mylist);
        for(int j = mylist.indexOf("OTHERS BANDS") + 1; j < mylist.size(); j=j+11){
            MusicBand tmp = new MusicBand();
            tmp.setId(Long.parseLong(mylist.get(j)));
            tmp.setName(mylist.get(j + 1));
            tmp.setCoordinates(new Coordinates(Double.valueOf(mylist.get(j + 2)), Float.parseFloat(mylist.get(j + 3))));
            tmp.setCreationDate(LocalDate.parse(mylist.get(j + 4)));
            tmp.setNumberOfParticipants(Long.valueOf(mylist.get(j + 5)));
            tmp.setSinglesCount(Long.parseLong(mylist.get(j + 6)));
            tmp.setAlbumsCount(Long.valueOf(mylist.get(j + 7)));
            tmp.setGenre(MusicGenre.valueOf(mylist.get(j + 8).toUpperCase(Locale.ROOT)));
            Album tmpal = new Album();
            tmpal.setName(mylist.get(j + 9));
            tmpal.setSales(Float.parseFloat(mylist.get(j + 10)));
            tmp.setBestAlbum(tmpal);

            res.add(tmp);

        }


        return res;
    }

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
