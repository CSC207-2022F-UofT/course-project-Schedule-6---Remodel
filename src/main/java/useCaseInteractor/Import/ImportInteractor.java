package useCaseInteractor.Import;

import boundary.Import.ImportInputBoundary;
import boundary.Import.ImportOutputBoundary;
import entity.Schedule.ScheduleItem;
import entity.Schedule.ScheduleItemFactory;
import presenter.ImportPresenter;
import requestModel.ImportRequestModel;
import responseModel.Import.ImportResponseModel;

import java.time.LocalDateTime;

public class ImportInteractor implements ImportInputBoundary {
    final ImportPresenter presenter;
    final ScheduleItemFactory factory;

    public ImportInteractor(ImportPresenter presenter, ScheduleItemFactory factory) {
        this.presenter = presenter;
        this.factory = factory;
    }

    @Override
    public ImportResponseModel create(ImportRequestModel requestModel){
        for(int i = 0; i < requestModel.getTitles().size(); i++){
            ScheduleItem item = factory.create(requestModel.getTitles().get(i),
                    requestModel.getDates().get(i),
                    requestModel.getStartTime().get(i),
                    requestModel.getEndTime().get(i));
        }
        // TODO: implement the view of failedImport
        LocalDateTime creation = LocalDateTime.now();
        ImportResponseModel responseModel = new ImportResponseModel(creation.toString());
        ImportOutputBoundary output = new ImportPresenter();
        return output.successfulImport(responseModel);
    }
}
