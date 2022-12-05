package entity.User;

import com.mongodb.DBCollection;
//entity does not know the database exists
public interface Request {

    void accept(DBCollection collection);

    void decline(DBCollection collection);
}

