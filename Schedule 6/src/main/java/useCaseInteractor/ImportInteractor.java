package useCaseInteractor;

import boundary.ImportInputBoundary;
import entity.ScheduleItem;
import entity.ScheduleItemFactory;
import presenter.ImportPresenter;

public class ImportInteractor implements ImportInputBoundary {
    final ImportPresenter presenter;
    final ScheduleItemFactory factory;

    public ImportInteractor(ImportPresenter presenter, ScheduleItemFactory factory) {
        this.presenter = presenter;
        this.factory = factory;
    }

    @Override
    public ImportResponseModel create(ImportRequestModel requestModel){}
}
