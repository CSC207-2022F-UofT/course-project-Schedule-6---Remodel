package useCaseInteractor.User;

import entity.User.User;

public class userCollection {

    public static User labelUser;

    public static void setUser(User user){
        labelUser = user;


    }
    public static String getUsername(){return labelUser.getUsername();}
}
