package boundary.User;

import requestModel.UserRegisterRequestModel;

/**
 * Interface for UserRegister
 * Allows the controller (UserRegisterController) to call the use case (UserRegister)
 */
public interface UserRegisterInputBoundary {

    void create(UserRegisterRequestModel requestModel);
}
