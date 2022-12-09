package controller.User;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class userCollectionTest {

    @BeforeEach
    void setUp(){

    }


    @Test
    void Event_test_setgetUsername(){
        userCollection.setUser("n1");
        assertNotNull(userCollection.getUsername());
        assertTrue(userCollection.getUsername().equals("n1"));
    }
}
