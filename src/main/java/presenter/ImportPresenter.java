package presenter;

import boundary.ImportOutputBoundary;
import responseModel.ImportResponseModel;

public class ImportPresenter implements ImportOutputBoundary {
    @Override
    public ImportResponseModel successfulImport(ImportResponseModel calendar){
        return calendar;
    }
}
