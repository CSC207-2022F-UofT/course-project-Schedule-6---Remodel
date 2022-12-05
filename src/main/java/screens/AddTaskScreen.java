package screens;

import controller.Task.TaskCreationController;
import database.MongoDBAccess;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.stage.Stage;
import main.collectCollection;
import presenter.TaskCreationPresenter;
import responseModel.Task.TaskResponseModel;
import useCaseInteractor.DataAccess;
import useCaseInteractor.User.userCollection;

import java.net.UnknownHostException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class AddTaskScreen {
    public Button taskCancel;

    @FXML
    private TextField taskCategory;

    @FXML
    private Button taskAdd;

    @FXML
    private DatePicker taskDate;

    @FXML
    private TextField taskDescription;

    @FXML
    private Label errorMessage;

    private DataAccess DB = new MongoDBAccess(collectCollection.main(), userCollection.getUsername());

    public AddTaskScreen() throws UnknownHostException {
    }

    public void addTask(ActionEvent event) throws UnknownHostException{
        TaskResponseModel model = new TaskResponseModel(taskDescription.getText(), taskDate.getValue(), taskCategory.getText());
        DB.setTask(model);
        this.cancelTask(new ActionEvent());
    }

    public void cancelTask(ActionEvent actionEvent) {
        Stage stage = (Stage) taskCancel.getScene().getWindow();
        stage.close();
    }
}
