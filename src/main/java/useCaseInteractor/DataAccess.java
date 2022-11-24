package useCaseInteractor;

import boundary.AddScheduleItemInputBoundary;
import requestModel.ScheduleItemRequestModel;
import responseModel.ScheduleItemResponseModel;

public interface DataAccess {
    void savetoDB(ScheduleItemRequestModel requestModel);

    void pullfromDB();
}
