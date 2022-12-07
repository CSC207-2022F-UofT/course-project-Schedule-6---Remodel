package useCaseInteractor.User;

import screens.TimetableScreen;

public class setUsername {

    public static void setName() {
        TimetableScreen.usernameChangeLabel.setText(userCollection.getUsername());
    }
}
