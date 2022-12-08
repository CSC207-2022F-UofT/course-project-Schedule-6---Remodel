package useCaseInteractor.User;

import boundary.User.UserRegisterInputBoundary;
import entity.User.CommonUserFactory;
import entity.User.User;
import entity.User.UserFactory;
import presenter.UserRegisterPresenter;
import requestModel.UserRegisterRequestModel;
import responseModel.User.UserRegisterResponseModel;
import useCaseInteractor.DataAccess;

public class UserRegister implements UserRegisterInputBoundary {

    private final DataAccess dataAccess;

    private final UserFactory userFactory = new CommonUserFactory();

    public UserRegister(DataAccess dataAccess) {
        this.dataAccess = dataAccess;
    }


    @Override
    public void create(UserRegisterRequestModel requestModel) {
        User user = userFactory.create(requestModel.getUsername(), requestModel.getPassword(),
                requestModel.getFirstName(), requestModel.getLastName());
        dataAccess.createUser(user.getPassword(), user.getFirstName(), user.getLastName());
        }
}

