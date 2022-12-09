package useCaseInteractor.User;

import boundary.User.UserRegisterInputBoundary;
import entity.User.CommonUserFactory;
import entity.User.User;
import entity.User.UserFactory;
import requestModel.UserRegisterRequestModel;
import useCaseInteractor.DataAccess;

public class UserRegister implements UserRegisterInputBoundary {

    private final DataAccess dataAccess;

    private final UserFactory userFactory = new CommonUserFactory();

    public UserRegister(DataAccess dataAccess) {
        this.dataAccess = dataAccess;
    }

    /**
     * Overrides create() method in its interface (UserRegisterInputBoundary)
     * Called when a user registers a new account, and then this User entity is created a
     * and stored in the database
     *
     * @param requestModel contains all the User info required for created a new account
     */
    @Override
    public void create(UserRegisterRequestModel requestModel) {
        User user = userFactory.create(requestModel.getUsername(), requestModel.getPassword(),
                requestModel.getFirstName(), requestModel.getLastName());
        dataAccess.createUser(user.getPassword(), user.getFirstName(), user.getLastName());
    }
}

