package boundary;

import useCaseInteractor.ScheduleItemRequestModel;
import useCaseInteractor.ScheduleItemResponseModel;

public interface DeleteScheduleItemInputBoundary {
    ScheduleItemResponseModel delete(ScheduleItemRequestModel inputData);
}
