package useCaseInteractor.User;


import controller.Schedule.TimetableController;
import screens.TimeTableScreen;

public class setUsername {

    public static void setName() {
        TimeTableScreen.usernameChangeLabel.setText(userCollection.getUsername());
    }
}
