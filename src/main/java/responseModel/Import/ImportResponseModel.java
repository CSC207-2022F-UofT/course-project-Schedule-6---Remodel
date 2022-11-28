package responseModel.Import;

public class ImportResponseModel {
    private String timeCreated;

    public ImportResponseModel(String timeCreated){
        this.timeCreated = timeCreated;
    }

    public String getTimeCreated(){
        return this.timeCreated;
    }

}
