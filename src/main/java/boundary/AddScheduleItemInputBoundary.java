package boundary;

import useCaseInteractor.ScheduleItemRequestModel;
import useCaseInteractor.ScheduleItemResponseModel;

public interface AddScheduleItemInputBoundary {
    ScheduleItemResponseModel create(ScheduleItemRequestModel inputData);
}
