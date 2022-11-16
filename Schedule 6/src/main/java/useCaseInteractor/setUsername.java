package useCaseInteractor;

import controller.TimetableController;
import useCaseInteractor.userCollection;
import controller.TimetableController;
public class setUsername {

    public static void setName() {
        TimetableController.usernameChageLabel.setText(userCollection.getUsername());
    }
}
