package boundary;

import useCaseInteractor.ScheduleItemRequestModel;
import useCaseInteractor.ScheduleItemResponseModel;

public interface EditScheduleItemInputBoundary {
    ScheduleItemResponseModel edit(ScheduleItemRequestModel inputData);
}
