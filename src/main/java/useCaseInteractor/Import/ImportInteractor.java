package useCaseInteractor.Import;

import boundary.Import.ImportInputBoundary;
import boundary.Import.ImportOutputBoundary;
import entity.Event.EventItem;
import entity.Event.EventItemFactory;
import presenter.ImportPresenter;
import requestModel.ImportRequestModel;
import responseModel.Import.ImportResponseModel;
import useCaseInteractor.DataAccess;

public class ImportInteractor implements ImportInputBoundary {
    final ImportPresenter presenter;
    final EventItemFactory factory;
    final DataAccess dataAccess;

    public ImportInteractor(ImportPresenter presenter, EventItemFactory factory, DataAccess dataAccess) {
        this.presenter = presenter;
        this.factory = factory;
        this.dataAccess = dataAccess;
    }

    @Override
    public void create(ImportRequestModel requestModel) {
        int itemNum = requestModel.getTitles().size(); // the number of events imported from the file
        for (int i = 0; i < itemNum; i++) {
            EventItem item = factory.create(requestModel.getTitles().get(i),
                    requestModel.getStartDates().get(i),
                    requestModel.getEndDates().get(i),
                    requestModel.getStartTime().get(i),
                    requestModel.getEndTime().get(i));
            dataAccess.setImportEvents(requestModel);
        }

        ImportResponseModel responseModel = new ImportResponseModel(requestModel.getTitles(),
                requestModel.getStartDates(),
                requestModel.getEndDates(),
                requestModel.getStartTime(),
                requestModel.getEndTime(),
                requestModel.getRRules());
        // Area for improvement: The Import usecase might share response model with AddSchecule to avoid lazy class

        ImportOutputBoundary output = new ImportPresenter();
        output.successfulImport(responseModel);
    }
}
