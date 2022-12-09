package useCaseInteractor.Import;

import boundary.Import.ImportInputBoundary;
import boundary.Import.ImportOutputBoundary;
import entity.Event.CommonEventItemFactory;
import entity.Event.EventItemFactory;
import presenter.ImportPresenter;
import requestModel.ImportRequestModel;
import responseModel.Import.ImportResponseModel;
import useCaseInteractor.DataAccess;

/**
 * The useCase of importing files
 */
public class ImportUseCase implements ImportInputBoundary {
    final DataAccess dataAccess;

    /**
     * The constructor of ImportUseCase
     * @param dataAccess the interface used to access external database, so the EventItems created can be stored
     */
    public ImportUseCase(DataAccess dataAccess) {
        this.dataAccess = dataAccess;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ImportResponseModel create(ImportRequestModel requestModel){
        EventItemFactory factory = new CommonEventItemFactory();
        int itemNum = requestModel.getTitles().size(); // the number of events imported from the file
        for(int i = 0; i < itemNum; i++){
            factory.create(requestModel.getTitles().get(i),
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
        // Area for improvement: The Import useCase might share response model with EventItemResponseModel

        ImportOutputBoundary output = new ImportPresenter();
        return output.successfulImport(responseModel);
    }
}
