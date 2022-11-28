package useCaseInteractor.User;

import controller.Schedule.TimetableController;

public class setUsername {

    public static void setName() {
        TimetableController.usernameChageLabel.setText(userCollection.getUsername());
    }
}
