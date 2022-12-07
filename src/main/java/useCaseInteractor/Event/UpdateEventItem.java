package useCaseInteractor.Event;

import boundary.Event.UpdateEventInputBoundary;
import entity.Event.EventItem;
import entity.Event.EventItemFactory;
import requestModel.EventItemRequestModel;
import responseModel.Event.EventItemResponseModel;
import useCaseInteractor.DataAccess;

public class UpdateEventItem implements UpdateEventInputBoundary {

    final DataAccess dataAccess;
    final EventItemFactory eventItemFactory;

    public UpdateEventItem(DataAccess dataAccess, EventItemFactory eventItemFactory) {
        this.dataAccess = dataAccess;
        this.eventItemFactory = eventItemFactory;
    }

    @Override
    public void create(EventItemRequestModel inputData) {
        EventItem eventItem = eventItemFactory.create(inputData.getTitle(),
                inputData.getStartDate(), inputData.getEndDate(), inputData.getStartTime(), inputData.getEndTime());

        EventItemResponseModel responseModel = new EventItemResponseModel(eventItem.getTitle(),
                eventItem.getStartDate(), eventItem.getEndDate(),
                eventItem.getStartTime(), eventItem.getEndTime());

        dataAccess.setEvent(responseModel);
    }
}