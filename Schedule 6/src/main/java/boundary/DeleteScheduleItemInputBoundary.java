package boundary;

import useCaseInteractor.ScheduleItemInputData;
import useCaseInteractor.ScheduleItemResponseModel;

public interface DeleteScheduleItemInputBoundary {
    ScheduleItemResponseModel delete(ScheduleItemInputData inputData);
}
