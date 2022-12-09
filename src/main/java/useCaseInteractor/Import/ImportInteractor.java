package useCaseInteractor.Import;

import boundary.Import.ImportInputBoundary;
import boundary.Import.ImportOutputBoundary;
import controller.User.userCollection;
import database.MongoDBAccess;
import entity.Event.CommonEventItemFactory;
import entity.Event.EventItem;
import entity.Event.EventItemFactory;
import main.collectCollection;
import presenter.ImportPresenter;
import requestModel.ImportRequestModel;
import responseModel.Import.ImportResponseModel;
import useCaseInteractor.DataAccess;

import java.net.UnknownHostException;

public class ImportInteractor implements ImportInputBoundary {
    final DataAccess dataAccess;

    public ImportInteractor(DataAccess dataAccess) {
        this.dataAccess = dataAccess;
    }

    @Override
    public ImportResponseModel create(ImportRequestModel requestModel){
        EventItemFactory factory = new CommonEventItemFactory();
        int itemNum = requestModel.getTitles().size(); // the number of events imported from the file
        for(int i = 0; i < itemNum; i++){
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
        // Area for improvement: The Import usecase might share response model with EventItemResponseModel

        ImportOutputBoundary output = new ImportPresenter();
        return output.successfulImport(responseModel);
    }
}
