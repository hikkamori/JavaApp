package com.example.client.Controllers;

import com.example.client.ConnectionClasses.CommandData;
import com.example.client.ConnectionClasses.Reciever;
import com.example.client.ConnectionClasses.Sender;
import com.example.client.UserData;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;

public class RegisterInputDataController {
    @FXML
    private TextField email;
    @FXML
    private PasswordField password;
    @FXML
    private Button confirmButton;
    @FXML
    private ImageView errorCat;
    @FXML
    private Text errorText;




    public RegisterInputDataController() throws IOException {}




    public void confirmData() throws IOException {
        Boolean emailIsEmpty = email.getText().equals("");
        Boolean passwordIsEmpty = password.getText().equals("");
        if (emailIsEmpty | passwordIsEmpty){
            showErrorText(emailIsEmpty, passwordIsEmpty, errorCat, errorText, email, password);
        } else {

            try {
                String userinfo;
                if(UserData.getIsAuthorizing()){
                    userinfo = "CheckUser";
                }
                else{
                    userinfo = "CreateUser";
                }
                MessageDigest digest = MessageDigest.getInstance("SHA-1");
                digest.reset();
                digest.update(password.getText().getBytes("utf8"));
                String codedPassword = String.format("%040x", new BigInteger(1, digest.digest()));
                CommandData data = CommandData.createData().Name(userinfo).Username(email.getText()).Password(codedPassword);
                Sender.send(data);
                String[] messages = Reciever.getData(UserData.getSoc());
                System.out.println(messages[0]);
            } catch (Exception e){
                e.printStackTrace();
            }

        }
    }
    public void makeEmailWhite(){
        email.setStyle("-fx-background-color: #ffffff");
        email.setStyle("-fx-border-color: #1a05d1");
    }
    public void makePasswordWhite(){
        password.setStyle("-fx-background-color: #ffffff");
        password.setStyle("-fx-border-color: #1a05d1");
    }

    public void showErrorText(boolean emailIsEmpty, boolean passwordIsEmpty, ImageView errorCat, Text errorText, TextField email, PasswordField password){
        if (emailIsEmpty & passwordIsEmpty){
            errorCat.setStyle("visibility: true;");
            errorText.setText("Enter your email and password, please");
            errorText.setStyle("visibility: true;");
        } else if (emailIsEmpty) {
            errorText.setText("Oh, it seems you forgot to enter your email(");
            errorText.setStyle("visibility: true;");
            email.setStyle("-fx-background-color: #c4c2df; -fx-border-color: #1a05d1");
        } else {
            errorText.setText("Oh, it seems you forgot to enter your password(");
            errorText.setStyle("visibility: true;");
            password.setStyle("-fx-background-color: #c4c2df; -fx-border-color: #1a05d1");
        }

    }
}
