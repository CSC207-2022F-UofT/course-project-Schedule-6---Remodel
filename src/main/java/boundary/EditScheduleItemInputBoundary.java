package boundary;

import useCaseInteractor.ScheduleItemInputData;
import useCaseInteractor.ScheduleItemResponseModel;

public interface EditScheduleItemInputBoundary {
    ScheduleItemResponseModel edit(ScheduleItemInputData inputData);
}
