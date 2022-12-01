module com.example.project6maven {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.controlsfx.controls;
    opens main to javafx.fxml;
    opens screens to javafx.fxml;
    exports main;
    //opens entity to javafx.fxml;
    exports controller.Schedule;
    opens controller.Schedule to javafx.fxml;
    exports controller.Task;
    opens controller.Task to javafx.fxml;
    exports controller.User;
    opens controller.User to javafx.fxml;
    exports controller.Import;
    opens controller.Import to javafx.fxml;
    exports entity.Schedule;
    opens entity.Schedule to javafx.fxml;
    exports entity.Task;
    opens entity.Task to javafx.fxml;
    exports entity.User;
    opens entity.User to javafx.fxml;
    requires com.calendarfx.view;
    requires mongo.java.driver;
    requires org.mnode.ical4j.core;
}