package boundary;

import useCaseInteractor.ScheduleItemInputData;
import useCaseInteractor.ScheduleItemResponseModel;

public interface AddScheduleItemInputBoundary {
    ScheduleItemResponseModel create(ScheduleItemInputData inputData);
}
