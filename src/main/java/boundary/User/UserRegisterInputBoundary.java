package boundary.User;

import requestModel.UserRegisterRequestModel;

public interface UserRegisterInputBoundary {

    void create(UserRegisterRequestModel requestModel);
}
