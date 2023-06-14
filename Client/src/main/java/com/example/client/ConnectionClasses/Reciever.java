package com.example.client.ConnectionClasses;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.ArrayList;
import java.util.Arrays;

public class Reciever {
    public static String[] getData(DatagramSocket soc) throws IOException {
        byte[] buffer = new byte[110];
        DatagramPacket datagramPacket = new DatagramPacket(buffer, buffer.length);
        ArrayList<String> unsortedMessages = new ArrayList();
        int packagesCount = -1;
        while (true){
            soc.receive(datagramPacket);
            String SerialisedData = new String(datagramPacket.getData(), 0, datagramPacket.getLength());
            unsortedMessages.add(SerialisedData);
            if (SerialisedData.split(":")[(int) (Arrays.stream(SerialisedData.split(":")).count()-1)].equals("0")){
                packagesCount = Integer.valueOf(SerialisedData.split(":")[0])+1;
            }
            if (unsortedMessages.size() == packagesCount){
                break;
            }
        }
        String[] sortedMessages = new String[packagesCount];
        for (int i = 0; i < unsortedMessages.size(); i++){
            int index = Integer.valueOf(unsortedMessages.get(i).split(":")[0]);
            int start_index = Integer.valueOf(unsortedMessages.get(i).split(":")[0].length()) + 1;
            int end_index = unsortedMessages.get(i).length() - Integer.valueOf(unsortedMessages.get(i).split(":")[(int) (Arrays.stream(unsortedMessages.get(i).split(":")).count()-1)].length()) - 1;
            sortedMessages[index] = unsortedMessages.get(i).substring(start_index, end_index);
        }
        String concatSerialisedMessages = "";
        for (int i = 0; i < Arrays.stream(sortedMessages).count(); i++) {
            concatSerialisedMessages = concatSerialisedMessages.concat(sortedMessages[i]);
        }
        return DeserialiseData(concatSerialisedMessages);
    }

    public static String[] DeserialiseData(String data) throws JsonProcessingException {
        ObjectMapper mapper = new YAMLMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.registerModule(new JavaTimeModule());
        String[] deserialisedData = mapper.readValue(data, String[].class);
        return deserialisedData;
    }
}
