module com.example.client {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.annotation;
    requires com.fasterxml.jackson.datatype.jsr310;
    requires com.fasterxml.jackson.dataformat.yaml;
    requires java.sql;


    opens com.example.client to javafx.fxml;
    exports com.example.client;
    exports com.example.client.Controllers;
    exports com.example.client.ConnectionClasses;
    opens com.example.client.Controllers to javafx.fxml;
}