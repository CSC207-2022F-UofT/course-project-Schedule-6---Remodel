package entity.User;

import com.mongodb.DBCollection;

import java.time.LocalDate;

public interface Search {



    boolean sendRequest(DBCollection collection);
}