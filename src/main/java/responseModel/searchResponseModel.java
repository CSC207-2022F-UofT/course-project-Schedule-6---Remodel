package responseModel;

import java.net.UnknownHostException;
import useCaseInteractor.Search.launchSearch;

public class searchResponseModel {

    public static void main(String[] args) throws UnknownHostException {

        launchSearch search = new launchSearch("nizar12");
        search.main(null);
    }
}
