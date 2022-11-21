package presenter;

import boundary.ImportOutputBoundary;
import useCaseInteractor.ImportResponseModel;

public class ImportPresenter implements ImportOutputBoundary {
    @Override
    public ImportResponseModel successfulImport(ImportResponseModel calendar){
        return calendar;
    }
}
