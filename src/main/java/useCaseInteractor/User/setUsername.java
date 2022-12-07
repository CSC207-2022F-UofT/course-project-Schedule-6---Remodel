package useCaseInteractor.User;


import screens.ScheduleScreen;

public class setUsername {

    public static void setName() {
        ScheduleScreen.usernameChangeLabel.setText(userCollection.getUsername());
    }
}
