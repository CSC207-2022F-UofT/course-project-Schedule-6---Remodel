package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class TaskCreationController {

    @FXML
    private ComboBox<?> categoryComboBox;

    @FXML
    private ComboBox<?> privacyComboBox;

    @FXML
    private Button taskCreateAddButton;

    @FXML
    private TextField taskDate;

    @FXML
    private TextField taskTitle;

    @FXML
    public void addTask(ActionEvent event) {
        String title_ = taskTitle.getText();
        String date_ = taskDate.getText();
        //String privacy_ = privacyComboBox.
        //Category category_ = categoryComboBox.
    }


}
