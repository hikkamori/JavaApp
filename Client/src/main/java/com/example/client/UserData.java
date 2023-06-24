package com.example.client;

import com.example.client.CollectionStructure.Album;
import com.example.client.CollectionStructure.Coordinates;
import com.example.client.CollectionStructure.MusicBand;
import com.example.client.CollectionStructure.MusicGenre;
import com.example.client.ConnectionClasses.CommandData;
import com.example.client.ConnectionClasses.Reciever;
import com.example.client.ConnectionClasses.Sender;
import javafx.stage.Stage;

import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.DatagramSocket;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Stream;

public class UserData {
    public static MusicBand currentElement;
    public static boolean elementIsYours;
    private static int attempts = 0;
    private static Stage stage;
    public static Stage settingsStage;

    public static void setTmpStage(Stage tmpStage) {
        UserData.tmpStage = tmpStage;
    }

    private static Stage tmpStage;

    public static Stage getTmpStage() {
        return tmpStage;
    }

    private static Boolean isAuthorizing;
    private static String email;
    private static String password;
    private static DatagramSocket soc;
    public static String currentLanguage = "english";
    public static ArrayList<MusicBand> myCollection;
    public static ArrayList<MusicBand> othersCollection;

    public static ArrayList<MusicBand> showMy() throws NoSuchAlgorithmException, IOException {
        String userinfo = "show";
        MessageDigest digest = MessageDigest.getInstance("SHA-1");
        digest.reset();
        digest.update(UserData.getPassword().getBytes("utf8"));
        String codedPassword = String.format("%040x", new BigInteger(1, digest.digest()));
        CommandData data = CommandData.createData().Name(userinfo).Username(UserData.getEmail()).Password(codedPassword);
        Sender.send(data);
        ArrayList<String> messages = new ArrayList<>(List.of(Reciever.getData(UserData.getSoc())));
        ArrayList<MusicBand> res = new ArrayList<>();

        for(int j = 1; j < messages.indexOf("OTHERS BANDS"); j++){
            ArrayList<String> info = new ArrayList<>(List.of(messages.get(j).split(", ")));
            MusicBand band = new MusicBand();
            band.setId(Long.valueOf(Integer.valueOf(info.get(0))));
            band.setName(info.get(1));
            band.setCoordinates(new Coordinates(Double.valueOf(info.get(2)), Float.valueOf(info.get(3))));
            band.setCreationDate(LocalDate.parse(info.get(4)));
            band.setNumberOfParticipants(Long.valueOf(info.get(5)));
            band.setSinglesCount(Long.valueOf(info.get(6)));
            band.setAlbumsCount(Long.valueOf(info.get(7)));
            band.setGenre(MusicGenre.getGenreName(info.get(8).toLowerCase()));
            Album album = new Album();
            album.setName(info.get(9));
            album.setSales(Float.valueOf(info.get(10)));
            band.setBestAlbum(album);
            res.add(band);

        }
        myCollection = res;
        return res;
    }
    public static ArrayList<MusicBand> showOthers() throws NoSuchAlgorithmException, IOException {
        String userinfo = "show";
        MessageDigest digest = MessageDigest.getInstance("SHA-1");
        digest.reset();
        digest.update(UserData.getPassword().getBytes("utf8"));
        String codedPassword = String.format("%040x", new BigInteger(1, digest.digest()));
        CommandData data = CommandData.createData().Name(userinfo).Username(UserData.getEmail()).Password(codedPassword);
        Sender.send(data);
        ArrayList<String> messages = new ArrayList<>(List.of(Reciever.getData(UserData.getSoc())));
        ArrayList<MusicBand> res = new ArrayList<>();
        System.out.println(Integer.valueOf(messages.indexOf("OTHERS BANDS")));
        for(int j = messages.indexOf("OTHERS BANDS")+1; j < messages.size(); j++){
            ArrayList<String> info = new ArrayList<>(List.of(messages.get(j).split(", ")));
            MusicBand band = new MusicBand();
            band.setId(Long.valueOf(Integer.valueOf(info.get(0))));
            band.setName(info.get(1));
            band.setCoordinates(new Coordinates(Double.valueOf(info.get(2)), Float.valueOf(info.get(3))));
            band.setCreationDate(LocalDate.parse(info.get(4)));
            band.setNumberOfParticipants(Long.valueOf(info.get(5)));
            band.setSinglesCount(Long.valueOf(info.get(6)));
            band.setAlbumsCount(Long.valueOf(info.get(7)));
            band.setGenre(MusicGenre.getGenreName(info.get(8).toLowerCase()));
            Album album = new Album();
            album.setName(info.get(9));
            album.setSales(Float.valueOf(info.get(10)));
            band.setBestAlbum(album);
            res.add(band);

        }
        othersCollection = res;
        return res;
    }
    public static String translate(String s, String filename, boolean order){
        try(FileReader reader = new FileReader(filename))
        {
            char[] buf = new char[1024];
            int c;
            while((c = reader.read(buf))>0){

                if(c < 1024){
                    buf = Arrays.copyOf(buf, c);
                }
            }
            String res = null;
            ArrayList<String> pare = new ArrayList<>(List.of(String.valueOf(buf).split("\n")));
            for (int i = 0; i < pare.size(); i++){
                String word;
                String translation;
                if (order){
                    word = pare.get(i).split("=")[0];
                    translation = pare.get(i).split("=")[1];
                    translation = translation.substring(0, translation.length()-1);
                } else {
                    word = pare.get(i).split("=")[1];
                    word = word.substring(0, word.length()-1);
                    translation = pare.get(i).split("=")[0];
                }
                if (s.equals(word)){
                    res = translation;
                    break;
                }
            }
            return res;
        }
        catch(IOException ex){
        }
        return null;
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
