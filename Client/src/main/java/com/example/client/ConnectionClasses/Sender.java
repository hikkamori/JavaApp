package com.example.client.ConnectionClasses;

import com.example.client.StartApplication;
import com.example.client.UserData;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Sender {
    public static void send(CommandData data) throws IOException {
        ObjectMapper mapper = new YAMLMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.registerModule(new JavaTimeModule());
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        String serialisedData = mapper.writeValueAsString(data);
        InetAddress adress = InetAddress.getByName("localhost");
        DatagramPacket datagramPacket = new DatagramPacket(serialisedData.getBytes(), serialisedData.getBytes().length, adress, StartApplication.SERVERPORT);
        UserData.getSoc().send(datagramPacket);
    }
}
