package entity.User;

import com.mongodb.DBCollection;

import java.time.LocalDate;
//entity does not know the database exists
public interface Search {


    boolean sendRequest(DBCollection collection);
}