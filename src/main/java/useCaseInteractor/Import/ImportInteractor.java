package useCaseInteractor.Import;

import boundary.Import.ImportInputBoundary;
import boundary.Import.ImportOutputBoundary;
import database.MongoDBAccess;
import entity.Schedule.ScheduleItem;
import entity.Schedule.ScheduleItemFactory;
import presenter.ImportPresenter;
import presenter.TimetablePresenter;
import requestModel.ImportRequestModel;
import responseModel.Import.ImportResponseModel;
import useCaseInteractor.DataAccess;

import java.time.LocalDateTime;

public class ImportInteractor implements ImportInputBoundary {
    final ImportPresenter presenter;
    final ScheduleItemFactory factory;
    final DataAccess dataAccess;

    public ImportInteractor(ImportPresenter presenter, ScheduleItemFactory factory, DataAccess dataAccess) {
        this.presenter = presenter;
        this.factory = factory;
        this.dataAccess = dataAccess;
    }

    @Override
    public ImportResponseModel create(ImportRequestModel requestModel){
        int itemNum = requestModel.getTitles().size(); // the number of events imported from the file
        for(int i = 0; i < itemNum; i++){
            ScheduleItem item = factory.create(requestModel.getTitles().get(i),
                    requestModel.getStartDates().get(i),
                    requestModel.getEndDates().get(i),
                    requestModel.getStartTime().get(i),
                    requestModel.getEndTime().get(i));
        }
        dataAccess.setImportSchedule(requestModel);

        ImportResponseModel responseModel = new ImportResponseModel(requestModel.getTitles(),
                requestModel.getStartDates(),
                requestModel.getEndDates(),
                requestModel.getStartTime(),
                requestModel.getEndTime(),
                requestModel.getRRules());
        // Area for improvement: The Import usecase might share response model with AddSchecule to avoid lazy class

        ImportOutputBoundary output = new ImportPresenter();
        return output.successfulImport(responseModel);
    }
}
