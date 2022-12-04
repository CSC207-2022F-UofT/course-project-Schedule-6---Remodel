package useCaseInteractor.User;

import boundary.User.loadUserScheduleInputBoundary;
import useCaseInteractor.DataAccess;

import java.util.ArrayList;

public class loadUserSchedule implements loadUserScheduleInputBoundary {

    final DataAccess dataAccess;

    public loadUserSchedule(DataAccess dataAccess) {

        this.dataAccess = dataAccess;
    }

    public ArrayList<ArrayList<Object>> getSchedule() {
        return dataAccess.getUserEntireSchedule();
    }
}
