package controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class CategoryCreationController {

    @FXML
    private Button categoryCreateAddButton;

    @FXML
    private TextField categoryHex;

    @FXML
    private TextField categoryTitle;

    @FXML
    private ComboBox<?> privacyComboBox;

    @FXML
    private AnchorPane statusComboBox;

    @FXML
    public void addCategory(ActionEvent event) {
        String name_ = categoryTitle.getText();
        String hex_ = categoryHex.getText();
        //boolean status_ = categoryComboBox.

    }

}
