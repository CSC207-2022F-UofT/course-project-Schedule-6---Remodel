package boundary.User;

import requestModel.UserRegisterRequestModel;
import responseModel.User.UserRegisterResponseModel;

public interface UserRegisterInputBoundary {

    void create(UserRegisterRequestModel requestModel);
}
