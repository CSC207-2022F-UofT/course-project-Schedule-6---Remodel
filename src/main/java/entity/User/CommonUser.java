package entity.User;

// Entity layer

import useCaseInteractor.DataAccess;

public class CommonUser implements User {

    private final String username;
    private final String password;

    public CommonUser(String username, String password) {
        this.username = username;
        this.password = password;

    }

    @Override
    public String getUsername(){
        return this.username;
    }

    @Override
    public String getPassword(){
        return this.password;
    }

    @Override
    public String getFullName(DataAccess data){
        return data.getFnameLname();
    }


}