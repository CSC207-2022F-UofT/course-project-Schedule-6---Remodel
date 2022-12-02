package screens;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.util.Objects;

public class AddCategoryScreen {
    public Label categoryError;
    public Button categoryCancelButton;
    @FXML
    private Button categoryCreateAddButton;

    @FXML
    private TextField categoryTitle;

    @FXML
    private ComboBox<?> privacyComboBox;

    @FXML
    private AnchorPane statusComboBox;

    @FXML
    public void addCategory(ActionEvent event) {
        String name_ = categoryTitle.getText();
        Boolean isPrivate_ = Objects.equals((java.lang.String) privacyComboBox.getValue(), "Private");

    }

    public void cancelCategory(ActionEvent actionEvent) {
        Stage stage = (Stage) categoryCancelButton.getScene().getWindow();
        stage.close();
    }
}
