module com.example.project6maven {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.controlsfx.controls;
    opens main to javafx.fxml;
    opens screens to javafx.fxml;
    exports main;
    exports controller.Event;
    opens controller.Event to javafx.fxml;
    exports controller.Task;
    opens controller.Task to javafx.fxml;
    exports controller.User;
    opens controller.User to javafx.fxml;
    exports controller.Import;
    opens controller.Import to javafx.fxml;
    exports entity.Event;
    opens entity.Event to javafx.fxml;
    exports entity.Task;
    opens entity.Task to javafx.fxml;
    exports entity.User;
    opens entity.User to javafx.fxml;
    requires javafx.graphics;
    requires com.calendarfx.view;
    requires mongo.java.driver;
    requires org.mnode.ical4j.core;
}