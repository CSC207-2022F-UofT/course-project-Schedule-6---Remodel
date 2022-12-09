package controller.User;

/**
 * Sets the username to the user that's logged in so when accessing the database, the system knows which
 * user to look for
 */
public class userCollection {

    public static String username;

    public static void setUser(String name) {
        username = name;
    }

    public static String getUsername() {
        return username;
    }
}
