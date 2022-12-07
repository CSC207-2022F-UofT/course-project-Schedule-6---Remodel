package responseModel.Event;

import java.util.ArrayList;

public class LoadEventsResponseModel {

    final ArrayList<ArrayList<Object>> allEvents;

    public LoadEventsResponseModel(ArrayList<ArrayList<Object>> allEvents) {
        this.allEvents = allEvents;
    }

    public ArrayList<ArrayList<Object>> getAllEvents() {
        return this.allEvents;
    }
}
