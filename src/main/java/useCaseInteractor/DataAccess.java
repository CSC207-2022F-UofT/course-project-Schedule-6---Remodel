package useCaseInteractor;

import requestModel.EventItemRequestModel;
import requestModel.ImportRequestModel;
import responseModel.Event.EventItemResponseModel;
import responseModel.Task.TaskResponseModel;

import java.util.ArrayList;

/**
 * MongoDBAccess interfaces to allow the use cases to call to the database
 */
public interface DataAccess {

    /**
     * Create a user in the database
     *
     * @param password users password
     * @param fName    users first name
     * @param lName    users last name
     */
    void createUser(String password, String fName, String lName);

    /**
     * Check if this user exists using the unique username identification
     *
     * @param username users username
     * @return returns true if this username already exists in the database
     */
    boolean getUserExist(String username);

    /**
     * Check if this event already exists in the database
     *
     * @param request contains the data of a single event
     * @return returns true if this event already exists in the database
     */
    boolean eventExists(EventItemRequestModel request);

    /**
     * Clear Users Events
     */
    void resetEvents();

    /**
     * Clear Users Tasks
     */
    void resetTask();

    /**
     * Add an Event to the database
     *
     * @param responseModel required event data
     */
    void setEvent(EventItemResponseModel responseModel);

    /**
     * Add all the events in the ICS file
     *
     * @param requestModel required event data
     */
    void setImportEvents(ImportRequestModel requestModel);

    /**
     * @return returns all Events of a User
     */
    ArrayList<ArrayList<Object>> getUserEvents();

    /**
     * Add a Task to the database
     *
     * @param responseModel required Task Data
     */
    void setTask(TaskResponseModel responseModel);

    /**
     * @return returns all Tasks of a User
     */
    ArrayList<ArrayList<Object>> getUserTasks();

    /**
     * Check if this usernames password matches in the database
     *
     * @param password the enetered password from the login page
     * @return return true if passward matches in the database
     */
    boolean checkPassword(String password);
}
