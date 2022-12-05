package entity.User;

import useCaseInteractor.DataAccess;

public interface User {
    /* User class */
     String getUsername();
     String getPassword();

     String getFullName(DataAccess data);

    }

