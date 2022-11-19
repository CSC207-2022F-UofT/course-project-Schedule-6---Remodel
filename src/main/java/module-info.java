module com.example.project6maven {
    requires javafx.controls;
    requires javafx.fxml;

//    requires org.controlsfx.controls;
    //requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens main to javafx.fxml;
    exports main;
    exports controller;
    opens controller to javafx.fxml;
    exports entity;
    opens entity to javafx.fxml;
    requires javafx.graphics;
    //requires mysql.connector.j;
//    requires com.calendarfx.view;
    requires mongo.java.driver;
}