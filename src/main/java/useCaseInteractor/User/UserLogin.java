package useCaseInteractor.User;

import boundary.User.UserLoginInputBoundary;
import boundary.User.UserLoginOutputBoundary;
import requestModel.UserLoginRequestModel;
import responseModel.User.UserLoginResponseModel;
import useCaseInteractor.DataAccess;

public class UserLogin implements UserLoginInputBoundary {

    private final DataAccess dataAccess;

    private final UserLoginRequestModel requestModel;

    private final UserLoginOutputBoundary outputBoundary;

    public UserLogin(DataAccess dataAccess, UserLoginRequestModel requestModel,
                     UserLoginOutputBoundary outputBoundary) {
        this.dataAccess = dataAccess;
        this.requestModel = requestModel;
        this.outputBoundary = outputBoundary;
    }

    /**
     * Overrides loginCheck() from this classes interface (UserLoginInputBoundary)
     * Checks if the login attempts username and password match, and if the username exists in the database.
     * If the username doesn't exist, or username and password doesn't match,
     * it will return a message "USERNAME OR PASSWORD INCORRECT"
     * If user exists, and password matches, it will prepareSuccessView
     */
    @Override
    public void loginCheck() {
        if (dataAccess.getUserExist(requestModel.getUsername()) &&
                dataAccess.checkPassword(requestModel.getPassword())) {
            outputBoundary.prepareSuccessView(new UserLoginResponseModel("LOGIN SUCCESSFUL"));
        } else {
            outputBoundary.prepareFailView(new UserLoginResponseModel("USERNAME OR PASSWORD INCORRECT"));
        }
    }
}
