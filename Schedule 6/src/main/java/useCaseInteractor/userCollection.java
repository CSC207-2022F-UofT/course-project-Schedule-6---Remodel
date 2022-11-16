package useCaseInteractor;

import entity.User;

public class userCollection {

    public static User labelUser;

    public static void setUser(User user){
        labelUser = user;


    }
    public static String getUsername(){return labelUser.username;}
}
