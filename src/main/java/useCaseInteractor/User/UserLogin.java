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
