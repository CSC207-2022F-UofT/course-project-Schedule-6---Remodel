package useCaseInteractor.User;

import database.MongoDBAccess;
import entity.User.User;
import javafx.scene.chart.PieChart;
import main.collectCollection;
import useCaseInteractor.DataAccess;

import java.net.UnknownHostException;

public class userCollection{

    public static User labelUser;

    public static void setUser(User user){
        labelUser = user;

    }


    public static String getUsername(){return labelUser.getUsername();}


    public String getPassword() {
        return labelUser.getPassword();
    }

    public static String getFullName() throws UnknownHostException {
        DataAccess data = new MongoDBAccess(collectCollection.main(), getUsername());
        return labelUser.getFullName(data);
    }
}
