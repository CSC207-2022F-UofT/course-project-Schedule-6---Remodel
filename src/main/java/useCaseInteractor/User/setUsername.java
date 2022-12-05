package useCaseInteractor.User;


import controller.Schedule.TimetableController;
import screens.TimeTableScreen;

import java.net.UnknownHostException;

public class setUsername {

    public static void setName() throws UnknownHostException {
        TimeTableScreen.usernameChangeLabel.setText(userCollection.getFullName());
    }
}
