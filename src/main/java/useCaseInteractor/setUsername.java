package useCaseInteractor;

import controller.TimetableController;

public class setUsername {

    public static void setName() {
        TimetableController.usernameChageLabel.setText(userCollection.getUsername());
    }
}
