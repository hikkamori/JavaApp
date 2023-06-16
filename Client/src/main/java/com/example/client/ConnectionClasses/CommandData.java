package com.example.client.ConnectionClasses;

import com.example.client.CollectionStructure.MusicBand;
import com.example.client.UserData;

import java.net.InetAddress;
import java.sql.Statement;

public class CommandData {
    public static Statement stm;
    public String CommandName;
    public Object[] CommandArgs;
    public MusicBand Band;
    public InetAddress ClientAdress;
    public int ClientPort;
    public String UserName;
    public String Password;
    public CommandData(){}

    public static CommandData createData() {
        CommandData data = new CommandData();
        data.UserName = UserData.getEmail();
        data.Password = UserData.getPassword();
        return data;
    }

    public CommandData Name(String name) {
        this.CommandName = name;
        return this;
    }

    public CommandData Args(Object[] args) {
        this.CommandArgs = args;
        return this;
    }

    public CommandData Band(MusicBand band) {
        this.Band = band;
        return this;
    }
    public CommandData Username(String s){
        this.UserName = s;
        return this;
    }
    public CommandData Password(String s){
        this.Password = s;
        return this;
    }
    public void SetClientInform(InetAddress adress, int port){
        this.ClientAdress = adress;
        this.ClientPort = port;
    }
    public String getCommandName(){
        return CommandName;
    }
    public MusicBand getBand(){
        return Band;
    }
    public Object[] getArgs(){
        return CommandArgs;
    }
    public InetAddress getClientAdress(){
        return ClientAdress;
    }
    public int getClientPort(){
        return ClientPort;
    }
    public String getUserName(){return  UserName;}
    public String getPassword(){return Password;}
    public void setUserName(String userName){
        this.UserName = UserData.getEmail();
    }
}

